import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class238 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   public static RSSocket field3255;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 175288755
   )
   public static int field3245;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -6446435534470100275L
   )
   public static long field3258;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static HashTable field3247;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1570656921
   )
   public static int field3248;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static HashTable field3244;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1826581109
   )
   public static int field3250;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   public static Node2LinkedList field3261;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static HashTable field3252;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -135001399
   )
   public static int field3253;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static HashTable field3254;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -285986479
   )
   public static int field3259;
   @ObfuscatedName("u")
   static boolean field3256;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   public static Buffer field3246;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -452708239
   )
   public static int field3251;
   @ObfuscatedName("j")
   static CRC32 field3265;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lih;"
   )
   static IndexData[] field3260;
   @ObfuscatedName("c")
   public static byte field3262;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -502064433
   )
   public static int field3263;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1572068145
   )
   public static int field3264;

   static {
      field3245 = 0;
      field3247 = new HashTable(4096);
      field3248 = 0;
      field3244 = new HashTable(32);
      field3250 = 0;
      field3261 = new Node2LinkedList();
      field3252 = new HashTable(4096);
      field3253 = 0;
      field3254 = new HashTable(4096);
      field3259 = 0;
      field3246 = new Buffer(8);
      field3251 = 0;
      field3265 = new CRC32();
      field3260 = new IndexData[256];
      field3262 = 0;
      field3263 = 0;
      field3264 = 0;
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "332986610"
   )
   static final void method4334(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var12 * var9 - var11 * var5 >> 16;
         var10 = var11 * var9 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var10 * var11 + var8 * var12 >> 16;
         var10 = var12 * var10 - var11 * var8 >> 16;
         var8 = var13;
      }

      AbstractByteBuffer.cameraX = var0 - var8;
      class229.cameraZ = var1 - var9;
      World.cameraY = var2 - var10;
      class18.cameraPitch = var3;
      CombatInfo1.cameraYaw = var4;
   }
}
