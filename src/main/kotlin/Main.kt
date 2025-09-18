fun main() {
    val cardType: String = "MasterCard"
    val totalTransfersInMon: Int = 70_000
    val transferAmount: Int = 10_000

    if (transferAmount > 150_000) {
        println("Ошибка! Превышен лимит на один перевод.")
        return
    }

    if (totalTransfersInMon + transferAmount > 600_000) {
        println("Ошибка! Превышен месячный лимит на переводы.")
        return
    }

    val tax = when (cardType) {
        "MasterCard" -> {
            val freeLimit = 75_000
            if (totalTransfersInMon + transferAmount > freeLimit) {
                transferAmount * 0.006 + 20
            } else {
                0.0
            }
        }
        "Visa" -> {
            val taxRate = 0.0075
            val minTax = 35.0
            val calculatedTax = transferAmount * taxRate

            if (calculatedTax < minTax) {
                minTax
            } else {
                calculatedTax
            }
        }
        "Mir" -> {
            0.0
        }
        else -> {
            println("Такой тип карты не поддерживается")
            0.0
        }
    }

    println("Сумма перевода: $transferAmount рублей")
    println("Комиссия составит: $tax рублей")
}