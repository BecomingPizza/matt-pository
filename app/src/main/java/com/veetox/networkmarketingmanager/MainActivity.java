package com.veetox.networkmarketingmanager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.veetox.networkmarketingmanager.data.Prospects;
import com.veetox.networkmarketingmanager.helper.FileHelper;

public class MainActivity extends AppCompatActivity
{
    Prospects prospects;
    public Context context;
    public FileHelper fh;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        prospects = new Prospects();

        //TODO:
        fh = new FileHelper(context);
        fh.saveProspects();
        fh.loadProspects();

        



    }


}
