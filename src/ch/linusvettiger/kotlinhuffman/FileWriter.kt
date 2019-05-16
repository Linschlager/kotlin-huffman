package ch.linusvettiger.kotlinhuffman

import java.io.File

/**
 * Write String to file
 */
fun writeFile(fileName: String, content: String) {
    val f = File(fileName)
    if (f.exists()) { // Don't overwrite files
        error("$fileName already exists. Please delete the file and try again")
    }
    f.createNewFile()
    f.writeText(content)
}

/**
 * Write ByteArray to file
 */
fun writeBytes(fileName: String, content: ByteArray) {
    val f = File(fileName)
    if (f.exists()) { // Don't overwrite files
        error("$fileName already exists. Please delete the file and try again")
    }
    f.createNewFile()
    f.writeBytes(content)
}