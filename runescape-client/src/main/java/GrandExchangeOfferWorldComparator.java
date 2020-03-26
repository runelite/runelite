import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("h")
@Implements("GrandExchangeOfferWorldComparator")
final class GrandExchangeOfferWorldComparator implements Comparator {
	@ObfuscatedName("rb")
	@ObfuscatedGetter(
		intValue = 587221949
	)
	static int field64;
	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "Lej;"
	)
	@Export("scene")
	static Scene scene;
	@ObfuscatedName("hk")
	@ObfuscatedGetter(
		intValue = -1477050145
	)
	@Export("cameraY")
	static int cameraY;

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Li;Li;I)I",
		garbageValue = "590840268"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1020131485"
	)
	static int method137(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GrandExchangeOfferNameComparator.field115 : Interpreter.field1130;
		if (var0 == ScriptOpcodes.CC_GETSCROLLX) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLY) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTEXT) {
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLWIDTH) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLHEIGHT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELZOOM) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_X) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Z) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Y) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTRANSTOP) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTRANSBOT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETCOLOUR) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETFILLCOLOUR) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETFILLMODE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELTRANSPARENT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-965659136"
	)
	static int method147() {
		if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
			int var0 = 0;

			for (int var1 = 0; var1 <= Client.archiveLoadersDone; ++var1) {
				var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
			}

			return var0 * 10000 / Client.field898;
		} else {
			return 10000;
		}
	}

	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "(Lbi;IIB)V",
		garbageValue = "8"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = SpotAnimationDefinition.SequenceDefinition_get(var1).field3525;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.field1011 = 0;
			}

			if (var3 == 2) {
				var0.field1011 = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || SpotAnimationDefinition.SequenceDefinition_get(var1).field3519 >= SpotAnimationDefinition.SequenceDefinition_get(var0.sequence).field3519) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.field1011 = 0;
			var0.field1032 = var0.pathLength;
		}

	}

	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "1791023210"
	)
	public static void method148(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = FaceNormal.getPacketBufferNode(ClientPacket.field2224, Client.packetWriter.isaacCipher);
		var4.packetBuffer.method5727(var2);
		var4.packetBuffer.writeInt(var3 ? Client.field762 * 166950687 * 1356416223 : 0);
		var4.packetBuffer.method5609(var0);
		var4.packetBuffer.writeIntME(var1);
		Client.packetWriter.addNode(var4);
	}
}
