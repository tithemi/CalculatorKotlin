import org.jetbrains.annotations.Mutable

class Parser {
    fun parseExpression(tokens: List<Token>, first: Int): Pair<Node, Int> {
        val items: MutableList<Any> = mutableListOf()

        var i = first
        var bracket = 0
        while (i < tokens.size) {
            val token = tokens[i]
            if (token.type == TokenType.CLOSINGBRACKET) {
                bracket = i
                break
            }
            else if (token.type == TokenType.OPENINGBRACKET) {
                val expBrackets = parseExpression(tokens, i + 1)
                items.add(expBrackets.first)
                i = expBrackets.second
            }
            else if (token.type == TokenType.OPERAND)
                items.add(token)
            else
                items.add(Node(token.value))
            i++
        }

        i = 0
        while (i < items.size) {
            if (items[i] is Token) {
                val item: Token = items[i] as Token
                if (item.value == "*" || item.value == "/") {
                    val left = items[i - 1] as Node
                    val right = items[i + 1] as Node
                    items[i - 1] = Node(item.value, left, right)
                    items.removeAt(i)
                    items.removeAt(i)
                    i--
                }
            }
            i++
        }

        i = 0
        while (i < items.size) {
            if (items[i] is Token) {
                val item: Token = items[i] as Token
                if (item.value == "+" || item.value == "-") {
                    val left = items[i - 1] as Node
                    val right = items[i + 1] as Node
                    items[i - 1] = Node(item.value, left, right)
                    items.removeAt(i)
                    items.removeAt(i)
                    i--
                }
            }
            i++
        }

        return Pair(items[0] as Node, bracket)

    }

}