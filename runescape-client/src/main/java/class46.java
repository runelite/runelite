import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class46 {
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -230003367
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   static Task field609;
   @ObfuscatedName("s")
   byte[][][] field607;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1548222003
   )
   int field610;

   class46(int var1) {
      this.field610 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-37"
   )
   void method685() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[0][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[0][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[0][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[0][3] = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "134"
   )
   int method670(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1051753844"
   )
   void method660() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[1][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field607[1][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[1][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[1][3] = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1018720661"
   )
   int method657(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1046789439"
   )
   void method661() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[2][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[2][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[2][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[2][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "257496041"
   )
   void method662() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[3][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[3][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[3][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[3][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "772858437"
   )
   void method669() {
      byte[] var1 = new byte[this.field610 * this.field610];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[4][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[4][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[4][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var2 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field607[4][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1504128703"
   )
   void method696() {
      byte[] var1 = new byte[this.field610 * this.field610];
      boolean var2 = false;
      var1 = new byte[this.field610 * this.field610];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[5][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var3 <= this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[5][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[5][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var3 >= this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[5][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-525943392"
   )
   void method664() {
      byte[] var1 = new byte[this.field610 * this.field610];
      boolean var2 = false;
      var1 = new byte[this.field610 * this.field610];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[6][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 <= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[6][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[6][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[6][3] = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "33"
   )
   void method663() {
      byte[] var1 = new byte[this.field610 * this.field610];
      boolean var2 = false;
      var1 = new byte[this.field610 * this.field610];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[7][0] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field610; ++var4) {
            if(var4 >= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[7][1] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = this.field610 - 1; var3 >= 0; --var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[7][2] = var1;
      var1 = new byte[this.field610 * this.field610];
      var5 = 0;

      for(var3 = 0; var3 < this.field610; ++var3) {
         for(var4 = this.field610 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field610 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field607[7][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1460583618"
   )
   void method658() {
      if(this.field607 == null) {
         this.field607 = new byte[8][4][];
         this.method685();
         this.method660();
         this.method661();
         this.method662();
         this.method669();
         this.method696();
         this.method664();
         this.method663();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1081422886"
   )
   void method655(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field610 != 0 && this.field607 != null) {
         var8 = this.method670(var8, var7);
         var7 = this.method657(var7);
         Rasterizer2D.method5050(var1, var2, var5, var6, var3, var4, this.field607[var7 - 1][var8], this.field610);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "226950826"
   )
   public static void method680(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method694() {
      if(class70.loadWorlds()) {
         class90.worldSelectShown = true;
      }

   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-315687682"
   )
   static boolean method693(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CIB)C",
      garbageValue = "62"
   )
   public static char method659(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
