import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1676474153
   )
   static int field2027;
   @ObfuscatedName("k")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1957978079
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2026194167
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1041049003
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 368283397
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 639980995
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -589908737
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "456718783"
   )
   static int method2708(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }
}
