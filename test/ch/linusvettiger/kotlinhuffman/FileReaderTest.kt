package ch.linusvettiger.kotlinhuffman

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class FileReaderTest {
    @Test
    fun `can read a huffman tree file`() {
        val fileName = "input/dec_tab-mada.txt"
        val input = readHuffmanTree(fileName)
        assertNotNull(input)
    }

    @Test
    fun `can read dat file`() {
        val fileName = "input/output-mada.dat"
        readInputFile(fileName)
    }
}