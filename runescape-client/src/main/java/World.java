import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bo")
@Implements("World")
public class World {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "[Lbo;"
	)
	@Export("World_worlds")
	static World[] World_worlds;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1109260753
	)
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1029210309
	)
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("m")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("y")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("en")
	@ObfuscatedGetter(
		intValue = 1902437399
	)
	static int field1012;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 974966281
	)
	@Export("id")
	int id;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1702314457
	)
	@Export("properties")
	int properties;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 997157235
	)
	@Export("population")
	int population;
	@ObfuscatedName("a")
	@Export("host")
	String host;
	@ObfuscatedName("e")
	@Export("activity")
	String activity;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1450881291
	)
	@Export("location")
	int location;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1472418349
	)
	@Export("index")
	int index;

	static {
		World_count = 0;
		World_listCount = 0;
		World_sortOption2 = new int[]{1, 1, 1, 1};
		World_sortOption1 = new int[]{0, 1, 2, 3};
	}

	World() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "858641980"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-622240981"
	)
	boolean method1806() {
		return (2 & this.properties) != 0;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2080738289"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "100459661"
	)
	boolean method1778() {
		return (8 & this.properties) != 0;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1262281013"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-24"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	@ObfuscatedName("z")
	@Export("base37DecodeLong")
	public static String base37DecodeLong(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (0L == var0 % 37L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; 0L != var3; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5;
				char var8;
				for (var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
					long var6 = var0;
					var0 /= 37L;
					var8 = class288.base37Table[(int)(var6 - var0 * 37L)];
					if (var8 == '_') {
						int var9 = var5.length() - 1;
						var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
						var8 = 160;
					}
				}

				var5.reverse();
				var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
				return var5.toString();
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "118"
	)
	@Export("colorStartTag")
	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1827551520"
	)
	public static int method1814(int var0, int var1) {
		int var2 = var0 >>> 31;
		return (var0 + var2) / var1 - var2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1196159395"
	)
	static int method1815(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GrandExchangeOfferAgeComparator.field76 : KitDefinition.field3252;
		if (var0 == ScriptOpcodes.CC_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class2.method30(class2.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.CC_GETOP) {
			if (var0 == ScriptOpcodes.CC_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		signature = "(Lby;II)V",
		garbageValue = "-310218201"
	)
	@Export("getActorScreenLocation")
	static final void getActorScreenLocation(Actor var0, int var1) {
		PlayerAppearance.worldToScreen(var0.x, var0.y, var1);
	}

	@ObfuscatedName("jj")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1791021557"
	)
	@Export("Clan_joinChat")
	static final void Clan_joinChat(String var0) {
		if (!var0.equals("")) {
			PacketBufferNode var1 = InterfaceParent.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(class268.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
