import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cx")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -20191173
   )
   int field1713;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -10950393
   )
   int field1714;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -914056393
   )
   int field1715;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1017372741
   )
   int field1717;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -2143898817
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("mi")
   static byte field1722;

   VertexNormal(VertexNormal var1) {
      this.field1717 = var1.field1717;
      this.field1714 = var1.field1714;
      this.field1715 = var1.field1715;
      this.field1713 = var1.field1713;
   }

   VertexNormal() {
   }
}
