package dwz.manageRest.dto;

public class TItovVideo {
    private int id;
    // 0-0 默认
    private String type_category_t;
    // 0-0 默认
    private String type_classify_l;
    // 视频标题
    private String title;
    // 文件地址
    private String url_file;
    // 时长
    private String duration;
    // 点击量
    private String point;
    // 截图地址
    private String url_image;
    // 时间
    private String time_add;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getType_category_t() {
	return type_category_t;
    }

    public void setType_category_t(String type_category_t) {
	this.type_category_t = type_category_t;
    }

    public String getType_classify_l() {
	return type_classify_l;
    }

    public void setType_classify_l(String type_classify_l) {
	this.type_classify_l = type_classify_l;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getUrl_file() {
	return url_file;
    }

    public void setUrl_file(String url_file) {
	this.url_file = url_file;
    }

    public String getDuration() {
	return duration;
    }

    public void setDuration(String duration) {
	this.duration = duration;
    }

    public String getPoint() {
	return point;
    }

    public void setPoint(String point) {
	this.point = point;
    }

    public String getUrl_image() {
	return url_image;
    }

    public void setUrl_image(String url_image) {
	this.url_image = url_image;
    }

    public String getTime_add() {
	return time_add;
    }

    public void setTime_add(String time_add) {
	this.time_add = time_add;
    }

}
