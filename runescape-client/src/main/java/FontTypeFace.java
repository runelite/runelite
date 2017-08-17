import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("FontTypeFace")
public abstract class FontTypeFace extends Rasterizer2D {
   @ObfuscatedName("m")
   @Export("strikeRGB")
   static int strikeRGB;
   @ObfuscatedName("u")
   static String[] field3636;
   @ObfuscatedName("i")
   @Export("underlineRGB")
   static int underlineRGB;
   @ObfuscatedName("z")
   static Random field3645;
   @ObfuscatedName("v")
   static int field3644;
   @ObfuscatedName("s")
   @Export("prevShadeRGB")
   static int prevShadeRGB;
   @ObfuscatedName("e")
   @Export("prevColorRGB")
   static int prevColorRGB;
   @ObfuscatedName("a")
   @Export("color")
   static int color;
   @ObfuscatedName("r")
   @Export("shadow")
   static int shadow;
   @ObfuscatedName("t")
   static int field3643;
   @ObfuscatedName("y")
   static int field3625;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   @Export("modIcons")
   public static IndexedSprite[] modIcons;
   @ObfuscatedName("h")
   int[] field3626;
   @ObfuscatedName("c")
   @Export("verticalSpace")
   public int verticalSpace;
   @ObfuscatedName("j")
   @Export("gylphs")
   byte[][] gylphs;
   @ObfuscatedName("l")
   @Export("minSpacing")
   public int minSpacing;
   @ObfuscatedName("x")
   @Export("horizontalOffsets")
   int[] horizontalOffsets;
   @ObfuscatedName("w")
   @Export("maxSpacing")
   public int maxSpacing;
   @ObfuscatedName("g")
   @Export("verticalOffsets")
   int[] verticalOffsets;
   @ObfuscatedName("o")
   byte[] field3639;
   @ObfuscatedName("f")
   @Export("gylphHeights")
   int[] gylphHeights;
   @ObfuscatedName("p")
   @Export("glyphWidths")
   int[] glyphWidths;

   static {
      strikeRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = -1;
      shadow = -1;
      prevColorRGB = 0;
      color = 0;
      field3644 = 256;
      field3643 = 0;
      field3625 = 0;
      field3645 = new Random();
      field3636 = new String[100];
   }

   FontTypeFace(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.gylphs = new byte[256][];
      this.verticalSpace = 0;
      this.horizontalOffsets = var2;
      this.verticalOffsets = var3;
      this.gylphHeights = var4;
      this.glyphWidths = var5;
      this.method4772(var1);
      this.gylphs = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.verticalOffsets[var10] < var8 && this.glyphWidths[var10] != 0) {
            var8 = this.verticalOffsets[var10];
         }

