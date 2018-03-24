import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -66107763
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2115920509
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1873915047
   )
   @Export("z")
   int z;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -117213315
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lee;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Lap;",
      garbageValue = "-1411881696"
   )
   static class33 method2776(int var0, int var1) {
      class213 var2 = WorldMapRegion.field462;
      long var3 = (long)(0 | var0 << 8 | var1);
      return (class33)var2.method3951(var3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2137282322"
   )
   static final int method2775(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
