import kotlin.math.sqrt

// Problem overview:
// Do some operation on 2D points
// Each point is represented by a list of x and y coordinates.
fun main() {
    // TASK: make a lambda function <pt> to define a point by a list of two Int (x,y)
    val pt: (Int, Int) -> List<Int> = { x: Int, y: Int -> listOf(x, y) }
    println("pt function check: " + pt(1, 2)) // should print [1,2]


    // TASK: make a list <points> of the following 2D points using the <pt> function
    // [[1,2], [-2,2], [-1,0], [2,1]]
    val points: List<List<Int>> = listOf(
        pt(1, 2),
        pt(-2, 2),
        pt(-1, 0),
        pt(2, 1)
    )

    println("points \t: " + points)

    // TASK: complete the myFilter function to filter elements based on some criteria function
    val defaultCriteria: (List<Int>) -> Boolean = { point -> true }
    println("default \t: " + myFilter(pts = points, criteria = defaultCriteria))

    // TASK: using myFilter function, select points having negative x coordinates.
    val neg_x = myFilter(pts = points,
        criteria = { point -> point[0] < 0 })
    println("neg_x \t\t: " + neg_x)

    // TASK: using myFilter function, select points having distance <= 2 from the origin
    val close_x = myFilter(pts = points,
        criteria = { point -> distance(point) <= 2.0 })
    print("dist<=2 \t: " + close_x)
}

fun myFilter(
    pts: List<List<Int>>,
    criteria: (List<Int>) -> Boolean
): List<List<Int>> {
    return pts.filter { criteria(it) }
}

fun distance(pt: List<Int>): Double {
    return sqrt((pt[0]*pt[0] + pt[1]*pt[1]).toDouble())
}
