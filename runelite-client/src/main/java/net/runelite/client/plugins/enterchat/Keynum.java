package net.runelite.client.plugins.enterchat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.event.KeyEvent;

@Getter
@RequiredArgsConstructor
public enum Keynum
{
	NONE(-1),
	A(KeyEvent.VK_A),
	B(KeyEvent.VK_B),
	C(KeyEvent.VK_C),
	D(KeyEvent.VK_D),
	E(KeyEvent.VK_E),
	F(KeyEvent.VK_F),
	G(KeyEvent.VK_G),
	H(KeyEvent.VK_H),
	I(KeyEvent.VK_I),
	J(KeyEvent.VK_J),
	K(KeyEvent.VK_K),
	L(KeyEvent.VK_L),
	M(KeyEvent.VK_M),
	N(KeyEvent.VK_N),
	O(KeyEvent.VK_O),
	P(KeyEvent.VK_P),
	Q(KeyEvent.VK_Q),
	R(KeyEvent.VK_R),
	S(KeyEvent.VK_S),
	T(KeyEvent.VK_T),
	U(KeyEvent.VK_U),
	V(KeyEvent.VK_V),
	W(KeyEvent.VK_W),
	X(KeyEvent.VK_X),
	Y(KeyEvent.VK_Y),
	Z(KeyEvent.VK_Z),
	N0(KeyEvent.VK_0),
	N1(KeyEvent.VK_1),
	N2(KeyEvent.VK_2),
	N3(KeyEvent.VK_3),
	N4(KeyEvent.VK_4),
	N5(KeyEvent.VK_5),
	N6(KeyEvent.VK_6),
	N7(KeyEvent.VK_7),
	N8(KeyEvent.VK_8),
	N9(KeyEvent.VK_9),
	MINUS(KeyEvent.VK_MINUS),
	SPACE(KeyEvent.VK_SPACE),
	EQUALS(KeyEvent.VK_EQUALS),
	LEFT_BRACE(KeyEvent.VK_BRACELEFT),
	RIGHT_BRACE(KeyEvent.VK_BRACERIGHT),
	SEMICOLON(KeyEvent.VK_SEMICOLON),
	APOSTROPHE(KeyEvent.VK_QUOTE),
	COMMA(KeyEvent.VK_COMMA),
	PERIOD(KeyEvent.VK_PERIOD),
	SLASH(KeyEvent.VK_SLASH),
	TILDA(KeyEvent.VK_BACK_QUOTE),
	TAB(KeyEvent.VK_TAB),
	SHIFT(KeyEvent.VK_SHIFT),
	CONTROL(KeyEvent.VK_CONTROL),
	ALT(KeyEvent.VK_ALT),
	ENTER(KeyEvent.VK_ENTER),
	BACKSPACE(KeyEvent.VK_BACK_SPACE),
	BACKSLASH(KeyEvent.VK_BACK_SLASH);

	private final int code;

	@Override
	public String toString()
	{
		switch (this)
		{
			case N0:
				return "0";
			case N1:
				return "1";
			case N2:
				return "2";
			case N3:
				return "3";
			case N4:
				return "4";
			case N5:
				return "5";
			case N6:
				return "6";
			case N7:
				return "7";
			case N8:
				return "8";
			case N9:
				return "9";
			case MINUS:
				return "-";
			case EQUALS:
				return "=";
			case LEFT_BRACE:
				return "[";
			case RIGHT_BRACE:
				return "]";
			case SEMICOLON:
				return ";";
			case APOSTROPHE:
				return "'";
			case COMMA:
				return ",";
			case PERIOD:
				return ".";
			case SLASH:
				return "/";
			case BACKSLASH:
				return "\\";
			default:
				return this.name();
		}
	}
}
