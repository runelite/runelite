import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lk")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("x")
	final int field3756;
	@ObfuscatedName("m")
	final int field3725;
	@ObfuscatedName("k")
	final int field3726;
	@ObfuscatedName("d")
	final int field3729;
	@ObfuscatedName("w")
	final int field3750;
	@ObfuscatedName("v")
	final int field3737;
	@ObfuscatedName("q")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1520658841
	)
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1705468259
	)
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("e")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -530026491
	)
	@Export("next_out")
	int next_out;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1793031375
	)
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 828020907
	)
	int field3724;
	@ObfuscatedName("u")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1550283393
	)
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 2097262377
	)
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1241583147
	)
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("a")
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1768899761
	)
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -2111080359
	)
	int field3743;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -125465233
	)
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("o")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1422716731
	)
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("j")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1484476187
	)
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("ae")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("an")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("ai")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("ap")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("ab")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("ar")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("af")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("at")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("al")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("as")
	@Export("base")
	int[][] base;
	@ObfuscatedName("am")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("au")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -453266259
	)
	int field3761;

	BZip2State() {
		this.field3756 = 4096;
		this.field3725 = 16;
		this.field3726 = 258;
		this.field3729 = 6;
		this.field3750 = 50;
		this.field3737 = 18002;
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
