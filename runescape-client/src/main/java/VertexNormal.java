import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1712914027
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1280131315
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -26542267
   )
   @Export("z")
   int z;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -118907961
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
