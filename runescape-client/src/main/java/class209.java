import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("FontTypeFace")
public abstract class class209 extends class219 {
   @ObfuscatedName("a")
   int[] field3081;
   @ObfuscatedName("e")
   static int field3082 = -1;
   @ObfuscatedName("i")
   int[] field3083;
   @ObfuscatedName("x")
   int[] field3084;
   @ObfuscatedName("f")
   int[] field3085;
   @ObfuscatedName("q")
   static int field3086 = -1;
   @ObfuscatedName("d")
   public int field3087 = 0;
   @ObfuscatedName("l")
   public int field3088;
   @ObfuscatedName("u")
   byte[][] field3089 = new byte[256][];
   @ObfuscatedName("z")
   @Export("modIcons")
   public static ModIcon[] modIcons;
   @ObfuscatedName("t")
   byte[] field3091;
   @ObfuscatedName("m")
   static int field3092 = -1;
   @ObfuscatedName("k")
   static int field3093 = 256;
   @ObfuscatedName("g")
   public int field3094;
   @ObfuscatedName("v")
   static int field3095 = -1;
   @ObfuscatedName("j")
   static int field3096 = 0;
   @ObfuscatedName("p")
   static int field3097 = 0;
   @ObfuscatedName("s")
   static String[] field3098 = new String[100];
   @ObfuscatedName("c")
   int[] field3099;
   @ObfuscatedName("y")
   static int field3100 = 0;
   @ObfuscatedName("h")
   static Random field3101 = new Random();
   @ObfuscatedName("r")
   static int field3102 = 0;

