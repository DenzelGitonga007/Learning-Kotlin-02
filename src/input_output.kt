import java.util.Scanner

fun main() {
    var reader = Scanner(System.`in`)
    println("Enter your full name: ")
    var fullname = readLine()
    println("Hello $fullname")

    println("How old are you?")
    var age = reader.nextInt()
    println("$fullname, you have existed for $age years, wow!")
}