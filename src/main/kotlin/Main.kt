fun main() {
    val tax = calcTax("Mir", 10_000, 75_000)
    println(tax)
}

fun calcTax(cardType: String = "Mir", transferAmount: Int = 10_000, limitInDay: Int = 0) {
    if (transferAmount > 150_000) {
        println("Ошибка! Превышен лимит на один перевод.")
        return
    }

    if (limitInDay + transferAmount > 600_000) {
        println("Ошибка! Превышен месячный лимит на переводы.")
        return
    }

    val freeLimit = 75_000
    val tax = when (cardType) {
        "MasterCard" -> {
            when {
                limitInDay + transferAmount <= freeLimit -> 0.0
                limitInDay >= freeLimit -> transferAmount * 0.006 + 20
                else -> (limitInDay + transferAmount - freeLimit) * 0.006 + 20
            }
        }
        "Visa" -> {
            val calculatedTax = transferAmount * 0.0075
            if (calculatedTax < 35) 35.0 else calculatedTax
        }
        "Mir" -> 0.0
        else -> {
            println("Такой тип карты не поддерживается")
            0.0
        }
    }

    println("Сумма перевода: $transferAmount рублей")
    println("Комиссия составит: $tax рублей")
}