import java.util.Date;
import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class168 extends class167 {
   @ObfuscatedName("s")
   class134 field2683;
   @ObfuscatedName("o")
   volatile boolean[] field2684;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1188008651
   )
   int field2685;
   @ObfuscatedName("b")
   volatile boolean field2686 = false;
   @ObfuscatedName("l")
   boolean field2687 = false;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1099938885
   )
   int field2688;
   @ObfuscatedName("v")
   static CRC32 field2689 = new CRC32();
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1081816215
   )
   int field2691;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1114800871
   )
   int field2692 = -1;
   @ObfuscatedName("h")
   class134 field2693;

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "592224048"
   )
   void method3438() {
      this.field2684 = new boolean[super.field2666.length];

      int var1;
      for(var1 = 0; var1 < this.field2684.length; ++var1) {
         this.field2684[var1] = false;
      }

      if(null == this.field2693) {
         this.field2686 = true;
      } else {
         this.field2692 = -1;

         for(var1 = 0; var1 < this.field2684.length; ++var1) {
            if(super.field2667[var1] > 0) {
               class134 var2 = this.field2693;
               class169 var4 = new class169();
               var4.field2698 = 1;
               var4.field3125 = (long)var1;
               var4.field2699 = var2;
               var4.field2697 = this;
               class199 var5 = class170.field2707;
               synchronized(class170.field2707) {
                  class170.field2707.method3900(var4);
               }

               class18.method228();
               this.field2692 = var1;
            }
         }

         if(this.field2692 == -1) {
            this.field2686 = true;
         }

      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-727604881"
   )
   public int method3439() {
      if(this.field2686) {
         return 100;
      } else if(null != super.field2666) {
         return 99;
      } else {
         int var2 = this.field2685;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(null != class124.field2032 && var3 == class124.field2032.field3125) {
            var1 = 1 + class171.field2716.field1992 * 99 / (class171.field2716.field1993.length - class124.field2032.field2740);
         } else {
            var1 = 0;
         }

         int var5 = var1;
         if(var1 >= 100) {
            var5 = 99;
         }

         return var5;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-297177099"
   )
   void vmethod3441(int var1) {
      if(this.field2693 != null && this.field2684 != null && this.field2684[var1]) {
         class13.method197(var1, this.field2693, this);
      } else {
         class98.method2284(this, this.field2685, var1, super.field2663[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1"
   )
   void method3443(int var1, byte[] var2, boolean var3, boolean var4) {
      if(this.field2686) {
         throw new RuntimeException();
      } else {
         if(this.field2683 != null) {
            int var5 = this.field2685;
            class134 var6 = this.field2683;
            class169 var7 = new class169();
            var7.field2698 = 0;
            var7.field3125 = (long)var5;
            var7.field2695 = var2;
            var7.field2699 = var6;
            class199 var8 = class170.field2707;
            synchronized(class170.field2707) {
               class170.field2707.method3900(var7);
            }

            class18.method228();
         }

         this.method3360(var2);
         this.method3438();
      }
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(Lclass134;I[BZI)V",
      garbageValue = "2084272227"
   )
   void method3444(class134 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2683) {
         if(this.field2686) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class98.method2284(this, 255, this.field2685, this.field2688, (byte)0, true);
            return;
         }

         field2689.reset();
         field2689.update(var3, 0, var3.length);
         var5 = (int)field2689.getValue();
         class119 var9 = new class119(class111.method2531(var3));
         int var7 = var9.method2613();
         if(5 != var7 && 6 != var7) {
            throw new RuntimeException(var7 + "," + this.field2685 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.method2618();
         }

         if(this.field2688 != var5 || var8 != this.field2691) {
            class98.method2284(this, 255, this.field2685, this.field2688, (byte)0, true);
            return;
         }

         this.method3360(var3);
         this.method3438();
      } else {
         if(!var4 && var2 == this.field2692) {
            this.field2686 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2684[var2] = false;
            if(this.field2687 || var4) {
               class98.method2284(this, this.field2685, var2, super.field2663[var2], (byte)2, var4);
            }

            return;
         }

         field2689.reset();
         field2689.update(var3, 0, var3.length - 2);
         var5 = (int)field2689.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.field2663[var2] != var5 || super.field2664[var2] != var6) {
            this.field2684[var2] = false;
            if(this.field2687 || var4) {
               class98.method2284(this, this.field2685, var2, super.field2663[var2], (byte)2, var4);
            }

            return;
         }

         this.field2684[var2] = true;
         if(var4) {
            super.field2666[var2] = class94.method2253(var3, false);
         }
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1208042797"
   )
   void method3445(int var1, int var2) {
      this.field2688 = var1;
      this.field2691 = var2;
      if(null != this.field2683) {
         class13.method197(this.field2685, this.field2683, this);
      } else {
         class98.method2284(this, 255, this.field2685, this.field2688, (byte)0, true);
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "706160186"
   )
   int method3446(int var1) {
      if(null != super.field2666[var1]) {
         return 100;
      } else if(this.field2684[var1]) {
         return 100;
      } else {
         int var3 = this.field2685;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(null != class124.field2032 && var4 == class124.field2032.field3125) {
            var2 = 1 + class171.field2716.field1992 * 99 / (class171.field2716.field1993.length - class124.field2032.field2740);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1717771412"
   )
   public int method3447() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2666.length; ++var3) {
         if(super.field2667[var3] > 0) {
            var1 += 100;
            var2 += this.method3446(var3);
         }
      }

      if(0 == var1) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "200000"
   )
   static void method3449(class0 var0, int var1) {
      Object[] var2 = var0.field4;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class18.method226(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field598;
         int[] var9 = var4.field606;
         byte var10 = -1;
         class36.field808 = 0;

         int var13;
         try {
            class36.field802 = new int[var4.field601];
            int var11 = 0;
            class36.field806 = new String[var4.field599];
            int var35 = 0;

            int var14;
            String var45;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field16;
                  }

                  if(-2147483645 == var14) {
                     var14 = var0.field2 != null?var0.field2.field2842:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field5;
                  }

                  if(-2147483643 == var14) {
                     var14 = null != var0.field2?var0.field2.field2759:-1;
                  }

                  if(-2147483642 == var14) {
                     var14 = null != var0.field6?var0.field6.field2842:-1;
                  }

                  if(-2147483641 == var14) {
                     var14 = null != var0.field6?var0.field6.field2759:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field14;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field1;
                  }

                  class36.field802[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var45 = (String)var2[var13];
                  if(var45.equals("event_opbase")) {
                     var45 = var0.field9;
                  }

                  class36.field806[var35++] = var45;
               }
            }

            var13 = 0;
            class36.field812 = var0.field10;

            label3902:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var34 = var8[var7];
               int var15;
               int var10001;
               int var19;
               int var37;
               String var38;
               int var40;
               int var42;
               int var49;
               String var52;
               String var55;
               String var65;
               byte var67;
               int[] var98;
               if(var34 < 100) {
                  if(0 == var34) {
                     class36.field813[var5++] = var9[var7];
                     continue;
                  }

                  if(var34 == 1) {
                     var14 = var9[var7];
                     class36.field813[var5++] = class176.field2905[var14];
                     continue;
                  }

                  if(2 == var34) {
                     var14 = var9[var7];
                     --var5;
                     class176.field2905[var14] = class36.field813[var5];
                     class0.method2(var14);
                     continue;
                  }

                  if(var34 == 3) {
                     class36.field805[var6++] = var4.field600[var7];
                     continue;
                  }

                  if(6 == var34) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var34 == 7) {
                     var5 -= 2;
                     if(class36.field813[var5 + 1] != class36.field813[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(8 == var34) {
                     var5 -= 2;
                     if(class36.field813[var5 + 1] == class36.field813[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var34 == 9) {
                     var5 -= 2;
                     if(class36.field813[var5] < class36.field813[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(10 == var34) {
                     var5 -= 2;
                     if(class36.field813[var5] > class36.field813[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var34 == 21) {
                     if(0 == class36.field808) {
                        return;
                     }

                     class14 var86 = class36.field809[--class36.field808];
                     var4 = var86.field216;
                     var8 = var4.field598;
                     var9 = var4.field606;
                     var7 = var86.field217;
                     class36.field802 = var86.field218;
                     class36.field806 = var86.field224;
                     continue;
                  }

                  if(25 == var34) {
                     var14 = var9[var7];
                     class36.field813[var5++] = class93.method2248(var14);
                     continue;
                  }

                  if(27 == var34) {
                     var14 = var9[var7];
                     --var5;
                     class157.method3264(var14, class36.field813[var5]);
                     continue;
                  }

                  if(31 == var34) {
                     var5 -= 2;
                     if(class36.field813[var5] <= class36.field813[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(32 == var34) {
                     var5 -= 2;
                     if(class36.field813[var5] >= class36.field813[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var34 == 33) {
                     class36.field813[var5++] = class36.field802[var9[var7]];
                     continue;
                  }

                  if(var34 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field802[var10001] = class36.field813[var5];
                     continue;
                  }

                  if(35 == var34) {
                     class36.field805[var6++] = class36.field806[var9[var7]];
                     continue;
                  }

                  if(36 == var34) {
                     var10001 = var9[var7];
                     --var6;
                     class36.field806[var10001] = class36.field805[var6];
                     continue;
                  }

                  if(37 == var34) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var108 = class36.field805;
                     if(0 == var14) {
                        var52 = "";
                     } else if(1 == var14) {
                        var38 = var108[var6];
                        if(null == var38) {
                           var52 = "null";
                        } else {
                           var52 = var38.toString();
                        }
                     } else {
                        var37 = var6 + var14;
                        var42 = 0;

                        for(var19 = var6; var19 < var37; ++var19) {
                           var55 = var108[var19];
                           if(var55 == null) {
                              var42 += 4;
                           } else {
                              var42 += var55.length();
                           }
                        }

                        StringBuilder var94 = new StringBuilder(var42);

                        for(var49 = var6; var49 < var37; ++var49) {
                           var65 = var108[var49];
                           if(var65 == null) {
                              var94.append("null");
                           } else {
                              var94.append(var65);
                           }
                        }

                        var52 = var94.toString();
                     }

                     class36.field805[var6++] = var52;
                     continue;
                  }

                  if(38 == var34) {
                     --var5;
                     continue;
                  }

                  if(39 == var34) {
                     --var6;
                     continue;
                  }

                  if(40 == var34) {
                     var14 = var9[var7];
                     class22 var112 = class18.method226(var14);
                     var98 = new int[var112.field601];
                     String[] var96 = new String[var112.field599];

                     for(var42 = 0; var42 < var112.field603; ++var42) {
                        var98[var42] = class36.field813[var5 - var112.field603 + var42];
                     }

                     for(var42 = 0; var42 < var112.field604; ++var42) {
                        var96[var42] = class36.field805[var42 + (var6 - var112.field604)];
                     }

                     var5 -= var112.field603;
                     var6 -= var112.field604;
                     class14 var107 = new class14();
                     var107.field216 = var4;
                     var107.field217 = var7;
                     var107.field218 = class36.field802;
                     var107.field224 = class36.field806;
                     class36.field809[++class36.field808 - 1] = var107;
                     var4 = var112;
                     var8 = var112.field598;
                     var9 = var112.field606;
                     var7 = -1;
                     class36.field802 = var98;
                     class36.field806 = var96;
                     continue;
                  }

                  if(42 == var34) {
                     class36.field813[var5++] = class171.field2723.method248(var9[var7]);
                     continue;
                  }

                  if(var34 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class171.field2723.method230(var10001, class36.field813[var5]);
                     continue;
                  }

                  if(var34 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var40 = class36.field813[var5];
                     if(var40 >= 0 && var40 <= 5000) {
                        class36.field807[var14] = var40;
                        var67 = -1;
                        if(var15 == 105) {
                           var67 = 0;
                        }

                        var42 = 0;

                        while(true) {
                           if(var42 >= var40) {
                              continue label3902;
                           }

                           class36.field800[var14][var42] = var67;
                           ++var42;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(45 == var34) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field813[var5];
                     if(var15 >= 0 && var15 < class36.field807[var14]) {
                        class36.field813[var5++] = class36.field800[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(46 == var34) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class36.field813[var5];
                     if(var15 >= 0 && var15 < class36.field807[var14]) {
                        class36.field800[var14][var15] = class36.field813[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var34 == 47) {
                     var45 = class171.field2723.method233(var9[var7]);
                     if(null == var45) {
                        var45 = "null";
                     }

                     class36.field805[var6++] = var45;
                     continue;
                  }

                  if(48 == var34) {
                     var10001 = var9[var7];
                     --var6;
                     class171.field2723.method232(var10001, class36.field805[var6]);
                     continue;
                  }
               }

               boolean var51;
               if(1 == var9[var7]) {
                  var51 = true;
               } else {
                  var51 = false;
               }

               class173 var16;
               class173 var36;
               class173 var39;
               class173 var41;
               boolean var50;
               boolean var59;
               if(var34 < 1000) {
                  if(100 == var34) {
                     var5 -= 3;
                     var15 = class36.field813[var5];
                     var40 = class36.field813[var5 + 1];
                     var37 = class36.field813[2 + var5];
                     if(var40 == 0) {
                        throw new RuntimeException();
                     }

                     var41 = class20.method641(var15);
                     if(var41.field2867 == null) {
                        var41.field2867 = new class173[1 + var37];
                     }

                     if(var41.field2867.length <= var37) {
                        class173[] var90 = new class173[1 + var37];

                        for(var49 = 0; var49 < var41.field2867.length; ++var49) {
                           var90[var49] = var41.field2867[var49];
                        }

                        var41.field2867 = var90;
                     }

                     if(var37 > 0 && var41.field2867[var37 - 1] == null) {
                        throw new RuntimeException("" + (var37 - 1));
                     }

                     class173 var91 = new class173();
                     var91.field2824 = var40;
                     var10001 = var41.field2842;
                     var91.field2842 = var41.field2842 * 2003393859;
                     var91.field2777 = var10001;
                     var91.field2759 = var37;
                     var91.field2757 = true;
                     var41.field2867[var37] = var91;
                     if(var51) {
                        class13.field211 = var91;
                     } else {
                        class4.field76 = var91;
                     }

                     class23.method657(var41);
                     continue;
                  }

                  if(101 == var34) {
                     var36 = var51?class13.field211:class4.field76;
                     var16 = class20.method641(var36.field2842);
                     var16.field2867[var36.field2759] = null;
                     class23.method657(var16);
                     continue;
                  }

                  if(102 == var34) {
                     --var5;
                     var36 = class20.method641(class36.field813[var5]);
                     var36.field2867 = null;
                     class23.method657(var36);
                     continue;
                  }

                  if(var34 == 200) {
                     var5 -= 2;
                     var15 = class36.field813[var5];
                     var40 = class36.field813[1 + var5];
                     var39 = class210.method4010(var15, var40);
                     if(var39 != null && -1 != var40) {
                        class36.field813[var5++] = 1;
                        if(var51) {
                           class13.field211 = var39;
                        } else {
                           class4.field76 = var39;
                        }
                        continue;
                     }

                     class36.field813[var5++] = 0;
                     continue;
                  }

                  if(var34 == 201) {
                     --var5;
                     var36 = class20.method641(class36.field813[var5]);
                     if(null != var36) {
                        class36.field813[var5++] = 1;
                        if(var51) {
                           class13.field211 = var36;
                        } else {
                           class4.field76 = var36;
                        }
                     } else {
                        class36.field813[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var17;
                  if((var34 < 1000 || var34 >= 1100) && (var34 < 2000 || var34 >= 2100)) {
                     if(var34 >= 1100 && var34 < 1200 || var34 >= 2100 && var34 < 2200) {
                        var40 = -1;
                        if(var34 >= 2000) {
                           var34 -= 1000;
                           --var5;
                           var40 = class36.field813[var5];
                           var36 = class20.method641(var40);
                        } else {
                           var36 = var51?class13.field211:class4.field76;
                        }

                        if(1100 == var34) {
                           var5 -= 2;
                           var36.field2879 = class36.field813[var5];
                           if(var36.field2879 > var36.field2853 - var36.field2773) {
                              var36.field2879 = var36.field2853 - var36.field2773;
                           }

                           if(var36.field2879 < 0) {
                              var36.field2879 = 0;
                           }

                           var36.field2780 = class36.field813[1 + var5];
                           if(var36.field2780 > var36.field2765 - var36.field2774) {
                              var36.field2780 = var36.field2765 - var36.field2774;
                           }

                           if(var36.field2780 < 0) {
                              var36.field2780 = 0;
                           }

                           class23.method657(var36);
                           continue;
                        }

                        if(1101 == var34) {
                           --var5;
                           var36.field2783 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1102) {
                           --var5;
                           var36.field2787 = class36.field813[var5] == 1;
                           class23.method657(var36);
                           continue;
                        }

                        if(1103 == var34) {
                           --var5;
                           var36.field2807 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1104) {
                           --var5;
                           var36.field2791 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1105) {
                           --var5;
                           var36.field2793 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1106) {
                           --var5;
                           var36.field2795 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(1107 == var34) {
                           --var5;
                           var36.field2796 = class36.field813[var5] == 1;
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1108) {
                           var36.field2801 = 1;
                           --var5;
                           var36.field2869 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1109) {
                           var5 -= 6;
                           var36.field2760 = class36.field813[var5];
                           var36.field2808 = class36.field813[1 + var5];
                           var36.field2800 = class36.field813[var5 + 2];
                           var36.field2810 = class36.field813[var5 + 3];
                           var36.field2811 = class36.field813[4 + var5];
                           var36.field2812 = class36.field813[5 + var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1110) {
                           --var5;
                           var37 = class36.field813[var5];
                           if(var37 != var36.field2805) {
                              var36.field2805 = var37;
                              var36.field2771 = 0;
                              var36.field2856 = 0;
                              class23.method657(var36);
                           }
                           continue;
                        }

                        if(var34 == 1111) {
                           --var5;
                           var36.field2815 = class36.field813[var5] == 1;
                           class23.method657(var36);
                           continue;
                        }

                        if(1112 == var34) {
                           --var6;
                           var38 = class36.field805[var6];
                           if(!var38.equals(var36.field2769)) {
                              var36.field2769 = var38;
                              class23.method657(var36);
                           }
                           continue;
                        }

                        if(var34 == 1113) {
                           --var5;
                           var36.field2817 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(1114 == var34) {
                           var5 -= 3;
                           var36.field2821 = class36.field813[var5];
                           var36.field2782 = class36.field813[var5 + 1];
                           var36.field2814 = class36.field813[var5 + 2];
                           class23.method657(var36);
                           continue;
                        }

                        if(1115 == var34) {
                           --var5;
                           var36.field2823 = class36.field813[var5] == 1;
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1116) {
                           --var5;
                           var36.field2820 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(1117 == var34) {
                           --var5;
                           var36.field2798 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(1118 == var34) {
                           --var5;
                           var36.field2748 = class36.field813[var5] == 1;
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1119) {
                           --var5;
                           var36.field2755 = class36.field813[var5] == 1;
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1120) {
                           var5 -= 2;
                           var36.field2853 = class36.field813[var5];
                           var36.field2765 = class36.field813[1 + var5];
                           class23.method657(var36);
                           if(var40 != -1 && 0 == var36.field2824) {
                              class14.method202(class173.field2886[var40 >> 16], var36, false);
                           }
                           continue;
                        }

                        if(1121 == var34) {
                           class219.method4073(var36.field2842, var36.field2759);
                           client.field526 = var36;
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1122) {
                           --var5;
                           var36.field2794 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(1123 == var34) {
                           --var5;
                           var36.field2784 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(var34 == 1124) {
                           --var5;
                           var36.field2833 = class36.field813[var5];
                           class23.method657(var36);
                           continue;
                        }

                        if(1125 == var34) {
                           --var5;
                           var37 = class36.field813[var5];
                           class82 var106 = (class82)class125.method2926(class45.method1050(), var37);
                           if(var106 != null) {
                              var36.field2845 = var106;
                              class23.method657(var36);
                           }
                           continue;
                        }
                     } else if((var34 < 1200 || var34 >= 1300) && (var34 < 2200 || var34 >= 2300)) {
                        if(var34 >= 1300 && var34 < 1400 || var34 >= 2300 && var34 < 2400) {
                           if(var34 >= 2000) {
                              var34 -= 1000;
                              --var5;
                              var36 = class20.method641(class36.field813[var5]);
                           } else {
                              var36 = var51?class13.field211:class4.field76;
                           }

                           if(var34 == 1300) {
                              --var5;
                              var40 = class36.field813[var5] - 1;
                              if(var40 >= 0 && var40 <= 9) {
                                 --var6;
                                 var36.method3498(var40, class36.field805[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(1301 == var34) {
                              var5 -= 2;
                              var40 = class36.field813[var5];
                              var37 = class36.field813[1 + var5];
                              var36.field2788 = class210.method4010(var40, var37);
                              continue;
                           }

                           if(1302 == var34) {
                              --var5;
                              var36.field2836 = class36.field813[var5] == 1;
                              continue;
                           }

                           if(var34 == 1303) {
                              --var5;
                              var36.field2756 = class36.field813[var5];
                              continue;
                           }

                           if(1304 == var34) {
                              --var5;
                              var36.field2835 = class36.field813[var5];
                              continue;
                           }

                           if(var34 == 1305) {
                              --var6;
                              var36.field2831 = class36.field805[var6];
                              continue;
                           }

                           if(1306 == var34) {
                              --var6;
                              var36.field2818 = class36.field805[var6];
                              continue;
                           }

                           if(1307 == var34) {
                              var36.field2832 = null;
                              continue;
                           }
                        } else {
                           int[] var43;
                           String var47;
                           if(var34 >= 1400 && var34 < 1500 || var34 >= 2400 && var34 < 2500) {
                              if(var34 >= 2000) {
                                 var34 -= 1000;
                                 --var5;
                                 var36 = class20.method641(class36.field813[var5]);
                              } else {
                                 var36 = var51?class13.field211:class4.field76;
                              }

                              --var6;
                              var47 = class36.field805[var6];
                              var43 = null;
                              if(var47.length() > 0 && var47.charAt(var47.length() - 1) == 89) {
                                 --var5;
                                 var42 = class36.field813[var5];
                                 if(var42 > 0) {
                                    for(var43 = new int[var42]; var42-- > 0; var43[var42] = class36.field813[var5]) {
                                       --var5;
                                    }
                                 }

                                 var47 = var47.substring(0, var47.length() - 1);
                              }

                              Object[] var99 = new Object[var47.length() + 1];

                              for(var19 = var99.length - 1; var19 >= 1; --var19) {
                                 if(var47.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var99[var19] = class36.field805[var6];
                                 } else {
                                    --var5;
                                    var99[var19] = new Integer(class36.field813[var5]);
                                 }
                              }

                              --var5;
                              var19 = class36.field813[var5];
                              if(-1 != var19) {
                                 var99[0] = new Integer(var19);
                              } else {
                                 var99 = null;
                              }

                              if(1400 == var34) {
                                 var36.field2840 = var99;
                              }

                              if(var34 == 1401) {
                                 var36.field2843 = var99;
                              }

                              if(var34 == 1402) {
                                 var36.field2749 = var99;
                              }

                              if(var34 == 1403) {
                                 var36.field2844 = var99;
                              }

                              if(1404 == var34) {
                                 var36.field2846 = var99;
                              }

                              if(var34 == 1405) {
                                 var36.field2847 = var99;
                              }

                              if(var34 == 1406) {
                                 var36.field2850 = var99;
                              }

                              if(1407 == var34) {
                                 var36.field2851 = var99;
                                 var36.field2852 = var43;
                              }

                              if(var34 == 1408) {
                                 var36.field2857 = var99;
                              }

                              if(1409 == var34) {
                                 var36.field2806 = var99;
                              }

                              if(1410 == var34) {
                                 var36.field2837 = var99;
                              }

                              if(var34 == 1411) {
                                 var36.field2799 = var99;
                              }

                              if(var34 == 1412) {
                                 var36.field2789 = var99;
                              }

                              if(var34 == 1414) {
                                 var36.field2767 = var99;
                                 var36.field2854 = var43;
                              }

                              if(1415 == var34) {
                                 var36.field2855 = var99;
                                 var36.field2882 = var43;
                              }

                              if(1416 == var34) {
                                 var36.field2864 = var99;
                              }

                              if(1417 == var34) {
                                 var36.field2859 = var99;
                              }

                              if(1418 == var34) {
                                 var36.field2860 = var99;
                              }

                              if(var34 == 1419) {
                                 var36.field2861 = var99;
                              }

                              if(var34 == 1420) {
                                 var36.field2862 = var99;
                              }

                              if(var34 == 1421) {
                                 var36.field2863 = var99;
                              }

                              if(1422 == var34) {
                                 var36.field2786 = var99;
                              }

                              if(var34 == 1423) {
                                 var36.field2865 = var99;
                              }

                              if(var34 == 1424) {
                                 var36.field2866 = var99;
                              }

                              if(var34 == 1425) {
                                 var36.field2868 = var99;
                              }

                              if(var34 == 1426) {
                                 var36.field2858 = var99;
                              }

                              if(1427 == var34) {
                                 var36.field2797 = var99;
                              }

                              var36.field2838 = true;
                              continue;
                           }

                           if(var34 < 1600) {
                              var36 = var51?class13.field211:class4.field76;
                              if(var34 == 1500) {
                                 class36.field813[var5++] = var36.field2848;
                                 continue;
                              }

                              if(1501 == var34) {
                                 class36.field813[var5++] = var36.field2772;
                                 continue;
                              }

                              if(1502 == var34) {
                                 class36.field813[var5++] = var36.field2773;
                                 continue;
                              }

                              if(1503 == var34) {
                                 class36.field813[var5++] = var36.field2774;
                                 continue;
                              }

                              if(1504 == var34) {
                                 class36.field813[var5++] = var36.field2778?1:0;
                                 continue;
                              }

                              if(var34 == 1505) {
                                 class36.field813[var5++] = var36.field2777;
                                 continue;
                              }
                           } else if(var34 < 1700) {
                              var36 = var51?class13.field211:class4.field76;
                              if(var34 == 1600) {
                                 class36.field813[var5++] = var36.field2879;
                                 continue;
                              }

                              if(var34 == 1601) {
                                 class36.field813[var5++] = var36.field2780;
                                 continue;
                              }

                              if(var34 == 1602) {
                                 class36.field805[var6++] = var36.field2769;
                                 continue;
                              }

                              if(1603 == var34) {
                                 class36.field813[var5++] = var36.field2853;
                                 continue;
                              }

                              if(1604 == var34) {
                                 class36.field813[var5++] = var36.field2765;
                                 continue;
                              }

                              if(var34 == 1605) {
                                 class36.field813[var5++] = var36.field2812;
                                 continue;
                              }

                              if(var34 == 1606) {
                                 class36.field813[var5++] = var36.field2800;
                                 continue;
                              }

                              if(1607 == var34) {
                                 class36.field813[var5++] = var36.field2811;
                                 continue;
                              }

                              if(var34 == 1608) {
                                 class36.field813[var5++] = var36.field2810;
                                 continue;
                              }

                              if(var34 == 1609) {
                                 class36.field813[var5++] = var36.field2807;
                                 continue;
                              }

                              if(1610 == var34) {
                                 class36.field813[var5++] = var36.field2833;
                                 continue;
                              }

                              if(1611 == var34) {
                                 class36.field813[var5++] = var36.field2783;
                                 continue;
                              }

                              if(var34 == 1612) {
                                 class36.field813[var5++] = var36.field2784;
                                 continue;
                              }

                              if(1613 == var34) {
                                 class36.field813[var5++] = var36.field2845.vmethod3266();
                                 continue;
                              }
                           } else if(var34 < 1800) {
                              var36 = var51?class13.field211:class4.field76;
                              if(1700 == var34) {
                                 class36.field813[var5++] = var36.field2878;
                                 continue;
                              }

                              if(var34 == 1701) {
                                 if(var36.field2878 != -1) {
                                    class36.field813[var5++] = var36.field2766;
                                 } else {
                                    class36.field813[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var34 == 1702) {
                                 class36.field813[var5++] = var36.field2759;
                                 continue;
                              }
                           } else if(var34 < 1900) {
                              var36 = var51?class13.field211:class4.field76;
                              if(1800 == var34) {
                                 class36.field813[var5++] = class98.method2283(class31.method776(var36));
                                 continue;
                              }

                              if(1801 == var34) {
                                 --var5;
                                 var40 = class36.field813[var5];
                                 --var40;
                                 if(null != var36.field2832 && var40 < var36.field2832.length && var36.field2832[var40] != null) {
                                    class36.field805[var6++] = var36.field2832[var40];
                                    continue;
                                 }

                                 class36.field805[var6++] = "";
                                 continue;
                              }

                              if(var34 == 1802) {
                                 if(null == var36.field2831) {
                                    class36.field805[var6++] = "";
                                 } else {
                                    class36.field805[var6++] = var36.field2831;
                                 }
                                 continue;
                              }
                           } else if(var34 >= 1900 && var34 < 2000 || var34 >= 2900 && var34 < 3000) {
                              if(var34 >= 2000) {
                                 var34 -= 1000;
                                 --var5;
                                 var36 = class20.method641(class36.field813[var5]);
                              } else {
                                 var36 = var51?class13.field211:class4.field76;
                              }

                              if(var34 == 1927) {
                                 if(class36.field812 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(var36.field2797 == null) {
                                    return;
                                 }

                                 class0 var104 = new class0();
                                 var104.field2 = var36;
                                 var104.field4 = var36.field2797;
                                 var104.field10 = class36.field812 + 1;
                                 client.field492.method3900(var0);
                                 continue;
                              }
                           } else if(var34 < 2600) {
                              --var5;
                              var36 = class20.method641(class36.field813[var5]);
                              if(2500 == var34) {
                                 class36.field813[var5++] = var36.field2848;
                                 continue;
                              }

                              if(var34 == 2501) {
                                 class36.field813[var5++] = var36.field2772;
                                 continue;
                              }

                              if(var34 == 2502) {
                                 class36.field813[var5++] = var36.field2773;
                                 continue;
                              }

                              if(var34 == 2503) {
                                 class36.field813[var5++] = var36.field2774;
                                 continue;
                              }

                              if(var34 == 2504) {
                                 class36.field813[var5++] = var36.field2778?1:0;
                                 continue;
                              }

                              if(2505 == var34) {
                                 class36.field813[var5++] = var36.field2777;
                                 continue;
                              }
                           } else if(var34 < 2700) {
                              --var5;
                              var36 = class20.method641(class36.field813[var5]);
                              if(var34 == 2600) {
                                 class36.field813[var5++] = var36.field2879;
                                 continue;
                              }

                              if(var34 == 2601) {
                                 class36.field813[var5++] = var36.field2780;
                                 continue;
                              }

                              if(2602 == var34) {
                                 class36.field805[var6++] = var36.field2769;
                                 continue;
                              }

                              if(var34 == 2603) {
                                 class36.field813[var5++] = var36.field2853;
                                 continue;
                              }

                              if(var34 == 2604) {
                                 class36.field813[var5++] = var36.field2765;
                                 continue;
                              }

                              if(2605 == var34) {
                                 class36.field813[var5++] = var36.field2812;
                                 continue;
                              }

                              if(2606 == var34) {
                                 class36.field813[var5++] = var36.field2800;
                                 continue;
                              }

                              if(var34 == 2607) {
                                 class36.field813[var5++] = var36.field2811;
                                 continue;
                              }

                              if(var34 == 2608) {
                                 class36.field813[var5++] = var36.field2810;
                                 continue;
                              }

                              if(var34 == 2609) {
                                 class36.field813[var5++] = var36.field2807;
                                 continue;
                              }

                              if(2610 == var34) {
                                 class36.field813[var5++] = var36.field2833;
                                 continue;
                              }

                              if(2611 == var34) {
                                 class36.field813[var5++] = var36.field2783;
                                 continue;
                              }

                              if(2612 == var34) {
                                 class36.field813[var5++] = var36.field2784;
                                 continue;
                              }

                              if(var34 == 2613) {
                                 class36.field813[var5++] = var36.field2845.vmethod3266();
                                 continue;
                              }
                           } else if(var34 < 2800) {
                              if(var34 == 2700) {
                                 --var5;
                                 var36 = class20.method641(class36.field813[var5]);
                                 class36.field813[var5++] = var36.field2878;
                                 continue;
                              }

                              if(var34 == 2701) {
                                 --var5;
                                 var36 = class20.method641(class36.field813[var5]);
                                 if(-1 != var36.field2878) {
                                    class36.field813[var5++] = var36.field2766;
                                 } else {
                                    class36.field813[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var34 == 2702) {
                                 --var5;
                                 var15 = class36.field813[var5];
                                 class3 var44 = (class3)client.field453.method3868((long)var15);
                                 if(var44 != null) {
                                    class36.field813[var5++] = 1;
                                 } else {
                                    class36.field813[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(2706 == var34) {
                                 class36.field813[var5++] = client.field452;
                                 continue;
                              }
                           } else if(var34 < 2900) {
                              --var5;
                              var36 = class20.method641(class36.field813[var5]);
                              if(var34 == 2800) {
                                 class36.field813[var5++] = class98.method2283(class31.method776(var36));
                                 continue;
                              }

                              if(var34 == 2801) {
                                 --var5;
                                 var40 = class36.field813[var5];
                                 --var40;
                                 if(null != var36.field2832 && var40 < var36.field2832.length && null != var36.field2832[var40]) {
                                    class36.field805[var6++] = var36.field2832[var40];
                                    continue;
                                 }

                                 class36.field805[var6++] = "";
                                 continue;
                              }

                              if(var34 == 2802) {
                                 if(null == var36.field2831) {
                                    class36.field805[var6++] = "";
                                 } else {
                                    class36.field805[var6++] = var36.field2831;
                                 }
                                 continue;
                              }
                           } else if(var34 < 3200) {
                              if(var34 == 3100) {
                                 --var6;
                                 var52 = class36.field805[var6];
                                 class129.method2943(0, "", var52);
                                 continue;
                              }

                              if(var34 == 3101) {
                                 var5 -= 2;
                                 class184.method3725(class5.field93, class36.field813[var5], class36.field813[var5 + 1]);
                                 continue;
                              }

                              if(3103 == var34) {
                                 class138.method3042();
                                 continue;
                              }

                              if(var34 == 3104) {
                                 --var6;
                                 var52 = class36.field805[var6];
                                 var40 = 0;
                                 if(class133.method2973(var52)) {
                                    var37 = class158.method3265(var52, 10, true);
                                    var40 = var37;
                                 }

                                 client.field338.method2873(98);
                                 client.field338.method2786(var40);
                                 continue;
                              }

                              if(var34 == 3105) {
                                 --var6;
                                 var52 = class36.field805[var6];
                                 client.field338.method2873(190);
                                 client.field338.method2603(var52.length() + 1);
                                 client.field338.method2694(var52);
                                 continue;
                              }

                              if(3106 == var34) {
                                 --var6;
                                 var52 = class36.field805[var6];
                                 client.field338.method2873(90);
                                 client.field338.method2603(var52.length() + 1);
                                 client.field338.method2694(var52);
                                 continue;
                              }

                              if(3107 == var34) {
                                 --var5;
                                 var15 = class36.field813[var5];
                                 --var6;
                                 var47 = class36.field805[var6];
                                 class2.method15(var15, var47);
                                 continue;
                              }

                              if(3108 == var34) {
                                 var5 -= 3;
                                 var15 = class36.field813[var5];
                                 var40 = class36.field813[1 + var5];
                                 var37 = class36.field813[var5 + 2];
                                 var41 = class20.method641(var37);
                                 class49.method1111(var41, var15, var40);
                                 continue;
                              }

                              if(var34 == 3109) {
                                 var5 -= 2;
                                 var15 = class36.field813[var5];
                                 var40 = class36.field813[1 + var5];
                                 var39 = var51?class13.field211:class4.field76;
                                 class49.method1111(var39, var15, var40);
                                 continue;
                              }

                              if(3110 == var34) {
                                 --var5;
                                 class7.field143 = class36.field813[var5] == 1;
                                 continue;
                              }

                              if(3111 == var34) {
                                 class36.field813[var5++] = class134.field2078.field147?1:0;
                                 continue;
                              }

                              if(var34 == 3112) {
                                 --var5;
                                 class134.field2078.field147 = class36.field813[var5] == 1;
                                 class213.method4031();
                                 continue;
                              }

                              if(3113 == var34) {
                                 --var6;
                                 var52 = class36.field805[var6];
                                 --var5;
                                 var50 = class36.field813[var5] == 1;
                                 class23.method670(var52, var50, "openjs", false);
                                 continue;
                              }

                              if(var34 == 3115) {
                                 --var5;
                                 var15 = class36.field813[var5];
                                 client.field338.method2873(205);
                                 client.field338.method2599(var15);
                                 continue;
                              }

                              if(3116 == var34) {
                                 --var5;
                                 var15 = class36.field813[var5];
                                 var6 -= 2;
                                 var47 = class36.field805[var6];
                                 var38 = class36.field805[var6 + 1];
                                 if(var47.length() <= 500 && var38.length() <= 500) {
                                    client.field338.method2873(58);
                                    client.field338.method2599(1 + class104.method2383(var47) + class104.method2383(var38));
                                    client.field338.method2694(var47);
                                    client.field338.method2638(var15);
                                    client.field338.method2694(var38);
                                 }
                                 continue;
                              }
                           } else if(var34 < 3300) {
                              if(3200 == var34) {
                                 var5 -= 3;
                                 class106.method2473(class36.field813[var5], class36.field813[1 + var5], class36.field813[2 + var5]);
                                 continue;
                              }

                              if(var34 == 3201) {
                                 --var5;
                                 var15 = class36.field813[var5];
                                 if(var15 == -1 && !client.field299) {
                                    class9.method163();
                                 } else if(-1 != var15 && var15 != client.field532 && 0 != client.field531 && !client.field299) {
                                    class176.method3536(2, class38.field884, var15, 0, client.field531, false);
                                 }

                                 client.field532 = var15;
                                 continue;
                              }

                              if(var34 == 3202) {
                                 var5 -= 2;
                                 var15 = class36.field813[var5];
                                 int var10000 = class36.field813[1 + var5];
                                 if(0 != client.field531 && -1 != var15) {
                                    class144.method3157(class36.field814, var15, 0, client.field531, false);
                                    client.field299 = true;
                                 }
                                 continue;
                              }
                           } else {
                              int var21;
                              int var22;
                              if(var34 < 3400) {
                                 if(3300 == var34) {
                                    class36.field813[var5++] = client.field306;
                                    continue;
                                 }

                                 if(3301 == var34) {
                                    var5 -= 2;
                                    var15 = class36.field813[var5];
                                    var40 = class36.field813[1 + var5];
                                    class36.field813[var5++] = class5.method57(var15, var40);
                                    continue;
                                 }

                                 if(3302 == var34) {
                                    var5 -= 2;
                                    var15 = class36.field813[var5];
                                    var40 = class36.field813[1 + var5];
                                    class36.field813[var5++] = class33.method799(var15, var40);
                                    continue;
                                 }

                                 class15 var20;
                                 if(3303 == var34) {
                                    var5 -= 2;
                                    var15 = class36.field813[var5];
                                    var40 = class36.field813[1 + var5];
                                    var43 = class36.field813;
                                    var42 = var5++;
                                    var20 = (class15)class15.field230.method3868((long)var15);
                                    if(var20 == null) {
                                       var19 = 0;
                                    } else if(var40 == -1) {
                                       var19 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var20.field234.length; ++var22) {
                                          if(var40 == var20.field229[var22]) {
                                             var21 += var20.field234[var22];
                                          }
                                       }

                                       var19 = var21;
                                    }

                                    var43[var42] = var19;
                                    continue;
                                 }

                                 if(3304 == var34) {
                                    --var5;
                                    var15 = class36.field813[var5];
                                    class36.field813[var5++] = class59.method1347(var15).field1111;
                                    continue;
                                 }

                                 if(var34 == 3305) {
                                    --var5;
                                    var15 = class36.field813[var5];
                                    class36.field813[var5++] = client.field429[var15];
                                    continue;
                                 }

                                 if(var34 == 3306) {
                                    --var5;
                                    var15 = class36.field813[var5];
                                    class36.field813[var5++] = client.field430[var15];
                                    continue;
                                 }

                                 if(var34 == 3307) {
                                    --var5;
                                    var15 = class36.field813[var5];
                                    class36.field813[var5++] = client.field479[var15];
                                    continue;
                                 }

                                 if(var34 == 3308) {
                                    var15 = class42.field1002;
                                    var40 = class144.field2204 + (class5.field93.field844 >> 7);
                                    var37 = class3.field67 + (class5.field93.field819 >> 7);
                                    class36.field813[var5++] = (var15 << 28) + (var40 << 14) + var37;
                                    continue;
                                 }

                                 if(var34 == 3309) {
                                    --var5;
                                    var15 = class36.field813[var5];
                                    class36.field813[var5++] = var15 >> 14 & 16383;
                                    continue;
                                 }

                                 if(var34 == 3310) {
                                    --var5;
                                    var15 = class36.field813[var5];
                                    class36.field813[var5++] = var15 >> 28;
                                    continue;
                                 }

                                 if(3311 == var34) {
                                    --var5;
                                    var15 = class36.field813[var5];
                                    class36.field813[var5++] = var15 & 16383;
                                    continue;
                                 }

                                 if(var34 == 3312) {
                                    class36.field813[var5++] = client.field301?1:0;
                                    continue;
                                 }

                                 if(var34 == 3313) {
                                    var5 -= 2;
                                    var15 = class36.field813[var5] + '耀';
                                    var40 = class36.field813[var5 + 1];
                                    class36.field813[var5++] = class5.method57(var15, var40);
                                    continue;
                                 }

                                 if(var34 == 3314) {
                                    var5 -= 2;
                                    var15 = '耀' + class36.field813[var5];
                                    var40 = class36.field813[var5 + 1];
                                    class36.field813[var5++] = class33.method799(var15, var40);
                                    continue;
                                 }

                                 if(3315 == var34) {
                                    var5 -= 2;
                                    var15 = '耀' + class36.field813[var5];
                                    var40 = class36.field813[var5 + 1];
                                    var43 = class36.field813;
                                    var42 = var5++;
                                    var20 = (class15)class15.field230.method3868((long)var15);
                                    if(var20 == null) {
                                       var19 = 0;
                                    } else if(-1 == var40) {
                                       var19 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var20.field234.length; ++var22) {
                                          if(var40 == var20.field229[var22]) {
                                             var21 += var20.field234[var22];
                                          }
                                       }

                                       var19 = var21;
                                    }

                                    var43[var42] = var19;
                                    continue;
                                 }

                                 if(3316 == var34) {
                                    if(client.field345 >= 2) {
                                       class36.field813[var5++] = client.field345;
                                    } else {
                                       class36.field813[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var34 == 3317) {
                                    class36.field813[var5++] = client.field313;
                                    continue;
                                 }

                                 if(3318 == var34) {
                                    class36.field813[var5++] = client.field296;
                                    continue;
                                 }

                                 if(var34 == 3321) {
                                    class36.field813[var5++] = client.field491;
                                    continue;
                                 }

                                 if(var34 == 3322) {
                                    class36.field813[var5++] = client.field458;
                                    continue;
                                 }

                                 if(3323 == var34) {
                                    if(client.field461) {
                                       class36.field813[var5++] = 1;
                                    } else {
                                       class36.field813[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var34 == 3324) {
                                    class36.field813[var5++] = client.field431;
                                    continue;
                                 }
                              } else if(var34 < 3500) {
                                 if(var34 == 3400) {
                                    var5 -= 2;
                                    var15 = class36.field813[var5];
                                    var40 = class36.field813[1 + var5];
                                    class48 var46 = class7.method138(var15);
                                    if(var46.field1082 != 115) {
                                       ;
                                    }

                                    for(var42 = 0; var42 < var46.field1085; ++var42) {
                                       if(var46.field1080[var42] == var40) {
                                          class36.field805[var6++] = var46.field1086[var42];
                                          var46 = null;
                                          break;
                                       }
                                    }

                                    if(var46 != null) {
                                       class36.field805[var6++] = var46.field1083;
                                    }
                                    continue;
                                 }

                                 if(var34 == 3408) {
                                    var5 -= 4;
                                    var15 = class36.field813[var5];
                                    var40 = class36.field813[var5 + 1];
                                    var37 = class36.field813[2 + var5];
                                    var42 = class36.field813[3 + var5];
                                    class48 var54 = class7.method138(var37);
                                    if(var15 == var54.field1081 && var54.field1082 == var40) {
                                       for(var49 = 0; var49 < var54.field1085; ++var49) {
                                          if(var42 == var54.field1080[var49]) {
                                             if(115 == var40) {
                                                class36.field805[var6++] = var54.field1086[var49];
                                             } else {
                                                class36.field813[var5++] = var54.field1087[var49];
                                             }

                                             var54 = null;
                                             break;
                                          }
                                       }

                                       if(null != var54) {
                                          if(var40 == 115) {
                                             class36.field805[var6++] = var54.field1083;
                                          } else {
                                             class36.field813[var5++] = var54.field1093;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var40 == 115) {
                                       class36.field805[var6++] = "null";
                                    } else {
                                       class36.field813[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var23;
                                 int var24;
                                 if(var34 < 3700) {
                                    if(3600 == var34) {
                                       if(client.field562 == 0) {
                                          class36.field813[var5++] = -2;
                                       } else if(client.field562 == 1) {
                                          class36.field813[var5++] = -1;
                                       } else {
                                          class36.field813[var5++] = client.field561;
                                       }
                                       continue;
                                    }

                                    if(3601 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       if(2 == client.field562 && var15 < client.field561) {
                                          class36.field805[var6++] = client.field563[var15].field261;
                                          class36.field805[var6++] = client.field563[var15].field262;
                                          continue;
                                       }

                                       class36.field805[var6++] = "";
                                       class36.field805[var6++] = "";
                                       continue;
                                    }

                                    if(var34 == 3602) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       if(2 == client.field562 && var15 < client.field561) {
                                          class36.field813[var5++] = client.field563[var15].field256;
                                          continue;
                                       }

                                       class36.field813[var5++] = 0;
                                       continue;
                                    }

                                    if(var34 == 3603) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       if(client.field562 == 2 && var15 < client.field561) {
                                          class36.field813[var5++] = client.field563[var15].field257;
                                          continue;
                                       }

                                       class36.field813[var5++] = 0;
                                       continue;
                                    }

                                    if(3604 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       --var5;
                                       var40 = class36.field813[var5];
                                       class38.method853(var52, var40);
                                       continue;
                                    }

                                    if(var34 == 3605) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class14.method200(var52);
                                       continue;
                                    }

                                    if(var34 == 3606) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class9.method159(var52);
                                       continue;
                                    }

                                    if(var34 == 3607) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class107.method2486(var52, false);
                                       continue;
                                    }

                                    if(var34 == 3608) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class103.method2374(var52);
                                       continue;
                                    }

                                    if(var34 == 3609) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class152[] var74 = new class152[]{class152.field2261, class152.field2268, class152.field2262, class152.field2263, class152.field2265};
                                       class152[] var53 = var74;

                                       for(var42 = 0; var42 < var53.length; ++var42) {
                                          class152 var58 = var53[var42];
                                          if(var58.field2260 != -1) {
                                             var22 = var58.field2260;
                                             var65 = "<img=" + var22 + ">";
                                             if(var52.startsWith(var65)) {
                                                var52 = var52.substring(6 + Integer.toString(var58.field2260).length());
                                                break;
                                             }
                                          }
                                       }

                                       class36.field813[var5++] = class41.method948(var52, false)?1:0;
                                       continue;
                                    }

                                    char var25;
                                    String var48;
                                    long var57;
                                    String[] var85;
                                    if(var34 == 3611) {
                                       if(null == client.field512) {
                                          class36.field805[var6++] = "";
                                          continue;
                                       }

                                       var85 = class36.field805;
                                       var40 = var6++;
                                       var48 = client.field512;
                                       var57 = 0L;
                                       var23 = var48.length();

                                       for(var24 = 0; var24 < var23; ++var24) {
                                          var57 *= 37L;
                                          var25 = var48.charAt(var24);
                                          if(var25 >= 65 && var25 <= 90) {
                                             var57 += (long)(1 + var25 - 65);
                                          } else if(var25 >= 97 && var25 <= 122) {
                                             var57 += (long)(1 + var25 - 97);
                                          } else if(var25 >= 48 && var25 <= 57) {
                                             var57 += (long)(var25 + 27 - 48);
                                          }

                                          if(var57 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(0L == var57 % 37L && var57 != 0L) {
                                          var57 /= 37L;
                                       }

                                       var65 = class187.method3824(var57);
                                       if(var65 == null) {
                                          var65 = "";
                                       }

                                       var85[var40] = var65;
                                       continue;
                                    }

                                    if(3612 == var34) {
                                       if(client.field512 != null) {
                                          class36.field813[var5++] = class139.field2143;
                                       } else {
                                          class36.field813[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var34 == 3613) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       if(null != client.field512 && var15 < class139.field2143) {
                                          class36.field805[var6++] = class59.field1226[var15].field637;
                                          continue;
                                       }

                                       class36.field805[var6++] = "";
                                       continue;
                                    }

                                    if(3614 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       if(client.field512 != null && var15 < class139.field2143) {
                                          class36.field813[var5++] = class59.field1226[var15].field633;
                                          continue;
                                       }

                                       class36.field813[var5++] = 0;
                                       continue;
                                    }

                                    if(3615 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       if(null != client.field512 && var15 < class139.field2143) {
                                          class36.field813[var5++] = class59.field1226[var15].field631;
                                          continue;
                                       }

                                       class36.field813[var5++] = 0;
                                       continue;
                                    }

                                    if(var34 == 3616) {
                                       class36.field813[var5++] = class172.field2744;
                                       continue;
                                    }

                                    if(var34 == 3617) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class6.method135(var52);
                                       continue;
                                    }

                                    if(3618 == var34) {
                                       class36.field813[var5++] = class6.field128;
                                       continue;
                                    }

                                    if(var34 == 3619) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class22.method656(var52);
                                       continue;
                                    }

                                    if(3620 == var34) {
                                       client.field338.method2873(83);
                                       client.field338.method2603(0);
                                       continue;
                                    }

                                    if(var34 == 3621) {
                                       if(client.field562 == 0) {
                                          class36.field813[var5++] = -1;
                                       } else {
                                          class36.field813[var5++] = client.field397;
                                       }
                                       continue;
                                    }

                                    if(var34 == 3622) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       if(client.field562 != 0 && var15 < client.field397) {
                                          class36.field805[var6++] = client.field395[var15].field140;
                                          class36.field805[var6++] = client.field395[var15].field137;
                                          continue;
                                       }

                                       class36.field805[var6++] = "";
                                       class36.field805[var6++] = "";
                                       continue;
                                    }

                                    if(3623 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       if(var52.startsWith(class124.method2912(0)) || var52.startsWith(class124.method2912(1))) {
                                          var52 = var52.substring(7);
                                       }

                                       class36.field813[var5++] = class33.method800(var52)?1:0;
                                       continue;
                                    }

                                    if(3624 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       if(class59.field1226 != null && var15 < class139.field2143 && class59.field1226[var15].field637.equalsIgnoreCase(class5.field93.field58)) {
                                          class36.field813[var5++] = 1;
                                          continue;
                                       }

                                       class36.field813[var5++] = 0;
                                       continue;
                                    }

                                    if(var34 == 3625) {
                                       if(null == client.field522) {
                                          class36.field805[var6++] = "";
                                          continue;
                                       }

                                       var85 = class36.field805;
                                       var40 = var6++;
                                       var48 = client.field522;
                                       var57 = 0L;
                                       var23 = var48.length();

                                       for(var24 = 0; var24 < var23; ++var24) {
                                          var57 *= 37L;
                                          var25 = var48.charAt(var24);
                                          if(var25 >= 65 && var25 <= 90) {
                                             var57 += (long)(1 + var25 - 65);
                                          } else if(var25 >= 97 && var25 <= 122) {
                                             var57 += (long)(1 + var25 - 97);
                                          } else if(var25 >= 48 && var25 <= 57) {
                                             var57 += (long)(27 + var25 - 48);
                                          }

                                          if(var57 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(var57 % 37L == 0L && 0L != var57) {
                                          var57 /= 37L;
                                       }

                                       var65 = class187.method3824(var57);
                                       if(var65 == null) {
                                          var65 = "";
                                       }

                                       var85[var40] = var65;
                                       continue;
                                    }
                                 } else if(var34 < 4000) {
                                    if(var34 == 3903) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = client.field570[var15].method4079();
                                       continue;
                                    }

                                    if(3904 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = client.field570[var15].field3170;
                                       continue;
                                    }

                                    if(var34 == 3905) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = client.field570[var15].field3171;
                                       continue;
                                    }

                                    if(var34 == 3906) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = client.field570[var15].field3172;
                                       continue;
                                    }

                                    if(3907 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = client.field570[var15].field3169;
                                       continue;
                                    }

                                    if(3908 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = client.field570[var15].field3174;
                                       continue;
                                    }

                                    if(var34 == 3910) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var40 = client.field570[var15].method4078();
                                       class36.field813[var5++] = 0 == var40?1:0;
                                       continue;
                                    }

                                    if(var34 == 3911) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var40 = client.field570[var15].method4078();
                                       class36.field813[var5++] = 2 == var40?1:0;
                                       continue;
                                    }

                                    if(3912 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var40 = client.field570[var15].method4078();
                                       class36.field813[var5++] = 5 == var40?1:0;
                                       continue;
                                    }

                                    if(var34 == 3913) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var40 = client.field570[var15].method4078();
                                       class36.field813[var5++] = var40 == 1?1:0;
                                       continue;
                                    }

                                    boolean var101;
                                    if(3914 == var34) {
                                       --var5;
                                       var101 = class36.field813[var5] == 1;
                                       if(class25.field656 != null) {
                                          class25.field656.method4099(class221.field3180, var101);
                                       }
                                       continue;
                                    }

                                    if(3915 == var34) {
                                       --var5;
                                       var101 = class36.field813[var5] == 1;
                                       if(null != class25.field656) {
                                          class25.field656.method4099(class221.field3178, var101);
                                       }
                                       continue;
                                    }

                                    if(3916 == var34) {
                                       var5 -= 2;
                                       var101 = 1 == class36.field813[var5];
                                       var50 = 1 == class36.field813[var5 + 1];
                                       if(class25.field656 != null) {
                                          class25.field656.method4099(new class21(var50), var101);
                                       }
                                       continue;
                                    }

                                    if(var34 == 3917) {
                                       --var5;
                                       var101 = class36.field813[var5] == 1;
                                       if(null != class25.field656) {
                                          class25.field656.method4099(class221.field3177, var101);
                                       }
                                       continue;
                                    }

                                    if(3918 == var34) {
                                       --var5;
                                       var101 = class36.field813[var5] == 1;
                                       if(class25.field656 != null) {
                                          class25.field656.method4099(class221.field3179, var101);
                                       }
                                       continue;
                                    }

                                    if(3919 == var34) {
                                       class36.field813[var5++] = class25.field656 == null?0:class25.field656.field3176.size();
                                       continue;
                                    }

                                    class214 var78;
                                    if(var34 == 3920) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var78 = (class214)class25.field656.field3176.get(var15);
                                       class36.field813[var5++] = var78.field3155;
                                       continue;
                                    }

                                    if(3921 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var78 = (class214)class25.field656.field3176.get(var15);
                                       class36.field805[var6++] = var78.method4033();
                                       continue;
                                    }

                                    if(var34 == 3922) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var78 = (class214)class25.field656.field3176.get(var15);
                                       class36.field805[var6++] = var78.method4034();
                                       continue;
                                    }

                                    if(3923 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var78 = (class214)class25.field656.field3176.get(var15);
                                       long var56 = class127.method2941() - class30.field718 - var78.field3151;
                                       var19 = (int)(var56 / 3600000L);
                                       var49 = (int)((var56 - (long)(3600000 * var19)) / 60000L);
                                       var21 = (int)((var56 - (long)(3600000 * var19) - (long)('\uea60' * var49)) / 1000L);
                                       String var60 = var19 + ":" + var49 / 10 + var49 % 10 + ":" + var21 / 10 + var21 % 10;
                                       class36.field805[var6++] = var60;
                                       continue;
                                    }

                                    if(var34 == 3924) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var78 = (class214)class25.field656.field3176.get(var15);
                                       class36.field813[var5++] = var78.field3153.field3172;
                                       continue;
                                    }

                                    if(var34 == 3925) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var78 = (class214)class25.field656.field3176.get(var15);
                                       class36.field813[var5++] = var78.field3153.field3171;
                                       continue;
                                    }

                                    if(var34 == 3926) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var78 = (class214)class25.field656.field3176.get(var15);
                                       class36.field813[var5++] = var78.field3153.field3170;
                                       continue;
                                    }
                                 } else if(var34 < 4100) {
                                    if(var34 == 4000) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       class36.field813[var5++] = var15 + var40;
                                       continue;
                                    }

                                    if(var34 == 4001) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       class36.field813[var5++] = var15 - var40;
                                       continue;
                                    }

                                    if(var34 == 4002) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       class36.field813[var5++] = var15 * var40;
                                       continue;
                                    }

                                    if(var34 == 4003) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[1 + var5];
                                       class36.field813[var5++] = var15 / var40;
                                       continue;
                                    }

                                    if(4004 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = (int)(Math.random() * (double)var15);
                                       continue;
                                    }

                                    if(4005 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = (int)(Math.random() * (double)(var15 + 1));
                                       continue;
                                    }

                                    if(var34 == 4006) {
                                       var5 -= 5;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[1 + var5];
                                       var37 = class36.field813[2 + var5];
                                       var42 = class36.field813[var5 + 3];
                                       var19 = class36.field813[var5 + 4];
                                       class36.field813[var5++] = var15 + (var40 - var15) * (var19 - var37) / (var42 - var37);
                                       continue;
                                    }

                                    if(var34 == 4007) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[1 + var5];
                                       class36.field813[var5++] = var40 * var15 / 100 + var15;
                                       continue;
                                    }

                                    if(4008 == var34) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       class36.field813[var5++] = var15 | 1 << var40;
                                       continue;
                                    }

                                    if(var34 == 4009) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[1 + var5];
                                       class36.field813[var5++] = var15 & -1 - (1 << var40);
                                       continue;
                                    }

                                    if(var34 == 4010) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       class36.field813[var5++] = 0 != (var15 & 1 << var40)?1:0;
                                       continue;
                                    }

                                    if(4011 == var34) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       class36.field813[var5++] = var15 % var40;
                                       continue;
                                    }

                                    if(var34 == 4012) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       if(var15 == 0) {
                                          class36.field813[var5++] = 0;
                                       } else {
                                          class36.field813[var5++] = (int)Math.pow((double)var15, (double)var40);
                                       }
                                       continue;
                                    }

                                    if(4013 == var34) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[1 + var5];
                                       if(0 == var15) {
                                          class36.field813[var5++] = 0;
                                       } else if(var40 == 0) {
                                          class36.field813[var5++] = Integer.MAX_VALUE;
                                       } else {
                                          class36.field813[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var40);
                                       }
                                       continue;
                                    }

                                    if(4014 == var34) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[1 + var5];
                                       class36.field813[var5++] = var15 & var40;
                                       continue;
                                    }

                                    if(var34 == 4015) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       class36.field813[var5++] = var15 | var40;
                                       continue;
                                    }
                                 } else if(var34 < 4200) {
                                    if(4100 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       --var5;
                                       var40 = class36.field813[var5];
                                       class36.field805[var6++] = var52 + var40;
                                       continue;
                                    }

                                    if(var34 == 4101) {
                                       var6 -= 2;
                                       var52 = class36.field805[var6];
                                       var47 = class36.field805[var6 + 1];
                                       class36.field805[var6++] = var52 + var47;
                                       continue;
                                    }

                                    if(var34 == 4102) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       --var5;
                                       var40 = class36.field813[var5];
                                       class36.field805[var6++] = var52 + class20.method640(var40, true);
                                       continue;
                                    }

                                    if(4103 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class36.field805[var6++] = var52.toLowerCase();
                                       continue;
                                    }

                                    if(var34 == 4104) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       long var100 = ((long)var15 + 11745L) * 86400000L;
                                       class36.field810.setTime(new Date(var100));
                                       var42 = class36.field810.get(5);
                                       var19 = class36.field810.get(2);
                                       var49 = class36.field810.get(1);
                                       class36.field805[var6++] = var42 + "-" + class36.field811[var19] + "-" + var49;
                                       continue;
                                    }

                                    if(4105 == var34) {
                                       var6 -= 2;
                                       var52 = class36.field805[var6];
                                       var47 = class36.field805[var6 + 1];
                                       if(null != class5.field93.field33 && class5.field93.field33.field2924) {
                                          class36.field805[var6++] = var47;
                                          continue;
                                       }

                                       class36.field805[var6++] = var52;
                                       continue;
                                    }

                                    if(var34 == 4106) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field805[var6++] = Integer.toString(var15);
                                       continue;
                                    }

                                    if(4107 == var34) {
                                       var6 -= 2;
                                       int[] var109 = class36.field813;
                                       var40 = var5++;
                                       String var66 = class36.field805[var6];
                                       var55 = class36.field805[1 + var6];
                                       var21 = client.field372;
                                       var22 = var66.length();
                                       var23 = var55.length();
                                       var24 = 0;
                                       int var68 = 0;
                                       byte var26 = 0;
                                       byte var27 = 0;

                                       label3666:
                                       while(true) {
                                          if(var24 - var26 >= var22 && var68 - var27 >= var23) {
                                             int var82 = Math.min(var22, var23);

                                             int var88;
                                             char var95;
                                             for(var88 = 0; var88 < var82; ++var88) {
                                                char var92 = var66.charAt(var88);
                                                var95 = var55.charAt(var88);
                                                if(var92 != var95 && Character.toUpperCase(var92) != Character.toUpperCase(var95)) {
                                                   var92 = Character.toLowerCase(var92);
                                                   var95 = Character.toLowerCase(var95);
                                                   if(var92 != var95) {
                                                      var42 = class94.method2252(var92, var21) - class94.method2252(var95, var21);
                                                      break label3666;
                                                   }
                                                }
                                             }

                                             var88 = var22 - var23;
                                             if(var88 != 0) {
                                                var42 = var88;
                                             } else {
                                                for(int var93 = 0; var93 < var82; ++var93) {
                                                   var95 = var66.charAt(var93);
                                                   char var32 = var55.charAt(var93);
                                                   if(var32 != var95) {
                                                      var42 = class94.method2252(var95, var21) - class94.method2252(var32, var21);
                                                      break label3666;
                                                   }
                                                }

                                                var42 = 0;
                                             }
                                             break;
                                          }

                                          if(var24 - var26 >= var22) {
                                             var42 = -1;
                                             break;
                                          }

                                          if(var68 - var27 >= var23) {
                                             var42 = 1;
                                             break;
                                          }

                                          char var28;
                                          if(0 != var26) {
                                             var28 = (char)var26;
                                             boolean var72 = false;
                                          } else {
                                             var28 = var66.charAt(var24++);
                                          }

                                          char var29;
                                          if(var27 != 0) {
                                             var29 = (char)var27;
                                             boolean var77 = false;
                                          } else {
                                             var29 = var55.charAt(var68++);
                                          }

                                          byte var30;
                                          if(198 == var28) {
                                             var30 = 69;
                                          } else if(230 == var28) {
                                             var30 = 101;
                                          } else if(var28 == 223) {
                                             var30 = 115;
                                          } else if(338 == var28) {
                                             var30 = 69;
                                          } else if(var28 == 339) {
                                             var30 = 101;
                                          } else {
                                             var30 = 0;
                                          }

                                          var26 = var30;
                                          byte var31;
                                          if(var29 == 198) {
                                             var31 = 69;
                                          } else if(230 == var29) {
                                             var31 = 101;
                                          } else if(223 == var29) {
                                             var31 = 115;
                                          } else if(338 == var29) {
                                             var31 = 69;
                                          } else if(var29 == 339) {
                                             var31 = 101;
                                          } else {
                                             var31 = 0;
                                          }

                                          var27 = var31;
                                          var28 = class3.method50(var28, var21);
                                          var29 = class3.method50(var29, var21);
                                          if(var29 != var28 && Character.toUpperCase(var28) != Character.toUpperCase(var29)) {
                                             var28 = Character.toLowerCase(var28);
                                             var29 = Character.toLowerCase(var29);
                                             if(var29 != var28) {
                                                var42 = class94.method2252(var28, var21) - class94.method2252(var29, var21);
                                                break;
                                             }
                                          }
                                       }

                                       if(var42 > 0) {
                                          var67 = 1;
                                       } else if(var42 < 0) {
                                          var67 = -1;
                                       } else {
                                          var67 = 0;
                                       }

                                       var109[var40] = var67;
                                       continue;
                                    }

                                    byte[] var63;
                                    class224 var64;
                                    if(4108 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       var5 -= 2;
                                       var40 = class36.field813[var5];
                                       var37 = class36.field813[1 + var5];
                                       var63 = class14.field219.method3403(var37, 0);
                                       var64 = new class224(var63);
                                       class36.field813[var5++] = var64.method4114(var52, var40);
                                       continue;
                                    }

                                    if(4109 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       var5 -= 2;
                                       var40 = class36.field813[var5];
                                       var37 = class36.field813[var5 + 1];
                                       var63 = class14.field219.method3403(var37, 0);
                                       var64 = new class224(var63);
                                       class36.field813[var5++] = var64.method4113(var52, var40);
                                       continue;
                                    }

                                    if(4110 == var34) {
                                       var6 -= 2;
                                       var52 = class36.field805[var6];
                                       var47 = class36.field805[var6 + 1];
                                       --var5;
                                       if(class36.field813[var5] == 1) {
                                          class36.field805[var6++] = var52;
                                       } else {
                                          class36.field805[var6++] = var47;
                                       }
                                       continue;
                                    }

                                    if(4111 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class36.field805[var6++] = class223.method4115(var52);
                                       continue;
                                    }

                                    if(var34 == 4112) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       --var5;
                                       var40 = class36.field813[var5];
                                       class36.field805[var6++] = var52 + (char)var40;
                                       continue;
                                    }

                                    char var61;
                                    if(var34 == 4113) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var98 = class36.field813;
                                       var37 = var5++;
                                       var61 = (char)var15;
                                       if(var61 >= 32 && var61 <= 126) {
                                          var59 = true;
                                       } else if(var61 >= 160 && var61 <= 255) {
                                          var59 = true;
                                       } else if(8364 != var61 && var61 != 338 && 8212 != var61 && 339 != var61 && 376 != var61) {
                                          var59 = false;
                                       } else {
                                          var59 = true;
                                       }

                                       var98[var37] = var59?1:0;
                                       continue;
                                    }

                                    if(4114 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = class122.method2864((char)var15)?1:0;
                                       continue;
                                    }

                                    if(4115 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = class129.method2946((char)var15)?1:0;
                                       continue;
                                    }

                                    if(4116 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var98 = class36.field813;
                                       var37 = var5++;
                                       var61 = (char)var15;
                                       var59 = var61 >= 48 && var61 <= 57;
                                       var98[var37] = var59?1:0;
                                       continue;
                                    }

                                    if(4117 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       if(null != var52) {
                                          class36.field813[var5++] = var52.length();
                                       } else {
                                          class36.field813[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(4118 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       var5 -= 2;
                                       var40 = class36.field813[var5];
                                       var37 = class36.field813[1 + var5];
                                       class36.field805[var6++] = var52.substring(var40, var37);
                                       continue;
                                    }

                                    if(4119 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       StringBuilder var97 = new StringBuilder(var52.length());
                                       var17 = false;

                                       for(var42 = 0; var42 < var52.length(); ++var42) {
                                          var61 = var52.charAt(var42);
                                          if(var61 == 60) {
                                             var17 = true;
                                          } else if(var61 == 62) {
                                             var17 = false;
                                          } else if(!var17) {
                                             var97.append(var61);
                                          }
                                       }

                                       class36.field805[var6++] = var97.toString();
                                       continue;
                                    }

                                    if(4120 == var34) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       --var5;
                                       var40 = class36.field813[var5];
                                       class36.field813[var5++] = var52.indexOf(var40);
                                       continue;
                                    }

                                    if(4121 == var34) {
                                       var6 -= 2;
                                       var52 = class36.field805[var6];
                                       var47 = class36.field805[var6 + 1];
                                       --var5;
                                       var37 = class36.field813[var5];
                                       class36.field813[var5++] = var52.indexOf(var47, var37);
                                       continue;
                                    }
                                 } else if(var34 < 4300) {
                                    if(4200 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field805[var6++] = class11.method178(var15).field1125;
                                       continue;
                                    }

                                    class51 var73;
                                    if(var34 == 4201) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       var73 = class11.method178(var15);
                                       if(var40 >= 1 && var40 <= 5 && null != var73.field1139[var40 - 1]) {
                                          class36.field805[var6++] = var73.field1139[var40 - 1];
                                          continue;
                                       }

                                       class36.field805[var6++] = "";
                                       continue;
                                    }

                                    if(var34 == 4202) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[var5 + 1];
                                       var73 = class11.method178(var15);
                                       if(var40 >= 1 && var40 <= 5 && null != var73.field1140[var40 - 1]) {
                                          class36.field805[var6++] = var73.field1140[var40 - 1];
                                          continue;
                                       }

                                       class36.field805[var6++] = "";
                                       continue;
                                    }

                                    if(4203 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = class11.method178(var15).field1150;
                                       continue;
                                    }

                                    if(var34 == 4204) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = class11.method178(var15).field1136 == 1?1:0;
                                       continue;
                                    }

                                    class51 var102;
                                    if(4205 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var102 = class11.method178(var15);
                                       if(var102.field1156 == -1 && var102.field1155 >= 0) {
                                          class36.field813[var5++] = var102.field1155;
                                          continue;
                                       }

                                       class36.field813[var5++] = var15;
                                       continue;
                                    }

                                    if(var34 == 4206) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var102 = class11.method178(var15);
                                       if(var102.field1156 >= 0 && var102.field1155 >= 0) {
                                          class36.field813[var5++] = var102.field1155;
                                          continue;
                                       }

                                       class36.field813[var5++] = var15;
                                       continue;
                                    }

                                    if(var34 == 4207) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = class11.method178(var15).field1138?1:0;
                                       continue;
                                    }

                                    if(var34 == 4208) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var102 = class11.method178(var15);
                                       if(var102.field1144 == -1 && var102.field1119 >= 0) {
                                          class36.field813[var5++] = var102.field1119;
                                          continue;
                                       }

                                       class36.field813[var5++] = var15;
                                       continue;
                                    }

                                    if(4209 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var102 = class11.method178(var15);
                                       if(var102.field1144 >= 0 && var102.field1119 >= 0) {
                                          class36.field813[var5++] = var102.field1119;
                                          continue;
                                       }

                                       class36.field813[var5++] = var15;
                                       continue;
                                    }

                                    if(var34 == 4210) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       --var5;
                                       var40 = class36.field813[var5];
                                       class29.method745(var52, 1 == var40);
                                       class36.field813[var5++] = class13.field210;
                                       continue;
                                    }

                                    if(var34 == 4211) {
                                       if(class30.field716 != null && class43.field1034 < class13.field210) {
                                          class36.field813[var5++] = class30.field716[++class43.field1034 - 1] & '\uffff';
                                          continue;
                                       }

                                       class36.field813[var5++] = -1;
                                       continue;
                                    }

                                    if(4212 == var34) {
                                       class43.field1034 = 0;
                                       continue;
                                    }
                                 } else if(var34 < 5100) {
                                    if(var34 == 5000) {
                                       class36.field813[var5++] = client.field511;
                                       continue;
                                    }

                                    if(var34 == 5001) {
                                       var5 -= 3;
                                       client.field511 = class36.field813[var5];
                                       var40 = class36.field813[1 + var5];
                                       class130[] var81 = class99.method2285();
                                       var42 = 0;

                                       class130 var110;
                                       while(true) {
                                          if(var42 >= var81.length) {
                                             var110 = null;
                                             break;
                                          }

                                          class130 var87 = var81[var42];
                                          if(var40 == var87.field2062) {
                                             var110 = var87;
                                             break;
                                          }

                                          ++var42;
                                       }

                                       class11.field189 = var110;
                                       if(class11.field189 == null) {
                                          class11.field189 = class130.field2058;
                                       }

                                       client.field445 = class36.field813[2 + var5];
                                       client.field338.method2873(19);
                                       client.field338.method2603(client.field511);
                                       client.field338.method2603(class11.field189.field2062);
                                       client.field338.method2603(client.field445);
                                       continue;
                                    }

                                    if(var34 == 5002) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       var5 -= 2;
                                       var40 = class36.field813[var5];
                                       var37 = class36.field813[var5 + 1];
                                       client.field338.method2873(131);
                                       client.field338.method2603(class104.method2383(var52) + 2);
                                       client.field338.method2694(var52);
                                       client.field338.method2603(var40 - 1);
                                       client.field338.method2603(var37);
                                       continue;
                                    }

                                    if(5003 == var34) {
                                       var5 -= 2;
                                       var15 = class36.field813[var5];
                                       var40 = class36.field813[1 + var5];
                                       class35 var80 = client.method629(var15, var40);
                                       if(null != var80) {
                                          class36.field813[var5++] = var80.field797;
                                          class36.field813[var5++] = var80.field789;
                                          class36.field805[var6++] = var80.field792 != null?var80.field792:"";
                                          class36.field805[var6++] = null != var80.field791?var80.field791:"";
                                          class36.field805[var6++] = var80.field795 != null?var80.field795:"";
                                       } else {
                                          class36.field813[var5++] = -1;
                                          class36.field813[var5++] = 0;
                                          class36.field805[var6++] = "";
                                          class36.field805[var6++] = "";
                                          class36.field805[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(5004 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class35 var103 = (class35)class11.field181.method3889((long)var15);
                                       if(var103 != null) {
                                          class36.field813[var5++] = var103.field790;
                                          class36.field813[var5++] = var103.field789;
                                          class36.field805[var6++] = null != var103.field792?var103.field792:"";
                                          class36.field805[var6++] = null != var103.field791?var103.field791:"";
                                          class36.field805[var6++] = null != var103.field795?var103.field795:"";
                                       } else {
                                          class36.field813[var5++] = -1;
                                          class36.field813[var5++] = 0;
                                          class36.field805[var6++] = "";
                                          class36.field805[var6++] = "";
                                          class36.field805[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(5005 == var34) {
                                       if(class11.field189 == null) {
                                          class36.field813[var5++] = -1;
                                       } else {
                                          class36.field813[var5++] = class11.field189.field2062;
                                       }
                                       continue;
                                    }

                                    if(var34 == 5008) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       --var5;
                                       var40 = class36.field813[var5];
                                       var38 = var52.toLowerCase();
                                       byte var84 = 0;
                                       if(var38.startsWith("yellow:")) {
                                          var84 = 0;
                                          var52 = var52.substring("yellow:".length());
                                       } else if(var38.startsWith("red:")) {
                                          var84 = 1;
                                          var52 = var52.substring("red:".length());
                                       } else if(var38.startsWith("green:")) {
                                          var84 = 2;
                                          var52 = var52.substring("green:".length());
                                       } else if(var38.startsWith("cyan:")) {
                                          var84 = 3;
                                          var52 = var52.substring("cyan:".length());
                                       } else if(var38.startsWith("purple:")) {
                                          var84 = 4;
                                          var52 = var52.substring("purple:".length());
                                       } else if(var38.startsWith("white:")) {
                                          var84 = 5;
                                          var52 = var52.substring("white:".length());
                                       } else if(var38.startsWith("flash1:")) {
                                          var84 = 6;
                                          var52 = var52.substring("flash1:".length());
                                       } else if(var38.startsWith("flash2:")) {
                                          var84 = 7;
                                          var52 = var52.substring("flash2:".length());
                                       } else if(var38.startsWith("flash3:")) {
                                          var84 = 8;
                                          var52 = var52.substring("flash3:".length());
                                       } else if(var38.startsWith("glow1:")) {
                                          var84 = 9;
                                          var52 = var52.substring("glow1:".length());
                                       } else if(var38.startsWith("glow2:")) {
                                          var84 = 10;
                                          var52 = var52.substring("glow2:".length());
                                       } else if(var38.startsWith("glow3:")) {
                                          var84 = 11;
                                          var52 = var52.substring("glow3:".length());
                                       } else if(0 != client.field372) {
                                          if(var38.startsWith("yellow:")) {
                                             var84 = 0;
                                             var52 = var52.substring("yellow:".length());
                                          } else if(var38.startsWith("red:")) {
                                             var84 = 1;
                                             var52 = var52.substring("red:".length());
                                          } else if(var38.startsWith("green:")) {
                                             var84 = 2;
                                             var52 = var52.substring("green:".length());
                                          } else if(var38.startsWith("cyan:")) {
                                             var84 = 3;
                                             var52 = var52.substring("cyan:".length());
                                          } else if(var38.startsWith("purple:")) {
                                             var84 = 4;
                                             var52 = var52.substring("purple:".length());
                                          } else if(var38.startsWith("white:")) {
                                             var84 = 5;
                                             var52 = var52.substring("white:".length());
                                          } else if(var38.startsWith("flash1:")) {
                                             var84 = 6;
                                             var52 = var52.substring("flash1:".length());
                                          } else if(var38.startsWith("flash2:")) {
                                             var84 = 7;
                                             var52 = var52.substring("flash2:".length());
                                          } else if(var38.startsWith("flash3:")) {
                                             var84 = 8;
                                             var52 = var52.substring("flash3:".length());
                                          } else if(var38.startsWith("glow1:")) {
                                             var84 = 9;
                                             var52 = var52.substring("glow1:".length());
                                          } else if(var38.startsWith("glow2:")) {
                                             var84 = 10;
                                             var52 = var52.substring("glow2:".length());
                                          } else if(var38.startsWith("glow3:")) {
                                             var84 = 11;
                                             var52 = var52.substring("glow3:".length());
                                          }
                                       }

                                       var38 = var52.toLowerCase();
                                       byte var75 = 0;
                                       if(var38.startsWith("wave:")) {
                                          var75 = 1;
                                          var52 = var52.substring("wave:".length());
                                       } else if(var38.startsWith("wave2:")) {
                                          var75 = 2;
                                          var52 = var52.substring("wave2:".length());
                                       } else if(var38.startsWith("shake:")) {
                                          var75 = 3;
                                          var52 = var52.substring("shake:".length());
                                       } else if(var38.startsWith("scroll:")) {
                                          var75 = 4;
                                          var52 = var52.substring("scroll:".length());
                                       } else if(var38.startsWith("slide:")) {
                                          var75 = 5;
                                          var52 = var52.substring("slide:".length());
                                       } else if(0 != client.field372) {
                                          if(var38.startsWith("wave:")) {
                                             var75 = 1;
                                             var52 = var52.substring("wave:".length());
                                          } else if(var38.startsWith("wave2:")) {
                                             var75 = 2;
                                             var52 = var52.substring("wave2:".length());
                                          } else if(var38.startsWith("shake:")) {
                                             var75 = 3;
                                             var52 = var52.substring("shake:".length());
                                          } else if(var38.startsWith("scroll:")) {
                                             var75 = 4;
                                             var52 = var52.substring("scroll:".length());
                                          } else if(var38.startsWith("slide:")) {
                                             var75 = 5;
                                             var52 = var52.substring("slide:".length());
                                          }
                                       }

                                       client.field338.method2873(139);
                                       client.field338.method2603(0);
                                       var49 = client.field338.field1992;
                                       client.field338.method2603(var40);
                                       client.field338.method2603(var84);
                                       client.field338.method2603(var75);
                                       class122 var89 = client.field338;
                                       var22 = var89.field1992;
                                       var24 = var52.length();
                                       byte[] var71 = new byte[var24];

                                       for(int var76 = 0; var76 < var24; ++var76) {
                                          char var79 = var52.charAt(var76);
                                          if((var79 <= 0 || var79 >= 128) && (var79 < 160 || var79 > 255)) {
                                             if(var79 == 8364) {
                                                var71[var76] = -128;
                                             } else if(var79 == 8218) {
                                                var71[var76] = -126;
                                             } else if(402 == var79) {
                                                var71[var76] = -125;
                                             } else if(var79 == 8222) {
                                                var71[var76] = -124;
                                             } else if(8230 == var79) {
                                                var71[var76] = -123;
                                             } else if(8224 == var79) {
                                                var71[var76] = -122;
                                             } else if(var79 == 8225) {
                                                var71[var76] = -121;
                                             } else if(var79 == 710) {
                                                var71[var76] = -120;
                                             } else if(var79 == 8240) {
                                                var71[var76] = -119;
                                             } else if(352 == var79) {
                                                var71[var76] = -118;
                                             } else if(var79 == 8249) {
                                                var71[var76] = -117;
                                             } else if(var79 == 338) {
                                                var71[var76] = -116;
                                             } else if(381 == var79) {
                                                var71[var76] = -114;
                                             } else if(8216 == var79) {
                                                var71[var76] = -111;
                                             } else if(8217 == var79) {
                                                var71[var76] = -110;
                                             } else if(var79 == 8220) {
                                                var71[var76] = -109;
                                             } else if(var79 == 8221) {
                                                var71[var76] = -108;
                                             } else if(8226 == var79) {
                                                var71[var76] = -107;
                                             } else if(var79 == 8211) {
                                                var71[var76] = -106;
                                             } else if(8212 == var79) {
                                                var71[var76] = -105;
                                             } else if(732 == var79) {
                                                var71[var76] = -104;
                                             } else if(var79 == 8482) {
                                                var71[var76] = -103;
                                             } else if(var79 == 353) {
                                                var71[var76] = -102;
                                             } else if(var79 == 8250) {
                                                var71[var76] = -101;
                                             } else if(339 == var79) {
                                                var71[var76] = -100;
                                             } else if(382 == var79) {
                                                var71[var76] = -98;
                                             } else if(var79 == 376) {
                                                var71[var76] = -97;
                                             } else {
                                                var71[var76] = 63;
                                             }
                                          } else {
                                             var71[var76] = (byte)var79;
                                          }
                                       }

                                       var89.method2717(var71.length);
                                       var89.field1992 += class129.field2055.method2535(var71, 0, var71.length, var89.field1993, var89.field1992);
                                       client.field338.method2610(client.field338.field1992 - var49);
                                       continue;
                                    }

                                    if(var34 == 5009) {
                                       var6 -= 2;
                                       var52 = class36.field805[var6];
                                       var47 = class36.field805[var6 + 1];
                                       client.field338.method2873(137);
                                       client.field338.method2599(0);
                                       var37 = client.field338.field1992;
                                       client.field338.method2694(var52);
                                       class122 var83 = client.field338;
                                       var19 = var83.field1992;
                                       var21 = var47.length();
                                       byte[] var62 = new byte[var21];

                                       for(var23 = 0; var23 < var21; ++var23) {
                                          char var69 = var47.charAt(var23);
                                          if(var69 > 0 && var69 < 128 || var69 >= 160 && var69 <= 255) {
                                             var62[var23] = (byte)var69;
                                          } else if(var69 == 8364) {
                                             var62[var23] = -128;
                                          } else if(var69 == 8218) {
                                             var62[var23] = -126;
                                          } else if(402 == var69) {
                                             var62[var23] = -125;
                                          } else if(var69 == 8222) {
                                             var62[var23] = -124;
                                          } else if(8230 == var69) {
                                             var62[var23] = -123;
                                          } else if(var69 == 8224) {
                                             var62[var23] = -122;
                                          } else if(var69 == 8225) {
                                             var62[var23] = -121;
                                          } else if(var69 == 710) {
                                             var62[var23] = -120;
                                          } else if(8240 == var69) {
                                             var62[var23] = -119;
                                          } else if(var69 == 352) {
                                             var62[var23] = -118;
                                          } else if(var69 == 8249) {
                                             var62[var23] = -117;
                                          } else if(338 == var69) {
                                             var62[var23] = -116;
                                          } else if(381 == var69) {
                                             var62[var23] = -114;
                                          } else if(8216 == var69) {
                                             var62[var23] = -111;
                                          } else if(8217 == var69) {
                                             var62[var23] = -110;
                                          } else if(8220 == var69) {
                                             var62[var23] = -109;
                                          } else if(var69 == 8221) {
                                             var62[var23] = -108;
                                          } else if(var69 == 8226) {
                                             var62[var23] = -107;
                                          } else if(var69 == 8211) {
                                             var62[var23] = -106;
                                          } else if(var69 == 8212) {
                                             var62[var23] = -105;
                                          } else if(var69 == 732) {
                                             var62[var23] = -104;
                                          } else if(var69 == 8482) {
                                             var62[var23] = -103;
                                          } else if(353 == var69) {
                                             var62[var23] = -102;
                                          } else if(8250 == var69) {
                                             var62[var23] = -101;
                                          } else if(339 == var69) {
                                             var62[var23] = -100;
                                          } else if(382 == var69) {
                                             var62[var23] = -98;
                                          } else if(var69 == 376) {
                                             var62[var23] = -97;
                                          } else {
                                             var62[var23] = 63;
                                          }
                                       }

                                       var83.method2717(var62.length);
                                       var83.field1992 += class129.field2055.method2535(var62, 0, var62.length, var83.field1993, var83.field1992);
                                       client.field338.method2811(client.field338.field1992 - var37);
                                       continue;
                                    }

                                    if(5015 == var34) {
                                       if(class5.field93 != null && null != class5.field93.field58) {
                                          var52 = class5.field93.field58;
                                       } else {
                                          var52 = "";
                                       }

                                       class36.field805[var6++] = var52;
                                       continue;
                                    }

                                    if(var34 == 5016) {
                                       class36.field813[var5++] = client.field445;
                                       continue;
                                    }

                                    if(5017 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = class39.method856(var15);
                                       continue;
                                    }

                                    if(5018 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       class36.field813[var5++] = class76.method1762(var15);
                                       continue;
                                    }

                                    if(5019 == var34) {
                                       --var5;
                                       var15 = class36.field813[var5];
                                       var98 = class36.field813;
                                       var37 = var5++;
                                       class35 var70 = (class35)class11.field181.method3889((long)var15);
                                       if(null == var70) {
                                          var42 = -1;
                                       } else if(var70.field3113 == class11.field182.field3109) {
                                          var42 = -1;
                                       } else {
                                          var42 = ((class35)var70.field3113).field797;
                                       }

                                       var98[var37] = var42;
                                       continue;
                                    }

                                    if(var34 == 5020) {
                                       --var6;
                                       var52 = class36.field805[var6];
                                       class167.method3436(var52);
                                       continue;
                                    }

                                    if(var34 == 5021) {
                                       --var6;
                                       client.field330 = class36.field805[var6].toLowerCase().trim();
                                       continue;
                                    }

                                    if(5022 == var34) {
                                       class36.field805[var6++] = client.field330;
                                       continue;
                                    }
                                 }
                              }
                           }
                        }
                     } else {
                        if(var34 >= 2000) {
                           var34 -= 1000;
                           --var5;
                           var36 = class20.method641(class36.field813[var5]);
                        } else {
                           var36 = var51?class13.field211:class4.field76;
                        }

                        class23.method657(var36);
                        if(var34 == 1200 || 1205 == var34 || 1212 == var34) {
                           var5 -= 2;
                           var40 = class36.field813[var5];
                           var37 = class36.field813[var5 + 1];
                           var36.field2878 = var40;
                           var36.field2766 = var37;
                           class51 var18 = class11.method178(var40);
                           var36.field2800 = var18.field1131;
                           var36.field2810 = var18.field1132;
                           var36.field2811 = var18.field1121;
                           var36.field2760 = var18.field1134;
                           var36.field2808 = var18.field1114;
                           var36.field2812 = var18.field1148;
                           if(var34 == 1205) {
                              var36.field2816 = 0;
                           } else if(var34 == 1212 | 1 == var18.field1136) {
                              var36.field2816 = 1;
                           } else {
                              var36.field2816 = 2;
                           }

                           if(var36.field2813 > 0) {
                              var36.field2812 = var36.field2812 * 32 / var36.field2813;
                           } else if(var36.field2827 > 0) {
                              var36.field2812 = var36.field2812 * 32 / var36.field2827;
                           }
                           continue;
                        }

                        if(var34 == 1201) {
                           var36.field2801 = 2;
                           --var5;
                           var36.field2869 = class36.field813[var5];
                           continue;
                        }

                        if(1202 == var34) {
                           var36.field2801 = 3;
                           var36.field2869 = class5.field93.field33.method3567();
                           continue;
                        }
                     }
                  } else {
                     var15 = -1;
                     if(var34 >= 2000) {
                        var34 -= 1000;
                        --var5;
                        var15 = class36.field813[var5];
                        var16 = class20.method641(var15);
                     } else {
                        var16 = var51?class13.field211:class4.field76;
                     }

                     if(var34 == 1000) {
                        var5 -= 4;
                        var16.field2753 = class36.field813[var5];
                        var16.field2768 = class36.field813[var5 + 1];
                        var16.field2763 = class36.field813[var5 + 2];
                        var16.field2849 = class36.field813[var5 + 3];
                        class23.method657(var16);
                        class96.method2278(var16);
                        if(var15 != -1 && 0 == var16.field2824) {
                           class14.method202(class173.field2886[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(1001 == var34) {
                        var5 -= 4;
                        var16.field2827 = class36.field813[var5];
                        var16.field2809 = class36.field813[var5 + 1];
                        var16.field2881 = class36.field813[2 + var5];
                        var16.field2880 = class36.field813[3 + var5];
                        class23.method657(var16);
                        class96.method2278(var16);
                        if(-1 != var15 && 0 == var16.field2824) {
                           class14.method202(class173.field2886[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var34 == 1003) {
                        --var5;
                        var17 = class36.field813[var5] == 1;
                        if(var16.field2778 != var17) {
                           var16.field2778 = var17;
                           class23.method657(var16);
                        }
                        continue;
                     }

                     if(1005 == var34) {
                        --var5;
                        var16.field2891 = class36.field813[var5] == 1;
                        continue;
                     }

                     if(1006 == var34) {
                        --var5;
                        var16.field2892 = class36.field813[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var34 < 5400) {
                  if(var34 == 5306) {
                     class36.field813[var5++] = class24.method674();
                     continue;
                  }

                  if(5307 == var34) {
                     --var5;
                     var15 = class36.field813[var5];
                     if(1 != var15 && 2 != var15) {
                        continue;
                     }

                     client.field506 = 0L;
                     if(var15 >= 2) {
                        client.field344 = true;
                     } else {
                        client.field344 = false;
                     }

                     class9.method160();
                     if(client.field554 >= 25) {
                        class34.method804();
                     }

                     class144.field2197 = true;
                     continue;
                  }

                  if(5308 == var34) {
                     class36.field813[var5++] = class134.field2078.field145;
                     continue;
                  }

                  if(var34 == 5309) {
                     --var5;
                     var15 = class36.field813[var5];
                     if(1 == var15 || 2 == var15) {
                        class134.field2078.field145 = var15;
                        class213.method4031();
                     }
                     continue;
                  }
               }

               if(var34 < 5600) {
                  if(5504 == var34) {
                     var5 -= 2;
                     var15 = class36.field813[var5];
                     var40 = class36.field813[var5 + 1];
                     if(!client.field542) {
                        client.field564 = var15;
                        client.field379 = var40;
                     }
                     continue;
                  }

                  if(var34 == 5505) {
                     class36.field813[var5++] = client.field564;
                     continue;
                  }

                  if(5506 == var34) {
                     class36.field813[var5++] = client.field379;
                     continue;
                  }

                  if(var34 == 5530) {
                     --var5;
                     var15 = class36.field813[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     client.field556 = var15;
                     continue;
                  }

                  if(5531 == var34) {
                     class36.field813[var5++] = client.field556;
                     continue;
                  }
               }

               if(var34 < 5700 && var34 == 5630) {
                  client.field401 = 250;
               } else {
                  if(var34 < 6300) {
                     if(var34 == 6200) {
                        var5 -= 2;
                        client.field548 = (short)class36.field813[var5];
                        if(client.field548 <= 0) {
                           client.field548 = 256;
                        }

                        client.field535 = (short)class36.field813[1 + var5];
                        if(client.field535 <= 0) {
                           client.field535 = 205;
                        }
                        continue;
                     }

                     if(var34 == 6201) {
                        var5 -= 2;
                        client.field421 = (short)class36.field813[var5];
                        if(client.field421 <= 0) {
                           client.field421 = 256;
                        }

                        client.field545 = (short)class36.field813[var5 + 1];
                        if(client.field545 <= 0) {
                           client.field545 = 320;
                        }
                        continue;
                     }

                     if(var34 == 6202) {
                        var5 -= 4;
                        client.field552 = (short)class36.field813[var5];
                        if(client.field552 <= 0) {
                           client.field552 = 1;
                        }

                        client.field553 = (short)class36.field813[1 + var5];
                        if(client.field553 <= 0) {
                           client.field553 = 32767;
                        } else if(client.field553 < client.field552) {
                           client.field553 = client.field552;
                        }

                        client.field385 = (short)class36.field813[2 + var5];
                        if(client.field385 <= 0) {
                           client.field385 = 1;
                        }

                        client.field555 = (short)class36.field813[var5 + 3];
                        if(client.field555 <= 0) {
                           client.field555 = 32767;
                        } else if(client.field555 < client.field385) {
                           client.field555 = client.field385;
                        }
                        continue;
                     }

                     if(6203 == var34) {
                        if(null != client.field470) {
                           class10.method165(0, 0, client.field470.field2773, client.field470.field2774, false);
                           class36.field813[var5++] = client.field558;
                           class36.field813[var5++] = client.field456;
                        } else {
                           class36.field813[var5++] = -1;
                           class36.field813[var5++] = -1;
                        }
                        continue;
                     }

                     if(6204 == var34) {
                        class36.field813[var5++] = client.field421;
                        class36.field813[var5++] = client.field545;
                        continue;
                     }

                     if(6205 == var34) {
                        class36.field813[var5++] = client.field548;
                        class36.field813[var5++] = client.field535;
                        continue;
                     }
                  }

                  if(var34 < 6600) {
                     if(6500 == var34) {
                        class36.field813[var5++] = class74.method1690()?1:0;
                        continue;
                     }

                     class25 var105;
                     if(var34 == 6501) {
                        class25.field642 = 0;
                        if(class25.field642 < class25.field650) {
                           var105 = class129.field2051[++class25.field642 - 1];
                        } else {
                           var105 = null;
                        }

                        if(null != var105) {
                           class36.field813[var5++] = var105.field646;
                           class36.field813[var5++] = var105.field647;
                           class36.field805[var6++] = var105.field649;
                           class36.field813[var5++] = var105.field651;
                           class36.field813[var5++] = var105.field648;
                           class36.field805[var6++] = var105.field655;
                        } else {
                           class36.field813[var5++] = -1;
                           class36.field813[var5++] = 0;
                           class36.field805[var6++] = "";
                           class36.field813[var5++] = 0;
                           class36.field813[var5++] = 0;
                           class36.field805[var6++] = "";
                        }
                        continue;
                     }

                     if(6502 == var34) {
                        class25 var111;
                        if(class25.field642 < class25.field650) {
                           var111 = class129.field2051[++class25.field642 - 1];
                        } else {
                           var111 = null;
                        }

                        if(var111 != null) {
                           class36.field813[var5++] = var111.field646;
                           class36.field813[var5++] = var111.field647;
                           class36.field805[var6++] = var111.field649;
                           class36.field813[var5++] = var111.field651;
                           class36.field813[var5++] = var111.field648;
                           class36.field805[var6++] = var111.field655;
                        } else {
                           class36.field813[var5++] = -1;
                           class36.field813[var5++] = 0;
                           class36.field805[var6++] = "";
                           class36.field813[var5++] = 0;
                           class36.field813[var5++] = 0;
                           class36.field805[var6++] = "";
                        }
                        continue;
                     }

                     if(6506 == var34) {
                        --var5;
                        var15 = class36.field813[var5];
                        var105 = null;

                        for(var37 = 0; var37 < class25.field650; ++var37) {
                           if(var15 == class129.field2051[var37].field646) {
                              var105 = class129.field2051[var37];
                              break;
                           }
                        }

                        if(null != var105) {
                           class36.field813[var5++] = var105.field646;
                           class36.field813[var5++] = var105.field647;
                           class36.field805[var6++] = var105.field649;
                           class36.field813[var5++] = var105.field651;
                           class36.field813[var5++] = var105.field648;
                           class36.field805[var6++] = var105.field655;
                        } else {
                           class36.field813[var5++] = -1;
                           class36.field813[var5++] = 0;
                           class36.field805[var6++] = "";
                           class36.field813[var5++] = 0;
                           class36.field813[var5++] = 0;
                           class36.field805[var6++] = "";
                        }
                        continue;
                     }

                     if(6507 == var34) {
                        var5 -= 4;
                        var15 = class36.field813[var5];
                        var50 = class36.field813[1 + var5] == 1;
                        var37 = class36.field813[2 + var5];
                        var59 = class36.field813[3 + var5] == 1;
                        class154.method3257(var15, var50, var37, var59);
                        continue;
                     }

                     if(var34 == 6511) {
                        --var5;
                        var15 = class36.field813[var5];
                        if(var15 >= 0 && var15 < class25.field650) {
                           var105 = class129.field2051[var15];
                           class36.field813[var5++] = var105.field646;
                           class36.field813[var5++] = var105.field647;
                           class36.field805[var6++] = var105.field649;
                           class36.field813[var5++] = var105.field651;
                           class36.field813[var5++] = var105.field648;
                           class36.field805[var6++] = var105.field655;
                           continue;
                        }

                        class36.field813[var5++] = -1;
                        class36.field813[var5++] = 0;
                        class36.field805[var6++] = "";
                        class36.field813[var5++] = 0;
                        class36.field813[var5++] = 0;
                        class36.field805[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var33) {
            StringBuilder var12 = new StringBuilder(30);
            var12.append("").append(var4.field3125).append(" ");

            for(var13 = class36.field808 - 1; var13 >= 0; --var13) {
               var12.append("").append(class36.field809[var13].field216.field3125).append(" ");
            }

            var12.append("").append(var10);
            class22.method655(var12.toString(), var33);
         }
      }
   }

   public class168(class134 var1, class134 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2693 = var1;
      this.field2683 = var2;
      this.field2685 = var3;
      this.field2687 = var6;
      int var8 = this.field2685;
      if(null != class10.field171) {
         class10.field171.field1992 = 5 + 8 * var8;
         int var9 = class10.field171.method2618();
         int var10 = class10.field171.method2618();
         this.method3445(var9, var10);
      } else {
         class98.method2284((class168)null, 255, 255, 0, (byte)0, true);
         class171.field2722[var8] = this;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method3458() {
      if(client.field523 != class42.field1002) {
         client.field523 = class42.field1002;
         class17.method219(class42.field1002);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2110155430"
   )
   void vmethod3459(int var1) {
      int var2 = this.field2685;
      long var3 = (long)((var2 << 16) + var1);
      class172 var5 = (class172)class171.field2721.method3868(var3);
      if(null != var5) {
         class171.field2720.method3964(var5);
      }

   }
}
