import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bh")
@Implements("Interpreter")
public class Interpreter {
	@ObfuscatedName("ps")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("sceneMinimapSprite")
	static Sprite sceneMinimapSprite;
	@ObfuscatedName("z")
	@Export("Interpreter_arrayLengths")
	static int[] Interpreter_arrayLengths;
	@ObfuscatedName("p")
	@Export("Interpreter_arrays")
	static int[][] Interpreter_arrays;
	@ObfuscatedName("h")
	@Export("Interpreter_intStack")
	static int[] Interpreter_intStack;
	@ObfuscatedName("w")
	@Export("Interpreter_stringStack")
	static String[] Interpreter_stringStack;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1012398359
	)
	@Export("Interpreter_frameDepth")
	static int Interpreter_frameDepth;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Lbd;"
	)
	@Export("Interpreter_frames")
	static ScriptFrame[] Interpreter_frames;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lcf;"
	)
	@Export("pcmPlayerProvider")
	static class99 pcmPlayerProvider;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhl;"
	)
	static Widget field1090;
	@ObfuscatedName("n")
	@Export("Interpreter_calendar")
	static java.util.Calendar Interpreter_calendar;
	@ObfuscatedName("r")
	@Export("Interpreter_MONTHS")
	static final String[] Interpreter_MONTHS;
	@ObfuscatedName("a")
	static boolean field1093;
	@ObfuscatedName("d")
	static boolean field1087;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -185993069
	)
	static int field1095;
	@ObfuscatedName("q")
	static final double field1082;
	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("js5Socket")
	static AbstractSocket js5Socket;

	static {
		Interpreter_arrayLengths = new int[5];
		Interpreter_arrays = new int[5][5000];
		Interpreter_intStack = new int[1000];
		Interpreter_stringStack = new String[1000];
		Interpreter_frameDepth = 0;
		Interpreter_frames = new ScriptFrame[50];
		Interpreter_calendar = java.util.Calendar.getInstance();
		Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		field1093 = false;
		field1087 = false;
		field1095 = 0;
		field1082 = Math.log(2.0D);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Liu;",
		garbageValue = "-1932320530"
	)
	@Export("ItemDefinition_get")
	public static ItemDefinition ItemDefinition_get(int var0) {
		ItemDefinition var1 = (ItemDefinition)ItemDefinition.ItemDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ItemDefinition.ItemDefinition_archive.takeFile(10, var0);
			var1 = new ItemDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			if (var1.noteTemplate != -1) {
				var1.genCert(ItemDefinition_get(var1.noteTemplate), ItemDefinition_get(var1.note));
			}

			if (var1.notedId != -1) {
				var1.genBought(ItemDefinition_get(var1.notedId), ItemDefinition_get(var1.unnotedId));
			}

			if (var1.placeholderTemplate != -1) {
				var1.genPlaceholder(ItemDefinition_get(var1.placeholderTemplate), ItemDefinition_get(var1.placeholder));
			}

			if (!ItemDefinition.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
				var1.name = "Members object";
				var1.isTradable = false;
				var1.groundActions = null;
				var1.inventoryActions = null;
				var1.shiftClickIndex = -1;
				var1.team = 0;
				if (var1.params != null) {
					boolean var3 = false;

					for (Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
						ParamDefinition var5 = MusicPatchNode.getParamDefinition((int)var4.key);
						if (var5.autoDisable) {
							var4.remove();
						} else {
							var3 = true;
						}
					}

					if (!var3) {
						var1.params = null;
					}
				}
			}

			ItemDefinition.ItemDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)Z",
		garbageValue = "-1540204759"
	)
	@Export("isNumber")
	public static boolean isNumber(CharSequence var0) {
		return SpriteMask.method4039(var0, 10, true);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(ILci;ZI)I",
		garbageValue = "1948301704"
	)
	static int method1995(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Language.getWidget(Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? field1090 : class188.field2352;
		}

		ScriptEvent.invalidateWidget(var3);
		if (var0 != ScriptOpcodes.CC_SETOBJECT && var0 != ScriptOpcodes.CC_SETOBJECT_NONUM && var0 != ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM) {
			if (var0 == ScriptOpcodes.CC_SETNPCHEAD) {
				var3.modelType = 2;
				var3.modelId = Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETPLAYERHEAD_SELF) {
				var3.modelType = 3;
				var3.modelId = class215.localPlayer.appearance.getChatHeadId();
				return 1;
			} else {
				return 2;
			}
		} else {
			GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
			int var4 = Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			int var5 = Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemDefinition var6 = ItemDefinition_get(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == ScriptOpcodes.CC_SETOBJECT_NONUM) {
				var3.itemQuantityMode = 0;
			} else if (var0 == ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM | 1 == var6.isStackable) {
				var3.itemQuantityMode = 1;
			} else {
				var3.itemQuantityMode = 2;
			}

			if (var3.field2711 > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.field2711;
			} else if (var3.rawWidth > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
			}

			return 1;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ldf;IIIB)Z",
		garbageValue = "-22"
	)
	static final boolean method1969(Model var0, int var1, int var2, int var3) {
		boolean var4 = ViewportMouse.ViewportMouse_isInViewport;
		if (!var4) {
			return false;
		} else {
			class96.method2307();
			int var5 = var0.xMid + var1;
			int var6 = var2 + var0.yMid;
			int var7 = var3 + var0.zMid;
			int var8 = var0.xMidOffset;
			int var9 = var0.yMidOffset;
			int var10 = var0.zMidOffset;
			int var11 = class30.field261 - var5;
			int var12 = class2.field5 - var6;
			int var13 = GrandExchangeEvents.field36 - var7;
			if (Math.abs(var11) > var8 + Frames.field1880) {
				return false;
			} else if (Math.abs(var12) > var9 + class189.field2355) {
				return false;
			} else if (Math.abs(var13) > var10 + class65.field603) {
				return false;
			} else if (Math.abs(var13 * ViewportMouse.field1739 - var12 * class288.field3652) > var9 * class65.field603 + var10 * class189.field2355) {
				return false;
			} else if (Math.abs(var11 * class288.field3652 - var13 * ViewportMouse.field1737) > var8 * class65.field603 + var10 * Frames.field1880) {
				return false;
			} else {
				return Math.abs(var12 * ViewportMouse.field1737 - var11 * ViewportMouse.field1739) <= var9 * Frames.field1880 + var8 * class189.field2355;
			}
		}
	}
}
