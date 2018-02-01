import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("fr")
   @Export("landMapFileIds")
   static int[] landMapFileIds;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1919970823
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1037053579
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 728831033
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1500459243
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1642698177
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1479182451
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("a")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -300662545
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1544951906"
   )
   static final void method2808(String var0) {
      class63.method1054(var0 + " is already on your friend list");
   }
}
