import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("TextureProvider")
public class class98 implements class95 {
   @ObfuscatedName("h")
   double field1689 = 1.0D;
   @ObfuscatedName("g")
   class202 field1690 = new class202();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -776827785
   )
   int field1691;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1430477295
   )
   int field1693 = 0;
   @ObfuscatedName("l")
   class86[] field1694;
   @ObfuscatedName("k")
   class170 field1695;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1800158211
   )
   int field1696 = 128;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2258(double var1) {
      this.field1689 = var1;
      this.method2263();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "2"
   )
   public int vmethod2260(int var1) {
      return null != this.field1694[var1]?this.field1694[var1].field1522:0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1025454023"
   )
   public boolean vmethod2262(int var1) {
      return this.field1696 == 64;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1688091902"
   )
   public void method2263() {
      for(int var1 = 0; var1 < this.field1694.length; ++var1) {
         if(this.field1694[var1] != null) {
            this.field1694[var1].method1979();
         }
      }

      this.field1690 = new class202();
      this.field1693 = this.field1691;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "101"
   )
   public void method2264(int var1) {
      for(int var2 = 0; var2 < this.field1694.length; ++var2) {
         class86 var3 = this.field1694[var2];
         if(null != var3 && var3.field1528 != 0 && var3.field1531) {
            var3.method1980(var1);
            var3.field1531 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "64"
   )
   public class98(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1695 = var2;
      this.field1691 = var3;
      this.field1693 = this.field1691;
      this.field1689 = var4;
      this.field1696 = var6;
      int[] var7 = var1.method3395(0);
      int var8 = var7.length;
      this.field1694 = new class86[var1.method3405(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class122 var10 = new class122(var1.method3411(0, var7[var9]));
         this.field1694[var7[var9]] = new class86(var10);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public boolean vmethod2270(int var1) {
      return this.field1694[var1].field1523;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1858605656"
   )
   @Export("load")
   public int[] vmethod2278(int var1) {
      class86 var2 = this.field1694[var1];
      if(var2 != null) {
         if(null != var2.field1520) {
            this.field1690.method3964(var2);
            var2.field1531 = true;
            return var2.field1520;
         }

         boolean var3 = var2.method1978(this.field1689, this.field1696, this.field1695);
         if(var3) {
            if(this.field1693 == 0) {
               class86 var4 = (class86)this.field1690.method3967();
               var4.method1979();
            } else {
               --this.field1693;
            }

            this.field1690.method3964(var2);
            var2.field1531 = true;
            return var2.field1520;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "-1353237188"
   )
   static void method2282(class0 var0, int var1) {
      Object[] var2 = var0.field8;
      int var3 = ((Integer)var2[0]).intValue();
      class23 var4 = class11.method165(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field607;
         int[] var9 = var4.field608;
         byte var10 = -1;
         class38.field825 = 0;

         int var13;
         try {
            class38.field820 = new int[var4.field610];
            int var11 = 0;
            class230.field3259 = new String[var4.field606];
            int var12 = 0;

            int var14;
            String var26;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field5;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field4;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field2 != null?var0.field2.field2807:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field14;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field2?var0.field2.field2813:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field6?var0.field6.field2807:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field6 != null?var0.field6.field2813:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field9;
                  }

                  class38.field820[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var26 = (String)var2[var13];
                  if(var26.equals("event_opbase")) {
                     var26 = var0.field0;
                  }

                  class230.field3259[var12++] = var26;
               }
            }

            var13 = 0;
            class38.field829 = var0.field10;

            label3584:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var38 = var8[var7];
               String var17;
               String var20;
               String var21;
               int var31;
               int var32;
               int var45;
               int var47;
               String var49;
               int[] var62;
               int var68;
               int var73;
               byte var90;
               if(var38 < 100) {
                  if(var38 == 0) {
                     class38.field823[var5++] = var9[var7];
                     continue;
                  }

                  if(var38 == 1) {
                     var14 = var9[var7];
                     class38.field823[var5++] = class179.field2958[var14];
                     continue;
                  }

                  if(var38 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class179.field2958[var14] = class38.field823[var5];
                     class213.method4080(var14);
                     continue;
                  }

                  if(var38 == 3) {
                     class38.field818[var6++] = var4.field609[var7];
                     continue;
                  }

                  if(var38 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var38 == 7) {
                     var5 -= 2;
                     if(class38.field823[var5] != class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var38 == 8) {
                     var5 -= 2;
                     if(class38.field823[1 + var5] == class38.field823[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var38 == 9) {
                     var5 -= 2;
                     if(class38.field823[var5] < class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var38 == 10) {
                     var5 -= 2;
                     if(class38.field823[var5] > class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var38 == 21) {
                     if(class38.field825 == 0) {
                        return;
                     }

                     class14 var69 = class38.field828[--class38.field825];
                     var4 = var69.field219;
                     var8 = var4.field607;
                     var9 = var4.field608;
                     var7 = var69.field213;
                     class38.field820 = var69.field214;
                     class230.field3259 = var69.field215;
                     continue;
                  }

                  if(var38 == 25) {
                     var14 = var9[var7];
                     class38.field823[var5++] = class54.method1164(var14);
                     continue;
                  }

                  if(var38 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class124.method2892(var14, class38.field823[var5]);
                     continue;
                  }

                  if(var38 == 31) {
                     var5 -= 2;
                     if(class38.field823[var5] <= class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var38 == 32) {
                     var5 -= 2;
                     if(class38.field823[var5] >= class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var38 == 33) {
                     class38.field823[var5++] = class38.field820[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var38 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class38.field820[var10001] = class38.field823[var5];
                     continue;
                  }

                  if(var38 == 35) {
                     class38.field818[var6++] = class230.field3259[var9[var7]];
                     continue;
                  }

                  if(var38 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class230.field3259[var10001] = class38.field818[var6];
                     continue;
                  }

                  if(var38 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var74 = class38.field818;
                     if(var14 == 0) {
                        var49 = "";
                     } else if(var14 == 1) {
                        var17 = var74[var6];
                        if(null == var17) {
                           var49 = "null";
                        } else {
                           var49 = var17.toString();
                        }
                     } else {
                        var68 = var14 + var6;
                        var45 = 0;

                        for(var47 = var6; var47 < var68; ++var47) {
                           var20 = var74[var47];
                           if(null == var20) {
                              var45 += 4;
                           } else {
                              var45 += var20.length();
                           }
                        }

                        StringBuilder var82 = new StringBuilder(var45);

                        for(var73 = var6; var73 < var68; ++var73) {
                           var21 = var74[var73];
                           if(var21 == null) {
                              var82.append("null");
                           } else {
                              var82.append(var21);
                           }
                        }

                        var49 = var82.toString();
                     }

                     class38.field818[var6++] = var49;
                     continue;
                  }

                  if(var38 == 38) {
                     --var5;
                     continue;
                  }

                  if(var38 == 39) {
                     --var6;
                     continue;
                  }

                  if(var38 == 40) {
                     var14 = var9[var7];
                     class23 var99 = class11.method165(var14);
                     var62 = new int[var99.field610];
                     String[] var60 = new String[var99.field606];

                     for(var45 = 0; var45 < var99.field612; ++var45) {
                        var62[var45] = class38.field823[var5 - var99.field612 + var45];
                     }

                     for(var45 = 0; var45 < var99.field613; ++var45) {
                        var60[var45] = class38.field818[var45 + (var6 - var99.field613)];
                     }

                     var5 -= var99.field612;
                     var6 -= var99.field613;
                     class14 var93 = new class14();
                     var93.field219 = var4;
                     var93.field213 = var7;
                     var93.field214 = class38.field820;
                     var93.field215 = class230.field3259;
                     class38.field828[++class38.field825 - 1] = var93;
                     var4 = var99;
                     var8 = var99.field607;
                     var9 = var99.field608;
                     var7 = -1;
                     class38.field820 = var62;
                     class230.field3259 = var60;
                     continue;
                  }

                  if(var38 == 42) {
                     class38.field823[var5++] = class39.field869.method220(var9[var7]);
                     continue;
                  }

                  if(var38 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class39.field869.method254(var10001, class38.field823[var5]);
                     continue;
                  }

                  if(var38 == 44) {
                     var14 = var9[var7] >> 16;
                     var31 = var9[var7] & '\uffff';
                     --var5;
                     var32 = class38.field823[var5];
                     if(var32 >= 0 && var32 <= 5000) {
                        class38.field821[var14] = var32;
                        var90 = -1;
                        if(var31 == 105) {
                           var90 = 0;
                        }

                        var45 = 0;

                        while(true) {
                           if(var45 >= var32) {
                              continue label3584;
                           }

                           class38.field822[var14][var45] = var90;
                           ++var45;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var38 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var31 = class38.field823[var5];
                     if(var31 >= 0 && var31 < class38.field821[var14]) {
                        class38.field823[var5++] = class38.field822[var14][var31];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var38 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var31 = class38.field823[var5];
                     if(var31 >= 0 && var31 < class38.field821[var14]) {
                        class38.field822[var14][var31] = class38.field823[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var38 == 47) {
                     var26 = class39.field869.method219(var9[var7]);
                     if(null == var26) {
                        var26 = "null";
                     }

                     class38.field818[var6++] = var26;
                     continue;
                  }

                  if(var38 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class39.field869.method224(var10001, class38.field818[var6]);
                     continue;
                  }
               }

               boolean var51;
               if(var9[var7] == 1) {
                  var51 = true;
               } else {
                  var51 = false;
               }

               class176 var15;
               class176 var16;
               boolean var18;
               class176 var39;
               class176 var77;
               boolean var88;
               if(var38 < 1000) {
                  if(var38 == 100) {
                     var5 -= 3;
                     var31 = class38.field823[var5];
                     var32 = class38.field823[1 + var5];
                     var68 = class38.field823[2 + var5];
                     if(var32 == 0) {
                        throw new RuntimeException();
                     }

                     var77 = class134.method2983(var31);
                     if(null == var77.field2931) {
                        var77.field2931 = new class176[var68 + 1];
                     }

                     if(var77.field2931.length <= var68) {
                        class176[] var76 = new class176[1 + var68];

                        for(var73 = 0; var73 < var77.field2931.length; ++var73) {
                           var76[var73] = var77.field2931[var73];
                        }

                        var77.field2931 = var76;
                     }

                     if(var68 > 0 && var77.field2931[var68 - 1] == null) {
                        throw new RuntimeException("" + (var68 - 1));
                     }

                     class176 var79 = new class176();
                     var79.field2910 = var32;
                     var79.field2826 = var79.field2807 = var77.field2807;
                     var79.field2813 = var68;
                     var79.field2855 = true;
                     var77.field2931[var68] = var79;
                     if(var51) {
                        class18.field266 = var79;
                     } else {
                        class50.field1122 = var79;
                     }

                     class79.method1777(var77);
                     continue;
                  }

                  if(var38 == 101) {
                     var15 = var51?class18.field266:class50.field1122;
                     var16 = class134.method2983(var15.field2807);
                     var16.field2931[var15.field2813] = null;
                     class79.method1777(var16);
                     continue;
                  }

                  if(var38 == 102) {
                     --var5;
                     var15 = class134.method2983(class38.field823[var5]);
                     var15.field2931 = null;
                     class79.method1777(var15);
                     continue;
                  }

                  if(var38 == 200) {
                     var5 -= 2;
                     var31 = class38.field823[var5];
                     var32 = class38.field823[1 + var5];
                     var39 = class151.method3265(var31, var32);
                     if(var39 != null && var32 != -1) {
                        class38.field823[var5++] = 1;
                        if(var51) {
                           class18.field266 = var39;
                        } else {
                           class50.field1122 = var39;
                        }
                        continue;
                     }

                     class38.field823[var5++] = 0;
                     continue;
                  }

                  if(var38 == 201) {
                     --var5;
                     var15 = class134.method2983(class38.field823[var5]);
                     if(var15 != null) {
                        class38.field823[var5++] = 1;
                        if(var51) {
                           class18.field266 = var15;
                        } else {
                           class50.field1122 = var15;
                        }
                     } else {
                        class38.field823[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var27;
                  if((var38 < 1000 || var38 >= 1100) && (var38 < 2000 || var38 >= 2100)) {
                     if(var38 >= 1100 && var38 < 1200 || var38 >= 2100 && var38 < 2200) {
                        var32 = -1;
                        if(var38 >= 2000) {
                           var38 -= 1000;
                           --var5;
                           var32 = class38.field823[var5];
                           var15 = class134.method2983(var32);
                        } else {
                           var15 = var51?class18.field266:class50.field1122;
                        }

                        if(var38 == 1100) {
                           var5 -= 2;
                           var15.field2864 = class38.field823[var5];
                           if(var15.field2864 > var15.field2830 - var15.field2822) {
                              var15.field2864 = var15.field2830 - var15.field2822;
                           }

                           if(var15.field2864 < 0) {
                              var15.field2864 = 0;
                           }

                           var15.field2850 = class38.field823[1 + var5];
                           if(var15.field2850 > var15.field2831 - var15.field2823) {
                              var15.field2850 = var15.field2831 - var15.field2823;
                           }

                           if(var15.field2850 < 0) {
                              var15.field2850 = 0;
                           }

                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1101) {
                           --var5;
                           var15.field2832 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1102) {
                           --var5;
                           var15.field2825 = class38.field823[var5] == 1;
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1103) {
                           --var5;
                           var15.field2886 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1104) {
                           --var5;
                           var15.field2840 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1105) {
                           --var5;
                           var15.field2842 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1106) {
                           --var5;
                           var15.field2844 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1107) {
                           --var5;
                           var15.field2845 = class38.field823[var5] == 1;
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1108) {
                           var15.field2800 = 1;
                           --var5;
                           var15.field2851 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1109) {
                           var5 -= 6;
                           var15.field2856 = class38.field823[var5];
                           var15.field2857 = class38.field823[var5 + 1];
                           var15.field2927 = class38.field823[2 + var5];
                           var15.field2859 = class38.field823[3 + var5];
                           var15.field2860 = class38.field823[4 + var5];
                           var15.field2933 = class38.field823[var5 + 5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1110) {
                           --var5;
                           var68 = class38.field823[var5];
                           if(var68 != var15.field2854) {
                              var15.field2854 = var68;
                              var15.field2929 = 0;
                              var15.field2930 = 0;
                              class79.method1777(var15);
                           }
                           continue;
                        }

                        if(var38 == 1111) {
                           --var5;
                           var15.field2908 = class38.field823[var5] == 1;
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1112) {
                           --var6;
                           var17 = class38.field818[var6];
                           if(!var17.equals(var15.field2867)) {
                              var15.field2867 = var17;
                              class79.method1777(var15);
                           }
                           continue;
                        }

                        if(var38 == 1113) {
                           --var5;
                           var15.field2866 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1114) {
                           var5 -= 3;
                           var15.field2814 = class38.field823[var5];
                           var15.field2883 = class38.field823[1 + var5];
                           var15.field2869 = class38.field823[2 + var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1115) {
                           --var5;
                           var15.field2827 = class38.field823[var5] == 1;
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1116) {
                           --var5;
                           var15.field2892 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1117) {
                           --var5;
                           var15.field2847 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1118) {
                           --var5;
                           var15.field2848 = class38.field823[var5] == 1;
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1119) {
                           --var5;
                           var15.field2849 = class38.field823[var5] == 1;
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1120) {
                           var5 -= 2;
                           var15.field2830 = class38.field823[var5];
                           var15.field2831 = class38.field823[var5 + 1];
                           class79.method1777(var15);
                           if(var32 != -1 && var15.field2910 == 0) {
                              class53.method1145(class176.field2836[var32 >> 16], var15, false);
                           }
                           continue;
                        }

                        if(var38 == 1121) {
                           class33.method718(var15.field2807, var15.field2813);
                           client.field376 = var15;
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1122) {
                           --var5;
                           var15.field2843 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1123) {
                           --var5;
                           var15.field2924 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1124) {
                           --var5;
                           var15.field2839 = class38.field823[var5];
                           class79.method1777(var15);
                           continue;
                        }

                        if(var38 == 1125) {
                           --var5;
                           var68 = class38.field823[var5];
                           class85 var92 = (class85)class85.method1971(class130.method2968(), var68);
                           if(var92 != null) {
                              var15.field2837 = var92;
                              class79.method1777(var15);
                           }
                           continue;
                        }
                     } else if((var38 < 1200 || var38 >= 1300) && (var38 < 2200 || var38 >= 2300)) {
                        if(var38 >= 1300 && var38 < 1400 || var38 >= 2300 && var38 < 2400) {
                           if(var38 >= 2000) {
                              var38 -= 1000;
                              --var5;
                              var15 = class134.method2983(class38.field823[var5]);
                           } else {
                              var15 = var51?class18.field266:class50.field1122;
                           }

                           if(var38 == 1300) {
                              --var5;
                              var32 = class38.field823[var5] - 1;
                              if(var32 >= 0 && var32 <= 9) {
                                 --var6;
                                 var15.method3560(var32, class38.field818[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var38 == 1301) {
                              var5 -= 2;
                              var32 = class38.field823[var5];
                              var68 = class38.field823[var5 + 1];
                              var15.field2882 = class151.method3265(var32, var68);
                              continue;
                           }

                           if(var38 == 1302) {
                              --var5;
                              var15.field2885 = class38.field823[var5] == 1;
                              continue;
                           }

                           if(var38 == 1303) {
                              --var5;
                              var15.field2939 = class38.field823[var5];
                              continue;
                           }

                           if(var38 == 1304) {
                              --var5;
                              var15.field2884 = class38.field823[var5];
                              continue;
                           }

                           if(var38 == 1305) {
                              --var6;
                              var15.field2902 = class38.field818[var6];
                              continue;
                           }

                           if(var38 == 1306) {
                              --var6;
                              var15.field2835 = class38.field818[var6];
                              continue;
                           }

                           if(var38 == 1307) {
                              var15.field2915 = null;
                              continue;
                           }
                        } else {
                           String var44;
                           if(var38 >= 1400 && var38 < 1500 || var38 >= 2400 && var38 < 2500) {
                              if(var38 >= 2000) {
                                 var38 -= 1000;
                                 --var5;
                                 var15 = class134.method2983(class38.field823[var5]);
                              } else {
                                 var15 = var51?class18.field266:class50.field1122;
                              }

                              --var6;
                              var44 = class38.field818[var6];
                              int[] var55 = null;
                              if(var44.length() > 0 && var44.charAt(var44.length() - 1) == 89) {
                                 --var5;
                                 var45 = class38.field823[var5];
                                 if(var45 > 0) {
                                    for(var55 = new int[var45]; var45-- > 0; var55[var45] = class38.field823[var5]) {
                                       --var5;
                                    }
                                 }

                                 var44 = var44.substring(0, var44.length() - 1);
                              }

                              Object[] var87 = new Object[var44.length() + 1];

                              for(var47 = var87.length - 1; var47 >= 1; --var47) {
                                 if(var44.charAt(var47 - 1) == 115) {
                                    --var6;
                                    var87[var47] = class38.field818[var6];
                                 } else {
                                    --var5;
                                    var87[var47] = new Integer(class38.field823[var5]);
                                 }
                              }

                              --var5;
                              var47 = class38.field823[var5];
                              if(var47 != -1) {
                                 var87[0] = new Integer(var47);
                              } else {
                                 var87 = null;
                              }

                              if(var38 == 1400) {
                                 var15.field2889 = var87;
                              }

                              if(var38 == 1401) {
                                 var15.field2828 = var87;
                              }

                              if(var38 == 1402) {
                                 var15.field2891 = var87;
                              }

                              if(var38 == 1403) {
                                 var15.field2893 = var87;
                              }

                              if(var38 == 1404) {
                                 var15.field2895 = var87;
                              }

                              if(var38 == 1405) {
                                 var15.field2928 = var87;
                              }

                              if(var38 == 1406) {
                                 var15.field2899 = var87;
                              }

                              if(var38 == 1407) {
                                 var15.field2833 = var87;
                                 var15.field2901 = var55;
                              }

                              if(var38 == 1408) {
                                 var15.field2881 = var87;
                              }

                              if(var38 == 1409) {
                                 var15.field2907 = var87;
                              }

                              if(var38 == 1410) {
                                 var15.field2897 = var87;
                              }

                              if(var38 == 1411) {
                                 var15.field2890 = var87;
                              }

                              if(var38 == 1412) {
                                 var15.field2894 = var87;
                              }

                              if(var38 == 1414) {
                                 var15.field2906 = var87;
                                 var15.field2805 = var55;
                              }

                              if(var38 == 1415) {
                                 var15.field2904 = var87;
                                 var15.field2871 = var55;
                              }

                              if(var38 == 1416) {
                                 var15.field2898 = var87;
                              }

                              if(var38 == 1417) {
                                 var15.field2838 = var87;
                              }

                              if(var38 == 1418) {
                                 var15.field2870 = var87;
                              }

                              if(var38 == 1419) {
                                 var15.field2858 = var87;
                              }

                              if(var38 == 1420) {
                                 var15.field2911 = var87;
                              }

                              if(var38 == 1421) {
                                 var15.field2912 = var87;
                              }

                              if(var38 == 1422) {
                                 var15.field2903 = var87;
                              }

                              if(var38 == 1423) {
                                 var15.field2914 = var87;
                              }

                              if(var38 == 1424) {
                                 var15.field2824 = var87;
                              }

                              if(var38 == 1425) {
                                 var15.field2900 = var87;
                              }

                              if(var38 == 1426) {
                                 var15.field2918 = var87;
                              }

                              if(var38 == 1427) {
                                 var15.field2916 = var87;
                              }

                              var15.field2817 = true;
                              continue;
                           }

                           if(var38 < 1600) {
                              var15 = var51?class18.field266:class50.field1122;
                              if(var38 == 1500) {
                                 class38.field823[var5++] = var15.field2820;
                                 continue;
                              }

                              if(var38 == 1501) {
                                 class38.field823[var5++] = var15.field2821;
                                 continue;
                              }

                              if(var38 == 1502) {
                                 class38.field823[var5++] = var15.field2822;
                                 continue;
                              }

                              if(var38 == 1503) {
                                 class38.field823[var5++] = var15.field2823;
                                 continue;
                              }

                              if(var38 == 1504) {
                                 class38.field823[var5++] = var15.field2804?1:0;
                                 continue;
                              }

                              if(var38 == 1505) {
                                 class38.field823[var5++] = var15.field2826;
                                 continue;
                              }
                           } else if(var38 < 1700) {
                              var15 = var51?class18.field266:class50.field1122;
                              if(var38 == 1600) {
                                 class38.field823[var5++] = var15.field2864;
                                 continue;
                              }

                              if(var38 == 1601) {
                                 class38.field823[var5++] = var15.field2850;
                                 continue;
                              }

                              if(var38 == 1602) {
                                 class38.field818[var6++] = var15.field2867;
                                 continue;
                              }

                              if(var38 == 1603) {
                                 class38.field823[var5++] = var15.field2830;
                                 continue;
                              }

                              if(var38 == 1604) {
                                 class38.field823[var5++] = var15.field2831;
                                 continue;
                              }

                              if(var38 == 1605) {
                                 class38.field823[var5++] = var15.field2933;
                                 continue;
                              }

                              if(var38 == 1606) {
                                 class38.field823[var5++] = var15.field2927;
                                 continue;
                              }

                              if(var38 == 1607) {
                                 class38.field823[var5++] = var15.field2860;
                                 continue;
                              }

                              if(var38 == 1608) {
                                 class38.field823[var5++] = var15.field2859;
                                 continue;
                              }

                              if(var38 == 1609) {
                                 class38.field823[var5++] = var15.field2886;
                                 continue;
                              }

                              if(var38 == 1610) {
                                 class38.field823[var5++] = var15.field2839;
                                 continue;
                              }

                              if(var38 == 1611) {
                                 class38.field823[var5++] = var15.field2832;
                                 continue;
                              }

                              if(var38 == 1612) {
                                 class38.field823[var5++] = var15.field2924;
                                 continue;
                              }

                              if(var38 == 1613) {
                                 class38.field823[var5++] = var15.field2837.vmethod3316();
                                 continue;
                              }
                           } else if(var38 < 1800) {
                              var15 = var51?class18.field266:class50.field1122;
                              if(var38 == 1700) {
                                 class38.field823[var5++] = var15.field2879;
                                 continue;
                              }

                              if(var38 == 1701) {
                                 if(var15.field2879 != -1) {
                                    class38.field823[var5++] = var15.field2808;
                                 } else {
                                    class38.field823[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var38 == 1702) {
                                 class38.field823[var5++] = var15.field2813;
                                 continue;
                              }
                           } else if(var38 < 1900) {
                              var15 = var51?class18.field266:class50.field1122;
                              if(var38 == 1800) {
                                 class38.field823[var5++] = class215.method4089(class2.method39(var15));
                                 continue;
                              }

                              if(var38 == 1801) {
                                 --var5;
                                 var32 = class38.field823[var5];
                                 --var32;
                                 if(var15.field2915 != null && var32 < var15.field2915.length && var15.field2915[var32] != null) {
                                    class38.field818[var6++] = var15.field2915[var32];
                                    continue;
                                 }

                                 class38.field818[var6++] = "";
                                 continue;
                              }

                              if(var38 == 1802) {
                                 if(null == var15.field2902) {
                                    class38.field818[var6++] = "";
                                 } else {
                                    class38.field818[var6++] = var15.field2902;
                                 }
                                 continue;
                              }
                           } else if((var38 < 1900 || var38 >= 2000) && (var38 < 2900 || var38 >= 3000)) {
                              if(var38 < 2600) {
                                 --var5;
                                 var15 = class134.method2983(class38.field823[var5]);
                                 if(var38 == 2500) {
                                    class38.field823[var5++] = var15.field2820;
                                    continue;
                                 }

                                 if(var38 == 2501) {
                                    class38.field823[var5++] = var15.field2821;
                                    continue;
                                 }

                                 if(var38 == 2502) {
                                    class38.field823[var5++] = var15.field2822;
                                    continue;
                                 }

                                 if(var38 == 2503) {
                                    class38.field823[var5++] = var15.field2823;
                                    continue;
                                 }

                                 if(var38 == 2504) {
                                    class38.field823[var5++] = var15.field2804?1:0;
                                    continue;
                                 }

                                 if(var38 == 2505) {
                                    class38.field823[var5++] = var15.field2826;
                                    continue;
                                 }
                              } else if(var38 < 2700) {
                                 --var5;
                                 var15 = class134.method2983(class38.field823[var5]);
                                 if(var38 == 2600) {
                                    class38.field823[var5++] = var15.field2864;
                                    continue;
                                 }

                                 if(var38 == 2601) {
                                    class38.field823[var5++] = var15.field2850;
                                    continue;
                                 }

                                 if(var38 == 2602) {
                                    class38.field818[var6++] = var15.field2867;
                                    continue;
                                 }

                                 if(var38 == 2603) {
                                    class38.field823[var5++] = var15.field2830;
                                    continue;
                                 }

                                 if(var38 == 2604) {
                                    class38.field823[var5++] = var15.field2831;
                                    continue;
                                 }

                                 if(var38 == 2605) {
                                    class38.field823[var5++] = var15.field2933;
                                    continue;
                                 }

                                 if(var38 == 2606) {
                                    class38.field823[var5++] = var15.field2927;
                                    continue;
                                 }

                                 if(var38 == 2607) {
                                    class38.field823[var5++] = var15.field2860;
                                    continue;
                                 }

                                 if(var38 == 2608) {
                                    class38.field823[var5++] = var15.field2859;
                                    continue;
                                 }

                                 if(var38 == 2609) {
                                    class38.field823[var5++] = var15.field2886;
                                    continue;
                                 }

                                 if(var38 == 2610) {
                                    class38.field823[var5++] = var15.field2839;
                                    continue;
                                 }

                                 if(var38 == 2611) {
                                    class38.field823[var5++] = var15.field2832;
                                    continue;
                                 }

                                 if(var38 == 2612) {
                                    class38.field823[var5++] = var15.field2924;
                                    continue;
                                 }

                                 if(var38 == 2613) {
                                    class38.field823[var5++] = var15.field2837.vmethod3316();
                                    continue;
                                 }
                              } else if(var38 < 2800) {
                                 if(var38 == 2700) {
                                    --var5;
                                    var15 = class134.method2983(class38.field823[var5]);
                                    class38.field823[var5++] = var15.field2879;
                                    continue;
                                 }

                                 if(var38 == 2701) {
                                    --var5;
                                    var15 = class134.method2983(class38.field823[var5]);
                                    if(var15.field2879 != -1) {
                                       class38.field823[var5++] = var15.field2808;
                                    } else {
                                       class38.field823[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var38 == 2702) {
                                    --var5;
                                    var31 = class38.field823[var5];
                                    class3 var42 = (class3)client.field475.method3936((long)var31);
                                    if(null != var42) {
                                       class38.field823[var5++] = 1;
                                    } else {
                                       class38.field823[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var38 == 2706) {
                                    class38.field823[var5++] = client.field495;
                                    continue;
                                 }
                              } else if(var38 < 2900) {
                                 --var5;
                                 var15 = class134.method2983(class38.field823[var5]);
                                 if(var38 == 2800) {
                                    class38.field823[var5++] = class215.method4089(class2.method39(var15));
                                    continue;
                                 }

                                 if(var38 == 2801) {
                                    --var5;
                                    var32 = class38.field823[var5];
                                    --var32;
                                    if(null != var15.field2915 && var32 < var15.field2915.length && null != var15.field2915[var32]) {
                                       class38.field818[var6++] = var15.field2915[var32];
                                       continue;
                                    }

                                    class38.field818[var6++] = "";
                                    continue;
                                 }

                                 if(var38 == 2802) {
                                    if(null == var15.field2902) {
                                       class38.field818[var6++] = "";
                                    } else {
                                       class38.field818[var6++] = var15.field2902;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var22;
                                 int var23;
                                 int var33;
                                 int var63;
                                 if(var38 < 3200) {
                                    if(var38 == 3100) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       class78.method1721(0, "", var49);
                                       continue;
                                    }

                                    if(var38 == 3101) {
                                       var5 -= 2;
                                       class20.method568(class3.field65, class38.field823[var5], class38.field823[1 + var5]);
                                       continue;
                                    }

                                    if(var38 == 3103) {
                                       client.field337.method2903(197);

                                       for(class3 var57 = (class3)client.field475.method3939(); null != var57; var57 = (class3)client.field475.method3935()) {
                                          if(var57.field60 == 0 || var57.field60 == 3) {
                                             class145.method3130(var57, true);
                                          }
                                       }

                                       if(client.field376 != null) {
                                          class79.method1777(client.field376);
                                          client.field376 = null;
                                       }
                                       continue;
                                    }

                                    if(var38 == 3104) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       var32 = 0;
                                       boolean var19 = false;
                                       boolean var29 = false;
                                       var33 = 0;
                                       var22 = var49.length();
                                       var23 = 0;

                                       while(true) {
                                          if(var23 >= var22) {
                                             var18 = var29;
                                             break;
                                          }

                                          label3843: {
                                             char var24 = var49.charAt(var23);
                                             if(var23 == 0) {
                                                if(var24 == 45) {
                                                   var19 = true;
                                                   break label3843;
                                                }

                                                if(var24 == 43) {
                                                   break label3843;
                                                }
                                             }

                                             if(var24 >= 48 && var24 <= 57) {
                                                var63 = var24 - 48;
                                             } else if(var24 >= 65 && var24 <= 90) {
                                                var63 = var24 - 55;
                                             } else {
                                                if(var24 < 97 || var24 > 122) {
                                                   var18 = false;
                                                   break;
                                                }

                                                var63 = var24 - 87;
                                             }

                                             if(var63 >= 10) {
                                                var18 = false;
                                                break;
                                             }

                                             if(var19) {
                                                var63 = -var63;
                                             }

                                             int var25 = 10 * var33 + var63;
                                             if(var33 != var25 / 10) {
                                                var18 = false;
                                                break;
                                             }

                                             var33 = var25;
                                             var29 = true;
                                          }

                                          ++var23;
                                       }

                                       if(var18) {
                                          var45 = class5.method91(var49, 10, true);
                                          var32 = var45;
                                       }

                                       client.field337.method2903(206);
                                       client.field337.method2728(var32);
                                       continue;
                                    }

                                    if(var38 == 3105) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       client.field337.method2903(107);
                                       client.field337.method2783(var49.length() + 1);
                                       client.field337.method2703(var49);
                                       continue;
                                    }

                                    if(var38 == 3106) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       client.field337.method2903(204);
                                       client.field337.method2783(var49.length() + 1);
                                       client.field337.method2703(var49);
                                       continue;
                                    }

                                    if(var38 == 3107) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       --var6;
                                       var44 = class38.field818[var6];
                                       class49.method1048(var31, var44);
                                       continue;
                                    }

                                    if(var38 == 3108) {
                                       var5 -= 3;
                                       var31 = class38.field823[var5];
                                       var32 = class38.field823[var5 + 1];
                                       var68 = class38.field823[2 + var5];
                                       var77 = class134.method2983(var68);
                                       class13.method175(var77, var31, var32);
                                       continue;
                                    }

                                    if(var38 == 3109) {
                                       var5 -= 2;
                                       var31 = class38.field823[var5];
                                       var32 = class38.field823[1 + var5];
                                       var39 = var51?class18.field266:class50.field1122;
                                       class13.method175(var39, var31, var32);
                                       continue;
                                    }

                                    if(var38 == 3110) {
                                       --var5;
                                       class214.field3188 = class38.field823[var5] == 1;
                                       continue;
                                    }

                                    if(var38 == 3111) {
                                       class38.field823[var5++] = class136.field2123.field143?1:0;
                                       continue;
                                    }

                                    if(var38 == 3112) {
                                       --var5;
                                       class136.field2123.field143 = class38.field823[var5] == 1;
                                       class42.method886();
                                       continue;
                                    }

                                    if(var38 == 3113) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       --var5;
                                       var88 = class38.field823[var5] == 1;
                                       class105.method2384(var49, var88, false);
                                       continue;
                                    }

                                    if(var38 == 3115) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       client.field337.method2903(45);
                                       client.field337.method2619(var31);
                                       continue;
                                    }

                                    if(var38 == 3116) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       var6 -= 2;
                                       var44 = class38.field818[var6];
                                       var17 = class38.field818[var6 + 1];
                                       if(var44.length() <= 500 && var17.length() <= 500) {
                                          client.field337.method2903(152);
                                          client.field337.method2619(1 + class54.method1165(var44) + class54.method1165(var17));
                                          client.field337.method2703(var17);
                                          client.field337.method2654(var31);
                                          client.field337.method2703(var44);
                                       }
                                       continue;
                                    }
                                 } else if(var38 < 3300) {
                                    if(var38 == 3200) {
                                       var5 -= 3;
                                       var31 = class38.field823[var5];
                                       var32 = class38.field823[var5 + 1];
                                       var68 = class38.field823[var5 + 2];
                                       if(client.field403 != 0 && var32 != 0 && client.field536 < 50) {
                                          client.field319[client.field536] = var31;
                                          client.field538[client.field536] = var32;
                                          client.field539[client.field536] = var68;
                                          client.field541[client.field536] = null;
                                          client.field528[client.field536] = 0;
                                          ++client.field536;
                                       }
                                       continue;
                                    }

                                    if(var38 == 3201) {
                                       --var5;
                                       class31.method696(class38.field823[var5]);
                                       continue;
                                    }

                                    if(var38 == 3202) {
                                       var5 -= 2;
                                       var31 = class38.field823[var5];
                                       int var10000 = class38.field823[1 + var5];
                                       if(client.field294 != 0 && var31 != -1) {
                                          class180.method3615(class0.field12, var31, 0, client.field294, false);
                                          client.field533 = true;
                                       }
                                       continue;
                                    }
                                 } else if(var38 < 3400) {
                                    if(var38 == 3300) {
                                       class38.field823[var5++] = client.field305;
                                       continue;
                                    }

                                    if(var38 == 3301) {
                                       var5 -= 2;
                                       var31 = class38.field823[var5];
                                       var32 = class38.field823[var5 + 1];
                                       class38.field823[var5++] = class31.method697(var31, var32);
                                       continue;
                                    }

                                    if(var38 == 3302) {
                                       var5 -= 2;
                                       var31 = class38.field823[var5];
                                       var32 = class38.field823[1 + var5];
                                       class38.field823[var5++] = class26.method623(var31, var32);
                                       continue;
                                    }

                                    if(var38 == 3303) {
                                       var5 -= 2;
                                       var31 = class38.field823[var5];
                                       var32 = class38.field823[1 + var5];
                                       class38.field823[var5++] = class14.method177(var31, var32);
                                       continue;
                                    }

                                    if(var38 == 3304) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       class38.field823[var5++] = class154.method3286(var31).field1170;
                                       continue;
                                    }

                                    if(var38 == 3305) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       class38.field823[var5++] = client.field430[var31];
                                       continue;
                                    }

                                    if(var38 == 3306) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       class38.field823[var5++] = client.field431[var31];
                                       continue;
                                    }

                                    if(var38 == 3307) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       class38.field823[var5++] = client.field432[var31];
                                       continue;
                                    }

                                    if(var38 == 3308) {
                                       var31 = class99.field1701;
                                       var32 = (class3.field65.field875 >> 7) + class0.field11;
                                       var68 = (class3.field65.field832 >> 7) + class21.field592;
                                       class38.field823[var5++] = (var31 << 28) + (var32 << 14) + var68;
                                       continue;
                                    }

                                    if(var38 == 3309) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       class38.field823[var5++] = var31 >> 14 & 16383;
                                       continue;
                                    }

                                    if(var38 == 3310) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       class38.field823[var5++] = var31 >> 28;
                                       continue;
                                    }

                                    if(var38 == 3311) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       class38.field823[var5++] = var31 & 16383;
                                       continue;
                                    }

                                    if(var38 == 3312) {
                                       class38.field823[var5++] = client.field520?1:0;
                                       continue;
                                    }

                                    if(var38 == 3313) {
                                       var5 -= 2;
                                       var31 = class38.field823[var5] + '耀';
                                       var32 = class38.field823[1 + var5];
                                       class38.field823[var5++] = class31.method697(var31, var32);
                                       continue;
                                    }

                                    if(var38 == 3314) {
                                       var5 -= 2;
                                       var31 = class38.field823[var5] + '耀';
                                       var32 = class38.field823[1 + var5];
                                       class38.field823[var5++] = class26.method623(var31, var32);
                                       continue;
                                    }

                                    if(var38 == 3315) {
                                       var5 -= 2;
                                       var31 = '耀' + class38.field823[var5];
                                       var32 = class38.field823[var5 + 1];
                                       class38.field823[var5++] = class14.method177(var31, var32);
                                       continue;
                                    }

                                    if(var38 == 3316) {
                                       if(client.field460 >= 2) {
                                          class38.field823[var5++] = client.field460;
                                       } else {
                                          class38.field823[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var38 == 3317) {
                                       class38.field823[var5++] = client.field312;
                                       continue;
                                    }

                                    if(var38 == 3318) {
                                       class38.field823[var5++] = client.field407;
                                       continue;
                                    }

                                    if(var38 == 3321) {
                                       class38.field823[var5++] = client.field458;
                                       continue;
                                    }

                                    if(var38 == 3322) {
                                       class38.field823[var5++] = client.field545;
                                       continue;
                                    }

                                    if(var38 == 3323) {
                                       if(client.field506) {
                                          class38.field823[var5++] = 1;
                                       } else {
                                          class38.field823[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var38 == 3324) {
                                       class38.field823[var5++] = client.field561;
                                       continue;
                                    }
                                 } else if(var38 < 3500) {
                                    if(var38 == 3400) {
                                       var5 -= 2;
                                       var31 = class38.field823[var5];
                                       var32 = class38.field823[var5 + 1];
                                       class52 var40 = class41.method843(var31);
                                       if(var40.field1154 != 115) {
                                          ;
                                       }

                                       for(var45 = 0; var45 < var40.field1159; ++var45) {
                                          if(var32 == var40.field1158[var45]) {
                                             class38.field818[var6++] = var40.field1163[var45];
                                             var40 = null;
                                             break;
                                          }
                                       }

                                       if(var40 != null) {
                                          class38.field818[var6++] = var40.field1151;
                                       }
                                       continue;
                                    }

                                    if(var38 == 3408) {
                                       var5 -= 4;
                                       var31 = class38.field823[var5];
                                       var32 = class38.field823[1 + var5];
                                       var68 = class38.field823[var5 + 2];
                                       var45 = class38.field823[var5 + 3];
                                       class52 var28 = class41.method843(var68);
                                       if(var28.field1155 == var31 && var28.field1154 == var32) {
                                          for(var73 = 0; var73 < var28.field1159; ++var73) {
                                             if(var45 == var28.field1158[var73]) {
                                                if(var32 == 115) {
                                                   class38.field818[var6++] = var28.field1163[var73];
                                                } else {
                                                   class38.field823[var5++] = var28.field1160[var73];
                                                }

                                                var28 = null;
                                                break;
                                             }
                                          }

                                          if(null != var28) {
                                             if(var32 == 115) {
                                                class38.field818[var6++] = var28.field1151;
                                             } else {
                                                class38.field823[var5++] = var28.field1156;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var32 == 115) {
                                          class38.field818[var6++] = "null";
                                       } else {
                                          class38.field823[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else if(var38 < 3700) {
                                    if(var38 == 3600) {
                                       if(client.field562 == 0) {
                                          class38.field823[var5++] = -2;
                                       } else if(client.field562 == 1) {
                                          class38.field823[var5++] = -1;
                                       } else {
                                          class38.field823[var5++] = client.field391;
                                       }
                                       continue;
                                    }

                                    if(var38 == 3601) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       if(client.field562 == 2 && var31 < client.field391) {
                                          class38.field818[var6++] = client.field456[var31].field250;
                                          class38.field818[var6++] = client.field456[var31].field246;
                                          continue;
                                       }

                                       class38.field818[var6++] = "";
                                       class38.field818[var6++] = "";
                                       continue;
                                    }

                                    if(var38 == 3602) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       if(client.field562 == 2 && var31 < client.field391) {
                                          class38.field823[var5++] = client.field456[var31].field247;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var38 == 3603) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       if(client.field562 == 2 && var31 < client.field391) {
                                          class38.field823[var5++] = client.field456[var31].field248;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var38 == 3604) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       --var5;
                                       var32 = class38.field823[var5];
                                       class43.method890(var49, var32);
                                       continue;
                                    }

                                    if(var38 == 3605) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       class118.method2568(var49);
                                       continue;
                                    }

                                    if(var38 == 3606) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       if(null == var49) {
                                          continue;
                                       }

                                       var44 = class156.method3300(var49, client.field518);
                                       if(var44 == null) {
                                          continue;
                                       }

                                       var68 = 0;

                                       while(true) {
                                          if(var68 >= client.field391) {
                                             continue label3584;
                                          }

                                          class17 var84 = client.field456[var68];
                                          String var71 = var84.field250;
                                          var20 = class156.method3300(var71, client.field518);
                                          boolean var91;
                                          if(null != var49 && null != var71) {
                                             if(!var49.startsWith("#") && !var71.startsWith("#")) {
                                                var91 = var44.equals(var20);
                                             } else {
                                                var91 = var49.equals(var71);
                                             }
                                          } else {
                                             var91 = false;
                                          }

                                          if(var91) {
                                             --client.field391;

                                             for(var22 = var68; var22 < client.field391; ++var22) {
                                                client.field456[var22] = client.field456[1 + var22];
                                             }

                                             client.field385 = client.field478;
                                             client.field337.method2903(47);
                                             client.field337.method2783(class54.method1165(var49));
                                             client.field337.method2703(var49);
                                             continue label3584;
                                          }

                                          ++var68;
                                       }
                                    }

                                    if(var38 == 3607) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       class4.method46(var49, false);
                                       continue;
                                    }

                                    if(var38 == 3608) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       class165.method3340(var49);
                                       continue;
                                    }

                                    if(var38 == 3609) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       class155[] var46 = class128.method2954();

                                       for(var68 = 0; var68 < var46.length; ++var68) {
                                          class155 var83 = var46[var68];
                                          if(var83.field2325 != -1 && var49.startsWith(class25.method615(var83.field2325))) {
                                             var49 = var49.substring(6 + Integer.toString(var83.field2325).length());
                                             break;
                                          }
                                       }

                                       class38.field823[var5++] = class145.method3128(var49, false)?1:0;
                                       continue;
                                    }

                                    String[] var59;
                                    char var65;
                                    String var81;
                                    long var89;
                                    if(var38 == 3611) {
                                       if(client.field363 == null) {
                                          class38.field818[var6++] = "";
                                          continue;
                                       }

                                       var59 = class38.field818;
                                       var32 = var6++;
                                       var81 = client.field363;
                                       var89 = 0L;
                                       var23 = var81.length();

                                       for(var63 = 0; var63 < var23; ++var63) {
                                          var89 *= 37L;
                                          var65 = var81.charAt(var63);
                                          if(var65 >= 65 && var65 <= 90) {
                                             var89 += (long)(1 + var65 - 65);
                                          } else if(var65 >= 97 && var65 <= 122) {
                                             var89 += (long)(var65 + 1 - 97);
                                          } else if(var65 >= 48 && var65 <= 57) {
                                             var89 += (long)(27 + var65 - 48);
                                          }

                                          if(var89 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(var89 % 37L == 0L && var89 != 0L) {
                                          var89 /= 37L;
                                       }

                                       var21 = class33.method701(var89);
                                       if(var21 == null) {
                                          var21 = "";
                                       }

                                       var59[var32] = var21;
                                       continue;
                                    }

                                    if(var38 == 3612) {
                                       if(client.field363 != null) {
                                          class38.field823[var5++] = client.field522;
                                       } else {
                                          class38.field823[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var38 == 3613) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       if(null != client.field363 && var31 < client.field522) {
                                          class38.field818[var6++] = class4.field74[var31].field645;
                                          continue;
                                       }

                                       class38.field818[var6++] = "";
                                       continue;
                                    }

                                    if(var38 == 3614) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       if(null != client.field363 && var31 < client.field522) {
                                          class38.field823[var5++] = class4.field74[var31].field640;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var38 == 3615) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       if(null != client.field363 && var31 < client.field522) {
                                          class38.field823[var5++] = class4.field74[var31].field641;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var38 == 3616) {
                                       class38.field823[var5++] = class178.field2952;
                                       continue;
                                    }

                                    if(var38 == 3617) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       class26.method628(var49);
                                       continue;
                                    }

                                    if(var38 == 3618) {
                                       class38.field823[var5++] = class30.field710;
                                       continue;
                                    }

                                    if(var38 == 3619) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       if(!var49.equals("")) {
                                          client.field337.method2903(3);
                                          client.field337.method2783(class54.method1165(var49));
                                          client.field337.method2703(var49);
                                       }
                                       continue;
                                    }

                                    if(var38 == 3620) {
                                       client.field337.method2903(3);
                                       client.field337.method2783(0);
                                       continue;
                                    }

                                    if(var38 == 3621) {
                                       if(client.field562 == 0) {
                                          class38.field823[var5++] = -1;
                                       } else {
                                          class38.field823[var5++] = client.field565;
                                       }
                                       continue;
                                    }

                                    if(var38 == 3622) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       if(client.field562 != 0 && var31 < client.field565) {
                                          class38.field818[var6++] = client.field566[var31].field132;
                                          class38.field818[var6++] = client.field566[var31].field131;
                                          continue;
                                       }

                                       class38.field818[var6++] = "";
                                       class38.field818[var6++] = "";
                                       continue;
                                    }

                                    if(var38 == 3623) {
                                       --var6;
                                       var49 = class38.field818[var6];
                                       if(var49.startsWith(class25.method615(0)) || var49.startsWith(class25.method615(1))) {
                                          var49 = var49.substring(7);
                                       }

                                       class38.field823[var5++] = class107.method2395(var49)?1:0;
                                       continue;
                                    }

                                    if(var38 == 3624) {
                                       --var5;
                                       var31 = class38.field823[var5];
                                       if(class4.field74 != null && var31 < client.field522 && class4.field74[var31].field645.equalsIgnoreCase(class3.field65.field58)) {
                                          class38.field823[var5++] = 1;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var38 == 3625) {
                                       if(null == client.field521) {
                                          class38.field818[var6++] = "";
                                          continue;
                                       }

                                       var59 = class38.field818;
                                       var32 = var6++;
                                       var81 = client.field521;
                                       var89 = 0L;
                                       var23 = var81.length();

                                       for(var63 = 0; var63 < var23; ++var63) {
                                          var89 *= 37L;
                                          var65 = var81.charAt(var63);
                                          if(var65 >= 65 && var65 <= 90) {
                                             var89 += (long)(var65 + 1 - 65);
                                          } else if(var65 >= 97 && var65 <= 122) {
                                             var89 += (long)(1 + var65 - 97);
                                          } else if(var65 >= 48 && var65 <= 57) {
                                             var89 += (long)(27 + var65 - 48);
                                          }

                                          if(var89 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(0L == var89 % 37L && 0L != var89) {
                                          var89 /= 37L;
                                       }

                                       var21 = class33.method701(var89);
                                       if(var21 == null) {
                                          var21 = "";
                                       }

                                       var59[var32] = var21;
                                       continue;
                                    }
                                 } else {
                                    long var78;
                                    if(var38 < 4000) {
                                       if(var38 == 3903) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = client.field570[var31].method4148();
                                          continue;
                                       }

                                       if(var38 == 3904) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = client.field570[var31].field3215;
                                          continue;
                                       }

                                       if(var38 == 3905) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = client.field570[var31].field3216;
                                          continue;
                                       }

                                       if(var38 == 3906) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = client.field570[var31].field3214;
                                          continue;
                                       }

                                       if(var38 == 3907) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = client.field570[var31].field3218;
                                          continue;
                                       }

                                       if(var38 == 3908) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = client.field570[var31].field3217;
                                          continue;
                                       }

                                       if(var38 == 3910) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var32 = client.field570[var31].method4144();
                                          class38.field823[var5++] = var32 == 0?1:0;
                                          continue;
                                       }

                                       if(var38 == 3911) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var32 = client.field570[var31].method4144();
                                          class38.field823[var5++] = var32 == 2?1:0;
                                          continue;
                                       }

                                       if(var38 == 3912) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var32 = client.field570[var31].method4144();
                                          class38.field823[var5++] = var32 == 5?1:0;
                                          continue;
                                       }

                                       if(var38 == 3913) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var32 = client.field570[var31].method4144();
                                          class38.field823[var5++] = var32 == 1?1:0;
                                          continue;
                                       }

                                       boolean var94;
                                       if(var38 == 3914) {
                                          --var5;
                                          var94 = class38.field823[var5] == 1;
                                          if(class162.field2659 != null) {
                                             class162.field2659.method4159(class224.field3223, var94);
                                          }
                                          continue;
                                       }

                                       if(var38 == 3915) {
                                          --var5;
                                          var94 = class38.field823[var5] == 1;
                                          if(class162.field2659 != null) {
                                             class162.field2659.method4159(class224.field3222, var94);
                                          }
                                          continue;
                                       }

                                       if(var38 == 3916) {
                                          var5 -= 2;
                                          var94 = class38.field823[var5] == 1;
                                          var88 = class38.field823[1 + var5] == 1;
                                          if(null != class162.field2659) {
                                             class162.field2659.method4159(new class22(var88), var94);
                                          }
                                          continue;
                                       }

                                       if(var38 == 3917) {
                                          --var5;
                                          var94 = class38.field823[var5] == 1;
                                          if(class162.field2659 != null) {
                                             class162.field2659.method4159(class224.field3221, var94);
                                          }
                                          continue;
                                       }

                                       if(var38 == 3918) {
                                          --var5;
                                          var94 = class38.field823[var5] == 1;
                                          if(null != class162.field2659) {
                                             class162.field2659.method4159(class224.field3224, var94);
                                          }
                                          continue;
                                       }

                                       if(var38 == 3919) {
                                          class38.field823[var5++] = null == class162.field2659?0:class162.field2659.field3220.size();
                                          continue;
                                       }

                                       class217 var54;
                                       if(var38 == 3920) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var54 = (class217)class162.field2659.field3220.get(var31);
                                          class38.field823[var5++] = var54.field3208;
                                          continue;
                                       }

                                       if(var38 == 3921) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var54 = (class217)class162.field2659.field3220.get(var31);
                                          class38.field818[var6++] = var54.method4102();
                                          continue;
                                       }

                                       if(var38 == 3922) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var54 = (class217)class162.field2659.field3220.get(var31);
                                          class38.field818[var6++] = var54.method4101();
                                          continue;
                                       }

                                       if(var38 == 3923) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var54 = (class217)class162.field2659.field3220.get(var31);
                                          var78 = class56.method1249() - class27.field677 - var54.field3209;
                                          var47 = (int)(var78 / 3600000L);
                                          var73 = (int)((var78 - (long)(3600000 * var47)) / 60000L);
                                          var33 = (int)((var78 - (long)(var47 * 3600000) - (long)('\uea60' * var73)) / 1000L);
                                          String var34 = var47 + ":" + var73 / 10 + var73 % 10 + ":" + var33 / 10 + var33 % 10;
                                          class38.field818[var6++] = var34;
                                          continue;
                                       }

                                       if(var38 == 3924) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var54 = (class217)class162.field2659.field3220.get(var31);
                                          class38.field823[var5++] = var54.field3206.field3214;
                                          continue;
                                       }

                                       if(var38 == 3925) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var54 = (class217)class162.field2659.field3220.get(var31);
                                          class38.field823[var5++] = var54.field3206.field3216;
                                          continue;
                                       }

                                       if(var38 == 3926) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var54 = (class217)class162.field2659.field3220.get(var31);
                                          class38.field823[var5++] = var54.field3206.field3215;
                                          continue;
                                       }
                                    } else if(var38 < 4100) {
                                       if(var38 == 4000) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var32 + var31;
                                          continue;
                                       }

                                       if(var38 == 4001) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[var5 + 1];
                                          class38.field823[var5++] = var31 - var32;
                                          continue;
                                       }

                                       if(var38 == 4002) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var32 * var31;
                                          continue;
                                       }

                                       if(var38 == 4003) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var31 / var32;
                                          continue;
                                       }

                                       if(var38 == 4004) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = (int)(Math.random() * (double)var31);
                                          continue;
                                       }

                                       if(var38 == 4005) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = (int)(Math.random() * (double)(1 + var31));
                                          continue;
                                       }

                                       if(var38 == 4006) {
                                          var5 -= 5;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[var5 + 1];
                                          var68 = class38.field823[var5 + 2];
                                          var45 = class38.field823[3 + var5];
                                          var47 = class38.field823[4 + var5];
                                          class38.field823[var5++] = var31 + (var47 - var68) * (var32 - var31) / (var45 - var68);
                                          continue;
                                       }

                                       if(var38 == 4007) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[var5 + 1];
                                          class38.field823[var5++] = var32 * var31 / 100 + var31;
                                          continue;
                                       }

                                       if(var38 == 4008) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[var5 + 1];
                                          class38.field823[var5++] = var31 | 1 << var32;
                                          continue;
                                       }

                                       if(var38 == 4009) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var31 & -1 - (1 << var32);
                                          continue;
                                       }

                                       if(var38 == 4010) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[1 + var5];
                                          class38.field823[var5++] = (var31 & 1 << var32) != 0?1:0;
                                          continue;
                                       }

                                       if(var38 == 4011) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var31 % var32;
                                          continue;
                                       }

                                       if(var38 == 4012) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[1 + var5];
                                          if(var31 == 0) {
                                             class38.field823[var5++] = 0;
                                          } else {
                                             class38.field823[var5++] = (int)Math.pow((double)var31, (double)var32);
                                          }
                                          continue;
                                       }

                                       if(var38 == 4013) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[var5 + 1];
                                          if(var31 == 0) {
                                             class38.field823[var5++] = 0;
                                          } else if(var32 == 0) {
                                             class38.field823[var5++] = Integer.MAX_VALUE;
                                          } else {
                                             class38.field823[var5++] = (int)Math.pow((double)var31, 1.0D / (double)var32);
                                          }
                                          continue;
                                       }

                                       if(var38 == 4014) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var31 & var32;
                                          continue;
                                       }

                                       if(var38 == 4015) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[var5 + 1];
                                          class38.field823[var5++] = var31 | var32;
                                          continue;
                                       }

                                       if(var38 == 4018) {
                                          var5 -= 3;
                                          long var97 = (long)class38.field823[var5];
                                          var78 = (long)class38.field823[1 + var5];
                                          long var50 = (long)class38.field823[2 + var5];
                                          class38.field823[var5++] = (int)(var97 * var50 / var78);
                                          continue;
                                       }
                                    } else if(var38 < 4200) {
                                       if(var38 == 4100) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          --var5;
                                          var32 = class38.field823[var5];
                                          class38.field818[var6++] = var49 + var32;
                                          continue;
                                       }

                                       if(var38 == 4101) {
                                          var6 -= 2;
                                          var49 = class38.field818[var6];
                                          var44 = class38.field818[var6 + 1];
                                          class38.field818[var6++] = var49 + var44;
                                          continue;
                                       }

                                       if(var38 == 4102) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          --var5;
                                          var32 = class38.field823[var5];
                                          class38.field818[var6++] = var49 + class21.method583(var32, true);
                                          continue;
                                       }

                                       if(var38 == 4103) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          class38.field818[var6++] = var49.toLowerCase();
                                          continue;
                                       }

                                       if(var38 == 4104) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          long var96 = 86400000L * ((long)var31 + 11745L);
                                          class38.field827.setTime(new Date(var96));
                                          var45 = class38.field827.get(5);
                                          var47 = class38.field827.get(2);
                                          var73 = class38.field827.get(1);
                                          class38.field818[var6++] = var45 + "-" + class38.field826[var47] + "-" + var73;
                                          continue;
                                       }

                                       if(var38 == 4105) {
                                          var6 -= 2;
                                          var49 = class38.field818[var6];
                                          var44 = class38.field818[var6 + 1];
                                          if(class3.field65.field31 != null && class3.field65.field31.field2971) {
                                             class38.field818[var6++] = var44;
                                             continue;
                                          }

                                          class38.field818[var6++] = var49;
                                          continue;
                                       }

                                       if(var38 == 4106) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field818[var6++] = Integer.toString(var31);
                                          continue;
                                       }

                                       if(var38 == 4107) {
                                          var6 -= 2;
                                          int[] var80 = class38.field823;
                                          var32 = var5++;
                                          var45 = class40.method811(class38.field818[var6], class38.field818[1 + var6], client.field326);
                                          if(var45 > 0) {
                                             var90 = 1;
                                          } else if(var45 < 0) {
                                             var90 = -1;
                                          } else {
                                             var90 = 0;
                                          }

                                          var80[var32] = var90;
                                          continue;
                                       }

                                       class227 var72;
                                       byte[] var85;
                                       if(var38 == 4108) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          var5 -= 2;
                                          var32 = class38.field823[var5];
                                          var68 = class38.field823[var5 + 1];
                                          var85 = class104.field1811.method3411(var68, 0);
                                          var72 = new class227(var85);
                                          class38.field823[var5++] = var72.method4168(var49, var32);
                                          continue;
                                       }

                                       if(var38 == 4109) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          var5 -= 2;
                                          var32 = class38.field823[var5];
                                          var68 = class38.field823[1 + var5];
                                          var85 = class104.field1811.method3411(var68, 0);
                                          var72 = new class227(var85);
                                          class38.field823[var5++] = var72.method4167(var49, var32);
                                          continue;
                                       }

                                       if(var38 == 4110) {
                                          var6 -= 2;
                                          var49 = class38.field818[var6];
                                          var44 = class38.field818[var6 + 1];
                                          --var5;
                                          if(class38.field823[var5] == 1) {
                                             class38.field818[var6++] = var49;
                                          } else {
                                             class38.field818[var6++] = var44;
                                          }
                                          continue;
                                       }

                                       if(var38 == 4111) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          class38.field818[var6++] = class226.method4169(var49);
                                          continue;
                                       }

                                       if(var38 == 4112) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          --var5;
                                          var32 = class38.field823[var5];
                                          class38.field818[var6++] = var49 + (char)var32;
                                          continue;
                                       }

                                       char var56;
                                       if(var38 == 4113) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var62 = class38.field823;
                                          var68 = var5++;
                                          var56 = (char)var31;
                                          if(var56 >= 32 && var56 <= 126) {
                                             var18 = true;
                                          } else if(var56 >= 160 && var56 <= 255) {
                                             var18 = true;
                                          } else if(var56 != 8364 && var56 != 338 && var56 != 8212 && var56 != 339 && var56 != 376) {
                                             var18 = false;
                                          } else {
                                             var18 = true;
                                          }

                                          var62[var68] = var18?1:0;
                                          continue;
                                       }

                                       if(var38 == 4114) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = class102.method2290((char)var31)?1:0;
                                          continue;
                                       }

                                       if(var38 == 4115) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = class35.method758((char)var31)?1:0;
                                          continue;
                                       }

                                       if(var38 == 4116) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = class40.method812((char)var31)?1:0;
                                          continue;
                                       }

                                       if(var38 == 4117) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          if(null != var49) {
                                             class38.field823[var5++] = var49.length();
                                          } else {
                                             class38.field823[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var38 == 4118) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          var5 -= 2;
                                          var32 = class38.field823[var5];
                                          var68 = class38.field823[1 + var5];
                                          class38.field818[var6++] = var49.substring(var32, var68);
                                          continue;
                                       }

                                       if(var38 == 4119) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          StringBuilder var61 = new StringBuilder(var49.length());
                                          var27 = false;

                                          for(var45 = 0; var45 < var49.length(); ++var45) {
                                             var56 = var49.charAt(var45);
                                             if(var56 == 60) {
                                                var27 = true;
                                             } else if(var56 == 62) {
                                                var27 = false;
                                             } else if(!var27) {
                                                var61.append(var56);
                                             }
                                          }

                                          class38.field818[var6++] = var61.toString();
                                          continue;
                                       }

                                       if(var38 == 4120) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          --var5;
                                          var32 = class38.field823[var5];
                                          class38.field823[var5++] = var49.indexOf(var32);
                                          continue;
                                       }

                                       if(var38 == 4121) {
                                          var6 -= 2;
                                          var49 = class38.field818[var6];
                                          var44 = class38.field818[var6 + 1];
                                          --var5;
                                          var68 = class38.field823[var5];
                                          class38.field823[var5++] = var49.indexOf(var44, var68);
                                          continue;
                                       }
                                    } else if(var38 < 4300) {
                                       if(var38 == 4200) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field818[var6++] = class1.method14(var31).field1183;
                                          continue;
                                       }

                                       class55 var43;
                                       if(var38 == 4201) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[var5 + 1];
                                          var43 = class1.method14(var31);
                                          if(var32 >= 1 && var32 <= 5 && var43.field1200[var32 - 1] != null) {
                                             class38.field818[var6++] = var43.field1200[var32 - 1];
                                             continue;
                                          }

                                          class38.field818[var6++] = "";
                                          continue;
                                       }

                                       if(var38 == 4202) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[var5 + 1];
                                          var43 = class1.method14(var31);
                                          if(var32 >= 1 && var32 <= 5 && null != var43.field1181[var32 - 1]) {
                                             class38.field818[var6++] = var43.field1181[var32 - 1];
                                             continue;
                                          }

                                          class38.field818[var6++] = "";
                                          continue;
                                       }

                                       if(var38 == 4203) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = class1.method14(var31).field1212;
                                          continue;
                                       }

                                       if(var38 == 4204) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = class1.method14(var31).field1197 == 1?1:0;
                                          continue;
                                       }

                                       class55 var64;
                                       if(var38 == 4205) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var64 = class1.method14(var31);
                                          if(var64.field1178 == -1 && var64.field1216 >= 0) {
                                             class38.field823[var5++] = var64.field1216;
                                             continue;
                                          }

                                          class38.field823[var5++] = var31;
                                          continue;
                                       }

                                       if(var38 == 4206) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var64 = class1.method14(var31);
                                          if(var64.field1178 >= 0 && var64.field1216 >= 0) {
                                             class38.field823[var5++] = var64.field1216;
                                             continue;
                                          }

                                          class38.field823[var5++] = var31;
                                          continue;
                                       }

                                       if(var38 == 4207) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = class1.method14(var31).field1199?1:0;
                                          continue;
                                       }

                                       if(var38 == 4208) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var64 = class1.method14(var31);
                                          if(var64.field1213 == -1 && var64.field1227 >= 0) {
                                             class38.field823[var5++] = var64.field1227;
                                             continue;
                                          }

                                          class38.field823[var5++] = var31;
                                          continue;
                                       }

                                       if(var38 == 4209) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var64 = class1.method14(var31);
                                          if(var64.field1213 >= 0 && var64.field1227 >= 0) {
                                             class38.field823[var5++] = var64.field1227;
                                             continue;
                                          }

                                          class38.field823[var5++] = var31;
                                          continue;
                                       }

                                       if(var38 == 4210) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          --var5;
                                          var32 = class38.field823[var5];
                                          class4.method50(var49, var32 == 1);
                                          class38.field823[var5++] = class78.field1452;
                                          continue;
                                       }

                                       if(var38 == 4211) {
                                          if(class8.field151 != null && class110.field1954 < class78.field1452) {
                                             class38.field823[var5++] = class8.field151[++class110.field1954 - 1] & '\uffff';
                                             continue;
                                          }

                                          class38.field823[var5++] = -1;
                                          continue;
                                       }

                                       if(var38 == 4212) {
                                          class110.field1954 = 0;
                                          continue;
                                       }
                                    } else if(var38 < 5100) {
                                       if(var38 == 5000) {
                                          class38.field823[var5++] = client.field511;
                                          continue;
                                       }

                                       if(var38 == 5001) {
                                          var5 -= 3;
                                          client.field511 = class38.field823[var5];
                                          var32 = class38.field823[1 + var5];
                                          class133[] var52 = new class133[]{class133.field2110, class133.field2108, class133.field2107};
                                          class133[] var86 = var52;
                                          var47 = 0;

                                          class133 var95;
                                          while(true) {
                                             if(var47 >= var86.length) {
                                                var95 = null;
                                                break;
                                             }

                                             class133 var53 = var86[var47];
                                             if(var32 == var53.field2109) {
                                                var95 = var53;
                                                break;
                                             }

                                             ++var47;
                                          }

                                          class29.field706 = var95;
                                          if(null == class29.field706) {
                                             class29.field706 = class133.field2107;
                                          }

                                          client.field379 = class38.field823[2 + var5];
                                          client.field337.method2903(145);
                                          client.field337.method2783(client.field511);
                                          client.field337.method2783(class29.field706.field2109);
                                          client.field337.method2783(client.field379);
                                          continue;
                                       }

                                       if(var38 == 5002) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          var5 -= 2;
                                          var32 = class38.field823[var5];
                                          var68 = class38.field823[var5 + 1];
                                          client.field337.method2903(128);
                                          client.field337.method2783(class54.method1165(var49) + 2);
                                          client.field337.method2703(var49);
                                          client.field337.method2783(var32 - 1);
                                          client.field337.method2783(var68);
                                          continue;
                                       }

                                       if(var38 == 5003) {
                                          var5 -= 2;
                                          var31 = class38.field823[var5];
                                          var32 = class38.field823[var5 + 1];
                                          class37 var48 = class44.method939(var31, var32);
                                          if(null != var48) {
                                             class38.field823[var5++] = var48.field808;
                                             class38.field823[var5++] = var48.field806;
                                             class38.field818[var6++] = null != var48.field810?var48.field810:"";
                                             class38.field818[var6++] = var48.field813 != null?var48.field813:"";
                                             class38.field818[var6++] = null != var48.field807?var48.field807:"";
                                          } else {
                                             class38.field823[var5++] = -1;
                                             class38.field823[var5++] = 0;
                                             class38.field818[var6++] = "";
                                             class38.field818[var6++] = "";
                                             class38.field818[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var38 == 5004) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class37 var67 = class118.method2569(var31);
                                          if(var67 != null) {
                                             class38.field823[var5++] = var67.field805;
                                             class38.field823[var5++] = var67.field806;
                                             class38.field818[var6++] = null != var67.field810?var67.field810:"";
                                             class38.field818[var6++] = null != var67.field813?var67.field813:"";
                                             class38.field818[var6++] = null != var67.field807?var67.field807:"";
                                          } else {
                                             class38.field823[var5++] = -1;
                                             class38.field823[var5++] = 0;
                                             class38.field818[var6++] = "";
                                             class38.field818[var6++] = "";
                                             class38.field818[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var38 == 5005) {
                                          if(class29.field706 == null) {
                                             class38.field823[var5++] = -1;
                                          } else {
                                             class38.field823[var5++] = class29.field706.field2109;
                                          }
                                          continue;
                                       }

                                       if(var38 == 5008) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          --var5;
                                          var32 = class38.field823[var5];
                                          var17 = var49.toLowerCase();
                                          byte var66 = 0;
                                          if(var17.startsWith("yellow:")) {
                                             var66 = 0;
                                             var49 = var49.substring("yellow:".length());
                                          } else if(var17.startsWith("red:")) {
                                             var66 = 1;
                                             var49 = var49.substring("red:".length());
                                          } else if(var17.startsWith("green:")) {
                                             var66 = 2;
                                             var49 = var49.substring("green:".length());
                                          } else if(var17.startsWith("cyan:")) {
                                             var66 = 3;
                                             var49 = var49.substring("cyan:".length());
                                          } else if(var17.startsWith("purple:")) {
                                             var66 = 4;
                                             var49 = var49.substring("purple:".length());
                                          } else if(var17.startsWith("white:")) {
                                             var66 = 5;
                                             var49 = var49.substring("white:".length());
                                          } else if(var17.startsWith("flash1:")) {
                                             var66 = 6;
                                             var49 = var49.substring("flash1:".length());
                                          } else if(var17.startsWith("flash2:")) {
                                             var66 = 7;
                                             var49 = var49.substring("flash2:".length());
                                          } else if(var17.startsWith("flash3:")) {
                                             var66 = 8;
                                             var49 = var49.substring("flash3:".length());
                                          } else if(var17.startsWith("glow1:")) {
                                             var66 = 9;
                                             var49 = var49.substring("glow1:".length());
                                          } else if(var17.startsWith("glow2:")) {
                                             var66 = 10;
                                             var49 = var49.substring("glow2:".length());
                                          } else if(var17.startsWith("glow3:")) {
                                             var66 = 11;
                                             var49 = var49.substring("glow3:".length());
                                          } else if(client.field326 != 0) {
                                             if(var17.startsWith("yellow:")) {
                                                var66 = 0;
                                                var49 = var49.substring("yellow:".length());
                                             } else if(var17.startsWith("red:")) {
                                                var66 = 1;
                                                var49 = var49.substring("red:".length());
                                             } else if(var17.startsWith("green:")) {
                                                var66 = 2;
                                                var49 = var49.substring("green:".length());
                                             } else if(var17.startsWith("cyan:")) {
                                                var66 = 3;
                                                var49 = var49.substring("cyan:".length());
                                             } else if(var17.startsWith("purple:")) {
                                                var66 = 4;
                                                var49 = var49.substring("purple:".length());
                                             } else if(var17.startsWith("white:")) {
                                                var66 = 5;
                                                var49 = var49.substring("white:".length());
                                             } else if(var17.startsWith("flash1:")) {
                                                var66 = 6;
                                                var49 = var49.substring("flash1:".length());
                                             } else if(var17.startsWith("flash2:")) {
                                                var66 = 7;
                                                var49 = var49.substring("flash2:".length());
                                             } else if(var17.startsWith("flash3:")) {
                                                var66 = 8;
                                                var49 = var49.substring("flash3:".length());
                                             } else if(var17.startsWith("glow1:")) {
                                                var66 = 9;
                                                var49 = var49.substring("glow1:".length());
                                             } else if(var17.startsWith("glow2:")) {
                                                var66 = 10;
                                                var49 = var49.substring("glow2:".length());
                                             } else if(var17.startsWith("glow3:")) {
                                                var66 = 11;
                                                var49 = var49.substring("glow3:".length());
                                             }
                                          }

                                          var17 = var49.toLowerCase();
                                          byte var58 = 0;
                                          if(var17.startsWith("wave:")) {
                                             var58 = 1;
                                             var49 = var49.substring("wave:".length());
                                          } else if(var17.startsWith("wave2:")) {
                                             var58 = 2;
                                             var49 = var49.substring("wave2:".length());
                                          } else if(var17.startsWith("shake:")) {
                                             var58 = 3;
                                             var49 = var49.substring("shake:".length());
                                          } else if(var17.startsWith("scroll:")) {
                                             var58 = 4;
                                             var49 = var49.substring("scroll:".length());
                                          } else if(var17.startsWith("slide:")) {
                                             var58 = 5;
                                             var49 = var49.substring("slide:".length());
                                          } else if(client.field326 != 0) {
                                             if(var17.startsWith("wave:")) {
                                                var58 = 1;
                                                var49 = var49.substring("wave:".length());
                                             } else if(var17.startsWith("wave2:")) {
                                                var58 = 2;
                                                var49 = var49.substring("wave2:".length());
                                             } else if(var17.startsWith("shake:")) {
                                                var58 = 3;
                                                var49 = var49.substring("shake:".length());
                                             } else if(var17.startsWith("scroll:")) {
                                                var58 = 4;
                                                var49 = var49.substring("scroll:".length());
                                             } else if(var17.startsWith("slide:")) {
                                                var58 = 5;
                                                var49 = var49.substring("slide:".length());
                                             }
                                          }

                                          client.field337.method2903(1);
                                          client.field337.method2783(0);
                                          var73 = client.field337.field2050;
                                          client.field337.method2783(var32);
                                          client.field337.method2783(var66);
                                          client.field337.method2783(var58);
                                          class39.method809(client.field337, var49);
                                          client.field337.method2671(client.field337.field2050 - var73);
                                          continue;
                                       }

                                       if(var38 == 5009) {
                                          var6 -= 2;
                                          var49 = class38.field818[var6];
                                          var44 = class38.field818[1 + var6];
                                          client.field337.method2903(104);
                                          client.field337.method2619(0);
                                          var68 = client.field337.field2050;
                                          client.field337.method2703(var49);
                                          class39.method809(client.field337, var44);
                                          client.field337.method2629(client.field337.field2050 - var68);
                                          continue;
                                       }

                                       if(var38 == 5015) {
                                          if(null != class3.field65 && null != class3.field65.field58) {
                                             var49 = class3.field65.field58;
                                          } else {
                                             var49 = "";
                                          }

                                          class38.field818[var6++] = var49;
                                          continue;
                                       }

                                       if(var38 == 5016) {
                                          class38.field823[var5++] = client.field379;
                                          continue;
                                       }

                                       if(var38 == 5017) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = class30.method687(var31);
                                          continue;
                                       }

                                       if(var38 == 5018) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          var62 = class38.field823;
                                          var68 = var5++;
                                          class37 var75 = (class37)class11.field174.method3950((long)var31);
                                          if(var75 == null) {
                                             var45 = -1;
                                          } else if(class11.field173.field3158 == var75.field3164) {
                                             var45 = -1;
                                          } else {
                                             var45 = ((class37)var75.field3164).field808;
                                          }

                                          var62[var68] = var45;
                                          continue;
                                       }

                                       if(var38 == 5019) {
                                          --var5;
                                          var31 = class38.field823[var5];
                                          class38.field823[var5++] = class36.method774(var31);
                                          continue;
                                       }

                                       if(var38 == 5020) {
                                          --var6;
                                          var49 = class38.field818[var6];
                                          class79.method1754(var49);
                                          continue;
                                       }

                                       if(var38 == 5021) {
                                          --var6;
                                          client.field415 = class38.field818[var6].toLowerCase().trim();
                                          continue;
                                       }

                                       if(var38 == 5022) {
                                          class38.field818[var6++] = client.field415;
                                          continue;
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var38 >= 2000) {
                                 var38 -= 1000;
                                 --var5;
                                 var15 = class134.method2983(class38.field823[var5]);
                              } else {
                                 var15 = var51?class18.field266:class50.field1122;
                              }

                              if(var38 == 1927) {
                                 if(class38.field829 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var15.field2916) {
                                    return;
                                 }

                                 class0 var41 = new class0();
                                 var41.field2 = var15;
                                 var41.field8 = var15.field2916;
                                 var41.field10 = class38.field829 + 1;
                                 client.field353.method3963(var0);
                                 continue;
                              }
                           }
                        }
                     } else {
                        if(var38 >= 2000) {
                           var38 -= 1000;
                           --var5;
                           var15 = class134.method2983(class38.field823[var5]);
                        } else {
                           var15 = var51?class18.field266:class50.field1122;
                        }

                        class79.method1777(var15);
                        if(var38 == 1200 || var38 == 1205 || var38 == 1212) {
                           var5 -= 2;
                           var32 = class38.field823[var5];
                           var68 = class38.field823[1 + var5];
                           var15.field2879 = var32;
                           var15.field2808 = var68;
                           class55 var30 = class1.method14(var32);
                           var15.field2927 = var30.field1188;
                           var15.field2859 = var30.field1193;
                           var15.field2860 = var30.field1194;
                           var15.field2856 = var30.field1179;
                           var15.field2857 = var30.field1196;
                           var15.field2933 = var30.field1191;
                           if(var38 == 1205) {
                              var15.field2865 = 0;
                           } else if(var38 == 1212 | var30.field1197 == 1) {
                              var15.field2865 = 1;
                           } else {
                              var15.field2865 = 2;
                           }

                           if(var15.field2862 > 0) {
                              var15.field2933 = var15.field2933 * 32 / var15.field2862;
                           } else if(var15.field2818 > 0) {
                              var15.field2933 = var15.field2933 * 32 / var15.field2818;
                           }
                           continue;
                        }

                        if(var38 == 1201) {
                           var15.field2800 = 2;
                           --var5;
                           var15.field2851 = class38.field823[var5];
                           continue;
                        }

                        if(var38 == 1202) {
                           var15.field2800 = 3;
                           var15.field2851 = class3.field65.field31.method3642();
                           continue;
                        }
                     }
                  } else {
                     var31 = -1;
                     if(var38 >= 2000) {
                        var38 -= 1000;
                        --var5;
                        var31 = class38.field823[var5];
                        var16 = class134.method2983(var31);
                     } else {
                        var16 = var51?class18.field266:class50.field1122;
                     }

                     if(var38 == 1000) {
                        var5 -= 4;
                        var16.field2816 = class38.field823[var5];
                        var16.field2941 = class38.field823[1 + var5];
                        var16.field2812 = class38.field823[2 + var5];
                        var16.field2925 = class38.field823[var5 + 3];
                        class79.method1777(var16);
                        class8.method117(var16);
                        if(var31 != -1 && var16.field2910 == 0) {
                           class53.method1145(class176.field2836[var31 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var38 == 1001) {
                        var5 -= 4;
                        var16.field2818 = class38.field823[var5];
                        var16.field2819 = class38.field823[1 + var5];
                        var16.field2806 = class38.field823[var5 + 2];
                        var16.field2815 = class38.field823[var5 + 3];
                        class79.method1777(var16);
                        class8.method117(var16);
                        if(var31 != -1 && var16.field2910 == 0) {
                           class53.method1145(class176.field2836[var31 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var38 == 1003) {
                        --var5;
                        var27 = class38.field823[var5] == 1;
                        if(var27 != var16.field2804) {
                           var16.field2804 = var27;
                           class79.method1777(var16);
                        }
                        continue;
                     }

                     if(var38 == 1005) {
                        --var5;
                        var16.field2940 = class38.field823[var5] == 1;
                        continue;
                     }

                     if(var38 == 1006) {
                        --var5;
                        var16.field2913 = class38.field823[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var38 < 5400) {
                  if(var38 == 5306) {
                     class38.field823[var5++] = class53.method1139();
                     continue;
                  }

                  if(var38 == 5307) {
                     --var5;
                     var31 = class38.field823[var5];
                     if(var31 != 1 && var31 != 2) {
                        continue;
                     }

                     client.field352 = 0L;
                     if(var31 >= 2) {
                        client.field507 = true;
                     } else {
                        client.field507 = false;
                     }

                     class10.method143();
                     if(client.field303 >= 25) {
                        class6.method103();
                     }

                     class147.field2263 = true;
                     continue;
                  }

                  if(var38 == 5308) {
                     class38.field823[var5++] = class136.field2123.field146;
                     continue;
                  }

                  if(var38 == 5309) {
                     --var5;
                     var31 = class38.field823[var5];
                     if(var31 == 1 || var31 == 2) {
                        class136.field2123.field146 = var31;
                        class42.method886();
                     }
                     continue;
                  }
               }

               if(var38 < 5600) {
                  if(var38 == 5504) {
                     var5 -= 2;
                     var31 = class38.field823[var5];
                     var32 = class38.field823[1 + var5];
                     if(!client.field542) {
                        client.field462 = var31;
                        client.field399 = var32;
                     }
                     continue;
                  }

                  if(var38 == 5505) {
                     class38.field823[var5++] = client.field462;
                     continue;
                  }

                  if(var38 == 5506) {
                     class38.field823[var5++] = client.field399;
                     continue;
                  }

                  if(var38 == 5530) {
                     --var5;
                     var31 = class38.field823[var5];
                     if(var31 < 0) {
                        var31 = 0;
                     }

                     client.field338 = var31;
                     continue;
                  }

                  if(var38 == 5531) {
                     class38.field823[var5++] = client.field338;
                     continue;
                  }
               }

               if(var38 < 5700 && var38 == 5630) {
                  client.field299 = 250;
               } else {
                  if(var38 < 6300) {
                     if(var38 == 6200) {
                        var5 -= 2;
                        client.field548 = (short)class38.field823[var5];
                        if(client.field548 <= 0) {
                           client.field548 = 256;
                        }

                        client.field549 = (short)class38.field823[1 + var5];
                        if(client.field549 <= 0) {
                           client.field549 = 205;
                        }
                        continue;
                     }

                     if(var38 == 6201) {
                        var5 -= 2;
                        client.field359 = (short)class38.field823[var5];
                        if(client.field359 <= 0) {
                           client.field359 = 256;
                        }

                        client.field551 = (short)class38.field823[1 + var5];
                        if(client.field551 <= 0) {
                           client.field551 = 320;
                        }
                        continue;
                     }

                     if(var38 == 6202) {
                        var5 -= 4;
                        client.field552 = (short)class38.field823[var5];
                        if(client.field552 <= 0) {
                           client.field552 = 1;
                        }

                        client.field492 = (short)class38.field823[1 + var5];
                        if(client.field492 <= 0) {
                           client.field492 = 32767;
                        } else if(client.field492 < client.field552) {
                           client.field492 = client.field552;
                        }

                        client.field320 = (short)class38.field823[2 + var5];
                        if(client.field320 <= 0) {
                           client.field320 = 1;
                        }

                        client.field563 = (short)class38.field823[var5 + 3];
                        if(client.field563 <= 0) {
                           client.field563 = 32767;
                        } else if(client.field563 < client.field320) {
                           client.field563 = client.field320;
                        }
                        continue;
                     }

                     if(var38 == 6203) {
                        if(client.field465 != null) {
                           class110.method2487(0, 0, client.field465.field2822, client.field465.field2823, false);
                           class38.field823[var5++] = client.field558;
                           class38.field823[var5++] = client.field559;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = -1;
                        }
                        continue;
                     }

                     if(var38 == 6204) {
                        class38.field823[var5++] = client.field359;
                        class38.field823[var5++] = client.field551;
                        continue;
                     }

                     if(var38 == 6205) {
                        class38.field823[var5++] = client.field548;
                        class38.field823[var5++] = client.field549;
                        continue;
                     }
                  }

                  if(var38 < 6600) {
                     if(var38 == 6500) {
                        class38.field823[var5++] = class2.method38()?1:0;
                        continue;
                     }

                     class27 var98;
                     if(var38 == 6501) {
                        var98 = class157.method3301();
                        if(var98 != null) {
                           class38.field823[var5++] = var98.field667;
                           class38.field823[var5++] = var98.field668;
                           class38.field818[var6++] = var98.field680;
                           class38.field823[var5++] = var98.field672;
                           class38.field823[var5++] = var98.field669;
                           class38.field818[var6++] = var98.field670;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                           class38.field823[var5++] = 0;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                        }
                        continue;
                     }

                     if(var38 == 6502) {
                        if(class27.field664 < class27.field663) {
                           var98 = class27.field662[++class27.field664 - 1];
                        } else {
                           var15 = null;
                        }

                        class38.field823[var5++] = -1;
                        class38.field823[var5++] = 0;
                        class38.field818[var6++] = "";
                        class38.field823[var5++] = 0;
                        class38.field823[var5++] = 0;
                        class38.field818[var6++] = "";
                        continue;
                     }

                     class27 var70;
                     if(var38 == 6506) {
                        --var5;
                        var31 = class38.field823[var5];
                        var70 = null;

                        for(var68 = 0; var68 < class27.field663; ++var68) {
                           if(var31 == class27.field662[var68].field667) {
                              var70 = class27.field662[var68];
                              break;
                           }
                        }

                        if(null != var70) {
                           class38.field823[var5++] = var70.field667;
                           class38.field823[var5++] = var70.field668;
                           class38.field818[var6++] = var70.field680;
                           class38.field823[var5++] = var70.field672;
                           class38.field823[var5++] = var70.field669;
                           class38.field818[var6++] = var70.field670;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                           class38.field823[var5++] = 0;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                        }
                        continue;
                     }

                     if(var38 == 6507) {
                        var5 -= 4;
                        var31 = class38.field823[var5];
                        var88 = class38.field823[1 + var5] == 1;
                        var68 = class38.field823[var5 + 2];
                        var18 = class38.field823[var5 + 3] == 1;
                        class28.method666(var31, var88, var68, var18);
                        continue;
                     }

                     if(var38 == 6511) {
                        --var5;
                        var31 = class38.field823[var5];
                        if(var31 >= 0 && var31 < class27.field663) {
                           var70 = class27.field662[var31];
                           class38.field823[var5++] = var70.field667;
                           class38.field823[var5++] = var70.field668;
                           class38.field818[var6++] = var70.field680;
                           class38.field823[var5++] = var70.field672;
                           class38.field823[var5++] = var70.field669;
                           class38.field818[var6++] = var70.field670;
                           continue;
                        }

                        class38.field823[var5++] = -1;
                        class38.field823[var5++] = 0;
                        class38.field818[var6++] = "";
                        class38.field823[var5++] = 0;
                        class38.field823[var5++] = 0;
                        class38.field818[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var37) {
            StringBuilder var36 = new StringBuilder(30);
            var36.append("").append(var4.field3175).append(" ");

            for(var13 = class38.field825 - 1; var13 >= 0; --var13) {
               var36.append("").append(class38.field828[var13].field219.field3175).append(" ");
            }

            var36.append("").append(var10);
            class13.method176(var36.toString(), var37);
         }
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-54"
   )
   static final void method2283() {
      client.field564 = 0;
      int var0 = (class3.field65.field875 >> 7) + class0.field11;
      int var1 = class21.field592 + (class3.field65.field832 >> 7);
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         client.field564 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         client.field564 = 1;
      }

      if(client.field564 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         client.field564 = 0;
      }

   }
}
