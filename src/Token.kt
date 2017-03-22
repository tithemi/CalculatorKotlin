enum class TokenType {
    NUMBER,
    OPENINGBRACKET,
    CLOSINGBRACKET,
    OPERAND
}

class Token(val value: String = "", val type: TokenType = TokenType.NUMBER) {
    override fun toString(): String {
        return value
    }
}