import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("UserComparator5")
public class UserComparator5 extends AbstractUserComparator {
	@ObfuscatedName("r")
	@Export("ArchiveDiskActionHandler_thread")
	static Thread ArchiveDiskActionHandler_thread;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "[[Lho;"
	)
	@Export("Widget_interfaceComponents")
	public static Widget[][] Widget_interfaceComponents;
	@ObfuscatedName("z")
	@Export("reversed")
	final boolean reversed;

	public UserComparator5(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljl;Ljl;I)I",
		garbageValue = "-1400201048"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0) {
			if (var2.world == 0) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world != 0) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkl;Llb;I)Llb;",
		garbageValue = "1757701513"
	)
	@Export("readStringIntParameters")
	static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
		int var2 = var0.readUnsignedByte();
		int var3;
		if (var1 == null) {
			var3 = Timer.method4935(var2);
			var1 = new IterableNodeHashTable(var3);
		}

		for (var3 = 0; var3 < var2; ++var3) {
			boolean var4 = var0.readUnsignedByte() == 1;
			int var5 = var0.readMedium();
			Object var6;
			if (var4) {
				var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
			} else {
				var6 = new IntegerNode(var0.readInt());
			}

			var1.put((Node)var6, (long)var5);
		}

		return var1;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)I",
		garbageValue = "103"
	)
	public static int method3387(String var0) {
		return var0.length() + 2;
	}
}
