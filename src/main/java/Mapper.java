import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import model.Course;
import model.Exam;
import model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Taimoor Choudhary
 */
public class Mapper {

    ObjectMapper mapper = new ObjectMapper();

    String sampleJasonText  = "{\n" +
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

    String sampleJasonList  = "[\n" +
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

    String sampleJasonText_Complex  = "{\n" +
            "  \"id\": 20,\n" +
            "  \"name\": \"Bruce\",\n" +
            "  \"year\": 2020,\n" +
            "  \"address\": \"Gotham City\",\n" +
            "  \"department\": \"Computer Science\",\n" +
            "  \"visualization\": \"Computer Science\",\n" +
            "  \"courses\": \"\"" +
            "}";

    String sampleJasonText_Exam  = "{\n" +
            "  \"id\": \"2021\",\n" +
            "  \"studentId\": 20,\n" +
            "  \"courseId\": \"73\"\n" +
            "}";

    public void readData(){
        try {
            Student value = mapper.readValue(sampleJasonText, Student.class);
            System.out.println(value);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void writeData(){
        try {
            Student value = mapper.readValue(sampleJasonText, Student.class);
            String jsonString = mapper.writeValueAsString(value);
            System.out.println(jsonString);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void readDataWithTreeModel(){
        try {

            ObjectMapper mapper = new ObjectMapper();

            List<Course> value = mapper.readValue(sampleJasonList, new TypeReference<List<Course>>() { });
            System.out.println(value);

            ObjectNode root = (ObjectNode) mapper.readTree(sampleJasonText);
            String courses = root.get("courses").toString();
            List<Course> valueTwo = mapper.readValue(courses, new TypeReference<List<Course>>() { });
            System.out.println(valueTwo);
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

            Student value = mapper.readValue(sampleJasonText_Complex, Student.class);
            System.out.println(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void readDataWithBuilder(){
        try {

            Exam value = mapper.readValue(sampleJasonText_Exam, Exam.class);
            System.out.println(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
