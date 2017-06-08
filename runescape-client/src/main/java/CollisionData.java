import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1691438483
   )
   @Export("x")
   public int x;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 873117027
   )
   @Export("width")
   int width;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 842042361
   )
   @Export("y")
   public int y;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -950734271
   )
   @Export("height")
   int height;
   @ObfuscatedName("ah")
   @Export("flags")
   public int[][] flags;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-245787913"
   )
   public void method3015(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method3017(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void method3016() {
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "121"
   )
   void method3017(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1952631595"
   )
   public void method3018(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method3040(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "16"
   )
   public void method3019(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "1"
   )
   public void method3020(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method3040(var1, var2, 128);
            this.method3040(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method3040(var1, var2, 2);
            this.method3040(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method3040(var1, var2, 8);
            this.method3040(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method3040(var1, var2, 32);
            this.method3040(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method3040(var1, var2, 1);
            this.method3040(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method3040(var1, var2, 4);
            this.method3040(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method3040(var1, var2, 16);
            this.method3040(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method3040(var1, var2, 64);
            this.method3040(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method3040(var1, var2, 130);
            this.method3040(var1 - 1, var2, 8);
            this.method3040(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method3040(var1, var2, 10);
            this.method3040(var1, var2 + 1, 32);
            this.method3040(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method3040(var1, var2, 40);
            this.method3040(var1 + 1, var2, 128);
            this.method3040(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method3040(var1, var2, 160);
            this.method3040(var1, var2 - 1, 2);
            this.method3040(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method3040(var1, var2, 65536);
               this.method3040(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method3040(var1, var2, 1024);
               this.method3040(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method3040(var1, var2, 4096);
               this.method3040(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method3040(var1, var2, 16384);
               this.method3040(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method3040(var1, var2, 512);
               this.method3040(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method3040(var1, var2, 2048);
               this.method3040(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method3040(var1, var2, 8192);
               this.method3040(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method3040(var1, var2, '耀');
               this.method3040(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method3040(var1, var2, 66560);
               this.method3040(var1 - 1, var2, 4096);
               this.method3040(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method3040(var1, var2, 5120);
               this.method3040(var1, var2 + 1, 16384);
               this.method3040(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method3040(var1, var2, 20480);
               this.method3040(var1 + 1, var2, 65536);
               this.method3040(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method3040(var1, var2, 81920);
               this.method3040(var1, var2 - 1, 1024);
               this.method3040(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1249812789"
   )
   public void method3022(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method3017(var1, var2, 128);
            this.method3017(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method3017(var1, var2, 2);
            this.method3017(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method3017(var1, var2, 8);
            this.method3017(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method3017(var1, var2, 32);
            this.method3017(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method3017(var1, var2, 1);
            this.method3017(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method3017(var1, var2, 4);
            this.method3017(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method3017(var1, var2, 16);
            this.method3017(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method3017(var1, var2, 64);
            this.method3017(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method3017(var1, var2, 130);
            this.method3017(var1 - 1, var2, 8);
            this.method3017(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method3017(var1, var2, 10);
            this.method3017(var1, var2 + 1, 32);
            this.method3017(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method3017(var1, var2, 40);
            this.method3017(var1 + 1, var2, 128);
            this.method3017(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method3017(var1, var2, 160);
            this.method3017(var1, var2 - 1, 2);
            this.method3017(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method3017(var1, var2, 65536);
               this.method3017(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method3017(var1, var2, 1024);
               this.method3017(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method3017(var1, var2, 4096);
               this.method3017(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method3017(var1, var2, 16384);
               this.method3017(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method3017(var1, var2, 512);
               this.method3017(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method3017(var1, var2, 2048);
               this.method3017(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method3017(var1, var2, 8192);
               this.method3017(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method3017(var1, var2, '耀');
               this.method3017(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method3017(var1, var2, 66560);
               this.method3017(var1 - 1, var2, 4096);
               this.method3017(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method3017(var1, var2, 5120);
               this.method3017(var1, var2 + 1, 16384);
               this.method3017(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method3017(var1, var2, 20480);
               this.method3017(var1 + 1, var2, 65536);
               this.method3017(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method3017(var1, var2, 81920);
               this.method3017(var1, var2 - 1, 1024);
               this.method3017(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass289;I)Ljava/lang/String;",
      garbageValue = "1525743263"
   )
   public static String method3023(CharSequence var0, class289 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class17.method146(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class17.method146(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= class162.method3054(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               if(WorldMapType1.method268(var7)) {
                  char var8;
                  switch(var7) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var8 = 95;
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var8 = var7;
                     break;
                  case 'À':
                  case 'Á':
                  case 'Â':
                  case 'Ã':
                  case 'Ä':
                  case 'à':
                  case 'á':
                  case 'â':
                  case 'ã':
                  case 'ä':
                     var8 = 97;
                     break;
                  case 'Ç':
                  case 'ç':
                     var8 = 99;
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var8 = 101;
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var8 = 105;
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var8 = 110;
                     break;
                  case 'Ò':
                  case 'Ó':
                  case 'Ô':
                  case 'Õ':
                  case 'Ö':
                  case 'ò':
                  case 'ó':
                  case 'ô':
                  case 'õ':
                  case 'ö':
                     var8 = 111;
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var8 = 117;
                     break;
                  case 'ß':
                     var8 = 98;
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var8 = 121;
                     break;
                  default:
                     var8 = Character.toLowerCase(var7);
                  }

                  if(var8 != 0) {
                     var5.append(var8);
                  }
               }
            }

            if(var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1410563350"
   )
   public void method3025(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
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
      this.method3016();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "13"
   )
   public void method3037(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1708300494"
   )
   void method3040(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }
}
