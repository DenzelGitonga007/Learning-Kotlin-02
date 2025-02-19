fun main() {

//    While loop
//    Incrementing

//    Assign first limit
    var lower_limit = 0 // initialize the lower limit

//    Set the condition to determine the range to the upper limit
    while (lower_limit <= 40) {
        println("The number is $lower_limit")
        lower_limit++
    }

//    Decrementing
    var upper_limit = 10

    while (upper_limit>=0) {
        println("The number is $upper_limit")
        upper_limit --
    }

//    Do while
    var counter=31

    do {
        println(counter)
        counter++
    }
    while (counter<=25)

//    For loop
    for (num in 5..10) {
        println(num)
    }

    for (letters in 'a'..'z') {
        println("Letter $letters")
    }

//    Break
    var number=1

    while (number<=6){
        println(number)
        number++

        if (number==4){
            break // you should stop: continue means to skip
        }
    }

//    Continue

    var counter2=5

    while (counter2<=10){
        if (counter2==8){
            counter2++
            continue
        }
        println(counter2)
        counter2++
    }


}


