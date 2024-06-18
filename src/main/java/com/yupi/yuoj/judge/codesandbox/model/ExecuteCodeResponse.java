package com.yupi.yuoj.judge.codesandbox.model;

import com.yupi.yuoj.model.dto.questionsubmit.JudgeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteCodeResponse {
    /**
     * 输出结果
     */
    private List<String> outputList;
    /**
     * 接口信息
     */
    private String message;
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;
}
