import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class1 implements class0 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkb;B)V",
		garbageValue = "3"
	)
	public void vmethod64(Object var1, Buffer var2) {
		this.method8((Integer)var1, var2);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;I)Ljava/lang/Object;",
		garbageValue = "-1146837249"
	)
	public Object vmethod74(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Integer;Lkb;B)V",
		garbageValue = "-6"
	)
	void method8(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1095307790"
	)
	static String method21(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIB)Lby;",
		garbageValue = "72"
	)
	@Export("Messages_getByChannelAndID")
	static Message Messages_getByChannelAndID(int var0, int var1) {
		ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var2.getMessage(var1);
	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		signature = "(IIIILla;Lhg;B)V",
		garbageValue = "-12"
	)
	@Export("worldToMinimap")
	static final void worldToMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		int var6 = var3 * var3 + var2 * var2;
		if (var6 > 4225 && var6 < 90000) {
			int var7 = Client.camAngleY & 2047;
			int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
			int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
			int var10 = var9 * var2 + var3 * var8 >> 16;
			int var11 = var3 * var9 - var8 * var2 >> 16;
			double var12 = Math.atan2((double)var10, (double)var11);
			int var14 = var5.width / 2 - 25;
			int var15 = (int)(Math.sin(var12) * (double)var14);
			int var16 = (int)(Math.cos(var12) * (double)var14);
			byte var17 = 20;
			GrandExchangeOfferNameComparator.redHintArrowSprite.method6242(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
		} else {
			ScriptEvent.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
		}

	}
}
