import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1804956373
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1850410701
   )
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -550968221
   )
   @Export("z")
   int z;
   @ObfuscatedName("cb")
   public static char field1424;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -726617637
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-17"
   )
   public static void method1627(int var0) {
      if(class138.field1921 != 0) {
         class105.field1721 = var0;
      } else {
         class138.field1920.method2507(var0);
      }

   }
}
