import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public abstract class class223 extends class79 {
   @ObfuscatedName("h")
   int[] field3186;
   @ObfuscatedName("i")
   int[] field3187;
   @ObfuscatedName("e")
   static int field3188 = 0;
   @ObfuscatedName("ad")
   static int field3189 = 0;
   @ObfuscatedName("z")
   int[] field3190;
   @ObfuscatedName("r")
   int[] field3191;
   @ObfuscatedName("t")
   byte[][] field3192 = new byte[256][];
   @ObfuscatedName("f")
   public int field3193 = 0;
   @ObfuscatedName("d")
   int field3194;
   @ObfuscatedName("l")
   @Export("modIcons")
   public static class80[] field3195;
   @ObfuscatedName("s")
   int field3196;
   @ObfuscatedName("p")
   static int field3197 = -1;
   @ObfuscatedName("n")
   static int field3198 = -1;
   @ObfuscatedName("q")
   static int field3199 = -1;
   @ObfuscatedName("x")
   static int field3200 = -1;
   @ObfuscatedName("y")
   byte[] field3201;
   @ObfuscatedName("m")
   static int field3202 = 0;
   @ObfuscatedName("v")
   static int field3203 = 0;
   @ObfuscatedName("g")
   int[] field3204;
   @ObfuscatedName("ag")
   static String[] field3205 = new String[100];
   @ObfuscatedName("as")
   static Random field3206 = new Random();
   @ObfuscatedName("w")
   static int field3207 = 256;

   @ObfuscatedName("x")
   abstract void vmethod4065(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   class223(byte[] var1) {
      this.method3960(var1);
   }

   @ObfuscatedName("t")
   void method3960(byte[] var1) {
      this.field3187 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3187.length; ++var2) {
            this.field3187[var2] = var1[var2] & 255;
         }

         this.field3193 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3187[var3] = var1[var2++] & 255;
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

         this.field3201 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3201[(var13 << 8) + var8] = (byte)method4001(var11, var12, var4, this.field3187, var10, var13, var8);
                  }
               }
            }
         }

         this.field3193 = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("g")
   int method3962(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3187[class13.method143(var1) & 255];
   }

   @ObfuscatedName("h")
   public int method3963(String var1) {
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
                              int var8 = class77.method1660(var7.substring(4));
                              var4 += field3195[var8].field1426;
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
                  var4 += this.field3187[(char)(class13.method143(var6) & 255)];
                  if(this.field3201 != null && var3 != -1) {
                     var4 += this.field3201[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   int method3964(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method3962('<');
                     if(this.field3201 != null && var11 != -1) {
                        var4 += this.field3201[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method3962('>');
                     if(this.field3201 != null && var11 != -1) {
                        var4 += this.field3201[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        int var17 = class77.method1660(var16.substring(4));
                        var4 += field3195[var17].field1426;
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
                     var4 += this.method3962(var15);
                     if(this.field3201 != null && var11 != -1) {
                        var4 += this.field3201[(var11 << 8) + var15];
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3966(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4012(var4, var5);
         this.method3979(var1, var2 - this.method3963(var1), var3);
      }
   }

   @ObfuscatedName("s")
   public static String method3967(String var0) {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "0"
   )
   public void method3968(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4012(var4, var5);
         this.method3979(var1, var2, var3);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3970(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4012(var4, var5);
         this.method3979(var1, var2 - this.method3963(var1) / 2, var3);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIII)V",
      garbageValue = "0"
   )
   public void method3972(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4012(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3980(var1, var2 - this.method3963(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIIII)V",
      garbageValue = "0"
   )
   public void method3974(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method4012(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method3980(var1, var2 - this.method3963(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("u")
   void method3975(String var1) {
      try {
         int var2;
         String var3;
         if(var1.startsWith("col=")) {
            var3 = var1.substring(4);
            var2 = class110.method2387(var3, 16, true);
            field3202 = var2;
         } else if(var1.equals("/col")) {
            field3202 = field3203;
         } else if(var1.startsWith("str=")) {
            var3 = var1.substring(4);
            var2 = class110.method2387(var3, 16, true);
            field3197 = var2;
         } else if(var1.equals("str")) {
            field3197 = 8388608;
         } else if(var1.equals("/str")) {
            field3197 = -1;
         } else if(var1.startsWith("u=")) {
            var3 = var1.substring(2);
            var2 = class110.method2387(var3, 16, true);
            field3198 = var2;
         } else if(var1.equals("u")) {
            field3198 = 0;
         } else if(var1.equals("/u")) {
            field3198 = -1;
         } else if(var1.startsWith("shad=")) {
            var3 = var1.substring(5);
            var2 = class110.method2387(var3, 16, true);
            field3200 = var2;
         } else if(var1.equals("shad")) {
            field3200 = 0;
         } else if(var1.equals("/shad")) {
            field3200 = field3199;
         } else if(var1.equals("br")) {
            this.method4012(field3203, field3199);
         }
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("c")
   void method3978(String var1, int var2) {
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
         field3188 = (var2 - this.method3963(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("n")
   void method3979(String var1, int var2, int var3) {
      var3 -= this.field3193;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class13.method143(var1.charAt(var6)) & 255);
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
                              var9 = class77.method1660(var8.substring(4));
                              class80 var10 = field3195[var9];
                              var10.method1822(var2, var3 + this.field3193 - var10.field1422);
                              var2 += var10.field1426;
                              var5 = -1;
                           } catch (Exception var14) {
                              ;
                           }
                        } else {
                           this.method3975(var8);
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
                  if(this.field3201 != null && var5 != -1) {
                     var2 += this.field3201[(var5 << 8) + var7];
                  }

                  int var12 = this.field3204[var7];
                  var9 = this.field3186[var7];
                  if(var7 != 32) {
                     if(field3207 == 256) {
                        if(field3200 != -1) {
                           method3983(this.field3192[var7], var2 + this.field3190[var7] + 1, var3 + this.field3191[var7] + 1, var12, var9, field3200);
                        }

                        this.vmethod4065(this.field3192[var7], var2 + this.field3190[var7], var3 + this.field3191[var7], var12, var9, field3202);
                     } else {
                        if(field3200 != -1) {
                           method4043(this.field3192[var7], var2 + this.field3190[var7] + 1, var3 + this.field3191[var7] + 1, var12, var9, field3200, field3207);
                        }

                        this.vmethod4062(this.field3192[var7], var2 + this.field3190[var7], var3 + this.field3191[var7], var12, var9, field3202, field3207);
                     }
                  } else if(field3188 > 0) {
                     field3189 += field3188;
                     var2 += field3189 >> 8;
                     field3189 &= 255;
                  }

                  int var13 = this.field3187[var7];
                  if(field3197 != -1) {
                     class79.method1759(var2, var3 + (int)((double)this.field3193 * 0.7D), var13, field3197);
                  }

                  if(field3198 != -1) {
                     class79.method1759(var2, var3 + this.field3193 + 1, var13, field3198);
                  }

                  var2 += var13;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   void method3980(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3193;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class13.method143(var1.charAt(var9)) & 255);
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
                              var14 = class77.method1660(var11.substring(4));
                              class80 var15 = field3195[var14];
                              var15.method1822(var2 + var12, var3 + this.field3193 - var15.field1422 + var13);
                              var2 += var15.field1426;
                              var7 = -1;
                           } catch (Exception var19) {
                              ;
                           }
                        } else {
                           this.method3975(var11);
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
                  if(this.field3201 != null && var7 != -1) {
                     var2 += this.field3201[(var7 << 8) + var10];
                  }

                  int var17 = this.field3204[var10];
                  var12 = this.field3186[var10];
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
                     if(field3207 == 256) {
                        if(field3200 != -1) {
                           method3983(this.field3192[var10], var2 + this.field3190[var10] + 1 + var13, var3 + this.field3191[var10] + 1 + var14, var17, var12, field3200);
                        }

                        this.vmethod4065(this.field3192[var10], var2 + this.field3190[var10] + var13, var3 + this.field3191[var10] + var14, var17, var12, field3202);
                     } else {
                        if(field3200 != -1) {
                           method4043(this.field3192[var10], var2 + this.field3190[var10] + 1 + var13, var3 + this.field3191[var10] + 1 + var14, var17, var12, field3200, field3207);
                        }

                        this.vmethod4062(this.field3192[var10], var2 + this.field3190[var10] + var13, var3 + this.field3191[var10] + var14, var17, var12, field3202, field3207);
                     }
                  } else if(field3188 > 0) {
                     field3189 += field3188;
                     var2 += field3189 >> 8;
                     field3189 &= 255;
                  }

                  int var18 = this.field3187[var10];
                  if(field3197 != -1) {
                     class79.method1759(var2, var3 + (int)((double)this.field3193 * 0.7D), var18, field3197);
                  }

                  if(field3198 != -1) {
                     class79.method1759(var2, var3 + this.field3193, var18, field3198);
                  }

                  var2 += var18;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   public int method3981(String var1, int var2) {
      return this.method3964(var1, new int[]{var2}, field3205);
   }

   @ObfuscatedName("v")
   abstract void vmethod4062(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("m")
   static void method3983(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class79.field1421;
      int var7 = class79.field1421 - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class79.field1416) {
         var10 = class79.field1416 - var2;
         var4 -= var10;
         var2 = class79.field1416;
         var9 += var10 * var3;
         var6 += var10 * class79.field1421;
      }

      if(var2 + var4 > class79.field1419) {
         var4 -= var2 + var4 - class79.field1419;
      }

      if(var1 < class79.field1420) {
         var10 = class79.field1420 - var1;
         var3 -= var10;
         var1 = class79.field1420;
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
         method3984(class79.field1418, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("w")
   static void method3984(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIIIIIII)I",
      garbageValue = "0"
   )
   public int method3985(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method4012(var6, var7);
         if(var10 == 0) {
            var10 = this.field3193;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3196 + this.field3194 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3964(var1, var11, field3205);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3196;
         } else if(var9 == 1) {
            var13 = var3 + this.field3196 + (var5 - this.field3196 - this.field3194 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3194 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3196 - this.field3194 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3196 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method3979(field3205[var14], var2, var13);
            } else if(var8 == 1) {
               this.method3979(field3205[var14], var2 + (var4 - this.method3963(field3205[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method3979(field3205[var14], var2 + var4 - this.method3963(field3205[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method3979(field3205[var14], var2, var13);
            } else {
               this.method3978(field3205[var14], var4);
               this.method3979(field3205[var14], var2, var13);
               field3188 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("ad")
   static void method3986(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("i")
   static int method4001(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIII)V",
      garbageValue = "16777215"
   )
   public void method4002(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4012(var4, var5);
         field3206.setSeed((long)var6);
         field3207 = 192 + (field3206.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3206.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method3980(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("a")
   void method4012(int var1, int var2) {
      field3197 = -1;
      field3198 = -1;
      field3199 = var2;
      field3200 = var2;
      field3203 = var1;
      field3202 = var1;
      field3207 = 256;
      field3188 = 0;
      field3189 = 0;
   }

   @ObfuscatedName("r")
   public int method4019(String var1, int var2) {
      int var3 = this.method3964(var1, new int[]{var2}, field3205);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3963(field3205[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   class223(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3190 = var2;
      this.field3191 = var3;
      this.field3204 = var4;
      this.field3186 = var5;
      this.method3960(var1);
      this.field3192 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3191[var10] < var8 && this.field3186[var10] != 0) {
            var8 = this.field3191[var10];
         }

         if(this.field3191[var10] + this.field3186[var10] > var9) {
            var9 = this.field3191[var10] + this.field3186[var10];
         }
      }

      this.field3196 = this.field3193 - var8;
      this.field3194 = var9 - this.field3193;
   }

   @ObfuscatedName("e")
   static void method4043(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class79.field1421;
      int var8 = class79.field1421 - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class79.field1416) {
         var11 = class79.field1416 - var2;
         var4 -= var11;
         var2 = class79.field1416;
         var10 += var11 * var3;
         var7 += var11 * class79.field1421;
      }

      if(var2 + var4 > class79.field1419) {
         var4 -= var2 + var4 - class79.field1419;
      }

      if(var1 < class79.field1420) {
         var11 = class79.field1420 - var1;
         var3 -= var11;
         var1 = class79.field1420;
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
         method3986(class79.field1418, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIII)V",
      garbageValue = "0"
   )
   public void method4055(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4012(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3980(var1, var2 - this.method3963(var1) / 2, var3, var7, var8);
      }
   }
}
