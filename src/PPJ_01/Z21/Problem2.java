package PPJ_01.Z21;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Problem2 {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        try ( InputStream fin = new FileInputStream(name);
              OutputStream fout = new FileOutputStream("Person.txt");) {
            int n;
            while ((n = fin.read()) != -1) {
                char c = (char)n;
                //System.out.print(c);
                fout.write(n);
            }
        } catch (IOException e){}
    }
}
