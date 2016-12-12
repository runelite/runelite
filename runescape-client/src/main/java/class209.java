import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public abstract class class209 extends class219 {
   @ObfuscatedName("p")
   static int field3091 = -1;
   @ObfuscatedName("e")
   int[] field3092;
   @ObfuscatedName("f")
   int[] field3093;
   @ObfuscatedName("k")
   int[] field3094;
   @ObfuscatedName("v")
   @Export("modIcons")
   public static ModIcon[] modIcons;
   @ObfuscatedName("l")
   static int field3096 = -1;
   @ObfuscatedName("a")
   public int field3097 = 0;
   @ObfuscatedName("q")
   public int field3098;
   @ObfuscatedName("w")
   public int field3099;
   @ObfuscatedName("u")
   static int field3100 = 0;
   @ObfuscatedName("h")
   byte[] field3101;
   @ObfuscatedName("g")
   int[] field3102;
   @ObfuscatedName("r")
   static int field3103 = 0;
   @ObfuscatedName("c")
   static int field3104 = -1;
   @ObfuscatedName("n")
   int[] field3105;
   @ObfuscatedName("d")
   static int field3106 = 0;
   @ObfuscatedName("m")
   static int field3107 = -1;
   @ObfuscatedName("j")
   static int field3108 = 256;
   @ObfuscatedName("x")
   static int field3109 = 0;
   @ObfuscatedName("i")
   byte[][] field3110 = new byte[256][];
   @ObfuscatedName("y")
   static Random field3111 = new Random();
   @ObfuscatedName("s")
   static String[] field3112 = new String[100];

   class209(byte[] var1) {
      this.method3772(var1);
   }

   @ObfuscatedName("v")
   void method3772(byte[] var1) {
      this.field3092 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3092.length; ++var2) {
            this.field3092[var2] = var1[var2] & 255;
         }

         this.field3097 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3092[var3] = var1[var2++] & 255;
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

         byte[][] var12 = new byte[256][];

         int var8;
         for(int var6 = 0; var6 < 256; ++var6) {
            var12[var6] = new byte[var11[var6]];
            byte var7 = 0;

            for(var8 = 0; var8 < var12[var6].length; ++var8) {
               var7 += var1[var2++];
               var12[var6][var8] = var7;
            }
         }

         byte[][] var10 = new byte[256][];

         int var13;
         for(var13 = 0; var13 < 256; ++var13) {
            var10[var13] = new byte[var11[var13]];
            byte var14 = 0;

            for(int var9 = 0; var9 < var10[var13].length; ++var9) {
               var14 += var1[var2++];
               var10[var13][var9] = var14;
            }
         }

         this.field3101 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3101[(var13 << 8) + var8] = (byte)method3816(var12, var10, var4, this.field3092, var11, var13, var8);
                  }
               }
            }
         }

         this.field3097 = var4[32] + var11[32];
      }

   }

   @ObfuscatedName("s")
   public int method3773(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method3788(var6, var7);
         if(var10 == 0) {
            var10 = this.field3097;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3098 + this.field3099 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3843(var1, var11, field3112);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3098;
         } else if(var9 == 1) {
            var13 = var3 + this.field3098 + (var5 - this.field3098 - this.field3099 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3099 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3098 - this.field3099 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3098 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method3791(field3112[var14], var2, var13);
            } else if(var8 == 1) {
               this.method3791(field3112[var14], var2 + (var4 - this.method3774(field3112[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method3791(field3112[var14], var2 + var4 - this.method3774(field3112[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method3791(field3112[var14], var2, var13);
            } else {
               this.method3790(field3112[var14], var4);
               this.method3791(field3112[var14], var2, var13);
               field3109 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   class209(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3102 = var2;
      this.field3105 = var3;
      this.field3093 = var4;
      this.field3094 = var5;
      this.method3772(var1);
      this.field3110 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3105[var10] < var8 && this.field3094[var10] != 0) {
            var8 = this.field3105[var10];
         }

         if(this.field3105[var10] + this.field3094[var10] > var9) {
            var9 = this.field3105[var10] + this.field3094[var10];
         }
      }

      this.field3098 = this.field3097 - var8;
      this.field3099 = var9 - this.field3097;
   }

   @ObfuscatedName("l")
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
                              int var8 = class177.method3191(var7.substring(4));
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
                  var4 += this.field3092[(char)(class162.method3009(var6) & 255)];
                  if(this.field3101 != null && var3 != -1) {
                     var4 += this.field3101[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   public static String method3778(String var0) {
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "0"
   )
   public void method3779(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3788(var4, var5);
         this.method3791(var1, var2, var3);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3781(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3788(var4, var5);
         this.method3791(var1, var2 - this.method3774(var1), var3);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3782(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3788(var4, var5);
         this.method3791(var1, var2 - this.method3774(var1) / 2, var3);
      }
   }

   @ObfuscatedName("t")
   public void method3784(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3788(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3792(var1, var2 - this.method3774(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("b")
   public void method3786(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method3788(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method3792(var1, var2 - this.method3774(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("o")
   public void method3787(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3788(var4, var5);
         field3111.setSeed((long)var6);
         field3108 = 192 + (field3111.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3111.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method3792(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("ak")
   void method3788(int var1, int var2) {
      field3091 = -1;
      field3096 = -1;
      field3104 = var2;
      field3107 = var2;
      field3103 = var1;
      field3100 = var1;
      field3108 = 256;
      field3109 = 0;
      field3106 = 0;
   }

   @ObfuscatedName("ai")
   void method3789(String var1) {
      try {
         int var2;
         String var3;
         if(var1.startsWith("col=")) {
            var3 = var1.substring(4);
            var2 = class146.method2699(var3, 16, true);
            field3100 = var2;
         } else if(var1.equals("/col")) {
            field3100 = field3103;
         } else if(var1.startsWith("str=")) {
            var3 = var1.substring(4);
            var2 = class146.method2699(var3, 16, true);
            field3091 = var2;
         } else if(var1.equals("str")) {
            field3091 = 8388608;
         } else if(var1.equals("/str")) {
            field3091 = -1;
         } else if(var1.startsWith("u=")) {
            var3 = var1.substring(2);
            var2 = class146.method2699(var3, 16, true);
            field3096 = var2;
         } else if(var1.equals("u")) {
            field3096 = 0;
         } else if(var1.equals("/u")) {
            field3096 = -1;
         } else if(var1.startsWith("shad=")) {
            var3 = var1.substring(5);
            var2 = class146.method2699(var3, 16, true);
            field3107 = var2;
         } else if(var1.equals("shad")) {
            field3107 = 0;
         } else if(var1.equals("/shad")) {
            field3107 = field3104;
         } else if(var1.equals("br")) {
            this.method3788(field3103, field3104);
         }
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("aq")
   void method3790(String var1, int var2) {
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
         field3109 = (var2 - this.method3774(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("an")
   void method3791(String var1, int var2, int var3) {
      var3 -= this.field3097;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class162.method3009(var1.charAt(var6)) & 255);
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
                              var9 = class177.method3191(var8.substring(4));
                              ModIcon var10 = modIcons[var9];
                              var10.method3979(var2, var3 + this.field3097 - var10.originalHeight);
                              var2 += var10.width;
                              var5 = -1;
                           } catch (Exception var14) {
                              ;
                           }
                        } else {
                           this.method3789(var8);
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
                  if(this.field3101 != null && var5 != -1) {
                     var2 += this.field3101[(var5 << 8) + var7];
                  }

                  int var12 = this.field3093[var7];
                  var9 = this.field3094[var7];
                  if(var7 != 32) {
                     if(field3108 == 256) {
                        if(field3107 != -1) {
                           method3795(this.field3110[var7], var2 + this.field3102[var7] + 1, var3 + this.field3105[var7] + 1, var12, var9, field3107);
                        }

                        this.vmethod3793(this.field3110[var7], var2 + this.field3102[var7], var3 + this.field3105[var7], var12, var9, field3100);
                     } else {
                        if(field3107 != -1) {
                           method3809(this.field3110[var7], var2 + this.field3102[var7] + 1, var3 + this.field3105[var7] + 1, var12, var9, field3107, field3108);
                        }

                        this.vmethod3794(this.field3110[var7], var2 + this.field3102[var7], var3 + this.field3105[var7], var12, var9, field3100, field3108);
                     }
                  } else if(field3109 > 0) {
                     field3106 += field3109;
                     var2 += field3106 >> 8;
                     field3106 &= 255;
                  }

                  int var13 = this.field3092[var7];
                  if(field3091 != -1) {
                     class219.method3886(var2, var3 + (int)((double)this.field3097 * 0.7D), var13, field3091);
                  }

                  if(field3096 != -1) {
                     class219.method3886(var2, var3 + this.field3097 + 1, var13, field3096);
                  }

                  var2 += var13;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("ay")
   void method3792(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3097;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class162.method3009(var1.charAt(var9)) & 255);
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
                              var14 = class177.method3191(var11.substring(4));
                              ModIcon var15 = modIcons[var14];
                              var15.method3979(var2 + var12, var3 + this.field3097 - var15.originalHeight + var13);
                              var2 += var15.width;
                              var7 = -1;
                           } catch (Exception var19) {
                              ;
                           }
                        } else {
                           this.method3789(var11);
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
                  if(this.field3101 != null && var7 != -1) {
                     var2 += this.field3101[(var7 << 8) + var10];
                  }

                  int var17 = this.field3093[var10];
                  var12 = this.field3094[var10];
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
                     if(field3108 == 256) {
                        if(field3107 != -1) {
                           method3795(this.field3110[var10], var2 + this.field3102[var10] + 1 + var13, var3 + this.field3105[var10] + 1 + var14, var17, var12, field3107);
                        }

                        this.vmethod3793(this.field3110[var10], var2 + this.field3102[var10] + var13, var3 + this.field3105[var10] + var14, var17, var12, field3100);
                     } else {
                        if(field3107 != -1) {
                           method3809(this.field3110[var10], var2 + this.field3102[var10] + 1 + var13, var3 + this.field3105[var10] + 1 + var14, var17, var12, field3107, field3108);
                        }

                        this.vmethod3794(this.field3110[var10], var2 + this.field3102[var10] + var13, var3 + this.field3105[var10] + var14, var17, var12, field3100, field3108);
                     }
                  } else if(field3109 > 0) {
                     field3106 += field3109;
                     var2 += field3106 >> 8;
                     field3106 &= 255;
                  }

                  int var18 = this.field3092[var10];
                  if(field3091 != -1) {
                     class219.method3886(var2, var3 + (int)((double)this.field3097 * 0.7D), var18, field3091);
                  }

                  if(field3096 != -1) {
                     class219.method3886(var2, var3 + this.field3097, var18, field3096);
                  }

                  var2 += var18;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   abstract void vmethod3793(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("e")
   abstract void vmethod3794(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("ap")
   static void method3795(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
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

      if(var2 + var4 > class219.field3177) {
         var4 -= var2 + var4 - class219.field3177;
      }

      if(var1 < class219.field3176) {
         var10 = class219.field3176 - var1;
         var3 -= var10;
         var1 = class219.field3176;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class219.field3174) {
         var10 = var1 + var3 - class219.field3174;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method3796(class219.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("aj")
   static void method3796(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("r")
   public int method3797(String var1, int var2) {
      return this.method3843(var1, new int[]{var2}, field3112);
   }

   @ObfuscatedName("am")
   static void method3798(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("m")
   public int method3799(String var1, int var2) {
      int var3 = this.method3843(var1, new int[]{var2}, field3112);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3774(field3112[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("aw")
   static void method3809(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
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

      if(var2 + var4 > class219.field3177) {
         var4 -= var2 + var4 - class219.field3177;
      }

      if(var1 < class219.field3176) {
         var11 = class219.field3176 - var1;
         var3 -= var11;
         var1 = class219.field3176;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class219.field3174) {
         var11 = var1 + var3 - class219.field3174;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method3798(class219.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("h")
   static int method3816(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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
   public void method3838(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3788(var4, var5);
         field3108 = var6;
         this.method3791(var1, var2, var3);
      }
   }

   @ObfuscatedName("c")
   int method3843(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method3847('<');
                     if(this.field3101 != null && var11 != -1) {
                        var4 += this.field3101[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method3847('>');
                     if(this.field3101 != null && var11 != -1) {
                        var4 += this.field3101[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        int var17 = class177.method3191(var16.substring(4));
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
                     var4 += this.method3847(var15);
                     if(this.field3101 != null && var11 != -1) {
                        var4 += this.field3101[(var11 << 8) + var15];
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

   @ObfuscatedName("p")
   int method3847(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3092[class162.method3009(var1) & 255];
   }

   @ObfuscatedName("z")
   public void method3849(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3788(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3792(var1, var2 - this.method3774(var1) / 2, var3, var7, var8);
      }
   }
}
