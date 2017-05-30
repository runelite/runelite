import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("FontTypeFace")
public abstract class FontTypeFace extends Rasterizer2D {
   @ObfuscatedName("a")
   @Export("modIcons")
   public static ModIcon[] modIcons;
   @ObfuscatedName("u")
   int[] field3633;
   @ObfuscatedName("y")
   static String[] field3634;
   @ObfuscatedName("q")
   int[] field3635;
   @ObfuscatedName("l")
   public int field3636;
   @ObfuscatedName("v")
   int[] field3637;
   @ObfuscatedName("t")
   public int field3638;
   @ObfuscatedName("p")
   public int field3639;
   @ObfuscatedName("r")
   static int field3640;
   @ObfuscatedName("h")
   int[] field3641;
   @ObfuscatedName("k")
   byte[] field3642;
   @ObfuscatedName("i")
   byte[][] field3643;
   @ObfuscatedName("b")
   static int field3644;
   @ObfuscatedName("x")
   static int field3645;
   @ObfuscatedName("o")
   static int field3646;
   @ObfuscatedName("j")
   static int field3647;
   @ObfuscatedName("m")
   static int field3648;
   @ObfuscatedName("d")
   static int field3649;
   @ObfuscatedName("e")
   static int field3650;
   @ObfuscatedName("s")
   static int field3651;
   @ObfuscatedName("g")
   int[] field3652;
   @ObfuscatedName("n")
   static Random field3653;

   @ObfuscatedName("t")
   void method4806(byte[] var1) {
      this.field3641 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3641.length; ++var2) {
            this.field3641[var2] = var1[var2] & 255;
         }

