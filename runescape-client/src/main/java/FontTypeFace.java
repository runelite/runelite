import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lh")
@Implements("FontTypeFace")
public abstract class FontTypeFace extends Rasterizer2D {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("modIcons")
   public static IndexedSprite[] modIcons;
   @ObfuscatedName("a")
   @Export("strikeRGB")
   static int strikeRGB;
   @ObfuscatedName("e")
   @Export("underlineRGB")
   static int underlineRGB;
   @ObfuscatedName("f")
   @Export("prevShadeRGB")
   static int prevShadeRGB;
   @ObfuscatedName("l")
   @Export("shadow")
   static int shadow;
   @ObfuscatedName("m")
   @Export("prevColorRGB")
   static int prevColorRGB;
   @ObfuscatedName("b")
   @Export("color")
   static int color;
   @ObfuscatedName("h")
   static int field3902;
   @ObfuscatedName("t")
   static int field3903;
   @ObfuscatedName("v")
   static int field3890;
   @ObfuscatedName("n")
   static Random field3905;
   @ObfuscatedName("u")
   static String[] field3886;
   @ObfuscatedName("c")
   @Export("gylphs")
   byte[][] gylphs;
   @ObfuscatedName("i")
   int[] field3887;
   @ObfuscatedName("o")
   @Export("gylphHeights")
   int[] gylphHeights;
   @ObfuscatedName("j")
   @Export("glyphWidths")
   int[] glyphWidths;
   @ObfuscatedName("k")
   @Export("horizontalOffsets")
   int[] horizontalOffsets;
   @ObfuscatedName("x")
   @Export("verticalOffsets")
   int[] verticalOffsets;
   @ObfuscatedName("z")
   @Export("verticalSpace")
   public int verticalSpace;
   @ObfuscatedName("p")
   @Export("minSpacing")
   public int minSpacing;
   @ObfuscatedName("w")
   @Export("maxSpacing")
   public int maxSpacing;
   @ObfuscatedName("d")
   byte[] field3895;

   static {
      strikeRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = -1;
      shadow = -1;
      prevColorRGB = 0;
      color = 0;
      field3902 = 256;
      field3903 = 0;
      field3890 = 0;
      field3905 = new Random();
      field3886 = new String[100];
   }

   FontTypeFace(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.gylphs = new byte[256][];
      this.verticalSpace = 0;
      this.horizontalOffsets = var2;
      this.verticalOffsets = var3;
      this.gylphHeights = var4;
      this.glyphWidths = var5;
      this.method5514(var1);
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
      this.method5514(var1);
   }

