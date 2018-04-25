import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        ExtendedSystemCache cache = new ExtendedSystemCache();
        ScatterSystem system = new ScatterSystem();
        double arrayFirst[] = {8, 4, 2, 13, 1, 2, 4};
        double arraySecond[] = {16, 1, 3, 23, 15, 1};
        Double output = cache.get(arrayFirst);
        if (output == null) {
            output = system.add(arrayFirst);
            cache.put(arrayFirst, output);
        }
        output = cache.get(arraySecond);
        if (output == null) {
            output = system.add(arraySecond);
            cache.put(arraySecond, output);
        }
        try {
            cache.exportCSV("plik.csv");
            cache.serialize("text");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //////////////////////
        /////////////////////

        try {
            cache.importCSV("plik.csv");
            cache.deserialize("text");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

}
}
