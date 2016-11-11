import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public final class class16 extends Node {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -789206533
   )
   int field241;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1404058153
   )
   int field242 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1394812191
   )
   int field243;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1408320669
   )
   int field244 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 654066187
   )
   int field246;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -17739123
   )
   int field247;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1883847399
   )
   int field248;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -421829427
   )
   int field249;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1906577479
   )
   int field250;
   @ObfuscatedName("dg")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 400766893
   )
   int field252;
   @ObfuscatedName("at")
   static ModIcon[] field254;
   @ObfuscatedName("c")
   public static Buffer field255;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2130971575
   )
   int field257;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1016370717
   )
   int field260;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1831131280"
   )
   public static void method190() {
      ObjectComposition.field967.reset();
      ObjectComposition.field947.reset();
      ObjectComposition.field948.reset();
      ObjectComposition.field979.reset();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-879093231"
   )
   static final int method191(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class5.tileHeights[var5][var3][var4] * (128 - var6) + class5.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = (128 - var6) * class5.tileHeights[var5][var3][1 + var4] + class5.tileHeights[var5][var3 + 1][var4 + 1] * var6 >> 7;
         return var9 * var7 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1755184541"
   )
   static final void method192() {
      Client.field378.method2801(129);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3815(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3816()) {
         if(var0.field70 == 0 || var0.field70 == 3) {
            class187.method3741(var0, true);
         }
      }

      if(null != Client.field464) {
         class32.method673(Client.field464);
         Client.field464 = null;
      }

   }
}
