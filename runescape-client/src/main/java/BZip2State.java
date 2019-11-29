import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ko")
@Implements("BZip2State")
public final class BZip2State {
	@ObfuscatedName("u")
	final int field3731;
	@ObfuscatedName("f")
	final int field3720;
	@ObfuscatedName("b")
	final int field3733;
	@ObfuscatedName("g")
	final int field3722;
	@ObfuscatedName("z")
	final int field3723;
	@ObfuscatedName("p")
	final int field3724;
	@ObfuscatedName("h")
	@Export("inputArray")
	byte[] inputArray;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 2112153425
	)
	@Export("nextByte")
	int nextByte;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -604029507
	)
	@Export("nextBit_unused")
	int nextBit_unused;
	@ObfuscatedName("i")
	@Export("outputArray")
	byte[] outputArray;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 101751211
	)
	@Export("next_out")
	int next_out;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1229248277
	)
	@Export("outputLength")
	int outputLength;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1913236213
	)
	int field3742;
	@ObfuscatedName("e")
	@Export("out_char")
	byte out_char;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -975314591
	)
	@Export("su_rNToGo")
	int su_rNToGo;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 843438185
	)
	@Export("bsBuff")
	int bsBuff;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1790725095
	)
	@Export("bsLive")
	int bsLive;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 2072280064
	)
	@Export("blockSize100k")
	int blockSize100k;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -233574369
	)
	@Export("originalPointer")
	int originalPointer;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 396288217
	)
	int field3738;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1359010819
	)
	@Export("su_ch2")
	int su_ch2;
	@ObfuscatedName("m")
	@Export("unzftab")
	int[] unzftab;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -197163901
	)
	@Export("nblocks_used")
	int nblocks_used;
	@ObfuscatedName("q")
	@Export("cftab")
	int[] cftab;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1651646591
	)
	@Export("nInUse")
	int nInUse;
	@ObfuscatedName("af")
	@Export("inUse")
	boolean[] inUse;
	@ObfuscatedName("ad")
	@Export("inUse16")
	boolean[] inUse16;
	@ObfuscatedName("am")
	@Export("seqToUnseq")
	byte[] seqToUnseq;
	@ObfuscatedName("ai")
	@Export("ll8")
	byte[] ll8;
	@ObfuscatedName("ag")
	@Export("getAndMoveToFrontDecode_yy")
	int[] getAndMoveToFrontDecode_yy;
	@ObfuscatedName("ao")
	@Export("selector")
	byte[] selector;
	@ObfuscatedName("aw")
	@Export("selectorMtf")
	byte[] selectorMtf;
	@ObfuscatedName("ak")
	@Export("temp_charArray2d")
	byte[][] temp_charArray2d;
	@ObfuscatedName("aa")
	@Export("limit")
	int[][] limit;
	@ObfuscatedName("ab")
	@Export("base")
	int[][] base;
	@ObfuscatedName("ar")
	@Export("perm")
	int[][] perm;
	@ObfuscatedName("av")
	@Export("minLens")
	int[] minLens;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1771574853
	)
	int field3756;

	BZip2State() {
		this.field3731 = 4096;
		this.field3720 = 16;
		this.field3733 = 258;
		this.field3722 = 6;
		this.field3723 = 50;
		this.field3724 = 18002;
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
		signature = "(Lhf;Ljava/lang/String;Ljava/lang/String;I)Llm;",
		garbageValue = "-972225948"
	)
	@Export("SpriteBuffer_getIndexedSpriteByName")
	public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		return UserComparator6.method3491(var0, var3, var4);
	}
}
