import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 844166729
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 377421093
	)
	@Export("type")
	int type;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1257246671
	)
	@Export("x")
	int x;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1319343831
	)
	@Export("y")
	int y;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 2111575223
	)
	@Export("objectId")
	int objectId;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -135346951
	)
	int field911;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -2066167261
	)
	int field912;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -530727913
	)
	@Export("id")
	int id;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1202721073
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1258720415
	)
	int field918;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1975686607
	)
	@Export("delay")
	int delay;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 614220967
	)
	@Export("hitpoints")
	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}
}
