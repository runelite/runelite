import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("nk")
   static boolean field1924;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -768024325
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 274996345
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -465437921
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1538420145
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1774275935
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("h")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 753608039
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "2099731363"
   )
   static int method2879(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class223.field2643:class80.field1228;
      if(var0 == 1700) {
         class80.intStack[++class80.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class80.intStack[++class80.intStackSize - 1] = var3.itemQuantity;
         } else {
            class80.intStack[++class80.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class80.intStack[++class80.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }
}
