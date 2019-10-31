import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bi")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("sc")
	@ObfuscatedSignature(
		signature = "Lbw;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("fz")
	@ObfuscatedGetter(
		intValue = -1497740127
	)
	static int field563;
	@ObfuscatedName("a")
	@Export("args")
	Object[] args;
	@ObfuscatedName("t")
	@Export("isMouseInputEvent")
	boolean isMouseInputEvent;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2022022571
	)
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 2109741703
	)
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -668858451
	)
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -649087669
	)
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1510622969
	)
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("d")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1448697707
	)
	int field550;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 251797665
	)
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;B)V",
		garbageValue = "0"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1079010061"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIILix;IB)V",
		garbageValue = "24"
	)
	static void method1274(int var0, int var1, int var2, ObjectDefinition var3, int var4) {
		ObjectSound var5 = new ObjectSound();
		var5.plane = var0;
		var5.x = var1 * 128;
		var5.y = var2 * 16384;
		int var6 = var3.sizeX;
		int var7 = var3.sizeY;
		if (var4 == 1 || var4 == 3) {
			var6 = var3.sizeY;
			var7 = var3.sizeX;
		}

		var5.field1060 = (var6 + var1) * 16384;
		var5.field1053 = (var7 + var2) * 16384;
		var5.soundEffectId = var3.ambientSoundId;
		var5.field1052 = var3.int4 * 128;
		var5.field1057 = var3.int5;
		var5.field1058 = var3.int6;
		var5.soundEffectIds = var3.soundEffectIds;
		if (var3.transforms != null) {
			var5.obj = var3;
			var5.set();
		}

		ObjectSound.objectSounds.addFirst(var5);
		if (var5.soundEffectIds != null) {
			var5.field1054 = var5.field1057 + (int)(Math.random() * (double)(var5.field1058 - var5.field1057));
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-1199782761"
	)
	static String method1277() {
		String var0;
		if (clientPreferences.hideUsername) {
			String var2 = Login.Login_username;
			int var4 = var2.length();
			char[] var5 = new char[var4];

			for (int var6 = 0; var6 < var4; ++var6) {
				var5[var6] = '*';
			}

			String var3 = new String(var5);
			var0 = var3;
		} else {
			var0 = Login.Login_username;
		}

		return var0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(CLgw;B)I",
		garbageValue = "86"
	)
	@Export("lowercaseChar")
	static int lowercaseChar(char var0, Language var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		if (var0 == 241 && var1 == Language.Language_ES) {
			var2 = 1762;
		}

		return var2;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1588093923"
	)
	public static int method1272(int var0) {
		return UserComparator8.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIIIIZB)Llx;",
		garbageValue = "1"
	)
	@Export("getItemSprite")
	public static final Sprite getItemSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
		if (var1 == -1) {
			var4 = 0;
		} else if (var4 == 2 && var1 != 1) {
			var4 = 1;
		}

		long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38);
		Sprite var8;
		if (!var5) {
			var8 = (Sprite)ItemDefinition.ItemDefinition_cachedSprites.get(var6);
			if (var8 != null) {
				return var8;
			}
		}

		ItemDefinition var9 = class222.ItemDefinition_get(var0);
		if (var1 > 1 && var9.countobj != null) {
			int var10 = -1;

			for (int var11 = 0; var11 < 10; ++var11) {
				if (var1 >= var9.countco[var11] && var9.countco[var11] != 0) {
					var10 = var9.countobj[var11];
				}
			}

			if (var10 != -1) {
				var9 = class222.ItemDefinition_get(var10);
			}
		}

		Model var21 = var9.getModel(1);
		if (var21 == null) {
			return null;
		} else {
			Sprite var22 = null;
			if (var9.noteTemplate != -1) {
				var22 = getItemSprite(var9.note, 10, 1, 0, 0, true);
				if (var22 == null) {
					return null;
				}
			} else if (var9.notedId != -1) {
				var22 = getItemSprite(var9.unnotedId, var1, var2, var3, 0, false);
				if (var22 == null) {
					return null;
				}
			} else if (var9.placeholderTemplate != -1) {
				var22 = getItemSprite(var9.placeholder, var1, 0, 0, 0, false);
				if (var22 == null) {
					return null;
				}
			}

			int[] var12 = Rasterizer2D.Rasterizer2D_pixels;
			int var13 = Rasterizer2D.Rasterizer2D_width;
			int var14 = Rasterizer2D.Rasterizer2D_height;
			int[] var15 = new int[4];
			Rasterizer2D.Rasterizer2D_getClipArray(var15);
			var8 = new Sprite(36, 32);
			Rasterizer2D.Rasterizer2D_replace(var8.pixels, 36, 32);
			Rasterizer2D.Rasterizer2D_clear();
			Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
			Rasterizer3D.method3131(16, 16);
			Rasterizer3D.field1739 = false;
			if (var9.placeholderTemplate != -1) {
				var22.drawTransBgAt(0, 0);
			}

			int var16 = var9.zoom2d;
			if (var5) {
				var16 = (int)(1.5D * (double)var16);
			} else if (var2 == 2) {
				var16 = (int)(1.04D * (double)var16);
			}

			int var17 = var16 * Rasterizer3D.Rasterizer3D_sine[var9.xan2d] >> 16;
			int var18 = var16 * Rasterizer3D.Rasterizer3D_cosine[var9.xan2d] >> 16;
			var21.calculateBoundsCylinder();
			var21.method3044(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var21.height / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
			if (var9.notedId != -1) {
				var22.drawTransBgAt(0, 0);
			}

			if (var2 >= 1) {
				var8.outline(1);
			}

			if (var2 >= 2) {
				var8.outline(16777215);
			}

			if (var3 != 0) {
				var8.shadow(var3);
			}

			Rasterizer2D.Rasterizer2D_replace(var8.pixels, 36, 32);
			if (var9.noteTemplate != -1) {
				var22.drawTransBgAt(0, 0);
			}

			if (var4 == 1 || var4 == 2 && var9.isStackable == 1) {
				Font var19 = class30.ItemDefinition_fontPlain11;
				String var20;
				if (var1 < 100000) {
					var20 = "<col=ffff00>" + var1 + "</col>";
				} else if (var1 < 10000000) {
					var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
				} else {
					var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
				}

				var19.draw(var20, 0, 9, 16776960, 1);
			}

			if (!var5) {
				ItemDefinition.ItemDefinition_cachedSprites.put(var8, var6);
			}

			Rasterizer2D.Rasterizer2D_replace(var12, var13, var14);
			Rasterizer2D.Rasterizer2D_setClipArray(var15);
			Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
			Rasterizer3D.field1739 = true;
			return var8;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(ILcj;ZB)I",
		garbageValue = "-66"
	)
	static int method1263(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class96.field1301 : ReflectionCheck.field1310;
		if (var0 == ScriptOpcodes.CC_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator5.method3551(class195.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.CC_GETOP) {
			if (var0 == ScriptOpcodes.CC_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "(IIIIIIIII)V",
		garbageValue = "-1558725091"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (TextureProvider.loadInterface(var0)) {
			VarcInt.field3218 = null;
			IgnoreList.drawInterface(Widget.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (VarcInt.field3218 != null) {
				IgnoreList.drawInterface(VarcInt.field3218, -1412584499, var1, var2, var3, var4, TriBool.field3600, GrandExchangeEvent.field46, var7);
				VarcInt.field3218 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field842[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field842[var8] = true;
				}
			}

		}
	}
}
