import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class Test {

	public static void main(String[] args) {
		bookInfo("bk112");
	}
	public static void bookInfo(String id) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(new File("books.xml"));			
			document.getDocumentElement().normalize();
			
			NodeList booksList = document.getElementsByTagName("book");
			
			for(int i=0;i<booksList.getLength();i++) {
				
				Node book = booksList.item(i);
				if(book.getNodeType() == Node.ELEMENT_NODE) {
					Element bookElement = (Element) book;
					if(bookElement.getAttribute("id").equals(id))
					{
						System.out.println(bookElement.getTagName()+": "+bookElement.getAttribute("id"));
						NodeList bookDetails = bookElement.getChildNodes();	
						for(int j=0;j<bookDetails.getLength();j++) {
							Node detail = bookDetails.item(j);
							if(detail.getNodeType() == Node.ELEMENT_NODE) {								
								Element detailElement = (Element)detail;
								System.out.println(detailElement.getTagName()+": "+detailElement.getTextContent());
								
							}
						}
					}
					
				}
			}
			
			
		} catch (Exception e) {
	
		}		
	}

}
