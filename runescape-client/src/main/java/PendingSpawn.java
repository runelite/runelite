import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	@Export("redHintArrowSprite")
	static Sprite redHintArrowSprite;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1962154215
	)
	@Export("objectId")
	int objectId;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1562451131
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1262583567
	)
	@Export("type")
	int type;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1018276189
	)
	@Export("x")
	int x;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 179665149
	)
	@Export("y")
	int y;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1264128253
	)
	int field922;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -753782081
	)
	int field921;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 481754121
	)
	@Export("id")
	int id;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 2059869293
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 764785127
	)
	int field916;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -201127845
	)
	@Export("delay")
	int delay;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -39012303
	)
	@Export("hitpoints")
	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}
}
