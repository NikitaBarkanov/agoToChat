package ru.netology

fun main () {
    val user: String = "Валерон"
    val agoToChat: String = agoBuilder(3600)
    println(user+ " был в сети " + agoToChat)
}

fun calculator(time: Int): String{
    val result: String = when(time){
        in 1..60 -> "только что"
        in 61..3599 -> minutes(time)
        in 3600..60*60*24 -> hours(time)
        else -> days(time)
    }
    return result
}
fun minutes(time: Int): String{
//логика обработки минут (от 1 до 59)
    val minutes: String = if(time%10 == 2 || time%10 == 3 || time%10 == 4){
        return "минуты назад"
    }
    else if (time%10 == 1) {
        return "минуту назад"
    }
    else {
        return "минут назад"
    }
}

fun hours(time: Int): String{
//in 3601..60*60*24 -> thatTime = time/60/60
    val hours: String = if((time/60/60)%10 == 2 || (time/60/60)%10 == 3 || (time/60/60)%10 == 4){
        return "часа назад"
    }
    else if ((time/60/60)%10 == 1) {
        return "час назад"
    }
    else {
        return "часов назад"
    }
}

fun days(time: Int): String {
    val days: String = if (time > 3600*24*2){
        return "давно"
    }
    else if(time <= 3600*24*2 && time >= 3600*24){
        return "вчера"
    }
    else { return "сегодня"}
}

fun timeValue (time: Int): Int {
    var thatTime:Int = 0
    when (time){
        in 1..59 -> thatTime = time
        in 60..3599 -> thatTime = time/60
        in 3600..60*60*24 -> thatTime = time/60/60
    }
    return thatTime

}

fun agoBuilder(time: Int): String {
    if(time > 60 && time < 24*3600)  return (timeValue(time)).toString() + " " + (calculator(time))
    else return calculator(time)
}