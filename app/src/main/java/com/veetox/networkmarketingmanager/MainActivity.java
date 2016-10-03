package com.veetox.networkmarketingmanager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.veetox.networkmarketingmanager.data.Prospect;
import com.veetox.networkmarketingmanager.helper.FileHelper;
import com.veetox.networkmarketingmanager.helper.ProspectListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    public static ArrayList<Prospect> prospectList = new ArrayList<>();
    Resources res;
    FileHelper fileHelper = new FileHelper(this);
    ListView prospectsListEntry;
    CheckBox prospectsCheckBox;
    EditText prospectsEditText;
    ProspectListAdapter pla;
    Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prospectsCheckBox = (CheckBox) findViewById(R.id.pr_checkBox);
        prospectsEditText = (EditText) findViewById(R.id.pr_name);

        res = getResources();

        createProspectList();


    }

    public void testProspects(View view)
    {
        prospectList = fileHelper.testProspects();
        pla.notifyDataSetChanged();

    }


    public void createProspectList()
    {
        fileHelper = new FileHelper(this);

        //Comment before testing
        //prospectList = fileHelper.loadProspects();

        //Uncomment for testing
        prospectList = fileHelper.testProspects();

        //Create the list
        pla = new ProspectListAdapter(this, R.layout.prospects_list_layout, prospectList);
        prospectsListEntry = (ListView) findViewById(R.id.prospects_list);
        prospectsListEntry.setAdapter(pla);

    }

    public static void onProspectTextBoxEdit(TextView v)
    {
    }

    public static void onProspectCheckBoxSelect(View v)
    {
    }

    public static void onProspectStatusChange(View v)
    {
    }
}
