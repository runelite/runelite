import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
public class class126 {
   @ObfuscatedName("k")
   public static String field2050;

   @ObfuscatedName("bk")
   static boolean method2805(int var0) {
      return var0 == 57 || 58 == var0 || 1007 == var0 || 25 == var0 || 30 == var0;
   }

   @ObfuscatedName("x")
   public static int method2812(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("m")
   public static class80 method2818(class167 var0, String var1, String var2) {
      int var3 = var0.method3303(var1);
      int var4 = var0.method3289(var3, var2);
      return class10.method125(var0, var3, var4);
   }

   @ObfuscatedName("w")
   static class22 method2819(int var0) {
      class22 var1 = (class22)class22.field607.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class9.field169.method3335(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class22();
            class119 var3 = new class119(var2);
            var3.field2011 = var3.field2012.length - 12;
            int var4 = var3.method2511();
            var1.field603 = var3.method2508();
            var1.field598 = var3.method2508();
            var1.field602 = var3.method2508();
            var1.field604 = var3.method2508();
            var3.field2011 = 0;
            var3.method2513();
            var1.field597 = new int[var4];
            var1.field599 = new int[var4];
            var1.field600 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field2011 < var3.field2012.length - 12; var1.field597[var5++] = var6) {
               var6 = var3.method2508();
               if(3 == var6) {
                  var1.field600[var5] = var3.method2683();
               } else if(var6 < 100 && var6 != 21 && 38 != var6 && var6 != 39) {
                  var1.field599[var5] = var3.method2511();
               } else {
                  var1.field599[var5] = var3.method2506();
               }
            }

            class22.field607.method3773(var1, (long)var0);
            return var1;
         }
      }
   }
}
