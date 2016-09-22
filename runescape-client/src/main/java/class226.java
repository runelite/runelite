import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public abstract class class226 extends class82 {
   @ObfuscatedName("s")
   static int field3231 = -1;
   @ObfuscatedName("d")
   int[] field3232;
   @ObfuscatedName("v")
   int[] field3233;
   @ObfuscatedName("z")
   int[] field3234;
   @ObfuscatedName("g")
   public int field3235;
   @ObfuscatedName("t")
   int[] field3236;
   @ObfuscatedName("n")
   public int field3237 = 0;
   @ObfuscatedName("i")
   public int field3238;
   @ObfuscatedName("a")
   byte[][] field3239 = new byte[256][];
   @ObfuscatedName("m")
   @Export("modIcons")
   public static ModIcon[] modIcons;
   @ObfuscatedName("k")
   byte[] field3241;
   @ObfuscatedName("r")
   int[] field3242;
   @ObfuscatedName("y")
   static int field3243 = -1;
   @ObfuscatedName("af")
   static String[] field3244 = new String[100];
   @ObfuscatedName("as")
   static Random field3245 = new Random();
   @ObfuscatedName("h")
   static int field3246 = 0;
   @ObfuscatedName("e")
   static int field3247 = -1;
   @ObfuscatedName("c")
   static int field3248 = 256;
   @ObfuscatedName("l")
   static int field3249 = 0;
   @ObfuscatedName("ac")
   static int field3250 = 0;
   @ObfuscatedName("x")
   static int field3251 = -1;
   @ObfuscatedName("f")
   static int field3252 = 0;

   class226(byte[] var1) {
      this.method4079(var1);
   }

   @ObfuscatedName("l")
   abstract void vmethod4165(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("b")
   public void method4063(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4127(var4, var5);
         field3245.setSeed((long)var6);
         field3248 = 192 + (field3245.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3245.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method4132(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("r")
   public int method4065(String var1) {
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
                              int var8 = class145.method3020(var9, 10, true);
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
                  var4 += this.field3232[(char)(ItemComposition.method1174(var6) & 255)];
                  if(this.field3241 != null && var3 != -1) {
                     var4 += this.field3241[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   int method4066(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method4122('<');
                     if(this.field3241 != null && var11 != -1) {
                        var4 += this.field3241[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method4122('>');
                     if(this.field3241 != null && var11 != -1) {
                        var4 += this.field3241[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = class145.method3020(var18, 10, true);
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
                     var4 += this.method4122(var15);
                     if(this.field3241 != null && var11 != -1) {
                        var4 += this.field3241[(var11 << 8) + var15];
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

   @ObfuscatedName("t")
   public int method4067(String var1, int var2) {
      int var3 = this.method4066(var1, new int[]{var2}, field3244);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method4065(field3244[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("n")
   public int method4068(String var1, int var2) {
      return this.method4066(var1, new int[]{var2}, field3244);
   }

   @ObfuscatedName("i")
   public static String method4069(String var0) {
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

   @ObfuscatedName("m")
   public void method4071(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4127(var4, var5);
         field3248 = var6;
         this.method4081(var1, var2, var3);
      }
   }

   class226(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3234 = var2;
      this.field3236 = var3;
      this.field3233 = var4;
      this.field3242 = var5;
      this.method4079(var1);
      this.field3239 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3236[var10] < var8 && this.field3242[var10] != 0) {
            var8 = this.field3236[var10];
         }

         if(this.field3236[var10] + this.field3242[var10] > var9) {
            var9 = this.field3236[var10] + this.field3242[var10];
         }
      }

      this.field3238 = this.field3237 - var8;
      this.field3235 = var9 - this.field3237;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4072(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4127(var4, var5);
         this.method4081(var1, var2 - this.method4065(var1), var3);
      }
   }

   @ObfuscatedName("u")
   public int method4073(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method4127(var6, var7);
         if(var10 == 0) {
            var10 = this.field3237;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3238 + this.field3235 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method4066(var1, var11, field3244);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3238;
         } else if(var9 == 1) {
            var13 = var3 + this.field3238 + (var5 - this.field3238 - this.field3235 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3235 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3238 - this.field3235 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3238 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method4081(field3244[var14], var2, var13);
            } else if(var8 == 1) {
               this.method4081(field3244[var14], var2 + (var4 - this.method4065(field3244[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method4081(field3244[var14], var2 + var4 - this.method4065(field3244[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method4081(field3244[var14], var2, var13);
            } else {
               this.method4082(field3244[var14], var4);
               this.method4081(field3244[var14], var2, var13);
               field3252 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("j")
   public void method4074(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4127(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4132(var1, var2 - this.method4065(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("q")
   public void method4075(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4127(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4132(var1, var2 - this.method4065(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("w")
   public void method4076(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method4127(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method4132(var1, var2 - this.method4065(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("a")
   void method4079(byte[] var1) {
      this.field3232 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3232.length; ++var2) {
            this.field3232[var2] = var1[var2] & 255;
         }

         this.field3237 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3232[var3] = var1[var2++] & 255;
         }

         int[] var11 = new int[256];
         int[] var4 = new int[256];

         int var10;
         for(var10 = 0; var10 < 256; ++var10) {
            var11[var10] = var1[var2++] & 255;
         }

         for(var10 = 0; var10 < 256; ++var10) {
            var4[var10] = var1[var2++] & 255;
         }

         byte[][] var5 = new byte[256][];

         int var8;
         for(int var12 = 0; var12 < 256; ++var12) {
            var5[var12] = new byte[var11[var12]];
            byte var7 = 0;

            for(var8 = 0; var8 < var5[var12].length; ++var8) {
               var7 += var1[var2++];
               var5[var12][var8] = var7;
            }
         }

         byte[][] var6 = new byte[256][];

         int var13;
         for(var13 = 0; var13 < 256; ++var13) {
            var6[var13] = new byte[var11[var13]];
            byte var14 = 0;

            for(int var9 = 0; var9 < var6[var13].length; ++var9) {
               var14 += var1[var2++];
               var6[var13][var9] = var14;
            }
         }

         this.field3241 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3241[(var13 << 8) + var8] = (byte)method4090(var5, var6, var4, this.field3232, var11, var13, var8);
                  }
               }
            }
         }

         this.field3237 = var4[32] + var11[32];
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4080(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4127(var4, var5);
         this.method4081(var1, var2 - this.method4065(var1) / 2, var3);
      }
   }

   @ObfuscatedName("s")
   void method4081(String var1, int var2, int var3) {
      var3 -= this.field3237;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(ItemComposition.method1174(var1.charAt(var6)) & 255);
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
                              var9 = class145.method3020(var10, 10, true);
                              ModIcon var12 = modIcons[var9];
                              var12.method1900(var2, var3 + this.field3237 - var12.originalHeight);
                              var2 += var12.width;
                              var5 = -1;
                           } catch (Exception var16) {
                              ;
                           }
                        } else {
                           this.method4128(var8);
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
                  if(this.field3241 != null && var5 != -1) {
                     var2 += this.field3241[(var5 << 8) + var7];
                  }

                  int var14 = this.field3233[var7];
                  var9 = this.field3242[var7];
                  if(var7 != 32) {
                     if(field3248 == 256) {
                        if(field3247 != -1) {
                           method4133(this.field3239[var7], var2 + this.field3234[var7] + 1, var3 + this.field3236[var7] + 1, var14, var9, field3247);
                        }

                        this.vmethod4162(this.field3239[var7], var2 + this.field3234[var7], var3 + this.field3236[var7], var14, var9, field3249);
                     } else {
                        if(field3247 != -1) {
                           method4087(this.field3239[var7], var2 + this.field3234[var7] + 1, var3 + this.field3236[var7] + 1, var14, var9, field3247, field3248);
                        }

                        this.vmethod4165(this.field3239[var7], var2 + this.field3234[var7], var3 + this.field3236[var7], var14, var9, field3249, field3248);
                     }
                  } else if(field3252 > 0) {
                     field3250 += field3252;
                     var2 += field3250 >> 8;
                     field3250 &= 255;
                  }

                  int var15 = this.field3232[var7];
                  if(field3251 != -1) {
                     class82.method1828(var2, var3 + (int)((double)this.field3237 * 0.7D), var15, field3251);
                  }

                  if(field3243 != -1) {
                     class82.method1828(var2, var3 + this.field3237 + 1, var15, field3243);
                  }

                  var2 += var15;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   void method4082(String var1, int var2) {
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
         field3252 = (var2 - this.method4065(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("f")
   static void method4086(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("ac")
   static void method4087(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class82.graphicsPixelsWidth;
      int var8 = class82.graphicsPixelsWidth - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class82.field1491) {
         var11 = class82.field1491 - var2;
         var4 -= var11;
         var2 = class82.field1491;
         var10 += var11 * var3;
         var7 += var11 * class82.graphicsPixelsWidth;
      }

      if(var2 + var4 > class82.field1490) {
         var4 -= var2 + var4 - class82.field1490;
      }

      if(var1 < class82.field1493) {
         var11 = class82.field1493 - var1;
         var3 -= var11;
         var1 = class82.field1493;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class82.field1488) {
         var11 = var1 + var3 - class82.field1488;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method4088(class82.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("as")
   static void method4088(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("d")
   static int method4090(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("h")
   abstract void vmethod4162(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("v")
   int method4122(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3232[ItemComposition.method1174(var1) & 255];
   }

   @ObfuscatedName("p")
   void method4127(int var1, int var2) {
      field3251 = -1;
      field3243 = -1;
      field3231 = var2;
      field3247 = var2;
      field3246 = var1;
      field3249 = var1;
      field3248 = 256;
      field3252 = 0;
      field3250 = 0;
   }

   @ObfuscatedName("o")
   void method4128(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3249 = class32.method694(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3249 = field3246;
         } else if(var1.startsWith("str=")) {
            field3251 = class32.method694(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3251 = 8388608;
         } else if(var1.equals("/str")) {
            field3251 = -1;
         } else if(var1.startsWith("u=")) {
            field3243 = class32.method694(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3243 = 0;
         } else if(var1.equals("/u")) {
            field3243 = -1;
         } else if(var1.startsWith("shad=")) {
            field3247 = class32.method694(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3247 = 0;
         } else if(var1.equals("/shad")) {
            field3247 = field3231;
         } else if(var1.equals("br")) {
            this.method4127(field3246, field3231);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("e")
   void method4132(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3237;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(ItemComposition.method1174(var1.charAt(var9)) & 255);
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
                              var14 = class145.method3020(var15, 10, true);
                              ModIcon var17 = modIcons[var14];
                              var17.method1900(var2 + var12, var3 + this.field3237 - var17.originalHeight + var13);
                              var2 += var17.width;
                              var7 = -1;
                           } catch (Exception var21) {
                              ;
                           }
                        } else {
                           this.method4128(var11);
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
                  if(this.field3241 != null && var7 != -1) {
                     var2 += this.field3241[(var7 << 8) + var10];
                  }

                  int var19 = this.field3233[var10];
                  var12 = this.field3242[var10];
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
                     if(field3248 == 256) {
                        if(field3247 != -1) {
                           method4133(this.field3239[var10], var2 + this.field3234[var10] + 1 + var13, var3 + this.field3236[var10] + 1 + var14, var19, var12, field3247);
                        }

                        this.vmethod4162(this.field3239[var10], var2 + this.field3234[var10] + var13, var3 + this.field3236[var10] + var14, var19, var12, field3249);
                     } else {
                        if(field3247 != -1) {
                           method4087(this.field3239[var10], var2 + this.field3234[var10] + 1 + var13, var3 + this.field3236[var10] + 1 + var14, var19, var12, field3247, field3248);
                        }

                        this.vmethod4165(this.field3239[var10], var2 + this.field3234[var10] + var13, var3 + this.field3236[var10] + var14, var19, var12, field3249, field3248);
                     }
                  } else if(field3252 > 0) {
                     field3250 += field3252;
                     var2 += field3250 >> 8;
                     field3250 &= 255;
                  }

                  int var20 = this.field3232[var10];
                  if(field3251 != -1) {
                     class82.method1828(var2, var3 + (int)((double)this.field3237 * 0.7D), var20, field3251);
                  }

                  if(field3243 != -1) {
                     class82.method1828(var2, var3 + this.field3237, var20, field3243);
                  }

                  var2 += var20;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   static void method4133(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class82.graphicsPixelsWidth;
      int var7 = class82.graphicsPixelsWidth - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class82.field1491) {
         var10 = class82.field1491 - var2;
         var4 -= var10;
         var2 = class82.field1491;
         var9 += var10 * var3;
         var6 += var10 * class82.graphicsPixelsWidth;
      }

      if(var2 + var4 > class82.field1490) {
         var4 -= var2 + var4 - class82.field1490;
      }

      if(var1 < class82.field1493) {
         var10 = class82.field1493 - var1;
         var3 -= var10;
         var1 = class82.field1493;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class82.field1488) {
         var10 = var1 + var3 - class82.field1488;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4086(class82.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "0"
   )
   public void method4157(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4127(var4, var5);
         this.method4081(var1, var2, var3);
      }
   }
}
