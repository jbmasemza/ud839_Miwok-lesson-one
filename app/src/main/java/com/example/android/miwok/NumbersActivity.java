/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class NumbersActivity extends AppCompatActivity {
    TextToSpeech t1;
    String words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //create an arrayList of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(getResources().getString(R.string.One), "Tee", R.drawable.number_one));
        words.add(new Word(getResources().getString(R.string.Two), "Pedi", R.drawable.number_two));
        words.add(new Word(getResources().getString(R.string.Three), "Tharo", R.drawable.number_three));
        words.add(new Word(getResources().getString(R.string.Four), "Nne", R.drawable.number_four));
        words.add(new Word(getResources().getString(R.string.Five), "Thlano", R.drawable.number_five));
        words.add(new Word(getResources().getString(R.string.Six), "Tshela", R.drawable.number_six));
        words.add(new Word(getResources().getString(R.string.Seven), "Shupa", R.drawable.number_seven));
        words.add(new Word(getResources().getString(R.string.Eight), "Seswai", R.drawable.number_eight));
        words.add(new Word(getResources().getString(R.string.Nine), "Senyane", R.drawable.number_nine));
        words.add(new Word(getResources().getString(R.string.Ten), "Lesome", R.drawable.number_ten));

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        final WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_numbers);

        final ListView listView = (ListView) findViewById(R.id.rootView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word value = (Word) adapterView.getItemAtPosition(i);
                t1.speak(value.getmDefaultTranslation(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        listView.setAdapter(adapter);
    }
    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}

