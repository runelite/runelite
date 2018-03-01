import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "[Lly;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -285937701
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1423085943
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -169512049
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 861076061
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1458760645
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("y")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1176862301
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "782107841"
   )
   static final void method2930(String var0) {
      class243.method4617(var0 + " is already on your ignore list");
   }
}
