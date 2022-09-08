package com.example.aniket.derby;

/**
 * Created by Aniket on 04/03/17.
 */

public class RecyclerViewClass {
    private String title, subtitle;
    public RecyclerViewClass()
    {

    }
    public RecyclerViewClass(String title, String subtitle)
    {
        this.title = title;
        this.subtitle = subtitle;
    }
    public String getTitle()
    {
        return title;
    }
    public String getSubtitle()
    {
        return subtitle;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void  setSubtitle(String subtitle)
    {
        this.subtitle = subtitle;
    }
}
