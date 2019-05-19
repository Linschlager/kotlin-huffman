package ch.linusvettiger.kotlinhuffman

fun main(args: Array<String>) {
    // If no arguments are provided, output usage
    if (args.isEmpty()) {
        println("Usage:")
        println("--file=<path-to-file> File to encode/decode")
        println("--out=<path-to-file> File to output the encoded/decoded Text")
        println("--ht-file File containing the huffman tree to decode --file. Format: <ASCII>:<Huffman>, delimiter: '-'")
        println("--encode Encode the input file")
        println("--decode Decode the input file using --ht-file")
        // println("--debug Enable debugging mode // Currently not in use")
        error("No arguments provided")
    }
    var inputFile = ""
    var outFile = ""
    var htFile = ""
    var htOutFile = ""
    var mode = ""
    var debug = false

    // Read in all arguments
    args.forEach {
        val parts = if (it.contains('=')) {
            it.split('=')
        } else {
            listOf(it)
        }
        when {
            parts[0] == "--file" -> inputFile = parts[1]
            parts[0] == "--out" -> outFile = parts[1]
            parts[0] == "--ht-file" -> htFile = parts[1]
            parts[0] == "--ht-out" -> htOutFile = parts[1]
            parts[0] == "--encode" -> mode = "encode"
            parts[0] == "--decode" -> mode = "decode"
            parts[0] == "--debug" -> debug = true // currently not doing anything
        }
    }

    if (mode === "encode" && inputFile.isEmpty()) {
        error("please provide a file to encode with --file")
    }
    if (mode === "decode" && (inputFile.isEmpty() || htFile.isEmpty())) {
        error("please provide a file to decode (--file) and a file containing the respective huffman tree (--ht-file)")
    }

    val output: String
    // val mode = "encode"
    when {
        mode === "encode" -> {
            // ENCODING PROCEDURE
            val input = readFile(inputFile)
            val frequency = analyzeText(input)
            val ht = createHT(frequency)
            val dict = generateDictionary(ht)
            var encodedText = encode(input, dict).joinToString("")

            encodedText += "1"
            while (encodedText.length % 8 != 0) {
                encodedText += "0"
            }

            output = encodedText

            val outHt = dict.entries.joinToString("-") { "${it.key.toByte()}:${it.value}" }
            if (htOutFile.isNotEmpty()) {
                writeFile(htOutFile, outHt)
            } else {
                println(outHt)
            }
        }
        mode === "decode" -> {
            val input = readInputFile(inputFile)
            val ht = readHuffmanTree(htFile)

            output = decode(input, ht)

        }
        else -> output = ""
    }

    if (outFile.isNotEmpty() && mode === "encode") {
        writeBytes(outFile, output.chunked(8).map { it.toInt(2).toByte() }.toByteArray())
    } else if (outFile.isNotEmpty() && mode === "decode") {
        writeFile(outFile, output)
    } else {
        println(output)
    }
}