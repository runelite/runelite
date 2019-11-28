import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("rg")
	@ObfuscatedGetter(
		intValue = 671141563
	)
	static int field308;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	public static final WorldMapCacheName field304;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	public static final WorldMapCacheName field303;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	public static final WorldMapCacheName field307;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	static final WorldMapCacheName field305;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lab;"
	)
	public static final WorldMapCacheName field306;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -770375157
	)
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("p")
	@Export("name")
	public final String name;

	static {
		field304 = new WorldMapCacheName("details");
		field303 = new WorldMapCacheName("compositemap");
		field307 = new WorldMapCacheName("compositetexture");
		field305 = new WorldMapCacheName("area");
		field306 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-98614245"
	)
	public static void method637(boolean var0) {
		if (var0 != ItemDefinition.ItemDefinition_inMembersWorld) {
			WorldMapAreaData.method703();
			ItemDefinition.ItemDefinition_inMembersWorld = var0;
		}

	}

	@ObfuscatedName("if")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "57"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = ModelData0.getPacketBufferNode(ClientPacket.field2275, Client.packetWriter.isaacCipher);
		var2.packetBuffer.method5613(var1);
		var2.packetBuffer.writeInt(var0);
		Client.packetWriter.addNode(var2);
	}
}
