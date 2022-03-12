data class Parameter(
    val ratio: Double,
    val cases: List<Case>
) {
    data class Case(
        val keyLength: Int,
        val numberOfThings: Long,
        val numberToGenerate: Long
    )
}
