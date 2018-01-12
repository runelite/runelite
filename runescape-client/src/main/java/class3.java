import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class3 implements class0 {
   @ObfuscatedName("lw")
   @ObfuscatedSignature(
      signature = "[Lhz;"
   )
   static Widget[] field17;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("rssocket")
   static AbstractSocket rssocket;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      longValue = -4249044884305654605L
   )
   static long field19;
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "101"
   )
   static final int method7(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(Lcw;III)V",
      garbageValue = "-1209857073"
   )
   static final void method6(ContextMenuRow var0, int var1, int var2) {
      class27.menuAction(var0.param0, var0.param1, var0.type, var0.identifier, var0.option, var0.option, var1, var2);
   }
}
