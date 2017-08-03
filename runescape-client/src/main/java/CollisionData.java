import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 87360057
   )
   @Export("width")
   int width;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -706880087
   )
   @Export("x")
   public int x;
   @ObfuscatedName("ao")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1892093829
   )
   @Export("height")
   int height;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 285466681
   )
   @Export("y")
   public int y;

   public CollisionData(int var1, int var2) {
      this.x = 0;
      this.y = 0;
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.reset();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1971872299"
   )
   @Export("remove")
   void remove(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1878892088"
   )
   @Export("add")
   void add(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2062098045"
   )
   @Export("reset")
   public void reset() {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "61"
   )
   @Export("removeWall")
   public void removeWall(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.remove(var1, var2, 128);
            this.remove(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.remove(var1, var2, 2);
            this.remove(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.remove(var1, var2, 8);
            this.remove(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.remove(var1, var2, 32);
            this.remove(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.remove(var1, var2, 1);
            this.remove(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.remove(var1, var2, 4);
            this.remove(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.remove(var1, var2, 16);
            this.remove(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.remove(var1, var2, 64);
            this.remove(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.remove(var1, var2, 130);
            this.remove(var1 - 1, var2, 8);
            this.remove(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.remove(var1, var2, 10);
            this.remove(var1, var2 + 1, 32);
            this.remove(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.remove(var1, var2, 40);
            this.remove(var1 + 1, var2, 128);
            this.remove(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.remove(var1, var2, 160);
            this.remove(var1, var2 - 1, 2);
            this.remove(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.remove(var1, var2, 65536);
               this.remove(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.remove(var1, var2, 1024);
               this.remove(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.remove(var1, var2, 4096);
               this.remove(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.remove(var1, var2, 16384);
               this.remove(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.remove(var1, var2, 512);
               this.remove(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.remove(var1, var2, 2048);
               this.remove(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.remove(var1, var2, 8192);
               this.remove(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.remove(var1, var2, '耀');
               this.remove(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.remove(var1, var2, 66560);
               this.remove(var1 - 1, var2, 4096);
               this.remove(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.remove(var1, var2, 5120);
               this.remove(var1, var2 + 1, 16384);
               this.remove(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.remove(var1, var2, 20480);
               this.remove(var1 + 1, var2, 65536);
               this.remove(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.remove(var1, var2, 81920);
               this.remove(var1, var2 - 1, 1024);
               this.remove(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "592009634"
   )
   @Export("unblock")
   public void unblock(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1775261963"
   )
   @Export("removeObject")
   public void removeObject(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.remove(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-318384986"
   )
   @Export("block")
   public void block(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1697575107"
   )
   @Export("addObject")
   public void addObject(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.add(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1089215932"
   )
   @Export("addWall")
   public void addWall(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.add(var1, var2, 128);
            this.add(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.add(var1, var2, 2);
            this.add(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.add(var1, var2, 8);
            this.add(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.add(var1, var2, 32);
            this.add(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.add(var1, var2, 1);
            this.add(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.add(var1, var2, 4);
            this.add(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.add(var1, var2, 16);
            this.add(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.add(var1, var2, 64);
            this.add(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.add(var1, var2, 130);
            this.add(var1 - 1, var2, 8);
            this.add(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.add(var1, var2, 10);
            this.add(var1, var2 + 1, 32);
            this.add(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.add(var1, var2, 40);
            this.add(var1 + 1, var2, 128);
            this.add(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.add(var1, var2, 160);
            this.add(var1, var2 - 1, 2);
            this.add(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.add(var1, var2, 65536);
               this.add(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.add(var1, var2, 1024);
               this.add(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.add(var1, var2, 4096);
               this.add(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.add(var1, var2, 16384);
               this.add(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.add(var1, var2, 512);
               this.add(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.add(var1, var2, 2048);
               this.add(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.add(var1, var2, 8192);
               this.add(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.add(var1, var2, '耀');
               this.add(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.add(var1, var2, 66560);
               this.add(var1 - 1, var2, 4096);
               this.add(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.add(var1, var2, 5120);
               this.add(var1, var2 + 1, 16384);
               this.add(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.add(var1, var2, 20480);
               this.add(var1 + 1, var2, 65536);
               this.add(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.add(var1, var2, 81920);
               this.add(var1, var2 - 1, 1024);
               this.add(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "12659"
   )
   public void method3060(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Lfg;II)Lfg;",
      garbageValue = "-1088613292"
   )
   @Export("forOrdinal")
   public static RSEnum forOrdinal(RSEnum[] var0, int var1) {
      RSEnum[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         RSEnum var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1035451488"
   )
   public static void method3079(int var0) {
      if(var0 != -1) {
         if(XItemContainer.validInterfaces[var0]) {
            class67.widgetIndex.method4126(var0);
            if(class170.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class170.widgets[var0].length; ++var2) {
                  if(class170.widgets[var0][var2] != null) {
                     if(class170.widgets[var0][var2].type != 2) {
                        class170.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class170.widgets[var0] = null;
               }

               XItemContainer.validInterfaces[var0] = false;
            }
         }
      }
   }
}
