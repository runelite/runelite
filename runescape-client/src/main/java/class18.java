import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class18 extends Node {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -698563905
   )
   int field187;
   @ObfuscatedName("c")
   boolean field188;
   @ObfuscatedName("n")
   Widget field189;
   @ObfuscatedName("v")
   String field190;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1757052415
   )
   int field191;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -322143939
   )
   int field192;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -934453075
   )
   int field193;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1821722553
   )
   static int field194;
   @ObfuscatedName("u")
   Widget field195;
   @ObfuscatedName("d")
   Object[] field196;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -757020121
   )
   int field197;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -218613445
   )
   int field198;
   @ObfuscatedName("bo")
   @Export("indexTrack1")
   static IndexData indexTrack1;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-732125067"
   )
   public static void method201(IndexDataBase var0) {
      class189.field2786 = var0;
      class189.field2783 = class189.field2786.method3305(16);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1724054196"
   )
   public static int method202(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }
}
