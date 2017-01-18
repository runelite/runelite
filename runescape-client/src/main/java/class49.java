import java.applet.Applet;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class49 extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1615883039
   )
   int field941;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 843907947
   )
   int field942;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 408659385
   )
   int field944;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -581575235
   )
   int field945;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1213251321
   )
   int field946;
   @ObfuscatedName("d")
   Sequence field947;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -944374521
   )
   int field948;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -245763257
   )
   int field953;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1129628255
   )
   int field955;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "25"
   )
   protected final Model getModel() {
      if(this.field947 != null) {
         int var1 = Client.gameCycle - this.field953;
         if(var1 > 100 && this.field947.frameStep > 0) {
            var1 = 100;
         }

         label47: {
            do {
               do {
                  if(var1 <= this.field947.frameLenghts[this.field955]) {
                     break label47;
                  }

                  var1 -= this.field947.frameLenghts[this.field955];
                  ++this.field955;
               } while(this.field955 < this.field947.frameIDs.length);

               this.field955 -= this.field947.frameStep;
            } while(this.field955 >= 0 && this.field955 < this.field947.frameIDs.length);

            this.field947 = null;
         }

         this.field953 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = Tile.getObjectDefinition(this.field948);
      if(null != var12.impostorIds) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field941 != 1 && this.field941 != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = this.field945 + (var2 >> 1);
         int var5 = (1 + var2 >> 1) + this.field945;
         int var6 = (var3 >> 1) + this.field946;
         int var7 = this.field946 + (1 + var3 >> 1);
         int[][] var8 = class10.tileHeights[this.field944];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.field945 << 7) + (var2 << 6);
         int var11 = (var3 << 6) + (this.field946 << 7);
         return var12.method3614(this.field942, this.field941, var8, var10, var9, var11, this.field947, this.field955);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass18;II)V",
      garbageValue = "1260552367"
   )
   static void method871(class18 var0, int var1) {
      Object[] var2 = var0.field203;
      int var3 = ((Integer)var2[0]).intValue();
      class48 var4 = class47.method861(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field928;
         int[] var9 = var4.field935;
         byte var10 = -1;
         class32.field725 = 0;

         int var11;
         try {
            class32.field719 = new int[var4.field934];
            int var12 = 0;
            class32.field717 = new String[var4.field932];
            int var52 = 0;

            int var14;
            String var15;
            for(var11 = 1; var11 < var2.length; ++var11) {
               if(var2[var11] instanceof Integer) {
                  var14 = ((Integer)var2[var11]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field191;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field190;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field195 != null?var0.field195.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field192;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field195?var0.field195.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = var0.field194 != null?var0.field194.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = null != var0.field194?var0.field194.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field201;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field193;
                  }

                  class32.field719[var12++] = var14;
               } else if(var2[var11] instanceof String) {
                  var15 = (String)var2[var11];
                  if(var15.equals("event_opbase")) {
                     var15 = var0.field197;
                  }

                  class32.field717[var52++] = var15;
               }
            }

            var11 = 0;
            class32.field722 = var0.field198;

            label3017:
            while(true) {
               ++var11;
               if(var11 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var16 = var8[var7];
               int var17;
               int var18;
               int var19;
               int var20;
               String var21;
               String var22;
               int var23;
               int var24;
               int[] var25;
               byte var26;
               String var27;
               String[] var28;
               String var29;
               if(var16 < 100) {
                  if(var16 == 0) {
                     class32.field723[var5++] = var9[var7];
                     continue;
                  }

                  if(var16 == 1) {
                     var14 = var9[var7];
                     class32.field723[var5++] = class165.widgetSettings[var14];
                     continue;
                  }

                  if(var16 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class165.widgetSettings[var14] = class32.field723[var5];
                     CombatInfo2.method3532(var14);
                     continue;
                  }

                  if(var16 == 3) {
                     class32.chatboxSegments[var6++] = var4.field930[var7];
                     continue;
                  }

                  if(var16 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var16 == 7) {
                     var5 -= 2;
                     if(class32.field723[var5] != class32.field723[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 8) {
                     var5 -= 2;
                     if(class32.field723[1 + var5] == class32.field723[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 9) {
                     var5 -= 2;
                     if(class32.field723[var5] < class32.field723[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 10) {
                     var5 -= 2;
                     if(class32.field723[var5] > class32.field723[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 21) {
                     if(class32.field725 == 0) {
                        return;
                     }

                     class11 var57 = class32.field726[--class32.field725];
                     var4 = var57.field124;
                     var8 = var4.field928;
                     var9 = var4.field935;
                     var7 = var57.field116;
                     class32.field719 = var57.field117;
                     class32.field717 = var57.field118;
                     continue;
                  }

                  if(var16 == 25) {
                     var14 = var9[var7];
                     class32.field723[var5++] = class101.method1911(var14);
                     continue;
                  }

                  if(var16 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var17 = class32.field723[var5];
                     class194 var56 = class65.method1124(var14);
                     var24 = var56.field2833;
                     var18 = var56.field2831;
                     var19 = var56.field2835;
                     var20 = class165.field2149[var19 - var18];
                     if(var17 < 0 || var17 > var20) {
                        var17 = 0;
                     }

                     var20 <<= var18;
                     class165.widgetSettings[var24] = class165.widgetSettings[var24] & ~var20 | var17 << var18 & var20;
                     continue;
                  }

                  if(var16 == 31) {
                     var5 -= 2;
                     if(class32.field723[var5] <= class32.field723[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 32) {
                     var5 -= 2;
                     if(class32.field723[var5] >= class32.field723[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 33) {
                     class32.field723[var5++] = class32.field719[var9[var7]];
                     continue;
                  }

                  int var55;
                  if(var16 == 34) {
                     var55 = var9[var7];
                     --var5;
                     class32.field719[var55] = class32.field723[var5];
                     continue;
                  }

                  if(var16 == 35) {
                     class32.chatboxSegments[var6++] = class32.field717[var9[var7]];
                     continue;
                  }

                  if(var16 == 36) {
                     var55 = var9[var7];
                     --var6;
                     class32.field717[var55] = class32.chatboxSegments[var6];
                     continue;
                  }

                  if(var16 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var54 = class32.chatboxSegments;
                     if(var14 == 0) {
                        var29 = "";
                     } else if(var14 == 1) {
                        var22 = var54[var6];
                        if(var22 == null) {
                           var29 = "null";
                        } else {
                           var29 = var22.toString();
                        }
                     } else {
                        var24 = var6 + var14;
                        var18 = 0;

                        for(var19 = var6; var19 < var24; ++var19) {
                           var27 = var54[var19];
                           if(null == var27) {
                              var18 += 4;
                           } else {
                              var18 += var27.length();
                           }
                        }

                        StringBuilder var104 = new StringBuilder(var18);

                        for(var20 = var6; var20 < var24; ++var20) {
                           var21 = var54[var20];
                           if(var21 == null) {
                              var104.append("null");
                           } else {
                              var104.append(var21);
                           }
                        }

                        var29 = var104.toString();
                     }

                     class32.chatboxSegments[var6++] = var29;
                     continue;
                  }

                  if(var16 == 38) {
                     --var5;
                     continue;
                  }

                  if(var16 == 39) {
                     --var6;
                     continue;
                  }

                  if(var16 == 40) {
                     var14 = var9[var7];
                     class48 var53 = class47.method861(var14);
                     var25 = new int[var53.field934];
                     var28 = new String[var53.field932];

                     for(var18 = 0; var18 < var53.field927; ++var18) {
                        var25[var18] = class32.field723[var18 + (var5 - var53.field927)];
                     }

                     for(var18 = 0; var18 < var53.field931; ++var18) {
                        var28[var18] = class32.chatboxSegments[var6 - var53.field931 + var18];
                     }

                     var5 -= var53.field927;
                     var6 -= var53.field931;
                     class11 var103 = new class11();
                     var103.field124 = var4;
                     var103.field116 = var7;
                     var103.field117 = class32.field719;
                     var103.field118 = class32.field717;
                     class32.field726[++class32.field725 - 1] = var103;
                     var4 = var53;
                     var8 = var53.field928;
                     var9 = var53.field935;
                     var7 = -1;
                     class32.field719 = var25;
                     class32.field717 = var28;
                     continue;
                  }

                  if(var16 == 42) {
                     class32.field723[var5++] = Renderable.chatMessages.method822(var9[var7]);
                     continue;
                  }

                  if(var16 == 43) {
                     var55 = var9[var7];
                     --var5;
                     Renderable.chatMessages.method821(var55, class32.field723[var5]);
                     continue;
                  }

                  if(var16 == 44) {
                     var14 = var9[var7] >> 16;
                     var17 = var9[var7] & '\uffff';
                     --var5;
                     var23 = class32.field723[var5];
                     if(var23 >= 0 && var23 <= 5000) {
                        class32.field727[var14] = var23;
                        var26 = -1;
                        if(var17 == 105) {
                           var26 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var23) {
                              continue label3017;
                           }

                           class32.field731[var14][var18] = var26;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var16 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var17 = class32.field723[var5];
                     if(var17 >= 0 && var17 < class32.field727[var14]) {
                        class32.field723[var5++] = class32.field731[var14][var17];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var16 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var17 = class32.field723[var5];
                     if(var17 >= 0 && var17 < class32.field727[var14]) {
                        class32.field731[var14][var17] = class32.field723[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var16 == 47) {
                     var15 = Renderable.chatMessages.method824(var9[var7]);
                     if(null == var15) {
                        var15 = "null";
                     }

                     class32.chatboxSegments[var6++] = var15;
                     continue;
                  }

                  if(var16 == 48) {
                     var55 = var9[var7];
                     --var6;
                     Renderable.chatMessages.method823(var55, class32.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var30;
               if(var9[var7] == 1) {
                  var30 = true;
               } else {
                  var30 = false;
               }

               Widget var31;
               Widget var32;
               boolean var33;
               Widget var34;
               Widget var35;
               boolean var36;
               if(var16 < 1000) {
                  if(var16 == 100) {
                     var5 -= 3;
                     var17 = class32.field723[var5];
                     var23 = class32.field723[var5 + 1];
                     var24 = class32.field723[var5 + 2];
                     if(var23 == 0) {
                        throw new RuntimeException();
                     }

                     var35 = class44.method799(var17);
                     if(var35.children == null) {
                        var35.children = new Widget[1 + var24];
                     }

                     if(var35.children.length <= var24) {
                        Widget[] var61 = new Widget[var24 + 1];

                        for(var20 = 0; var20 < var35.children.length; ++var20) {
                           var61[var20] = var35.children[var20];
                        }

                        var35.children = var61;
                     }

                     if(var24 > 0 && null == var35.children[var24 - 1]) {
                        throw new RuntimeException("" + (var24 - 1));
                     }

                     Widget var63 = new Widget();
                     var63.type = var23;
                     var63.parentId = var63.id = var35.id;
                     var63.index = var24;
                     var63.field2184 = true;
                     var35.children[var24] = var63;
                     if(var30) {
                        WidgetNode.field187 = var63;
                     } else {
                        class38.field789 = var63;
                     }

                     class6.method87(var35);
                     continue;
                  }

                  if(var16 == 101) {
                     var32 = var30?WidgetNode.field187:class38.field789;
                     var31 = class44.method799(var32.id);
                     var31.children[var32.index] = null;
                     class6.method87(var31);
                     continue;
                  }

                  if(var16 == 102) {
                     --var5;
                     var32 = class44.method799(class32.field723[var5]);
                     var32.children = null;
                     class6.method87(var32);
                     continue;
                  }

                  if(var16 == 200) {
                     var5 -= 2;
                     var17 = class32.field723[var5];
                     var23 = class32.field723[var5 + 1];
                     var34 = class157.method3011(var17, var23);
                     if(var34 != null && var23 != -1) {
                        class32.field723[var5++] = 1;
                        if(var30) {
                           WidgetNode.field187 = var34;
                        } else {
                           class38.field789 = var34;
                        }
                        continue;
                     }

                     class32.field723[var5++] = 0;
                     continue;
                  }

                  if(var16 == 201) {
                     --var5;
                     var32 = class44.method799(class32.field723[var5]);
                     if(null != var32) {
                        class32.field723[var5++] = 1;
                        if(var30) {
                           WidgetNode.field187 = var32;
                        } else {
                           class38.field789 = var32;
                        }
                     } else {
                        class32.field723[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var37;
                  if(var16 >= 1000 && var16 < 1100 || var16 >= 2000 && var16 < 2100) {
                     var17 = -1;
                     if(var16 >= 2000) {
                        var16 -= 1000;
                        --var5;
                        var17 = class32.field723[var5];
                        var31 = class44.method799(var17);
                     } else {
                        var31 = var30?WidgetNode.field187:class38.field789;
                     }

                     if(var16 == 1000) {
                        var5 -= 4;
                        var31.field2194 = class32.field723[var5];
                        var31.field2195 = class32.field723[var5 + 1];
                        var31.field2230 = class32.field723[2 + var5];
                        var31.field2191 = class32.field723[var5 + 3];
                        class6.method87(var31);
                        XItemContainer.method166(var31);
                        if(var17 != -1 && var31.type == 0) {
                           class6.method97(Widget.widgets[var17 >> 16], var31, false);
                        }
                        continue;
                     }

                     if(var16 == 1001) {
                        var5 -= 4;
                        var31.field2237 = class32.field723[var5];
                        var31.field2279 = class32.field723[var5 + 1];
                        var31.field2197 = class32.field723[2 + var5];
                        var31.field2193 = class32.field723[3 + var5];
                        class6.method87(var31);
                        XItemContainer.method166(var31);
                        if(var17 != -1 && var31.type == 0) {
                           class6.method97(Widget.widgets[var17 >> 16], var31, false);
                        }
                        continue;
                     }

                     if(var16 == 1003) {
                        --var5;
                        var37 = class32.field723[var5] == 1;
                        if(var31.isHidden != var37) {
                           var31.isHidden = var37;
                           class6.method87(var31);
                        }
                        continue;
                     }

                     if(var16 == 1005) {
                        --var5;
                        var31.field2204 = class32.field723[var5] == 1;
                        continue;
                     }

                     if(var16 == 1006) {
                        --var5;
                        var31.field2319 = class32.field723[var5] == 1;
                        continue;
                     }
                  } else if((var16 < 1100 || var16 >= 1200) && (var16 < 2100 || var16 >= 2200)) {
                     if(var16 >= 1200 && var16 < 1300 || var16 >= 2200 && var16 < 2300) {
                        if(var16 >= 2000) {
                           var16 -= 1000;
                           --var5;
                           var32 = class44.method799(class32.field723[var5]);
                        } else {
                           var32 = var30?WidgetNode.field187:class38.field789;
                        }

                        class6.method87(var32);
                        if(var16 == 1200 || var16 == 1205 || var16 == 1212) {
                           var5 -= 2;
                           var23 = class32.field723[var5];
                           var24 = class32.field723[1 + var5];
                           var32.item = var23;
                           var32.stackSize = var24;
                           ItemComposition var64 = class88.getItemDefinition(var23);
                           var32.rotationX = var64.xan2d;
                           var32.rotationZ = var64.yan2d;
                           var32.rotationY = var64.zan2d;
                           var32.field2234 = var64.offsetX2d;
                           var32.field2178 = var64.offsetY2d;
                           var32.field2239 = var64.zoom2d;
                           if(var16 == 1205) {
                              var32.field2244 = 0;
                           } else if(var16 == 1212 | var64.isStackable == 1) {
                              var32.field2244 = 1;
                           } else {
                              var32.field2244 = 2;
                           }

                           if(var32.field2231 > 0) {
                              var32.field2239 = var32.field2239 * 32 / var32.field2231;
                           } else if(var32.field2237 > 0) {
                              var32.field2239 = var32.field2239 * 32 / var32.field2237;
                           }
                           continue;
                        }

                        if(var16 == 1201) {
                           var32.modelType = 2;
                           --var5;
                           var32.modelId = class32.field723[var5];
                           continue;
                        }

                        if(var16 == 1202) {
                           var32.modelType = 3;
                           var32.modelId = class148.localPlayer.composition.method3125();
                           continue;
                        }
                     } else if(var16 >= 1300 && var16 < 1400 || var16 >= 2300 && var16 < 2400) {
                        if(var16 >= 2000) {
                           var16 -= 1000;
                           --var5;
                           var32 = class44.method799(class32.field723[var5]);
                        } else {
                           var32 = var30?WidgetNode.field187:class38.field789;
                        }

                        if(var16 == 1300) {
                           --var5;
                           var23 = class32.field723[var5] - 1;
                           if(var23 >= 0 && var23 <= 9) {
                              --var6;
                              var32.method3174(var23, class32.chatboxSegments[var6]);
                              continue;
                           }

                           --var6;
                           continue;
                        }

                        if(var16 == 1301) {
                           var5 -= 2;
                           var23 = class32.field723[var5];
                           var24 = class32.field723[var5 + 1];
                           var32.parent = class157.method3011(var23, var24);
                           continue;
                        }

                        if(var16 == 1302) {
                           --var5;
                           var32.field2263 = class32.field723[var5] == 1;
                           continue;
                        }

                        if(var16 == 1303) {
                           --var5;
                           var32.field2261 = class32.field723[var5];
                           continue;
                        }

                        if(var16 == 1304) {
                           --var5;
                           var32.field2262 = class32.field723[var5];
                           continue;
                        }

                        if(var16 == 1305) {
                           --var6;
                           var32.name = class32.chatboxSegments[var6];
                           continue;
                        }

                        if(var16 == 1306) {
                           --var6;
                           var32.field2264 = class32.chatboxSegments[var6];
                           continue;
                        }

                        if(var16 == 1307) {
                           var32.actions = null;
                           continue;
                        }
                     } else {
                        String var58;
                        int[] var60;
                        if(var16 >= 1400 && var16 < 1500 || var16 >= 2400 && var16 < 2500) {
                           if(var16 >= 2000) {
                              var16 -= 1000;
                              --var5;
                              var32 = class44.method799(class32.field723[var5]);
                           } else {
                              var32 = var30?WidgetNode.field187:class38.field789;
                           }

                           --var6;
                           var58 = class32.chatboxSegments[var6];
                           var60 = null;
                           if(var58.length() > 0 && var58.charAt(var58.length() - 1) == 89) {
                              --var5;
                              var18 = class32.field723[var5];
                              if(var18 > 0) {
                                 for(var60 = new int[var18]; var18-- > 0; var60[var18] = class32.field723[var5]) {
                                    --var5;
                                 }
                              }

                              var58 = var58.substring(0, var58.length() - 1);
                           }

                           Object[] var67 = new Object[var58.length() + 1];

                           for(var19 = var67.length - 1; var19 >= 1; --var19) {
                              if(var58.charAt(var19 - 1) == 115) {
                                 --var6;
                                 var67[var19] = class32.chatboxSegments[var6];
                              } else {
                                 --var5;
                                 var67[var19] = new Integer(class32.field723[var5]);
                              }
                           }

                           --var5;
                           var19 = class32.field723[var5];
                           if(var19 != -1) {
                              var67[0] = new Integer(var19);
                           } else {
                              var67 = null;
                           }

                           if(var16 == 1400) {
                              var32.field2267 = var67;
                           }

                           if(var16 == 1401) {
                              var32.field2270 = var67;
                           }

                           if(var16 == 1402) {
                              var32.field2269 = var67;
                           }

                           if(var16 == 1403) {
                              var32.field2271 = var67;
                           }

                           if(var16 == 1404) {
                              var32.field2273 = var67;
                           }

                           if(var16 == 1405) {
                              var32.field2274 = var67;
                           }

                           if(var16 == 1406) {
                              var32.field2297 = var67;
                           }

                           if(var16 == 1407) {
                              var32.field2303 = var67;
                              var32.field2192 = var60;
                           }

                           if(var16 == 1408) {
                              var32.field2272 = var67;
                           }

                           if(var16 == 1409) {
                              var32.field2285 = var67;
                           }

                           if(var16 == 1410) {
                              var32.field2275 = var67;
                           }

                           if(var16 == 1411) {
                              var32.field2268 = var67;
                           }

                           if(var16 == 1412) {
                              var32.field2232 = var67;
                           }

                           if(var16 == 1414) {
                              var32.field2175 = var67;
                              var32.field2281 = var60;
                           }

                           if(var16 == 1415) {
                              var32.field2282 = var67;
                              var32.field2249 = var60;
                           }

                           if(var16 == 1416) {
                              var32.field2276 = var67;
                           }

                           if(var16 == 1417) {
                              var32.field2286 = var67;
                           }

                           if(var16 == 1418) {
                              var32.field2287 = var67;
                           }

                           if(var16 == 1419) {
                              var32.field2288 = var67;
                           }

                           if(var16 == 1420) {
                              var32.field2179 = var67;
                           }

                           if(var16 == 1421) {
                              var32.field2290 = var67;
                           }

                           if(var16 == 1422) {
                              var32.field2291 = var67;
                           }

                           if(var16 == 1423) {
                              var32.field2292 = var67;
                           }

                           if(var16 == 1424) {
                              var32.field2293 = var67;
                           }

                           if(var16 == 1425) {
                              var32.field2295 = var67;
                           }

                           if(var16 == 1426) {
                              var32.field2296 = var67;
                           }

                           if(var16 == 1427) {
                              var32.field2227 = var67;
                           }

                           var32.field2307 = true;
                           continue;
                        }

                        if(var16 < 1600) {
                           var32 = var30?WidgetNode.field187:class38.field789;
                           if(var16 == 1500) {
                              class32.field723[var5++] = var32.relativeX;
                              continue;
                           }

                           if(var16 == 1501) {
                              class32.field723[var5++] = var32.relativeY;
                              continue;
                           }

                           if(var16 == 1502) {
                              class32.field723[var5++] = var32.width;
                              continue;
                           }

                           if(var16 == 1503) {
                              class32.field723[var5++] = var32.height;
                              continue;
                           }

                           if(var16 == 1504) {
                              class32.field723[var5++] = var32.isHidden?1:0;
                              continue;
                           }

                           if(var16 == 1505) {
                              class32.field723[var5++] = var32.parentId;
                              continue;
                           }
                        } else if(var16 < 1700) {
                           var32 = var30?WidgetNode.field187:class38.field789;
                           if(var16 == 1600) {
                              class32.field723[var5++] = var32.scrollX;
                              continue;
                           }

                           if(var16 == 1601) {
                              class32.field723[var5++] = var32.scrollY;
                              continue;
                           }

                           if(var16 == 1602) {
                              class32.chatboxSegments[var6++] = var32.text;
                              continue;
                           }

                           if(var16 == 1603) {
                              class32.field723[var5++] = var32.scrollWidth;
                              continue;
                           }

                           if(var16 == 1604) {
                              class32.field723[var5++] = var32.scrollHeight;
                              continue;
                           }

                           if(var16 == 1605) {
                              class32.field723[var5++] = var32.field2239;
                              continue;
                           }

                           if(var16 == 1606) {
                              class32.field723[var5++] = var32.rotationX;
                              continue;
                           }

                           if(var16 == 1607) {
                              class32.field723[var5++] = var32.rotationY;
                              continue;
                           }

                           if(var16 == 1608) {
                              class32.field723[var5++] = var32.rotationZ;
                              continue;
                           }

                           if(var16 == 1609) {
                              class32.field723[var5++] = var32.opacity;
                              continue;
                           }

                           if(var16 == 1610) {
                              class32.field723[var5++] = var32.field2280;
                              continue;
                           }

                           if(var16 == 1611) {
                              class32.field723[var5++] = var32.textColor;
                              continue;
                           }

                           if(var16 == 1612) {
                              class32.field723[var5++] = var32.field2211;
                              continue;
                           }

                           if(var16 == 1613) {
                              class32.field723[var5++] = var32.field2219.vmethod4062();
                              continue;
                           }
                        } else if(var16 < 1800) {
                           var32 = var30?WidgetNode.field187:class38.field789;
                           if(var16 == 1700) {
                              class32.field723[var5++] = var32.item;
                              continue;
                           }

                           if(var16 == 1701) {
                              if(var32.item != -1) {
                                 class32.field723[var5++] = var32.stackSize;
                              } else {
                                 class32.field723[var5++] = 0;
                              }
                              continue;
                           }

                           if(var16 == 1702) {
                              class32.field723[var5++] = var32.index;
                              continue;
                           }
                        } else if(var16 < 1900) {
                           var32 = var30?WidgetNode.field187:class38.field789;
                           if(var16 == 1800) {
                              var25 = class32.field723;
                              var24 = var5++;
                              var19 = GameObject.method1872(var32);
                              var18 = var19 >> 11 & 63;
                              var25[var24] = var18;
                              continue;
                           }

                           if(var16 == 1801) {
                              --var5;
                              var23 = class32.field723[var5];
                              --var23;
                              if(var32.actions != null && var23 < var32.actions.length && var32.actions[var23] != null) {
                                 class32.chatboxSegments[var6++] = var32.actions[var23];
                                 continue;
                              }

                              class32.chatboxSegments[var6++] = "";
                              continue;
                           }

                           if(var16 == 1802) {
                              if(var32.name == null) {
                                 class32.chatboxSegments[var6++] = "";
                              } else {
                                 class32.chatboxSegments[var6++] = var32.name;
                              }
                              continue;
                           }
                        } else if(var16 >= 1900 && var16 < 2000 || var16 >= 2900 && var16 < 3000) {
                           if(var16 >= 2000) {
                              var16 -= 1000;
                              --var5;
                              var32 = class44.method799(class32.field723[var5]);
                           } else {
                              var32 = var30?WidgetNode.field187:class38.field789;
                           }

                           if(var16 == 1927) {
                              if(class32.field722 >= 10) {
                                 throw new RuntimeException();
                              }

                              if(null == var32.field2227) {
                                 return;
                              }

                              class18 var66 = new class18();
                              var66.field195 = var32;
                              var66.field203 = var32.field2227;
                              var66.field198 = 1 + class32.field722;
                              Client.field479.method2394(var0);
                              continue;
                           }
                        } else if(var16 < 2600) {
                           --var5;
                           var32 = class44.method799(class32.field723[var5]);
                           if(var16 == 2500) {
                              class32.field723[var5++] = var32.relativeX;
                              continue;
                           }

                           if(var16 == 2501) {
                              class32.field723[var5++] = var32.relativeY;
                              continue;
                           }

                           if(var16 == 2502) {
                              class32.field723[var5++] = var32.width;
                              continue;
                           }

                           if(var16 == 2503) {
                              class32.field723[var5++] = var32.height;
                              continue;
                           }

                           if(var16 == 2504) {
                              class32.field723[var5++] = var32.isHidden?1:0;
                              continue;
                           }

                           if(var16 == 2505) {
                              class32.field723[var5++] = var32.parentId;
                              continue;
                           }
                        } else if(var16 < 2700) {
                           --var5;
                           var32 = class44.method799(class32.field723[var5]);
                           if(var16 == 2600) {
                              class32.field723[var5++] = var32.scrollX;
                              continue;
                           }

                           if(var16 == 2601) {
                              class32.field723[var5++] = var32.scrollY;
                              continue;
                           }

                           if(var16 == 2602) {
                              class32.chatboxSegments[var6++] = var32.text;
                              continue;
                           }

                           if(var16 == 2603) {
                              class32.field723[var5++] = var32.scrollWidth;
                              continue;
                           }

                           if(var16 == 2604) {
                              class32.field723[var5++] = var32.scrollHeight;
                              continue;
                           }

                           if(var16 == 2605) {
                              class32.field723[var5++] = var32.field2239;
                              continue;
                           }

                           if(var16 == 2606) {
                              class32.field723[var5++] = var32.rotationX;
                              continue;
                           }

                           if(var16 == 2607) {
                              class32.field723[var5++] = var32.rotationY;
                              continue;
                           }

                           if(var16 == 2608) {
                              class32.field723[var5++] = var32.rotationZ;
                              continue;
                           }

                           if(var16 == 2609) {
                              class32.field723[var5++] = var32.opacity;
                              continue;
                           }

                           if(var16 == 2610) {
                              class32.field723[var5++] = var32.field2280;
                              continue;
                           }

                           if(var16 == 2611) {
                              class32.field723[var5++] = var32.textColor;
                              continue;
                           }

                           if(var16 == 2612) {
                              class32.field723[var5++] = var32.field2211;
                              continue;
                           }

                           if(var16 == 2613) {
                              class32.field723[var5++] = var32.field2219.vmethod4062();
                              continue;
                           }
                        } else {
                           WidgetNode var40;
                           if(var16 < 2800) {
                              if(var16 == 2700) {
                                 --var5;
                                 var32 = class44.method799(class32.field723[var5]);
                                 class32.field723[var5++] = var32.item;
                                 continue;
                              }

                              if(var16 == 2701) {
                                 --var5;
                                 var32 = class44.method799(class32.field723[var5]);
                                 if(var32.item != -1) {
                                    class32.field723[var5++] = var32.stackSize;
                                 } else {
                                    class32.field723[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var16 == 2702) {
                                 --var5;
                                 var17 = class32.field723[var5];
                                 var40 = (WidgetNode)Client.componentTable.method2339((long)var17);
                                 if(null != var40) {
                                    class32.field723[var5++] = 1;
                                 } else {
                                    class32.field723[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var16 == 2706) {
                                 class32.field723[var5++] = Client.widgetRoot;
                                 continue;
                              }
                           } else if(var16 < 2900) {
                              --var5;
                              var32 = class44.method799(class32.field723[var5]);
                              if(var16 == 2800) {
                                 var25 = class32.field723;
                                 var24 = var5++;
                                 var19 = GameObject.method1872(var32);
                                 var18 = var19 >> 11 & 63;
                                 var25[var24] = var18;
                                 continue;
                              }

                              if(var16 == 2801) {
                                 --var5;
                                 var23 = class32.field723[var5];
                                 --var23;
                                 if(var32.actions != null && var23 < var32.actions.length && null != var32.actions[var23]) {
                                    class32.chatboxSegments[var6++] = var32.actions[var23];
                                    continue;
                                 }

                                 class32.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var16 == 2802) {
                                 if(null == var32.name) {
                                    class32.chatboxSegments[var6++] = "";
                                 } else {
                                    class32.chatboxSegments[var6++] = var32.name;
                                 }
                                 continue;
                              }
                           } else if(var16 < 3200) {
                              if(var16 == 3100) {
                                 --var6;
                                 var29 = class32.chatboxSegments[var6];
                                 class7.method99(0, "", var29);
                                 continue;
                              }

                              if(var16 == 3101) {
                                 var5 -= 2;
                                 XItemContainer.method167(class148.localPlayer, class32.field723[var5], class32.field723[1 + var5]);
                                 continue;
                              }

                              if(var16 == 3103) {
                                 Client.field326.method3029(249);

                                 for(var40 = (WidgetNode)Client.componentTable.method2344(); var40 != null; var40 = (WidgetNode)Client.componentTable.method2343()) {
                                    if(var40.field182 == 0 || var40.field182 == 3) {
                                       class3.method31(var40, true);
                                    }
                                 }

                                 if(Client.field537 != null) {
                                    class6.method87(Client.field537);
                                    Client.field537 = null;
                                 }
                                 continue;
                              }

                              if(var16 == 3104) {
                                 --var6;
                                 var29 = class32.chatboxSegments[var6];
                                 var23 = 0;
                                 var37 = MessageNode.method202(var29, 10, true);
                                 if(var37) {
                                    var23 = class16.method183(var29);
                                 }

                                 Client.field326.method3029(52);
                                 Client.field326.method2763(var23);
                                 continue;
                              }

                              if(var16 == 3105) {
                                 --var6;
                                 var29 = class32.chatboxSegments[var6];
                                 Client.field326.method3029(128);
                                 Client.field326.method2760(var29.length() + 1);
                                 Client.field326.method2811(var29);
                                 continue;
                              }

                              if(var16 == 3106) {
                                 --var6;
                                 var29 = class32.chatboxSegments[var6];
                                 Client.field326.method3029(35);
                                 Client.field326.method2760(var29.length() + 1);
                                 Client.field326.method2811(var29);
                                 continue;
                              }

                              if(var16 == 3107) {
                                 --var5;
                                 var17 = class32.field723[var5];
                                 --var6;
                                 var58 = class32.chatboxSegments[var6];
                                 class44.method794(var17, var58);
                                 continue;
                              }

                              if(var16 == 3108) {
                                 var5 -= 3;
                                 var17 = class32.field723[var5];
                                 var23 = class32.field723[var5 + 1];
                                 var24 = class32.field723[2 + var5];
                                 var35 = class44.method799(var24);
                                 WallObject.method1845(var35, var17, var23);
                                 continue;
                              }

                              if(var16 == 3109) {
                                 var5 -= 2;
                                 var17 = class32.field723[var5];
                                 var23 = class32.field723[1 + var5];
                                 var34 = var30?WidgetNode.field187:class38.field789;
                                 WallObject.method1845(var34, var17, var23);
                                 continue;
                              }

                              if(var16 == 3110) {
                                 --var5;
                                 GroundObject.field1297 = class32.field723[var5] == 1;
                                 continue;
                              }

                              if(var16 == 3111) {
                                 class32.field723[var5++] = class2.field21.field690?1:0;
                                 continue;
                              }

                              if(var16 == 3112) {
                                 --var5;
                                 class2.field21.field690 = class32.field723[var5] == 1;
                                 class7.method108();
                                 continue;
                              }

                              if(var16 == 3113) {
                                 --var6;
                                 var29 = class32.chatboxSegments[var6];
                                 --var5;
                                 var36 = class32.field723[var5] == 1;
                                 class156.method2998(var29, var36, false);
                                 continue;
                              }

                              if(var16 == 3115) {
                                 --var5;
                                 var17 = class32.field723[var5];
                                 Client.field326.method3029(0);
                                 Client.field326.method2918(var17);
                                 continue;
                              }

                              if(var16 == 3116) {
                                 --var5;
                                 var17 = class32.field723[var5];
                                 var6 -= 2;
                                 var58 = class32.chatboxSegments[var6];
                                 var22 = class32.chatboxSegments[var6 + 1];
                                 if(var58.length() <= 500 && var22.length() <= 500) {
                                    Client.field326.method3029(247);
                                    Client.field326.method2918(1 + class148.method2740(var58) + class148.method2740(var22));
                                    Client.field326.method2811(var58);
                                    Client.field326.method2811(var22);
                                    Client.field326.method2800(var17);
                                 }
                                 continue;
                              }
                           } else if(var16 < 3300) {
                              if(var16 == 3200) {
                                 var5 -= 3;
                                 class119.method2275(class32.field723[var5], class32.field723[var5 + 1], class32.field723[2 + var5]);
                                 continue;
                              }

                              if(var16 == 3201) {
                                 --var5;
                                 var17 = class32.field723[var5];
                                 if(var17 == -1 && !Client.field519) {
                                    class9.method118();
                                 } else if(var17 != -1 && var17 != Client.field444 && Client.field517 != 0 && !Client.field519) {
                                    class85.method1663(2, class37.field781, var17, 0, Client.field517, false);
                                 }

                                 Client.field444 = var17;
                                 continue;
                              }

                              if(var16 == 3202) {
                                 var5 -= 2;
                                 class94.method1867(class32.field723[var5], class32.field723[var5 + 1]);
                                 continue;
                              }
                           } else {
                              int var41;
                              byte[] var42;
                              int var62;
                              if(var16 < 3400) {
                                 if(var16 == 3300) {
                                    class32.field723[var5++] = Client.gameCycle;
                                    continue;
                                 }

                                 if(var16 == 3301) {
                                    var5 -= 2;
                                    var17 = class32.field723[var5];
                                    var23 = class32.field723[1 + var5];
                                    class32.field723[var5++] = class5.method75(var17, var23);
                                    continue;
                                 }

                                 XItemContainer var43;
                                 if(var16 == 3302) {
                                    var5 -= 2;
                                    var17 = class32.field723[var5];
                                    var23 = class32.field723[1 + var5];
                                    var60 = class32.field723;
                                    var18 = var5++;
                                    var43 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var17);
                                    if(null == var43) {
                                       var19 = 0;
                                    } else if(var23 >= 0 && var23 < var43.stackSizes.length) {
                                       var19 = var43.stackSizes[var23];
                                    } else {
                                       var19 = 0;
                                    }

                                    var60[var18] = var19;
                                    continue;
                                 }

                                 if(var16 == 3303) {
                                    var5 -= 2;
                                    var17 = class32.field723[var5];
                                    var23 = class32.field723[1 + var5];
                                    var60 = class32.field723;
                                    var18 = var5++;
                                    var43 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var17);
                                    if(null == var43) {
                                       var19 = 0;
                                    } else if(var23 == -1) {
                                       var19 = 0;
                                    } else {
                                       var41 = 0;

                                       for(var62 = 0; var62 < var43.stackSizes.length; ++var62) {
                                          if(var43.itemIds[var62] == var23) {
                                             var41 += var43.stackSizes[var62];
                                          }
                                       }

                                       var19 = var41;
                                    }

                                    var60[var18] = var19;
                                    continue;
                                 }

                                 if(var16 == 3304) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    var25 = class32.field723;
                                    var24 = var5++;
                                    class186 var44 = (class186)class186.field2745.get((long)var17);
                                    class186 var45;
                                    if(null != var44) {
                                       var45 = var44;
                                    } else {
                                       var42 = class186.field2748.method3272(5, var17);
                                       var44 = new class186();
                                       if(var42 != null) {
                                          var44.method3407(new Buffer(var42));
                                       }

                                       class186.field2745.put(var44, (long)var17);
                                       var45 = var44;
                                    }

                                    var25[var24] = var45.field2746;
                                    continue;
                                 }

                                 if(var16 == 3305) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    class32.field723[var5++] = Client.boostedSkillLevels[var17];
                                    continue;
                                 }

                                 if(var16 == 3306) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    class32.field723[var5++] = Client.realSkillLevels[var17];
                                    continue;
                                 }

                                 if(var16 == 3307) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    class32.field723[var5++] = Client.skillExperiences[var17];
                                    continue;
                                 }

                                 if(var16 == 3308) {
                                    var17 = class60.plane;
                                    var23 = FrameMap.baseX + (class148.localPlayer.x >> 7);
                                    var24 = XItemContainer.baseY + (class148.localPlayer.y >> 7);
                                    class32.field723[var5++] = var24 + (var17 << 28) + (var23 << 14);
                                    continue;
                                 }

                                 if(var16 == 3309) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    class32.field723[var5++] = var17 >> 14 & 16383;
                                    continue;
                                 }

                                 if(var16 == 3310) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    class32.field723[var5++] = var17 >> 28;
                                    continue;
                                 }

                                 if(var16 == 3311) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    class32.field723[var5++] = var17 & 16383;
                                    continue;
                                 }

                                 if(var16 == 3312) {
                                    class32.field723[var5++] = Client.isMembers?1:0;
                                    continue;
                                 }

                                 if(var16 == 3313) {
                                    var5 -= 2;
                                    var17 = class32.field723[var5] + '耀';
                                    var23 = class32.field723[1 + var5];
                                    class32.field723[var5++] = class5.method75(var17, var23);
                                    continue;
                                 }

                                 if(var16 == 3314) {
                                    var5 -= 2;
                                    var17 = class32.field723[var5] + '耀';
                                    var23 = class32.field723[1 + var5];
                                    var60 = class32.field723;
                                    var18 = var5++;
                                    var43 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var17);
                                    if(var43 == null) {
                                       var19 = 0;
                                    } else if(var23 >= 0 && var23 < var43.stackSizes.length) {
                                       var19 = var43.stackSizes[var23];
                                    } else {
                                       var19 = 0;
                                    }

                                    var60[var18] = var19;
                                    continue;
                                 }

                                 if(var16 == 3315) {
                                    var5 -= 2;
                                    var17 = '耀' + class32.field723[var5];
                                    var23 = class32.field723[var5 + 1];
                                    var60 = class32.field723;
                                    var18 = var5++;
                                    var43 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var17);
                                    if(null == var43) {
                                       var19 = 0;
                                    } else if(var23 == -1) {
                                       var19 = 0;
                                    } else {
                                       var41 = 0;

                                       for(var62 = 0; var62 < var43.stackSizes.length; ++var62) {
                                          if(var43.itemIds[var62] == var23) {
                                             var41 += var43.stackSizes[var62];
                                          }
                                       }

                                       var19 = var41;
                                    }

                                    var60[var18] = var19;
                                    continue;
                                 }

                                 if(var16 == 3316) {
                                    if(Client.field352 >= 2) {
                                       class32.field723[var5++] = Client.field352;
                                    } else {
                                       class32.field723[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var16 == 3317) {
                                    class32.field723[var5++] = Client.field297;
                                    continue;
                                 }

                                 if(var16 == 3318) {
                                    class32.field723[var5++] = Client.world;
                                    continue;
                                 }

                                 if(var16 == 3321) {
                                    class32.field723[var5++] = Client.energy;
                                    continue;
                                 }

                                 if(var16 == 3322) {
                                    class32.field723[var5++] = Client.weight;
                                    continue;
                                 }

                                 if(var16 == 3323) {
                                    if(Client.field449) {
                                       class32.field723[var5++] = 1;
                                    } else {
                                       class32.field723[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var16 == 3324) {
                                    class32.field723[var5++] = Client.flags;
                                    continue;
                                 }
                              } else if(var16 < 3500) {
                                 class195 var68;
                                 if(var16 == 3400) {
                                    var5 -= 2;
                                    var17 = class32.field723[var5];
                                    var23 = class32.field723[1 + var5];
                                    var68 = class139.method2602(var17);
                                    if(var68.field2842 != 115) {
                                       ;
                                    }

                                    for(var18 = 0; var18 < var68.field2845; ++var18) {
                                       if(var68.field2846[var18] == var23) {
                                          class32.chatboxSegments[var6++] = var68.field2841[var18];
                                          var68 = null;
                                          break;
                                       }
                                    }

                                    if(null != var68) {
                                       class32.chatboxSegments[var6++] = var68.field2843;
                                    }
                                    continue;
                                 }

                                 if(var16 == 3408) {
                                    var5 -= 4;
                                    var17 = class32.field723[var5];
                                    var23 = class32.field723[1 + var5];
                                    var24 = class32.field723[var5 + 2];
                                    var18 = class32.field723[3 + var5];
                                    var68 = class139.method2602(var24);
                                    if(var17 == var68.field2848 && var23 == var68.field2842) {
                                       for(var20 = 0; var20 < var68.field2845; ++var20) {
                                          if(var18 == var68.field2846[var20]) {
                                             if(var23 == 115) {
                                                class32.chatboxSegments[var6++] = var68.field2841[var20];
                                             } else {
                                                class32.field723[var5++] = var68.field2839[var20];
                                             }

                                             var68 = null;
                                             break;
                                          }
                                       }

                                       if(var68 != null) {
                                          if(var23 == 115) {
                                             class32.chatboxSegments[var6++] = var68.field2843;
                                          } else {
                                             class32.field723[var5++] = var68.field2844;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var23 == 115) {
                                       class32.chatboxSegments[var6++] = "null";
                                    } else {
                                       class32.field723[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else if(var16 < 3700) {
                                 if(var16 == 3600) {
                                    if(Client.field465 == 0) {
                                       class32.field723[var5++] = -2;
                                    } else if(Client.field465 == 1) {
                                       class32.field723[var5++] = -1;
                                    } else {
                                       class32.field723[var5++] = Client.friendCount;
                                    }
                                    continue;
                                 }

                                 if(var16 == 3601) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    if(Client.field465 == 2 && var17 < Client.friendCount) {
                                       class32.chatboxSegments[var6++] = Client.friends[var17].name;
                                       class32.chatboxSegments[var6++] = Client.friends[var17].previousName;
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var16 == 3602) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    if(Client.field465 == 2 && var17 < Client.friendCount) {
                                       class32.field723[var5++] = Client.friends[var17].world;
                                       continue;
                                    }

                                    class32.field723[var5++] = 0;
                                    continue;
                                 }

                                 if(var16 == 3603) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    if(Client.field465 == 2 && var17 < Client.friendCount) {
                                       class32.field723[var5++] = Client.friends[var17].rank;
                                       continue;
                                    }

                                    class32.field723[var5++] = 0;
                                    continue;
                                 }

                                 if(var16 == 3604) {
                                    --var6;
                                    var29 = class32.chatboxSegments[var6];
                                    --var5;
                                    var23 = class32.field723[var5];
                                    class107.method1996(var29, var23);
                                    continue;
                                 }

                                 if(var16 == 3605) {
                                    --var6;
                                    var29 = class32.chatboxSegments[var6];
                                    class36.method729(var29);
                                    continue;
                                 }

                                 if(var16 == 3606) {
                                    --var6;
                                    var29 = class32.chatboxSegments[var6];
                                    if(var29 == null) {
                                       continue;
                                    }

                                    var58 = class139.method2601(var29, Ignore.field209);
                                    if(null == var58) {
                                       continue;
                                    }

                                    var24 = 0;

                                    while(true) {
                                       if(var24 >= Client.friendCount) {
                                          continue label3017;
                                       }

                                       Friend var73 = Client.friends[var24];
                                       String var70 = var73.name;
                                       var27 = class139.method2601(var70, Ignore.field209);
                                       if(class170.method3216(var29, var58, var70, var27)) {
                                          --Client.friendCount;

                                          for(var41 = var24; var41 < Client.friendCount; ++var41) {
                                             Client.friends[var41] = Client.friends[var41 + 1];
                                          }

                                          Client.field460 = Client.field446;
                                          Client.field326.method3029(45);
                                          Client.field326.method2760(class148.method2740(var29));
                                          Client.field326.method2811(var29);
                                          continue label3017;
                                       }

                                       ++var24;
                                    }
                                 }

                                 if(var16 == 3607) {
                                    --var6;
                                    var29 = class32.chatboxSegments[var6];
                                    class60.method1096(var29, false);
                                    continue;
                                 }

                                 if(var16 == 3608) {
                                    --var6;
                                    var29 = class32.chatboxSegments[var6];
                                    class1.method9(var29);
                                    continue;
                                 }

                                 if(var16 == 3609) {
                                    --var6;
                                    var29 = class32.chatboxSegments[var6];
                                    class177[] var72 = class22.method211();

                                    for(var24 = 0; var24 < var72.length; ++var24) {
                                       class177 var69 = var72[var24];
                                       if(var69.field2641 != -1 && var29.startsWith(class109.method2012(var69.field2641))) {
                                          var29 = var29.substring(6 + Integer.toString(var69.field2641).length());
                                          break;
                                       }
                                    }

                                    class32.field723[var5++] = class60.method1098(var29, false)?1:0;
                                    continue;
                                 }

                                 if(var16 == 3611) {
                                    if(Client.field507 != null) {
                                       class32.chatboxSegments[var6++] = class11.method155(Client.field507);
                                    } else {
                                       class32.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var16 == 3612) {
                                    if(Client.field507 != null) {
                                       class32.field723[var5++] = class142.field1984;
                                    } else {
                                       class32.field723[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var16 == 3613) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    if(null != Client.field507 && var17 < class142.field1984) {
                                       class32.chatboxSegments[var6++] = class30.clanMembers[var17].username;
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var16 == 3614) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    if(Client.field507 != null && var17 < class142.field1984) {
                                       class32.field723[var5++] = class30.clanMembers[var17].world;
                                       continue;
                                    }

                                    class32.field723[var5++] = 0;
                                    continue;
                                 }

                                 if(var16 == 3615) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    if(null != Client.field507 && var17 < class142.field1984) {
                                       class32.field723[var5++] = class30.clanMembers[var17].rank;
                                       continue;
                                    }

                                    class32.field723[var5++] = 0;
                                    continue;
                                 }

                                 if(var16 == 3616) {
                                    class32.field723[var5++] = class165.field2147;
                                    continue;
                                 }

                                 if(var16 == 3617) {
                                    --var6;
                                    var29 = class32.chatboxSegments[var6];
                                    if(class30.clanMembers != null) {
                                       Client.field326.method3029(251);
                                       Client.field326.method2760(class148.method2740(var29));
                                       Client.field326.method2811(var29);
                                    }
                                    continue;
                                 }

                                 if(var16 == 3618) {
                                    class32.field723[var5++] = class118.field1831;
                                    continue;
                                 }

                                 if(var16 == 3619) {
                                    --var6;
                                    var29 = class32.chatboxSegments[var6];
                                    class105.method1961(var29);
                                    continue;
                                 }

                                 if(var16 == 3620) {
                                    Client.field326.method3029(7);
                                    Client.field326.method2760(0);
                                    continue;
                                 }

                                 if(var16 == 3621) {
                                    if(Client.field465 == 0) {
                                       class32.field723[var5++] = -1;
                                    } else {
                                       class32.field723[var5++] = Client.ignoreCount;
                                    }
                                    continue;
                                 }

                                 if(var16 == 3622) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    if(Client.field465 != 0 && var17 < Client.ignoreCount) {
                                       class32.chatboxSegments[var6++] = Client.ignores[var17].name;
                                       class32.chatboxSegments[var6++] = Client.ignores[var17].previousName;
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var16 == 3623) {
                                    --var6;
                                    var29 = class32.chatboxSegments[var6];
                                    if(var29.startsWith(class109.method2012(0)) || var29.startsWith(class109.method2012(1))) {
                                       var29 = var29.substring(7);
                                    }

                                    class32.field723[var5++] = class164.method3115(var29)?1:0;
                                    continue;
                                 }

                                 if(var16 == 3624) {
                                    --var5;
                                    var17 = class32.field723[var5];
                                    if(class30.clanMembers != null && var17 < class142.field1984 && class30.clanMembers[var17].username.equalsIgnoreCase(class148.localPlayer.name)) {
                                       class32.field723[var5++] = 1;
                                       continue;
                                    }

                                    class32.field723[var5++] = 0;
                                    continue;
                                 }

                                 if(var16 == 3625) {
                                    if(null != Client.clanChatOwner) {
                                       class32.chatboxSegments[var6++] = class11.method155(Client.clanChatOwner);
                                    } else {
                                       class32.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }
                              } else {
                                 long var74;
                                 if(var16 < 4000) {
                                    if(var16 == 3903) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       class32.field723[var5++] = Client.grandExchangeOffers[var17].method51();
                                       continue;
                                    }

                                    if(var16 == 3904) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       class32.field723[var5++] = Client.grandExchangeOffers[var17].itemId;
                                       continue;
                                    }

                                    if(var16 == 3905) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       class32.field723[var5++] = Client.grandExchangeOffers[var17].price;
                                       continue;
                                    }

                                    if(var16 == 3906) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       class32.field723[var5++] = Client.grandExchangeOffers[var17].totalQuantity;
                                       continue;
                                    }

                                    if(var16 == 3907) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       class32.field723[var5++] = Client.grandExchangeOffers[var17].quantitySold;
                                       continue;
                                    }

                                    if(var16 == 3908) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       class32.field723[var5++] = Client.grandExchangeOffers[var17].spent;
                                       continue;
                                    }

                                    if(var16 == 3910) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var23 = Client.grandExchangeOffers[var17].method44();
                                       class32.field723[var5++] = var23 == 0?1:0;
                                       continue;
                                    }

                                    if(var16 == 3911) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var23 = Client.grandExchangeOffers[var17].method44();
                                       class32.field723[var5++] = var23 == 2?1:0;
                                       continue;
                                    }

                                    if(var16 == 3912) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var23 = Client.grandExchangeOffers[var17].method44();
                                       class32.field723[var5++] = var23 == 5?1:0;
                                       continue;
                                    }

                                    if(var16 == 3913) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var23 = Client.grandExchangeOffers[var17].method44();
                                       class32.field723[var5++] = var23 == 1?1:0;
                                       continue;
                                    }

                                    boolean var71;
                                    if(var16 == 3914) {
                                       --var5;
                                       var71 = class32.field723[var5] == 1;
                                       if(class11.field123 != null) {
                                          class11.field123.method10(class1.field10, var71);
                                       }
                                       continue;
                                    }

                                    if(var16 == 3915) {
                                       --var5;
                                       var71 = class32.field723[var5] == 1;
                                       if(null != class11.field123) {
                                          class11.field123.method10(class1.field9, var71);
                                       }
                                       continue;
                                    }

                                    if(var16 == 3916) {
                                       var5 -= 2;
                                       var71 = class32.field723[var5] == 1;
                                       var36 = class32.field723[1 + var5] == 1;
                                       if(class11.field123 != null) {
                                          class11.field123.method10(new class44(var36), var71);
                                       }
                                       continue;
                                    }

                                    if(var16 == 3917) {
                                       --var5;
                                       var71 = class32.field723[var5] == 1;
                                       if(class11.field123 != null) {
                                          class11.field123.method10(class1.field11, var71);
                                       }
                                       continue;
                                    }

                                    if(var16 == 3918) {
                                       --var5;
                                       var71 = class32.field723[var5] == 1;
                                       if(class11.field123 != null) {
                                          class11.field123.method10(class1.field8, var71);
                                       }
                                       continue;
                                    }

                                    if(var16 == 3919) {
                                       class32.field723[var5++] = null == class11.field123?0:class11.field123.field12.size();
                                       continue;
                                    }

                                    class2 var46;
                                    if(var16 == 3920) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var46 = (class2)class11.field123.field12.get(var17);
                                       class32.field723[var5++] = var46.field22;
                                       continue;
                                    }

                                    if(var16 == 3921) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var46 = (class2)class11.field123.field12.get(var17);
                                       class32.chatboxSegments[var6++] = var46.method18();
                                       continue;
                                    }

                                    if(var16 == 3922) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var46 = (class2)class11.field123.field12.get(var17);
                                       class32.chatboxSegments[var6++] = var46.method20();
                                       continue;
                                    }

                                    if(var16 == 3923) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var46 = (class2)class11.field123.field12.get(var17);
                                       var74 = class9.method117() - class5.field45 - var46.field17;
                                       var19 = (int)(var74 / 3600000L);
                                       var20 = (int)((var74 - (long)(var19 * 3600000)) / 60000L);
                                       var41 = (int)((var74 - (long)(3600000 * var19) - (long)(var20 * '\uea60')) / 1000L);
                                       String var47 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var41 / 10 + var41 % 10;
                                       class32.chatboxSegments[var6++] = var47;
                                       continue;
                                    }

                                    if(var16 == 3924) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var46 = (class2)class11.field123.field12.get(var17);
                                       class32.field723[var5++] = var46.field15.totalQuantity;
                                       continue;
                                    }

                                    if(var16 == 3925) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var46 = (class2)class11.field123.field12.get(var17);
                                       class32.field723[var5++] = var46.field15.price;
                                       continue;
                                    }

                                    if(var16 == 3926) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       var46 = (class2)class11.field123.field12.get(var17);
                                       class32.field723[var5++] = var46.field15.itemId;
                                       continue;
                                    }
                                 } else if(var16 < 4100) {
                                    if(var16 == 4000) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       class32.field723[var5++] = var17 + var23;
                                       continue;
                                    }

                                    if(var16 == 4001) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[var5 + 1];
                                       class32.field723[var5++] = var17 - var23;
                                       continue;
                                    }

                                    if(var16 == 4002) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       class32.field723[var5++] = var23 * var17;
                                       continue;
                                    }

                                    if(var16 == 4003) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       class32.field723[var5++] = var17 / var23;
                                       continue;
                                    }

                                    if(var16 == 4004) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       class32.field723[var5++] = (int)(Math.random() * (double)var17);
                                       continue;
                                    }

                                    if(var16 == 4005) {
                                       --var5;
                                       var17 = class32.field723[var5];
                                       class32.field723[var5++] = (int)(Math.random() * (double)(var17 + 1));
                                       continue;
                                    }

                                    if(var16 == 4006) {
                                       var5 -= 5;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       var24 = class32.field723[var5 + 2];
                                       var18 = class32.field723[3 + var5];
                                       var19 = class32.field723[var5 + 4];
                                       class32.field723[var5++] = (var19 - var24) * (var23 - var17) / (var18 - var24) + var17;
                                       continue;
                                    }

                                    if(var16 == 4007) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       class32.field723[var5++] = var17 * var23 / 100 + var17;
                                       continue;
                                    }

                                    if(var16 == 4008) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       class32.field723[var5++] = var17 | 1 << var23;
                                       continue;
                                    }

                                    if(var16 == 4009) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[var5 + 1];
                                       class32.field723[var5++] = var17 & -1 - (1 << var23);
                                       continue;
                                    }

                                    if(var16 == 4010) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       class32.field723[var5++] = (var17 & 1 << var23) != 0?1:0;
                                       continue;
                                    }

                                    if(var16 == 4011) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[var5 + 1];
                                       class32.field723[var5++] = var17 % var23;
                                       continue;
                                    }

                                    if(var16 == 4012) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[var5 + 1];
                                       if(var17 == 0) {
                                          class32.field723[var5++] = 0;
                                       } else {
                                          class32.field723[var5++] = (int)Math.pow((double)var17, (double)var23);
                                       }
                                       continue;
                                    }

                                    if(var16 == 4013) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       if(var17 == 0) {
                                          class32.field723[var5++] = 0;
                                       } else if(var23 == 0) {
                                          class32.field723[var5++] = Integer.MAX_VALUE;
                                       } else {
                                          class32.field723[var5++] = (int)Math.pow((double)var17, 1.0D / (double)var23);
                                       }
                                       continue;
                                    }

                                    if(var16 == 4014) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       class32.field723[var5++] = var17 & var23;
                                       continue;
                                    }

                                    if(var16 == 4015) {
                                       var5 -= 2;
                                       var17 = class32.field723[var5];
                                       var23 = class32.field723[1 + var5];
                                       class32.field723[var5++] = var17 | var23;
                                       continue;
                                    }

                                    if(var16 == 4018) {
                                       var5 -= 3;
                                       long var77 = (long)class32.field723[var5];
                                       var74 = (long)class32.field723[var5 + 1];
                                       long var75 = (long)class32.field723[var5 + 2];
                                       class32.field723[var5++] = (int)(var75 * var77 / var74);
                                       continue;
                                    }
                                 } else {
                                    int var78;
                                    if(var16 < 4200) {
                                       if(var16 == 4100) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          --var5;
                                          var23 = class32.field723[var5];
                                          class32.chatboxSegments[var6++] = var29 + var23;
                                          continue;
                                       }

                                       if(var16 == 4101) {
                                          var6 -= 2;
                                          var29 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[var6 + 1];
                                          class32.chatboxSegments[var6++] = var29 + var58;
                                          continue;
                                       }

                                       if(var16 == 4102) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          --var5;
                                          var23 = class32.field723[var5];
                                          var28 = class32.chatboxSegments;
                                          var18 = var6++;
                                          if(var23 < 0) {
                                             var27 = Integer.toString(var23);
                                          } else {
                                             var62 = var23;
                                             if(var23 < 0) {
                                                var21 = Integer.toString(var23, 10);
                                             } else {
                                                int var87 = 2;

                                                for(var78 = var23 / 10; var78 != 0; ++var87) {
                                                   var78 /= 10;
                                                }

                                                char[] var79 = new char[var87];
                                                var79[0] = 43;

                                                for(int var81 = var87 - 1; var81 > 0; --var81) {
                                                   int var85 = var62;
                                                   var62 /= 10;
                                                   int var50 = var85 - var62 * 10;
                                                   if(var50 >= 10) {
                                                      var79[var81] = (char)(87 + var50);
                                                   } else {
                                                      var79[var81] = (char)(48 + var50);
                                                   }
                                                }

                                                var21 = new String(var79);
                                             }

                                             var27 = var21;
                                          }

                                          var28[var18] = var29 + var27;
                                          continue;
                                       }

                                       if(var16 == 4103) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          class32.chatboxSegments[var6++] = var29.toLowerCase();
                                          continue;
                                       }

                                       if(var16 == 4104) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          long var84 = ((long)var17 + 11745L) * 86400000L;
                                          class32.field730.setTime(new Date(var84));
                                          var18 = class32.field730.get(5);
                                          var19 = class32.field730.get(2);
                                          var20 = class32.field730.get(1);
                                          class32.chatboxSegments[var6++] = var18 + "-" + class32.field728[var19] + "-" + var20;
                                          continue;
                                       }

                                       if(var16 == 4105) {
                                          var6 -= 2;
                                          var29 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[var6 + 1];
                                          if(null != class148.localPlayer.composition && class148.localPlayer.composition.isFemale) {
                                             class32.chatboxSegments[var6++] = var58;
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = var29;
                                          continue;
                                       }

                                       if(var16 == 4106) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          class32.chatboxSegments[var6++] = Integer.toString(var17);
                                          continue;
                                       }

                                       if(var16 == 4107) {
                                          var6 -= 2;
                                          int[] var83 = class32.field723;
                                          var23 = var5++;
                                          var18 = class171.method3235(class32.chatboxSegments[var6], class32.chatboxSegments[1 + var6], Client.field472);
                                          if(var18 > 0) {
                                             var26 = 1;
                                          } else if(var18 < 0) {
                                             var26 = -1;
                                          } else {
                                             var26 = 0;
                                          }

                                          var83[var23] = var26;
                                          continue;
                                       }

                                       byte[] var76;
                                       class208 var80;
                                       if(var16 == 4108) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var23 = class32.field723[var5];
                                          var24 = class32.field723[var5 + 1];
                                          var76 = class119.field1843.method3272(var24, 0);
                                          var80 = new class208(var76);
                                          class32.field723[var5++] = var80.method3865(var29, var23);
                                          continue;
                                       }

                                       if(var16 == 4109) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var23 = class32.field723[var5];
                                          var24 = class32.field723[var5 + 1];
                                          var76 = class119.field1843.method3272(var24, 0);
                                          var80 = new class208(var76);
                                          class32.field723[var5++] = var80.method3864(var29, var23);
                                          continue;
                                       }

                                       if(var16 == 4110) {
                                          var6 -= 2;
                                          var29 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[1 + var6];
                                          --var5;
                                          if(class32.field723[var5] == 1) {
                                             class32.chatboxSegments[var6++] = var29;
                                          } else {
                                             class32.chatboxSegments[var6++] = var58;
                                          }
                                          continue;
                                       }

                                       if(var16 == 4111) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          class32.chatboxSegments[var6++] = class209.method3866(var29);
                                          continue;
                                       }

                                       if(var16 == 4112) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          --var5;
                                          var23 = class32.field723[var5];
                                          class32.chatboxSegments[var6++] = var29 + (char)var23;
                                          continue;
                                       }

                                       char var48;
                                       if(var16 == 4113) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          var25 = class32.field723;
                                          var24 = var5++;
                                          var48 = (char)var17;
                                          if(var48 >= 32 && var48 <= 126) {
                                             var33 = true;
                                          } else if(var48 >= 160 && var48 <= 255) {
                                             var33 = true;
                                          } else if(var48 != 8364 && var48 != 338 && var48 != 8212 && var48 != 339 && var48 != 376) {
                                             var33 = false;
                                          } else {
                                             var33 = true;
                                          }

                                          var25[var24] = var33?1:0;
                                          continue;
                                       }

                                       if(var16 == 4114) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          class32.field723[var5++] = Frames.method1852((char)var17)?1:0;
                                          continue;
                                       }

                                       if(var16 == 4115) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          class32.field723[var5++] = Frames.method1848((char)var17)?1:0;
                                          continue;
                                       }

                                       if(var16 == 4116) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          class32.field723[var5++] = class186.method3412((char)var17)?1:0;
                                          continue;
                                       }

                                       if(var16 == 4117) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          if(var29 != null) {
                                             class32.field723[var5++] = var29.length();
                                          } else {
                                             class32.field723[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var16 == 4118) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var23 = class32.field723[var5];
                                          var24 = class32.field723[1 + var5];
                                          class32.chatboxSegments[var6++] = var29.substring(var23, var24);
                                          continue;
                                       }

                                       if(var16 == 4119) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          StringBuilder var49 = new StringBuilder(var29.length());
                                          var37 = false;

                                          for(var18 = 0; var18 < var29.length(); ++var18) {
                                             var48 = var29.charAt(var18);
                                             if(var48 == 60) {
                                                var37 = true;
                                             } else if(var48 == 62) {
                                                var37 = false;
                                             } else if(!var37) {
                                                var49.append(var48);
                                             }
                                          }

                                          class32.chatboxSegments[var6++] = var49.toString();
                                          continue;
                                       }

                                       if(var16 == 4120) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          --var5;
                                          var23 = class32.field723[var5];
                                          class32.field723[var5++] = var29.indexOf(var23);
                                          continue;
                                       }

                                       if(var16 == 4121) {
                                          var6 -= 2;
                                          var29 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[1 + var6];
                                          --var5;
                                          var24 = class32.field723[var5];
                                          class32.field723[var5++] = var29.indexOf(var58, var24);
                                          continue;
                                       }
                                    } else if(var16 < 4300) {
                                       if(var16 == 4200) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          class32.chatboxSegments[var6++] = class88.getItemDefinition(var17).name;
                                          continue;
                                       }

                                       ItemComposition var91;
                                       if(var16 == 4201) {
                                          var5 -= 2;
                                          var17 = class32.field723[var5];
                                          var23 = class32.field723[var5 + 1];
                                          var91 = class88.getItemDefinition(var17);
                                          if(var23 >= 1 && var23 <= 5 && null != var91.groundActions[var23 - 1]) {
                                             class32.chatboxSegments[var6++] = var91.groundActions[var23 - 1];
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var16 == 4202) {
                                          var5 -= 2;
                                          var17 = class32.field723[var5];
                                          var23 = class32.field723[1 + var5];
                                          var91 = class88.getItemDefinition(var17);
                                          if(var23 >= 1 && var23 <= 5 && var91.inventoryActions[var23 - 1] != null) {
                                             class32.chatboxSegments[var6++] = var91.inventoryActions[var23 - 1];
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var16 == 4203) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          class32.field723[var5++] = class88.getItemDefinition(var17).price;
                                          continue;
                                       }

                                       if(var16 == 4204) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          class32.field723[var5++] = class88.getItemDefinition(var17).isStackable == 1?1:0;
                                          continue;
                                       }

                                       ItemComposition var82;
                                       if(var16 == 4205) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          var82 = class88.getItemDefinition(var17);
                                          if(var82.notedTemplate == -1 && var82.note >= 0) {
                                             class32.field723[var5++] = var82.note;
                                             continue;
                                          }

                                          class32.field723[var5++] = var17;
                                          continue;
                                       }

                                       if(var16 == 4206) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          var82 = class88.getItemDefinition(var17);
                                          if(var82.notedTemplate >= 0 && var82.note >= 0) {
                                             class32.field723[var5++] = var82.note;
                                             continue;
                                          }

                                          class32.field723[var5++] = var17;
                                          continue;
                                       }

                                       if(var16 == 4207) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          class32.field723[var5++] = class88.getItemDefinition(var17).isMembers?1:0;
                                          continue;
                                       }

                                       if(var16 == 4208) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          var82 = class88.getItemDefinition(var17);
                                          if(var82.field2942 == -1 && var82.field2984 >= 0) {
                                             class32.field723[var5++] = var82.field2984;
                                             continue;
                                          }

                                          class32.field723[var5++] = var17;
                                          continue;
                                       }

                                       if(var16 == 4209) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          var82 = class88.getItemDefinition(var17);
                                          if(var82.field2942 >= 0 && var82.field2984 >= 0) {
                                             class32.field723[var5++] = var82.field2984;
                                             continue;
                                          }

                                          class32.field723[var5++] = var17;
                                          continue;
                                       }

                                       if(var16 == 4210) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          --var5;
                                          var23 = class32.field723[var5];
                                          var33 = var23 == 1;
                                          var22 = var29.toLowerCase();
                                          short[] var86 = new short[16];
                                          var20 = 0;
                                          var41 = 0;

                                          while(true) {
                                             short[] var94;
                                             if(var41 >= ItemComposition.field2975) {
                                                Projectile.field874 = var86;
                                                class149.field2024 = 0;
                                                DecorativeObject.field1596 = var20;
                                                String[] var90 = new String[DecorativeObject.field1596];

                                                for(var62 = 0; var62 < DecorativeObject.field1596; ++var62) {
                                                   var90[var62] = class88.getItemDefinition(var86[var62]).name;
                                                }

                                                var94 = Projectile.field874;
                                                CombatInfo1.method623(var90, var94, 0, var90.length - 1);
                                                break;
                                             }

                                             ItemComposition var88 = class88.getItemDefinition(var41);
                                             if((!var33 || var88.field2981) && var88.notedTemplate == -1 && var88.name.toLowerCase().indexOf(var22) != -1) {
                                                if(var20 >= 250) {
                                                   DecorativeObject.field1596 = -1;
                                                   Projectile.field874 = null;
                                                   break;
                                                }

                                                if(var20 >= var86.length) {
                                                   var94 = new short[var86.length * 2];

                                                   for(var78 = 0; var78 < var20; ++var78) {
                                                      var94[var78] = var86[var78];
                                                   }

                                                   var86 = var94;
                                                }

                                                var86[var20++] = (short)var41;
                                             }

                                             ++var41;
                                          }

                                          class32.field723[var5++] = DecorativeObject.field1596;
                                          continue;
                                       }

                                       if(var16 == 4211) {
                                          if(null != Projectile.field874 && class149.field2024 < DecorativeObject.field1596) {
                                             class32.field723[var5++] = Projectile.field874[++class149.field2024 - 1] & '\uffff';
                                             continue;
                                          }

                                          class32.field723[var5++] = -1;
                                          continue;
                                       }

                                       if(var16 == 4212) {
                                          class149.field2024 = 0;
                                          continue;
                                       }
                                    } else if(var16 < 5100) {
                                       if(var16 == 5000) {
                                          class32.field723[var5++] = Client.field498;
                                          continue;
                                       }

                                       if(var16 == 5001) {
                                          var5 -= 3;
                                          Client.field498 = class32.field723[var5];
                                          var23 = class32.field723[1 + var5];
                                          class216[] var105 = new class216[]{class216.field3162, class216.field3165, class216.field3163};
                                          class216[] var102 = var105;
                                          var19 = 0;

                                          class216 var95;
                                          while(true) {
                                             if(var19 >= var102.length) {
                                                var95 = null;
                                                break;
                                             }

                                             class216 var96 = var102[var19];
                                             if(var23 == var96.field3161) {
                                                var95 = var96;
                                                break;
                                             }

                                             ++var19;
                                          }

                                          FrameMap.field1467 = var95;
                                          if(null == FrameMap.field1467) {
                                             FrameMap.field1467 = class216.field3165;
                                          }

                                          Client.field499 = class32.field723[var5 + 2];
                                          Client.field326.method3029(73);
                                          Client.field326.method2760(Client.field498);
                                          Client.field326.method2760(FrameMap.field1467.field3161);
                                          Client.field326.method2760(Client.field499);
                                          continue;
                                       }

                                       if(var16 == 5002) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var23 = class32.field723[var5];
                                          var24 = class32.field723[1 + var5];
                                          Client.field326.method3029(81);
                                          Client.field326.method2760(class148.method2740(var29) + 2);
                                          Client.field326.method2811(var29);
                                          Client.field326.method2760(var23 - 1);
                                          Client.field326.method2760(var24);
                                          continue;
                                       }

                                       ChatLineBuffer var98;
                                       if(var16 == 5003) {
                                          var5 -= 2;
                                          var17 = class32.field723[var5];
                                          var23 = class32.field723[var5 + 1];
                                          var98 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var17));
                                          MessageNode var101 = var98.method876(var23);
                                          if(null != var101) {
                                             class32.field723[var5++] = var101.id;
                                             class32.field723[var5++] = var101.tick;
                                             class32.chatboxSegments[var6++] = null != var101.name?var101.name:"";
                                             class32.chatboxSegments[var6++] = null != var101.sender?var101.sender:"";
                                             class32.chatboxSegments[var6++] = null != var101.value?var101.value:"";
                                          } else {
                                             class32.field723[var5++] = -1;
                                             class32.field723[var5++] = 0;
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       MessageNode var97;
                                       if(var16 == 5004) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          var97 = (MessageNode)class47.field922.method2300((long)var17);
                                          if(var97 != null) {
                                             class32.field723[var5++] = var97.type;
                                             class32.field723[var5++] = var97.tick;
                                             class32.chatboxSegments[var6++] = null != var97.name?var97.name:"";
                                             class32.chatboxSegments[var6++] = null != var97.sender?var97.sender:"";
                                             class32.chatboxSegments[var6++] = null != var97.value?var97.value:"";
                                          } else {
                                             class32.field723[var5++] = -1;
                                             class32.field723[var5++] = 0;
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var16 == 5005) {
                                          if(FrameMap.field1467 == null) {
                                             class32.field723[var5++] = -1;
                                          } else {
                                             class32.field723[var5++] = FrameMap.field1467.field3161;
                                          }
                                          continue;
                                       }

                                       if(var16 == 5008) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          --var5;
                                          var23 = class32.field723[var5];
                                          var22 = var29.toLowerCase();
                                          byte var100 = 0;
                                          if(var22.startsWith("yellow:")) {
                                             var100 = 0;
                                             var29 = var29.substring("yellow:".length());
                                          } else if(var22.startsWith("red:")) {
                                             var100 = 1;
                                             var29 = var29.substring("red:".length());
                                          } else if(var22.startsWith("green:")) {
                                             var100 = 2;
                                             var29 = var29.substring("green:".length());
                                          } else if(var22.startsWith("cyan:")) {
                                             var100 = 3;
                                             var29 = var29.substring("cyan:".length());
                                          } else if(var22.startsWith("purple:")) {
                                             var100 = 4;
                                             var29 = var29.substring("purple:".length());
                                          } else if(var22.startsWith("white:")) {
                                             var100 = 5;
                                             var29 = var29.substring("white:".length());
                                          } else if(var22.startsWith("flash1:")) {
                                             var100 = 6;
                                             var29 = var29.substring("flash1:".length());
                                          } else if(var22.startsWith("flash2:")) {
                                             var100 = 7;
                                             var29 = var29.substring("flash2:".length());
                                          } else if(var22.startsWith("flash3:")) {
                                             var100 = 8;
                                             var29 = var29.substring("flash3:".length());
                                          } else if(var22.startsWith("glow1:")) {
                                             var100 = 9;
                                             var29 = var29.substring("glow1:".length());
                                          } else if(var22.startsWith("glow2:")) {
                                             var100 = 10;
                                             var29 = var29.substring("glow2:".length());
                                          } else if(var22.startsWith("glow3:")) {
                                             var100 = 11;
                                             var29 = var29.substring("glow3:".length());
                                          } else if(Client.field472 != 0) {
                                             if(var22.startsWith("yellow:")) {
                                                var100 = 0;
                                                var29 = var29.substring("yellow:".length());
                                             } else if(var22.startsWith("red:")) {
                                                var100 = 1;
                                                var29 = var29.substring("red:".length());
                                             } else if(var22.startsWith("green:")) {
                                                var100 = 2;
                                                var29 = var29.substring("green:".length());
                                             } else if(var22.startsWith("cyan:")) {
                                                var100 = 3;
                                                var29 = var29.substring("cyan:".length());
                                             } else if(var22.startsWith("purple:")) {
                                                var100 = 4;
                                                var29 = var29.substring("purple:".length());
                                             } else if(var22.startsWith("white:")) {
                                                var100 = 5;
                                                var29 = var29.substring("white:".length());
                                             } else if(var22.startsWith("flash1:")) {
                                                var100 = 6;
                                                var29 = var29.substring("flash1:".length());
                                             } else if(var22.startsWith("flash2:")) {
                                                var100 = 7;
                                                var29 = var29.substring("flash2:".length());
                                             } else if(var22.startsWith("flash3:")) {
                                                var100 = 8;
                                                var29 = var29.substring("flash3:".length());
                                             } else if(var22.startsWith("glow1:")) {
                                                var100 = 9;
                                                var29 = var29.substring("glow1:".length());
                                             } else if(var22.startsWith("glow2:")) {
                                                var100 = 10;
                                                var29 = var29.substring("glow2:".length());
                                             } else if(var22.startsWith("glow3:")) {
                                                var100 = 11;
                                                var29 = var29.substring("glow3:".length());
                                             }
                                          }

                                          var22 = var29.toLowerCase();
                                          byte var89 = 0;
                                          if(var22.startsWith("wave:")) {
                                             var89 = 1;
                                             var29 = var29.substring("wave:".length());
                                          } else if(var22.startsWith("wave2:")) {
                                             var89 = 2;
                                             var29 = var29.substring("wave2:".length());
                                          } else if(var22.startsWith("shake:")) {
                                             var89 = 3;
                                             var29 = var29.substring("shake:".length());
                                          } else if(var22.startsWith("scroll:")) {
                                             var89 = 4;
                                             var29 = var29.substring("scroll:".length());
                                          } else if(var22.startsWith("slide:")) {
                                             var89 = 5;
                                             var29 = var29.substring("slide:".length());
                                          } else if(Client.field472 != 0) {
                                             if(var22.startsWith("wave:")) {
                                                var89 = 1;
                                                var29 = var29.substring("wave:".length());
                                             } else if(var22.startsWith("wave2:")) {
                                                var89 = 2;
                                                var29 = var29.substring("wave2:".length());
                                             } else if(var22.startsWith("shake:")) {
                                                var89 = 3;
                                                var29 = var29.substring("shake:".length());
                                             } else if(var22.startsWith("scroll:")) {
                                                var89 = 4;
                                                var29 = var29.substring("scroll:".length());
                                             } else if(var22.startsWith("slide:")) {
                                                var89 = 5;
                                                var29 = var29.substring("slide:".length());
                                             }
                                          }

                                          Client.field326.method3029(174);
                                          Client.field326.method2760(0);
                                          var20 = Client.field326.offset;
                                          Client.field326.method2760(var23);
                                          Client.field326.method2760(var100);
                                          Client.field326.method2760(var89);
                                          class159 var92 = Client.field326;
                                          var62 = var92.offset;
                                          byte[] var93 = class183.method3353(var29);
                                          var92.method2900(var93.length);
                                          var92.offset += class210.field3106.method2709(var93, 0, var93.length, var92.payload, var92.offset);
                                          Client.field326.method2772(Client.field326.offset - var20);
                                          continue;
                                       }

                                       if(var16 == 5009) {
                                          var6 -= 2;
                                          var29 = class32.chatboxSegments[var6];
                                          var58 = class32.chatboxSegments[1 + var6];
                                          Client.field326.method3029(65);
                                          Client.field326.method2918(0);
                                          var24 = Client.field326.offset;
                                          Client.field326.method2811(var29);
                                          class159 var99 = Client.field326;
                                          var19 = var99.offset;
                                          var42 = class183.method3353(var58);
                                          var99.method2900(var42.length);
                                          var99.offset += class210.field3106.method2709(var42, 0, var42.length, var99.payload, var99.offset);
                                          Client.field326.method2771(Client.field326.offset - var24);
                                          continue;
                                       }

                                       if(var16 == 5015) {
                                          if(null != class148.localPlayer && null != class148.localPlayer.name) {
                                             var29 = class148.localPlayer.name;
                                          } else {
                                             var29 = "";
                                          }

                                          class32.chatboxSegments[var6++] = var29;
                                          continue;
                                       }

                                       if(var16 == 5016) {
                                          class32.field723[var5++] = Client.field499;
                                          continue;
                                       }

                                       if(var16 == 5017) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          var25 = class32.field723;
                                          var24 = var5++;
                                          var98 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var17));
                                          if(var98 == null) {
                                             var18 = 0;
                                          } else {
                                             var18 = var98.method877();
                                          }

                                          var25[var24] = var18;
                                          continue;
                                       }

                                       if(var16 == 5018) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          class32.field723[var5++] = class191.method3478(var17);
                                          continue;
                                       }

                                       if(var16 == 5019) {
                                          --var5;
                                          var17 = class32.field723[var5];
                                          var25 = class32.field723;
                                          var24 = var5++;
                                          var97 = (MessageNode)class47.field922.method2300((long)var17);
                                          if(var97 == null) {
                                             var18 = -1;
                                          } else if(class47.field921.field1886 == var97.next) {
                                             var18 = -1;
                                          } else {
                                             var18 = ((MessageNode)var97.next).id;
                                          }

                                          var25[var24] = var18;
                                          continue;
                                       }

                                       if(var16 == 5020) {
                                          --var6;
                                          var29 = class32.chatboxSegments[var6];
                                          if(var29.equalsIgnoreCase("toggleroof")) {
                                             class2.field21.field690 = !class2.field21.field690;
                                             class7.method108();
                                             if(class2.field21.field690) {
                                                class7.method99(99, "", "Roofs are now all hidden");
                                             } else {
                                                class7.method99(99, "", "Roofs will only be removed selectively");
                                             }
                                          }

                                          if(var29.equalsIgnoreCase("displayfps")) {
                                             Client.field296 = !Client.field296;
                                          }

                                          if(Client.field352 >= 2) {
                                             if(var29.equalsIgnoreCase("fpson")) {
                                                Client.field296 = true;
                                             }

                                             if(var29.equalsIgnoreCase("fpsoff")) {
                                                Client.field296 = false;
                                             }

                                             if(var29.equalsIgnoreCase("gc")) {
                                                System.gc();
                                             }

                                             if(var29.equalsIgnoreCase("clientdrop")) {
                                                Frames.method1851();
                                             }

                                             if(var29.equalsIgnoreCase("errortest") && Client.field416 == 2) {
                                                throw new RuntimeException();
                                             }
                                          }

                                          Client.field326.method3029(64);
                                          Client.field326.method2760(var29.length() + 1);
                                          Client.field326.method2811(var29);
                                          continue;
                                       }

                                       if(var16 == 5021) {
                                          --var6;
                                          Client.field554 = class32.chatboxSegments[var6].toLowerCase().trim();
                                          continue;
                                       }

                                       if(var16 == 5022) {
                                          class32.chatboxSegments[var6++] = Client.field554;
                                          continue;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  } else {
                     var23 = -1;
                     if(var16 >= 2000) {
                        var16 -= 1000;
                        --var5;
                        var23 = class32.field723[var5];
                        var32 = class44.method799(var23);
                     } else {
                        var32 = var30?WidgetNode.field187:class38.field789;
                     }

                     if(var16 == 1100) {
                        var5 -= 2;
                        var32.scrollX = class32.field723[var5];
                        if(var32.scrollX > var32.scrollWidth - var32.width) {
                           var32.scrollX = var32.scrollWidth - var32.width;
                        }

                        if(var32.scrollX < 0) {
                           var32.scrollX = 0;
                        }

                        var32.scrollY = class32.field723[var5 + 1];
                        if(var32.scrollY > var32.scrollHeight - var32.height) {
                           var32.scrollY = var32.scrollHeight - var32.height;
                        }

                        if(var32.scrollY < 0) {
                           var32.scrollY = 0;
                        }

                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1101) {
                        --var5;
                        var32.textColor = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1102) {
                        --var5;
                        var32.field2235 = class32.field723[var5] == 1;
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1103) {
                        --var5;
                        var32.opacity = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1104) {
                        --var5;
                        var32.field2236 = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1105) {
                        --var5;
                        var32.textureId = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1106) {
                        --var5;
                        var32.field2222 = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1107) {
                        --var5;
                        var32.field2223 = class32.field723[var5] == 1;
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1108) {
                        var32.modelType = 1;
                        --var5;
                        var32.modelId = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1109) {
                        var5 -= 6;
                        var32.field2234 = class32.field723[var5];
                        var32.field2178 = class32.field723[1 + var5];
                        var32.rotationX = class32.field723[var5 + 2];
                        var32.rotationZ = class32.field723[var5 + 3];
                        var32.rotationY = class32.field723[var5 + 4];
                        var32.field2239 = class32.field723[5 + var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1110) {
                        --var5;
                        var24 = class32.field723[var5];
                        if(var32.field2250 != var24) {
                           var32.field2250 = var24;
                           var32.field2215 = 0;
                           var32.field2308 = 0;
                           class6.method87(var32);
                        }
                        continue;
                     }

                     if(var16 == 1111) {
                        --var5;
                        var32.field2242 = class32.field723[var5] == 1;
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1112) {
                        --var6;
                        var22 = class32.chatboxSegments[var6];
                        if(!var22.equals(var32.text)) {
                           var32.text = var22;
                           class6.method87(var32);
                        }
                        continue;
                     }

                     if(var16 == 1113) {
                        --var5;
                        var32.field2217 = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1114) {
                        var5 -= 3;
                        var32.field2176 = class32.field723[var5];
                        var32.field2214 = class32.field723[var5 + 1];
                        var32.field2247 = class32.field723[var5 + 2];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1115) {
                        --var5;
                        var32.field2218 = class32.field723[var5] == 1;
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1116) {
                        --var5;
                        var32.borderThickness = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1117) {
                        --var5;
                        var32.sprite2 = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1118) {
                        --var5;
                        var32.flippedVertically = class32.field723[var5] == 1;
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1119) {
                        --var5;
                        var32.flippedHorizontally = class32.field723[var5] == 1;
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1120) {
                        var5 -= 2;
                        var32.scrollWidth = class32.field723[var5];
                        var32.scrollHeight = class32.field723[var5 + 1];
                        class6.method87(var32);
                        if(var23 != -1 && var32.type == 0) {
                           class6.method97(Widget.widgets[var23 >> 16], var32, false);
                        }
                        continue;
                     }

                     if(var16 == 1121) {
                        class140.method2606(var32.id, var32.index);
                        Client.field537 = var32;
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1122) {
                        --var5;
                        var32.field2240 = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1123) {
                        --var5;
                        var32.field2211 = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1124) {
                        --var5;
                        var32.field2280 = class32.field723[var5];
                        class6.method87(var32);
                        continue;
                     }

                     if(var16 == 1125) {
                        --var5;
                        var24 = class32.field723[var5];
                        class221[] var38 = new class221[]{class221.field3185, class221.field3182, class221.field3183, class221.field3184, class221.field3188};
                        class221 var39 = (class221)class181.method3258(var38, var24);
                        if(var39 != null) {
                           var32.field2219 = var39;
                           class6.method87(var32);
                        }
                        continue;
                     }
                  }
               }

               if(var16 < 5400) {
                  if(var16 == 5306) {
                     class32.field723[var5++] = class182.method3335();
                     continue;
                  }

                  if(var16 == 5307) {
                     --var5;
                     var17 = class32.field723[var5];
                     if(var17 != 1 && var17 != 2) {
                        continue;
                     }

                     Client.field379 = 0L;
                     if(var17 >= 2) {
                        Client.isResized = true;
                     } else {
                        Client.isResized = false;
                     }

                     class31.method682();
                     if(Client.gameState >= 25) {
                        Client.field326.method3029(112);
                        Client.field326.method2760(class182.method3335());
                        Client.field326.method2918(class0.field1);
                        Client.field326.method2918(class65.field1099);
                     }

                     GameEngine.field1768 = true;
                     continue;
                  }

                  if(var16 == 5308) {
                     class32.field723[var5++] = class2.field21.field687;
                     continue;
                  }

                  if(var16 == 5309) {
                     --var5;
                     var17 = class32.field723[var5];
                     if(var17 == 1 || var17 == 2) {
                        class2.field21.field687 = var17;
                        class7.method108();
                     }
                     continue;
                  }
               }

               if(var16 < 5600) {
                  if(var16 == 5504) {
                     var5 -= 2;
                     var17 = class32.field723[var5];
                     var23 = class32.field723[1 + var5];
                     if(!Client.field529) {
                        Client.field520 = var17;
                        Client.mapAngle = var23;
                     }
                     continue;
                  }

                  if(var16 == 5505) {
                     class32.field723[var5++] = Client.field520;
                     continue;
                  }

                  if(var16 == 5506) {
                     class32.field723[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var16 == 5530) {
                     --var5;
                     var17 = class32.field723[var5];
                     if(var17 < 0) {
                        var17 = 0;
                     }

                     Client.field372 = var17;
                     continue;
                  }

                  if(var16 == 5531) {
                     class32.field723[var5++] = Client.field372;
                     continue;
                  }
               }

               if(var16 < 5700 && var16 == 5630) {
                  Client.field336 = 250;
               } else {
                  if(var16 < 6300) {
                     if(var16 == 6200) {
                        var5 -= 2;
                        Client.field535 = (short)class32.field723[var5];
                        if(Client.field535 <= 0) {
                           Client.field535 = 256;
                        }

                        Client.field536 = (short)class32.field723[1 + var5];
                        if(Client.field536 <= 0) {
                           Client.field536 = 205;
                        }
                        continue;
                     }

                     if(var16 == 6201) {
                        var5 -= 2;
                        Client.field389 = (short)class32.field723[var5];
                        if(Client.field389 <= 0) {
                           Client.field389 = 256;
                        }

                        Client.field538 = (short)class32.field723[var5 + 1];
                        if(Client.field538 <= 0) {
                           Client.field538 = 320;
                        }
                        continue;
                     }

                     if(var16 == 6202) {
                        var5 -= 4;
                        Client.field539 = (short)class32.field723[var5];
                        if(Client.field539 <= 0) {
                           Client.field539 = 1;
                        }

                        Client.field540 = (short)class32.field723[1 + var5];
                        if(Client.field540 <= 0) {
                           Client.field540 = 32767;
                        } else if(Client.field540 < Client.field539) {
                           Client.field540 = Client.field539;
                        }

                        Client.field541 = (short)class32.field723[var5 + 2];
                        if(Client.field541 <= 0) {
                           Client.field541 = 1;
                        }

                        Client.field513 = (short)class32.field723[3 + var5];
                        if(Client.field513 <= 0) {
                           Client.field513 = 32767;
                        } else if(Client.field513 < Client.field541) {
                           Client.field513 = Client.field541;
                        }
                        continue;
                     }

                     if(var16 == 6203) {
                        if(null != Client.field452) {
                           ItemComposition.method3697(0, 0, Client.field452.width, Client.field452.height, false);
                           class32.field723[var5++] = Client.camera2;
                           class32.field723[var5++] = Client.camera3;
                        } else {
                           class32.field723[var5++] = -1;
                           class32.field723[var5++] = -1;
                        }
                        continue;
                     }

                     if(var16 == 6204) {
                        class32.field723[var5++] = Client.field389;
                        class32.field723[var5++] = Client.field538;
                        continue;
                     }

                     if(var16 == 6205) {
                        class32.field723[var5++] = Client.field535;
                        class32.field723[var5++] = Client.field536;
                        continue;
                     }
                  }

                  if(var16 < 6600) {
                     if(var16 == 6500) {
                        class32.field723[var5++] = class97.loadWorlds()?1:0;
                        continue;
                     }

                     World var59;
                     if(var16 == 6501) {
                        World.field675 = 0;
                        if(World.field675 < World.field684) {
                           var59 = World.worldList[++World.field675 - 1];
                        } else {
                           var59 = null;
                        }

                        if(var59 != null) {
                           class32.field723[var5++] = var59.id;
                           class32.field723[var5++] = var59.mask;
                           class32.chatboxSegments[var6++] = var59.activity;
                           class32.field723[var5++] = var59.location;
                           class32.field723[var5++] = var59.playerCount;
                           class32.chatboxSegments[var6++] = var59.address;
                        } else {
                           class32.field723[var5++] = -1;
                           class32.field723[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field723[var5++] = 0;
                           class32.field723[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var16 == 6502) {
                        World var65;
                        if(World.field675 < World.field684) {
                           var65 = World.worldList[++World.field675 - 1];
                        } else {
                           var65 = null;
                        }

                        if(null != var65) {
                           class32.field723[var5++] = var65.id;
                           class32.field723[var5++] = var65.mask;
                           class32.chatboxSegments[var6++] = var65.activity;
                           class32.field723[var5++] = var65.location;
                           class32.field723[var5++] = var65.playerCount;
                           class32.chatboxSegments[var6++] = var65.address;
                        } else {
                           class32.field723[var5++] = -1;
                           class32.field723[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field723[var5++] = 0;
                           class32.field723[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var16 == 6506) {
                        --var5;
                        var17 = class32.field723[var5];
                        var59 = null;

                        for(var24 = 0; var24 < World.field684; ++var24) {
                           if(World.worldList[var24].id == var17) {
                              var59 = World.worldList[var24];
                              break;
                           }
                        }

                        if(var59 != null) {
                           class32.field723[var5++] = var59.id;
                           class32.field723[var5++] = var59.mask;
                           class32.chatboxSegments[var6++] = var59.activity;
                           class32.field723[var5++] = var59.location;
                           class32.field723[var5++] = var59.playerCount;
                           class32.chatboxSegments[var6++] = var59.address;
                        } else {
                           class32.field723[var5++] = -1;
                           class32.field723[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field723[var5++] = 0;
                           class32.field723[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var16 == 6507) {
                        var5 -= 4;
                        var17 = class32.field723[var5];
                        var36 = class32.field723[1 + var5] == 1;
                        var24 = class32.field723[2 + var5];
                        var33 = class32.field723[var5 + 3] == 1;
                        class30.method666(var17, var36, var24, var33);
                        continue;
                     }

                     if(var16 == 6511) {
                        --var5;
                        var17 = class32.field723[var5];
                        if(var17 >= 0 && var17 < World.field684) {
                           var59 = World.worldList[var17];
                           class32.field723[var5++] = var59.id;
                           class32.field723[var5++] = var59.mask;
                           class32.chatboxSegments[var6++] = var59.activity;
                           class32.field723[var5++] = var59.location;
                           class32.field723[var5++] = var59.playerCount;
                           class32.chatboxSegments[var6++] = var59.address;
                           continue;
                        }

                        class32.field723[var5++] = -1;
                        class32.field723[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        class32.field723[var5++] = 0;
                        class32.field723[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var51) {
            StringBuilder var13 = new StringBuilder(30);
            var13.append("").append(var4.hash).append(" ");

            for(var11 = class32.field725 - 1; var11 >= 0; --var11) {
               var13.append("").append(class32.field726[var11].field124.hash).append(" ");
            }

            var13.append("").append(var10);
            class174.method3240(var13.toString(), var51);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "-16711936"
   )
   public static void method873(Applet var0, String var1) {
      class114.field1778 = var0;
      class114.field1775 = var1;
   }

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field948 = var1;
      this.field942 = var2;
      this.field941 = var3;
      this.field944 = var4;
      this.field945 = var5;
      this.field946 = var6;
      if(var7 != -1) {
         this.field947 = CombatInfo2.getAnimation(var7);
         this.field955 = 0;
         this.field953 = Client.gameCycle - 1;
         if(this.field947.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(this.field947 == var10.field947) {
               this.field955 = var10.field955;
               this.field953 = var10.field953;
               return;
            }
         }

         if(var8 && this.field947.frameStep != -1) {
            this.field955 = (int)(Math.random() * (double)this.field947.frameIDs.length);
            this.field953 -= (int)(Math.random() * (double)this.field947.frameLenghts[this.field955]);
         }
      }

   }
}
