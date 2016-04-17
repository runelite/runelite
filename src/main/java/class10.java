import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class10 extends class107 {
   @ObfuscatedName("h")
   static class119 field171;
   @ObfuscatedName("nj")
   static class55 field178;

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "0"
   )
   static final void method165(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field548 + (client.field535 - client.field548) * var5 / 100;
      int var7 = var6 * var3 * 512 / (334 * var2);
      int var8;
      int var9;
      short var14;
      if(var7 < client.field385) {
         var14 = client.field385;
         var6 = 334 * var2 * var14 / (var3 * 512);
         if(var6 > client.field553) {
            var6 = client.field553;
            var8 = 512 * var6 * var3 / (var14 * 334);
            var9 = (var2 - var8) / 2;
            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > client.field555) {
         var14 = client.field555;
         var6 = 334 * var14 * var2 / (512 * var3);
         if(var6 < client.field552) {
            var6 = client.field552;
            var8 = var14 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = client.field421 + var5 * (client.field545 - client.field421) / 100;
      client.field560 = var3 * var6 * var8 / 85504 << 1;
      if(client.field558 != var2 || var3 != client.field456) {
         int[] var15 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 128 + var10 * 32 + 15;
            int var12 = 600 + var11 * 3;
            int var13 = class91.field1593[var11];
            var15[var10] = var13 * var12 >> 16;
         }

         class86.method2043(var15, 500, 800, var2, var3);
      }

      client.field305 = var0;
      client.field557 = var1;
      client.field558 = var2;
      client.field456 = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILclass108;I)Z",
      garbageValue = "271013110"
   )
   protected boolean vmethod2480(int var1, int var2, int var3, class108 var4) {
      return var2 == super.field1873 && super.field1868 == var3;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-68"
   )
   static void method169() {
      if(client.field447) {
         class173 var0 = class210.method4010(class9.field169, client.field386);
         if(null != var0 && null != var0.field2850) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field4 = var0.field2850;
            class168.method3449(var1, 200000);
         }

         client.field447 = false;
         class23.method657(var0);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIIIIII)V",
      garbageValue = "-219158313"
   )
   static final void method170(class119 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field82[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2613();
            if(0 == var7) {
               if(0 == var1) {
                  class5.field94[0][var2][var3] = -class150.method3242(var4 + var2 + 932731, var5 + 556238 + var3) * 8;
               } else {
                  class5.field94[var1][var2][var3] = class5.field94[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(1 == var7) {
               int var8 = var0.method2613();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(0 == var1) {
                  class5.field94[0][var2][var3] = 8 * -var8;
               } else {
                  class5.field94[var1][var2][var3] = class5.field94[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field84[var1][var2][var3] = var0.method2699();
               class5.field85[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class84.field1463[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.field82[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class45.field1053[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2613();
            if(0 == var7) {
               break;
            }

            if(1 == var7) {
               var0.method2613();
               break;
            }

            if(var7 <= 49) {
               var0.method2613();
            }
         }
      }

   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1933065970"
   )
   static final void method171(int var0, int var1) {
      int var2 = class33.field781.method4111("Choose Option");

      int var3;
      for(var3 = 0; var3 < client.field434; ++var3) {
         class224 var4 = class33.field781;
         String var5;
         if(client.field440[var3].length() > 0) {
            var5 = client.field439[var3] + " " + client.field440[var3];
         } else {
            var5 = client.field439[var3];
         }

         int var6 = var4.method4111(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = client.field434 * 15 + 22;
      int var7 = var0 - var2 / 2;
      if(var7 + var2 > class37.field876) {
         var7 = class37.field876 - var2;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      int var8 = var1;
      if(var3 + var1 > class98.field1671) {
         var8 = class98.field1671 - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      client.field433 = true;
      class2.field59 = var7;
      class72.field1355 = var8;
      class42.field996 = var2;
      class3.field69 = client.field434 * 15 + 22;
   }
}
