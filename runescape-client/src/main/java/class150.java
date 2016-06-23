import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public final class class150 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)Lclass80;",
      garbageValue = "-553386611"
   )
   public static class80 method3164(class167 var0, String var1, String var2) {
      int var3 = var0.method3300(var1);
      int var4 = var0.method3301(var3, var2);
      return class6.method93(var0, var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-319792652"
   )
   public static String method3165(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class165.field2659[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Lclass40;",
      garbageValue = "0"
   )
   @Export("getObjectDefinition")
   public static class40 method3166(int var0) {
      class40 var1 = (class40)class40.field938.method3797((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class40.field969.method3286(6, var0);
         var1 = new class40();
         var1.field943 = var0;
         if(var2 != null) {
            var1.method864(new class119(var2));
         }

         var1.method870();
         if(var1.field971) {
            var1.field953 = 0;
            var1.field954 = false;
         }

         class40.field938.method3788(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1822420907"
   )
   public static void method3167() {
      class41.field987.method3796();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1492474707"
   )
   static final int method3168(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var0 / 4 << 10) + (var1 / 32 << 7) + var2 / 2;
      return var3;
   }
}
