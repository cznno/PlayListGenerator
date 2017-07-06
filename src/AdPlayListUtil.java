import java.util.*;

/**
 * 廣告播放列表生成
 *
 * @author cznno
 *         Created by cznno on 17-7-1.
 */
public class AdPlayListUtil {

    public List<AdSectionPlayList> generateAdPlayOrderList(List<Ad> adList) {

        List<AdSectionPlayList> adSectionPlayListSum = null;
        List<Section> sectionList = generateSections(adList);
        for (Section section : sectionList) {
            List<Integer> playList = new ArrayList<>();
            playList.addAll(generateSectionAdPlaySequence(section, adList));
            AdSectionPlayList adSectionPlayList = new AdSectionPlayList(playList, section.getStart(), section.getEnd());
            adSectionPlayListSum.add(adSectionPlayList);
        }
        return adSectionPlayListSum;
    }

    public static List<Section> generateSections(List<Ad> adList) {

        List<Section> sectionList = new ArrayList<>();
        List<Integer> sectionPointsList = getSectionPeriods(adList);
        List<Integer> sectionAds = new ArrayList<>();

        int sectionSize = sectionPointsList.size() - 1;
        for (int i = 0; i < sectionSize; i++) {
            Map<Integer, Integer> adInfo = new HashMap<>();
            int sectionStart = sectionPointsList.get(i);
            int sectionEnd = sectionPointsList.get(i + 1);
            sectionAds.clear();
            for (Ad ad : adList) {
                if (!(ad.getStart() >= sectionEnd || ad.getEnd() <= sectionStart)) {
                    int adId = ad.getId();
                    int adStart = adList.get(adId).getStart();//
                    int adEnd = adList.get(adId).getEnd();//
                    int adLoopTimes = adList.get(adId).getLoopTimes();//
                    if (adLoopTimes > 0) {
                        if (adStart <= sectionStart & adEnd <= sectionEnd) {
                            adInfo.put(adId, (int) Math.ceil((float) (adEnd - sectionStart) / (float) (adEnd - adStart) * adLoopTimes));
                        } else if (adStart >= sectionStart & adEnd >= sectionEnd) {
                            adInfo.put(adId, (int) Math.ceil((float) (sectionEnd - adStart) / (float) (adEnd - adStart) * adLoopTimes));
                        } else if (adStart < sectionStart & adEnd > sectionEnd) {
                            adInfo.put(adId, (int) Math.ceil((float) (sectionEnd - sectionStart) / (float) (adEnd - adStart) * adLoopTimes));
                        } else if (adStart > sectionStart & adEnd < sectionEnd) {
                            adInfo.put(adId, (int) Math.ceil((float) (adEnd - adStart) / (float) (adEnd - adStart) * adLoopTimes));
                        } else {
                            System.out.println("ERROR");
                        }
                    } else if (adLoopTimes == 0) {
                        adInfo.put(adId, 0);
                    } else if (adLoopTimes == -1) {
                        adInfo.put(adId, -1);
                    }
                }
            }
            Section section = new Section(adInfo, sectionStart, sectionEnd);
            sectionList.add(section);
        }

        return sectionList;
    }

    private static List<Integer> getSectionPeriods(List<Ad> adList) {

        Set<Integer> sectionPointsSet = new TreeSet<>();
        sectionPointsSet.add(0);
        for (Ad ad : adList) {
            sectionPointsSet.add(ad.getStart());
            sectionPointsSet.add(ad.getEnd());
        }
        List<Integer> sectionPointsList = new ArrayList<>(sectionPointsSet);
        return sectionPointsList;
    }

    public static List<Integer> generateSectionAdPlaySequence(Section section, List<Ad> adList) {

        List<Integer> adGroup = new ArrayList<>(section.getAdsInfo().keySet());
        List<Integer> sequence = new ArrayList<>();
        Integer totalLength = 0;
        Integer sectionLength = section.getEnd() - section.getStart();
        int totalLoopTimes = 0;
        int remainTimes = 0;

        int i=0;
        while (adGroup.size() > 0) {

            if(i<=section.getAdsInfo().get())
        }

        //====================
        for (int i : section.getAds()) {
            if (i != 0) {
                for (Ad j : adList) {
                    if (j.getId() == i) {
                        adGroup.add(j.getId());
                    }
                }
            }
        }

        int i = 0;
        Set<Integer> infiniteGroup = new HashSet<>();
        addAds:
        while (totalLength < sectionLength) {  //!!!!
            for (Map.Entry<Integer, Integer> adInfo : section.getAdsInfo().entrySet()) {
                if (adInfo.getValue().equals(0))
                    infiniteGroup.add(adInfo.getKey());
                if (adInfo.getValue().equals(i))
                    adGroup.remove(adInfo.getKey());
            }
            if (adGroup.size() == 0)
                break addAds;
            for (int j : adGroup) {
                sequence.add(j);
                totalLength += adList.get(j).getLength();
            }
            i++;
        }

        remainTimes = (int) Math.ceil((sectionLength - totalLength) / adList.get(0).getLength());
        if (infiniteGroup.size() == 0) {
            for (i = 0; i <= remainTimes - 1; i++) {
                sequence.add(0);
                Collections.shuffle(sequence);
            }
            sequence.add(0);
        } else if (infiniteGroup.size() != 0) {
            for (i = 0; i <= remainTimes; i++) {
                for (int j : infiniteGroup) {
                    sequence.add(j);
                }
            }
            Collections.shuffle(sequence);
        }

        return sequence;
    }


}