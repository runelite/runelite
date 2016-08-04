import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("g")
   @Export("previousName")
   String field131;
   @ObfuscatedName("l")
   @Export("name")
   String field132;
   @ObfuscatedName("cu")
   static class227 field133;
   @ObfuscatedName("dt")
   @Export("mapRegions")
   static int[] field135;
   @ObfuscatedName("bn")
   static class171 field137;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1061965560"
   )
   static void method111(int var0) {
      class15 var1 = (class15)class15.field225.method3936((long)var0);
      if(var1 != null) {
         var1.method4067();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)[Lclass81;",
      garbageValue = "128"
   )
   static class81[] method112() {
      class81[] var0 = new class81[class79.field1466];

      for(int var1 = 0; var1 < class79.field1466; ++var1) {
         class81 var2 = var0[var1] = new class81();
         var2.field1484 = class79.field1454;
         var2.field1483 = class79.field1456;
         var2.field1480 = class79.field1457[var1];
         var2.field1478 = class180.field2962[var1];
         var2.field1482 = class192.field3106[var1];
         var2.field1479 = class79.field1458[var1];
         int var3 = var2.field1479 * var2.field1482;
         byte[] var4 = class145.field2236[var1];
         var2.field1487 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1487[var5] = class79.field1459[var4[var5] & 255];
         }
      }

      class55.method1182();
      return var0;
   }
}