         this.field3638 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var10 = 0; var10 < 256; ++var10) {
            this.field3641[var10] = var1[var2++] & 255;
         }

         int[] var3 = new int[256];
         int[] var4 = new int[256];

         int var5;
         for(var5 = 0; var5 < 256; ++var5) {
            var3[var5] = var1[var2++] & 255;
         }

         for(var5 = 0; var5 < 256; ++var5) {
            var4[var5] = var1[var2++] & 255;
         }

         byte[][] var11 = new byte[256][];

         int var8;
         for(int var6 = 0; var6 < 256; ++var6) {
            var11[var6] = new byte[var3[var6]];
            byte var7 = 0;

            for(var8 = 0; var8 < var11[var6].length; ++var8) {
               var7 += var1[var2++];
               var11[var6][var8] = var7;
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

         this.field3642 = new byte[65536];

         for(var13 = 0; var13 < 256; ++var13) {
            if(var13 != 32 && var13 != 160) {
               for(var8 = 0; var8 < 256; ++var8) {
                  if(var8 != 32 && var8 != 160) {
                     this.field3642[(var13 << 8) + var8] = (byte)method4864(var11, var12, var4, this.field3641, var3, var13, var8);
                  }
               }
            }
         }

         this.field3638 = var4[32] + var3[32];
      }

   }

   @ObfuscatedName("l")
   int method4808(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3641[class177.method3456(var1) & 255];
   }

   @ObfuscatedName("a")
   public int method4809(String var1) {
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
                              int var8 = Friend.method1098(var7.substring(4));
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
                  var4 += this.field3641[(char)(class177.method3456(var6) & 255)];
                  if(this.field3642 != null && var3 != -1) {
                     var4 += this.field3642[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("az")
   void method4810(String var1, int var2) {
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
         field3650 = (var2 - this.method4809(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("b")
   public int method4811(String var1, int var2) {
      int var3 = this.method4887(var1, new int[]{var2}, field3634);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method4809(field3634[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("o")
   public static String method4813(String var0) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4816(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4883(var4, var5);
         this.method4826(var1, var2 - this.method4809(var1), var3);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method4817(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4883(var4, var5);
         this.method4826(var1, var2 - this.method4809(var1) / 2, var3);
      }
   }

   @ObfuscatedName("y")
   public int method4818(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method4883(var6, var7);
         if(var10 == 0) {
            var10 = this.field3638;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3639 + this.field3636 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method4887(var1, var11, field3634);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3639;
         } else if(var9 == 1) {
            var13 = var3 + this.field3639 + (var5 - this.field3639 - this.field3636 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3636 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3639 - this.field3636 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3639 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method4826(field3634[var14], var2, var13);
            } else if(var8 == 1) {
               this.method4826(field3634[var14], var2 + (var4 - this.method4809(field3634[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method4826(field3634[var14], var2 + var4 - this.method4809(field3634[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method4826(field3634[var14], var2, var13);
            } else {
               this.method4810(field3634[var14], var4);
               this.method4826(field3634[var14], var2, var13);
               field3650 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("w")
   public void method4819(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4883(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4827(var1, var2 - this.method4809(var1) / 2, var3, (int[])null, var7);
      }
   }

   @ObfuscatedName("f")
   public void method4820(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4883(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method4827(var1, var2 - this.method4809(var1) / 2, var3, var7, var8);
      }
   }

   @ObfuscatedName("c")
   public void method4821(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method4883(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method4827(var1, var2 - this.method4809(var1) / 2, var3, (int[])null, var10);
      }
   }

   @ObfuscatedName("z")
   public void method4822(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4883(var4, var5);
         field3653.setSeed((long)var6);
         field3649 = (field3653.nextInt() & 31) + 192;
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3653.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method4827(var1, var2, var3, var7, (int[])null);
      }
   }

   @ObfuscatedName("ah")
   void method4824(String var1) {
      try {
         if(var1.startsWith("col=")) {
            field3648 = WorldMapType0.method738(var1.substring(4), 16);
         } else if(var1.equals("/col")) {
            field3648 = field3647;
         } else if(var1.startsWith("str=")) {
            field3640 = WorldMapType0.method738(var1.substring(4), 16);
         } else if(var1.equals("str")) {
            field3640 = 8388608;
         } else if(var1.equals("/str")) {
            field3640 = -1;
         } else if(var1.startsWith("u=")) {
            field3644 = WorldMapType0.method738(var1.substring(2), 16);
         } else if(var1.equals("u")) {
            field3644 = 0;
         } else if(var1.equals("/u")) {
            field3644 = -1;
         } else if(var1.startsWith("shad=")) {
            field3646 = WorldMapType0.method738(var1.substring(5), 16);
         } else if(var1.equals("shad")) {
            field3646 = 0;
         } else if(var1.equals("/shad")) {
            field3646 = field3645;
         } else if(var1.equals("br")) {
            this.method4883(field3647, field3645);
         }
      } catch (Exception var3) {
         ;
      }

   }

   @ObfuscatedName("ad")
   static void method4825(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   @ObfuscatedName("ac")
   void method4826(String var1, int var2, int var3) {
      var3 -= this.field3638;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(class177.method3456(var1.charAt(var6)) & 255);
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
                              var9 = Friend.method1098(var8.substring(4));
                              ModIcon var10 = modIcons[var9];
                              var10.method5101(var2, var3 + this.field3638 - var10.originalHeight);
                              var2 += var10.width;
                              var5 = -1;
                           } catch (Exception var14) {
                              ;
                           }
                        } else {
                           this.method4824(var8);
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
                  if(this.field3642 != null && var5 != -1) {
                     var2 += this.field3642[(var5 << 8) + var7];
                  }

                  int var12 = this.field3633[var7];
                  var9 = this.field3635[var7];
                  if(var7 != 32) {
                     if(field3649 == 256) {
                        if(field3646 != -1) {
                           method4831(this.field3643[var7], var2 + this.field3652[var7] + 1, var3 + this.field3637[var7] + 1, var12, var9, field3646);
                        }

                        this.vmethod4858(this.field3643[var7], var2 + this.field3652[var7], var3 + this.field3637[var7], var12, var9, field3648);
                     } else {
                        if(field3646 != -1) {
                           method4845(this.field3643[var7], var2 + this.field3652[var7] + 1, var3 + this.field3637[var7] + 1, var12, var9, field3646, field3649);
                        }

                        this.vmethod4885(this.field3643[var7], var2 + this.field3652[var7], var3 + this.field3637[var7], var12, var9, field3648, field3649);
                     }
                  } else if(field3650 > 0) {
                     field3651 += field3650;
                     var2 += field3651 >> 8;
                     field3651 &= 255;
                  }

                  int var13 = this.field3641[var7];
                  if(field3640 != -1) {
                     Rasterizer2D.method5014(var2, var3 + (int)((double)this.field3638 * 0.7D), var13, field3640);
                  }

                  if(field3644 != -1) {
                     Rasterizer2D.method5014(var2, var3 + this.field3638 + 1, var13, field3644);
                  }

                  var2 += var13;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("aq")
   void method4827(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3638;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(class177.method3456(var1.charAt(var9)) & 255);
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
                              var14 = Friend.method1098(var11.substring(4));
                              ModIcon var15 = modIcons[var14];
                              var15.method5101(var2 + var12, var3 + this.field3638 - var15.originalHeight + var13);
                              var2 += var15.width;
                              var7 = -1;
                           } catch (Exception var19) {
                              ;
                           }
                        } else {
                           this.method4824(var11);
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
                  if(this.field3642 != null && var7 != -1) {
                     var2 += this.field3642[(var7 << 8) + var10];
                  }

                  int var17 = this.field3633[var10];
                  var12 = this.field3635[var10];
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
                     if(field3649 == 256) {
                        if(field3646 != -1) {
                           method4831(this.field3643[var10], var2 + this.field3652[var10] + 1 + var13, var3 + this.field3637[var10] + 1 + var14, var17, var12, field3646);
                        }

                        this.vmethod4858(this.field3643[var10], var2 + this.field3652[var10] + var13, var3 + this.field3637[var10] + var14, var17, var12, field3648);
                     } else {
                        if(field3646 != -1) {
                           method4845(this.field3643[var10], var2 + this.field3652[var10] + 1 + var13, var3 + this.field3637[var10] + 1 + var14, var17, var12, field3646, field3649);
                        }

                        this.vmethod4885(this.field3643[var10], var2 + this.field3652[var10] + var13, var3 + this.field3637[var10] + var14, var17, var12, field3648, field3649);
                     }
                  } else if(field3650 > 0) {
                     field3651 += field3650;
                     var2 += field3651 >> 8;
                     field3651 &= 255;
                  }

                  int var18 = this.field3641[var10];
                  if(field3640 != -1) {
                     Rasterizer2D.method5014(var2, var3 + (int)((double)this.field3638 * 0.7D), var18, field3640);
                  }

                  if(field3644 != -1) {
                     Rasterizer2D.method5014(var2, var3 + this.field3638, var18, field3644);
                  }

                  var2 += var18;
                  var7 = var10;
               }
            }
         }
      }

   }

   FontTypeFace(byte[] var1) {
      this.field3643 = new byte[256][];
      this.field3638 = 0;
      this.method4806(var1);
   }

   @ObfuscatedName("aj")
   static void method4830(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("af")
   static void method4831(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var7 = Rasterizer2D.graphicsPixelsWidth - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < Rasterizer2D.field3746) {
         var10 = Rasterizer2D.field3746 - var2;
         var4 -= var10;
         var2 = Rasterizer2D.field3746;
         var9 += var10 * var3;
         var6 += var10 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var4 > Rasterizer2D.field3750) {
         var4 -= var2 + var4 - Rasterizer2D.field3750;
      }

      if(var1 < Rasterizer2D.field3749) {
         var10 = Rasterizer2D.field3749 - var1;
         var3 -= var10;
         var1 = Rasterizer2D.field3749;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > Rasterizer2D.field3752) {
         var10 = var1 + var3 - Rasterizer2D.field3752;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method4830(Rasterizer2D.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }
   }

   FontTypeFace(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3643 = new byte[256][];
      this.field3638 = 0;
      this.field3652 = var2;
      this.field3637 = var3;
      this.field3633 = var4;
      this.field3635 = var5;
      this.method4806(var1);
      this.field3643 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3637[var10] < var8 && this.field3635[var10] != 0) {
            var8 = this.field3637[var10];
         }

         if(this.field3637[var10] + this.field3635[var10] > var9) {
            var9 = this.field3637[var10] + this.field3635[var10];
         }
      }

      this.field3639 = this.field3638 - var8;
      this.field3636 = var9 - this.field3638;
   }

   static {
      field3640 = -1;
      field3644 = -1;
      field3645 = -1;
      field3646 = -1;
      field3647 = 0;
      field3648 = 0;
      field3649 = 256;
      field3650 = 0;
      field3651 = 0;
      field3653 = new Random();
      field3634 = new String[100];
   }

   @ObfuscatedName("x")
   public int method4841(String var1, int var2) {
      return this.method4887(var1, new int[]{var2}, field3634);
   }

   @ObfuscatedName("ax")
   static void method4845(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var8 = Rasterizer2D.graphicsPixelsWidth - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < Rasterizer2D.field3746) {
         var11 = Rasterizer2D.field3746 - var2;
         var4 -= var11;
         var2 = Rasterizer2D.field3746;
         var10 += var11 * var3;
         var7 += var11 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var4 > Rasterizer2D.field3750) {
         var4 -= var2 + var4 - Rasterizer2D.field3750;
      }

      if(var1 < Rasterizer2D.field3749) {
         var11 = Rasterizer2D.field3749 - var1;
         var3 -= var11;
         var1 = Rasterizer2D.field3749;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > Rasterizer2D.field3752) {
         var11 = var1 + var3 - Rasterizer2D.field3752;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method4825(Rasterizer2D.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }
   }

   @ObfuscatedName("i")
   abstract void vmethod4858(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("p")
   static int method4864(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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
   public void method4872(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method4883(var4, var5);
         field3649 = var6;
         this.method4826(var1, var2, var3);
      }
   }

   @ObfuscatedName("ay")
   void method4883(int var1, int var2) {
      field3640 = -1;
      field3644 = -1;
      field3645 = var2;
      field3646 = var2;
      field3647 = var1;
      field3648 = var1;
      field3649 = 256;
      field3650 = 0;
      field3651 = 0;
   }

   @ObfuscatedName("h")
   abstract void vmethod4885(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("k")
   public int method4887(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method4808('<');
                     if(this.field3642 != null && var11 != -1) {
                        var4 += this.field3642[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method4808('>');
                     if(this.field3642 != null && var11 != -1) {
                        var4 += this.field3642[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        int var17 = Friend.method1098(var16.substring(4));
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
                     var4 += this.method4808(var15);
                     if(this.field3642 != null && var11 != -1) {
                        var4 += this.field3642[(var11 << 8) + var15];
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "0"
   )
   public void method4889(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method4883(var4, var5);
         this.method4826(var1, var2, var3);
      }
   }
}
