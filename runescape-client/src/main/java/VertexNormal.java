import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("e")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1567833451
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1486411121
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 290083451
   )
   @Export("z")
   int z;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 679348509
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lep;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }
}
