import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("c")
	final int field3736;
	@ObfuscatedName("t")
	final int field3718;
	@ObfuscatedName("o")
	final int field3748;
	@ObfuscatedName("e")
	final int field3720;
	@ObfuscatedName("i")
	final int field3717;
	@ObfuscatedName("g")
	final int field3722;
	@ObfuscatedName("d")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -807035473
	)
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1509070377
	)
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("m")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -902711531
	)
	@Export("next_out")
	int next_out;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1633057799
	)
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 135980565
	)
	int field3729;
	@ObfuscatedName("n")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1481212591
	)
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -29854091
	)
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -725667235
	)
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1401293824
	)
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2006117845
	)
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1496152105
	)
	int field3746;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2017789723
	)
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("b")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -2065710979
	)
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("s")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -402806649
	)
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("ae")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("af")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("az")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("ax")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("aj")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("au")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("ay")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("aa")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("aq")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("as")
	@Export("base")
	int[][] base;
	@ObfuscatedName("ak")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("ac")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1642554811
	)
	int field3754;

	BZip2State() {
		this.field3736 = 4096;
		this.field3718 = 16;
		this.field3748 = 258;
		this.field3720 = 6;
		this.field3717 = 50;
		this.field3722 = 18002;
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

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IB)V",
		garbageValue = "84"
	)
	static final void method5833(String var0, int var1) {
		PacketBufferNode var2 = TilePaint.getPacketBufferNode(ClientPacket.field2265, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var0) + 1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		var2.packetBuffer.method5603(var1);
		Client.packetWriter.addNode(var2);
	}
}
