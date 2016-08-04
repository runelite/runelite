import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public abstract class class226 extends class82 {
   @ObfuscatedName("l")
   byte[][] field3229 = new byte[256][];
   @ObfuscatedName("g")
   int[] field3230;
   @ObfuscatedName("as")
   static Random field3231 = new Random();
   @ObfuscatedName("h")
   int[] field3232;
   @ObfuscatedName("e")
   int[] field3233;
   @ObfuscatedName("r")
   int[] field3234;
   @ObfuscatedName("k")
   public int field3235 = 0;
   @ObfuscatedName("u")
   public int field3236;
   @ObfuscatedName("n")
   public int field3237;
   @ObfuscatedName("s")
   int[] field3238;
   @ObfuscatedName("b")
   @Export("modIcons")
   public static class83[] field3239;
   @ObfuscatedName("q")
   static int field3240 = -1;
   @ObfuscatedName("v")
   static int field3241 = -1;
   @ObfuscatedName("j")
   static int field3242 = -1;
   @ObfuscatedName("x")
   static int field3243 = -1;
   @ObfuscatedName("t")
   static int field3244 = 0;
   @ObfuscatedName("y")
   static int field3245 = 0;
   @ObfuscatedName("a")
   static int field3246 = 256;
   @ObfuscatedName("c")
   static int field3247 = 0;
   @ObfuscatedName("ad")
   static int field3248 = 0;
   @ObfuscatedName("m")
   byte[] field3249;
   @ObfuscatedName("ac")
   static String[] field3250 = new String[100];

   @ObfuscatedName("t")
   abstract void vmethod4259(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   class226(byte[] var1) {
      this.method4163(var1);
   }

   @ObfuscatedName("l")
   void method4163(byte[] var1) {
      this.field3230 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3230.length; ++var2) {
            this.field3230[var2] = var1[var2] & 255;
         }

         this.field3235 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3230[var3] = var1[var2++] & 255;
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

         byte[][] var12 = new byte[256][];

         int var8;
         for(int var11 = 0; var11 < 256; ++var11) {
            var12[var11] = new byte[var10[var11]];
            byte var7 = 0;

            for(var8 = 0; var8 < var12[var11].length; ++var8) {
               var7 += var1[var2++];
               var12[var11][var8] = var7;
            }
         }

         byte[][] var6 = new byte[256][];

         int var13;
         for(var13 = 0; var13 < 256; ++var13) {
            var6[var13] = new byte[var10[var13]];
            byte var14 = 0;

            for(int var9 = 0; var9 < var6[var13].length; ++var9) {
               var14 += var1[var2++];
               var6[var13][var9] = var14;
            }
         }

         this.field3249 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3249[(var13 << 8) + var8] = (byte)method4208(var12, var6, var4, this.field3230, var10, var13, var8);
                  }
               }
            }
         }

         this.field3235 = var4[32] + var10[32];
      }

   }

   @ObfuscatedName("e")
   public int method4165(String var1) {
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
                              int var8 = class5.method91(var9, 10, true);
                              var4 += field3239[var8].field1496;
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
                  var4 += this.field3230[(char)(class33.method735(var6) & 255)];
                  if(this.field3249 != null && var3 != -1) {
                     var4 += this.field3249[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("h")
   int method4166(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method4238('<');
                     if(this.field3249 != null && var11 != -1) {
                        var4 += this.field3249[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method4238('>');
                     if(this.field3249 != null && var11 != -1) {
                        var4 += this.field3249[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var18 = var16.substring(4);
                        int var17 = class5.method91(var18, 10, true);
                        var4 += field3239[var17].field1496;
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
                     var4 += this.method4238(var15);
                     if(this.field3249 != null && var11 != -1) {
                        var4 += this.field3249[(var11 << 8) + var15];
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

   @ObfuscatedName("s")
   public int method4167(String var1, int var2) {
      int var3 = this.method4166(var1, new int[]{var2}, field3250);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method4165(field3250[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("k")
   public int method4168(String var1, int var2) {
      return this.method4166(var1, new int[]{var2}, field3250);
   }

   @ObfuscatedName("u")
   public static String method4169(String var0) {
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
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4170(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4179(var4, var5);
         this.method4192(var1, var2, var3);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4172(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4179(var4, var5);
         this.method4192(var1, var2 - this.method4165(var1), var3);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4173(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4179(var4, var5);
         this.method4192(var1, var2 - this.method4165(var1) / 2, var3);
      }
   }

   @ObfuscatedName("p")
   public int method4174(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method4179(var6, var7);
         if(var10 == 0) {
            var10 = this.field3235;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3236 + this.field3237 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method4166(var1, var11, field3250);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3236;
         } else if(var9 == 1) {
            var13 = var3 + this.field3236 + (var5 - this.field3236 - this.field3237 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3237 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3236 - this.field3237 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3236 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method4192(field3250[var14], var2, var13);
            } else if(var8 == 1) {
               this.method4192(field3250[var14], var2 + (var4 - this.method4165(field3250[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method4192(field3250[var14], var2 + var4 - this.method4165(field3250[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method4192(field3250[var14], var2, var13);
            } else {
               this.method4181(field3250[var14], var4);
               this.method4192(field3250[var14], var2, var13);
               field3247 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("o")
   public void method4176(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4179(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4226(var1, var2 - this.method4165(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("f")
   public void method4178(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4179(var4, var5);
         field3231.setSeed((long)var6);
         field3246 = 192 + (field3231.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3231.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method4226(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("z")
   void method4179(int var1, int var2) {
      field3240 = -1;
      field3241 = -1;
      field3242 = var2;
      field3243 = var2;
      field3244 = var1;
      field3245 = var1;
      field3246 = 256;
      field3247 = 0;
      field3248 = 0;
   }

   @ObfuscatedName("v")
   void method4181(String var1, int var2) {
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
         field3247 = (var2 - this.method4165(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("y")
   abstract void vmethod4265(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("c")
   static void method4187(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("ad")
   static void method4188(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class82.field1490;
      int var8 = class82.field1490 - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class82.field1492) {
         var11 = class82.field1492 - var2;
         var4 -= var11;
         var2 = class82.field1492;
         var10 += var11 * var3;
         var7 += var11 * class82.field1490;
      }

      if(var2 + var4 > class82.field1489) {
         var4 -= var2 + var4 - class82.field1489;
      }

      if(var1 < class82.field1491) {
         var11 = class82.field1491 - var1;
         var3 -= var11;
         var1 = class82.field1491;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class82.field1495) {
         var11 = var1 + var3 - class82.field1495;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method4189(class82.field1493, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("as")
   static void method4189(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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
   public void method4190(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4179(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4226(var1, var2 - this.method4165(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("j")
   void method4192(String var1, int var2, int var3) {
      var3 -= this.field3235;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class33.method735(var1.charAt(var6)) & 255);
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
                              var9 = class5.method91(var10, 10, true);
                              class83 var12 = field3239[var9];
                              var12.method1954(var2, var3 + this.field3235 - var12.field1502);
                              var2 += var12.field1496;
                              var5 = -1;
                           } catch (Exception var16) {
                              ;
                           }
                        } else {
                           this.method4253(var8);
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
                  if(this.field3249 != null && var5 != -1) {
                     var2 += this.field3249[(var5 << 8) + var7];
                  }

                  int var14 = this.field3234[var7];
                  var9 = this.field3233[var7];
                  if(var7 != 32) {
                     if(field3246 == 256) {
                        if(field3243 != -1) {
                           method4234(this.field3229[var7], var2 + this.field3232[var7] + 1, var3 + this.field3238[var7] + 1, var14, var9, field3243);
                        }

                        this.vmethod4259(this.field3229[var7], var2 + this.field3232[var7], var3 + this.field3238[var7], var14, var9, field3245);
                     } else {
                        if(field3243 != -1) {
                           method4188(this.field3229[var7], var2 + this.field3232[var7] + 1, var3 + this.field3238[var7] + 1, var14, var9, field3243, field3246);
                        }

                        this.vmethod4265(this.field3229[var7], var2 + this.field3232[var7], var3 + this.field3238[var7], var14, var9, field3245, field3246);
                     }
                  } else if(field3247 > 0) {
                     field3248 += field3247;
                     var2 += field3248 >> 8;
                     field3248 &= 255;
                  }

                  int var15 = this.field3230[var7];
                  if(field3240 != -1) {
                     class82.method1945(var2, var3 + (int)((double)this.field3235 * 0.7D), var15, field3240);
                  }

                  if(field3241 != -1) {
                     class82.method1945(var2, var3 + this.field3235 + 1, var15, field3241);
                  }

                  var2 += var15;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   public void method4200(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method4179(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method4226(var1, var2 - this.method4165(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("g")
   static int method4208(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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
   void method4226(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3235;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class33.method735(var1.charAt(var9)) & 255);
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
                              var14 = class5.method91(var15, 10, true);
                              class83 var17 = field3239[var14];
                              var17.method1954(var2 + var12, var3 + this.field3235 - var17.field1502 + var13);
                              var2 += var17.field1496;
                              var7 = -1;
                           } catch (Exception var21) {
                              ;
                           }
                        } else {
                           this.method4253(var11);
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
                  if(this.field3249 != null && var7 != -1) {
                     var2 += this.field3249[(var7 << 8) + var10];
                  }

                  int var19 = this.field3234[var10];
                  var12 = this.field3233[var10];
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
                     if(field3246 == 256) {
                        if(field3243 != -1) {
                           method4234(this.field3229[var10], var2 + this.field3232[var10] + 1 + var13, var3 + this.field3238[var10] + 1 + var14, var19, var12, field3243);
                        }

                        this.vmethod4259(this.field3229[var10], var2 + this.field3232[var10] + var13, var3 + this.field3238[var10] + var14, var19, var12, field3245);
                     } else {
                        if(field3243 != -1) {
                           method4188(this.field3229[var10], var2 + this.field3232[var10] + 1 + var13, var3 + this.field3238[var10] + 1 + var14, var19, var12, field3243, field3246);
                        }

                        this.vmethod4265(this.field3229[var10], var2 + this.field3232[var10] + var13, var3 + this.field3238[var10] + var14, var19, var12, field3245, field3246);
                     }
                  } else if(field3247 > 0) {
                     field3248 += field3247;
                     var2 += field3248 >> 8;
                     field3248 &= 255;
                  }

                  int var20 = this.field3230[var10];
                  if(field3240 != -1) {
                     class82.method1945(var2, var3 + (int)((double)this.field3235 * 0.7D), var20, field3240);
                  }

                  if(field3241 != -1) {
                     class82.method1945(var2, var3 + this.field3235, var20, field3241);
                  }

                  var2 += var20;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   public void method4227(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4179(var4, var5);
         field3246 = var6;
         this.method4192(var1, var2, var3);
      }
   }

   @ObfuscatedName("a")
   static void method4234(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class82.field1490;
      int var7 = class82.field1490 - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class82.field1492) {
         var10 = class82.field1492 - var2;
         var4 -= var10;
         var2 = class82.field1492;
         var9 += var10 * var3;
         var6 += var10 * class82.field1490;
      }

      if(var2 + var4 > class82.field1489) {
         var4 -= var2 + var4 - class82.field1489;
      }

      if(var1 < class82.field1491) {
         var10 = class82.field1491 - var1;
         var3 -= var10;
         var1 = class82.field1491;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class82.field1495) {
         var10 = var1 + var3 - class82.field1495;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4187(class82.field1493, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   class226(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3232 = var2;
      this.field3238 = var3;
      this.field3234 = var4;
      this.field3233 = var5;
      this.method4163(var1);
      this.field3229 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3238[var10] < var8 && this.field3233[var10] != 0) {
            var8 = this.field3238[var10];
         }

         if(this.field3238[var10] + this.field3233[var10] > var9) {
            var9 = this.field3238[var10] + this.field3233[var10];
         }
      }

      this.field3236 = this.field3235 - var8;
      this.field3237 = var9 - this.field3235;
   }

   @ObfuscatedName("r")
   int method4238(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3230[class33.method735(var1) & 255];
   }

   @ObfuscatedName("i")
   void method4253(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3245 = class26.method616(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3245 = field3244;
         } else if(var1.startsWith("str=")) {
            field3240 = class26.method616(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3240 = 8388608;
         } else if(var1.equals("/str")) {
            field3240 = -1;
         } else if(var1.startsWith("u=")) {
            field3241 = class26.method616(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3241 = 0;
         } else if(var1.equals("/u")) {
            field3241 = -1;
         } else if(var1.startsWith("shad=")) {
            field3243 = class26.method616(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3243 = 0;
         } else if(var1.equals("/shad")) {
            field3243 = field3242;
         } else if(var1.equals("br")) {
            this.method4179(field3244, field3242);
         }
      } catch (Exception var3) {
         ;
      }

   }
}
