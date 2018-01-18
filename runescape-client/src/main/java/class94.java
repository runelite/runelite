import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class94 {
   @ObfuscatedName("y")
   static byte[] field1402;
   @ObfuscatedName("r")
   static byte[] field1401;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lgv;"
   )
   static Buffer[] field1404;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1231789495
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("s")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1715869373
   )
   static int field1407;
   @ObfuscatedName("e")
   static int[] field1412;
   @ObfuscatedName("f")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("z")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("u")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1787872137
   )
   static int field1403;
   @ObfuscatedName("w")
   static int[] field1413;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static Buffer field1414;

   static {
      field1402 = new byte[2048];
      field1401 = new byte[2048];
      field1404 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1407 = 0;
      field1412 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1403 = 0;
      field1413 = new int[2048];
      field1414 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lch;Lch;IZIZI)I",
      garbageValue = "1411960756"
   )
   static int method1810(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = ISAACCipher.method3647(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = ISAACCipher.method3647(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
