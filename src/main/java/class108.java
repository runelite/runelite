import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("CollisionData")
public class class108 {
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -514342687
   )
   int field1891;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -2059925091
   )
   int field1892 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1012001791
   )
   int field1893 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1958484617
   )
   int field1895;
   @ObfuscatedName("ax")
   @Export("flags")
   public int[][] field1896;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1841053641"
   )
   public void method2487(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1892;
      var2 -= this.field1893;
      if(0 == var3) {
         if(var4 == 0) {
            this.method2510(var1, var2, 128);
            this.method2510(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2510(var1, var2, 2);
            this.method2510(var1, var2 + 1, 32);
         }

         if(2 == var4) {
            this.method2510(var1, var2, 8);
            this.method2510(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2510(var1, var2, 32);
            this.method2510(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || 3 == var3) {
         if(var4 == 0) {
            this.method2510(var1, var2, 1);
            this.method2510(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2510(var1, var2, 4);
            this.method2510(1 + var1, 1 + var2, 64);
         }

         if(2 == var4) {
            this.method2510(var1, var2, 16);
            this.method2510(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2510(var1, var2, 64);
            this.method2510(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2510(var1, var2, 130);
            this.method2510(var1 - 1, var2, 8);
            this.method2510(var1, var2 + 1, 32);
         }

         if(1 == var4) {
            this.method2510(var1, var2, 10);
            this.method2510(var1, var2 + 1, 32);
            this.method2510(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2510(var1, var2, 40);
            this.method2510(1 + var1, var2, 128);
            this.method2510(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2510(var1, var2, 160);
            this.method2510(var1, var2 - 1, 2);
            this.method2510(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(0 == var3) {
            if(0 == var4) {
               this.method2510(var1, var2, 65536);
               this.method2510(var1 - 1, var2, 4096);
            }

            if(1 == var4) {
               this.method2510(var1, var2, 1024);
               this.method2510(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2510(var1, var2, 4096);
               this.method2510(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2510(var1, var2, 16384);
               this.method2510(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || 3 == var3) {
            if(var4 == 0) {
               this.method2510(var1, var2, 512);
               this.method2510(var1 - 1, var2 + 1, 8192);
            }

            if(1 == var4) {
               this.method2510(var1, var2, 2048);
               this.method2510(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2510(var1, var2, 8192);
               this.method2510(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2510(var1, var2, '耀');
               this.method2510(var1 - 1, var2 - 1, 2048);
            }
         }

         if(2 == var3) {
            if(var4 == 0) {
               this.method2510(var1, var2, 66560);
               this.method2510(var1 - 1, var2, 4096);
               this.method2510(var1, 1 + var2, 16384);
            }

            if(1 == var4) {
               this.method2510(var1, var2, 5120);
               this.method2510(var1, var2 + 1, 16384);
               this.method2510(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2510(var1, var2, 20480);
               this.method2510(var1 + 1, var2, 65536);
               this.method2510(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2510(var1, var2, 81920);
               this.method2510(var1, var2 - 1, 1024);
               this.method2510(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "464830765"
   )
   public void method2488() {
      for(int var1 = 0; var1 < this.field1891; ++var1) {
         for(int var2 = 0; var2 < this.field1895; ++var2) {
            if(0 != var1 && var2 != 0 && var1 < this.field1891 - 5 && var2 < this.field1895 - 5) {
               this.field1896[var1][var2] = 16777216;
            } else {
               this.field1896[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1900185499"
   )
   public void method2489(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1892;
      var2 -= this.field1893;
      if(0 == var3) {
         if(var4 == 0) {
            this.method2502(var1, var2, 128);
            this.method2502(var1 - 1, var2, 8);
         }

         if(1 == var4) {
            this.method2502(var1, var2, 2);
            this.method2502(var1, 1 + var2, 32);
         }

         if(2 == var4) {
            this.method2502(var1, var2, 8);
            this.method2502(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2502(var1, var2, 32);
            this.method2502(var1, var2 - 1, 2);
         }
      }

      if(1 == var3 || var3 == 3) {
         if(0 == var4) {
            this.method2502(var1, var2, 1);
            this.method2502(var1 - 1, 1 + var2, 16);
         }

         if(1 == var4) {
            this.method2502(var1, var2, 4);
            this.method2502(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2502(var1, var2, 16);
            this.method2502(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2502(var1, var2, 64);
            this.method2502(var1 - 1, var2 - 1, 4);
         }
      }

      if(2 == var3) {
         if(0 == var4) {
            this.method2502(var1, var2, 130);
            this.method2502(var1 - 1, var2, 8);
            this.method2502(var1, 1 + var2, 32);
         }

         if(1 == var4) {
            this.method2502(var1, var2, 10);
            this.method2502(var1, 1 + var2, 32);
            this.method2502(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2502(var1, var2, 40);
            this.method2502(var1 + 1, var2, 128);
            this.method2502(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2502(var1, var2, 160);
            this.method2502(var1, var2 - 1, 2);
            this.method2502(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(0 == var3) {
            if(var4 == 0) {
               this.method2502(var1, var2, 65536);
               this.method2502(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2502(var1, var2, 1024);
               this.method2502(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2502(var1, var2, 4096);
               this.method2502(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2502(var1, var2, 16384);
               this.method2502(var1, var2 - 1, 1024);
            }
         }

         if(1 == var3 || var3 == 3) {
            if(0 == var4) {
               this.method2502(var1, var2, 512);
               this.method2502(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2502(var1, var2, 2048);
               this.method2502(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2502(var1, var2, 8192);
               this.method2502(1 + var1, var2 - 1, 512);
            }

            if(3 == var4) {
               this.method2502(var1, var2, '耀');
               this.method2502(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(0 == var4) {
               this.method2502(var1, var2, 66560);
               this.method2502(var1 - 1, var2, 4096);
               this.method2502(var1, 1 + var2, 16384);
            }

            if(1 == var4) {
               this.method2502(var1, var2, 5120);
               this.method2502(var1, var2 + 1, 16384);
               this.method2502(var1 + 1, var2, 65536);
            }

            if(2 == var4) {
               this.method2502(var1, var2, 20480);
               this.method2502(1 + var1, var2, 65536);
               this.method2502(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2502(var1, var2, 81920);
               this.method2502(var1, var2 - 1, 1024);
               this.method2502(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "2141895435"
   )
   public void method2490(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1892;
      var2 -= this.field1893;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.field1891) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.field1895) {
                  this.method2502(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "98776300"
   )
   public void method2492(int var1, int var2) {
      var1 -= this.field1892;
      var2 -= this.field1893;
      this.field1896[var1][var2] |= 262144;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1056389253"
   )
   public void method2495(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1892;
      var2 -= this.field1893;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var1 + var3; ++var8) {
         if(var8 >= 0 && var8 < this.field1891) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.field1895) {
                  this.method2510(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-727902464"
   )
   public void method2496(int var1, int var2) {
      var1 -= this.field1892;
      var2 -= this.field1893;
      this.field1896[var1][var2] |= 2097152;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1373090344"
   )
   public void method2497(int var1, int var2) {
      var1 -= this.field1892;
      var2 -= this.field1893;
      this.field1896[var1][var2] &= -262145;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public class108(int var1, int var2) {
      this.field1891 = var1;
      this.field1895 = var2;
      this.field1896 = new int[this.field1891][this.field1895];
      this.method2488();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "943039492"
   )
   void method2502(int var1, int var2, int var3) {
      this.field1896[var1][var2] |= var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;B)I",
      garbageValue = "124"
   )
   static final int method2503(long var0, String var2) {
      Random var3 = new Random();
      class119 var4 = new class119(128);
      class119 var5 = new class119(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2603(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2786(var3.nextInt());
      }

      var4.method2786(var6[0]);
      var4.method2786(var6[1]);
      var4.method2716(var0);
      var4.method2716(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2786(var3.nextInt());
      }

      var4.method2633(class9.field160, class9.field161);
      var5.method2603(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2786(var3.nextInt());
      }

      var5.method2716(var3.nextLong());
      var5.method2685(var3.nextLong());
      byte[] var22 = new byte[24];

      try {
         class149.field2234.method4222(0L);
         class149.field2234.method4224(var22);

         int var8;
         for(var8 = 0; var8 < 24 && 0 == var22[var8]; ++var8) {
            ;
         }

         if(var8 >= 24) {
            throw new IOException();
         }
      } catch (Exception var20) {
         for(int var9 = 0; var9 < 24; ++var9) {
            var22[var9] = -1;
         }
      }

      var5.method2607(var22, 0, 24);
      var5.method2716(var3.nextLong());
      var5.method2633(class9.field160, class9.field161);
      var7 = class104.method2383(var2);
      if(0 != var7 % 8) {
         var7 += 8 - var7 % 8;
      }

      class119 var21 = new class119(var7);
      var21.method2694(var2);
      var21.field1992 = var7;
      var21.method2806(var6);
      class119 var23 = new class119(var21.field1992 + 5 + var4.field1992 + var5.field1992);
      var23.method2603(2);
      var23.method2603(var4.field1992);
      var23.method2607(var4.field1993, 0, var4.field1992);
      var23.method2603(var5.field1992);
      var23.method2607(var5.field1993, 0, var5.field1992);
      var23.method2599(var21.field1992);
      var23.method2607(var21.field1993, 0, var21.field1992);
      String var10 = class37.method848(var23.field1993);

      try {
         URL var11 = new URL(class17.method218("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class84.method1996(var10) + "&dest=" + class84.method1996("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var23 = new class119(new byte[1000]);

         do {
            int var15 = var14.read(var23.field1993, var23.field1992, 1000 - var23.field1992);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var24 = new String(var23.field1993);
               if(var24.startsWith("OFFLINE")) {
                  return 4;
               } else if(var24.startsWith("WRONG")) {
                  return 7;
               } else if(var24.startsWith("RELOAD")) {
                  return 3;
               } else if(var24.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var23.method2654(var6);

                  while(var23.field1992 > 0 && 0 == var23.field1993[var23.field1992 - 1]) {
                     --var23.field1992;
                  }

                  var24 = new String(var23.field1993, 0, var23.field1992);
                  boolean var16;
                  if(null == var24) {
                     var16 = false;
                  } else {
                     label98: {
                        try {
                           new URL(var24);
                        } catch (MalformedURLException var18) {
                           var16 = false;
                           break label98;
                        }

                        var16 = true;
                     }
                  }

                  if(var16) {
                     class23.method670(var24, true, "openjs", false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var23.field1992 += var15;
         } while(var23.field1992 < 1000);

         return 5;
      } catch (Throwable var19) {
         var19.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-89"
   )
   void method2510(int var1, int var2, int var3) {
      this.field1896[var1][var2] &= ~var3;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "-319434141"
   )
   static final void method2519(class37 var0) {
      int var1 = var0.field862 - client.field306;
      int var2 = var0.field841 * 64 + var0.field858 * 128;
      int var3 = var0.field860 * 128 + var0.field841 * 64;
      var0.field844 += (var2 - var0.field844) / var1;
      var0.field819 += (var3 - var0.field819) / var1;
      var0.field874 = 0;
      var0.field853 = var0.field864;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass103;",
      garbageValue = "-1767647414"
   )
   static class103 method2520(int var0) {
      class103 var1 = (class103)class42.field991.method3840((long)var0);
      if(null != var1) {
         return var1;
      } else {
         var1 = class0.method0(class42.field1008, class114.field1962, var0, false);
         if(var1 != null) {
            class42.field991.method3842(var1, (long)var0);
         }

         return var1;
      }
   }
}