   @ObfuscatedName("t")
   void method3859(byte[] var1) {
      this.field3084 = new int[256];
      int var2;
      if(var1.length == 257) {
         for(var2 = 0; var2 < this.field3084.length; ++var2) {
            this.field3084[var2] = var1[var2] & 255;
         }

         this.field3087 = var1[256] & 255;
      } else {
         var2 = 0;

         for(int var3 = 0; var3 < 256; ++var3) {
            this.field3084[var3] = var1[var2++] & 255;
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

         byte[][] var6 = new byte[256][];

         int var7;
         for(int var8 = 0; var8 < 256; ++var8) {
            var6[var8] = new byte[var12[var8]];
            byte var9 = 0;

            for(var7 = 0; var7 < var6[var8].length; ++var7) {
               var9 += var1[var2++];
               var6[var8][var7] = var9;
            }
         }

         byte[][] var13 = new byte[256][];

         int var14;
         for(var14 = 0; var14 < 256; ++var14) {
            var13[var14] = new byte[var12[var14]];
            byte var10 = 0;

            for(int var11 = 0; var11 < var13[var14].length; ++var11) {
               var10 += var1[var2++];
               var13[var14][var11] = var10;
            }
         }

         this.field3091 = new byte[65536];

         for(var14 = 0; var14 < 256; ++var14) {
            if(var14 != 32 && var14 != 160) {
               for(var7 = 0; var7 < 256; ++var7) {
                  if(var7 != 32 && var7 != 160) {
                     this.field3091[(var14 << 8) + var7] = (byte)method3860(var6, var13, var4, this.field3084, var12, var14, var7);
                  }
               }
            }
         }

         this.field3087 = var4[32] + var12[32];
      }

   }

   @ObfuscatedName("m")
   static int method3860(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
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

   @ObfuscatedName("q")
   int method3861(char var1) {
      if(var1 == 160) {
         var1 = 32;
      }

      return this.field3084[XClanMember.method240(var1) & 255];
   }

   @ObfuscatedName("v")
   int method3863(String var1, int[] var2, String[] var3) {
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
                     var4 += this.method3861('<');
                     if(this.field3091 != null && var11 != -1) {
                        var4 += this.field3091[(var11 << 8) + 60];
                     }

                     var11 = 60;
                  } else if(var16.equals("gt")) {
                     var4 += this.method3861('>');
                     if(this.field3091 != null && var11 != -1) {
                        var4 += this.field3091[(var11 << 8) + 62];
                     }

                     var11 = 62;
                  } else if(var16.startsWith("img=")) {
                     try {
                        String var17 = var16.substring(4);
                        int var18 = KitDefinition.method3499(var17, 10, true);
                        var4 += modIcons[var18].width;
                        var11 = 0;
                     } catch (Exception var19) {
                        ;
                     }
                  }

                  var15 = 0;
               }

               if(var10 == -1) {
                  if(var15 != 0) {
                     var6.append(var15);
                     var4 += this.method3861(var15);
                     if(this.field3091 != null && var11 != -1) {
                        var4 += this.field3091[(var11 << 8) + var15];
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

         String var20 = var6.toString();
         if(var20.length() > var5) {
            var3[var12++] = var20.substring(var5, var20.length());
         }

         return var12;
      }
   }

   @ObfuscatedName("j")
   public int method3864(String var1, int var2) {
      int var3 = this.method3863(var1, new int[]{var2}, field3098);
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = this.method3874(field3098[var5]);
         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   @ObfuscatedName("p")
   public int method3865(String var1, int var2) {
      return this.method3863(var1, new int[]{var2}, field3098);
   }

   @ObfuscatedName("k")
   public static String method3866(String var0) {
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
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3867(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3876(var4, var5);
         this.method3879(var1, var2, var3);
      }

   }

   @ObfuscatedName("y")
   public void method3868(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3876(var4, var5);
         field3093 = var6;
         this.method3879(var1, var2, var3);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3869(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3876(var4, var5);
         this.method3879(var1, var2 - this.method3874(var1), var3);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IIII)V",
      garbageValue = "-1"
   )
   public void method3870(String var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         this.method3876(var4, var5);
         this.method3879(var1, var2 - this.method3874(var1) / 2, var3);
      }

   }

   @ObfuscatedName("w")
   public int method3871(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if(var1 == null) {
         return 0;
      } else {
         this.method3876(var6, var7);
         if(var10 == 0) {
            var10 = this.field3087;
         }

         int[] var11 = new int[]{var4};
         if(var5 < this.field3088 + this.field3094 + var10 && var5 < var10 + var10) {
            var11 = null;
         }

         int var12 = this.method3863(var1, var11, field3098);
         if(var9 == 3 && var12 == 1) {
            var9 = 1;
         }

         int var13;
         int var14;
         if(var9 == 0) {
            var13 = var3 + this.field3088;
         } else if(var9 == 1) {
            var13 = var3 + this.field3088 + (var5 - this.field3088 - this.field3094 - (var12 - 1) * var10) / 2;
         } else if(var9 == 2) {
            var13 = var3 + var5 - this.field3094 - (var12 - 1) * var10;
         } else {
            var14 = (var5 - this.field3088 - this.field3094 - (var12 - 1) * var10) / (var12 + 1);
            if(var14 < 0) {
               var14 = 0;
            }

            var13 = var3 + this.field3088 + var14;
            var10 += var14;
         }

         for(var14 = 0; var14 < var12; ++var14) {
            if(var8 == 0) {
               this.method3879(field3098[var14], var2, var13);
            } else if(var8 == 1) {
               this.method3879(field3098[var14], var2 + (var4 - this.method3874(field3098[var14])) / 2, var13);
            } else if(var8 == 2) {
               this.method3879(field3098[var14], var2 + var4 - this.method3874(field3098[var14]), var13);
            } else if(var14 == var12 - 1) {
               this.method3879(field3098[var14], var2, var13);
            } else {
               this.method3878(field3098[var14], var4);
               this.method3879(field3098[var14], var2, var13);
               field3102 = 0;
            }

            var13 += var10;
         }

         return var12;
      }
   }

   @ObfuscatedName("e")
   public int method3874(String var1) {
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
                              int var8 = class16.method183(var7.substring(4));
                              var4 += modIcons[var8].width;
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
                  var4 += this.field3084[(char)(XClanMember.method240(var6) & 255)];
                  if(this.field3091 != null && var3 != -1) {
                     var4 += this.field3091[(var3 << 8) + var6];
                  }

                  var3 = var6;
               }
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("aj")
   public void method3875(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3876(var4, var5);
         field3101.setSeed((long)var6);
         field3093 = 192 + (field3101.nextInt() & 31);
         int[] var7 = new int[var1.length()];
         int var8 = 0;

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = var8;
            if((field3101.nextInt() & 3) == 0) {
               ++var8;
            }
         }

         this.method3915(var1, var2, var3, var7, (int[])null);
      }

   }

