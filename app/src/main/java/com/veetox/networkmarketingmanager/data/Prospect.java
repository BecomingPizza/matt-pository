package com.veetox.networkmarketingmanager.data;


/**
 * A Prospective customer
 */

public class Prospect
{
    private String prospectname;
    private boolean contacted;
    private String stringContacted;

    public Prospect(String aName, boolean contacted)
    {
        prospectname = aName;
        this.contacted = contacted;
    }

    public Prospect(String aName, String contacted)
    {
        prospectname = aName;
        this.stringContacted = contacted;
    }

    public Prospect(String aName)
    {
        prospectname = aName;
    }

    public String getName()
    {
        return prospectname;
    }

    public boolean isChecked()
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

    public void toggleContacted()
    {
        contacted = !contacted;
    }




}
