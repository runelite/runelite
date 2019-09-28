import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ay")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("z")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)Lho;",
		garbageValue = "313560965"
	)
	@Export("getWidget")
	public static Widget getWidget(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & 65535;
		if (UserComparator5.Widget_interfaceComponents[var1] == null || UserComparator5.Widget_interfaceComponents[var1][var2] == null) {
			boolean var3 = WorldMapData_0.loadInterface(var1);
			if (!var3) {
				return null;
			}
		}

		return UserComparator5.Widget_interfaceComponents[var1][var2];
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lhp;III)[Llf;",
		garbageValue = "-2024454786"
	)
	@Export("SpriteBuffer_getSpriteArray")
	public static Sprite[] SpriteBuffer_getSpriteArray(AbstractArchive var0, int var1, int var2) {
		return !VertexNormal.method2962(var0, var1, var2) ? null : AbstractWorldMapIcon.method642();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "952621968"
	)
	static int method889(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.GETWINDOWMODE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class247.getWindowedMode();
			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.SETWINDOWMODE) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					UserComparator8.setWindowedMode(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.GETDEFAULTWINDOWMODE) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractArchive.clientPreferences.windowMode;
				return 1;
			} else if (var0 != ScriptOpcodes.SETDEFAULTWINDOWMODE) {
				if (var0 == 5310) {
					--Interpreter.Interpreter_intStackSize;
					return 1;
				} else {
					return 2;
				}
			} else {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					AbstractArchive.clientPreferences.windowMode = var3;
					Language.savePreferences();
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)V",
		garbageValue = "328041460"
	)
	@Export("findItemDefinitions")
	static void findItemDefinitions(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var2 = new short[16];
		int var3 = 0;

		for (int var4 = 0; var4 < JagexCache.ItemDefinition_fileCount; ++var4) {
			ItemDefinition var5 = Occluder.ItemDefinition_get(var4);
			if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
				if (var3 >= 250) {
					DevicePcmPlayerProvider.foundItemIdCount = -1;
					WorldMapIcon_0.foundItemIds = null;
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

		WorldMapIcon_0.foundItemIds = var2;
		ReflectionCheck.foundItemIndex = 0;
		DevicePcmPlayerProvider.foundItemIdCount = var3;
		String[] var8 = new String[DevicePcmPlayerProvider.foundItemIdCount];

		for (int var9 = 0; var9 < DevicePcmPlayerProvider.foundItemIdCount; ++var9) {
			var8[var9] = Occluder.ItemDefinition_get(var2[var9]).name;
		}

		short[] var10 = WorldMapIcon_0.foundItemIds;
		GrandExchangeOfferNameComparator.sortItemsByName(var8, var10, 0, var8.length - 1);
	}
}
