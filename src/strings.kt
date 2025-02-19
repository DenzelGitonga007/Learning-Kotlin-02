fun main() {
    var text="Hello world"
    var firstname="Denzel"
    var lastname="eMobilis"

    println(firstname+" "+lastname) //Concatenation
    println(firstname.plus(lastname)) // also joins but no space

    println(text[0]) // accessing an element

    // Modifying a string
    println(text.toUpperCase()) // depreciated
    println(text.toLowerCase())
    println(text.indexOf("world"))
    println("Hello there, my name is $firstname") //String interpolation
}