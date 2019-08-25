import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("q")
	final int field3748;
	@ObfuscatedName("w")
	final int field3743;
	@ObfuscatedName("e")
	final int field3779;
	@ObfuscatedName("p")
	final int field3778;
	@ObfuscatedName("k")
	final int field3745;
	@ObfuscatedName("l")
	final int field3746;
	@ObfuscatedName("b")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1049906743
	)
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1743451477
	)
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("f")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1528977191
	)
	@Export("next_out")
	int next_out;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1616991267
	)
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1607838751
	)
	int field3753;
	@ObfuscatedName("r")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 236002095
	)
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 145021143
	)
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 964245035
	)
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 738319360
	)
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 826030823
	)
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -300117779
	)
	int field3760;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -284126821
	)
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("o")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -485705465
	)
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("d")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 386581291
	)
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("al")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("av")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("as")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("aw")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("ad")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("ag")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("ar")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("ax")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("az")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("ae")
	@Export("base")
	int[][] base;
	@ObfuscatedName("ao")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("aj")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -590888097
	)
	int field3776;

	BZip2State() {
		this.field3748 = 4096;
		this.field3743 = 16;
		this.field3779 = 258;
		this.field3778 = 6;
		this.field3745 = 50;
		this.field3746 = 18002;
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

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;IIB)Lky;",
		garbageValue = "10"
	)
	@Export("newBufferedNetSocket")
	public static AbstractSocket newBufferedNetSocket(Socket var0, int var1, int var2) throws IOException {
		return new BufferedNetSocket(var0, var1, var2);
	}
}
