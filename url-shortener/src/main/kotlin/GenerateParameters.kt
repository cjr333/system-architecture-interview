object GenerateParameters {
    fun generate(arg: InputArgument): List<Parameter> {
        var keyLength = 1
        var numberOfThings = arg.numberOfCharacters
        while (numberOfThings < arg.numberToGenerate) {
            numberOfThings *= arg.numberOfCharacters
            keyLength++
        }

        return (0..10).map { it.toDouble() }
            .map { ratio ->
            val numberToGenerateAnotherLength = (arg.numberToGenerate * ratio / 100).toLong()
            Parameter(
                ratio = ratio,
                cases = listOf(
                    Parameter.Case(
                        keyLength = keyLength - 1,
                        numberOfThings = numberOfThings / arg.numberOfCharacters,
                        numberToGenerate = numberToGenerateAnotherLength
                    ),
                    Parameter.Case(
                        keyLength = keyLength,
                        numberOfThings = numberOfThings,
                        numberToGenerate = arg.numberToGenerate - 2 * numberToGenerateAnotherLength
                    ),
                    Parameter.Case(
                        keyLength = keyLength + 1,
                        numberOfThings = numberOfThings * arg.numberOfCharacters,
                        numberToGenerate = numberToGenerateAnotherLength
                    )
                )
            )
        }
    }
}
