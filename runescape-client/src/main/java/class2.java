import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
final class class2 implements class0 {
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -722721087
	)
	static int field5;
	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		signature = "Lbr;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive9")
	static Archive archive9;
	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("scene")
	static Scene scene;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkg;I)V",
		garbageValue = "-1331780546"
	)
	public void vmethod57(Object var1, Buffer var2) {
		this.method26((Long)var1, var2);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkg;I)Ljava/lang/Object;",
		garbageValue = "1713449680"
	)
	public Object vmethod65(Buffer var1) {
		return var1.readLong();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Long;Lkg;I)V",
		garbageValue = "-1453735507"
	)
	void method26(Long var1, Buffer var2) {
		var2.writeLong(var1);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lhb;",
		garbageValue = "277199676"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_hardcoreIronman, PlayerType.PlayerType_ultimateIronman, PlayerType.PlayerType_ironman, PlayerType.PlayerType_normal};
	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-5"
	)
	static final void method31() {
		Client.field756 = 0;
		int var0 = class51.baseX * 64 + (class215.localPlayer.x >> 7);
		int var1 = VarcInt.baseY * 64 + (class215.localPlayer.y >> 7);
		if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
			Client.field756 = 1;
		}

		if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
			Client.field756 = 1;
		}

		if (Client.field756 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
			Client.field756 = 0;
		}

	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-487610810"
	)
	@Export("addCancelMenuEntry")
	static void addCancelMenuEntry() {
		RouteStrategy.method3641();
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
