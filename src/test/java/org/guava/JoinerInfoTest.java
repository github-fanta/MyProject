package org.guava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.internal.Pair;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;
import pojo.Root;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinerInfoTest {

    /*
     * 根据key和josn字符串取出特定的value
     */
    public static String findJosnValue1(String key, String josn) {
        String regex = "\"" + key + "\": \"(.*?)\"|(\\d*)";
        Matcher matcher = Pattern.compile(regex).matcher(josn);
        String value = null;
        if (matcher.find()) {
            value = matcher.group().split("\\:")[1].replace("\"", "").trim();
            System.out.println(value);
        }
        return value;
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void parseLog() {
        String jsonTest = "{\"processTime\":\"233\",\"timestamp\":\"2020-04-20 12:57:11.296\"}";
        String json = "2459966786\t{\"auditData\":{\"processTime\":\"59\",\"timestamp\":\"2020-04-19 17:05:50.343\",\"requestHost\":\"103.48.141.176, 64.252.139.67, 10.185.5.249, 10.185.29.91\",\"serverId\":\"ip-10-185-10-253.eu-west-1.compute.internal.node.liveaws.discovery#A+\",\"environment\":\"[awseuwest1, awseuwest1a, ip_10_185_10_253]\",\"release\":\"6056f4ad464c8d4709750759eecbd74cd5392333\",\"token\":\"F80C38F324874CB181C8A3D482DB03E6\",\"internal\":\"0|05~~2632d7~737500600~S~~~CFF3A06ECD1440F158730874942902AWCN00000010001000205248267|||0|0|||||||||||R|0|3|~1~3~0||0||0|bhg29r5w4hbngrhr7rybzp4u||||\"},\"error\":{\"code\":\"PRODUCT_ERROR-F80C38F324874CB181C8A3D482DB03E6\",\"message\":\"ProductException(CHECK_RATE, Hotel not Available)\"}}";

        List<Pair<String, String>> pairList = new ArrayList<>();
        String str;

        try (BufferedReader bufReader = new BufferedReader(new FileReader("D:\\Users\\qlil.CN1\\Desktop\\in.txt"));
             BufferedWriter bufWriter = new BufferedWriter(new FileWriter("D:\\Users\\qlil.CN1\\Desktop\\out.txt"))) {
            Root root ;
            while ((str = bufReader.readLine()) != null) {
                try {
                    if (!StringUtils.isEmpty(str.trim())) {
                        String[] splitArr = str.split("\t");
                        root = JSON.parseObject(splitArr[1], Root.class);
                        pairList.add(new Pair<>(splitArr[0],
                                root.getHotel().getRooms().get(0).getRates().get(0).getRateComments()));
                    }
                } catch (Exception ex) {
                    continue;
                }
            }

            for (Pair<String, String> pair : pairList) {
                bufWriter.append(pair.first + "   " + pair.second + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
