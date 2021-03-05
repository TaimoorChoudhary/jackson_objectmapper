/**
 * @author Taimoor Choudhary
 */
public class Main {

    public static void main(String[] args) {
        Mapper mapper = new Mapper();

        mapper.readData();
        mapper.readDataWithTreeModel();
        mapper.readDataWithConfiguration();
        mapper.readDataWithBuilder();

        mapper.writeData();
    }
}
