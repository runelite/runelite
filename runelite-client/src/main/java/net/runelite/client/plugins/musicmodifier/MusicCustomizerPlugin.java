/*
 * Copyright (c) 2019, Rodolfo Ruiz-Velasco <https://github.com/lequietriot/>
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
 */
package net.runelite.client.plugins.musicmodifier;

import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.*;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.io.File;

@PluginDescriptor(
    name = "Music Track Customizer",
    description = "Customize what track plays and how it sounds, with local files",
    tags = {"music", "sound"},
    type = PluginType.UTILITY,
    enabledByDefault = false
)

public class MusicCustomizerPlugin extends Plugin
{

    @Inject
    private Client client;

    @Inject
    private ChatboxPanelManager chatboxPanelManager;

    @Inject
    private ClientThread clientThread;

    private RealTimeMIDIPlayer realTimeMIDIPlayer = new RealTimeMIDIPlayer();

    private String songName = "Scape Main";

    private ChatboxTextInput songInput;

    private Widget playlistModeButton;

    private Widget playlistBox;

    private Widget hidePlaylistButton;

    private Widget addPlaylistSongButton;

    private Widget playlistText;

    private Widget playlistSong;

    private String defaultUnlockedSongs;

    private boolean isLooping = true;

    private boolean playlistMode = false;

    private int newSongY = 34;

    private int playlistCount = 0;

    @Override
    public void startUp()
    {
        playSong(songName);
    }

    @Override
    public void shutDown()
    {
        if (realTimeMIDIPlayer != null)
        {
            realTimeMIDIPlayer.stopSong();
        }
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        try
        {
            if (!playlistMode)
            {
                String newSong = client.getWidget(WidgetInfo.MUSICTAB_CURRENT_SONG_NAME).getText();

                if (!newSong.equals(songName))
                {
                    songName = newSong;
                    playSongFromList(songName);
                }
            }
        } catch (NullPointerException ignored)
        {

        }

    }

    private void playSong(String song)
    {
        File midiMusicFile = new File(System.getProperty("user.home") + "/RuneLiteAudio/MIDI Files/" +
                "Music/" + song + ".mid/");
        if (realTimeMIDIPlayer.midi == null)
        {
            realTimeMIDIPlayer.midi = midiMusicFile;
            realTimeMIDIPlayer.run();
        }

        else
        {
            if (realTimeMIDIPlayer.isPlaying())
            {
                realTimeMIDIPlayer.stopSong();
            }
            realTimeMIDIPlayer.midi = midiMusicFile;
            realTimeMIDIPlayer.run();
        }
    }

    @Subscribe
    private void onWidgetLoaded(WidgetLoaded widgetLoaded)
    {
        if (widgetLoaded.getGroupId() == WidgetID.MUSICTAB_GROUP_ID)
        {
            Widget musicPlayerSongs = client.getWidget(WidgetInfo.MUSICTAB_ALL_SONGS);
            if (musicPlayerSongs != null)
            {
                playlistModeButton = musicPlayerSongs.createChild(-1, WidgetType.GRAPHIC);
                playlistModeButton.setSpriteId(SpriteID.RS2_TAB_MUSIC);
                playlistModeButton.setOriginalWidth(32);
                playlistModeButton.setOriginalHeight(32);
                playlistModeButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
                playlistModeButton.setOriginalX(0);
                playlistModeButton.setOriginalY(0);
                playlistModeButton.setHasListener(true);
                playlistModeButton.setAction(1, "Open");
                playlistModeButton.setOnOpListener((JavaScriptCallback) e -> openPlaylist());
                playlistModeButton.setName("Playlist");
                playlistModeButton.setHidden(true); //Playlist is not enabled for this release (Unfinished).
                playlistModeButton.revalidate();
            }
        }
    }

    private void openPlaylist()
    {
        playlistMode = true;

        Widget currentPlayingSong = client.getWidget(WidgetInfo.MUSICTAB_CURRENT_SONG_NAME);
        Widget allInGameSongs = client.getWidget(WidgetInfo.MUSICTAB_ALL_SONGS);
        Widget musicScrollbar = client.getWidget(WidgetInfo.MUSICTAB_SCROLLBAR);
        allInGameSongs.setHidden(true);
        musicScrollbar.setHidden(true);

        defaultUnlockedSongs = client.getWidget(WidgetInfo.MUSICTAB_UNLOCKED_SONGS).getText();

        client.getWidget(WidgetInfo.MUSICTAB_UNLOCKED_SONGS).setText(playlistCount + " / 10");

        playlistBox = client.getWidget(WidgetInfo.MUSICTAB_INTERFACE);

        playlistText = playlistBox.createChild(-1, WidgetType.TEXT);
        playlistText.setText("Music Playlist");
        playlistText.setFontId(497);
        playlistText.setXPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
        playlistText.setOriginalX(40);
        playlistText.setOriginalY(14);
        playlistText.setOriginalHeight(1);
        playlistText.setOriginalWidth(1);
        playlistText.setTextColor(currentPlayingSong.getTextColor());
        playlistText.revalidate();

        hidePlaylistButton = playlistBox.createChild(-1, WidgetType.GRAPHIC);
        hidePlaylistButton.setSpriteId(SpriteID.RS2_TAB_MUSIC);
        hidePlaylistButton.setOriginalWidth(32);
        hidePlaylistButton.setOriginalHeight(32);
        hidePlaylistButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_RIGHT);
        hidePlaylistButton.setOriginalX(0);
        hidePlaylistButton.setOriginalY(6);
        hidePlaylistButton.setHasListener(true);
        hidePlaylistButton.setAction(1, "Close");
        hidePlaylistButton.setOnOpListener((JavaScriptCallback) e -> closePlaylist());
        hidePlaylistButton.setName("Playlist");
        hidePlaylistButton.revalidate();

