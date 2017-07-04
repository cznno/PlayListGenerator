import java.util.List;

/**
 * 播放區間 Entity
 * @author cznno
 * Created by cznno on 17-7-1.
 */
public class AdPlayList {

    private List<Integer> playOrderList;
    private Integer playSectionStart;
    private Integer playSectionEnd;

    public AdPlayList(List<Integer> playOrderList, Integer playSectionStart, Integer playSectionEnd) {
        this.playOrderList = playOrderList;
        this.playSectionStart = playSectionStart;
        this.playSectionEnd = playSectionEnd;
    }

    public AdPlayList() {
    }

    public List<Integer> getPlayOrderList() {
        return playOrderList;
    }

    public void setPlayOrderList(List<Integer> playOrderList) {
        this.playOrderList = playOrderList;
    }

    public Integer getPlaySectionStart() {
        return playSectionStart;
    }

    public void setPlaySectionStart(Integer playSectionStart) {
        this.playSectionStart = playSectionStart;
    }

    public Integer getPlaySectionEnd() {
        return playSectionEnd;
    }

    public void setPlaySectionEnd(Integer playSectionEnd) {
        this.playSectionEnd = playSectionEnd;
    }
}
