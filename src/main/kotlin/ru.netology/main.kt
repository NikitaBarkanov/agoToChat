package ru.netology

fun main () {
    val user: String = "Валерон"
    val agoToChat: String = agoBuilder(3602)
    println(user+ " " + "Был в сети " + agoToChat + " назад")
}

fun timeConverter (time: Int): String{
    val s: String = if (time%10 == 2 || time%10 == 3 || time%10 == 4)
        {
            when(time){
                in 1..60 ->  "секунды"
                in 61..3600 -> "минуты"
                in 3601..60*60*24 -> "часа"
                else -> "anyone"
            }}
        else if (time%10 == 1){
        when (time) {
            in 1..60 -> "секунд"
            in 61..3600 -> "минут"
            in 3601..60 * 60 * 24 -> "час"
            else -> "anyone"
        }}
        else {
            when(time){
                in 1..60 ->  "секунд"
                in 61..3600 -> "минут"
                in 3601..60*60*24 -> "часов"
                else -> "anyone"}
        }
    return s
}

fun timeValue (time: Int): Int {
    var thatTime:Int = 0
    when (time){
        in 1..60 -> thatTime = time
        in 61..3600 -> thatTime = time/60
        in 3601..60*60*24 -> thatTime = time/60/60
    }
    return thatTime

}

fun agoBuilder(time: Int): String {
    return (timeValue(time)).toString() + " " + (timeConverter(time))
}