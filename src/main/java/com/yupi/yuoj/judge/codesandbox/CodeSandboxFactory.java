package com.yupi.yuoj.judge.codesandbox;

import com.yupi.yuoj.judge.codesandbox.impl.ExampleCodeSandboxImpl;
import com.yupi.yuoj.judge.codesandbox.impl.RemoteCodeSandboxImpl;
import com.yupi.yuoj.judge.codesandbox.impl.ThirdPartyCodeSandboxImpl;

/**
 * 代码沙箱工厂 (根据字符串获取对应的代码沙箱)
 */
public class CodeSandboxFactory {
    /**
     * 获取对应的代码沙箱实现
     *
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandboxImpl();
            case "remote":
                return new RemoteCodeSandboxImpl();
            case "thirdParty":
                return new ThirdPartyCodeSandboxImpl();
            default:
                return new ExampleCodeSandboxImpl();
        }
    }

}
