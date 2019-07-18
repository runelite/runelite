import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("UserComparator3")
public class UserComparator3 extends AbstractUserComparator {
	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "[Lly;"
	)
	@Export("headIconPkSprites")
	static Sprite[] headIconPkSprites;
	@ObfuscatedName("q")
	@Export("reversed")
	final boolean reversed;

	public UserComparator3(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljz;Ljz;I)I",
		garbageValue = "2060416979"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var2.world != var1.world) {
			return this.reversed ? var1.world - var2.world : var2.world - var1.world;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1010038987"
	)
	@Export("loadWorlds")
	static boolean loadWorlds() {
		try {
			if (World.field1027 == null) {
				World.field1027 = SequenceDefinition.urlRequester.request(new URL(WorldMapArea.field213));
			} else if (World.field1027.isDone()) {
				byte[] var0 = World.field1027.getResponse();
				Buffer var1 = new Buffer(var0);
				var1.readInt();
				World.worldsCount = var1.readUnsignedShort();
				World.worlds = new World[World.worldsCount];

				World var3;
				for (int var2 = 0; var2 < World.worldsCount; var3.index = var2++) {
					var3 = World.worlds[var2] = new World();
					var3.id = var1.readUnsignedShort();
					var3.properties = var1.readInt();
					var3.host = var1.readStringCp1252NullTerminated();
					var3.activity = var1.readStringCp1252NullTerminated();
					var3.location = var1.readUnsignedByte();
					var3.population = var1.readShort();
				}

				Client.sortWorlds(World.worlds, 0, World.worlds.length - 1, World.sortOption1, World.sortOption2);
				World.field1027 = null;
				return true;
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			World.field1027 = null;
		}

		return false;
	}
}
