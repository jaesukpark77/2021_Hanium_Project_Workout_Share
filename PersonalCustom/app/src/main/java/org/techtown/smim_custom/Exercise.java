package org.techtown.smim_custom;

public class Exercise {
    String name;
    String part;
    int imageRes;
    private boolean isSelected = false;

    public Exercise(String name, String part, int imageRes) {
        this.name = name;
        this.part = part;
        this.imageRes = imageRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public void setSelected(boolean selected){
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }


}