fun main(args: Array<String>) {
    val s = readLine()
    val lexer : Lexer = Lexer()
    val parser : Parser = Parser()
    val root : Node = parser.parseExpression(lexer.parse(s!!), 0).first
    print(root.getValue())
}