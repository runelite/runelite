import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 636280227
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1570693391
   )
   @Export("z")
   int z;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1052996541
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1396506893
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("bt")
   static ModIcon[] field1426;

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   VertexNormal() {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass139;I)Z",
      garbageValue = "778349687"
   )
   public static boolean method1591(class182 var0, class182 var1, class182 var2, class139 var3) {
      class138.field1931 = var0;
      class0.field5 = var1;
      class138.field1922 = var2;
      class138.field1923 = var3;
      return true;
   }
}
