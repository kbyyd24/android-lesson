package cn.gaoyuexiang.lolheros.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by kbyyd on 2016/7/7.
 */
public class HttpUtil {

    public static String downloadData(String addrUrl) {
        String result = null;
        try {
            URL url = new URL(addrUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() == 200) {
                InputStream resIn = conn.getInputStream();
                ByteArrayOutputStream resOut = new ByteArrayOutputStream();
                int len = 0;
                byte[] buffer = new byte[512];
                while (-1 != (len = resIn.read(buffer)))
                    resOut.write(buffer, 0, len);
                result = resOut.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
