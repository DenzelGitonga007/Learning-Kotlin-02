import java.util.Scanner

fun main() {
    // To determine the area of a rectangle
//    Get the length and width

    var reader = Scanner(System.`in`) // declaring the Scanner class
    println("Enter the length: ")
    var length = reader.nextInt()

    println("Enter width: ")
    var width = reader.nextInt()

    var area = length * width
    println("The area is $area")
}