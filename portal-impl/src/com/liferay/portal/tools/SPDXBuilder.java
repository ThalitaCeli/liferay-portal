/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.tools;

import com.liferay.petra.string.StringPool;
import com.liferay.petra.xml.Dom4jUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.xml.SAXReaderFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;

/**
 * @author Peter Shin
 */
public class SPDXBuilder {

	public static void main(String[] args) throws IOException {
		String xmls = null;

		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in))) {

			xmls = bufferedReader.readLine();
		}

		new SPDXBuilder(StringUtil.split(xmls), args[0]);
	}

	public SPDXBuilder(String[] xmls, String rdf) {
		try {
			System.setProperty("line.separator", StringPool.NEW_LINE);

			String content = Dom4jUtil.toString(_getDocument(xmls, rdf));

			File rdfFile = new File(rdf);

			File file = new File(rdfFile.getParentFile(), "versions-spdx.xml");

			Files.write(
				file.toPath(), content.getBytes(StandardCharsets.UTF_8));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private List<Element> _createLibraryElements(Element packageElement) {
		List<Element> libraryElements = new ArrayList<>();

		String downloadLocation = packageElement.elementText(
			_QNAME_DOWNLOAD_LOCATION);
		String licenseConcluded = packageElement.elementText(
			_QNAME_LICENSE_CONCLUDED);
		String name = packageElement.elementText(_QNAME_NAME);
		String versionInfo = packageElement.elementText(_QNAME_VERSION_INFO);

		List<Element> fileElements = packageElement.elements(_QNAME_FILE);

		for (Element fileElement : fileElements) {
			String fileName = fileElement.elementText(_QNAME_FILE_NAME);

			String dirName = fileName.substring(0, fileName.indexOf('/') + 1);

			if (dirName.endsWith("portal/") || dirName.endsWith("portal-ee/")) {
				fileName = fileName.substring(dirName.length());
			}

			Element libraryElement = DocumentHelper.createElement("library");

			Element fileNameElement = libraryElement.addElement("file-name");

			fileNameElement.addText(fileName);

			Element versionElement = libraryElement.addElement("version");

			versionElement.addText(versionInfo);

			Element projectNameElement = libraryElement.addElement(
				"project-name");

			projectNameElement.addText(name);

			if ((downloadLocation != null) && !downloadLocation.isEmpty()) {
				Element element = libraryElement.addElement("project-url");

				element.addText(name);
			}

			if ((licenseConcluded != null) && !licenseConcluded.isEmpty()) {
				Element licensesElement = libraryElement.addElement("licenses");

				Element licenseElement = licensesElement.addElement("license");

				Element element = licenseElement.addElement("license-name");

				element.addText(licenseConcluded);
			}

			Element commentsElement = libraryElement.addElement("comments");

			commentsElement.addText("This was autogenerated by SPDX");

			libraryElements.add(libraryElement);
		}

		return libraryElements;
	}

	@SuppressWarnings("unchecked")
	private Document _getDocument(String[] xmls, String rdf) throws Exception {
		Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;

		Map<String, Element> libraryElementMap = new TreeMap<>(comparator);

		SAXReader saxReader = SAXReaderFactory.getSAXReader(null, false, false);

		for (String xml : xmls) {
			Document xmlDocument = saxReader.read(new File(xml));

			List<Node> fileNameNodes = xmlDocument.selectNodes("//file-name");

			for (Node fileNameNode : fileNameNodes) {
				Element libraryElement = fileNameNode.getParent();

				String key = _getKey("portal", libraryElement);

				libraryElementMap.put(key, libraryElement);
			}
		}

		Document spdxDocument = saxReader.read(new File(rdf));

		Element spdxRootElement = spdxDocument.getRootElement();

		Element spdxDocumentElement = spdxRootElement.element(
			_QNAME_SPDX_DOCUMENT);

		List<Element> elements = spdxDocumentElement.elements(_QNAME_PACKAGE);

		for (Element element : elements) {
			List<Element> libraryElements = _createLibraryElements(element);

			for (Element libraryElement : libraryElements) {
				String key = _getKey("spdx", libraryElement);

				libraryElementMap.put(key, libraryElement);
			}
		}

		Document document = DocumentHelper.createDocument();

		Element versionsElement = document.addElement("versions");

		Element versionElement = versionsElement.addElement("version");

		Element librariesElement = versionElement.addElement("libraries");

		for (Element libraryElement : libraryElementMap.values()) {
			librariesElement.add(libraryElement.detach());
		}

		return document;
	}

	private String _getKey(String type, Element libraryElement) {
		StringBuilder sb = new StringBuilder();

		sb.append(StringUtil.upperCase(type));
		sb.append(StringPool.COLON);

		Node fileNameNode = libraryElement.selectSingleNode("file-name");

		sb.append(fileNameNode.getText());

		sb.append(StringPool.COLON);

		Node versionNode = libraryElement.selectSingleNode("version");

		sb.append(versionNode.getText());

		return sb.toString();
	}

	private static final QName _QNAME_DOWNLOAD_LOCATION = new QName(
		"downloadLocation", new Namespace("spdx", "http://spdx.org/rdf/terms#"),
		"spdx:downloadLocation");

	private static final QName _QNAME_FILE = new QName(
		"File", new Namespace("spdx", "http://spdx.org/rdf/terms#"),
		"spdx:File");

	private static final QName _QNAME_FILE_NAME = new QName(
		"fileName", new Namespace("spdx", "http://spdx.org/rdf/terms#"),
		"spdx:fileName");

	private static final QName _QNAME_LICENSE_CONCLUDED = new QName(
		"licenseConcluded", new Namespace("spdx", "http://spdx.org/rdf/terms#"),
		"spdx:licenseConcluded");

	private static final QName _QNAME_NAME = new QName(
		"name", new Namespace("spdx", "http://spdx.org/rdf/terms#"),
		"spdx:name");

	private static final QName _QNAME_PACKAGE = new QName(
		"Package", new Namespace("spdx", "http://spdx.org/rdf/terms#"),
		"spdx:Package");

	private static final QName _QNAME_SPDX_DOCUMENT = new QName(
		"SpdxDocument", new Namespace("spdx", "http://spdx.org/rdf/terms#"),
		"spdx:SpdxDocument");

	private static final QName _QNAME_VERSION_INFO = new QName(
		"versionInfo", new Namespace("spdx", "http://spdx.org/rdf/terms#"),
		"spdx:versionInfo");

}