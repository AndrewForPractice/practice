import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Reader {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Вера\\Desktop\\OOP\\практика1\\JDOM\\src\\students.xml";
        try {
            org.jdom2.Document jdomDocument = createJDOM(fileName);
            Element root = jdomDocument.getRootElement();
            List<Element> studListElements = root.getChildren("Student");
            List<Student> students = new ArrayList<>();
            for (Element studentEl : studListElements) {
                Student student = new Student();
                student.setId(Integer.parseInt(studentEl.getAttributeValue("id")));
                student.setAge(Integer.parseInt(studentEl.getChildText("age")));
                student.setName(studentEl.getChildText("name"));
                student.setacademicCourse(studentEl.getChildText("academicCourse"));
                students.add(student);
            }
            for (Student student : students) {
                System.out.println(student.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static org.jdom2.Document createJDOM(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build(doc);

    }
}
