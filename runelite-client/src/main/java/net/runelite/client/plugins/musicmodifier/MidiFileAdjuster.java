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

import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MidiFileAdjuster
{

	private int bankLSBValue;
	private int chPosition = -1;

	private boolean customBank = false;

	public Sequence reorderTracks(Sequence sequence) throws InvalidMidiDataException, IOException
	{
		for (Track track : sequence.getTracks())
		{
			for (int i = 0; i < track.size(); i++)
			{
				MidiEvent midiEvent = track.get(i);
				MidiMessage midiMessage = midiEvent.getMessage();

				if (midiMessage instanceof ShortMessage)
				{
					ShortMessage sm = (ShortMessage) midiMessage;

					if (sm.getChannel() < 16)
					{
						getBankLSB(sm);

						if (i == 0 & bankLSBValue != 1)
						{
							chPosition++;
							if (chPosition == 9)
							{
								chPosition = 10;
							}
						}

						if (!customBank)
						{

							if (sm.getChannel() == 9)
							{
								bankLSBValue = 1;
							}

							if (sm.getChannel() != 9)
							{
								bankLSBValue = 0;
							}
						}
					}

					if (bankLSBValue == 1)
					{

						int drumChannel = 9;
						if (sm.getCommand() == ShortMessage.PROGRAM_CHANGE)
						{
							sm.setMessage(ShortMessage.PROGRAM_CHANGE, drumChannel, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.CONTROL_CHANGE)
						{
							sm.setMessage(ShortMessage.CONTROL_CHANGE, drumChannel, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.NOTE_OFF)
						{
							sm.setMessage(ShortMessage.NOTE_OFF, drumChannel, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.NOTE_ON)
						{
							sm.setMessage(ShortMessage.NOTE_ON, drumChannel, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.PROGRAM_CHANGE)
						{
							sm.setMessage(ShortMessage.PROGRAM_CHANGE, drumChannel, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.CONTROL_CHANGE)
						{
							sm.setMessage(ShortMessage.CONTROL_CHANGE, drumChannel, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.PITCH_BEND)
						{
							sm.setMessage(ShortMessage.PITCH_BEND, drumChannel, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.CHANNEL_PRESSURE)
						{
							sm.setMessage(ShortMessage.CHANNEL_PRESSURE, drumChannel, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.POLY_PRESSURE)
						{
							sm.setMessage(ShortMessage.POLY_PRESSURE, drumChannel, sm.getData1(), sm.getData2());
						}
					}
					else
					{

						if (sm.getCommand() == ShortMessage.PROGRAM_CHANGE)
						{
							sm.setMessage(ShortMessage.PROGRAM_CHANGE, chPosition, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.CONTROL_CHANGE)
						{
							sm.setMessage(ShortMessage.CONTROL_CHANGE, chPosition, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.NOTE_OFF)
						{
							sm.setMessage(ShortMessage.NOTE_OFF, chPosition, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.NOTE_ON)
						{
							sm.setMessage(ShortMessage.NOTE_ON, chPosition, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.PROGRAM_CHANGE)
						{
							sm.setMessage(ShortMessage.PROGRAM_CHANGE, chPosition, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.CONTROL_CHANGE)
						{
							sm.setMessage(ShortMessage.CONTROL_CHANGE, chPosition, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.PITCH_BEND)
						{
							sm.setMessage(ShortMessage.PITCH_BEND, chPosition, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.CHANNEL_PRESSURE)
						{
							sm.setMessage(ShortMessage.CHANNEL_PRESSURE, chPosition, sm.getData1(), sm.getData2());
						}

						if (sm.getCommand() == ShortMessage.POLY_PRESSURE)
						{
							sm.setMessage(ShortMessage.POLY_PRESSURE, chPosition, sm.getData1(), sm.getData2());
						}
					}
				}
			}
		}
		return sequence;
	}

	private void getBankLSB(ShortMessage sm) throws InvalidMidiDataException
	{
		if (sm.getCommand() == ShortMessage.CONTROL_CHANGE)
		{
			if (sm.getData1() == 32)
			{
				bankLSBValue = sm.getData2();
				customBank = true;
			}
			if (sm.getData1() == 0)
			{
				sm.setMessage(sm.getCommand(), sm.getChannel(), sm.getData1(), bankLSBValue);
			}
		}
	}
}
