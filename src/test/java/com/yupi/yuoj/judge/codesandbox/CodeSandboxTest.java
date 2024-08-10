package com.yupi.yuoj.judge.codesandbox;

import com.yupi.yuoj.judge.codesandbox.impl.ExampleCodeSandboxImpl;
import com.yupi.yuoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.yuoj.judge.codesandbox.model.ExecuteCodeResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CodeSandboxTest {
    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCode() {
        CodeSandbox codeSandbox = new ExampleCodeSandboxImpl();
        String code = "public class Main {public static void main(String[] args) {System.out.println(\"Hello World\");}}";
        String language = "java";
        List<String> inputList = Arrays.asList("1 2","3 4");
        ExecuteCodeRequest build = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(build);
        Assertions.assertNotNull(executeCodeResponse);
    }
    @Test
    void executeCodeByValue() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        String code = "public class Main {public static void main(String[] args) {System.out.println(\"Hello World\");}}";
        String language = "java";
        List<String> inputList = Arrays.asList("1 2","3 4");
        ExecuteCodeRequest build = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(build);
        Assertions.assertNotNull(executeCodeResponse);
    }
    @Test
    void executeCodeByProxy() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "public class Main {\n" +
                "    public static void main(String[] args) throws InterruptedException {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果是：\"+(a + b));\n" +
                "    }\n" +
                "}\n";
        String language = "java";
        List<String> inputList = Arrays.asList("1 2","3 4");
        ExecuteCodeRequest build = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(build);
        Assertions.assertNotNull(executeCodeResponse);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String type = scanner.next();
            CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
            String code = "public class Main {public static void main(String[] args) {System.out.println(\"Hello World\");}}";
            String language = "java";
            List<String> inputList = Arrays.asList("1 2","3 4");
            ExecuteCodeRequest build = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(build);
        }

    }
}
