import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class32 {
   @ObfuscatedName("f")
   static byte[] field755 = new byte[2048];
   @ObfuscatedName("s")
   static byte[] field756 = new byte[2048];
   @ObfuscatedName("y")
   static class118[] field757 = new class118[2048];
   @ObfuscatedName("h")
   static int[] field758 = new int[2048];
   @ObfuscatedName("g")
   static int[] field759 = new int[2048];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1962560395
   )
   static int field760 = 0;
   @ObfuscatedName("j")
   static int[] field761 = new int[2048];
   @ObfuscatedName("go")
   static class172 field762;
   @ObfuscatedName("l")
   static int[] field763 = new int[2048];
   @ObfuscatedName("z")
   static class118 field764 = new class118(new byte[5000]);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1140879549
   )
   static int field765 = 0;
   @ObfuscatedName("v")
   static int[] field766 = new int[2048];
   @ObfuscatedName("bx")
   static String field768;
   @ObfuscatedName("aj")
   static class145 field769;
   @ObfuscatedName("n")
   static int[] field773 = new int[2048];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 799467117
   )
   static int field774 = 0;

   @ObfuscatedName("r")
   static void method693(File var0, File var1) {
      try {
         class226 var2 = new class226(class148.field2218, "rw", 10000L);
         class118 var3 = new class118(500);
         var3.method2497(3);
         var3.method2497(var1 != null?1:0);
         var3.method2505(var0.getPath());
         if(null != var1) {
            var3.method2505(var1.getPath());
         }

         var2.method4154(var3.field1980, 0, var3.field1979);
         var2.method4168();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-9586534"
   )
   public static void method710(String var0, boolean var1) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var3) {
               ;
            }
         }

         if(class137.field2123.startsWith("win")) {
            class112.method2445(var0, 0);
         } else if(class137.field2123.startsWith("mac")) {
            class126.method2829(var0, 1, "openjs");
         } else {
            class112.method2445(var0, 2);
         }
      } else {
         class112.method2445(var0, 3);
      }

   }

   @ObfuscatedName("r")
   public static class44 method711(int var0) {
      class44 var1 = (class44)class44.field1028.method3792((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class44.field1031.method3263(3, var0);
         var1 = new class44();
         if(var2 != null) {
            var1.method929(new class118(var2));
         }

         class44.field1028.method3794(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass85;Lclass107;I)V",
      garbageValue = "1026843332"
   )
   static final void method712(int var0, int var1, int var2, int var3, int var4, int var5, class85 var6, class107 var7) {
      if(!client.field297 || 0 != (class5.field90[0][var1][var2] & 2) || 0 == (class5.field90[var0][var1][var2] & 16)) {
         if(var0 < class5.field72) {
            class5.field72 = var0;
         }

         class40 var8 = class156.method3176(var3);
         int var9;
         int var10;
         if(var4 != 1 && 3 != var4) {
            var9 = var8.field938;
            var10 = var8.field939;
         } else {
            var9 = var8.field939;
            var10 = var8.field938;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (1 + var9 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.field86[var0];
         int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + var1 + (var2 << 7) + (var3 << 14);
         if(var8.field942 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field963 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method816()) {
            class23 var21 = new class23();
            var21.field607 = var0;
            var21.field609 = var1 * 128;
            var21.field619 = var2 * 128;
            var22 = var8.field938;
            var23 = var8.field939;
            if(1 == var4 || 3 == var4) {
               var22 = var8.field939;
               var23 = var8.field938;
            }

            var21.field610 = (var1 + var22) * 128;
            var21.field611 = (var23 + var2) * 128;
            var21.field613 = var8.field967;
            var21.field612 = var8.field968 * 128;
            var21.field615 = var8.field969;
            var21.field616 = var8.field970;
            var21.field617 = var8.field928;
            if(null != var8.field955) {
               var21.field620 = var8;
               var21.method582();
            }

            class23.field606.method3855(var21);
            if(null != var21.field617) {
               var21.field618 = var21.field615 + (int)(Math.random() * (double)(var21.field616 - var21.field615));
            }
         }

         Object var26;
         if(var5 == 22) {
            if(!client.field297 || var8.field942 != 0 || var8.field925 == 1 || var8.field961) {
               if(-1 == var8.field946 && null == var8.field955) {
                  var26 = var8.method811(22, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 22, var4, var0, var1, var2, var8.field946, true, (class84)null);
               }

               var6.method1928(var0, var1, var2, var16, (class84)var26, var19, var20);
               if(1 == var8.field925 && null != var7) {
                  var7.method2400(var1, var2);
               }

            }
         } else if(10 != var5 && var5 != 11) {
            if(var5 >= 12) {
               if(-1 == var8.field946 && null == var8.field955) {
                  var26 = var8.method811(var5, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field946, true, (class84)null);
               }

               var6.method1932(var0, var1, var2, var16, 1, 1, (class84)var26, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class5.field80[var0][var1][var2] |= 2340;
               }

               if(0 != var8.field925 && var7 != null) {
                  var7.method2398(var1, var2, var9, var10, var8.field941);
               }

            } else if(0 == var5) {
               if(-1 == var8.field946 && var8.field955 == null) {
                  var26 = var8.method811(0, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 0, var4, var0, var1, var2, var8.field946, true, (class84)null);
               }

               var6.method1972(var0, var1, var2, var16, (class84)var26, (class84)null, class5.field81[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field971) {
                     class5.field78[var0][var1][var2] = 50;
                     class5.field78[var0][var1][1 + var2] = 50;
                  }

                  if(var8.field929) {
                     class5.field80[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field971) {
                     class5.field78[var0][var1][1 + var2] = 50;
                     class5.field78[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field929) {
                     class5.field80[var0][var1][1 + var2] |= 1170;
                  }
               } else if(2 == var4) {
                  if(var8.field971) {
                     class5.field78[var0][var1 + 1][var2] = 50;
                     class5.field78[var0][1 + var1][1 + var2] = 50;
                  }

                  if(var8.field929) {
                     class5.field80[var0][var1 + 1][var2] |= 585;
                  }
               } else if(3 == var4) {
                  if(var8.field971) {
                     class5.field78[var0][var1][var2] = 50;
                     class5.field78[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.field929) {
                     class5.field80[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field925 != 0 && var7 != null) {
                  var7.method2416(var1, var2, var5, var4, var8.field941);
               }

               if(16 != var8.field951) {
                  var6.method1998(var0, var1, var2, var8.field951);
               }

            } else if(1 == var5) {
               if(-1 == var8.field946 && null == var8.field955) {
                  var26 = var8.method811(1, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 1, var4, var0, var1, var2, var8.field946, true, (class84)null);
               }

               var6.method1972(var0, var1, var2, var16, (class84)var26, (class84)null, class5.field82[var4], 0, var19, var20);
               if(var8.field971) {
                  if(var4 == 0) {
                     class5.field78[var0][var1][1 + var2] = 50;
                  } else if(var4 == 1) {
                     class5.field78[var0][1 + var1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class5.field78[var0][1 + var1][var2] = 50;
                  } else if(var4 == 3) {
                     class5.field78[var0][var1][var2] = 50;
                  }
               }

               if(0 != var8.field925 && null != var7) {
                  var7.method2416(var1, var2, var5, var4, var8.field941);
               }

            } else {
               int var27;
               Object var28;
               if(var5 == 2) {
                  var27 = 1 + var4 & 3;
                  Object var30;
                  if(var8.field946 == -1 && var8.field955 == null) {
                     var30 = var8.method811(2, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.method811(2, var27, var15, var17, var16, var18);
                  } else {
                     var30 = new class12(var3, 2, var4 + 4, var0, var1, var2, var8.field946, true, (class84)null);
                     var28 = new class12(var3, 2, var27, var0, var1, var2, var8.field946, true, (class84)null);
                  }

                  var6.method1972(var0, var1, var2, var16, (class84)var30, (class84)var28, class5.field81[var4], class5.field81[var27], var19, var20);
                  if(var8.field929) {
                     if(0 == var4) {
                        class5.field80[var0][var1][var2] |= 585;
                        class5.field80[var0][var1][1 + var2] |= 1170;
                     } else if(1 == var4) {
                        class5.field80[var0][var1][1 + var2] |= 1170;
                        class5.field80[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class5.field80[var0][1 + var1][var2] |= 585;
                        class5.field80[var0][var1][var2] |= 1170;
                     } else if(3 == var4) {
                        class5.field80[var0][var1][var2] |= 1170;
                        class5.field80[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field925 != 0 && null != var7) {
                     var7.method2416(var1, var2, var5, var4, var8.field941);
                  }

                  if(var8.field951 != 16) {
                     var6.method1998(var0, var1, var2, var8.field951);
                  }

               } else if(3 == var5) {
                  if(var8.field946 == -1 && null == var8.field955) {
                     var26 = var8.method811(3, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 3, var4, var0, var1, var2, var8.field946, true, (class84)null);
                  }

                  var6.method1972(var0, var1, var2, var16, (class84)var26, (class84)null, class5.field82[var4], 0, var19, var20);
                  if(var8.field971) {
                     if(0 == var4) {
                        class5.field78[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class5.field78[var0][1 + var1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class5.field78[var0][var1 + 1][var2] = 50;
                     } else if(3 == var4) {
                        class5.field78[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field925 != 0 && var7 != null) {
                     var7.method2416(var1, var2, var5, var4, var8.field941);
                  }

               } else if(var5 == 9) {
                  if(-1 == var8.field946 && null == var8.field955) {
                     var26 = var8.method811(var5, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field946, true, (class84)null);
                  }

                  var6.method1932(var0, var1, var2, var16, 1, 1, (class84)var26, 0, var19, var20);
                  if(0 != var8.field925 && var7 != null) {
                     var7.method2398(var1, var2, var9, var10, var8.field941);
                  }

                  if(var8.field951 != 16) {
                     var6.method1998(var0, var1, var2, var8.field951);
                  }

               } else if(var5 == 4) {
                  if(-1 == var8.field946 && var8.field955 == null) {
                     var26 = var8.method811(4, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field946, true, (class84)null);
                  }

                  var6.method1931(var0, var1, var2, var16, (class84)var26, (class84)null, class5.field81[var4], 0, 0, 0, var19, var20);
               } else if(5 == var5) {
                  var27 = 16;
                  var22 = var6.method1948(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class156.method3176(var22 >> 14 & 32767).field951;
                  }

                  if(var8.field946 == -1 && null == var8.field955) {
                     var28 = var8.method811(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4, var0, var1, var2, var8.field946, true, (class84)null);
                  }

                  var6.method1931(var0, var1, var2, var16, (class84)var28, (class84)null, class5.field81[var4], 0, var27 * class5.field83[var4], var27 * class5.field84[var4], var19, var20);
               } else if(var5 == 6) {
                  var27 = 8;
                  var22 = var6.method1948(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class156.method3176(var22 >> 14 & 32767).field951 / 2;
                  }

                  if(-1 == var8.field946 && null == var8.field955) {
                     var28 = var8.method811(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field946, true, (class84)null);
                  }

                  var6.method1931(var0, var1, var2, var16, (class84)var28, (class84)null, 256, var4, class5.field79[var4] * var27, class5.field77[var4] * var27, var19, var20);
               } else if(7 == var5) {
                  var22 = var4 + 2 & 3;
                  if(-1 == var8.field946 && null == var8.field955) {
                     var26 = var8.method811(4, 4 + var22, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field946, true, (class84)null);
                  }

                  var6.method1931(var0, var1, var2, var16, (class84)var26, (class84)null, 256, var22, 0, 0, var19, var20);
               } else if(8 == var5) {
                  var27 = 8;
                  var22 = var6.method1948(var0, var1, var2);
                  if(var22 != 0) {
                     var27 = class156.method3176(var22 >> 14 & 32767).field951 / 2;
                  }

                  int var25 = 2 + var4 & 3;
                  Object var29;
                  if(-1 == var8.field946 && var8.field955 == null) {
                     var28 = var8.method811(4, 4 + var4, var15, var17, var16, var18);
                     var29 = var8.method811(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field946, true, (class84)null);
                     var29 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field946, true, (class84)null);
                  }

                  var6.method1931(var0, var1, var2, var16, (class84)var28, (class84)var29, 256, var4, var27 * class5.field79[var4], var27 * class5.field77[var4], var19, var20);
               }
            }
         } else {
            if(var8.field946 == -1 && null == var8.field955) {
               var26 = var8.method811(10, var4, var15, var17, var16, var18);
            } else {
               var26 = new class12(var3, 10, var4, var0, var1, var2, var8.field946, true, (class84)null);
            }

            if(null != var26 && var6.method1932(var0, var1, var2, var16, var9, var10, (class84)var26, 11 == var5?256:0, var19, var20) && var8.field971) {
               var22 = 15;
               if(var26 instanceof class104) {
                  var22 = ((class104)var26).method2333() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class5.field78[var0][var1 + var23][var24 + var2]) {
                        class5.field78[var0][var1 + var23][var2 + var24] = (byte)var22;
                     }
                  }
               }
            }

            if(0 != var8.field925 && var7 != null) {
               var7.method2398(var1, var2, var9, var10, var8.field941);
            }

         }
      }
   }

   @ObfuscatedName("g")
   public static class153[] method713() {
      return new class153[]{class153.field2271, class153.field2276, class153.field2275, class153.field2268, class153.field2269, class153.field2267};
   }
}
