import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static IndexDataBase field2305;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -623009907
   )
   @Export("width")
   int width;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -129596505
   )
   @Export("x")
   public int x;
   @ObfuscatedName("af")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 757313123
   )
   @Export("height")
   int height;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1960427479
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-52"
   )
   @Export("remove")
   void remove(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1019935599"
   )
   @Export("add")
   void add(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "3"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "708008422"
   )
   @Export("unblock")
   public void unblock(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "746734812"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "758544155"
   )
   @Export("block")
   public void block(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1760424790"
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
      signature = "(IIIIZI)V",
      garbageValue = "1284638943"
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1319518634"
   )
   public void method3047(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1239472604"
   )
   public static int method3074(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   static void method3075() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3558(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3559()) {
         int var1 = var0.id;
         if(Ignore.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = class176.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class84.method1670(var4);
               if(var5 != null) {
                  class90.method1723(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILih;II)V",
      garbageValue = "-1391579836"
   )
   static void method3051(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class82 var5 = new class82();
      var5.field1321 = var0;
      var5.field1317 = var1 * 128;
      var5.field1327 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1319 = (var6 + var1) * 128;
      var5.field1322 = (var7 + var2) * 128;
      var5.field1326 = var3.ambientSoundId;
      var5.field1325 = var3.field3437 * 128;
      var5.field1324 = var3.field3472;
      var5.field1331 = var3.field3434;
      var5.field1316 = var3.field3474;
      if(var3.impostorIds != null) {
         var5.field1329 = var3;
         var5.method1599();
      }

      class82.field1330.addFront(var5);
      if(var5.field1316 != null) {
         var5.field1315 = var5.field1324 + (int)(Math.random() * (double)(var5.field1331 - var5.field1324));
      }

   }
}
