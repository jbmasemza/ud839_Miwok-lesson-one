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

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class PhrasesActivity extends AppCompatActivity {

    TextToSpeech t1;
    String words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create an arrayList of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(getResources().getString(R.string.name),"Leina laka ke nna...."));
        words.add(new Word(getResources().getString(R.string.hello),"Thobela"));
        words.add(new Word(getResources().getString(R.string.Time),"Ke nako mang?"));
        words.add(new Word(getResources().getString(R.string.Beautiful),"O a bogega."));
        words.add(new Word(getResources().getString(R.string.Old),"O na le mengwaga e me kae?"));
        words.add(new Word(getResources().getString(R.string.Stay),"O dula kae"));
        words.add(new Word(getResources().getString(R.string.Eat),"Nka go ntxa gore ro ja dijo txa matena?"));
        words.add(new Word(getResources().getString(R.string.Yes),"Eya"));
        words.add(new Word(getResources().getString(R.string.No),"Aowa"));
        words.add(new Word(getResources().getString(R.string.Thanks),"Ke a leboga"));

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        final WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_phrases);

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


