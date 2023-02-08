package uz.gita.memorygamedi.data.model

enum class LevelEnum(
    val horCount: Int,
    val verCount: Int
) {
    EASY(3, 4),
    MEDIUM(4, 6),
    HARD(6, 8)
}