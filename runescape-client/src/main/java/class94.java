import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class94 {
   @ObfuscatedName("k")
   static byte[] field1412;
   @ObfuscatedName("z")
   static byte[] field1410;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lfr;"
   )
   static Buffer[] field1407;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -851335563
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("b")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -793819977
   )
   static int field1414;
   @ObfuscatedName("p")
   static int[] field1415;
   @ObfuscatedName("r")
   static int[] field1416;
   @ObfuscatedName("l")
   static int[] field1417;
   @ObfuscatedName("u")
   static int[] field1418;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1203782239
   )
   static int field1419;
   @ObfuscatedName("c")
   static int[] field1420;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   static Buffer field1421;
   @ObfuscatedName("aj")
   static Image field1408;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1117531761
   )
   static int field1409;

   static {
      field1412 = new byte[2048];
      field1410 = new byte[2048];
      field1407 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1414 = 0;
      field1415 = new int[2048];
      field1416 = new int[2048];
      field1417 = new int[2048];
      field1418 = new int[2048];
      field1419 = 0;
      field1420 = new int[2048];
      field1421 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Lgd;II)Lgd;",
      garbageValue = "388327774"
   )
   @Export("forOrdinal")
   public static class185 forOrdinal(class185[] var0, int var1) {
      class185[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class185 var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-14"
   )
   static int method1830(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class259.currentRequest != null && var2 == class259.currentRequest.hash?class245.field3335.offset * 99 / (class245.field3335.payload.length - class259.currentRequest.padding) + 1:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-389037053"
   )
   public static void method1849() {
      ObjectComposition.objects.reset();
      ObjectComposition.field3502.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3504.reset();
   }
}
