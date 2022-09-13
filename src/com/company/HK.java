package com.company;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HK {
    public static void main(String[] args) throws IOException {

        List<Integer> example = Arrays.asList( 3, 6, 2, 4, 5);
        countVisibleTowers(example).forEach(System.out::println);
    }

    public static int getDiscountedPrice(int barcode) {
        try {

            URL url = new URL("https://jsonmock.hackerrank.com/api/inventory?barcode=" + barcode);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            if (con != null) {

                try {

                    System.out.println("****** Content of the URL ********");
                    BufferedReader br =
                            new BufferedReader(
                                    new InputStreamReader(con.getInputStream()));

                    String input = br.readLine();

//                    while ((input = br.readLine()) != null) {
//                        System.out.println(input);
//                    }
                    br.close();
                    JsonElement jsonElement = JsonParser.parseString(input);
                    JsonObject data = jsonElement.getAsJsonObject();
                    JsonArray asJsonArray = data.get("data").getAsJsonArray();
                    if (!asJsonArray.isEmpty()) {
                        JsonElement data1 = asJsonArray.get(0);
                        JsonObject asJsonObject1 = data1.getAsJsonObject();
                        JsonElement price = asJsonObject1.get("price");
                        JsonElement discount = asJsonObject1.get("discount");
                        System.out.println(price.getAsString());
                        System.out.println(discount.getAsString());
                        int priceAsInt = price.getAsInt();
                        return priceAsInt - ((discount.getAsInt() / 100) * priceAsInt);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public static List<Integer> countVisibleTowers(List<Integer> height) {
        List<Integer> visible = new ArrayList<>();
        for (int i = 0; i < height.size(); i++) {
            int count = 0;
            int tempMin = 0;
            int tempMax = 0;
            for (int l = i - 1; l >= 0; l--) {

                if (height.get(l) < height.get(i) && height.get(l)  > tempMin) {
                    tempMin= height.get(l);
                    count++;
                } else {
                    if (height.get(l) > tempMax) {
                        count++;
                        tempMax = height.get(l);
                    }

                }

            }
             tempMin = 0;
             tempMax = 0;
            for (int r = i + 1; r < height.size(); r++) {
                if (height.get(r) < height.get(i) && height.get(r)  > tempMin) {
                    tempMin = height.get(r);
                    count++;
                } else {
                    if (height.get(r) > tempMax) {
                        count++;
                        tempMax = height.get(r);
                    }

                }

            }

            visible.add(count);

        }
        return visible;

    }
}