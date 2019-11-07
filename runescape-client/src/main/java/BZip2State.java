import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ky")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("a")
	final int field3709;
	@ObfuscatedName("t")
	final int field3732;
	@ObfuscatedName("n")
	final int field3734;
	@ObfuscatedName("q")
	final int field3711;
	@ObfuscatedName("v")
	final int field3712;
	@ObfuscatedName("l")
	final int field3713;
	@ObfuscatedName("c")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -502427743
	)
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -561445913
	)
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("d")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -871682081
	)
	@Export("next_out")
	int next_out;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -661840641
	)
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 77506983
	)
	int field3718;
	@ObfuscatedName("k")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -250901683
	)
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 2016386947
	)
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1150627855
	)
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1637628928
	)
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1744345569
	)
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1139360211
	)
	int field3720;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -2116705151
	)
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("f")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -271375789
	)
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("w")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1457092991
	)
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("aa")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("aw")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("ar")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("aq")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("ad")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("ag")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("ak")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("av")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("am")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("ab")
	@Export("base")
	int[][] base;
	@ObfuscatedName("ax")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("al")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 1163964567
	)
	int field3745;

	BZip2State() {
		this.field3709 = 4096;
		this.field3732 = 16;
		this.field3734 = 258;
		this.field3711 = 6;
		this.field3712 = 50;
		this.field3713 = 18002;
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
