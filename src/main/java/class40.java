import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("ObjectComposition")
public class class40 extends class204 {
   @ObfuscatedName("ai")
   @Export("actions")
   public String[] field898 = new String[5];
   @ObfuscatedName("w")
   static class167 field899;
   @ObfuscatedName("m")
   int[] field900;
   @ObfuscatedName("f")
   static class167 field901;
   @ObfuscatedName("p")
   public static class193 field902 = new class193(500);
   @ObfuscatedName("h")
   public static class193 field903 = new class193(30);
   @ObfuscatedName("g")
   public static class193 field904 = new class193(30);
   @ObfuscatedName("a")
   static class100[] field905 = new class100[4];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2029991413
   )
   public int field906;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -326490791
   )
   int field907 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -89982029
   )
   public int field908 = 1;
   @ObfuscatedName("n")
   @Export("name")
   public String field909 = "null";
   @ObfuscatedName("y")
   short[] field910;
   @ObfuscatedName("i")
   short[] field911;
   @ObfuscatedName("j")
   short[] field912;
   @ObfuscatedName("l")
   short[] field913;
   @ObfuscatedName("aw")
   boolean field914 = false;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1396670059
   )
   public int field915 = 1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1276153345
   )
   public int field916 = -1;
   @ObfuscatedName("b")
   public boolean field917 = true;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1109556461
   )
   int field918 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -183723401
   )
   int field919 = -1;
   @ObfuscatedName("t")
   boolean field920 = false;
   @ObfuscatedName("d")
   public boolean field921 = false;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1202209519
   )
   public int field922 = -1;
   @ObfuscatedName("aa")
   public int[] field923;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -979536097
   )
   public int field924 = 2;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1994579653
   )
   int field925 = 0;
   @ObfuscatedName("k")
   int[] field926;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1290063829
   )
   public int field927 = -1;
   @ObfuscatedName("s")
   public static class193 field928 = new class193(64);
   @ObfuscatedName("ar")
   public boolean field930 = true;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 404987155
   )
   int field931 = 128;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1642731113
   )
   int field932 = 128;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1737059011
   )
   int field933 = 128;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 370442929
   )
   int field934 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 634295565
   )
   public int field935 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 733006145
   )
   int field936 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1285641711
   )
   public int field937 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1332753547
   )
   public int field938 = -1;
   @ObfuscatedName("e")
   static boolean field939 = false;
   @ObfuscatedName("am")
   public boolean field940 = false;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 724747199
   )
   int field941 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -65391853
   )
   int field942 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1905240613
   )
   public int field943 = -1;
   @ObfuscatedName("ah")
   boolean field944 = false;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1965082643
   )
   public int field945 = 16;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 301093123
   )
   public int field946 = 0;
   @ObfuscatedName("al")
   public int[] field947;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -611869519
   )
   public int field948 = -1;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "124"
   )
   void method788() {
      if(-1 == this.field922) {
         this.field922 = 0;
         if(this.field926 != null && (null == this.field900 || this.field900[0] == 10)) {
            this.field922 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.field898[var1]) {
               this.field922 = 1;
            }
         }
      }

      if(this.field948 == -1) {
         this.field948 = this.field924 != 0?1:0;
      }

   }

   @ObfuscatedName("s")
   void method789(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(var2 == 0) {
            return;
         }

         this.method835(var1, var2);
      }
   }

   @ObfuscatedName("h")
   public final boolean method791(int var1) {
      if(null != this.field900) {
         for(int var4 = 0; var4 < this.field900.length; ++var4) {
            if(var1 == this.field900[var4]) {
               return field901.method3264(this.field926[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field926 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field926.length; ++var3) {
            var2 &= field901.method3264(this.field926[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("g")
   public final boolean method792() {
      if(this.field926 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field926.length; ++var2) {
            var1 &= field901.method3264(this.field926[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("a")
   public final class85 method793(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field900) {
         var7 = (long)((this.field906 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field906 << 10) + var2);
      }

      Object var9 = (class85)field903.method3754(var7);
      if(null == var9) {
         class100 var10 = this.method810(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field920) {
            var9 = var10.method2236(64 + this.field907, this.field925 + 768, -50, -10, -50);
         } else {
            var10.field1698 = (short)(64 + this.field907);
            var10.field1699 = (short)(768 + this.field925);
            var10.method2238();
            var9 = var10;
         }

         field903.method3756((class204)var9, var7);
      }

      if(this.field920) {
         var9 = ((class100)var9).method2296();
      }

      if(this.field919 >= 0) {
         if(var9 instanceof class105) {
            var9 = ((class105)var9).method2367(var3, var4, var5, var6, true, this.field919);
         } else if(var9 instanceof class100) {
            var9 = ((class100)var9).method2244(var3, var4, var5, var6, this.field919);
         }
      }

      return (class85)var9;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass168;IIIBZB)V",
      garbageValue = "4"
   )
   static void method794(class168 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class172 var8 = (class172)class171.field2715.method3788(var6);
      if(var8 == null) {
         var8 = (class172)class171.field2725.method3788(var6);
         if(var8 == null) {
            var8 = (class172)class171.field2720.method3788(var6);
            if(null != var8) {
               if(var5) {
                  var8.method3891();
                  class171.field2715.method3789(var8, var6);
                  --class171.field2721;
                  ++class171.field2730;
               }

            } else {
               if(!var5) {
                  var8 = (class172)class171.field2712.method3788(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class172();
               var8.field2737 = var0;
               var8.field2738 = var3;
               var8.field2739 = var4;
               if(var5) {
                  class171.field2715.method3789(var8, var6);
                  ++class171.field2730;
               } else {
                  class171.field2719.method3875(var8);
                  class171.field2720.method3789(var8, var6);
                  ++class171.field2721;
               }

            }
         }
      }
   }

   @ObfuscatedName("k")
   public final class105 method795(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(this.field900 == null) {
         var9 = (long)(var2 + (this.field906 << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field906 << 10));
      }

      class105 var11 = (class105)field904.method3754(var9);
      if(var11 == null) {
         class100 var12 = this.method810(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2236(this.field907 + 64, this.field925 + 768, -50, -10, -50);
         field904.method3756(var11, var9);
      }

      if(var7 == null && -1 == this.field919) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method861(var11, var8, var2);
         } else {
            var11 = var11.method2324(true);
         }

         if(this.field919 >= 0) {
            var11 = var11.method2367(var3, var4, var5, var6, false, this.field919);
         }

         return var11;
      }
   }

   @ObfuscatedName("n")
   public final class40 method797() {
      int var1 = -1;
      if(this.field941 != -1) {
         var1 = class142.method2979(this.field941);
      } else if(-1 != this.field942) {
         var1 = class176.field2903[this.field942];
      }

      return var1 >= 0 && var1 < this.field923.length && this.field923[var1] != -1?class26.method633(this.field923[var1]):null;
   }

   @ObfuscatedName("r")
   public final class105 method799(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field900 == null) {
         var7 = (long)((this.field906 << 10) + var2);
      } else {
         var7 = (long)((this.field906 << 10) + (var1 << 3) + var2);
      }

      class105 var9 = (class105)field904.method3754(var7);
      if(null == var9) {
         class100 var10 = this.method810(var1, var2);
         if(null == var10) {
            return null;
         }

         var9 = var10.method2236(64 + this.field907, this.field925 + 768, -50, -10, -50);
         field904.method3756(var9, var7);
      }

      if(this.field919 >= 0) {
         var9 = var9.method2367(var3, var4, var5, var6, true, this.field919);
      }

      return var9;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIB)V",
      garbageValue = "115"
   )
   static final void method806(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class173 var9 = var0[var8];
         if(var9 != null && (!var9.field2809 || 0 == var9.field2757 || var9.field2835 || class75.method1642(var9) != 0 || client.field452 == var9 || 1338 == var9.field2833) && var9.field2774 == var1 && (!var9.field2809 || !class21.method579(var9))) {
            int var10 = var6 + var9.field2880;
            int var11 = var7 + var9.field2769;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(2 == var9.field2757) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(9 == var9.field2757) {
               var16 = var10;
               var17 = var11;
               var18 = var10 + var9.field2770;
               var19 = var11 + var9.field2834;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.field2770 + var10;
               var17 = var11 + var9.field2834;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == client.field451) {
               client.field459 = true;
               client.field460 = var10;
               client.field294 = var11;
            }

            if(!var9.field2809 || var12 < var14 && var13 < var15) {
               var16 = class140.field2140;
               var17 = class140.field2141;
               if(0 != class140.field2146) {
                  var16 = class140.field2135;
                  var17 = class140.field2148;
               }

               int var21;
               int var22;
               int var23;
               int var24;
               int var27;
               int var34;
               int var46;
               if(var9.field2833 == 1337) {
                  if(!client.field288 && !client.field331 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(client.field431 == 0 && !client.field433) {
                        class11.method156("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var34 = 0; var34 < class105.field1833; ++var34) {
                        var21 = class105.field1803[var34];
                        var22 = var21 & 127;
                        var23 = var21 >> 7 & 127;
                        var24 = var21 >> 29 & 3;
                        var46 = var21 >> 14 & 32767;
                        if(var19 != var21) {
                           var19 = var21;
                           if(2 == var24 && class151.field2250.method1979(class48.field1063, var22, var23, var21) >= 0) {
                              class40 var49 = class26.method633(var46);
                              if(null != var49.field923) {
                                 var49 = var49.method797();
                              }

                              if(null == var49) {
                                 continue;
                              }

                              if(1 == client.field431) {
                                 class11.method156("Use", client.field392 + " " + "->" + " " + class39.method784('\uffff') + var49.field909, 1, var21, var22, var23);
                              } else if(client.field433) {
                                 if((class190.field3048 & 4) == 4) {
                                    class11.method156(client.field377, client.field437 + " " + "->" + " " + class39.method784('\uffff') + var49.field909, 2, var21, var22, var23);
                                 }
                              } else {
                                 String[] var50 = var49.field898;
                                 if(client.field539) {
                                    var50 = class9.method130(var50);
                                 }

                                 if(null != var50) {
                                    for(int var58 = 4; var58 >= 0; --var58) {
                                       if(null != var50[var58]) {
                                          short var29 = 0;
                                          if(var58 == 0) {
                                             var29 = 3;
                                          }

                                          if(var58 == 1) {
                                             var29 = 4;
                                          }

                                          if(var58 == 2) {
                                             var29 = 5;
                                          }

                                          if(var58 == 3) {
                                             var29 = 6;
                                          }

                                          if(var58 == 4) {
                                             var29 = 1001;
                                          }

                                          class11.method156(var50[var58], class39.method784('\uffff') + var49.field909, var29, var21, var22, var23);
                                       }
                                    }
                                 }

                                 class11.method156("Examine", class39.method784('\uffff') + var49.field909, 1002, var49.field906 << 14, var22, var23);
                              }
                           }

                           class2 var30;
                           int var55;
                           class34 var59;
                           int[] var60;
                           if(var24 == 1) {
                              class34 var51 = client.field316[var46];
                              if(var51 == null) {
                                 continue;
                              }

                              if(var51.field755.field871 == 1 && (var51.field804 & 127) == 64 && 64 == (var51.field814 & 127)) {
                                 for(var27 = 0; var27 < client.field317; ++var27) {
                                    var59 = client.field316[client.field318[var27]];
                                    if(null != var59 && var59 != var51 && 1 == var59.field755.field871 && var51.field804 == var59.field804 && var51.field814 == var59.field814) {
                                       class225.method4107(var59.field755, client.field318[var27], var22, var23);
                                    }
                                 }

                                 var27 = class32.field731;
                                 var60 = class32.field732;

                                 for(var55 = 0; var55 < var27; ++var55) {
                                    var30 = client.field387[var60[var55]];
                                    if(var30 != null && var30.field804 == var51.field804 && var30.field814 == var51.field814) {
                                       class24.method593(var30, var60[var55], var22, var23);
                                    }
                                 }
                              }

                              class225.method4107(var51.field755, var46, var22, var23);
                           }

                           if(var24 == 0) {
                              class2 var52 = client.field387[var46];
                              if(null == var52) {
                                 continue;
                              }

                              if((var52.field804 & 127) == 64 && (var52.field814 & 127) == 64) {
                                 for(var27 = 0; var27 < client.field317; ++var27) {
                                    var59 = client.field316[client.field318[var27]];
                                    if(null != var59 && var59.field755.field871 == 1 && var52.field804 == var59.field804 && var52.field814 == var59.field814) {
                                       class225.method4107(var59.field755, client.field318[var27], var22, var23);
                                    }
                                 }

                                 var27 = class32.field731;
                                 var60 = class32.field732;

                                 for(var55 = 0; var55 < var27; ++var55) {
                                    var30 = client.field387[var60[var55]];
                                    if(var30 != null && var30 != var52 && var30.field804 == var52.field804 && var52.field814 == var30.field814) {
                                       class24.method593(var30, var60[var55], var22, var23);
                                    }
                                 }
                              }

                              if(var46 != client.field409) {
                                 class24.method593(var52, var46, var22, var23);
                              } else {
                                 var18 = var21;
                              }
                           }

                           if(3 == var24) {
                              class199 var53 = client.field410[class48.field1063][var22][var23];
                              if(var53 != null) {
                                 for(class28 var56 = (class28)var53.method3818(); var56 != null; var56 = (class28)var53.method3844()) {
                                    class51 var61 = class33.method711(var56.field666);
                                    if(1 == client.field431) {
                                       class11.method156("Use", client.field392 + " " + "->" + " " + class39.method784(16748608) + var61.field1091, 16, var56.field666, var22, var23);
                                    } else if(client.field433) {
                                       if((class190.field3048 & 1) == 1) {
                                          class11.method156(client.field377, client.field437 + " " + "->" + " " + class39.method784(16748608) + var61.field1091, 17, var56.field666, var22, var23);
                                       }
                                    } else {
                                       String[] var57 = var61.field1105;
                                       if(client.field539) {
                                          var57 = class9.method130(var57);
                                       }

                                       for(int var54 = 4; var54 >= 0; --var54) {
                                          if(var57 != null && null != var57[var54]) {
                                             byte var31 = 0;
                                             if(var54 == 0) {
                                                var31 = 18;
                                             }

                                             if(var54 == 1) {
                                                var31 = 19;
                                             }

                                             if(var54 == 2) {
                                                var31 = 20;
                                             }

                                             if(var54 == 3) {
                                                var31 = 21;
                                             }

                                             if(4 == var54) {
                                                var31 = 22;
                                             }

                                             class11.method156(var57[var54], class39.method784(16748608) + var61.field1091, var31, var56.field666, var22, var23);
                                          } else if(2 == var54) {
                                             class11.method156("Take", class39.method784(16748608) + var61.field1091, 20, var56.field666, var22, var23);
                                          }
                                       }

                                       class11.method156("Examine", class39.method784(16748608) + var61.field1091, 1004, var56.field666, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var34 = var18 & 127;
                        var21 = var18 >> 7 & 127;
                        class2 var47 = client.field387[client.field409];
                        class24.method593(var47, client.field409, var34, var21);
                     }
                  }
               } else if(var9.field2833 == 1338) {
                  if((0 == client.field514 || client.field514 == 3) && (class140.field2146 == 1 || !class3.field66 && class140.field2146 == 4)) {
                     class175 var43 = var9.method3381(true);
                     if(var43 != null) {
                        var19 = class140.field2135 - var10;
                        var34 = class140.field2148 - var11;
                        if(var43.method3426(var19, var34)) {
                           var19 -= var43.field2899 / 2;
                           var34 -= var43.field2897 / 2;
                           var21 = client.field350 + client.field368 & 2047;
                           var22 = class91.field1568[var21];
                           var23 = class91.field1554[var21];
                           var22 = (256 + client.field352) * var22 >> 8;
                           var23 = var23 * (256 + client.field352) >> 8;
                           var24 = var34 * var22 + var23 * var19 >> 11;
                           var46 = var23 * var34 - var19 * var22 >> 11;
                           int var48 = var24 + class20.field572.field804 >> 7;
                           var27 = class20.field572.field814 - var46 >> 7;
                           client.field321.method2762(42);
                           client.field321.method2565(18);
                           client.field321.method2565(class137.field2103[82]?(class137.field2103[81]?2:1):0);
                           client.field321.method2556(class6.field128 + var27);
                           client.field321.method2548(class85.field1439 + var48);
                           client.field321.method2565(var19);
                           client.field321.method2565(var34);
                           client.field321.method2713(client.field368);
                           client.field321.method2565(57);
                           client.field321.method2565(client.field350);
                           client.field321.method2565(client.field352);
                           client.field321.method2565(89);
                           client.field321.method2713(class20.field572.field804);
                           client.field321.method2713(class20.field572.field814);
                           client.field321.method2565(63);
                           client.field432 = var48;
                           client.field513 = var27;
                        }
                     }
                  }
               } else {
                  if(!client.field331 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2758 == 1) {
                        class11.method156(var9.field2872, "", 24, 0, 0, var9.field2794);
                     }

                     String var20;
                     if(var9.field2758 == 2 && !client.field433) {
                        var20 = class84.method1918(var9);
                        if(var20 != null) {
                           class11.method156(var20, class39.method784('\uff00') + var9.field2803, 25, 0, -1, var9.field2794);
                        }
                     }

                     if(var9.field2758 == 3) {
                        class11.method156("Close", "", 26, 0, 0, var9.field2794);
                     }

                     if(4 == var9.field2758) {
                        class11.method156(var9.field2872, "", 28, 0, 0, var9.field2794);
                     }

                     if(5 == var9.field2758) {
                        class11.method156(var9.field2872, "", 29, 0, 0, var9.field2794);
                     }

                     if(6 == var9.field2758 && client.field442 == null) {
                        class11.method156(var9.field2872, "", 30, 0, -1, var9.field2794);
                     }

                     if(var9.field2757 == 2) {
                        var34 = 0;

                        for(var21 = 0; var21 < var9.field2834; ++var21) {
                           for(var22 = 0; var22 < var9.field2770; ++var22) {
                              var23 = var22 * (32 + var9.field2754);
                              var24 = (32 + var9.field2799) * var21;
                              if(var34 < 20) {
                                 var23 += var9.field2823[var34];
                                 var24 += var9.field2841[var34];
                              }

                              if(var18 >= var23 && var19 >= var24 && var18 < 32 + var23 && var19 < 32 + var24) {
                                 client.field400 = var34;
                                 class143.field2182 = var9;
                                 if(var9.field2759[var34] > 0) {
                                    class51 var25 = class33.method711(var9.field2759[var34] - 1);
                                    if(1 == client.field431 && class29.method669(class75.method1642(var9))) {
                                       if(var9.field2794 != class59.field1185 || class172.field2741 != var34) {
                                          class11.method156("Use", client.field392 + " " + "->" + " " + class39.method784(16748608) + var25.field1091, 31, var25.field1089, var34, var9.field2794);
                                       }
                                    } else if(client.field433 && class29.method669(class75.method1642(var9))) {
                                       if(16 == (class190.field3048 & 16)) {
                                          class11.method156(client.field377, client.field437 + " " + "->" + " " + class39.method784(16748608) + var25.field1091, 32, var25.field1089, var34, var9.field2794);
                                       }
                                    } else {
                                       String[] var26 = var25.field1130;
                                       if(client.field539) {
                                          var26 = class9.method130(var26);
                                       }

                                       byte var28;
                                       if(class29.method669(class75.method1642(var9))) {
                                          for(var27 = 4; var27 >= 3; --var27) {
                                             if(var26 != null && var26[var27] != null) {
                                                if(var27 == 3) {
                                                   var28 = 36;
                                                } else {
                                                   var28 = 37;
                                                }

                                                class11.method156(var26[var27], class39.method784(16748608) + var25.field1091, var28, var25.field1089, var34, var9.field2794);
                                             } else if(var27 == 4) {
                                                class11.method156("Drop", class39.method784(16748608) + var25.field1091, 37, var25.field1089, var34, var9.field2794);
                                             }
                                          }
                                       }

                                       if(class0.method3(class75.method1642(var9))) {
                                          class11.method156("Use", class39.method784(16748608) + var25.field1091, 38, var25.field1089, var34, var9.field2794);
                                       }

                                       if(class29.method669(class75.method1642(var9)) && null != var26) {
                                          for(var27 = 2; var27 >= 0; --var27) {
                                             if(var26[var27] != null) {
                                                var28 = 0;
                                                if(0 == var27) {
                                                   var28 = 33;
                                                }

                                                if(1 == var27) {
                                                   var28 = 34;
                                                }

                                                if(2 == var27) {
                                                   var28 = 35;
                                                }

                                                class11.method156(var26[var27], class39.method784(16748608) + var25.field1091, var28, var25.field1089, var34, var9.field2794);
                                             }
                                          }
                                       }

                                       var26 = var9.field2826;
                                       if(client.field539) {
                                          var26 = class9.method130(var26);
                                       }

                                       if(var26 != null) {
                                          for(var27 = 4; var27 >= 0; --var27) {
                                             if(null != var26[var27]) {
                                                var28 = 0;
                                                if(0 == var27) {
                                                   var28 = 39;
                                                }

                                                if(var27 == 1) {
                                                   var28 = 40;
                                                }

                                                if(2 == var27) {
                                                   var28 = 41;
                                                }

                                                if(var27 == 3) {
                                                   var28 = 42;
                                                }

                                                if(4 == var27) {
                                                   var28 = 43;
                                                }

                                                class11.method156(var26[var27], class39.method784(16748608) + var25.field1091, var28, var25.field1089, var34, var9.field2794);
                                             }
                                          }
                                       }

                                       class11.method156("Examine", class39.method784(16748608) + var25.field1091, 1005, var25.field1089, var34, var9.field2794);
                                    }
                                 }
                              }

                              ++var34;
                           }
                        }
                     }

                     if(var9.field2809) {
                        if(client.field433) {
                           if(class59.method1265(class75.method1642(var9)) && (class190.field3048 & 32) == 32) {
                              class11.method156(client.field377, client.field437 + " " + "->" + " " + var9.field2828, 58, 0, var9.field2816, var9.field2794);
                           }
                        } else {
                           for(var34 = 9; var34 >= 5; --var34) {
                              String var38 = class93.method2182(var9, var34);
                              if(null != var38) {
                                 class11.method156(var38, var9.field2828, 1007, var34 + 1, var9.field2816, var9.field2794);
                              }
                           }

                           var20 = class84.method1918(var9);
                           if(null != var20) {
                              class11.method156(var20, var9.field2828, 25, 0, var9.field2816, var9.field2794);
                           }

                           for(var21 = 4; var21 >= 0; --var21) {
                              String var41 = class93.method2182(var9, var21);
                              if(var41 != null) {
                                 class11.method156(var41, var9.field2828, 57, 1 + var21, var9.field2816, var9.field2794);
                              }
                           }

                           var22 = class75.method1642(var9);
                           boolean var40 = 0 != (var22 & 1);
                           if(var40) {
                              class11.method156("Continue", "", 30, 0, var9.field2816, var9.field2794);
                           }
                        }
                     }
                  }

                  if(0 == var9.field2757) {
                     if(!var9.field2809 && class21.method579(var9) && var9 != class7.field138) {
                        continue;
                     }

                     method806(var0, var9.field2794, var12, var13, var14, var15, var10 - var9.field2776, var11 - var9.field2815);
                     if(null != var9.field2879) {
                        method806(var9.field2879, var9.field2794, var12, var13, var14, var15, var10 - var9.field2776, var11 - var9.field2815);
                     }

                     class3 var32 = (class3)client.field439.method3788((long)var9.field2794);
                     if(null != var32) {
                        if(var32.field64 == 0 && class140.field2140 >= var12 && class140.field2141 >= var13 && class140.field2140 < var14 && class140.field2141 < var15 && !client.field331 && !client.field448) {
                           for(class0 var35 = (class0)client.field466.method3825(); var35 != null; var35 = (class0)client.field466.method3827()) {
                              if(var35.field0) {
                                 var35.method3913();
                                 var35.field2.field2856 = false;
                              }
                           }

                           if(0 == class7.field139) {
                              client.field451 = null;
                              client.field452 = null;
                           }

                           if(!client.field331) {
                              client.field425[0] = "Cancel";
                              client.field426[0] = "";
                              client.field301[0] = 1006;
                              client.field420 = 1;
                           }
                        }

                        var19 = var32.field69;
                        if(class113.method2462(var19)) {
                           method806(class173.field2837[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2809) {
                     class0 var33;
                     if(!var9.field2888) {
                        if(var9.field2889 && class140.field2140 >= var12 && class140.field2141 >= var13 && class140.field2140 < var14 && class140.field2141 < var15) {
                           for(var33 = (class0)client.field466.method3825(); var33 != null; var33 = (class0)client.field466.method3827()) {
                              if(var33.field0 && var33.field11 == var33.field2.field2821) {
                                 var33.method3913();
                              }
                           }
                        }
                     } else if(class140.field2140 >= var12 && class140.field2141 >= var13 && class140.field2140 < var14 && class140.field2141 < var15) {
                        for(var33 = (class0)client.field466.method3825(); var33 != null; var33 = (class0)client.field466.method3827()) {
                           if(var33.field0) {
                              var33.method3913();
                              var33.field2.field2856 = false;
                           }
                        }

                        if(0 == class7.field139) {
                           client.field451 = null;
                           client.field452 = null;
                        }

                        if(!client.field331) {
                           client.field425[0] = "Cancel";
                           client.field426[0] = "";
                           client.field301[0] = 1006;
                           client.field420 = 1;
                        }
                     }

                     boolean var36;
                     if(class140.field2140 >= var12 && class140.field2141 >= var13 && class140.field2140 < var14 && class140.field2141 < var15) {
                        var36 = true;
                     } else {
                        var36 = false;
                     }

                     boolean var37 = false;
                     if((class140.field2136 == 1 || !class3.field66 && 4 == class140.field2136) && var36) {
                        var37 = true;
                     }

                     boolean var39 = false;
                     if((class140.field2146 == 1 || !class3.field66 && class140.field2146 == 4) && class140.field2135 >= var12 && class140.field2148 >= var13 && class140.field2135 < var14 && class140.field2148 < var15) {
                        var39 = true;
                     }

                     if(var39) {
                        class157.method3168(var9, class140.field2135 - var10, class140.field2148 - var11);
                     }

                     if(null != client.field451 && client.field451 != var9 && var36 && class59.method1264(class75.method1642(var9))) {
                        client.field455 = var9;
                     }

                     if(var9 == client.field452) {
                        client.field509 = true;
                        client.field527 = var10;
                        client.field458 = var11;
                     }

                     if(var9.field2835) {
                        class0 var42;
                        if(var36 && 0 != client.field476 && null != var9.field2821) {
                           var42 = new class0();
                           var42.field0 = true;
                           var42.field2 = var9;
                           var42.field4 = client.field476;
                           var42.field11 = var9.field2821;
                           client.field466.method3834(var42);
                        }

                        if(client.field451 != null || class142.field2170 != null || client.field331) {
                           var39 = false;
                           var37 = false;
                           var36 = false;
                        }

                        if(!var9.field2881 && var39) {
                           var9.field2881 = true;
                           if(var9.field2750 != null) {
                              var42 = new class0();
                              var42.field0 = true;
                              var42.field2 = var9;
                              var42.field3 = class140.field2135 - var10;
                              var42.field4 = class140.field2148 - var11;
                              var42.field11 = var9.field2750;
                              client.field466.method3834(var42);
                           }
                        }

                        if(var9.field2881 && var37 && null != var9.field2838) {
                           var42 = new class0();
                           var42.field0 = true;
                           var42.field2 = var9;
                           var42.field3 = class140.field2140 - var10;
                           var42.field4 = class140.field2141 - var11;
                           var42.field11 = var9.field2838;
                           client.field466.method3834(var42);
                        }

                        if(var9.field2881 && !var37) {
                           var9.field2881 = false;
                           if(null != var9.field2790) {
                              var42 = new class0();
                              var42.field0 = true;
                              var42.field2 = var9;
                              var42.field3 = class140.field2140 - var10;
                              var42.field4 = class140.field2141 - var11;
                              var42.field11 = var9.field2790;
                              client.field479.method3834(var42);
                           }
                        }

                        if(var37 && null != var9.field2840) {
                           var42 = new class0();
                           var42.field0 = true;
                           var42.field2 = var9;
                           var42.field3 = class140.field2140 - var10;
                           var42.field4 = class140.field2141 - var11;
                           var42.field11 = var9.field2840;
                           client.field466.method3834(var42);
                        }

                        if(!var9.field2856 && var36) {
                           var9.field2856 = true;
                           if(var9.field2832 != null) {
                              var42 = new class0();
                              var42.field0 = true;
                              var42.field2 = var9;
                              var42.field3 = class140.field2140 - var10;
                              var42.field4 = class140.field2141 - var11;
                              var42.field11 = var9.field2832;
                              client.field466.method3834(var42);
                           }
                        }

                        if(var9.field2856 && var36 && null != var9.field2842) {
                           var42 = new class0();
                           var42.field0 = true;
                           var42.field2 = var9;
                           var42.field3 = class140.field2140 - var10;
                           var42.field4 = class140.field2141 - var11;
                           var42.field11 = var9.field2842;
                           client.field466.method3834(var42);
                        }

                        if(var9.field2856 && !var36) {
                           var9.field2856 = false;
                           if(var9.field2843 != null) {
                              var42 = new class0();
                              var42.field0 = true;
                              var42.field2 = var9;
                              var42.field3 = class140.field2140 - var10;
                              var42.field4 = class140.field2141 - var11;
                              var42.field11 = var9.field2843;
                              client.field479.method3834(var42);
                           }
                        }

                        if(null != var9.field2875) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field11 = var9.field2875;
                           client.field478.method3834(var42);
                        }

                        class0 var45;
                        if(var9.field2848 != null && client.field557 > var9.field2883) {
                           if(null != var9.field2849 && client.field557 - var9.field2883 <= 32) {
                              label1371:
                              for(var21 = var9.field2883; var21 < client.field557; ++var21) {
                                 var22 = client.field464[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2849.length; ++var23) {
                                    if(var9.field2849[var23] == var22) {
                                       var45 = new class0();
                                       var45.field2 = var9;
                                       var45.field11 = var9.field2848;
                                       client.field466.method3834(var45);
                                       break label1371;
                                    }
                                 }
                              }
                           } else {
                              var42 = new class0();
                              var42.field2 = var9;
                              var42.field11 = var9.field2848;
                              client.field466.method3834(var42);
                           }

                           var9.field2883 = client.field557;
                        }

                        if(var9.field2850 != null && client.field467 > var9.field2884) {
                           if(var9.field2851 != null && client.field467 - var9.field2884 <= 32) {
                              label1347:
                              for(var21 = var9.field2884; var21 < client.field467; ++var21) {
                                 var22 = client.field481[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2851.length; ++var23) {
                                    if(var22 == var9.field2851[var23]) {
                                       var45 = new class0();
                                       var45.field2 = var9;
                                       var45.field11 = var9.field2850;
                                       client.field466.method3834(var45);
                                       break label1347;
                                    }
                                 }
                              }
                           } else {
                              var42 = new class0();
                              var42.field2 = var9;
                              var42.field11 = var9.field2850;
                              client.field466.method3834(var42);
                           }

                           var9.field2884 = client.field467;
                        }

                        if(null != var9.field2852 && client.field469 > var9.field2885) {
                           if(null != var9.field2777 && client.field469 - var9.field2885 <= 32) {
                              label1323:
                              for(var21 = var9.field2885; var21 < client.field469; ++var21) {
                                 var22 = client.field468[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2777.length; ++var23) {
                                    if(var9.field2777[var23] == var22) {
                                       var45 = new class0();
                                       var45.field2 = var9;
                                       var45.field11 = var9.field2852;
                                       client.field466.method3834(var45);
                                       break label1323;
                                    }
                                 }
                              }
                           } else {
                              var42 = new class0();
                              var42.field2 = var9;
                              var42.field11 = var9.field2852;
                              client.field466.method3834(var42);
                           }

                           var9.field2885 = client.field469;
                        }

                        if(client.field470 > var9.field2882 && var9.field2857 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field11 = var9.field2857;
                           client.field466.method3834(var42);
                        }

                        if(client.field471 > var9.field2882 && var9.field2859 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field11 = var9.field2859;
                           client.field466.method3834(var42);
                        }

                        if(client.field474 > var9.field2882 && var9.field2781 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field11 = var9.field2781;
                           client.field466.method3834(var42);
                        }

                        if(client.field473 > var9.field2882 && var9.field2865 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field11 = var9.field2865;
                           client.field466.method3834(var42);
                        }

                        if(client.field364 > var9.field2882 && var9.field2753 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field11 = var9.field2753;
                           client.field466.method3834(var42);
                        }

                        if(client.field546 > var9.field2882 && null != var9.field2771) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field11 = var9.field2771;
                           client.field466.method3834(var42);
                        }

                        var9.field2882 = client.field463;
                        if(var9.field2869 != null) {
                           for(var21 = 0; var21 < client.field520; ++var21) {
                              class0 var44 = new class0();
                              var44.field2 = var9;
                              var44.field7 = client.field503[var21];
                              var44.field16 = client.field306[var21];
                              var44.field11 = var9.field2869;
                              client.field466.method3834(var44);
                           }
                        }
                     }
                  }

                  if(!var9.field2809 && null == client.field451 && null == class142.field2170 && !client.field331) {
                     if((var9.field2870 >= 0 || var9.field2782 != 0) && class140.field2140 >= var12 && class140.field2141 >= var13 && class140.field2140 < var14 && class140.field2141 < var15) {
                        if(var9.field2870 >= 0) {
                           class7.field138 = var0[var9.field2870];
                        } else {
                           class7.field138 = var9;
                        }
                     }

                     if(8 == var9.field2757 && class140.field2140 >= var12 && class140.field2141 >= var13 && class140.field2140 < var14 && class140.field2141 < var15) {
                        class98.field1649 = var9;
                     }

                     if(var9.field2779 > var9.field2834) {
                        class6.method99(var9, var9.field2770 + var10, var11, var9.field2834, var9.field2779, class140.field2140, class140.field2141);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   final class100 method810(int var1, int var2) {
      class100 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field900 == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.field926 == null) {
            return null;
         }

         var4 = this.field944;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field926.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field926[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class100)field902.method3754((long)var7);
            if(null == var3) {
               var3 = class100.method2221(field901, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2282();
               }

               field902.method3756(var3, (long)var7);
            }

            if(var5 > 1) {
               field905[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class100(field905, var5);
         }
      } else {
         int var8 = -1;

         for(var5 = 0; var5 < this.field900.length; ++var5) {
            if(this.field900[var5] == var1) {
               var8 = var5;
               break;
            }
         }

         if(var8 == -1) {
            return null;
         }

         var5 = this.field926[var8];
         boolean var9 = this.field944 ^ var2 > 3;
         if(var9) {
            var5 += 65536;
         }

         var3 = (class100)field902.method3754((long)var5);
         if(null == var3) {
            var3 = class100.method2221(field901, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var9) {
               var3.method2282();
            }

            field902.method3756(var3, (long)var5);
         }
      }

      if(this.field931 == 128 && 128 == this.field932 && this.field933 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(0 == this.field934 && this.field918 == 0 && 0 == this.field936) {
         var10 = false;
      } else {
         var10 = true;
      }

      class100 var11 = new class100(var3, var2 == 0 && !var4 && !var10, null == this.field910, this.field912 == null, true);
      if(4 == var1 && var2 > 3) {
         var11.method2232(256);
         var11.method2233(45, 0, -45);
      }

      var2 &= 3;
      if(1 == var2) {
         var11.method2272();
      } else if(var2 == 2) {
         var11.method2230();
      } else if(3 == var2) {
         var11.method2231();
      }

      if(null != this.field910) {
         for(var7 = 0; var7 < this.field910.length; ++var7) {
            var11.method2234(this.field910[var7], this.field911[var7]);
         }
      }

      if(this.field912 != null) {
         for(var7 = 0; var7 < this.field912.length; ++var7) {
            var11.method2235(this.field912[var7], this.field913[var7]);
         }
      }

      if(var4) {
         var11.method2249(this.field931, this.field932, this.field933);
      }

      if(var10) {
         var11.method2233(this.field934, this.field918, this.field936);
      }

      return var11;
   }

   @ObfuscatedName("y")
   public boolean method823() {
      if(null == this.field923) {
         return -1 != this.field943 || this.field947 != null;
      } else {
         for(int var1 = 0; var1 < this.field923.length; ++var1) {
            if(this.field923[var1] != -1) {
               class40 var2 = class26.method633(this.field923[var1]);
               if(-1 != var2.field943 || null != var2.field947) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-715601013"
   )
   void method835(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2523();
         if(var3 > 0) {
            if(null != this.field926 && !field939) {
               var1.field1976 += var3 * 3;
            } else {
               this.field900 = new int[var3];
               this.field926 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field926[var4] = var1.method2700();
                  this.field900[var4] = var1.method2523();
               }
            }
         }
      } else if(var2 == 2) {
         this.field909 = var1.method2531();
      } else if(5 == var2) {
         var3 = var1.method2523();
         if(var3 > 0) {
            if(this.field926 != null && !field939) {
               var1.field1976 += var3 * 2;
            } else {
               this.field900 = null;
               this.field926 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field926[var4] = var1.method2700();
               }
            }
         }
      } else if(14 == var2) {
         this.field908 = var1.method2523();
      } else if(var2 == 15) {
         this.field915 = var1.method2523();
      } else if(17 == var2) {
         this.field924 = 0;
         this.field917 = false;
      } else if(var2 == 18) {
         this.field917 = false;
      } else if(19 == var2) {
         this.field922 = var1.method2523();
      } else if(var2 == 21) {
         this.field919 = 0;
      } else if(22 == var2) {
         this.field920 = true;
      } else if(23 == var2) {
         this.field921 = true;
      } else if(24 == var2) {
         this.field938 = var1.method2700();
         if('\uffff' == this.field938) {
            this.field938 = -1;
         }
      } else if(var2 == 27) {
         this.field924 = 1;
      } else if(var2 == 28) {
         this.field945 = var1.method2523();
      } else if(29 == var2) {
         this.field907 = var1.method2633();
      } else if(var2 == 39) {
         this.field925 = var1.method2633() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field898[var2 - 30] = var1.method2531();
         if(this.field898[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field898[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2523();
         this.field910 = new short[var3];
         this.field911 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field910[var4] = (short)var1.method2700();
            this.field911[var4] = (short)var1.method2700();
         }
      } else if(var2 == 41) {
         var3 = var1.method2523();
         this.field912 = new short[var3];
         this.field913 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field912[var4] = (short)var1.method2700();
            this.field913[var4] = (short)var1.method2700();
         }
      } else if(60 == var2) {
         this.field927 = var1.method2700();
      } else if(var2 == 62) {
         this.field944 = true;
      } else if(var2 == 64) {
         this.field930 = false;
      } else if(65 == var2) {
         this.field931 = var1.method2700();
      } else if(var2 == 66) {
         this.field932 = var1.method2700();
      } else if(67 == var2) {
         this.field933 = var1.method2700();
      } else if(68 == var2) {
         this.field916 = var1.method2700();
      } else if(var2 == 69) {
         var1.method2523();
      } else if(70 == var2) {
         this.field934 = var1.method2526();
      } else if(var2 == 71) {
         this.field918 = var1.method2526();
      } else if(72 == var2) {
         this.field936 = var1.method2526();
      } else if(var2 == 73) {
         this.field940 = true;
      } else if(var2 == 74) {
         this.field914 = true;
      } else if(75 == var2) {
         this.field948 = var1.method2523();
      } else if(var2 == 77) {
         this.field941 = var1.method2700();
         if(this.field941 == '\uffff') {
            this.field941 = -1;
         }

         this.field942 = var1.method2700();
         if('\uffff' == this.field942) {
            this.field942 = -1;
         }

         var3 = var1.method2523();
         this.field923 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field923[var4] = var1.method2700();
            if('\uffff' == this.field923[var4]) {
               this.field923[var4] = -1;
            }
         }
      } else if(78 == var2) {
         this.field943 = var1.method2700();
         this.field935 = var1.method2523();
      } else if(var2 == 79) {
         this.field937 = var1.method2700();
         this.field946 = var1.method2700();
         this.field935 = var1.method2523();
         var3 = var1.method2523();
         this.field947 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field947[var4] = var1.method2700();
         }
      } else if(81 == var2) {
         this.field919 = var1.method2523() * 256;
      }

   }

   @ObfuscatedName("f")
   public static class173 method837(int var0, int var1) {
      class173 var2 = class148.method3129(var0);
      return -1 == var1?var2:(null != var2 && var2.field2879 != null && var1 < var2.field2879.length?var2.field2879[var1]:null);
   }

   @ObfuscatedName("w")
   static File method838(String var0) {
      if(!class135.field2078) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class135.field2079.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class135.field2075, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class135.field2079.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(null != var3) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }
}
