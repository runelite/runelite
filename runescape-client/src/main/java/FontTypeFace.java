import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("FontTypeFace")
public abstract class FontTypeFace extends Rasterizer2D {
   @ObfuscatedName("f")
   static int field3107 = 0;
   @ObfuscatedName("x")
   byte[][] field3108 = new byte[256][];
   @ObfuscatedName("r")
   static int field3109 = 0;
   @ObfuscatedName("d")
   int[] field3110;
   @ObfuscatedName("w")
   int[] field3111;
   @ObfuscatedName("v")
   static int field3112 = -1;
   @ObfuscatedName("c")
   int[] field3113;
   @ObfuscatedName("k")
   public int field3114;
   @ObfuscatedName("g")
   public int field3115;
   @ObfuscatedName("y")
   @Export("modIcons")
   public static ModIcon[] modIcons;
   @ObfuscatedName("e")
   byte[] field3117;
   @ObfuscatedName("h")
   int[] field3118;
   @ObfuscatedName("j")
   int[] field3119;
   @ObfuscatedName("u")
   public int field3120 = 0;
   @ObfuscatedName("s")
   static int field3121 = -1;
   @ObfuscatedName("l")
   static int field3122 = -1;
   @ObfuscatedName("m")
   static int field3123 = 0;
   @ObfuscatedName("i")
   static int field3124 = 256;
   @ObfuscatedName("q")
   static int field3125 = -1;
   @ObfuscatedName("b")
   static int field3126 = 0;
   @ObfuscatedName("t")
   static Random field3127 = new Random();
   @ObfuscatedName("z")
   static String[] field3128 = new String[100];

   @ObfuscatedName("q")
   void method3873(byte[] var1) {
      this.field3119 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3119.length; ++var2) {
            this.field3119[var2] = var1[var2] & 255;
         }

