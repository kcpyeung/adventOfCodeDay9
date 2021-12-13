class HeightMap(lines: List<String>) {
    fun neighbours(x: Int, y: Int): List<Int> {
        val n = { get(x, y - 1) }
        val ne = { get(x + 1, y - 1) }
        val e = { get(x + 1, y) }
        val se = { get(x + 1, y + 1) }
        val s = { get(x, y + 1) }
        val sw = { get(x - 1, y + 1) }
        val w = { get(x - 1, y) }
        val nw = { get(x - 1, y - 1) }

        if (y == 0) {
            if (x == 0) {
                return listOf(
                    e(),
                    s(),
                    se(),
                ).sorted()
            }
            if (x == width - 1) {
                return listOf(
                    w(),
                    sw(),
                    s(),
                ).sorted()
            }

            return listOf(
                w(),
                e(),
                sw(),
                s(),
                se(),
            ).sorted()
        }

        if (y == height - 1) {
            if (x == 0) {
                return listOf(
                    n(),
                    ne(),
                    e(),
                ).sorted()
            }

            if (x == width - 1) {
                return listOf(
                    nw(),
                    n(),
                    w(),
                ).sorted()
            }

            return listOf(
                nw(),
                n(),
                ne(),
                w(),
                e(),
            ).sorted()
        }

        if (x == 0) {
            return listOf(
                n(),
                ne(),
                e(),
                s(),
                se(),
            ).sorted()
        }

        if (x == width - 1) {
            return listOf(
                nw(),
                n(),
                w(),
                sw(),
                s(),
            ).sorted()
        }

        return listOf(
            nw(),
            n(),
            ne(),
            w(),
            e(),
            sw(),
            s(),
            se(),
        ).sorted()
    }

    fun get(x: Int, y: Int) = cells[y][x]
    fun isLowPoint(x: Int, y: Int) = neighbours(x, y).all { it > get(x, y) }

    val height = lines.size
    val width = lines.first().length
    private val cells = lines.map { line -> line.map { it.digitToInt() } }
    val riskLevel = cells.flatMapIndexed { y, xs -> xs.mapIndexed { x, v -> if (isLowPoint(x, y)) v + 1 else 0 } }.sum()
}
