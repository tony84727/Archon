package com.github.tony84727.archon.mathexp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MathExpressionDetectorTest {
    @Test
    fun testGetExpressions() {
        val cases = arrayOf(
                MathExpressionDetectorTestCase("How much is 1 + 1?", sequenceOf("1 + 1")),
                MathExpressionDetectorTestCase("1 * 100 + 1跟200 + 1000 哪個比較大?", sequenceOf("1 * 100 + 1", "200 + 1000")),
                MathExpressionDetectorTestCase("10^2是多少?", sequenceOf("10^2"))
        )
        val detector = MathExpressionDetector()
        cases.forEach { assertEquals(it.expected.toList(), detector.getExpressions(it.input).toList()) }
    }
}