        addPlaylistSongButton = playlistBox.createChild(-1, WidgetType.GRAPHIC);
        addPlaylistSongButton.setSpriteId(SpriteID.BANK_ADD_TAB_ICON);
        addPlaylistSongButton.setOriginalWidth(36);
        addPlaylistSongButton.setOriginalHeight(32);
        addPlaylistSongButton.setXPositionMode(WidgetPositionMode.ABSOLUTE_LEFT);
        addPlaylistSongButton.setOriginalX(0);
        addPlaylistSongButton.setOriginalY(6);
        addPlaylistSongButton.setHasListener(true);
        addPlaylistSongButton.setAction(1, "Add to");
        addPlaylistSongButton.setOnOpListener((JavaScriptCallback) e -> addSongFromInput());
        addPlaylistSongButton.setName("Playlist");
        addPlaylistSongButton.revalidate();

        if (playlistSong != null)
        {
            playlistSong.setHidden(false);
        }
    }

    private void closePlaylist()
    {
        playlistMode = false;

        Widget allInGameSongs = client.getWidget(WidgetInfo.MUSICTAB_ALL_SONGS);
        Widget musicScrollbar = client.getWidget(WidgetInfo.MUSICTAB_SCROLLBAR);
        allInGameSongs.setHidden(false);
        musicScrollbar.setHidden(false);

        client.getWidget(WidgetInfo.MUSICTAB_UNLOCKED_SONGS).setText(defaultUnlockedSongs);
        playlistText.setHidden(true);
        addPlaylistSongButton.setHidden(true);
        hidePlaylistButton.setHidden(true);

        if (playlistSong != null)
        {
            playlistSong.setHidden(true);
        }
    }

    private void addSongFromInput()
    {
        addPlaylistSongButton.setAction(1, "Close search");
        addPlaylistSongButton.setOnOpListener((JavaScriptCallback) e -> closeInput());
        songInput = chatboxPanelManager.openTextInput("Please type a valid song name")
        .onChanged(s -> clientThread.invokeLater(() -> updateSongs(s)))
        .onClose(() ->
        {
            clientThread.invokeLater(() -> updateSongs(songInput.getValue()));
            addPlaylistSongButton.setOnOpListener((JavaScriptCallback) e -> addSongFromInput());
            addPlaylistSongButton.setAction(1, "Add to");
        })
        .build();
    }

    private void updateSongs()
    {
        String song = "";
        if (chatboxIsOpen())
        {
            song = songInput.getValue();
        }
        updateSongs(song);
    }

    private void updateSongs(String song)
    {
        if (playlistBox == null)
        {
            return;
        }

        if (new File(System.getProperty("user.home") + "/RuneLiteAudio/MIDI Files/" +
                "Music/" + song + ".mid/").exists())
        {
            playListSongPlayer(song);
        }
    }

    private void playListSongPlayer(String song)
    {
        if (!song.equals(songName) && !chatboxIsOpen() && playlistCount < 10)
        {
            Widget playlistWidget = client.getWidget(WidgetInfo.MUSICTAB_INTERFACE);
            playlistSong = playlistWidget.createChild(-1, WidgetType.TEXT);
            playlistSong.setText(song);
            playlistSong.setFontId(495);
            playlistSong.setOriginalX(12);
            playlistSong.setOriginalY(newSongY);
            playlistSong.setOriginalWidth(120);
            playlistSong.setOriginalHeight(16);
            playlistSong.setTextColor(client.getWidget(WidgetInfo.MUSICTAB_CURRENT_SONG_NAME).getTextColor());
            playlistSong.setHasListener(true);
            playlistSong.setAction(1, "Play");
            playlistSong.setOnOpListener((JavaScriptCallback) e -> playSongFromList(song));
            playlistSong.setName(song);
            playlistSong.revalidate();

            newSongY = newSongY + 15;

            songName = song;

            playlistCount++;
            client.getWidget(WidgetInfo.MUSICTAB_UNLOCKED_SONGS).setText(playlistCount + " / 10");

            if (playlistCount == 10)
            {
                addPlaylistSongButton.setHidden(true);
            }
        }
    }

    private boolean chatboxIsOpen()
    {
        return songInput != null && chatboxPanelManager.getCurrentInput() == songInput;
    }

    private void closeInput()
    {
        updateSongs();
        chatboxPanelManager.close();
    }

    private void playSongFromList(String song)
    {
        client.getWidget(WidgetInfo.MUSICTAB_CURRENT_SONG_NAME).setName(song);
        File midiMusicFile = new File(System.getProperty("user.home") + "/RuneLiteAudio/MIDI Files/" +
                "Music/" + song + ".mid/");

        if (realTimeMIDIPlayer.midi == null)
        {
            realTimeMIDIPlayer.midi = midiMusicFile;
            realTimeMIDIPlayer.run();
        }

        else
        {
            if (realTimeMIDIPlayer.isPlaying())
            {
                realTimeMIDIPlayer.stopSong();
            }
            realTimeMIDIPlayer.midi = midiMusicFile;
            realTimeMIDIPlayer.run();
        }
    }
}
