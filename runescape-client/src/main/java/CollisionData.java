import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -315931977
   )
   @Export("height")
   int height;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1359792851
   )
   @Export("x")
   public int x = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1698875589
   )
   @Export("y")
   public int y = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1739005087
   )
   @Export("width")
   int width;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -699067465
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("qt")
   protected static java.awt.Frame field1835;
   @ObfuscatedName("ax")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("ew")
   static ModIcon[] field1838;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2083025760"
   )
   public void method2342() {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "50"
   )
   public void method2344(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2348(var1, var2, 128);
            this.method2348(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2348(var1, var2, 2);
            this.method2348(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2348(var1, var2, 8);
            this.method2348(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2348(var1, var2, 32);
            this.method2348(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2348(var1, var2, 1);
            this.method2348(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2348(var1, var2, 4);
            this.method2348(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2348(var1, var2, 16);
            this.method2348(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2348(var1, var2, 64);
            this.method2348(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2348(var1, var2, 130);
            this.method2348(var1 - 1, var2, 8);
            this.method2348(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2348(var1, var2, 10);
            this.method2348(var1, 1 + var2, 32);
            this.method2348(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2348(var1, var2, 40);
            this.method2348(var1 + 1, var2, 128);
            this.method2348(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2348(var1, var2, 160);
            this.method2348(var1, var2 - 1, 2);
            this.method2348(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2348(var1, var2, 65536);
               this.method2348(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2348(var1, var2, 1024);
               this.method2348(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2348(var1, var2, 4096);
               this.method2348(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2348(var1, var2, 16384);
               this.method2348(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2348(var1, var2, 512);
               this.method2348(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2348(var1, var2, 2048);
               this.method2348(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2348(var1, var2, 8192);
               this.method2348(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2348(var1, var2, '耀');
               this.method2348(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2348(var1, var2, 66560);
               this.method2348(var1 - 1, var2, 4096);
               this.method2348(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2348(var1, var2, 5120);
               this.method2348(var1, 1 + var2, 16384);
               this.method2348(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2348(var1, var2, 20480);
               this.method2348(var1 + 1, var2, 65536);
               this.method2348(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2348(var1, var2, 81920);
               this.method2348(var1, var2 - 1, 1024);
               this.method2348(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "5"
   )
   public void method2346(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   public void method2347(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2132685012"
   )
   void method2348(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1170777787"
   )
   public void method2349(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2353(var1, var2, 128);
            this.method2353(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2353(var1, var2, 2);
            this.method2353(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2353(var1, var2, 8);
            this.method2353(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2353(var1, var2, 32);
            this.method2353(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2353(var1, var2, 1);
            this.method2353(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2353(var1, var2, 4);
            this.method2353(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2353(var1, var2, 16);
            this.method2353(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2353(var1, var2, 64);
            this.method2353(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2353(var1, var2, 130);
            this.method2353(var1 - 1, var2, 8);
            this.method2353(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2353(var1, var2, 10);
            this.method2353(var1, var2 + 1, 32);
            this.method2353(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2353(var1, var2, 40);
            this.method2353(1 + var1, var2, 128);
            this.method2353(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2353(var1, var2, 160);
            this.method2353(var1, var2 - 1, 2);
            this.method2353(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2353(var1, var2, 65536);
               this.method2353(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2353(var1, var2, 1024);
               this.method2353(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2353(var1, var2, 4096);
               this.method2353(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2353(var1, var2, 16384);
               this.method2353(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2353(var1, var2, 512);
               this.method2353(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2353(var1, var2, 2048);
               this.method2353(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2353(var1, var2, 8192);
               this.method2353(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2353(var1, var2, '耀');
               this.method2353(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2353(var1, var2, 66560);
               this.method2353(var1 - 1, var2, 4096);
               this.method2353(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2353(var1, var2, 5120);
               this.method2353(var1, var2 + 1, 16384);
               this.method2353(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2353(var1, var2, 20480);
               this.method2353(1 + var1, var2, 65536);
               this.method2353(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2353(var1, var2, 81920);
               this.method2353(var1, var2 - 1, 1024);
               this.method2353(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "602168660"
   )
   void method2353(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-1758930939"
   )
   public void method2355(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method2353(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "333485651"
   )
   public void method2358(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method2348(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2063310221"
   )
   public void method2376(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1248849603"
   )
   static int method2377(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class32.field726[++class32.field735 - 1] = class162.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            var3 = class181.method3349();
            if(null != var3) {
               class32.field726[++class32.field735 - 1] = var3.id;
               class32.field726[++class32.field735 - 1] = var3.mask;
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var3.activity;
               class32.field726[++class32.field735 - 1] = var3.location;
               class32.field726[++class32.field735 - 1] = var3.playerCount;
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var3.address;
            } else {
               class32.field726[++class32.field735 - 1] = -1;
               class32.field726[++class32.field735 - 1] = 0;
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
               class32.field726[++class32.field735 - 1] = 0;
               class32.field726[++class32.field735 - 1] = 0;
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = ScriptState.method159();
            if(null != var3) {
               class32.field726[++class32.field735 - 1] = var3.id;
               class32.field726[++class32.field735 - 1] = var3.mask;
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var3.activity;
               class32.field726[++class32.field735 - 1] = var3.location;
               class32.field726[++class32.field735 - 1] = var3.playerCount;
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var3.address;
            } else {
               class32.field726[++class32.field735 - 1] = -1;
               class32.field726[++class32.field735 - 1] = 0;
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
               class32.field726[++class32.field735 - 1] = 0;
               class32.field726[++class32.field735 - 1] = 0;
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class32.field726[--class32.field735];
               var4 = null;

               for(var5 = 0; var5 < World.field675; ++var5) {
                  if(var7 == CombatInfoListHolder.worldList[var5].id) {
                     var4 = CombatInfoListHolder.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class32.field726[++class32.field735 - 1] = var4.id;
                  class32.field726[++class32.field735 - 1] = var4.mask;
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var4.activity;
                  class32.field726[++class32.field735 - 1] = var4.location;
                  class32.field726[++class32.field735 - 1] = var4.playerCount;
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var4.address;
               } else {
                  class32.field726[++class32.field735 - 1] = -1;
                  class32.field726[++class32.field735 - 1] = 0;
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                  class32.field726[++class32.field735 - 1] = 0;
                  class32.field726[++class32.field735 - 1] = 0;
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class32.field735 -= 4;
               var7 = class32.field726[class32.field735];
               boolean var8 = class32.field726[1 + class32.field735] == 1;
               var5 = class32.field726[class32.field735 + 2];
               boolean var6 = class32.field726[3 + class32.field735] == 1;
               Projectile.method875(var7, var8, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field546 = class32.field726[--class32.field735] == 1;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               var7 = class32.field726[--class32.field735];
               if(var7 >= 0 && var7 < World.field675) {
                  var4 = CombatInfoListHolder.worldList[var7];
                  class32.field726[++class32.field735 - 1] = var4.id;
                  class32.field726[++class32.field735 - 1] = var4.mask;
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var4.activity;
                  class32.field726[++class32.field735 - 1] = var4.location;
                  class32.field726[++class32.field735 - 1] = var4.playerCount;
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var4.address;
               } else {
                  class32.field726[++class32.field735 - 1] = -1;
                  class32.field726[++class32.field735 - 1] = 0;
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                  class32.field726[++class32.field735 - 1] = 0;
                  class32.field726[++class32.field735 - 1] = 0;
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
               }

               return 1;
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
      this.method2342();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lclass178;",
      garbageValue = "-1168461635"
   )
   public static class178[] method2379() {
      return new class178[]{class178.field2677, class178.field2675, class178.field2674, class178.field2676};
   }
}
