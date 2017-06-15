import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class25 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 87772025
   )
   int field384;
   @ObfuscatedName("m")
   Coordinates field385;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1052722873"
   )
   public static byte[] method201() {
      byte[] var0 = new byte[24];

      try {
         class155.field2256.method2256(0L);
         class155.field2256.method2238(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1833998027"
   )
   static void method202(int var0, int var1, int var2, int var3) {
      Widget var4 = class172.method3015(var0, var1);
      if(var4 != null && var4.field2763 != null) {
         class69 var5 = new class69();
         var5.field822 = var4;
         var5.field821 = var4.field2763;
         class77.method1440(var5);
      }

      Client.field1157 = var3;
      Client.field1061 = true;
      class47.field611 = var0;
      Client.field1062 = var1;
      class232.spellTargetFlags = var2;
      XItemContainer.method1020(var4);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lclass241;",
      garbageValue = "1860125645"
   )
   public static class241 method203(int var0) {
      class241 var1 = (class241)class241.field3294.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class241.field3293.getConfigData(16, var0);
         var1 = new class241();
         if(var2 != null) {
            var1.method4159(new Buffer(var2));
         }

         class241.field3294.put(var1, (long)var0);
         return var1;
      }
   }

   class25(int var1, Coordinates var2) {
      this.field384 = var1;
      this.field385 = var2;
   }
}
