import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class99 extends class109 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1665883653
   )
   int field1641 = 256;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -428719053
   )
   int field1643 = 1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -811008419416940341L
   )
   long field1644 = class22.method224();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1805808149
   )
   int field1645 = 0;
   @ObfuscatedName("k")
   long[] field1647 = new long[10];
   @ObfuscatedName("eq")
   static SpritePixels[] field1648;
   @ObfuscatedName("ay")
   static class102 field1649;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1962682891
   )
   int field1650;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 352118349
   )
   @Export("menuWidth")
   static int menuWidth;

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1647[var1] = this.field1644;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1203637754"
   )
   void vmethod2039() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1647[var1] = 0L;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "96"
   )
   int vmethod2040(int var1, int var2) {
      int var3 = this.field1641;
      int var4 = this.field1643;
      this.field1641 = 300;
      this.field1643 = 1;
      this.field1644 = class22.method224();
      if(this.field1647[this.field1650] == 0L) {
         this.field1641 = var3;
         this.field1643 = var4;
      } else if(this.field1644 > this.field1647[this.field1650]) {
         this.field1641 = (int)((long)(var1 * 2560) / (this.field1644 - this.field1647[this.field1650]));
      }

      if(this.field1641 < 25) {
         this.field1641 = 25;
      }

      if(this.field1641 > 256) {
         this.field1641 = 256;
         this.field1643 = (int)((long)var1 - (this.field1644 - this.field1647[this.field1650]) / 10L);
      }

      if(this.field1643 > var1) {
         this.field1643 = var1;
      }

      this.field1647[this.field1650] = this.field1644;
      this.field1650 = (this.field1650 + 1) % 10;
      int var5;
      if(this.field1643 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1647[var5]) {
               this.field1647[var5] += (long)this.field1643;
            }
         }
      }

      if(this.field1643 < var2) {
         this.field1643 = var2;
      }

      class195.method3560((long)this.field1643);

      for(var5 = 0; this.field1645 < 256; this.field1645 += this.field1641) {
         ++var5;
      }

      this.field1645 &= 255;
      return var5;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass18;IB)V",
      garbageValue = "11"
   )
   static void method1923(class18 var0, int var1) {
      Object[] var2 = var0.field198;
      int var3 = ((Integer)var2[0]).intValue();
      class48 var4 = class140.method2613(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field934;
         int[] var9 = var4.field935;
         byte var10 = -1;
         class32.field712 = 0;

         int var13;
         try {
            class32.field714 = new int[var4.field942];
            int var11 = 0;
            class32.field713 = new String[var4.field938];
            int var12 = 0;

            int var14;
            String var32;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field191;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field188;
                  }

                  if(var14 == -2147483645) {
                     var14 = null != var0.field190?var0.field190.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field193;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field190 != null?var0.field190.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field194?var0.field194.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field194 != null?var0.field194.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field195;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field196;
                  }

                  class32.field714[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var32 = (String)var2[var13];
                  if(var32.equals("event_opbase")) {
                     var32 = var0.field200;
                  }

                  class32.field713[var12++] = var32;
               }
            }

            var13 = 0;
            class32.field723 = var0.field197;

            label3848:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var55 = var8[var7];
               int var15;
               int[] var16;
               int var17;
               int var18;
               int var19;
               int var20;
               int var36;
               String var89;
               if(var55 < 100) {
                  if(var55 == 0) {
                     class32.field716[var5++] = var9[var7];
                     continue;
                  }

                  if(var55 == 1) {
                     var14 = var9[var7];
                     class32.field716[var5++] = class146.widgetSettings[var14];
                     continue;
                  }

                  if(var55 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class146.widgetSettings[var14] = class32.field716[var5];
                     class182.method3296(var14);
                     continue;
                  }

                  if(var55 == 3) {
                     class32.chatboxSegments[var6++] = var4.field937[var7];
                     continue;
                  }

                  if(var55 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var55 == 7) {
                     var5 -= 2;
                     if(class32.field716[var5] != class32.field716[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var55 == 8) {
                     var5 -= 2;
                     if(class32.field716[var5] == class32.field716[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var55 == 9) {
                     var5 -= 2;
                     if(class32.field716[var5] < class32.field716[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var55 == 10) {
                     var5 -= 2;
                     if(class32.field716[var5] > class32.field716[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var55 == 21) {
                     if(class32.field712 == 0) {
                        return;
                     }

                     class10 var82 = class32.field719[--class32.field712];
                     var4 = var82.field90;
                     var8 = var4.field934;
                     var9 = var4.field935;
                     var7 = var82.field86;
                     class32.field714 = var82.field88;
                     class32.field713 = var82.field89;
                     continue;
                  }

                  if(var55 == 25) {
                     var14 = var9[var7];
                     class32.field716[var5++] = class10.method127(var14);
                     continue;
                  }

                  if(var55 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field716[var5];
                     Varbit var80 = class0.method13(var14);
                     var17 = var80.leastSignificantBit;
                     var18 = var80.configId;
                     var19 = var80.mostSignificantBit;
                     var20 = class146.field2013[var19 - var18];
                     if(var15 < 0 || var15 > var20) {
                        var15 = 0;
                     }

                     var20 <<= var18;
                     class146.widgetSettings[var17] = class146.widgetSettings[var17] & ~var20 | var15 << var18 & var20;
                     continue;
                  }

                  if(var55 == 31) {
                     var5 -= 2;
                     if(class32.field716[var5] <= class32.field716[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var55 == 32) {
                     var5 -= 2;
                     if(class32.field716[var5] >= class32.field716[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var55 == 33) {
                     class32.field716[var5++] = class32.field714[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var55 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class32.field714[var10001] = class32.field716[var5];
                     continue;
                  }

                  if(var55 == 35) {
                     class32.chatboxSegments[var6++] = class32.field713[var9[var7]];
                     continue;
                  }

                  if(var55 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class32.field713[var10001] = class32.chatboxSegments[var6];
                     continue;
                  }

                  if(var55 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var89 = class204.method3813(class32.chatboxSegments, var6, var14);
                     class32.chatboxSegments[var6++] = var89;
                     continue;
                  }

                  if(var55 == 38) {
                     --var5;
                     continue;
                  }

                  if(var55 == 39) {
                     --var6;
                     continue;
                  }

                  if(var55 == 40) {
                     var14 = var9[var7];
                     class48 var114 = class140.method2613(var14);
                     var16 = new int[var114.field942];
                     String[] var103 = new String[var114.field938];

                     for(var18 = 0; var18 < var114.field939; ++var18) {
                        var16[var18] = class32.field716[var5 - var114.field939 + var18];
                     }

                     for(var18 = 0; var18 < var114.field941; ++var18) {
                        var103[var18] = class32.chatboxSegments[var6 - var114.field941 + var18];
                     }

                     var5 -= var114.field939;
                     var6 -= var114.field941;
                     class10 var112 = new class10();
                     var112.field90 = var4;
                     var112.field86 = var7;
                     var112.field88 = class32.field714;
                     var112.field89 = class32.field713;
                     class32.field719[++class32.field712 - 1] = var112;
                     var4 = var114;
                     var8 = var114.field934;
                     var9 = var114.field935;
                     var7 = -1;
                     class32.field714 = var16;
                     class32.field713 = var103;
                     continue;
                  }

                  if(var55 == 42) {
                     class32.field716[var5++] = class45.chatMessages.method842(var9[var7]);
                     continue;
                  }

                  if(var55 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class45.chatMessages.method843(var10001, class32.field716[var5]);
                     continue;
                  }

                  if(var55 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var36 = class32.field716[var5];
                     if(var36 >= 0 && var36 <= 5000) {
                        class32.field734[var14] = var36;
                        byte var81 = -1;
                        if(var15 == 105) {
                           var81 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var36) {
                              continue label3848;
                           }

                           class32.field720[var14][var18] = var81;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var55 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field716[var5];
                     if(var15 >= 0 && var15 < class32.field734[var14]) {
                        class32.field716[var5++] = class32.field720[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var55 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class32.field716[var5];
                     if(var15 >= 0 && var15 < class32.field734[var14]) {
                        class32.field720[var14][var15] = class32.field716[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var55 == 47) {
                     var32 = class45.chatMessages.method851(var9[var7]);
                     if(null == var32) {
                        var32 = "null";
                     }

                     class32.chatboxSegments[var6++] = var32;
                     continue;
                  }

                  if(var55 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class45.chatMessages.method868(var10001, class32.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var61;
               if(var9[var7] == 1) {
                  var61 = true;
               } else {
                  var61 = false;
               }

               Widget var33;
               Widget var35;
               boolean var62;
               Widget var73;
               Widget var83;
               boolean var91;
               int[] var109;
               if(var55 < 1000) {
                  if(var55 == 100) {
                     var5 -= 3;
                     var15 = class32.field716[var5];
                     var36 = class32.field716[1 + var5];
                     var17 = class32.field716[2 + var5];
                     if(var36 == 0) {
                        throw new RuntimeException();
                     }

                     var35 = class37.method759(var15);
                     if(var35.children == null) {
                        var35.children = new Widget[var17 + 1];
                     }

                     if(var35.children.length <= var17) {
                        Widget[] var107 = new Widget[1 + var17];

                        for(var20 = 0; var20 < var35.children.length; ++var20) {
                           var107[var20] = var35.children[var20];
                        }

                        var35.children = var107;
                     }

                     if(var17 > 0 && null == var35.children[var17 - 1]) {
                        throw new RuntimeException("" + (var17 - 1));
                     }

                     Widget var108 = new Widget();
                     var108.type = var36;
                     var108.parentId = var108.id = var35.id;
                     var108.index = var17;
                     var108.hasScript = true;
                     var35.children[var17] = var108;
                     if(var61) {
                        class32.field731 = var108;
                     } else {
                        class174.field2623 = var108;
                     }

                     class2.method28(var35);
                     continue;
                  }

                  if(var55 == 101) {
                     var33 = var61?class32.field731:class174.field2623;
                     var73 = class37.method759(var33.id);
                     var73.children[var33.index] = null;
                     class2.method28(var73);
                     continue;
                  }

                  if(var55 == 102) {
                     --var5;
                     var33 = class37.method759(class32.field716[var5]);
                     var33.children = null;
                     class2.method28(var33);
                     continue;
                  }

                  if(var55 == 200) {
                     var5 -= 2;
                     var15 = class32.field716[var5];
                     var36 = class32.field716[1 + var5];
                     var83 = ItemLayer.method1468(var15, var36);
                     if(null != var83 && var36 != -1) {
                        class32.field716[var5++] = 1;
                        if(var61) {
                           class32.field731 = var83;
                        } else {
                           class174.field2623 = var83;
                        }
                        continue;
                     }

                     class32.field716[var5++] = 0;
                     continue;
                  }

                  if(var55 == 201) {
                     --var5;
                     var33 = class37.method759(class32.field716[var5]);
                     if(null != var33) {
                        class32.field716[var5++] = 1;
                        if(var61) {
                           class32.field731 = var33;
                        } else {
                           class174.field2623 = var33;
                        }
                     } else {
                        class32.field716[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var67;
                  if(var55 >= 1000 && var55 < 1100 || var55 >= 2000 && var55 < 2100) {
                     var15 = -1;
                     if(var55 >= 2000) {
                        var55 -= 1000;
                        --var5;
                        var15 = class32.field716[var5];
                        var73 = class37.method759(var15);
                     } else {
                        var73 = var61?class32.field731:class174.field2623;
                     }

                     if(var55 == 1000) {
                        var5 -= 4;
                        var73.originalX = class32.field716[var5];
                        var73.originalY = class32.field716[var5 + 1];
                        var73.field2111 = class32.field716[2 + var5];
                        var73.field2179 = class32.field716[3 + var5];
                        class2.method28(var73);
                        class103.method1965(var73);
                        if(var15 != -1 && var73.type == 0) {
                           class22.method233(Widget.widgets[var15 >> 16], var73, false);
                        }
                        continue;
                     }

                     if(var55 == 1001) {
                        var5 -= 4;
                        var73.originalWidth = class32.field716[var5];
                        var73.field2061 = class32.field716[1 + var5];
                        var73.field2056 = class32.field716[var5 + 2];
                        var73.field2151 = class32.field716[var5 + 3];
                        class2.method28(var73);
                        class103.method1965(var73);
                        if(var15 != -1 && var73.type == 0) {
                           class22.method233(Widget.widgets[var15 >> 16], var73, false);
                        }
                        continue;
                     }

                     if(var55 == 1003) {
                        --var5;
                        var67 = class32.field716[var5] == 1;
                        if(var67 != var73.isHidden) {
                           var73.isHidden = var67;
                           class2.method28(var73);
                        }
                        continue;
                     }

                     if(var55 == 1005) {
                        --var5;
                        var73.field2182 = class32.field716[var5] == 1;
                        continue;
                     }

                     if(var55 == 1006) {
                        --var5;
                        var73.field2183 = class32.field716[var5] == 1;
                        continue;
                     }
                  } else {
                     String var34;
                     if(var55 >= 1100 && var55 < 1200 || var55 >= 2100 && var55 < 2200) {
                        var36 = -1;
                        if(var55 >= 2000) {
                           var55 -= 1000;
                           --var5;
                           var36 = class32.field716[var5];
                           var33 = class37.method759(var36);
                        } else {
                           var33 = var61?class32.field731:class174.field2623;
                        }

                        if(var55 == 1100) {
                           var5 -= 2;
                           var33.scrollX = class32.field716[var5];
                           if(var33.scrollX > var33.scrollWidth - var33.width) {
                              var33.scrollX = var33.scrollWidth - var33.width;
                           }

                           if(var33.scrollX < 0) {
                              var33.scrollX = 0;
                           }

                           var33.scrollY = class32.field716[1 + var5];
                           if(var33.scrollY > var33.scrollHeight - var33.height) {
                              var33.scrollY = var33.scrollHeight - var33.height;
                           }

                           if(var33.scrollY < 0) {
                              var33.scrollY = 0;
                           }

                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1101) {
                           --var5;
                           var33.textColor = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1102) {
                           --var5;
                           var33.field2099 = class32.field716[var5] == 1;
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1103) {
                           --var5;
                           var33.opacity = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1104) {
                           --var5;
                           var33.field2082 = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1105) {
                           --var5;
                           var33.textureId = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1106) {
                           --var5;
                           var33.field2078 = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1107) {
                           --var5;
                           var33.field2087 = class32.field716[var5] == 1;
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1108) {
                           var33.modelType = 1;
                           --var5;
                           var33.modelId = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1109) {
                           var5 -= 6;
                           var33.field2160 = class32.field716[var5];
                           var33.field2114 = class32.field716[1 + var5];
                           var33.rotationX = class32.field716[var5 + 2];
                           var33.rotationZ = class32.field716[3 + var5];
                           var33.rotationY = class32.field716[4 + var5];
                           var33.field2103 = class32.field716[var5 + 5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1110) {
                           --var5;
                           var17 = class32.field716[var5];
                           if(var17 != var33.field2164) {
                              var33.field2164 = var17;
                              var33.field2054 = 0;
                              var33.field2176 = 0;
                              class2.method28(var33);
                           }
                           continue;
                        }

                        if(var55 == 1111) {
                           --var5;
                           var33.field2121 = class32.field716[var5] == 1;
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1112) {
                           --var6;
                           var34 = class32.chatboxSegments[var6];
                           if(!var34.equals(var33.text)) {
                              var33.text = var34;
                              class2.method28(var33);
                           }
                           continue;
                        }

                        if(var55 == 1113) {
                           --var5;
                           var33.fontId = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1114) {
                           var5 -= 3;
                           var33.field2112 = class32.field716[var5];
                           var33.field2080 = class32.field716[var5 + 1];
                           var33.field2113 = class32.field716[var5 + 2];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1115) {
                           --var5;
                           var33.field2163 = class32.field716[var5] == 1;
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1116) {
                           --var5;
                           var33.borderThickness = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1117) {
                           --var5;
                           var33.sprite2 = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1118) {
                           --var5;
                           var33.flippedVertically = class32.field716[var5] == 1;
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1119) {
                           --var5;
                           var33.flippedHorizontally = class32.field716[var5] == 1;
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1120) {
                           var5 -= 2;
                           var33.scrollWidth = class32.field716[var5];
                           var33.scrollHeight = class32.field716[1 + var5];
                           class2.method28(var33);
                           if(var36 != -1 && var33.type == 0) {
                              class22.method233(Widget.widgets[var36 >> 16], var33, false);
                           }
                           continue;
                        }

                        if(var55 == 1121) {
                           var17 = var33.id;
                           var18 = var33.index;
                           Client.field321.method3195(136);
                           Client.field321.method2970(var17);
                           Client.field321.method3094(var18);
                           Client.field309 = var33;
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1122) {
                           --var5;
                           var33.field2062 = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1123) {
                           --var5;
                           var33.field2075 = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1124) {
                           --var5;
                           var33.field2081 = class32.field716[var5];
                           class2.method28(var33);
                           continue;
                        }

                        if(var55 == 1125) {
                           --var5;
                           var17 = class32.field716[var5];
                           class221[] var111 = new class221[]{class221.field3180, class221.field3181, class221.field3183, class221.field3184, class221.field3182};
                           class221 var106 = (class221)CombatInfoListHolder.method732(var111, var17);
                           if(var106 != null) {
                              var33.field2079 = var106;
                              class2.method28(var33);
                           }
                           continue;
                        }
                     } else if(var55 >= 1200 && var55 < 1300 || var55 >= 2200 && var55 < 2300) {
                        if(var55 >= 2000) {
                           var55 -= 1000;
                           --var5;
                           var33 = class37.method759(class32.field716[var5]);
                        } else {
                           var33 = var61?class32.field731:class174.field2623;
                        }

                        class2.method28(var33);
                        if(var55 == 1200 || var55 == 1205 || var55 == 1212) {
                           var5 -= 2;
                           var36 = class32.field716[var5];
                           var17 = class32.field716[1 + var5];
                           var33.item = var36;
                           var33.stackSize = var17;
                           ItemComposition var110 = PlayerComposition.getItemDefinition(var36);
                           var33.rotationX = var110.xan2d;
                           var33.rotationZ = var110.yan2d;
                           var33.rotationY = var110.zan2d;
                           var33.field2160 = var110.offsetX2d;
                           var33.field2114 = var110.offsetY2d;
                           var33.field2103 = var110.zoom2d;
                           if(var55 == 1205) {
                              var33.field2057 = 0;
                           } else if(var55 == 1212 | var110.isStackable == 1) {
                              var33.field2057 = 1;
                           } else {
                              var33.field2057 = 2;
                           }

                           if(var33.field2104 > 0) {
                              var33.field2103 = var33.field2103 * 32 / var33.field2104;
                           } else if(var33.originalWidth > 0) {
                              var33.field2103 = var33.field2103 * 32 / var33.originalWidth;
                           }
                           continue;
                        }

                        if(var55 == 1201) {
                           var33.modelType = 2;
                           --var5;
                           var33.modelId = class32.field716[var5];
                           continue;
                        }

                        if(var55 == 1202) {
                           var33.modelType = 3;
                           var33.modelId = VertexNormal.localPlayer.composition.method2737();
                           continue;
                        }
                     } else if(var55 >= 1300 && var55 < 1400 || var55 >= 2300 && var55 < 2400) {
                        if(var55 >= 2000) {
                           var55 -= 1000;
                           --var5;
                           var33 = class37.method759(class32.field716[var5]);
                        } else {
                           var33 = var61?class32.field731:class174.field2623;
                        }

                        if(var55 == 1300) {
                           --var5;
                           var36 = class32.field716[var5] - 1;
                           if(var36 >= 0 && var36 <= 9) {
                              --var6;
                              var33.method2824(var36, class32.chatboxSegments[var6]);
                              continue;
                           }

                           --var6;
                           continue;
                        }

                        if(var55 == 1301) {
                           var5 -= 2;
                           var36 = class32.field716[var5];
                           var17 = class32.field716[var5 + 1];
                           var33.parent = ItemLayer.method1468(var36, var17);
                           continue;
                        }

                        if(var55 == 1302) {
                           --var5;
                           var33.field2172 = class32.field716[var5] == 1;
                           continue;
                        }

                        if(var55 == 1303) {
                           --var5;
                           var33.field2125 = class32.field716[var5];
                           continue;
                        }

                        if(var55 == 1304) {
                           --var5;
                           var33.field2097 = class32.field716[var5];
                           continue;
                        }

                        if(var55 == 1305) {
                           --var6;
                           var33.name = class32.chatboxSegments[var6];
                           continue;
                        }

                        if(var55 == 1306) {
                           --var6;
                           var33.field2128 = class32.chatboxSegments[var6];
                           continue;
                        }

                        if(var55 == 1307) {
                           var33.actions = null;
                           continue;
                        }
                     } else {
                        String var58;
                        int[] var84;
                        if(var55 >= 1400 && var55 < 1500 || var55 >= 2400 && var55 < 2500) {
                           if(var55 >= 2000) {
                              var55 -= 1000;
                              --var5;
                              var33 = class37.method759(class32.field716[var5]);
                           } else {
                              var33 = var61?class32.field731:class174.field2623;
                           }

                           --var6;
                           var58 = class32.chatboxSegments[var6];
                           var84 = null;
                           if(var58.length() > 0 && var58.charAt(var58.length() - 1) == 89) {
                              --var5;
                              var18 = class32.field716[var5];
                              if(var18 > 0) {
                                 for(var84 = new int[var18]; var18-- > 0; var84[var18] = class32.field716[var5]) {
                                    --var5;
                                 }
                              }

                              var58 = var58.substring(0, var58.length() - 1);
                           }

                           Object[] var105 = new Object[var58.length() + 1];

                           for(var19 = var105.length - 1; var19 >= 1; --var19) {
                              if(var58.charAt(var19 - 1) == 115) {
                                 --var6;
                                 var105[var19] = class32.chatboxSegments[var6];
                              } else {
                                 --var5;
                                 var105[var19] = new Integer(class32.field716[var5]);
                              }
                           }

                           --var5;
                           var19 = class32.field716[var5];
                           if(var19 != -1) {
                              var105[0] = new Integer(var19);
                           } else {
                              var105 = null;
                           }

                           if(var55 == 1400) {
                              var33.field2131 = var105;
                           }

                           if(var55 == 1401) {
                              var33.field2134 = var105;
                           }

                           if(var55 == 1402) {
                              var33.field2133 = var105;
                           }

                           if(var55 == 1403) {
                              var33.field2135 = var105;
                           }

                           if(var55 == 1404) {
                              var33.field2137 = var105;
                           }

                           if(var55 == 1405) {
                              var33.field2138 = var105;
                           }

                           if(var55 == 1406) {
                              var33.field2141 = var105;
                           }

                           if(var55 == 1407) {
                              var33.field2073 = var105;
                              var33.field2127 = var84;
                           }

                           if(var55 == 1408) {
                              var33.field2148 = var105;
                           }

                           if(var55 == 1409) {
                              var33.field2064 = var105;
                           }

                           if(var55 == 1410) {
                              var33.field2139 = var105;
                           }

                           if(var55 == 1411) {
                              var33.field2132 = var105;
                           }

                           if(var55 == 1412) {
                              var33.field2136 = var105;
                           }

                           if(var55 == 1414) {
                              var33.field2144 = var105;
                              var33.field2145 = var84;
                           }

                           if(var55 == 1415) {
                              var33.field2086 = var105;
                              var33.field2147 = var84;
                           }

                           if(var55 == 1416) {
                              var33.field2096 = var105;
                           }

                           if(var55 == 1417) {
                              var33.field2106 = var105;
                           }

                           if(var55 == 1418) {
                              var33.field2070 = var105;
                           }

                           if(var55 == 1419) {
                              var33.field2152 = var105;
                           }

                           if(var55 == 1420) {
                              var33.field2153 = var105;
                           }

                           if(var55 == 1421) {
                              var33.field2154 = var105;
                           }

                           if(var55 == 1422) {
                              var33.field2155 = var105;
                           }

                           if(var55 == 1423) {
                              var33.field2156 = var105;
                           }

                           if(var55 == 1424) {
                              var33.field2157 = var105;
                           }

                           if(var55 == 1425) {
                              var33.field2159 = var105;
                           }

                           if(var55 == 1426) {
                              var33.field2055 = var105;
                           }

                           if(var55 == 1427) {
                              var33.field2158 = var105;
                           }

                           var33.field2129 = true;
                           continue;
                        }

                        if(var55 < 1600) {
                           var33 = var61?class32.field731:class174.field2623;
                           if(var55 == 1500) {
                              class32.field716[var5++] = var33.relativeX;
                              continue;
                           }

                           if(var55 == 1501) {
                              class32.field716[var5++] = var33.relativeY;
                              continue;
                           }

                           if(var55 == 1502) {
                              class32.field716[var5++] = var33.width;
                              continue;
                           }

                           if(var55 == 1503) {
                              class32.field716[var5++] = var33.height;
                              continue;
                           }

                           if(var55 == 1504) {
                              class32.field716[var5++] = var33.isHidden?1:0;
                              continue;
                           }

                           if(var55 == 1505) {
                              class32.field716[var5++] = var33.parentId;
                              continue;
                           }
                        } else if(var55 < 1700) {
                           var33 = var61?class32.field731:class174.field2623;
                           if(var55 == 1600) {
                              class32.field716[var5++] = var33.scrollX;
                              continue;
                           }

                           if(var55 == 1601) {
                              class32.field716[var5++] = var33.scrollY;
                              continue;
                           }

                           if(var55 == 1602) {
                              class32.chatboxSegments[var6++] = var33.text;
                              continue;
                           }

                           if(var55 == 1603) {
                              class32.field716[var5++] = var33.scrollWidth;
                              continue;
                           }

                           if(var55 == 1604) {
                              class32.field716[var5++] = var33.scrollHeight;
                              continue;
                           }

                           if(var55 == 1605) {
                              class32.field716[var5++] = var33.field2103;
                              continue;
                           }

                           if(var55 == 1606) {
                              class32.field716[var5++] = var33.rotationX;
                              continue;
                           }

                           if(var55 == 1607) {
                              class32.field716[var5++] = var33.rotationY;
                              continue;
                           }

                           if(var55 == 1608) {
                              class32.field716[var5++] = var33.rotationZ;
                              continue;
                           }

                           if(var55 == 1609) {
                              class32.field716[var5++] = var33.opacity;
                              continue;
                           }

                           if(var55 == 1610) {
                              class32.field716[var5++] = var33.field2081;
                              continue;
                           }

                           if(var55 == 1611) {
                              class32.field716[var5++] = var33.textColor;
                              continue;
                           }

                           if(var55 == 1612) {
                              class32.field716[var5++] = var33.field2075;
                              continue;
                           }

                           if(var55 == 1613) {
                              class32.field716[var5++] = var33.field2079.vmethod4057();
                              continue;
                           }
                        } else if(var55 < 1800) {
                           var33 = var61?class32.field731:class174.field2623;
                           if(var55 == 1700) {
                              class32.field716[var5++] = var33.item;
                              continue;
                           }

                           if(var55 == 1701) {
                              if(var33.item != -1) {
                                 class32.field716[var5++] = var33.stackSize;
                              } else {
                                 class32.field716[var5++] = 0;
                              }
                              continue;
                           }

                           if(var55 == 1702) {
                              class32.field716[var5++] = var33.index;
                              continue;
                           }
                        } else if(var55 < 1900) {
                           var33 = var61?class32.field731:class174.field2623;
                           if(var55 == 1800) {
                              var16 = class32.field716;
                              var17 = var5++;
                              var19 = class88.method1872(var33);
                              var18 = var19 >> 11 & 63;
                              var16[var17] = var18;
                              continue;
                           }

                           if(var55 == 1801) {
                              --var5;
                              var36 = class32.field716[var5];
                              --var36;
                              if(var33.actions != null && var36 < var33.actions.length && null != var33.actions[var36]) {
                                 class32.chatboxSegments[var6++] = var33.actions[var36];
                                 continue;
                              }

                              class32.chatboxSegments[var6++] = "";
                              continue;
                           }

                           if(var55 == 1802) {
                              if(var33.name == null) {
                                 class32.chatboxSegments[var6++] = "";
                              } else {
                                 class32.chatboxSegments[var6++] = var33.name;
                              }
                              continue;
                           }
                        } else if((var55 < 1900 || var55 >= 2000) && (var55 < 2900 || var55 >= 3000)) {
                           if(var55 < 2600) {
                              --var5;
                              var33 = class37.method759(class32.field716[var5]);
                              if(var55 == 2500) {
                                 class32.field716[var5++] = var33.relativeX;
                                 continue;
                              }

                              if(var55 == 2501) {
                                 class32.field716[var5++] = var33.relativeY;
                                 continue;
                              }

                              if(var55 == 2502) {
                                 class32.field716[var5++] = var33.width;
                                 continue;
                              }

                              if(var55 == 2503) {
                                 class32.field716[var5++] = var33.height;
                                 continue;
                              }

                              if(var55 == 2504) {
                                 class32.field716[var5++] = var33.isHidden?1:0;
                                 continue;
                              }

                              if(var55 == 2505) {
                                 class32.field716[var5++] = var33.parentId;
                                 continue;
                              }
                           } else if(var55 < 2700) {
                              --var5;
                              var33 = class37.method759(class32.field716[var5]);
                              if(var55 == 2600) {
                                 class32.field716[var5++] = var33.scrollX;
                                 continue;
                              }

                              if(var55 == 2601) {
                                 class32.field716[var5++] = var33.scrollY;
                                 continue;
                              }

                              if(var55 == 2602) {
                                 class32.chatboxSegments[var6++] = var33.text;
                                 continue;
                              }

                              if(var55 == 2603) {
                                 class32.field716[var5++] = var33.scrollWidth;
                                 continue;
                              }

                              if(var55 == 2604) {
                                 class32.field716[var5++] = var33.scrollHeight;
                                 continue;
                              }

                              if(var55 == 2605) {
                                 class32.field716[var5++] = var33.field2103;
                                 continue;
                              }

                              if(var55 == 2606) {
                                 class32.field716[var5++] = var33.rotationX;
                                 continue;
                              }

                              if(var55 == 2607) {
                                 class32.field716[var5++] = var33.rotationY;
                                 continue;
                              }

                              if(var55 == 2608) {
                                 class32.field716[var5++] = var33.rotationZ;
                                 continue;
                              }

                              if(var55 == 2609) {
                                 class32.field716[var5++] = var33.opacity;
                                 continue;
                              }

                              if(var55 == 2610) {
                                 class32.field716[var5++] = var33.field2081;
                                 continue;
                              }

                              if(var55 == 2611) {
                                 class32.field716[var5++] = var33.textColor;
                                 continue;
                              }

                              if(var55 == 2612) {
                                 class32.field716[var5++] = var33.field2075;
                                 continue;
                              }

                              if(var55 == 2613) {
                                 class32.field716[var5++] = var33.field2079.vmethod4057();
                                 continue;
                              }
                           } else if(var55 < 2800) {
                              if(var55 == 2700) {
                                 --var5;
                                 var33 = class37.method759(class32.field716[var5]);
                                 class32.field716[var5++] = var33.item;
                                 continue;
                              }

                              if(var55 == 2701) {
                                 --var5;
                                 var33 = class37.method759(class32.field716[var5]);
                                 if(var33.item != -1) {
                                    class32.field716[var5++] = var33.stackSize;
                                 } else {
                                    class32.field716[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var55 == 2702) {
                                 --var5;
                                 var15 = class32.field716[var5];
                                 WidgetNode var57 = (WidgetNode)Client.componentTable.method2331((long)var15);
                                 if(var57 != null) {
                                    class32.field716[var5++] = 1;
                                 } else {
                                    class32.field716[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var55 == 2706) {
                                 class32.field716[var5++] = Client.widgetRoot;
                                 continue;
                              }
                           } else if(var55 < 2900) {
                              --var5;
                              var33 = class37.method759(class32.field716[var5]);
                              if(var55 == 2800) {
                                 var16 = class32.field716;
                                 var17 = var5++;
                                 var19 = class88.method1872(var33);
                                 var18 = var19 >> 11 & 63;
                                 var16[var17] = var18;
                                 continue;
                              }

                              if(var55 == 2801) {
                                 --var5;
                                 var36 = class32.field716[var5];
                                 --var36;
                                 if(null != var33.actions && var36 < var33.actions.length && var33.actions[var36] != null) {
                                    class32.chatboxSegments[var6++] = var33.actions[var36];
                                    continue;
                                 }

                                 class32.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var55 == 2802) {
                                 if(null == var33.name) {
                                    class32.chatboxSegments[var6++] = "";
                                 } else {
                                    class32.chatboxSegments[var6++] = var33.name;
                                 }
                                 continue;
                              }
                           } else if(var55 < 3200) {
                              if(var55 == 3100) {
                                 --var6;
                                 var89 = class32.chatboxSegments[var6];
                                 ChatLineBuffer.sendGameMessage(0, "", var89);
                                 continue;
                              }

                              if(var55 == 3101) {
                                 var5 -= 2;
                                 class13.method188(VertexNormal.localPlayer, class32.field716[var5], class32.field716[var5 + 1]);
                                 continue;
                              }

                              if(var55 == 3103) {
                                 class108.method2037();
                                 continue;
                              }

                              if(var55 == 3104) {
                                 --var6;
                                 var89 = class32.chatboxSegments[var6];
                                 var36 = 0;
                                 if(class163.method3149(var89)) {
                                    var36 = class221.method4058(var89);
                                 }

                                 Client.field321.method3195(181);
                                 Client.field321.method3057(var36);
                                 continue;
                              }

                              if(var55 == 3105) {
                                 --var6;
                                 var89 = class32.chatboxSegments[var6];
                                 Client.field321.method3195(186);
                                 Client.field321.method2912(var89.length() + 1);
                                 Client.field321.method3097(var89);
                                 continue;
                              }

                              if(var55 == 3106) {
                                 --var6;
                                 var89 = class32.chatboxSegments[var6];
                                 Client.field321.method3195(98);
                                 Client.field321.method2912(var89.length() + 1);
                                 Client.field321.method3097(var89);
                                 continue;
                              }

                              if(var55 == 3107) {
                                 --var5;
                                 var15 = class32.field716[var5];
                                 --var6;
                                 var58 = class32.chatboxSegments[var6];
                                 class109.method2045(var15, var58);
                                 continue;
                              }

                              if(var55 == 3108) {
                                 var5 -= 3;
                                 var15 = class32.field716[var5];
                                 var36 = class32.field716[var5 + 1];
                                 var17 = class32.field716[var5 + 2];
                                 var35 = class37.method759(var17);
                                 class25.method611(var35, var15, var36);
                                 continue;
                              }

                              if(var55 == 3109) {
                                 var5 -= 2;
                                 var15 = class32.field716[var5];
                                 var36 = class32.field716[1 + var5];
                                 var83 = var61?class32.field731:class174.field2623;
                                 class25.method611(var83, var15, var36);
                                 continue;
                              }

                              if(var55 == 3110) {
                                 --var5;
                                 class115.field1809 = class32.field716[var5] == 1;
                                 continue;
                              }

                              if(var55 == 3111) {
                                 class32.field716[var5++] = class85.field1456.field685?1:0;
                                 continue;
                              }

                              if(var55 == 3112) {
                                 --var5;
                                 class85.field1456.field685 = class32.field716[var5] == 1;
                                 class3.method39();
                                 continue;
                              }

                              if(var55 == 3113) {
                                 --var6;
                                 var89 = class32.chatboxSegments[var6];
                                 --var5;
                                 var91 = class32.field716[var5] == 1;
                                 if(!var91) {
                                    class11.method169(var89, 3, "openjs");
                                    continue;
                                 }

                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var89));
                                       continue;
                                    } catch (Exception var53) {
                                       ;
                                    }
                                 }

                                 if(class114.field1785.startsWith("win")) {
                                    class11.method169(var89, 0, "openjs");
                                 } else if(class114.field1785.startsWith("mac")) {
                                    class11.method169(var89, 1, "openjs");
                                 } else {
                                    class11.method169(var89, 2, "openjs");
                                 }
                                 continue;
                              }

                              if(var55 == 3115) {
                                 --var5;
                                 var15 = class32.field716[var5];
                                 Client.field321.method3195(80);
                                 Client.field321.method3094(var15);
                                 continue;
                              }

                              if(var55 == 3116) {
                                 --var5;
                                 var15 = class32.field716[var5];
                                 var6 -= 2;
                                 var58 = class32.chatboxSegments[var6];
                                 var34 = class32.chatboxSegments[1 + var6];
                                 if(var58.length() <= 500 && var34.length() <= 500) {
                                    Client.field321.method3195(172);
                                    Client.field321.method3094(1 + class105.method1999(var58) + class105.method1999(var34));
                                    Client.field321.method2951(var15);
                                    Client.field321.method3097(var34);
                                    Client.field321.method3097(var58);
                                 }
                                 continue;
                              }
                           } else if(var55 < 3300) {
                              if(var55 == 3200) {
                                 var5 -= 3;
                                 GroundObject.method1547(class32.field716[var5], class32.field716[var5 + 1], class32.field716[2 + var5]);
                                 continue;
                              }

                              if(var55 == 3201) {
                                 --var5;
                                 var15 = class32.field716[var5];
                                 if(var15 == -1 && !Client.field517) {
                                    class85.method1702();
                                 } else if(var15 != -1 && var15 != Client.field516 && Client.field515 != 0 && !Client.field517) {
                                    class22.method228(2, ChatMessages.field923, var15, 0, Client.field515, false);
                                 }

                                 Client.field516 = var15;
                                 continue;
                              }

                              if(var55 == 3202) {
                                 var5 -= 2;
                                 var15 = class32.field716[var5];
                                 int var10000 = class32.field716[var5 + 1];
                                 if(Client.field515 != 0 && var15 != -1) {
                                    class159.method2909(class11.field109, var15, 0, Client.field515, false);
                                    Client.field517 = true;
                                 }
                                 continue;
                              }
                           } else {
                              int var21;
                              int var22;
                              byte[] var96;
                              if(var55 < 3400) {
                                 if(var55 == 3300) {
                                    class32.field716[var5++] = Client.gameCycle;
                                    continue;
                                 }

                                 if(var55 == 3301) {
                                    var5 -= 2;
                                    var15 = class32.field716[var5];
                                    var36 = class32.field716[var5 + 1];
                                    class32.field716[var5++] = class9.method122(var15, var36);
                                    continue;
                                 }

                                 if(var55 == 3302) {
                                    var5 -= 2;
                                    var15 = class32.field716[var5];
                                    var36 = class32.field716[var5 + 1];
                                    class32.field716[var5++] = class177.method3261(var15, var36);
                                    continue;
                                 }

                                 XItemContainer var38;
                                 if(var55 == 3303) {
                                    var5 -= 2;
                                    var15 = class32.field716[var5];
                                    var36 = class32.field716[1 + var5];
                                    var84 = class32.field716;
                                    var18 = var5++;
                                    var38 = (XItemContainer)XItemContainer.itemContainers.method2331((long)var15);
                                    if(var38 == null) {
                                       var19 = 0;
                                    } else if(var36 == -1) {
                                       var19 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var38.stackSizes.length; ++var22) {
                                          if(var38.itemIds[var22] == var36) {
                                             var21 += var38.stackSizes[var22];
                                          }
                                       }

                                       var19 = var21;
                                    }

                                    var84[var18] = var19;
                                    continue;
                                 }

                                 if(var55 == 3304) {
                                    --var5;
                                    var15 = class32.field716[var5];
                                    var16 = class32.field716;
                                    var17 = var5++;
                                    class186 var37 = (class186)class186.field2749.get((long)var15);
                                    class186 var86;
                                    if(null != var37) {
                                       var86 = var37;
                                    } else {
                                       var96 = class186.field2750.getConfigData(5, var15);
                                       var37 = new class186();
                                       if(var96 != null) {
                                          var37.method3409(new Buffer(var96));
                                       }

                                       class186.field2749.put(var37, (long)var15);
                                       var86 = var37;
                                    }

                                    var16[var17] = var86.field2751;
                                    continue;
                                 }

                                 if(var55 == 3305) {
                                    --var5;
                                    var15 = class32.field716[var5];
                                    class32.field716[var5++] = Client.boostedSkillLevels[var15];
                                    continue;
                                 }

                                 if(var55 == 3306) {
                                    --var5;
                                    var15 = class32.field716[var5];
                                    class32.field716[var5++] = Client.realSkillLevels[var15];
                                    continue;
                                 }

                                 if(var55 == 3307) {
                                    --var5;
                                    var15 = class32.field716[var5];
                                    class32.field716[var5++] = Client.skillExperiences[var15];
                                    continue;
                                 }

                                 if(var55 == 3308) {
                                    var15 = class48.plane;
                                    var36 = (VertexNormal.localPlayer.x >> 7) + class114.baseX;
                                    var17 = (VertexNormal.localPlayer.y >> 7) + CombatInfo1.baseY;
                                    class32.field716[var5++] = var17 + (var15 << 28) + (var36 << 14);
                                    continue;
                                 }

                                 if(var55 == 3309) {
                                    --var5;
                                    var15 = class32.field716[var5];
                                    class32.field716[var5++] = var15 >> 14 & 16383;
                                    continue;
                                 }

                                 if(var55 == 3310) {
                                    --var5;
                                    var15 = class32.field716[var5];
                                    class32.field716[var5++] = var15 >> 28;
                                    continue;
                                 }

                                 if(var55 == 3311) {
                                    --var5;
                                    var15 = class32.field716[var5];
                                    class32.field716[var5++] = var15 & 16383;
                                    continue;
                                 }

                                 if(var55 == 3312) {
                                    class32.field716[var5++] = Client.isMembers?1:0;
                                    continue;
                                 }

                                 if(var55 == 3313) {
                                    var5 -= 2;
                                    var15 = '耀' + class32.field716[var5];
                                    var36 = class32.field716[1 + var5];
                                    class32.field716[var5++] = class9.method122(var15, var36);
                                    continue;
                                 }

                                 if(var55 == 3314) {
                                    var5 -= 2;
                                    var15 = '耀' + class32.field716[var5];
                                    var36 = class32.field716[1 + var5];
                                    class32.field716[var5++] = class177.method3261(var15, var36);
                                    continue;
                                 }

                                 if(var55 == 3315) {
                                    var5 -= 2;
                                    var15 = '耀' + class32.field716[var5];
                                    var36 = class32.field716[1 + var5];
                                    var84 = class32.field716;
                                    var18 = var5++;
                                    var38 = (XItemContainer)XItemContainer.itemContainers.method2331((long)var15);
                                    if(var38 == null) {
                                       var19 = 0;
                                    } else if(var36 == -1) {
                                       var19 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var38.stackSizes.length; ++var22) {
                                          if(var36 == var38.itemIds[var22]) {
                                             var21 += var38.stackSizes[var22];
                                          }
                                       }

                                       var19 = var21;
                                    }

                                    var84[var18] = var19;
                                    continue;
                                 }

                                 if(var55 == 3316) {
                                    if(Client.field396 >= 2) {
                                       class32.field716[var5++] = Client.field396;
                                    } else {
                                       class32.field716[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var55 == 3317) {
                                    class32.field716[var5++] = Client.field325;
                                    continue;
                                 }

                                 if(var55 == 3318) {
                                    class32.field716[var5++] = Client.world;
                                    continue;
                                 }

                                 if(var55 == 3321) {
                                    class32.field716[var5++] = Client.energy;
                                    continue;
                                 }

                                 if(var55 == 3322) {
                                    class32.field716[var5++] = Client.weight;
                                    continue;
                                 }

                                 if(var55 == 3323) {
                                    if(Client.field446) {
                                       class32.field716[var5++] = 1;
                                    } else {
                                       class32.field716[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var55 == 3324) {
                                    class32.field716[var5++] = Client.flags;
                                    continue;
                                 }
                              } else if(var55 < 3500) {
                                 if(var55 == 3400) {
                                    var5 -= 2;
                                    var15 = class32.field716[var5];
                                    var36 = class32.field716[1 + var5];
                                    class195 var85 = TextureProvider.method1464(var15);
                                    if(var85.field2841 != 115) {
                                       ;
                                    }

                                    for(var18 = 0; var18 < var85.field2843; ++var18) {
                                       if(var85.field2842[var18] == var36) {
                                          class32.chatboxSegments[var6++] = var85.field2846[var18];
                                          var85 = null;
                                          break;
                                       }
                                    }

                                    if(null != var85) {
                                       class32.chatboxSegments[var6++] = var85.field2847;
                                    }
                                    continue;
                                 }

                                 if(var55 == 3408) {
                                    var5 -= 4;
                                    var15 = class32.field716[var5];
                                    var36 = class32.field716[var5 + 1];
                                    var17 = class32.field716[var5 + 2];
                                    var18 = class32.field716[3 + var5];
                                    class195 var93 = TextureProvider.method1464(var17);
                                    if(var93.field2839 == var15 && var93.field2841 == var36) {
                                       for(var20 = 0; var20 < var93.field2843; ++var20) {
                                          if(var93.field2842[var20] == var18) {
                                             if(var36 == 115) {
                                                class32.chatboxSegments[var6++] = var93.field2846[var20];
                                             } else {
                                                class32.field716[var5++] = var93.field2844[var20];
                                             }

                                             var93 = null;
                                             break;
                                          }
                                       }

                                       if(null != var93) {
                                          if(var36 == 115) {
                                             class32.chatboxSegments[var6++] = var93.field2847;
                                          } else {
                                             class32.field716[var5++] = var93.field2837;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var36 == 115) {
                                       class32.chatboxSegments[var6++] = "null";
                                    } else {
                                       class32.field716[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var23;
                                 int var24;
                                 char var25;
                                 String var88;
                                 String var97;
                                 if(var55 < 3700) {
                                    if(var55 == 3600) {
                                       if(Client.field333 == 0) {
                                          class32.field716[var5++] = -2;
                                       } else if(Client.field333 == 1) {
                                          class32.field716[var5++] = -1;
                                       } else {
                                          class32.field716[var5++] = Client.friendCount;
                                       }
                                       continue;
                                    }

                                    if(var55 == 3601) {
                                       --var5;
                                       var15 = class32.field716[var5];
                                       if(Client.field333 == 2 && var15 < Client.friendCount) {
                                          class32.chatboxSegments[var6++] = Client.friends[var15].name;
                                          class32.chatboxSegments[var6++] = Client.friends[var15].previousName;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var55 == 3602) {
                                       --var5;
                                       var15 = class32.field716[var5];
                                       if(Client.field333 == 2 && var15 < Client.friendCount) {
                                          class32.field716[var5++] = Client.friends[var15].world;
                                          continue;
                                       }

                                       class32.field716[var5++] = 0;
                                       continue;
                                    }

                                    if(var55 == 3603) {
                                       --var5;
                                       var15 = class32.field716[var5];
                                       if(Client.field333 == 2 && var15 < Client.friendCount) {
                                          class32.field716[var5++] = Client.friends[var15].rank;
                                          continue;
                                       }

                                       class32.field716[var5++] = 0;
                                       continue;
                                    }

                                    if(var55 == 3604) {
                                       --var6;
                                       var89 = class32.chatboxSegments[var6];
                                       --var5;
                                       var36 = class32.field716[var5];
                                       Client.field321.method3195(2);
                                       Client.field321.method2912(class105.method1999(var89) + 1);
                                       Client.field321.method2952(var36);
                                       Client.field321.method3097(var89);
                                       continue;
                                    }

                                    Ignore var92;
                                    Friend var95;
                                    String var99;
                                    if(var55 == 3605) {
                                       --var6;
                                       var89 = class32.chatboxSegments[var6];
                                       if(null == var89) {
                                          continue;
                                       }

                                       if((Client.friendCount < 200 || Client.field503 == 1) && Client.friendCount < 400) {
                                          var58 = Overlay.method3751(var89, Client.field282);
                                          if(null == var58) {
                                             continue;
                                          }

                                          for(var17 = 0; var17 < Client.friendCount; ++var17) {
                                             var95 = Client.friends[var17];
                                             var97 = Overlay.method3751(var95.name, Client.field282);
                                             if(null != var97 && var97.equals(var58)) {
                                                ChatLineBuffer.sendGameMessage(30, "", var89 + " is already on your friend list");
                                                continue label3848;
                                             }

                                             if(null != var95.previousName) {
                                                var99 = Overlay.method3751(var95.previousName, Client.field282);
                                                if(var99 != null && var99.equals(var58)) {
                                                   ChatLineBuffer.sendGameMessage(30, "", var89 + " is already on your friend list");
                                                   continue label3848;
                                                }
                                             }
                                          }

                                          for(var17 = 0; var17 < Client.ignoreCount; ++var17) {
                                             var92 = Client.ignores[var17];
                                             var97 = Overlay.method3751(var92.name, Client.field282);
                                             if(var97 != null && var97.equals(var58)) {
                                                ChatLineBuffer.sendGameMessage(30, "", "Please remove " + var89 + " from your ignore list first");
                                                continue label3848;
                                             }

                                             if(var92.previousName != null) {
                                                var99 = Overlay.method3751(var92.previousName, Client.field282);
                                                if(var99 != null && var99.equals(var58)) {
                                                   ChatLineBuffer.sendGameMessage(30, "", "Please remove " + var89 + " from your ignore list first");
                                                   continue label3848;
                                                }
                                             }
                                          }

                                          if(Overlay.method3751(VertexNormal.localPlayer.name, Client.field282).equals(var58)) {
                                             ChatLineBuffer.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                          } else {
                                             Client.field321.method3195(118);
                                             Client.field321.method2912(class105.method1999(var89));
                                             Client.field321.method3097(var89);
                                          }
                                          continue;
                                       }

                                       ChatLineBuffer.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                       continue;
                                    }

                                    if(var55 == 3606) {
                                       --var6;
                                       var89 = class32.chatboxSegments[var6];
                                       Friend.method189(var89);
                                       continue;
                                    }

                                    if(var55 == 3607) {
                                       --var6;
                                       var89 = class32.chatboxSegments[var6];
                                       if(null == var89) {
                                          continue;
                                       }

                                       if((Client.ignoreCount < 100 || Client.field503 == 1) && Client.ignoreCount < 400) {
                                          var58 = Overlay.method3751(var89, Client.field282);
                                          if(var58 == null) {
                                             continue;
                                          }

                                          for(var17 = 0; var17 < Client.ignoreCount; ++var17) {
                                             var92 = Client.ignores[var17];
                                             var97 = Overlay.method3751(var92.name, Client.field282);
                                             if(var97 != null && var97.equals(var58)) {
                                                ChatLineBuffer.sendGameMessage(31, "", var89 + " is already on your ignore list");
                                                continue label3848;
                                             }

                                             if(var92.previousName != null) {
                                                var99 = Overlay.method3751(var92.previousName, Client.field282);
                                                if(null != var99 && var99.equals(var58)) {
                                                   ChatLineBuffer.sendGameMessage(31, "", var89 + " is already on your ignore list");
                                                   continue label3848;
                                                }
                                             }
                                          }

                                          for(var17 = 0; var17 < Client.friendCount; ++var17) {
                                             var95 = Client.friends[var17];
                                             var97 = Overlay.method3751(var95.name, Client.field282);
                                             if(var97 != null && var97.equals(var58)) {
                                                ChatLineBuffer.sendGameMessage(31, "", "Please remove " + var89 + " from your friend list first");
                                                continue label3848;
                                             }

                                             if(var95.previousName != null) {
                                                var99 = Overlay.method3751(var95.previousName, Client.field282);
                                                if(var99 != null && var99.equals(var58)) {
                                                   ChatLineBuffer.sendGameMessage(31, "", "Please remove " + var89 + " from your friend list first");
                                                   continue label3848;
                                                }
                                             }
                                          }

                                          if(Overlay.method3751(VertexNormal.localPlayer.name, Client.field282).equals(var58)) {
                                             ChatLineBuffer.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                          } else {
                                             Client.field321.method3195(157);
                                             Client.field321.method2912(class105.method1999(var89));
                                             Client.field321.method3097(var89);
                                          }
                                          continue;
                                       }

                                       ChatLineBuffer.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                       continue;
                                    }

                                    if(var55 == 3608) {
                                       --var6;
                                       var89 = class32.chatboxSegments[var6];
                                       if(null == var89) {
                                          continue;
                                       }

                                       var58 = Overlay.method3751(var89, Client.field282);
                                       if(null == var58) {
                                          continue;
                                       }

                                       var17 = 0;

                                       while(true) {
                                          if(var17 >= Client.ignoreCount) {
                                             continue label3848;
                                          }

                                          var92 = Client.ignores[var17];
                                          var97 = var92.name;
                                          var99 = Overlay.method3751(var97, Client.field282);
                                          boolean var63;
                                          if(var89 != null && var97 != null) {
                                             if(!var89.startsWith("#") && !var97.startsWith("#")) {
                                                var63 = var58.equals(var99);
                                             } else {
                                                var63 = var89.equals(var97);
                                             }
                                          } else {
                                             var63 = false;
                                          }

                                          if(var63) {
                                             --Client.ignoreCount;

                                             for(var22 = var17; var22 < Client.ignoreCount; ++var22) {
                                                Client.ignores[var22] = Client.ignores[1 + var22];
                                             }

                                             Client.field470 = Client.field462;
                                             Client.field321.method3195(132);
                                             Client.field321.method2912(class105.method1999(var89));
                                             Client.field321.method3097(var89);
                                             continue label3848;
                                          }

                                          ++var17;
                                       }
                                    }

                                    if(var55 == 3609) {
                                       --var6;
                                       var89 = class32.chatboxSegments[var6];
                                       class177[] var59 = class114.method2189();

                                       for(var17 = 0; var17 < var59.length; ++var17) {
                                          class177 var90 = var59[var17];
                                          if(var90.field2647 != -1 && var89.startsWith(class114.method2191(var90.field2647))) {
                                             var89 = var89.substring(6 + Integer.toString(var90.field2647).length());
                                             break;
                                          }
                                       }

                                       class32.field716[var5++] = class63.method1170(var89, false)?1:0;
                                       continue;
                                    }

                                    long var39;
                                    String var43;
                                    String[] var98;
                                    if(var55 == 3611) {
                                       if(null == Client.field299) {
                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       var98 = class32.chatboxSegments;
                                       var36 = var6++;
                                       var88 = Client.field299;
                                       var39 = 0L;
                                       var23 = var88.length();

                                       for(var24 = 0; var24 < var23; ++var24) {
                                          var39 *= 37L;
                                          var25 = var88.charAt(var24);
                                          if(var25 >= 65 && var25 <= 90) {
                                             var39 += (long)(1 + var25 - 65);
                                          } else if(var25 >= 97 && var25 <= 122) {
                                             var39 += (long)(var25 + 1 - 97);
                                          } else if(var25 >= 48 && var25 <= 57) {
                                             var39 += (long)(var25 + 27 - 48);
                                          }

                                          if(var39 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(var39 % 37L == 0L && var39 != 0L) {
                                          var39 /= 37L;
                                       }

                                       var43 = class151.method2837(var39);
                                       if(var43 == null) {
                                          var43 = "";
                                       }

                                       var98[var36] = var43;
                                       continue;
                                    }

                                    if(var55 == 3612) {
                                       if(Client.field299 != null) {
                                          class32.field716[var5++] = class72.clanChatCount;
                                       } else {
                                          class32.field716[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var55 == 3613) {
                                       --var5;
                                       var15 = class32.field716[var5];
                                       if(null != Client.field299 && var15 < class72.clanChatCount) {
                                          class32.chatboxSegments[var6++] = class85.clanMembers[var15].username;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var55 == 3614) {
                                       --var5;
                                       var15 = class32.field716[var5];
                                       if(null != Client.field299 && var15 < class72.clanChatCount) {
                                          class32.field716[var5++] = class85.clanMembers[var15].world;
                                          continue;
                                       }

                                       class32.field716[var5++] = 0;
                                       continue;
                                    }

                                    if(var55 == 3615) {
                                       --var5;
                                       var15 = class32.field716[var5];
                                       if(null != Client.field299 && var15 < class72.clanChatCount) {
                                          class32.field716[var5++] = class85.clanMembers[var15].rank;
                                          continue;
                                       }

                                       class32.field716[var5++] = 0;
                                       continue;
                                    }

                                    if(var55 == 3616) {
                                       class32.field716[var5++] = class166.field2291;
                                       continue;
                                    }

                                    if(var55 == 3617) {
                                       --var6;
                                       var89 = class32.chatboxSegments[var6];
                                       GameObject.method1909(var89);
                                       continue;
                                    }

                                    if(var55 == 3618) {
                                       class32.field716[var5++] = Buffer.field2265;
                                       continue;
                                    }

                                    if(var55 == 3619) {
                                       --var6;
                                       var89 = class32.chatboxSegments[var6];
                                       class48.method893(var89);
                                       continue;
                                    }

                                    if(var55 == 3620) {
                                       class162.method3139();
                                       continue;
                                    }

                                    if(var55 == 3621) {
                                       if(Client.field333 == 0) {
                                          class32.field716[var5++] = -1;
                                       } else {
                                          class32.field716[var5++] = Client.ignoreCount;
                                       }
                                       continue;
                                    }

                                    if(var55 == 3622) {
                                       --var5;
                                       var15 = class32.field716[var5];
                                       if(Client.field333 != 0 && var15 < Client.ignoreCount) {
                                          class32.chatboxSegments[var6++] = Client.ignores[var15].name;
                                          class32.chatboxSegments[var6++] = Client.ignores[var15].previousName;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var55 == 3623) {
                                       --var6;
                                       var89 = class32.chatboxSegments[var6];
                                       if(var89.startsWith(class114.method2191(0)) || var89.startsWith(class114.method2191(1))) {
                                          var89 = var89.substring(7);
                                       }

                                       class32.field716[var5++] = class1.method20(var89)?1:0;
                                       continue;
                                    }

                                    if(var55 == 3624) {
                                       --var5;
                                       var15 = class32.field716[var5];
                                       if(null != class85.clanMembers && var15 < class72.clanChatCount && class85.clanMembers[var15].username.equalsIgnoreCase(VertexNormal.localPlayer.name)) {
                                          class32.field716[var5++] = 1;
                                          continue;
                                       }

                                       class32.field716[var5++] = 0;
                                       continue;
                                    }

                                    if(var55 == 3625) {
                                       if(null == Client.clanChatOwner) {
                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       var98 = class32.chatboxSegments;
                                       var36 = var6++;
                                       var88 = Client.clanChatOwner;
                                       var39 = 0L;
                                       var23 = var88.length();

                                       for(var24 = 0; var24 < var23; ++var24) {
                                          var39 *= 37L;
                                          var25 = var88.charAt(var24);
                                          if(var25 >= 65 && var25 <= 90) {
                                             var39 += (long)(1 + var25 - 65);
                                          } else if(var25 >= 97 && var25 <= 122) {
                                             var39 += (long)(1 + var25 - 97);
                                          } else if(var25 >= 48 && var25 <= 57) {
                                             var39 += (long)(27 + var25 - 48);
                                          }

                                          if(var39 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(var39 % 37L == 0L && var39 != 0L) {
                                          var39 /= 37L;
                                       }

                                       var43 = class151.method2837(var39);
                                       if(null == var43) {
                                          var43 = "";
                                       }

                                       var98[var36] = var43;
                                       continue;
                                    }
                                 } else {
                                    long var44;
                                    if(var55 < 4000) {
                                       if(var55 == 3903) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = Client.grandExchangeOffers[var15].method51();
                                          continue;
                                       }

                                       if(var55 == 3904) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = Client.grandExchangeOffers[var15].itemId;
                                          continue;
                                       }

                                       if(var55 == 3905) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = Client.grandExchangeOffers[var15].price;
                                          continue;
                                       }

                                       if(var55 == 3906) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = Client.grandExchangeOffers[var15].totalQuantity;
                                          continue;
                                       }

                                       if(var55 == 3907) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = Client.grandExchangeOffers[var15].quantitySold;
                                          continue;
                                       }

                                       if(var55 == 3908) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = Client.grandExchangeOffers[var15].spent;
                                          continue;
                                       }

                                       if(var55 == 3910) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var36 = Client.grandExchangeOffers[var15].method62();
                                          class32.field716[var5++] = var36 == 0?1:0;
                                          continue;
                                       }

                                       if(var55 == 3911) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var36 = Client.grandExchangeOffers[var15].method62();
                                          class32.field716[var5++] = var36 == 2?1:0;
                                          continue;
                                       }

                                       if(var55 == 3912) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var36 = Client.grandExchangeOffers[var15].method62();
                                          class32.field716[var5++] = var36 == 5?1:0;
                                          continue;
                                       }

                                       if(var55 == 3913) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var36 = Client.grandExchangeOffers[var15].method62();
                                          class32.field716[var5++] = var36 == 1?1:0;
                                          continue;
                                       }

                                       boolean var74;
                                       if(var55 == 3914) {
                                          --var5;
                                          var74 = class32.field716[var5] == 1;
                                          if(class26.field576 != null) {
                                             class26.field576.method15(class1.field8, var74);
                                          }
                                          continue;
                                       }

                                       if(var55 == 3915) {
                                          --var5;
                                          var74 = class32.field716[var5] == 1;
                                          if(null != class26.field576) {
                                             class26.field576.method15(class1.field7, var74);
                                          }
                                          continue;
                                       }

                                       if(var55 == 3916) {
                                          var5 -= 2;
                                          var74 = class32.field716[var5] == 1;
                                          var91 = class32.field716[1 + var5] == 1;
                                          if(class26.field576 != null) {
                                             class26.field576.method15(new class44(var91), var74);
                                          }
                                          continue;
                                       }

                                       if(var55 == 3917) {
                                          --var5;
                                          var74 = class32.field716[var5] == 1;
                                          if(null != class26.field576) {
                                             class26.field576.method15(class1.field6, var74);
                                          }
                                          continue;
                                       }

                                       if(var55 == 3918) {
                                          --var5;
                                          var74 = class32.field716[var5] == 1;
                                          if(null != class26.field576) {
                                             class26.field576.method15(class1.field14, var74);
                                          }
                                          continue;
                                       }

                                       if(var55 == 3919) {
                                          class32.field716[var5++] = class26.field576 == null?0:class26.field576.field19.size();
                                          continue;
                                       }

                                       class2 var60;
                                       if(var55 == 3920) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var60 = (class2)class26.field576.field19.get(var15);
                                          class32.field716[var5++] = var60.field23;
                                          continue;
                                       }

                                       if(var55 == 3921) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var60 = (class2)class26.field576.field19.get(var15);
                                          class32.chatboxSegments[var6++] = var60.method22();
                                          continue;
                                       }

                                       if(var55 == 3922) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var60 = (class2)class26.field576.field19.get(var15);
                                          class32.chatboxSegments[var6++] = var60.method26();
                                          continue;
                                       }

                                       if(var55 == 3923) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var60 = (class2)class26.field576.field19.get(var15);
                                          var44 = class22.method224() - class139.field1946 - var60.field21;
                                          var19 = (int)(var44 / 3600000L);
                                          var20 = (int)((var44 - (long)(3600000 * var19)) / 60000L);
                                          var21 = (int)((var44 - (long)(3600000 * var19) - (long)('\uea60' * var20)) / 1000L);
                                          String var46 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var21 / 10 + var21 % 10;
                                          class32.chatboxSegments[var6++] = var46;
                                          continue;
                                       }

                                       if(var55 == 3924) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var60 = (class2)class26.field576.field19.get(var15);
                                          class32.field716[var5++] = var60.field22.totalQuantity;
                                          continue;
                                       }

                                       if(var55 == 3925) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var60 = (class2)class26.field576.field19.get(var15);
                                          class32.field716[var5++] = var60.field22.price;
                                          continue;
                                       }

                                       if(var55 == 3926) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var60 = (class2)class26.field576.field19.get(var15);
                                          class32.field716[var5++] = var60.field22.itemId;
                                          continue;
                                       }
                                    } else if(var55 < 4100) {
                                       if(var55 == 4000) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[1 + var5];
                                          class32.field716[var5++] = var15 + var36;
                                          continue;
                                       }

                                       if(var55 == 4001) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          class32.field716[var5++] = var15 - var36;
                                          continue;
                                       }

                                       if(var55 == 4002) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[1 + var5];
                                          class32.field716[var5++] = var36 * var15;
                                          continue;
                                       }

                                       if(var55 == 4003) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          class32.field716[var5++] = var15 / var36;
                                          continue;
                                       }

                                       if(var55 == 4004) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = (int)(Math.random() * (double)var15);
                                          continue;
                                       }

                                       if(var55 == 4005) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = (int)(Math.random() * (double)(1 + var15));
                                          continue;
                                       }

                                       if(var55 == 4006) {
                                          var5 -= 5;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          var17 = class32.field716[2 + var5];
                                          var18 = class32.field716[var5 + 3];
                                          var19 = class32.field716[var5 + 4];
                                          class32.field716[var5++] = var15 + (var36 - var15) * (var19 - var17) / (var18 - var17);
                                          continue;
                                       }

                                       if(var55 == 4007) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          class32.field716[var5++] = var15 + var15 * var36 / 100;
                                          continue;
                                       }

                                       if(var55 == 4008) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[1 + var5];
                                          class32.field716[var5++] = var15 | 1 << var36;
                                          continue;
                                       }

                                       if(var55 == 4009) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[1 + var5];
                                          class32.field716[var5++] = var15 & -1 - (1 << var36);
                                          continue;
                                       }

                                       if(var55 == 4010) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          class32.field716[var5++] = (var15 & 1 << var36) != 0?1:0;
                                          continue;
                                       }

                                       if(var55 == 4011) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          class32.field716[var5++] = var15 % var36;
                                          continue;
                                       }

                                       if(var55 == 4012) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[1 + var5];
                                          if(var15 == 0) {
                                             class32.field716[var5++] = 0;
                                          } else {
                                             class32.field716[var5++] = (int)Math.pow((double)var15, (double)var36);
                                          }
                                          continue;
                                       }

                                       if(var55 == 4013) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[1 + var5];
                                          if(var15 == 0) {
                                             class32.field716[var5++] = 0;
                                          } else if(var36 == 0) {
                                             class32.field716[var5++] = Integer.MAX_VALUE;
                                          } else {
                                             class32.field716[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var36);
                                          }
                                          continue;
                                       }

                                       if(var55 == 4014) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          class32.field716[var5++] = var15 & var36;
                                          continue;
                                       }

                                       if(var55 == 4015) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          class32.field716[var5++] = var15 | var36;
                                          continue;
                                       }

                                       if(var55 == 4018) {
                                          var5 -= 3;
                                          long var47 = (long)class32.field716[var5];
                                          var44 = (long)class32.field716[1 + var5];
                                          long var41 = (long)class32.field716[var5 + 2];
                                          class32.field716[var5++] = (int)(var47 * var41 / var44);
                                          continue;
                                       }
                                    } else if(var55 < 4200) {
                                       if(var55 == 4100) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          --var5;
                                          var36 = class32.field716[var5];
                                          class32.chatboxSegments[var6++] = var89 + var36;
                                          continue;
                                       }

                                       if(var55 == 4101) {
                                          var6 -= 2;
                                          var89 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[var6 + 1];
                                          class32.chatboxSegments[var6++] = var89 + var58;
                                          continue;
                                       }

                                       if(var55 == 4102) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          --var5;
                                          var36 = class32.field716[var5];
                                          class32.chatboxSegments[var6++] = var89 + Ignore.method206(var36, true);
                                          continue;
                                       }

                                       if(var55 == 4103) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          class32.chatboxSegments[var6++] = var89.toLowerCase();
                                          continue;
                                       }

                                       if(var55 == 4104) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          long var49 = 86400000L * ((long)var15 + 11745L);
                                          class32.field711.setTime(new Date(var49));
                                          var18 = class32.field711.get(5);
                                          var19 = class32.field711.get(2);
                                          var20 = class32.field711.get(1);
                                          class32.chatboxSegments[var6++] = var18 + "-" + class32.field722[var19] + "-" + var20;
                                          continue;
                                       }

                                       if(var55 == 4105) {
                                          var6 -= 2;
                                          var89 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[1 + var6];
                                          if(VertexNormal.localPlayer.composition != null && VertexNormal.localPlayer.composition.isFemale) {
                                             class32.chatboxSegments[var6++] = var58;
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = var89;
                                          continue;
                                       }

                                       if(var55 == 4106) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.chatboxSegments[var6++] = Integer.toString(var15);
                                          continue;
                                       }

                                       if(var55 == 4107) {
                                          var6 -= 2;
                                          var109 = class32.field716;
                                          var36 = var5++;
                                          var88 = class32.chatboxSegments[var6];
                                          var97 = class32.chatboxSegments[var6 + 1];
                                          var20 = Client.field285;
                                          var21 = var88.length();
                                          var22 = var97.length();
                                          var23 = 0;
                                          var24 = 0;
                                          var25 = 0;
                                          char var26 = 0;

                                          label3646:
                                          while(true) {
                                             if(var23 - var25 >= var21 && var24 - var26 >= var22) {
                                                int var75 = Math.min(var21, var22);

                                                char var30;
                                                int var77;
                                                for(var77 = 0; var77 < var75; ++var77) {
                                                   char var29 = var88.charAt(var77);
                                                   var30 = var97.charAt(var77);
                                                   if(var30 != var29 && Character.toUpperCase(var29) != Character.toUpperCase(var30)) {
                                                      var29 = Character.toLowerCase(var29);
                                                      var30 = Character.toLowerCase(var30);
                                                      if(var30 != var29) {
                                                         var17 = class115.method2195(var29, var20) - class115.method2195(var30, var20);
                                                         break label3646;
                                                      }
                                                   }
                                                }

                                                var77 = var21 - var22;
                                                if(var77 != 0) {
                                                   var17 = var77;
                                                } else {
                                                   for(int var78 = 0; var78 < var75; ++var78) {
                                                      var30 = var88.charAt(var78);
                                                      char var31 = var97.charAt(var78);
                                                      if(var30 != var31) {
                                                         var17 = class115.method2195(var30, var20) - class115.method2195(var31, var20);
                                                         break label3646;
                                                      }
                                                   }

                                                   var17 = 0;
                                                }
                                                break;
                                             }

                                             if(var23 - var25 >= var21) {
                                                var17 = -1;
                                                break;
                                             }

                                             if(var24 - var26 >= var22) {
                                                var17 = 1;
                                                break;
                                             }

                                             char var27;
                                             if(var25 != 0) {
                                                var27 = var25;
                                                boolean var71 = false;
                                             } else {
                                                var27 = var88.charAt(var23++);
                                             }

                                             char var28;
                                             if(var26 != 0) {
                                                var28 = var26;
                                                boolean var72 = false;
                                             } else {
                                                var28 = var97.charAt(var24++);
                                             }

                                             var25 = class8.method116(var27);
                                             var26 = class8.method116(var28);
                                             var27 = class15.method195(var27, var20);
                                             var28 = class15.method195(var28, var20);
                                             if(var28 != var27 && Character.toUpperCase(var27) != Character.toUpperCase(var28)) {
                                                var27 = Character.toLowerCase(var27);
                                                var28 = Character.toLowerCase(var28);
                                                if(var27 != var28) {
                                                   var17 = class115.method2195(var27, var20) - class115.method2195(var28, var20);
                                                   break;
                                                }
                                             }
                                          }

                                          var109[var36] = class172.method3250(var17);
                                          continue;
                                       }

                                       byte[] var100;
                                       Font var104;
                                       if(var55 == 4108) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var36 = class32.field716[var5];
                                          var17 = class32.field716[1 + var5];
                                          var100 = class25.field574.getConfigData(var17, 0);
                                          var104 = new Font(var100);
                                          class32.field716[var5++] = var104.method3869(var89, var36);
                                          continue;
                                       }

                                       if(var55 == 4109) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var36 = class32.field716[var5];
                                          var17 = class32.field716[1 + var5];
                                          var100 = class25.field574.getConfigData(var17, 0);
                                          var104 = new Font(var100);
                                          class32.field716[var5++] = var104.method3868(var89, var36);
                                          continue;
                                       }

                                       if(var55 == 4110) {
                                          var6 -= 2;
                                          var89 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[var6 + 1];
                                          --var5;
                                          if(class32.field716[var5] == 1) {
                                             class32.chatboxSegments[var6++] = var89;
                                          } else {
                                             class32.chatboxSegments[var6++] = var58;
                                          }
                                          continue;
                                       }

                                       if(var55 == 4111) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          class32.chatboxSegments[var6++] = FontTypeFace.method3937(var89);
                                          continue;
                                       }

                                       if(var55 == 4112) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          --var5;
                                          var36 = class32.field716[var5];
                                          class32.chatboxSegments[var6++] = var89 + (char)var36;
                                          continue;
                                       }

                                       char var65;
                                       if(var55 == 4113) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var16 = class32.field716;
                                          var17 = var5++;
                                          var65 = (char)var15;
                                          if(var65 >= 32 && var65 <= 126) {
                                             var62 = true;
                                          } else if(var65 >= 160 && var65 <= 255) {
                                             var62 = true;
                                          } else if(var65 != 8364 && var65 != 338 && var65 != 8212 && var65 != 339 && var65 != 376) {
                                             var62 = false;
                                          } else {
                                             var62 = true;
                                          }

                                          var16[var17] = var62?1:0;
                                          continue;
                                       }

                                       if(var55 == 4114) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = class20.method213((char)var15)?1:0;
                                          continue;
                                       }

                                       if(var55 == 4115) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var16 = class32.field716;
                                          var17 = var5++;
                                          var65 = (char)var15;
                                          var62 = var65 >= 65 && var65 <= 90 || var65 >= 97 && var65 <= 122;
                                          var16[var17] = var62?1:0;
                                          continue;
                                       }

                                       if(var55 == 4116) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = RSCanvas.method2075((char)var15)?1:0;
                                          continue;
                                       }

                                       if(var55 == 4117) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          if(null != var89) {
                                             class32.field716[var5++] = var89.length();
                                          } else {
                                             class32.field716[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var55 == 4118) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var36 = class32.field716[var5];
                                          var17 = class32.field716[1 + var5];
                                          class32.chatboxSegments[var6++] = var89.substring(var36, var17);
                                          continue;
                                       }

                                       if(var55 == 4119) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          StringBuilder var64 = new StringBuilder(var89.length());
                                          var67 = false;

                                          for(var18 = 0; var18 < var89.length(); ++var18) {
                                             var65 = var89.charAt(var18);
                                             if(var65 == 60) {
                                                var67 = true;
                                             } else if(var65 == 62) {
                                                var67 = false;
                                             } else if(!var67) {
                                                var64.append(var65);
                                             }
                                          }

                                          class32.chatboxSegments[var6++] = var64.toString();
                                          continue;
                                       }

                                       if(var55 == 4120) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          --var5;
                                          var36 = class32.field716[var5];
                                          class32.field716[var5++] = var89.indexOf(var36);
                                          continue;
                                       }

                                       if(var55 == 4121) {
                                          var6 -= 2;
                                          var89 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[1 + var6];
                                          --var5;
                                          var17 = class32.field716[var5];
                                          class32.field716[var5++] = var89.indexOf(var58, var17);
                                          continue;
                                       }
                                    } else if(var55 < 4300) {
                                       if(var55 == 4200) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.chatboxSegments[var6++] = PlayerComposition.getItemDefinition(var15).name;
                                          continue;
                                       }

                                       ItemComposition var87;
                                       if(var55 == 4201) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          var87 = PlayerComposition.getItemDefinition(var15);
                                          if(var36 >= 1 && var36 <= 5 && null != var87.groundActions[var36 - 1]) {
                                             class32.chatboxSegments[var6++] = var87.groundActions[var36 - 1];
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var55 == 4202) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          var87 = PlayerComposition.getItemDefinition(var15);
                                          if(var36 >= 1 && var36 <= 5 && var87.inventoryActions[var36 - 1] != null) {
                                             class32.chatboxSegments[var6++] = var87.inventoryActions[var36 - 1];
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var55 == 4203) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = PlayerComposition.getItemDefinition(var15).price;
                                          continue;
                                       }

                                       if(var55 == 4204) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = PlayerComposition.getItemDefinition(var15).isStackable == 1?1:0;
                                          continue;
                                       }

                                       ItemComposition var68;
                                       if(var55 == 4205) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var68 = PlayerComposition.getItemDefinition(var15);
                                          if(var68.notedTemplate == -1 && var68.note >= 0) {
                                             class32.field716[var5++] = var68.note;
                                             continue;
                                          }

                                          class32.field716[var5++] = var15;
                                          continue;
                                       }

                                       if(var55 == 4206) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var68 = PlayerComposition.getItemDefinition(var15);
                                          if(var68.notedTemplate >= 0 && var68.note >= 0) {
                                             class32.field716[var5++] = var68.note;
                                             continue;
                                          }

                                          class32.field716[var5++] = var15;
                                          continue;
                                       }

                                       if(var55 == 4207) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = PlayerComposition.getItemDefinition(var15).isMembers?1:0;
                                          continue;
                                       }

                                       if(var55 == 4208) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var68 = PlayerComposition.getItemDefinition(var15);
                                          if(var68.field2952 == -1 && var68.field2978 >= 0) {
                                             class32.field716[var5++] = var68.field2978;
                                             continue;
                                          }

                                          class32.field716[var5++] = var15;
                                          continue;
                                       }

                                       if(var55 == 4209) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          var68 = PlayerComposition.getItemDefinition(var15);
                                          if(var68.field2952 >= 0 && var68.field2978 >= 0) {
                                             class32.field716[var5++] = var68.field2978;
                                             continue;
                                          }

                                          class32.field716[var5++] = var15;
                                          continue;
                                       }

                                       if(var55 == 4210) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          --var5;
                                          var36 = class32.field716[var5];
                                          class115.method2213(var89, var36 == 1);
                                          class32.field716[var5++] = class162.field2279;
                                          continue;
                                       }

                                       if(var55 == 4211) {
                                          if(Renderable.field1544 != null && class15.field162 < class162.field2279) {
                                             class32.field716[var5++] = Renderable.field1544[++class15.field162 - 1] & '\uffff';
                                             continue;
                                          }

                                          class32.field716[var5++] = -1;
                                          continue;
                                       }

                                       if(var55 == 4212) {
                                          class15.field162 = 0;
                                          continue;
                                       }
                                    } else if(var55 < 5100) {
                                       if(var55 == 5000) {
                                          class32.field716[var5++] = Client.field495;
                                          continue;
                                       }

                                       if(var55 == 5001) {
                                          var5 -= 3;
                                          Client.field495 = class32.field716[var5];
                                          class112.field1760 = RSCanvas.method2072(class32.field716[1 + var5]);
                                          if(class112.field1760 == null) {
                                             class112.field1760 = class216.field3156;
                                          }

                                          Client.field496 = class32.field716[var5 + 2];
                                          Client.field321.method3195(61);
                                          Client.field321.method2912(Client.field495);
                                          Client.field321.method2912(class112.field1760.field3158);
                                          Client.field321.method2912(Client.field496);
                                          continue;
                                       }

                                       if(var55 == 5002) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var36 = class32.field716[var5];
                                          var17 = class32.field716[1 + var5];
                                          Client.field321.method3195(171);
                                          Client.field321.method2912(class105.method1999(var89) + 2);
                                          Client.field321.method3097(var89);
                                          Client.field321.method2912(var36 - 1);
                                          Client.field321.method2912(var17);
                                          continue;
                                       }

                                       if(var55 == 5003) {
                                          var5 -= 2;
                                          var15 = class32.field716[var5];
                                          var36 = class32.field716[var5 + 1];
                                          ChatLineBuffer var102 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var15));
                                          MessageNode var94 = var102.method905(var36);
                                          if(null != var94) {
                                             class32.field716[var5++] = var94.id;
                                             class32.field716[var5++] = var94.tick;
                                             class32.chatboxSegments[var6++] = null != var94.name?var94.name:"";
                                             class32.chatboxSegments[var6++] = null != var94.sender?var94.sender:"";
                                             class32.chatboxSegments[var6++] = null != var94.value?var94.value:"";
                                          } else {
                                             class32.field716[var5++] = -1;
                                             class32.field716[var5++] = 0;
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var55 == 5004) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          MessageNode var70 = (MessageNode)class47.field925.method2297((long)var15);
                                          if(var70 != null) {
                                             class32.field716[var5++] = var70.type;
                                             class32.field716[var5++] = var70.tick;
                                             class32.chatboxSegments[var6++] = null != var70.name?var70.name:"";
                                             class32.chatboxSegments[var6++] = null != var70.sender?var70.sender:"";
                                             class32.chatboxSegments[var6++] = null != var70.value?var70.value:"";
                                          } else {
                                             class32.field716[var5++] = -1;
                                             class32.field716[var5++] = 0;
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var55 == 5005) {
                                          if(null == class112.field1760) {
                                             class32.field716[var5++] = -1;
                                          } else {
                                             class32.field716[var5++] = class112.field1760.field3158;
                                          }
                                          continue;
                                       }

                                       if(var55 == 5008) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          --var5;
                                          var36 = class32.field716[var5];
                                          var34 = var89.toLowerCase();
                                          byte var66 = 0;
                                          if(var34.startsWith("yellow:")) {
                                             var66 = 0;
                                             var89 = var89.substring("yellow:".length());
                                          } else if(var34.startsWith("red:")) {
                                             var66 = 1;
                                             var89 = var89.substring("red:".length());
                                          } else if(var34.startsWith("green:")) {
                                             var66 = 2;
                                             var89 = var89.substring("green:".length());
                                          } else if(var34.startsWith("cyan:")) {
                                             var66 = 3;
                                             var89 = var89.substring("cyan:".length());
                                          } else if(var34.startsWith("purple:")) {
                                             var66 = 4;
                                             var89 = var89.substring("purple:".length());
                                          } else if(var34.startsWith("white:")) {
                                             var66 = 5;
                                             var89 = var89.substring("white:".length());
                                          } else if(var34.startsWith("flash1:")) {
                                             var66 = 6;
                                             var89 = var89.substring("flash1:".length());
                                          } else if(var34.startsWith("flash2:")) {
                                             var66 = 7;
                                             var89 = var89.substring("flash2:".length());
                                          } else if(var34.startsWith("flash3:")) {
                                             var66 = 8;
                                             var89 = var89.substring("flash3:".length());
                                          } else if(var34.startsWith("glow1:")) {
                                             var66 = 9;
                                             var89 = var89.substring("glow1:".length());
                                          } else if(var34.startsWith("glow2:")) {
                                             var66 = 10;
                                             var89 = var89.substring("glow2:".length());
                                          } else if(var34.startsWith("glow3:")) {
                                             var66 = 11;
                                             var89 = var89.substring("glow3:".length());
                                          } else if(Client.field285 != 0) {
                                             if(var34.startsWith("yellow:")) {
                                                var66 = 0;
                                                var89 = var89.substring("yellow:".length());
                                             } else if(var34.startsWith("red:")) {
                                                var66 = 1;
                                                var89 = var89.substring("red:".length());
                                             } else if(var34.startsWith("green:")) {
                                                var66 = 2;
                                                var89 = var89.substring("green:".length());
                                             } else if(var34.startsWith("cyan:")) {
                                                var66 = 3;
                                                var89 = var89.substring("cyan:".length());
                                             } else if(var34.startsWith("purple:")) {
                                                var66 = 4;
                                                var89 = var89.substring("purple:".length());
                                             } else if(var34.startsWith("white:")) {
                                                var66 = 5;
                                                var89 = var89.substring("white:".length());
                                             } else if(var34.startsWith("flash1:")) {
                                                var66 = 6;
                                                var89 = var89.substring("flash1:".length());
                                             } else if(var34.startsWith("flash2:")) {
                                                var66 = 7;
                                                var89 = var89.substring("flash2:".length());
                                             } else if(var34.startsWith("flash3:")) {
                                                var66 = 8;
                                                var89 = var89.substring("flash3:".length());
                                             } else if(var34.startsWith("glow1:")) {
                                                var66 = 9;
                                                var89 = var89.substring("glow1:".length());
                                             } else if(var34.startsWith("glow2:")) {
                                                var66 = 10;
                                                var89 = var89.substring("glow2:".length());
                                             } else if(var34.startsWith("glow3:")) {
                                                var66 = 11;
                                                var89 = var89.substring("glow3:".length());
                                             }
                                          }

                                          var34 = var89.toLowerCase();
                                          byte var69 = 0;
                                          if(var34.startsWith("wave:")) {
                                             var69 = 1;
                                             var89 = var89.substring("wave:".length());
                                          } else if(var34.startsWith("wave2:")) {
                                             var69 = 2;
                                             var89 = var89.substring("wave2:".length());
                                          } else if(var34.startsWith("shake:")) {
                                             var69 = 3;
                                             var89 = var89.substring("shake:".length());
                                          } else if(var34.startsWith("scroll:")) {
                                             var69 = 4;
                                             var89 = var89.substring("scroll:".length());
                                          } else if(var34.startsWith("slide:")) {
                                             var69 = 5;
                                             var89 = var89.substring("slide:".length());
                                          } else if(Client.field285 != 0) {
                                             if(var34.startsWith("wave:")) {
                                                var69 = 1;
                                                var89 = var89.substring("wave:".length());
                                             } else if(var34.startsWith("wave2:")) {
                                                var69 = 2;
                                                var89 = var89.substring("wave2:".length());
                                             } else if(var34.startsWith("shake:")) {
                                                var69 = 3;
                                                var89 = var89.substring("shake:".length());
                                             } else if(var34.startsWith("scroll:")) {
                                                var69 = 4;
                                                var89 = var89.substring("scroll:".length());
                                             } else if(var34.startsWith("slide:")) {
                                                var69 = 5;
                                                var89 = var89.substring("slide:".length());
                                             }
                                          }

                                          Client.field321.method3195(189);
                                          Client.field321.method2912(0);
                                          var20 = Client.field321.offset;
                                          Client.field321.method2912(var36);
                                          Client.field321.method2912(var66);
                                          Client.field321.method2912(var69);
                                          WallObject.method1884(Client.field321, var89);
                                          Client.field321.method2924(Client.field321.offset - var20);
                                          continue;
                                       }

                                       if(var55 == 5009) {
                                          var6 -= 2;
                                          var89 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[var6 + 1];
                                          Client.field321.method3195(226);
                                          Client.field321.method3094(0);
                                          var17 = Client.field321.offset;
                                          Client.field321.method3097(var89);
                                          class166 var101 = Client.field321;
                                          var19 = var101.offset;
                                          var96 = class63.method1174(var58);
                                          var101.method2925(var96.length);
                                          var101.offset += class210.field3110.method2851(var96, 0, var96.length, var101.payload, var101.offset);
                                          Client.field321.method3056(Client.field321.offset - var17);
                                          continue;
                                       }

                                       if(var55 == 5015) {
                                          if(null != VertexNormal.localPlayer && null != VertexNormal.localPlayer.name) {
                                             var89 = VertexNormal.localPlayer.name;
                                          } else {
                                             var89 = "";
                                          }

                                          class32.chatboxSegments[var6++] = var89;
                                          continue;
                                       }

                                       if(var55 == 5016) {
                                          class32.field716[var5++] = Client.field496;
                                          continue;
                                       }

                                       if(var55 == 5017) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = FrameMap.method1703(var15);
                                          continue;
                                       }

                                       if(var55 == 5018) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = class36.method749(var15);
                                          continue;
                                       }

                                       if(var55 == 5019) {
                                          --var5;
                                          var15 = class32.field716[var5];
                                          class32.field716[var5++] = class7.method103(var15);
                                          continue;
                                       }

                                       if(var55 == 5020) {
                                          --var6;
                                          var89 = class32.chatboxSegments[var6];
                                          if(var89.equalsIgnoreCase("toggleroof")) {
                                             class85.field1456.field685 = !class85.field1456.field685;
                                             class3.method39();
                                             if(class85.field1456.field685) {
                                                ChatLineBuffer.sendGameMessage(99, "", "Roofs are now all hidden");
                                             } else {
                                                ChatLineBuffer.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                             }
                                          }

                                          if(var89.equalsIgnoreCase("displayfps")) {
                                             Client.field441 = !Client.field441;
                                          }

                                          if(Client.field396 >= 2) {
                                             if(var89.equalsIgnoreCase("fpson")) {
                                                Client.field441 = true;
                                             }

                                             if(var89.equalsIgnoreCase("fpsoff")) {
                                                Client.field441 = false;
                                             }

                                             if(var89.equalsIgnoreCase("gc")) {
                                                System.gc();
                                             }

                                             if(var89.equalsIgnoreCase("clientdrop")) {
                                                class1.method16();
                                             }

                                             if(var89.equalsIgnoreCase("errortest") && Client.field281 == 2) {
                                                throw new RuntimeException();
                                             }
                                          }

                                          Client.field321.method3195(250);
                                          Client.field321.method2912(var89.length() + 1);
                                          Client.field321.method3097(var89);
                                          continue;
                                       }

                                       if(var55 == 5021) {
                                          --var6;
                                          Client.field559 = class32.chatboxSegments[var6].toLowerCase().trim();
                                          continue;
                                       }

                                       if(var55 == 5022) {
                                          class32.chatboxSegments[var6++] = Client.field559;
                                          continue;
                                       }
                                    }
                                 }
                              }
                           }
                        } else {
                           if(var55 >= 2000) {
                              var55 -= 1000;
                              --var5;
                              var33 = class37.method759(class32.field716[var5]);
                           } else {
                              var33 = var61?class32.field731:class174.field2623;
                           }

                           if(var55 == 1927) {
                              if(class32.field723 >= 10) {
                                 throw new RuntimeException();
                              }

                              if(null == var33.field2158) {
                                 return;
                              }

                              class18 var56 = new class18();
                              var56.field190 = var33;
                              var56.field198 = var33.field2158;
                              var56.field197 = 1 + class32.field723;
                              Client.field476.method2380(var0);
                              continue;
                           }
                        }
                     }
                  }
               }

               if(var55 < 5400) {
                  if(var55 == 5306) {
                     var109 = class32.field716;
                     var36 = var5++;
                     var17 = Client.isResized?2:1;
                     var109[var36] = var17;
                     continue;
                  }

                  if(var55 == 5307) {
                     --var5;
                     var15 = class32.field716[var5];
                     if(var15 != 1 && var15 != 2) {
                        continue;
                     }

                     Client.field484 = 0L;
                     if(var15 >= 2) {
                        Client.isResized = true;
                     } else {
                        Client.isResized = false;
                     }

                     ChatLineBuffer.method912();
                     if(Client.gameState >= 25) {
                        Client.field321.method3195(245);
                        class166 var79 = Client.field321;
                        var17 = Client.isResized?2:1;
                        var79.method2912(var17);
                        Client.field321.method3094(XItemContainer.field123);
                        Client.field321.method3094(class143.field1999);
                     }

                     GameEngine.field1776 = true;
                     continue;
                  }

                  if(var55 == 5308) {
                     class32.field716[var5++] = class85.field1456.field684;
                     continue;
                  }

                  if(var55 == 5309) {
                     --var5;
                     var15 = class32.field716[var5];
                     if(var15 == 1 || var15 == 2) {
                        class85.field1456.field684 = var15;
                        class3.method39();
                     }
                     continue;
                  }
               }

               if(var55 < 5600) {
                  if(var55 == 5504) {
                     var5 -= 2;
                     var15 = class32.field716[var5];
                     var36 = class32.field716[var5 + 1];
                     if(!Client.field526) {
                        Client.field361 = var15;
                        Client.mapAngle = var36;
                     }
                     continue;
                  }

                  if(var55 == 5505) {
                     class32.field716[var5++] = Client.field361;
                     continue;
                  }

                  if(var55 == 5506) {
                     class32.field716[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var55 == 5530) {
                     --var5;
                     var15 = class32.field716[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     Client.field367 = var15;
                     continue;
                  }

                  if(var55 == 5531) {
                     class32.field716[var5++] = Client.field367;
                     continue;
                  }
               }

               if(var55 < 5700 && var55 == 5630) {
                  Client.field331 = 250;
               } else {
                  if(var55 < 6300) {
                     if(var55 == 6200) {
                        var5 -= 2;
                        Client.field368 = (short)class32.field716[var5];
                        if(Client.field368 <= 0) {
                           Client.field368 = 256;
                        }

                        Client.field292 = (short)class32.field716[var5 + 1];
                        if(Client.field292 <= 0) {
                           Client.field292 = 205;
                        }
                        continue;
                     }

                     if(var55 == 6201) {
                        var5 -= 2;
                        Client.field534 = (short)class32.field716[var5];
                        if(Client.field534 <= 0) {
                           Client.field534 = 256;
                        }

                        Client.field521 = (short)class32.field716[var5 + 1];
                        if(Client.field521 <= 0) {
                           Client.field521 = 320;
                        }
                        continue;
                     }

                     if(var55 == 6202) {
                        var5 -= 4;
                        Client.field447 = (short)class32.field716[var5];
                        if(Client.field447 <= 0) {
                           Client.field447 = 1;
                        }

                        Client.field412 = (short)class32.field716[1 + var5];
                        if(Client.field412 <= 0) {
                           Client.field412 = 32767;
                        } else if(Client.field412 < Client.field447) {
                           Client.field412 = Client.field447;
                        }

                        Client.field538 = (short)class32.field716[var5 + 2];
                        if(Client.field538 <= 0) {
                           Client.field538 = 1;
                        }

                        Client.field539 = (short)class32.field716[var5 + 3];
                        if(Client.field539 <= 0) {
                           Client.field539 = 32767;
                        } else if(Client.field539 < Client.field538) {
                           Client.field539 = Client.field538;
                        }
                        continue;
                     }

                     if(var55 == 6203) {
                        if(null != Client.field467) {
                           class206.method3825(0, 0, Client.field467.width, Client.field467.height, false);
                           class32.field716[var5++] = Client.camera2;
                           class32.field716[var5++] = Client.camera3;
                        } else {
                           class32.field716[var5++] = -1;
                           class32.field716[var5++] = -1;
                        }
                        continue;
                     }

                     if(var55 == 6204) {
                        class32.field716[var5++] = Client.field534;
                        class32.field716[var5++] = Client.field521;
                        continue;
                     }

                     if(var55 == 6205) {
                        class32.field716[var5++] = Client.field368;
                        class32.field716[var5++] = Client.field292;
                        continue;
                     }
                  }

                  if(var55 < 6600) {
                     if(var55 == 6500) {
                        class32.field716[var5++] = class8.loadWorlds()?1:0;
                        continue;
                     }

                     World var113;
                     if(var55 == 6501) {
                        var113 = class6.method91();
                        if(var113 != null) {
                           class32.field716[var5++] = var113.id;
                           class32.field716[var5++] = var113.mask;
                           class32.chatboxSegments[var6++] = var113.activity;
                           class32.field716[var5++] = var113.location;
                           class32.field716[var5++] = var113.playerCount;
                           class32.chatboxSegments[var6++] = var113.address;
                        } else {
                           class32.field716[var5++] = -1;
                           class32.field716[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field716[var5++] = 0;
                           class32.field716[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var55 == 6502) {
                        if(World.field670 < World.field677) {
                           var113 = WidgetNode.worldList[++World.field670 - 1];
                        } else {
                           var113 = null;
                        }

                        if(var113 != null) {
                           class32.field716[var5++] = var113.id;
                           class32.field716[var5++] = var113.mask;
                           class32.chatboxSegments[var6++] = var113.activity;
                           class32.field716[var5++] = var113.location;
                           class32.field716[var5++] = var113.playerCount;
                           class32.chatboxSegments[var6++] = var113.address;
                        } else {
                           class32.field716[var5++] = -1;
                           class32.field716[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field716[var5++] = 0;
                           class32.field716[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     World var76;
                     if(var55 == 6506) {
                        --var5;
                        var15 = class32.field716[var5];
                        var76 = null;

                        for(var17 = 0; var17 < World.field677; ++var17) {
                           if(WidgetNode.worldList[var17].id == var15) {
                              var76 = WidgetNode.worldList[var17];
                              break;
                           }
                        }

                        if(null != var76) {
                           class32.field716[var5++] = var76.id;
                           class32.field716[var5++] = var76.mask;
                           class32.chatboxSegments[var6++] = var76.activity;
                           class32.field716[var5++] = var76.location;
                           class32.field716[var5++] = var76.playerCount;
                           class32.chatboxSegments[var6++] = var76.address;
                        } else {
                           class32.field716[var5++] = -1;
                           class32.field716[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field716[var5++] = 0;
                           class32.field716[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var55 == 6507) {
                        var5 -= 4;
                        var15 = class32.field716[var5];
                        var91 = class32.field716[var5 + 1] == 1;
                        var17 = class32.field716[var5 + 2];
                        var62 = class32.field716[3 + var5] == 1;
                        if(WidgetNode.worldList != null) {
                           class177.method3262(0, WidgetNode.worldList.length - 1, var15, var91, var17, var62);
                        }
                        continue;
                     }

                     if(var55 == 6511) {
                        --var5;
                        var15 = class32.field716[var5];
                        if(var15 >= 0 && var15 < World.field677) {
                           var76 = WidgetNode.worldList[var15];
                           class32.field716[var5++] = var76.id;
                           class32.field716[var5++] = var76.mask;
                           class32.chatboxSegments[var6++] = var76.activity;
                           class32.field716[var5++] = var76.location;
                           class32.field716[var5++] = var76.playerCount;
                           class32.chatboxSegments[var6++] = var76.address;
                           continue;
                        }

                        class32.field716[var5++] = -1;
                        class32.field716[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        class32.field716[var5++] = 0;
                        class32.field716[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var54) {
            StringBuilder var52 = new StringBuilder(30);
            var52.append("").append(var4.hash).append(" ");

            for(var13 = class32.field712 - 1; var13 >= 0; --var13) {
               var52.append("").append(class32.field719[var13].field90.hash).append(" ");
            }

            var52.append("").append(var10);
            class32.method709(var52.toString(), var54);
         }
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "80"
   )
   static final void method1927() {
      int var0 = class161.menuX;
      int var1 = class217.menuY;
      int var2 = menuWidth;
      int var3 = class18.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4004(var0, var1, var2, var3, var4);
      Rasterizer2D.method4004(1 + var0, 1 + var1, var2 - 2, 16, 0);
      Rasterizer2D.method3985(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class16.field176.method3919("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class115.field1799;
      int var6 = class115.field1794;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = 31 + var1 + 15 * (Client.menuOptionCount - 1 - var7);
         int var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         Font var10 = class16.field176;
         String var11;
         if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method3919(var11, var0 + 3, var8, var9, 0);
      }

      Client.method609(class161.menuX, class217.menuY, menuWidth, class18.menuHeight);
   }
}
