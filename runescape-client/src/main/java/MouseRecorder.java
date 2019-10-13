import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("qc")
	@ObfuscatedGetter(
		intValue = -749855997
	)
	static int field572;
	@ObfuscatedName("z")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("n")
	@Export("lock")
	Object lock;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -395886809
	)
	@Export("index")
	int index;
	@ObfuscatedName("u")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("r")
	@Export("ys")
	int[] ys;
	@ObfuscatedName("p")
	@Export("millis")
	long[] millis;

	MouseRecorder() {
		this.isRunning = true;
		this.lock = new Object();
		this.index = 0;
		this.xs = new int[500];
		this.ys = new int[500];
		this.millis = new long[500];
	}

	public void run() {
		while (this.isRunning) {
			synchronized(this.lock) {
				if (this.index < 500) {
					this.xs[this.index] = MouseHandler.MouseHandler_x;
					this.ys[this.index] = MouseHandler.MouseHandler_y;
					this.millis[this.index] = MouseHandler.MouseHandler_millis;
					++this.index;
				}
			}

			long var4 = 49L;

			try {
				Thread.sleep(var4);
			} catch (InterruptedException var7) {
			}

			try {
				Thread.sleep(1L);
			} catch (InterruptedException var6) {
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;Lhp;Lhp;I)V",
		garbageValue = "757656787"
	)
	@Export("Widget_setArchives")
	public static void Widget_setArchives(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, AbstractArchive var3) {
		Widget.Widget_archive = var0;
		TaskHandler.Widget_modelsArchive = var1;
		ClientPreferences.Widget_spritesArchive = var2;
		class2.Widget_fontsArchive = var3;
		UserComparator5.Widget_interfaceComponents = new Widget[Widget.Widget_archive.getGroupCount()][];
		ViewportMouse.Widget_loadedInterfaces = new boolean[Widget.Widget_archive.getGroupCount()];
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;IZI)Z",
		garbageValue = "1781175129"
	)
	static boolean method1209(CharSequence var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			boolean var3 = false;
			boolean var4 = false;
			int var5 = 0;
			int var6 = var0.length();

			for (int var7 = 0; var7 < var6; ++var7) {
				char var8 = var0.charAt(var7);
				if (var7 == 0) {
					if (var8 == '-') {
						var3 = true;
						continue;
					}

					if (var8 == '+') {
						continue;
					}
				}

				int var10;
				if (var8 >= '0' && var8 <= '9') {
					var10 = var8 - '0';
				} else if (var8 >= 'A' && var8 <= 'Z') {
					var10 = var8 - '7';
				} else {
					if (var8 < 'a' || var8 > 'z') {
						return false;
					}

					var10 = var8 - 'W';
				}

				if (var10 >= var1) {
					return false;
				}

				if (var3) {
					var10 = -var10;
				}

				int var9 = var10 + var5 * var1;
				if (var9 / var1 != var5) {
					return false;
				}

				var5 = var9;
				var4 = true;
			}

			return var4;
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}

	@ObfuscatedName("ej")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1180818017"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				ViewportMouse.client.method1024();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field669 = 0;
				Client.field670 = 0;
				Client.timer.method4938(var0);
				if (var0 != 20) {
					PlayerType.method4104(false);
				}
			}

			if (var0 != 20 && var0 != 40 && class30.field251 != null) {
				class30.field251.close();
				class30.field251 = null;
			}

			if (Client.gameState == 25) {
				Client.field693 = 0;
				Client.field689 = 0;
				Client.field690 = 1;
				Client.field691 = 0;
				Client.field692 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					WorldMapSprite.method435(Client.archive10, GrandExchangeOfferAgeComparator.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					WorldMapSprite.method435(Client.archive10, GrandExchangeOfferAgeComparator.archive8, false, 4);
				} else if (Login.field1160) {
					class32.titleboxSprite = null;
					AbstractRasterProvider.titlebuttonSprite = null;
					Login.runesSprite = null;
					WorldMapID.leftTitleSprite = null;
					class51.rightTitleSprite = null;
					FontName.logoSprite = null;
					UserComparator7.title_muteSprite = null;
					class195.options_buttons_0Sprite = null;
					class42.options_buttons_2Sprite = null;
					ArchiveLoader.worldSelectBackSprites = null;
					Language.worldSelectFlagSprites = null;
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows = null;
					Frames.worldSelectStars = null;
					Skeleton.field1767 = null;
					BufferedSink.loginScreenRunesAnimation.method1821();
					class197.field2386 = 1;
					class197.musicTrackArchive = null;
					class188.musicTrackGroupId = -1;
					class49.musicTrackFileId = -1;
					TileItem.field1223 = 0;
					WorldMapSectionType.musicTrackBoolean = false;
					MusicPatchNode2.field2382 = 2;
					DirectByteArrayCopier.method3924(true);
					Login.field1160 = false;
				}
			} else {
				WorldMapSprite.method435(Client.archive10, GrandExchangeOfferAgeComparator.archive8, true, 0);
			}

			Client.gameState = var0;
		}
	}

	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "861469651"
	)
	static final void method1213() {
		if (Client.logoutTimer > 0) {
			DynamicObject.logOut();
		} else {
			Client.timer.method4937();
			updateGameState(40);
			class30.field251 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		signature = "([Lho;II)V",
		garbageValue = "-1695750792"
	)
	@Export("runComponentCloseListeners")
	static final void runComponentCloseListeners(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null) {
				if (var3.type == 0) {
					if (var3.children != null) {
						runComponentCloseListeners(var3.children, var1);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						class40.runIntfCloseListeners(var4.group, var1);
					}
				}

				ScriptEvent var5;
				if (var1 == 0 && var3.onDialogAbort != null) {
					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onDialogAbort;
					ParamDefinition.runScriptEvent(var5);
				}

				if (var1 == 1 && var3.onSubChange != null) {
					if (var3.childIndex >= 0) {
						Widget var6 = Canvas.getWidget(var3.id);
						if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
							continue;
						}
					}

					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onSubChange;
					ParamDefinition.runScriptEvent(var5);
				}
			}
		}

	}
}
