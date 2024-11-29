package com.abnamro.apps.referenceandroid

import com.abnamro.apps.referenceandroid.utils.XmlColorParser
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import java.io.File
import java.io.FileNotFoundException


class ColorXmlTest {

    @Test
    fun `test colors from XML match expected values`() {
        val parser = XmlColorParser("src/main/res/values/colors.xml")
        val colorsFromXml = parser.parseColors()
        val expectedColors = mapOf(
            "colorPrimary" to "#008577",
            "colorPrimaryDark" to "#00574B",
            "colorAccent" to "#D81B60"
        )

        for ((name, value) in expectedColors) {
            assertEquals("Mismatch for color: $name", value, colorsFromXml[name])
        }
    }

    @Test
    fun `test parsing throws exception for missing file`() {
        val parser = XmlColorParser("src/main/res/values/nonexistent_colors.xml")

        assertThrows(FileNotFoundException::class.java) {
            parser.parseColors()
        }
    }

    @Test(expected = Exception::class)
    fun `test parsing throws exception for invalid XML`() {
        val invalidXmlFile = File("app/src/test/java/com/abnamro/apps/referenceandroid/resources/invalid_colors.xml")
        val parser = XmlColorParser(invalidXmlFile.absolutePath)
        parser.parseColors()
    }

}
