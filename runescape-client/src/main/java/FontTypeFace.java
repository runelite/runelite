import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
@Implements("FontTypeFace")
public abstract class FontTypeFace extends Rasterizer2D {
   @ObfuscatedName("a")
   static int field3111 = 0;
   @ObfuscatedName("i")
   int[] field3112;
   @ObfuscatedName("u")
   int[] field3113;
   @ObfuscatedName("f")
   byte[][] field3114 = new byte[256][];
   @ObfuscatedName("d")
   static int field3115 = -1;
   @ObfuscatedName("o")
   int[] field3116;
   @ObfuscatedName("l")
   public int field3117 = 0;
   @ObfuscatedName("n")
   public int field3118;
   @ObfuscatedName("m")
   public int field3119;
   @ObfuscatedName("r")
   int[] field3120;
   @ObfuscatedName("j")
   byte[] field3121;
   @ObfuscatedName("s")
   static int field3122 = -1;
   @ObfuscatedName("q")
   static int field3123 = -1;
   @ObfuscatedName("w")
   @Export("modIcons")
   public static ModIcon[] modIcons;
   @ObfuscatedName("p")
   static int field3125 = -1;
   @ObfuscatedName("y")
   static int field3126 = 0;
   @ObfuscatedName("h")
   int[] field3127;
   @ObfuscatedName("v")
   static int field3128 = 256;
   @ObfuscatedName("z")
   static int field3129 = 0;
   @ObfuscatedName("g")
   static Random field3130 = new Random();
   @ObfuscatedName("x")
   static int field3131 = 0;
   @ObfuscatedName("b")
   static String[] field3132 = new String[100];

   FontTypeFace(byte[] var1) {
      this.method3932(var1);
   }

