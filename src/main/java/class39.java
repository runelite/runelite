import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("NPCComposition")
public class class39 extends class204 {
   @ObfuscatedName("q")
   int[] field886;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1367890041
   )
   public int field887 = 1;
   @ObfuscatedName("v")
   @Export("isVisible")
   public boolean field888 = false;
   @ObfuscatedName("c")
   public static class193 field889 = new class193(50);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1094645615
   )
   @Export("id")
   public int field890;
   @ObfuscatedName("h")
   short[] field891;
   @ObfuscatedName("a")
   public static class167 field892;
   @ObfuscatedName("p")
   @Export("models")
   int[] field893;
   @ObfuscatedName("w")
   public static class167 field894;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -485651443
   )
   public int field895 = -1;
   @ObfuscatedName("j")
   short[] field896;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 225069965
   )
   public int field897 = -1;
   @ObfuscatedName("an")
   public boolean field898 = true;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1059793311
   )
   int field899 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1933930503
   )
   public int field900 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2089862389
   )
   public int field901 = -1;
   @ObfuscatedName("u")
   short[] field902;
   @ObfuscatedName("g")
   short[] field903;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -951119189
   )
   public int field904 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -807127883
   )
   @Export("combatLevel")
   public int field905 = -1;
   @ObfuscatedName("s")
   @Export("actions")
   public String[] field906 = new String[5];
   @ObfuscatedName("f")
   @Export("isMinimapVisible")
   public boolean field907 = true;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1374348255
   )
   int field908 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2033999587
   )
   int field909 = 128;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 821159269
   )
   int field910 = 128;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 313639947
   )
   public int field911 = -1;
   @ObfuscatedName("d")
   public static class193 field912 = new class193(64);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 872843679
   )
   public int field913 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 140618035
   )
   public int field914 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1504551455
   )
   public int field915 = 32;
   @ObfuscatedName("af")
   public int[] field916;
   @ObfuscatedName("k")
   @Export("name")
   public String field917 = "null";
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 456393645
   )
   int field918 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1732754403
   )
   int field919 = 0;
   @ObfuscatedName("az")
   @Export("isClickable")
   public boolean field920 = true;
   @ObfuscatedName("ac")
   public boolean field921 = false;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -2081237429
   )
   public int field922 = 30;
   @ObfuscatedName("bg")
   static class80 field923;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1388699879"
   )
   static int method856(int var0) {
      class27 var1 = (class27)class11.field183.get(Integer.valueOf(var0));
      return null == var1?0:var1.method727();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;S)V",
      garbageValue = "1055"
   )
   void method858(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(0 == var2) {
            return;
         }

         this.method859(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "465764952"
   )
   void method859(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2613();
         this.field893 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field893[var4] = var1.method2615();
         }
      } else if(var2 == 2) {
         this.field917 = var1.method2621();
      } else if(12 == var2) {
         this.field887 = var1.method2613();
      } else if(var2 == 13) {
         this.field895 = var1.method2615();
      } else if(var2 == 14) {
         this.field904 = var1.method2615();
      } else if(15 == var2) {
         this.field913 = var1.method2615();
      } else if(var2 == 16) {
         this.field897 = var1.method2615();
      } else if(17 == var2) {
         this.field904 = var1.method2615();
         this.field911 = var1.method2615();
         this.field900 = var1.method2615();
         this.field901 = var1.method2615();
      } else if(var2 >= 30 && var2 < 35) {
         this.field906[var2 - 30] = var1.method2621();
         if(this.field906[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field906[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2613();
         this.field902 = new short[var3];
         this.field903 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field902[var4] = (short)var1.method2615();
            this.field903[var4] = (short)var1.method2615();
         }
      } else if(var2 == 41) {
         var3 = var1.method2613();
         this.field896 = new short[var3];
         this.field891 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field896[var4] = (short)var1.method2615();
            this.field891[var4] = (short)var1.method2615();
         }
      } else if(60 == var2) {
         var3 = var1.method2613();
         this.field886 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field886[var4] = var1.method2615();
         }
      } else if(var2 == 93) {
         this.field907 = false;
      } else if(var2 == 95) {
         this.field905 = var1.method2615();
      } else if(97 == var2) {
         this.field909 = var1.method2615();
      } else if(var2 == 98) {
         this.field910 = var1.method2615();
      } else if(99 == var2) {
         this.field888 = true;
      } else if(100 == var2) {
         this.field899 = var1.method2699();
      } else if(101 == var2) {
         this.field919 = var1.method2699() * 5;
      } else if(102 == var2) {
         this.field914 = var1.method2615();
      } else if(var2 == 103) {
         this.field915 = var1.method2615();
      } else if(106 == var2) {
         this.field908 = var1.method2615();
         if(this.field908 == '\uffff') {
            this.field908 = -1;
         }

         this.field918 = var1.method2615();
         if(this.field918 == '\uffff') {
            this.field918 = -1;
         }

         var3 = var1.method2613();
         this.field916 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field916[var4] = var1.method2615();
            if('\uffff' == this.field916[var4]) {
               this.field916[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field898 = false;
      } else if(109 == var2) {
         this.field920 = false;
      } else if(var2 == 111) {
         this.field921 = true;
      } else if(112 == var2) {
         this.field922 = var1.method2613();
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;II)Lclass105;",
      garbageValue = "2075945119"
   )
   public final class105 method860(class42 var1, int var2, class42 var3, int var4) {
      if(null != this.field916) {
         class39 var11 = this.method862();
         return null == var11?null:var11.method860(var1, var2, var3, var4);
      } else {
         class105 var5 = (class105)field889.method3840((long)this.field890);
         if(null == var5) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field893.length; ++var7) {
               if(!field894.method3429(this.field893[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class100[] var8 = new class100[this.field893.length];

            int var9;
            for(var9 = 0; var9 < this.field893.length; ++var9) {
               var8[var9] = class100.method2307(field894, this.field893[var9], 0);
            }

            class100 var12;
            if(var8.length == 1) {
               var12 = var8[0];
            } else {
               var12 = new class100(var8, var8.length);
            }

            if(this.field902 != null) {
               for(var9 = 0; var9 < this.field902.length; ++var9) {
                  var12.method2303(this.field902[var9], this.field903[var9]);
               }
            }

            if(this.field896 != null) {
               for(var9 = 0; var9 < this.field896.length; ++var9) {
                  var12.method2304(this.field896[var9], this.field891[var9]);
               }
            }

            var5 = var12.method2368(64 + this.field899, 850 + this.field919, -30, -50, -30);
            field889.method3842(var5, (long)this.field890);
         }

         class105 var10;
         if(null != var1 && var3 != null) {
            var10 = var1.method957(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method954(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method954(var5, var4);
         } else {
            var10 = var5.method2471(true);
         }

         if(128 != this.field909 || this.field910 != 128) {
            var10.method2403(this.field909, this.field910, this.field909);
         }

         return var10;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "-900704230"
   )
   public final class100 method861() {
      if(null != this.field916) {
         class39 var5 = this.method862();
         return null == var5?null:var5.method861();
      } else if(this.field886 == null) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field886.length; ++var2) {
            if(!field894.method3429(this.field886[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var6 = new class100[this.field886.length];

            for(int var3 = 0; var3 < this.field886.length; ++var3) {
               var6[var3] = class100.method2307(field894, this.field886[var3], 0);
            }

            class100 var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new class100(var6, var6.length);
            }

            int var4;
            if(null != this.field902) {
               for(var4 = 0; var4 < this.field902.length; ++var4) {
                  var7.method2303(this.field902[var4], this.field903[var4]);
               }
            }

            if(this.field896 != null) {
               for(var4 = 0; var4 < this.field896.length; ++var4) {
                  var7.method2304(this.field896[var4], this.field891[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass39;",
      garbageValue = "-385835625"
   )
   public final class39 method862() {
      int var1 = -1;
      if(-1 != this.field908) {
         var1 = class93.method2248(this.field908);
      } else if(-1 != this.field918) {
         var1 = class176.field2905[this.field918];
      }

      return var1 >= 0 && var1 < this.field916.length && this.field916[var1] != -1?class28.method734(this.field916[var1]):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1941606043"
   )
   public boolean method863() {
      if(null == this.field916) {
         return true;
      } else {
         int var1 = -1;
         if(this.field908 != -1) {
            var1 = class93.method2248(this.field908);
         } else if(-1 != this.field918) {
            var1 = class176.field2905[this.field918];
         }

         return var1 >= 0 && var1 < this.field916.length && -1 != this.field916[var1];
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   static void method871() {
      for(class3 var0 = (class3)client.field453.method3871(); null != var0; var0 = (class3)client.field453.method3867()) {
         int var1 = var0.field70;
         if(class9.method161(var1)) {
            boolean var2 = true;
            class173[] var3 = class173.field2886[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2757;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3125;
               class173 var5 = class20.method641(var4);
               if(null != var5) {
                  class23.method657(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-7"
   )
   void method877() {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "116"
   )
   static void method878(String var0, String var1, String var2) {
      class31.field743 = var0;
      class31.field724 = var1;
      class31.field745 = var2;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-952157584"
   )
   static final void method887(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field302 && var0 != class42.field1002) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class30.field717.method2034(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class30.field717.method2035(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class30.field717.method2036(var0, var2, var3);
         }

         if(3 == var1) {
            var7 = class30.field717.method2037(var0, var2, var3);
         }

         int var11;
         if(0 != var7) {
            var11 = class30.field717.method2038(var0, var2, var3, var7);
            int var32 = var7 >> 14 & 32767;
            int var33 = var11 & 31;
            int var34 = var11 >> 6 & 3;
            class40 var12;
            if(0 == var1) {
               class30.field717.method2025(var0, var2, var3);
               var12 = class133.method2969(var32);
               if(0 != var12.field940) {
                  client.field361[var0].method2487(var2, var3, var33, var34, var12.field941);
               }
            }

            if(1 == var1) {
               class30.field717.method2060(var0, var2, var3);
            }

            if(2 == var1) {
               class30.field717.method2027(var0, var2, var3);
               var12 = class133.method2969(var32);
               if(var12.field938 + var2 > 103 || var3 + var12.field938 > 103 || var2 + var12.field939 > 103 || var3 + var12.field939 > 103) {
                  return;
               }

               if(var12.field940 != 0) {
                  client.field361[var0].method2495(var2, var3, var12.field938, var12.field939, var34, var12.field941);
               }
            }

            if(3 == var1) {
               class30.field717.method2028(var0, var2, var3);
               var12 = class133.method2969(var32);
               if(var12.field940 == 1) {
                  client.field361[var0].method2497(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field82[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class86 var35 = class30.field717;
            class108 var13 = client.field361[var0];
            class40 var14 = class133.method2969(var4);
            int var15;
            int var16;
            if(1 != var5 && 3 != var5) {
               var15 = var14.field938;
               var16 = var14.field939;
            } else {
               var15 = var14.field939;
               var16 = var14.field938;
            }

            int var17;
            int var18;
            if(var2 + var15 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (1 + var15 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = (1 + var16 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class5.field94[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var18][var19] + var21[var17][var19] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
            if(0 == var14.field942) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(1 == var14.field963) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(-1 == var14.field959 && null == var14.field925) {
                  var27 = var14.method896(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field959, true, (class85)null);
               }

               var35.method2014(var0, var2, var3, var22, (class85)var27, var25, var26);
               if(var14.field940 == 1) {
                  var13.method2492(var2, var3);
               }
            } else if(10 != var6 && 11 != var6) {
               if(var6 >= 12) {
                  if(-1 == var14.field959 && var14.field925 == null) {
                     var27 = var14.method896(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field959, true, (class85)null);
                  }

                  var35.method2055(var0, var2, var3, var22, 1, 1, (class85)var27, 0, var25, var26);
                  if(var14.field940 != 0) {
                     var13.method2490(var2, var3, var15, var16, var14.field941);
                  }
               } else if(0 == var6) {
                  if(var14.field959 == -1 && var14.field925 == null) {
                     var27 = var14.method896(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field959, true, (class85)null);
                  }

                  var35.method2016(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field88[var5], 0, var25, var26);
                  if(var14.field940 != 0) {
                     var13.method2489(var2, var3, var6, var5, var14.field941);
                  }
               } else if(1 == var6) {
                  if(var14.field959 == -1 && null == var14.field925) {
                     var27 = var14.method896(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field959, true, (class85)null);
                  }

                  var35.method2016(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field89[var5], 0, var25, var26);
                  if(var14.field940 != 0) {
                     var13.method2489(var2, var3, var6, var5, var14.field941);
                  }
               } else {
                  Object var29;
                  int var37;
                  if(2 == var6) {
                     var37 = 1 + var5 & 3;
                     Object var28;
                     if(-1 == var14.field959 && null == var14.field925) {
                        var28 = var14.method896(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method896(2, var37, var21, var23, var22, var24);
                     } else {
                        var28 = new class12(var4, 2, var5 + 4, var11, var2, var3, var14.field959, true, (class85)null);
                        var29 = new class12(var4, 2, var37, var11, var2, var3, var14.field959, true, (class85)null);
                     }

                     var35.method2016(var0, var2, var3, var22, (class85)var28, (class85)var29, class5.field88[var5], class5.field88[var37], var25, var26);
                     if(0 != var14.field940) {
                        var13.method2489(var2, var3, var6, var5, var14.field941);
                     }
                  } else if(var6 == 3) {
                     if(-1 == var14.field959 && var14.field925 == null) {
                        var27 = var14.method896(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field959, true, (class85)null);
                     }

                     var35.method2016(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field89[var5], 0, var25, var26);
                     if(0 != var14.field940) {
                        var13.method2489(var2, var3, var6, var5, var14.field941);
                     }
                  } else if(var6 == 9) {
                     if(var14.field959 == -1 && null == var14.field925) {
                        var27 = var14.method896(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field959, true, (class85)null);
                     }

                     var35.method2055(var0, var2, var3, var22, 1, 1, (class85)var27, 0, var25, var26);
                     if(0 != var14.field940) {
                        var13.method2490(var2, var3, var15, var16, var14.field941);
                     }
                  } else if(var6 == 4) {
                     if(var14.field959 == -1 && null == var14.field925) {
                        var27 = var14.method896(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field959, true, (class85)null);
                     }

                     var35.method2017(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field88[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var36;
                     if(var6 == 5) {
                        var37 = 16;
                        var36 = var35.method2034(var0, var2, var3);
                        if(var36 != 0) {
                           var37 = class133.method2969(var36 >> 14 & 32767).field947;
                        }

                        if(var14.field959 == -1 && var14.field925 == null) {
                           var29 = var14.method896(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field959, true, (class85)null);
                        }

                        var35.method2017(var0, var2, var3, var22, (class85)var29, (class85)null, class5.field88[var5], 0, class5.field90[var5] * var37, class5.field91[var5] * var37, var25, var26);
                     } else if(var6 == 6) {
                        var37 = 8;
                        var36 = var35.method2034(var0, var2, var3);
                        if(var36 != 0) {
                           var37 = class133.method2969(var36 >> 14 & 32767).field947 / 2;
                        }

                        if(-1 == var14.field959 && null == var14.field925) {
                           var29 = var14.method896(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field959, true, (class85)null);
                        }

                        var35.method2017(var0, var2, var3, var22, (class85)var29, (class85)null, 256, var5, class5.field92[var5] * var37, class5.field83[var5] * var37, var25, var26);
                     } else if(var6 == 7) {
                        var36 = var5 + 2 & 3;
                        if(-1 == var14.field959 && null == var14.field925) {
                           var27 = var14.method896(4, var36 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, var36 + 4, var11, var2, var3, var14.field959, true, (class85)null);
                        }

                        var35.method2017(var0, var2, var3, var22, (class85)var27, (class85)null, 256, var36, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var37 = 8;
                        var36 = var35.method2034(var0, var2, var3);
                        if(0 != var36) {
                           var37 = class133.method2969(var36 >> 14 & 32767).field947 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.field959 == -1 && var14.field925 == null) {
                           var29 = var14.method896(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method896(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field959, true, (class85)null);
                           var30 = new class12(var4, 4, var31 + 4, var11, var2, var3, var14.field959, true, (class85)null);
                        }

                        var35.method2017(var0, var2, var3, var22, (class85)var29, (class85)var30, 256, var5, var37 * class5.field92[var5], var37 * class5.field83[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field959 == -1 && null == var14.field925) {
                  var27 = var14.method896(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field959, true, (class85)null);
               }

               if(null != var27) {
                  var35.method2055(var0, var2, var3, var22, var15, var16, (class85)var27, 11 == var6?256:0, var25, var26);
               }

               if(var14.field940 != 0) {
                  var13.method2490(var2, var3, var15, var16, var14.field941);
               }
            }
         }
      }

   }
}
