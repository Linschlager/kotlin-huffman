package ch.linusvettiger.kotlinhuffman

fun main(args: Array<String>) {

    val tree = readHuffmanTree("input/dec_tab-mada.txt")
    val input = readInputFile("input/output-mada.dat")

    println(tree)
    println(input)
    //input!!.forEach { print(revList[it]) }

}