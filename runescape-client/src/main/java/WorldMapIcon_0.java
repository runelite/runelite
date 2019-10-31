import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("WorldMapIcon_0")
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 445280929
	)
	@Export("element")
	final int element;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lar;"
	)
	@Export("label")
	final WorldMapLabel label;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 106254271
	)
	@Export("subWidth")
	final int subWidth;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1418810221
	)
	@Export("subHeight")
	final int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;ILar;)V"
	)
	WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
		super(var1, var2);
		this.element = var3;
		this.label = var4;
		WorldMapElement var5 = class65.WorldMapElement_get(this.getElement());
		Sprite var6 = var5.getSpriteBool(false);
		if (var6 != null) {
			this.subWidth = var6.subWidth;
			this.subHeight = var6.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1878632225"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lar;",
		garbageValue = "-77909992"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "60677286"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-92"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "([BB)Lcj;",
		garbageValue = "47"
	)
	@Export("newScript")
	static Script newScript(byte[] var0) {
		Script var1 = new Script();
		Buffer var2 = new Buffer(var0);
		var2.offset = var2.array.length - 2;
		int var3 = var2.readUnsignedShort();
		int var4 = var2.array.length - 2 - var3 - 12;
		var2.offset = var4;
		int var5 = var2.readInt();
		var1.localIntCount = var2.readUnsignedShort();
		var1.localStringCount = var2.readUnsignedShort();
		var1.intArgumentCount = var2.readUnsignedShort();
		var1.stringArgumentCount = var2.readUnsignedShort();
		int var6 = var2.readUnsignedByte();
		int var7;
		int var8;
		if (var6 > 0) {
			var1.switches = var1.newIterableNodeHashTable(var6);

			for (var7 = 0; var7 < var6; ++var7) {
				var8 = var2.readUnsignedShort();
				int var9;
				int var11;
				if (var8 > 0) {
					var11 = var8 - 1;
					var11 |= var11 >>> 1;
					var11 |= var11 >>> 2;
					var11 |= var11 >>> 4;
					var11 |= var11 >>> 8;
					var11 |= var11 >>> 16;
					int var10 = var11 + 1;
					var9 = var10;
				} else {
					var9 = 1;
				}

				IterableNodeHashTable var13 = new IterableNodeHashTable(var9);
				var1.switches[var7] = var13;

				while (var8-- > 0) {
					var11 = var2.readInt();
					int var12 = var2.readInt();
					var13.put(new IntegerNode(var12), (long)var11);
				}
			}
		}

		var2.offset = 0;
		var2.readStringCp1252NullTerminatedOrNull();
		var1.opcodes = new int[var5];
		var1.intOperands = new int[var5];
		var1.stringOperands = new String[var5];

		for (var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
			var8 = var2.readUnsignedShort();
			if (var8 == 3) {
				var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
			} else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
				var1.intOperands[var7] = var2.readInt();
			} else {
				var1.intOperands[var7] = var2.readUnsignedByte();
			}
		}

		return var1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILhq;IIIZB)V",
		garbageValue = "-27"
	)
	public static void method253(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		class197.field2377 = 1;
		class247.musicTrackArchive = var1;
		class189.musicTrackGroupId = var2;
		class197.musicTrackFileId = var3;
		class197.musicTrackVolume = var4;
		ScriptFrame.musicTrackBoolean = var5;
		class197.field2384 = var0;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "-50588493"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + WorldMapData_1.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "427121780"
	)
	static void method252(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}

	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		signature = "(Lhi;I)Z",
		garbageValue = "-1282406799"
	)
	static final boolean method237(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 205) {
			Client.logoutTimer = 250;
			return true;
		} else {
			int var2;
			int var3;
			if (var1 >= 300 && var1 <= 313) {
				var2 = (var1 - 300) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.changeAppearance(var2, var3 == 1);
			}

			if (var1 >= 314 && var1 <= 323) {
				var2 = (var1 - 314) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.method4156(var2, var3 == 1);
			}

			if (var1 == 324) {
				Client.playerAppearance.changeSex(false);
			}

			if (var1 == 325) {
				Client.playerAppearance.changeSex(true);
			}

			if (var1 == 326) {
				PacketBufferNode var4 = SoundSystem.getPacketBufferNode(ClientPacket.field2264, Client.packetWriter.isaacCipher);
				Client.playerAppearance.write(var4.packetBuffer);
				Client.packetWriter.addNode(var4);
				return true;
			} else {
				return false;
			}
		}
	}
}
