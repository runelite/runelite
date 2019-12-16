import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("HealthBarUpdate")
public class HealthBarUpdate extends Node {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1629160111
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 618660317
	)
	@Export("health")
	int health;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -717144759
	)
	@Export("health2")
	int health2;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 938888871
	)
	@Export("cycleOffset")
	int cycleOffset;

	HealthBarUpdate(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "2118505733"
	)
	@Export("set")
	void set(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}
}
