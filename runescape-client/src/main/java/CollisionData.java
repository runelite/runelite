import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 97464129
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1807215421
   )
   @Export("width")
   int width;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -102067785
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1483760077
   )
   @Export("height")
   int height;
   @ObfuscatedName("ab")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -741277811
   )
   static int field1964;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -321240383
   )
   static int field1965;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1475673457"
   )
   public void method2441(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "49345902"
   )
   public void method2442() {
      for(int var1 = 0; var1 < this.width; ++var1) {
         for(int var2 = 0; var2 < this.height; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.width - 5 && var2 < this.height - 5) {
               this.flags[var1][var2] = 16777216;
            } else {
               this.flags[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1961954721"
   )
   public void method2443(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2447(var1, var2, 128);
            this.method2447(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2447(var1, var2, 2);
            this.method2447(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2447(var1, var2, 8);
            this.method2447(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2447(var1, var2, 32);
            this.method2447(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2447(var1, var2, 1);
            this.method2447(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2447(var1, var2, 4);
            this.method2447(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2447(var1, var2, 16);
            this.method2447(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2447(var1, var2, 64);
            this.method2447(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2447(var1, var2, 130);
            this.method2447(var1 - 1, var2, 8);
            this.method2447(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2447(var1, var2, 10);
            this.method2447(var1, var2 + 1, 32);
            this.method2447(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2447(var1, var2, 40);
            this.method2447(1 + var1, var2, 128);
            this.method2447(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2447(var1, var2, 160);
            this.method2447(var1, var2 - 1, 2);
            this.method2447(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2447(var1, var2, 65536);
               this.method2447(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2447(var1, var2, 1024);
               this.method2447(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2447(var1, var2, 4096);
               this.method2447(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2447(var1, var2, 16384);
               this.method2447(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2447(var1, var2, 512);
               this.method2447(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2447(var1, var2, 2048);
               this.method2447(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2447(var1, var2, 8192);
               this.method2447(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2447(var1, var2, '耀');
               this.method2447(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2447(var1, var2, 66560);
               this.method2447(var1 - 1, var2, 4096);
               this.method2447(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2447(var1, var2, 5120);
               this.method2447(var1, 1 + var2, 16384);
               this.method2447(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2447(var1, var2, 20480);
               this.method2447(1 + var1, var2, 65536);
               this.method2447(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2447(var1, var2, 81920);
               this.method2447(var1, var2 - 1, 1024);
               this.method2447(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1328522522"
   )
   public void method2444(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2447(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-738097187"
   )
   public void method2446(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1311463996"
   )
   void method2447(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)V",
      garbageValue = "61"
   )
   public void method2449(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.width) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method2450(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "70626504"
   )
   void method2450(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-616272950"
   )
   public static void method2457() {
      Sequence.field1010.reset();
      Sequence.field996.reset();
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2442();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "703244336"
   )
   public void method2471(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2450(var1, var2, 128);
            this.method2450(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2450(var1, var2, 2);
            this.method2450(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2450(var1, var2, 8);
            this.method2450(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2450(var1, var2, 32);
            this.method2450(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2450(var1, var2, 1);
            this.method2450(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2450(var1, var2, 4);
            this.method2450(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2450(var1, var2, 16);
            this.method2450(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2450(var1, var2, 64);
            this.method2450(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2450(var1, var2, 130);
            this.method2450(var1 - 1, var2, 8);
            this.method2450(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2450(var1, var2, 10);
            this.method2450(var1, var2 + 1, 32);
            this.method2450(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2450(var1, var2, 40);
            this.method2450(1 + var1, var2, 128);
            this.method2450(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2450(var1, var2, 160);
            this.method2450(var1, var2 - 1, 2);
            this.method2450(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2450(var1, var2, 65536);
               this.method2450(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2450(var1, var2, 1024);
               this.method2450(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2450(var1, var2, 4096);
               this.method2450(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2450(var1, var2, 16384);
               this.method2450(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2450(var1, var2, 512);
               this.method2450(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2450(var1, var2, 2048);
               this.method2450(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2450(var1, var2, 8192);
               this.method2450(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2450(var1, var2, '耀');
               this.method2450(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2450(var1, var2, 66560);
               this.method2450(var1 - 1, var2, 4096);
               this.method2450(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2450(var1, var2, 5120);
               this.method2450(var1, 1 + var2, 16384);
               this.method2450(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2450(var1, var2, 20480);
               this.method2450(var1 + 1, var2, 65536);
               this.method2450(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2450(var1, var2, 81920);
               this.method2450(var1, var2 - 1, 1024);
               this.method2450(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lclass52;",
      garbageValue = "-811503497"
   )
   public static class52 method2472(int var0) {
      class52 var1 = (class52)class52.field1119.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class52.field1127.method3290(8, var0);
         var1 = new class52();
         if(null != var2) {
            var1.method1057(new Buffer(var2));
         }

         class52.field1119.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-921852644"
   )
   public void method2473(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Lclass47;",
      garbageValue = "84"
   )
   public static class47 method2475(int var0) {
      class47 var1 = (class47)class47.field1048.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class47.field1046.method3290(19, var0);
         var1 = new class47();
         if(null != var2) {
            var1.method953(new Buffer(var2));
         }

         class47.field1048.put(var1, (long)var0);
         return var1;
      }
   }
}
