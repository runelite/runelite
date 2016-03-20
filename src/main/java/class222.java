import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hs")
public abstract class class222 extends class79 {
   @ObfuscatedName("d")
   static int field3178 = -1;
   @ObfuscatedName("m")
   int field3179;
   @ObfuscatedName("f")
   int[] field3180;
   @ObfuscatedName("s")
   int[] field3181;
   @ObfuscatedName("y")
   int[] field3182;
   @ObfuscatedName("at")
   static Random field3183 = new Random();
   @ObfuscatedName("q")
   static int field3184 = 0;
   @ObfuscatedName("a")
   byte[][] field3185 = new byte[256][];
   @ObfuscatedName("j")
   int field3186;
   @ObfuscatedName("n")
   public static class80[] field3187;
   @ObfuscatedName("e")
   int[] field3188;
   @ObfuscatedName("h")
   static int field3189 = -1;
   @ObfuscatedName("x")
   static int field3190 = -1;
   @ObfuscatedName("r")
   int[] field3191;
   @ObfuscatedName("p")
   static int field3192 = -1;
   @ObfuscatedName("g")
   public int field3193 = 0;
   @ObfuscatedName("w")
   static int field3194 = 0;
   @ObfuscatedName("k")
   static int field3195 = 256;
   @ObfuscatedName("o")
   static int field3196 = 0;
   @ObfuscatedName("ad")
   static int field3197 = 0;
   @ObfuscatedName("l")
   byte[] field3198;
   @ObfuscatedName("aw")
   static String[] field3199 = new String[100];

   class222(byte[] var1) {
      this.method4049(var1);
   }

   @ObfuscatedName("a")
   void method4049(byte[] var1) {
      this.field3191 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3191.length; ++var2) {
            this.field3191[var2] = var1[var2] & 255;
         }

         this.field3193 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3191[var3] = var1[var2++] & 255;
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

