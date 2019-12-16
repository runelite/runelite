import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1160137245
	)
	@Export("oldZ")
	int oldZ;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1904283883
	)
	@Export("newZ")
	int newZ;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -314575009
	)
	@Export("oldX")
	int oldX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 2112889933
	)
	@Export("oldY")
	int oldY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -792611751
	)
	@Export("newX")
	int newX;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -575856113
	)
	@Export("newY")
	int newY;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1539446875
	)
	@Export("oldChunkXLow")
	int oldChunkXLow;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1657391795
	)
	@Export("oldChunkYLow")
	int oldChunkYLow;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 442819299
	)
	@Export("oldChunkXHigh")
	int oldChunkXHigh;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1953687417
	)
	@Export("oldChunkYHigh")
	int oldChunkYHigh;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1951120751
	)
	@Export("newChunkXLow")
	int newChunkXLow;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -940095865
	)
	@Export("newChunkYLow")
	int newChunkYLow;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -777745283
	)
	@Export("newChunkXHigh")
	int newChunkXHigh;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -733068917
	)
	@Export("newChunkYHigh")
	int newChunkYHigh;

	WorldMapSection0() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Laa;I)V",
		garbageValue = "515570621"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}

		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}

		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}

		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "2033433479"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.oldZ + this.newZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "-66"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1684413985"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.newX * 64 - this.oldX * 64 + var2 + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
			return var4;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)Lht;",
		garbageValue = "21"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = this.oldY * 64 - this.newY * 64 + var2 + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkq;B)V",
		garbageValue = "74"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.oldZ = var1.readUnsignedByte();
		this.newZ = var1.readUnsignedByte();
		this.oldX = var1.readUnsignedShort();
		this.oldChunkXLow = var1.readUnsignedByte();
		this.oldChunkXHigh = var1.readUnsignedByte();
		this.oldY = var1.readUnsignedShort();
		this.oldChunkYLow = var1.readUnsignedByte();
		this.oldChunkYHigh = var1.readUnsignedByte();
		this.newX = var1.readUnsignedShort();
		this.newChunkXLow = var1.readUnsignedByte();
		this.newChunkXHigh = var1.readUnsignedByte();
		this.newY = var1.readUnsignedShort();
		this.newChunkYLow = var1.readUnsignedByte();
		this.newChunkYHigh = var1.readUnsignedByte();
		this.postRead();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1568210913"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)Liv;",
		garbageValue = "-25"
	)
	@Export("SequenceDefinition_get")
	public static SequenceDefinition SequenceDefinition_get(int var0) {
		SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SequenceDefinition.SequenceDefinition_archive.takeFile(12, var0);
			var1 = new SequenceDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			SequenceDefinition.SequenceDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "806992568"
	)
	@Export("Messages_getNextChatID")
	static int Messages_getNextChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
		}
	}

	@ObfuscatedName("kb")
	@ObfuscatedSignature(
		signature = "(Lha;I)I",
		garbageValue = "452244252"
	)
	@Export("getWidgetClickMask")
	static int getWidgetClickMask(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.get((long)var0.childIndex + ((long)var0.id << 32));
		return var1 != null ? var1.integer : var0.clickMask;
	}
}
