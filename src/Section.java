import java.util.List;
import java.util.Map;

/**
 * 播放區間 Entity
 *
 * @author cznno
 *         Created by cznno on 17-6-30.
 */
public class Section {

    private Map<Integer, Integer> adsInfo;
    private Integer start;
    private Integer end;

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

    public Map<Integer, Integer> getAdsInfo() {
        return adsInfo;
    }

    public void setAdsInfo(Map<Integer, Integer> adsInfo) {
        this.adsInfo = adsInfo;
    }

    public Section() {

    }

    public Section(Map<Integer, Integer> adsInfo, Integer start, Integer end) {
        this.adsInfo = adsInfo;
        this.start = start;
        this.end = end;
    }
}
