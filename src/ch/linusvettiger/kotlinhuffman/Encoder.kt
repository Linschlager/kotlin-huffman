package ch.linusvettiger.kotlinhuffman

/**
 * Replaces all chars in string by the representation in the given huffman encoding
 * @param text input text to encode
 * @param dictionary huffman encoding as a dictionary
 */
fun encode(text: String, dictionary: Map<Char, String>): Iterable<String> {
    return text.toCharArray().map { dictionary[it] ?: error("Could not find $it") }
}