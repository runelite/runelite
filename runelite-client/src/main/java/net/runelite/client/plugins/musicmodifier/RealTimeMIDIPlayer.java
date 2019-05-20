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

import com.sun.media.sound.AudioSynthesizer;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class RealTimeMIDIPlayer implements Runnable
{
	private AudioFormat format;

	private Sequence midiSequence;

	private Soundbank soundbank;

	private SourceDataLine sdl;

	private MusicCustomizerPlugin customMusicPlugin;

	private MidiFileAdjuster adjuster;

	private Clip clip;

	public boolean looping = true;

	public File soundFont = new File(System.getProperty("user.home") + "/RuneLiteAudio/SoundFonts/" +
		"RuneScape 2.sf2/");

	public File midi;

	@Override
	public void run()
	{

		try
		{

			adjuster = new MidiFileAdjuster(); //Unfinished class

			midiSequence = MidiSystem.getSequence(midi);
			soundbank = MidiSystem.getSoundbank(soundFont);
			init();
		}
		catch (IOException | InvalidMidiDataException e)
		{
			e.printStackTrace();
		}
	}

	public void stopSong()
	{
		if (sdl.isRunning())
		{
			sdl.stop();
		}
	}

	public static AudioSynthesizer findAudioSynthesizer() throws MidiUnavailableException
	{
		Synthesizer synth = MidiSystem.getSynthesizer();
		if (synth instanceof AudioSynthesizer)
		{
			return (AudioSynthesizer) synth;
		}

		double gain = 0.8D;

		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
		MidiChannel[] channels = synth.getChannels();

		for (int i = 0; i < channels.length; i++)
		{
			channels[i].controlChange(7, ((int) (channels[i].getController(7) * gain)));
		}

		for (int i = 0; i < infos.length; i++)
		{
			MidiDevice device = MidiSystem.getMidiDevice(infos[i]);

			if (device instanceof AudioSynthesizer)
			{
				return (AudioSynthesizer) device;
			}
		}
		return null;
	}

	public boolean isPlaying()
	{
		return sdl.isActive();
	}

	public static double send(Sequence sequence, Receiver receiver)
	{
		float divtype = sequence.getDivisionType();
		assert (sequence.getDivisionType() == Sequence.PPQ);
		Track[] tracks = sequence.getTracks();
		int[] trackspos = new int[tracks.length];
		int mpq = 500000;
		int seqres = sequence.getResolution();
		long lasttick = 0;
		long curtime = 0;
		while (true)
		{
			MidiEvent selevent = null;
			int seltrack = -1;
			for (int i = 0; i < tracks.length; i++)
			{
				int trackpos = trackspos[i];
				Track track = tracks[i];
				if (trackpos < track.size())
				{
					MidiEvent event = track.get(trackpos);
					if (selevent == null
						|| event.getTick() < selevent.getTick())
					{
						selevent = event;
						seltrack = i;
					}
				}
			}
			if (seltrack == -1)
			{
				break;
			}
			trackspos[seltrack]++;
			long tick = selevent.getTick();
			if (divtype == Sequence.PPQ)
			{
				curtime += ((tick - lasttick) * mpq) / seqres;
			}
			else
			{
				curtime = (long) ((tick * 1000000.0 * divtype) / seqres);
			}
			lasttick = tick;
			MidiMessage msg = selevent.getMessage();
			if (msg instanceof MetaMessage)
			{
				if (divtype == Sequence.PPQ)
				{
					if (((MetaMessage) msg).getType() == 0x51)
					{
						byte[] data = ((MetaMessage) msg).getData();
						mpq = ((data[0] & 0xff) << 16)
							| ((data[1] & 0xff) << 8) | (data[2] & 0xff);
					}
				}
			}
			else
			{
				if (receiver != null)
				{
					receiver.send(msg, curtime);
				}
			}
		}
		return curtime / 1000000.0;
	}

	public void init()
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{

				AudioSynthesizer synth = null;
				try
				{
					synth = findAudioSynthesizer();
					format = new AudioFormat(44100, 16, 2, true, false);

					Map<String, Object> info = new HashMap<String, Object>();
					info.put("resamplerType", "sinc");
					info.put("maxPolyphony", "8192");
					AudioInputStream ais = synth.openStream(format, info);
					synth.unloadAllInstruments(synth.getDefaultSoundbank());
					synth.loadAllInstruments(soundbank);
					double total = send(midiSequence, synth.getReceiver());
					long length = (long) (ais.getFormat().getFrameRate() * (total + 4));
					AudioInputStream stream = new AudioInputStream(ais, format, length);
					sdl = AudioSystem.getSourceDataLine(format);
					sdl.open(format);
					sdl.start();
					writeAudio(sdl, stream);
				}
				catch (LineUnavailableException | MidiUnavailableException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void writeAudio(SourceDataLine sdl, AudioInputStream stream)
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{

				byte[] sampledAudio = new byte[1024];

				int numBytesRead = 0;

				while (numBytesRead != -1)
				{
					try
					{
						numBytesRead = stream.read(sampledAudio, 0, sampledAudio.length);

						if (numBytesRead >= 0)
						{
							sdl.write(sampledAudio, 0, numBytesRead);
						}
					}

					catch (IOException e)
					{
						e.printStackTrace();
					}

					finally
					{

						if (!isPlaying() && looping)
						{
							this.run();
						}
					}
				}
			}
		}).start();
	}
}
