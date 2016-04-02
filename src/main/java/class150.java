import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
public final class class150 {
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 2127036755
   )
   static int field2238;

   @ObfuscatedName("w")
   static void method3147(int var0, byte[] var1, class134 var2) {
      class169 var3 = new class169();
      var3.field2703 = 0;
      var3.field3115 = (long)var0;
      var3.field2699 = var1;
      var3.field2700 = var2;
      class199 var4 = class170.field2708;
      synchronized(class170.field2708) {
         class170.field2708.method3834(var3);
      }

      Object var9 = class170.field2709;
      synchronized(class170.field2709) {
         if(0 == class170.field2707) {
            class125.field2028.method2888(new class170(), 5);
         }

         class170.field2707 = 600;
      }
   }

   @ObfuscatedName("da")
   static final void method3148(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      if(var4 != null) {
         int var6 = client.field368 + client.field350 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class91.field1568[var6];
            int var9 = class91.field1554[var6];
            var8 = 256 * var8 / (client.field352 + 256);
            var9 = 256 * var9 / (client.field352 + 256);
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var9 * var3 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method1722(var5.field2899 / 2 + var10 - var4.field1372 / 2, var5.field2897 / 2 - var11 - var4.field1376 / 2, var0, var1, var5.field2899, var5.field2897, var5.field2898, var5.field2896);
            } else {
               var4.method1709(var0 + var5.field2899 / 2 + var10 - var4.field1372 / 2, var1 + var5.field2897 / 2 - var11 - var4.field1376 / 2);
            }

         }
      }
   }
}
