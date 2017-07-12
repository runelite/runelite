import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1875962745
   )
   @Export("z")
   int z;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1871515527
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1826977823
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1333091505
   )
   @Export("magnitude")
   int magnitude;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1806394361"
   )
   public static void method2580() {
      FloorUnderlayDefinition.underlays.reset();
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   VertexNormal() {
   }
}
