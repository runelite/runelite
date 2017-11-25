import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1151718107
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 834672307
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2000917347
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 891733803
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 478219785
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("m")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1763148095
   )
   @Export("rgb")
   int rgb;

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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-1"
   )
   public static int method2795(String var0) {
      return var0.length() + 2;
   }
}
