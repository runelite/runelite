import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("FontTypeFace")
public abstract class FontTypeFace extends Rasterizer2D {
   @ObfuscatedName("b")
   static int field3106 = 0;
   @ObfuscatedName("n")
   int[] field3107;
   @ObfuscatedName("k")
   static int field3108 = -1;
   @ObfuscatedName("v")
   int[] field3109;
   @ObfuscatedName("y")
   int[] field3110;
   @ObfuscatedName("c")
   static int field3111 = 0;
   @ObfuscatedName("j")
   public int field3112 = 0;
   @ObfuscatedName("m")
   public int field3113;
   @ObfuscatedName("a")
   public int field3114;
   @ObfuscatedName("i")
   @Export("modIcons")
   public static ModIcon[] modIcons;
   @ObfuscatedName("w")
   static int field3116 = 256;
   @ObfuscatedName("p")
   int[] field3117;
   @ObfuscatedName("f")
   static int field3118 = -1;
   @ObfuscatedName("o")
   static int field3119 = -1;
   @ObfuscatedName("q")
   static int field3120 = -1;
   @ObfuscatedName("u")
   static Random field3121 = new Random();
   @ObfuscatedName("s")
   byte[] field3122;
   @ObfuscatedName("x")
   byte[][] field3123 = new byte[256][];
   @ObfuscatedName("g")
   int[] field3124;
   @ObfuscatedName("r")
   static int field3125 = 0;
   @ObfuscatedName("l")
   static int field3126 = 0;
   @ObfuscatedName("e")
   static String[] field3127 = new String[100];

   FontTypeFace(byte[] var1) {
      this.method3901(var1);
   }

   @ObfuscatedName("p")
   void method3901(byte[] var1) {
      this.field3107 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3107.length; ++var2) {
            this.field3107[var2] = var1[var2] & 255;
         }

