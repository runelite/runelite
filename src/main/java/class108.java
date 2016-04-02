import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("CollisionData")
public class class108 {
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 820562603
   )
   int field1866;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 23453557
   )
   int field1875 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1963878757
   )
   int field1877;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -139838735
   )
   int field1879 = 0;
   @ObfuscatedName("bw")
   static class168 field1880;
   @ObfuscatedName("cm")
   public static char field1883;
   @ObfuscatedName("av")
   @Export("flags")
   public int[][] field1885;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1348057959"
   )
   public void method2407() {
      for(int var1 = 0; var1 < this.field1877; ++var1) {
         for(int var2 = 0; var2 < this.field1866; ++var2) {
            if(var1 != 0 && 0 != var2 && var1 < this.field1877 - 5 && var2 < this.field1866 - 5) {
               this.field1885[var1][var2] = 16777216;
            } else {
               this.field1885[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "38"
   )
   public void method2409(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1875;
      var2 -= this.field1879;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.field1877) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.field1866) {
                  this.method2419(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   public void method2411(int var1, int var2) {
      var1 -= this.field1875;
      var2 -= this.field1879;
      this.field1885[var1][var2] |= 262144;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "4"
   )
   public void method2412(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1875;
      var2 -= this.field1879;
      if(0 == var3) {
         if(var4 == 0) {
            this.method2419(var1, var2, 128);
            this.method2419(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2419(var1, var2, 2);
            this.method2419(var1, 1 + var2, 32);
         }

         if(2 == var4) {
            this.method2419(var1, var2, 8);
            this.method2419(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2419(var1, var2, 32);
            this.method2419(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || 3 == var3) {
         if(var4 == 0) {
            this.method2419(var1, var2, 1);
            this.method2419(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2419(var1, var2, 4);
            this.method2419(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2419(var1, var2, 16);
            this.method2419(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2419(var1, var2, 64);
            this.method2419(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(0 == var4) {
            this.method2419(var1, var2, 130);
            this.method2419(var1 - 1, var2, 8);
            this.method2419(var1, 1 + var2, 32);
         }

         if(1 == var4) {
            this.method2419(var1, var2, 10);
            this.method2419(var1, 1 + var2, 32);
            this.method2419(var1 + 1, var2, 128);
         }

         if(2 == var4) {
            this.method2419(var1, var2, 40);
            this.method2419(var1 + 1, var2, 128);
            this.method2419(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2419(var1, var2, 160);
            this.method2419(var1, var2 - 1, 2);
            this.method2419(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(0 == var4) {
               this.method2419(var1, var2, 65536);
               this.method2419(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2419(var1, var2, 1024);
               this.method2419(var1, 1 + var2, 16384);
            }

            if(2 == var4) {
               this.method2419(var1, var2, 4096);
               this.method2419(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2419(var1, var2, 16384);
               this.method2419(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || 3 == var3) {
            if(0 == var4) {
               this.method2419(var1, var2, 512);
               this.method2419(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2419(var1, var2, 2048);
               this.method2419(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2419(var1, var2, 8192);
               this.method2419(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2419(var1, var2, '耀');
               this.method2419(var1 - 1, var2 - 1, 2048);
            }
         }

         if(2 == var3) {
            if(0 == var4) {
               this.method2419(var1, var2, 66560);
               this.method2419(var1 - 1, var2, 4096);
               this.method2419(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2419(var1, var2, 5120);
               this.method2419(var1, var2 + 1, 16384);
               this.method2419(1 + var1, var2, 65536);
            }

            if(2 == var4) {
               this.method2419(var1, var2, 20480);
               this.method2419(1 + var1, var2, 65536);
               this.method2419(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2419(var1, var2, 81920);
               this.method2419(var1, var2 - 1, 1024);
               this.method2419(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "1"
   )
   public void method2413(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1875;
      var2 -= this.field1879;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2424(var1, var2, 128);
            this.method2424(var1 - 1, var2, 8);
         }

         if(1 == var4) {
            this.method2424(var1, var2, 2);
            this.method2424(var1, 1 + var2, 32);
         }

         if(2 == var4) {
            this.method2424(var1, var2, 8);
            this.method2424(var1 + 1, var2, 128);
         }

         if(3 == var4) {
            this.method2424(var1, var2, 32);
            this.method2424(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || 3 == var3) {
         if(var4 == 0) {
            this.method2424(var1, var2, 1);
            this.method2424(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2424(var1, var2, 4);
            this.method2424(var1 + 1, var2 + 1, 64);
         }

         if(2 == var4) {
            this.method2424(var1, var2, 16);
            this.method2424(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2424(var1, var2, 64);
            this.method2424(var1 - 1, var2 - 1, 4);
         }
      }

      if(2 == var3) {
         if(0 == var4) {
            this.method2424(var1, var2, 130);
            this.method2424(var1 - 1, var2, 8);
            this.method2424(var1, var2 + 1, 32);
         }

         if(1 == var4) {
            this.method2424(var1, var2, 10);
            this.method2424(var1, var2 + 1, 32);
            this.method2424(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2424(var1, var2, 40);
            this.method2424(var1 + 1, var2, 128);
            this.method2424(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2424(var1, var2, 160);
            this.method2424(var1, var2 - 1, 2);
            this.method2424(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(0 == var4) {
               this.method2424(var1, var2, 65536);
               this.method2424(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2424(var1, var2, 1024);
               this.method2424(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2424(var1, var2, 4096);
               this.method2424(var1 + 1, var2, 65536);
            }

            if(3 == var4) {
               this.method2424(var1, var2, 16384);
               this.method2424(var1, var2 - 1, 1024);
            }
         }

         if(1 == var3 || 3 == var3) {
            if(var4 == 0) {
               this.method2424(var1, var2, 512);
               this.method2424(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2424(var1, var2, 2048);
               this.method2424(var1 + 1, var2 + 1, '耀');
            }

            if(2 == var4) {
               this.method2424(var1, var2, 8192);
               this.method2424(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2424(var1, var2, '耀');
               this.method2424(var1 - 1, var2 - 1, 2048);
            }
         }

         if(2 == var3) {
            if(var4 == 0) {
               this.method2424(var1, var2, 66560);
               this.method2424(var1 - 1, var2, 4096);
               this.method2424(var1, var2 + 1, 16384);
            }

            if(1 == var4) {
               this.method2424(var1, var2, 5120);
               this.method2424(var1, 1 + var2, 16384);
               this.method2424(1 + var1, var2, 65536);
            }

            if(2 == var4) {
               this.method2424(var1, var2, 20480);
               this.method2424(var1 + 1, var2, 65536);
               this.method2424(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2424(var1, var2, 81920);
               this.method2424(var1, var2 - 1, 1024);
               this.method2424(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "379405847"
   )
   public void method2414(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1875;
      var2 -= this.field1879;
      int var8;
      if(1 == var5 || 3 == var5) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.field1877) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.field1866) {
                  this.method2424(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;Lclass224;ZI)V",
      garbageValue = "2096652696"
   )
   static void method2415(class224 var0, class224 var1, class224 var2, boolean var3) {
      if(var3) {
         class31.field696 = (class35.field762 - client.field493) / 2;
         class31.field699 = 202 + class31.field696;
      }

      byte var4;
      int var5;
      int var7;
      int var25;
      int var29;
      int var30;
      Graphics var36;
      if(class31.field721) {
         if(null == class119.field1983) {
            class119.field1983 = class122.method2774(class17.field246, "sl_back", "");
         }

         if(null == class89.field1536) {
            class89.field1536 = class133.method2848(class17.field246, "sl_flags", "");
         }

         if(class12.field182 == null) {
            class12.field182 = class133.method2848(class17.field246, "sl_arrows", "");
         }

         if(class52.field1138 == null) {
            class52.field1138 = class133.method2848(class17.field246, "sl_stars", "");
         }

         class79.method1809(class31.field696, 23, 765, 480, 0);
         class79.method1814(class31.field696, 0, 125, 23, 12425273, 9135624);
         class79.method1814(class31.field696 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4010("Select a world", class31.field696 + 62, 15, 0, -1);
         if(null != class52.field1138) {
            class52.field1138[1].method1880(140 + class31.field696, 1);
            var1.method4019("Members only world", class31.field696 + 152, 10, 16777215, -1);
            class52.field1138[0].method1880(140 + class31.field696, 12);
            var1.method4019("Free world", 152 + class31.field696, 21, 16777215, -1);
         }

         if(null != class12.field182) {
            var25 = class31.field696 + 280;
            if(class25.field619[0] == 0 && 0 == class25.field618[0]) {
               class12.field182[2].method1880(var25, 4);
            } else {
               class12.field182[0].method1880(var25, 4);
            }

            if(0 == class25.field619[0] && 1 == class25.field618[0]) {
               class12.field182[3].method1880(var25 + 15, 4);
            } else {
               class12.field182[1].method1880(15 + var25, 4);
            }

            var0.method4019("World", 32 + var25, 17, 16777215, -1);
            var5 = class31.field696 + 390;
            if(1 == class25.field619[0] && 0 == class25.field618[0]) {
               class12.field182[2].method1880(var5, 4);
            } else {
               class12.field182[0].method1880(var5, 4);
            }

            if(1 == class25.field619[0] && class25.field618[0] == 1) {
               class12.field182[3].method1880(15 + var5, 4);
            } else {
               class12.field182[1].method1880(var5 + 15, 4);
            }

            var0.method4019("Players", var5 + 32, 17, 16777215, -1);
            var30 = class31.field696 + 500;
            if(class25.field619[0] == 2 && class25.field618[0] == 0) {
               class12.field182[2].method1880(var30, 4);
            } else {
               class12.field182[0].method1880(var30, 4);
            }

            if(class25.field619[0] == 2 && 1 == class25.field618[0]) {
               class12.field182[3].method1880(15 + var30, 4);
            } else {
               class12.field182[1].method1880(15 + var30, 4);
            }

            var0.method4019("Location", var30 + 32, 17, 16777215, -1);
            var7 = class31.field696 + 610;
            if(class25.field619[0] == 3 && class25.field618[0] == 0) {
               class12.field182[2].method1880(var7, 4);
            } else {
               class12.field182[0].method1880(var7, 4);
            }

            if(class25.field619[0] == 3 && 1 == class25.field618[0]) {
               class12.field182[3].method1880(var7 + 15, 4);
            } else {
               class12.field182[1].method1880(var7 + 15, 4);
            }

            var0.method4019("Type", 32 + var7, 17, 16777215, -1);
         }

         class79.method1809(708 + class31.field696, 4, 50, 16, 0);
         var1.method4010("Cancel", 25 + 708 + class31.field696, 16, 16777215, -1);
         class31.field700 = -1;
         if(null != class119.field1983) {
            var4 = 88;
            byte var33 = 19;
            var30 = 765 / (var4 + 1);
            var7 = 480 / (1 + var33);

            int var32;
            do {
               var29 = var7;
               var32 = var30;
               if((var30 - 1) * var7 >= class25.field616) {
                  --var30;
               }

               if(var30 * (var7 - 1) >= class25.field616) {
                  --var7;
               }

               if((var7 - 1) * var30 >= class25.field616) {
                  --var7;
               }
            } while(var29 != var7 || var32 != var30);

            var29 = (765 - var4 * var30) / (var30 + 1);
            if(var29 > 5) {
               var29 = 5;
            }

            var32 = (480 - var7 * var33) / (var7 + 1);
            if(var32 > 5) {
               var32 = 5;
            }

            int var10 = (765 - var30 * var4 - (var30 - 1) * var29) / 2;
            int var11 = (480 - var33 * var7 - (var7 - 1) * var32) / 2;
            int var12 = var11 + 23;
            int var13 = class31.field696 + var10;
            int var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < class25.field616; ++var16) {
               class25 var17 = class25.field615[var16];
               boolean var18 = true;
               String var19 = Integer.toString(var17.field622);
               if(-1 == var17.field622) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.field622 > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var20;
               if(var17.method604()) {
                  if(var17.method628()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method600()) {
                  var21 = 16711680;
                  if(var17.method628()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method598()) {
                  if(var17.method628()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method628()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class140.field2140 >= var13 && class140.field2141 >= var12 && class140.field2140 < var4 + var13 && class140.field2141 < var12 + var33 && var18) {
                  class31.field700 = var16;
                  class119.field1983[var20].method1716(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class119.field1983[var20].method1741(var13, var12);
               }

               if(class89.field1536 != null) {
                  class89.field1536[(var17.method628()?8:0) + var17.field625].method1880(var13 + 29, var12);
               }

               var0.method4010(Integer.toString(var17.field620), 15 + var13, var33 / 2 + var12 + 5, var21, -1);
               var1.method4010(var19, var13 + 60, 5 + var33 / 2 + var12, 268435455, -1);
               var12 += var33 + var32;
               ++var14;
               if(var14 >= var7) {
                  var12 = 23 + var11;
                  var13 += var29 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4074(class25.field615[class31.field700].field624) + 6;
               int var35 = 8 + var1.field3188;
               class79.method1809(class140.field2140 - var16 / 2, 20 + class140.field2141 + 5, var16, var35, 16777120);
               class79.method1801(class140.field2140 - var16 / 2, class140.field2141 + 20 + 5, var16, var35, 0);
               var1.method4010(class25.field615[class31.field700].field624, class140.field2140, 4 + var1.field3188 + 5 + class140.field2141 + 20, 0, -1);
            }
         }

         try {
            var36 = class12.field192.getGraphics();
            class134.field2070.vmethod1886(var36, 0, 0);
         } catch (Exception var22) {
            class12.field192.repaint();
         }

      } else {
         if(var3) {
            class31.field720.method1741(class31.field696, 0);
            class13.field199.method1741(382 + class31.field696, 0);
            class31.field704.method1880(class31.field696 + 382 - class31.field704.field1390 / 2, 18);
         }

         if(0 == client.field287 || 5 == client.field287) {
            var4 = 20;
            var0.method4010("RuneScape is loading - please wait...", class31.field699 + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1801(class31.field699 + 180 - 152, var5, 304, 34, 9179409);
            class79.method1801(180 + class31.field699 - 151, 1 + var5, 302, 32, 0);
            class79.method1809(class31.field699 + 180 - 150, var5 + 2, class31.field707 * 3, 30, 9179409);
            class79.method1809(class31.field707 * 3 + (class31.field699 + 180 - 150), 2 + var5, 300 - class31.field707 * 3, 30, 0);
            var0.method4010(class31.field722, class31.field699 + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var24;
         short var26;
         if(20 == client.field287) {
            class31.field694.method1880(180 + class31.field699 - class31.field694.field1390 / 2, 271 - class31.field694.field1391 / 2);
            var24 = 211;
            var0.method4010(class31.field711, class31.field699 + 180, var24, 16776960, 0);
            var25 = var24 + 15;
            var0.method4010(class31.field712, 180 + class31.field699, var25, 16776960, 0);
            var25 += 15;
            var0.method4010(class31.field713, class31.field699 + 180, var25, 16776960, 0);
            var25 += 15;
            var25 += 10;
            if(class31.field702 != 4) {
               var0.method4019("Login: ", 180 + class31.field699 - 110, var25, 16777215, 0);
               var26 = 200;

               for(var6 = class31.field703; var0.method4074(var6) > var26; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4019(class223.method4072(var6), 180 + class31.field699 - 70, var25, 16777215, 0);
               var25 += 15;
               var0.method4019("Password: " + class27.method649(class31.field715), 180 + class31.field699 - 108, var25, 16777215, 0);
               var25 += 15;
            }
         }

         if(10 == client.field287 || client.field287 == 11) {
            class31.field694.method1880(class31.field699, 171);
            short var27;
            if(0 == class31.field702) {
               var24 = 251;
               var0.method4010("Welcome to RuneScape", class31.field699 + 180, var24, 16776960, 0);
               var25 = var24 + 30;
               var5 = 180 + class31.field699 - 80;
               var27 = 291;
               class189.field3044.method1880(var5 - 73, var27 - 20);
               var0.method4022("New User", var5 - 73, var27 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class31.field699 + 180;
               class189.field3044.method1880(var5 - 73, var27 - 20);
               var0.method4022("Existing User", var5 - 73, var27 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(1 == class31.field702) {
               var0.method4010(class31.field710, class31.field699 + 180, 211, 16776960, 0);
               var24 = 236;
               var0.method4010(class31.field711, 180 + class31.field699, var24, 16777215, 0);
               var25 = var24 + 15;
               var0.method4010(class31.field712, class31.field699 + 180, var25, 16777215, 0);
               var25 += 15;
               var0.method4010(class31.field713, class31.field699 + 180, var25, 16777215, 0);
               var25 += 15;
               var5 = 180 + class31.field699 - 80;
               var27 = 321;
               class189.field3044.method1880(var5 - 73, var27 - 20);
               var0.method4010("Continue", var5, 5 + var27, 16777215, 0);
               var5 = 80 + 180 + class31.field699;
               class189.field3044.method1880(var5 - 73, var27 - 20);
               var0.method4010("Cancel", var5, var27 + 5, 16777215, 0);
            } else {
               short var8;
               if(class31.field702 == 2) {
                  var24 = 211;
                  var0.method4010(class31.field711, 180 + class31.field699, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var0.method4010(class31.field712, 180 + class31.field699, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4010(class31.field713, class31.field699 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var25 += 10;
                  var0.method4019("Login: ", 180 + class31.field699 - 110, var25, 16777215, 0);
                  var26 = 200;

                  for(var6 = class31.field703; var0.method4074(var6) > var26; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4019(class223.method4072(var6) + (class31.field718 == 0 & client.field289 % 40 < 20?class39.method784(16776960) + "|":""), class31.field699 + 180 - 70, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4019("Password: " + class27.method649(class31.field715) + (class31.field718 == 1 & client.field289 % 40 < 20?class39.method784(16776960) + "|":""), 180 + class31.field699 - 108, var25, 16777215, 0);
                  var25 += 15;
                  var7 = class31.field699 + 180 - 80;
                  var8 = 321;
                  class189.field3044.method1880(var7 - 73, var8 - 20);
                  var0.method4010("Login", var7, var8 + 5, 16777215, 0);
                  var7 = 80 + 180 + class31.field699;
                  class189.field3044.method1880(var7 - 73, var8 - 20);
                  var0.method4010("Cancel", var7, 5 + var8, 16777215, 0);
                  var24 = 357;
                  var1.method4010("Forgotten your password? <col=ffffff>Click here.", 180 + class31.field699, var24, 16776960, 0);
               } else if(3 == class31.field702) {
                  var24 = 201;
                  var0.method4010("Invalid username or password.", 180 + class31.field699, var24, 16776960, 0);
                  var25 = var24 + 20;
                  var1.method4010("For accounts created after 24th November 2010, please use your", class31.field699 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var1.method4010("email address to login. Otherwise please login with your username.", class31.field699 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var5 = class31.field699 + 180;
                  var27 = 276;
                  class189.field3044.method1880(var5 - 73, var27 - 20);
                  var2.method4010("Try again", var5, 5 + var27, 16777215, 0);
                  var5 = class31.field699 + 180;
                  var27 = 326;
                  class189.field3044.method1880(var5 - 73, var27 - 20);
                  var2.method4010("Forgotten password?", var5, var27 + 5, 16777215, 0);
               } else if(class31.field702 == 4) {
                  var0.method4010("Authenticator", 180 + class31.field699, 211, 16776960, 0);
                  var24 = 236;
                  var0.method4010(class31.field711, class31.field699 + 180, var24, 16777215, 0);
                  var25 = var24 + 15;
                  var0.method4010(class31.field712, 180 + class31.field699, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4010(class31.field713, class31.field699 + 180, var25, 16777215, 0);
                  var25 += 15;
                  var0.method4019("PIN: " + class27.method649(class9.field153) + (client.field289 % 40 < 20?class39.method784(16776960) + "|":""), 180 + class31.field699 - 108, var25, 16777215, 0);
                  var25 -= 8;
                  var0.method4019("Trust this computer", 180 + class31.field699 - 9, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4019("for 30 days: ", class31.field699 + 180 - 9, var25, 16776960, 0);
                  var5 = 180 + class31.field699 - 9 + var0.method4074("for 30 days: ") + 15;
                  var30 = var25 - var0.field3188;
                  class80 var28;
                  if(class31.field717) {
                     var28 = class34.field757;
                  } else {
                     var28 = class31.field705;
                  }

                  var28.method1880(var5, var30);
                  var25 += 15;
                  var29 = 180 + class31.field699 - 80;
                  short var9 = 321;
                  class189.field3044.method1880(var29 - 73, var9 - 20);
                  var0.method4010("Continue", var29, 5 + var9, 16777215, 0);
                  var29 = class31.field699 + 180 + 80;
                  class189.field3044.method1880(var29 - 73, var9 - 20);
                  var0.method4010("Cancel", var29, 5 + var9, 16777215, 0);
                  var1.method4010("<u=ff>Can\'t Log In?</u>", 180 + class31.field699, var9 + 36, 255, 0);
               } else if(class31.field702 == 5) {
                  var0.method4010("Forgotten your password?", 180 + class31.field699, 201, 16776960, 0);
                  var24 = 221;
                  var2.method4010(class31.field711, 180 + class31.field699, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var2.method4010(class31.field712, class31.field699 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var2.method4010(class31.field713, class31.field699 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var25 += 14;
                  var0.method4019("Username/email: ", 180 + class31.field699 - 145, var25, 16777215, 0);
                  var26 = 174;

                  for(var6 = class31.field703; var0.method4074(var6) > var26; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4019(class223.method4072(var6) + (client.field289 % 40 < 20?class39.method784(16776960) + "|":""), class31.field699 + 180 - 34, var25, 16777215, 0);
                  var25 += 15;
                  var7 = 180 + class31.field699 - 80;
                  var8 = 321;
                  class189.field3044.method1880(var7 - 73, var8 - 20);
                  var0.method4010("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = 80 + 180 + class31.field699;
                  class189.field3044.method1880(var7 - 73, var8 - 20);
                  var0.method4010("Back", var7, 5 + var8, 16777215, 0);
               } else if(class31.field702 == 6) {
                  var24 = 211;
                  var0.method4010(class31.field711, class31.field699 + 180, var24, 16776960, 0);
                  var25 = var24 + 15;
                  var0.method4010(class31.field712, class31.field699 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var0.method4010(class31.field713, class31.field699 + 180, var25, 16776960, 0);
                  var25 += 15;
                  var5 = 180 + class31.field699;
                  var27 = 321;
                  class189.field3044.method1880(var5 - 73, var27 - 20);
                  var0.method4010("Back", var5, 5 + var27, 16777215, 0);
               }
            }
         }

         if(class31.field714 > 0) {
            class99.method2215(class31.field714);
            class31.field714 = 0;
         }

         class41.method840();
         class18.field260[class39.field865.field145?1:0].method1880(class31.field696 + 765 - 40, 463);
         if(client.field287 > 5 && client.field286 == 0) {
            if(null != class99.field1662) {
               var25 = class31.field696 + 5;
               var26 = 463;
               byte var34 = 100;
               byte var31 = 35;
               class99.field1662.method1880(var25, var26);
               var0.method4010("World" + " " + client.field279, var34 / 2 + var25, var31 / 2 + var26 - 2, 16777215, 0);
               if(null != class27.field652) {
                  var1.method4010("Loading...", var25 + var34 / 2, 12 + var26 + var31 / 2, 16777215, 0);
               } else {
                  var1.method4010("Click to switch", var34 / 2 + var25, var26 + var31 / 2 + 12, 16777215, 0);
               }
            } else {
               class99.field1662 = class16.method178(class17.field246, "sl_button", "");
            }
         }

         try {
            var36 = class12.field192.getGraphics();
            class134.field2070.vmethod1886(var36, 0, 0);
         } catch (Exception var23) {
            class12.field192.repaint();
         }

      }
   }

   public class108(int var1, int var2) {
      this.field1877 = var1;
      this.field1866 = var2;
      this.field1885 = new int[this.field1877][this.field1866];
      this.method2407();
   }

   @ObfuscatedName("h")
   void method2419(int var1, int var2, int var3) {
      this.field1885[var1][var2] |= var3;
   }

   @ObfuscatedName("s")
   public void method2423(int var1, int var2) {
      var1 -= this.field1875;
      var2 -= this.field1879;
      this.field1885[var1][var2] |= 2097152;
   }

   @ObfuscatedName("r")
   void method2424(int var1, int var2, int var3) {
      this.field1885[var1][var2] &= ~var3;
   }

   @ObfuscatedName("k")
   public void method2438(int var1, int var2) {
      var1 -= this.field1875;
      var2 -= this.field1879;
      this.field1885[var1][var2] &= -262145;
   }
}
