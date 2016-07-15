import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class138 {
   @ObfuscatedName("a")
   public static int[] field2134;
   @ObfuscatedName("e")
   public static boolean field2135 = false;
   @ObfuscatedName("c")
   static Hashtable field2138 = new Hashtable(16);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lclass81;",
      garbageValue = "1273599519"
   )
   static class81[] method2990() {
      class81[] var0 = new class81[class79.field1450];

      for(int var1 = 0; var1 < class79.field1450; ++var1) {
         class81 var2 = var0[var1] = new class81();
         var2.field1471 = class79.field1458;
         var2.field1469 = class79.field1452;
         var2.field1468 = class79.field1449[var1];
         var2.field1475 = class11.field192[var1];
         var2.field1466 = field2134[var1];
         var2.field1467 = class169.field2703[var1];
         int var3 = var2.field1467 * var2.field1466;
         byte[] var4 = class93.field1626[var1];
         var2.field1476 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1476[var5] = class178.field2941[var4[var5] & 255];
         }
      }

      class52.method1134();
      return var0;
   }
}
