import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("at")
public class class51 {
	@ObfuscatedName("z")
	@Export("applet")
	public static Applet applet;
	@ObfuscatedName("n")
	public static String field406;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	@Export("rightTitleSprite")
	static Sprite rightTitleSprite;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("World_request")
	static UrlRequest World_request;
	@ObfuscatedName("kc")
	@ObfuscatedGetter(
		intValue = -1418069311
	)
	@Export("menuY")
	static int menuY;

	static {
		applet = null;
		field406 = "";
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-150727859"
	)
	static int method921(int var0, Script var1, boolean var2) {
		Widget var3 = Canvas.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETX) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETY) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1129572121"
	)
	static final void method922() {
		PacketBufferNode var0 = InterfaceParent.getPacketBufferNode(ClientPacket.field2241, Client.packetWriter.isaacCipher);
		Client.packetWriter.addNode(var0);

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
			if (var1.type == 0 || var1.type == 3) {
				FontName.closeInterface(var1, true);
			}
		}

		if (Client.meslayerContinueWidget != null) {
			WorldMapSectionType.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

	}
}
