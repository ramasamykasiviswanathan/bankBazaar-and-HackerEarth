package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParsingForXMLComparison {
	public static void main(String[] args) throws Exception {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser parser = saxParserFactory.newSAXParser();
		StringBuilder stringBuilder = new StringBuilder();
		final Stack<String> startTag = new Stack<>(), endTag = new Stack<>(), content = new Stack<>();
		DefaultHandler handler = new DefaultHandler(){
			boolean hasContent = false;
			String previousTag = "";
			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				qName = StringUtils.trimToNull(qName);
				if(qName!=null){
					if(StringUtils.contains(qName, ":"));{
						qName = qName.substring(qName.indexOf(":")+1, qName.length());
					}
					stringBuilder.append("<");
					stringBuilder.append(qName);
					stringBuilder.append(">");
					previousTag=qName;
				}
			}
			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				qName = StringUtils.trimToNull(qName);
				if(qName!=null){
					if(StringUtils.contains(qName, ":"));{
						qName = qName.substring(qName.indexOf(":")+1, qName.length());
					}
					stringBuilder.append("</");
					stringBuilder.append(qName);
					stringBuilder.append(">");
					if(hasContent){
						endTag.push(qName);
						hasContent=false;
					}
				}
			}
			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				String qName = StringUtils.trimToNull(new String(ch, start, length));
				if(qName!=null){
					hasContent = true;
					stringBuilder.append(qName);
					content.push(qName);
					startTag.push(previousTag);
				}
			}
		};
		File file = new File("F:/requestResponse.xml");
		InputStream inputStream = new FileInputStream(file);
		Reader reader = new InputStreamReader(inputStream, "UTF-8");
		InputSource inputSource = new InputSource(inputStream);
		inputSource.setEncoding("UTF-8");
		parser.parse(inputSource, handler);
		
		System.out.println(stringBuilder.toString());
		System.out.println(startTag);
		System.out.println(content);
		System.out.println(endTag);
	}
}
