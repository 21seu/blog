package com.ftj.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengtj on 2021/8/14 15:45
 */
public class ListUtils {

    public static List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if (!StringUtils.isEmpty(ids)){
            String[] idArray = ids.split(",");
            for (int i = 0; i < idArray.length; i++) {
                list.add(new Long(idArray[i]));
            }
        }
        return list;
    }
}
