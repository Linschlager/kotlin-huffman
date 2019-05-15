package ch.linusvettiger.kotlinhuffman

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HuffmanTreeTest {
    @Test
    fun `new items can be added`() {
        val ht = HuffmanTree()
        assertEquals(0, ht.length())
        ht.add('A', "00100")
        assertEquals(1, ht.length())
        assertEquals('A', ht.getBySeq("00100"))
        assertEquals("00100", ht.getByChar('A'))
    }
}