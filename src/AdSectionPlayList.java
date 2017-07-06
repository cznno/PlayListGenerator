import java.util.List;

/**
 * 播放區間 Entity
 * @author cznno
 * Created by cznno on 17-7-1.
 */
public class AdSectionPlayList {

    private Integer id;
    private List<Integer> adSequence;  //which was adSequence
    private Integer playSectionStart;
    private Integer playSectionEnd;
    private String deviceId;

    public AdSectionPlayList(List<Integer> adSequence, Integer playSectionStart, Integer playSectionEnd) {
        this.adSequence = adSequence;
        this.playSectionStart = playSectionStart;
        this.playSectionEnd = playSectionEnd;
    }

    public AdSectionPlayList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getAdSequence() {
        return adSequence;
    }

    public void setAdSequence(List<Integer> adSequence) {
        this.adSequence = adSequence;
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
