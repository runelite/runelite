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
         int var12 = Client.gameCycle - this.field953;
         if(var12 > 100 && this.field947.frameStep > 0) {
            var12 = 100;
         }

         label68: {
            do {
               do {
                  if(var12 <= this.field947.frameLenghts[this.field955]) {
                     break label68;
                  }

                  var12 -= this.field947.frameLenghts[this.field955];
                  ++this.field955;
               } while(this.field955 < this.field947.frameIDs.length);

               this.field955 -= this.field947.frameStep;
            } while(this.field955 >= 0 && this.field955 < this.field947.frameIDs.length);

            this.field947 = null;
         }

         this.field953 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = Tile.getObjectDefinition(this.field948);
      if(null != var1.impostorIds) {
         var1 = var1.getImpostor();
      }

      if(var1 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field941 != 1 && this.field941 != 3) {
            var2 = var1.field2895;
            var3 = var1.field2931;
         } else {
            var2 = var1.field2931;
            var3 = var1.field2895;
         }

         int var4 = this.field945 + (var2 >> 1);
         int var5 = (1 + var2 >> 1) + this.field945;
         int var6 = (var3 >> 1) + this.field946;
         int var7 = this.field946 + (1 + var3 >> 1);
         int[][] var8 = class10.tileHeights[this.field944];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.field945 << 7) + (var2 << 6);
         int var11 = (var3 << 6) + (this.field946 << 7);
         return var1.method3614(this.field942, this.field941, var8, var10, var9, var11, this.field947, this.field955);
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

         int var13;
         try {
            class32.field719 = new int[var4.field934];
            int var11 = 0;
            class32.field717 = new String[var4.field932];
            int var12 = 0;

            int var14;
            String var29;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
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

                  class32.field719[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var29 = (String)var2[var13];
                  if(var29.equals("event_opbase")) {
                     var29 = var0.field197;
                  }

                  class32.field717[var12++] = var29;
               }
            }

            var13 = 0;
            class32.field722 = var0.field198;

            label3659:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var42 = var8[var7];
               int var15;
               int var18;
               int var19;
               int var20;
               String var21;
               String var31;
               int var35;
               int var43;
               int[] var44;
               byte var56;
               String var73;
               String[] var74;
               String var100;
               if(var42 < 100) {
                  if(var42 == 0) {
                     class32.field723[var5++] = var9[var7];
                     continue;
                  }

                  if(var42 == 1) {
                     var14 = var9[var7];
                     class32.field723[var5++] = class165.widgetSettings[var14];
                     continue;
                  }

                  if(var42 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class165.widgetSettings[var14] = class32.field723[var5];
                     CombatInfo2.method3532(var14);
                     continue;
                  }

                  if(var42 == 3) {
                     class32.chatboxSegments[var6++] = var4.field930[var7];
                     continue;
                  }

                  if(var42 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var42 == 7) {
                     var5 -= 2;
                     if(class32.field723[var5] != class32.field723[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 8) {
                     var5 -= 2;
                     if(class32.field723[1 + var5] == class32.field723[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 9) {
                     var5 -= 2;
                     if(class32.field723[var5] < class32.field723[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 10) {
                     var5 -= 2;
                     if(class32.field723[var5] > class32.field723[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 21) {
                     if(class32.field725 == 0) {
                        return;
                     }

                     class11 var65 = class32.field726[--class32.field725];
                     var4 = var65.field124;
                     var8 = var4.field928;
                     var9 = var4.field935;
                     var7 = var65.field116;
                     class32.field719 = var65.field117;
                     class32.field717 = var65.field118;
                     continue;
                  }

                  if(var42 == 25) {
                     var14 = var9[var7];
                     class32.field723[var5++] = class101.method1911(var14);
                     continue;
                  }

                  if(var42 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field723[var5];
                     class194 var69 = class65.method1124(var14);
                     var43 = var69.field2833;
                     var18 = var69.field2831;
                     var19 = var69.field2835;
                     var20 = class165.field2149[var19 - var18];
                     if(var15 < 0 || var15 > var20) {
                        var15 = 0;
                     }

                     var20 <<= var18;
                     class165.widgetSettings[var43] = class165.widgetSettings[var43] & ~var20 | var15 << var18 & var20;
                     continue;
                  }

                  if(var42 == 31) {
                     var5 -= 2;
                     if(class32.field723[var5] <= class32.field723[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 32) {
                     var5 -= 2;
                     if(class32.field723[var5] >= class32.field723[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 33) {
                     class32.field723[var5++] = class32.field719[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var42 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class32.field719[var10001] = class32.field723[var5];
                     continue;
                  }

                  if(var42 == 35) {
                     class32.chatboxSegments[var6++] = class32.field717[var9[var7]];
                     continue;
                  }

                  if(var42 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class32.field717[var10001] = class32.chatboxSegments[var6];
                     continue;
                  }

                  if(var42 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var68 = class32.chatboxSegments;
                     if(var14 == 0) {
                        var100 = "";
                     } else if(var14 == 1) {
                        var31 = var68[var6];
                        if(var31 == null) {
                           var100 = "null";
                        } else {
                           var100 = var31.toString();
                        }
                     } else {
                        var43 = var6 + var14;
                        var18 = 0;

                        for(var19 = var6; var19 < var43; ++var19) {
                           var73 = var68[var19];
                           if(null == var73) {
                              var18 += 4;
                           } else {
                              var18 += var73.length();
                           }
                        }

                        StringBuilder var101 = new StringBuilder(var18);

                        for(var20 = var6; var20 < var43; ++var20) {
                           var21 = var68[var20];
                           if(var21 == null) {
                              var101.append("null");
                           } else {
                              var101.append(var21);
                           }
                        }

                        var100 = var101.toString();
                     }

                     class32.chatboxSegments[var6++] = var100;
                     continue;
                  }

                  if(var42 == 38) {
                     --var5;
                     continue;
                  }

                  if(var42 == 39) {
                     --var6;
                     continue;
                  }

                  if(var42 == 40) {
                     var14 = var9[var7];
                     class48 var110 = class47.method861(var14);
                     var44 = new int[var110.field934];
                     var74 = new String[var110.field932];

                     for(var18 = 0; var18 < var110.field927; ++var18) {
                        var44[var18] = class32.field723[var18 + (var5 - var110.field927)];
                     }

                     for(var18 = 0; var18 < var110.field931; ++var18) {
                        var74[var18] = class32.chatboxSegments[var6 - var110.field931 + var18];
                     }

                     var5 -= var110.field927;
                     var6 -= var110.field931;
                     class11 var105 = new class11();
                     var105.field124 = var4;
                     var105.field116 = var7;
                     var105.field117 = class32.field719;
                     var105.field118 = class32.field717;
                     class32.field726[++class32.field725 - 1] = var105;
                     var4 = var110;
                     var8 = var110.field928;
                     var9 = var110.field935;
                     var7 = -1;
                     class32.field719 = var44;
                     class32.field717 = var74;
                     continue;
                  }

                  if(var42 == 42) {
                     class32.field723[var5++] = Renderable.chatMessages.method822(var9[var7]);
                     continue;
                  }

                  if(var42 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     Renderable.chatMessages.method821(var10001, class32.field723[var5]);
                     continue;
                  }

                  if(var42 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var35 = class32.field723[var5];
                     if(var35 >= 0 && var35 <= 5000) {
                        class32.field727[var14] = var35;
                        var56 = -1;
                        if(var15 == 105) {
                           var56 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var35) {
                              continue label3659;
                           }

                           class32.field731[var14][var18] = var56;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var42 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field723[var5];
                     if(var15 >= 0 && var15 < class32.field727[var14]) {
                        class32.field723[var5++] = class32.field731[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var42 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class32.field723[var5];
                     if(var15 >= 0 && var15 < class32.field727[var14]) {
                        class32.field731[var14][var15] = class32.field723[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var42 == 47) {
                     var29 = Renderable.chatMessages.method824(var9[var7]);
                     if(null == var29) {
                        var29 = "null";
                     }

                     class32.chatboxSegments[var6++] = var29;
                     continue;
                  }

                  if(var42 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     Renderable.chatMessages.method823(var10001, class32.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var48;
               if(var9[var7] == 1) {
                  var48 = true;
               } else {
                  var48 = false;
               }

               Widget var16;
               Widget var30;
               boolean var53;
               Widget var66;
               Widget var76;
               boolean var92;
               if(var42 < 1000) {
                  if(var42 == 100) {
                     var5 -= 3;
                     var15 = class32.field723[var5];
                     var35 = class32.field723[var5 + 1];
                     var43 = class32.field723[var5 + 2];
                     if(var35 == 0) {
                        throw new RuntimeException();
                     }

                     var76 = class44.method799(var15);
                     if(var76.children == null) {
                        var76.children = new Widget[1 + var43];
                     }

                     if(var76.children.length <= var43) {
                        Widget[] var95 = new Widget[var43 + 1];

                        for(var20 = 0; var20 < var76.children.length; ++var20) {
                           var95[var20] = var76.children[var20];
                        }

                        var76.children = var95;
                     }

                     if(var43 > 0 && null == var76.children[var43 - 1]) {
                        throw new RuntimeException("" + (var43 - 1));
                     }

                     Widget var98 = new Widget();
                     var98.type = var35;
                     var98.parentId = var98.id = var76.id;
                     var98.index = var43;
                     var98.field2184 = true;
                     var76.children[var43] = var98;
                     if(var48) {
                        WidgetNode.field187 = var98;
                     } else {
                        class38.field789 = var98;
                     }

                     class6.method87(var76);
                     continue;
                  }

                  if(var42 == 101) {
                     var30 = var48?WidgetNode.field187:class38.field789;
                     var16 = class44.method799(var30.id);
                     var16.children[var30.index] = null;
                     class6.method87(var16);
                     continue;
                  }

                  if(var42 == 102) {
                     --var5;
                     var30 = class44.method799(class32.field723[var5]);
                     var30.children = null;
                     class6.method87(var30);
                     continue;
                  }

                  if(var42 == 200) {
                     var5 -= 2;
                     var15 = class32.field723[var5];
                     var35 = class32.field723[var5 + 1];
                     var66 = class157.method3011(var15, var35);
                     if(var66 != null && var35 != -1) {
                        class32.field723[var5++] = 1;
                        if(var48) {
                           WidgetNode.field187 = var66;
                        } else {
                           class38.field789 = var66;
                        }
                        continue;
                     }

                     class32.field723[var5++] = 0;
                     continue;
                  }

                  if(var42 == 201) {
                     --var5;
                     var30 = class44.method799(class32.field723[var5]);
                     if(null != var30) {
                        class32.field723[var5++] = 1;
                        if(var48) {
                           WidgetNode.field187 = var30;
                        } else {
                           class38.field789 = var30;
                        }
                     } else {
                        class32.field723[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var17;
                  if((var42 < 1000 || var42 >= 1100) && (var42 < 2000 || var42 >= 2100)) {
                     if(var42 >= 1100 && var42 < 1200 || var42 >= 2100 && var42 < 2200) {
                        var35 = -1;
                        if(var42 >= 2000) {
                           var42 -= 1000;
                           --var5;
                           var35 = class32.field723[var5];
                           var30 = class44.method799(var35);
                        } else {
                           var30 = var48?WidgetNode.field187:class38.field789;
                        }

                        if(var42 == 1100) {
                           var5 -= 2;
                           var30.scrollX = class32.field723[var5];
                           if(var30.scrollX > var30.scrollWidth - var30.width) {
                              var30.scrollX = var30.scrollWidth - var30.width;
                           }

                           if(var30.scrollX < 0) {
                              var30.scrollX = 0;
                           }

                           var30.scrollY = class32.field723[var5 + 1];
                           if(var30.scrollY > var30.scrollHeight - var30.height) {
                              var30.scrollY = var30.scrollHeight - var30.height;
                           }

                           if(var30.scrollY < 0) {
                              var30.scrollY = 0;
                           }

                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1101) {
                           --var5;
                           var30.textColor = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1102) {
                           --var5;
                           var30.field2235 = class32.field723[var5] == 1;
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1103) {
                           --var5;
                           var30.opacity = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1104) {
                           --var5;
                           var30.field2236 = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1105) {
                           --var5;
                           var30.textureId = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1106) {
                           --var5;
                           var30.field2222 = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1107) {
                           --var5;
                           var30.field2223 = class32.field723[var5] == 1;
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1108) {
                           var30.modelType = 1;
                           --var5;
                           var30.modelId = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1109) {
                           var5 -= 6;
                           var30.field2234 = class32.field723[var5];
                           var30.field2178 = class32.field723[1 + var5];
                           var30.rotationX = class32.field723[var5 + 2];
                           var30.rotationZ = class32.field723[var5 + 3];
                           var30.rotationY = class32.field723[var5 + 4];
                           var30.field2239 = class32.field723[5 + var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1110) {
                           --var5;
                           var43 = class32.field723[var5];
                           if(var30.field2250 != var43) {
                              var30.field2250 = var43;
                              var30.field2215 = 0;
                              var30.field2308 = 0;
                              class6.method87(var30);
                           }
                           continue;
                        }

                        if(var42 == 1111) {
                           --var5;
                           var30.field2242 = class32.field723[var5] == 1;
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1112) {
                           --var6;
                           var31 = class32.chatboxSegments[var6];
                           if(!var31.equals(var30.text)) {
                              var30.text = var31;
                              class6.method87(var30);
                           }
                           continue;
                        }

                        if(var42 == 1113) {
                           --var5;
                           var30.field2217 = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1114) {
                           var5 -= 3;
                           var30.field2176 = class32.field723[var5];
                           var30.field2214 = class32.field723[var5 + 1];
                           var30.field2247 = class32.field723[var5 + 2];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1115) {
                           --var5;
                           var30.field2218 = class32.field723[var5] == 1;
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1116) {
                           --var5;
                           var30.borderThickness = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1117) {
                           --var5;
                           var30.sprite2 = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1118) {
                           --var5;
                           var30.flippedVertically = class32.field723[var5] == 1;
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1119) {
                           --var5;
                           var30.flippedHorizontally = class32.field723[var5] == 1;
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1120) {
                           var5 -= 2;
                           var30.scrollWidth = class32.field723[var5];
                           var30.scrollHeight = class32.field723[var5 + 1];
                           class6.method87(var30);
                           if(var35 != -1 && var30.type == 0) {
                              class6.method97(Widget.widgets[var35 >> 16], var30, false);
                           }
                           continue;
                        }

                        if(var42 == 1121) {
                           class140.method2606(var30.id, var30.index);
                           Client.field537 = var30;
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1122) {
                           --var5;
                           var30.field2240 = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1123) {
                           --var5;
                           var30.field2211 = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1124) {
                           --var5;
                           var30.field2280 = class32.field723[var5];
                           class6.method87(var30);
                           continue;
                        }

                        if(var42 == 1125) {
                           --var5;
                           var43 = class32.field723[var5];
                           class221[] var104 = new class221[]{class221.field3185, class221.field3182, class221.field3183, class221.field3184, class221.field3188};
                           class221 var93 = (class221)class181.method3258(var104, var43);
                           if(var93 != null) {
                              var30.field2219 = var93;
                              class6.method87(var30);
                           }
                           continue;
                        }
                     } else if((var42 < 1200 || var42 >= 1300) && (var42 < 2200 || var42 >= 2300)) {
                        if((var42 < 1300 || var42 >= 1400) && (var42 < 2300 || var42 >= 2400)) {
                           String var47;
                           int[] var67;
                           if(var42 >= 1400 && var42 < 1500 || var42 >= 2400 && var42 < 2500) {
                              if(var42 >= 2000) {
                                 var42 -= 1000;
                                 --var5;
                                 var30 = class44.method799(class32.field723[var5]);
                              } else {
                                 var30 = var48?WidgetNode.field187:class38.field789;
                              }

                              --var6;
                              var47 = class32.chatboxSegments[var6];
                              var67 = null;
                              if(var47.length() > 0 && var47.charAt(var47.length() - 1) == 89) {
                                 --var5;
                                 var18 = class32.field723[var5];
                                 if(var18 > 0) {
                                    for(var67 = new int[var18]; var18-- > 0; var67[var18] = class32.field723[var5]) {
                                       --var5;
                                    }
                                 }

                                 var47 = var47.substring(0, var47.length() - 1);
                              }

                              Object[] var99 = new Object[var47.length() + 1];

                              for(var19 = var99.length - 1; var19 >= 1; --var19) {
                                 if(var47.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var99[var19] = class32.chatboxSegments[var6];
                                 } else {
                                    --var5;
                                    var99[var19] = new Integer(class32.field723[var5]);
                                 }
                              }

                              --var5;
                              var19 = class32.field723[var5];
                              if(var19 != -1) {
                                 var99[0] = new Integer(var19);
                              } else {
                                 var99 = null;
                              }

                              if(var42 == 1400) {
                                 var30.field2267 = var99;
                              }

                              if(var42 == 1401) {
                                 var30.field2270 = var99;
                              }

                              if(var42 == 1402) {
                                 var30.field2269 = var99;
                              }

                              if(var42 == 1403) {
                                 var30.field2271 = var99;
                              }

                              if(var42 == 1404) {
                                 var30.field2273 = var99;
                              }

                              if(var42 == 1405) {
                                 var30.field2274 = var99;
                              }

                              if(var42 == 1406) {
                                 var30.field2297 = var99;
                              }

                              if(var42 == 1407) {
                                 var30.field2303 = var99;
                                 var30.field2192 = var67;
                              }

                              if(var42 == 1408) {
                                 var30.field2272 = var99;
                              }

                              if(var42 == 1409) {
                                 var30.field2285 = var99;
                              }

                              if(var42 == 1410) {
                                 var30.field2275 = var99;
                              }

                              if(var42 == 1411) {
                                 var30.field2268 = var99;
                              }

                              if(var42 == 1412) {
                                 var30.field2232 = var99;
                              }

                              if(var42 == 1414) {
                                 var30.field2175 = var99;
                                 var30.field2281 = var67;
                              }

                              if(var42 == 1415) {
                                 var30.field2282 = var99;
                                 var30.field2249 = var67;
                              }

                              if(var42 == 1416) {
                                 var30.field2276 = var99;
                              }

                              if(var42 == 1417) {
                                 var30.field2286 = var99;
                              }

                              if(var42 == 1418) {
                                 var30.field2287 = var99;
                              }

                              if(var42 == 1419) {
                                 var30.field2288 = var99;
                              }

                              if(var42 == 1420) {
                                 var30.field2179 = var99;
                              }

                              if(var42 == 1421) {
                                 var30.field2290 = var99;
                              }

                              if(var42 == 1422) {
                                 var30.field2291 = var99;
                              }

                              if(var42 == 1423) {
                                 var30.field2292 = var99;
                              }

                              if(var42 == 1424) {
                                 var30.field2293 = var99;
                              }

                              if(var42 == 1425) {
                                 var30.field2295 = var99;
                              }

                              if(var42 == 1426) {
                                 var30.field2296 = var99;
                              }

                              if(var42 == 1427) {
                                 var30.field2227 = var99;
                              }

                              var30.field2307 = true;
                              continue;
                           }

                           if(var42 < 1600) {
                              var30 = var48?WidgetNode.field187:class38.field789;
                              if(var42 == 1500) {
                                 class32.field723[var5++] = var30.relativeX;
                                 continue;
                              }

                              if(var42 == 1501) {
                                 class32.field723[var5++] = var30.relativeY;
                                 continue;
                              }

                              if(var42 == 1502) {
                                 class32.field723[var5++] = var30.width;
                                 continue;
                              }

                              if(var42 == 1503) {
                                 class32.field723[var5++] = var30.height;
                                 continue;
                              }

                              if(var42 == 1504) {
                                 class32.field723[var5++] = var30.isHidden?1:0;
                                 continue;
                              }

                              if(var42 == 1505) {
                                 class32.field723[var5++] = var30.parentId;
                                 continue;
                              }
                           } else if(var42 < 1700) {
                              var30 = var48?WidgetNode.field187:class38.field789;
                              if(var42 == 1600) {
                                 class32.field723[var5++] = var30.scrollX;
                                 continue;
                              }

                              if(var42 == 1601) {
                                 class32.field723[var5++] = var30.scrollY;
                                 continue;
                              }

                              if(var42 == 1602) {
                                 class32.chatboxSegments[var6++] = var30.text;
                                 continue;
                              }

                              if(var42 == 1603) {
                                 class32.field723[var5++] = var30.scrollWidth;
                                 continue;
                              }

                              if(var42 == 1604) {
                                 class32.field723[var5++] = var30.scrollHeight;
                                 continue;
                              }

                              if(var42 == 1605) {
                                 class32.field723[var5++] = var30.field2239;
                                 continue;
                              }

                              if(var42 == 1606) {
                                 class32.field723[var5++] = var30.rotationX;
                                 continue;
                              }

                              if(var42 == 1607) {
                                 class32.field723[var5++] = var30.rotationY;
                                 continue;
                              }

                              if(var42 == 1608) {
                                 class32.field723[var5++] = var30.rotationZ;
                                 continue;
                              }

                              if(var42 == 1609) {
                                 class32.field723[var5++] = var30.opacity;
                                 continue;
                              }

                              if(var42 == 1610) {
                                 class32.field723[var5++] = var30.field2280;
                                 continue;
                              }

                              if(var42 == 1611) {
                                 class32.field723[var5++] = var30.textColor;
                                 continue;
                              }

                              if(var42 == 1612) {
                                 class32.field723[var5++] = var30.field2211;
                                 continue;
                              }

                              if(var42 == 1613) {
                                 class32.field723[var5++] = var30.field2219.vmethod4062();
                                 continue;
                              }
                           } else if(var42 < 1800) {
                              var30 = var48?WidgetNode.field187:class38.field789;
                              if(var42 == 1700) {
                                 class32.field723[var5++] = var30.item;
                                 continue;
                              }

                              if(var42 == 1701) {
                                 if(var30.item != -1) {
                                    class32.field723[var5++] = var30.stackSize;
                                 } else {
                                    class32.field723[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var42 == 1702) {
                                 class32.field723[var5++] = var30.index;
                                 continue;
                              }
                           } else if(var42 < 1900) {
                              var30 = var48?WidgetNode.field187:class38.field789;
                              if(var42 == 1800) {
                                 var44 = class32.field723;
                                 var43 = var5++;
                                 var19 = GameObject.method1872(var30);
                                 var18 = var19 >> 11 & 63;
                                 var44[var43] = var18;
                                 continue;
                              }

                              if(var42 == 1801) {
                                 --var5;
                                 var35 = class32.field723[var5];
                                 --var35;
                                 if(var30.actions != null && var35 < var30.actions.length && var30.actions[var35] != null) {
                                    class32.chatboxSegments[var6++] = var30.actions[var35];
                                    continue;
                                 }

                                 class32.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var42 == 1802) {
                                 if(var30.name == null) {
                                    class32.chatboxSegments[var6++] = "";
                                 } else {
                                    class32.chatboxSegments[var6++] = var30.name;
                                 }
                                 continue;
                              }
                           } else if((var42 < 1900 || var42 >= 2000) && (var42 < 2900 || var42 >= 3000)) {
                              if(var42 < 2600) {
                                 --var5;
                                 var30 = class44.method799(class32.field723[var5]);
                                 if(var42 == 2500) {
                                    class32.field723[var5++] = var30.relativeX;
                                    continue;
                                 }

                                 if(var42 == 2501) {
                                    class32.field723[var5++] = var30.relativeY;
                                    continue;
                                 }

                                 if(var42 == 2502) {
                                    class32.field723[var5++] = var30.width;
                                    continue;
                                 }

                                 if(var42 == 2503) {
                                    class32.field723[var5++] = var30.height;
                                    continue;
                                 }

                                 if(var42 == 2504) {
                                    class32.field723[var5++] = var30.isHidden?1:0;
                                    continue;
                                 }

                                 if(var42 == 2505) {
                                    class32.field723[var5++] = var30.parentId;
                                    continue;
                                 }
                              } else if(var42 < 2700) {
                                 --var5;
                                 var30 = class44.method799(class32.field723[var5]);
                                 if(var42 == 2600) {
                                    class32.field723[var5++] = var30.scrollX;
                                    continue;
                                 }

                                 if(var42 == 2601) {
                                    class32.field723[var5++] = var30.scrollY;
                                    continue;
                                 }

                                 if(var42 == 2602) {
                                    class32.chatboxSegments[var6++] = var30.text;
                                    continue;
                                 }

                                 if(var42 == 2603) {
                                    class32.field723[var5++] = var30.scrollWidth;
                                    continue;
                                 }

                                 if(var42 == 2604) {
                                    class32.field723[var5++] = var30.scrollHeight;
                                    continue;
                                 }

                                 if(var42 == 2605) {
                                    class32.field723[var5++] = var30.field2239;
                                    continue;
                                 }

                                 if(var42 == 2606) {
                                    class32.field723[var5++] = var30.rotationX;
                                    continue;
                                 }

                                 if(var42 == 2607) {
                                    class32.field723[var5++] = var30.rotationY;
                                    continue;
                                 }

                                 if(var42 == 2608) {
                                    class32.field723[var5++] = var30.rotationZ;
                                    continue;
                                 }

                                 if(var42 == 2609) {
                                    class32.field723[var5++] = var30.opacity;
                                    continue;
                                 }

                                 if(var42 == 2610) {
                                    class32.field723[var5++] = var30.field2280;
                                    continue;
                                 }

                                 if(var42 == 2611) {
                                    class32.field723[var5++] = var30.textColor;
                                    continue;
                                 }

                                 if(var42 == 2612) {
                                    class32.field723[var5++] = var30.field2211;
                                    continue;
                                 }

                                 if(var42 == 2613) {
                                    class32.field723[var5++] = var30.field2219.vmethod4062();
                                    continue;
                                 }
                              } else if(var42 < 2800) {
                                 if(var42 == 2700) {
                                    --var5;
                                    var30 = class44.method799(class32.field723[var5]);
                                    class32.field723[var5++] = var30.item;
                                    continue;
                                 }

                                 if(var42 == 2701) {
                                    --var5;
                                    var30 = class44.method799(class32.field723[var5]);
                                    if(var30.item != -1) {
                                       class32.field723[var5++] = var30.stackSize;
                                    } else {
                                       class32.field723[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var42 == 2702) {
                                    --var5;
                                    var15 = class32.field723[var5];
                                    WidgetNode var46 = (WidgetNode)Client.componentTable.method2339((long)var15);
                                    if(null != var46) {
                                       class32.field723[var5++] = 1;
                                    } else {
                                       class32.field723[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var42 == 2706) {
                                    class32.field723[var5++] = Client.widgetRoot;
                                    continue;
                                 }
                              } else if(var42 < 2900) {
                                 --var5;
                                 var30 = class44.method799(class32.field723[var5]);
                                 if(var42 == 2800) {
                                    var44 = class32.field723;
                                    var43 = var5++;
                                    var19 = GameObject.method1872(var30);
                                    var18 = var19 >> 11 & 63;
                                    var44[var43] = var18;
                                    continue;
                                 }

                                 if(var42 == 2801) {
                                    --var5;
                                    var35 = class32.field723[var5];
                                    --var35;
                                    if(var30.actions != null && var35 < var30.actions.length && null != var30.actions[var35]) {
                                       class32.chatboxSegments[var6++] = var30.actions[var35];
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var42 == 2802) {
                                    if(null == var30.name) {
                                       class32.chatboxSegments[var6++] = "";
                                    } else {
                                       class32.chatboxSegments[var6++] = var30.name;
                                    }
                                    continue;
                                 }
                              } else if(var42 < 3200) {
                                 if(var42 == 3100) {
                                    --var6;
                                    var100 = class32.chatboxSegments[var6];
                                    class7.method99(0, "", var100);
                                    continue;
                                 }

                                 if(var42 == 3101) {
                                    var5 -= 2;
                                    XItemContainer.method167(class148.localPlayer, class32.field723[var5], class32.field723[1 + var5]);
                                    continue;
                                 }

                                 if(var42 == 3103) {
                                    Client.field326.method3029(249);

                                    for(WidgetNode var103 = (WidgetNode)Client.componentTable.method2344(); var103 != null; var103 = (WidgetNode)Client.componentTable.method2343()) {
                                       if(var103.field182 == 0 || var103.field182 == 3) {
                                          class3.method31(var103, true);
                                       }
                                    }

                                    if(Client.field537 != null) {
                                       class6.method87(Client.field537);
                                       Client.field537 = null;
                                    }
                                    continue;
                                 }

                                 if(var42 == 3104) {
                                    --var6;
                                    var100 = class32.chatboxSegments[var6];
                                    var35 = 0;
                                    var17 = MessageNode.method202(var100, 10, true);
                                    if(var17) {
                                       var35 = class16.method183(var100);
                                    }

                                    Client.field326.method3029(52);
                                    Client.field326.method2763(var35);
                                    continue;
                                 }

                                 if(var42 == 3105) {
                                    --var6;
                                    var100 = class32.chatboxSegments[var6];
                                    Client.field326.method3029(128);
                                    Client.field326.method2760(var100.length() + 1);
                                    Client.field326.method2811(var100);
                                    continue;
                                 }

                                 if(var42 == 3106) {
                                    --var6;
                                    var100 = class32.chatboxSegments[var6];
                                    Client.field326.method3029(35);
                                    Client.field326.method2760(var100.length() + 1);
                                    Client.field326.method2811(var100);
                                    continue;
                                 }

                                 if(var42 == 3107) {
                                    --var5;
                                    var15 = class32.field723[var5];
                                    --var6;
                                    var47 = class32.chatboxSegments[var6];
                                    class44.method794(var15, var47);
                                    continue;
                                 }

                                 if(var42 == 3108) {
                                    var5 -= 3;
                                    var15 = class32.field723[var5];
                                    var35 = class32.field723[var5 + 1];
                                    var43 = class32.field723[2 + var5];
                                    var76 = class44.method799(var43);
                                    WallObject.method1845(var76, var15, var35);
                                    continue;
                                 }

                                 if(var42 == 3109) {
                                    var5 -= 2;
                                    var15 = class32.field723[var5];
                                    var35 = class32.field723[1 + var5];
                                    var66 = var48?WidgetNode.field187:class38.field789;
                                    WallObject.method1845(var66, var15, var35);
                                    continue;
                                 }

                                 if(var42 == 3110) {
                                    --var5;
                                    GroundObject.field1297 = class32.field723[var5] == 1;
                                    continue;
                                 }

                                 if(var42 == 3111) {
                                    class32.field723[var5++] = class2.field21.field690?1:0;
                                    continue;
                                 }

                                 if(var42 == 3112) {
                                    --var5;
                                    class2.field21.field690 = class32.field723[var5] == 1;
                                    class7.method108();
                                    continue;
                                 }

                                 if(var42 == 3113) {
                                    --var6;
                                    var100 = class32.chatboxSegments[var6];
                                    --var5;
                                    var92 = class32.field723[var5] == 1;
                                    class156.method2998(var100, var92, false);
                                    continue;
                                 }

                                 if(var42 == 3115) {
                                    --var5;
                                    var15 = class32.field723[var5];
                                    Client.field326.method3029(0);
                                    Client.field326.method2918(var15);
                                    continue;
                                 }

                                 if(var42 == 3116) {
                                    --var5;
                                    var15 = class32.field723[var5];
                                    var6 -= 2;
                                    var47 = class32.chatboxSegments[var6];
                                    var31 = class32.chatboxSegments[var6 + 1];
                                    if(var47.length() <= 500 && var31.length() <= 500) {
                                       Client.field326.method3029(247);
                                       Client.field326.method2918(1 + class148.method2740(var47) + class148.method2740(var31));
                                       Client.field326.method2811(var47);
                                       Client.field326.method2811(var31);
                                       Client.field326.method2800(var15);
                                    }
                                    continue;
                                 }
                              } else if(var42 < 3300) {
                                 if(var42 == 3200) {
                                    var5 -= 3;
                                    class119.method2275(class32.field723[var5], class32.field723[var5 + 1], class32.field723[2 + var5]);
                                    continue;
                                 }

                                 if(var42 == 3201) {
                                    --var5;
                                    var15 = class32.field723[var5];
                                    if(var15 == -1 && !Client.field519) {
                                       class9.method118();
                                    } else if(var15 != -1 && var15 != Client.field444 && Client.field517 != 0 && !Client.field519) {
                                       class85.method1663(2, class37.field781, var15, 0, Client.field517, false);
                                    }

                                    Client.field444 = var15;
                                    continue;
                                 }

                                 if(var42 == 3202) {
                                    var5 -= 2;
                                    class94.method1867(class32.field723[var5], class32.field723[var5 + 1]);
                                    continue;
                                 }
                              } else {
                                 int var22;
                                 int var36;
                                 byte[] var70;
                                 if(var42 < 3400) {
                                    if(var42 == 3300) {
                                       class32.field723[var5++] = Client.gameCycle;
                                       continue;
                                    }

                                    if(var42 == 3301) {
                                       var5 -= 2;
                                       var15 = class32.field723[var5];
                                       var35 = class32.field723[1 + var5];
                                       class32.field723[var5++] = class5.method75(var15, var35);
                                       continue;
                                    }

                                    XItemContainer var32;
                                    if(var42 == 3302) {
                                       var5 -= 2;
                                       var15 = class32.field723[var5];
                                       var35 = class32.field723[1 + var5];
                                       var67 = class32.field723;
                                       var18 = var5++;
                                       var32 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var15);
                                       if(null == var32) {
                                          var19 = 0;
                                       } else if(var35 >= 0 && var35 < var32.stackSizes.length) {
                                          var19 = var32.stackSizes[var35];
                                       } else {
                                          var19 = 0;
                                       }

                                       var67[var18] = var19;
                                       continue;
                                    }

                                    if(var42 == 3303) {
                                       var5 -= 2;
                                       var15 = class32.field723[var5];
                                       var35 = class32.field723[1 + var5];
                                       var67 = class32.field723;
                                       var18 = var5++;
                                       var32 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var15);
                                       if(null == var32) {
                                          var19 = 0;
                                       } else if(var35 == -1) {
                                          var19 = 0;
                                       } else {
                                          var36 = 0;

                                          for(var22 = 0; var22 < var32.stackSizes.length; ++var22) {
                                             if(var32.itemIds[var22] == var35) {
                                                var36 += var32.stackSizes[var22];
                                             }
                                          }

                                          var19 = var36;
                                       }

                                       var67[var18] = var19;
                                       continue;
                                    }

                                    if(var42 == 3304) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       var44 = class32.field723;
                                       var43 = var5++;
                                       class186 var33 = (class186)class186.field2745.get((long)var15);
                                       class186 var77;
                                       if(null != var33) {
                                          var77 = var33;
                                       } else {
                                          var70 = class186.field2748.method3272(5, var15);
                                          var33 = new class186();
                                          if(var70 != null) {
                                             var33.method3407(new Buffer(var70));
                                          }

                                          class186.field2745.put(var33, (long)var15);
                                          var77 = var33;
                                       }

                                       var44[var43] = var77.field2746;
                                       continue;
                                    }

                                    if(var42 == 3305) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       class32.field723[var5++] = Client.boostedSkillLevels[var15];
                                       continue;
                                    }

                                    if(var42 == 3306) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       class32.field723[var5++] = Client.realSkillLevels[var15];
                                       continue;
                                    }

                                    if(var42 == 3307) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       class32.field723[var5++] = Client.skillExperiences[var15];
                                       continue;
                                    }

                                    if(var42 == 3308) {
                                       var15 = class60.plane;
                                       var35 = FrameMap.baseX + (class148.localPlayer.x >> 7);
                                       var43 = XItemContainer.baseY + (class148.localPlayer.y >> 7);
                                       class32.field723[var5++] = var43 + (var15 << 28) + (var35 << 14);
                                       continue;
                                    }

                                    if(var42 == 3309) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       class32.field723[var5++] = var15 >> 14 & 16383;
                                       continue;
                                    }

                                    if(var42 == 3310) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       class32.field723[var5++] = var15 >> 28;
                                       continue;
                                    }

                                    if(var42 == 3311) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       class32.field723[var5++] = var15 & 16383;
                                       continue;
                                    }

                                    if(var42 == 3312) {
                                       class32.field723[var5++] = Client.isMembers?1:0;
                                       continue;
                                    }

                                    if(var42 == 3313) {
                                       var5 -= 2;
                                       var15 = class32.field723[var5] + '耀';
                                       var35 = class32.field723[1 + var5];
                                       class32.field723[var5++] = class5.method75(var15, var35);
                                       continue;
                                    }

                                    if(var42 == 3314) {
                                       var5 -= 2;
                                       var15 = class32.field723[var5] + '耀';
                                       var35 = class32.field723[1 + var5];
                                       var67 = class32.field723;
                                       var18 = var5++;
                                       var32 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var15);
                                       if(var32 == null) {
                                          var19 = 0;
                                       } else if(var35 >= 0 && var35 < var32.stackSizes.length) {
                                          var19 = var32.stackSizes[var35];
                                       } else {
                                          var19 = 0;
                                       }

                                       var67[var18] = var19;
                                       continue;
                                    }

                                    if(var42 == 3315) {
                                       var5 -= 2;
                                       var15 = '耀' + class32.field723[var5];
                                       var35 = class32.field723[var5 + 1];
                                       var67 = class32.field723;
                                       var18 = var5++;
                                       var32 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var15);
                                       if(null == var32) {
                                          var19 = 0;
                                       } else if(var35 == -1) {
                                          var19 = 0;
                                       } else {
                                          var36 = 0;

                                          for(var22 = 0; var22 < var32.stackSizes.length; ++var22) {
                                             if(var32.itemIds[var22] == var35) {
                                                var36 += var32.stackSizes[var22];
                                             }
                                          }

                                          var19 = var36;
                                       }

                                       var67[var18] = var19;
                                       continue;
                                    }

                                    if(var42 == 3316) {
                                       if(Client.field352 >= 2) {
                                          class32.field723[var5++] = Client.field352;
                                       } else {
                                          class32.field723[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var42 == 3317) {
                                       class32.field723[var5++] = Client.field297;
                                       continue;
                                    }

                                    if(var42 == 3318) {
                                       class32.field723[var5++] = Client.world;
                                       continue;
                                    }

                                    if(var42 == 3321) {
                                       class32.field723[var5++] = Client.energy;
                                       continue;
                                    }

                                    if(var42 == 3322) {
                                       class32.field723[var5++] = Client.weight;
                                       continue;
                                    }

                                    if(var42 == 3323) {
                                       if(Client.field449) {
                                          class32.field723[var5++] = 1;
                                       } else {
                                          class32.field723[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var42 == 3324) {
                                       class32.field723[var5++] = Client.flags;
                                       continue;
                                    }
                                 } else if(var42 < 3500) {
                                    if(var42 == 3400) {
                                       var5 -= 2;
                                       var15 = class32.field723[var5];
                                       var35 = class32.field723[1 + var5];
                                       class195 var71 = class139.method2602(var15);
                                       if(var71.field2842 != 115) {
                                          ;
                                       }

                                       for(var18 = 0; var18 < var71.field2845; ++var18) {
                                          if(var71.field2846[var18] == var35) {
                                             class32.chatboxSegments[var6++] = var71.field2841[var18];
                                             var71 = null;
                                             break;
                                          }
                                       }

                                       if(null != var71) {
                                          class32.chatboxSegments[var6++] = var71.field2843;
                                       }
                                       continue;
                                    }

                                    if(var42 == 3408) {
                                       var5 -= 4;
                                       var15 = class32.field723[var5];
                                       var35 = class32.field723[1 + var5];
                                       var43 = class32.field723[var5 + 2];
                                       var18 = class32.field723[3 + var5];
                                       class195 var72 = class139.method2602(var43);
                                       if(var15 == var72.field2848 && var35 == var72.field2842) {
                                          for(var20 = 0; var20 < var72.field2845; ++var20) {
                                             if(var18 == var72.field2846[var20]) {
                                                if(var35 == 115) {
                                                   class32.chatboxSegments[var6++] = var72.field2841[var20];
                                                } else {
                                                   class32.field723[var5++] = var72.field2839[var20];
                                                }

                                                var72 = null;
                                                break;
                                             }
                                          }

                                          if(var72 != null) {
                                             if(var35 == 115) {
                                                class32.chatboxSegments[var6++] = var72.field2843;
                                             } else {
                                                class32.field723[var5++] = var72.field2844;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var35 == 115) {
                                          class32.chatboxSegments[var6++] = "null";
                                       } else {
                                          class32.field723[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else if(var42 < 3700) {
                                    if(var42 == 3600) {
                                       if(Client.field465 == 0) {
                                          class32.field723[var5++] = -2;
                                       } else if(Client.field465 == 1) {
                                          class32.field723[var5++] = -1;
                                       } else {
                                          class32.field723[var5++] = Client.friendCount;
                                       }
                                       continue;
                                    }

                                    if(var42 == 3601) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       if(Client.field465 == 2 && var15 < Client.friendCount) {
                                          class32.chatboxSegments[var6++] = Client.friends[var15].name;
                                          class32.chatboxSegments[var6++] = Client.friends[var15].previousName;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var42 == 3602) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       if(Client.field465 == 2 && var15 < Client.friendCount) {
                                          class32.field723[var5++] = Client.friends[var15].world;
                                          continue;
                                       }

                                       class32.field723[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3603) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       if(Client.field465 == 2 && var15 < Client.friendCount) {
                                          class32.field723[var5++] = Client.friends[var15].rank;
                                          continue;
                                       }

                                       class32.field723[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3604) {
                                       --var6;
                                       var100 = class32.chatboxSegments[var6];
                                       --var5;
                                       var35 = class32.field723[var5];
                                       class107.method1996(var100, var35);
                                       continue;
                                    }

                                    if(var42 == 3605) {
                                       --var6;
                                       var100 = class32.chatboxSegments[var6];
                                       class36.method729(var100);
                                       continue;
                                    }

                                    if(var42 == 3606) {
                                       --var6;
                                       var100 = class32.chatboxSegments[var6];
                                       if(var100 == null) {
                                          continue;
                                       }

                                       var47 = class139.method2601(var100, Ignore.field209);
                                       if(null == var47) {
                                          continue;
                                       }

                                       var43 = 0;

                                       while(true) {
                                          if(var43 >= Client.friendCount) {
                                             continue label3659;
                                          }

                                          Friend var85 = Client.friends[var43];
                                          String var79 = var85.name;
                                          var73 = class139.method2601(var79, Ignore.field209);
                                          if(class170.method3216(var100, var47, var79, var73)) {
                                             --Client.friendCount;

                                             for(var36 = var43; var36 < Client.friendCount; ++var36) {
                                                Client.friends[var36] = Client.friends[var36 + 1];
                                             }

                                             Client.field460 = Client.field446;
                                             Client.field326.method3029(45);
                                             Client.field326.method2760(class148.method2740(var100));
                                             Client.field326.method2811(var100);
                                             continue label3659;
                                          }

                                          ++var43;
                                       }
                                    }

                                    if(var42 == 3607) {
                                       --var6;
                                       var100 = class32.chatboxSegments[var6];
                                       class60.method1096(var100, false);
                                       continue;
                                    }

                                    if(var42 == 3608) {
                                       --var6;
                                       var100 = class32.chatboxSegments[var6];
                                       class1.method9(var100);
                                       continue;
                                    }

                                    if(var42 == 3609) {
                                       --var6;
                                       var100 = class32.chatboxSegments[var6];
                                       class177[] var49 = class22.method211();

                                       for(var43 = 0; var43 < var49.length; ++var43) {
                                          class177 var82 = var49[var43];
                                          if(var82.field2641 != -1 && var100.startsWith(class109.method2012(var82.field2641))) {
                                             var100 = var100.substring(6 + Integer.toString(var82.field2641).length());
                                             break;
                                          }
                                       }

                                       class32.field723[var5++] = class60.method1098(var100, false)?1:0;
                                       continue;
                                    }

                                    if(var42 == 3611) {
                                       if(Client.field507 != null) {
                                          class32.chatboxSegments[var6++] = class11.method155(Client.field507);
                                       } else {
                                          class32.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var42 == 3612) {
                                       if(Client.field507 != null) {
                                          class32.field723[var5++] = class142.field1984;
                                       } else {
                                          class32.field723[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var42 == 3613) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       if(null != Client.field507 && var15 < class142.field1984) {
                                          class32.chatboxSegments[var6++] = class30.clanMembers[var15].username;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var42 == 3614) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       if(Client.field507 != null && var15 < class142.field1984) {
                                          class32.field723[var5++] = class30.clanMembers[var15].world;
                                          continue;
                                       }

                                       class32.field723[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3615) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       if(null != Client.field507 && var15 < class142.field1984) {
                                          class32.field723[var5++] = class30.clanMembers[var15].rank;
                                          continue;
                                       }

                                       class32.field723[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3616) {
                                       class32.field723[var5++] = class165.field2147;
                                       continue;
                                    }

                                    if(var42 == 3617) {
                                       --var6;
                                       var100 = class32.chatboxSegments[var6];
                                       if(class30.clanMembers != null) {
                                          Client.field326.method3029(251);
                                          Client.field326.method2760(class148.method2740(var100));
                                          Client.field326.method2811(var100);
                                       }
                                       continue;
                                    }

                                    if(var42 == 3618) {
                                       class32.field723[var5++] = class118.field1831;
                                       continue;
                                    }

                                    if(var42 == 3619) {
                                       --var6;
                                       var100 = class32.chatboxSegments[var6];
                                       class105.method1961(var100);
                                       continue;
                                    }

                                    if(var42 == 3620) {
                                       Client.field326.method3029(7);
                                       Client.field326.method2760(0);
                                       continue;
                                    }

                                    if(var42 == 3621) {
                                       if(Client.field465 == 0) {
                                          class32.field723[var5++] = -1;
                                       } else {
                                          class32.field723[var5++] = Client.ignoreCount;
                                       }
                                       continue;
                                    }

                                    if(var42 == 3622) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       if(Client.field465 != 0 && var15 < Client.ignoreCount) {
                                          class32.chatboxSegments[var6++] = Client.ignores[var15].name;
                                          class32.chatboxSegments[var6++] = Client.ignores[var15].previousName;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var42 == 3623) {
                                       --var6;
                                       var100 = class32.chatboxSegments[var6];
                                       if(var100.startsWith(class109.method2012(0)) || var100.startsWith(class109.method2012(1))) {
                                          var100 = var100.substring(7);
                                       }

                                       class32.field723[var5++] = class164.method3115(var100)?1:0;
                                       continue;
                                    }

                                    if(var42 == 3624) {
                                       --var5;
                                       var15 = class32.field723[var5];
                                       if(class30.clanMembers != null && var15 < class142.field1984 && class30.clanMembers[var15].username.equalsIgnoreCase(class148.localPlayer.name)) {
                                          class32.field723[var5++] = 1;
                                          continue;
                                       }

                                       class32.field723[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3625) {
                                       if(null != Client.clanChatOwner) {
                                          class32.chatboxSegments[var6++] = class11.method155(Client.clanChatOwner);
                                       } else {
                                          class32.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }
                                 } else {
                                    long var51;
                                    if(var42 < 4000) {
                                       if(var42 == 3903) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          class32.field723[var5++] = Client.grandExchangeOffers[var15].method51();
                                          continue;
                                       }

                                       if(var42 == 3904) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          class32.field723[var5++] = Client.grandExchangeOffers[var15].itemId;
                                          continue;
                                       }

                                       if(var42 == 3905) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          class32.field723[var5++] = Client.grandExchangeOffers[var15].price;
                                          continue;
                                       }

                                       if(var42 == 3906) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          class32.field723[var5++] = Client.grandExchangeOffers[var15].totalQuantity;
                                          continue;
                                       }

                                       if(var42 == 3907) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          class32.field723[var5++] = Client.grandExchangeOffers[var15].quantitySold;
                                          continue;
                                       }

                                       if(var42 == 3908) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          class32.field723[var5++] = Client.grandExchangeOffers[var15].spent;
                                          continue;
                                       }

                                       if(var42 == 3910) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var35 = Client.grandExchangeOffers[var15].method44();
                                          class32.field723[var5++] = var35 == 0?1:0;
                                          continue;
                                       }

                                       if(var42 == 3911) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var35 = Client.grandExchangeOffers[var15].method44();
                                          class32.field723[var5++] = var35 == 2?1:0;
                                          continue;
                                       }

                                       if(var42 == 3912) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var35 = Client.grandExchangeOffers[var15].method44();
                                          class32.field723[var5++] = var35 == 5?1:0;
                                          continue;
                                       }

                                       if(var42 == 3913) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var35 = Client.grandExchangeOffers[var15].method44();
                                          class32.field723[var5++] = var35 == 1?1:0;
                                          continue;
                                       }

                                       boolean var63;
                                       if(var42 == 3914) {
                                          --var5;
                                          var63 = class32.field723[var5] == 1;
                                          if(class11.field123 != null) {
                                             class11.field123.method10(class1.field10, var63);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3915) {
                                          --var5;
                                          var63 = class32.field723[var5] == 1;
                                          if(null != class11.field123) {
                                             class11.field123.method10(class1.field9, var63);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3916) {
                                          var5 -= 2;
                                          var63 = class32.field723[var5] == 1;
                                          var92 = class32.field723[1 + var5] == 1;
                                          if(class11.field123 != null) {
                                             class11.field123.method10(new class44(var92), var63);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3917) {
                                          --var5;
                                          var63 = class32.field723[var5] == 1;
                                          if(class11.field123 != null) {
                                             class11.field123.method10(class1.field11, var63);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3918) {
                                          --var5;
                                          var63 = class32.field723[var5] == 1;
                                          if(class11.field123 != null) {
                                             class11.field123.method10(class1.field8, var63);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3919) {
                                          class32.field723[var5++] = null == class11.field123?0:class11.field123.field12.size();
                                          continue;
                                       }

                                       class2 var50;
                                       if(var42 == 3920) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var50 = (class2)class11.field123.field12.get(var15);
                                          class32.field723[var5++] = var50.field22;
                                          continue;
                                       }

                                       if(var42 == 3921) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var50 = (class2)class11.field123.field12.get(var15);
                                          class32.chatboxSegments[var6++] = var50.method18();
                                          continue;
                                       }

                                       if(var42 == 3922) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var50 = (class2)class11.field123.field12.get(var15);
                                          class32.chatboxSegments[var6++] = var50.method20();
                                          continue;
                                       }

                                       if(var42 == 3923) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var50 = (class2)class11.field123.field12.get(var15);
                                          var51 = class9.method117() - class5.field45 - var50.field17;
                                          var19 = (int)(var51 / 3600000L);
                                          var20 = (int)((var51 - (long)(var19 * 3600000)) / 60000L);
                                          var36 = (int)((var51 - (long)(3600000 * var19) - (long)(var20 * '\uea60')) / 1000L);
                                          String var37 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var36 / 10 + var36 % 10;
                                          class32.chatboxSegments[var6++] = var37;
                                          continue;
                                       }

                                       if(var42 == 3924) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var50 = (class2)class11.field123.field12.get(var15);
                                          class32.field723[var5++] = var50.field15.totalQuantity;
                                          continue;
                                       }

                                       if(var42 == 3925) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var50 = (class2)class11.field123.field12.get(var15);
                                          class32.field723[var5++] = var50.field15.price;
                                          continue;
                                       }

                                       if(var42 == 3926) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          var50 = (class2)class11.field123.field12.get(var15);
                                          class32.field723[var5++] = var50.field15.itemId;
                                          continue;
                                       }
                                    } else if(var42 < 4100) {
                                       if(var42 == 4000) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          class32.field723[var5++] = var15 + var35;
                                          continue;
                                       }

                                       if(var42 == 4001) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[var5 + 1];
                                          class32.field723[var5++] = var15 - var35;
                                          continue;
                                       }

                                       if(var42 == 4002) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          class32.field723[var5++] = var35 * var15;
                                          continue;
                                       }

                                       if(var42 == 4003) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          class32.field723[var5++] = var15 / var35;
                                          continue;
                                       }

                                       if(var42 == 4004) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          class32.field723[var5++] = (int)(Math.random() * (double)var15);
                                          continue;
                                       }

                                       if(var42 == 4005) {
                                          --var5;
                                          var15 = class32.field723[var5];
                                          class32.field723[var5++] = (int)(Math.random() * (double)(var15 + 1));
                                          continue;
                                       }

                                       if(var42 == 4006) {
                                          var5 -= 5;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          var43 = class32.field723[var5 + 2];
                                          var18 = class32.field723[3 + var5];
                                          var19 = class32.field723[var5 + 4];
                                          class32.field723[var5++] = (var19 - var43) * (var35 - var15) / (var18 - var43) + var15;
                                          continue;
                                       }

                                       if(var42 == 4007) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          class32.field723[var5++] = var15 * var35 / 100 + var15;
                                          continue;
                                       }

                                       if(var42 == 4008) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          class32.field723[var5++] = var15 | 1 << var35;
                                          continue;
                                       }

                                       if(var42 == 4009) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[var5 + 1];
                                          class32.field723[var5++] = var15 & -1 - (1 << var35);
                                          continue;
                                       }

                                       if(var42 == 4010) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          class32.field723[var5++] = (var15 & 1 << var35) != 0?1:0;
                                          continue;
                                       }

                                       if(var42 == 4011) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[var5 + 1];
                                          class32.field723[var5++] = var15 % var35;
                                          continue;
                                       }

                                       if(var42 == 4012) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[var5 + 1];
                                          if(var15 == 0) {
                                             class32.field723[var5++] = 0;
                                          } else {
                                             class32.field723[var5++] = (int)Math.pow((double)var15, (double)var35);
                                          }
                                          continue;
                                       }

                                       if(var42 == 4013) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          if(var15 == 0) {
                                             class32.field723[var5++] = 0;
                                          } else if(var35 == 0) {
                                             class32.field723[var5++] = Integer.MAX_VALUE;
                                          } else {
                                             class32.field723[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var35);
                                          }
                                          continue;
                                       }

                                       if(var42 == 4014) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          class32.field723[var5++] = var15 & var35;
                                          continue;
                                       }

                                       if(var42 == 4015) {
                                          var5 -= 2;
                                          var15 = class32.field723[var5];
                                          var35 = class32.field723[1 + var5];
                                          class32.field723[var5++] = var15 | var35;
                                          continue;
                                       }

                                       if(var42 == 4018) {
                                          var5 -= 3;
                                          long var75 = (long)class32.field723[var5];
                                          var51 = (long)class32.field723[var5 + 1];
                                          long var57 = (long)class32.field723[var5 + 2];
                                          class32.field723[var5++] = (int)(var57 * var75 / var51);
                                          continue;
                                       }
                                    } else {
                                       int var24;
                                       if(var42 < 4200) {
                                          if(var42 == 4100) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field723[var5];
                                             class32.chatboxSegments[var6++] = var100 + var35;
                                             continue;
                                          }

                                          if(var42 == 4101) {
                                             var6 -= 2;
                                             var100 = class32.chatboxSegments[var6];
                                             var47 = class32.chatboxSegments[var6 + 1];
                                             class32.chatboxSegments[var6++] = var100 + var47;
                                             continue;
                                          }

                                          if(var42 == 4102) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field723[var5];
                                             var74 = class32.chatboxSegments;
                                             var18 = var6++;
                                             if(var35 < 0) {
                                                var73 = Integer.toString(var35);
                                             } else {
                                                var22 = var35;
                                                if(var35 < 0) {
                                                   var21 = Integer.toString(var35, 10);
                                                } else {
                                                   int var23 = 2;

                                                   for(var24 = var35 / 10; var24 != 0; ++var23) {
                                                      var24 /= 10;
                                                   }

                                                   char[] var25 = new char[var23];
                                                   var25[0] = 43;

                                                   for(int var26 = var23 - 1; var26 > 0; --var26) {
                                                      int var27 = var22;
                                                      var22 /= 10;
                                                      int var28 = var27 - var22 * 10;
                                                      if(var28 >= 10) {
                                                         var25[var26] = (char)(87 + var28);
                                                      } else {
                                                         var25[var26] = (char)(48 + var28);
                                                      }
                                                   }

                                                   var21 = new String(var25);
                                                }

                                                var73 = var21;
                                             }

                                             var74[var18] = var100 + var73;
                                             continue;
                                          }

                                          if(var42 == 4103) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             class32.chatboxSegments[var6++] = var100.toLowerCase();
                                             continue;
                                          }

                                          if(var42 == 4104) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             long var107 = ((long)var15 + 11745L) * 86400000L;
                                             class32.field730.setTime(new Date(var107));
                                             var18 = class32.field730.get(5);
                                             var19 = class32.field730.get(2);
                                             var20 = class32.field730.get(1);
                                             class32.chatboxSegments[var6++] = var18 + "-" + class32.field728[var19] + "-" + var20;
                                             continue;
                                          }

                                          if(var42 == 4105) {
                                             var6 -= 2;
                                             var100 = class32.chatboxSegments[var6];
                                             var47 = class32.chatboxSegments[var6 + 1];
                                             if(null != class148.localPlayer.composition && class148.localPlayer.composition.isFemale) {
                                                class32.chatboxSegments[var6++] = var47;
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = var100;
                                             continue;
                                          }

                                          if(var42 == 4106) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             class32.chatboxSegments[var6++] = Integer.toString(var15);
                                             continue;
                                          }

                                          if(var42 == 4107) {
                                             var6 -= 2;
                                             int[] var106 = class32.field723;
                                             var35 = var5++;
                                             var18 = class171.method3235(class32.chatboxSegments[var6], class32.chatboxSegments[1 + var6], Client.field472);
                                             if(var18 > 0) {
                                                var56 = 1;
                                             } else if(var18 < 0) {
                                                var56 = -1;
                                             } else {
                                                var56 = 0;
                                             }

                                             var106[var35] = var56;
                                             continue;
                                          }

                                          class208 var80;
                                          byte[] var87;
                                          if(var42 == 4108) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var35 = class32.field723[var5];
                                             var43 = class32.field723[var5 + 1];
                                             var87 = class119.field1843.method3272(var43, 0);
                                             var80 = new class208(var87);
                                             class32.field723[var5++] = var80.method3865(var100, var35);
                                             continue;
                                          }

                                          if(var42 == 4109) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var35 = class32.field723[var5];
                                             var43 = class32.field723[var5 + 1];
                                             var87 = class119.field1843.method3272(var43, 0);
                                             var80 = new class208(var87);
                                             class32.field723[var5++] = var80.method3864(var100, var35);
                                             continue;
                                          }

                                          if(var42 == 4110) {
                                             var6 -= 2;
                                             var100 = class32.chatboxSegments[var6];
                                             var47 = class32.chatboxSegments[1 + var6];
                                             --var5;
                                             if(class32.field723[var5] == 1) {
                                                class32.chatboxSegments[var6++] = var100;
                                             } else {
                                                class32.chatboxSegments[var6++] = var47;
                                             }
                                             continue;
                                          }

                                          if(var42 == 4111) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             class32.chatboxSegments[var6++] = class209.method3866(var100);
                                             continue;
                                          }

                                          if(var42 == 4112) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field723[var5];
                                             class32.chatboxSegments[var6++] = var100 + (char)var35;
                                             continue;
                                          }

                                          char var59;
                                          if(var42 == 4113) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             var44 = class32.field723;
                                             var43 = var5++;
                                             var59 = (char)var15;
                                             if(var59 >= 32 && var59 <= 126) {
                                                var53 = true;
                                             } else if(var59 >= 160 && var59 <= 255) {
                                                var53 = true;
                                             } else if(var59 != 8364 && var59 != 338 && var59 != 8212 && var59 != 339 && var59 != 376) {
                                                var53 = false;
                                             } else {
                                                var53 = true;
                                             }

                                             var44[var43] = var53?1:0;
                                             continue;
                                          }

                                          if(var42 == 4114) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             class32.field723[var5++] = Frames.method1852((char)var15)?1:0;
                                             continue;
                                          }

                                          if(var42 == 4115) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             class32.field723[var5++] = Frames.method1848((char)var15)?1:0;
                                             continue;
                                          }

                                          if(var42 == 4116) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             class32.field723[var5++] = class186.method3412((char)var15)?1:0;
                                             continue;
                                          }

                                          if(var42 == 4117) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             if(var100 != null) {
                                                class32.field723[var5++] = var100.length();
                                             } else {
                                                class32.field723[var5++] = 0;
                                             }
                                             continue;
                                          }

                                          if(var42 == 4118) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var35 = class32.field723[var5];
                                             var43 = class32.field723[1 + var5];
                                             class32.chatboxSegments[var6++] = var100.substring(var35, var43);
                                             continue;
                                          }

                                          if(var42 == 4119) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             StringBuilder var55 = new StringBuilder(var100.length());
                                             var17 = false;

                                             for(var18 = 0; var18 < var100.length(); ++var18) {
                                                var59 = var100.charAt(var18);
                                                if(var59 == 60) {
                                                   var17 = true;
                                                } else if(var59 == 62) {
                                                   var17 = false;
                                                } else if(!var17) {
                                                   var55.append(var59);
                                                }
                                             }

                                             class32.chatboxSegments[var6++] = var55.toString();
                                             continue;
                                          }

                                          if(var42 == 4120) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field723[var5];
                                             class32.field723[var5++] = var100.indexOf(var35);
                                             continue;
                                          }

                                          if(var42 == 4121) {
                                             var6 -= 2;
                                             var100 = class32.chatboxSegments[var6];
                                             var47 = class32.chatboxSegments[1 + var6];
                                             --var5;
                                             var43 = class32.field723[var5];
                                             class32.field723[var5++] = var100.indexOf(var47, var43);
                                             continue;
                                          }
                                       } else if(var42 < 4300) {
                                          if(var42 == 4200) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             class32.chatboxSegments[var6++] = class88.getItemDefinition(var15).name;
                                             continue;
                                          }

                                          ItemComposition var78;
                                          if(var42 == 4201) {
                                             var5 -= 2;
                                             var15 = class32.field723[var5];
                                             var35 = class32.field723[var5 + 1];
                                             var78 = class88.getItemDefinition(var15);
                                             if(var35 >= 1 && var35 <= 5 && null != var78.groundActions[var35 - 1]) {
                                                class32.chatboxSegments[var6++] = var78.groundActions[var35 - 1];
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var42 == 4202) {
                                             var5 -= 2;
                                             var15 = class32.field723[var5];
                                             var35 = class32.field723[1 + var5];
                                             var78 = class88.getItemDefinition(var15);
                                             if(var35 >= 1 && var35 <= 5 && var78.inventoryActions[var35 - 1] != null) {
                                                class32.chatboxSegments[var6++] = var78.inventoryActions[var35 - 1];
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var42 == 4203) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             class32.field723[var5++] = class88.getItemDefinition(var15).price;
                                             continue;
                                          }

                                          if(var42 == 4204) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             class32.field723[var5++] = class88.getItemDefinition(var15).isStackable == 1?1:0;
                                             continue;
                                          }

                                          ItemComposition var58;
                                          if(var42 == 4205) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             var58 = class88.getItemDefinition(var15);
                                             if(var58.field2974 == -1 && var58.note >= 0) {
                                                class32.field723[var5++] = var58.note;
                                                continue;
                                             }

                                             class32.field723[var5++] = var15;
                                             continue;
                                          }

                                          if(var42 == 4206) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             var58 = class88.getItemDefinition(var15);
                                             if(var58.field2974 >= 0 && var58.note >= 0) {
                                                class32.field723[var5++] = var58.note;
                                                continue;
                                             }

                                             class32.field723[var5++] = var15;
                                             continue;
                                          }

                                          if(var42 == 4207) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             class32.field723[var5++] = class88.getItemDefinition(var15).isMembers?1:0;
                                             continue;
                                          }

                                          if(var42 == 4208) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             var58 = class88.getItemDefinition(var15);
                                             if(var58.field2942 == -1 && var58.field2984 >= 0) {
                                                class32.field723[var5++] = var58.field2984;
                                                continue;
                                             }

                                             class32.field723[var5++] = var15;
                                             continue;
                                          }

                                          if(var42 == 4209) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             var58 = class88.getItemDefinition(var15);
                                             if(var58.field2942 >= 0 && var58.field2984 >= 0) {
                                                class32.field723[var5++] = var58.field2984;
                                                continue;
                                             }

                                             class32.field723[var5++] = var15;
                                             continue;
                                          }

                                          if(var42 == 4210) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field723[var5];
                                             var53 = var35 == 1;
                                             var31 = var100.toLowerCase();
                                             short[] var83 = new short[16];
                                             var20 = 0;
                                             var36 = 0;

                                             while(true) {
                                                if(var36 >= ItemComposition.field2975) {
                                                   Projectile.field874 = var83;
                                                   class149.field2024 = 0;
                                                   DecorativeObject.field1596 = var20;
                                                   String[] var52 = new String[DecorativeObject.field1596];

                                                   for(var22 = 0; var22 < DecorativeObject.field1596; ++var22) {
                                                      var52[var22] = class88.getItemDefinition(var83[var22]).name;
                                                   }

                                                   short[] var97 = Projectile.field874;
                                                   CombatInfo1.method623(var52, var97, 0, var52.length - 1);
                                                   break;
                                                }

                                                ItemComposition var94 = class88.getItemDefinition(var36);
                                                if((!var53 || var94.field2981) && var94.field2974 == -1 && var94.name.toLowerCase().indexOf(var31) != -1) {
                                                   if(var20 >= 250) {
                                                      DecorativeObject.field1596 = -1;
                                                      Projectile.field874 = null;
                                                      break;
                                                   }

                                                   if(var20 >= var83.length) {
                                                      short[] var38 = new short[var83.length * 2];

                                                      for(var24 = 0; var24 < var20; ++var24) {
                                                         var38[var24] = var83[var24];
                                                      }

                                                      var83 = var38;
                                                   }

                                                   var83[var20++] = (short)var36;
                                                }

                                                ++var36;
                                             }

                                             class32.field723[var5++] = DecorativeObject.field1596;
                                             continue;
                                          }

                                          if(var42 == 4211) {
                                             if(null != Projectile.field874 && class149.field2024 < DecorativeObject.field1596) {
                                                class32.field723[var5++] = Projectile.field874[++class149.field2024 - 1] & '\uffff';
                                                continue;
                                             }

                                             class32.field723[var5++] = -1;
                                             continue;
                                          }

                                          if(var42 == 4212) {
                                             class149.field2024 = 0;
                                             continue;
                                          }
                                       } else if(var42 < 5100) {
                                          if(var42 == 5000) {
                                             class32.field723[var5++] = Client.field498;
                                             continue;
                                          }

                                          if(var42 == 5001) {
                                             var5 -= 3;
                                             Client.field498 = class32.field723[var5];
                                             var35 = class32.field723[1 + var5];
                                             class216[] var86 = new class216[]{class216.field3162, class216.field3165, class216.field3163};
                                             class216[] var96 = var86;
                                             var19 = 0;

                                             class216 var108;
                                             while(true) {
                                                if(var19 >= var96.length) {
                                                   var108 = null;
                                                   break;
                                                }

                                                class216 var81 = var96[var19];
                                                if(var35 == var81.field3161) {
                                                   var108 = var81;
                                                   break;
                                                }

                                                ++var19;
                                             }

                                             FrameMap.field1467 = var108;
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

                                          if(var42 == 5002) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var35 = class32.field723[var5];
                                             var43 = class32.field723[1 + var5];
                                             Client.field326.method3029(81);
                                             Client.field326.method2760(class148.method2740(var100) + 2);
                                             Client.field326.method2811(var100);
                                             Client.field326.method2760(var35 - 1);
                                             Client.field326.method2760(var43);
                                             continue;
                                          }

                                          if(var42 == 5003) {
                                             var5 -= 2;
                                             var15 = class32.field723[var5];
                                             var35 = class32.field723[var5 + 1];
                                             ChatLineBuffer var91 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var15));
                                             MessageNode var84 = var91.method876(var35);
                                             if(null != var84) {
                                                class32.field723[var5++] = var84.id;
                                                class32.field723[var5++] = var84.tick;
                                                class32.chatboxSegments[var6++] = null != var84.name?var84.name:"";
                                                class32.chatboxSegments[var6++] = null != var84.sender?var84.sender:"";
                                                class32.chatboxSegments[var6++] = null != var84.value?var84.value:"";
                                             } else {
                                                class32.field723[var5++] = -1;
                                                class32.field723[var5++] = 0;
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var42 == 5004) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             MessageNode var62 = (MessageNode)class47.field922.method2300((long)var15);
                                             if(var62 != null) {
                                                class32.field723[var5++] = var62.type;
                                                class32.field723[var5++] = var62.tick;
                                                class32.chatboxSegments[var6++] = null != var62.name?var62.name:"";
                                                class32.chatboxSegments[var6++] = null != var62.sender?var62.sender:"";
                                                class32.chatboxSegments[var6++] = null != var62.value?var62.value:"";
                                             } else {
                                                class32.field723[var5++] = -1;
                                                class32.field723[var5++] = 0;
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var42 == 5005) {
                                             if(FrameMap.field1467 == null) {
                                                class32.field723[var5++] = -1;
                                             } else {
                                                class32.field723[var5++] = FrameMap.field1467.field3161;
                                             }
                                             continue;
                                          }

                                          if(var42 == 5008) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field723[var5];
                                             var31 = var100.toLowerCase();
                                             byte var60 = 0;
                                             if(var31.startsWith("yellow:")) {
                                                var60 = 0;
                                                var100 = var100.substring("yellow:".length());
                                             } else if(var31.startsWith("red:")) {
                                                var60 = 1;
                                                var100 = var100.substring("red:".length());
                                             } else if(var31.startsWith("green:")) {
                                                var60 = 2;
                                                var100 = var100.substring("green:".length());
                                             } else if(var31.startsWith("cyan:")) {
                                                var60 = 3;
                                                var100 = var100.substring("cyan:".length());
                                             } else if(var31.startsWith("purple:")) {
                                                var60 = 4;
                                                var100 = var100.substring("purple:".length());
                                             } else if(var31.startsWith("white:")) {
                                                var60 = 5;
                                                var100 = var100.substring("white:".length());
                                             } else if(var31.startsWith("flash1:")) {
                                                var60 = 6;
                                                var100 = var100.substring("flash1:".length());
                                             } else if(var31.startsWith("flash2:")) {
                                                var60 = 7;
                                                var100 = var100.substring("flash2:".length());
                                             } else if(var31.startsWith("flash3:")) {
                                                var60 = 8;
                                                var100 = var100.substring("flash3:".length());
                                             } else if(var31.startsWith("glow1:")) {
                                                var60 = 9;
                                                var100 = var100.substring("glow1:".length());
                                             } else if(var31.startsWith("glow2:")) {
                                                var60 = 10;
                                                var100 = var100.substring("glow2:".length());
                                             } else if(var31.startsWith("glow3:")) {
                                                var60 = 11;
                                                var100 = var100.substring("glow3:".length());
                                             } else if(Client.field472 != 0) {
                                                if(var31.startsWith("yellow:")) {
                                                   var60 = 0;
                                                   var100 = var100.substring("yellow:".length());
                                                } else if(var31.startsWith("red:")) {
                                                   var60 = 1;
                                                   var100 = var100.substring("red:".length());
                                                } else if(var31.startsWith("green:")) {
                                                   var60 = 2;
                                                   var100 = var100.substring("green:".length());
                                                } else if(var31.startsWith("cyan:")) {
                                                   var60 = 3;
                                                   var100 = var100.substring("cyan:".length());
                                                } else if(var31.startsWith("purple:")) {
                                                   var60 = 4;
                                                   var100 = var100.substring("purple:".length());
                                                } else if(var31.startsWith("white:")) {
                                                   var60 = 5;
                                                   var100 = var100.substring("white:".length());
                                                } else if(var31.startsWith("flash1:")) {
                                                   var60 = 6;
                                                   var100 = var100.substring("flash1:".length());
                                                } else if(var31.startsWith("flash2:")) {
                                                   var60 = 7;
                                                   var100 = var100.substring("flash2:".length());
                                                } else if(var31.startsWith("flash3:")) {
                                                   var60 = 8;
                                                   var100 = var100.substring("flash3:".length());
                                                } else if(var31.startsWith("glow1:")) {
                                                   var60 = 9;
                                                   var100 = var100.substring("glow1:".length());
                                                } else if(var31.startsWith("glow2:")) {
                                                   var60 = 10;
                                                   var100 = var100.substring("glow2:".length());
                                                } else if(var31.startsWith("glow3:")) {
                                                   var60 = 11;
                                                   var100 = var100.substring("glow3:".length());
                                                }
                                             }

                                             var31 = var100.toLowerCase();
                                             byte var61 = 0;
                                             if(var31.startsWith("wave:")) {
                                                var61 = 1;
                                                var100 = var100.substring("wave:".length());
                                             } else if(var31.startsWith("wave2:")) {
                                                var61 = 2;
                                                var100 = var100.substring("wave2:".length());
                                             } else if(var31.startsWith("shake:")) {
                                                var61 = 3;
                                                var100 = var100.substring("shake:".length());
                                             } else if(var31.startsWith("scroll:")) {
                                                var61 = 4;
                                                var100 = var100.substring("scroll:".length());
                                             } else if(var31.startsWith("slide:")) {
                                                var61 = 5;
                                                var100 = var100.substring("slide:".length());
                                             } else if(Client.field472 != 0) {
                                                if(var31.startsWith("wave:")) {
                                                   var61 = 1;
                                                   var100 = var100.substring("wave:".length());
                                                } else if(var31.startsWith("wave2:")) {
                                                   var61 = 2;
                                                   var100 = var100.substring("wave2:".length());
                                                } else if(var31.startsWith("shake:")) {
                                                   var61 = 3;
                                                   var100 = var100.substring("shake:".length());
                                                } else if(var31.startsWith("scroll:")) {
                                                   var61 = 4;
                                                   var100 = var100.substring("scroll:".length());
                                                } else if(var31.startsWith("slide:")) {
                                                   var61 = 5;
                                                   var100 = var100.substring("slide:".length());
                                                }
                                             }

                                             Client.field326.method3029(174);
                                             Client.field326.method2760(0);
                                             var20 = Client.field326.offset;
                                             Client.field326.method2760(var35);
                                             Client.field326.method2760(var60);
                                             Client.field326.method2760(var61);
                                             class159 var54 = Client.field326;
                                             var22 = var54.offset;
                                             byte[] var102 = class183.method3353(var100);
                                             var54.method2900(var102.length);
                                             var54.offset += class210.field3106.method2709(var102, 0, var102.length, var54.payload, var54.offset);
                                             Client.field326.method2772(Client.field326.offset - var20);
                                             continue;
                                          }

                                          if(var42 == 5009) {
                                             var6 -= 2;
                                             var100 = class32.chatboxSegments[var6];
                                             var47 = class32.chatboxSegments[1 + var6];
                                             Client.field326.method3029(65);
                                             Client.field326.method2918(0);
                                             var43 = Client.field326.offset;
                                             Client.field326.method2811(var100);
                                             class159 var89 = Client.field326;
                                             var19 = var89.offset;
                                             var70 = class183.method3353(var47);
                                             var89.method2900(var70.length);
                                             var89.offset += class210.field3106.method2709(var70, 0, var70.length, var89.payload, var89.offset);
                                             Client.field326.method2771(Client.field326.offset - var43);
                                             continue;
                                          }

                                          if(var42 == 5015) {
                                             if(null != class148.localPlayer && null != class148.localPlayer.name) {
                                                var100 = class148.localPlayer.name;
                                             } else {
                                                var100 = "";
                                             }

                                             class32.chatboxSegments[var6++] = var100;
                                             continue;
                                          }

                                          if(var42 == 5016) {
                                             class32.field723[var5++] = Client.field499;
                                             continue;
                                          }

                                          if(var42 == 5017) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             var44 = class32.field723;
                                             var43 = var5++;
                                             ChatLineBuffer var90 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var15));
                                             if(var90 == null) {
                                                var18 = 0;
                                             } else {
                                                var18 = var90.method877();
                                             }

                                             var44[var43] = var18;
                                             continue;
                                          }

                                          if(var42 == 5018) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             class32.field723[var5++] = class191.method3478(var15);
                                             continue;
                                          }

                                          if(var42 == 5019) {
                                             --var5;
                                             var15 = class32.field723[var5];
                                             var44 = class32.field723;
                                             var43 = var5++;
                                             MessageNode var88 = (MessageNode)class47.field922.method2300((long)var15);
                                             if(var88 == null) {
                                                var18 = -1;
                                             } else if(class47.field921.field1886 == var88.next) {
                                                var18 = -1;
                                             } else {
                                                var18 = ((MessageNode)var88.next).id;
                                             }

                                             var44[var43] = var18;
                                             continue;
                                          }

                                          if(var42 == 5020) {
                                             --var6;
                                             var100 = class32.chatboxSegments[var6];
                                             if(var100.equalsIgnoreCase("toggleroof")) {
                                                class2.field21.field690 = !class2.field21.field690;
                                                class7.method108();
                                                if(class2.field21.field690) {
                                                   class7.method99(99, "", "Roofs are now all hidden");
                                                } else {
                                                   class7.method99(99, "", "Roofs will only be removed selectively");
                                                }
                                             }

                                             if(var100.equalsIgnoreCase("displayfps")) {
                                                Client.field296 = !Client.field296;
                                             }

                                             if(Client.field352 >= 2) {
                                                if(var100.equalsIgnoreCase("fpson")) {
                                                   Client.field296 = true;
                                                }

                                                if(var100.equalsIgnoreCase("fpsoff")) {
                                                   Client.field296 = false;
                                                }

                                                if(var100.equalsIgnoreCase("gc")) {
                                                   System.gc();
                                                }

                                                if(var100.equalsIgnoreCase("clientdrop")) {
                                                   Frames.method1851();
                                                }

                                                if(var100.equalsIgnoreCase("errortest") && Client.field416 == 2) {
                                                   throw new RuntimeException();
                                                }
                                             }

                                             Client.field326.method3029(64);
                                             Client.field326.method2760(var100.length() + 1);
                                             Client.field326.method2811(var100);
                                             continue;
                                          }

                                          if(var42 == 5021) {
                                             --var6;
                                             Client.field554 = class32.chatboxSegments[var6].toLowerCase().trim();
                                             continue;
                                          }

                                          if(var42 == 5022) {
                                             class32.chatboxSegments[var6++] = Client.field554;
                                             continue;
                                          }
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var42 >= 2000) {
                                 var42 -= 1000;
                                 --var5;
                                 var30 = class44.method799(class32.field723[var5]);
                              } else {
                                 var30 = var48?WidgetNode.field187:class38.field789;
                              }

                              if(var42 == 1927) {
                                 if(class32.field722 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var30.field2227) {
                                    return;
                                 }

                                 class18 var45 = new class18();
                                 var45.field195 = var30;
                                 var45.field203 = var30.field2227;
                                 var45.field198 = 1 + class32.field722;
                                 Client.field479.method2394(var0);
                                 continue;
                              }
                           }
                        } else {
                           if(var42 >= 2000) {
                              var42 -= 1000;
                              --var5;
                              var30 = class44.method799(class32.field723[var5]);
                           } else {
                              var30 = var48?WidgetNode.field187:class38.field789;
                           }

                           if(var42 == 1300) {
                              --var5;
                              var35 = class32.field723[var5] - 1;
                              if(var35 >= 0 && var35 <= 9) {
                                 --var6;
                                 var30.method3174(var35, class32.chatboxSegments[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var42 == 1301) {
                              var5 -= 2;
                              var35 = class32.field723[var5];
                              var43 = class32.field723[var5 + 1];
                              var30.parent = class157.method3011(var35, var43);
                              continue;
                           }

                           if(var42 == 1302) {
                              --var5;
                              var30.field2263 = class32.field723[var5] == 1;
                              continue;
                           }

                           if(var42 == 1303) {
                              --var5;
                              var30.field2261 = class32.field723[var5];
                              continue;
                           }

                           if(var42 == 1304) {
                              --var5;
                              var30.field2262 = class32.field723[var5];
                              continue;
                           }

                           if(var42 == 1305) {
                              --var6;
                              var30.name = class32.chatboxSegments[var6];
                              continue;
                           }

                           if(var42 == 1306) {
                              --var6;
                              var30.field2264 = class32.chatboxSegments[var6];
                              continue;
                           }

                           if(var42 == 1307) {
                              var30.actions = null;
                              continue;
                           }
                        }
                     } else {
                        if(var42 >= 2000) {
                           var42 -= 1000;
                           --var5;
                           var30 = class44.method799(class32.field723[var5]);
                        } else {
                           var30 = var48?WidgetNode.field187:class38.field789;
                        }

                        class6.method87(var30);
                        if(var42 == 1200 || var42 == 1205 || var42 == 1212) {
                           var5 -= 2;
                           var35 = class32.field723[var5];
                           var43 = class32.field723[1 + var5];
                           var30.item = var35;
                           var30.stackSize = var43;
                           ItemComposition var34 = class88.getItemDefinition(var35);
                           var30.rotationX = var34.field2949;
                           var30.rotationZ = var34.field2937;
                           var30.rotationY = var34.field2951;
                           var30.field2234 = var34.field2952;
                           var30.field2178 = var34.field2953;
                           var30.field2239 = var34.field2948;
                           if(var42 == 1205) {
                              var30.field2244 = 0;
                           } else if(var42 == 1212 | var34.isStackable == 1) {
                              var30.field2244 = 1;
                           } else {
                              var30.field2244 = 2;
                           }

                           if(var30.field2231 > 0) {
                              var30.field2239 = var30.field2239 * 32 / var30.field2231;
                           } else if(var30.field2237 > 0) {
                              var30.field2239 = var30.field2239 * 32 / var30.field2237;
                           }
                           continue;
                        }

                        if(var42 == 1201) {
                           var30.modelType = 2;
                           --var5;
                           var30.modelId = class32.field723[var5];
                           continue;
                        }

                        if(var42 == 1202) {
                           var30.modelType = 3;
                           var30.modelId = class148.localPlayer.composition.method3125();
                           continue;
                        }
                     }
                  } else {
                     var15 = -1;
                     if(var42 >= 2000) {
                        var42 -= 1000;
                        --var5;
                        var15 = class32.field723[var5];
                        var16 = class44.method799(var15);
                     } else {
                        var16 = var48?WidgetNode.field187:class38.field789;
                     }

                     if(var42 == 1000) {
                        var5 -= 4;
                        var16.field2194 = class32.field723[var5];
                        var16.field2195 = class32.field723[var5 + 1];
                        var16.field2230 = class32.field723[2 + var5];
                        var16.field2191 = class32.field723[var5 + 3];
                        class6.method87(var16);
                        XItemContainer.method166(var16);
                        if(var15 != -1 && var16.type == 0) {
                           class6.method97(Widget.widgets[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var42 == 1001) {
                        var5 -= 4;
                        var16.field2237 = class32.field723[var5];
                        var16.field2279 = class32.field723[var5 + 1];
                        var16.field2197 = class32.field723[2 + var5];
                        var16.field2193 = class32.field723[3 + var5];
                        class6.method87(var16);
                        XItemContainer.method166(var16);
                        if(var15 != -1 && var16.type == 0) {
                           class6.method97(Widget.widgets[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var42 == 1003) {
                        --var5;
                        var17 = class32.field723[var5] == 1;
                        if(var16.isHidden != var17) {
                           var16.isHidden = var17;
                           class6.method87(var16);
                        }
                        continue;
                     }

                     if(var42 == 1005) {
                        --var5;
                        var16.field2204 = class32.field723[var5] == 1;
                        continue;
                     }

                     if(var42 == 1006) {
                        --var5;
                        var16.field2319 = class32.field723[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var42 < 5400) {
                  if(var42 == 5306) {
                     class32.field723[var5++] = class182.method3335();
                     continue;
                  }

                  if(var42 == 5307) {
                     --var5;
                     var15 = class32.field723[var5];
                     if(var15 != 1 && var15 != 2) {
                        continue;
                     }

                     Client.field379 = 0L;
                     if(var15 >= 2) {
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

                  if(var42 == 5308) {
                     class32.field723[var5++] = class2.field21.field687;
                     continue;
                  }

                  if(var42 == 5309) {
                     --var5;
                     var15 = class32.field723[var5];
                     if(var15 == 1 || var15 == 2) {
                        class2.field21.field687 = var15;
                        class7.method108();
                     }
                     continue;
                  }
               }

               if(var42 < 5600) {
                  if(var42 == 5504) {
                     var5 -= 2;
                     var15 = class32.field723[var5];
                     var35 = class32.field723[1 + var5];
                     if(!Client.field529) {
                        Client.field520 = var15;
                        Client.mapAngle = var35;
                     }
                     continue;
                  }

                  if(var42 == 5505) {
                     class32.field723[var5++] = Client.field520;
                     continue;
                  }

                  if(var42 == 5506) {
                     class32.field723[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var42 == 5530) {
                     --var5;
                     var15 = class32.field723[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     Client.field372 = var15;
                     continue;
                  }

                  if(var42 == 5531) {
                     class32.field723[var5++] = Client.field372;
                     continue;
                  }
               }

               if(var42 < 5700 && var42 == 5630) {
                  Client.field336 = 250;
               } else {
                  if(var42 < 6300) {
                     if(var42 == 6200) {
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

                     if(var42 == 6201) {
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

                     if(var42 == 6202) {
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

                     if(var42 == 6203) {
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

                     if(var42 == 6204) {
                        class32.field723[var5++] = Client.field389;
                        class32.field723[var5++] = Client.field538;
                        continue;
                     }

                     if(var42 == 6205) {
                        class32.field723[var5++] = Client.field535;
                        class32.field723[var5++] = Client.field536;
                        continue;
                     }
                  }

                  if(var42 < 6600) {
                     if(var42 == 6500) {
                        class32.field723[var5++] = class97.loadWorlds()?1:0;
                        continue;
                     }

                     World var64;
                     if(var42 == 6501) {
                        World.field675 = 0;
                        if(World.field675 < World.field684) {
                           var64 = World.worldList[++World.field675 - 1];
                        } else {
                           var64 = null;
                        }

                        if(var64 != null) {
                           class32.field723[var5++] = var64.id;
                           class32.field723[var5++] = var64.mask;
                           class32.chatboxSegments[var6++] = var64.activity;
                           class32.field723[var5++] = var64.location;
                           class32.field723[var5++] = var64.playerCount;
                           class32.chatboxSegments[var6++] = var64.address;
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

                     if(var42 == 6502) {
                        World var109;
                        if(World.field675 < World.field684) {
                           var109 = World.worldList[++World.field675 - 1];
                        } else {
                           var109 = null;
                        }

                        if(null != var109) {
                           class32.field723[var5++] = var109.id;
                           class32.field723[var5++] = var109.mask;
                           class32.chatboxSegments[var6++] = var109.activity;
                           class32.field723[var5++] = var109.location;
                           class32.field723[var5++] = var109.playerCount;
                           class32.chatboxSegments[var6++] = var109.address;
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

                     if(var42 == 6506) {
                        --var5;
                        var15 = class32.field723[var5];
                        var64 = null;

                        for(var43 = 0; var43 < World.field684; ++var43) {
                           if(World.worldList[var43].id == var15) {
                              var64 = World.worldList[var43];
                              break;
                           }
                        }

                        if(var64 != null) {
                           class32.field723[var5++] = var64.id;
                           class32.field723[var5++] = var64.mask;
                           class32.chatboxSegments[var6++] = var64.activity;
                           class32.field723[var5++] = var64.location;
                           class32.field723[var5++] = var64.playerCount;
                           class32.chatboxSegments[var6++] = var64.address;
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

                     if(var42 == 6507) {
                        var5 -= 4;
                        var15 = class32.field723[var5];
                        var92 = class32.field723[1 + var5] == 1;
                        var43 = class32.field723[2 + var5];
                        var53 = class32.field723[var5 + 3] == 1;
                        class30.method666(var15, var92, var43, var53);
                        continue;
                     }

                     if(var42 == 6511) {
                        --var5;
                        var15 = class32.field723[var5];
                        if(var15 >= 0 && var15 < World.field684) {
                           var64 = World.worldList[var15];
                           class32.field723[var5++] = var64.id;
                           class32.field723[var5++] = var64.mask;
                           class32.chatboxSegments[var6++] = var64.activity;
                           class32.field723[var5++] = var64.location;
                           class32.field723[var5++] = var64.playerCount;
                           class32.chatboxSegments[var6++] = var64.address;
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
         } catch (Exception var41) {
            StringBuilder var40 = new StringBuilder(30);
            var40.append("").append(var4.hash).append(" ");

            for(var13 = class32.field725 - 1; var13 >= 0; --var13) {
               var40.append("").append(class32.field726[var13].field124.hash).append(" ");
            }

            var40.append("").append(var10);
            class174.method3240(var40.toString(), var41);
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
