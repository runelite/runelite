import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("eg")
	@ObfuscatedGetter(
		intValue = -1555084527
	)
	@Export("port2")
	static int port2;
	@ObfuscatedName("z")
	final int field3723;
	@ObfuscatedName("n")
	final int field3740;
	@ObfuscatedName("v")
	final int field3749;
	@ObfuscatedName("u")
	final int field3729;
	@ObfuscatedName("r")
	final int field3717;
	@ObfuscatedName("p")
	final int field3730;
	@ObfuscatedName("q")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1460237959
	)
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 19255173
	)
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("i")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 577933795
	)
	@Export("next_out")
	int next_out;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1492713953
	)
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1053795843
	)
	int field3713;
	@ObfuscatedName("a")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 423882031
	)
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1870654053
	)
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 2034972657
	)
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1804549120
	)
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -2121773995
	)
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1375440771
	)
	int field3732;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1764835615
	)
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("f")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1747033841
	)
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("d")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1244375945
	)
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("ac")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("az")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("aw")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("aa")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("ap")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("ar")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("ab")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("ax")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("as")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("ao")
	@Export("base")
	int[][] base;
	@ObfuscatedName("al")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("ad")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 648150601
	)
	int field3750;

	BZip2State() {
		this.field3723 = 4096;
		this.field3740 = 16;
		this.field3749 = 258;
		this.field3729 = 6;
		this.field3717 = 50;
		this.field3730 = 18002;
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)[Lkc;",
		garbageValue = "-127"
	)
	@Export("ChatMode_values")
	static PrivateChatMode[] ChatMode_values() {
		return new PrivateChatMode[]{PrivateChatMode.field3792, PrivateChatMode.field3790, PrivateChatMode.field3791};
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "157596925"
	)
	static boolean method5703(int var0) {
		return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
	}
}
