fun main() {
    var languages = arrayOf("Python", "Kotlin", "Java")
//

    for (x in languages) {
        println("Examples of programming languages are $x")
    }

//    Accessing an element
    println(languages[1])

//    Changing the elements

    languages[2] = "Php"

    println(languages[2])

//    Length of an array

    println(languages.size)

//    Adding a new element
    var more_languages = languages.plus("Ruby")
    for (y in more_languages) {
        println(y)
    }

}