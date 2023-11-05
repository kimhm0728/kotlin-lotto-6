package lotto.io.input

import lotto.constants.Exception

class InputValidator {
    fun checkInputDigit(amount: String) {
        validateEmpty(amount)
        validateNotDigit(amount)
    }

    fun checkWinningLotto(numbers: String) {
        validateEmpty(numbers)
        validateComma(numbers)
        numbers.split(",").forEach { number -> validateNotDigit(number) }
    }

    private fun validateEmpty(value: String) {
        require(value.isNotEmpty()) { Exception.EMPTY }
    }

    private fun validateNotDigit(value: String) {
        require(value.all { it.isDigit() }) { Exception.DIGIT }
    }

    private fun validateComma(value: String) {
        require(!(value.startsWith(",") || value.endsWith(",") || value.contains(",,"))) {
            Exception.LOTTO_COMMA
        }
    }
}