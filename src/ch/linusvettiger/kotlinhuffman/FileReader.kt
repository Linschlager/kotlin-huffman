package ch.linusvettiger.kotlinhuffman

import java.io.File

fun readHuffmanTree(fileName: String): HashMap<Char, String>? {
    try {
        val map = HashMap<Char, String>()
        File(fileName).readLines().first().split('-').forEach {
            val pair = it.split(':')
            val key = pair[0].toInt().toChar()
            map[key] = pair[1]
        }
        return map
    } catch(e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun readInputFile(fileName: String): List<Int>? {
    try {
        File(fileName).readBytes().forEach { println(it) }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}
fun readFile(path: String): String {
    val f = File(path)

    return f.readText()
}