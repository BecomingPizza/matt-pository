package com.veetox.networkmarketingmanager.data;


/**
 * A Prospective customer
 */

public class Prospects
{
    private String prospectname;
    private boolean contacted;
    private String stringContacted;

    public Prospects(String aName, boolean contacted)
    {
        prospectname = aName;
        this.contacted = contacted;
    }

    public Prospects(String aName, String contacted)
    {
        prospectname = aName;
        this.stringContacted = contacted;
    }

    public Prospects(String aName)
    {
        prospectname = aName;
    }

    public String getName()
    {
        return prospectname;
    }

    public boolean getContacted()
    {
        return contacted;
    }

    public void setName (String aName)
    {
        prospectname = aName;
    }

    public void setContacted(boolean contacted)
    {
        this.contacted = contacted;
    }




}
