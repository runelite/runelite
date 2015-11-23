package net.runelite.rs.client;

import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ar")
@Implements("ObjectComposition")
public class class40 extends class203 {
   @ObfuscatedName("ac")
   public boolean field905 = false;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1683046353
   )
   public int field906 = -1;
   @ObfuscatedName("u")
   public static class192 field907 = new class192(500);
   @ObfuscatedName("a")
   static class192 field908 = new class192(30);
   @ObfuscatedName("h")
   static class192 field909 = new class192(30);
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1493133205
   )
   public int field910 = -1;
   @ObfuscatedName("ax")
   public boolean field911 = true;
   @ObfuscatedName("k")
   int[] field912;
   @ObfuscatedName("s")
   int[] field913;
   @ObfuscatedName("w")
   @Export("name")
   public String field914 = "null";
   @ObfuscatedName("e")
   short[] field915;
   @ObfuscatedName("z")
   short[] field916;
   @ObfuscatedName("d")
   boolean field917 = false;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1021773793
   )
   int field918 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -59443019
   )
   public int field919 = 1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1983395469
   )
   public int field920 = 1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2023661835
   )
   public int field921 = 2;
   @ObfuscatedName("v")
   public boolean field922 = true;
   @ObfuscatedName("r")
   short[] field923;
   @ObfuscatedName("j")
   public static boolean field924 = false;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2131462333
   )
   public int field925 = -1;
   @ObfuscatedName("o")
   public boolean field926 = false;
   @ObfuscatedName("i")
   static class99[] field927 = new class99[4];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1011077233
   )
   public int field928 = 16;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1133344921
   )
   int field929 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 440299915
   )
   int field930 = 0;
   @ObfuscatedName("as")
   @Export("actions")
   public String[] field931 = new String[5];
   @ObfuscatedName("am")
   boolean field933 = false;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1726793295
   )
   public int field934 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -995851259
   )
   public int field935;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 998146113
   )
   int field936 = 128;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1131360969
   )
   public int field937 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1524746619
   )
   int field938 = 128;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 599189895
   )
   int field939 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -835601831
   )
   int field940 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1295306549
   )
   int field941 = 128;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -123286243
   )
   int field942 = 1;
   @ObfuscatedName("ar")
   boolean field943 = false;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 689414781
   )
   public int field944 = -1;
   @ObfuscatedName("ak")
   public int[] field945;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -288106135
   )
   int field946 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -26038565
   )
   int field947 = -1;
   @ObfuscatedName("p")
   short[] field948;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1427315137
   )
   public int field949 = 0;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 910690645
   )
   public int field950 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 635070461
   )
   public int field951 = 0;
   @ObfuscatedName("l")
   static class192 field952 = new class192(64);
   @ObfuscatedName("aj")
   public int[] field955;

   @ObfuscatedName("a")
   public final boolean method844() {
      if(this.field912 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field912.length; ++var2) {
            var1 &= class228.field3213.method3314(this.field912[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("m")
   void method845() {
      if(this.field937 == -1) {
         this.field937 = 0;
         if(null != this.field912 && (null == this.field913 || this.field913[0] == 10)) {
            this.field937 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.field931[var1] != null) {
               this.field937 = 1;
            }
         }
      }

      if(this.field944 == -1) {
         this.field944 = this.field921 != 0?1:0;
      }

   }

   @ObfuscatedName("f")
   void method846(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(var2 == 0) {
            return;
         }

         this.method876(var1, var2);
      }
   }

   @ObfuscatedName("s")
   public final class40 method847() {
      int var1 = -1;
      if(-1 != this.field946) {
         var1 = class160.method3227(this.field946);
      } else if(-1 != this.field947) {
         var1 = class175.field2884[this.field947];
      }

      return var1 >= 0 && var1 < this.field945.length && -1 != this.field945[var1]?class33.method755(this.field945[var1]):null;
   }

   @ObfuscatedName("u")
   public final boolean method848(int var1) {
      if(null != this.field913) {
         for(int var4 = 0; var4 < this.field913.length; ++var4) {
            if(var1 == this.field913[var4]) {
               return class228.field3213.method3314(this.field912[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field912 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field912.length; ++var3) {
            var2 &= class228.field3213.method3314(this.field912[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("h")
   public final class84 method850(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field913 == null) {
         var7 = (long)((this.field935 << 10) + var2);
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field935 << 10));
      }

      Object var9 = (class84)field908.method3808(var7);
      if(null == var9) {
         class99 var10 = this.method853(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field917) {
            var9 = var10.method2247(64 + this.field929, 768 + this.field930, -50, -10, -50);
         } else {
            var10.field1672 = (short)(this.field929 + 64);
            var10.field1695 = (short)(768 + this.field930);
            var10.method2236();
            var9 = var10;
         }

         field908.method3805((class203)var9, var7);
      }

      if(this.field917) {
         var9 = ((class99)var9).method2304();
      }

      if(this.field942 * -1 >= 0) {
         if(var9 instanceof class104) {
            var9 = ((class104)var9).method2342(var3, var4, var5, var6, true, this.field942 * -1);
         } else if(var9 instanceof class99) {
            var9 = ((class99)var9).method2225(var3, var4, var5, var6, this.field942 * -1);
         }
      }

      return (class84)var9;
   }

   @ObfuscatedName("i")
   public final class104 method851(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field913) {
         var7 = (long)(var2 + (this.field935 << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.field935 << 10) + var2);
      }

      class104 var9 = (class104)field909.method3808(var7);
      if(var9 == null) {
         class99 var10 = this.method853(var1, var2);
         if(null == var10) {
            return null;
         }

         var9 = var10.method2247(this.field929 + 64, this.field930 + 768, -50, -10, -50);
         field909.method3805(var9, var7);
      }

      if(this.field942 * -1 >= 0) {
         var9 = var9.method2342(var3, var4, var5, var6, true, this.field942 * -1);
      }

      return var9;
   }

   @ObfuscatedName("k")
   final class99 method853(int var1, int var2) {
      class99 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field913 == null) {
         if(10 != var1) {
            return null;
         }

         if(null == this.field912) {
            return null;
         }

         var4 = this.field933;
         if(2 == var1 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field912.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field912[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class99)field907.method3808((long)var7);
            if(null == var3) {
               var3 = class99.method2218(class228.field3213, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2234();
               }

               field907.method3805(var3, (long)var7);
            }

            if(var5 > 1) {
               field927[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class99(field927, var5);
         }
      } else {
         int var8 = -1;

         for(var5 = 0; var5 < this.field913.length; ++var5) {
            if(var1 == this.field913[var5]) {
               var8 = var5;
               break;
            }
         }

         if(-1 == var8) {
            return null;
         }

         var5 = this.field912[var8];
         boolean var9 = this.field933 ^ var2 > 3;
         if(var9) {
            var5 += 65536;
         }

         var3 = (class99)field907.method3808((long)var5);
         if(var3 == null) {
            var3 = class99.method2218(class228.field3213, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var9) {
               var3.method2234();
            }

            field907.method3805(var3, (long)var5);
         }
      }

      if(128 == this.field936 && this.field941 == 128 && 128 == this.field938) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field939 == 0 && 0 == this.field940 && 0 == this.field918) {
         var10 = false;
      } else {
         var10 = true;
      }

      class99 var11 = new class99(var3, 0 == var2 && !var4 && !var10, null == this.field915, this.field948 == null, true);
      if(4 == var1 && var2 > 3) {
         var11.method2230(256);
         var11.method2239(45, 0, -45);
      }

      var2 &= 3;
      if(1 == var2) {
         var11.method2227();
      } else if(2 == var2) {
         var11.method2228();
      } else if(3 == var2) {
         var11.method2303();
      }

      if(null != this.field915) {
         for(var7 = 0; var7 < this.field915.length; ++var7) {
            var11.method2298(this.field915[var7], this.field916[var7]);
         }
      }

      if(this.field948 != null) {
         for(var7 = 0; var7 < this.field948.length; ++var7) {
            var11.method2233(this.field948[var7], this.field923[var7]);
         }
      }

      if(var4) {
         var11.method2235(this.field936, this.field941, this.field938);
      }

      if(var10) {
         var11.method2239(this.field939, this.field940, this.field918);
      }

      return var11;
   }

   @ObfuscatedName("e")
   public boolean method855() {
      if(this.field945 == null) {
         return this.field906 != -1 || null != this.field955;
      } else {
         for(int var1 = 0; var1 < this.field945.length; ++var1) {
            if(-1 != this.field945[var1]) {
               class40 var2 = class33.method755(this.field945[var1]);
               if(-1 != var2.field906 || null != var2.field955) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("cg")
   static final void method863(class172 var0, int var1, int var2) {
      if(1 == var0.field2737) {
         class25.method674(var0.field2849, "", 24, 0, 0, var0.field2734 * -1);
      }

      String var3;
      int var4;
      int var5;
      if(var0.field2737 == 2 && !client.field546) {
         var5 = class7.method126(var0);
         var4 = var5 >> 11 & 63;
         if(0 == var4) {
            var3 = null;
         } else if(null != var0.field2811 && var0.field2811.trim().length() != 0) {
            var3 = var0.field2811;
         } else {
            var3 = null;
         }

         if(null != var3) {
            class25.method674(var3, class74.method1617('\uff00') + var0.field2848, 25, 0, -1, var0.field2734 * -1);
         }
      }

      if(3 == var0.field2737) {
         class25.method674("Close", "", 26, 0, 0, var0.field2734 * -1);
      }

      if(4 == var0.field2737) {
         class25.method674(var0.field2849, "", 28, 0, 0, var0.field2734 * -1);
      }

      if(5 == var0.field2737) {
         class25.method674(var0.field2849, "", 29, 0, 0, var0.field2734 * -1);
      }

      if(6 == var0.field2737 && null == client.field545) {
         class25.method674(var0.field2849, "", 30, 0, -1, var0.field2734 * -1);
      }

      int var14;
      if(var0.field2736 == 2) {
         var14 = 0;

         for(var4 = 0; var4 < var0.field2750; ++var4) {
            for(var5 = 0; var5 < var0.field2749; ++var5) {
               int var6 = (var0.field2761 + 32) * var5;
               int var7 = (32 + var0.field2799) * var4;
               if(var14 < 20) {
                  var6 += var0.field2800[var14];
                  var7 += var0.field2801[var14];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < 32 + var7) {
                  client.field393 = var14;
                  class29.field678 = var0;
                  if(var0.field2850[var14] > 0) {
                     class51 var8 = class10.method158(var0.field2850[var14] - 1);
                     if(client.field398 == 1 && class49.method1051(class7.method126(var0))) {
                        if(class98.field1660 != var0.field2734 * -1 || class219.field3155 != var14) {
                           class25.method674("Use", client.field428 + " " + "->" + " " + class74.method1617(16748608) + var8.field1099, 31, var8.field1097, var14, var0.field2734 * -1);
                        }
                     } else if(client.field546 && class49.method1051(class7.method126(var0))) {
                        if((class138.field2124 & 16) == 16) {
                           class25.method674(client.field432, client.field433 + " " + "->" + " " + class74.method1617(16748608) + var8.field1099, 32, var8.field1097, var14, var0.field2734 * -1);
                        }
                     } else {
                        String[] var9 = var8.field1116;
                        if(client.field374) {
                           var9 = class143.method3145(var9);
                        }

                        if(class49.method1051(class7.method126(var0))) {
                           for(int var10 = 4; var10 >= 3; --var10) {
                              if(null != var9 && var9[var10] != null) {
                                 byte var11;
                                 if(var10 == 3) {
                                    var11 = 36;
                                 } else {
                                    var11 = 37;
                                 }

                                 class25.method674(var9[var10], class74.method1617(16748608) + var8.field1099, var11, var8.field1097, var14, var0.field2734 * -1);
                              } else if(4 == var10) {
                                 class25.method674("Drop", class74.method1617(16748608) + var8.field1099, 37, var8.field1097, var14, var0.field2734 * -1);
                              }
                           }
                        }

                        int var18 = class7.method126(var0);
                        boolean var17 = (var18 >> 31 & 1) != 0;
                        if(var17) {
                           class25.method674("Use", class74.method1617(16748608) + var8.field1099, 38, var8.field1097, var14, var0.field2734 * -1);
                        }

                        class177 var10000 = (class177)null;
                        int var12;
                        byte var13;
                        if(class49.method1051(class7.method126(var0)) && null != var9) {
                           for(var12 = 2; var12 >= 0; --var12) {
                              if(var9[var12] != null) {
                                 var13 = 0;
                                 if(0 == var12) {
                                    var13 = 33;
                                 }

                                 if(var12 == 1) {
                                    var13 = 34;
                                 }

                                 if(var12 == 2) {
                                    var13 = 35;
                                 }

                                 class25.method674(var9[var12], class74.method1617(16748608) + var8.field1099, var13, var8.field1097, var14, var0.field2734 * -1);
                              }
                           }
                        }

                        var9 = var0.field2803;
                        if(client.field374) {
                           var9 = class143.method3145(var9);
                        }

                        if(var9 != null) {
                           for(var12 = 4; var12 >= 0; --var12) {
                              if(var9[var12] != null) {
                                 var13 = 0;
                                 if(var12 == 0) {
                                    var13 = 39;
                                 }

                                 if(var12 == 1) {
                                    var13 = 40;
                                 }

                                 if(var12 == 2) {
                                    var13 = 41;
                                 }

                                 if(3 == var12) {
                                    var13 = 42;
                                 }

                                 if(4 == var12) {
                                    var13 = 43;
                                 }

                                 class25.method674(var9[var12], class74.method1617(16748608) + var8.field1099, var13, var8.field1097, var14, var0.field2734 * -1);
                              }
                           }
                        }

                        class25.method674("Examine", class74.method1617(16748608) + var8.field1099, 1005, var8.field1097, var14, var0.field2734 * -1);
                     }
                  }
               }

               ++var14;
            }
         }
      }

      if(var0.field2733) {
         if(client.field546) {
            if(class35.method775(class7.method126(var0)) && (class138.field2124 & 32) == 32) {
               class25.method674(client.field432, client.field433 + " " + "->" + " " + var0.field2805, 58, 0, var0.field2735, var0.field2734 * -1);
            }
         } else {
            for(var14 = 9; var14 >= 5; --var14) {
               String var15 = class10.method159(var0, var14);
               if(var15 != null) {
                  class25.method674(var15, var0.field2805, 1007, var14 + 1, var0.field2735, var0.field2734 * -1);
               }
            }

            var5 = class7.method126(var0);
            var4 = var5 >> 11 & 63;
            if(0 == var4) {
               var3 = null;
            } else if(var0.field2811 != null && var0.field2811.trim().length() != 0) {
               var3 = var0.field2811;
            } else {
               var3 = null;
            }

            if(null != var3) {
               class25.method674(var3, var0.field2805, 25, 0, var0.field2735, var0.field2734 * -1);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var16 = class10.method159(var0, var5);
               if(var16 != null) {
                  class25.method674(var16, var0.field2805, 57, 1 + var5, var0.field2735, var0.field2734 * -1);
               }
            }

            if(class137.method2969(class7.method126(var0))) {
               class25.method674("Continue", "", 30, 0, var0.field2735, var0.field2734 * -1);
            }
         }
      }

   }

   @ObfuscatedName("t")
   public final class104 method867(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(null == this.field913) {
         var9 = (long)(var2 + (this.field935 << 10));
      } else {
         var9 = (long)(var2 + (this.field935 << 10) + (var1 << 3));
      }

      class104 var11 = (class104)field909.method3808(var9);
      if(null == var11) {
         class99 var12 = this.method853(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2247(this.field929 + 64, this.field930 + 768, -50, -10, -50);
         field909.method3805(var11, var9);
      }

      if(null == var7 && -1 == this.field942 * -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method931(var11, var8, var2);
         } else {
            var11 = var11.method2366(true);
         }

         if(this.field942 * -1 >= 0) {
            var11 = var11.method2342(var3, var4, var5, var6, false, this.field942 * -1);
         }

         return var11;
      }
   }

   @ObfuscatedName("l")
   void method876(class118 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2536();
         if(var3 > 0) {
            if(null != this.field912 && !field924) {
               var1.field1981 += var3 * 3;
            } else {
               this.field913 = new int[var3];
               this.field912 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field912[var4] = var1.method2538();
                  this.field913[var4] = var1.method2536();
               }
            }
         }
      } else if(2 == var2) {
         this.field914 = var1.method2544();
      } else if(5 == var2) {
         var3 = var1.method2536();
         if(var3 > 0) {
            if(null != this.field912 && !field924) {
               var1.field1981 += var3 * 2;
            } else {
               this.field913 = null;
               this.field912 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field912[var4] = var1.method2538();
               }
            }
         }
      } else if(var2 == 14) {
         this.field919 = var1.method2536();
      } else if(15 == var2) {
         this.field920 = var1.method2536();
      } else if(var2 == 17) {
         this.field921 = 0;
         this.field922 = false;
      } else if(18 == var2) {
         this.field922 = false;
      } else if(var2 == 19) {
         this.field937 = var1.method2536();
      } else if(21 == var2) {
         this.field942 = 0;
      } else if(var2 == 22) {
         this.field917 = true;
      } else if(var2 == 23) {
         this.field926 = true;
      } else if(24 == var2) {
         this.field925 = var1.method2538();
         if(this.field925 == '\uffff') {
            this.field925 = -1;
         }
      } else if(27 == var2) {
         this.field921 = 1;
      } else if(var2 == 28) {
         this.field928 = var1.method2536();
      } else if(29 == var2) {
         this.field929 = var1.method2537();
      } else if(39 == var2) {
         this.field930 = var1.method2537() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field931[var2 - 30] = var1.method2544();
         if(this.field931[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field931[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2536();
         this.field915 = new short[var3];
         this.field916 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field915[var4] = (short)var1.method2538();
            this.field916[var4] = (short)var1.method2538();
         }
      } else if(var2 == 41) {
         var3 = var1.method2536();
         this.field948 = new short[var3];
         this.field923 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field948[var4] = (short)var1.method2538();
            this.field923[var4] = (short)var1.method2538();
         }
      } else if(60 == var2) {
         this.field910 = var1.method2538();
      } else if(var2 == 62) {
         this.field933 = true;
      } else if(var2 == 64) {
         this.field911 = false;
      } else if(var2 == 65) {
         this.field936 = var1.method2538();
      } else if(66 == var2) {
         this.field941 = var1.method2538();
      } else if(var2 == 67) {
         this.field938 = var1.method2538();
      } else if(var2 == 68) {
         this.field934 = var1.method2538();
      } else if(var2 == 69) {
         var1.method2536();
      } else if(var2 == 70) {
         this.field939 = var1.method2539();
      } else if(71 == var2) {
         this.field940 = var1.method2539();
      } else if(var2 == 72) {
         this.field918 = var1.method2539();
      } else if(var2 == 73) {
         this.field905 = true;
      } else if(74 == var2) {
         this.field943 = true;
      } else if(var2 == 75) {
         this.field944 = var1.method2536();
      } else if(77 == var2) {
         this.field946 = var1.method2538();
         if('\uffff' == this.field946) {
            this.field946 = -1;
         }

         this.field947 = var1.method2538();
         if('\uffff' == this.field947) {
            this.field947 = -1;
         }

         var3 = var1.method2536();
         this.field945 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field945[var4] = var1.method2538();
            if(this.field945[var4] == '\uffff') {
               this.field945[var4] = -1;
            }
         }
      } else if(78 == var2) {
         this.field906 = var1.method2538();
         this.field949 = var1.method2536();
      } else if(var2 == 79) {
         this.field950 = var1.method2538();
         this.field951 = var1.method2538();
         this.field949 = var1.method2536();
         var3 = var1.method2536();
         this.field955 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field955[var4] = var1.method2538();
         }
      } else if(var2 == 81) {
         this.field942 = var1.method2536() * -256;
      }

   }

   @ObfuscatedName("az")
   static final void method880(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class8.field139.method4101(var0, 250);
      int var6 = class8.field139.method4087(var0, 250) * 13;
      class79.method1820(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
      class79.method1815(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      class8.field139.method4078(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class186.method3794(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
      if(var1) {
         try {
            Graphics var7 = class17.field244.getGraphics();
            class84.field1440.vmethod1895(var7, 0, 0);
         } catch (Exception var12) {
            class17.field244.repaint();
         }
      } else {
         int var13 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < client.field477; ++var11) {
            if(client.field484[var11] + client.field482[var11] > var13 && client.field482[var11] < var13 + var9 && client.field483[var11] + client.field526[var11] > var8 && client.field483[var11] < var10 + var8) {
               client.field496[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("dl")
   static boolean method881(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class140.method3010(var0, client.field280);

         for(int var2 = 0; var2 < client.field354; ++var2) {
            class7 var3 = client.field445[var2];
            if(var1.equalsIgnoreCase(class140.method3010(var3.field130, client.field280))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class140.method3010(var3.field126, client.field280))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("j")
   public static class78 method883(class166 var0, int var1, int var2) {
      return !class46.method1007(var0, var1, var2)?null:class75.method1651();
   }
}
