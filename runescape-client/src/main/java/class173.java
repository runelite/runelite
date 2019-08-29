import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class173 {
	@ObfuscatedName("i")
	@Export("directions")
	public static int[][] directions;
	@ObfuscatedName("k")
	@Export("distances")
	public static int[][] distances;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1891183659
	)
	public static int field2073;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 783444493
	)
	public static int field2070;
	@ObfuscatedName("q")
	@Export("bufferX")
	public static int[] bufferX;
	@ObfuscatedName("x")
	@Export("bufferY")
	public static int[] bufferY;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -1559987227
	)
	static int field2079;

	static {
		directions = new int[128][128];
		distances = new int[128][128];
		bufferX = new int[4096];
		bufferY = new int[4096];
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-146894719"
	)
	@Export("loadWorlds")
	static boolean loadWorlds() {
		try {
			if (IgnoreList.World_request == null) {
				IgnoreList.World_request = ScriptEvent.urlRequester.request(new URL(class1.field6));
			} else if (IgnoreList.World_request.isDone()) {
				byte[] var0 = IgnoreList.World_request.getResponse();
				Buffer var1 = new Buffer(var0);
				var1.readInt();
				World.World_count = var1.readUnsignedShort();
				ChatChannel.World_worlds = new World[World.World_count];

				World var3;
				for (int var2 = 0; var2 < World.World_count; var3.index = var2++) {
					var3 = ChatChannel.World_worlds[var2] = new World();
					var3.id = var1.readUnsignedShort();
					var3.properties = var1.readInt();
					var3.host = var1.readStringCp1252NullTerminated();
					var3.activity = var1.readStringCp1252NullTerminated();
					var3.location = var1.readUnsignedByte();
					var3.population = var1.readShort();
				}

				Tile.sortWorlds(ChatChannel.World_worlds, 0, ChatChannel.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
				IgnoreList.World_request = null;
				return true;
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			IgnoreList.World_request = null;
		}

		return false;
	}

	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		signature = "(Lhp;I)Ljava/lang/String;",
		garbageValue = "1595503156"
	)
	static String method3529(Widget var0) {
		if (WorldMapRegion.method530(ParamDefinition.getWidgetClickMask(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}
}
