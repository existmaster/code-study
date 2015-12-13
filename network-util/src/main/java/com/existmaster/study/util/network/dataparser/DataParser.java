package com.existmaster.study.util.network.dataparser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by existmaster on 2015. 12. 13..
 */
public class DataParser {
    public static Map<String, String> parseData(String data, String first, String second) {

        Map<String, String> result = new HashMap<>();

        String[] pairDataset = data.split(first);

        for(String pairData : pairDataset){
            int splitIndex = pairData.indexOf(second);
            result.put(pairData.substring(0,splitIndex), pairData.substring(splitIndex+1));
        }

        return result;

    }
}
