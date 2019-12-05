import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class208 {
	@ObfuscatedName("je")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "682234129"
	)
	static void method4017(int var0) {
		Tiles.tempMenuAction = new MenuAction();
		Tiles.tempMenuAction.param0 = Client.menuArguments1[var0];
		Tiles.tempMenuAction.param1 = Client.menuArguments2[var0];
		Tiles.tempMenuAction.opcode = Client.menuOpcodes[var0];
		Tiles.tempMenuAction.identifier = Client.menuIdentifiers[var0];
		Tiles.tempMenuAction.action = Client.menuActions[var0];
	}
}
