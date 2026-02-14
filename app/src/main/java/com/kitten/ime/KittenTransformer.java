package com.kitten.ime;

/**
 * 猫咪文字变换器
 * 将普通中文变成可爱的猫咪风格
 * 长按Shift可以切换猫模式
 */
public class KittenTransformer {
    
    private static boolean sCatModeEnabled = true; // 默认开启猫模式
    
    /**
     * 切换猫模式
     * @return 切换后的状态
     */
    public static boolean toggleCatMode() {
        sCatModeEnabled = !sCatModeEnabled;
        return sCatModeEnabled;
    }
    
    /**
     * 获取猫模式状态
     */
    public static boolean isCatModeEnabled() {
        return sCatModeEnabled;
    }
    
    public static String transform(String text) {
        if (text == null || text.isEmpty()) return text;
        if (!sCatModeEnabled) return text; // 猫模式关闭时不变换
        if (!containsChinese(text)) return text;
        
        String result = text;
        result = result.replace("人", "人咪");
        result = result.replace("你", "人咪");
        result = result.replace("他", "人咪");
        result = result.replace("她", "人咪");
        result = result.replace("它", "人咪");
        result = result.replace("我", "猫");
        result = result.replace("个", "只");
        result = result.replace("什么", "喵什么");
        result = result.replace("为什么", "为喵");
        result = result.replace("怎么", "喵么");
        result = addMiaoToSentenceEnd(result);
        
        return result;
    }
    
    private static String addMiaoToSentenceEnd(String text) {
        if (text == null || text.isEmpty()) return text;
        char lastChar = text.charAt(text.length() - 1);
        String punctuation = "。！？,.?!";
        if (punctuation.indexOf(lastChar) != -1) {
            return text.substring(0, text.length() - 1) + "喵~" + lastChar;
        }
        return text;
    }
    
    private static boolean containsChinese(String str) {
        if (str == null) return false;
        for (char c : str.toCharArray()) {
            if (c >= 0x4E00 && c <= 0x9FA5) return true;
        }
        return false;
    }
}
