package com.example.a15puzzleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Puzzle4_4Activity extends AppCompatActivity {

    public int puzzle = 4;

    TextView[] texts = new TextView[puzzle*puzzle];

    public void move(TextView text1, TextView text2) {
        text2.setText(text1.getText().toString());
        text1.setText("");
    }

    public void check(int i) {
        if ((i % puzzle != 0) && (texts[i - 1].getText().toString() == "")) {
            move(texts[i], texts[i - 1]);
        } else if ((i % puzzle != puzzle - 1) && (texts[i + 1].getText().toString() == "")) {
            move(texts[i], texts[i + 1]);
        } else if ((i >= puzzle) && (texts[i - puzzle].getText().toString() == "")) {
            move(texts[i], texts[i - puzzle]);
        } else if ((i < puzzle * puzzle - 1) && (texts[i + puzzle].getText().toString() == "")) {
            move(texts[i], texts[i + puzzle]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle4_4);

        texts[0] = findViewById(R.id.text_1);
        texts[1] = findViewById(R.id.text_2);
        texts[2] = findViewById(R.id.text_3);
        texts[3] = findViewById(R.id.text_4);
        texts[4] = findViewById(R.id.text_5);
        texts[5] = findViewById(R.id.text_6);
        texts[6] = findViewById(R.id.text_7);
        texts[7] = findViewById(R.id.text_8);
        texts[8] = findViewById(R.id.text_9);
        texts[9] = findViewById(R.id.text_10);
        texts[10] = findViewById(R.id.text_11);
        texts[11] = findViewById(R.id.text_12);
        texts[12] = findViewById(R.id.text_13);
        texts[13] = findViewById(R.id.text_14);
        texts[14] = findViewById(R.id.text_15);
        texts[15] = findViewById(R.id.text_16);

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < texts.length + 1; i++) {
            list.add(i);
        }
        for (int i = 0; i < texts.length -1; i++) {
            int n = (int) Math.floor(Math.random() * list.size());
            texts[i].setText(String.valueOf(list.get(n)));
            list.remove(n);
        }

        for (int i = 0; i < texts.length; i++) {
            int finalI = i;
            texts[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check(finalI);
                }
            });
        }

    }
}