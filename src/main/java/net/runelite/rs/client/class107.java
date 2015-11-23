package net.runelite.rs.client;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dh")
@Implements("CollisionData")
public class class107 {
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1667855125
   )
   int field1869;
   @ObfuscatedName("at")
   @Export("flags")
   public int[][] field1879;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -421331097
   )
   public int field1881 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 745825409
   )
   public int field1883 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1721040549
   )
   int field1884;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -600152583
   )
   protected static int field1885;

   @ObfuscatedName("f")
   public void method2423(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1881;
      var2 -= this.field1883;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.field1869) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.field1884) {
                  this.method2426(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   public void method2424(int var1, int var2) {
      var1 -= this.field1881;
      var2 -= this.field1883;
      this.field1879[var1][var2] |= 2097152;
   }

   @ObfuscatedName("t")
   void method2425(int var1, int var2, int var3) {
      this.field1879[var1][var2] &= ~var3;
   }

   @ObfuscatedName("a")
   void method2426(int var1, int var2, int var3) {
      this.field1879[var1][var2] |= var3;
   }

   @ObfuscatedName("h")
   public void method2427(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1881;
      var2 -= this.field1883;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2425(var1, var2, 128);
            this.method2425(var1 - 1, var2, 8);
         }

         if(1 == var4) {
            this.method2425(var1, var2, 2);
            this.method2425(var1, var2 + 1, 32);
         }

         if(2 == var4) {
            this.method2425(var1, var2, 8);
            this.method2425(var1 + 1, var2, 128);
         }

         if(3 == var4) {
            this.method2425(var1, var2, 32);
            this.method2425(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || 3 == var3) {
         if(var4 == 0) {
            this.method2425(var1, var2, 1);
            this.method2425(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2425(var1, var2, 4);
            this.method2425(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2425(var1, var2, 16);
            this.method2425(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2425(var1, var2, 64);
            this.method2425(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(0 == var4) {
            this.method2425(var1, var2, 130);
            this.method2425(var1 - 1, var2, 8);
            this.method2425(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2425(var1, var2, 10);
            this.method2425(var1, var2 + 1, 32);
            this.method2425(var1 + 1, var2, 128);
         }

         if(2 == var4) {
            this.method2425(var1, var2, 40);
            this.method2425(var1 + 1, var2, 128);
            this.method2425(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2425(var1, var2, 160);
            this.method2425(var1, var2 - 1, 2);
            this.method2425(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(0 == var3) {
            if(var4 == 0) {
               this.method2425(var1, var2, 65536);
               this.method2425(var1 - 1, var2, 4096);
            }

            if(1 == var4) {
               this.method2425(var1, var2, 1024);
               this.method2425(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2425(var1, var2, 4096);
               this.method2425(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2425(var1, var2, 16384);
               this.method2425(var1, var2 - 1, 1024);
            }
         }

         if(1 == var3 || var3 == 3) {
            if(var4 == 0) {
               this.method2425(var1, var2, 512);
               this.method2425(var1 - 1, var2 + 1, 8192);
            }

            if(1 == var4) {
               this.method2425(var1, var2, 2048);
               this.method2425(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2425(var1, var2, 8192);
               this.method2425(1 + var1, var2 - 1, 512);
            }

            if(3 == var4) {
               this.method2425(var1, var2, '耀');
               this.method2425(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(0 == var4) {
               this.method2425(var1, var2, 66560);
               this.method2425(var1 - 1, var2, 4096);
               this.method2425(var1, var2 + 1, 16384);
            }

            if(1 == var4) {
               this.method2425(var1, var2, 5120);
               this.method2425(var1, 1 + var2, 16384);
               this.method2425(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2425(var1, var2, 20480);
               this.method2425(1 + var1, var2, 65536);
               this.method2425(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2425(var1, var2, 81920);
               this.method2425(var1, var2 - 1, 1024);
               this.method2425(var1 - 1, var2, 4096);
            }
         }
      }

   }

   public class107(int var1, int var2) {
      this.field1869 = var1;
      this.field1884 = var2;
      this.field1879 = new int[this.field1869][this.field1884];
      this.method2441();
   }

   @ObfuscatedName("k")
   public void method2429(int var1, int var2) {
      var1 -= this.field1881;
      var2 -= this.field1883;
      this.field1879[var1][var2] &= -262145;
   }

   @ObfuscatedName("j")
   public void method2441() {
      for(int var1 = 0; var1 < this.field1869; ++var1) {
         for(int var2 = 0; var2 < this.field1884; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.field1869 - 5 && var2 < this.field1884 - 5) {
               this.field1879[var1][var2] = 16777216;
            } else {
               this.field1879[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("i")
   public void method2443(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1881;
      var2 -= this.field1883;
      int var8;
      if(1 == var5 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var1 + var3; ++var8) {
         if(var8 >= 0 && var8 < this.field1869) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.field1884) {
                  this.method2425(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   public void method2444(int var1, int var2) {
      var1 -= this.field1881;
      var2 -= this.field1883;
      this.field1879[var1][var2] |= 262144;
   }

   @ObfuscatedName("m")
   public void method2447(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1881;
      var2 -= this.field1883;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2426(var1, var2, 128);
            this.method2426(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2426(var1, var2, 2);
            this.method2426(var1, 1 + var2, 32);
         }

         if(2 == var4) {
            this.method2426(var1, var2, 8);
            this.method2426(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2426(var1, var2, 32);
            this.method2426(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || 3 == var3) {
         if(0 == var4) {
            this.method2426(var1, var2, 1);
            this.method2426(var1 - 1, var2 + 1, 16);
         }

         if(1 == var4) {
            this.method2426(var1, var2, 4);
            this.method2426(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2426(var1, var2, 16);
            this.method2426(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2426(var1, var2, 64);
            this.method2426(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(0 == var4) {
            this.method2426(var1, var2, 130);
            this.method2426(var1 - 1, var2, 8);
            this.method2426(var1, var2 + 1, 32);
         }

         if(1 == var4) {
            this.method2426(var1, var2, 10);
            this.method2426(var1, var2 + 1, 32);
            this.method2426(var1 + 1, var2, 128);
         }

         if(2 == var4) {
            this.method2426(var1, var2, 40);
            this.method2426(var1 + 1, var2, 128);
            this.method2426(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2426(var1, var2, 160);
            this.method2426(var1, var2 - 1, 2);
            this.method2426(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(0 == var4) {
               this.method2426(var1, var2, 65536);
               this.method2426(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2426(var1, var2, 1024);
               this.method2426(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2426(var1, var2, 4096);
               this.method2426(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2426(var1, var2, 16384);
               this.method2426(var1, var2 - 1, 1024);
            }
         }

         if(1 == var3 || var3 == 3) {
            if(0 == var4) {
               this.method2426(var1, var2, 512);
               this.method2426(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2426(var1, var2, 2048);
               this.method2426(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2426(var1, var2, 8192);
               this.method2426(1 + var1, var2 - 1, 512);
            }

            if(3 == var4) {
               this.method2426(var1, var2, '耀');
               this.method2426(var1 - 1, var2 - 1, 2048);
            }
         }

         if(2 == var3) {
            if(0 == var4) {
               this.method2426(var1, var2, 66560);
               this.method2426(var1 - 1, var2, 4096);
               this.method2426(var1, 1 + var2, 16384);
            }

            if(1 == var4) {
               this.method2426(var1, var2, 5120);
               this.method2426(var1, var2 + 1, 16384);
               this.method2426(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2426(var1, var2, 20480);
               this.method2426(var1 + 1, var2, 65536);
               this.method2426(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2426(var1, var2, 81920);
               this.method2426(var1, var2 - 1, 1024);
               this.method2426(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("l")
   public static void method2449() {
      try {
         File var0 = new File(class0.field14, "random.dat");
         int var2;
         if(var0.exists()) {
            class148.field2220 = new class227(new class226(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class14.field209.length; ++var1) {
               for(var2 = 0; var2 < class188.field3036.length; ++var2) {
                  File var3 = new File(class188.field3036[var2] + class14.field209[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class148.field2220 = new class227(new class226(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class148.field2220 == null) {
            RandomAccessFile var5 = new RandomAccessFile(var0, "rw");
            var2 = var5.read();
            var5.seek(0L);
            var5.write(var2);
            var5.seek(0L);
            var5.close();
            class148.field2220 = new class227(new class226(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var4) {
         ;
      }

   }
}
