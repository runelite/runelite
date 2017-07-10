import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("FontTypeFace")
public abstract class FontTypeFace extends Rasterizer2D {
   @ObfuscatedName("n")
   static int field3643;
   @ObfuscatedName("b")
   @Export("color")
   static int color;
   @ObfuscatedName("a")
   int[] field3645;
   @ObfuscatedName("t")
   int[] field3646;
   @ObfuscatedName("s")
   int[] field3647;
   @ObfuscatedName("w")
   int[] field3648;
   @ObfuscatedName("v")
   public int field3649;
   @ObfuscatedName("y")
   public int field3650;
   @ObfuscatedName("j")
   public int field3651;
   @ObfuscatedName("r")
   int[] field3652;
   @ObfuscatedName("e")
   byte[] field3653;
   @ObfuscatedName("o")
   static int field3654;
   @ObfuscatedName("z")
   static int field3655;
   @ObfuscatedName("l")
   static int field3656;
   @ObfuscatedName("c")
   @Export("shadow")
   static int shadow;
   @ObfuscatedName("m")
   static int field3658;
   @ObfuscatedName("p")
   static Random field3659;
   @ObfuscatedName("f")
   static int field3660;
   @ObfuscatedName("i")
   byte[][] field3661;
   @ObfuscatedName("u")
   static int field3662;
   @ObfuscatedName("k")
   @Export("modIcons")
   public static ModIcon[] modIcons;
   @ObfuscatedName("q")
   static String[] field3664;

   @ObfuscatedName("au")
   static void method4745(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var7 = Rasterizer2D.graphicsPixelsWidth - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < Rasterizer2D.drawingAreaTop) {
         var10 = Rasterizer2D.drawingAreaTop - var2;
         var4 -= var10;
         var2 = Rasterizer2D.drawingAreaTop;
         var9 += var10 * var3;
         var6 += var10 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var4 > Rasterizer2D.drawingAreaRight) {
         var4 -= var2 + var4 - Rasterizer2D.drawingAreaRight;
      }

