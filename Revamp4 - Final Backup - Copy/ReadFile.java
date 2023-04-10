import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private String file_name = "tt.txt";

    public void readToAllData() throws IOException {     //THIS FUNCTION READS FROM file_name (FROM THIS SAME CLASS) AND PUTS ALL DATA INTO fileData[] (FROM DataBase CLASS) ONE BY ONE
                                                         //NO NEED TO CALL THIS IN MAIN. IT'S MOSTLY USED IN ReadData.java
        this.file_name = file_name;
        BufferedReader br = new BufferedReader(new FileReader(file_name));

        String s;
        int i = 0;

        while((s = br.readLine()) != null){
            DataBase.database[i] = s;
            i++;
        }

    }


    public static int notNullValuesCount(String[] alldata) {  // SINCE fileData (IN DataBase CLASS) IS TOO LARGE,
                                                              // MOST OF ITS ELEMENTS ARE GOING TO BE EMPTY. THIS FUNCTION RETURNS COUNT OF NONEMPTY ELEMENTS OF THIS ARRAY
        int i = 0;
        while(alldata[i] != null){
            i++;
        }
        return i;
    }

}
