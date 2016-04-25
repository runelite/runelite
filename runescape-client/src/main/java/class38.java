import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class38 extends class207 {
   @ObfuscatedName("h")
   String field857;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -198197465
   )
   int field858 = (int)(class77.method1674() / 1000L);
   @ObfuscatedName("m")
   short field859;
   @ObfuscatedName("a")
   public static boolean field862;

   class38(String var1, int var2) {
      this.field857 = var1;
      this.field859 = (short)var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass47;",
      garbageValue = "1940209101"
   )
   public static class47 method751(int var0) {
      class47 var1 = (class47)class47.field1047.method3704((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class47.field1056.method3217(14, var0);
         var1 = new class47();
         if(var2 != null) {
            var1.method981(new class119(var2));
         }

         class47.field1047.method3706(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)Lclass80;",
      garbageValue = "-2014735007"
   )
   static class80 method752(class167 var0, int var1, int var2) {
      if(!class31.method691(var0, var1, var2)) {
         return null;
      } else {
         class80 var4 = new class80();
         var4.field1407 = class76.field1364;
         var4.field1408 = class129.field2027;
         var4.field1406 = class76.field1366[0];
         var4.field1404 = class76.field1367[0];
         var4.field1403 = class52.field1145[0];
         var4.field1401 = class76.field1371[0];
         var4.field1405 = class227.field3220;
         var4.field1402 = client.field557[0];
         class157.method3133();
         return var4;
      }
   }
}
