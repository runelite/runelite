package net.runelite.client.game;

import com.google.inject.Inject;
import java.io.IOException;
import javax.inject.Singleton;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import net.runelite.client.config.RuneLiteConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class SoundManager
{
	private static final Logger log = LoggerFactory.getLogger(SoundManager.class);
	private final RuneLiteConfig runeliteConfig;

	@Inject
	private SoundManager(RuneLiteConfig runeLiteConfig)
	{
		this.runeliteConfig = runeLiteConfig;
	}

	public void playSound(final Sound sound)
	{
		new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				try
				{
					AudioInputStream in = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource(sound.getFilePath()));
					AudioFormat outFormat = SoundManager.this.getOutFormat(in.getFormat());
					DataLine.Info info = new DataLine.Info(SourceDataLine.class, outFormat);
					SourceDataLine line = (SourceDataLine)AudioSystem.getLine(info);
					if (line != null)
					{
						line.open(outFormat, 2200);
						if (line.isControlSupported(FloatControl.Type.MASTER_GAIN))
						{
							int volume = SoundManager.this.runeliteConfig.volume();
							FloatControl gainControl = (FloatControl)line.getControl(FloatControl.Type.MASTER_GAIN);
							BooleanControl muteControl = (BooleanControl)line.getControl(BooleanControl.Type.MUTE);
							if (volume == 0)
							{
								muteControl.setValue(true);
							}
							else
							{
								muteControl.setValue(false);
								gainControl.setValue((float)(Math.log((double)volume / 100.0) / Math.log(10.0) * 20.0));
							}
						}
						line.start();
						SoundManager.this.stream(AudioSystem.getAudioInputStream(outFormat, in), line);
						line.drain();
						line.stop();
					}
				}
				catch (IOException | LineUnavailableException | UnsupportedAudioFileException e)
				{
					throw new IllegalStateException(e);
				}
			}
		}).start();
	}

	private AudioFormat getOutFormat(AudioFormat inFormat)
	{
		int ch = inFormat.getChannels();
		float rate = inFormat.getSampleRate();
		return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
	}

	private void stream(AudioInputStream in, SourceDataLine line) throws IOException
	{
		byte[] buffer = new byte[2200];
		int n = 0;
		while (n != -1)
		{
			line.write(buffer, 0, n);
			n = in.read(buffer, 0, buffer.length);
		}
	}

}