   @ObfuscatedName("ag")
   void method3876(int var1, int var2) {
      field3092 = -1;
      field3086 = -1;
      field3082 = var2;
      field3095 = var2;
      field3096 = var1;
      field3097 = var1;
      field3093 = 256;
      field3102 = 0;
      field3100 = 0;
   }

   @ObfuscatedName("al")
   void method3877(String var1) {
      try {
         int var2;
         String var3;
         if(var1.startsWith("col=")) {
            var3 = var1.substring(4);
            var2 = KitDefinition.method3499(var3, 16, true);
            field3097 = var2;
         } else if(var1.equals("/col")) {
            field3097 = field3096;
         } else if(var1.startsWith("str=")) {
            var3 = var1.substring(4);
            var2 = KitDefinition.method3499(var3, 16, true);
            field3092 = var2;
         } else if(var1.equals("str")) {
            field3092 = 8388608;
         } else if(var1.equals("/str")) {
            field3092 = -1;
         } else if(var1.startsWith("u=")) {
            var3 = var1.substring(2);
            var2 = KitDefinition.method3499(var3, 16, true);
            field3086 = var2;
         } else if(var1.equals("u")) {
            field3086 = 0;
         } else if(var1.equals("/u")) {
            field3086 = -1;
         } else if(var1.startsWith("shad=")) {
            var3 = var1.substring(5);
            var2 = KitDefinition.method3499(var3, 16, true);
            field3095 = var2;
         } else if(var1.equals("shad")) {
            field3095 = 0;
         } else if(var1.equals("/shad")) {
            field3095 = field3082;
         } else if(var1.equals("br")) {
            this.method3876(field3096, field3082);
         }
      } catch (Exception var4) {
         ;
      }

   }

