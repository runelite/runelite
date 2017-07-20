import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("fd")
   static byte[][] field2003;
   @ObfuscatedName("m")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 647942793
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1074758273
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1524711411
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -356868279
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1468905647
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1228279237
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "24518772"
   )
   public static boolean method2613(int var0) {
      return var0 >= class221.field2789.field2803 && var0 <= class221.field2790.field2803 || var0 == class221.field2798.field2803;
   }
}
