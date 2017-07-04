import java.util.*;

/**
 * 廣告播放列表生成,保存广告播放列表
 *
 * @author cznno
 *         Created by cznno on 17-7-1.
 */
public class AdSort {

    public List<AdPlayList> adSort(List<Ad> adList) {

        List<AdPlayList> adPlayListSum = null;
        AdPlayList adPlayList = null;
        List<Section> sectionList = getSectionList(adList);
        List<Integer> playList = new ArrayList<>();
        for (Section section : sectionList) {
            playList.addAll(sorting(section, adList));
            adPlayList = new AdPlayList(playList, section.getStart(), section.getEnd());
            adPlayListSum.add(adPlayList);
        }
        return adPlayListSum;
    }

    /**
     * 生成區間播放列表List
     *
     * @param section 播放區間
     * @param adList  广告列表
     * @return 區間播放列表List
     */
    public static List<Integer> sorting(Section section, List<Ad> adList) {

        List<Integer> group = new ArrayList<>();
        List<Integer> adsOrder = new ArrayList<>();
        Integer totalLength = 0;
        Integer sectionLength = section.getEnd() - section.getStart();
        int totalLoopTimes = 0;
        int remainTimes = 0;

        for (int i : section.getAds()) {
            if(i!=0) {
                for (Ad j : adList) {
                    if (j.getId() == i) {
                        group.add(j.getId());
                    }
                }
            }
        }

        int i = 0;
        Set<Integer> infiniteGroup = new HashSet<>();
        addAds:
        while (totalLength < sectionLength) {  //!!!!
            for (Map.Entry<Integer, Integer> adWeightMap : section.adWeight.entrySet()) {
                if (adWeightMap.getValue().equals(0))
                    infiniteGroup.add(adWeightMap.getKey());
                if (adWeightMap.getValue().equals(i))
                    group.remove(adWeightMap.getKey());
            }
            if (group.size() == 0)
                break addAds;
            for (int j : group) {
                adsOrder.add(j);
                totalLength += adList.get(j).getLength();
            }
            i++;
        }

        remainTimes = (int) Math.ceil((sectionLength - totalLength) / 110);
        if (infiniteGroup.size() == 0) {
            for (i = 0; i <= remainTimes - 1; i++) {
                adsOrder.add(0);
                Collections.shuffle(adsOrder);
            }
            adsOrder.add(0);
        } else if (infiniteGroup.size() != 0) {
            for (i = 0; i <= remainTimes; i++) {
                for (int j : infiniteGroup) {
                    adsOrder.add(j);
                }
            }
            Collections.shuffle(adsOrder);
        }

        return adsOrder;
    }

    /**
     * 生成播放區間List
     *
     * @param adList 广告列表
     * @return 播放區間List
     */
    public static List<Section> getSectionList(List<Ad> adList) {

        List<Section> sectionList = new ArrayList<>();

        Set<Integer> sectionPointsSet = new TreeSet<>();
        sectionPointsSet.add(0);
        for (Ad ad : adList) {
            sectionPointsSet.add(ad.getStart());
            sectionPointsSet.add(ad.getEnd());
        }

        Object[] sectionPointList = sectionPointsSet.toArray();
        int sectionSize = sectionPointsSet.size() - 1;
        List<Integer> sectionAds = new ArrayList<>();
        int sectionStart = 0;
        int sectionEnd = 0;
        int adStart = 0;
        int adEnd = 0;
        int adLoopTimes = 0;

        for (int i = 0; i < sectionSize; i++) {
            Map<Integer, Integer> adWeight = new HashMap<>();
            sectionStart = (int) sectionPointList[i];
            sectionEnd = (int) sectionPointList[i + 1];
            sectionAds.clear();
            for (Ad ad : adList) {
                if (!(ad.getStart() >= sectionEnd || ad.getEnd() <= sectionStart)) {
                    sectionAds.add(ad.getId());
                }
            }
            for (Integer integer : sectionAds) {
                adStart = adList.get(integer).getStart();//
                adEnd = adList.get(integer).getEnd();//
                adLoopTimes = adList.get(integer).getLoopTimes();//
                if (adLoopTimes > 0) {
                    if (adStart <= sectionStart & adEnd <= sectionEnd) {
                        adWeight.put(integer, (int) Math.ceil((float) (adEnd - sectionStart) / (float) (adEnd - adStart) * adLoopTimes));
                    } else if (adStart >= sectionStart & adEnd >= sectionEnd) {
                        adWeight.put(integer, (int) Math.ceil((float) (sectionEnd - adStart) / (float) (adEnd - adStart) * adLoopTimes));
                    } else if (adStart < sectionStart & adEnd > sectionEnd) {
                        adWeight.put(integer, (int) Math.ceil((float) (sectionEnd - sectionStart) / (float) (adEnd - adStart) * adLoopTimes));
                    } else if (adStart > sectionStart & adEnd < sectionEnd) {
                        adWeight.put(integer, (int) Math.ceil((float) (adEnd - adStart) / (float) (adEnd - adStart) * adLoopTimes));
                    } else {
                        System.out.println("ERROR");
                    }
                } else if (adLoopTimes == 0) {
                    adWeight.put(integer, 0);
                }
            }
            Section section = new Section(sectionAds, sectionStart, sectionEnd, adWeight);
            sectionList.add(section);
        }

        return sectionList;
    }
}