   @ObfuscatedName("i")
   abstract void vmethod3896(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("m")
   public int method3897(String var1) {
      if(var1 == null) {
         return 0;
      } else {
         int var2 = -1;
         int var3 = -1;
         int var4 = 0;

         for(int var5 = 0; var5 < var1.length(); ++var5) {
            char var6 = var1.charAt(var5);
            if(var6 == 60) {
               var2 = var5;
            } else {
               if(var6 == 62 && var2 != -1) {
                  String var7 = var1.substring(var2 + 1, var5);
                  var2 = -1;
                  if(var7.equals("lt")) {
                     var6 = 60;
                  } else {
                     if(!var7.equals("gt")) {
                        if(var7.startsWith("img=")) {
                           try {
                              String var9 = var7.substring(4);
                              int var8 = FloorUnderlayDefinition.method3548(var9, 10, true);
                              var4 += modIcons[var8].width;
                              var3 = -1;
                           } catch (Exception var12) {
                              ;
                           }
                        }
                        continue;
                     }

                     var6 = 62;
                  }
               }

               if(var6 == 160) {
                  var6 = 32;
               }

               if(var2 == -1) {
                  var4 += this.field3112[(char)(DecorativeObject.method1955(var6) & 255)];
                  if(this.field3121 != null && var3 != -1) {
                     var4 += this.field3121[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("q")
   public static String method3900(String var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var6 = 0; var6 < var1; ++var6) {
         char var4 = var0.charAt(var6);
         if(var4 == 60 || var4 == 62) {
            var2 += 3;
         }
      }

      StringBuilder var3 = new StringBuilder(var1 + var2);

      for(int var7 = 0; var7 < var1; ++var7) {
         char var5 = var0.charAt(var7);
         if(var5 == 60) {
            var3.append("<lt>");
         } else if(var5 == 62) {
            var3.append("<gt>");
         } else {
            var3.append(var5);
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("p")
   public void method3902(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3910(var4, var5);
         field3128 = var6;
         this.method3976(var1, var2, var3);
      }
   }

   @ObfuscatedName("ah")
   static void method3904(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var8 = Rasterizer2D.graphicsPixelsWidth - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < Rasterizer2D.field3191) {
         var11 = Rasterizer2D.field3191 - var2;
         var4 -= var11;
         var2 = Rasterizer2D.field3191;
         var10 += var11 * var3;
         var7 += var11 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var4 > Rasterizer2D.field3189) {
         var4 -= var2 + var4 - Rasterizer2D.field3189;
      }

      if(var1 < Rasterizer2D.field3193) {
         var11 = Rasterizer2D.field3193 - var1;
         var3 -= var11;
         var1 = Rasterizer2D.field3193;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > Rasterizer2D.field3194) {
         var11 = var1 + var3 - Rasterizer2D.field3194;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method3920(Rasterizer2D.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("v")
   public int method3905(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method3910(var6, var7);
         if(var10 == 0) {
            var10 = this.field3117;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3118 + this.field3119 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3978(var1, var11, field3132);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3118;
         } else if(var9 == 1) {
            var13 = var3 + this.field3118 + (var5 - this.field3118 - this.field3119 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3119 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3118 - this.field3119 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3118 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method3976(field3132[var14], var2, var13);
            } else if(var8 == 1) {
               this.method3976(field3132[var14], var2 + (var4 - this.method3897(field3132[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method3976(field3132[var14], var2 + var4 - this.method3897(field3132[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method3976(field3132[var14], var2, var13);
            } else {
               this.method3912(field3132[var14], var4);
               this.method3976(field3132[var14], var2, var13);
               field3129 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("z")
   public void method3906(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3910(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3914(var1, var2 - this.method3897(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("x")
   public void method3907(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3910(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3914(var1, var2 - this.method3897(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("j")
   public int method3908(String var1, int var2) {
      int var3 = this.method3978(var1, new int[]{var2}, field3132);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3897(field3132[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("b")
   public void method3909(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3910(var4, var5);
         field3130.setSeed((long)var6);
         field3128 = 192 + (field3130.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3130.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method3914(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("k")
   void method3910(int var1, int var2) {
      field3122 = -1;
      field3123 = -1;
      field3115 = var2;
      field3125 = var2;
      field3126 = var1;
      field3111 = var1;
      field3128 = 256;
      field3129 = 0;
      field3131 = 0;
   }

   @ObfuscatedName("t")
   void method3911(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3111 = Tile.method1580(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3111 = field3126;
         } else if(var1.startsWith("str=")) {
            field3122 = Tile.method1580(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3122 = 8388608;
         } else if(var1.equals("/str")) {
            field3122 = -1;
         } else if(var1.startsWith("u=")) {
            field3123 = Tile.method1580(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3123 = 0;
         } else if(var1.equals("/u")) {
            field3123 = -1;
         } else if(var1.startsWith("shad=")) {
            field3125 = Tile.method1580(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3125 = 0;
         } else if(var1.equals("/shad")) {
            field3125 = field3115;
         } else if(var1.equals("br")) {
            this.method3910(field3126, field3115);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("c")
   void method3912(String var1, int var2) {
      int var3 = 0;
      boolean var4 = false;

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         char var6 = var1.charAt(var5);
         if(var6 == 60) {
            var4 = true;
         } else if(var6 == 62) {
            var4 = false;
         } else if(!var4 && var6 == 32) {
            ++var3;
         }
      }

      if(var3 > 0) {
         field3129 = (var2 - this.method3897(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("am")
   void method3914(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3117;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(DecorativeObject.method1955(var1.charAt(var9)) & 255);
            if(var10 == 60) {
               var6 = var9;
            } else {
               int var12;
               int var13;
               int var14;
               if(var10 == 62 && var6 != -1) {
                  String var11 = var1.substring(var6 + 1, var9);
                  var6 = -1;
                  if(var11.equals("lt")) {
                     var10 = 60;
                  } else {
                     if(!var11.equals("gt")) {
                        if(var11.startsWith("img=")) {
                           try {
                              if(var4 != null) {
                                 var12 = var4[var8];
                              } else {
                                 var12 = 0;
                              }

                              if(var5 != null) {
                                 var13 = var5[var8];
                              } else {
                                 var13 = 0;
                              }

                              ++var8;
                              String var15 = var11.substring(4);
                              var14 = FloorUnderlayDefinition.method3548(var15, 10, true);
                              ModIcon var17 = modIcons[var14];
                              var17.method4088(var2 + var12, var3 + this.field3117 - var17.originalHeight + var13);
                              var2 += var17.width;
                              var7 = -1;
                           } catch (Exception var21) {
                              ;
                           }
                        } else {
                           this.method3911(var11);
                        }
                        continue;
                     }

                     var10 = 62;
                  }
               }

               if(var10 == 160) {
                  var10 = 32;
               }

               if(var6 == -1) {
                  if(this.field3121 != null && var7 != -1) {
                     var2 += this.field3121[(var7 << 8) + var10];
                  }

                  int var19 = this.field3113[var10];
                  var12 = this.field3127[var10];
                  if(var4 != null) {
                     var13 = var4[var8];
                  } else {
                     var13 = 0;
                  }

                  if(var5 != null) {
                     var14 = var5[var8];
                  } else {
                     var14 = 0;
                  }

                  ++var8;
                  if(var10 != 32) {
                     if(field3128 == 256) {
                        if(field3125 != -1) {
                           method3917(this.field3114[var10], var2 + this.field3120[var10] + 1 + var13, var3 + this.field3116[var10] + 1 + var14, var19, var12, field3125);
                        }

                        this.vmethod3915(this.field3114[var10], var2 + this.field3120[var10] + var13, var3 + this.field3116[var10] + var14, var19, var12, field3111);
                     } else {
                        if(field3125 != -1) {
                           method3904(this.field3114[var10], var2 + this.field3120[var10] + 1 + var13, var3 + this.field3116[var10] + 1 + var14, var19, var12, field3125, field3128);
                        }

                        this.vmethod3896(this.field3114[var10], var2 + this.field3120[var10] + var13, var3 + this.field3116[var10] + var14, var19, var12, field3111, field3128);
                     }
                  } else if(field3129 > 0) {
                     field3131 += field3129;
                     var2 += field3131 >> 8;
                     field3131 &= 255;
                  }

                  int var20 = this.field3112[var10];
                  if(field3122 != -1) {
                     Rasterizer2D.method4027(var2, var3 + (int)((double)this.field3117 * 0.7D), var20, field3122);
                  }

                  if(field3123 != -1) {
                     Rasterizer2D.method4027(var2, var3 + this.field3117, var20, field3123);
                  }

                  var2 += var20;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   abstract void vmethod3915(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("g")
   public void method3916(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method3910(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method3914(var1, var2 - this.method3897(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("an")
   static void method3917(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var7 = Rasterizer2D.graphicsPixelsWidth - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < Rasterizer2D.field3191) {
         var10 = Rasterizer2D.field3191 - var2;
         var4 -= var10;
         var2 = Rasterizer2D.field3191;
         var9 += var10 * var3;
         var6 += var10 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var4 > Rasterizer2D.field3189) {
         var4 -= var2 + var4 - Rasterizer2D.field3189;
      }

      if(var1 < Rasterizer2D.field3193) {
         var10 = Rasterizer2D.field3193 - var1;
         var3 -= var10;
         var1 = Rasterizer2D.field3193;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > Rasterizer2D.field3194) {
         var10 = var1 + var3 - Rasterizer2D.field3194;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method3927(Rasterizer2D.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("ag")
   static void method3920(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      var2 = ((var2 & 16711935) * var9 & -16711936) + ((var2 & '\uff00') * var9 & 16711680) >> 8;
      var9 = 256 - var9;

      for(int var10 = -var6; var10 < 0; ++var10) {
         for(int var11 = -var5; var11 < 0; ++var11) {
            if(var1[var3++] != 0) {
               int var12 = var0[var4];
               var0[var4++] = (((var12 & 16711935) * var9 & -16711936) + ((var12 & '\uff00') * var9 & 16711680) >> 8) + var2;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   @ObfuscatedName("s")
   public int method3921(String var1, int var2) {
      return this.method3978(var1, new int[]{var2}, field3132);
   }

   @ObfuscatedName("aq")
   static void method3927(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = -(var5 >> 2);
      var5 = -(var5 & 3);

      for(int var10 = -var6; var10 < 0; ++var10) {
         int var11;
         for(var11 = var9; var11 < 0; ++var11) {
            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         for(var11 = var5; var11 < 0; ++var11) {
            if(var1[var3++] != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3930(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3910(var4, var5);
         this.method3976(var1, var2, var3);
      }
   }

   @ObfuscatedName("o")
   void method3932(byte[] var1) {
      this.field3112 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3112.length; ++var2) {
            this.field3112[var2] = var1[var2] & 255;
         }

         this.field3117 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var10 = 0; var10 < 256; ++var10) {
            this.field3112[var10] = var1[var2++] & 255;
         }

         int[] var3 = new int[256];
         int[] var4 = new int[256];

         int var5;
         for(var5 = 0; var5 < 256; ++var5) {
            var3[var5] = var1[var2++] & 255;
         }

         for(var5 = 0; var5 < 256; ++var5) {
            var4[var5] = var1[var2++] & 255;
         }

         byte[][] var12 = new byte[256][];

         int var8;
         for(int var11 = 0; var11 < 256; ++var11) {
            var12[var11] = new byte[var3[var11]];
            byte var7 = 0;

            for(var8 = 0; var8 < var12[var11].length; ++var8) {
               var7 += var1[var2++];
               var12[var11][var8] = var7;
            }
         }

         byte[][] var6 = new byte[256][];

         int var13;
         for(var13 = 0; var13 < 256; ++var13) {
            var6[var13] = new byte[var3[var13]];
            byte var14 = 0;

            for(int var9 = 0; var9 < var6[var13].length; ++var9) {
               var14 += var1[var2++];
               var6[var13][var9] = var14;
            }
         }

         this.field3121 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3121[(var13 << 8) + var8] = (byte)method3961(var12, var6, var4, this.field3112, var3, var13, var8);
                  }
               }
            }
         }

         this.field3117 = var4[32] + var3[32];
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3941(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3910(var4, var5);
         this.method3976(var1, var2 - this.method3897(var1), var3);
      }
   }

   @ObfuscatedName("n")
   int method3953(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3112[DecorativeObject.method1955(var1) & 255];
   }

   FontTypeFace(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3120 = var2;
      this.field3116 = var3;
      this.field3113 = var4;
      this.field3127 = var5;
      this.method3932(var1);
      this.field3114 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3116[var10] < var8 && this.field3127[var10] != 0) {
            var8 = this.field3116[var10];
         }

         if(this.field3116[var10] + this.field3127[var10] > var9) {
            var9 = this.field3116[var10] + this.field3127[var10];
         }
      }

      this.field3118 = this.field3117 - var8;
      this.field3119 = var9 - this.field3117;
   }

   @ObfuscatedName("l")
   static int method3961(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
      int var7 = var2[var5];
      int var8 = var7 + var4[var5];
      int var9 = var2[var6];
      int var10 = var9 + var4[var6];
      int var11 = var7;
      if(var9 > var7) {
         var11 = var9;
      }

      int var12 = var8;
      if(var10 < var8) {
         var12 = var10;
      }

      int var13 = var3[var5];
      if(var3[var6] < var13) {
         var13 = var3[var6];
      }

      byte[] var14 = var1[var5];
      byte[] var15 = var0[var6];
      int var16 = var11 - var7;
      int var17 = var11 - var9;

      for(int var18 = var11; var18 < var12; ++var18) {
         int var19 = var14[var16++] + var15[var17++];
         if(var19 < var13) {
            var13 = var19;
         }
      }

      return -var13;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3963(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3910(var4, var5);
         this.method3976(var1, var2 - this.method3897(var1) / 2, var3);
      }
   }

   @ObfuscatedName("e")
   void method3976(String var1, int var2, int var3) {
      var3 -= this.field3117;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(DecorativeObject.method1955(var1.charAt(var6)) & 255);
            if(var7 == 60) {
               var4 = var6;
            } else {
               int var9;
               if(var7 == 62 && var4 != -1) {
                  String var8 = var1.substring(var4 + 1, var6);
                  var4 = -1;
                  if(var8.equals("lt")) {
                     var7 = 60;
                  } else {
                     if(!var8.equals("gt")) {
                        if(var8.startsWith("img=")) {
                           try {
                              String var10 = var8.substring(4);
                              var9 = FloorUnderlayDefinition.method3548(var10, 10, true);
                              ModIcon var12 = modIcons[var9];
                              var12.method4088(var2, var3 + this.field3117 - var12.originalHeight);
                              var2 += var12.width;
                              var5 = -1;
                           } catch (Exception var16) {
                              ;
                           }
                        } else {
                           this.method3911(var8);
                        }
                        continue;
                     }

                     var7 = 62;
                  }
               }

               if(var7 == 160) {
                  var7 = 32;
               }

               if(var4 == -1) {
                  if(this.field3121 != null && var5 != -1) {
                     var2 += this.field3121[(var5 << 8) + var7];
                  }

                  int var14 = this.field3113[var7];
                  var9 = this.field3127[var7];
                  if(var7 != 32) {
                     if(field3128 == 256) {
                        if(field3125 != -1) {
                           method3917(this.field3114[var7], var2 + this.field3120[var7] + 1, var3 + this.field3116[var7] + 1, var14, var9, field3125);
                        }

                        this.vmethod3915(this.field3114[var7], var2 + this.field3120[var7], var3 + this.field3116[var7], var14, var9, field3111);
                     } else {
                        if(field3125 != -1) {
                           method3904(this.field3114[var7], var2 + this.field3120[var7] + 1, var3 + this.field3116[var7] + 1, var14, var9, field3125, field3128);
                        }

                        this.vmethod3896(this.field3114[var7], var2 + this.field3120[var7], var3 + this.field3116[var7], var14, var9, field3111, field3128);
                     }
                  } else if(field3129 > 0) {
                     field3131 += field3129;
                     var2 += field3131 >> 8;
                     field3131 &= 255;
                  }

                  int var15 = this.field3112[var7];
                  if(field3122 != -1) {
                     Rasterizer2D.method4027(var2, var3 + (int)((double)this.field3117 * 0.7D), var15, field3122);
                  }

                  if(field3123 != -1) {
                     Rasterizer2D.method4027(var2, var3 + this.field3117 + 1, var15, field3123);
                  }

                  var2 += var15;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   int method3978(String var1, int[] var2, String[] var3) {
      if(var1 == null) {
         return 0;
      } else {
         int var4 = 0;
         int var5 = 0;
         StringBuilder var6 = new StringBuilder(100);
         int var7 = -1;
         int var8 = 0;
         byte var9 = 0;
         int var10 = -1;
         char var11 = 0;
         int var12 = 0;
         int var13 = var1.length();

         for(int var14 = 0; var14 < var13; ++var14) {
            char var15 = var1.charAt(var14);
            if(var15 == 60) {
               var10 = var14;
            } else {
               if(var15 == 62 && var10 != -1) {
                  String var16 = var1.substring(var10 + 1, var14);
                  var10 = -1;
                  var6.append('<');
                  var6.append(var16);
                  var6.append('>');
                  if(var16.equals("br")) {
                     var3[var12] = var6.toString().substring(var5, var6.length());
                     ++var12;
                     var5 = var6.length();
                     var4 = 0;
                     var7 = -1;
                     var11 = 0;
                  } else if(var16.equals("lt")) {
                     var4 += this.method3953('<');
                     if(this.field3121 != null && var11 != -1) {
                        var4 += this.field3121[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method3953('>');
                     if(this.field3121 != null && var11 != -1) {
                        var4 += this.field3121[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = FloorUnderlayDefinition.method3548(var18, 10, true);
                        var4 += modIcons[var17].width;
                        var11 = 0;
                     } catch (Exception var22) {
                        ;
                     }
                  }

                  var15 = 0;
               }

               if(var10 == -1) {
                  if(var15 != 0) {
                     var6.append(var15);
                     var4 += this.method3953(var15);
                     if(this.field3121 != null && var11 != -1) {
                        var4 += this.field3121[(var11 << 8) + var15];
                     }

                     var11 = var15;
                  }

                  if(var15 == 32) {
                     var7 = var6.length();
                     var8 = var4;
                     var9 = 1;
                  }

                  if(var2 != null && var4 > var2[var12 < var2.length?var12:var2.length - 1] && var7 >= 0) {
                     var3[var12] = var6.toString().substring(var5, var7 - var9);
                     ++var12;
                     var5 = var7;
                     var7 = -1;
                     var4 -= var8;
                     var11 = 0;
                  }

                  if(var15 == 45) {
                     var7 = var6.length();
                     var8 = var4;
                     var9 = 0;
                  }
               }
            }
         }

         String var21 = var6.toString();
         if(var21.length() > var5) {
            var3[var12++] = var21.substring(var5, var21.length());
         }

         return var12;
      }
   }
}
