object CollisionProbability {
    fun calculate(numberOfThings: Long, numberToGenerate: Long): Double =
        numberToGenerate / numberOfThings.toDouble()  * ((numberToGenerate - 1) * 2)
}
