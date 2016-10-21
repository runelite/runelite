import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1781343269
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1666928819
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 522360845
   )
   @Export("height")
   int height;
   @ObfuscatedName("aa")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("qx")
   protected static java.awt.Frame field1956;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1252284033
   )
   static int field1957;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1619482545
   )
   @Export("width")
   int width;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "343617638"
   )
   public void method2410(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method2419(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIZS)V",
      garbageValue = "13219"
   )
   public void method2412(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2436(var1, var2, 128);
            this.method2436(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2436(var1, var2, 2);
            this.method2436(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2436(var1, var2, 8);
            this.method2436(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2436(var1, var2, 32);
            this.method2436(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2436(var1, var2, 1);
            this.method2436(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2436(var1, var2, 4);
            this.method2436(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2436(var1, var2, 16);
            this.method2436(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2436(var1, var2, 64);
            this.method2436(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2436(var1, var2, 130);
            this.method2436(var1 - 1, var2, 8);
            this.method2436(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2436(var1, var2, 10);
            this.method2436(var1, 1 + var2, 32);
            this.method2436(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2436(var1, var2, 40);
            this.method2436(var1 + 1, var2, 128);
            this.method2436(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2436(var1, var2, 160);
            this.method2436(var1, var2 - 1, 2);
            this.method2436(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2436(var1, var2, 65536);
               this.method2436(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2436(var1, var2, 1024);
               this.method2436(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2436(var1, var2, 4096);
               this.method2436(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2436(var1, var2, 16384);
               this.method2436(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2436(var1, var2, 512);
               this.method2436(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2436(var1, var2, 2048);
               this.method2436(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2436(var1, var2, 8192);
               this.method2436(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2436(var1, var2, '耀');
               this.method2436(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2436(var1, var2, 66560);
               this.method2436(var1 - 1, var2, 4096);
               this.method2436(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2436(var1, var2, 5120);
               this.method2436(var1, var2 + 1, 16384);
               this.method2436(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2436(var1, var2, 20480);
               this.method2436(var1 + 1, var2, 65536);
               this.method2436(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2436(var1, var2, 81920);
               this.method2436(var1, var2 - 1, 1024);
               this.method2436(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1592879584"
   )
   public void method2413(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method2436(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-95"
   )
   public void method2414(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1747254774"
   )
   public void method2417(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2419(var1, var2, 128);
            this.method2419(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2419(var1, var2, 2);
            this.method2419(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2419(var1, var2, 8);
            this.method2419(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2419(var1, var2, 32);
            this.method2419(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2419(var1, var2, 1);
            this.method2419(var1 - 1, var2 + 1, 16);
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
         if(var4 == 0) {
            this.method2419(var1, var2, 130);
            this.method2419(var1 - 1, var2, 8);
            this.method2419(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2419(var1, var2, 10);
            this.method2419(var1, var2 + 1, 32);
            this.method2419(1 + var1, var2, 128);
         }

         if(var4 == 2) {
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
            if(var4 == 0) {
               this.method2419(var1, var2, 65536);
               this.method2419(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2419(var1, var2, 1024);
               this.method2419(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2419(var1, var2, 4096);
               this.method2419(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2419(var1, var2, 16384);
               this.method2419(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2419(var1, var2, 512);
               this.method2419(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2419(var1, var2, 2048);
               this.method2419(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2419(var1, var2, 8192);
               this.method2419(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2419(var1, var2, '耀');
               this.method2419(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2419(var1, var2, 66560);
               this.method2419(var1 - 1, var2, 4096);
               this.method2419(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2419(var1, var2, 5120);
               this.method2419(var1, var2 + 1, 16384);
               this.method2419(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2419(var1, var2, 20480);
               this.method2419(1 + var1, var2, 65536);
               this.method2419(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2419(var1, var2, 81920);
               this.method2419(var1, var2 - 1, 1024);
               this.method2419(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1300502084"
   )
   void method2419(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "305448672"
   )
   public void method2420(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[BLclass137;I)V",
      garbageValue = "-671616707"
   )
   static void method2421(int var0, byte[] var1, class137 var2) {
      class172 var3 = new class172();
      var3.field2737 = 0;
      var3.hash = (long)var0;
      var3.field2735 = var1;
      var3.field2736 = var2;
      Deque var4 = class173.field2744;
      synchronized(class173.field2744) {
         class173.field2744.method3886(var3);
      }

      class92.method2127();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-89"
   )
   public void method2425(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "20"
   )
   static int method2430(int var0) {
      MessageNode var1 = (MessageNode)class11.field167.method3881((long)var0);
      return var1 == null?-1:(class11.field174.field3150 == var1.previous?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "209"
   )
   public void method2432() {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "3"
   )
   void method2436(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[Lclass133;",
      garbageValue = "660833159"
   )
   static class133[] method2445() {
      return new class133[]{class133.field2110, class133.field2112, class133.field2116};
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "763591461"
   )
   public static void method2449() {
      class56.field1209.reset();
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2432();
   }
}