         this.field3112 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3107[var3] = var1[var2++] & 255;
         }

         int[] var10 = new int[256];
         int[] var4 = new int[256];

         int var5;
         for(var5 = 0; var5 < 256; ++var5) {
            var10[var5] = var1[var2++] & 255;
         }

         for(var5 = 0; var5 < 256; ++var5) {
            var4[var5] = var1[var2++] & 255;
         }

         byte[][] var11 = new byte[256][];

         int var8;
         for(int var6 = 0; var6 < 256; ++var6) {
            var11[var6] = new byte[var10[var6]];
            byte var7 = 0;

            for(var8 = 0; var8 < var11[var6].length; ++var8) {
               var7 += var1[var2++];
               var11[var6][var8] = var7;
            }
         }

         byte[][] var12 = new byte[256][];

         int var13;
         for(var13 = 0; var13 < 256; ++var13) {
            var12[var13] = new byte[var10[var13]];
            byte var14 = 0;

            for(int var9 = 0; var9 < var12[var13].length; ++var9) {
               var14 += var1[var2++];
               var12[var13][var9] = var14;
            }
         }

         this.field3122 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3122[(var13 << 8) + var8] = (byte)method3902(var11, var12, var4, this.field3107, var10, var13, var8);
                  }
               }
            }
         }

         this.field3112 = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("j")
   static int method3902(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("s")
   int method3903(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3107[class150.method2850(var1) & 255];
   }

   @ObfuscatedName("k")
   public int method3904(String var1) {
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
                              int var8 = GameObject.method2019(var7.substring(4));
                              var4 += modIcons[var8].width;
                              var3 = -1;
                           } catch (Exception var10) {
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
                  var4 += this.field3107[(char)(class150.method2850(var6) & 255)];
                  if(this.field3122 != null && var3 != -1) {
                     var4 += this.field3122[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("q")
   public int method3907(String var1, int var2) {
      return this.method3980(var1, new int[]{var2}, field3127);
   }

   @ObfuscatedName("w")
   public void method3910(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3918(var4, var5);
         field3116 = var6;
         this.method3921(var1, var2, var3);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3911(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3918(var4, var5);
         this.method3921(var1, var2 - this.method3904(var1), var3);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3912(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3918(var4, var5);
         this.method3921(var1, var2 - this.method3904(var1) / 2, var3);
      }
   }

   @ObfuscatedName("u")
   public int method3913(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method3918(var6, var7);
         if(var10 == 0) {
            var10 = this.field3112;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3113 + this.field3114 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3980(var1, var11, field3127);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3113;
         } else if(var9 == 1) {
            var13 = var3 + this.field3113 + (var5 - this.field3113 - this.field3114 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3114 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3113 - this.field3114 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3113 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method3921(field3127[var14], var2, var13);
            } else if(var8 == 1) {
               this.method3921(field3127[var14], var2 + (var4 - this.method3904(field3127[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method3921(field3127[var14], var2 + var4 - this.method3904(field3127[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method3921(field3127[var14], var2, var13);
            } else {
               this.method3920(field3127[var14], var4);
               this.method3921(field3127[var14], var2, var13);
               field3126 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("aa")
   static void method3914(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("h")
   public void method3915(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3918(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3922(var1, var2 - this.method3904(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("d")
   public void method3916(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method3918(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method3922(var1, var2 - this.method3904(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("z")
   public void method3917(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3918(var4, var5);
         field3121.setSeed((long)var6);
         field3116 = 192 + (field3121.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3121.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method3922(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("t")
   void method3918(int var1, int var2) {
      field3108 = -1;
      field3118 = -1;
      field3119 = var2;
      field3120 = var2;
      field3111 = var1;
      field3106 = var1;
      field3116 = 256;
      field3126 = 0;
      field3125 = 0;
   }

   @ObfuscatedName("ac")
   void method3920(String var1, int var2) {
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
         field3126 = (var2 - this.method3904(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("au")
   void method3921(String var1, int var2, int var3) {
      var3 -= this.field3112;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class150.method2850(var1.charAt(var6)) & 255);
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
                              var9 = class31.method718(var10, 10, true);
                              ModIcon var12 = modIcons[var9];
                              var12.method4115(var2, var3 + this.field3112 - var12.originalHeight);
                              var2 += var12.width;
                              var5 = -1;
                           } catch (Exception var16) {
                              ;
                           }
                        } else {
                           this.method3974(var8);
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
                  if(this.field3122 != null && var5 != -1) {
                     var2 += this.field3122[(var5 << 8) + var7];
                  }

                  int var14 = this.field3124[var7];
                  var9 = this.field3109[var7];
                  if(var7 != 32) {
                     if(field3116 == 256) {
                        if(field3120 != -1) {
                           method3925(this.field3123[var7], var2 + this.field3110[var7] + 1, var3 + this.field3117[var7] + 1, var14, var9, field3120);
                        }

                        this.vmethod3930(this.field3123[var7], var2 + this.field3110[var7], var3 + this.field3117[var7], var14, var9, field3106);
                     } else {
                        if(field3120 != -1) {
                           method3927(this.field3123[var7], var2 + this.field3110[var7] + 1, var3 + this.field3117[var7] + 1, var14, var9, field3120, field3116);
                        }

                        this.vmethod3924(this.field3123[var7], var2 + this.field3110[var7], var3 + this.field3117[var7], var14, var9, field3106, field3116);
                     }
                  } else if(field3126 > 0) {
                     field3125 += field3126;
                     var2 += field3125 >> 8;
                     field3125 &= 255;
                  }

                  int var15 = this.field3107[var7];
                  if(field3108 != -1) {
                     Rasterizer2D.method4026(var2, var3 + (int)((double)this.field3112 * 0.7D), var15, field3108);
                  }

                  if(field3118 != -1) {
                     Rasterizer2D.method4026(var2, var3 + this.field3112 + 1, var15, field3118);
                  }

                  var2 += var15;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("al")
   void method3922(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3112;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class150.method2850(var1.charAt(var9)) & 255);
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
                              var14 = GameObject.method2019(var11.substring(4));
                              ModIcon var15 = modIcons[var14];
                              var15.method4115(var2 + var12, var3 + this.field3112 - var15.originalHeight + var13);
                              var2 += var15.width;
                              var7 = -1;
                           } catch (Exception var19) {
                              ;
                           }
                        } else {
                           this.method3974(var11);
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
                  if(this.field3122 != null && var7 != -1) {
                     var2 += this.field3122[(var7 << 8) + var10];
                  }

                  int var17 = this.field3124[var10];
                  var12 = this.field3109[var10];
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
                     if(field3116 == 256) {
                        if(field3120 != -1) {
                           method3925(this.field3123[var10], var2 + this.field3110[var10] + 1 + var13, var3 + this.field3117[var10] + 1 + var14, var17, var12, field3120);
                        }

                        this.vmethod3930(this.field3123[var10], var2 + this.field3110[var10] + var13, var3 + this.field3117[var10] + var14, var17, var12, field3106);
                     } else {
                        if(field3120 != -1) {
                           method3927(this.field3123[var10], var2 + this.field3110[var10] + 1 + var13, var3 + this.field3117[var10] + 1 + var14, var17, var12, field3120, field3116);
                        }

                        this.vmethod3924(this.field3123[var10], var2 + this.field3110[var10] + var13, var3 + this.field3117[var10] + var14, var17, var12, field3106, field3116);
                     }
                  } else if(field3126 > 0) {
                     field3125 += field3126;
                     var2 += field3125 >> 8;
                     field3125 &= 255;
                  }

                  int var18 = this.field3107[var10];
                  if(field3108 != -1) {
                     Rasterizer2D.method4026(var2, var3 + (int)((double)this.field3112 * 0.7D), var18, field3108);
                  }

                  if(field3118 != -1) {
                     Rasterizer2D.method4026(var2, var3 + this.field3112, var18, field3118);
                  }

                  var2 += var18;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   abstract void vmethod3924(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("ae")
   static void method3925(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var7 = Rasterizer2D.graphicsPixelsWidth - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < Rasterizer2D.field3193) {
         var10 = Rasterizer2D.field3193 - var2;
         var4 -= var10;
         var2 = Rasterizer2D.field3193;
         var9 += var10 * var3;
         var6 += var10 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var4 > Rasterizer2D.field3190) {
         var4 -= var2 + var4 - Rasterizer2D.field3190;
      }

      if(var1 < Rasterizer2D.field3195) {
         var10 = Rasterizer2D.field3195 - var1;
         var3 -= var10;
         var1 = Rasterizer2D.field3195;
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
         method3955(Rasterizer2D.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("aq")
   static void method3927(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var8 = Rasterizer2D.graphicsPixelsWidth - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < Rasterizer2D.field3193) {
         var11 = Rasterizer2D.field3193 - var2;
         var4 -= var11;
         var2 = Rasterizer2D.field3193;
         var10 += var11 * var3;
         var7 += var11 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var4 > Rasterizer2D.field3190) {
         var4 -= var2 + var4 - Rasterizer2D.field3190;
      }

      if(var1 < Rasterizer2D.field3195) {
         var11 = Rasterizer2D.field3195 - var1;
         var3 -= var11;
         var1 = Rasterizer2D.field3195;
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
         method3914(Rasterizer2D.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("x")
   abstract void vmethod3930(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("o")
   public int method3938(String var1, int var2) {
      int var3 = this.method3980(var1, new int[]{var2}, field3127);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3904(field3127[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("c")
   public static String method3949(String var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 == 60 || var4 == 62) {
            var2 += 3;
         }
      }

      StringBuilder var6 = new StringBuilder(var1 + var2);

      for(int var7 = 0; var7 < var1; ++var7) {
         char var5 = var0.charAt(var7);
         if(var5 == 60) {
            var6.append("<lt>");
         } else if(var5 == 62) {
            var6.append("<gt>");
         } else {
            var6.append(var5);
         }
      }

      return var6.toString();
   }

   @ObfuscatedName("e")
   public void method3951(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3918(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3922(var1, var2 - this.method3904(var1) / 2, var3, (int[])null, var7);
      }
   }

   FontTypeFace(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3110 = var2;
      this.field3117 = var3;
      this.field3124 = var4;
      this.field3109 = var5;
      this.method3901(var1);
      this.field3123 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3117[var10] < var8 && this.field3109[var10] != 0) {
            var8 = this.field3117[var10];
         }

         if(this.field3117[var10] + this.field3109[var10] > var9) {
            var9 = this.field3117[var10] + this.field3109[var10];
         }
      }

      this.field3113 = this.field3112 - var8;
      this.field3114 = var9 - this.field3112;
   }

   @ObfuscatedName("ad")
   static void method3955(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "0"
   )
   public void method3973(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3918(var4, var5);
         this.method3921(var1, var2, var3);
      }
   }

   @ObfuscatedName("ab")
   void method3974(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3106 = class5.method80(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3106 = field3111;
         } else if(var1.startsWith("str=")) {
            field3108 = class5.method80(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3108 = 8388608;
         } else if(var1.equals("/str")) {
            field3108 = -1;
         } else if(var1.startsWith("u=")) {
            field3118 = class5.method80(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3118 = 0;
         } else if(var1.equals("/u")) {
            field3118 = -1;
         } else if(var1.startsWith("shad=")) {
            field3120 = class5.method80(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3120 = 0;
         } else if(var1.equals("/shad")) {
            field3120 = field3119;
         } else if(var1.equals("br")) {
            this.method3918(field3111, field3119);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("f")
   int method3980(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method3903('<');
                     if(this.field3122 != null && var11 != -1) {
                        var4 += this.field3122[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method3903('>');
                     if(this.field3122 != null && var11 != -1) {
                        var4 += this.field3122[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = class31.method718(var18, 10, true);
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
                     var4 += this.method3903(var15);
                     if(this.field3122 != null && var11 != -1) {
                        var4 += this.field3122[(var11 << 8) + var15];
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
