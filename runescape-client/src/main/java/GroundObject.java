import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("l")
   static int[] field1751;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1770782577
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -785254195
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -132681551
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1572616039
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 870625945
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Llm;",
      garbageValue = "-2020140536"
   )
   static SpritePixels method2684() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class323.field3913;
      var0.maxHeight = class323.field3915;
      var0.offsetX = TotalQuantityComparator.field281[0];
      var0.offsetY = FileSystem.offsetsY[0];
      var0.width = BaseVarType.field28[0];
      var0.height = field1751[0];
      int var1 = var0.width * var0.height;
      byte[] var2 = class323.spritePixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class323.field3912[var2[var3] & 255];
      }

      class152.method3133();
      return var0;
   }
}
