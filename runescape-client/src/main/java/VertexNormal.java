import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ci")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1456286731
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1403269607
   )
   @Export("z")
   int z;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1156152927
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -65604697
   )
   static int field1406;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2064462669
   )
   @Export("x")
   int x;

   VertexNormal() {
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }
}
