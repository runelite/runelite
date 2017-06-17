import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1479730493
   )
   @Export("y")
   int y;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1885778109
   )
   @Export("x")
   int x;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -588541847
   )
   public static int field2304;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1915834989
   )
   @Export("width")
   int width;
   @ObfuscatedName("ac")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1264027297
   )
   @Export("height")
   int height;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-605740638"
   )
   public void method2912() {
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "463173653"
   )
   public void method2913(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "187615115"
   )
   public void method2914(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2917(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "6"
   )
   public void method2916(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-56728300"
   )
   void method2917(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1089857816"
   )
   public void method2919(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method2920(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1228035357"
   )
   void method2920(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.x = 0;
      this.y = 0;
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2912();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1908902507"
   )
   public void method2921(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "409914806"
   )
   public void method2922(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2917(var1, var2, 128);
            this.method2917(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2917(var1, var2, 2);
            this.method2917(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2917(var1, var2, 8);
            this.method2917(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2917(var1, var2, 32);
            this.method2917(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2917(var1, var2, 1);
            this.method2917(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2917(var1, var2, 4);
            this.method2917(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2917(var1, var2, 16);
            this.method2917(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2917(var1, var2, 64);
            this.method2917(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2917(var1, var2, 130);
            this.method2917(var1 - 1, var2, 8);
            this.method2917(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2917(var1, var2, 10);
            this.method2917(var1, var2 + 1, 32);
            this.method2917(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2917(var1, var2, 40);
            this.method2917(var1 + 1, var2, 128);
            this.method2917(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2917(var1, var2, 160);
            this.method2917(var1, var2 - 1, 2);
            this.method2917(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2917(var1, var2, 65536);
               this.method2917(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2917(var1, var2, 1024);
               this.method2917(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2917(var1, var2, 4096);
               this.method2917(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2917(var1, var2, 16384);
               this.method2917(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2917(var1, var2, 512);
               this.method2917(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2917(var1, var2, 2048);
               this.method2917(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2917(var1, var2, 8192);
               this.method2917(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2917(var1, var2, '耀');
               this.method2917(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2917(var1, var2, 66560);
               this.method2917(var1 - 1, var2, 4096);
               this.method2917(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2917(var1, var2, 5120);
               this.method2917(var1, var2 + 1, 16384);
               this.method2917(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2917(var1, var2, 20480);
               this.method2917(var1 + 1, var2, 65536);
               this.method2917(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2917(var1, var2, 81920);
               this.method2917(var1, var2 - 1, 1024);
               this.method2917(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(LActor;S)V",
      garbageValue = "12734"
   )
   static final void method2924(Actor var0) {
      if(var0.field1227 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < '耀') {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var1 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1226) {
               var0.interacting = -1;
               var0.field1226 = false;
            }
         }

         if(var0.field1236 != -1 && (var0.queueSize == 0 || var0.field1266 > 0)) {
            var0.orientation = var0.field1236;
            var0.field1236 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1226) {
            var0.interacting = -1;
            var0.field1226 = false;
         }

         if(var4 != 0) {
            ++var0.field1230;
            boolean var5;
            if(var4 > 1024) {
               var0.angle -= var0.field1227;
               var5 = true;
               if(var4 < var0.field1227 || var4 > 2048 - var0.field1227) {
                  var0.angle = var0.orientation;
                  var5 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1230 > 25 || var5)) {
                  if(var0.field1214 != -1) {
                     var0.poseAnimation = var0.field1214;
                  } else {
                     var0.poseAnimation = var0.field1216;
                  }
               }
            } else {
               var0.angle += var0.field1227;
               var5 = true;
               if(var4 < var0.field1227 || var4 > 2048 - var0.field1227) {
                  var0.angle = var0.orientation;
                  var5 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1230 > 25 || var5)) {
                  if(var0.field1215 != -1) {
                     var0.poseAnimation = var0.field1215;
                  } else {
                     var0.poseAnimation = var0.field1216;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1230 = 0;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1646594124"
   )
   public void method2931(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2920(var1, var2, 128);
            this.method2920(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2920(var1, var2, 2);
            this.method2920(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2920(var1, var2, 8);
            this.method2920(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2920(var1, var2, 32);
            this.method2920(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2920(var1, var2, 1);
            this.method2920(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2920(var1, var2, 4);
            this.method2920(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2920(var1, var2, 16);
            this.method2920(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2920(var1, var2, 64);
            this.method2920(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2920(var1, var2, 130);
            this.method2920(var1 - 1, var2, 8);
            this.method2920(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2920(var1, var2, 10);
            this.method2920(var1, var2 + 1, 32);
            this.method2920(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2920(var1, var2, 40);
            this.method2920(var1 + 1, var2, 128);
            this.method2920(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2920(var1, var2, 160);
            this.method2920(var1, var2 - 1, 2);
            this.method2920(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2920(var1, var2, 65536);
               this.method2920(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2920(var1, var2, 1024);
               this.method2920(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2920(var1, var2, 4096);
               this.method2920(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2920(var1, var2, 16384);
               this.method2920(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2920(var1, var2, 512);
               this.method2920(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2920(var1, var2, 2048);
               this.method2920(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2920(var1, var2, 8192);
               this.method2920(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2920(var1, var2, '耀');
               this.method2920(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2920(var1, var2, 66560);
               this.method2920(var1 - 1, var2, 4096);
               this.method2920(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2920(var1, var2, 5120);
               this.method2920(var1, var2 + 1, 16384);
               this.method2920(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2920(var1, var2, 20480);
               this.method2920(var1 + 1, var2, 65536);
               this.method2920(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2920(var1, var2, 81920);
               this.method2920(var1, var2 - 1, 1024);
               this.method2920(var1 - 1, var2, 4096);
            }
         }
      }

   }
}
