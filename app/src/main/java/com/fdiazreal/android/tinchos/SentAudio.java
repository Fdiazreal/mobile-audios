package com.fdiazreal.android.tinchos;

public class SentAudio {

    private final String title;
    private final int audio;

    public SentAudio(String title, int audio) {
        this.title = title;
        this.audio = audio;
    }


    public String getTitle() {
        return title;
    }

    public int getAudio() {
        return audio;
    }
}
