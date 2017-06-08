import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -383907761
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 970908259
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -854934929
   )
   @Export("z")
   int z;
   @ObfuscatedName("rn")
   static RenderOverview field2146;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "2"
   )
   static int method2877(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class278.field3737:class37.field515;
      if(var0 == 1600) {
         class83.intStack[++class165.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class83.intStack[++class165.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class83.intStack[++class165.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class83.intStack[++class165.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class83.intStack[++class165.intStackSize - 1] = var3.field2706;
         return 1;
      } else if(var0 == 1606) {
         class83.intStack[++class165.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class83.intStack[++class165.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class83.intStack[++class165.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class83.intStack[++class165.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class83.intStack[++class165.intStackSize - 1] = var3.field2684;
         return 1;
      } else if(var0 == 1611) {
         class83.intStack[++class165.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class83.intStack[++class165.intStackSize - 1] = var3.field2775;
         return 1;
      } else if(var0 == 1613) {
         class83.intStack[++class165.intStackSize - 1] = var3.field2668.vmethod5059();
         return 1;
      } else {
         return 2;
      }
   }
}
