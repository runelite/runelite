import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("f")
	final int field3721;
	@ObfuscatedName("i")
	final int field3728;
	@ObfuscatedName("y")
	final int field3716;
	@ObfuscatedName("w")
	final int field3722;
	@ObfuscatedName("p")
	final int field3735;
	@ObfuscatedName("b")
	final int field3719;
	@ObfuscatedName("e")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -117705425
	)
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 808052371
	)
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("d")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 862638407
	)
	@Export("next_out")
	int next_out;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 982229001
	)
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1677667273
	)
	int field3726;
	@ObfuscatedName("k")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -320144157
	)
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 720575069
	)
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 846973035
	)
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1197540352
	)
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 184664593
	)
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1391220013
	)
	int field3733;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1996939641
	)
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("h")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 903678455
	)
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("g")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1381794175
	)
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("aa")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("av")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("aw")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("as")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("ak")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("au")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("ah")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("aq")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("ao")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("an")
	@Export("base")
	int[][] base;
	@ObfuscatedName("ar")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("az")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 871538763
	)
	int field3742;

	BZip2State() {
		this.field3721 = 4096;
		this.field3728 = 16;
		this.field3716 = 258;
		this.field3722 = 6;
		this.field3735 = 50;
		this.field3719 = 18002;
		this.nextByte = 0;
		this.next_out = 0;
		this.unzftab = new int[256];
		this.cftab = new int[257];
		this.inUse = new boolean[256];
		this.inUse16 = new boolean[16];
		this.seqToUnseq = new byte[256];
		this.ll8 = new byte[4096];
		this.getAndMoveToFrontDecode_yy = new int[16];
		this.selector = new byte[18002];
		this.selectorMtf = new byte[18002];
		this.temp_charArray2d = new byte[6][258];
		this.limit = new int[6][258];
		this.base = new int[6][258];
		this.perm = new int[6][258];
		this.minLens = new int[6];
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIB)Lha;",
		garbageValue = "119"
	)
	@Export("getWidgetChild")
	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = Tile.getWidget(var0);
		if (var1 == -1) {
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
		}
	}
}
