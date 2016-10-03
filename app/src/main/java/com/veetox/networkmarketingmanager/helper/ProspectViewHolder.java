package com.veetox.networkmarketingmanager.helper;

import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by Matt on 02/10/2016.
 */

public class ProspectViewHolder
{
    private CheckBox checkBox;
    private EditText editText;

    public ProspectViewHolder()
    {

    }

    public ProspectViewHolder(EditText editText, CheckBox checkBox)
    {
        this.setCheckBox(checkBox);
        this.setEditText(editText);
    }


    public CheckBox getCheckBox()
    {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox)
    {
        this.checkBox = checkBox;
    }

    public EditText getEditText()
    {
        return editText;
    }

    public void setEditText(EditText editText)
    {
        this.editText = editText;
    }
}
