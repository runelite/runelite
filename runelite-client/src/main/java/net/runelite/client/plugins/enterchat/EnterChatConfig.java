package net.runelite.client.plugins.enterchat;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "enterchat",
	name = "Enter Chat",
	description = "Requires you to hit enter to use chat. Also provides the ability to rebind certain keys."
)
public interface EnterChatConfig extends Config
{

	@ConfigItem(
		keyName = "invertShiftCtrl",
		name = "Invert Shift and Ctrl",
		description = "Switches binds for Shift and Control",
		position = 0
	)
	default boolean invertShiftCtrl()
	{
		return false;
	}

	@ConfigItem(
		keyName = "upArrow",
		name = "Up arrow",
		description = "The button to remap for up arrow",
		position = 1
	)
	default Keynum upArrow()
	{
		return Keynum.W;
	}

	@ConfigItem(
		keyName = "downArrow",
		name = "Down arrow",
		description = "The button to remap for down arrow",
		position = 3
	)
	default Keynum downArrow()
	{
		return Keynum.S;
	}

	@ConfigItem(
		keyName = "leftArrow",
		name = "Left arrow",
		description = "The button to remap for left arrow",
		position = 2
	)
	default Keynum leftArrow()
	{
		return Keynum.A;
	}

	@ConfigItem(
		keyName = "rightArrow",
		name = "Right arrow",
		description = "The button to remap for right arrow",
		position = 4
	)
	default Keynum rightArrow()
	{
		return Keynum.D;
	}

	@ConfigItem(
		keyName = "f1",
		name = "F1",
		description = "The button to remap for F1",
		position = 5
	)
	default Keynum f1()
	{
		return Keynum.N1;
	}

	@ConfigItem(
		keyName = "f2",
		name = "F2",
		description = "The button to remap for F2",
		position = 6
	)
	default Keynum f2()
	{
		return Keynum.N2;
	}

	@ConfigItem(
		keyName = "f3",
		name = "F3",
		description = "The button to remap for F3",
		position = 7
	)
	default Keynum f3()
	{
		return Keynum.N3;
	}

	@ConfigItem(
		keyName = "f4",
		name = "F4",
		description = "The button to remap for F4",
		position = 8
	)
	default Keynum f4()
	{
		return Keynum.N4;
	}

	@ConfigItem(
		keyName = "f5",
		name = "F5",
		description = "The button to remap for F5",
		position = 9
	)
	default Keynum f5()
	{
		return Keynum.N5;
	}

	@ConfigItem(
		keyName = "f6",
		name = "F6",
		description = "The button to remap for F6",
		position = 10
	)
	default Keynum f6()
	{
		return Keynum.N6;
	}

	@ConfigItem(
		keyName = "f7",
		name = "F7",
		description = "The button to remap for F7",
		position = 11
	)
	default Keynum f7()
	{
		return Keynum.N7;
	}

	@ConfigItem(
		keyName = "f8",
		name = "F8",
		description = "The button to remap for F8",
		position = 12
	)
	default Keynum f8()
	{
		return Keynum.N8;
	}

	/*
    @ConfigItem(
            keyName = "f9",
            name = "F9",
            description = "The button to remap for F9",
            position = 13
    )
    default Keynum f9()
    {
        return Keynum.N9;
    }

    @ConfigItem(
            keyName = "f10",
            name = "F10",
            description = "The button to remap for F10",
            position = 14
    )
    default Keynum f10()
    {
        return Keynum.N0;
    }

    @ConfigItem(
            keyName = "f11",
            name = "F11",
            description = "The button to remap for F11",
            position = 15
    )
    default Keynum f11()
    {
        return Keynum.MINUS;
    }

    @ConfigItem(
            keyName = "f12",
            name = "F12",
            description = "The button to remap for F12",
            position = 16
    )
    default Keynum f12()
    {
        return Keynum.EQUALS;
    }
    */

	@ConfigItem(
		keyName = "esc",
		name = "Escape",
		description = "The button to remap for escape",
		position = 17
	)
	default Keynum escape()
	{
		return Keynum.TILDA;
	}

	@ConfigItem(
		keyName = "altf1",
		name = "Alternate F1",
		description = "The alternate bind for F1",
		position = 18
	)
	default Keynum altF1()
	{
		return Keynum.Q;
	}

	@ConfigItem(
		keyName = "altf2",
		name = "Alternate F2",
		description = "The alternate bind for F2",
		position = 19
	)
	default Keynum altF2()
	{
		return Keynum.E;
	}

	@ConfigItem(
		keyName = "altf3",
		name = "Alternate F3",
		description = "The alternate bind for F3",
		position = 20
	)
	default Keynum altF3()
	{
		return Keynum.R;
	}

	@ConfigItem(
		keyName = "altf4",
		name = "Alternate F4",
		description = "The alternate bind for F4",
		position = 21
	)
	default Keynum altF4()
	{
		return Keynum.F;
	}

	@ConfigItem(
		keyName = "altf5",
		name = "Alternate F5",
		description = "The alternate bind for F5",
		position = 22
	)
	default Keynum altF5()
	{
		return Keynum.NONE;
	}

	@ConfigItem(
		keyName = "altf6",
		name = "Alternate F6",
		description = "The alternate bind for F6",
		position = 23
	)
	default Keynum altF6()
	{
		return Keynum.NONE;
	}

	@ConfigItem(
		keyName = "altf7",
		name = "Alternate F7",
		description = "The alternate bind for F7",
		position = 24
	)
	default Keynum altF7()
	{
		return Keynum.NONE;
	}

	@ConfigItem(
		keyName = "altf8",
		name = "Alternate F8",
		description = "The alternate bind for F8",
		position = 25
	)
	default Keynum altF8()
	{
		return Keynum.NONE;
	}

	/*
    @ConfigItem(
            keyName = "altf9",
            name = "Alternate F9",
            description = "The alternate bind for F9",
            position = 26
    )
    default Keynum altF9()
    {
        return Keynum.NONE;
    }

    @ConfigItem(
            keyName = "altf10",
            name = "Alternate F10",
            description = "The alternate bind for F10",
            position = 27
    )
    default Keynum altF10()
    {
        return Keynum.NONE;
    }

    @ConfigItem(
            keyName = "altf11",
            name = "Alternate F11",
            description = "The alternate bind for F11",
            position = 28
    )
    default Keynum altF11()
    {
        return Keynum.NONE;
    }

    @ConfigItem(
            keyName = "altf12",
            name = "Alternate F12",
            description = "The alternate bind for F12",
            position = 29
    )
    default Keynum altF12()
    {
        return Keynum.NONE;
    }
    */

	@ConfigItem(
		keyName = "altesc",
		name = "Alternate Escape",
		description = "The alternate bind for escape",
		position = 30
	)
	default Keynum altescape()
	{
		return Keynum.SPACE;
	}

}

