fun main(args: Array<String>) {
    val students = listOf("John","Alice","Park", "Jessica")
    val scores = listOf(30,40,35,50)

    // TASK-1: print the students and their scores
    println("Student\tscore")
    println("-------\t-----")
    for ((index, scores) in scores.withIndex()) {
        println("${students[index]}\t${scores}")
    }
    println("-------\t-----")

    // TASK-2: find the average score
    var total_score = 0
    for (score in scores) {
        total_score += score
    }
    println("Total score: $total_score")
    val avg_score = total_score.toFloat() / scores.size
    println("Avg. scores: $avg_score")

    // TASK-3: find the above-average students
    val avg_above_students: MutableList<String> = mutableListOf()
    for ((index, score) in scores.withIndex()) {
        if (score > avg_score) {
            avg_above_students.add(students[index])
        }
    }
    println("Students above average: ${avg_above_students}")

}