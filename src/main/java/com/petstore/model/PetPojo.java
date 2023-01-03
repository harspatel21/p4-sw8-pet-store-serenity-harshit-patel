package com.petstore.model;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class PetPojo {

    private int id;
    private HashMap<Object, Object> category;
    private String name;
    private List<Object> photoUrls;
    private List<HashMap<Object, Object>> tags;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Object, Object> getCategory() {
        return category;
    }

    public void setCategory(HashMap<Object, Object> category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<Object> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<HashMap<Object, Object>> getTags() {
        return tags;
    }

    public void setTags(List<HashMap<Object, Object>> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

