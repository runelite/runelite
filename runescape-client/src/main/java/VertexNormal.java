import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 703595271
   )
   @Export("y")
   int y;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 988935729
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1130056623
   )
   @Export("x")
   int x;
   @ObfuscatedName("ez")
   static SpritePixels[] field1414;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -149388147
   )
   @Export("z")
   int z;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;B)I",
      garbageValue = "112"
   )
   static int method1647(PacketBuffer var0) {
      int var1 = var0.readBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.readBits(5);
      } else if(var1 == 2) {
         var2 = var0.readBits(8);
      } else {
         var2 = var0.readBits(11);
      }

      return var2;
   }

   VertexNormal() {
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }
}
