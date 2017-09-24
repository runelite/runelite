import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 143155435
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 294846737
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1152417143
   )
   @Export("type")
   int type;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -682756227
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1950958799
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1565475853
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 7760047
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 969211677
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 146135063
   )
   int field2157;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2019152701
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1785571233
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1148936797
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2041927513
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 650126015
   )
   int field2158;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2018133093
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -519994231
   )
   @Export("maxNormalY")
   int maxNormalY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1609353075
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -856900641
   )
   @Export("maxTIleX")
   int maxTIleX;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "24230659"
   )
   public static int method2940(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)Ljm;",
      garbageValue = "-2010491973"
   )
   static Font method2939(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class271.field3679, class18.offsetsY, class287.field3796, class245.field3324, Varbit.field3387, class274.spritePixels);
         Buffer.method3330();
         return var1;
      }
   }
}
