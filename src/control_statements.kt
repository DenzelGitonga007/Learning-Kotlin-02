import java.util.Scanner // allow user to input values

fun main() {
//    A program to check room temperature
    var data = Scanner(System.`in`) // the variable to get the input

//    Ask the user to enter temperature
    println("Enter temperature: ")
    var temperature = data.nextDouble() // read the value entered

//    Conditions to check the temperature
    if (temperature < 37){

        println("It is too cold")
    } else if (temperature > 37) {
        println("It is too hot")
    } else {
        println("Normal temperature")
    }



}
