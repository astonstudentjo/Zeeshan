package com.example.demoo.model;
public class Image 
{
    public static void ImagePath(Artist a)
    {
        String URL = "";
        String[] name = a.getArtistName().split(" ");
        for (String s: name)
        {
            URL.concat(s);
            URL.concat("-");
        }
       URL.concat("1");
    }
}
