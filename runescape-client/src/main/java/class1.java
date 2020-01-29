import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class1 implements class0 {
	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("fontBold12")
	static Font fontBold12;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkp;B)V",
		garbageValue = "95"
	)
	public void vmethod55(Object var1, Buffer var2) {
		this.method7((Integer)var1, var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;I)Ljava/lang/Object;",
		garbageValue = "1665636232"
	)
	public Object vmethod53(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Integer;Lkp;I)V",
		garbageValue = "-890899410"
	)
	void method7(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lbg;Lbg;IZIZI)I",
		garbageValue = "-926800273"
	)
	static int method19(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
		int var6 = MouseHandler.compareWorlds(var0, var1, var2, var3);
		if (var6 != 0) {
			return var3 ? -var6 : var6;
		} else if (var4 == -1) {
			return 0;
		} else {
			int var7 = MouseHandler.compareWorlds(var0, var1, var4, var5);
			return var5 ? -var7 : var7;
		}
	}
}
