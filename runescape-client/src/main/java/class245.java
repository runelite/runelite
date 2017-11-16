import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public class class245 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1722873529
   )
   static int field3307;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -8768678816557200249L
   )
   static long field3306;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static HashTable field3318;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1161646003
   )
   public static int field3308;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static HashTable field3309;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1783800711
   )
   public static int field3310;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   static Node2LinkedList field3305;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static HashTable field3313;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 563547157
   )
   public static int field3322;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static HashTable field3314;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2019867077
   )
   public static int field3315;
   @ObfuscatedName("a")
   static boolean field3316;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   static Buffer field3317;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 45414225
   )
   static int field3311;
   @ObfuscatedName("y")
   static CRC32 field3319;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Liu;"
   )
   static IndexData[] field3321;
   @ObfuscatedName("l")
   static byte field3320;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1840000377
   )
   public static int field3323;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1215444427
   )
   public static int field3324;

   static {
      field3307 = 0;
      field3318 = new HashTable(4096);
      field3308 = 0;
      field3309 = new HashTable(32);
      field3310 = 0;
      field3305 = new Node2LinkedList();
      field3313 = new HashTable(4096);
      field3322 = 0;
      field3314 = new HashTable(4096);
      field3315 = 0;
      field3317 = new Buffer(8);
      field3311 = 0;
      field3319 = new CRC32();
      field3321 = new IndexData[256];
      field3320 = 0;
      field3323 = 0;
      field3324 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lix;",
      garbageValue = "1974919335"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3378.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }
}
