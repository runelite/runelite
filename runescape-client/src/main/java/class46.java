import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class46 extends class204 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1090279361
   )
   public int field1051 = -1;
   @ObfuscatedName("i")
   public static class193 field1052 = new class193(64);
   @ObfuscatedName("t")
   public static class167 field1053;
   @ObfuscatedName("z")
   public boolean field1055 = true;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -148451863
   )
   public int field1057;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -382522041
   )
   public int field1058;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 486567129
   )
   public int field1059;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1558716313
   )
   public int field1060;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 583406959
   )
   public int field1062;
   @ObfuscatedName("c")
   static int[] field1064;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -769304179
   )
   public int field1065;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1834822735
   )
   public int field1066 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -617867823
   )
   public int field1067 = -1;
   @ObfuscatedName("kv")
   static class131 field1068;
   @ObfuscatedName("w")
   static int[] field1069;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2073885228"
   )
   public void method931() {
      if(this.field1051 != -1) {
         this.method940(this.field1051);
         this.field1060 = this.field1057;
         this.field1065 = this.field1058;
         this.field1062 = this.field1059;
      }

      this.method940(this.field1066);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1972923266"
   )
   public void method932(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2494();
         if(var3 == 0) {
            return;
         }

         this.method933(var1, var3, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;III)V",
      garbageValue = "1212409731"
   )
   void method933(class119 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1066 = var1.method2472();
      } else if(var2 == 2) {
         this.field1067 = var1.method2494();
      } else if(var2 == 5) {
         this.field1055 = false;
      } else if(var2 == 7) {
         this.field1051 = var1.method2472();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "([Lclass173;Lclass173;ZB)V",
      garbageValue = "0"
   )
   static void method935(class173[] var0, class173 var1, boolean var2) {
      int var3 = var1.field2894 != 0?var1.field2894:var1.field2791;
      int var4 = var1.field2823 != 0?var1.field2823:var1.field2792;
      class20.method548(var0, var1.field2776, var3, var4, var2);
      if(null != var1.field2770) {
         class20.method548(var1.field2770, var1.field2776, var3, var4, var2);
      }

      class3 var5 = (class3)client.field443.method3748((long)var1.field2776);
      if(var5 != null) {
         int var6 = var5.field65;
         if(class173.method3380(var6)) {
            class20.method548(class216.field3168[var6], -1, var3, var4, var2);
         }
      }

      if(var1.field2780 == 1337) {
         ;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2137878655"
   )
   void method940(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1057 = (int)(var12 * 256.0D);
      this.field1058 = (int)(256.0D * var14);
      this.field1059 = (int)(var16 * 256.0D);
      if(this.field1058 < 0) {
         this.field1058 = 0;
      } else if(this.field1058 > 255) {
         this.field1058 = 255;
      }

      if(this.field1059 < 0) {
         this.field1059 = 0;
      } else if(this.field1059 > 255) {
         this.field1059 = 255;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1868061384"
   )
   static final void method948(int var0, int var1, int var2, int var3) {
      client.field377 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class32.field741;
      int[] var7 = class32.field742;

      int var8;
      for(var8 = 0; var8 < client.field293 + var6; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = client.field405[var7[var8]];
            if(var7[var8] == client.field484) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = client.field320[client.field322[var8 - var6]];
         }

         class11.method128((class37)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class11.method128(client.field405[client.field484], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < client.field377; ++var8) {
         int var19 = client.field554[var8];
         int var10 = client.field380[var8];
         int var11 = client.field430[var8];
         int var12 = client.field381[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(var10 + 2 > client.field380[var14] - client.field381[var14] && var10 - var12 < client.field380[var14] + 2 && var19 - var11 < client.field430[var14] + client.field554[var14] && var19 + var11 > client.field554[var14] - client.field430[var14] && client.field380[var14] - client.field381[var14] < var10) {
                  var10 = client.field380[var14] - client.field381[var14];
                  var13 = true;
               }
            }
         }

         client.field389 = client.field554[var8];
         client.field365 = client.field380[var8] = var10;
         String var18 = client.field447[var8];
         if(client.field444 == 0) {
            int var15 = 16776960;
            if(client.field550[var8] < 6) {
               var15 = client.field499[client.field550[var8]];
            }

            if(client.field550[var8] == 6) {
               var15 = client.field388 % 20 < 10?16711680:16776960;
            }

            if(client.field550[var8] == 7) {
               var15 = client.field388 % 20 < 10?255:'\uffff';
            }

            if(client.field550[var8] == 8) {
               var15 = client.field388 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(client.field550[var8] == 9) {
               var16 = 150 - client.field385[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 1280;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + '\uff00';
               }
            }

            if(client.field550[var8] == 10) {
               var16 = 150 - client.field385[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 5 * var16;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 327680 * (var16 - 100) + 255 - 5 * (var16 - 100);
               }
            }

            if(client.field550[var8] == 11) {
               var16 = 150 - client.field385[var8];
               if(var16 < 50) {
                  var15 = 16777215 - 327685 * var16;
               } else if(var16 < 100) {
                  var15 = 327685 * (var16 - 50) + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(client.field368[var8] == 0) {
               class4.field79.method3970(var18, var0 + client.field389, client.field365 + var1, var15, 0);
            }

            if(client.field368[var8] == 1) {
               class4.field79.method3972(var18, client.field389 + var0, var1 + client.field365, var15, 0, client.field388);
            }

            if(client.field368[var8] == 2) {
               class4.field79.method4055(var18, client.field389 + var0, client.field365 + var1, var15, 0, client.field388);
            }

            if(client.field368[var8] == 3) {
               class4.field79.method3974(var18, var0 + client.field389, var1 + client.field365, var15, 0, client.field388, 150 - client.field385[var8]);
            }

            if(client.field368[var8] == 4) {
               var16 = (150 - client.field385[var8]) * (class4.field79.method3963(var18) + 100) / 150;
               class79.method1800(client.field389 + var0 - 50, var1, client.field389 + var0 + 50, var3 + var1);
               class4.field79.method3968(var18, client.field389 + var0 + 50 - var16, var1 + client.field365, var15, 0);
               class79.method1753(var0, var1, var2 + var0, var3 + var1);
            }

            if(client.field368[var8] == 5) {
               var16 = 150 - client.field385[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class79.method1800(var0, client.field365 + var1 - class4.field79.field3193 - 1, var2 + var0, 5 + client.field365 + var1);
               class4.field79.method3970(var18, client.field389 + var0, var17 + var1 + client.field365, var15, 0);
               class79.method1753(var0, var1, var2 + var0, var1 + var3);
            }
         } else {
            class4.field79.method3970(var18, client.field389 + var0, var1 + client.field365, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "5"
   )
   static void method949(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field222.method3748((long)var0);
      if(null == var4) {
         var4 = new class15();
         class15.field222.method3749(var4, (long)var0);
      }

      if(var4.field220.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.field220.length; ++var7) {
            var5[var7] = var4.field220[var7];
            var6[var7] = var4.field221[var7];
         }

         for(var7 = var4.field220.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field220 = var5;
         var4.field221 = var6;
      }

      var4.field220[var1] = var2;
      var4.field221[var1] = var3;
   }
}
