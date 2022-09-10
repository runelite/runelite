package net.runelite.api.packets;

import java.util.Map;

public interface ClientPacket
{
	int getId();

	int getLength();

	ClientPacket RESUME_PAUSEBUTTON();

	ClientPacket RESUME_NAMEDIALOG();

	ClientPacket EVENT_KEYBOARD();

	ClientPacket EVENT_APPLET_FOCUS();

//	ClientPacket CLICKWORLDMAP_TELEPORT();

	ClientPacket IF_BUTTONT();

	ClientPacket OPPLAYER6();

	ClientPacket OPNPC2();

	ClientPacket OPPLAYER7();

	ClientPacket OPNPC3();

	ClientPacket OPLOC2();

	ClientPacket OPPLAYER8();

	ClientPacket OPNPC1();

	ClientPacket OPLOC1();

	ClientPacket OPLOC4();

	ClientPacket FREECAM_EXIT();

	ClientPacket OPPLAYER2();

	ClientPacket OPLOC3();

	ClientPacket OPPLAYER3();

	ClientPacket OPPLAYER4();

	ClientPacket OPNPC4();

	ClientPacket LOGIN_TIMINGS();

	ClientPacket OPLOC5();

	ClientPacket OPPLAYER5();

	ClientPacket EVENT_MOUSE_IDLE();

	ClientPacket OPNPC5();

	ClientPacket CHAT_SENDPRIVATE();

	ClientPacket CLOSE_MODAL();

	ClientPacket OPPLAYER1();

	ClientPacket CHAT_SENDABUSEREPORT();

	ClientPacket PING_STATISTICS();

	ClientPacket EVENT_WINDOW_SETTING();

	ClientPacket OPOBJ1();

	ClientPacket FRIEND_ADDUSER();

	ClientPacket DOCHEAT();

	ClientPacket IF_BUTTON9();

	ClientPacket CLAN_KICKUSER();

	ClientPacket IF_BUTTON8();

	ClientPacket OPOBJ5();

	ClientPacket IGNORE_DELUSER();

	ClientPacket IF_BUTTON5();

	ClientPacket IF_BUTTON4();

	ClientPacket OPOBJ4();

	ClientPacket OPOBJ3();

	ClientPacket IF_BUTTON7();

	ClientPacket CHAT_SETFILTER();

	ClientPacket OPOBJ2();

	ClientPacket IF_BUTTON6();

	ClientPacket OPHELDD();

	ClientPacket RESUME_COUNTDIALOG();

	ClientPacket NO_TIMEOUT();

	ClientPacket OPLOCT();

	ClientPacket RESUME_OBJDIALOG();

	ClientPacket OPPLAYERT();

	ClientPacket OPNPCT();

	ClientPacket FRIEND_DELUSER();

	ClientPacket IF_BUTTOND();

	ClientPacket OPLOCE();

	ClientPacket OPNPCE();

	ClientPacket EVENT_CAMERA_POSITION();

	ClientPacket REFLECTION_CHECK_REPLY();

	ClientPacket OPOBJT();

	ClientPacket DETECT_MODIFIED_CLIENT();

	ClientPacket OPOBJE();

	ClientPacket RESUME_STRINGDIALOG();

	ClientPacket IF_BUTTON1();

	ClientPacket MOVE_GAMECLICK();

	ClientPacket IF_BUTTON3();

	ClientPacket IF_BUTTON2();

	ClientPacket EVENT_MOUSE_CLICK();

	ClientPacket IF_BUTTON10();

