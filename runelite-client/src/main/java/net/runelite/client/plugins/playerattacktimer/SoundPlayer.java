package net.runelite.client.plugins.playerattacktimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SoundPlayer {

  private static Logger logger = LoggerFactory.getLogger(SoundPlayer.class);

  public static void playSound(String soundFileName) {
    try (InputStream initialStream = SoundPlayer.class.getResourceAsStream(soundFileName);
         ByteArrayOutputStream outStream = new ByteArrayOutputStream()) {

      if (initialStream == null) {
        throw new RuntimeException("Resource not found: " + soundFileName);
      }

      byte[] buffer = new byte[1024];
      int bytesRead;
      while ((bytesRead = initialStream.read(buffer)) != -1) {
        outStream.write(buffer, 0, bytesRead);
      }

      try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(
          new BufferedInputStream(new ByteArrayInputStream(outStream.toByteArray())))) {

        logger.debug("AudioStream frame length: {}", audioStream.getFrameLength());

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
      }
    } catch (Exception e) {
      logger.error("Error playing sound", e);
    }
  }
}
