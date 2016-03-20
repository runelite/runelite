import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class46 extends class203 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -410539519
   )
   public int field1047 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 239112507
   )
   public int field1048;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2133473129
   )
   public int field1049 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 799638961
   )
   public int field1050;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 251324925
   )
   public int field1051;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -718459945
   )
   public int field1052 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1954753741
   )
   public int field1053;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1534723257
   )
   public int field1054;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -132756061
   )
   public int field1055;
   @ObfuscatedName("y")
   public boolean field1056 = true;
   @ObfuscatedName("rr")
   protected static boolean field1057;
   @ObfuscatedName("r")
   static class192 field1058 = new class192(64);
   @ObfuscatedName("a")
   public static class166 field1059;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass118;II)V",
      garbageValue = "-910927214"
   )
   void method967(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(var2 == 0) {
            return;
         }

         this.method968(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass118;III)V",
      garbageValue = "-1688288040"
   )
   void method968(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1049 = var1.method2516();
      } else if(var2 == 2) {
         this.field1047 = var1.method2579();
      } else if(var2 == 5) {
         this.field1056 = false;
      } else if(7 == var2) {
         this.field1052 = var1.method2516();
      } else if(8 == var2) {
         ;
      }

   }

   @ObfuscatedName("f")
   static void method969(class167 var0, int var1) {
      if(null != class170.field2710) {
         class170.field2710.field1979 = 5 + var1 * 8;
         int var2 = class170.field2710.method2517();
         int var3 = class170.field2710.method2517();
         var0.method3359(var2, var3);
      } else {
         class8.method128((class167)null, 255, 255, 0, (byte)0, true);
         class170.field2708[var1] = var0;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "127"
   )
   void method972(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field1053 = (int)(var12 * 256.0D);
      this.field1054 = (int)(var14 * 256.0D);
      this.field1055 = (int)(256.0D * var16);
      if(this.field1054 < 0) {
         this.field1054 = 0;
      } else if(this.field1054 > 255) {
         this.field1054 = 255;
      }

      if(this.field1055 < 0) {
         this.field1055 = 0;
      } else if(this.field1055 > 255) {
         this.field1055 = 255;
      }

   }

   @ObfuscatedName("bf")
   static final boolean method976(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field302[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return 1007 == var1;
      }
   }

   @ObfuscatedName("a")
   public static boolean method977() {
      long var0 = class18.method214();
      int var2 = (int)(var0 - class170.field2704);
      class170.field2704 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class170.field2716 += var2;
      if(0 == class170.field2713 && 0 == class170.field2717 && 0 == class170.field2711 && 0 == class170.field2725) {
         return true;
      } else if(null == class89.field1549) {
         return false;
      } else {
         try {
            if(class170.field2716 > 30000) {
               throw new IOException();
            } else {
               class171 var3;
               class118 var4;
               while(class170.field2717 < 20 && class170.field2725 > 0) {
                  var3 = (class171)class170.field2705.method3836();
                  var4 = new class118(4);
                  var4.method2497(1);
                  var4.method2499((int)var3.field3111);
                  class89.field1549.method3003(var4.field1980, 0, 4);
                  class170.field2707.method3831(var3, var3.field3111);
                  --class170.field2725;
                  ++class170.field2717;
               }

               while(class170.field2713 < 20 && class170.field2711 > 0) {
                  var3 = (class171)class170.field2709.method3912();
                  var4 = new class118(4);
                  var4.method2497(0);
                  var4.method2499((int)var3.field3111);
                  class89.field1549.method3003(var4.field1980, 0, 4);
                  var3.method3920();
                  class170.field2712.method3831(var3, var3.field3111);
                  --class170.field2711;
                  ++class170.field2713;
               }

               for(int var18 = 0; var18 < 100; ++var18) {
                  int var19 = class89.field1549.method3001();
                  if(var19 < 0) {
                     throw new IOException();
                  }

                  if(0 == var19) {
                     break;
                  }

                  class170.field2716 = 0;
                  byte var5 = 0;
                  if(null == class106.field1868) {
                     var5 = 8;
                  } else if(class170.field2706 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class170.field2714.field1979;
                     if(var6 > var19) {
                        var6 = var19;
                     }

                     class89.field1549.method3002(class170.field2714.field1980, class170.field2714.field1979, var6);
                     if(0 != class170.field2719) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class170.field2714.field1980[var7 + class170.field2714.field1979] ^= class170.field2719;
                        }
                     }

                     class170.field2714.field1979 += var6;
                     if(class170.field2714.field1979 < var5) {
                        break;
                     }

                     if(class106.field1868 == null) {
                        class170.field2714.field1979 = 0;
                        var7 = class170.field2714.method2579();
                        var8 = class170.field2714.method2514();
                        int var9 = class170.field2714.method2579();
                        var10 = class170.field2714.method2517();
                        long var11 = (long)(var8 + (var7 << 16));
                        class171 var13 = (class171)class170.field2707.method3824(var11);
                        class155.field2289 = true;
                        if(null == var13) {
                           var13 = (class171)class170.field2712.method3824(var11);
                           class155.field2289 = false;
                        }

                        if(null == var13) {
                           throw new IOException();
                        }

                        int var14 = 0 == var9?5:9;
                        class106.field1868 = var13;
                        class76.field1388 = new class118(class106.field1868.field2728 + var10 + var14);
                        class76.field1388.method2497(var9);
                        class76.field1388.method2663(var10);
                        class170.field2706 = 8;
                        class170.field2714.field1979 = 0;
                     } else if(class170.field2706 == 0) {
                        if(class170.field2714.field1980[0] == -1) {
                           class170.field2706 = 1;
                           class170.field2714.field1979 = 0;
                        } else {
                           class106.field1868 = null;
                        }
                     }
                  } else {
                     var6 = class76.field1388.field1980.length - class106.field1868.field2728;
                     var7 = 512 - class170.field2706;
                     if(var7 > var6 - class76.field1388.field1979) {
                        var7 = var6 - class76.field1388.field1979;
                     }

                     if(var7 > var19) {
                        var7 = var19;
                     }

                     class89.field1549.method3002(class76.field1388.field1980, class76.field1388.field1979, var7);
                     if(class170.field2719 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class76.field1388.field1980[var8 + class76.field1388.field1979] ^= class170.field2719;
                        }
                     }

                     class76.field1388.field1979 += var7;
                     class170.field2706 += var7;
                     if(var6 == class76.field1388.field1979) {
                        if(class106.field1868.field3111 == 16711935L) {
                           class170.field2710 = class76.field1388;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class167 var20 = class170.field2708[var8];
                              if(null != var20) {
                                 class170.field2710.field1979 = 5 + var8 * 8;
                                 var10 = class170.field2710.method2517();
                                 int var21 = class170.field2710.method2517();
                                 var20.method3359(var10, var21);
                              }
                           }
                        } else {
                           class170.field2715.reset();
                           class170.field2715.update(class76.field1388.field1980, 0, var6);
                           var8 = (int)class170.field2715.getValue();
                           if(class106.field1868.field2727 != var8) {
                              try {
                                 class89.field1549.method3019();
                              } catch (Exception var16) {
                                 ;
                              }

                              ++class170.field2720;
                              class89.field1549 = null;
                              class170.field2719 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class170.field2720 = 0;
                           class170.field2721 = 0;
                           class106.field1868.field2731.method3373((int)(class106.field1868.field3111 & 65535L), class76.field1388.field1980, 16711680L == (class106.field1868.field3111 & 16711680L), class155.field2289);
                        }

                        class106.field1868.method3946();
                        if(class155.field2289) {
                           --class170.field2717;
                        } else {
                           --class170.field2713;
                        }

                        class170.field2706 = 0;
                        class106.field1868 = null;
                        class76.field1388 = null;
                     } else {
                        if(class170.field2706 != 512) {
                           break;
                        }

                        class170.field2706 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var17) {
            try {
               class89.field1549.method3019();
            } catch (Exception var15) {
               ;
            }

            ++class170.field2721;
            class89.field1549 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("r")
   void method979() {
      if(-1 != this.field1052) {
         this.method972(this.field1052);
         this.field1050 = this.field1053;
         this.field1048 = this.field1054;
         this.field1051 = this.field1055;
      }

      this.method972(this.field1049);
   }

   @ObfuscatedName("ay")
   static final void method984() {
      if(client.field405 == 1) {
         class14.field206[client.field355 / 100].method1805(client.field402 - 8, client.field403 - 8);
      }

      if(client.field405 == 2) {
         class14.field206[4 + client.field355 / 100].method1805(client.field402 - 8, client.field403 - 8);
      }

      class4.method54();
   }

   @ObfuscatedName("s")
   static void method985() {
      class31.field742 = class31.field742.trim();
      if(class31.field742.length() == 0) {
         class4.method56("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class34.method733();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = class103.method2304(var1, class31.field742);
         }

         switch(var0) {
         case 2:
            class4.method56("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field733 = 6;
            break;
         case 3:
            class4.method56("", "Error connecting to server.", "");
            break;
         case 4:
            class4.method56("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class4.method56("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class4.method56("", "Error connecting to server.", "");
            break;
         case 7:
            class4.method56("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("e")
   public static void method987() {
      Object var0 = class169.field2699;
      synchronized(class169.field2699) {
         if(0 != class169.field2695) {
            class169.field2695 = 1;

            try {
               class169.field2699.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1593142251"
   )
   static void method990() {
      for(class3 var0 = (class3)client.field454.method3836(); var0 != null; var0 = (class3)client.field454.method3827()) {
         int var1 = var0.field56;
         if(class103.method2303(var1)) {
            boolean var2 = true;
            class172[] var3 = class172.field2850[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2742;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3111;
               class172 var5 = class92.method2180(var4);
               if(null != var5) {
                  class36.method745(var5);
               }
            }
         }
      }

   }
}
