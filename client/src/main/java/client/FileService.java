package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileService {
    private static FileOutputStream fileOutputStream;
    private static FileInputStream fileInputStream;
    private static String fileName;

    public static boolean openFileToWrite(String login) {
        try {
            fileOutputStream = new FileOutputStream("./history_" + login, true);
            fileInputStream = new FileInputStream("./history_" + login);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return true;
    }

    public static boolean closeFile() {
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void writeToFile(String message) {
        try {
            fileOutputStream.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readAllMessages() {
        String allMessageses = "";
        byte[] arr = new byte[100];
        try {
            int l;
            while ((l = fileInputStream.read(arr)) > 0) {
                allMessageses = allMessageses + new String(Arrays.copyOf(arr, l));
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        System.out.println(allMessageses);
        return allMessageses;
    }
}
