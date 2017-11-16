import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class94 {
   @ObfuscatedName("r")
   static byte[] field1397;
   @ObfuscatedName("g")
   static byte[] field1398;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lfs;"
   )
   static Buffer[] field1408;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -989275685
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("u")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1590883479
   )
   static int field1402;
   @ObfuscatedName("k")
   static int[] field1403;
   @ObfuscatedName("n")
   static int[] field1404;
   @ObfuscatedName("d")
   static int[] field1395;
   @ObfuscatedName("o")
   static int[] field1409;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -725261631
   )
   static int field1407;
   @ObfuscatedName("q")
   static int[] field1405;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   static Buffer field1399;

   static {
      field1397 = new byte[2048];
      field1398 = new byte[2048];
      field1408 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1402 = 0;
      field1403 = new int[2048];
      field1404 = new int[2048];
      field1395 = new int[2048];
      field1409 = new int[2048];
      field1407 = 0;
      field1405 = new int[2048];
      field1399 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-510547822"
   )
   static final void method1754(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class175.field2440[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
