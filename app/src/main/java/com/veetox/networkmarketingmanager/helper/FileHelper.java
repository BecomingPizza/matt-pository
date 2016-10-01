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
            File aFile = new File(context.getFilesDir(), "prospects.csv");
            aFile.createNewFile();

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

    public ArrayList<Prospects> loadProspects()
    {
        ArrayList<Prospects> prospectsList = new ArrayList<>();
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

                    Prospects aProspect = new Prospects(prospect, contacted);
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

        public ArrayList<Prospects> testProspects()
        {
            ArrayList<Prospects> p = new ArrayList<>();

            Prospects q = new Prospects("Matt Lee", true);
            Prospects r = new Prospects("Rosemary Watson", false);
            Prospects s = new Prospects("Joe Bloggs", false);
            Prospects t = new Prospects("Ronny Corbit", false);
            Prospects u = new Prospects("Mr Man", false);
            Prospects v = new Prospects("Mr Bond", true);
            Prospects w = new Prospects("Mr Blobby", false);
            Prospects x = new Prospects("Mary Rose", false);
            Prospects y = new Prospects("Jane Doe", false);
            Prospects z = new Prospects("Lucy Sanders", false);

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


