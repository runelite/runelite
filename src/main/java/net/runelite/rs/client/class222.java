package net.runelite.rs.client;

import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hk")
public abstract class class222 extends class79 {
   @ObfuscatedName("f")
   int[] field3167;
   @ObfuscatedName("m")
   int[] field3168;
   @ObfuscatedName("q")
   static int field3169 = -1;
   @ObfuscatedName("l")
   int[] field3170;
   @ObfuscatedName("j")
   byte[][] field3171 = new byte[256][];
   @ObfuscatedName("a")
   int[] field3172;
   @ObfuscatedName("u")
   int[] field3173;
   @ObfuscatedName("i")
   int field3174;
   @ObfuscatedName("as")
   static String[] field3175 = new String[100];
   @ObfuscatedName("c")
   static int field3176 = 256;
   @ObfuscatedName("s")
   byte[] field3177;
   @ObfuscatedName("w")
   static int field3178 = -1;
   @ObfuscatedName("v")
   static int field3179 = -1;
   @ObfuscatedName("t")
   int field3180;
   @ObfuscatedName("x")
   static int field3181 = -1;
   @ObfuscatedName("h")
   public int field3182 = 0;
   @ObfuscatedName("o")
   static int field3183 = 0;
   @ObfuscatedName("d")
   static int field3184 = 0;
   @ObfuscatedName("k")
   public static class80[] field3185;
   @ObfuscatedName("aa")
   static int field3186 = 0;
   @ObfuscatedName("ao")
   static Random field3187 = new Random();
   @ObfuscatedName("b")
   static int field3188 = 0;

   @ObfuscatedName("j")
   void method4068(byte[] var1) {
      this.field3168 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3168.length; ++var2) {
            this.field3168[var2] = var1[var2] & 255;
         }

         this.field3182 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3168[var3] = var1[var2++] & 255;
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

