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
import java.util.Map;
import java.util.Scanner;


/**
 * Created by Matt on 28/09/2016.
 */

public final class FileHelper
{
    Context context;
    File aFile;

   public FileHelper(Context aContext)
   {
       context = aContext;
       File aFile = new File(context.getFilesDir(), "prospects.txt");


   }


//    public void saveProspects()
//    {
//
//
//        BufferedWriter bufferedFileWriter = null;
//
//        Map<String, String> prospects = Prospects.getProspects();
//
//        try
//        {
//            bufferedFileWriter = new BufferedWriter(new FileWriter(aFile));
//
//            for (String eachProspect : prospects.keySet())
//            {
//                bufferedFileWriter.write(eachProspect);
//                bufferedFileWriter.write(",");
//                bufferedFileWriter.write(prospects.get(eachProspect));
//                bufferedFileWriter.newLine();
//            }
//
//        }
//        catch (Exception e)
//        {
//            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//        }
//        finally
//        {
//            try
//            {
//                bufferedFileWriter.close();
//            }
//            catch (Exception e)
//            {
//                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }
//
//    }

//    public void loadProspects()
//    {
//            Scanner bufferedScanner = null;
//            Scanner lineScanner = null;
//
//            try
//            {
//                bufferedScanner = new Scanner(new BufferedReader(new FileReader(aFile)));
//                while (bufferedScanner.hasNextLine())
//                {
//                    lineScanner = new Scanner(bufferedScanner.nextLine());
//                    lineScanner.useDelimiter(",");
//                    String uuid = lineScanner.next();
//                    String prospect = lineScanner.next();
//
//                    Prospects.addProspect(uuid, prospect);
//                }
//
//            }
//            catch (Exception e)
//            {
//                Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
//            }
//            finally
//            {
//                try
//                {
//                    bufferedScanner.close();
//                }
//                catch (Exception e)
//                {
//                    Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
//                }
//            }
//
//            }



}


