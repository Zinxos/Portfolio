package pl.piotrS;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class xmlReader {


    public static void xmlReader() {
        
            int autId = 0;
            ResultSet idResult;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Connection connection = DbConnect.Connect();
                Statement statement = connection.createStatement();
                Document document = builder.parse(new File("xml.xml"));
                document.getDocumentElement().normalize();
                NodeList bookList = document.getElementsByTagName("book");
                String xmlGenre = null;
                String xmlAuthor = null;
                for (int i = 0; i < bookList.getLength(); i++) {
                    Node book = bookList.item(i);
                    if (book.getNodeType() == Node.ELEMENT_NODE) {
                        Element bookElement = (Element) book;
                        String xmlTitle  = bookElement.getAttribute("title");
                        NodeList bookDetails = book.getChildNodes();
                        for (int j = 0; j < bookDetails.getLength(); j++) {
                            Node detail = bookDetails.item(j);
                            if (detail.getNodeType() == Node.ELEMENT_NODE) {
                                Element detailElement = (Element) detail;
                                if(xmlAuthor==null){
                                    xmlAuthor = detailElement.getAttribute("value");
                                }else{xmlGenre = detailElement.getAttribute("value");}
                                

                            }
                        }
                        idResult = statement.executeQuery("select * from catalog_author where author ='" + xmlAuthor + "';");
                        if(idResult.next()) {
                            autId = idResult.getInt("aut_id");
                        }else
                        {
                            statement.executeUpdate("insert into catalog_author(author)" +
                                    "value('"+xmlAuthor+"');");
                            idResult = statement.executeQuery("select * from catalog_author where author ='" + xmlAuthor + "';");
                            if(idResult.next()) {
                                autId = idResult.getInt("aut_id");}
                        }
                        String sqlInsert = "insert into books (title, author, code_genre, aut_id)" +
                                "Values('"+xmlTitle+"', '"+xmlAuthor+"', '"+xmlGenre+"','"+autId+"');";
                        
                        statement.executeUpdate(sqlInsert);
                        xmlAuthor = null;
                    }
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }
    }






