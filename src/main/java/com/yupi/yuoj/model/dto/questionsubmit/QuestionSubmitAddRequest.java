package com.yupi.yuoj.model.dto.questionsubmit;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目提交
 *
 * @author <a href="https://github.com/wcw-001">程序员wcw</a>
 *
 */
@TableName(value = "post")
@Data
public class QuestionSubmitAddRequest implements Serializable {

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 代码
     */
    private String code;

    /**
     * 判题信息（json 对象）
     */
    private String judgeInfo;

    private static final long serialVersionUID = 1L;
}
