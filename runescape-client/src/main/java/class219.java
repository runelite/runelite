import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hb")
public class class219 {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ILcu;ZS)I",
		garbageValue = "6812"
	)
	static int method4077(int var0, Script var1, boolean var2) {
		Widget var3 = Tile.getWidget(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETX) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETY) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-857951152"
	)
	static void method4076() {
		PacketBufferNode var0 = class2.getPacketBufferNode(ClientPacket.field2179, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(ItemDefinition.getWindowedMode());
		var0.packetBuffer.writeShort(GrandExchangeOfferTotalQuantityComparator.canvasWidth);
		var0.packetBuffer.writeShort(AttackOption.canvasHeight);
		Client.packetWriter.addNode(var0);
	}
}
