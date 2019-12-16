import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class81 {
	@ObfuscatedName("nd")
	@ObfuscatedGetter(
		intValue = -122722745
	)
	static int field1126;
	@ObfuscatedName("z")
	public static String field1129;

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
		garbageValue = "855544439"
	)
	static File method2064(String var0, String var1, int var2) {
		String var3 = var2 == 0 ? "" : "" + var2;
		DefaultsGroup.JagexCache_locationFile = new File(ReflectionCheck.userHomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
		String var4 = null;
		String var5 = null;
		boolean var6 = false;
		Buffer var8;
		File var23;
		if (DefaultsGroup.JagexCache_locationFile.exists()) {
			try {
				AccessFile var7 = new AccessFile(DefaultsGroup.JagexCache_locationFile, "rw", 10000L);

				int var9;
				for (var8 = new Buffer((int)var7.length()); var8.offset < var8.array.length; var8.offset += var9) {
					var9 = var7.read(var8.array, var8.offset, var8.array.length - var8.offset);
					if (var9 == -1) {
						throw new IOException();
					}
				}

				var8.offset = 0;
				var9 = var8.readUnsignedByte();
				if (var9 < 1 || var9 > 3) {
					throw new IOException("" + var9);
				}

				int var10 = 0;
				if (var9 > 1) {
					var10 = var8.readUnsignedByte();
				}

				if (var9 <= 2) {
					var4 = var8.readStringCp1252NullCircumfixed();
					if (var10 == 1) {
						var5 = var8.readStringCp1252NullCircumfixed();
					}
				} else {
					var4 = var8.readCESU8();
					if (var10 == 1) {
						var5 = var8.readCESU8();
					}
				}

				var7.close();
			} catch (IOException var21) {
				var21.printStackTrace();
			}

			if (var4 != null) {
				var23 = new File(var4);
				if (!var23.exists()) {
					var4 = null;
				}
			}

			if (var4 != null) {
				var23 = new File(var4, "test.dat");
				if (!class173.method3561(var23, true)) {
					var4 = null;
				}
			}
		}

		if (var4 == null && var2 == 0) {
			label142:
			for (int var15 = 0; var15 < WorldMapSprite.field219.length; ++var15) {
				for (int var16 = 0; var16 < JagexCache.field2024.length; ++var16) {
					File var17 = new File(JagexCache.field2024[var16] + WorldMapSprite.field219[var15] + File.separatorChar + var0 + File.separatorChar);
					if (var17.exists() && class173.method3561(new File(var17, "test.dat"), true)) {
						var4 = var17.toString();
						var6 = true;
						break label142;
					}
				}
			}
		}

		if (var4 == null) {
			var4 = ReflectionCheck.userHomeDirectory + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
			var6 = true;
		}

		File var22;
		if (var5 != null) {
			var22 = new File(var5);
			var23 = new File(var4);

			try {
				File[] var24 = var22.listFiles();
				File[] var18 = var24;

				for (int var11 = 0; var11 < var18.length; ++var11) {
					File var12 = var18[var11];
					File var13 = new File(var23, var12.getName());
					boolean var14 = var12.renameTo(var13);
					if (!var14) {
						throw new IOException();
					}
				}
			} catch (Exception var20) {
				var20.printStackTrace();
			}

			var6 = true;
		}

		if (var6) {
			var22 = new File(var4);
			var8 = null;

			try {
				AccessFile var25 = new AccessFile(DefaultsGroup.JagexCache_locationFile, "rw", 10000L);
				Buffer var26 = new Buffer(500);
				var26.writeByte(3);
				var26.writeByte(var8 != null ? 1 : 0);
				var26.writeCESU8(var22.getPath());
				if (var8 != null) {
					var26.writeCESU8("");
				}

				var25.write(var26.array, 0, var26.offset);
				var25.close();
			} catch (IOException var19) {
				var19.printStackTrace();
			}
		}

		return new File(var4);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "998758859"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + NetSocket.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}

	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1389817543"
	)
	static final void method2063() {
		PacketBufferNode.method3587();
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
		KitDefinition.KitDefinition_cached.clear();
		class189.method3623();
		class237.method4300();
		class54.method1104();
		class286.method5310();
		MusicPatchNode2.method3668();
		Huffman.method3917();
		Actor.method1756();
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
		class226.method4100();
		GrandExchangeOfferAgeComparator.method146();
		class16.method179();
		WorldMapElement.WorldMapElement_cachedSprites.clear();
		class14.method155();
		Widget.Widget_cachedSprites.clear();
		Widget.Widget_cachedModels.clear();
		Widget.Widget_cachedFonts.clear();
		Widget.Widget_cachedSpriteMasks.clear();
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
		Script.Script_cached.clear();
		ClientPacket.archive0.clearFiles();
		ItemDefinition.archive1.clearFiles();
		WorldMapData_1.archive3.clearFiles();
		FloorDecoration.archive4.clearFiles();
		AbstractWorldMapData.archive5.clearFiles();
		GrandExchangeOfferWorldComparator.archive6.clearFiles();
		MouseRecorder.archive7.clearFiles();
		class3.archive8.clearFiles();
		WorldMapManager.archive9.clearFiles();
		ServerBuild.archive10.clearFiles();
		class48.archive11.clearFiles();
		SoundSystem.archive12.clearFiles();
	}
}
