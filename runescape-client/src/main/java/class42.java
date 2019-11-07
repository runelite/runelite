import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ah")
public class class42 implements WorldMapSection {
	@ObfuscatedName("ql")
	@ObfuscatedGetter(
		intValue = -1572028416
	)
	static int field360;
	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("mapDotSprites")
	static Sprite[] mapDotSprites;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1414528917
	)
	int field358;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1336936449
	)
	int field349;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1265839335
	)
	int field351;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1444724099
	)
	int field357;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1979837671
	)
	int field353;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1964329659
	)
	int field354;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -837058271
	)
	int field355;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -882784751
	)
	int field350;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1697600129
	)
	int field359;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 309221771
	)
	int field352;

	class42() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Laa;B)V",
		garbageValue = "-111"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field353) {
			var1.regionLowX = this.field353;
		}

		if (var1.regionHighX < this.field353) {
			var1.regionHighX = this.field353;
		}

		if (var1.regionLowY > this.field354) {
			var1.regionLowY = this.field354;
		}

		if (var1.regionHighY < this.field354) {
			var1.regionHighY = this.field354;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-1417818612"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field358 && var1 < this.field358 + this.field349) {
			return var2 >= (this.field351 << 6) + (this.field355 << 3) && var2 <= (this.field351 << 6) + (this.field355 << 3) + 7 && var3 >= (this.field357 << 6) + (this.field350 << 3) && var3 <= (this.field357 << 6) + (this.field350 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-2132898041"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field353 << 6) + (this.field359 << 3) && var1 <= (this.field353 << 6) + (this.field359 << 3) + 7 && var2 >= (this.field354 << 6) + (this.field352 << 3) && var2 <= (this.field354 << 6) + (this.field352 << 3) + 7;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1209167521"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field353 * 64 - this.field351 * 64 + var2 + (this.field359 * 8 - this.field355 * 8), var3 + (this.field354 * 64 - this.field357 * 64) + (this.field352 * 8 - this.field350 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIS)Lhf;",
		garbageValue = "7283"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field351 * 64 - this.field353 * 64 + (this.field355 * 8 - this.field359 * 8) + var1;
			int var4 = this.field357 * 64 - this.field354 * 64 + var2 + (this.field350 * 8 - this.field352 * 8);
			return new Coord(this.field358, var3, var4);
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-568369534"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field358 = var1.readUnsignedByte();
		this.field349 = var1.readUnsignedByte();
		this.field351 = var1.readUnsignedShort();
		this.field355 = var1.readUnsignedByte();
		this.field357 = var1.readUnsignedShort();
		this.field350 = var1.readUnsignedByte();
		this.field353 = var1.readUnsignedShort();
		this.field359 = var1.readUnsignedByte();
		this.field354 = var1.readUnsignedShort();
		this.field352 = var1.readUnsignedByte();
		this.method852();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "108"
	)
	void method852() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-1518213603"
	)
	static final int method856(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = RouteStrategy.method3736(var3, var5);
		int var8 = RouteStrategy.method3736(var3 + 1, var5);
		int var9 = RouteStrategy.method3736(var3, var5 + 1);
		int var10 = RouteStrategy.method3736(var3 + 1, var5 + 1);
		int var12 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
		int var13 = GrandExchangeOfferAgeComparator.method195(var9, var10, var4, var2);
		int var15 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var6 * 1024 / var2] >> 1;
		int var14 = ((65536 - var15) * var11 >> 16) + (var13 * var15 >> 16);
		return var14;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "-1035175611"
	)
	static int method873(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = PacketBufferNode.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class96.field1301 : ReflectionCheck.field1310;
		}

		String var4 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
		int[] var5 = null;
		if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
			int var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			if (var6 > 0) {
				for (var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]) {
				}
			}

			var4 = var4.substring(0, var4.length() - 1);
		}

		Object[] var8 = new Object[var4.length() + 1];

		int var7;
		for (var7 = var8.length - 1; var7 >= 1; --var7) {
			if (var4.charAt(var7 - 1) == 's') {
				var8[var7] = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
			} else {
				var8[var7] = new Integer(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			}
		}

		var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
		if (var7 != -1) {
			var8[0] = new Integer(var7);
		} else {
			var8 = null;
		}

		if (var0 == ScriptOpcodes.CC_SETONCLICK) {
			var3.onClick = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONHOLD) {
			var3.onHold = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONRELEASE) {
			var3.onRelease = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSEOVER) {
			var3.onMouseOver = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSELEAVE) {
			var3.onMouseLeave = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDRAG) {
			var3.onDrag = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONTARGETLEAVE) {
			var3.onTargetLeave = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONVARTRANSMIT) {
			var3.onVarTransmit = var8;
			var3.varTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONTIMER) {
			var3.onTimer = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONOP) {
			var3.onOp = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDRAGCOMPLETE) {
			var3.onDragComplete = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCLICKREPEAT) {
			var3.onClickRepeat = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSEREPEAT) {
			var3.onMouseRepeat = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONINVTRANSMIT) {
			var3.onInvTransmit = var8;
			var3.invTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONSTATTRANSMIT) {
			var3.onStatTransmit = var8;
			var3.statTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONTARGETENTER) {
			var3.onTargetEnter = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSCROLLWHEEL) {
			var3.onScroll = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCHATTRANSMIT) {
			var3.onChatTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONKEY) {
			var3.onKey = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONFRIENDTRANSMIT) {
			var3.onFriendTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCLANTRANSMIT) {
			var3.onClanTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMISCTRANSMIT) {
			var3.onMiscTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDIALOGABORT) {
			var3.onDialogAbort = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSUBCHANGE) {
			var3.onSubChange = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSTOCKTRANSMIT) {
			var3.onStockTransmit = var8;
		} else if (var0 == 1426) {
			var3.field2665 = var8;
		} else {
			if (var0 != ScriptOpcodes.CC_SETONRESIZE) {
				return 2;
			}

			var3.onResize = var8;
		}

		var3.hasListener = true;
		return 1;
	}

	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1911467364"
	)
	@Export("FriendSystem_invalidateIgnoreds")
	static final void FriendSystem_invalidateIgnoreds() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

		if (class4.clanChat != null) {
			class4.clanChat.invalidateIgnoreds();
		}

	}
}
