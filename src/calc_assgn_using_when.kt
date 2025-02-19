import java.util.Scanner

// Calculator assignment using when

fun main() {
    println("....Welcome to Denzel Calculator....")
    println("....Powered by Kotlin....")

//    Get the user input, two numbers
    var reader = Scanner(System.`in`)
    println("...To perform calculations...")
    println("Enter the first number: ")
    var num1 = reader.nextInt() // assign the first input to the the reader

    println("Now enter the calculation symbol (operator)")
    //  Get the operation to be done on the numbers
    var operator = readLine()

    println("Enter the second number:")
    var num2 = reader.nextInt()

//    Perform the calculation
    var result = when(operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "/" -> num1 / num2
        "*" -> num1 * num2
        else -> "Invalid operation"
    }
    println("The answer is $result")

}