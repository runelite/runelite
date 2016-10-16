import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1442988655
   )
   int field1667;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1459596207
   )
   int field1668;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 841135403
   )
   int field1670;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1617597675
   )
   int field1675;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1459395878"
   )
   public static void method2177() {
      try {
         if(class186.field3002 == 1) {
            int var0 = class186.field3007.method3582();
            if(var0 > 0 && class186.field3007.method3588()) {
               var0 -= class153.field2283;
               if(var0 < 0) {
                  var0 = 0;
               }

               class186.field3007.method3617(var0);
               return;
            }

            class186.field3007.method3587();
            class186.field3007.method3662();
            if(null != XItemContainer.field200) {
               class186.field3002 = 2;
            } else {
               class186.field3002 = 0;
            }

            class132.field2090 = null;
            class130.field2083 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class186.field3007.method3587();
         class186.field3002 = 0;
         class132.field2090 = null;
         class130.field2083 = null;
         XItemContainer.field200 = null;
      }

   }

   VertexNormal(VertexNormal var1) {
      this.field1675 = var1.field1675;
      this.field1667 = var1.field1667;
      this.field1668 = var1.field1668;
      this.field1670 = var1.field1670;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[Lclass85;",
      garbageValue = "99"
   )
   public static class85[] method2178() {
      return new class85[]{class85.field1474, class85.field1471, class85.field1469, class85.field1476, class85.field1468};
   }

   VertexNormal() {
   }
}