         this.field3120 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3119[var3] = var1[var2++] & 255;
         }

         int[] var11 = new int[256];
         int[] var4 = new int[256];

         int var5;
         for(var5 = 0; var5 < 256; ++var5) {
            var11[var5] = var1[var2++] & 255;
         }

         for(var5 = 0; var5 < 256; ++var5) {
            var4[var5] = var1[var2++] & 255;
         }

         byte[][] var10 = new byte[256][];

         int var8;
         for(int var6 = 0; var6 < 256; ++var6) {
            var10[var6] = new byte[var11[var6]];
            byte var7 = 0;

            for(var8 = 0; var8 < var10[var6].length; ++var8) {
               var7 += var1[var2++];
               var10[var6][var8] = var7;
            }
         }

         byte[][] var12 = new byte[256][];

         int var13;
         for(var13 = 0; var13 < 256; ++var13) {
            var12[var13] = new byte[var11[var13]];
            byte var14 = 0;

            for(int var9 = 0; var9 < var12[var13].length; ++var9) {
               var14 += var1[var2++];
               var12[var13][var9] = var14;
            }
         }

         this.field3117 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3117[(var13 << 8) + var8] = (byte)method3928(var10, var12, var4, this.field3119, var11, var13, var8);
                  }
               }
            }
         }

         this.field3120 = var4[32] + var11[32];
      }

   }

   @ObfuscatedName("ah")
   void method3874(String var1, int var2, int var3) {
      var3 -= this.field3120;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class18.method215(var1.charAt(var6)) & 255);
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
                              var9 = class196.method3599(var8.substring(4));
                              ModIcon var10 = modIcons[var9];
                              var10.method4090(var2, var3 + this.field3120 - var10.originalHeight);
                              var2 += var10.width;
                              var5 = -1;
                           } catch (Exception var14) {
                              ;
                           }
                        } else {
                           this.method3924(var8);
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
                  if(this.field3117 != null && var5 != -1) {
                     var2 += this.field3117[(var5 << 8) + var7];
                  }

                  int var12 = this.field3113[var7];
                  var9 = this.field3110[var7];
                  if(var7 != 32) {
                     if(field3124 == 256) {
                        if(field3121 != -1) {
                           method3884(this.field3108[var7], var2 + this.field3111[var7] + 1, var3 + this.field3118[var7] + 1, var12, var9, field3121);
                        }

                        this.vmethod3927(this.field3108[var7], var2 + this.field3111[var7], var3 + this.field3118[var7], var12, var9, field3123);
                     } else {
                        if(field3121 != -1) {
                           method3899(this.field3108[var7], var2 + this.field3111[var7] + 1, var3 + this.field3118[var7] + 1, var12, var9, field3121, field3124);
                        }

                        this.vmethod3896(this.field3108[var7], var2 + this.field3111[var7], var3 + this.field3118[var7], var12, var9, field3123, field3124);
                     }
                  } else if(field3107 > 0) {
                     field3126 += field3107;
                     var2 += field3126 >> 8;
                     field3126 &= 255;
                  }

                  int var13 = this.field3119[var7];
                  if(field3125 != -1) {
                     Rasterizer2D.method4012(var2, var3 + (int)((double)this.field3120 * 0.7D), var13, field3125);
                  }

                  if(field3112 != -1) {
                     Rasterizer2D.method4012(var2, var3 + this.field3120 + 1, var13, field3112);
                  }

                  var2 += var13;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   int method3875(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3119[class18.method215(var1) & 255];
   }

   @ObfuscatedName("s")
   public int method3876(String var1) {
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
                              int var8 = class196.method3599(var7.substring(4));
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
                  var4 += this.field3119[(char)(class18.method215(var6) & 255)];
                  if(this.field3117 != null && var3 != -1) {
                     var4 += this.field3117[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("r")
   int method3877(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method3875('<');
                     if(this.field3117 != null && var11 != -1) {
                        var4 += this.field3117[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method3875('>');
                     if(this.field3117 != null && var11 != -1) {
                        var4 += this.field3117[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        int var17 = class196.method3599(var16.substring(4));
                        var4 += modIcons[var17].width;
                        var11 = 0;
                     } catch (Exception var20) {
                        ;
                     }
                  }

                  var15 = 0;
               }

               if(var10 == -1) {
                  if(var15 != 0) {
                     var6.append(var15);
                     var4 += this.method3875(var15);
                     if(this.field3117 != null && var11 != -1) {
                        var4 += this.field3117[(var11 << 8) + var15];
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

         String var19 = var6.toString();
         if(var19.length() > var5) {
            var3[var12++] = var19.substring(var5, var19.length());
         }

         return var12;
      }
   }

   @ObfuscatedName("i")
   public int method3879(String var1, int var2) {
      return this.method3877(var1, new int[]{var2}, field3128);
   }

   @ObfuscatedName("f")
   public static String method3880(String var0) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3881(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3959(var4, var5);
         this.method3874(var1, var2, var3);
      }
   }

   @ObfuscatedName("t")
   public void method3882(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3959(var4, var5);
         field3124 = var6;
         this.method3874(var1, var2, var3);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3883(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3959(var4, var5);
         this.method3874(var1, var2 - this.method3876(var1), var3);
      }
   }

   @ObfuscatedName("at")
   static void method3884(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
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

      if(var2 + var4 > Rasterizer2D.field3187) {
         var4 -= var2 + var4 - Rasterizer2D.field3187;
      }

      if(var1 < Rasterizer2D.field3192) {
         var10 = Rasterizer2D.field3192 - var1;
         var3 -= var10;
         var1 = Rasterizer2D.field3192;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > Rasterizer2D.field3190) {
         var10 = var1 + var3 - Rasterizer2D.field3190;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method3898(Rasterizer2D.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("o")
   public void method3887(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3959(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3973(var1, var2 - this.method3876(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("an")
   public void method3888(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method3959(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method3973(var1, var2 - this.method3876(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("ar")
   public void method3889(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3959(var4, var5);
         field3127.setSeed((long)var6);
         field3124 = 192 + (field3127.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3127.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method3973(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("ax")
   void method3892(String var1, int var2) {
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
         field3107 = (var2 - this.method3876(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("j")
   abstract void vmethod3896(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("ab")
   static void method3898(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("ae")
   static void method3899(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
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

      if(var2 + var4 > Rasterizer2D.field3187) {
         var4 -= var2 + var4 - Rasterizer2D.field3187;
      }

      if(var1 < Rasterizer2D.field3192) {
         var11 = Rasterizer2D.field3192 - var1;
         var3 -= var11;
         var1 = Rasterizer2D.field3192;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > Rasterizer2D.field3190) {
         var11 = var1 + var3 - Rasterizer2D.field3190;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method3900(Rasterizer2D.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("ao")
   static void method3900(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("n")
   public int method3916(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method3959(var6, var7);
         if(var10 == 0) {
            var10 = this.field3120;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3114 + this.field3115 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3877(var1, var11, field3128);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3114;
         } else if(var9 == 1) {
            var13 = var3 + this.field3114 + (var5 - this.field3114 - this.field3115 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3115 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3114 - this.field3115 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3114 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method3874(field3128[var14], var2, var13);
            } else if(var8 == 1) {
               this.method3874(field3128[var14], var2 + (var4 - this.method3876(field3128[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method3874(field3128[var14], var2 + var4 - this.method3876(field3128[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method3874(field3128[var14], var2, var13);
            } else {
               this.method3892(field3128[var14], var4);
               this.method3874(field3128[var14], var2, var13);
               field3107 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("af")
   void method3924(String var1) {
      try {
         int var2;
         String var3;
         if(var1.startsWith("col=")) {
            var3 = var1.substring(4);
            var2 = class176.method3276(var3, 16, true);
            field3123 = var2;
         } else if(var1.equals("/col")) {
            field3123 = field3109;
         } else if(var1.startsWith("str=")) {
            var3 = var1.substring(4);
            var2 = class176.method3276(var3, 16, true);
            field3125 = var2;
         } else if(var1.equals("str")) {
            field3125 = 8388608;
         } else if(var1.equals("/str")) {
            field3125 = -1;
         } else if(var1.startsWith("u=")) {
            var3 = var1.substring(2);
            var2 = class176.method3276(var3, 16, true);
            field3112 = var2;
         } else if(var1.equals("u")) {
            field3112 = 0;
         } else if(var1.equals("/u")) {
            field3112 = -1;
         } else if(var1.startsWith("shad=")) {
            var3 = var1.substring(5);
            var2 = class176.method3276(var3, 16, true);
            field3121 = var2;
         } else if(var1.equals("shad")) {
            field3121 = 0;
         } else if(var1.equals("/shad")) {
            field3121 = field3122;
         } else if(var1.equals("br")) {
            this.method3959(field3109, field3122);
         }
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("a")
   public void method3925(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3959(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3973(var1, var2 - this.method3876(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("x")
   abstract void vmethod3927(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("v")
   static int method3928(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("m")
   public int method3930(String var1, int var2) {
      int var3 = this.method3877(var1, new int[]{var2}, field3128);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3876(field3128[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   FontTypeFace(byte[] var1) {
      this.method3873(var1);
   }

   FontTypeFace(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3111 = var2;
      this.field3118 = var3;
      this.field3113 = var4;
      this.field3110 = var5;
      this.method3873(var1);
      this.field3108 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3118[var10] < var8 && this.field3110[var10] != 0) {
            var8 = this.field3118[var10];
         }

         if(this.field3118[var10] + this.field3110[var10] > var9) {
            var9 = this.field3118[var10] + this.field3110[var10];
         }
      }

      this.field3114 = this.field3120 - var8;
      this.field3115 = var9 - this.field3120;
   }

   @ObfuscatedName("aa")
   void method3959(int var1, int var2) {
      field3125 = -1;
      field3112 = -1;
      field3122 = var2;
      field3121 = var2;
      field3109 = var1;
      field3123 = var1;
      field3124 = 256;
      field3107 = 0;
      field3126 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3964(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3959(var4, var5);
         this.method3874(var1, var2 - this.method3876(var1) / 2, var3);
      }
   }

   @ObfuscatedName("az")
   void method3973(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3120;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class18.method215(var1.charAt(var9)) & 255);
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
                              var14 = class196.method3599(var11.substring(4));
                              ModIcon var15 = modIcons[var14];
                              var15.method4090(var2 + var12, var3 + this.field3120 - var15.originalHeight + var13);
                              var2 += var15.width;
                              var7 = -1;
                           } catch (Exception var19) {
                              ;
                           }
                        } else {
                           this.method3924(var11);
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
                  if(this.field3117 != null && var7 != -1) {
                     var2 += this.field3117[(var7 << 8) + var10];
                  }

                  int var17 = this.field3113[var10];
                  var12 = this.field3110[var10];
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
                     if(field3124 == 256) {
                        if(field3121 != -1) {
                           method3884(this.field3108[var10], var2 + this.field3111[var10] + 1 + var13, var3 + this.field3118[var10] + 1 + var14, var17, var12, field3121);
                        }

                        this.vmethod3927(this.field3108[var10], var2 + this.field3111[var10] + var13, var3 + this.field3118[var10] + var14, var17, var12, field3123);
                     } else {
                        if(field3121 != -1) {
                           method3899(this.field3108[var10], var2 + this.field3111[var10] + 1 + var13, var3 + this.field3118[var10] + 1 + var14, var17, var12, field3121, field3124);
                        }

                        this.vmethod3896(this.field3108[var10], var2 + this.field3111[var10] + var13, var3 + this.field3118[var10] + var14, var17, var12, field3123, field3124);
                     }
                  } else if(field3107 > 0) {
                     field3126 += field3107;
                     var2 += field3126 >> 8;
                     field3126 &= 255;
                  }

                  int var18 = this.field3119[var10];
                  if(field3125 != -1) {
                     Rasterizer2D.method4012(var2, var3 + (int)((double)this.field3120 * 0.7D), var18, field3125);
                  }

                  if(field3112 != -1) {
                     Rasterizer2D.method4012(var2, var3 + this.field3120, var18, field3112);
                  }

                  var2 += var18;
                  var7 = var10;
               }
            }
         }
      }

   }
}
