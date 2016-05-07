import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class41 extends class204 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1022940477
   )
   public int field973;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1687870475
   )
   int field975 = 0;
   @ObfuscatedName("j")
   static class193 field976 = new class193(64);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1457936419
   )
   public int field977;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -284476781
   )
   public int field978;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1923922385
   )
   public int field979;
   @ObfuscatedName("s")
   public static class167 field981;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-831293133"
   )
   void method811() {
      this.method814(this.field975);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "38"
   )
   void method812(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2492();
         if(var3 == 0) {
            return;
         }

         this.method813(var1, var3, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;III)V",
      garbageValue = "-7014343"
   )
   void method813(class119 var1, int var2, int var3) {
      if(1 == var2) {
         this.field975 = var1.method2513();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1464796821"
   )
   void method814(int var1) {
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
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field977 = (int)(256.0D * var14);
      this.field978 = (int)(var16 * 256.0D);
      if(this.field977 < 0) {
         this.field977 = 0;
      } else if(this.field977 > 255) {
         this.field977 = 255;
      }

      if(this.field978 < 0) {
         this.field978 = 0;
      } else if(this.field978 > 255) {
         this.field978 = 255;
      }

      if(var16 > 0.5D) {
         this.field979 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field979 = (int)(var16 * var14 * 512.0D);
      }

      if(this.field979 < 1) {
         this.field979 = 1;
      }

      this.field973 = (int)((double)this.field979 * var12);
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "2109703118"
   )
   static final void method833(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field410 + client.field364 & 2047;
         int var8 = class91.field1596[var7];
         int var9 = class91.field1597[var7];
         var8 = 256 * var8 / (256 + client.field353);
         var9 = var9 * 256 / (client.field353 + 256);
         int var10 = var2 * var9 + var8 * var3 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class24.field620.method1688(4 + var14 + var0 + 94 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class13.method164(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-748216172"
   )
   static final void method834(int var0, int var1, int var2, int var3) {
      client.field373 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class32.field755;
      int[] var7 = class32.field756;

      int var8;
      for(var8 = 0; var8 < client.field317 + var6; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = client.field491[var7[var8]];
            if(var7[var8] == client.field409) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = client.field515[client.field318[var8 - var6]];
         }

         class9.method126((class37)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class9.method126(client.field491[client.field409], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < client.field373; ++var8) {
         int var18 = client.field375[var8];
         int var10 = client.field376[var8];
         int var11 = client.field466[var8];
         int var12 = client.field377[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > client.field376[var14] - client.field377[var14] && var10 - var12 < client.field376[var14] + 2 && var18 - var11 < client.field375[var14] + client.field466[var14] && var11 + var18 > client.field375[var14] - client.field466[var14] && client.field376[var14] - client.field377[var14] < var10) {
                  var10 = client.field376[var14] - client.field377[var14];
                  var13 = true;
               }
            }
         }

         client.field385 = client.field375[var8];
         client.field386 = client.field376[var8] = var10;
         String var19 = client.field384[var8];
         if(0 == client.field439) {
            int var15 = 16776960;
            if(client.field379[var8] < 6) {
               var15 = client.field494[client.field379[var8]];
            }

            if(client.field379[var8] == 6) {
               var15 = client.field275 % 20 < 10?16711680:16776960;
            }

            if(client.field379[var8] == 7) {
               var15 = client.field275 % 20 < 10?255:'\uffff';
            }

            if(client.field379[var8] == 8) {
               var15 = client.field275 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(9 == client.field379[var8]) {
               var16 = 150 - client.field381[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 5 * (var16 - 100) + '\uff00';
               }
            }

            if(10 == client.field379[var8]) {
               var16 = 150 - client.field381[var8];
               if(var16 < 50) {
                  var15 = 5 * var16 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 255 + (var16 - 100) * 327680 - 5 * (var16 - 100);
               }
            }

            if(client.field379[var8] == 11) {
               var16 = 150 - client.field381[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(0 == client.field380[var8]) {
               class164.field2665.method4004(var19, var0 + client.field385, client.field386 + var1, var15, 0);
            }

            if(client.field380[var8] == 1) {
               class164.field2665.method4006(var19, client.field385 + var0, client.field386 + var1, var15, 0, client.field275);
            }

            if(2 == client.field380[var8]) {
               class164.field2665.method4007(var19, client.field385 + var0, client.field386 + var1, var15, 0, client.field275);
            }

            if(client.field380[var8] == 3) {
               class164.field2665.method3996(var19, var0 + client.field385, client.field386 + var1, var15, 0, client.field275, 150 - client.field381[var8]);
            }

            if(client.field380[var8] == 4) {
               var16 = (150 - client.field381[var8]) * (class164.field2665.method3997(var19) + 100) / 150;
               class79.method1768(var0 + client.field385 - 50, var1, 50 + var0 + client.field385, var1 + var3);
               class164.field2665.method4002(var19, 50 + client.field385 + var0 - var16, client.field386 + var1, var15, 0);
               class79.method1767(var0, var1, var0 + var2, var1 + var3);
            }

            if(5 == client.field380[var8]) {
               var16 = 150 - client.field381[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class79.method1768(var0, var1 + client.field386 - class164.field2665.field3189 - 1, var2 + var0, client.field386 + var1 + 5);
               class164.field2665.method4004(var19, client.field385 + var0, var1 + client.field386 + var17, var15, 0);
               class79.method1767(var0, var1, var0 + var2, var1 + var3);
            }
         } else {
            class164.field2665.method4004(var19, client.field385 + var0, client.field386 + var1, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "1"
   )
   static void method835(int var0, int var1, int var2, int var3) {
      class173 var4 = class45.method932(var0, var1);
      if(var4 != null && var4.field2892 != null) {
         class0 var5 = new class0();
         var5.field8 = var4;
         var5.field12 = var4.field2892;
         class16.method197(var5);
      }

      client.field434 = var3;
      client.field432 = true;
      class159.field2613 = var0;
      client.field307 = var1;
      class89.field1555 = var2;
      class34.method701(var4);
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1"
   )
   static void method836(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class51.field1110; ++var4) {
         class51 var5 = class9.method128(var4);
         if(var5.field1154 && -1 == var5.field1147 && var5.field1128.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class5.field95 = -1;
               class37.field873 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class37.field873 = var2;
      class48.field1083 = 0;
      class5.field95 = var3;
      String[] var8 = new String[class5.field95];

      for(int var9 = 0; var9 < class5.field95; ++var9) {
         var8[var9] = class9.method128(var2[var9]).field1128;
      }

      short[] var10 = class37.field873;
      class115.method2440(var8, var10, 0, var8.length - 1);
   }
}
