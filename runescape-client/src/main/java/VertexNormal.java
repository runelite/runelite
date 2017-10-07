import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 520727101
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1582269149
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1380517615
   )
   @Export("z")
   int z;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1496147457
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Les;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }
}
