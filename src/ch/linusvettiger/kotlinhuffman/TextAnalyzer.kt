package ch.linusvettiger.kotlinhuffman

fun analyzeText(text: String): CharFrequency {
    val freq = CharFrequency()

    text.toCharArray().forEach { freq.addChar(it) }

    return freq
}