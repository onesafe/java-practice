package com._onesafe.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpiderTEst {
    public static void main(String[] args) {
        String destStr = getURLContent("http://www.163.com", "gbk");

        List<String> result = getMatherSubstrs(destStr, "href=\"(http[\\w\\s./:]+?)\"");
        for (String temp: result) {
            System.out.println(temp);
        }
    }

    public static List<String> getMatherSubstrs(String destStr, String regexStr) {
        //Pattern p = Pattern.compile("<a[\\s\\S]+?</a>"); //取到的超链接的整个内容
        Pattern p = Pattern.compile(regexStr);
        Matcher m = p.matcher(destStr);
        List<String> result = new ArrayList<>();
        while(m.find()) {
            result.add(m.group(1));
        }
        return result;
    }

    public static String getURLContent(String urlStr, String charSet) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charSet)));

            String temp = "";
            while((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

