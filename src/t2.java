import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class t2 {
    private final static String CLOSE_SUMBOL = "x";// constant
    private final static int CLOSE_SUMBOL_CODE = 120;

    public static boolean Scann_Sumbol(int input_sting) throws IOException{
        if (input_sting == CLOSE_SUMBOL_CODE) {
            return false;
        }else return true;
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java -jar folder-scanner.jar <folder-to-scan>");
            System.exit(0);
        } else {
            String folderToScan = args[0];

            Scanner line_in = new Scanner(System.in);

            System.out.println("To end the program, click: " + CLOSE_SUMBOL);

            File file = new File(folderToScan);
            String[] files = file.list();

            System.out.println("Your files: ");

            List<String> arr = new ArrayList<>();
            for (String f : files) {
                arr.add(f);
            }
            Collections.sort(arr);

            for (int j = 0; j < arr.size(); j++) {
                System.out.println(arr.get(j));
            }

            boolean bool = true;
            while (bool == true) {
                if (line_in.hasNext()) {
                    int input_int = System.in.read();
                    bool = Scann_Sumbol(input_int);
                } else {
                    List<String> arr1 = new ArrayList<>();
                    String[] files1 = file.list();
                    for (String f1 : files1) {
                        arr1.add(f1);
                    }

                    Collections.sort(arr1);
                    while (arr.size() < arr1.size()) {
                        for (int i = arr.size(); i < arr1.size(); i++) {
                            arr.add(arr.get(arr.size() - 1));
                        }
                    }
                    for (int i = 0; i < arr1.size(); i++) {
                        if (arr.get(i).equals(arr1.get(i))) {
                            continue;
                        } else {
                            System.out.println(arr1.get(i));
                            arr.remove(arr.get(i));
                            Collections.sort(arr);
                            arr.add(arr1.get(i));
                            Collections.sort(arr);
                            arr1.remove(arr1.get(i));
                            Collections.sort(arr1);
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
