import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 38599785
   )
   @Export("x")
   int x;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1387977053
   )
   @Export("y")
   int y;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1175091293
   )
   @Export("width")
   int width;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1595202999
   )
   @Export("height")
   int height;
   @ObfuscatedName("ab")
   @Export("flags")
   public int[][] flags;

   public CollisionData(int var1, int var2) {
      this.x = 0;
      this.y = 0;
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1853290766"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2076439895"
   )
   public void method3380(int var1, int var2, int var3, int var4, boolean var5) {
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
               this.add(var1 + 1, var2 + 1, 32768);
            }

            if(var4 == 2) {
               this.add(var1, var2, 8192);
               this.add(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.add(var1, var2, 32768);
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1519072684"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-111"
   )
   public void method3376(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-9"
   )
   public void method3352(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1824112419"
   )
   @Export("add")
   void add(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1609437111"
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
               this.remove(var1 + 1, var2 + 1, 32768);
            }

            if(var4 == 2) {
               this.remove(var1, var2, 8192);
               this.remove(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.remove(var1, var2, 32768);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "514130876"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1724242805"
   )
   @Export("remove")
   void remove(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "966087574"
   )
   public void method3354(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Liv;",
      garbageValue = "-136408307"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Lhs;Ljc;IIZI)V",
      garbageValue = "-1705908592"
   )
   static final void method3357(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         Resampler.method2380(var7, class70.getColTags(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
      }

   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-741769844"
   )
   static final void method3379() {
      Client.field1030 = Client.cycleCntr;
      GrandExchangeEvent.field282 = true;
   }
}
