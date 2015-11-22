package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cv")
public class class102 extends class203 {
   @ObfuscatedName("u")
   static class80[] field1749;
   @ObfuscatedName("a")
   public static boolean field1750;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = 2068745197
   )
   protected static int field1751;
   @ObfuscatedName("j")
   class87[] field1752;

   @ObfuscatedName("j")
   public static boolean method2311() {
      class209 var0 = (class209)class210.field3116.method3907();
      return var0 != null;
   }

   @ObfuscatedName("j")
   public boolean method2312(int var1) {
      return this.field1752[var1].field1522;
   }

   @ObfuscatedName("j")
   static class20[] method2313() {
      return new class20[]{class20.field559, class20.field557, class20.field560, class20.field565};
   }

   public class102(class166 var1, class166 var2, int var3, boolean var4) {
      class198 var5 = new class198();
      int var6 = var1.method3322(var3);
      this.field1752 = new class87[var6];
      int[] var7 = var1.method3321(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3352(var3, var7[var8]);
         class101 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class101 var12 = (class101)var5.method3871(); null != var12; var12 = (class101)var5.method3873()) {
            if(var11 == var12.field1746) {
               var10 = var12;
               break;
            }
         }

         if(null == var10) {
            byte[] var13 = var2.method3318(var11, 0);
            var10 = new class101(var11, var13);
            var5.method3868(var10);
         }

         this.field1752[var7[var8]] = new class87(var9, var10);
      }

   }

   @ObfuscatedName("ct")
   static final void method2317() {
      class42.method942(client.field447);
      ++class25.field625;
      if(client.field455 && client.field452) {
         int var0 = class139.field2134;
         int var1 = class139.field2135;
         var0 -= client.field449;
         var1 -= client.field450;
         if(var0 < client.field453) {
            var0 = client.field453;
         }

         if(var0 + client.field447.field2749 > client.field448.field2749 + client.field453) {
            var0 = client.field448.field2749 + client.field453 - client.field447.field2749;
         }

         if(var1 < client.field454) {
            var1 = client.field454;
         }

         if(var1 + client.field447.field2750 > client.field448.field2750 + client.field454) {
            var1 = client.field448.field2750 + client.field454 - client.field447.field2750;
         }

         int var2 = var0 - client.field456;
         int var3 = var1 - client.field457;
         int var4 = client.field447.field2804;
         if(class25.field625 > client.field447.field2809 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            client.field517 = true;
         }

         int var5 = client.field448.field2755 + (var0 - client.field453);
         int var6 = var1 - client.field454 + client.field448.field2762;
         class0 var7;
         if(client.field447.field2821 != null && client.field517) {
            var7 = new class0();
            var7.field2 = client.field447;
            var7.field3 = var5;
            var7.field4 = var6;
            var7.field10 = client.field447.field2821;
            class171.method3458(var7);
         }

         if(0 == class139.field2133) {
            if(client.field517) {
               if(null != client.field447.field2822) {
                  var7 = new class0();
                  var7.field2 = client.field447;
                  var7.field3 = var5;
                  var7.field4 = var6;
                  var7.field15 = client.field451;
                  var7.field10 = client.field447.field2822;
                  class171.method3458(var7);
               }

               if(null != client.field451 && class154.method3203(client.field447) != null) {
                  client.field318.method2785(190);
                  client.field318.method2567(client.field447.field2852);
                  client.field318.method2567(client.field451.field2852);
                  client.field318.method2730(client.field447.field2735);
                  client.field318.method2577(client.field451.field2734 * -1);
                  client.field318.method2524(client.field447.field2734 * -1);
                  client.field318.method2522(client.field451.field2735);
               }
            } else {
               label142: {
                  int var8;
                  label115: {
                     if(1 != client.field414) {
                        var8 = client.field416 - 1;
                        boolean var10;
                        if(var8 < 0) {
                           var10 = false;
                        } else {
                           int var9 = client.field419[var8];
                           if(var9 >= 2000) {
                              var9 -= 2000;
                           }

                           if(1007 == var9) {
                              var10 = true;
                           } else {
                              var10 = false;
                           }
                        }

                        if(!var10) {
                           break label115;
                        }
                     }

                     if(client.field416 > 2) {
                        class154.method3202(client.field449 + client.field456, client.field450 + client.field457);
                        break label142;
                     }
                  }

                  if(client.field416 > 0) {
                     int var11 = client.field456 + client.field449;
                     var8 = client.field450 + client.field457;
                     class103.method2326(class160.field2625, var11, var8);
                     class160.field2625 = null;
                  }
               }
            }

            client.field447 = null;
         }

      } else {
         if(class25.field625 > 1) {
            client.field447 = null;
         }

      }
   }

   @ObfuscatedName("i")
   public static int method2318(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("j")
   public static class153[] method2321() {
      return new class153[]{class153.field2276, class153.field2274, class153.field2273, class153.field2269, class153.field2270, class153.field2272};
   }

   @ObfuscatedName("j")
   public static class45 method2322(int var0) {
      class45 var1 = (class45)class45.field1028.method3808((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field1027.method3352(19, var0);
         var1 = new class45();
         if(null != var2) {
            var1.method980(new class118(var2));
         }

         class45.field1028.method3805(var1, (long)var0);
         return var1;
      }
   }
}
