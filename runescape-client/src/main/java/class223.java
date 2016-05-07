import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public abstract class class223 extends class79 {
   @ObfuscatedName("j")
   int[] field3188;
   @ObfuscatedName("o")
   public int field3189 = 0;
   @ObfuscatedName("l")
   byte[] field3190;
   @ObfuscatedName("x")
   int[] field3191;
   @ObfuscatedName("c")
   public static class80[] field3192;
   @ObfuscatedName("ad")
   static Random field3193 = new Random();
   @ObfuscatedName("s")
   byte[][] field3194 = new byte[256][];
   @ObfuscatedName("b")
   int field3195;
   @ObfuscatedName("k")
   int field3196;
   @ObfuscatedName("u")
   int[] field3197;
   @ObfuscatedName("n")
   static int field3198 = 256;
   @ObfuscatedName("t")
   static int field3199 = -1;
   @ObfuscatedName("w")
   static int field3200 = -1;
   @ObfuscatedName("g")
   static int field3201 = -1;
   @ObfuscatedName("y")
   static int field3202 = -1;
   @ObfuscatedName("f")
   static int field3203 = 0;
   @ObfuscatedName("q")
   static int field3204 = 0;
   @ObfuscatedName("d")
   int[] field3205;
   @ObfuscatedName("v")
   static int field3206 = 0;
   @ObfuscatedName("ab")
   static int field3207 = 0;
   @ObfuscatedName("p")
   int[] field3208;
   @ObfuscatedName("an")
   static String[] field3209 = new String[100];

   class223(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3205 = var2;
      this.field3197 = var3;
      this.field3208 = var4;
      this.field3191 = var5;
      this.method3994(var1);
      this.field3194 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3197[var10] < var8 && this.field3191[var10] != 0) {
            var8 = this.field3197[var10];
         }

         if(this.field3197[var10] + this.field3191[var10] > var9) {
            var9 = this.field3197[var10] + this.field3191[var10];
         }
      }

      this.field3195 = this.field3189 - var8;
      this.field3196 = var9 - this.field3189;
   }

   @ObfuscatedName("s")
   void method3994(byte[] var1) {
      this.field3188 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3188.length; ++var2) {
            this.field3188[var2] = var1[var2] & 255;
         }

         this.field3189 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3188[var3] = var1[var2++] & 255;
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

         this.field3190 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3190[(var13 << 8) + var8] = (byte)method3995(var11, var12, var4, this.field3188, var10, var13, var8);
                  }
               }
            }
         }

         this.field3189 = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("j")
   static int method3995(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIIII)V",
      garbageValue = "0"
   )
   public void method3996(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method4010(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method4014(var1, var2 - this.method3997(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("x")
   public int method3997(String var1) {
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
                              int var8 = class121.method2729(var9, 10, true);
                              var4 += field3192[var8].field1425;
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
                  var4 += this.field3188[(char)(class94.method2145(var6) & 255)];
                  if(this.field3190 != null && var3 != -1) {
                     var4 += this.field3190[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   int method3998(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method4053('<');
                     if(this.field3190 != null && var11 != -1) {
                        var4 += this.field3190[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method4053('>');
                     if(this.field3190 != null && var11 != -1) {
                        var4 += this.field3190[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = class121.method2729(var18, 10, true);
                        var4 += field3192[var17].field1425;
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
                     var4 += this.method4053(var15);
                     if(this.field3190 != null && var11 != -1) {
                        var4 += this.field3190[(var11 << 8) + var15];
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

   @ObfuscatedName("o")
   public int method4000(String var1, int var2) {
      return this.method3998(var1, new int[]{var2}, field3209);
   }

   @ObfuscatedName("b")
   public static String method4001(String var0) {
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "0"
   )
   public void method4002(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4010(var4, var5);
         this.method4013(var1, var2, var3);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4003(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4010(var4, var5);
         this.method4013(var1, var2 - this.method3997(var1), var3);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4004(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4010(var4, var5);
         this.method4013(var1, var2 - this.method3997(var1) / 2, var3);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIIIIIII)I",
      garbageValue = "-1"
   )
   public int method4005(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method4010(var6, var7);
         if(var10 == 0) {
            var10 = this.field3189;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3195 + this.field3196 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3998(var1, var11, field3209);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3195;
         } else if(var9 == 1) {
            var13 = var3 + this.field3195 + (var5 - this.field3195 - this.field3196 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3196 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3195 - this.field3196 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3195 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method4013(field3209[var14], var2, var13);
            } else if(var8 == 1) {
               this.method4013(field3209[var14], var2 + (var4 - this.method3997(field3209[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method4013(field3209[var14], var2 + var4 - this.method3997(field3209[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method4013(field3209[var14], var2, var13);
            } else {
               this.method4012(field3209[var14], var4);
               this.method4013(field3209[var14], var2, var13);
               field3206 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIII)V",
      garbageValue = "0"
   )
   public void method4006(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4010(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4014(var1, var2 - this.method3997(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIII)V",
      garbageValue = "0"
   )
   public void method4007(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4010(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4014(var1, var2 - this.method3997(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("y")
   abstract void vmethod4093(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIIII)V",
      garbageValue = "16777215"
   )
   public void method4009(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4010(var4, var5);
         field3193.setSeed((long)var6);
         field3198 = 192 + (field3193.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3193.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method4014(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("h")
   void method4010(int var1, int var2) {
      field3199 = -1;
      field3200 = -1;
      field3201 = var2;
      field3202 = var2;
      field3203 = var1;
      field3204 = var1;
      field3198 = 256;
      field3206 = 0;
      field3207 = 0;
   }

   @ObfuscatedName("z")
   void method4011(String var1) {
      try {
         int var2;
         String var3;
         if(var1.startsWith("col=")) {
            var3 = var1.substring(4);
            var2 = class121.method2729(var3, 16, true);
            field3204 = var2;
         } else if(var1.equals("/col")) {
            field3204 = field3203;
         } else if(var1.startsWith("str=")) {
            var3 = var1.substring(4);
            var2 = class121.method2729(var3, 16, true);
            field3199 = var2;
         } else if(var1.equals("str")) {
            field3199 = 8388608;
         } else if(var1.equals("/str")) {
            field3199 = -1;
         } else if(var1.startsWith("u=")) {
            var3 = var1.substring(2);
            var2 = class121.method2729(var3, 16, true);
            field3200 = var2;
         } else if(var1.equals("u")) {
            field3200 = 0;
         } else if(var1.equals("/u")) {
            field3200 = -1;
         } else if(var1.startsWith("shad=")) {
            var3 = var1.substring(5);
            var2 = class121.method2729(var3, 16, true);
            field3202 = var2;
         } else if(var1.equals("shad")) {
            field3202 = 0;
         } else if(var1.equals("/shad")) {
            field3202 = field3201;
         } else if(var1.equals("br")) {
            this.method4010(field3203, field3201);
         }
      } catch (Exception var4) {
         ;
      }

   }

   @ObfuscatedName("a")
   void method4012(String var1, int var2) {
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
         field3206 = (var2 - this.method3997(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("w")
   void method4013(String var1, int var2, int var3) {
      var3 -= this.field3189;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class94.method2145(var1.charAt(var6)) & 255);
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
                              var9 = class121.method2729(var15, 10, true);
                              class80 var12 = field3192[var9];
                              var12.method1841(var2, var3 + this.field3189 - var12.field1432);
                              var2 += var12.field1425;
                              var5 = -1;
                           } catch (Exception var13) {
                              ;
                           }
                        } else {
                           this.method4011(var8);
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
                  if(this.field3190 != null && var5 != -1) {
                     var2 += this.field3190[(var5 << 8) + var7];
                  }

                  int var14 = this.field3208[var7];
                  var9 = this.field3191[var7];
                  if(var7 != 32) {
                     if(field3198 == 256) {
                        if(field3202 != -1) {
                           method4033(this.field3194[var7], var2 + this.field3205[var7] + 1, var3 + this.field3197[var7] + 1, var14, var9, field3202);
                        }

                        this.vmethod4093(this.field3194[var7], var2 + this.field3205[var7], var3 + this.field3197[var7], var14, var9, field3204);
                     } else {
                        if(field3202 != -1) {
                           method4019(this.field3194[var7], var2 + this.field3205[var7] + 1, var3 + this.field3197[var7] + 1, var14, var9, field3202, field3198);
                        }

                        this.vmethod4094(this.field3194[var7], var2 + this.field3205[var7], var3 + this.field3197[var7], var14, var9, field3204, field3198);
                     }
                  } else if(field3206 > 0) {
                     field3207 += field3206;
                     var2 += field3207 >> 8;
                     field3207 &= 255;
                  }

                  int var10 = this.field3188[var7];
                  if(field3199 != -1) {
                     class79.method1781(var2, var3 + (int)((double)this.field3189 * 0.7D), var10, field3199);
                  }

                  if(field3200 != -1) {
                     class79.method1781(var2, var3 + this.field3189 + 1, var10, field3200);
                  }

                  var2 += var10;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   void method4014(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3189;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class94.method2145(var1.charAt(var9)) & 255);
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
                              var14 = class121.method2729(var20, 10, true);
                              class80 var17 = field3192[var14];
                              var17.method1841(var2 + var12, var3 + this.field3189 - var17.field1432 + var13);
                              var2 += var17.field1425;
                              var7 = -1;
                           } catch (Exception var18) {
                              ;
                           }
                        } else {
                           this.method4011(var11);
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
                  if(this.field3190 != null && var7 != -1) {
                     var2 += this.field3190[(var7 << 8) + var10];
                  }

                  int var19 = this.field3208[var10];
                  var12 = this.field3191[var10];
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
                     if(field3198 == 256) {
                        if(field3202 != -1) {
                           method4033(this.field3194[var10], var2 + this.field3205[var10] + 1 + var13, var3 + this.field3197[var10] + 1 + var14, var19, var12, field3202);
                        }

                        this.vmethod4093(this.field3194[var10], var2 + this.field3205[var10] + var13, var3 + this.field3197[var10] + var14, var19, var12, field3204);
                     } else {
                        if(field3202 != -1) {
                           method4019(this.field3194[var10], var2 + this.field3205[var10] + 1 + var13, var3 + this.field3197[var10] + 1 + var14, var19, var12, field3202, field3198);
                        }

                        this.vmethod4094(this.field3194[var10], var2 + this.field3205[var10] + var13, var3 + this.field3197[var10] + var14, var19, var12, field3204, field3198);
                     }
                  } else if(field3206 > 0) {
                     field3207 += field3206;
                     var2 += field3207 >> 8;
                     field3207 &= 255;
                  }

                  int var15 = this.field3188[var10];
                  if(field3199 != -1) {
                     class79.method1781(var2, var3 + (int)((double)this.field3189 * 0.7D), var15, field3199);
                  }

                  if(field3200 != -1) {
                     class79.method1781(var2, var3 + this.field3189, var15, field3200);
                  }

                  var2 += var15;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   abstract void vmethod4094(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("v")
   static void method4019(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class79.field1419;
      int var8 = class79.field1419 - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class79.field1423) {
         var11 = class79.field1423 - var2;
         var4 -= var11;
         var2 = class79.field1423;
         var10 += var11 * var3;
         var7 += var11 * class79.field1419;
      }

      if(var2 + var4 > class79.field1421) {
         var4 -= var2 + var4 - class79.field1421;
      }

      if(var1 < class79.field1418) {
         var11 = class79.field1418 - var1;
         var3 -= var11;
         var1 = class79.field1418;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class79.field1424) {
         var11 = var1 + var3 - class79.field1424;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method4020(class79.field1420, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("ab")
   static void method4020(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("u")
   public int method4023(String var1, int var2) {
      int var3 = this.method3998(var1, new int[]{var2}, field3209);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3997(field3209[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("q")
   static void method4033(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class79.field1419;
      int var7 = class79.field1419 - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class79.field1423) {
         var10 = class79.field1423 - var2;
         var4 -= var10;
         var2 = class79.field1423;
         var9 += var10 * var3;
         var6 += var10 * class79.field1419;
      }

      if(var2 + var4 > class79.field1421) {
         var4 -= var2 + var4 - class79.field1421;
      }

      if(var1 < class79.field1418) {
         var10 = class79.field1418 - var1;
         var3 -= var10;
         var1 = class79.field1418;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class79.field1424) {
         var10 = var1 + var3 - class79.field1424;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4088(class79.field1420, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("p")
   int method4053(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3188[class94.method2145(var1) & 255];
   }

   class223(byte[] var1) {
      this.method3994(var1);
   }

   @ObfuscatedName("n")
   static void method4088(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
}
