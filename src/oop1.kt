class Person{
    //Properties/Variables/Data members/Attributes
    var name="Glory"
    var age=31
    var location="Nairobi"
    var height=6.1

    //Methods/Functions
    fun eat(){
        println("Eating")
    }
    fun walk(){
        println("Walking")
    }
}

fun main(){
//    Creating an object
    var teacher=Person() // create a variable and specify which class is takes
    teacher.eat() // accessing the methods within the class
    println(teacher.name)

    println(teacher.name+" "+teacher.age.toString()+" "+teacher.location+" "+teacher.height.toString())
}