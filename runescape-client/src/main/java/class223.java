import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public abstract class class223 extends class79 {
   @ObfuscatedName("i")
   static int field3182 = 0;
   @ObfuscatedName("v")
   static int field3183 = -1;
   @ObfuscatedName("x")
   int[] field3184;
   @ObfuscatedName("b")
   int[] field3185;
   @ObfuscatedName("f")
   byte[][] field3186 = new byte[256][];
   @ObfuscatedName("d")
   int[] field3187;
   @ObfuscatedName("n")
   public int field3188 = 0;
   @ObfuscatedName("r")
   byte[] field3189;
   @ObfuscatedName("g")
   int field3190;
   @ObfuscatedName("s")
   @Export("modIcons")
   public static class80[] field3191;
   @ObfuscatedName("ao")
   static String[] field3192 = new String[100];
   @ObfuscatedName("k")
   static int field3193 = -1;
   @ObfuscatedName("m")
   int field3194;
   @ObfuscatedName("y")
   static int field3195 = -1;
   @ObfuscatedName("j")
   static int field3196 = 0;
   @ObfuscatedName("a")
   static int field3197 = 0;
   @ObfuscatedName("l")
   int[] field3198;
   @ObfuscatedName("z")
   static int field3199 = 256;
   @ObfuscatedName("u")
   int[] field3200;
   @ObfuscatedName("ag")
   static int field3201 = 0;
   @ObfuscatedName("ax")
   static Random field3202 = new Random();
   @ObfuscatedName("c")
   static int field3203 = -1;

   class223(byte[] var1) {
      this.method4040(var1);
   }

   @ObfuscatedName("f")
   void method4040(byte[] var1) {
      this.field3200 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3200.length; ++var2) {
            this.field3200[var2] = var1[var2] & 255;
         }

         this.field3188 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var10 = 0; var10 < 256; ++var10) {
            this.field3200[var10] = var1[var2++] & 255;
         }

         int[] var3 = new int[256];
         int[] var4 = new int[256];

         int var11;
         for(var11 = 0; var11 < 256; ++var11) {
            var3[var11] = var1[var2++] & 255;
         }

         for(var11 = 0; var11 < 256; ++var11) {
            var4[var11] = var1[var2++] & 255;
         }

         byte[][] var5 = new byte[256][];

         int var8;
         for(int var6 = 0; var6 < 256; ++var6) {
            var5[var6] = new byte[var3[var6]];
            byte var7 = 0;

            for(var8 = 0; var8 < var5[var6].length; ++var8) {
               var7 += var1[var2++];
               var5[var6][var8] = var7;
            }
         }

         byte[][] var12 = new byte[256][];

         int var13;
         for(var13 = 0; var13 < 256; ++var13) {
            var12[var13] = new byte[var3[var13]];
            byte var14 = 0;

            for(int var9 = 0; var9 < var12[var13].length; ++var9) {
               var14 += var1[var2++];
               var12[var13][var9] = var14;
            }
         }

         this.field3189 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3189[(var13 << 8) + var8] = (byte)method4041(var5, var12, var4, this.field3200, var3, var13, var8);
                  }
               }
            }
         }

         this.field3188 = var4[32] + var3[32];
      }

   }

   @ObfuscatedName("u")
   static int method4041(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("x")
   int method4042(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3200[class111.method2482(var1) & 255];
   }

   @ObfuscatedName("b")
   public int method4043(String var1) {
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
                              int var8 = class35.method772(var7.substring(4));
                              var4 += field3191[var8].field1426;
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
                  var4 += this.field3200[(char)(class111.method2482(var6) & 255)];
                  if(this.field3189 != null && var3 != -1) {
                     var4 += this.field3189[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   int method4044(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method4042('<');
                     if(this.field3189 != null && var11 != -1) {
                        var4 += this.field3189[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method4042('>');
                     if(this.field3189 != null && var11 != -1) {
                        var4 += this.field3189[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        int var17 = class35.method772(var16.substring(4));
                        var4 += field3191[var17].field1426;
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
                     var4 += this.method4042(var15);
                     if(this.field3189 != null && var11 != -1) {
                        var4 += this.field3189[(var11 << 8) + var15];
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

   @ObfuscatedName("d")
   public int method4045(String var1, int var2) {
      int var3 = this.method4044(var1, new int[]{var2}, field3192);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method4043(field3192[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("n")
   public int method4046(String var1, int var2) {
      return this.method4044(var1, new int[]{var2}, field3192);
   }

   @ObfuscatedName("k")
   public int method4051(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method4056(var6, var7);
         if(var10 == 0) {
            var10 = this.field3188;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3194 + this.field3190 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method4044(var1, var11, field3192);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3194;
         } else if(var9 == 1) {
            var13 = var3 + this.field3194 + (var5 - this.field3194 - this.field3190 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3190 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3194 - this.field3190 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3194 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method4059(field3192[var14], var2, var13);
            } else if(var8 == 1) {
               this.method4059(field3192[var14], var2 + (var4 - this.method4043(field3192[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method4059(field3192[var14], var2 + var4 - this.method4043(field3192[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method4059(field3192[var14], var2, var13);
            } else {
               this.method4058(field3192[var14], var4);
               this.method4059(field3192[var14], var2, var13);
               field3196 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("o")
   public void method4052(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4056(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4060(var1, var2 - this.method4043(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("q")
   public void method4053(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4056(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4060(var1, var2 - this.method4043(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("ag")
   static void method4055(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("e")
   void method4056(int var1, int var2) {
      field3193 = -1;
      field3183 = -1;
      field3195 = var2;
      field3203 = var2;
      field3182 = var1;
      field3197 = var1;
      field3199 = 256;
      field3196 = 0;
      field3201 = 0;
   }

   @ObfuscatedName("t")
   void method4057(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3197 = class169.method3393(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3197 = field3182;
         } else if(var1.startsWith("str=")) {
            field3193 = class169.method3393(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3193 = 8388608;
         } else if(var1.equals("/str")) {
            field3193 = -1;
         } else if(var1.startsWith("u=")) {
            field3183 = class169.method3393(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3183 = 0;
         } else if(var1.equals("/u")) {
            field3183 = -1;
         } else if(var1.startsWith("shad=")) {
            field3203 = class169.method3393(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3203 = 0;
         } else if(var1.equals("/shad")) {
            field3203 = field3195;
         } else if(var1.equals("br")) {
            this.method4056(field3182, field3195);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("w")
   void method4058(String var1, int var2) {
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
         field3196 = (var2 - this.method4043(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("v")
   void method4059(String var1, int var2, int var3) {
      var3 -= this.field3188;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class111.method2482(var1.charAt(var6)) & 255);
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
                              var9 = class35.method772(var8.substring(4));
                              class80 var10 = field3191[var9];
                              var10.method1916(var2, var3 + this.field3188 - var10.field1432);
                              var2 += var10.field1426;
                              var5 = -1;
                           } catch (Exception var14) {
                              ;
                           }
                        } else {
                           this.method4057(var8);
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
                  if(this.field3189 != null && var5 != -1) {
                     var2 += this.field3189[(var5 << 8) + var7];
                  }

                  int var12 = this.field3184[var7];
                  var9 = this.field3185[var7];
                  if(var7 != 32) {
                     if(field3199 == 256) {
                        if(field3203 != -1) {
                           method4130(this.field3186[var7], var2 + this.field3198[var7] + 1, var3 + this.field3187[var7] + 1, var12, var9, field3203);
                        }

                        this.vmethod4136(this.field3186[var7], var2 + this.field3198[var7], var3 + this.field3187[var7], var12, var9, field3197);
                     } else {
                        if(field3203 != -1) {
                           method4065(this.field3186[var7], var2 + this.field3198[var7] + 1, var3 + this.field3187[var7] + 1, var12, var9, field3203, field3199);
                        }

                        this.vmethod4135(this.field3186[var7], var2 + this.field3198[var7], var3 + this.field3187[var7], var12, var9, field3197, field3199);
                     }
                  } else if(field3196 > 0) {
                     field3201 += field3196;
                     var2 += field3201 >> 8;
                     field3201 &= 255;
                  }

                  int var13 = this.field3200[var7];
                  if(field3193 != -1) {
                     class79.method1876(var2, var3 + (int)((double)this.field3188 * 0.7D), var13, field3193);
                  }

                  if(field3183 != -1) {
                     class79.method1876(var2, var3 + this.field3188 + 1, var13, field3183);
                  }

                  var2 += var13;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   void method4060(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3188;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class111.method2482(var1.charAt(var9)) & 255);
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
                              var14 = class35.method772(var11.substring(4));
                              class80 var15 = field3191[var14];
                              var15.method1916(var2 + var12, var3 + this.field3188 - var15.field1432 + var13);
                              var2 += var15.field1426;
                              var7 = -1;
                           } catch (Exception var19) {
                              ;
                           }
                        } else {
                           this.method4057(var11);
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
                  if(this.field3189 != null && var7 != -1) {
                     var2 += this.field3189[(var7 << 8) + var10];
                  }

                  int var17 = this.field3184[var10];
                  var12 = this.field3185[var10];
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
                     if(field3199 == 256) {
                        if(field3203 != -1) {
                           method4130(this.field3186[var10], var2 + this.field3198[var10] + 1 + var13, var3 + this.field3187[var10] + 1 + var14, var17, var12, field3203);
                        }

                        this.vmethod4136(this.field3186[var10], var2 + this.field3198[var10] + var13, var3 + this.field3187[var10] + var14, var17, var12, field3197);
                     } else {
                        if(field3203 != -1) {
                           method4065(this.field3186[var10], var2 + this.field3198[var10] + 1 + var13, var3 + this.field3187[var10] + 1 + var14, var17, var12, field3203, field3199);
                        }

                        this.vmethod4135(this.field3186[var10], var2 + this.field3198[var10] + var13, var3 + this.field3187[var10] + var14, var17, var12, field3197, field3199);
                     }
                  } else if(field3196 > 0) {
                     field3201 += field3196;
                     var2 += field3201 >> 8;
                     field3201 &= 255;
                  }

                  int var18 = this.field3200[var10];
                  if(field3193 != -1) {
                     class79.method1876(var2, var3 + (int)((double)this.field3188 * 0.7D), var18, field3193);
                  }

                  if(field3183 != -1) {
                     class79.method1876(var2, var3 + this.field3188, var18, field3183);
                  }

                  var2 += var18;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   abstract void vmethod4136(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("z")
   static void method4064(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("j")
   static void method4065(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class79.field1419;
      int var8 = class79.field1419 - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class79.field1422) {
         var11 = class79.field1422 - var2;
         var4 -= var11;
         var2 = class79.field1422;
         var10 += var11 * var3;
         var7 += var11 * class79.field1419;
      }

      if(var2 + var4 > class79.field1423) {
         var4 -= var2 + var4 - class79.field1423;
      }

      if(var1 < class79.field1424) {
         var11 = class79.field1424 - var1;
         var3 -= var11;
         var1 = class79.field1424;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class79.field1420) {
         var11 = var1 + var3 - class79.field1420;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method4055(class79.field1421, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "0"
   )
   public void method4066(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4056(var4, var5);
         this.method4059(var1, var2, var3);
      }
   }

   @ObfuscatedName("m")
   public static String method4069(String var0) {
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
   public void method4072(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method4056(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method4060(var1, var2 - this.method4043(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4073(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4056(var4, var5);
         this.method4059(var1, var2 - this.method4043(var1) / 2, var3);
      }
   }

   class223(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3198 = var2;
      this.field3187 = var3;
      this.field3184 = var4;
      this.field3185 = var5;
      this.method4040(var1);
      this.field3186 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3187[var10] < var8 && this.field3185[var10] != 0) {
            var8 = this.field3187[var10];
         }

         if(this.field3187[var10] + this.field3185[var10] > var9) {
            var9 = this.field3187[var10] + this.field3185[var10];
         }
      }

      this.field3194 = this.field3188 - var8;
      this.field3190 = var9 - this.field3188;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4105(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4056(var4, var5);
         this.method4059(var1, var2 - this.method4043(var1), var3);
      }
   }

   @ObfuscatedName("h")
   public void method4114(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4056(var4, var5);
         field3202.setSeed((long)var6);
         field3199 = 192 + (field3202.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3202.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method4060(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("i")
   abstract void vmethod4135(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("a")
   static void method4130(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class79.field1419;
      int var7 = class79.field1419 - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class79.field1422) {
         var10 = class79.field1422 - var2;
         var4 -= var10;
         var2 = class79.field1422;
         var9 += var10 * var3;
         var6 += var10 * class79.field1419;
      }

      if(var2 + var4 > class79.field1423) {
         var4 -= var2 + var4 - class79.field1423;
      }

      if(var1 < class79.field1424) {
         var10 = class79.field1424 - var1;
         var3 -= var10;
         var1 = class79.field1424;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class79.field1420) {
         var10 = var1 + var3 - class79.field1420;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4064(class79.field1421, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }
}
