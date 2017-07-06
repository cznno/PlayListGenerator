import java.util.*;

/**
 * 演示類
 * 对生成的播放列表做统计
 *
 * @author cznno
 */
public class Main {

    /**
     * main
     * input: 廣告（序號，長度，預定起始播放時間，預定結束播放時間，預定播放次數）
     * output: 播放區間（序號，播放列表，開始時間，結束時間）     *
     */
    public static void main(String[] args) {

        //statistic
        Map<Integer, Integer> statisitc = new HashMap<>();

        //input
        Ad ad_0 = new Ad(0, "10524869", 11, 0, 86400, -1);     //default ad
        Ad ad_1 = new Ad(10001, "10524869", 15, 18000, 72000, 0);     //custom ads
        Ad ad_2 = new Ad(10002, "10524869", 100, 36000, 57600, 22);
        Ad ad_3 = new Ad(10003, "10524869", 180, 54000, 72000, 0);
        Ad ad_4 = new Ad(10004, "10524869", 130, 64000, 72000, 0);
        Ad ad_5 = new Ad(10005, "10524869", 120, 54000, 62000, 12);

        //generate list of ads
        List<Ad> adList = new ArrayList<>();
        adList.add(ad_0);
        adList.add(ad_1);
//        adList.add(ad_2);
//        adList.add(ad_3);
//        adList.add(ad_4);
//        adList.add(ad_5);

        //set sections
        List<Section> sectionList = AdPlayListUtil.generateSections(adList);

        //statistic init
        statisitc.put(0, 0);
        for (Ad ad : adList) {
            statisitc.put(ad.getId(), 0);
        }

        //output
        int i = 0;
        for (Section section : sectionList) {
            System.out.println("--------------------------");
            System.out.println("第" + i + "區間");
            Map<Integer, Integer> playInfo;
            playInfo = getPlayListInfo(AdPlayListUtil.sorting(section, adList), adList);

            for (Map.Entry<Integer, Integer> entry : playInfo.entrySet()) {
                statisitc.put(entry.getKey(), entry.getValue() + (Integer) statisitc.get(entry.getKey()));
            }

            i++;
        }
        System.out.println("--------------------------");
        for (Map.Entry<Integer, Integer> entry : statisitc.entrySet()) {
            System.out.println("序號爲" + entry.getKey() + "的廣告一共播放了" + entry.getValue() + "次");
        }
    }

    /**
     * 统计广告播放状态
     *
     * @param playList 播放列表
     * @param adList   广告列表
     * @return 播放列表展示
     */
    private static Map<Integer, Integer> getPlayListInfo(List<Integer> playList, List<Ad> adList) {
        int count;
        Map<Integer, Integer> playInfo = new HashMap<>();
        System.out.println(playList);
        for (int i = 0; i < playList.size(); i++) {
            count = 1;
            playInfo.put(playList.get(i), 0);
            for (int j = i + 1; j < playList.size(); j++) {
                if (playList.get(i) == playList.get(j)) {
                    count++;// 次数+1
                    playList.remove(j);
                    j--;
                }
            }
            System.out.print("序號爲" + playList.get(i) + "的廣告播放了" + count + "次，");
            playInfo.put(playList.get(i), playInfo.get(playList.get(i)) + count);
            if (playList.get(i) != 0) {
                System.out.println("一共" + adList.get(playList.get(i) - 1).getLength() * count + "秒");
            } else {
                System.out.println("一共" + 110 * count + "秒");
            }
        }
        return playInfo;
    }
}