	default Map<ClientPacket, String> getClientPackets()
	{
		//noinspection RedundantTypeArguments (explicit type arguments speedup compilation and analysis time)
		return Map.<ClientPacket, String>ofEntries(
				Map.entry(RESUME_PAUSEBUTTON(), "RESUME_PAUSEBUTTON"),
				Map.entry(RESUME_NAMEDIALOG(), "RESUME_NAMEDIALOG"),
				Map.entry(EVENT_KEYBOARD(), "EVENT_KEYBOARD"),
				Map.entry(EVENT_APPLET_FOCUS(), "EVENT_APPLET_FOCUS"),
//				Map.entry(CLICKWORLDMAP_TELEPORT(), "CLICKWORLDMAP_TELEPORT"),
				Map.entry(IF_BUTTONT(), "IF_BUTTONT"),
				Map.entry(OPPLAYER6(), "OPPLAYER6"),
				Map.entry(OPNPC2(), "OPNPC2"),
				Map.entry(OPPLAYER7(), "OPPLAYER7"),
				Map.entry(OPNPC3(), "OPNPC3"),
				Map.entry(OPLOC2(), "OPLOC2"),
				Map.entry(OPPLAYER8(), "OPPLAYER8"),
				Map.entry(OPNPC1(), "OPNPC1"),
				Map.entry(OPLOC1(), "OPLOC1"),
				Map.entry(OPLOC4(), "OPLOC4"),
				Map.entry(FREECAM_EXIT(), "FREECAM_EXIT"),
				Map.entry(OPPLAYER2(), "OPPLAYER2"),
				Map.entry(OPLOC3(), "OPLOC3"),
				Map.entry(OPPLAYER3(), "OPPLAYER3"),
				Map.entry(OPPLAYER4(), "OPPLAYER4"),
				Map.entry(OPNPC4(), "OPNPC4"),
				Map.entry(LOGIN_TIMINGS(), "LOGIN_TIMINGS"),
				Map.entry(OPLOC5(), "OPLOC5"),
				Map.entry(OPPLAYER5(), "OPPLAYER5"),
				Map.entry(EVENT_MOUSE_IDLE(), "EVENT_MOUSE_IDLE"),
				Map.entry(OPNPC5(), "OPNPC5"),
				Map.entry(CHAT_SENDPRIVATE(), "CHAT_SENDPRIVATE"),
				Map.entry(CLOSE_MODAL(), "CLOSE_MODAL"),
				Map.entry(OPPLAYER1(), "OPPLAYER1"),
				Map.entry(CHAT_SENDABUSEREPORT(), "CHAT_SENDABUSEREPORT"),
				Map.entry(PING_STATISTICS(), "PING_STATISTICS"),
				Map.entry(EVENT_WINDOW_SETTING(), "EVENT_WINDOW_SETTING"),
				Map.entry(OPOBJ1(), "OPOBJ1"),
				Map.entry(FRIEND_ADDUSER(), "FRIEND_ADDUSER"),
				Map.entry(DOCHEAT(), "DOCHEAT"),
				Map.entry(IF_BUTTON9(), "IF_BUTTON9"),
				Map.entry(CLAN_KICKUSER(), "CLAN_KICKUSER"),
				Map.entry(IF_BUTTON8(), "IF_BUTTON8"),
				Map.entry(OPOBJ5(), "OPOBJ5"),
				Map.entry(IGNORE_DELUSER(), "IGNORE_DELUSER"),
				Map.entry(IF_BUTTON5(), "IF_BUTTON5"),
				Map.entry(IF_BUTTON4(), "IF_BUTTON4"),
				Map.entry(OPOBJ4(), "OPOBJ4"),
				Map.entry(OPOBJ3(), "OPOBJ3"),
				Map.entry(IF_BUTTON7(), "IF_BUTTON7"),
				Map.entry(CHAT_SETFILTER(), "CHAT_SETFILTER"),
				Map.entry(OPOBJ2(), "OPOBJ2"),
				Map.entry(IF_BUTTON6(), "IF_BUTTON6"),
				Map.entry(OPHELDD(), "OPHELDD"),
				Map.entry(RESUME_COUNTDIALOG(), "RESUME_COUNTDIALOG"),
				Map.entry(NO_TIMEOUT(), "NO_TIMEOUT"),
				Map.entry(OPLOCT(), "OPLOCT"),
				Map.entry(RESUME_OBJDIALOG(), "RESUME_OBJDIALOG"),
				Map.entry(OPPLAYERT(), "OPPLAYERT"),
				Map.entry(OPNPCT(), "OPNPCT"),
				Map.entry(FRIEND_DELUSER(), "FRIEND_DELUSER"),
				Map.entry(IF_BUTTOND(), "IF_BUTTOND"),
				Map.entry(OPLOCE(), "OPLOCE"),
				Map.entry(OPNPCE(), "OPNPCE"),
				Map.entry(EVENT_CAMERA_POSITION(), "EVENT_CAMERA_POSITION"),
				Map.entry(REFLECTION_CHECK_REPLY(), "REFLECTION_CHECK_REPLY"),
				Map.entry(OPOBJT(), "OPOBJT"),
				Map.entry(DETECT_MODIFIED_CLIENT(), "DETECT_MODIFIED_CLIENT"),
				Map.entry(OPOBJE(), "OPOBJE"),
				Map.entry(RESUME_STRINGDIALOG(), "RESUME_STRINGDIALOG"),
				Map.entry(IF_BUTTON1(), "IF_BUTTON1"),
				Map.entry(MOVE_GAMECLICK(), "MOVE_GAMECLICK"),
				Map.entry(IF_BUTTON3(), "IF_BUTTON3"),
				Map.entry(IF_BUTTON2(), "IF_BUTTON2"),
				Map.entry(EVENT_MOUSE_CLICK(), "EVENT_MOUSE_CLICK"),
				Map.entry(IF_BUTTON10(), "IF_BUTTON10")
		);
	}
}
