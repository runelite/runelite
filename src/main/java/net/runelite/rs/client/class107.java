import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
@Implements("CollisionData")
public class class107 {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1083038299
   )
   int field1895 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 109623625
   )
   int field1901 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1926714977
   )
   int field1902;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1724288601
   )
   int field1903;
   @ObfuscatedName("ag")
   @Export("flags")
   public int[][] field1904;
   @ObfuscatedName("dq")
   @Export("region")
   static class85 field1906;

   @ObfuscatedName("j")
   public void method2341() {
      for(int var1 = 0; var1 < this.field1902; ++var1) {
         for(int var2 = 0; var2 < this.field1903; ++var2) {
            if(var1 != 0 && 0 != var2 && var1 < this.field1902 - 5 && var2 < this.field1903 - 5) {
               this.field1904[var1][var2] = 16777216;
            } else {
               this.field1904[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("a")
   public void method2342(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1895;
      var2 -= this.field1901;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.field1902) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.field1903) {
                  this.method2370(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   public void method2344(int var1, int var2) {
      var1 -= this.field1895;
      var2 -= this.field1901;
      this.field1904[var1][var2] |= 2097152;
   }

   @ObfuscatedName("f")
   public void method2345(int var1, int var2) {
      var1 -= this.field1895;
      var2 -= this.field1901;
      this.field1904[var1][var2] |= 262144;
   }

   @ObfuscatedName("o")
   public void method2347(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1895;
      var2 -= this.field1901;
      if(0 == var3) {
         if(var4 == 0) {
            this.method2352(var1, var2, 128);
            this.method2352(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2352(var1, var2, 2);
            this.method2352(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2352(var1, var2, 8);
            this.method2352(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2352(var1, var2, 32);
            this.method2352(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || 3 == var3) {
         if(0 == var4) {
            this.method2352(var1, var2, 1);
            this.method2352(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2352(var1, var2, 4);
            this.method2352(var1 + 1, 1 + var2, 64);
         }

         if(2 == var4) {
            this.method2352(var1, var2, 16);
            this.method2352(1 + var1, var2 - 1, 1);
         }

         if(3 == var4) {
            this.method2352(var1, var2, 64);
            this.method2352(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2352(var1, var2, 130);
            this.method2352(var1 - 1, var2, 8);
            this.method2352(var1, var2 + 1, 32);
         }

         if(1 == var4) {
            this.method2352(var1, var2, 10);
            this.method2352(var1, 1 + var2, 32);
            this.method2352(1 + var1, var2, 128);
         }

         if(2 == var4) {
            this.method2352(var1, var2, 40);
            this.method2352(1 + var1, var2, 128);
            this.method2352(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2352(var1, var2, 160);
            this.method2352(var1, var2 - 1, 2);
            this.method2352(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(0 == var3) {
            if(var4 == 0) {
               this.method2352(var1, var2, 65536);
               this.method2352(var1 - 1, var2, 4096);
            }

            if(1 == var4) {
               this.method2352(var1, var2, 1024);
               this.method2352(var1, var2 + 1, 16384);
            }

            if(2 == var4) {
               this.method2352(var1, var2, 4096);
               this.method2352(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2352(var1, var2, 16384);
               this.method2352(var1, var2 - 1, 1024);
            }
         }

         if(1 == var3 || var3 == 3) {
            if(0 == var4) {
               this.method2352(var1, var2, 512);
               this.method2352(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2352(var1, var2, 2048);
               this.method2352(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2352(var1, var2, 8192);
               this.method2352(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2352(var1, var2, '耀');
               this.method2352(var1 - 1, var2 - 1, 2048);
            }
         }

         if(2 == var3) {
            if(var4 == 0) {
               this.method2352(var1, var2, 66560);
               this.method2352(var1 - 1, var2, 4096);
               this.method2352(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2352(var1, var2, 5120);
               this.method2352(var1, 1 + var2, 16384);
               this.method2352(1 + var1, var2, 65536);
            }

            if(2 == var4) {
               this.method2352(var1, var2, 20480);
               this.method2352(var1 + 1, var2, 65536);
               this.method2352(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2352(var1, var2, 81920);
               this.method2352(var1, var2 - 1, 1024);
               this.method2352(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("h")
   public void method2348(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1895;
      var2 -= this.field1901;
      int var8;
      if(var5 == 1 || 3 == var5) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var1 + var3; ++var8) {
         if(var8 >= 0 && var8 < this.field1902) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.field1903) {
                  this.method2352(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   public void method2350(int var1, int var2) {
      var1 -= this.field1895;
      var2 -= this.field1901;
      this.field1904[var1][var2] &= -262145;
   }

   @ObfuscatedName("n")
   void method2352(int var1, int var2, int var3) {
      this.field1904[var1][var2] &= ~var3;
   }

   @ObfuscatedName("db")
   static void method2353(int var0) {
      for(class200 var1 = (class200)client.field490.method3748(); null != var1; var1 = (class200)client.field490.method3747()) {
         if((long)var0 == (var1.field3112 >> 48 & 65535L)) {
            var1.method3853();
         }
      }

   }

   public class107(int var1, int var2) {
      this.field1902 = var1;
      this.field1903 = var2;
      this.field1904 = new int[this.field1902][this.field1903];
      this.method2341();
   }

   @ObfuscatedName("l")
   public void method2365(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1895;
      var2 -= this.field1901;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2370(var1, var2, 128);
            this.method2370(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2370(var1, var2, 2);
            this.method2370(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2370(var1, var2, 8);
            this.method2370(1 + var1, var2, 128);
         }

         if(3 == var4) {
            this.method2370(var1, var2, 32);
            this.method2370(var1, var2 - 1, 2);
         }
      }

      if(1 == var3 || 3 == var3) {
         if(var4 == 0) {
            this.method2370(var1, var2, 1);
            this.method2370(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2370(var1, var2, 4);
            this.method2370(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2370(var1, var2, 16);
            this.method2370(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2370(var1, var2, 64);
            this.method2370(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2370(var1, var2, 130);
            this.method2370(var1 - 1, var2, 8);
            this.method2370(var1, var2 + 1, 32);
         }

         if(1 == var4) {
            this.method2370(var1, var2, 10);
            this.method2370(var1, 1 + var2, 32);
            this.method2370(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2370(var1, var2, 40);
            this.method2370(1 + var1, var2, 128);
            this.method2370(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2370(var1, var2, 160);
            this.method2370(var1, var2 - 1, 2);
            this.method2370(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2370(var1, var2, 65536);
               this.method2370(var1 - 1, var2, 4096);
            }

            if(1 == var4) {
               this.method2370(var1, var2, 1024);
               this.method2370(var1, var2 + 1, 16384);
            }

            if(2 == var4) {
               this.method2370(var1, var2, 4096);
               this.method2370(var1 + 1, var2, 65536);
            }

            if(3 == var4) {
               this.method2370(var1, var2, 16384);
               this.method2370(var1, var2 - 1, 1024);
            }
         }

         if(1 == var3 || var3 == 3) {
            if(var4 == 0) {
               this.method2370(var1, var2, 512);
               this.method2370(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2370(var1, var2, 2048);
               this.method2370(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2370(var1, var2, 8192);
               this.method2370(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2370(var1, var2, '耀');
               this.method2370(var1 - 1, var2 - 1, 2048);
            }
         }

         if(2 == var3) {
            if(var4 == 0) {
               this.method2370(var1, var2, 66560);
               this.method2370(var1 - 1, var2, 4096);
               this.method2370(var1, 1 + var2, 16384);
            }

            if(1 == var4) {
               this.method2370(var1, var2, 5120);
               this.method2370(var1, 1 + var2, 16384);
               this.method2370(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2370(var1, var2, 20480);
               this.method2370(var1 + 1, var2, 65536);
               this.method2370(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2370(var1, var2, 81920);
               this.method2370(var1, var2 - 1, 1024);
               this.method2370(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("bl")
   static final void method2366(int var0, int var1) {
      class198 var2 = client.field420[class75.field1386][var0][var1];
      if(null == var2) {
         field1906.method1896(class75.field1386, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3773(); null != var6; var6 = (class28)var2.method3772()) {
            class51 var7 = class22.method581(var6.field677);
            long var8 = (long)var7.field1133;
            if(var7.field1134 == 1) {
               var8 *= (long)(var6.field672 + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            field1906.method1896(class75.field1386, var0, var1);
         } else {
            var2.method3769(var5);
            class28 var10 = null;
            class28 var11 = null;

            for(var6 = (class28)var2.method3773(); null != var6; var6 = (class28)var2.method3772()) {
               if(var5.field677 != var6.field677) {
                  if(var10 == null) {
                     var10 = var6;
                  }

                  if(var10.field677 != var6.field677 && null == var11) {
                     var11 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            field1906.method1882(class75.field1386, var0, var1, class105.method2335(64 + var0 * 128, 64 + 128 * var1, class75.field1386), var5, var9, var10, var11);
         }
      }
   }

   @ObfuscatedName("j")
   public static void method2369(Applet var0, String var1) {
      class137.field2143 = var0;
      class137.field2147 = var1;
   }

   @ObfuscatedName("m")
   void method2370(int var1, int var2, int var3) {
      this.field1904[var1][var2] |= var3;
   }

   @ObfuscatedName("bm")
   static void method2371() {
      for(int var0 = 0; var0 < client.field430; ++var0) {
         int var2 = client.field433[var0];
         boolean var1 = var2 == 57 || 58 == var2 || var2 == 1007 || 25 == var2 || 30 == var2;
         if(var1) {
            if(var0 < client.field430 - 1) {
               for(int var3 = var0; var3 < client.field430 - 1; ++var3) {
                  client.field437[var3] = client.field437[1 + var3];
                  client.field365[var3] = client.field365[1 + var3];
                  client.field433[var3] = client.field433[1 + var3];
                  client.field523[var3] = client.field523[1 + var3];
                  client.field431[var3] = client.field431[var3 + 1];
                  client.field432[var3] = client.field432[1 + var3];
               }
            }

            --client.field430;
         }
      }

   }
}
