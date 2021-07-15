import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String[] directories = {"src", "res", "savegames", "temp",
                "src//main", "src//test",
                "res//drawables", "res//vectors", "res//icons"};
        String[] files = {"src//main//Main.java", "src//main//Utils.java", "temp//temp.txt"};
        String createDirFile = "";
        final String MAIN_PATH = "D://Games//";

        for (int i = 0; i < directories.length; i++) {
            File dir = new File(MAIN_PATH + directories[i]);
            if (dir.mkdir()) {
                createDirFile = " создан.";
            } else {
                createDirFile = " не создан.";
            }
            sb.append(dateFormat.format(date) + " ******* Каталог \"" + directories[i] + "\"" + createDirFile + "\n");
        }

        for (int i = 0; i < files.length; i++) {
            File myFile = new File(MAIN_PATH + files[i]);
            try {
                if (myFile.createNewFile()) {
                    createDirFile = " создан.";
                } else {
                    createDirFile = " не создан.";
                }
                sb.append(dateFormat.format(date) + " ------------ Файл \"" + files[i] + "\"" + createDirFile + "\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

        try {
            FileWriter writer = new FileWriter(MAIN_PATH + "temp//temp.txt", true);
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

