import java.io.IOException;
import java.util.ArrayList;

public class testSample {

    public static void main(String[] args) throws IOException {

        dataDriven dd = new dataDriven();
        ArrayList<String> data = dd.getData("Purchase");

        System.out.println(data.get(0));

    }
}