      if(var1 < Rasterizer2D.field3761) {
         var10 = Rasterizer2D.field3761 - var1;
         var3 -= var10;
         var1 = Rasterizer2D.field3761;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 + var1 > Rasterizer2D.drawingAreaBottom) {
         var10 = var3 + var1 - Rasterizer2D.drawingAreaBottom;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4789(Rasterizer2D.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   FontTypeFace(byte[] var1) {
      this.field3661 = new byte[256][];
      this.field3649 = 0;
      this.method4746(var1);
   }

   @ObfuscatedName("r")
   void method4746(byte[] var1) {
      this.field3648 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3648.length; ++var2) {
            this.field3648[var2] = var1[var2] & 255;
         }

         this.field3649 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3648[var3] = var1[var2++] & 255;
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

         this.field3653 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3653[var8 + (var13 << 8)] = (byte)method4747(var11, var12, var4, this.field3648, var10, var13, var8);
                  }
               }
            }
         }

         this.field3649 = var10[32] + var4[32];
      }

   }

   @ObfuscatedName("v")
   static int method4747(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
      int var7 = var2[var5];
      int var8 = var4[var5] + var7;
      int var9 = var2[var6];
      int var10 = var4[var6] + var9;
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

   @ObfuscatedName("y")
   int method4748(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3648[TextureProvider.method2403(var1) & 255];
   }

   @ObfuscatedName("k")
   public int method4750(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method4748('<');
                     if(this.field3653 != null && var11 != -1) {
                        var4 += this.field3653[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method4748('>');
                     if(this.field3653 != null && var11 != -1) {
                        var4 += this.field3653[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        int var17 = ScriptState.method1103(var16.substring(4));
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
                     var4 += this.method4748(var15);
                     if(this.field3653 != null && var11 != -1) {
                        var4 += this.field3653[var15 + (var11 << 8)];
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

         String var18 = var6.toString();
         if(var18.length() > var5) {
            var3[var12++] = var18.substring(var5, var18.length());
         }

         return var12;
      }
   }

   @ObfuscatedName("e")
   public int method4751(String var1, int var2) {
      int var3 = this.method4750(var1, new int[]{var2}, field3664);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method4773(field3664[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("o")
   public int method4752(String var1, int var2) {
      return this.method4750(var1, new int[]{var2}, field3664);
   }

   @ObfuscatedName("an")
   @Export("drawMouseoverText")
   void drawMouseoverText(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3649;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(TextureProvider.method2403(var1.charAt(var9)) & 255);
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
                              var14 = ScriptState.method1103(var11.substring(4));
                              ModIcon var17 = modIcons[var14];
                              var17.method5025(var2 + var12, var13 + (var3 + this.field3649 - var17.originalHeight));
                              var2 += var17.width;
                              var7 = -1;
                           } catch (Exception var19) {
                              ;
                           }
                        } else {
                           this.method4764(var11);
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
                  if(this.field3653 != null && var7 != -1) {
                     var2 += this.field3653[(var7 << 8) + var10];
                  }

                  int var16 = this.field3645[var10];
                  var12 = this.field3646[var10];
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
                     if(field3660 == 256) {
                        if(shadow != -1) {
                           method4745(this.field3661[var10], var13 + var2 + this.field3647[var10] + 1, var3 + this.field3652[var10] + 1 + var14, var16, var12, shadow);
                        }

                        this.vmethod4781(this.field3661[var10], var13 + var2 + this.field3647[var10], var3 + this.field3652[var10] + var14, var16, var12, color);
                     } else {
                        if(shadow != -1) {
                           method4786(this.field3661[var10], var13 + var2 + this.field3647[var10] + 1, var3 + this.field3652[var10] + 1 + var14, var16, var12, shadow, field3660);
                        }

                        this.vmethod4769(this.field3661[var10], var13 + var2 + this.field3647[var10], var3 + this.field3652[var10] + var14, var16, var12, color, field3660);
                     }
                  } else if(field3643 > 0) {
                     field3662 += field3643;
                     var2 += field3662 >> 8;
                     field3662 &= 255;
                  }

                  int var15 = this.field3648[var10];
                  if(field3654 != -1) {
                     Rasterizer2D.method4941(var2, var3 + (int)((double)this.field3649 * 0.7D), var15, field3654);
                  }

                  if(field3655 != -1) {
                     Rasterizer2D.method4941(var2, var3 + this.field3649, var15, field3655);
                  }

                  var2 += var15;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4756(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.setColor(var4, var5);
         this.method4766(var1, var2 - this.method4773(var1), var3);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4757(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.setColor(var4, var5);
         this.method4766(var1, var2 - this.method4773(var1) / 2, var3);
      }
   }

   @ObfuscatedName("u")
   public void method4759(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(var1, var2 - this.method4773(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("p")
   public void method4760(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(var1, var2 - this.method4773(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("c")
   public void method4761(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         field3660 = var6;
         this.method4766(var1, var2, var3);
      }
   }

   @ObfuscatedName("h")
   @Export("setColor")
   void setColor(int var1, int var2) {
      field3654 = -1;
      field3655 = -1;
      field3656 = var2;
      shadow = var2;
      field3658 = var1;
      color = var1;
      field3660 = 256;
      field3643 = 0;
      field3662 = 0;
   }

   @ObfuscatedName("g")
   void method4764(String var1) {
      try {
         int var2;
         String var3;
         if(var1.startsWith("col=")) {
            var3 = var1.substring(4);
            var2 = class181.parseInt(var3, 16, true);
            color = var2;
         } else if(var1.equals("/col")) {
            color = field3658;
         } else if(var1.startsWith("str=")) {
            var3 = var1.substring(4);
            var2 = class181.parseInt(var3, 16, true);
            field3654 = var2;
         } else if(var1.equals("str")) {
            field3654 = 8388608;
         } else if(var1.equals("/str")) {
            field3654 = -1;
         } else if(var1.startsWith("u=")) {
            var3 = var1.substring(2);
            var2 = class181.parseInt(var3, 16, true);
            field3655 = var2;
         } else if(var1.equals("u")) {
            field3655 = 0;
         } else if(var1.equals("/u")) {
            field3655 = -1;
         } else if(var1.startsWith("shad=")) {
            var3 = var1.substring(5);
            var2 = class181.parseInt(var3, 16, true);
            shadow = var2;
         } else if(var1.equals("shad")) {
            shadow = 0;
         } else if(var1.equals("/shad")) {
            shadow = field3656;
         } else if(var1.equals("br")) {
            this.setColor(field3658, field3656);
         }
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("x")
   void method4765(String var1, int var2) {
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
         field3643 = (var2 - this.method4773(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("ai")
   void method4766(String var1, int var2, int var3) {
      var3 -= this.field3649;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(TextureProvider.method2403(var1.charAt(var6)) & 255);
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
                              var9 = ScriptState.method1103(var8.substring(4));
                              ModIcon var12 = modIcons[var9];
                              var12.method5025(var2, var3 + this.field3649 - var12.originalHeight);
                              var2 += var12.width;
                              var5 = -1;
                           } catch (Exception var14) {
                              ;
                           }
                        } else {
                           this.method4764(var8);
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
                  if(this.field3653 != null && var5 != -1) {
                     var2 += this.field3653[(var5 << 8) + var7];
                  }

                  int var11 = this.field3645[var7];
                  var9 = this.field3646[var7];
                  if(var7 != 32) {
                     if(field3660 == 256) {
                        if(shadow != -1) {
                           method4745(this.field3661[var7], var2 + this.field3647[var7] + 1, var3 + this.field3652[var7] + 1, var11, var9, shadow);
                        }

                        this.vmethod4781(this.field3661[var7], var2 + this.field3647[var7], var3 + this.field3652[var7], var11, var9, color);
                     } else {
                        if(shadow != -1) {
                           method4786(this.field3661[var7], var2 + this.field3647[var7] + 1, var3 + this.field3652[var7] + 1, var11, var9, shadow, field3660);
                        }

                        this.vmethod4769(this.field3661[var7], var2 + this.field3647[var7], var3 + this.field3652[var7], var11, var9, color, field3660);
                     }
                  } else if(field3643 > 0) {
                     field3662 += field3643;
                     var2 += field3662 >> 8;
                     field3662 &= 255;
                  }

                  int var10 = this.field3648[var7];
                  if(field3654 != -1) {
                     Rasterizer2D.method4941(var2, var3 + (int)((double)this.field3649 * 0.7D), var10, field3654);
                  }

                  if(field3655 != -1) {
                     Rasterizer2D.method4941(var2, var3 + this.field3649 + 1, var10, field3655);
                  }

                  var2 += var10;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   abstract void vmethod4769(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("q")
   public void method4770(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.setColor(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.drawMouseoverText(var1, var2 - this.method4773(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("ao")
   static void method4772(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      var2 = ((var2 & '\uff00') * var9 & 16711680) + ((var2 & 16711935) * var9 & -16711936) >> 8;
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

   @ObfuscatedName("j")
   public int method4773(String var1) {
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
                              int var8 = ScriptState.method1103(var7.substring(4));
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
                  var4 += this.field3648[(char)(TextureProvider.method2403(var6) & 255)];
                  if(this.field3653 != null && var3 != -1) {
                     var4 += this.field3653[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   static {
      field3654 = -1;
      field3655 = -1;
      field3656 = -1;
      shadow = -1;
      field3658 = 0;
      color = 0;
      field3660 = 256;
      field3643 = 0;
      field3662 = 0;
      field3659 = new Random();
      field3664 = new String[100];
   }

   @ObfuscatedName("d")
   @Export("drawRandomizedMouseoverText")
   public void drawRandomizedMouseoverText(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         field3659.setSeed((long)var6);
         field3660 = 192 + (field3659.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3659.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.drawMouseoverText(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("i")
   abstract void vmethod4781(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("ay")
   static void method4786(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var8 = Rasterizer2D.graphicsPixelsWidth - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < Rasterizer2D.drawingAreaTop) {
         var11 = Rasterizer2D.drawingAreaTop - var2;
         var4 -= var11;
         var2 = Rasterizer2D.drawingAreaTop;
         var10 += var3 * var11;
         var7 += var11 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var4 > Rasterizer2D.drawingAreaRight) {
         var4 -= var2 + var4 - Rasterizer2D.drawingAreaRight;
      }

      if(var1 < Rasterizer2D.field3761) {
         var11 = Rasterizer2D.field3761 - var1;
         var3 -= var11;
         var1 = Rasterizer2D.field3761;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 + var1 > Rasterizer2D.drawingAreaBottom) {
         var11 = var3 + var1 - Rasterizer2D.drawingAreaBottom;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method4772(Rasterizer2D.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("n")
   public int method4788(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.setColor(var6, var7);
         if(var10 == 0) {
            var10 = this.field3649;
         }

         int[] var11 = new int[]{var4};
         if(var5 < var10 + this.field3650 + this.field3651 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method4750(var1, var11, field3664);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3650;
         } else if(var9 == 1) {
            var13 = (var5 - this.field3650 - this.field3651 - (var12 - 1) * var10) / 2 + var3 + this.field3650;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3651 - var10 * (var12 - 1);
         } else {
            var14 = (var5 - this.field3650 - this.field3651 - var10 * (var12 - 1)) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3650 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method4766(field3664[var14], var2, var13);
            } else if(var8 == 1) {
               this.method4766(field3664[var14], var2 + (var4 - this.method4773(field3664[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method4766(field3664[var14], var2 + var4 - this.method4773(field3664[var14]), var13);
            } else if(var12 - 1 == var14) {
               this.method4766(field3664[var14], var2, var13);
            } else {
               this.method4765(field3664[var14], var4);
               this.method4766(field3664[var14], var2, var13);
               field3643 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("ar")
   static void method4789(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "0"
   )
   public void method4790(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.setColor(var4, var5);
         this.method4766(var1, var2, var3);
      }
   }

   FontTypeFace(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3661 = new byte[256][];
      this.field3649 = 0;
      this.field3647 = var2;
      this.field3652 = var3;
      this.field3645 = var4;
      this.field3646 = var5;
      this.method4746(var1);
      this.field3661 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3652[var10] < var8 && this.field3646[var10] != 0) {
            var8 = this.field3652[var10];
         }

         if(this.field3652[var10] + this.field3646[var10] > var9) {
            var9 = this.field3652[var10] + this.field3646[var10];
         }
      }

      this.field3650 = this.field3649 - var8;
      this.field3651 = var9 - this.field3649;
   }

   @ObfuscatedName("z")
   public static String method4835(String var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 == 60 || var4 == 62) {
            var2 += 3;
         }
      }

      StringBuilder var6 = new StringBuilder(var2 + var1);

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
}
