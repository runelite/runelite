import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Frames")
public class Frames extends DualNode {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "[Ldj;"
	)
	@Export("frames")
	Animation[] frames;

	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;IZ)V",
		garbageValue = "0"
	)
	public Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.getGroupFileCount(var3);
		this.frames = new Animation[var6];
		int[] var7 = var1.getGroupFileIds(var3);

		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.takeFile(var3, var7[var8]);
			Skeleton var10 = null;
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

			for (Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
				if (var11 == var12.id) {
					var10 = var12;
					break;
				}
			}

			if (var10 == null) {
				byte[] var13 = var2.getFile(var11, 0);
				var10 = new Skeleton(var11, var13);
				var5.addFirst(var10);
			}

			this.frames[var7[var8]] = new Animation(var9, var10);
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-996338531"
	)
	@Export("hasAlphaTransform")
	public boolean hasAlphaTransform(int var1) {
		return this.frames[var1].hasAlphaTransform;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-360173892"
	)
	static void method3280() {
		if (Login.field1173) {
			Login.titleboxSprite = null;
			Login.titlebuttonSprite = null;
			Login.runesSprite = null;
			UrlRequest.leftTitleSprite = null;
			ScriptFrame.rightTitleSprite = null;
			Login.logoSprite = null;
			class30.title_muteSprite = null;
			class218.options_buttons_0Sprite = null;
			Login.options_buttons_2Sprite = null;
			Calendar.worldSelectBackSprites = null;
			AbstractWorldMapIcon.worldSelectFlagSprites = null;
			Message.worldSelectArrows = null;
			SpotAnimationDefinition.worldSelectStars = null;
			class54.field483 = null;
			StructDefinition.loginScreenRunesAnimation.method1812();
			BoundaryObject.method3273(2);
			BuddyRankComparator.method3362(true);
			Login.field1173 = false;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "43"
	)
	static int method3281(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return WorldMapManager.method656(var0, var1, var2);
		} else if (var0 < 1100) {
			return class60.method1170(var0, var1, var2);
		} else if (var0 < 1200) {
			return MidiPcmStream.method3737(var0, var1, var2);
		} else if (var0 < 1300) {
			return Friend.method5286(var0, var1, var2);
		} else if (var0 < 1400) {
			return UrlRequester.method3306(var0, var1, var2);
		} else if (var0 < 1500) {
			return GrandExchangeOfferNameComparator.method134(var0, var1, var2);
		} else if (var0 < 1600) {
			return class2.method34(var0, var1, var2);
		} else if (var0 < 1700) {
			return ServerPacket.method3568(var0, var1, var2);
		} else if (var0 < 1800) {
			return UserList.method5193(var0, var1, var2);
		} else if (var0 < 1900) {
			return ServerPacket.method3569(var0, var1, var2);
		} else if (var0 < 2000) {
			return LoginPacket.method3575(var0, var1, var2);
		} else if (var0 < 2100) {
			return class60.method1170(var0, var1, var2);
		} else if (var0 < 2200) {
			return MidiPcmStream.method3737(var0, var1, var2);
		} else if (var0 < 2300) {
			return Friend.method5286(var0, var1, var2);
		} else if (var0 < 2400) {
			return UrlRequester.method3306(var0, var1, var2);
		} else if (var0 < 2500) {
			return GrandExchangeOfferNameComparator.method134(var0, var1, var2);
		} else if (var0 < 2600) {
			return class219.method4077(var0, var1, var2);
		} else if (var0 < 2700) {
			return WorldMapAreaData.method692(var0, var1, var2);
		} else if (var0 < 2800) {
			return GameShell.method1068(var0, var1, var2);
		} else if (var0 < 2900) {
			return class32.method559(var0, var1, var2);
		} else if (var0 < 3000) {
			return LoginPacket.method3575(var0, var1, var2);
		} else if (var0 < 3200) {
			return AbstractArchive.method4166(var0, var1, var2);
		} else if (var0 < 3300) {
			return AbstractByteArrayCopier.method3937(var0, var1, var2);
		} else if (var0 < 3400) {
			return class206.method3919(var0, var1, var2);
		} else if (var0 < 3500) {
			return DevicePcmPlayerProvider.method840(var0, var1, var2);
		} else if (var0 < 3700) {
			return MenuAction.method2069(var0, var1, var2);
		} else if (var0 < 4000) {
			return ScriptFrame.method1111(var0, var1, var2);
		} else if (var0 < 4100) {
			return GrandExchangeEvents.method72(var0, var1, var2);
		} else if (var0 < 4200) {
			return class60.method1171(var0, var1, var2);
		} else if (var0 < 4300) {
			return ScriptFrame.method1112(var0, var1, var2);
		} else if (var0 < 5100) {
			return Tiles.method1144(var0, var1, var2);
		} else if (var0 < 5400) {
			return UserComparator6.method3369(var0, var1, var2);
		} else if (var0 < 5600) {
			return VarpDefinition.method4347(var0, var1, var2);
		} else if (var0 < 5700) {
			return UserComparator7.method3345(var0, var1, var2);
		} else if (var0 < 6300) {
			return Player.method1277(var0, var1, var2);
		} else if (var0 < 6600) {
			return AbstractWorldMapData.method272(var0, var1, var2);
		} else {
			return var0 < 6700 ? WorldMapRectangle.method273(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1767342490"
	)
	@Export("iLog")
	public static int iLog(int var0) {
		int var1 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var1 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var1 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var1 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var1 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var1;
		}

		return var0 + var1;
	}

	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		signature = "(IIIIZB)V",
		garbageValue = "36"
	)
	@Export("setViewportShape")
	static final void setViewportShape(int var0, int var1, int var2, int var3, boolean var4) {
		if (var2 < 1) {
			var2 = 1;
		}

		if (var3 < 1) {
			var3 = 1;
		}

		int var5 = var3 - 334;
		int var6;
		if (var5 < 0) {
			var6 = Client.field879;
		} else if (var5 >= 100) {
			var6 = Client.field880;
		} else {
			var6 = (Client.field880 - Client.field879) * var5 / 100 + Client.field879;
		}

		int var7 = var3 * var6 * 512 / (var2 * 334);
		int var8;
		int var9;
		short var10;
		if (var7 < Client.field804) {
			var10 = Client.field804;
			var6 = var10 * var2 * 334 / (var3 * 512);
			if (var6 > Client.field884) {
				var6 = Client.field884;
				var8 = var3 * var6 * 512 / (var10 * 334);
				var9 = (var2 - var8) / 2;
				if (var4) {
					Rasterizer2D.Rasterizer2D_resetClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
				}

				var0 += var9;
				var2 -= var9 * 2;
			}
		} else if (var7 > Client.field886) {
			var10 = Client.field886;
			var6 = var10 * var2 * 334 / (var3 * 512);
			if (var6 < Client.field796) {
				var6 = Client.field796;
				var8 = var10 * var2 * 334 / (var6 * 512);
				var9 = (var3 - var8) / 2;
				if (var4) {
					Rasterizer2D.Rasterizer2D_resetClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
				}

				var1 += var9;
				var3 -= var9 * 2;
			}
		}

		Client.viewportZoom = var3 * var6 / 334;
		if (var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
			Language.method3634(var2, var3);
		}

		Client.viewportOffsetX = var0;
		Client.viewportOffsetY = var1;
		Client.viewportWidth = var2;
		Client.viewportHeight = var3;
	}
}
