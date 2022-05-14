import org.junit.*
import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest {
    companion object {
        private val console: PrintStream = System.out

        private var bytesOutput: ByteArrayOutputStream = ByteArrayOutputStream()
        private val printStreamNew: PrintStream = PrintStream(bytesOutput)

        @BeforeClass
        @JvmStatic
        fun setUp(){
            System.setOut(printStreamNew)
        }

        @AfterClass
        @JvmStatic
        fun tearDown(){
            System.setOut(console)
        }
    }


    @Before
    fun prepareTest() {
        bytesOutput.reset()
    }

    @After
    fun cleanupTest() {
        bytesOutput.reset()
    }

    @Test
    fun testUnits(){
        main("1")
        val actual = bytesOutput.toString(Charsets.UTF_8).trim()
        assertEquals("Units are wrong", "один", actual)
    }

    @Test
    fun testTens(){
        main("30")
        val actual = bytesOutput.toString(Charsets.UTF_8).trim()
        assertEquals("Tens are wrong", "тридцать", actual)
    }

    @Test
    fun testSpecial(){
        main("13")
        val actual = bytesOutput.toString(Charsets.UTF_8).trim()
        assertEquals("Special are wrong", "тринадцать", actual)
    }

    @Test
    fun testHundreds(){
        main("900")
        val actual = bytesOutput.toString(Charsets.UTF_8).trim()
        assertEquals("Hundreds are wrong", "девятьсот", actual)
    }

    @Test
    fun testThousand(){
        main("1000")
        val actual = bytesOutput.toString(Charsets.UTF_8).trim()
        assertEquals("Thousand is wrong", "тысяча", actual)
    }

}