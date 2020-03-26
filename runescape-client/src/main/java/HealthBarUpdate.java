import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("HealthBarUpdate")
public class HealthBarUpdate extends Node {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -186864867
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 134168981
	)
	@Export("health")
	int health;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1066019297
	)
	@Export("health2")
	int health2;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 442713571
	)
	@Export("cycleOffset")
	int cycleOffset;

	HealthBarUpdate(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-2054467883"
	)
	@Export("set")
	void set(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "87"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}
}