         this.field3198 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3198[(var13 << 8) + var8] = (byte)method4139(var11, var12, var4, this.field3191, var10, var13, var8);
                  }
               }
            }
         }

         this.field3193 = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("f")
   int method4051(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3191[class120.method2749(var1) & 255];
   }

   @ObfuscatedName("s")
   public int method4052(String var1) {
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
                              int var8 = class109.method2432(var9, 10);
                              var4 += field3187[var8].field1422;
                              var3 = -1;
                           } catch (Exception var11) {
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
                  var4 += this.field3191[(char)(class120.method2749(var6) & 255)];
                  if(this.field3198 != null && var3 != -1) {
                     var4 += this.field3198[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("y")
   int method4053(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method4051('<');
                     if(this.field3198 != null && var11 != -1) {
                        var4 += this.field3198[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method4051('>');
                     if(this.field3198 != null && var11 != -1) {
                        var4 += this.field3198[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = class109.method2432(var18, 10);
                        var4 += field3187[var17].field1422;
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
                     var4 += this.method4051(var15);
                     if(this.field3198 != null && var11 != -1) {
                        var4 += this.field3198[(var11 << 8) + var15];
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

   @ObfuscatedName("e")
   public int method4054(String var1, int var2) {
      int var3 = this.method4053(var1, new int[]{var2}, field3199);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method4052(field3199[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("g")
   public int method4055(String var1, int var2) {
      return this.method4053(var1, new int[]{var2}, field3199);
   }

   @ObfuscatedName("j")
   public void method4057(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4065(var4, var5);
         this.method4080(var1, var2, var3);
      }
   }

   @ObfuscatedName("n")
   public void method4058(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4065(var4, var5);
         this.method4080(var1, var2 - this.method4052(var1), var3);
      }
   }

   @ObfuscatedName("l")
   public void method4059(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4065(var4, var5);
         this.method4080(var1, var2 - this.method4052(var1) / 2, var3);
      }
   }

   @ObfuscatedName("i")
   public void method4061(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4065(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4094(var1, var2 - this.method4052(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("v")
   public void method4062(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4065(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4094(var1, var2 - this.method4052(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("z")
   public void method4063(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method4065(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method4094(var1, var2 - this.method4052(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("u")
   public void method4064(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4065(var4, var5);
         field3183.setSeed((long)var6);
         field3195 = 192 + (field3183.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3183.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method4094(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("t")
   void method4065(int var1, int var2) {
      field3189 = -1;
      field3190 = -1;
      field3178 = var2;
      field3192 = var2;
      field3184 = var1;
      field3194 = var1;
      field3195 = 256;
      field3196 = 0;
      field3197 = 0;
   }

   @ObfuscatedName("b")
   void method4066(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3194 = class100.method2291(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3194 = field3184;
         } else if(var1.startsWith("str=")) {
            field3189 = class100.method2291(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3189 = 8388608;
         } else if(var1.equals("/str")) {
            field3189 = -1;
         } else if(var1.startsWith("u=")) {
            field3190 = class100.method2291(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3190 = 0;
         } else if(var1.equals("/u")) {
            field3190 = -1;
         } else if(var1.startsWith("shad=")) {
            field3192 = class100.method2291(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3192 = 0;
         } else if(var1.equals("/shad")) {
            field3192 = field3178;
         } else if(var1.equals("br")) {
            this.method4065(field3184, field3178);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("c")
   void method4067(String var1, int var2) {
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
         field3196 = (var2 - this.method4052(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("p")
   abstract void vmethod4143(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("k")
   static void method4073(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("o")
   static void method4074(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class79.field1412;
      int var8 = class79.field1412 - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class79.field1409) {
         var11 = class79.field1409 - var2;
         var4 -= var11;
         var2 = class79.field1409;
         var10 += var11 * var3;
         var7 += var11 * class79.field1412;
      }

      if(var2 + var4 > class79.field1413) {
         var4 -= var2 + var4 - class79.field1413;
      }

      if(var1 < class79.field1414) {
         var11 = class79.field1414 - var1;
         var3 -= var11;
         var1 = class79.field1414;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class79.field1415) {
         var11 = var1 + var3 - class79.field1415;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method4075(class79.field1410, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("ad")
   static void method4075(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("x")
   void method4080(String var1, int var2, int var3) {
      var3 -= this.field3193;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class120.method2749(var1.charAt(var6)) & 255);
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
                              String var15 = var8.substring(4);
                              var9 = class109.method2432(var15, 10);
                              class80 var12 = field3187[var9];
                              var12.method1883(var2, var3 + this.field3193 - var12.field1416);
                              var2 += var12.field1422;
                              var5 = -1;
                           } catch (Exception var13) {
                              ;
                           }
                        } else {
                           this.method4066(var8);
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
                  if(this.field3198 != null && var5 != -1) {
                     var2 += this.field3198[(var5 << 8) + var7];
                  }

                  int var14 = this.field3180[var7];
                  var9 = this.field3181[var7];
                  if(var7 != 32) {
                     if(field3195 == 256) {
                        if(field3192 != -1) {
                           method4112(this.field3185[var7], var2 + this.field3182[var7] + 1, var3 + this.field3188[var7] + 1, var14, var9, field3192);
                        }

                        this.vmethod4143(this.field3185[var7], var2 + this.field3182[var7], var3 + this.field3188[var7], var14, var9, field3194);
                     } else {
                        if(field3192 != -1) {
                           method4074(this.field3185[var7], var2 + this.field3182[var7] + 1, var3 + this.field3188[var7] + 1, var14, var9, field3192, field3195);
                        }

                        this.vmethod4145(this.field3185[var7], var2 + this.field3182[var7], var3 + this.field3188[var7], var14, var9, field3194, field3195);
                     }
                  } else if(field3196 > 0) {
                     field3197 += field3196;
                     var2 += field3197 >> 8;
                     field3197 &= 255;
                  }

                  int var10 = this.field3191[var7];
                  if(field3189 != -1) {
                     class79.method1864(var2, var3 + (int)((double)this.field3193 * 0.7D), var10, field3189);
                  }

                  if(field3190 != -1) {
                     class79.method1864(var2, var3 + this.field3193 + 1, var10, field3190);
                  }

                  var2 += var10;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   abstract void vmethod4145(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("d")
   void method4094(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3193;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class120.method2749(var1.charAt(var9)) & 255);
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
                              String var20 = var11.substring(4);
                              var14 = class109.method2432(var20, 10);
                              class80 var17 = field3187[var14];
                              var17.method1883(var2 + var12, var3 + this.field3193 - var17.field1416 + var13);
                              var2 += var17.field1422;
                              var7 = -1;
                           } catch (Exception var18) {
                              ;
                           }
                        } else {
                           this.method4066(var11);
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
                  if(this.field3198 != null && var7 != -1) {
                     var2 += this.field3198[(var7 << 8) + var10];
                  }

                  int var19 = this.field3180[var10];
                  var12 = this.field3181[var10];
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
                     if(field3195 == 256) {
                        if(field3192 != -1) {
                           method4112(this.field3185[var10], var2 + this.field3182[var10] + 1 + var13, var3 + this.field3188[var10] + 1 + var14, var19, var12, field3192);
                        }

                        this.vmethod4143(this.field3185[var10], var2 + this.field3182[var10] + var13, var3 + this.field3188[var10] + var14, var19, var12, field3194);
                     } else {
                        if(field3192 != -1) {
                           method4074(this.field3185[var10], var2 + this.field3182[var10] + 1 + var13, var3 + this.field3188[var10] + 1 + var14, var19, var12, field3192, field3195);
                        }

                        this.vmethod4145(this.field3185[var10], var2 + this.field3182[var10] + var13, var3 + this.field3188[var10] + var14, var19, var12, field3194, field3195);
                     }
                  } else if(field3196 > 0) {
                     field3197 += field3196;
                     var2 += field3197 >> 8;
                     field3197 &= 255;
                  }

                  int var15 = this.field3191[var10];
                  if(field3189 != -1) {
                     class79.method1864(var2, var3 + (int)((double)this.field3193 * 0.7D), var15, field3189);
                  }

                  if(field3190 != -1) {
                     class79.method1864(var2, var3 + this.field3193, var15, field3190);
                  }

                  var2 += var15;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   public int method4095(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method4065(var6, var7);
         if(var10 == 0) {
            var10 = this.field3193;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3179 + this.field3186 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method4053(var1, var11, field3199);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3179;
         } else if(var9 == 1) {
            var13 = var3 + this.field3179 + (var5 - this.field3179 - this.field3186 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3186 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3179 - this.field3186 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3179 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method4080(field3199[var14], var2, var13);
            } else if(var8 == 1) {
               this.method4080(field3199[var14], var2 + (var4 - this.method4052(field3199[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method4080(field3199[var14], var2 + var4 - this.method4052(field3199[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method4080(field3199[var14], var2, var13);
            } else {
               this.method4067(field3199[var14], var4);
               this.method4080(field3199[var14], var2, var13);
               field3196 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("w")
   static void method4112(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class79.field1412;
      int var7 = class79.field1412 - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class79.field1409) {
         var10 = class79.field1409 - var2;
         var4 -= var10;
         var2 = class79.field1409;
         var9 += var10 * var3;
         var6 += var10 * class79.field1412;
      }

      if(var2 + var4 > class79.field1413) {
         var4 -= var2 + var4 - class79.field1413;
      }

      if(var1 < class79.field1414) {
         var10 = class79.field1414 - var1;
         var3 -= var10;
         var1 = class79.field1414;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class79.field1415) {
         var10 = var1 + var3 - class79.field1415;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4073(class79.field1410, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   class222(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3182 = var2;
      this.field3188 = var3;
      this.field3180 = var4;
      this.field3181 = var5;
      this.method4049(var1);
      this.field3185 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3188[var10] < var8 && this.field3181[var10] != 0) {
            var8 = this.field3188[var10];
         }

         if(this.field3188[var10] + this.field3181[var10] > var9) {
            var9 = this.field3188[var10] + this.field3181[var10];
         }
      }

      this.field3179 = this.field3193 - var8;
      this.field3186 = var9 - this.field3193;
   }

   @ObfuscatedName("m")
   public static String method4130(String var0) {
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

   @ObfuscatedName("r")
   static int method4139(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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
}
