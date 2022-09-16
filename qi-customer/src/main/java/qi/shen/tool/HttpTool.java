package qi.shen.tool;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpTool {

    public static byte[] doGet(String path) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(path);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("get");
            conn.setConnectTimeout(5000);
            InputStream in = conn.getInputStream();
            if (in != null) {
                BufferedInputStream bufferIn = new BufferedInputStream(in);
                bufferIn.read();
            }
        } catch (Exception e)  {
            e.printStackTrace();
        }
        return null;
    }
}
