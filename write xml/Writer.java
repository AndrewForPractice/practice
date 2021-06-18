import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Writer {

    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Andrew", 18, "first"));
        students.add(new Student(2, "Viktor", 20, "third"));
        students.add(new Student(3, "Dima", 22, "fourth"));

        String fileName = "write.xml";
        writeToXMLusingJDOM(students, fileName);
    }

    private static void writeToXMLusingJDOM(List<Student> students, String fileName) throws IOException { //метод, записывающий в файл xml
        Document doc = new Document();
        doc.setRootElement(new Element("Students"));
        for (Student student : students) {
            Element studentElement = new Element("Student");
            studentElement.setAttribute("id", String.valueOf(student.getId()));
            studentElement.addContent(new Element("age").setText(String.valueOf(student.getAge())));
            studentElement.addContent(new Element("name").setText(student.getName()));
            studentElement.addContent(new Element("academicCourse").setText(student.getacademicCourse()));
            doc.getRootElement().addContent(studentElement);
        }
        XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());
        xmlWriter.output(doc, new FileOutputStream(fileName));
    }
}
