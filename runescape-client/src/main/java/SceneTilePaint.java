import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 618716109
   )
   int field2047;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1458413775
   )
   int field2049;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -78544361
   )
   int field2050;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 102543291
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("r")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1567608003
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 267379915
   )
   int field2055;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.field2050 = var1;
      this.field2055 = var2;
      this.field2049 = var3;
      this.field2047 = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }
}
