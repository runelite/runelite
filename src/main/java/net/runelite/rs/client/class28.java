package net.runelite.rs.client;

import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("as")
public final class class28 extends class84 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -748024123
   )
   int field658;
   @ObfuscatedName("a")
   static class72 field659;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1494914441
   )
   int field660;

   @ObfuscatedName("cy")
   static class172 method689(class172 var0) {
      class172 var1 = class154.method3203(var0);
      if(null == var1) {
         var1 = var0.field2775;
      }

      return var1;
   }

   @ObfuscatedName("f")
   static void method694(int var0) {
      class15 var1 = (class15)class15.field216.method3836((long)var0);
      if(null != var1) {
         for(int var2 = 0; var2 < var1.field217.length; ++var2) {
            var1.field217[var2] = -1;
            var1.field214[var2] = 0;
         }

      }
   }

   @ObfuscatedName("l")
   static void method695(int var0, boolean var1, int var2, boolean var3) {
      if(null != class25.field615) {
         class12.method190(0, class25.field615.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("f")
   protected final class104 vmethod1921() {
      return class10.method158(this.field660).method1073(this.field658);
   }

   @ObfuscatedName("j")
   public static void method697(class135 var0, Object var1) {
      if(null != var0.field2078) {
         for(int var2 = 0; var2 < 50 && var0.field2078.peekEvent() != null; ++var2) {
            class29.method711(1L);
         }

         if(null != var1) {
            var0.field2078.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("ay")
   static final void method698() {
      int var0;
      if(client.field438 != -1) {
         var0 = client.field438;
         if(class167.method3400(var0)) {
            class115.method2471(class172.field2857[var0], -1);
         }
      }

      for(var0 = 0; var0 < client.field477; ++var0) {
         if(client.field370[var0]) {
            client.field496[var0] = true;
         }

         client.field481[var0] = client.field370[var0];
         client.field370[var0] = false;
      }

      client.field478 = client.field286;
      client.field423 = -1;
      client.field424 = -1;
      class29.field678 = null;
      if(-1 != client.field438) {
         client.field477 = 0;
         class106.method2419(client.field438, 0, 0, class129.field2048, class136.field2101, 0, 0, -1);
      }

      class79.method1875();
      int var1;
      int var4;
      if(!client.field500) {
         if(client.field423 != -1) {
            var0 = client.field423;
            var1 = client.field424;
            if(client.field416 >= 2 || 0 != client.field398 || client.field546) {
               String var2;
               if(1 == client.field398 && client.field416 < 2) {
                  var2 = "Use" + " " + client.field428 + " " + "->";
               } else if(client.field546 && client.field416 < 2) {
                  var2 = client.field432 + " " + client.field433 + " " + "->";
               } else {
                  var4 = client.field416 - 1;
                  String var3;
                  if(client.field422[var4].length() > 0) {
                     var3 = client.field297[var4] + " " + client.field422[var4];
                  } else {
                     var3 = client.field297[var4];
                  }

                  var2 = var3;
               }

               if(client.field416 > 2) {
                  var2 = var2 + class74.method1617(16777215) + " " + '/' + " " + (client.field416 - 2) + " more options";
               }

               class143.field2174.method4082(var2, var0 + 4, 15 + var1, 16777215, 0, client.field286 / 1000);
            }
         }
      } else {
         var0 = class18.field253;
         var1 = class36.field793;
         int var12 = class0.field9;
         int var13 = class19.field267;
         var4 = 6116423;
         class79.method1820(var0, var1, var12, var13, var4);
         class79.method1820(var0 + 1, var1 + 1, var12 - 2, 16, 0);
         class79.method1815(1 + var0, 18 + var1, var12 - 2, var13 - 19, 0);
         class143.field2174.method4074("Choose Option", 3 + var0, 14 + var1, var4, -1);
         int var5 = class139.field2134;
         int var6 = class139.field2135;

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < client.field416; ++var7) {
            var8 = (client.field416 - 1 - var7) * 15 + 31 + var1;
            var9 = 16777215;
            if(var5 > var0 && var5 < var0 + var12 && var6 > var8 - 13 && var6 < var8 + 3) {
               var9 = 16776960;
            }

            class143.field2174.method4074(class106.method2418(var7), 3 + var0, var8, var9, 0);
         }

         var7 = class18.field253;
         var8 = class36.field793;
         var9 = class0.field9;
         int var10 = class19.field267;

         for(int var11 = 0; var11 < client.field477; ++var11) {
            if(client.field482[var11] + client.field484[var11] > var7 && client.field482[var11] < var7 + var9 && client.field483[var11] + client.field526[var11] > var8 && client.field483[var11] < var10 + var8) {
               client.field496[var11] = true;
            }
         }
      }

      if(client.field316 == 3) {
         for(var0 = 0; var0 < client.field477; ++var0) {
            if(client.field481[var0]) {
               class79.method1821(client.field482[var0], client.field483[var0], client.field484[var0], client.field526[var0], 16711935, 128);
            } else if(client.field496[var0]) {
               class79.method1821(client.field482[var0], client.field483[var0], client.field484[var0], client.field526[var0], 16711680, 128);
            }
         }
      }

      class50.method1059(class8.field134, class0.field12.field846, class0.field12.field834, client.field420);
      client.field420 = 0;
   }

   @ObfuscatedName("j")
   public static String method699(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && 46 != var4 && 45 != var4 && 42 != var4 && 95 != var4) {
            if(32 == var4) {
               var2.append('+');
            } else {
               byte var5 = class154.method3204(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
