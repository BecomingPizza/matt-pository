package com.veetox.networkmarketingmanager.helper;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.veetox.networkmarketingmanager.MainActivity;
import com.veetox.networkmarketingmanager.R;
import com.veetox.networkmarketingmanager.data.Prospect;

import java.util.ArrayList;

/**
 * Created by Matt on 29/09/2016.
 */

public class ProspectListAdapter extends ArrayAdapter<Prospect>
{

    private Context context;
    private int layoutResourceId;
    private ArrayList<Prospect> prospect;
    private int colourDecider = 0;


    public ProspectListAdapter(Context context, int layoutResourceId, ArrayList<Prospect> prospect)
    {
        super(context, layoutResourceId, prospect);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.prospect = prospect;

    }

    public int getCount()
    {
        return prospect.size();
    }


    public Prospect getItem(int position)
    {
        return prospect.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        View v = convertView;

        if (v == null)
        {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(layoutResourceId, parent, false);
        }

        Prospect prospect = this.prospect.get(position);

        if (prospect != null)
        {
            TextView prname = (TextView) v.findViewById(R.id.pr_name);
            CheckBox complete = (CheckBox) v.findViewById(R.id.pr_checkBox);
            Button prospectStatus = (Button) v.findViewById(R.id.pr_button_status);
            ListView prospectListView = (ListView) v.findViewById(R.id.prospects_list);


            prname.setOnEditorActionListener(new TextView.OnEditorActionListener()
            {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
                {

                    Log.e("ThingLabel","Wooooh I did a thing");
                    MainActivity.onProspectTextBoxEdit(v);

                    return false;
                }
            });

            complete.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Log.e("AnotherLabel","Wooooh check box works!");
                    MainActivity.onProspectCheckBoxSelect(v);
                }
            });

            prospectStatus.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Log.e("AnotherLabel", "Wooooh the button works!");
                    View parentRow = (View) v.getParent();
                    ListView listView = (ListView) parentRow.getParent();
                    final int position = listView.getPositionForView(parentRow);

                    //ColorDrawable listViewColor = (ColorDrawable) listView.getBackground();
                    //int colorId = listViewColor.getColor();

                    listView.getChildAt(position).setBackgroundColor(Color.GREEN);

                }
            });

            if (prname != null)
            {
                prname.setText(prospect.getName());
            }

            if (complete != null)
            {
                complete.setChecked(prospect.isChecked());
            }


        }




        return v;
    }



}
