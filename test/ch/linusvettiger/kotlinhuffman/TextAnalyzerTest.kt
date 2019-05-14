package ch.linusvettiger.kotlinhuffman

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TextAnalyzerTest {
    @Test fun `can count chars`() {
        val freq = analyzeText("AA")
        assertEquals(2, freq.get('A'))
        assertEquals(0, freq.get('B'))
    }
    @Test fun `can count more complex structures`() {
        val freq = analyzeText("ABCDEFGggg\n")

        assertEquals(1, freq.get('\n'))
        assertEquals(3, freq.get('g'))
    }
}