package org.zengzuo613.log4j2.jdk;

public class Const {
    public static final String MSG_HAVE_100_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789abcdefghijklmnopqrstuvwxyz0123456789abcdefghijklmnopqrstuvwxyz ";
    public static final Throwable THROWABLE_HAVE_100_STACK = getStackThrowable(100);

    public static Throwable getStackThrowable(int depth) {
        if (depth == 0) {
            return new Exception("Stack depth reached 100");
        }
        return getStackThrowable(depth - 1); // 递归调用
    }
}
