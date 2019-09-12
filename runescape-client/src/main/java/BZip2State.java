import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ki")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("c")
	final int field3717;
	@ObfuscatedName("x")
	final int field3709;
	@ObfuscatedName("t")
	final int field3715;
	@ObfuscatedName("g")
	final int field3712;
	@ObfuscatedName("l")
	final int field3737;
	@ObfuscatedName("u")
	final int field3731;
	@ObfuscatedName("j")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1785442725
	)
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1327133653
	)
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("z")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1502043783
	)
	@Export("next_out")
	int next_out;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1076780583
	)
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -2062863895
	)
	int field3740;
	@ObfuscatedName("s")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -424992051
	)
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2124513987
	)
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 225690987
	)
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 813800448
	)
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1074633139
	)
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1279441131
	)
	int field3725;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1234783121
	)
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("w")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -147337203
	)
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("o")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1493034079
	)
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("ag")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("at")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("ao")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("av")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("an")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("al")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("as")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("ad")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("ap")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("ax")
	@Export("base")
	int[][] base;
	@ObfuscatedName("aj")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("ab")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -864562359
	)
	int field3710;

	BZip2State() {
		this.field3717 = 4096;
		this.field3709 = 16;
		this.field3715 = 258;
		this.field3712 = 6;
		this.field3737 = 50;
		this.field3731 = 18002;
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
}
