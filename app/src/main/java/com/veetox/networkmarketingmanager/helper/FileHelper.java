package com.veetox.networkmarketingmanager.helper;

import android.content.Context;
import android.widget.Toast;

import com.veetox.networkmarketingmanager.data.Prospects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by Matt on 28/09/2016.
 */

public final class FileHelper
{
    Context context;


   public FileHelper(Context aContext)
   {
       context = aContext;


   }


    public void saveProspects(ArrayList<Prospects> prospects)
    {
        ArrayList<Prospects> p = prospects;

        BufferedWriter bufferedFileWriter = null;


        try
        {
            File aFile = new File(context.getFilesDir(), "prospects.txt");
            bufferedFileWriter = new BufferedWriter(new FileWriter(aFile));

            for (Prospects eachProspect : p)
            {
                bufferedFileWriter.write(eachProspect.getName());
                bufferedFileWriter.write(",");
                bufferedFileWriter.write(String.valueOf(eachProspect.getContacted()));
                bufferedFileWriter.newLine();
            }


        }
        catch (Exception e)
        {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        finally
        {
            try
            {
                bufferedFileWriter.close();
            }
            catch (Exception e)
            {
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    public ArrayList<Prospects> loadProspects()
    {
        ArrayList<Prospects> prospectsList = new ArrayList<>();
        Scanner bufferedScanner = null;
        Scanner lineScanner = null;



            try
            {
                File aFile = new File(context.getFilesDir(), "prospects.txt");
                bufferedScanner = new Scanner(new BufferedReader(new FileReader(aFile)));
                while (bufferedScanner.hasNextLine())
                {
                    lineScanner = new Scanner(bufferedScanner.nextLine());
                    lineScanner.useDelimiter(",");
                    String prospect = lineScanner.next();
                    String contacted = lineScanner.next();

                    Prospects aProspect = new Prospects(prospect, contacted);
                    prospectsList.add(aProspect);

                }

            }
            catch (Exception e)
            {
                Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            }
            finally
            {
                try
                {
                    bufferedScanner.close();
                }
                catch (Exception e)
                {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
                return prospectsList;
            }



}


