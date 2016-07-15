import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class109 {
   @ObfuscatedName("c")
   public static int[][] field1942 = new int[128][128];
   @ObfuscatedName("h")
   public static int[][] field1943 = new int[128][128];
   @ObfuscatedName("u")
   public static int[] field1944 = new int[4096];
   @ObfuscatedName("o")
   public static int[] field1945 = new int[4096];
   @ObfuscatedName("bp")
   static class171 field1948;

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "16"
   )
   static void method2460(int var0, int var1, int var2, int var3) {
      class176 var4 = class93.method2180(var0, var1);
      if(null != var4 && null != var4.field2885) {
         class0 var5 = new class0();
         var5.field2 = var4;
         var5.field4 = var4.field2885;
         class143.method3071(var5);
      }

      client.field451 = var3;
      client.field448 = true;
      client.field344 = var0;
      client.field450 = var1;
      class19.field278 = var2;
      class51.method1124(var4);
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIIB)V",
      garbageValue = "-22"
   )
   @Export("generateMenuActionsForPlayer")
   static final void method2462(class2 var0, int var1, int var2, int var3) {
      if(var0 != class118.field2035) {
         if(client.field435 < 400) {
            String var4;
            int var7;
            if(var0.field36 == 0) {
               String var11 = var0.field47[0] + var0.field52 + var0.field47[1];
               var7 = var0.field35;
               int var8 = class118.field2035.field35;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class117.method2530(16711680);
               } else if(var9 < -6) {
                  var6 = class117.method2530(16723968);
               } else if(var9 < -3) {
                  var6 = class117.method2530(16740352);
               } else if(var9 < 0) {
                  var6 = class117.method2530(16756736);
               } else if(var9 > 9) {
                  var6 = class117.method2530('\uff00');
               } else if(var9 > 6) {
                  var6 = class117.method2530(4259584);
               } else if(var9 > 3) {
                  var6 = class117.method2530(8453888);
               } else if(var9 > 0) {
                  var6 = class117.method2530(12648192);
               } else {
                  var6 = class117.method2530(16776960);
               }

               var4 = var11 + var6 + " " + " (" + "level-" + var0.field35 + ")" + var0.field47[2];
            } else {
               var4 = var0.field47[0] + var0.field52 + var0.field47[1] + " " + " (" + "skill-" + var0.field36 + ")" + var0.field47[2];
            }

            int var5;
            if(client.field459 == 1) {
               class118.method2543("Use", client.field447 + " " + "->" + " " + class117.method2530(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field448) {
               if((class19.field278 & 8) == 8) {
                  class118.method2543(client.field452, client.field369 + " " + "->" + " " + class117.method2530(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(null != client.field422[var5]) {
                     short var10 = 0;
                     if(client.field422[var5].equalsIgnoreCase("Attack")) {
                        if(class21.field594 == client.field320) {
                           continue;
                        }

                        if(client.field320 == class21.field598 || client.field320 == class21.field597 && var0.field35 > class118.field2035.field35) {
                           var10 = 2000;
                        }

                        if(class118.field2035.field49 != 0 && var0.field49 != 0) {
                           if(class118.field2035.field49 == var0.field49) {
                              var10 = 2000;
                           } else {
                              var10 = 0;
                           }
                        }
                     } else if(client.field423[var5]) {
                        var10 = 2000;
                     }

                     boolean var12 = false;
                     var7 = client.field421[var5] + var10;
                     class118.method2543(client.field422[var5], class117.method2530(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < client.field435; ++var5) {
               if(client.field438[var5] == 23) {
                  client.field441[var5] = class117.method2530(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)V",
      garbageValue = "-1581118464"
   )
   static final void method2463(class176 var0) {
      int var1 = var0.field2916;
      if(var1 == 324) {
         if(client.field340 == -1) {
            client.field340 = var0.field2829;
            client.field570 = var0.field2830 * -1;
         }

         if(client.field568.field2957) {
            var0.field2829 = client.field340;
         } else {
            var0.field2829 = client.field570 * -1;
         }

      } else if(var1 == 325) {
         if(client.field340 == -1) {
            client.field340 = var0.field2829;
            client.field570 = var0.field2830 * -1;
         }

         if(client.field568.field2957) {
            var0.field2829 = client.field570 * -1;
         } else {
            var0.field2829 = client.field340;
         }

      } else if(var1 == 327) {
         var0.field2845 = 150;
         var0.field2846 = (int)(Math.sin((double)client.field567 / 40.0D) * 256.0D) & 2047;
         var0.field2837 = 5;
         var0.field2863 = 0;
      } else if(var1 == 328) {
         var0.field2845 = 150;
         var0.field2846 = (int)(Math.sin((double)client.field567 / 40.0D) * 256.0D) & 2047;
         var0.field2837 = 5;
         var0.field2863 = 1;
      }
   }
}
