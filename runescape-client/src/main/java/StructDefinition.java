import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("StructDefinition")
public class StructDefinition extends DualNode {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("StructDefinition_archive")
	static AbstractArchive StructDefinition_archive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("StructDefinition_cached")
	static EvictingDualNodeHashTable StructDefinition_cached;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lbd;"
	)
	@Export("loginScreenRunesAnimation")
	static LoginScreenAnimation loginScreenRunesAnimation;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		StructDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	StructDefinition() {
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1694399537"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "-1313087587"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkq;IB)V",
		garbageValue = "2"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 249) {
			this.params = Calendar.readStringIntParameters(var1, this.params);
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "445815336"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return class83.method2071(this.params, var1, var2);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-8"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return class14.method151(this.params, var1, var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
		garbageValue = "1595091169"
	)
	public static String method4551(CharSequence var0) {
		return UserComparator6.method3370('*', var0.length());
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "0"
	)
	static final boolean method4546(int var0, int var1) {
		ObjectDefinition var2 = Coord.getObjectDefinition(var0);
		if (var1 == 11) {
			var1 = 10;
		}

		if (var1 >= 5 && var1 <= 8) {
			var1 = 4;
		}

		return var2.method4616(var1);
	}

	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "363580597"
	)
	static final void method4529() {
		int var0 = SequenceDefinition.field3477 * 128 + 64;
		int var1 = AbstractWorldMapData.field147 * 128 + 64;
		int var2 = ScriptEvent.getTileHeight(var0, var1, UrlRequest.Client_plane) - Canvas.field397;
		if (MusicPatchNode2.cameraX < var0) {
			MusicPatchNode2.cameraX = (var0 - MusicPatchNode2.cameraX) * WorldMapData_0.field92 / 1000 + MusicPatchNode2.cameraX + HitSplatDefinition.field3312;
			if (MusicPatchNode2.cameraX > var0) {
				MusicPatchNode2.cameraX = var0;
			}
		}

		if (MusicPatchNode2.cameraX > var0) {
			MusicPatchNode2.cameraX -= WorldMapData_0.field92 * (MusicPatchNode2.cameraX - var0) / 1000 + HitSplatDefinition.field3312;
			if (MusicPatchNode2.cameraX < var0) {
				MusicPatchNode2.cameraX = var0;
			}
		}

		if (class60.cameraY < var2) {
			class60.cameraY = (var2 - class60.cameraY) * WorldMapData_0.field92 / 1000 + class60.cameraY + HitSplatDefinition.field3312;
			if (class60.cameraY > var2) {
				class60.cameraY = var2;
			}
		}

		if (class60.cameraY > var2) {
			class60.cameraY -= WorldMapData_0.field92 * (class60.cameraY - var2) / 1000 + HitSplatDefinition.field3312;
			if (class60.cameraY < var2) {
				class60.cameraY = var2;
			}
		}

		if (UserComparator9.cameraZ < var1) {
			UserComparator9.cameraZ = (var1 - UserComparator9.cameraZ) * WorldMapData_0.field92 / 1000 + UserComparator9.cameraZ + HitSplatDefinition.field3312;
			if (UserComparator9.cameraZ > var1) {
				UserComparator9.cameraZ = var1;
			}
		}

		if (UserComparator9.cameraZ > var1) {
			UserComparator9.cameraZ -= WorldMapData_0.field92 * (UserComparator9.cameraZ - var1) / 1000 + HitSplatDefinition.field3312;
			if (UserComparator9.cameraZ < var1) {
				UserComparator9.cameraZ = var1;
			}
		}

		var0 = class80.field1111 * 128 + 64;
		var1 = Ignored.field3589 * 16384 + 64;
		var2 = ScriptEvent.getTileHeight(var0, var1, UrlRequest.Client_plane) - Client.field873;
		int var3 = var0 - MusicPatchNode2.cameraX;
		int var4 = var2 - class60.cameraY;
		int var5 = var1 - UserComparator9.cameraZ;
		int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
		int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
		int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
		if (var7 < 128) {
			var7 = 128;
		}

		if (var7 > 383) {
			var7 = 383;
		}

		if (ViewportMouse.cameraPitch < var7) {
			ViewportMouse.cameraPitch = (var7 - ViewportMouse.cameraPitch) * GrandExchangeOfferOwnWorldComparator.field623 / 1000 + ViewportMouse.cameraPitch + PacketBufferNode.field2310;
			if (ViewportMouse.cameraPitch > var7) {
				ViewportMouse.cameraPitch = var7;
			}
		}

		if (ViewportMouse.cameraPitch > var7) {
			ViewportMouse.cameraPitch -= GrandExchangeOfferOwnWorldComparator.field623 * (ViewportMouse.cameraPitch - var7) / 1000 + PacketBufferNode.field2310;
			if (ViewportMouse.cameraPitch < var7) {
				ViewportMouse.cameraPitch = var7;
			}
		}

		int var9 = var8 - WorldMapLabelSize.cameraYaw;
		if (var9 > 1024) {
			var9 -= 2048;
		}

		if (var9 < -1024) {
			var9 += 2048;
		}

		if (var9 > 0) {
			WorldMapLabelSize.cameraYaw = WorldMapLabelSize.cameraYaw + PacketBufferNode.field2310 + var9 * GrandExchangeOfferOwnWorldComparator.field623 / 1000;
			WorldMapLabelSize.cameraYaw &= 2047;
		}

		if (var9 < 0) {
			WorldMapLabelSize.cameraYaw -= PacketBufferNode.field2310 + -var9 * GrandExchangeOfferOwnWorldComparator.field623 / 1000;
			WorldMapLabelSize.cameraYaw &= 2047;
		}

		int var10 = var8 - WorldMapLabelSize.cameraYaw;
		if (var10 > 1024) {
			var10 -= 2048;
		}

		if (var10 < -1024) {
			var10 += 2048;
		}

		if (var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
			WorldMapLabelSize.cameraYaw = var8;
		}

	}
}
