package main.java.com.example.demoo.model.classes;

import java.util.Currency;
import java.util.Set;

import javax.swing.DefaultDesktopManager;

public class Price {
    private Double cost = 0;
    private Currency currency = £;

    public Price(Double cost)
    {
        if (checkCost(cost))
        {
        this.cost = cost;
        }
        else
        {
            //throw error
        }
    }
    @Override
    public String toString()
    {
        String result = currency.toString() + cost;
    }

    public void setCost(Double cost)
    {

    }

    private boolean checkCost(Double cost)
    {
       char[] decimalPlaces = cost.toString().split(".")[2].toCharArray();
       if (decimalPlaces.length == 2)
       {
        return true;
       }
       else 
       {
        return false;
       }
    }
}
