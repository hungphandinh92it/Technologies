package com.hungphandinh.technologies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hungphandinh on 05-Jan-15.
 */
public class Utils {

    public static List<CardData> creatCardData(int number, int color){
        ArrayList<CardData> cardDatas = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < number; i++){
            String txtTitle = createString(120);
            String txtContent = createString(250);
            String txtPage = createString(30);
            String txtTime = createString(20);
            int icon = r.nextBoolean()? color:-1;
            CardData data = new CardData(txtTitle,txtContent,txtTime,txtPage,icon);
            cardDatas.add(data);
        }
        return cardDatas;
    }

    private static String createString(int number) {
        StringBuilder builder = new StringBuilder();
        Random r = new Random();
        for (int i=0; i < number;i++){
            char c = (char) r.nextInt(256);
            builder.append(c);
        }
        return builder.toString();
    }
}
