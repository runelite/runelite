import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("Sequence")
public class class42 extends class204 {
   @ObfuscatedName("h")
   static class193 field980 = new class193(64);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1292137237
   )
   public int field981 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1214753495
   )
   public int field982 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1743681259
   )
   public int field983 = 5;
   @ObfuscatedName("z")
   static class193 field984 = new class193(100);
   @ObfuscatedName("r")
   public int[] field985;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 839243045
   )
   @Export("replyMode")
   public int field986 = 2;
   @ObfuscatedName("s")
   public int[] field987;
   @ObfuscatedName("d")
   public int[] field988;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1690621559
   )
   @Export("precedenceAnimating")
   public int field989 = -1;
   @ObfuscatedName("y")
   @Export("interleaveLeave")
   int[] field990;
   @ObfuscatedName("p")
   @Export("stretches")
   public boolean field991 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1666085503
   )
   public int field992 = -1;
   @ObfuscatedName("t")
   public static class167 field993;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2060266977
   )
   public int field994 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -683565765
   )
   @Export("maxLoops")
   public int field995 = 99;
   @ObfuscatedName("i")
   public static class167 field996;
   @ObfuscatedName("f")
   int[] field997;
   @ObfuscatedName("g")
   public static class167 field998;
   @ObfuscatedName("br")
   static class168 field1000;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "2067160941"
   )
   public class105 method848(class105 var1, int var2) {
      var2 = this.field985[var2];
      class103 var3 = class142.method2958(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2255(true);
      } else {
         class105 var4 = var1.method2255(!var3.method2241(var2));
         var4.method2261(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "16"
   )
   void method849(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method850(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;IS)V",
      garbageValue = "16933"
   )
   void method850(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2470();
         this.field987 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field987[var4] = var1.method2470();
         }

         this.field985 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field985[var4] = var1.method2470();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field985[var4] += var1.method2470() << 16;
         }
      } else if(var2 == 2) {
         this.field981 = var1.method2470();
      } else if(var2 == 3) {
         var3 = var1.method2494();
         this.field990 = new int[1 + var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field990[var4] = var1.method2494();
         }

         this.field990[var3] = 9999999;
      } else if(var2 == 4) {
         this.field991 = true;
      } else if(var2 == 5) {
         this.field983 = var1.method2494();
      } else if(var2 == 6) {
         this.field982 = var1.method2470();
      } else if(var2 == 7) {
         this.field994 = var1.method2470();
      } else if(var2 == 8) {
         this.field995 = var1.method2494();
      } else if(var2 == 9) {
         this.field989 = var1.method2494();
      } else if(var2 == 10) {
         this.field992 = var1.method2494();
      } else if(var2 == 11) {
         this.field986 = var1.method2494();
      } else if(var2 == 12) {
         var3 = var1.method2494();
         this.field997 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field997[var4] = var1.method2470();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field997[var4] += var1.method2470() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2494();
         this.field988 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field988[var4] = var1.method2472();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-487800626"
   )
   void method851() {
      if(this.field989 == -1) {
         if(this.field990 != null) {
            this.field989 = 2;
         } else {
            this.field989 = 0;
         }
      }

      if(this.field992 == -1) {
         if(this.field990 != null) {
            this.field992 = 2;
         } else {
            this.field992 = 0;
         }
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1223778768"
   )
   static final void method852(int var0, int var1) {
      if(class40.field964 != var0 || class31.field732 != var1) {
         class40.field964 = var0;
         class31.field732 = var1;
         class2.method14(25);
         class76.method1632("Loading - please wait.", true);
         int var2 = class89.field1565;
         int var3 = client.field358;
         class89.field1565 = (var0 - 6) * 8;
         client.field358 = (var1 - 6) * 8;
         int var4 = class89.field1565 - var2;
         int var5 = client.field358 - var3;
         var2 = class89.field1565;
         var3 = client.field358;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var17 = client.field320[var6];
            if(null != var17) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var17.field847[var8] -= var4;
                  var17.field839[var8] -= var5;
               }

               var17.field809 -= 128 * var4;
               var17.field804 -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var21 = client.field405[var6];
            if(null != var21) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var21.field847[var8] -= var4;
                  var21.field839[var8] -= var5;
               }

               var21.field809 -= 128 * var4;
               var21.field804 -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var7 = 104;
         byte var20 = 1;
         if(var4 < 0) {
            var19 = 103;
            var7 = -1;
            var20 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var18 = var19; var7 != var18; var18 += var20) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var18;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field415[var16][var18][var13] = client.field415[var16][var14][var15];
                  } else {
                     client.field415[var16][var18][var13] = null;
                  }
               }
            }
         }

         for(class16 var12 = (class16)client.field542.method3797(); null != var12; var12 = (class16)client.field542.method3779()) {
            var12.field226 -= var4;
            var12.field227 -= var5;
            if(var12.field226 < 0 || var12.field227 < 0 || var12.field226 >= 104 || var12.field227 >= 104) {
               var12.method3870();
            }
         }

         if(client.field545 != 0) {
            client.field545 -= var4;
            client.field517 -= var5;
         }

         client.field524 = 0;
         client.field530 = false;
         client.field511 = -1;
         client.field446.method3772();
         client.field417.method3772();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field344[var13].method2352();
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "-850531790"
   )
   class105 method854(class105 var1, int var2) {
      var2 = this.field985[var2];
      class103 var3 = class142.method2958(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2296(true);
      } else {
         class105 var4 = var1.method2296(!var3.method2241(var2));
         var4.method2261(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass105;ILclass42;II)Lclass105;",
      garbageValue = "829440629"
   )
   public class105 method855(class105 var1, int var2, class42 var3, int var4) {
      var2 = this.field985[var2];
      class103 var5 = class142.method2958(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method848(var1, var4);
      } else {
         var4 = var3.field985[var4];
         class103 var6 = class142.method2958(var4 >> 16);
         var4 &= '\uffff';
         class105 var7;
         if(null == var6) {
            var7 = var1.method2255(!var5.method2241(var2));
            var7.method2261(var5, var2);
            return var7;
         } else {
            var7 = var1.method2255(!var5.method2241(var2) & !var6.method2241(var4));
            var7.method2262(var5, var2, var6, var4, this.field990);
            return var7;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass105;IB)Lclass105;",
      garbageValue = "16"
   )
   public class105 method856(class105 var1, int var2) {
      int var3 = this.field985[var2];
      class103 var4 = class142.method2958(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2255(true);
      } else {
         class103 var5 = null;
         int var6 = 0;
         if(null != this.field997 && var2 < this.field997.length) {
            var6 = this.field997[var2];
            var5 = class142.method2958(var6 >> 16);
            var6 &= '\uffff';
         }

         class105 var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2255(!var4.method2241(var3) & !var5.method2241(var6));
            var7.method2261(var4, var3);
            var7.method2261(var5, var6);
            return var7;
         } else {
            var7 = var1.method2255(!var4.method2241(var3));
            var7.method2261(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass105;IIS)Lclass105;",
      garbageValue = "21638"
   )
   class105 method859(class105 var1, int var2, int var3) {
      var2 = this.field985[var2];
      class103 var4 = class142.method2958(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2255(true);
      } else {
         class105 var5 = var1.method2255(!var4.method2241(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2266();
         } else if(var3 == 2) {
            var5.method2302();
         } else if(var3 == 3) {
            var5.method2264();
         }

         var5.method2261(var4, var2);
         if(var3 == 1) {
            var5.method2264();
         } else if(var3 == 2) {
            var5.method2302();
         } else if(var3 == 3) {
            var5.method2266();
         }

         return var5;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass37;II)V",
      garbageValue = "-1085882198"
   )
   static final void method877(class37 var0, int var1) {
      if(var0.field848 > client.field332) {
         class181.method3476(var0);
      } else if(var0.field849 >= client.field332) {
         class76.method1637(var0);
      } else {
         var0.field827 = var0.field808;
         if(var0.field856 == 0) {
            var0.field860 = 0;
         } else {
            label302: {
               if(var0.field834 != -1 && var0.field824 == 0) {
                  class42 var2 = class18.method177(var0.field834);
                  if(var0.field861 > 0 && var2.field989 == 0) {
                     ++var0.field860;
                     break label302;
                  }

                  if(var0.field861 <= 0 && var2.field992 == 0) {
                     ++var0.field860;
                     break label302;
                  }
               }

               int var11 = var0.field809;
               int var3 = var0.field804;
               int var4 = var0.field807 * 64 + var0.field847[var0.field856 - 1] * 128;
               int var5 = var0.field807 * 64 + 128 * var0.field839[var0.field856 - 1];
               if(var11 < var4) {
                  if(var3 < var5) {
                     var0.field831 = 1280;
                  } else if(var3 > var5) {
                     var0.field831 = 1792;
                  } else {
                     var0.field831 = 1536;
                  }
               } else if(var11 > var4) {
                  if(var3 < var5) {
                     var0.field831 = 768;
                  } else if(var3 > var5) {
                     var0.field831 = 256;
                  } else {
                     var0.field831 = 512;
                  }
               } else if(var3 < var5) {
                  var0.field831 = 1024;
               } else if(var3 > var5) {
                  var0.field831 = 0;
               }

               byte var6 = var0.field859[var0.field856 - 1];
               if(var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.field831 - var0.field805 & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field812;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field811;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field857;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field814;
                  }

                  if(var8 == -1) {
                     var8 = var0.field811;
                  }

                  var0.field827 = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof class34) {
                     var10 = ((class34)var0).field772.field906;
                  }

                  if(var10) {
                     if(var0.field805 != var0.field831 && var0.field828 == -1 && var0.field863 != 0) {
                        var9 = 2;
                     }

                     if(var0.field856 > 2) {
                        var9 = 6;
                     }

                     if(var0.field856 > 3) {
                        var9 = 8;
                     }

                     if(var0.field860 > 0 && var0.field856 > 1) {
                        var9 = 8;
                        --var0.field860;
                     }
                  } else {
                     if(var0.field856 > 1) {
                        var9 = 6;
                     }

                     if(var0.field856 > 2) {
                        var9 = 8;
                     }

                     if(var0.field860 > 0 && var0.field856 > 1) {
                        var9 = 8;
                        --var0.field860;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.field827 == var0.field811 && var0.field815 != -1) {
                     var0.field827 = var0.field815;
                  }

                  if(var11 != var4 || var3 != var5) {
                     if(var11 < var4) {
                        var0.field809 += var9;
                        if(var0.field809 > var4) {
                           var0.field809 = var4;
                        }
                     } else if(var11 > var4) {
                        var0.field809 -= var9;
                        if(var0.field809 < var4) {
                           var0.field809 = var4;
                        }
                     }

                     if(var3 < var5) {
                        var0.field804 += var9;
                        if(var0.field804 > var5) {
                           var0.field804 = var5;
                        }
                     } else if(var3 > var5) {
                        var0.field804 -= var9;
                        if(var0.field804 < var5) {
                           var0.field804 = var5;
                        }
                     }
                  }

                  if(var4 == var0.field809 && var5 == var0.field804) {
                     --var0.field856;
                     if(var0.field861 > 0) {
                        --var0.field861;
                     }
                  }
               } else {
                  var0.field809 = var4;
                  var0.field804 = var5;
                  --var0.field856;
                  if(var0.field861 > 0) {
                     --var0.field861;
                  }
               }
            }
         }
      }

      if(var0.field809 < 128 || var0.field804 < 128 || var0.field809 >= 13184 || var0.field804 >= 13184) {
         var0.field834 = -1;
         var0.field836 = -1;
         var0.field848 = 0;
         var0.field849 = 0;
         var0.field809 = 128 * var0.field847[0] + var0.field807 * 64;
         var0.field804 = var0.field807 * 64 + var0.field839[0] * 128;
         var0.method734();
      }

      if(var0 == class152.field2301 && (var0.field809 < 1536 || var0.field804 < 1536 || var0.field809 >= 11776 || var0.field804 >= 11776)) {
         var0.field834 = -1;
         var0.field836 = -1;
         var0.field848 = 0;
         var0.field849 = 0;
         var0.field809 = var0.field807 * 64 + 128 * var0.field847[0];
         var0.field804 = var0.field839[0] * 128 + var0.field807 * 64;
         var0.method734();
      }

      class158.method3141(var0);
      class11.method127(var0);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-1135665721"
   )
   public static void method878(File var0) {
      class135.field2103 = var0;
      if(!class135.field2103.exists()) {
         throw new RuntimeException("");
      } else {
         class135.field2107 = true;
      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "109"
   )
   static final void method880() {
      client.field404 = 0;
      int var0 = (class152.field2301.field809 >> 7) + class89.field1565;
      int var1 = (class152.field2301.field804 >> 7) + client.field358;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         client.field404 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         client.field404 = 1;
      }

      if(client.field404 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         client.field404 = 0;
      }

   }
}
