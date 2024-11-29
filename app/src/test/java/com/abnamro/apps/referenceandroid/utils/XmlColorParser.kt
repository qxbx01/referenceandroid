package com.abnamro.apps.referenceandroid.utils

import org.w3c.dom.Document
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

class XmlColorParser(private val filePath: String) {

    fun parseColors(): Map<String, String> {
        val colorsMap = mutableMapOf<String, String>()
        val file = File(filePath)
        val doc: Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file)
        val nodeList = doc.getElementsByTagName("color")

        for (i in 0 until nodeList.length) {
            val node = nodeList.item(i)
            val name = node.attributes.getNamedItem("name").nodeValue
            val value = node.textContent.trim()
            colorsMap[name] = value
        }
        return colorsMap
    }
}
