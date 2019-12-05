import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("InvDefinition")
public class InvDefinition extends DualNode {
	@ObfuscatedName("sy")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	public static class237 field3210;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("InvDefinition_archive")
	public static AbstractArchive InvDefinition_archive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("InvDefinition_cached")
	static EvictingDualNodeHashTable InvDefinition_cached;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("Widget_archive")
	public static AbstractArchive Widget_archive;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1331007469
	)
	@Export("size")
	public int size;

	static {
		InvDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	InvDefinition() {
		this.size = 0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkg;B)V",
		garbageValue = "-67"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "63686644"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 2) {
			this.size = var1.readUnsignedShort();
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-77"
	)
	@Export("isKeyDown")
	public static final boolean isKeyDown() {
		synchronized(KeyHandler.KeyHandler_instance) {
			if (KeyHandler.field399 == KeyHandler.field384) {
				return false;
			} else {
				class49.field418 = KeyHandler.field396[KeyHandler.field399];
				class297.field3699 = KeyHandler.field395[KeyHandler.field399];
				KeyHandler.field399 = KeyHandler.field399 + 1 & 127;
				return true;
			}
		}
	}
}
