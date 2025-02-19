fun main() {
    //Arithmetic operators
    var num1:Int=34
    var num2:Int=15

    println(num1+num2) // addition
    println(num1*num2) // multiplication
    println(num1-num2) // subtraction
    println(num1/num2) // division
    println(num1%num2) // modulus


    //Assignment operators
    var number=5
    println(number)

    var x=6
    x+=5 // operator precedence -- order in which operators get executed, eg BODMAS
    // = is executed first, 5 will be assigned to x, then added to 6
    println(x)

    var y=20
    y%=11 // 20 divided by 11, remains 9

    println(y)

    //Comparison Operators
    var firstnumber=89
    var secondnumber=64
    println(firstnumber<secondnumber)
    println(firstnumber>secondnumber)
    println(firstnumber==secondnumber)
    println(firstnumber<=secondnumber)
    println(firstnumber>=secondnumber)
    println(firstnumber!=secondnumber)

    //Logical operators
    var log=78
    println(log<56 && log>23) //And
    println(log<56 || log>23) //Or
    println(!(log<56 || log>23)) //Not

}