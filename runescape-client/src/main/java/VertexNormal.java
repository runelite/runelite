import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cd")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 575764791
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1700708603
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1643375369
   )
   @Export("z")
   int z;
   @ObfuscatedName("bh")
   static class184 field1425;
   @ObfuscatedName("ar")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2022247301
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }
}
