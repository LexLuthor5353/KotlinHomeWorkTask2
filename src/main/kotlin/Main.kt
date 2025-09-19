fun main() {
    val tax = calcTax("Mir", 10_000, 75_000)
    println(tax)

}

fun calcTax(cardType: String, transferAmount: Int, limitInDay:Int) {
        if (transferAmount > 150_000) {
        println("Ошибка! Превышен лимит на один перевод.")
        return
    }

    if (limitInDay + transferAmount > 600_000) {
        println("Ошибка! Превышен месячный лимит на переводы.")
        return
    }

    val tax = when (cardType) {
        "MasterCard" -> {
            val freeLimit = 75_000
            if (limitInDay + transferAmount > freeLimit) {
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