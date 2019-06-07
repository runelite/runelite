import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("Huffman")
public class Huffman {
   @ObfuscatedName("e")
   @Export("__gd_e")
   static int[][] __gd_e;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -842662451
   )
   @Export("canvasHeight")
   public static int canvasHeight;
   @ObfuscatedName("m")
   @Export("__m")
   int[] __m;
   @ObfuscatedName("f")
   @Export("__f")
   byte[] __f;
   @ObfuscatedName("q")
   @Export("__q")
   int[] __q;

   public Huffman(byte[] var1) {
      int var2 = var1.length;
      this.__m = new int[var2];
      this.__f = var1;
      int[] var3 = new int[33];
      this.__q = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.__m[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.__q[var10] == 0) {
                     this.__q[var10] = var4;
                  }

                  var10 = this.__q[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.__q.length) {
                  int[] var13 = new int[this.__q.length * 2];

                  for(int var14 = 0; var14 < this.__q.length; ++var14) {
                     var13[var14] = this.__q[var14];
                  }

                  this.__q = var13;
               }

               var12 >>>= 1;
            }

            this.__q[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "64"
   )
   @Export("__m_293")
   public int __m_293(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.__m[var8];
         byte var10 = this.__f[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var10 + var12 - 1 >> 3) + var11;
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-2094399899"
   )
   @Export("__f_294")
   public int __f_294(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.__q[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.__q[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.__q[var6];
            } else {
               ++var6;
            }

            if((var9 = this.__q[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.__q[var6];
            } else {
               ++var6;
            }

            if((var9 = this.__q[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.__q[var6];
            } else {
               ++var6;
            }

            if((var9 = this.__q[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.__q[var6];
            } else {
               ++var6;
            }

            if((var9 = this.__q[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.__q[var6];
            } else {
               ++var6;
            }

            if((var9 = this.__q[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.__q[var6];
            } else {
               ++var6;
            }

            if((var9 = this.__q[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.__q[var6];
            } else {
               ++var6;
            }

            if((var9 = this.__q[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lho;",
      garbageValue = "60"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = GroundItemPile.loadWidgetGroup(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SB)V",
      garbageValue = "-20"
   )
   public static void method3695(String[] var0, short[] var1) {
      DynamicObject.method2218(var0, var1, 0, var0.length - 1);
   }
}