         if(this.verticalOffsets[var10] + this.glyphWidths[var10] > var9) {
            var9 = this.verticalOffsets[var10] + this.glyphWidths[var10];
         }
      }

      this.minSpacing = this.verticalSpace - var8;
      this.maxSpacing = var9 - this.verticalSpace;
   }

   FontTypeFace(byte[] var1) {
      this.gylphs = new byte[256][];
      this.verticalSpace = 0;
      this.method4772(var1);
   }

   @ObfuscatedName("av")
   @Export("setColor")
   void setColor(int var1, int var2) {
      strikeRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = var2;
      shadow = var2;
      prevColorRGB = var1;
      color = var1;
      field3644 = 256;
      field3643 = 0;
      field3625 = 0;
   }

   @ObfuscatedName("m")
   public int method4775(String var1) {
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
                              int var8 = class255.method4554(var7.substring(4));
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
                  var4 += this.field3626[(char)(class19.method146(var6) & 255)];
                  if(this.field3639 != null && var3 != -1) {
                     var4 += this.field3639[var6 + (var3 << 8)];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("e")
   public int method4776(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method4855('<');
                     if(this.field3639 != null && var11 != -1) {
                        var4 += this.field3639[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method4855('>');
                     if(this.field3639 != null && var11 != -1) {
                        var4 += this.field3639[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = class19.parseInt(var18, 10, true);
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
                     var4 += this.method4855(var15);
                     if(this.field3639 != null && var11 != -1) {
                        var4 += this.field3639[var15 + (var11 << 8)];
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

         String var20 = var6.toString();
         if(var20.length() > var5) {
            var3[var12++] = var20.substring(var5, var20.length());
         }

         return var12;
      }
   }

   @ObfuscatedName("ae")
   void method4797(String var1, int var2, int var3) {
      var3 -= this.verticalSpace;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class19.method146(var1.charAt(var6)) & 255);
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
                              var9 = class255.method4554(var8.substring(4));
                              IndexedSprite var12 = modIcons[var9];
                              var12.method5058(var2, var3 + this.verticalSpace - var12.originalHeight);
                              var2 += var12.width;
                              var5 = -1;
                           } catch (Exception var14) {
                              ;
                           }
                        } else {
                           this.setRGB(var8);
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
                  if(this.field3639 != null && var5 != -1) {
                     var2 += this.field3639[var7 + (var5 << 8)];
                  }

                  int var11 = this.gylphHeights[var7];
                  var9 = this.glyphWidths[var7];
                  if(var7 != 32) {
                     if(field3644 == 256) {
                        if(shadow != -1) {
                           renderShadeRGB(this.gylphs[var7], var2 + this.horizontalOffsets[var7] + 1, var3 + this.verticalOffsets[var7] + 1, var11, var9, shadow);
                        }

                        this.renderRGB(this.gylphs[var7], var2 + this.horizontalOffsets[var7], var3 + this.verticalOffsets[var7], var11, var9, color);
                     } else {
                        if(shadow != -1) {
                           renderShadeRGBA(this.gylphs[var7], var2 + this.horizontalOffsets[var7] + 1, var3 + this.verticalOffsets[var7] + 1, var11, var9, shadow, field3644);
                        }

                        this.renderRGBA(this.gylphs[var7], var2 + this.horizontalOffsets[var7], var3 + this.verticalOffsets[var7], var11, var9, color, field3644);
                     }
                  } else if(field3643 > 0) {
                     field3625 += field3643;
                     var2 += field3625 >> 8;
                     field3625 &= 255;
                  }

                  int var10 = this.field3626[var7];
                  if(strikeRGB != -1) {
                     Rasterizer2D.method4985(var2, var3 + (int)((double)this.verticalSpace * 0.7D), var10, strikeRGB);
                  }

                  if(underlineRGB != -1) {
                     Rasterizer2D.method4985(var2, var3 + this.verticalSpace + 1, var10, underlineRGB);
                  }

                  var2 += var10;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   void method4772(byte[] var1) {
      this.field3626 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3626.length; ++var2) {
            this.field3626[var2] = var1[var2] & 255;
         }

         this.verticalSpace = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3626[var3] = var1[var2++] & 255;
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

         this.field3639 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3639[var8 + (var13 << 8)] = (byte)method4798(var11, var12, var4, this.field3626, var10, var13, var8);
                  }
               }
            }
         }

         this.verticalSpace = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("at")
   @Export("drawMouseoverText")
   void drawMouseoverText(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.verticalSpace;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class19.method146(var1.charAt(var9)) & 255);
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
                              String var19 = var11.substring(4);
                              var14 = class19.parseInt(var19, 10, true);
                              IndexedSprite var17 = modIcons[var14];
                              var17.method5058(var12 + var2, var13 + (var3 + this.verticalSpace - var17.originalHeight));
                              var2 += var17.width;
                              var7 = -1;
                           } catch (Exception var21) {
                              ;
                           }
                        } else {
                           this.setRGB(var11);
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
                  if(this.field3639 != null && var7 != -1) {
                     var2 += this.field3639[var10 + (var7 << 8)];
                  }

                  int var18 = this.gylphHeights[var10];
                  var12 = this.glyphWidths[var10];
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
                     if(field3644 == 256) {
                        if(shadow != -1) {
                           renderShadeRGB(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10] + 1, var3 + var14 + this.verticalOffsets[var10] + 1, var18, var12, shadow);
                        }

                        this.renderRGB(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10], var3 + var14 + this.verticalOffsets[var10], var18, var12, color);
                     } else {
                        if(shadow != -1) {
                           renderShadeRGBA(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10] + 1, var3 + var14 + this.verticalOffsets[var10] + 1, var18, var12, shadow, field3644);
                        }

                        this.renderRGBA(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10], var3 + var14 + this.verticalOffsets[var10], var18, var12, color, field3644);
                     }
                  } else if(field3643 > 0) {
                     field3625 += field3643;
                     var2 += field3625 >> 8;
                     field3625 &= 255;
                  }

                  int var15 = this.field3626[var10];
                  if(strikeRGB != -1) {
                     Rasterizer2D.method4985(var2, var3 + (int)((double)this.verticalSpace * 0.7D), var15, strikeRGB);
                  }

                  if(underlineRGB != -1) {
                     Rasterizer2D.method4985(var2, var3 + this.verticalSpace, var15, underlineRGB);
                  }

                  var2 += var15;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   int method4855(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3626[class19.method146(var1) & 255];
   }

   @ObfuscatedName("v")
   public int method4778(String var1, int var2) {
      return this.method4776(var1, new int[]{var2}, field3636);
   }

   @ObfuscatedName("ab")
   @Export("setRGB")
   void setRGB(String var1) {
      try {
         int var2;
         String var3;
         if(var1.startsWith("col=")) {
            var3 = var1.substring(4);
            var2 = class19.parseInt(var3, 16, true);
            color = var2;
         } else if(var1.equals("/col")) {
            color = prevColorRGB;
         } else if(var1.startsWith("str=")) {
            var3 = var1.substring(4);
            var2 = class19.parseInt(var3, 16, true);
            strikeRGB = var2;
         } else if(var1.equals("str")) {
            strikeRGB = 8388608;
         } else if(var1.equals("/str")) {
            strikeRGB = -1;
         } else if(var1.startsWith("u=")) {
            var3 = var1.substring(2);
            var2 = class19.parseInt(var3, 16, true);
            underlineRGB = var2;
         } else if(var1.equals("u")) {
            underlineRGB = 0;
         } else if(var1.equals("/u")) {
            underlineRGB = -1;
         } else if(var1.startsWith("shad=")) {
            var3 = var1.substring(5);
            var2 = class19.parseInt(var3, 16, true);
            shadow = var2;
         } else if(var1.equals("shad")) {
            shadow = 0;
         } else if(var1.equals("/shad")) {
            shadow = prevShadeRGB;
         } else if(var1.equals("br")) {
            this.setColor(prevColorRGB, prevShadeRGB);
         }
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("ax")
   public int method4784(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.setColor(var6, var7);
         if(var10 == 0) {
            var10 = this.verticalSpace;
         }

         int[] var11 = new int[]{var4};
         if(var5 < var10 + this.minSpacing + this.maxSpacing && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method4776(var1, var11, field3636);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.minSpacing;
         } else if(var9 == 1) {
            var13 = var3 + (var5 - this.minSpacing - this.maxSpacing - var10 * (var12 - 1)) / 2 + this.minSpacing;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.maxSpacing - var10 * (var12 - 1);
         } else {
            var14 = (var5 - this.minSpacing - this.maxSpacing - var10 * (var12 - 1)) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + var14 + this.minSpacing;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method4797(field3636[var14], var2, var13);
            } else if(var8 == 1) {
               this.method4797(field3636[var14], var2 + (var4 - this.method4775(field3636[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method4797(field3636[var14], var2 + var4 - this.method4775(field3636[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method4797(field3636[var14], var2, var13);
            } else {
               this.method4791(field3636[var14], var4);
               this.method4797(field3636[var14], var2, var13);
               field3643 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("aj")
   void method4791(String var1, int var2) {
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
         field3643 = (var2 - this.method4775(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("j")
   @Export("renderRGB")
   abstract void renderRGB(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("h")
   @Export("renderRGBA")
   abstract void renderRGBA(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("a")
   public int method4777(String var1, int var2) {
      int var3 = this.method4776(var1, new int[]{var2}, field3636);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method4775(field3636[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("ag")
   @Export("drawRandomizedMouseoverText")
   public void drawRandomizedMouseoverText(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         field3645.setSeed((long)var6);
         field3644 = 192 + (field3645.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3645.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.drawMouseoverText(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("d")
   public void method4843(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.setColor(var4, var5);
         this.method4797(var1, var2 - this.method4775(var1) / 2, var3);
      }
   }

   @ObfuscatedName("y")
   public void method4780(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.setColor(var4, var5);
         this.method4797(var1, var2, var3);
      }
   }

   @ObfuscatedName("n")
   public void method4782(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.setColor(var4, var5);
         this.method4797(var1, var2 - this.method4775(var1), var3);
      }
   }

   @ObfuscatedName("ao")
   public void method4785(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(var1, var2 - this.method4775(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("an")
   public void method4786(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(var1, var2 - this.method4775(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("ar")
   public void method4787(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
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

         this.drawMouseoverText(var1, var2 - this.method4775(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("u")
   public void method4781(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         field3644 = var6;
         this.method4797(var1, var2, var3);
      }
   }

   @ObfuscatedName("b")
   static int method4798(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("as")
   @Export("renderShadeRGB")
   static void renderShadeRGB(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var7 = Rasterizer2D.graphicsPixelsWidth - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < Rasterizer2D.drawingAreaTop) {
         var10 = Rasterizer2D.drawingAreaTop - var2;
         var4 -= var10;
         var2 = Rasterizer2D.drawingAreaTop;
         var9 += var3 * var10;
         var6 += var10 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var4 > Rasterizer2D.drawingAreaRight) {
         var4 -= var2 + var4 - Rasterizer2D.drawingAreaRight;
      }

      if(var1 < Rasterizer2D.draw_region_x) {
         var10 = Rasterizer2D.draw_region_x - var1;
         var3 -= var10;
         var1 = Rasterizer2D.draw_region_x;
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
         render(Rasterizer2D.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("au")
   @Export("renderShadeRGBA")
   static void renderShadeRGBA(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
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

      if(var1 < Rasterizer2D.draw_region_x) {
         var11 = Rasterizer2D.draw_region_x - var1;
         var3 -= var11;
         var1 = Rasterizer2D.draw_region_x;
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
         renderRGBA(Rasterizer2D.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("az")
   @Export("renderRGBA")
   static void renderRGBA(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      var2 = (var9 * (var2 & 16711935) & -16711936) + ((var2 & '\uff00') * var9 & 16711680) >> 8;
      var9 = 256 - var9;

      for(int var10 = -var6; var10 < 0; ++var10) {
         for(int var11 = -var5; var11 < 0; ++var11) {
            if(var1[var3++] != 0) {
               int var12 = var0[var4];
               var0[var4++] = (((var12 & '\uff00') * var9 & 16711680) + ((var12 & 16711935) * var9 & -16711936) >> 8) + var2;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   @ObfuscatedName("af")
   @Export("render")
   static void render(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("t")
   @Export("appendTags")
   public static String appendTags(String var0) {
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
}
