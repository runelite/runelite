import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public abstract class class209 extends class219 {
   @ObfuscatedName("q")
   byte[] field3085;
   @ObfuscatedName("d")
   int[] field3086;
   @ObfuscatedName("m")
   int[] field3087;
   @ObfuscatedName("h")
   int[] field3088;
   @ObfuscatedName("w")
   int[] field3089;
   @ObfuscatedName("r")
   int[] field3090;
   @ObfuscatedName("c")
   public int field3091 = 0;
   @ObfuscatedName("p")
   public int field3092;
   @ObfuscatedName("l")
   static int field3093 = -1;
   @ObfuscatedName("z")
   @Export("modIcons")
   public static ModIcon[] modIcons;
   @ObfuscatedName("s")
   static int field3095 = 0;
   @ObfuscatedName("g")
   public int field3096;
   @ObfuscatedName("y")
   static int field3097 = -1;
   @ObfuscatedName("j")
   static String[] field3098 = new String[100];
   @ObfuscatedName("x")
   static int field3099 = -1;
   @ObfuscatedName("f")
   static int field3100 = 0;
   @ObfuscatedName("n")
   byte[][] field3101 = new byte[256][];
   @ObfuscatedName("o")
   static int field3102 = 256;
   @ObfuscatedName("i")
   static int field3103 = 0;
   @ObfuscatedName("a")
   static int field3104 = 0;
   @ObfuscatedName("b")
   static Random field3105 = new Random();
   @ObfuscatedName("e")
   static int field3106 = -1;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3907(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3951(var4, var5);
         this.method3929(var1, var2 - this.method3912(var1) / 2, var3);
      }
   }

   @ObfuscatedName("y")
   void method3909(byte[] var1) {
      this.field3086 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3086.length; ++var2) {
            this.field3086[var2] = var1[var2] & 255;
         }

         this.field3091 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3086[var3] = var1[var2++] & 255;
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

         this.field3085 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3085[(var13 << 8) + var8] = (byte)method3910(var11, var12, var4, this.field3086, var10, var13, var8);
                  }
               }
            }
         }

         this.field3091 = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("e")
   static int method3910(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("ag")
   static void method3911(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class219.graphicsPixelsWidth;
      int var7 = class219.graphicsPixelsWidth - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class219.field3168) {
         var10 = class219.field3168 - var2;
         var4 -= var10;
         var2 = class219.field3168;
         var9 += var10 * var3;
         var6 += var10 * class219.graphicsPixelsWidth;
      }

      if(var2 + var4 > class219.field3169) {
         var4 -= var2 + var4 - class219.field3169;
      }

      if(var1 < class219.field3165) {
         var10 = class219.field3165 - var1;
         var3 -= var10;
         var1 = class219.field3165;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class219.field3171) {
         var10 = var1 + var3 - class219.field3171;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4009(class219.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("f")
   public int method3912(String var1) {
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
                              int var8 = class28.method635(var7.substring(4));
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
                  var4 += this.field3086[(char)(class196.method3649(var6) & 255)];
                  if(this.field3085 != null && var3 != -1) {
                     var4 += this.field3085[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("s")
   int method3913(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method3940('<');
                     if(this.field3085 != null && var11 != -1) {
                        var4 += this.field3085[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method3940('>');
                     if(this.field3085 != null && var11 != -1) {
                        var4 += this.field3085[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        int var17 = class28.method635(var16.substring(4));
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
                     var4 += this.method3940(var15);
                     if(this.field3085 != null && var11 != -1) {
                        var4 += this.field3085[(var11 << 8) + var15];
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

   @ObfuscatedName("o")
   public int method3914(String var1, int var2) {
      int var3 = this.method3913(var1, new int[]{var2}, field3098);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3912(field3098[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("i")
   public int method3915(String var1, int var2) {
      return this.method3913(var1, new int[]{var2}, field3098);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "0"
   )
   public void method3920(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3951(var4, var5);
         this.method3929(var1, var2, var3);
      }
   }

   @ObfuscatedName("u")
   public int method3921(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method3951(var6, var7);
         if(var10 == 0) {
            var10 = this.field3091;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3092 + this.field3096 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3913(var1, var11, field3098);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3092;
         } else if(var9 == 1) {
            var13 = var3 + this.field3092 + (var5 - this.field3092 - this.field3096 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3096 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3092 - this.field3096 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3092 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method3929(field3098[var14], var2, var13);
            } else if(var8 == 1) {
               this.method3929(field3098[var14], var2 + (var4 - this.method3912(field3098[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method3929(field3098[var14], var2 + var4 - this.method3912(field3098[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method3929(field3098[var14], var2, var13);
            } else {
               this.method3928(field3098[var14], var4);
               this.method3929(field3098[var14], var2, var13);
               field3103 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("t")
   public void method3922(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3951(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3930(var1, var2 - this.method3912(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("av")
   public void method3923(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3951(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3930(var1, var2 - this.method3912(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("aw")
   public void method3924(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method3951(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method3930(var1, var2 - this.method3912(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("ay")
   public void method3925(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3951(var4, var5);
         field3105.setSeed((long)var6);
         field3102 = 192 + (field3105.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3105.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method3930(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("ai")
   void method3927(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3095 = class2.method33(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3095 = field3100;
         } else if(var1.startsWith("str=")) {
            field3093 = class2.method33(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3093 = 8388608;
         } else if(var1.equals("/str")) {
            field3093 = -1;
         } else if(var1.startsWith("u=")) {
            field3097 = class2.method33(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3097 = 0;
         } else if(var1.equals("/u")) {
            field3097 = -1;
         } else if(var1.startsWith("shad=")) {
            field3099 = class2.method33(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3099 = 0;
         } else if(var1.equals("/shad")) {
            field3099 = field3106;
         } else if(var1.equals("br")) {
            this.method3951(field3100, field3106);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("aq")
   void method3928(String var1, int var2) {
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
         field3103 = (var2 - this.method3912(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("ac")
   void method3929(String var1, int var2, int var3) {
      var3 -= this.field3091;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class196.method3649(var1.charAt(var6)) & 255);
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
                              var9 = class28.method635(var8.substring(4));
                              ModIcon var10 = modIcons[var9];
                              var10.method4146(var2, var3 + this.field3091 - var10.originalHeight);
                              var2 += var10.width;
                              var5 = -1;
                           } catch (Exception var14) {
                              ;
                           }
                        } else {
                           this.method3927(var8);
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
                  if(this.field3085 != null && var5 != -1) {
                     var2 += this.field3085[(var5 << 8) + var7];
                  }

                  int var12 = this.field3087[var7];
                  var9 = this.field3088[var7];
                  if(var7 != 32) {
                     if(field3102 == 256) {
                        if(field3099 != -1) {
                           method3911(this.field3101[var7], var2 + this.field3089[var7] + 1, var3 + this.field3090[var7] + 1, var12, var9, field3099);
                        }

                        this.vmethod3993(this.field3101[var7], var2 + this.field3089[var7], var3 + this.field3090[var7], var12, var9, field3095);
                     } else {
                        if(field3099 != -1) {
                           method3935(this.field3101[var7], var2 + this.field3089[var7] + 1, var3 + this.field3090[var7] + 1, var12, var9, field3099, field3102);
                        }

                        this.vmethod3932(this.field3101[var7], var2 + this.field3089[var7], var3 + this.field3090[var7], var12, var9, field3095, field3102);
                     }
                  } else if(field3103 > 0) {
                     field3104 += field3103;
                     var2 += field3104 >> 8;
                     field3104 &= 255;
                  }

                  int var13 = this.field3086[var7];
                  if(field3093 != -1) {
                     class219.method4055(var2, var3 + (int)((double)this.field3091 * 0.7D), var13, field3093);
                  }

                  if(field3097 != -1) {
                     class219.method4055(var2, var3 + this.field3091 + 1, var13, field3097);
                  }

                  var2 += var13;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("ae")
   void method3930(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3091;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class196.method3649(var1.charAt(var9)) & 255);
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
                              var14 = class28.method635(var11.substring(4));
                              ModIcon var15 = modIcons[var14];
                              var15.method4146(var2 + var12, var3 + this.field3091 - var15.originalHeight + var13);
                              var2 += var15.width;
                              var7 = -1;
                           } catch (Exception var19) {
                              ;
                           }
                        } else {
                           this.method3927(var11);
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
                  if(this.field3085 != null && var7 != -1) {
                     var2 += this.field3085[(var7 << 8) + var10];
                  }

                  int var17 = this.field3087[var10];
                  var12 = this.field3088[var10];
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
                     if(field3102 == 256) {
                        if(field3099 != -1) {
                           method3911(this.field3101[var10], var2 + this.field3089[var10] + 1 + var13, var3 + this.field3090[var10] + 1 + var14, var17, var12, field3099);
                        }

                        this.vmethod3993(this.field3101[var10], var2 + this.field3089[var10] + var13, var3 + this.field3090[var10] + var14, var17, var12, field3095);
                     } else {
                        if(field3099 != -1) {
                           method3935(this.field3101[var10], var2 + this.field3089[var10] + 1 + var13, var3 + this.field3090[var10] + 1 + var14, var17, var12, field3099, field3102);
                        }

                        this.vmethod3932(this.field3101[var10], var2 + this.field3089[var10] + var13, var3 + this.field3090[var10] + var14, var17, var12, field3095, field3102);
                     }
                  } else if(field3103 > 0) {
                     field3104 += field3103;
                     var2 += field3104 >> 8;
                     field3104 &= 255;
                  }

                  int var18 = this.field3086[var10];
                  if(field3093 != -1) {
                     class219.method4055(var2, var3 + (int)((double)this.field3091 * 0.7D), var18, field3093);
                  }

                  if(field3097 != -1) {
                     class219.method4055(var2, var3 + this.field3091, var18, field3097);
                  }

                  var2 += var18;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   abstract void vmethod3932(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3934(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3951(var4, var5);
         this.method3929(var1, var2 - this.method3912(var1), var3);
      }
   }

   @ObfuscatedName("af")
   static void method3935(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class219.graphicsPixelsWidth;
      int var8 = class219.graphicsPixelsWidth - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class219.field3168) {
         var11 = class219.field3168 - var2;
         var4 -= var11;
         var2 = class219.field3168;
         var10 += var11 * var3;
         var7 += var11 * class219.graphicsPixelsWidth;
      }

      if(var2 + var4 > class219.field3169) {
         var4 -= var2 + var4 - class219.field3169;
      }

      if(var1 < class219.field3165) {
         var11 = class219.field3165 - var1;
         var3 -= var11;
         var1 = class219.field3165;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class219.field3171) {
         var11 = var1 + var3 - class219.field3171;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method3937(class219.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("ap")
   static void method3937(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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
   int method3940(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3086[class196.method3649(var1) & 255];
   }

   @ObfuscatedName("as")
   void method3951(int var1, int var2) {
      field3093 = -1;
      field3097 = -1;
      field3106 = var2;
      field3099 = var2;
      field3100 = var1;
      field3095 = var1;
      field3102 = 256;
      field3103 = 0;
      field3104 = 0;
   }

   class209(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3089 = var2;
      this.field3090 = var3;
      this.field3087 = var4;
      this.field3088 = var5;
      this.method3909(var1);
      this.field3101 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3090[var10] < var8 && this.field3088[var10] != 0) {
            var8 = this.field3090[var10];
         }

         if(this.field3090[var10] + this.field3088[var10] > var9) {
            var9 = this.field3090[var10] + this.field3088[var10];
         }
      }

      this.field3092 = this.field3091 - var8;
      this.field3096 = var9 - this.field3091;
   }

   class209(byte[] var1) {
      this.method3909(var1);
   }

   @ObfuscatedName("j")
   public void method3972(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3951(var4, var5);
         field3102 = var6;
         this.method3929(var1, var2, var3);
      }
   }

   @ObfuscatedName("a")
   public static String method3979(String var0) {
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

   @ObfuscatedName("n")
   abstract void vmethod3993(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("am")
   static void method4009(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
