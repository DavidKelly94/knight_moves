import java.util.*

// Represents a square on a chess board with x and y coordinates
// Also keeps the number of steps from the source and square the knight moved from
data class Square(
    val x: Int,
    val y: Int,
    val stepsFromSrc: Int = 0,
    val prevSquare: Square? = null
) {
    // Override toString() to print out formatted (x, y) coordinates
    override fun toString(): String {
        return "($x, $y)"
    }
}

class KnightMoves {
    companion object Main {
        @JvmStatic
        fun main(args: Array<String>) {
            val source = Square(0, 0)
            val destination = Square(1, 2)

            KnightMoves().run { println(this.findMinimumSteps(source, destination)) }
        }
    }

    // List of Pairs of all the possible directions (as x,y coordinates) to move from the current square
    private val moves = listOf(
        2 to -1,
        2 to 1,
        -2 to 1,
        -2 to -1,
        1 to 2,
        1 to -2,
        -1 to 2,
        -1 to -2,
    )

    private fun findMinimumSteps(source: Square, destination: Square): Int {
        // HashSet used to verify knight doesn't return to a square
        val previousMoves = HashSet<Square>()
        // Queue for keeping track of valid squares to move to that are unexplored beginning from the source
        val queue = LinkedList<Square>().also { it.add(source) }

        // Use BFS approach to explore all possible moves from a given square before evaluating moves at the next
        // step count
        while (queue.isNotEmpty()) {
            val currentSquare = queue.remove()
            val stepsFromSrc = currentSquare.stepsFromSrc

            // If the current square coordinates match the destination, print the path and return the step count
            if (currentSquare.x == destination.x && currentSquare.y == destination.y) {
                println(returnPath(currentSquare))
                return stepsFromSrc
            }

            // Prevent going back to a square
            if (!previousMoves.contains(currentSquare)) {
                previousMoves.add(currentSquare)

                // Queue all moves from a current square that are inbounds of the board to be explored
                for (move in moves) {
                    val x = currentSquare.x + move.first
                    val y = currentSquare.y + move.second
                    if (isMoveOnBoard(x, y)) {
                        queue.add(Square(x, y, stepsFromSrc + 1, currentSquare))
                    }
                }
            }
        }

        return -1
    }

    // Used to verify a potential move is on the board
    private fun isMoveOnBoard(x: Int, y: Int): Boolean {
        val bounds = 0 until 8
        return x in bounds && y in bounds
    }

    // Returns string representation of the path taken from source to destination
    private fun returnPath(square: Square): String {
        var path = square.toString()

        if (square.prevSquare != null) {
            path = "${returnPath(square.prevSquare)} -> $path"
        }

        return path
    }
}