package ch.linusvettiger.kotlinhuffman

fun encode(text: String, dictionary: Map<Char, String>): Iterable<String> {
    return text.toCharArray().map { dictionary[it] ?: error("Could not find $it") }
}