/*
 * Copyright (c) 2019, Jordan Houghton <jordan.houghton@protonmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * ALL MUSIC USED IS THE PROPERTY OF OSRSBeatz AND THE AUTHOR OF THIS CODE HAS HAD
 * PERMISSIONS TO USE AND STORE SAID MUSIC.
 */

package net.runelite.client.plugins.osrsbeatz;

import com.google.inject.Provides;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.embed.swing.JFXPanel;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;


@PluginDescriptor(
        name = "OSRSBeatz Music Track Replacer",
        description = "Replace Normal Old School Runescape Music with OSRSBeatz Remixes",
        tags = {"music", "sound", ""},
        enabledByDefault = false
)

public class OSRSBeatzPlugin extends Plugin
{
    private static MediaPlayer mediaPlayer;
    private static String prefix = "OSRSBeatz+-+";
    private static int fadeOutSeconds = 5;
    private List<String> availableMusic = new ArrayList<>();
    private static double volume = 0.20;
    private String song = null;

    @Inject
    private Client client;


    @Inject
    private OSRSBeatzConfiguration config;



    @Provides
    OSRSBeatzConfiguration provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(OSRSBeatzConfiguration.class);
    }

    private static void play(final MediaPlayer mediaPlayer, final long fadeInMillis)
    {
        if (fadeInMillis > 0)
        {
            mediaPlayer.setVolume(0);
        }
        mediaPlayer.setOnReady(() -> {
            mediaPlayer.play();
            new Transition() {
                {
                    setCycleDuration(Duration.millis(fadeInMillis));
                }
                @Override
                protected void interpolate(double frac) {
                    if (mediaPlayer.getVolume() < volume)
                    mediaPlayer.setVolume(frac);
                }
            }.play();
        });
    }


    private void createMusicList()
    {
        String output;
        try
        {
            URL url = new URL("http://1h.lc/music-list.txt");
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            while ((output = br.readLine()) != null)
            {
                availableMusic.add(output);
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
    }

    }

    @Override
    protected void startUp() throws Exception
    {
        JFXPanel fxPanel = new JFXPanel();
        createMusicList();
        Media media = new Media("http://1h.lc/OSRSBeatz+-+Scape+Main.mp3"); //replace /Movies/test.mp3 with your file
        mediaPlayer = new MediaPlayer(media);
        play(mediaPlayer, 5000);
    }

    @Override
    protected void shutDown() throws Exception
    {
        mediaPlayer.stop();
    }

    @Subscribe
    public void onGameTick(GameTick tick){
        try {

            String newSong = client.getWidget(239,6).getText();

            if (!newSong.equals(song))
            {
                song = newSong;
                onMusicChange(song);
            }
        } catch (NullPointerException ignored){}
    }

    private void onMusicChange(String song) {
        // Set up and play song

            if (availableMusic.contains(song))
            {
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(fadeOutSeconds),
                                new KeyValue(mediaPlayer.volumeProperty(), 0)));
                song = song.replaceAll("\\s", "\\+");
                String songURL = "http://1h.lc/" + prefix + song + ".mp3";
                Duration d = mediaPlayer.getCurrentTime();
                d = d.add(Duration.seconds(fadeOutSeconds + 0.5));
                mediaPlayer.setStopTime(d);
                timeline.play();
                mediaPlayer.setOnEndOfMedia(() -> {
                    Media media = new Media(songURL);
                    mediaPlayer = new MediaPlayer(media);
                    //mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
                    play(mediaPlayer, 7500);
                });
            }

    }
}

