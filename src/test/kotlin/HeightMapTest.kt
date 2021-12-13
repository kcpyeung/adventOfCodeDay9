import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class HeightMapTest {
    @Test
    fun `has width`() {
        val lines = listOf("2199943210", "3987894921")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.width, `is`(10))
    }

    @Test
    fun `has height`() {
        val lines = listOf("2199943210", "3987894921", "9856789892")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.height, `is`(3))
    }

    @Test
    fun `assigns each digit an xy coordinate`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.get(0, 0), `is`(2))
        assertThat(heightmap.get(5, 1), `is`(9))
        assertThat(heightmap.get(9, 2), `is`(2))
    }

    @Test
    fun `returns neighbours of a specified coordinate in a centre cell`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.neighbours(2, 1), `is`(listOf(1, 5, 6, 7, 8, 9, 9, 9)))
    }

    @Test
    fun `returns neighbours of a specified coordinate in a top-row cell`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.neighbours(2, 0), `is`(listOf(1, 7, 8, 9, 9)))
    }

    @Test
    fun `returns neighbours of the top-left corner cell`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.neighbours(0, 0), `is`(listOf(1, 3, 9)))
    }

    @Test
    fun `returns neighbours of the top-right corner cell`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.neighbours(9, 0), `is`(listOf(1, 1, 2)))
    }

    @Test
    fun `returns neighbours of a specified coordinate in a bottom-row cell`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.neighbours(6, 4), `is`(listOf(6, 6, 6, 7, 9)))
    }

    @Test
    fun `returns neighbours of the bottom-left corner cell`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.neighbours(0, 4), `is`(listOf(7, 8, 8)))
    }

    @Test
    fun `returns neighbours of the bottom-right corner cell`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.neighbours(9, 4), `is`(listOf(7, 8, 9)))
    }

    @Test
    fun `returns neighbours of a specified coordinate in a left-margin cell`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.neighbours(0, 2), `is`(listOf(3, 7, 8, 8, 9)))
    }

    @Test
    fun `returns neighbours of a specified coordinate in a right-margin cell`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.neighbours(9, 2), `is`(listOf(1, 2, 8, 9, 9)))
    }

    @Test
    fun `knows a cell is not a low point`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.isLowPoint(2, 1), `is`(false))
        assertThat(heightmap.isLowPoint(6, 3), `is`(false))
    }

    @Test
    fun `knows a cell is a low point`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.isLowPoint(2, 2), `is`(true))
        assertThat(heightmap.isLowPoint(9, 0), `is`(true))
    }

    @Test
    fun `has a risk level`() {
        val lines = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")

        val heightmap = HeightMap(lines)

        assertThat(heightmap.riskLevel, `is`(15))
    }
}
