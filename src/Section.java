import java.util.List;
import java.util.Map;

/**
 * 播放區間 Entity
 * @author cznno
 * Created by cznno on 17-6-30.
 */
public class Section {
    private int[] ads;
    private Integer start;
    private Integer end;
    Map<Integer,Integer> adWeight;

    public int[] getAds() {
        return ads;
    }

    public void setAds(int[] ads) {
        this.ads = ads;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Map<Integer, Integer> getAdWeight() {
        return adWeight;
    }

    public void setAdWeight(Map<Integer, Integer> adWeight) {
        this.adWeight = adWeight;
    }

    public Section(int[] ads, Integer start, Integer end) {
        this.ads = ads;
        this.start = start;
        this.end = end;
    }

    public Section(List<Integer> ads, int start, int end, Map<Integer, Integer> adWeight) {
        int[] adsInt = new int[ads.size()];
        for(int i=0;i<ads.size();i++)
        {
            adsInt[i] = ads.get(i);
        }
        this.ads = adsInt;
        this.start = start;
        this.end = end;
        this.adWeight = adWeight;
    }
}
