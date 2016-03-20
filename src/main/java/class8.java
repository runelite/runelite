import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class8 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 826638247
   )
   static int field130 = 4;
   @ObfuscatedName("f")
   boolean field131;
   @ObfuscatedName("s")
   boolean field132;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1706159383
   )
   int field133 = 1;
   @ObfuscatedName("e")
   LinkedHashMap field134 = new LinkedHashMap();
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -807743721
   )
   static int field135;

   class8(class118 var1) {
      if(var1 != null && var1.field1980 != null) {
         int var2 = var1.method2579();
         if(var2 >= 0 && var2 <= field130) {
            if(var1.method2579() == 1) {
               this.field131 = true;
            }

            if(var2 > 1) {
               this.field132 = var1.method2579() == 1;
            }

            if(var2 > 3) {
               this.field133 = var1.method2579();
            }

            if(var2 > 2) {
               int var3 = var1.method2579();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2517();
                  int var6 = var1.method2517();
                  this.field134.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method118();
         }
      } else {
         this.method118();
      }

   }

   @ObfuscatedName("a")
   void method118() {
   }

   @ObfuscatedName("r")
   class118 method119() {
      class118 var1 = new class118(100);
      var1.method2497(field130);
      var1.method2497(this.field131?1:0);
      var1.method2497(this.field132?1:0);
      var1.method2497(this.field133);
      var1.method2497(this.field134.size());
      Iterator var2 = this.field134.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2663(((Integer)var3.getKey()).intValue());
         var1.method2663(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-218864880"
   )
   static final void method121(int var0, int var1, int var2, int var3) {
      client.field388 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class32.field774;
      int[] var7 = class32.field759;

      int var8;
      for(var8 = 0; var8 < client.field331 + var6; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = client.field415[var7[var8]];
            if(client.field521 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = client.field358[client.field564[var8 - var6]];
         }

         class210.method3963((class37)var9, var8, var0, var1);
      }

      if(var4) {
         class210.method3963(client.field415[client.field521], var5, var0, var1);
      }

      for(var8 = 0; var8 < client.field388; ++var8) {
         int var18 = client.field381[var8];
         int var10 = client.field391[var8];
         int var11 = client.field393[var8];
         int var12 = client.field392[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > client.field391[var14] - client.field392[var14] && var10 - var12 < 2 + client.field391[var14] && var18 - var11 < client.field381[var14] + client.field393[var14] && var18 + var11 > client.field381[var14] - client.field393[var14] && client.field391[var14] - client.field392[var14] < var10) {
                  var10 = client.field391[var14] - client.field392[var14];
                  var13 = true;
               }
            }
         }

         client.field400 = client.field381[var8] * -1;
         client.field401 = (client.field391[var8] = var10) * -1;
         String var19 = client.field411[var8];
         if(0 == client.field455) {
            int var15 = 16776960;
            if(client.field394[var8] < 6) {
               var15 = client.field516[client.field394[var8]];
            }

            if(client.field394[var8] == 6) {
               var15 = client.field399 % 20 < 10?16711680:16776960;
            }

            if(client.field394[var8] == 7) {
               var15 = client.field399 % 20 < 10?255:'\uffff';
            }

            if(client.field394[var8] == 8) {
               var15 = client.field399 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(9 == client.field394[var8]) {
               var16 = 150 - client.field396[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 1280 * var16;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = '\uff00' + (var16 - 100) * 5;
               }
            }

            if(client.field394[var8] == 10) {
               var16 = 150 - client.field396[var8];
               if(var16 < 50) {
                  var15 = 5 * var16 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - (var16 - 100) * 5;
               }
            }

            if(client.field394[var8] == 11) {
               var16 = 150 - client.field396[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(0 == client.field575[var8]) {
               class38.field876.method4059(var19, var0 + client.field400 * -1, var1 + client.field401 * -1, var15, 0);
            }

            if(client.field575[var8] == 1) {
               class38.field876.method4061(var19, var0 + client.field400 * -1, var1 + client.field401 * -1, var15, 0, client.field399);
            }

            if(client.field575[var8] == 2) {
               class38.field876.method4062(var19, var0 + client.field400 * -1, client.field401 * -1 + var1, var15, 0, client.field399);
            }

            if(3 == client.field575[var8]) {
               class38.field876.method4063(var19, var0 + client.field400 * -1, var1 + client.field401 * -1, var15, 0, client.field399, 150 - client.field396[var8]);
            }

            if(client.field575[var8] == 4) {
               var16 = (150 - client.field396[var8]) * (class38.field876.method4052(var19) + 100) / 150;
               class79.method1825(client.field400 * -1 + var0 - 50, var1, 50 + client.field400 * -1 + var0, var3 + var1);
               class38.field876.method4057(var19, client.field400 * -1 + var0 + 50 - var16, client.field401 * -1 + var1, var15, 0);
               class79.method1852(var0, var1, var0 + var2, var3 + var1);
            }

            if(5 == client.field575[var8]) {
               var16 = 150 - client.field396[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class79.method1825(var0, client.field401 * -1 + var1 - class38.field876.field3193 - 1, var2 + var0, 5 + var1 + client.field401 * -1);
               class38.field876.method4059(var19, client.field400 * -1 + var0, var17 + var1 + client.field401 * -1, var15, 0);
               class79.method1852(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class38.field876.method4059(var19, client.field400 * -1 + var0, client.field401 * -1 + var1, 16776960, 0);
         }
      }

   }

   class8() {
      this.method118();
   }

   @ObfuscatedName("s")
   static void method128(class167 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class171 var8 = (class171)class170.field2705.method3824(var6);
      if(null == var8) {
         var8 = (class171)class170.field2707.method3824(var6);
         if(null == var8) {
            var8 = (class171)class170.field2718.method3824(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3920();
                  class170.field2705.method3831(var8, var6);
                  --class170.field2711;
                  ++class170.field2725;
               }

            } else {
               if(!var5) {
                  var8 = (class171)class170.field2712.method3824(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class171();
               var8.field2731 = var0;
               var8.field2727 = var3;
               var8.field2728 = var4;
               if(var5) {
                  class170.field2705.method3831(var8, var6);
                  ++class170.field2725;
               } else {
                  class170.field2709.method3908(var8);
                  class170.field2718.method3831(var8, var6);
                  ++class170.field2711;
               }

            }
         }
      }
   }

   @ObfuscatedName("a")
   public static int method130(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }
}
