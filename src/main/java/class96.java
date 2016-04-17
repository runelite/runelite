import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class96 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -190453931
   )
   int field1626;
   @ObfuscatedName("nx")
   static class56 field1627;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1331568309
   )
   int field1628;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1428211309
   )
   int field1629;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -805071681
   )
   int field1630;
   @ObfuscatedName("c")
   public static boolean field1633;

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass37;IIIIIB)V",
      garbageValue = "-49"
   )
   static final void method2275(class37 var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod836()) {
         if(var0 instanceof class34) {
            class39 var6 = ((class34)var0).field784;
            if(null != var6.field916) {
               var6 = var6.method862();
            }

            if(var6 == null) {
               return;
            }
         }

         int var10 = class32.field771;
         int[] var7 = class32.field762;
         int var8;
         if(var1 < var10) {
            var8 = 30;
            class2 var9 = (class2)var0;
            if(var9.field51) {
               return;
            }

            if(var9.field41 != -1 || -1 != var9.field50) {
               class126.method2935(var0, var0.field867 + 15);
               if(client.field400 > -1) {
                  if(var9.field41 != -1) {
                     class0.field13[var9.field41].method1798(var2 + client.field400 - 12, client.field293 + var3 - var8);
                     var8 += 25;
                  }

                  if(var9.field50 != -1) {
                     class174.field2895[var9.field50].method1798(client.field400 + var2 - 12, client.field293 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field314 == 10 && client.field316 == var7[var1]) {
               class126.method2935(var0, 15 + var0.field867);
               if(client.field400 > -1) {
                  class127.field2044[1].method1798(client.field400 + var2 - 12, var3 + client.field293 - var8);
               }
            }
         } else {
            class39 var12 = ((class34)var0).field784;
            if(null != var12.field916) {
               var12 = var12.method862();
            }

            if(var12.field914 >= 0 && var12.field914 < class174.field2895.length) {
               class126.method2935(var0, var0.field867 + 15);
               if(client.field400 > -1) {
                  class174.field2895[var12.field914].method1798(client.field400 + var2 - 12, var3 + client.field293 - 30);
               }
            }

            if(1 == client.field314 && client.field335[var1 - var10] == client.field315 && client.field306 % 20 < 10) {
               class126.method2935(var0, 15 + var0.field867);
               if(client.field400 > -1) {
                  class127.field2044[0].method1798(client.field400 + var2 - 12, var3 + client.field293 - 28);
               }
            }
         }

         if(var0.field830 != null && (var1 >= var10 || !var0.field832 && (4 == client.field511 || !var0.field861 && (client.field511 == 0 || 3 == client.field511 || client.field511 == 1 && class41.method948(((class2)var0).field58, false))))) {
            class126.method2935(var0, var0.field867);
            if(client.field400 > -1 && client.field388 < client.field389) {
               client.field419[client.field388] = class33.field781.method4111(var0.field830) / 2;
               client.field566[client.field388] = class33.field781.field3190;
               client.field390[client.field388] = client.field400;
               client.field533[client.field388] = client.field293;
               client.field459[client.field388] = var0.field834;
               client.field502[client.field388] = var0.field873;
               client.field396[client.field388] = var0.field856;
               client.field488[client.field388] = var0.field830;
               ++client.field388;
            }
         }

         if(var0.field870 > client.field306) {
            class126.method2935(var0, 15 + var0.field867);
            if(client.field400 > -1) {
               if(var1 < var10) {
                  var8 = 30;
               } else {
                  class39 var11 = ((class34)var0).field784;
                  var8 = var11.field922;
               }

               int var13 = var0.field840 * var8 / var0.field831;
               if(var13 > var8) {
                  var13 = var8;
               } else if(0 == var13 && var0.field840 > 0) {
                  var13 = 1;
               }

               class79.method1929(client.field400 + var2 - var8 / 2, client.field293 + var3 - 3, var13, 5, '\uff00');
               class79.method1929(var13 + (var2 + client.field400 - var8 / 2), var3 + client.field293 - 3, var8 - var13, 5, 16711680);
            }
         }

         for(var8 = 0; var8 < 4; ++var8) {
            if(var0.field838[var8] > client.field306) {
               class126.method2935(var0, var0.field867 / 2);
               if(client.field400 > -1) {
                  if(1 == var8) {
                     client.field293 -= 20;
                  }

                  if(var8 == 2) {
                     client.field400 -= 15;
                     client.field293 -= 10;
                  }

                  if(3 == var8) {
                     client.field400 += 15;
                     client.field293 -= 10;
                  }

                  class4.field75[var0.field837[var8]].method1798(client.field400 + var2 - 12, var3 + client.field293 - 12);
                  class148.field2220.method4118(Integer.toString(var0.field818[var8]), var2 + client.field400 - 1, var3 + client.field293 + 3, 16777215, 0);
               }
            }
         }

      }
   }

   class96(class96 var1) {
      this.field1628 = var1.field1628;
      this.field1629 = var1.field1629;
      this.field1630 = var1.field1630;
      this.field1626 = var1.field1626;
   }

   class96() {
   }

   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)Ljava/lang/String;",
      garbageValue = "66"
   )
   static String method2276(class173 var0) {
      return class98.method2283(class31.method776(var0)) == 0?null:(null != var0.field2818 && var0.field2818.trim().length() != 0?var0.field2818:null);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "-1366948458"
   )
   public static void method2277(String[] var0, short[] var1) {
      class32.method779(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "1440086520"
   )
   static void method2278(class173 var0) {
      class173 var1 = var0.field2777 == -1?null:class20.method641(var0.field2777);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class37.field876;
         var3 = class98.field1671;
      } else {
         var2 = var1.field2773;
         var3 = var1.field2774;
      }

      class113.method2542(var0, var2, var3, false);
      class16.method213(var0, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Lclass42;",
      garbageValue = "-16"
   )
   public static class42 method2279(int var0) {
      class42 var1 = (class42)class42.field990.method3840((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class124.field2031.method3403(12, var0);
         var1 = new class42();
         if(var2 != null) {
            var1.method951(new class119(var2));
         }

         var1.method953();
         class42.field990.method3842(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "14500"
   )
   public static void method2280(int var0) {
      class140.field2146 = var0;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1255167127"
   )
   static final void method2281() {
      int[] var0 = class32.field762;

      int var1;
      for(var1 = 0; var1 < class32.field771; ++var1) {
         class2 var2 = client.field550[var0[var1]];
         if(null != var2 && var2.field856 > 0) {
            --var2.field856;
            if(var2.field856 == 0) {
               var2.field830 = null;
            }
         }
      }

      for(var1 = 0; var1 < client.field343; ++var1) {
         int var4 = client.field335[var1];
         class34 var3 = client.field546[var4];
         if(null != var3 && var3.field856 > 0) {
            --var3.field856;
            if(0 == var3.field856) {
               var3.field830 = null;
            }
         }
      }

   }
}
