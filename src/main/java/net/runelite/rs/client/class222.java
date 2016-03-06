package net.runelite.rs.client;
import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hv")
public abstract class class222 extends class79 {
   @ObfuscatedName("m")
   int[] field3176;
   @ObfuscatedName("l")
   int[] field3177;
   @ObfuscatedName("k")
   public static class80[] field3178;
   @ObfuscatedName("a")
   int[] field3179;
   @ObfuscatedName("e")
   static int field3180 = 256;
   @ObfuscatedName("f")
   int[] field3181;
   @ObfuscatedName("o")
   public int field3182 = 0;
   @ObfuscatedName("h")
   int field3183;
   @ObfuscatedName("n")
   int field3184;
   @ObfuscatedName("j")
   byte[][] field3185 = new byte[256][];
   @ObfuscatedName("r")
   byte[] field3186;
   @ObfuscatedName("w")
   static int field3187 = -1;
   @ObfuscatedName("p")
   static int field3188 = -1;
   @ObfuscatedName("b")
   static int field3189 = -1;
   @ObfuscatedName("t")
   static int field3190 = -1;
   @ObfuscatedName("c")
   static int field3191 = 0;
   @ObfuscatedName("x")
   static int field3192 = 0;
   @ObfuscatedName("ab")
   static int field3193 = 0;
   @ObfuscatedName("v")
   static int field3194 = 0;
   @ObfuscatedName("i")
   int[] field3195;
   @ObfuscatedName("ak")
   static Random field3196 = new Random();
   @ObfuscatedName("am")
   static String[] field3197 = new String[100];

   class222(byte[] var1) {
      this.method3959(var1);
   }

   @ObfuscatedName("j")
   void method3959(byte[] var1) {
      this.field3177 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3177.length; ++var2) {
            this.field3177[var2] = var1[var2] & 255;
         }

         this.field3182 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3177[var3] = var1[var2++] & 255;
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

