class Node (val value: String = "", val left: Node? = null, val right: Node? = null) {
    fun getValue() : Double {
            when(this.value) {
                "+" -> return this.left!!.getValue() + this.right!!.getValue()
                "-" -> return this.left!!.getValue() - this.right!!.getValue()
                "*" -> return this.left!!.getValue() * this.right!!.getValue()
                "/" -> return this.left!!.getValue() / this.right!!.getValue()
            }
        return this.value.toDouble()
    }
}