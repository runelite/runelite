import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class28 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Lclass44;",
      garbageValue = "17"
   )
   @Export("getAnimation")
   public static class44 method646(int var0) {
      class44 var1 = (class44)class44.field1024.method3817((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class127.field2084.method3304(12, var0);
         var1 = new class44();
         if(var2 != null) {
            var1.method907(new class122(var2));
         }

         var1.method909();
         class44.field1024.method3823(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;S)Lclass81;",
      garbageValue = "361"
   )
   public static class81 method647(class170 var0, String var1, String var2) {
      int var3 = var0.method3319(var1);
      int var4 = var0.method3368(var3, var2);
      return class164.method3232(var0, var3, var4);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "929855995"
   )
   static void method648(int var0) {
      if(var0 == -1 && !client.field532) {
         class46.method969();
      } else if(var0 != -1 && client.field443 != var0 && client.field507 != 0 && !client.field532) {
         class171 var1 = class38.field814;
         int var2 = client.field507;
         class186.field3004 = 1;
         class128.field2089 = var1;
         class105.field1834 = var0;
         class186.field3009 = 0;
         class40.field903 = var2;
         class133.field2111 = false;
         class186.field3010 = 2;
      }

      client.field443 = var0;
   }
}
