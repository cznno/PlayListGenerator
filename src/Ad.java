/**
 * 廣告 Entity
 * @author cznno
 * Created by cznno on 17-6-30.
 */
public class Ad {

    private Integer id;
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

    public Ad(Integer id, Integer length, Integer start, Integer end) {
        this.id = id;
        this.length = length;
        this.start = start;
        this.end = end;
    }

    public Ad(Integer id, Integer length, Integer start, Integer end, Integer loopTimes) {
        this.id = id;
        this.length = length;
        this.start = start;
        this.end = end;
        this.loopTimes = loopTimes;
    }
}
