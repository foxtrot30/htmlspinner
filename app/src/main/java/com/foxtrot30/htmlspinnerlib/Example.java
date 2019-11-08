package com.foxtrot30.htmlspinnerlib;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.foxtrot30.htmlspinner.HtmlSpinner;
import com.foxtrot30.htmlspinner.HtmlSpinnerAdapter;
import com.foxtrot30.htmlspinner.HtmlSpinnerModel;

import java.util.ArrayList;

public class Example extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HtmlSpinnerModel> list = new ArrayList<>();
        HtmlSpinnerModel model = new HtmlSpinnerModel();
        model.setKey("");
        model.setValue("Select an item.");
        list.add(model);

        for (int i = 0; i < 10; i++) {
            model = new HtmlSpinnerModel();
            model.setKey("Spinner key " + i);
            model.setValue("Spinner value " + i);

            list.add(model);
        }

        final HtmlSpinnerAdapter adapter = new HtmlSpinnerAdapter(Example.this, list);
        HtmlSpinner htmlSpinner = findViewById(R.id.html_spinner);
        htmlSpinner.setAdapter(adapter);
        htmlSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) findViewById(R.id.selected_key)).setText(adapter.key(position));
                ((TextView) findViewById(R.id.selected_value)).setText(adapter.val(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Example.this, "nothing selected :)", Toast.LENGTH_SHORT).show();
                ((TextView) findViewById(R.id.selected_key)).setText("");
                ((TextView) findViewById(R.id.selected_value)).setText("");
            }
        });
    }
}
