

fun main(arg: String){

    val thousands = mapOf(1 to "тысяча")

    val hundreds = mapOf(1 to "сто", 2 to "двести", 3 to "триста", 4 to "четыреста",
                         5 to "пятьсот", 6 to "шестьсот", 7 to "семьсот", 8 to "восемьсот",
                         9 to "девятьсот")

    val tens = mapOf(2 to "двадцать", 3 to "тридцать", 4 to "сорок", 5 to "пятьдесят",
                     6 to "шестьдесят", 7 to "семьдесят", 8 to "восемьдесят", 9 to "девяносто")

    val special = mapOf(10 to "десять", 11 to "одиннадцать", 12 to "двенадцать", 13 to "тринадцать",
                        14 to "четырнадцать", 15 to "пятнадцать", 16 to "шестнадцать", 17 to "семнадцать",
                        18 to "восемнадцать", 19 to "девятнадцать")

    val units = mapOf(1 to "один", 2 to "два", 3 to "три", 4 to "четыре",
                      5 to "пять", 6 to "шесть", 7 to "семь", 8 to "восемь",
                      9 to "девять")


    var number = arg.toInt()
    var numberInWords = ""

    if (number >= 1000) {
        numberInWords += thousands[number / 1000] + " "
        number %= 1000
    }

    if (number >= 100) {
        numberInWords += hundreds[number / 100] + " "
        number %= 100
    }

    if (special.containsKey(number)) {
        numberInWords += special[number]
    } else if (number >= 10) {
        numberInWords += tens[number / 10] + " "
        number %= 10
    }

    if (number in 1..9) {
        numberInWords += units[number]
    }

    println(numberInWords)
}