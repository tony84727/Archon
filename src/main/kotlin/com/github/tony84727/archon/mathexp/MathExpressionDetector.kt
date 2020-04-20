package com.github.tony84727.archon.mathexp

class MathExpressionDetector {
    private val pattern = Regex("[0-9]+(\\^[0-9]+)?(\\s*[+\\-*/]?\\s*[0-9]+(\\^[0-9]+)?)+")

    fun getExpressions(input: String): Sequence<String> {
        return pattern.findAll(input).map { it.value }
    }
}