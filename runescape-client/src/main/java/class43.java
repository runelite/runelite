import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class43 {
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static Font field544;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1619839727
   )
   int field543;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1684974199
   )
   int field539;
   @ObfuscatedName("x")
   int[][] field540;
   @ObfuscatedName("e")
   int[][] field542;
   @ObfuscatedName("y")
   int[][] field541;
   @ObfuscatedName("f")
   int[][] field538;

   class43(int var1, int var2) {
      this.field543 = var1;
      this.field539 = var2;
      this.field540 = new int[var1][var2];
      this.field541 = new int[var1][var2];
      this.field542 = new int[var1][var2];
      this.field538 = new int[var1][var2];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-557985748"
   )
   int method626(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field543 && var2 < this.field539) {
         if(this.field542[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field540[var1][var2] / this.field538[var1][var2];
            int var4 = this.field541[var1][var2] / this.field538[var1][var2];
            int var5 = this.field542[var1][var2] / this.field538[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(var9 != 0.0D) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = var11 * (1.0D + var9);
               } else {
                  var19 = var9 + var11 - var9 * var11;
               }

               double var21 = var11 * 2.0D - var19;
               double var23 = 0.3333333333333333D + var7;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var7 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(6.0D * var23 < 1.0D) {
                  var13 = var21 + 6.0D * (var19 - var21) * var23;
               } else if(2.0D * var23 < 1.0D) {
                  var13 = var19;
               } else if(var23 * 3.0D < 2.0D) {
                  var13 = var21 + (var19 - var21) * (0.6666666666666666D - var23) * 6.0D;
               } else {
                  var13 = var21;
               }

               if(6.0D * var7 < 1.0D) {
                  var15 = var21 + var7 * (var19 - var21) * 6.0D;
               } else if(var7 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var7 < 2.0D) {
                  var15 = 6.0D * (0.6666666666666666D - var7) * (var19 - var21) + var21;
               } else {
                  var15 = var21;
               }

               if(var27 * 6.0D < 1.0D) {
                  var17 = var27 * 6.0D * (var19 - var21) + var21;
               } else if(var27 * 2.0D < 1.0D) {
                  var17 = var19;
               } else if(3.0D * var27 < 2.0D) {
                  var17 = var21 + (var19 - var21) * (0.6666666666666666D - var27) * 6.0D;
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(var13 * 256.0D);
            int var20 = (int)(var15 * 256.0D);
            int var30 = (int)(256.0D * var17);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            return var22;
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILiy;B)V",
      garbageValue = "106"
   )
   void method635(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field543 && var2 - var3 <= this.field539) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field543, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field539, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field540[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field541[var9][var10] += var4.saturation;
                     this.field542[var9][var10] += var4.lightness;
                     ++this.field538[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lib;IIIBZI)V",
      garbageValue = "-966118427"
   )
   static void method628(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class238.field3236.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class238.field3246.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class238.field3241.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class238.field3236.put(var8, var6);
                  --class238.field3243;
                  ++class238.field3234;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class238.field3233.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class238.field3236.put(var8, var6);
                  ++class238.field3234;
               } else {
                  class238.field3240.push(var8);
                  class238.field3241.put(var8, var6);
                  ++class238.field3243;
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1040729330"
   )
   static char method634(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
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
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
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
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "1986737288"
   )
   static void method633(byte[] var0, int var1) {
      if(Client.field930 == null) {
         Client.field930 = new byte[24];
      }

      class183.method3506(var0, var1, Client.field930, 0, 24);
   }
}