   @ObfuscatedName("c")
   @Export("renderRGB")
   abstract void renderRGB(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("i")
   @Export("renderRGBA")
   abstract void renderRGBA(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("w")
   void method5514(byte[] var1) {
      this.field3887 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3887.length; ++var2) {
            this.field3887[var2] = var1[var2] & 255;
         }

         this.verticalSpace = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3887[var3] = var1[var2++] & 255;
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

         this.field3895 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3895[var8 + (var13 << 8)] = (byte)method5609(var11, var12, var4, this.field3887, var10, var13, var8);
                  }
               }
            }
         }

         this.verticalSpace = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("d")
   int method5547(char var1) {
      if(var1 == 160) {
         var1 = ' ';
      }

      return this.field3887[MessageNode.charToByteCp1252(var1) & 255];
   }

   @ObfuscatedName("a")
   @Export("getTextWidth")
   public int getTextWidth(String var1) {
      if(var1 == null) {
         return 0;
      } else {
         int var2 = -1;
         int var3 = -1;
         int var4 = 0;

         for(int var5 = 0; var5 < var1.length(); ++var5) {
            char var6 = var1.charAt(var5);
            if(var6 == '<') {
               var2 = var5;
            } else {
               if(var6 == '>' && var2 != -1) {
                  String var7 = var1.substring(var2 + 1, var5);
                  var2 = -1;
                  if(var7.equals("lt")) {
                     var6 = '<';
                  } else {
                     if(!var7.equals("gt")) {
                        if(var7.startsWith("img=")) {
                           try {
                              String var9 = var7.substring(4);
                              int var8 = FrameMap.parseInt(var9, 10, true);
                              var4 += modIcons[var8].originalWidth;
                              var3 = -1;
                           } catch (Exception var12) {
                              ;
                           }
                        }
                        continue;
                     }

                     var6 = '>';
                  }
               }

               if(var6 == 160) {
                  var6 = ' ';
               }

               if(var2 == -1) {
                  var4 += this.field3887[(char)(MessageNode.charToByteCp1252(var6) & 255)];
                  if(this.field3895 != null && var3 != -1) {
                     var4 += this.field3895[var6 + (var3 << 8)];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("b")
   public int method5517(String var1, int[] var2, String[] var3) {
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
            if(var15 == '<') {
               var10 = var14;
            } else {
               if(var15 == '>' && var10 != -1) {
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
                     var4 += this.method5547('<');
                     if(this.field3895 != null && var11 != -1) {
                        var4 += this.field3895[(var11 << '\b') + 60];
                     }

                     var11 = '<';
                  } else if(var16.equals("gt")) {
                     var4 += this.method5547('>');
                     if(this.field3895 != null && var11 != -1) {
                        var4 += this.field3895[(var11 << '\b') + 62];
                     }

                     var11 = '>';
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = FrameMap.parseInt(var18, 10, true);
                        var4 += modIcons[var17].originalWidth;
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
                     var4 += this.method5547(var15);
                     if(this.field3895 != null && var11 != -1) {
                        var4 += this.field3895[var15 + (var11 << '\b')];
                     }

                     var11 = var15;
                  }

                  if(var15 == ' ') {
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

                  if(var15 == '-') {
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

   @ObfuscatedName("h")
   public int method5518(String var1, int var2) {
      int var3 = this.method5517(var1, new int[]{var2}, field3886);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.getTextWidth(field3886[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("n")
   public int method5519(String var1, int var2) {
      return this.method5517(var1, new int[]{var2}, field3886);
   }

   @ObfuscatedName("q")
   public void method5521(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.setColor(var4, var5);
         this.drawText(var1, var2, var3);
      }
   }

   @ObfuscatedName("g")
   public void method5586(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         field3902 = var6;
         this.drawText(var1, var2, var3);
      }
   }

   @ObfuscatedName("y")
   public void method5544(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.setColor(var4, var5);
         this.drawText(var1, var2 - this.getTextWidth(var1), var3);
      }
   }

   @ObfuscatedName("s")
   @Export("drawTextCentered")
   public void drawTextCentered(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.setColor(var4, var5);
         this.drawText(var1, var2 - this.getTextWidth(var1) / 2, var3);
      }
   }

   @ObfuscatedName("ac")
   public int method5525(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
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

         int var12 = this.method5517(var1, var11, field3886);
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
               this.drawText(field3886[var14], var2, var13);
            } else if(var8 == 1) {
               this.drawText(field3886[var14], var2 + (var4 - this.getTextWidth(field3886[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.drawText(field3886[var14], var2 + var4 - this.getTextWidth(field3886[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.drawText(field3886[var14], var2, var13);
            } else {
               this.method5583(field3886[var14], var4);
               this.drawText(field3886[var14], var2, var13);
               field3903 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("ap")
   public void method5526(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(var1, var2 - this.getTextWidth(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("al")
   public void method5527(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.drawMouseoverText(var1, var2 - this.getTextWidth(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("ai")
   public void method5528(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
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

         this.drawMouseoverText(var1, var2 - this.getTextWidth(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("ab")
   @Export("drawRandomizedMouseoverText")
   public void drawRandomizedMouseoverText(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.setColor(var4, var5);
         field3905.setSeed((long)var6);
         field3902 = 192 + (field3905.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3905.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.drawMouseoverText(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("ak")
   @Export("setColor")
   void setColor(int var1, int var2) {
      strikeRGB = -1;
      underlineRGB = -1;
      prevShadeRGB = var2;
      shadow = var2;
      prevColorRGB = var1;
      color = var1;
      field3902 = 256;
      field3903 = 0;
      field3890 = 0;
   }

   @ObfuscatedName("as")
   @Export("setRGB")
   void setRGB(String var1) {
      try {
         if(var1.startsWith("col=")) {
            color = class93.method1928(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            color = prevColorRGB;
         } else if(var1.startsWith("str=")) {
            strikeRGB = class93.method1928(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            strikeRGB = 8388608;
         } else if(var1.equals("/str")) {
            strikeRGB = -1;
         } else if(var1.startsWith("u=")) {
            underlineRGB = class93.method1928(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            underlineRGB = 0;
         } else if(var1.equals("/u")) {
            underlineRGB = -1;
         } else if(var1.startsWith("shad=")) {
            shadow = class93.method1928(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            shadow = 0;
         } else if(var1.equals("/shad")) {
            shadow = prevShadeRGB;
         } else if(var1.equals("br")) {
            this.setColor(prevColorRGB, prevShadeRGB);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("aa")
   void method5583(String var1, int var2) {
      int var3 = 0;
      boolean var4 = false;

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         char var6 = var1.charAt(var5);
         if(var6 == '<') {
            var4 = true;
         } else if(var6 == '>') {
            var4 = false;
         } else if(!var4 && var6 == ' ') {
            ++var3;
         }
      }

      if(var3 > 0) {
         field3903 = (var2 - this.getTextWidth(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("ah")
   @Export("drawText")
   void drawText(String var1, int var2, int var3) {
      var3 -= this.verticalSpace;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(MessageNode.charToByteCp1252(var1.charAt(var6)) & 255);
            if(var7 == '<') {
               var4 = var6;
            } else {
               int var9;
               if(var7 == '>' && var4 != -1) {
                  String var8 = var1.substring(var4 + 1, var6);
                  var4 = -1;
                  if(var8.equals("lt")) {
                     var7 = '<';
                  } else {
                     if(!var8.equals("gt")) {
                        if(var8.startsWith("img=")) {
                           try {
                              String var10 = var8.substring(4);
                              var9 = FrameMap.parseInt(var10, 10, true);
                              IndexedSprite var12 = modIcons[var9];
                              var12.method5842(var2, var3 + this.verticalSpace - var12.originalHeight);
                              var2 += var12.originalWidth;
                              var5 = -1;
                           } catch (Exception var16) {
                              ;
                           }
                        } else {
                           this.setRGB(var8);
                        }
                        continue;
                     }

                     var7 = '>';
                  }
               }

               if(var7 == 160) {
                  var7 = ' ';
               }

               if(var4 == -1) {
                  if(this.field3895 != null && var5 != -1) {
                     var2 += this.field3895[var7 + (var5 << 8)];
                  }

                  int var14 = this.gylphHeights[var7];
                  var9 = this.glyphWidths[var7];
                  if(var7 != ' ') {
                     if(field3902 == 256) {
                        if(shadow != -1) {
                           renderShadeRGB(this.gylphs[var7], var2 + this.horizontalOffsets[var7] + 1, var3 + this.verticalOffsets[var7] + 1, var14, var9, shadow);
                        }

                        this.renderRGB(this.gylphs[var7], var2 + this.horizontalOffsets[var7], var3 + this.verticalOffsets[var7], var14, var9, color);
                     } else {
                        if(shadow != -1) {
                           renderShadeRGBA(this.gylphs[var7], var2 + this.horizontalOffsets[var7] + 1, var3 + this.verticalOffsets[var7] + 1, var14, var9, shadow, field3902);
                        }

                        this.renderRGBA(this.gylphs[var7], var2 + this.horizontalOffsets[var7], var3 + this.verticalOffsets[var7], var14, var9, color, field3902);
                     }
                  } else if(field3903 > 0) {
                     field3890 += field3903;
                     var2 += field3890 >> 8;
                     field3890 &= 255;
                  }

                  int var15 = this.field3887[var7];
                  if(strikeRGB != -1) {
                     Rasterizer2D.method5756(var2, var3 + (int)((double)this.verticalSpace * 0.7D), var15, strikeRGB);
                  }

                  if(underlineRGB != -1) {
                     Rasterizer2D.method5756(var2, var3 + this.verticalSpace + 1, var15, underlineRGB);
                  }

                  var2 += var15;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @Export("drawMouseoverText")
   void drawMouseoverText(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.verticalSpace;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(MessageNode.charToByteCp1252(var1.charAt(var9)) & 255);
            if(var10 == '<') {
               var6 = var9;
            } else {
               int var12;
               int var13;
               int var14;
               if(var10 == '>' && var6 != -1) {
                  String var11 = var1.substring(var6 + 1, var9);
                  var6 = -1;
                  if(var11.equals("lt")) {
                     var10 = '<';
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
                              var14 = FrameMap.parseInt(var15, 10, true);
                              IndexedSprite var17 = modIcons[var14];
                              var17.method5842(var12 + var2, var13 + (var3 + this.verticalSpace - var17.originalHeight));
                              var2 += var17.originalWidth;
                              var7 = -1;
                           } catch (Exception var21) {
                              ;
                           }
                        } else {
                           this.setRGB(var11);
                        }
                        continue;
                     }

                     var10 = '>';
                  }
               }

               if(var10 == 160) {
                  var10 = ' ';
               }

               if(var6 == -1) {
                  if(this.field3895 != null && var7 != -1) {
                     var2 += this.field3895[var10 + (var7 << 8)];
                  }

                  int var19 = this.gylphHeights[var10];
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
                  if(var10 != ' ') {
                     if(field3902 == 256) {
                        if(shadow != -1) {
                           renderShadeRGB(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10] + 1, var3 + var14 + this.verticalOffsets[var10] + 1, var19, var12, shadow);
                        }

                        this.renderRGB(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10], var3 + var14 + this.verticalOffsets[var10], var19, var12, color);
                     } else {
                        if(shadow != -1) {
                           renderShadeRGBA(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10] + 1, var3 + var14 + this.verticalOffsets[var10] + 1, var19, var12, shadow, field3902);
                        }

                        this.renderRGBA(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10], var3 + var14 + this.verticalOffsets[var10], var19, var12, color, field3902);
                     }
                  } else if(field3903 > 0) {
                     field3890 += field3903;
                     var2 += field3890 >> 8;
                     field3890 &= 255;
                  }

                  int var20 = this.field3887[var10];
                  if(strikeRGB != -1) {
                     Rasterizer2D.method5756(var2, var3 + (int)((double)this.verticalSpace * 0.7D), var20, strikeRGB);
                  }

                  if(underlineRGB != -1) {
                     Rasterizer2D.method5756(var2, var3 + this.verticalSpace, var20, underlineRGB);
                  }

                  var2 += var20;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   static int method5609(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("u")
   @Export("appendTags")
   public static String appendTags(String var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 == '<' || var4 == '>') {
            var2 += 3;
         }
      }

      StringBuilder var6 = new StringBuilder(var1 + var2);

      for(int var7 = 0; var7 < var1; ++var7) {
         char var5 = var0.charAt(var7);
         if(var5 == '<') {
            var6.append("<lt>");
         } else if(var5 == '>') {
            var6.append("<gt>");
         } else {
            var6.append(var5);
         }
      }

      return var6.toString();
   }

   @ObfuscatedName("am")
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

   @ObfuscatedName("aq")
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

   @ObfuscatedName("ae")
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

   @ObfuscatedName("af")
   @Export("renderRGBA")
   static void renderRGBA(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      var2 = ((var2 & 65280) * var9 & 16711680) + (var9 * (var2 & 16711935) & -16711936) >> 8;
      var9 = 256 - var9;

      for(int var10 = -var6; var10 < 0; ++var10) {
         for(int var11 = -var5; var11 < 0; ++var11) {
            if(var1[var3++] != 0) {
               int var12 = var0[var4];
               var0[var4++] = (((var12 & 65280) * var9 & 16711680) + ((var12 & 16711935) * var9 & -16711936) >> 8) + var2;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }
}
