fun main(args: Array<String>) {
//    println("Hello, ${args[0]}")
//
//    val temperature = 20
//    val isHot = if (temperature > 40) true else false
//    println(isHot)
//
//    val isUnit = println("This is an expression")
//    println(isUnit)

    val books = listOf("nature", "biology", "birds")
    println(books.filter { it[0] == 'b' })
}