fun main(args: Array<String>) {
    val inputArg = InputArgument(
        numberToGenerate = 3650_0000_0000,
        numberOfCharacters = 62
    )
    val parameters = GenerateParameters.generate(inputArg)
    parameters.forEach {
        calculateProbability(it)
    }
}

fun calculateProbability(parameter: Parameter) {
    parameter.cases.map {
        it.keyLength to CollisionProbability.calculate(it.numberOfThings, it.numberToGenerate)
    }.let { pairs ->
        pairs.plus("all" to pairs.sumOf { it.second })
    }.joinToString().let {
        println("ratio=${parameter.ratio} => $it")
    }
}
