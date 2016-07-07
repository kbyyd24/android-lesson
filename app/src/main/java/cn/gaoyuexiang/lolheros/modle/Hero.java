package cn.gaoyuexiang.lolheros.modle;

import java.util.List;

/**
 * Created by kbyyd on 2016/7/7.
 */
public class Hero {

    private int id;
    private String nameC;
    private String title;
    private String img;
    private String tags;

    public Hero(int id, String nameC, String title, String img, String tags) {
        this.id = id;
        this.nameC = nameC;
        this.title = title;
        this.img = img;
        this.tags = tags;
    }

    public Hero() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
