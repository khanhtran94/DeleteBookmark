import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        //read file
        BufferedReader reader;
        Set<String> draw = new HashSet<>();
        Set<String> href = new HashSet<>();
        String reg = "\"";
        Map<String, String> stringHashMap = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader(
                    "src/bookmarks_12_4_20.html"));
            String line = reader.readLine();
            int i = 0;
            while (line != null) {

                draw.add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //split string map url -> line
        System.out.println(draw.size());
        for (String s :
                draw) {
            String[] arr = s.split(reg);
            if (arr.length > 1 ){
                stringHashMap.putIfAbsent(arr[1], s);
            }
        }

        // write file
        int count = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt", true));
        for (Map.Entry<String, String> me : stringHashMap.entrySet()) {
            writer.append(me.getValue());
            writer.append("\n");
            count ++;
        }
        System.out.println(count);
        writer.close();
    }
}