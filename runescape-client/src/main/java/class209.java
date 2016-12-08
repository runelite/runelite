import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public abstract class class209 extends class219 {
   @ObfuscatedName("p")
   static int field3096 = -1;
   @ObfuscatedName("m")
   int[] field3097;
   @ObfuscatedName("q")
   static String[] field3098 = new String[100];
   @ObfuscatedName("i")
   static int field3099 = 0;
   @ObfuscatedName("h")
   int[] field3100;
   @ObfuscatedName("v")
   int[] field3101;
   @ObfuscatedName("l")
   public int field3102 = 0;
   @ObfuscatedName("x")
   static int field3103 = 256;
   @ObfuscatedName("u")
   public int field3104;
   @ObfuscatedName("c")
   public int field3105;
   @ObfuscatedName("z")
   byte[] field3106;
   @ObfuscatedName("y")
   static int field3107 = -1;
   @ObfuscatedName("o")
   byte[][] field3108 = new byte[256][];
   @ObfuscatedName("f")
   static int field3109 = -1;
   @ObfuscatedName("b")
   int[] field3110;
   @ObfuscatedName("n")
   static Random field3111 = new Random();
   @ObfuscatedName("s")
   static int field3112 = 0;
   @ObfuscatedName("g")
   int[] field3113;
   @ObfuscatedName("d")
   static int field3114 = 0;
   @ObfuscatedName("w")
   static int field3115 = 0;
   @ObfuscatedName("j")
   static int field3116 = -1;
   @ObfuscatedName("k")
   @Export("modIcons")
   public static ModIcon[] modIcons;

   @ObfuscatedName("k")
   public int method3774(String var1) {
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
                              int var8 = FileOnDisk.method1403(var7.substring(4));
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
                  var4 += this.field3097[(char)(class0.method6(var6) & 255)];
                  if(this.field3106 != null && var3 != -1) {
                     var4 += this.field3106[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   void method3776(byte[] var1) {
      this.field3097 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3097.length; ++var2) {
            this.field3097[var2] = var1[var2] & 255;
         }

         this.field3102 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3097[var3] = var1[var2++] & 255;
         }

         int[] var12 = new int[256];
         int[] var4 = new int[256];

         int var5;
         for(var5 = 0; var5 < 256; ++var5) {
            var12[var5] = var1[var2++] & 255;
         }

         for(var5 = 0; var5 < 256; ++var5) {
            var4[var5] = var1[var2++] & 255;
         }

         byte[][] var10 = new byte[256][];

         int var8;
         for(int var6 = 0; var6 < 256; ++var6) {
            var10[var6] = new byte[var12[var6]];
            byte var7 = 0;

            for(var8 = 0; var8 < var10[var6].length; ++var8) {
               var7 += var1[var2++];
               var10[var6][var8] = var7;
            }
         }

         byte[][] var11 = new byte[256][];

         int var13;
         for(var13 = 0; var13 < 256; ++var13) {
            var11[var13] = new byte[var12[var13]];
            byte var14 = 0;

            for(int var9 = 0; var9 < var11[var13].length; ++var9) {
               var14 += var1[var2++];
               var11[var13][var9] = var14;
            }
         }

         this.field3106 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3106[(var13 << 8) + var8] = (byte)method3777(var10, var11, var4, this.field3097, var12, var13, var8);
                  }
               }
            }
         }

         this.field3102 = var4[32] + var12[32];
      }

   }

   @ObfuscatedName("c")
   static int method3777(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("i")
   public void method3780(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3832(var4, var5);
         field3103 = var6;
         this.method3802(var1, var2, var3);
      }
   }

   @ObfuscatedName("y")
   public int method3781(String var1, int var2) {
      int var3 = this.method3821(var1, new int[]{var2}, field3098);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3774(field3098[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("f")
   public static String method3783(String var0) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3784(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3832(var4, var5);
         this.method3802(var1, var2, var3);
      }
   }

   @ObfuscatedName("u")
   int method3785(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3097[class0.method6(var1) & 255];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3786(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3832(var4, var5);
         this.method3802(var1, var2 - this.method3774(var1), var3);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3787(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3832(var4, var5);
         this.method3802(var1, var2 - this.method3774(var1) / 2, var3);
      }
   }

   @ObfuscatedName("av")
   static void method3788(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("w")
   public void method3789(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3832(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3795(var1, var2 - this.method3774(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("q")
   public void method3790(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method3832(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method3795(var1, var2 - this.method3774(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("t")
   public void method3791(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3832(var4, var5);
         field3111.setSeed((long)var6);
         field3103 = 192 + (field3111.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3111.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method3795(var1, var2, var3, var7, (int[])null);
      }
   }

   class209(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3100 = var2;
      this.field3101 = var3;
      this.field3110 = var4;
      this.field3113 = var5;
      this.method3776(var1);
      this.field3108 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3101[var10] < var8 && this.field3113[var10] != 0) {
            var8 = this.field3101[var10];
         }

         if(this.field3101[var10] + this.field3113[var10] > var9) {
            var9 = this.field3101[var10] + this.field3113[var10];
         }
      }

      this.field3105 = this.field3102 - var8;
      this.field3104 = var9 - this.field3102;
   }

   @ObfuscatedName("e")
   void method3793(String var1, int var2) {
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
         field3114 = (var2 - this.method3774(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("ag")
   void method3795(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3102;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class0.method6(var1.charAt(var9)) & 255);
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
                              var14 = FileOnDisk.method1403(var11.substring(4));
                              ModIcon var15 = modIcons[var14];
                              var15.method3995(var2 + var12, var3 + this.field3102 - var15.originalHeight + var13);
                              var2 += var15.width;
                              var7 = -1;
                           } catch (Exception var19) {
                              ;
                           }
                        } else {
                           this.method3803(var11);
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
                  if(this.field3106 != null && var7 != -1) {
                     var2 += this.field3106[(var7 << 8) + var10];
                  }

                  int var17 = this.field3110[var10];
                  var12 = this.field3113[var10];
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
                     if(field3103 == 256) {
                        if(field3096 != -1) {
                           method3798(this.field3108[var10], var2 + this.field3100[var10] + 1 + var13, var3 + this.field3101[var10] + 1 + var14, var17, var12, field3096);
                        }

                        this.vmethod3796(this.field3108[var10], var2 + this.field3100[var10] + var13, var3 + this.field3101[var10] + var14, var17, var12, field3112);
                     } else {
                        if(field3096 != -1) {
                           method3800(this.field3108[var10], var2 + this.field3100[var10] + 1 + var13, var3 + this.field3101[var10] + 1 + var14, var17, var12, field3096, field3103);
                        }

                        this.vmethod3801(this.field3108[var10], var2 + this.field3100[var10] + var13, var3 + this.field3101[var10] + var14, var17, var12, field3112, field3103);
                     }
                  } else if(field3114 > 0) {
                     field3115 += field3114;
                     var2 += field3115 >> 8;
                     field3115 &= 255;
                  }

                  int var18 = this.field3097[var10];
                  if(field3107 != -1) {
                     class219.method3907(var2, var3 + (int)((double)this.field3102 * 0.7D), var18, field3107);
                  }

                  if(field3116 != -1) {
                     class219.method3907(var2, var3 + this.field3102, var18, field3116);
                  }

                  var2 += var18;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   abstract void vmethod3796(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("au")
   static void method3798(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class219.graphicsPixelsWidth;
      int var7 = class219.graphicsPixelsWidth - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class219.field3171) {
         var10 = class219.field3171 - var2;
         var4 -= var10;
         var2 = class219.field3171;
         var9 += var10 * var3;
         var6 += var10 * class219.graphicsPixelsWidth;
      }

      if(var2 + var4 > class219.field3173) {
         var4 -= var2 + var4 - class219.field3173;
      }

      if(var1 < class219.field3175) {
         var10 = class219.field3175 - var1;
         var3 -= var10;
         var1 = class219.field3175;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class219.field3176) {
         var10 = var1 + var3 - class219.field3176;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method3799(class219.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("aa")
   static void method3799(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
   static void method3800(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class219.graphicsPixelsWidth;
      int var8 = class219.graphicsPixelsWidth - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class219.field3171) {
         var11 = class219.field3171 - var2;
         var4 -= var11;
         var2 = class219.field3171;
         var10 += var11 * var3;
         var7 += var11 * class219.graphicsPixelsWidth;
      }

      if(var2 + var4 > class219.field3173) {
         var4 -= var2 + var4 - class219.field3173;
      }

      if(var1 < class219.field3175) {
         var11 = class219.field3175 - var1;
         var3 -= var11;
         var1 = class219.field3175;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class219.field3176) {
         var11 = var1 + var3 - class219.field3176;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method3788(class219.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   class209(byte[] var1) {
      this.method3776(var1);
   }

   @ObfuscatedName("m")
   abstract void vmethod3801(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("am")
   void method3802(String var1, int var2, int var3) {
      var3 -= this.field3102;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class0.method6(var1.charAt(var6)) & 255);
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
                              var9 = FileOnDisk.method1403(var8.substring(4));
                              ModIcon var10 = modIcons[var9];
                              var10.method3995(var2, var3 + this.field3102 - var10.originalHeight);
                              var2 += var10.width;
                              var5 = -1;
                           } catch (Exception var14) {
                              ;
                           }
                        } else {
                           this.method3803(var8);
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
                  if(this.field3106 != null && var5 != -1) {
                     var2 += this.field3106[(var5 << 8) + var7];
                  }

                  int var12 = this.field3110[var7];
                  var9 = this.field3113[var7];
                  if(var7 != 32) {
                     if(field3103 == 256) {
                        if(field3096 != -1) {
                           method3798(this.field3108[var7], var2 + this.field3100[var7] + 1, var3 + this.field3101[var7] + 1, var12, var9, field3096);
                        }

                        this.vmethod3796(this.field3108[var7], var2 + this.field3100[var7], var3 + this.field3101[var7], var12, var9, field3112);
                     } else {
                        if(field3096 != -1) {
                           method3800(this.field3108[var7], var2 + this.field3100[var7] + 1, var3 + this.field3101[var7] + 1, var12, var9, field3096, field3103);
                        }

                        this.vmethod3801(this.field3108[var7], var2 + this.field3100[var7], var3 + this.field3101[var7], var12, var9, field3112, field3103);
                     }
                  } else if(field3114 > 0) {
                     field3115 += field3114;
                     var2 += field3115 >> 8;
                     field3115 &= 255;
                  }

                  int var13 = this.field3097[var7];
                  if(field3107 != -1) {
                     class219.method3907(var2, var3 + (int)((double)this.field3102 * 0.7D), var13, field3107);
                  }

                  if(field3116 != -1) {
                     class219.method3907(var2, var3 + this.field3102 + 1, var13, field3116);
                  }

                  var2 += var13;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   void method3803(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3112 = class157.method2951(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3112 = field3099;
         } else if(var1.startsWith("str=")) {
            field3107 = class157.method2951(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3107 = 8388608;
         } else if(var1.equals("/str")) {
            field3107 = -1;
         } else if(var1.startsWith("u=")) {
            field3116 = class157.method2951(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3116 = 0;
         } else if(var1.equals("/u")) {
            field3116 = -1;
         } else if(var1.startsWith("shad=")) {
            field3096 = class157.method2951(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3096 = 0;
         } else if(var1.equals("/shad")) {
            field3096 = field3109;
         } else if(var1.equals("br")) {
            this.method3832(field3099, field3109);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("j")
   public int method3816(String var1, int var2) {
      return this.method3821(var1, new int[]{var2}, field3098);
   }

   @ObfuscatedName("z")
   int method3821(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method3785('<');
                     if(this.field3106 != null && var11 != -1) {
                        var4 += this.field3106[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method3785('>');
                     if(this.field3106 != null && var11 != -1) {
                        var4 += this.field3106[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        int var17 = FileOnDisk.method1403(var16.substring(4));
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
                     var4 += this.method3785(var15);
                     if(this.field3106 != null && var11 != -1) {
                        var4 += this.field3106[(var11 << 8) + var15];
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
   public int method3827(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method3832(var6, var7);
         if(var10 == 0) {
            var10 = this.field3102;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3105 + this.field3104 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3821(var1, var11, field3098);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3105;
         } else if(var9 == 1) {
            var13 = var3 + this.field3105 + (var5 - this.field3105 - this.field3104 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3104 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3105 - this.field3104 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3105 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method3802(field3098[var14], var2, var13);
            } else if(var8 == 1) {
               this.method3802(field3098[var14], var2 + (var4 - this.method3774(field3098[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method3802(field3098[var14], var2 + var4 - this.method3774(field3098[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method3802(field3098[var14], var2, var13);
            } else {
               this.method3793(field3098[var14], var4);
               this.method3802(field3098[var14], var2, var13);
               field3114 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("r")
   void method3832(int var1, int var2) {
      field3107 = -1;
      field3116 = -1;
      field3109 = var2;
      field3096 = var2;
      field3099 = var1;
      field3112 = var1;
      field3103 = 256;
      field3114 = 0;
      field3115 = 0;
   }

   @ObfuscatedName("n")
   public void method3840(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3832(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3795(var1, var2 - this.method3774(var1) / 2, var3, var7, var8);
      }
   }
}
