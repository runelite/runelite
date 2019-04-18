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
 */

package net.runelite.client.plugins.musicreplacer;


import com.google.inject.Provides;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@PluginDescriptor(
        name = "Music Track Replacer",
        description = "Replace Old School Runescape Music with User Defined Packs",
        tags = {"music", "sound", "replace", "track", "pack"},
        enabledByDefault = false
)

public class MusicReplacerPlugin extends Plugin
{
    private static MediaPlayer mediaPlayer;
    private static int fadeOutSeconds = 3;
    private Map<String, String> musicMap = new HashMap<>();
    private static double volume = 0.25;
    private String song = null;
    private static String RUNELITE_DIR_MUSIC = System.getProperty("user.home") + "/.runelite/music-replacer/";

    @Inject
    private Client client;


    @Inject
    private MusicReplacerConfiguration config;


    @Provides
    MusicReplacerConfiguration provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(MusicReplacerConfiguration.class);
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        String key = event.getKey();
        switch(key)
        {
            //More to add later
            case "musicPack":
                File dirCheck = new File(RUNELITE_DIR_MUSIC + config.musicPack());
                if(dirCheck.exists() && !config.musicPack().isEmpty())
                {
                    //Change to music pack and start
                    createMusicList(dirCheck);
                }
                break;
            case "vol":
                volume = (double) config.vol() / 100;
                mediaPlayer.setVolume(volume);
                break;
        }

    }

    private void createMusicList(File musicDir)
    {
        String line;
        try
        {
            FileReader fr = new FileReader(musicDir + "/list.csv");
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null)
            {
                if(!line.isEmpty()) {
                    String[] values = line.split(",");
                    if(!values[0].isEmpty() && !values[1].isEmpty()) {
                        musicMap.put(values[0].trim(), values[1].trim());
                    }
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.toString());
        }
    }

    @Override
    protected void startUp() throws Exception
    {
        JFXPanel fxPanel = new JFXPanel();
        if(!config.musicPack().isEmpty()) {
            File dirCheck = new File(RUNELITE_DIR_MUSIC + config.musicPack());
            if (dirCheck.exists()) {
                createMusicList(dirCheck);
                if(musicMap.containsKey("Main Theme")) {
                    if(!musicMap.get("Main Theme").equals("")) {
                        String songLoc = RUNELITE_DIR_MUSIC + config.musicPack() + "/" + musicMap.get("Main Theme");
                        File songFile = new File(songLoc);
                        if (songFile.exists()) {
                            String songURI = songFile.toURI().toString();
                            Media media = new Media(songURI);
                            mediaPlayer = new MediaPlayer(media);
                            play(mediaPlayer, 5000);
                            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void shutDown() throws Exception
    {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(fadeOutSeconds),
                        new KeyValue(mediaPlayer.volumeProperty(), 0)));
        timeline.play();
    }

    @Subscribe
    public void onGameTick(GameTick tick)
    {
        try
        {
            String newSong = client.getWidget(239, 6).getText();

            if (!newSong.equals(song))
            {
                song = newSong;
                onMusicChange(song);
            }
        }
        catch (NullPointerException ignored)
        {

        }
    }

    private void onMusicChange(String song)
    {
        // Set up and play song
        if (musicMap.containsKey(song))
        {
            if(!musicMap.get(song).equals("")) {
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(fadeOutSeconds),
                                new KeyValue(mediaPlayer.volumeProperty(), 0)));
                String songLoc = RUNELITE_DIR_MUSIC + config.musicPack() + "/" + musicMap.get(song);
                File songFile = new File(songLoc);
                if (songFile.exists()) {
                    String songURI = songFile.toURI().toString();
                    Duration d = mediaPlayer.getCurrentTime();
                    d = d.add(Duration.seconds(fadeOutSeconds + 0.2));
                    mediaPlayer.setStopTime(d);
                    timeline.play();
                    mediaPlayer.setOnEndOfMedia(() ->
                    {
                        Media media = new Media(songURI);
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
                        play(mediaPlayer, 7500);
                    });
                }
            }
        }
    }

    private static void play(final MediaPlayer mediaPlayer, final long fadeInMillis)
    {

        if (fadeInMillis > 0)
        {
            mediaPlayer.setVolume(0);
        }
        mediaPlayer.setOnReady(() ->
        {
            mediaPlayer.play();
            new Transition()
            {
                {
                    setCycleDuration(Duration.millis(fadeInMillis));
                }
                @Override
                protected void interpolate(double frac)
                {
                    if (mediaPlayer.getVolume() < volume)
                    {
                        mediaPlayer.setVolume(frac);
                    }
                }
            }.play();
        });
    }
}

