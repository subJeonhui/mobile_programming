import kotlin.math.*

interface MyNumber<T> {
    var a: Double
    var b: Double
    fun add(x: T): T
    fun neg(x: T): T
    fun sub(x: T): T = add(neg(x))
    operator fun plus(x: T): T = add(x)
    operator fun minus(x: T): T = sub(x)
}

class Complex(override var a: Double = 0.0, override var b: Double = 0.0) : MyNumber<Complex> {

    // Task-1: Complete the add and neg functions of the Complex class.
    override fun add(x: Complex): Complex {
        return Complex(this.a + x.a, this.b + x.b);
    }

    override fun neg(x: Complex): Complex {
        return Complex(-x.a, -x.b);
    }

    override fun toString(): String {
        return "$a+${b}i"
    }
}


class Exponent(override var a: Double = 0.0, override var b: Double = 1.0) : MyNumber<Exponent> {

    // Task2: create and complete the Exponent class.
    override fun add(x: Exponent): Exponent {
        return Exponent(a.pow(b) + x.a.pow(x.b), 1.0);
    }

    override fun neg(x: Exponent): Exponent {
        return Exponent(-x.a.pow(x.b), 1.0);
    }

    override fun toString(): String {
        return "$a^$b"
    }
}

// Task3: add extension functions to allow cross object operation.
operator fun Complex.plus(x: Exponent): Complex = Complex(x.a.pow(x.b) + a, b)
operator fun Exponent.plus(x: Complex): Complex = Complex(a.pow(b) + x.a, x.b)

fun main(args: Array<String>) {
    val c1 = Complex(4.0, 2.0)
    val c2 = Complex(1.0, 2.0)
    println("c1 + c2 = ${c1 + c2}")
    println("c1 - c2 = ${c1 - c2}")

    val e1 = Exponent(2.0, 3.0)
    val e2 = Exponent(1.0, 2.0)
    println("e1 + e2 = ${e1 + e2}")
    println("e1 - e2 = ${e1 - e2}")

    println("c1 + e1 = ${c1 + e1}")
    println("e1 + c1 = ${e1 + c1}")
}