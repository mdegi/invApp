/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stdClasses;


import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 *
 * @author nla
 */

public class SyncPipe extends Thread {

    InputStream is;
    String type;
    OutputStream os;

    public SyncPipe(InputStream is, String type) {
        this(is, type, null);
    }

    public SyncPipe(InputStream is, String type, OutputStream redirect) {
        this.is = is;
        this.type = type;
        this.os = redirect;
    }

    @Override
    public void run() {

        try {
            PrintWriter pw = null;
            if (os != null) {
                pw = new PrintWriter(os);
            }

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line=null;
            while ( (line = br.readLine()) != null) {
                if (pw != null) {
                    pw.println(line);
                } else {
                    System.out.println(type + ">" + line);
                }
            }
            if (pw != null) {
                pw.flush();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}

