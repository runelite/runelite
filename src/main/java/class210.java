import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class210 {
   @ObfuscatedName("a")
   static class201 field3125 = new class201();

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass37;IIIIIS)V",
      garbageValue = "-3521"
   )
   static final void method3963(class37 var0, int var1, int var2, int var3) {
      if(var0 != null && var0.vmethod755()) {
         if(var0 instanceof class34) {
            class39 var4 = ((class34)var0).field785;
            if(var4.field909 != null) {
               var4 = var4.method774();
            }

            if(var4 == null) {
               return;
            }
         }

         int var8 = class32.field774;
         int[] var5 = class32.field759;
         int var6;
         if(var1 < var8) {
            var6 = 30;
            class2 var7 = (class2)var0;
            if(var7.field52) {
               return;
            }

            if(-1 != var7.field27 || var7.field36 != -1) {
               class20.method560(var0, 15 + var0.field845);
               if(client.field400 * -1 > -1) {
                  if(-1 != var7.field27) {
                     class15.field216[var7.field27].method1805(var2 + client.field400 * -1 - 12, client.field401 * -1 + var3 - var6);
                     var6 += 25;
                  }

                  if(var7.field36 != -1) {
                     class34.field787[var7.field36].method1805(client.field400 * -1 + var2 - 12, var3 + client.field401 * -1 - var6);
                     var6 += 25;
                  }
               }
            }

            if(var1 >= 0 && 10 == client.field311 && var5[var1] == client.field313) {
               class20.method560(var0, 15 + var0.field845);
               if(client.field400 * -1 > -1) {
                  client.field370[1].method1805(var2 + client.field400 * -1 - 12, var3 + client.field401 * -1 - var6);
               }
            }
         } else {
            class39 var10 = ((class34)var0).field785;
            if(var10.field909 != null) {
               var10 = var10.method774();
            }

            if(var10.field916 >= 0 && var10.field916 < class34.field787.length) {
               class20.method560(var0, 15 + var0.field845);
               if(client.field400 * -1 > -1) {
                  class34.field787[var10.field916].method1805(var2 + client.field400 * -1 - 12, var3 + client.field401 * -1 - 30);
               }
            }

            if(1 == client.field311 && client.field564[var1 - var8] == client.field312 && client.field303 % 20 < 10) {
               class20.method560(var0, 15 + var0.field845);
               if(client.field400 * -1 > -1) {
                  client.field370[0].method1805(client.field400 * -1 + var2 - 12, client.field401 * -1 + var3 - 28);
               }
            }
         }

         if(null != var0.field825 && (var1 >= var8 || !var0.field829 && (client.field512 == 4 || !var0.field826 && (client.field512 == 0 || client.field512 == 3 || client.field512 == 1 && class10.method140(((class2)var0).field40, false))))) {
            class20.method560(var0, var0.field845);
            if(client.field400 * -1 > -1 && client.field388 < client.field389) {
               client.field393[client.field388] = class38.field876.method4052(var0.field825) / 2;
               client.field392[client.field388] = class38.field876.field3193;
               client.field381[client.field388] = client.field400 * -1;
               client.field391[client.field388] = client.field401 * -1;
               client.field394[client.field388] = var0.field822;
               client.field575[client.field388] = var0.field827;
               client.field396[client.field388] = var0.field855;
               client.field411[client.field388] = var0.field825;
               ++client.field388;
            }
         }

         if(var0.field838 > client.field303) {
            class20.method560(var0, var0.field845 + 15);
            if(client.field400 * -1 > -1) {
               if(var1 < var8) {
                  var6 = 30;
               } else {
                  class39 var9 = ((class34)var0).field785;
                  var6 = var9.field895;
               }

               int var11 = var6 * var0.field835 / var0.field836;
               if(var11 > var6) {
                  var11 = var6;
               } else if(var11 == 0 && var0.field835 > 0) {
                  var11 = 1;
               }

               class79.method1830(client.field400 * -1 + var2 - var6 / 2, client.field401 * -1 + var3 - 3, var11, 5, '\uff00');
               class79.method1830(var2 + client.field400 * -1 - var6 / 2 + var11, var3 + client.field401 * -1 - 3, var6 - var11, 5, 16711680);
            }
         }

         for(var6 = 0; var6 < 4; ++var6) {
            if(var0.field833[var6] > client.field303) {
               class20.method560(var0, var0.field845 / 2);
               if(client.field400 * -1 > -1) {
                  if(1 == var6) {
                     client.field401 -= -20;
                  }

                  if(2 == var6) {
                     client.field400 -= -15;
                     client.field401 -= -10;
                  }

                  if(3 == var6) {
                     client.field400 += -15;
                     client.field401 -= -10;
                  }

                  client.field545[var0.field832[var6]].method1805(client.field400 * -1 + var2 - 12, var3 + client.field401 * -1 - 12);
                  class95.field1627.method4059(Integer.toString(var0.field858[var6]), var2 + client.field400 * -1 - 1, client.field401 * -1 + var3 + 3, 16777215, 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "81"
   )
   static void method3965(int var0) {
      for(class200 var1 = (class200)client.field366.method3836(); var1 != null; var1 = (class200)client.field366.method3827()) {
         if((long)var0 == (var1.field3111 >> 48 & 65535L)) {
            var1.method3946();
         }
      }

   }
}
