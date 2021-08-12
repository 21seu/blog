package com.ftj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by fengtj on 2021/8/12 21:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogQuery {

    private String title;

    private Long typeId;

    private boolean recommend;
}
