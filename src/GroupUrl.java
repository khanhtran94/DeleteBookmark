import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//group url. change reg
public class GroupUrl {
    public static void main(String[] args) throws IOException {
        //read file
        BufferedReader reader;
        Set<String> draw = new HashSet<>();
        Set<String> href = new HashSet<>();
        String reg = "\"";
        Map<String, String> stringHashMap = new HashMap<>();

        try {
//            reader = new BufferedReader(new FileReader(
//                    "src/bookmarks_unit.html"));
            reader = new BufferedReader(new FileReader(
                    "text.txt"));
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
            if (arr.length > 1) {
                stringHashMap.putIfAbsent(arr[1], s);
            }
        }

        // write file
        BufferedWriter writer_java = new BufferedWriter(new FileWriter("java.txt", true));
        BufferedWriter writer_xxx = new BufferedWriter(new FileWriter("xxx.txt", true));
        BufferedWriter writer_other = new BufferedWriter(new FileWriter("other.txt", true));
        BufferedWriter writer_medium = new BufferedWriter(new FileWriter("medium.txt", true));
        int count = 0;
        for (Map.Entry<String, String> me : stringHashMap.entrySet()) {
            if (me.getValue().contains("java")) {
                count++;
                writer_java.append(me.getValue());
                writer_java.append("\n");
            } else if (me.getValue().contains("javmost") || me.getValue().contains("xvideos")
                    || me.getValue().contains("avgle") || me.getValue().contains("hentai")) {
                writer_xxx.append(me.getValue());
                writer_xxx.append("\n");
                count++;
            } else if (me.getValue().contains("medium")) {
                writer_medium.append(me.getValue());
                writer_medium.append("\n");
                count++;
            } else {
                writer_other.append(me.getValue());
                writer_other.append("\n");
                count++;
            }

        }
        System.out.println(count);
        writer_java.close();
        writer_xxx.close();
        writer_other.close();
        writer_medium.close();
    }
}
