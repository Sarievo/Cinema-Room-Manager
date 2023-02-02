package cinema

class Cinema(private val nRows: Int, private val nCols: Int) {
    private val data = MutableList(nRows) { MutableList(nCols) { false } }
    private val totalSeats = nRows * nCols
    private val firstHalf = nRows / 2
    private var occupiedSeats = 0
    private var income = 0
    private var expectedIncome = firstHalf * nCols * 10 + (nRows - firstHalf) * nCols * 8

    fun printScene() {
        println("Cinema:")
        print(' ')
        for (i in 1..nCols) {
            print(" $i")
        }
        println()
        for (i in 1..nRows) {
            print(i)
            for (j in 1..nCols) {
                when (data[i - 1][j - 1]) {
                    true -> print(" B")
                    false -> print(" S")
                }
            }
            println()
        }
    }

    private fun assignScene(r: Int, c: Int): Boolean {
        if (data[r - 1][c - 1]) return false
        data[r - 1][c - 1] = true
        return true
    }

    fun buy() {
        var done = false
        while (!done) {
            println("Enter a row number:")
            val kRows = readln().toInt()
            println("Enter a seat number in that row:")
            val kCols = readln().toInt()

            if (kRows <= 0 || kRows > nRows || kCols <= 0 || kCols > nCols) {
                println("Wrong input!")
                return
            }

            if (assignScene(kRows, kCols)) {
                printScene()

                val fee: Int = if (totalSeats <= 60) {
                    10
                } else {
                    if (kRows <= firstHalf) 10
                    else 8
                }
                println("Ticket price: $$fee")
                income += fee
                occupiedSeats += 1
                done = true
            } else {
                println("That ticket has already been purchased!")
            }
        }
    }

    fun printStatistics() {
        println("Number of purchased tickets: $occupiedSeats")
        println("Percentage: ${"%.2f%%".format(occupiedSeats * 100.0 / totalSeats)}")
        println("Current income: $$income")
        println("Total income: $$expectedIncome")
    }
}

fun showMenu() {
    println(
        """1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit"""
    )
}

fun main() {
    println("Enter the number of rows:")
    val nRows = readln().toInt()
    println("Enter the number of seats in each row:")
    val nCols = readln().toInt()
    val cinema = Cinema(nRows, nCols)

    var running = true
    while (running) {
        showMenu()
        when (readln().toInt()) {
            1 -> cinema.printScene()
            2 -> cinema.buy()
            3 -> cinema.printStatistics()
            0 -> running = false
        }
        println()
    }
}