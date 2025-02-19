import java.util.Scanner

fun main() {
    var reader = Scanner(System.`in`)

    println("Enter a number below 5")
    var number = reader.nextInt()

    var result = when(number) {
        1->"One"
        2->"Two"
        3->"Three"
        4->"Four"
        5->"Five"
        else->"Invalid number"
    }
    println("You entered $result")
}