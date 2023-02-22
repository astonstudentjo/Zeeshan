package main.java.com.example.demoo.model.classes;
public class Image 
{
    private String url;
    public Image(String artistName)
    {
        url = "";
        String[] name = artistName.split(" ");
        for (String s: name)
        {
            url.concat(s);
            url.concat("-");
        }
       url.concat("1");
    }

    public string getUrl()
    {
        return url;
    }
}
