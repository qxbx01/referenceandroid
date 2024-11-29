import com.abnamro.apps.referenceandroid.utils.ParseXmlUtil
import org.junit.Assert.assertFalse
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.w3c.dom.Document
import org.xml.sax.SAXParseException
import java.io.FileNotFoundException

class MainActivityResourceTest {

    private lateinit var document: Document

    @Before
    fun setup() {
        // Common setup: parse XML once for all tests
        document = ParseXmlUtil.parseXml("src/main/res/layout/activity_main.xml")
    }

    @Test
    fun `test toolbar resource exists`() {
        val toolbarExists = document.getElementsByTagName("androidx.appcompat.widget.Toolbar")
            .length > 0
        assertTrue("Toolbar element should exist in activity_main.xml", toolbarExists)
    }

    @Test
    fun `test floating action button resource exists`() {
        val fabExists = document.getElementsByTagName("com.google.android.material.floatingactionbutton.FloatingActionButton")
            .length > 0
        assertTrue("Floating Action Button should exist in activity_main.xml", fabExists)
    }

    @Test
    fun `test content_main layout is included`() {
        val includeExists = document.getElementsByTagName("include").let { nodes ->
            (0 until nodes.length).any { i ->
                val node = nodes.item(i)
                node.attributes.getNamedItem("layout")?.nodeValue == "@layout/content_main"
            }
        }
        assertTrue("Content layout should be included in activity_main.xml", includeExists)
    }

    @Test
    fun `test parsing throws exception for missing file`() {
        val exception = assertThrows(FileNotFoundException::class.java) {
            ParseXmlUtil.parseXml("src/main/res/layout/nonexistent_file.xml")
        }
        assertTrue("Exception message should indicate missing file", exception.message?.contains("nonexistent_file.xml") == true)
    }

    @Test
    fun `test parsing XML file with empty root element`() {
        val document = ParseXmlUtil.parseXml("/home/deck/Documents/AndroidStudio/testersassessment-android/app/src/test/java/com/abnamro/apps/referenceandroid/resources/empty_activity_main.xml")
        val rootElement = document.documentElement
        val hasChildNodes = rootElement.hasChildNodes()
        assertFalse("Root element should not have child nodes", hasChildNodes)
    }


}
