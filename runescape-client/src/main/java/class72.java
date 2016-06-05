import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class72 implements Runnable {
   @ObfuscatedName("i")
   volatile class56[] field1352 = new class56[2];
   @ObfuscatedName("h")
   volatile boolean field1354 = false;
   @ObfuscatedName("g")
   volatile boolean field1355 = false;
   @ObfuscatedName("mr")
   static byte field1356;
   @ObfuscatedName("t")
   class136 field1357;

   public void run() {
      this.field1354 = true;

      try {
         while(!this.field1355) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class56 var2 = this.field1352[var1];
               if(null != var2) {
                  var2.method1186();
               }
            }

            class45.method926(10L);
            class122.method2718(this.field1357, (Object)null);
         }
      } catch (Exception var7) {
         class30.method654((String)null, var7);
      } finally {
         this.field1354 = false;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lclass78;",
      garbageValue = "-680885787"
   )
   static class78[] method1527() {
      class78[] var0 = new class78[class76.field1387];

      for(int var1 = 0; var1 < class76.field1387; ++var1) {
         class78 var2 = var0[var1] = new class78();
         var2.field1408 = class76.field1386;
         var2.field1411 = class76.field1392;
         var2.field1406 = class76.field1388[var1];
         var2.field1407 = class165.field2689[var1];
         var2.field1404 = class76.field1385[var1];
         var2.field1405 = class14.field209[var1];
         int var3 = var2.field1404 * var2.field1405;
         byte[] var4 = class45.field1045[var1];
         var2.field1409 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1409[var5] = class14.field213[var4[var5] & 255];
         }
      }

      class16.method164();
      return var0;
   }
}
