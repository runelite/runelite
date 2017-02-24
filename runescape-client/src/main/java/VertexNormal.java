import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 204507085
   )
   @Export("x")
   int x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1018984985
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -124263277
   )
   @Export("z")
   int z;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1068500395
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("aq")
   static int[] field1443;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -1829483421
   )
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "11"
   )
   static boolean method1683(Widget var0) {
      if(Client.field505) {
         if(class196.method3614(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   VertexNormal() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "8112"
   )
   static void method1684(int var0, int var1, int var2) {
      if(Client.field479 != 0 && var1 != 0 && Client.field547 < 50) {
         Client.field548[Client.field547] = var0;
         Client.field549[Client.field547] = var1;
         Client.field550[Client.field547] = var2;
         Client.field349[Client.field547] = null;
         Client.field555[Client.field547] = 0;
         ++Client.field547;
      }

   }
}
