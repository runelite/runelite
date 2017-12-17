import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   static NodeCache field1431;
   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("w")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("e")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("k")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 475547171
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1400091303
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1243325363
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1013854573
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lgr;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1431 = new NodeCache(128);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[Lgr;",
      garbageValue = "2031854513"
   )
   IterableHashTable[] method1833(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("a")
   static final int method1842(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(0.0D != var2) {
         double var12;
         if(var4 < 0.5D) {
            var12 = (var2 + 1.0D) * var4;
         } else {
            var12 = var4 + var2 - var2 * var4;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = var0 + 0.3333333333333333D;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(6.0D * var16 < 1.0D) {
            var6 = var14 + var16 * (var12 - var14) * 6.0D;
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = (var12 - var14) * (0.6666666666666666D - var16) * 6.0D + var14;
         } else {
            var6 = var14;
         }

         if(6.0D * var0 < 1.0D) {
            var8 = var14 + 6.0D * (var12 - var14) * var0;
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = 6.0D * (0.6666666666666666D - var0) * (var12 - var14) + var14;
         } else {
            var8 = var14;
         }

         if(6.0D * var20 < 1.0D) {
            var10 = var14 + var20 * (var12 - var14) * 6.0D;
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(var20 * 3.0D < 2.0D) {
            var10 = (var12 - var14) * (0.6666666666666666D - var20) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(256.0D * var8);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }
}
