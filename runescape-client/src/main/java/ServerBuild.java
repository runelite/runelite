import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("ServerBuild")
public class ServerBuild {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("LIVE")
	static final ServerBuild LIVE;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("BUILDLIVE")
	static final ServerBuild BUILDLIVE;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("RC")
	static final ServerBuild RC;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("WIP")
	static final ServerBuild WIP;
	@ObfuscatedName("z")
	@Export("name")
	public final String name;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -832726311
	)
	public final int field3109;

	static {
		LIVE = new ServerBuild("LIVE", 0);
		BUILDLIVE = new ServerBuild("BUILDLIVE", 3);
		RC = new ServerBuild("RC", 1);
		WIP = new ServerBuild("WIP", 2);
	}

	ServerBuild(String var1, int var2) {
		this.name = var1;
		this.field3109 = var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Llb;ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-88537768"
	)
	static String method4214(IterableNodeHashTable var0, int var1, String var2) {
		if (var0 == null) {
			return var2;
		} else {
			ObjectNode var3 = (ObjectNode)var0.get((long)var1);
			return var3 == null ? var2 : (String)var3.obj;
		}
	}
}
