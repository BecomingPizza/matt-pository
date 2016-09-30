package com.veetox.networkmarketingmanager.data;

import com.veetox.networkmarketingmanager.helper.FileHelper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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




}
