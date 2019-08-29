import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("LoginPacket")
public class LoginPacket implements class181 {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public static final LoginPacket field2291;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	static final LoginPacket field2293;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public static final LoginPacket field2295;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public static final LoginPacket field2292;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	static final LoginPacket field2289;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lge;"
	)
	@Export("LoginPacket_indexedValues")
	static final LoginPacket[] LoginPacket_indexedValues;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1160024949
	)
	@Export("id")
	public final int id;

	static {
		field2291 = new LoginPacket(14, 0);
		field2293 = new LoginPacket(15, 4);
		field2295 = new LoginPacket(16, -2);
		field2292 = new LoginPacket(18, -2);
		field2289 = new LoginPacket(27, 0);
		LoginPacket_indexedValues = new LoginPacket[32];
		LoginPacket[] var0 = class16.method183();

		for (int var1 = 0; var1 < var0.length; ++var1) {
			LoginPacket_indexedValues[var0[var1].id] = var0[var1];
		}

	}

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	LoginPacket(int var1, int var2) {
		this.id = var1;
	}

	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)V",
		garbageValue = "237960990"
	)
	@Export("findItemDefinitions")
	static void findItemDefinitions(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var2 = new short[16];
		int var3 = 0;

		for (int var4 = 0; var4 < MouseRecorder.ItemDefinition_fileCount; ++var4) {
			ItemDefinition var5 = WorldMapData_0.ItemDefinition_get(var4);
			if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
				if (var3 >= 250) {
					Language.foundItemIdCount = -1;
					SecureRandomCallable.foundItemIds = null;
					return;
				}

				if (var3 >= var2.length) {
					short[] var6 = new short[var2.length * 2];

					for (int var7 = 0; var7 < var3; ++var7) {
						var6[var7] = var2[var7];
					}

					var2 = var6;
				}

				var2[var3++] = (short)var4;
			}
		}

		SecureRandomCallable.foundItemIds = var2;
		GrandExchangeOffer.foundItemIndex = 0;
		Language.foundItemIdCount = var3;
		String[] var8 = new String[Language.foundItemIdCount];

		for (int var9 = 0; var9 < Language.foundItemIdCount; ++var9) {
			var8[var9] = WorldMapData_0.ItemDefinition_get(var2[var9]).name;
		}

		short[] var10 = SecureRandomCallable.foundItemIds;
		ModelData0.sortItemsByName(var8, var10, 0, var8.length - 1);
	}
}
