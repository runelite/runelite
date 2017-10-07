import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -1657021603
   )
   static int field2023;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   static Buffer field2033;
   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field2031;
   @ObfuscatedName("s")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 65172699
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -532987485
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 653241741
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1056120709
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1068316985
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1604457903
   )
   @Export("texture")
   int texture;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "111"
   )
   static final int method2753(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
