import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class145 {
   @ObfuscatedName("l")
   public static class170 field2235;
   @ObfuscatedName("n")
   public static byte[][] field2236;

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "-7"
   )
   static boolean method3128(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class156.method3300(var0, client.field518);

         for(int var3 = 0; var3 < client.field391; ++var3) {
            if(var2.equalsIgnoreCase(class156.method3300(client.field456[var3].field250, client.field518)) && (!var1 || client.field456[var3].field247 != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class156.method3300(class3.field65.field58, client.field518))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1098458733"
   )
   static void method3129(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(class27.field666[var5] != var0) {
            var2[var4] = class27.field666[var5];
            var3[var4] = class27.field665[var5];
            ++var4;
         }
      }

      class27.field666 = var2;
      class27.field665 = var3;
      class9.method133(class27.field662, 0, class27.field662.length - 1, class27.field666, class27.field665);
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZB)V",
      garbageValue = "70"
   )
   static final void method3130(class3 var0, boolean var1) {
      int var2 = var0.field70;
      int var3 = (int)var0.field3175;
      var0.method4067();
      if(var1) {
         class163.method3329(var2);
      }

      for(class204 var4 = (class204)client.field435.method3939(); null != var4; var4 = (class204)client.field435.method3935()) {
         if((long)var2 == (var4.field3175 >> 48 & 65535L)) {
            var4.method4067();
         }
      }

      class176 var6 = class134.method2983(var3);
      if(var6 != null) {
         class79.method1777(var6);
      }

      class124.method2891();
      if(client.field495 != -1) {
         int var5 = client.field495;
         if(class14.method179(var5)) {
            class9.method134(class176.field2836[var5], 1);
         }
      }

   }
}
