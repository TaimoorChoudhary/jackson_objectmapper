import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import model.Course;
import model.Exam;
import model.Post;
import model.Student;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author Taimoor Choudhary
 */
public class Mapper {

    ObjectMapper mapper = new ObjectMapper();

    String sampleJsonText = "{\n" +
            "  \"idCard\": 20,\n" +
            "  \"name\": \"Bruce\",\n" +
            "  \"year\": 2020,\n" +
            "  \"address\": \"Gotham City\",\n" +
            "  \"department\": \"Computer Science\",\n" +
            "  \"courses\": [\n" +
            "    {\n" +
            "      \"name\": \"Algorithms\",\n" +
            "      \"credits\": 6\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Data Structure\",\n" +
            "      \"credits\": 5\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Design patters\",\n" +
            "      \"credits\": 3\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    String sampleJsonList = "[\n" +
            "  {\n" +
            "    \"name\": \"Algorithms\",\n" +
            "    \"credits\": 6\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Data Structure\",\n" +
            "    \"credits\": 5\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Design patters\",\n" +
            "    \"credits\": 3\n" +
            "  }\n" +
            "]";

    String sampleJsonText_Complex = "{\n" +
            "  \"id\": 20,\n" +
            "  \"name\": \"Bruce\",\n" +
            "  \"year\": 2020,\n" +
            "  \"address\": \"Gotham City\",\n" +
            "  \"department\": \"Computer Science\",\n" +
            "  \"visualization\": \"Computer Science\",\n" +
            "  \"courses\": \"\"" +
            "}";

    String sampleJsonText_Exam = "{\n" +
            "  \"id\": \"2021\",\n" +
            "  \"studentId\": 20,\n" +
            "  \"courseId\": \"73\"\n" +
            "}";

    public void readData(){
        try {
            Student value = mapper.readValue(sampleJsonText, Student.class);
            System.out.println(value);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void readDataFromURL(){
        try {

            System.out.println(mapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts/1"), Post.class));

        } catch (JsonProcessingException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(){
        try {
            Student studentObject = mapper.readValue(sampleJsonText, Student.class);
            String jsonString = mapper.writeValueAsString(studentObject);
            System.out.println(jsonString);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void readDataWithTreeModel(){
        try {

            ObjectMapper mapper = new ObjectMapper();

            List<Course> value = mapper.readValue(sampleJsonList, new TypeReference<List<Course>>() { });
            System.out.println(value);

            ObjectNode nodes = (ObjectNode) mapper.readTree(sampleJsonText);
            String courses = nodes.get("courses").toString();
            List<Course> courseList = mapper.readValue(courses, new TypeReference<List<Course>>() { });
            System.out.println(courseList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void readDataWithConfiguration(){
        try {

            // to enable standard indentation ("pretty-printing"):
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // to prevent exception when encountering unknown property:
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            // to allow coercion of JSON empty String ("") to null Object value:
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

            Student value = mapper.readValue(sampleJsonText_Complex, Student.class);
            System.out.println(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void readDataWithBuilder(){
        try {

            Exam value = mapper.readValue(sampleJsonText_Exam, Exam.class);
            System.out.println(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