         this.field3177 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3177[(var13 << 8) + var8] = (byte)method4069(var11, var12, var4, this.field3168, var10, var13, var8);
                  }
               }
            }
         }

         this.field3182 = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("m")
   static int method4069(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("f")
   int method4070(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3168[class154.method3204(var1) & 255];
   }

   @ObfuscatedName("g")
   void method4071(int var1, int var2) {
      field3178 = -1;
      field3179 = -1;
      field3169 = var2;
      field3181 = var2;
      field3184 = var1;
      field3183 = var1;
      field3176 = 256;
      field3188 = 0;
      field3186 = 0;
   }

   @ObfuscatedName("u")
   int method4072(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method4070('<');
                     if(this.field3177 != null && var11 != -1) {
                        var4 += this.field3177[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method4070('>');
                     if(this.field3177 != null && var11 != -1) {
                        var4 += this.field3177[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = client.method585(var18, 10);
                        var4 += field3185[var17].field1413;
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
                     var4 += this.method4070(var15);
                     if(this.field3177 != null && var11 != -1) {
                        var4 += this.field3177[(var11 << 8) + var15];
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
   public void method4074(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4071(var4, var5);
         this.method4086(var1, var2, var3);
      }
   }

   class222(byte[] var1) {
      this.method4068(var1);
   }

   @ObfuscatedName("k")
   public void method4076(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4071(var4, var5);
         this.method4086(var1, var2 - this.method4161(var1), var3);
      }
   }

   @ObfuscatedName("s")
   public void method4077(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4071(var4, var5);
         this.method4086(var1, var2 - this.method4161(var1) / 2, var3);
      }
   }

   @ObfuscatedName("w")
   public int method4078(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method4071(var6, var7);
         if(var10 == 0) {
            var10 = this.field3182;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3174 + this.field3180 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method4072(var1, var11, field3175);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3174;
         } else if(var9 == 1) {
            var13 = var3 + this.field3174 + (var5 - this.field3174 - this.field3180 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3180 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3174 - this.field3180 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3174 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method4086(field3175[var14], var2, var13);
            } else if(var8 == 1) {
               this.method4086(field3175[var14], var2 + (var4 - this.method4161(field3175[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method4086(field3175[var14], var2 + var4 - this.method4161(field3175[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method4086(field3175[var14], var2, var13);
            } else {
               this.method4085(field3175[var14], var4);
               this.method4086(field3175[var14], var2, var13);
               field3188 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("e")
   public void method4079(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4071(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4093(var1, var2 - this.method4161(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("p")
   public void method4081(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method4071(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method4093(var1, var2 - this.method4161(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("r")
   public void method4082(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4071(var4, var5);
         field3187.setSeed((long)var6);
         field3176 = 192 + (field3187.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3187.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method4093(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("n")
   void method4084(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3183 = class24.method638(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3183 = field3184;
         } else if(var1.startsWith("str=")) {
            field3178 = class24.method638(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3178 = 8388608;
         } else if(var1.equals("/str")) {
            field3178 = -1;
         } else if(var1.startsWith("u=")) {
            field3179 = class24.method638(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3179 = 0;
         } else if(var1.equals("/u")) {
            field3179 = -1;
         } else if(var1.startsWith("shad=")) {
            field3181 = class24.method638(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3181 = 0;
         } else if(var1.equals("/shad")) {
            field3181 = field3169;
         } else if(var1.equals("br")) {
            this.method4071(field3184, field3169);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("y")
   void method4085(String var1, int var2) {
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
         field3188 = (var2 - this.method4161(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("v")
   void method4086(String var1, int var2, int var3) {
      var3 -= this.field3182;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class154.method3204(var1.charAt(var6)) & 255);
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
                              var9 = client.method585(var15, 10);
                              class80 var12 = field3185[var9];
                              var12.method1881(var2, var3 + this.field3182 - var12.field1414);
                              var2 += var12.field1413;
                              var5 = -1;
                           } catch (Exception var13) {
                              ;
                           }
                        } else {
                           this.method4084(var8);
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
                  if(this.field3177 != null && var5 != -1) {
                     var2 += this.field3177[(var5 << 8) + var7];
                  }

                  int var14 = this.field3167[var7];
                  var9 = this.field3170[var7];
                  if(var7 != 32) {
                     if(field3176 == 256) {
                        if(field3181 != -1) {
                           method4112(this.field3171[var7], var2 + this.field3173[var7] + 1, var3 + this.field3172[var7] + 1, var14, var9, field3181);
                        }

                        this.vmethod4164(this.field3171[var7], var2 + this.field3173[var7], var3 + this.field3172[var7], var14, var9, field3183);
                     } else {
                        if(field3181 != -1) {
                           method4092(this.field3171[var7], var2 + this.field3173[var7] + 1, var3 + this.field3172[var7] + 1, var14, var9, field3181, field3176);
                        }

                        this.vmethod4166(this.field3171[var7], var2 + this.field3173[var7], var3 + this.field3172[var7], var14, var9, field3183, field3176);
                     }
                  } else if(field3188 > 0) {
                     field3186 += field3188;
                     var2 += field3186 >> 8;
                     field3186 &= 255;
                  }

                  int var10 = this.field3168[var7];
                  if(field3178 != -1) {
                     class79.method1831(var2, var3 + (int)((double)this.field3182 * 0.7D), var10, field3178);
                  }

                  if(field3179 != -1) {
                     class79.method1831(var2, var3 + this.field3182 + 1, var10, field3179);
                  }

                  var2 += var10;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   public int method4087(String var1, int var2) {
      return this.method4072(var1, new int[]{var2}, field3175);
   }

   @ObfuscatedName("x")
   abstract void vmethod4164(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("d")
   abstract void vmethod4166(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("c")
   static void method4091(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("b")
   static void method4092(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class79.field1401;
      int var8 = class79.field1401 - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class79.field1403) {
         var11 = class79.field1403 - var2;
         var4 -= var11;
         var2 = class79.field1403;
         var10 += var11 * var3;
         var7 += var11 * class79.field1401;
      }

      if(var2 + var4 > class79.field1402) {
         var4 -= var2 + var4 - class79.field1402;
      }

      if(var1 < class79.field1405) {
         var11 = class79.field1405 - var1;
         var3 -= var11;
         var1 = class79.field1405;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class79.field1400) {
         var11 = var1 + var3 - class79.field1400;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method4127(class79.field1406, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("q")
   void method4093(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3182;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class154.method3204(var1.charAt(var9)) & 255);
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
                              var14 = client.method585(var20, 10);
                              class80 var17 = field3185[var14];
                              var17.method1881(var2 + var12, var3 + this.field3182 - var17.field1414 + var13);
                              var2 += var17.field1413;
                              var7 = -1;
                           } catch (Exception var18) {
                              ;
                           }
                        } else {
                           this.method4084(var11);
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
                  if(this.field3177 != null && var7 != -1) {
                     var2 += this.field3177[(var7 << 8) + var10];
                  }

                  int var19 = this.field3167[var10];
                  var12 = this.field3170[var10];
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
                     if(field3176 == 256) {
                        if(field3181 != -1) {
                           method4112(this.field3171[var10], var2 + this.field3173[var10] + 1 + var13, var3 + this.field3172[var10] + 1 + var14, var19, var12, field3181);
                        }

                        this.vmethod4164(this.field3171[var10], var2 + this.field3173[var10] + var13, var3 + this.field3172[var10] + var14, var19, var12, field3183);
                     } else {
                        if(field3181 != -1) {
                           method4092(this.field3171[var10], var2 + this.field3173[var10] + 1 + var13, var3 + this.field3172[var10] + 1 + var14, var19, var12, field3181, field3176);
                        }

                        this.vmethod4166(this.field3171[var10], var2 + this.field3173[var10] + var13, var3 + this.field3172[var10] + var14, var19, var12, field3183, field3176);
                     }
                  } else if(field3188 > 0) {
                     field3186 += field3188;
                     var2 += field3186 >> 8;
                     field3186 &= 255;
                  }

                  int var15 = this.field3168[var10];
                  if(field3178 != -1) {
                     class79.method1831(var2, var3 + (int)((double)this.field3182 * 0.7D), var15, field3178);
                  }

                  if(field3179 != -1) {
                     class79.method1831(var2, var3 + this.field3182, var15, field3179);
                  }

                  var2 += var15;
                  var7 = var10;
               }
            }
         }
      }

   }

   class222(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3173 = var2;
      this.field3172 = var3;
      this.field3167 = var4;
      this.field3170 = var5;
      this.method4068(var1);
      this.field3171 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3172[var10] < var8 && this.field3170[var10] != 0) {
            var8 = this.field3172[var10];
         }

         if(this.field3172[var10] + this.field3170[var10] > var9) {
            var9 = this.field3172[var10] + this.field3170[var10];
         }
      }

      this.field3174 = this.field3182 - var8;
      this.field3180 = var9 - this.field3182;
   }

   @ObfuscatedName("a")
   public int method4101(String var1, int var2) {
      int var3 = this.method4072(var1, new int[]{var2}, field3175);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method4161(field3175[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("i")
   public static String method4107(String var0) {
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

   @ObfuscatedName("o")
   static void method4112(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class79.field1401;
      int var7 = class79.field1401 - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class79.field1403) {
         var10 = class79.field1403 - var2;
         var4 -= var10;
         var2 = class79.field1403;
         var9 += var10 * var3;
         var6 += var10 * class79.field1401;
      }

      if(var2 + var4 > class79.field1402) {
         var4 -= var2 + var4 - class79.field1402;
      }

      if(var1 < class79.field1405) {
         var10 = class79.field1405 - var1;
         var3 -= var10;
         var1 = class79.field1405;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class79.field1400) {
         var10 = var1 + var3 - class79.field1400;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4091(class79.field1406, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   @ObfuscatedName("aa")
   static void method4127(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("z")
   public void method4152(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4071(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4093(var1, var2 - this.method4161(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("l")
   public int method4161(String var1) {
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
                              int var8 = client.method585(var9, 10);
                              var4 += field3185[var8].field1413;
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
                  var4 += this.field3168[(char)(class154.method3204(var6) & 255)];
                  if(this.field3177 != null && var3 != -1) {
                     var4 += this.field3177[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }
}
