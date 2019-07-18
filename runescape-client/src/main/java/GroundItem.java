import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("GroundItem")
public final class GroundItem extends Entity {
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1900937269
	)
	static int field1242;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1946972179
	)
	@Export("id")
	int id;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1304382567
	)
	@Export("quantity")
	int quantity;

	GroundItem() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ldm;",
		garbageValue = "759381421"
	)
	@Export("getModel")
	protected final Model getModel() {
		return WorldMapArea.getItemDefinition(this.id).getModel(this.quantity);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;B)V",
		garbageValue = "97"
	)
	public static void method2054(AbstractArchive var0) {
		StructDefinition.StructDefinition_archive = var0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)Lbj;",
		garbageValue = "308740376"
	)
	static Message method2049(int var0, int var1) {
		ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var2.getMessage(var1);
	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "96373324"
	)
	static void method2053(int var0, int var1, int var2, int var3) {
		Widget var4 = Client.getWidgetChild(var0, var1);
		if (var4 != null && var4.onTargetEnter != null) {
			ScriptEvent var5 = new ScriptEvent();
			var5.widget = var4;
			var5.args = var4.onTargetEnter;
			LoginPacket.runScriptEvent(var5);
		}

		Client.field812 = var3;
		Client.isSpellSelected = true;
		WorldMapEvent.field359 = var0;
		Client.field848 = var1;
		WorldMapCacheName.selectedSpellFlags = var2;
		Strings.method4120(var4);
	}
}
