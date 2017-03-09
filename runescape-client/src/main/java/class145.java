import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class145 {
   @ObfuscatedName("x")
   int[] field2014;
   @ObfuscatedName("c")
   int[] field2015;
   @ObfuscatedName("j")
   byte[] field2016;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -979558923
   )
   protected static int field2018;
   @ObfuscatedName("du")
   static byte[][] field2019;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BII[BIS)I",
      garbageValue = "-32580"
   )
   public int method2759(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2014[var8];
         byte var10 = this.field2016[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = var11 + (var10 + var12 - 1 >> 3);
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

      return (7 + var7 >> 3) - var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass110;ZI)V",
      garbageValue = "-1658850232"
   )
   public static void method2760(class110 var0, boolean var1) {
      if(null != class185.field2748) {
         try {
            class185.field2748.method2115();
         } catch (Exception var6) {
            ;
         }

         class185.field2748 = null;
      }

      class185.field2748 = var0;
      class44.method884(var1);
      class185.field2752.offset = 0;
      FloorUnderlayDefinition.field2808 = null;
      class72.field1196 = null;
      class185.field2753 = 0;

      while(true) {
         class181 var2 = (class181)class185.field2745.method2391();
         if(var2 == null) {
            while(true) {
               var2 = (class181)class185.field2750.method2391();
               if(var2 == null) {
                  if(class185.field2756 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.method2843(4);
                        var7.method2843(class185.field2756);
                        var7.method2817(0);
                        class185.field2748.method2117(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class185.field2748.method2115();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class185.field2758;
                        class185.field2748 = null;
                     }
                  }

                  class185.field2741 = 0;
                  class185.field2742 = class99.method2005();
                  return;
               }

               class185.field2747.method2336(var2);
               class185.field2757.method2403(var2, var2.hash);
               ++class185.field2749;
               --class185.field2751;
            }
         }

         class185.field2743.method2403(var2, var2.hash);
         ++class185.field2744;
         --class185.field2759;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "-2091626818"
   )
   public int method2761(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2015[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2015[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2015[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2015[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2015[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2015[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2015[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2015[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2015[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2015[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2015[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2015[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2015[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2015[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2015[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2015[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return 1 + var7 - var2;
      }
   }

   public class145(byte[] var1) {
      int var2 = var1.length;
      this.field2014 = new int[var2];
      this.field2016 = var1;
      int[] var3 = new int[33];
      this.field2015 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2014[var5] = var8;
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
                  if(this.field2015[var10] == 0) {
                     this.field2015[var10] = var4;
                  }

                  var10 = this.field2015[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2015.length) {
                  int[] var13 = new int[this.field2015.length * 2];

                  for(int var14 = 0; var14 < this.field2015.length; ++var14) {
                     var13[var14] = this.field2015[var14];
                  }

                  this.field2015 = var13;
               }

               var12 >>>= 1;
            }

            this.field2015[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-1402081053"
   )
   public static void method2763(class182 var0) {
      class231.field3298 = var0;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1649992139"
   )
   static final int method2764() {
      return Client.menuOptionCount <= 0?-1:(Client.field561 && class105.field1725[81] && Client.field391 != -1?Client.field391:Client.menuOptionCount - 1);
   }
}
