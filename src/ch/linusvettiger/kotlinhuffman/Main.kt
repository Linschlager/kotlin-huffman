package ch.linusvettiger.kotlinhuffman

fun main(args: Array<String>) {
    /*
    // ENCODING PROCEDURE
    val input = readFile("input/sample-text.txt")
    val frequency = analyzeText(input)
    val ht = createHT(frequency)
    val dict = generateDictionary(ht)
    var encodedText = encode(input, dict).joinToString("")

    // TODO PADDING: make sure it doesn't get confused for actual input
    if (encodedText.length % 8 != 0) {
        encodedText += "1"
    }
    while (encodedText.length % 8 != 0) {
        encodedText += "0"
    }

    print(encodedText)
    */

    val input = readInputFile("input/output-mada.dat").joinToString("")
    val ht = readHuffmanTree("input/dec_tab-mada.txt")

    print(decode(input, ht))
}