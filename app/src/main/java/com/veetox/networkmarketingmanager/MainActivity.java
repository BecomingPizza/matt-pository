package com.veetox.networkmarketingmanager;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.veetox.networkmarketingmanager.data.Prospects;
import com.veetox.networkmarketingmanager.helper.FileHelper;
import com.veetox.networkmarketingmanager.helper.ProspectListAdapter;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    public static ArrayList<Prospects> prospectList = new ArrayList<>();
    Resources res;
    FileHelper fileHelper;


   ListView prospectsListEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = getResources();
        File aFile = new File(this.getFilesDir(), "prospects.csv");
        try
        {
            aFile.createNewFile();
            Toast.makeText(this, aFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //fileHelper = new FileHelper(this);
        //prospectList = fileHelper.loadProspects();

        //Create the list
        ProspectListAdapter pla = new ProspectListAdapter(this,R.layout.prospects_list_layout,prospectList);
        prospectsListEntry = (ListView) findViewById(R.id.prospects_list);
        prospectsListEntry.setAdapter(pla);


    }


}
