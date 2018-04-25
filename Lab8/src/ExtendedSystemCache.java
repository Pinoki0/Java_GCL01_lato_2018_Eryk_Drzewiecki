import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class ExtendedSystemCache extends SystemCache implements Serializable {


    public void serialize(String path) throws IOException {

        FileOutputStream fileOutput = new FileOutputStream(path);
        //serialize(fileOutput);
        try (ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {

            objectOutput.writeObject(this);
            objectOutput.close();
            fileOutput.close();
        }




    }
    public void serialize(File file) throws IOException{

        FileOutputStream fileOutput = new FileOutputStream(file);
       // serialize(fileOutput);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

        objectOutput.writeObject(this);
        objectOutput.close();
        fileOutput.close();

    }
    public void serialize(OutputStream stream) throws IOException{

        FileOutputStream fileOutput = new FileOutputStream(String.valueOf(stream));
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

        objectOutput.writeObject(this);
        objectOutput.close();
        fileOutput.close();

    }


    ExtendedSystemCache system = null;

    public void deserialize(String path) throws IOException, ClassNotFoundException {

        FileInputStream file = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(file);

        system = (ExtendedSystemCache) in.readObject();
        system.getCache().forEach((key, value) -> System.out.println(Arrays.toString(key.values)+ " " + value));

        in.close();
        file.close();


    }

    public void deserialize(File mainFile) throws IOException, ClassNotFoundException {

        FileInputStream file = new FileInputStream(mainFile);
        ObjectInputStream in = new ObjectInputStream(file);

        system  = (ExtendedSystemCache) in.readObject();

        system .getCache().forEach((key, value) -> System.out.print(value + "\n"));


        in.close();
        file.close();


    }
    public void deserialize(InputStream stream) throws IOException, ClassNotFoundException {

        FileInputStream file = new FileInputStream(String.valueOf(stream));
        ObjectInputStream in = new ObjectInputStream(file);

        system = (ExtendedSystemCache) in.readObject();

        system .getCache().forEach((key, value) -> System.out.print(value + "\n"));


        in.close();
        file.close();


    }



    public void exportCSV(String path) throws IOException {
        DataOutputStream write = new DataOutputStream(new FileOutputStream(path));
        for (Map.Entry<Parameter, Double> entry : getCache().entrySet()) {

            String toWrite = new String();
            for (int i = 0; i < entry.getKey().values.length; i++) {
                toWrite = toWrite + " " + entry.getKey().values[i];
            }
            write.writeBytes(toWrite + "," + entry.getValue());
            write.writeBytes(System.getProperty("line.separator"));

        }

        write.close();
    }

    public void exportCSV(File file) throws IOException {


        DataOutputStream write = new DataOutputStream(new FileOutputStream(file));
        for (Map.Entry<Parameter, Double> entry : this.getCache().entrySet()) {
           // double[] tempTab = new double[entry.getKey().values.length];
            String toWrite = new String();
            for (int i = 0; i < entry.getKey().values.length; i++) {
                toWrite = toWrite + " " + entry.getKey().values[i];
            }
            write.writeBytes(toWrite + "," + entry.getValue());
          //  write.writeBytes(System.getProperty("line.separator"));

        }
        write.close();

    }


    public void exportCSV(OutputStream stream) throws IOException {
        DataOutputStream dataOut = new DataOutputStream(stream);


        for (Map.Entry<Parameter, Double> entry : this.getCache().entrySet()) {
           // double[] tempTab = new double[entry.getKey().values.length];
            String toWrite = new String();
            for (int i = 0; i < entry.getKey().values.length; i++) {
                toWrite = toWrite + " " + entry.getKey().values[i];
            }
            dataOut.writeBytes(toWrite + "," + entry.getValue());
            dataOut.writeBytes(System.getProperty("line.separator"));
        }
        dataOut.close();


    }

    public void importCSV(String path) throws IOException {


        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader stream = new BufferedReader(inputStreamReader);


        String line = null;



        while ((line = stream.readLine()) != null) {

            String[] tab1 = line.split(",");
            String[] tabS = tab1[0].split("\\s+");
            double[] valuesToMap = new double[tabS.length - 1];


            for (int i = 1; i < tabS.length; i++) {
                valuesToMap[i - 1] = Double.parseDouble(tabS[i]);

            }
            put(valuesToMap, Double.parseDouble(tab1[1]));
        }


       // System.out.print(this.getCache().values());

    }

    public void importCSV(File file) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader stream = new BufferedReader(inputStreamReader);

        String line = null;


        while ((line = stream.readLine()) != null) {

            String[] tab1 = line.split(",");
            String[] tabS = tab1[0].split("\\s+");
            double[] valuesToMap = new double[tabS.length - 1];


            for (int i = 1; i < tabS.length; i++) {
                valuesToMap[i - 1] = Double.parseDouble(tabS[i]);



            }

            put(valuesToMap, Double.parseDouble(tab1[1]));
        }

        System.out.print(this.getCache().values());

    }

    public void importCSV(InputStream stream1) throws IOException{


        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(String.valueOf(stream1)));
        BufferedReader stream = new BufferedReader(inputStreamReader);

        String line = null;


        while ((line = stream.readLine()) != null) {

            String[] tab1 = line.split(",");
            String[] tabS = tab1[0].split("\\s+");
            double[] valuesToMap = new double[tabS.length - 1];



            for (int i = 1; i < tabS.length; i++) {
                valuesToMap[i - 1] = Double.parseDouble(tabS[i]);


            }


        }

    }


}
