import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class189 {
	@ObfuscatedName("sb")
	@ObfuscatedGetter(
		intValue = -1002742885
	)
	@Export("foundItemIndex")
	static int foundItemIndex;
	@ObfuscatedName("f")
	static int[] field2331;
	@ObfuscatedName("ao")
	static Image field2333;

	static {
		new Object();
		field2331 = new int[33];
		field2331[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2331[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-567890341"
	)
	public static void method3623() {
		ObjectDefinition.ObjectDefinition_cached.clear();
		ObjectDefinition.ObjectDefinition_cachedModelData.clear();
		ObjectDefinition.ObjectDefinition_cachedEntities.clear();
		ObjectDefinition.ObjectDefinition_cachedModels.clear();
	}

	@ObfuscatedName("la")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-32149"
	)
	static void method3620() {
		Client.packetWriter.addNode(class2.getPacketBufferNode(ClientPacket.field2226, Client.packetWriter.isaacCipher));
		Client.oculusOrbState = 0;
	}
}
