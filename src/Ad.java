/**
 * 廣告 Entity
 *
 * @author cznno
 *         Created by cznno on 17-6-30.
 */
public class Ad {

    private Integer id;
    private Integer media_id;
    private String device_id;
    private Integer length;
    private Integer start;
    private Integer end;
    private Integer loopTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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

    public Integer getLoopTimes() {
        return loopTimes;
    }

    public void setLoopTimes(Integer loopTimes) {
        this.loopTimes = loopTimes;
    }

    public Integer getMedia_id() {
        return media_id;
    }

    public void setMedia_id(Integer media_id) {
        this.media_id = media_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public Ad() {
    }

    public Ad(Integer media_id, String device_id, Integer length, Integer start, Integer end, Integer loopTimes) {
        this.media_id = media_id;
        this.device_id = device_id;
        this.length = length;
        this.start = start;
        this.end = end;
        this.loopTimes = loopTimes;
    }
}


