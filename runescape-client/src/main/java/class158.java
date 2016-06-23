import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class158 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass52;",
      garbageValue = "1163727902"
   )
   public static class52 method3191(int var0) {
      class52 var1 = (class52)class52.field1168.method3797((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class217.field3163.method3286(16, var0);
         var1 = new class52();
         if(null != var2) {
            var1.method1136(new class119(var2));
         }

         class52.field1168.method3788(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass80;",
      garbageValue = "-538047208"
   )
   static class80 method3192() {
      class80 var0 = new class80();
      var0.field1426 = class76.field1396;
      var0.field1432 = class76.field1398;
      var0.field1433 = class76.field1397[0];
      var0.field1431 = class52.field1178[0];
      var0.field1428 = class28.field690[0];
      var0.field1429 = class31.field744[0];
      var0.field1427 = class7.field135;
      var0.field1430 = class76.field1400[0];
      class33.method749();
      return var0;
   }
}
