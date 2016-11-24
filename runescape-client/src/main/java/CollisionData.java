import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -552280571
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 131938003
   )
   @Export("width")
   int width;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 425801271
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("ap")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1778389721
   )
   @Export("height")
   int height;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1656450862"
   )
   public void method2302() {
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1106025826"
   )
   public void method2303(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2059848385"
   )
   public void method2305(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "622290707"
   )
   public void method2306(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2122310312"
   )
   void method2307(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1038639023"
   )
   public void method2309(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method2310(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1715029530"
   )
   void method2310(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "1700682508"
   )
   public static int method2313(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = (char)var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = (char)var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         byte var11;
         if(var9 == 198) {
            var11 = 69;
         } else if(var9 == 230) {
            var11 = 101;
         } else if(var9 == 223) {
            var11 = 115;
         } else if(var9 == 338) {
            var11 = 69;
         } else if(var9 == 339) {
            var11 = 101;
         } else {
            var11 = 0;
         }

         var7 = var11;
         byte var12;
         if(var10 == 198) {
            var12 = 69;
         } else if(var10 == 230) {
            var12 = 101;
         } else if(var10 == 223) {
            var12 = 115;
         } else if(var10 == 338) {
            var12 = 69;
         } else if(var10 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = class115.method2271(var9, var2);
         var10 = class115.method2271(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return PlayerComposition.method2822(var9, var2) - PlayerComposition.method2822(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      int var17;
      char var20;
      for(var17 = 0; var17 < var16; ++var17) {
         char var18 = var0.charAt(var17);
         var20 = var1.charAt(var17);
         if(var18 != var20 && Character.toUpperCase(var18) != Character.toUpperCase(var20)) {
            var18 = Character.toLowerCase(var18);
            var20 = Character.toLowerCase(var20);
            if(var18 != var20) {
               return PlayerComposition.method2822(var18, var2) - PlayerComposition.method2822(var20, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var19 = 0; var19 < var16; ++var19) {
            var20 = var0.charAt(var19);
            char var13 = var1.charAt(var19);
            if(var20 != var13) {
               return PlayerComposition.method2822(var20, var2) - PlayerComposition.method2822(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-811326214"
   )
   public void method2318(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2310(var1, var2, 128);
            this.method2310(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2310(var1, var2, 2);
            this.method2310(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2310(var1, var2, 8);
            this.method2310(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2310(var1, var2, 32);
            this.method2310(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2310(var1, var2, 1);
            this.method2310(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2310(var1, var2, 4);
            this.method2310(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2310(var1, var2, 16);
            this.method2310(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2310(var1, var2, 64);
            this.method2310(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2310(var1, var2, 130);
            this.method2310(var1 - 1, var2, 8);
            this.method2310(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2310(var1, var2, 10);
            this.method2310(var1, 1 + var2, 32);
            this.method2310(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2310(var1, var2, 40);
            this.method2310(1 + var1, var2, 128);
            this.method2310(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2310(var1, var2, 160);
            this.method2310(var1, var2 - 1, 2);
            this.method2310(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2310(var1, var2, 65536);
               this.method2310(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2310(var1, var2, 1024);
               this.method2310(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2310(var1, var2, 4096);
               this.method2310(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2310(var1, var2, 16384);
               this.method2310(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2310(var1, var2, 512);
               this.method2310(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2310(var1, var2, 2048);
               this.method2310(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2310(var1, var2, 8192);
               this.method2310(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2310(var1, var2, '耀');
               this.method2310(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2310(var1, var2, 66560);
               this.method2310(var1 - 1, var2, 4096);
               this.method2310(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2310(var1, var2, 5120);
               this.method2310(var1, var2 + 1, 16384);
               this.method2310(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2310(var1, var2, 20480);
               this.method2310(var1 + 1, var2, 65536);
               this.method2310(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2310(var1, var2, 81920);
               this.method2310(var1, var2 - 1, 1024);
               this.method2310(var1 - 1, var2, 4096);
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
      this.method2302();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1060252666"
   )
   public void method2326(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2307(var1, var2, 128);
            this.method2307(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2307(var1, var2, 2);
            this.method2307(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2307(var1, var2, 8);
            this.method2307(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2307(var1, var2, 32);
            this.method2307(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2307(var1, var2, 1);
            this.method2307(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2307(var1, var2, 4);
            this.method2307(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2307(var1, var2, 16);
            this.method2307(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2307(var1, var2, 64);
            this.method2307(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2307(var1, var2, 130);
            this.method2307(var1 - 1, var2, 8);
            this.method2307(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2307(var1, var2, 10);
            this.method2307(var1, 1 + var2, 32);
            this.method2307(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2307(var1, var2, 40);
            this.method2307(1 + var1, var2, 128);
            this.method2307(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2307(var1, var2, 160);
            this.method2307(var1, var2 - 1, 2);
            this.method2307(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2307(var1, var2, 65536);
               this.method2307(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2307(var1, var2, 1024);
               this.method2307(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2307(var1, var2, 4096);
               this.method2307(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2307(var1, var2, 16384);
               this.method2307(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2307(var1, var2, 512);
               this.method2307(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2307(var1, var2, 2048);
               this.method2307(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2307(var1, var2, 8192);
               this.method2307(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2307(var1, var2, '耀');
               this.method2307(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2307(var1, var2, 66560);
               this.method2307(var1 - 1, var2, 4096);
               this.method2307(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2307(var1, var2, 5120);
               this.method2307(var1, 1 + var2, 16384);
               this.method2307(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2307(var1, var2, 20480);
               this.method2307(var1 + 1, var2, 65536);
               this.method2307(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2307(var1, var2, 81920);
               this.method2307(var1, var2 - 1, 1024);
               this.method2307(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1967971033"
   )
   public void method2333(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method2307(var7, var8, var6);
               }
            }
         }
      }

   }
}
