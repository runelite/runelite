import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class21 implements Comparator {
   @ObfuscatedName("q")
   public static class172 field590;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -139855777
   )
   static int field592;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("i")
   static void method582() {
      class76.field1392 = null;
      class76.field1388 = null;
      class76.field1389 = null;
      class76.field1390 = null;
      class76.field1391 = null;
      class10.field180 = (byte[][])null;
   }

   public int compare(Object var1, Object var2) {
      return this.method584((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("w")
   int method584(class214 var1, class214 var2) {
      if(var2.field3160 == var1.field3160) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(client.field296 == var1.field3160) {
               return -1;
            }

            if(client.field296 == var2.field3160) {
               return 1;
            }
         }

         return var1.field3160 < var2.field3160?-1:1;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1833544856"
   )
   static final void method588(int var0) {
      int[] var1 = class7.field143.field1406;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 24628 + 2048 * (103 - var3);

         for(var5 = 1; var5 < 103; ++var5) {
            if((class5.field109[var0][var5][var3] & 24) == 0) {
               class3.field75.method2049(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class5.field109[1 + var0][var5][var3] & 8) != 0) {
               class3.field75.method2049(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class7.field143.method1689();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class5.field109[var0][var6][var5] & 24) == 0) {
               class35.method753(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class5.field109[var0 + 1][var6][var5] & 8) != 0) {
               class35.method753(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      client.field390 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class3.field75.method1978(class82.field1437, var5, var6);
            if(0 != var7) {
               var7 = var7 >> 14 & 32767;
               int var8 = class22.method592(var7).field954;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && 34 != var8 && 36 != var8 && var8 != 46 && 47 != var8 && 48 != var8) {
                     int[][] var13 = client.field372[class82.field1437].field1894;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && 0 == (var13[var9 + 1][var10] & 19136896)) {
                           ++var9;
                        }

                        if(2 == var15 && var10 > 0 && var10 > var6 - 3 && 0 == (var13[var9][var10 - 1] & 19136770)) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < 3 + var6 && (var13[var9][1 + var10] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  client.field487[client.field390] = class4.field88[var8];
                  client.field525[client.field390] = var9;
                  client.field526[client.field390] = var10;
                  ++client.field390;
               }
            }
         }
      }

      class42.field991.method1670();
   }

   @ObfuscatedName("w")
   public static class49 method589(int var0) {
      class49 var1 = (class49)class49.field1101.method3771((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class49.field1104.method3335(15, var0);
         var1 = new class49();
         if(var2 != null) {
            var1.method1040(new class119(var2));
         }

         class49.field1101.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   static void method590(String var0, String var1, String var2) {
      class31.field714 = var0;
      class31.field732 = var1;
      class31.field739 = var2;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "-2133942647"
   )
   static final void method591(class66 var0) {
      var0.field1269 = false;
      if(var0.field1271 != null) {
         var0.field1271.field1268 = 0;
      }

      for(class66 var1 = var0.vmethod3729(); null != var1; var1 = var0.vmethod3749()) {
         method591(var1);
      }

   }
}
