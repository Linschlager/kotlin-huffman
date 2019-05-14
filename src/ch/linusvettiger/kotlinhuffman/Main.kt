package ch.linusvettiger.kotlinhuffman

fun main(args: Array<String>) {
    val input = readFile("input/sample-text.txt")
    val frequency = analyzeText(input)

    print(frequency)
}