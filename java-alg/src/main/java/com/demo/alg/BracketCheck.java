package com.demo.alg;

import java.util.LinkedList;

/**
 * 括号匹配 栈
 * @version 1.0
 * @date 2020/10/9 10:23 上午
 */
public class BracketCheck {
    public static void main(String[] args) {
        // 待匹配 if语句
//        String str = "if ((((((a==1) && (b==1))";
        String str = "if ((a==1)(b==1))";
//        String str = "if (str.contains(\")\"))";
        new BracketCheck().check(str);

    }

    // 括号检查
    public boolean check(String bracketStr) {
        // 初始化栈
        StackUtil<Character> stack = new StackUtil<Character>();
        // 统计左右括号的数目
        short cntL = 0;
        short cntR = 0;
        for (int i = 0; i < bracketStr.length(); i++) {
            if (bracketStr.charAt(i) == '(') {
                ++cntL;
            }
            if (bracketStr.charAt(i) == ')') {
                ++cntR;
            }
        }

        // 遇左括号入栈，遇右括号弹出栈顶元素并匹配
        for (int i = 0; i < bracketStr.length(); i++) {
            // 遇左括号入栈
            if (bracketStr.charAt(i) == '(') {
                stack.push(bracketStr.charAt(i));
            } else if (bracketStr.charAt(i) == ')') { // 遇右括号弹出栈顶元素
                // 栈空，缺少左括号
                if (stack.isEmpty()) {
                    System.out.println("WRONG " + cntL + " " + cntR);
                    return false;
                }
                if (stack.pop() != '(') {
                    System.out.println("WRONG " + cntL + " " + cntR);
                    return false;
                }
            }
        }
        // 栈非空，缺少右括号
        if (!stack.isEmpty()) {
            System.out.println("WRONG " + cntL + " " + cntR);
            return false;
        }

        System.out.println("RIGHT " + cntL + " " + cntR);
        return true;

    }
}

// 使用 LinkedList API 封装栈
class StackUtil<E> {
    private final LinkedList<E> list;

    public StackUtil() {
        list = new LinkedList<E>();
    }
    // 弹出栈顶元素
    public E pop() {
        return list.removeFirst();
    }
    // 压栈
    public void push(E o) {
        list.push(o);
    }
    // 判空
    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void showAll() {
        System.out.println(list);
    }

}