   @ObfuscatedName("an")
   void method3878(String var1, int var2) {
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
         field3102 = (var2 - this.method3874(var1) << 8) / var3;
      }

   }

   @ObfuscatedName("af")
   void method3879(String var1, int var2, int var3) {
      var3 -= this.field3087;
      int var4 = -1;
      int var5 = -1;

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         if(var1.charAt(var6) != 0) {
            char var7 = (char)(XClanMember.method240(var1.charAt(var6)) & 255);
            if(var7 == 60) {
               var4 = var6;
            } else {
               int var8;
               if(var7 == 62 && var4 != -1) {
                  String var9 = var1.substring(var4 + 1, var6);
                  var4 = -1;
                  if(var9.equals("lt")) {
                     var7 = 60;
                  } else {
                     if(!var9.equals("gt")) {
                        if(var9.startsWith("img=")) {
                           try {
                              String var14 = var9.substring(4);
                              var8 = KitDefinition.method3499(var14, 10, true);
                              ModIcon var11 = modIcons[var8];
                              var11.method4066(var2, var3 + this.field3087 - var11.originalHeight);
                              var2 += var11.width;
                              var5 = -1;
                           } catch (Exception var12) {
                              ;
                           }
                        } else {
                           this.method3877(var9);
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
                  if(this.field3091 != null && var5 != -1) {
                     var2 += this.field3091[(var5 << 8) + var7];
                  }

                  int var13 = this.field3083[var7];
                  var8 = this.field3081[var7];
                  if(var7 != 32) {
                     if(field3093 == 256) {
                        if(field3095 != -1) {
                           method3883(this.field3089[var7], var2 + this.field3085[var7] + 1, var3 + this.field3099[var7] + 1, var13, var8, field3095);
                        }

                        this.vmethod3881(this.field3089[var7], var2 + this.field3085[var7], var3 + this.field3099[var7], var13, var8, field3097);
                     } else {
                        if(field3095 != -1) {
                           method3920(this.field3089[var7], var2 + this.field3085[var7] + 1, var3 + this.field3099[var7] + 1, var13, var8, field3095, field3093);
                        }

                        this.vmethod3882(this.field3089[var7], var2 + this.field3085[var7], var3 + this.field3099[var7], var13, var8, field3097, field3093);
                     }
                  } else if(field3102 > 0) {
                     field3100 += field3102;
                     var2 += field3100 >> 8;
                     field3100 &= 255;
                  }

                  int var10 = this.field3084[var7];
                  if(field3092 != -1) {
                     class219.method3979(var2, var3 + (int)((double)this.field3087 * 0.7D), var10, field3092);
                  }

                  if(field3086 != -1) {
                     class219.method3979(var2, var3 + this.field3087 + 1, var10, field3086);
                  }

                  var2 += var10;
                  var5 = var7;
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   abstract void vmethod3881(byte[] var1, int var2, int var3, int var4, int var5, int var6);

   @ObfuscatedName("x")
   abstract void vmethod3882(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @ObfuscatedName("ax")
   static void method3883(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 + var2 * class219.graphicsPixelsWidth;
      int var7 = class219.graphicsPixelsWidth - var3;
      int var8 = 0;
      int var9 = 0;
      int var10;
      if(var2 < class219.field3172) {
         var10 = class219.field3172 - var2;
         var4 -= var10;
         var2 = class219.field3172;
         var9 += var10 * var3;
         var6 += var10 * class219.graphicsPixelsWidth;
      }

      if(var2 + var4 > class219.field3173) {
         var4 -= var2 + var4 - class219.field3173;
      }

      if(var1 < class219.field3171) {
         var10 = class219.field3171 - var1;
         var3 -= var10;
         var1 = class219.field3171;
         var9 += var10;
         var6 += var10;
         var8 += var10;
         var7 += var10;
      }

      if(var1 + var3 > class219.field3175) {
         var10 = var1 + var3 - class219.field3175;
         var3 -= var10;
         var8 += var10;
         var7 += var10;
      }

      if(var3 > 0 && var4 > 0) {
         method3884(class219.graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
      }

   }

   @ObfuscatedName("ai")
   static void method3884(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("av")
   static void method3886(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
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

   class209(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      this.field3085 = var2;
      this.field3099 = var3;
      this.field3083 = var4;
      this.field3081 = var5;
      this.method3859(var1);
      this.field3089 = var7;
      int var8 = Integer.MAX_VALUE;
      int var9 = Integer.MIN_VALUE;

      for(int var10 = 0; var10 < 256; ++var10) {
         if(this.field3099[var10] < var8 && this.field3081[var10] != 0) {
            var8 = this.field3099[var10];
         }

         if(this.field3099[var10] + this.field3081[var10] > var9) {
            var9 = this.field3099[var10] + this.field3081[var10];
         }
      }

      this.field3088 = this.field3087 - var8;
      this.field3094 = var9 - this.field3087;
   }

   @ObfuscatedName("b")
   public void method3898(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 != null) {
         this.method3876(var4, var5);
         double var8 = 7.0D - (double)var7 / 8.0D;
         if(var8 < 0.0D) {
            var8 = 0.0D;
         }

         int[] var10 = new int[var1.length()];

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
         }

         this.method3915(var1, var2 - this.method3874(var1) / 2, var3, (int[])null, var10);
      }

   }

   class209(byte[] var1) {
      this.method3859(var1);
   }

   @ObfuscatedName("n")
   public void method3913(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3876(var4, var5);
         int[] var7 = new int[var1.length()];

         for(int var8 = 0; var8 < var1.length(); ++var8) {
            var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3915(var1, var2 - this.method3874(var1) / 2, var3, (int[])null, var7);
      }

   }

   @ObfuscatedName("aa")
   void method3915(String var1, int var2, int var3, int[] var4, int[] var5) {
      var3 -= this.field3087;
      int var6 = -1;
      int var7 = -1;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.length(); ++var9) {
         if(var1.charAt(var9) != 0) {
            char var10 = (char)(XClanMember.method240(var1.charAt(var9)) & 255);
            if(var10 == 60) {
               var6 = var9;
            } else {
               int var11;
               int var12;
               int var13;
               if(var10 == 62 && var6 != -1) {
                  String var14 = var1.substring(var6 + 1, var9);
                  var6 = -1;
                  if(var14.equals("lt")) {
                     var10 = 60;
                  } else {
                     if(!var14.equals("gt")) {
                        if(var14.startsWith("img=")) {
                           try {
                              if(var4 != null) {
                                 var11 = var4[var8];
                              } else {
                                 var11 = 0;
                              }

                              if(var5 != null) {
                                 var12 = var5[var8];
                              } else {
                                 var12 = 0;
                              }

                              ++var8;
                              String var19 = var14.substring(4);
                              var13 = KitDefinition.method3499(var19, 10, true);
                              ModIcon var16 = modIcons[var13];
                              var16.method4066(var2 + var11, var3 + this.field3087 - var16.originalHeight + var12);
                              var2 += var16.width;
                              var7 = -1;
                           } catch (Exception var17) {
                              ;
                           }
                        } else {
                           this.method3877(var14);
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
                  if(this.field3091 != null && var7 != -1) {
                     var2 += this.field3091[(var7 << 8) + var10];
                  }

                  int var18 = this.field3083[var10];
                  var11 = this.field3081[var10];
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
                  if(var10 != 32) {
                     if(field3093 == 256) {
                        if(field3095 != -1) {
                           method3883(this.field3089[var10], var2 + this.field3085[var10] + 1 + var12, var3 + this.field3099[var10] + 1 + var13, var18, var11, field3095);
                        }

                        this.vmethod3881(this.field3089[var10], var2 + this.field3085[var10] + var12, var3 + this.field3099[var10] + var13, var18, var11, field3097);
                     } else {
                        if(field3095 != -1) {
                           method3920(this.field3089[var10], var2 + this.field3085[var10] + 1 + var12, var3 + this.field3099[var10] + 1 + var13, var18, var11, field3095, field3093);
                        }

                        this.vmethod3882(this.field3089[var10], var2 + this.field3085[var10] + var12, var3 + this.field3099[var10] + var13, var18, var11, field3097, field3093);
                     }
                  } else if(field3102 > 0) {
                     field3100 += field3102;
                     var2 += field3100 >> 8;
                     field3100 &= 255;
                  }

                  int var15 = this.field3084[var10];
                  if(field3092 != -1) {
                     class219.method3979(var2, var3 + (int)((double)this.field3087 * 0.7D), var15, field3092);
                  }

                  if(field3086 != -1) {
                     class219.method3979(var2, var3 + this.field3087, var15, field3086);
                  }

                  var2 += var15;
                  var7 = var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("ah")
   static void method3920(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var2 * class219.graphicsPixelsWidth;
      int var8 = class219.graphicsPixelsWidth - var3;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var2 < class219.field3172) {
         var11 = class219.field3172 - var2;
         var4 -= var11;
         var2 = class219.field3172;
         var10 += var11 * var3;
         var7 += var11 * class219.graphicsPixelsWidth;
      }

      if(var2 + var4 > class219.field3173) {
         var4 -= var2 + var4 - class219.field3173;
      }

      if(var1 < class219.field3171) {
         var11 = class219.field3171 - var1;
         var3 -= var11;
         var1 = class219.field3171;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var1 + var3 > class219.field3175) {
         var11 = var1 + var3 - class219.field3175;
         var3 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var3 > 0 && var4 > 0) {
         method3886(class219.graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
      }

   }

   @ObfuscatedName("o")
   public void method3925(String var1, int var2, int var3, int var4, int var5, int var6) {
      if(var1 != null) {
         this.method3876(var4, var5);
         int[] var7 = new int[var1.length()];
         int[] var8 = new int[var1.length()];

         for(int var9 = 0; var9 < var1.length(); ++var9) {
            var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
            var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
         }

         this.method3915(var1, var2 - this.method3874(var1) / 2, var3, var7, var8);
      }

   }
}
