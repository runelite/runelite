import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ClientPreferences")
public class ClientPreferences {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1654668565
	)
	@Export("ClientPreferences_optionCount")
	static int ClientPreferences_optionCount;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1650607601
	)
	@Export("clientTickTimeIdx")
	static int clientTickTimeIdx;
	@ObfuscatedName("k")
	@Export("roofsHidden")
	boolean roofsHidden;
	@ObfuscatedName("d")
	@Export("titleMusicDisabled")
	boolean titleMusicDisabled;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1989279891
	)
	@Export("windowMode")
	int windowMode;
	@ObfuscatedName("v")
	@Export("rememberedUsername")
	String rememberedUsername;
	@ObfuscatedName("q")
	@Export("hideUsername")
	boolean hideUsername;
	@ObfuscatedName("z")
	@Export("parameters")
	LinkedHashMap parameters;

	static {
		ClientPreferences_optionCount = 6;
	}

	ClientPreferences() {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		this.method1942(true);
	}

	@ObfuscatedSignature(
		signature = "(Lkb;)V"
	)
	ClientPreferences(Buffer var1) {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		if (var1 != null && var1.array != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= ClientPreferences_optionCount) {
				if (var1.readUnsignedByte() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
				}

				if (var2 > 5) {
					this.hideUsername = var1.readBoolean();
				}
			} else {
				this.method1942(true);
			}
		} else {
			this.method1942(true);
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1802002327"
	)
	void method1942(boolean var1) {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Lkb;",
		garbageValue = "745371681"
	)
	@Export("toBuffer")
	Buffer toBuffer() {
		Buffer var1 = new Buffer(100);
		var1.writeByte(ClientPreferences_optionCount);
		var1.writeByte(this.roofsHidden ? 1 : 0);
		var1.writeByte(this.titleMusicDisabled ? 1 : 0);
		var1.writeByte(this.windowMode);
		var1.writeByte(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.writeInt((Integer)var3.getKey());
			var1.writeInt((Integer)var3.getValue());
		}

		var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBoolean(this.hideUsername);
		return var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "102"
	)
	static final void method1950(String var0) {
		GrandExchangeEvent.method165("Please remove " + var0 + " from your ignore list first");
	}
}
