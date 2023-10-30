import com.github.heqiao2010.lunar.LunarCalendar;

import java.util.Calendar;

/**
 * 小六壬算卦法 https://zhuanlan.zhihu.com/p/570234199
 * 遇事即刻起卦，无事勿占，凡事只占一次，再占不验
 */
public class XiaoLiuRen {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
//        today.set(Calendar.HOUR_OF_DAY,8);
        LunarCalendar lunar = LunarCalendar.solar2Lunar(today);
        int lunarMonth = lunar.getLunarMonth();
        int dayOfLunarMonth = lunar.getDayOfLunarMonth();
        int shiChen = calculateShichen(today.get(Calendar.HOUR_OF_DAY));
        System.out.println("农历：" + lunar.getFullLunarName());
        String[] gua = {"大安","留连","速喜","赤口","小吉","空亡"};
        //测试六月初五9点半
//        lunarMonth = 6;
//        dayOfLunarMonth = 5;
//        shiChen= calculateShichen(9);
        int m = (lunarMonth-1+dayOfLunarMonth-1+shiChen)%6;
        System.out.println("卦象结果："+gua[m]);
    }
    // 根据小时数计算对应的时辰
    public static int calculateShichen(int hour) {
        String[] shichenArray = {
                "子时", "丑时", "寅时", "卯时",
                "辰时", "巳时", "午时", "未时",
                "申时", "酉时", "戌时", "亥时"
        };

        // 计算时辰索引
        int index = (hour + 1) / 2 % 12;
        System.out.println("当前时辰："+shichenArray[index]);
        return index;
    }
}
