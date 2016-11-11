import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1157088875
   )
   @Export("height")
   int height;
   @ObfuscatedName("e")
   public static class170 field1945;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1858463967
   )
   @Export("y")
   public int y = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1997881481
   )
   @Export("width")
   int width;
   @ObfuscatedName("aw")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1078280019
   )
   @Export("x")
   public int x = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "200"
   )
   public void method2419() {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "8"
   )
   public void method2420(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2434(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-71"
   )
   public void method2422(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1868578590"
   )
   public void method2423(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "472468218"
   )
   public void method2425(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2427(var1, var2, 128);
            this.method2427(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2427(var1, var2, 2);
            this.method2427(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2427(var1, var2, 8);
            this.method2427(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2427(var1, var2, 32);
            this.method2427(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2427(var1, var2, 1);
            this.method2427(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2427(var1, var2, 4);
            this.method2427(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2427(var1, var2, 16);
            this.method2427(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2427(var1, var2, 64);
            this.method2427(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2427(var1, var2, 130);
            this.method2427(var1 - 1, var2, 8);
            this.method2427(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2427(var1, var2, 10);
            this.method2427(var1, 1 + var2, 32);
            this.method2427(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2427(var1, var2, 40);
            this.method2427(var1 + 1, var2, 128);
            this.method2427(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2427(var1, var2, 160);
            this.method2427(var1, var2 - 1, 2);
            this.method2427(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2427(var1, var2, 65536);
               this.method2427(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2427(var1, var2, 1024);
               this.method2427(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2427(var1, var2, 4096);
               this.method2427(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2427(var1, var2, 16384);
               this.method2427(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2427(var1, var2, 512);
               this.method2427(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2427(var1, var2, 2048);
               this.method2427(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2427(var1, var2, 8192);
               this.method2427(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2427(var1, var2, '耀');
               this.method2427(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2427(var1, var2, 66560);
               this.method2427(var1 - 1, var2, 4096);
               this.method2427(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2427(var1, var2, 5120);
               this.method2427(var1, var2 + 1, 16384);
               this.method2427(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2427(var1, var2, 20480);
               this.method2427(1 + var1, var2, 65536);
               this.method2427(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2427(var1, var2, 81920);
               this.method2427(var1, var2 - 1, 1024);
               this.method2427(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-145847098"
   )
   public void method2426(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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

      for(var8 = var1; var8 < var1 + var3; ++var8) {
         if(var8 >= 0 && var8 < this.width) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method2427(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1563319990"
   )
   void method2427(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-811921224"
   )
   public void method2428(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "677692174"
   )
   void method2434(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "30"
   )
   public void method2439(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2434(var1, var2, 128);
            this.method2434(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2434(var1, var2, 2);
            this.method2434(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2434(var1, var2, 8);
            this.method2434(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2434(var1, var2, 32);
            this.method2434(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2434(var1, var2, 1);
            this.method2434(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2434(var1, var2, 4);
            this.method2434(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2434(var1, var2, 16);
            this.method2434(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2434(var1, var2, 64);
            this.method2434(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2434(var1, var2, 130);
            this.method2434(var1 - 1, var2, 8);
            this.method2434(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2434(var1, var2, 10);
            this.method2434(var1, 1 + var2, 32);
            this.method2434(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2434(var1, var2, 40);
            this.method2434(1 + var1, var2, 128);
            this.method2434(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2434(var1, var2, 160);
            this.method2434(var1, var2 - 1, 2);
            this.method2434(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2434(var1, var2, 65536);
               this.method2434(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2434(var1, var2, 1024);
               this.method2434(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2434(var1, var2, 4096);
               this.method2434(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2434(var1, var2, 16384);
               this.method2434(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2434(var1, var2, 512);
               this.method2434(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2434(var1, var2, 2048);
               this.method2434(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2434(var1, var2, 8192);
               this.method2434(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2434(var1, var2, '耀');
               this.method2434(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2434(var1, var2, 66560);
               this.method2434(var1 - 1, var2, 4096);
               this.method2434(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2434(var1, var2, 5120);
               this.method2434(var1, 1 + var2, 16384);
               this.method2434(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2434(var1, var2, 20480);
               this.method2434(var1 + 1, var2, 65536);
               this.method2434(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2434(var1, var2, 81920);
               this.method2434(var1, var2 - 1, 1024);
               this.method2434(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2419();
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1538974801"
   )
   static final void method2456(boolean var0) {
      Client.field314 = 0;
      Client.field343 = 0;
      Client.field347.method2786();
      int var1 = Client.field347.method2787(8);
      int var2;
      if(var1 < Client.field341) {
         for(var2 = var1; var2 < Client.field341; ++var2) {
            Client.field427[++Client.field314 - 1] = Client.field342[var2];
         }
      }

      if(var1 > Client.field341) {
         throw new RuntimeException("");
      } else {
         Client.field341 = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.field342[var2];
            NPC var4 = Client.cachedNPCs[var3];
            int var5 = Client.field347.method2787(1);
            if(var5 == 0) {
               Client.field342[++Client.field341 - 1] = var3;
               var4.field884 = Client.gameCycle;
            } else {
               int var6 = Client.field347.method2787(2);
               if(var6 == 0) {
                  Client.field342[++Client.field341 - 1] = var3;
                  var4.field884 = Client.gameCycle;
                  Client.field555[++Client.field343 - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     Client.field342[++Client.field341 - 1] = var3;
                     var4.field884 = Client.gameCycle;
                     var7 = Client.field347.method2787(3);
                     var4.method755(var7, (byte)1);
                     var8 = Client.field347.method2787(1);
                     if(var8 == 1) {
                        Client.field555[++Client.field343 - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.field342[++Client.field341 - 1] = var3;
                     var4.field884 = Client.gameCycle;
                     var7 = Client.field347.method2787(3);
                     var4.method755(var7, (byte)2);
                     var8 = Client.field347.method2787(3);
                     var4.method755(var8, (byte)2);
                     int var9 = Client.field347.method2787(1);
                     if(var9 == 1) {
                        Client.field555[++Client.field343 - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.field427[++Client.field314 - 1] = var3;
                  }
               }
            }
         }

         class92.method2137(var0);
         class12.method154();

         for(var1 = 0; var1 < Client.field314; ++var1) {
            var2 = Client.field427[var1];
            if(Client.gameCycle != Client.cachedNPCs[var2].field884) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field347.offset != Client.field348) {
            throw new RuntimeException(Client.field347.offset + "," + Client.field348);
         } else {
            for(var1 = 0; var1 < Client.field341; ++var1) {
               if(null == Client.cachedNPCs[Client.field342[var1]]) {
                  throw new RuntimeException(var1 + "," + Client.field341);
               }
            }

         }
      }
   }
}
