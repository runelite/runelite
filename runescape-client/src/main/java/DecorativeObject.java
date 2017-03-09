import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -346422229
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2037101791
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 183050635
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 807279593
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -34909671
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("k")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1093056229
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 378119669
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1417724195
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2062148779
   )
   @Export("offsetX")
   int offsetX;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-347293127"
   )
   public static int method1983(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
