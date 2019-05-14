package ch.linusvettiger.kotlinhuffman

import java.io.File

fun readFile(path: String): String {
    val f = File(path)

    return f.readText()
}