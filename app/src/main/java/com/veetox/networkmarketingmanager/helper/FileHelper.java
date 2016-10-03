package com.veetox.networkmarketingmanager.helper;

import android.content.Context;

import com.veetox.networkmarketingmanager.data.Prospect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
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


    public void saveProspects(ArrayList<Prospect> prospects)
    {

        ArrayList<Prospect> p = prospects;

        BufferedWriter bufferedFileWriter = null;


        try
        {
            File aFile = new File(context.getFilesDir(), "prospects.csv");
            aFile.createNewFile();

            bufferedFileWriter = new BufferedWriter(new FileWriter(aFile));

            for (Prospect eachProspect : p)
            {
                bufferedFileWriter.write(eachProspect.getName());
                bufferedFileWriter.write(",");
                bufferedFileWriter.write(String.valueOf(eachProspect.isChecked()));
                bufferedFileWriter.newLine();
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
            // Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        finally
        {
            try
            {
                bufferedFileWriter.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                //Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    public ArrayList<Prospect> loadProspects()
    {
        ArrayList<Prospect> prospectsList = new ArrayList<>();
        Scanner bufferedScanner = null;
        Scanner lineScanner = null;



            try
            {
                File aFile = new File(context.getFilesDir(), "prospects.csv");
                bufferedScanner = new Scanner(new BufferedReader(new FileReader(aFile)));
                while (bufferedScanner.hasNextLine())
                {
                    lineScanner = new Scanner(bufferedScanner.nextLine());
                    lineScanner.useDelimiter(",");
                    String prospect = lineScanner.next();
                    String contacted = lineScanner.next();

                    Prospect aProspect = new Prospect(prospect, contacted);
                    prospectsList.add(aProspect);

                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
                //Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            }
            finally
            {
                try
                {
                    bufferedScanner.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    //Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
                return prospectsList;
            }

        public ArrayList<Prospect> testProspects()
        {
            ArrayList<Prospect> p = new ArrayList<>();

            Prospect q = new Prospect("Matt Lee", true);
            Prospect r = new Prospect("Rosemary Watson", false);
            Prospect s = new Prospect("Joe Bloggs", false);
            Prospect t = new Prospect("Ronny Corbit", false);
            Prospect u = new Prospect("Mr Man", false);
            Prospect v = new Prospect("Mr Bond", true);
            Prospect w = new Prospect("Mr Blobby", true);
            Prospect x = new Prospect("Mary Rose", false);
            Prospect y = new Prospect("Jane Doe", false);
            Prospect z = new Prospect("Lucy Sanders", false);

            p.add(q);
            p.add(r);
            p.add(s);
            p.add(t);
            p.add(u);
            p.add(v);
            p.add(w);
            p.add(x);
            p.add(y);
            p.add(z);

            return p;
        }



}


