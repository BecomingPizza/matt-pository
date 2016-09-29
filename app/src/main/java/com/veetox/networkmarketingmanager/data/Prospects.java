package com.veetox.networkmarketingmanager.data;

import com.veetox.networkmarketingmanager.helper.FileHelper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A Prospective customer
 */

public final class Prospects
{
    private static Map<String, String> prospects;

    public Prospects()
    {
        prospects = new HashMap<>();
    }


    /**
     * Adds a prospect to the list
      * @param aProspect - The prospect to add
     */
    public static void newProspect(String aProspect)
    {
        UUID uuid = UUID.randomUUID();

        while(prospects.containsKey(uuid))
        {
            uuid = UUID.randomUUID();
        }
        prospects.put(uuid.toString(), aProspect);
    }

    public static void addProspect(String uuid, String prospect)
    {
        prospects.put(uuid, prospect);
    }

    /**
     *
     * @return - Returns an  unmodifiable Map of prospects
     */
    public static Map<String, String> getProspects()
    {
        return Collections.unmodifiableMap(prospects);
    }

    /**
     * Remove a prospect from the list
     * @param uuid
     * @return - True if successful else False
     */
    public static Boolean removeProspect(String uuid)
    {
        if (prospects.containsKey(uuid))
        {
            prospects.remove(uuid);

            return true;
        }
        else
        {
            return false;
        }
    }


}