         this.field3186 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3186[(var13 << 8) + var8] = (byte)method3974(var11, var12, var4, this.field3177, var10, var13, var8);
                  }
               }
            }
         }

         this.field3182 = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("q")
   public void method3960(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3975(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3979(var1, var2 - this.method3962(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("a")
   int method3961(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3177[class29.method663(var1) & 255];
   }

   @ObfuscatedName("i")
   public int method3962(String var1) {
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
                              int var8 = class106.method2339(var7.substring(4));
                              var4 += field3178[var8].field1435;
                              var3 = -1;
                           } catch (Exception var9) {
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
                  var4 += this.field3177[(char)(class29.method663(var6) & 255)];
                  if(this.field3186 != null && var3 != -1) {
                     var4 += this.field3186[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("f")
   int method3963(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method3961('<');
                     if(this.field3186 != null && var11 != -1) {
                        var4 += this.field3186[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method3961('>');
                     if(this.field3186 != null && var11 != -1) {
                        var4 += this.field3186[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        int var17 = class106.method2339(var16.substring(4));
                        var4 += field3178[var17].field1435;
                        var11 = 0;
                     } catch (Exception var18) {
                        ;
                     }
                  }

                  var15 = 0;
               }

               if(var10 == -1) {
                  if(var15 != 0) {
                     var6.append(var15);
                     var4 += this.method3961(var15);
                     if(this.field3186 != null && var11 != -1) {
                        var4 += this.field3186[(var11 << 8) + var15];
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

   @ObfuscatedName("m")
   public int method3964(String var1, int var2) {
      int var3 = this.method3963(var1, new int[]{var2}, field3197);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3962(field3197[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("o")
   public int method3965(String var1, int var2) {
      return this.method3963(var1, new int[]{var2}, field3197);
   }

   @ObfuscatedName("h")
   public static String method3966(String var0) {
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

   @ObfuscatedName("n")
   public void method3967(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3975(var4, var5);
         this.method3978(var1, var2, var3);
      }
   }

   @ObfuscatedName("k")
   public void method3968(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3975(var4, var5);
         this.method3978(var1, var2 - this.method3962(var1), var3);
      }
   }

   @ObfuscatedName("b")
   public int method3970(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method3975(var6, var7);
         if(var10 == 0) {
            var10 = this.field3182;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3183 + this.field3184 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3963(var1, var11, field3197);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3183;
         } else if(var9 == 1) {
            var13 = var3 + this.field3183 + (var5 - this.field3183 - this.field3184 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3184 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3183 - this.field3184 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3183 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method3978(field3197[var14], var2, var13);
            } else if(var8 == 1) {
               this.method3978(field3197[var14], var2 + (var4 - this.method3962(field3197[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method3978(field3197[var14], var2 + var4 - this.method3962(field3197[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method3978(field3197[var14], var2, var13);
            } else {
               this.method3977(field3197[var14], var4);
               this.method3978(field3197[var14], var2, var13);
               field3194 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("u")
   public void method3972(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3975(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3979(var1, var2 - this.method3962(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("g")
   public void method3973(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method3975(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method3979(var1, var2 - this.method3962(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("l")
   static int method3974(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("s")
   void method3975(int var1, int var2) {
      field3189 = -1;
      field3188 = -1;
      field3187 = var2;
      field3190 = var2;
      field3191 = var1;
      field3192 = var1;
      field3180 = 256;
      field3194 = 0;
      field3193 = 0;
   }

   @ObfuscatedName("z")
   void method3977(String var1, int var2) {
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
         field3194 = (var2 - this.method3962(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("p")
   void method3978(String var1, int var2, int var3) {
      var3 -= this.field3182;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class29.method663(var1.charAt(var6)) & 255);
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
                              var9 = class106.method2339(var8.substring(4));
                              class80 var13 = field3178[var9];
                              var13.method1838(var2, var3 + this.field3182 - var13.field1436);
                              var2 += var13.field1435;
                              var5 = -1;
                           } catch (Exception var11) {
                              ;
                           }
                        } else {
                           this.method3988(var8);
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
                  if(this.field3186 != null && var5 != -1) {
                     var2 += this.field3186[(var5 << 8) + var7];
                  }

                  int var12 = this.field3179[var7];
                  var9 = this.field3195[var7];
                  if(var7 != 32) {
                     if(field3180 == 256) {
                        if(field3190 != -1) {
                           method3982(this.field3185[var7], var2 + this.field3181[var7] + 1, var3 + this.field3176[var7] + 1, var12, var9, field3190);
                        }

                        this.vmethod4056(this.field3185[var7], var2 + this.field3181[var7], var3 + this.field3176[var7], var12, var9, field3192);
                     } else {
                        if(field3190 != -1) {
                           method3984(this.field3185[var7], var2 + this.field3181[var7] + 1, var3 + this.field3176[var7] + 1, var12, var9, field3190, field3180);
                        }

                        this.vmethod4053(this.field3185[var7], var2 + this.field3181[var7], var3 + this.field3176[var7], var12, var9, field3192, field3180);
                     }
                  } else if(field3194 > 0) {
                     field3193 += field3194;
                     var2 += field3193 >> 8;
                     field3193 &= 255;
                  }

                  int var10 = this.field3177[var7];
                  if(field3189 != -1) {
                     class79.method1780(var2, var3 + (int)((double)this.field3182 * 0.7D), var10, field3189);
                  }

                  if(field3188 != -1) {
                     class79.method1780(var2, var3 + this.field3182 + 1, var10, field3188);
                  }

                  var2 += var10;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   void method3979(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3182;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class29.method663(var1.charAt(var9)) & 255);
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
                              var14 = class106.method2339(var11.substring(4));
                              class80 var18 = field3178[var14];
                              var18.method1838(var2 + var12, var3 + this.field3182 - var18.field1436 + var13);
                              var2 += var18.field1435;
                              var7 = -1;
                           } catch (Exception var16) {
                              ;
                           }
                        } else {
                           this.method3988(var11);
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
                  if(this.field3186 != null && var7 != -1) {
                     var2 += this.field3186[(var7 << 8) + var10];
                  }

                  int var17 = this.field3179[var10];
                  var12 = this.field3195[var10];
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
                     if(field3180 == 256) {
                        if(field3190 != -1) {
                           method3982(this.field3185[var10], var2 + this.field3181[var10] + 1 + var13, var3 + this.field3176[var10] + 1 + var14, var17, var12, field3190);
                        }

                        this.vmethod4056(this.field3185[var10], var2 + this.field3181[var10] + var13, var3 + this.field3176[var10] + var14, var17, var12, field3192);
                     } else {
                        if(field3190 != -1) {
                           method3984(this.field3185[var10], var2 + this.field3181[var10] + 1 + var13, var3 + this.field3176[var10] + 1 + var14, var17, var12, field3190, field3180);
                        }

                        this.vmethod4053(this.field3185[var10], var2 + this.field3181[var10] + var13, var3 + this.field3176[var10] + var14, var17, var12, field3192, field3180);
                     }
                  } else if(field3194 > 0) {
                     field3193 += field3194;
                     var2 += field3193 >> 8;
                     field3193 &= 255;
                  }

                  int var15 = this.field3177[var10];
                  if(field3189 != -1) {
                     class79.method1780(var2, var3 + (int)((double)this.field3182 * 0.7D), var15, field3189);
                  }

                  if(field3188 != -1) {
                     class79.method1780(var2, var3 + this.field3182, var15, field3188);
                  }

                  var2 += var15;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   static void method3982(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class79.field1423;
      int var7 = class79.field1423 - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class79.field1425) {
         var10 = class79.field1425 - var2;
         var4 -= var10;
         var2 = class79.field1425;
         var9 += var10 * var3;
         var6 += var10 * class79.field1423;
      }

      if(var2 + var4 > class79.field1422) {
         var4 -= var2 + var4 - class79.field1422;
      }

      if(var1 < class79.field1427) {
         var10 = class79.field1427 - var1;
         var3 -= var10;
         var1 = class79.field1427;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class79.field1428) {
         var10 = var1 + var3 - class79.field1428;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4013(class79.field1426, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("v")
   static void method3984(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class79.field1423;
      int var8 = class79.field1423 - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class79.field1425) {
         var11 = class79.field1425 - var2;
         var4 -= var11;
         var2 = class79.field1425;
         var10 += var11 * var3;
         var7 += var11 * class79.field1423;
      }

      if(var2 + var4 > class79.field1422) {
         var4 -= var2 + var4 - class79.field1422;
      }

      if(var1 < class79.field1427) {
         var11 = class79.field1427 - var1;
         var3 -= var11;
         var1 = class79.field1427;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class79.field1428) {
         var11 = var1 + var3 - class79.field1428;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method3985(class79.field1426, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("ab")
   static void method3985(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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
   void method3988(String var1) {
      try {
         int var2;
         String var3;
         if(var1.startsWith("col=")) {
            var3 = var1.substring(4);
            var2 = class128.method2756(var3, 16);
            field3192 = var2;
         } else if(var1.equals("/col")) {
            field3192 = field3191;
         } else if(var1.startsWith("str=")) {
            var3 = var1.substring(4);
            var2 = class128.method2756(var3, 16);
            field3189 = var2;
         } else if(var1.equals("str")) {
            field3189 = 8388608;
         } else if(var1.equals("/str")) {
            field3189 = -1;
         } else if(var1.startsWith("u=")) {
            var3 = var1.substring(2);
            var2 = class128.method2756(var3, 16);
            field3188 = var2;
         } else if(var1.equals("u")) {
            field3188 = 0;
         } else if(var1.equals("/u")) {
            field3188 = -1;
         } else if(var1.startsWith("shad=")) {
            var3 = var1.substring(5);
            var2 = class128.method2756(var3, 16);
            field3190 = var2;
         } else if(var1.equals("shad")) {
            field3190 = 0;
         } else if(var1.equals("/shad")) {
            field3190 = field3187;
         } else if(var1.equals("br")) {
            this.method3975(field3191, field3187);
         }
      } catch (Exception var4) {
         ;
      }

   }

   @ObfuscatedName("c")
   abstract void vmethod4053(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("t")
   abstract void vmethod4056(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("y")
   public void method4006(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3975(var4, var5);
         field3196.setSeed((long)var6);
         field3180 = 192 + (field3196.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3196.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method3979(var1, var2, var3, var7, (int[])null);
      }
   }

   class222(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3181 = var2;
      this.field3176 = var3;
      this.field3179 = var4;
      this.field3195 = var5;
      this.method3959(var1);
      this.field3185 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3176[var10] < var8 && this.field3195[var10] != 0) {
            var8 = this.field3176[var10];
         }

         if(this.field3176[var10] + this.field3195[var10] > var9) {
            var9 = this.field3176[var10] + this.field3195[var10];
         }
      }

      this.field3183 = this.field3182 - var8;
      this.field3184 = var9 - this.field3182;
   }

   @ObfuscatedName("e")
   static void method4013(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
   public void method4039(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3975(var4, var5);
         this.method3978(var1, var2 - this.method3962(var1) / 2, var3);
      }
   }
}
