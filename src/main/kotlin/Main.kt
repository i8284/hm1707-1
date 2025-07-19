package ru.netology

fun main() {
    val seconds = 840
    fun agoToText (
        second: Int
    ): String {

        val time = when {
            (second >= 39600 && second < 54000) -> "часов"
            (second >= 600 && second < 1200)-> "минут"
            (second / 60) % 10 == 1 && second < 60 * 60 -> "минуту"
            (second / 60 % 10 == 2 || second / 60 % 10 == 3 || second / 60 % 10 == 4) && second < 60 * 60 -> "минуты"
            (second /60 %10 == 0 || second / 60 % 10 == 5 || second / 60 % 10 == 6 || second / 60 % 10 == 7 || second / 60 % 10 == 8 || second / 60 % 10 == 9) && second <= 60 * 60 -> "минут"
            (second / (60 * 60) % 10) == 1 -> "час"
            ((second / (60 * 60) % 10) == 2) || ((second / (60 * 60) % 10) == 3) || ((second / (60 * 60) % 10) == 4) -> "часа"
            else -> "часов"
        }


        return when {
            second >= 0 && second <= 60 -> "был(а) только что"
            second >= 61 && second <= 60 * 60 -> "был(а) ${second / 60} ${time} назад"
            second >= 60 * 60 + 1 && second <= 24 * 60 * 60 -> "был(а) ${second / (60 * 60)} ${time} назад"
            second >= 24 * 60 * 60 && second <= 2 * (24 * 60 * 60) -> "был(а) вчера"
            second >= 2 * (24 * 60 * 60) && second <= 3 * (24 * 60 * 60) -> "был(а) позавчера"
            else -> "был(а) давно"
        }

    }

    val message = agoToText(seconds)
    println(message)
}