import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -1853673167
   )
   static int field2152;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1748972165
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -224100975
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -605170993
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -913038811
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 33614573
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -407693163
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1858221351
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1253309511
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -382753515
   )
   @Export("rotation")
   int rotation;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-14360"
   )
   public static int method2920(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(IIB)Ljava/lang/String;",
      garbageValue = "-125"
   )
   static final String method2921(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?CacheFile.getColTags(16711680):(var2 < -6?CacheFile.getColTags(16723968):(var2 < -3?CacheFile.getColTags(16740352):(var2 < 0?CacheFile.getColTags(16756736):(var2 > 9?CacheFile.getColTags('\uff00'):(var2 > 6?CacheFile.getColTags(4259584):(var2 > 3?CacheFile.getColTags(8453888):(var2 > 0?CacheFile.getColTags(12648192):CacheFile.getColTags(16776960))))))));
   }
}
