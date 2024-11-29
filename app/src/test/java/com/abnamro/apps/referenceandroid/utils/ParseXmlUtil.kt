package com.abnamro.apps.referenceandroid.utils

import org.w3c.dom.Document
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

object ParseXmlUtil {
    fun parseXml(filePath: String): Document {
        val file = File(filePath)
        val documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        return documentBuilder.parse(file)
    }
}