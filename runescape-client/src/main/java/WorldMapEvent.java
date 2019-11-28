import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2127525977
	)
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		signature = "(ILhx;Lhx;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lbp;Lbp;IZIZI)I",
		garbageValue = "-965478315"
	)
	static int method782(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
		int var6 = UserComparator10.compareWorlds(var0, var1, var2, var3);
		if (var6 != 0) {
			return var3 ? -var6 : var6;
		} else if (var4 == -1) {
			return 0;
		} else {
			int var7 = UserComparator10.compareWorlds(var0, var1, var4, var5);
			return var5 ? -var7 : var7;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;III)Lkn;",
		garbageValue = "753193132"
	)
	public static AbstractSocket method783(Socket var0, int var1, int var2) throws IOException {
		return new BufferedNetSocket(var0, var1, var2);
	}
}
