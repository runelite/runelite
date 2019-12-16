import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1533834755
	)
	@Export("group")
	int group;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 642122867
	)
	@Export("type")
	int type;
	@ObfuscatedName("y")
	boolean field546;

	InterfaceParent() {
		this.field546 = false;
	}

	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "472182360"
	)
	@Export("logOut")
	static final void logOut() {
		Client.packetWriter.close();
		class81.method2063();
		class14.scene.clear();

		for (int var0 = 0; var0 < 4; ++var0) {
			Client.collisionMaps[var0].clear();
		}

		System.gc();
		BoundaryObject.method3273(2);
		Client.currentTrackGroupId = -1;
		Client.field767 = false;
		WorldMapSectionType.method236();
		class195.updateGameState(10);
	}
}
