package com.ftj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fengtj on 2021/8/7 14:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    /**
     * 首图
     */
    private String firstPicture;

    private String flag;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 赞赏开启
     */
    private boolean appreciation;

    /**
     * 版权开启
     */
    private boolean shareStatement;

    /**
     * 评论开启
     */
    private boolean commentabled;

    /**
     * 是否发布
     */
    private boolean published;

    /**
     * 是否推荐
     */
    private boolean recommend;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST}) //CascadeType.PERSIST 级联新增
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();
}
