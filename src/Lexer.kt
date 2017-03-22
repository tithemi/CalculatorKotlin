class Lexer() {
    fun parse(input: String) : List<Token> {
        var tokens: List<Token> = mutableListOf<Token>()

        var i = 0
        while (i < input.length) {
            while (i < input.length && input[i] == ' ') {
                i++
                continue
            }

            var newTokenName: String = ""
            if (input[i] == '(') {
                tokens += Token(input[i].toString(), TokenType.OPENINGBRACKET)
                i++
            }
            else if(input[i] == ')') {
                tokens += Token(input[i].toString(), TokenType.CLOSINGBRACKET)
                i++
            }
            else if (input[i] in '0'..'9') {
                newTokenName += input[i]
                i++
                while (i < input.length && input[i] in '0'..'9') {
                    newTokenName += input[i]
                    i++
                }
                tokens += Token(newTokenName, TokenType.NUMBER)
            }
            else if (input[i] in listOf<Char>('+', '-', '*', '/', '^')) {
                tokens += Token(input[i].toString(), TokenType.OPERAND)
                i++
            }
        }

        return tokens
    }
}