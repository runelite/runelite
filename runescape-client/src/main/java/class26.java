import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class26 extends Node {
   @ObfuscatedName("t")
   class205 field640 = new class205();
   @ObfuscatedName("n")
   class49 field642;
   @ObfuscatedName("a")
   static String field643;

   class26(class49 var1) {
      this.field642 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "28"
   )
   void method605(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field640.method3932(); var7 != null; var7 = (class20)this.field640.method3928()) {
         ++var6;
         if(var7.field570 == var1) {
            var7.method558(var1, var2, var3, var4);
            return;
         }

         if(var7.field570 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.field640.method3930(new class20(var1, var2, var3, var4));
         }

      } else {
         class205.method3936(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field640.method3932().unlink();
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass20;",
      garbageValue = "-413252353"
   )
   class20 method606(int var1) {
      class20 var2 = (class20)this.field640.method3932();
      if(null != var2 && var2.field570 <= var1) {
         for(class20 var3 = (class20)this.field640.method3928(); var3 != null && var3.field570 <= var1; var3 = (class20)this.field640.method3928()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.field642.field1084 + var2.field570 + var2.field568 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-17812"
   )
   boolean method607() {
      return this.field640.method3935();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "-489643878"
   )
   static void method613(class0 var0, int var1) {
      Object[] var2 = var0.field1;
      int var3 = ((Integer)var2[0]).intValue();
      class23 var4 = SecondaryBufferProvider.method1691(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field594;
         int[] var9 = var4.field593;
         byte var10 = -1;
         class38.field806 = 0;

         int var13;
         try {
            class222.field3214 = new int[var4.field597];
            int var11 = 0;
            class38.field801 = new String[var4.field602];
            int var12 = 0;

            int var14;
            String var33;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field5;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field2 != null?var0.field2.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field0;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field2 != null?var0.field2.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field6?var0.field6.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field6 != null?var0.field6.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field11;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field8;
                  }

                  class222.field3214[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var33 = (String)var2[var13];
                  if(var33.equals("event_opbase")) {
                     var33 = var0.field9;
                  }

                  class38.field801[var12++] = var33;
               }
            }

            var13 = 0;
            class38.field810 = var0.field10;

            label3803:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var47 = var8[var7];
               int var15;
               int var17;
               int var18;
               int var19;
               int var20;
               String var35;
               int var39;
               int[] var56;
               byte var67;
               String var81;
               String var102;
               if(var47 < 100) {
                  if(var47 == 0) {
                     class38.field804[var5++] = var9[var7];
                     continue;
                  }

                  if(var47 == 1) {
                     var14 = var9[var7];
                     class38.field804[var5++] = class179.widgetSettings[var14];
                     continue;
                  }

                  if(var47 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class179.widgetSettings[var14] = class38.field804[var5];
                     BufferProvider.method1745(var14);
                     continue;
                  }

                  if(var47 == 3) {
                     class38.chatboxSegments[var6++] = var4.field596[var7];
                     continue;
                  }

                  if(var47 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var47 == 7) {
                     var5 -= 2;
                     if(class38.field804[var5 + 1] != class38.field804[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 8) {
                     var5 -= 2;
                     if(class38.field804[var5] == class38.field804[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 9) {
                     var5 -= 2;
                     if(class38.field804[var5] < class38.field804[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 10) {
                     var5 -= 2;
                     if(class38.field804[var5] > class38.field804[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 21) {
                     if(class38.field806 == 0) {
                        return;
                     }

                     class14 var77 = class38.field807[--class38.field806];
                     var4 = var77.field216;
                     var8 = var4.field594;
                     var9 = var4.field593;
                     var7 = var77.field206;
                     class222.field3214 = var77.field215;
                     class38.field801 = var77.field208;
                     continue;
                  }

                  if(var47 == 25) {
                     var14 = var9[var7];
                     class38.field804[var5++] = class112.method2454(var14);
                     continue;
                  }

                  if(var47 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class38.field804[var5];
                     class50 var75 = class28.method652(var14);
                     var17 = var75.field1092;
                     var18 = var75.field1094;
                     var19 = var75.field1093;
                     var20 = class179.field2938[var19 - var18];
                     if(var15 < 0 || var15 > var20) {
                        var15 = 0;
                     }

                     var20 <<= var18;
                     class179.widgetSettings[var17] = class179.widgetSettings[var17] & ~var20 | var15 << var18 & var20;
                     continue;
                  }

                  if(var47 == 31) {
                     var5 -= 2;
                     if(class38.field804[var5] <= class38.field804[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 32) {
                     var5 -= 2;
                     if(class38.field804[var5] >= class38.field804[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 33) {
                     class38.field804[var5++] = class222.field3214[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var47 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class222.field3214[var10001] = class38.field804[var5];
                     continue;
                  }

                  if(var47 == 35) {
                     class38.chatboxSegments[var6++] = class38.field801[var9[var7]];
                     continue;
                  }

                  if(var47 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class38.field801[var10001] = class38.chatboxSegments[var6];
                     continue;
                  }

                  if(var47 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var72 = class38.chatboxSegments;
                     if(var14 == 0) {
                        var102 = "";
                     } else if(var14 == 1) {
                        var35 = var72[var6];
                        if(null == var35) {
                           var102 = "null";
                        } else {
                           var102 = var35.toString();
                        }
                     } else {
                        var17 = var14 + var6;
                        var18 = 0;

                        for(var19 = var6; var19 < var17; ++var19) {
                           var81 = var72[var19];
                           if(var81 == null) {
                              var18 += 4;
                           } else {
                              var18 += var81.length();
                           }
                        }

                        StringBuilder var101 = new StringBuilder(var18);

                        for(var20 = var6; var20 < var17; ++var20) {
                           String var55 = var72[var20];
                           if(null == var55) {
                              var101.append("null");
                           } else {
                              var101.append(var55);
                           }
                        }

                        var102 = var101.toString();
                     }

                     class38.chatboxSegments[var6++] = var102;
                     continue;
                  }

                  if(var47 == 38) {
                     --var5;
                     continue;
                  }

                  if(var47 == 39) {
                     --var6;
                     continue;
                  }

                  if(var47 == 40) {
                     var14 = var9[var7];
                     class23 var109 = SecondaryBufferProvider.method1691(var14);
                     var56 = new int[var109.field597];
                     String[] var92 = new String[var109.field602];

                     for(var18 = 0; var18 < var109.field599; ++var18) {
                        var56[var18] = class38.field804[var5 - var109.field599 + var18];
                     }

                     for(var18 = 0; var18 < var109.field607; ++var18) {
                        var92[var18] = class38.chatboxSegments[var18 + (var6 - var109.field607)];
                     }

                     var5 -= var109.field599;
                     var6 -= var109.field607;
                     class14 var105 = new class14();
                     var105.field216 = var4;
                     var105.field206 = var7;
                     var105.field215 = class222.field3214;
                     var105.field208 = class38.field801;
                     class38.field807[++class38.field806 - 1] = var105;
                     var4 = var109;
                     var8 = var109.field594;
                     var9 = var109.field593;
                     var7 = -1;
                     class222.field3214 = var56;
                     class38.field801 = var92;
                     continue;
                  }

                  if(var47 == 42) {
                     class38.field804[var5++] = class126.chatMessages.method197(var9[var7]);
                     continue;
                  }

                  if(var47 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class126.chatMessages.method196(var10001, class38.field804[var5]);
                     continue;
                  }

                  if(var47 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var39 = class38.field804[var5];
                     if(var39 >= 0 && var39 <= 5000) {
                        class38.field799[var14] = var39;
                        var67 = -1;
                        if(var15 == 105) {
                           var67 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var39) {
                              continue label3803;
                           }

                           class38.field802[var14][var18] = var67;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var47 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class38.field804[var5];
                     if(var15 >= 0 && var15 < class38.field799[var14]) {
                        class38.field804[var5++] = class38.field802[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var47 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class38.field804[var5];
                     if(var15 >= 0 && var15 < class38.field799[var14]) {
                        class38.field802[var14][var15] = class38.field804[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var47 == 47) {
                     var33 = class126.chatMessages.method225(var9[var7]);
                     if(var33 == null) {
                        var33 = "null";
                     }

                     class38.chatboxSegments[var6++] = var33;
                     continue;
                  }

                  if(var47 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class126.chatMessages.method202(var10001, class38.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var51;
               if(var9[var7] == 1) {
                  var51 = true;
               } else {
                  var51 = false;
               }

               Widget var34;
               boolean var52;
               Widget var65;
               Widget var78;
               Widget var84;
               boolean var94;
               if(var47 < 1000) {
                  if(var47 == 100) {
                     var5 -= 3;
                     var15 = class38.field804[var5];
                     var39 = class38.field804[var5 + 1];
                     var17 = class38.field804[var5 + 2];
                     if(var39 == 0) {
                        throw new RuntimeException();
                     }

                     var84 = class153.method3170(var15);
                     if(var84.children == null) {
                        var84.children = new Widget[var17 + 1];
                     }

                     if(var84.children.length <= var17) {
                        Widget[] var97 = new Widget[1 + var17];

                        for(var20 = 0; var20 < var84.children.length; ++var20) {
                           var97[var20] = var84.children[var20];
                        }

                        var84.children = var97;
                     }

                     if(var17 > 0 && var84.children[var17 - 1] == null) {
                        throw new RuntimeException("" + (var17 - 1));
                     }

                     Widget var100 = new Widget();
                     var100.type = var39;
                     var100.parentId = var100.id = var84.id;
                     var100.index = var17;
                     var100.field2787 = true;
                     var84.children[var17] = var100;
                     if(var51) {
                        BufferProvider.field1448 = var100;
                     } else {
                        class165.field2683 = var100;
                     }

                     MessageNode.method750(var84);
                     continue;
                  }

                  if(var47 == 101) {
                     var34 = var51?BufferProvider.field1448:class165.field2683;
                     var65 = class153.method3170(var34.id);
                     var65.children[var34.index] = null;
                     MessageNode.method750(var65);
                     continue;
                  }

                  if(var47 == 102) {
                     --var5;
                     var34 = class153.method3170(class38.field804[var5]);
                     var34.children = null;
                     MessageNode.method750(var34);
                     continue;
                  }

                  if(var47 == 200) {
                     var5 -= 2;
                     var15 = class38.field804[var5];
                     var39 = class38.field804[var5 + 1];
                     var78 = Player.method44(var15, var39);
                     if(var78 != null && var39 != -1) {
                        class38.field804[var5++] = 1;
                        if(var51) {
                           BufferProvider.field1448 = var78;
                        } else {
                           class165.field2683 = var78;
                        }
                        continue;
                     }

                     class38.field804[var5++] = 0;
                     continue;
                  }

                  if(var47 == 201) {
                     --var5;
                     var34 = class153.method3170(class38.field804[var5]);
                     if(var34 != null) {
                        class38.field804[var5++] = 1;
                        if(var51) {
                           BufferProvider.field1448 = var34;
                        } else {
                           class165.field2683 = var34;
                        }
                     } else {
                        class38.field804[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var61;
                  if(var47 >= 1000 && var47 < 1100 || var47 >= 2000 && var47 < 2100) {
                     var15 = -1;
                     if(var47 >= 2000) {
                        var47 -= 1000;
                        --var5;
                        var15 = class38.field804[var5];
                        var65 = class153.method3170(var15);
                     } else {
                        var65 = var51?BufferProvider.field1448:class165.field2683;
                     }

                     if(var47 == 1000) {
                        var5 -= 4;
                        var65.field2797 = class38.field804[var5];
                        var65.field2798 = class38.field804[1 + var5];
                        var65.field2793 = class38.field804[var5 + 2];
                        var65.field2794 = class38.field804[var5 + 3];
                        MessageNode.method750(var65);
                        class14.method157(var65);
                        if(var15 != -1 && var65.type == 0) {
                           class174.method3428(Widget.widgets[var15 >> 16], var65, false);
                        }
                        continue;
                     }

                     if(var47 == 1001) {
                        var5 -= 4;
                        var65.field2799 = class38.field804[var5];
                        var65.field2800 = class38.field804[1 + var5];
                        var65.field2795 = class38.field804[2 + var5];
                        var65.field2796 = class38.field804[3 + var5];
                        MessageNode.method750(var65);
                        class14.method157(var65);
                        if(var15 != -1 && var65.type == 0) {
                           class174.method3428(Widget.widgets[var15 >> 16], var65, false);
                        }
                        continue;
                     }

                     if(var47 == 1003) {
                        --var5;
                        var61 = class38.field804[var5] == 1;
                        if(var61 != var65.isHidden) {
                           var65.isHidden = var61;
                           MessageNode.method750(var65);
                        }
                        continue;
                     }

                     if(var47 == 1005) {
                        --var5;
                        var65.field2921 = class38.field804[var5] == 1;
                        continue;
                     }

                     if(var47 == 1006) {
                        --var5;
                        var65.field2877 = class38.field804[var5] == 1;
                        continue;
                     }
                  } else if((var47 < 1100 || var47 >= 1200) && (var47 < 2100 || var47 >= 2200)) {
                     if(var47 >= 1200 && var47 < 1300 || var47 >= 2200 && var47 < 2300) {
                        if(var47 >= 2000) {
                           var47 -= 1000;
                           --var5;
                           var34 = class153.method3170(class38.field804[var5]);
                        } else {
                           var34 = var51?BufferProvider.field1448:class165.field2683;
                        }

                        MessageNode.method750(var34);
                        if(var47 == 1200 || var47 == 1205 || var47 == 1212) {
                           var5 -= 2;
                           var39 = class38.field804[var5];
                           var17 = class38.field804[1 + var5];
                           var34.item = var39;
                           var34.stackSize = var17;
                           ItemComposition var104 = class45.getItemDefinition(var39);
                           var34.rotationX = var104.field1184;
                           var34.rotationZ = var104.field1174;
                           var34.rotationY = var104.field1198;
                           var34.field2837 = var104.field1170;
                           var34.field2860 = var104.field1171;
                           var34.field2842 = var104.field1166;
                           if(var47 == 1205) {
                              var34.field2846 = 0;
                           } else if(var47 == 1212 | var104.isStackable == 1) {
                              var34.field2846 = 1;
                           } else {
                              var34.field2846 = 2;
                           }

                           if(var34.field2844 > 0) {
                              var34.field2842 = var34.field2842 * 32 / var34.field2844;
                           } else if(var34.field2799 > 0) {
                              var34.field2842 = var34.field2842 * 32 / var34.field2799;
                           }
                           continue;
                        }

                        if(var47 == 1201) {
                           var34.modelType = 2;
                           --var5;
                           var34.modelId = class38.field804[var5];
                           continue;
                        }

                        if(var47 == 1202) {
                           var34.modelType = 3;
                           var34.modelId = class34.localPlayer.composition.method3547();
                           continue;
                        }
                     } else if(var47 >= 1300 && var47 < 1400 || var47 >= 2300 && var47 < 2400) {
                        if(var47 >= 2000) {
                           var47 -= 1000;
                           --var5;
                           var34 = class153.method3170(class38.field804[var5]);
                        } else {
                           var34 = var51?BufferProvider.field1448:class165.field2683;
                        }

                        if(var47 == 1300) {
                           --var5;
                           var39 = class38.field804[var5] - 1;
                           if(var39 >= 0 && var39 <= 9) {
                              --var6;
                              var34.method3439(var39, class38.chatboxSegments[var6]);
                              continue;
                           }

                           --var6;
                           continue;
                        }

                        if(var47 == 1301) {
                           var5 -= 2;
                           var39 = class38.field804[var5];
                           var17 = class38.field804[var5 + 1];
                           var34.parent = Player.method44(var39, var17);
                           continue;
                        }

                        if(var47 == 1302) {
                           --var5;
                           var34.field2866 = class38.field804[var5] == 1;
                           continue;
                        }

                        if(var47 == 1303) {
                           --var5;
                           var34.field2864 = class38.field804[var5];
                           continue;
                        }

                        if(var47 == 1304) {
                           --var5;
                           var34.field2916 = class38.field804[var5];
                           continue;
                        }

                        if(var47 == 1305) {
                           --var6;
                           var34.name = class38.chatboxSegments[var6];
                           continue;
                        }

                        if(var47 == 1306) {
                           --var6;
                           var34.field2897 = class38.chatboxSegments[var6];
                           continue;
                        }

                        if(var47 == 1307) {
                           var34.actions = null;
                           continue;
                        }
                     } else {
                        String var48;
                        int[] var79;
                        if(var47 >= 1400 && var47 < 1500 || var47 >= 2400 && var47 < 2500) {
                           if(var47 >= 2000) {
                              var47 -= 1000;
                              --var5;
                              var34 = class153.method3170(class38.field804[var5]);
                           } else {
                              var34 = var51?BufferProvider.field1448:class165.field2683;
                           }

                           --var6;
                           var48 = class38.chatboxSegments[var6];
                           var79 = null;
                           if(var48.length() > 0 && var48.charAt(var48.length() - 1) == 89) {
                              --var5;
                              var18 = class38.field804[var5];
                              if(var18 > 0) {
                                 for(var79 = new int[var18]; var18-- > 0; var79[var18] = class38.field804[var5]) {
                                    --var5;
                                 }
                              }

                              var48 = var48.substring(0, var48.length() - 1);
                           }

                           Object[] var98 = new Object[var48.length() + 1];

                           for(var19 = var98.length - 1; var19 >= 1; --var19) {
                              if(var48.charAt(var19 - 1) == 115) {
                                 --var6;
                                 var98[var19] = class38.chatboxSegments[var6];
                              } else {
                                 --var5;
                                 var98[var19] = new Integer(class38.field804[var5]);
                              }
                           }

                           --var5;
                           var19 = class38.field804[var5];
                           if(var19 != -1) {
                              var98[0] = new Integer(var19);
                           } else {
                              var98 = null;
                           }

                           if(var47 == 1400) {
                              var34.field2870 = var98;
                           }

                           if(var47 == 1401) {
                              var34.field2886 = var98;
                           }

                           if(var47 == 1402) {
                              var34.field2872 = var98;
                           }

                           if(var47 == 1403) {
                              var34.field2874 = var98;
                           }

                           if(var47 == 1404) {
                              var34.field2876 = var98;
                           }

                           if(var47 == 1405) {
                              var34.field2781 = var98;
                           }

                           if(var47 == 1406) {
                              var34.field2880 = var98;
                           }

                           if(var47 == 1407) {
                              var34.field2881 = var98;
                              var34.field2882 = var79;
                           }

                           if(var47 == 1408) {
                              var34.field2779 = var98;
                           }

                           if(var47 == 1409) {
                              var34.field2888 = var98;
                           }

                           if(var47 == 1410) {
                              var34.field2878 = var98;
                           }

                           if(var47 == 1411) {
                              var34.field2871 = var98;
                           }

                           if(var47 == 1412) {
                              var34.field2875 = var98;
                           }

                           if(var47 == 1414) {
                              var34.field2883 = var98;
                              var34.field2884 = var79;
                           }

                           if(var47 == 1415) {
                              var34.field2811 = var98;
                              var34.field2784 = var79;
                           }

                           if(var47 == 1416) {
                              var34.field2879 = var98;
                           }

                           if(var47 == 1417) {
                              var34.field2865 = var98;
                           }

                           if(var47 == 1418) {
                              var34.field2847 = var98;
                           }

                           if(var47 == 1419) {
                              var34.field2852 = var98;
                           }

                           if(var47 == 1420) {
                              var34.field2892 = var98;
                           }

                           if(var47 == 1421) {
                              var34.field2893 = var98;
                           }

                           if(var47 == 1422) {
                              var34.field2894 = var98;
                           }

                           if(var47 == 1423) {
                              var34.field2895 = var98;
                           }

                           if(var47 == 1424) {
                              var34.field2896 = var98;
                           }

                           if(var47 == 1425) {
                              var34.field2873 = var98;
                           }

                           if(var47 == 1426) {
                              var34.field2899 = var98;
                           }

                           if(var47 == 1427) {
                              var34.field2791 = var98;
                           }

                           var34.field2817 = true;
                           continue;
                        }

                        if(var47 < 1600) {
                           var34 = var51?BufferProvider.field1448:class165.field2683;
                           if(var47 == 1500) {
                              class38.field804[var5++] = var34.relativeX;
                              continue;
                           }

                           if(var47 == 1501) {
                              class38.field804[var5++] = var34.relativeY;
                              continue;
                           }

                           if(var47 == 1502) {
                              class38.field804[var5++] = var34.width;
                              continue;
                           }

                           if(var47 == 1503) {
                              class38.field804[var5++] = var34.height;
                              continue;
                           }

                           if(var47 == 1504) {
                              class38.field804[var5++] = var34.isHidden?1:0;
                              continue;
                           }

                           if(var47 == 1505) {
                              class38.field804[var5++] = var34.parentId;
                              continue;
                           }
                        } else if(var47 < 1700) {
                           var34 = var51?BufferProvider.field1448:class165.field2683;
                           if(var47 == 1600) {
                              class38.field804[var5++] = var34.itemId;
                              continue;
                           }

                           if(var47 == 1601) {
                              class38.field804[var5++] = var34.scrollY;
                              continue;
                           }

                           if(var47 == 1602) {
                              class38.chatboxSegments[var6++] = var34.text;
                              continue;
                           }

                           if(var47 == 1603) {
                              class38.field804[var5++] = var34.scrollWidth;
                              continue;
                           }

                           if(var47 == 1604) {
                              class38.field804[var5++] = var34.scrollHeight;
                              continue;
                           }

                           if(var47 == 1605) {
                              class38.field804[var5++] = var34.field2842;
                              continue;
                           }

                           if(var47 == 1606) {
                              class38.field804[var5++] = var34.rotationX;
                              continue;
                           }

                           if(var47 == 1607) {
                              class38.field804[var5++] = var34.rotationY;
                              continue;
                           }

                           if(var47 == 1608) {
                              class38.field804[var5++] = var34.rotationZ;
                              continue;
                           }

                           if(var47 == 1609) {
                              class38.field804[var5++] = var34.opacity;
                              continue;
                           }

                           if(var47 == 1610) {
                              class38.field804[var5++] = var34.field2782;
                              continue;
                           }

                           if(var47 == 1611) {
                              class38.field804[var5++] = var34.textColor;
                              continue;
                           }

                           if(var47 == 1612) {
                              class38.field804[var5++] = var34.field2814;
                              continue;
                           }

                           if(var47 == 1613) {
                              class38.field804[var5++] = var34.field2818.vmethod3196();
                              continue;
                           }
                        } else if(var47 < 1800) {
                           var34 = var51?BufferProvider.field1448:class165.field2683;
                           if(var47 == 1700) {
                              class38.field804[var5++] = var34.item;
                              continue;
                           }

                           if(var47 == 1701) {
                              if(var34.item != -1) {
                                 class38.field804[var5++] = var34.stackSize;
                              } else {
                                 class38.field804[var5++] = 0;
                              }
                              continue;
                           }

                           if(var47 == 1702) {
                              class38.field804[var5++] = var34.index;
                              continue;
                           }
                        } else if(var47 < 1900) {
                           var34 = var51?BufferProvider.field1448:class165.field2683;
                           if(var47 == 1800) {
                              class38.field804[var5++] = class175.method3438(class93.method2130(var34));
                              continue;
                           }

                           if(var47 == 1801) {
                              --var5;
                              var39 = class38.field804[var5];
                              --var39;
                              if(null != var34.actions && var39 < var34.actions.length && null != var34.actions[var39]) {
                                 class38.chatboxSegments[var6++] = var34.actions[var39];
                                 continue;
                              }

                              class38.chatboxSegments[var6++] = "";
                              continue;
                           }

                           if(var47 == 1802) {
                              if(null == var34.name) {
                                 class38.chatboxSegments[var6++] = "";
                              } else {
                                 class38.chatboxSegments[var6++] = var34.name;
                              }
                              continue;
                           }
                        } else if(var47 >= 1900 && var47 < 2000 || var47 >= 2900 && var47 < 3000) {
                           if(var47 >= 2000) {
                              var47 -= 1000;
                              --var5;
                              var34 = class153.method3170(class38.field804[var5]);
                           } else {
                              var34 = var51?BufferProvider.field1448:class165.field2683;
                           }

                           if(var47 == 1927) {
                              if(class38.field810 >= 10) {
                                 throw new RuntimeException();
                              }

                              if(var34.field2791 == null) {
                                 return;
                              }

                              class0 var63 = new class0();
                              var63.field2 = var34;
                              var63.field1 = var34.field2791;
                              var63.field10 = 1 + class38.field810;
                              Client.field379.method3886(var0);
                              continue;
                           }
                        } else if(var47 < 2600) {
                           --var5;
                           var34 = class153.method3170(class38.field804[var5]);
                           if(var47 == 2500) {
                              class38.field804[var5++] = var34.relativeX;
                              continue;
                           }

                           if(var47 == 2501) {
                              class38.field804[var5++] = var34.relativeY;
                              continue;
                           }

                           if(var47 == 2502) {
                              class38.field804[var5++] = var34.width;
                              continue;
                           }

                           if(var47 == 2503) {
                              class38.field804[var5++] = var34.height;
                              continue;
                           }

                           if(var47 == 2504) {
                              class38.field804[var5++] = var34.isHidden?1:0;
                              continue;
                           }

                           if(var47 == 2505) {
                              class38.field804[var5++] = var34.parentId;
                              continue;
                           }
                        } else if(var47 < 2700) {
                           --var5;
                           var34 = class153.method3170(class38.field804[var5]);
                           if(var47 == 2600) {
                              class38.field804[var5++] = var34.itemId;
                              continue;
                           }

                           if(var47 == 2601) {
                              class38.field804[var5++] = var34.scrollY;
                              continue;
                           }

                           if(var47 == 2602) {
                              class38.chatboxSegments[var6++] = var34.text;
                              continue;
                           }

                           if(var47 == 2603) {
                              class38.field804[var5++] = var34.scrollWidth;
                              continue;
                           }

                           if(var47 == 2604) {
                              class38.field804[var5++] = var34.scrollHeight;
                              continue;
                           }

                           if(var47 == 2605) {
                              class38.field804[var5++] = var34.field2842;
                              continue;
                           }

                           if(var47 == 2606) {
                              class38.field804[var5++] = var34.rotationX;
                              continue;
                           }

                           if(var47 == 2607) {
                              class38.field804[var5++] = var34.rotationY;
                              continue;
                           }

                           if(var47 == 2608) {
                              class38.field804[var5++] = var34.rotationZ;
                              continue;
                           }

                           if(var47 == 2609) {
                              class38.field804[var5++] = var34.opacity;
                              continue;
                           }

                           if(var47 == 2610) {
                              class38.field804[var5++] = var34.field2782;
                              continue;
                           }

                           if(var47 == 2611) {
                              class38.field804[var5++] = var34.textColor;
                              continue;
                           }

                           if(var47 == 2612) {
                              class38.field804[var5++] = var34.field2814;
                              continue;
                           }

                           if(var47 == 2613) {
                              class38.field804[var5++] = var34.field2818.vmethod3196();
                              continue;
                           }
                        } else if(var47 < 2800) {
                           if(var47 == 2700) {
                              --var5;
                              var34 = class153.method3170(class38.field804[var5]);
                              class38.field804[var5++] = var34.item;
                              continue;
                           }

                           if(var47 == 2701) {
                              --var5;
                              var34 = class153.method3170(class38.field804[var5]);
                              if(var34.item != -1) {
                                 class38.field804[var5++] = var34.stackSize;
                              } else {
                                 class38.field804[var5++] = 0;
                              }
                              continue;
                           }

                           if(var47 == 2702) {
                              --var5;
                              var15 = class38.field804[var5];
                              WidgetNode var16 = (WidgetNode)Client.componentTable.method3849((long)var15);
                              if(null != var16) {
                                 class38.field804[var5++] = 1;
                              } else {
                                 class38.field804[var5++] = 0;
                              }
                              continue;
                           }

                           if(var47 == 2706) {
                              class38.field804[var5++] = Client.widgetRoot;
                              continue;
                           }
                        } else if(var47 < 2900) {
                           --var5;
                           var34 = class153.method3170(class38.field804[var5]);
                           if(var47 == 2800) {
                              class38.field804[var5++] = class175.method3438(class93.method2130(var34));
                              continue;
                           }

                           if(var47 == 2801) {
                              --var5;
                              var39 = class38.field804[var5];
                              --var39;
                              if(var34.actions != null && var39 < var34.actions.length && var34.actions[var39] != null) {
                                 class38.chatboxSegments[var6++] = var34.actions[var39];
                                 continue;
                              }

                              class38.chatboxSegments[var6++] = "";
                              continue;
                           }

                           if(var47 == 2802) {
                              if(null == var34.name) {
                                 class38.chatboxSegments[var6++] = "";
                              } else {
                                 class38.chatboxSegments[var6++] = var34.name;
                              }
                              continue;
                           }
                        } else if(var47 < 3200) {
                           if(var47 == 3100) {
                              --var6;
                              var102 = class38.chatboxSegments[var6];
                              class190.sendGameMessage(0, "", var102);
                              continue;
                           }

                           if(var47 == 3101) {
                              var5 -= 2;
                              class184.method3588(class34.localPlayer, class38.field804[var5], class38.field804[1 + var5]);
                              continue;
                           }

                           if(var47 == 3103) {
                              Client.field397.method2768(243);

                              for(WidgetNode var103 = (WidgetNode)Client.componentTable.method3852(); var103 != null; var103 = (WidgetNode)Client.componentTable.method3857()) {
                                 if(var103.field58 == 0 || var103.field58 == 3) {
                                    Player.method33(var103, true);
                                 }
                              }

                              if(null != Client.field443) {
                                 MessageNode.method750(Client.field443);
                                 Client.field443 = null;
                              }
                              continue;
                           }

                           if(var47 == 3104) {
                              --var6;
                              var102 = class38.chatboxSegments[var6];
                              var39 = 0;
                              if(class16.method185(var102)) {
                                 var17 = class93.method2129(var102, 10, true);
                                 var39 = var17;
                              }

                              Client.field397.method2768(63);
                              Client.field397.method2521(var39);
                              continue;
                           }

                           if(var47 == 3105) {
                              --var6;
                              var102 = class38.chatboxSegments[var6];
                              Client.field397.method2768(164);
                              Client.field397.method2518(var102.length() + 1);
                              Client.field397.method2524(var102);
                              continue;
                           }

                           if(var47 == 3106) {
                              --var6;
                              var102 = class38.chatboxSegments[var6];
                              Client.field397.method2768(226);
                              Client.field397.method2518(var102.length() + 1);
                              Client.field397.method2524(var102);
                              continue;
                           }

                           if(var47 == 3107) {
                              --var5;
                              var15 = class38.field804[var5];
                              --var6;
                              var48 = class38.chatboxSegments[var6];
                              class214.method4011(var15, var48);
                              continue;
                           }

                           if(var47 == 3108) {
                              var5 -= 3;
                              var15 = class38.field804[var5];
                              var39 = class38.field804[var5 + 1];
                              var17 = class38.field804[var5 + 2];
                              var84 = class153.method3170(var17);
                              class79.method1695(var84, var15, var39);
                              continue;
                           }

                           if(var47 == 3109) {
                              var5 -= 2;
                              var15 = class38.field804[var5];
                              var39 = class38.field804[1 + var5];
                              var78 = var51?BufferProvider.field1448:class165.field2683;
                              class79.method1695(var78, var15, var39);
                              continue;
                           }

                           if(var47 == 3110) {
                              --var5;
                              ChatMessages.field276 = class38.field804[var5] == 1;
                              continue;
                           }

                           if(var47 == 3111) {
                              class38.field804[var5++] = class16.field232.field149?1:0;
                              continue;
                           }

                           if(var47 == 3112) {
                              --var5;
                              class16.field232.field149 = class38.field804[var5] == 1;
                              class18.method193();
                              continue;
                           }

                           if(var47 == 3113) {
                              --var6;
                              var102 = class38.chatboxSegments[var6];
                              --var5;
                              var94 = class38.field804[var5] == 1;
                              if(!var94) {
                                 class20.method565(var102, 3);
                                 continue;
                              }

                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var102));
                                    continue;
                                 } catch (Exception var45) {
                                    ;
                                 }
                              }

                              if(class141.field2180.startsWith("win")) {
                                 class20.method565(var102, 0);
                              } else if(class141.field2180.startsWith("mac")) {
                                 SecondaryBufferProvider.method1668(var102, 1, "openjs");
                              } else {
                                 class20.method565(var102, 2);
                              }
                              continue;
                           }

                           if(var47 == 3115) {
                              --var5;
                              var15 = class38.field804[var5];
                              Client.field397.method2768(1);
                              Client.field397.method2519(var15);
                              continue;
                           }

                           if(var47 == 3116) {
                              --var5;
                              var15 = class38.field804[var5];
                              var6 -= 2;
                              var48 = class38.chatboxSegments[var6];
                              var35 = class38.chatboxSegments[1 + var6];
                              if(var48.length() <= 500 && var35.length() <= 500) {
                                 Client.field397.method2768(237);
                                 Client.field397.method2519(1 + class75.method1624(var48) + class75.method1624(var35));
                                 Client.field397.method2558(var15);
                                 Client.field397.method2524(var48);
                                 Client.field397.method2524(var35);
                              }
                              continue;
                           }
                        } else if(var47 < 3300) {
                           if(var47 == 3200) {
                              var5 -= 3;
                              Player.method39(class38.field804[var5], class38.field804[1 + var5], class38.field804[var5 + 2]);
                              continue;
                           }

                           if(var47 == 3201) {
                              --var5;
                              class14.method160(class38.field804[var5]);
                              continue;
                           }

                           if(var47 == 3202) {
                              var5 -= 2;
                              var15 = class38.field804[var5];
                              int var10000 = class38.field804[1 + var5];
                              if(Client.field516 != 0 && var15 != -1) {
                                 class1.method16(class21.field585, var15, 0, Client.field516, false);
                                 Client.field470 = true;
                              }
                              continue;
                           }
                        } else if(var47 < 3400) {
                           if(var47 == 3300) {
                              class38.field804[var5++] = Client.gameCycle;
                              continue;
                           }

                           if(var47 == 3301) {
                              var5 -= 2;
                              var15 = class38.field804[var5];
                              var39 = class38.field804[var5 + 1];
                              class38.field804[var5++] = class0.method2(var15, var39);
                              continue;
                           }

                           if(var47 == 3302) {
                              var5 -= 2;
                              var15 = class38.field804[var5];
                              var39 = class38.field804[var5 + 1];
                              var79 = class38.field804;
                              var18 = var5++;
                              XItemContainer var36 = (XItemContainer)XItemContainer.itemContainers.method3849((long)var15);
                              if(var36 == null) {
                                 var19 = 0;
                              } else if(var39 >= 0 && var39 < var36.stackSizes.length) {
                                 var19 = var36.stackSizes[var39];
                              } else {
                                 var19 = 0;
                              }

                              var79[var18] = var19;
                              continue;
                           }

                           if(var47 == 3303) {
                              var5 -= 2;
                              var15 = class38.field804[var5];
                              var39 = class38.field804[var5 + 1];
                              class38.field804[var5++] = KitDefinition.method959(var15, var39);
                              continue;
                           }

                           if(var47 == 3304) {
                              --var5;
                              var15 = class38.field804[var5];
                              class38.field804[var5++] = class16.method187(var15).field1143;
                              continue;
                           }

                           if(var47 == 3305) {
                              --var5;
                              var15 = class38.field804[var5];
                              class38.field804[var5++] = Client.boostedSkillLevels[var15];
                              continue;
                           }

                           if(var47 == 3306) {
                              --var5;
                              var15 = class38.field804[var5];
                              class38.field804[var5++] = Client.realSkillLevels[var15];
                              continue;
                           }

                           if(var47 == 3307) {
                              --var5;
                              var15 = class38.field804[var5];
                              class38.field804[var5++] = Client.skillExperiences[var15];
                              continue;
                           }

                           if(var47 == 3308) {
                              var15 = XItemContainer.plane;
                              var39 = class32.baseX + (class34.localPlayer.x >> 7);
                              var17 = class8.baseY + (class34.localPlayer.y >> 7);
                              class38.field804[var5++] = (var15 << 28) + (var39 << 14) + var17;
                              continue;
                           }

                           if(var47 == 3309) {
                              --var5;
                              var15 = class38.field804[var5];
                              class38.field804[var5++] = var15 >> 14 & 16383;
                              continue;
                           }

                           if(var47 == 3310) {
                              --var5;
                              var15 = class38.field804[var5];
                              class38.field804[var5++] = var15 >> 28;
                              continue;
                           }

                           if(var47 == 3311) {
                              --var5;
                              var15 = class38.field804[var5];
                              class38.field804[var5++] = var15 & 16383;
                              continue;
                           }

                           if(var47 == 3312) {
                              class38.field804[var5++] = Client.isMembers?1:0;
                              continue;
                           }

                           if(var47 == 3313) {
                              var5 -= 2;
                              var15 = class38.field804[var5] + '耀';
                              var39 = class38.field804[var5 + 1];
                              class38.field804[var5++] = class0.method2(var15, var39);
                              continue;
                           }

                           if(var47 == 3314) {
                              var5 -= 2;
                              var15 = class38.field804[var5] + '耀';
                              var39 = class38.field804[var5 + 1];
                              class38.field804[var5++] = class20.method567(var15, var39);
                              continue;
                           }

                           if(var47 == 3315) {
                              var5 -= 2;
                              var15 = '耀' + class38.field804[var5];
                              var39 = class38.field804[var5 + 1];
                              class38.field804[var5++] = KitDefinition.method959(var15, var39);
                              continue;
                           }

                           if(var47 == 3316) {
                              if(Client.field446 >= 2) {
                                 class38.field804[var5++] = Client.field446;
                              } else {
                                 class38.field804[var5++] = 0;
                              }
                              continue;
                           }

                           if(var47 == 3317) {
                              class38.field804[var5++] = Client.field457;
                              continue;
                           }

                           if(var47 == 3318) {
                              class38.field804[var5++] = Client.world;
                              continue;
                           }

                           if(var47 == 3321) {
                              class38.field804[var5++] = Client.energy;
                              continue;
                           }

                           if(var47 == 3322) {
                              class38.field804[var5++] = Client.weight;
                              continue;
                           }

                           if(var47 == 3323) {
                              if(Client.field448) {
                                 class38.field804[var5++] = 1;
                              } else {
                                 class38.field804[var5++] = 0;
                              }
                              continue;
                           }

                           if(var47 == 3324) {
                              class38.field804[var5++] = Client.flags;
                              continue;
                           }
                        } else if(var47 < 3500) {
                           if(var47 == 3400) {
                              var5 -= 2;
                              var15 = class38.field804[var5];
                              var39 = class38.field804[var5 + 1];
                              class52 var80 = class13.method150(var15);
                              if(var80.field1126 != 115) {
                                 ;
                              }

                              for(var18 = 0; var18 < var80.field1135; ++var18) {
                                 if(var80.field1132[var18] == var39) {
                                    class38.chatboxSegments[var6++] = var80.field1134[var18];
                                    var80 = null;
                                    break;
                                 }
                              }

                              if(null != var80) {
                                 class38.chatboxSegments[var6++] = var80.field1125;
                              }
                              continue;
                           }

                           if(var47 == 3408) {
                              var5 -= 4;
                              var15 = class38.field804[var5];
                              var39 = class38.field804[var5 + 1];
                              var17 = class38.field804[2 + var5];
                              var18 = class38.field804[var5 + 3];
                              class52 var37 = class13.method150(var17);
                              if(var15 == var37.field1129 && var37.field1126 == var39) {
                                 for(var20 = 0; var20 < var37.field1135; ++var20) {
                                    if(var37.field1132[var20] == var18) {
                                       if(var39 == 115) {
                                          class38.chatboxSegments[var6++] = var37.field1134[var20];
                                       } else {
                                          class38.field804[var5++] = var37.field1133[var20];
                                       }

                                       var37 = null;
                                       break;
                                    }
                                 }

                                 if(var37 != null) {
                                    if(var39 == 115) {
                                       class38.chatboxSegments[var6++] = var37.field1125;
                                    } else {
                                       class38.field804[var5++] = var37.field1130;
                                    }
                                 }
                                 continue;
                              }

                              if(var39 == 115) {
                                 class38.chatboxSegments[var6++] = "null";
                              } else {
                                 class38.field804[var5++] = 0;
                              }
                              continue;
                           }
                        } else {
                           int var22;
                           String var83;
                           if(var47 < 3700) {
                              if(var47 == 3600) {
                                 if(Client.field494 == 0) {
                                    class38.field804[var5++] = -2;
                                 } else if(Client.field494 == 1) {
                                    class38.field804[var5++] = -1;
                                 } else {
                                    class38.field804[var5++] = Client.friendCount;
                                 }
                                 continue;
                              }

                              if(var47 == 3601) {
                                 --var5;
                                 var15 = class38.field804[var5];
                                 if(Client.field494 == 2 && var15 < Client.friendCount) {
                                    class38.chatboxSegments[var6++] = Client.friends[var15].name;
                                    class38.chatboxSegments[var6++] = Client.friends[var15].previousName;
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var47 == 3602) {
                                 --var5;
                                 var15 = class38.field804[var5];
                                 if(Client.field494 == 2 && var15 < Client.friendCount) {
                                    class38.field804[var5++] = Client.friends[var15].world;
                                    continue;
                                 }

                                 class38.field804[var5++] = 0;
                                 continue;
                              }

                              if(var47 == 3603) {
                                 --var5;
                                 var15 = class38.field804[var5];
                                 if(Client.field494 == 2 && var15 < Client.friendCount) {
                                    class38.field804[var5++] = Client.friends[var15].rank;
                                    continue;
                                 }

                                 class38.field804[var5++] = 0;
                                 continue;
                              }

                              if(var47 == 3604) {
                                 --var6;
                                 var102 = class38.chatboxSegments[var6];
                                 --var5;
                                 var39 = class38.field804[var5];
                                 class38.method764(var102, var39);
                                 continue;
                              }

                              Ignore var87;
                              Friend var89;
                              if(var47 == 3605) {
                                 --var6;
                                 var102 = class38.chatboxSegments[var6];
                                 if(null == var102) {
                                    continue;
                                 }

                                 if((Client.friendCount < 200 || Client.field404 == 1) && Client.friendCount < 400) {
                                    var48 = class47.method967(var102, RSCanvas.field2188);
                                    if(var48 == null) {
                                       continue;
                                    }

                                    for(var17 = 0; var17 < Client.friendCount; ++var17) {
                                       var89 = Client.friends[var17];
                                       var83 = class47.method967(var89.name, RSCanvas.field2188);
                                       if(null != var83 && var83.equals(var48)) {
                                          class190.sendGameMessage(30, "", var102 + " is already on your friend list");
                                          continue label3803;
                                       }

                                       if(null != var89.previousName) {
                                          var81 = class47.method967(var89.previousName, RSCanvas.field2188);
                                          if(var81 != null && var81.equals(var48)) {
                                             class190.sendGameMessage(30, "", var102 + " is already on your friend list");
                                             continue label3803;
                                          }
                                       }
                                    }

                                    for(var17 = 0; var17 < Client.ignoreCount; ++var17) {
                                       var87 = Client.ignores[var17];
                                       var83 = class47.method967(var87.name, RSCanvas.field2188);
                                       if(var83 != null && var83.equals(var48)) {
                                          class190.sendGameMessage(30, "", "Please remove " + var102 + " from your ignore list first");
                                          continue label3803;
                                       }

                                       if(null != var87.previousName) {
                                          var81 = class47.method967(var87.previousName, RSCanvas.field2188);
                                          if(var81 != null && var81.equals(var48)) {
                                             class190.sendGameMessage(30, "", "Please remove " + var102 + " from your ignore list first");
                                             continue label3803;
                                          }
                                       }
                                    }

                                    if(class47.method967(class34.localPlayer.name, RSCanvas.field2188).equals(var48)) {
                                       class190.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                    } else {
                                       Client.field397.method2768(114);
                                       Client.field397.method2518(class75.method1624(var102));
                                       Client.field397.method2524(var102);
                                    }
                                    continue;
                                 }

                                 class190.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                 continue;
                              }

                              if(var47 == 3606) {
                                 --var6;
                                 var102 = class38.chatboxSegments[var6];
                                 KitDefinition.method957(var102);
                                 continue;
                              }

                              if(var47 == 3607) {
                                 --var6;
                                 var102 = class38.chatboxSegments[var6];
                                 if(var102 == null) {
                                    continue;
                                 }

                                 if((Client.ignoreCount < 100 || Client.field404 == 1) && Client.ignoreCount < 400) {
                                    var48 = class47.method967(var102, RSCanvas.field2188);
                                    if(null == var48) {
                                       continue;
                                    }

                                    for(var17 = 0; var17 < Client.ignoreCount; ++var17) {
                                       var87 = Client.ignores[var17];
                                       var83 = class47.method967(var87.name, RSCanvas.field2188);
                                       if(null != var83 && var83.equals(var48)) {
                                          class190.sendGameMessage(31, "", var102 + " is already on your ignore list");
                                          continue label3803;
                                       }

                                       if(null != var87.previousName) {
                                          var81 = class47.method967(var87.previousName, RSCanvas.field2188);
                                          if(var81 != null && var81.equals(var48)) {
                                             class190.sendGameMessage(31, "", var102 + " is already on your ignore list");
                                             continue label3803;
                                          }
                                       }
                                    }

                                    for(var17 = 0; var17 < Client.friendCount; ++var17) {
                                       var89 = Client.friends[var17];
                                       var83 = class47.method967(var89.name, RSCanvas.field2188);
                                       if(null != var83 && var83.equals(var48)) {
                                          class190.sendGameMessage(31, "", "Please remove " + var102 + " from your friend list first");
                                          continue label3803;
                                       }

                                       if(var89.previousName != null) {
                                          var81 = class47.method967(var89.previousName, RSCanvas.field2188);
                                          if(var81 != null && var81.equals(var48)) {
                                             class190.sendGameMessage(31, "", "Please remove " + var102 + " from your friend list first");
                                             continue label3803;
                                          }
                                       }
                                    }

                                    if(class47.method967(class34.localPlayer.name, RSCanvas.field2188).equals(var48)) {
                                       class190.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                    } else {
                                       Client.field397.method2768(58);
                                       Client.field397.method2518(class75.method1624(var102));
                                       Client.field397.method2524(var102);
                                    }
                                    continue;
                                 }

                                 class190.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                 continue;
                              }

                              if(var47 == 3608) {
                                 --var6;
                                 var102 = class38.chatboxSegments[var6];
                                 if(null == var102) {
                                    continue;
                                 }

                                 var48 = class47.method967(var102, RSCanvas.field2188);
                                 if(null == var48) {
                                    continue;
                                 }

                                 var17 = 0;

                                 while(true) {
                                    if(var17 >= Client.ignoreCount) {
                                       continue label3803;
                                    }

                                    var87 = Client.ignores[var17];
                                    var83 = var87.name;
                                    var81 = class47.method967(var83, RSCanvas.field2188);
                                    boolean var40;
                                    if(var102 != null && null != var83) {
                                       if(!var102.startsWith("#") && !var83.startsWith("#")) {
                                          var40 = var48.equals(var81);
                                       } else {
                                          var40 = var102.equals(var83);
                                       }
                                    } else {
                                       var40 = false;
                                    }

                                    if(var40) {
                                       --Client.ignoreCount;

                                       for(var22 = var17; var22 < Client.ignoreCount; ++var22) {
                                          Client.ignores[var22] = Client.ignores[var22 + 1];
                                       }

                                       Client.field472 = Client.field295;
                                       Client.field397.method2768(87);
                                       Client.field397.method2518(class75.method1624(var102));
                                       Client.field397.method2524(var102);
                                       continue label3803;
                                    }

                                    ++var17;
                                 }
                              }

                              if(var47 == 3609) {
                                 --var6;
                                 var102 = class38.chatboxSegments[var6];
                                 class155[] var49 = class158.method3190();

                                 for(var17 = 0; var17 < var49.length; ++var17) {
                                    class155 var85 = var49[var17];
                                    if(var85.field2311 != -1 && var102.startsWith(class119.method2476(var85.field2311))) {
                                       var102 = var102.substring(6 + Integer.toString(var85.field2311).length());
                                       break;
                                    }
                                 }

                                 class38.field804[var5++] = class5.method79(var102, false)?1:0;
                                 continue;
                              }

                              if(var47 == 3611) {
                                 if(null != Client.field506) {
                                    class38.chatboxSegments[var6++] = Client.method556(Client.field506);
                                 } else {
                                    class38.chatboxSegments[var6++] = "";
                                 }
                                 continue;
                              }

                              if(var47 == 3612) {
                                 if(Client.field506 != null) {
                                    class38.field804[var5++] = XItemContainer.field224;
                                 } else {
                                    class38.field804[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var47 == 3613) {
                                 --var5;
                                 var15 = class38.field804[var5];
                                 if(null != Client.field506 && var15 < XItemContainer.field224) {
                                    class38.chatboxSegments[var6++] = TextureProvider.clanMembers[var15].username;
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var47 == 3614) {
                                 --var5;
                                 var15 = class38.field804[var5];
                                 if(null != Client.field506 && var15 < XItemContainer.field224) {
                                    class38.field804[var5++] = TextureProvider.clanMembers[var15].world;
                                    continue;
                                 }

                                 class38.field804[var5++] = 0;
                                 continue;
                              }

                              if(var47 == 3615) {
                                 --var5;
                                 var15 = class38.field804[var5];
                                 if(Client.field506 != null && var15 < XItemContainer.field224) {
                                    class38.field804[var5++] = TextureProvider.clanMembers[var15].rank;
                                    continue;
                                 }

                                 class38.field804[var5++] = 0;
                                 continue;
                              }

                              if(var47 == 3616) {
                                 class38.field804[var5++] = ObjectComposition.field970;
                                 continue;
                              }

                              if(var47 == 3617) {
                                 --var6;
                                 var102 = class38.chatboxSegments[var6];
                                 if(TextureProvider.clanMembers != null) {
                                    Client.field397.method2768(41);
                                    Client.field397.method2518(class75.method1624(var102));
                                    Client.field397.method2524(var102);
                                 }
                                 continue;
                              }

                              if(var47 == 3618) {
                                 class38.field804[var5++] = WallObject.field1592;
                                 continue;
                              }

                              if(var47 == 3619) {
                                 --var6;
                                 var102 = class38.chatboxSegments[var6];
                                 if(!var102.equals("")) {
                                    Client.field397.method2768(221);
                                    Client.field397.method2518(class75.method1624(var102));
                                    Client.field397.method2524(var102);
                                 }
                                 continue;
                              }

                              if(var47 == 3620) {
                                 class177.method3496();
                                 continue;
                              }

                              if(var47 == 3621) {
                                 if(Client.field494 == 0) {
                                    class38.field804[var5++] = -1;
                                 } else {
                                    class38.field804[var5++] = Client.ignoreCount;
                                 }
                                 continue;
                              }

                              if(var47 == 3622) {
                                 --var5;
                                 var15 = class38.field804[var5];
                                 if(Client.field494 != 0 && var15 < Client.ignoreCount) {
                                    class38.chatboxSegments[var6++] = Client.ignores[var15].name;
                                    class38.chatboxSegments[var6++] = Client.ignores[var15].previousName;
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var47 == 3623) {
                                 --var6;
                                 var102 = class38.chatboxSegments[var6];
                                 if(var102.startsWith(class119.method2476(0)) || var102.startsWith(class119.method2476(1))) {
                                    var102 = var102.substring(7);
                                 }

                                 class38.field804[var5++] = class8.method104(var102)?1:0;
                                 continue;
                              }

                              if(var47 == 3624) {
                                 --var5;
                                 var15 = class38.field804[var5];
                                 if(TextureProvider.clanMembers != null && var15 < XItemContainer.field224 && TextureProvider.clanMembers[var15].username.equalsIgnoreCase(class34.localPlayer.name)) {
                                    class38.field804[var5++] = 1;
                                    continue;
                                 }

                                 class38.field804[var5++] = 0;
                                 continue;
                              }

                              if(var47 == 3625) {
                                 if(null != Client.field507) {
                                    class38.chatboxSegments[var6++] = Client.method556(Client.field507);
                                 } else {
                                    class38.chatboxSegments[var6++] = "";
                                 }
                                 continue;
                              }
                           } else {
                              long var60;
                              int var96;
                              if(var47 < 4000) {
                                 if(var47 == 3903) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    class38.field804[var5++] = Client.grandExchangeOffers[var15].method4072();
                                    continue;
                                 }

                                 if(var47 == 3904) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    class38.field804[var5++] = Client.grandExchangeOffers[var15].itemId;
                                    continue;
                                 }

                                 if(var47 == 3905) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    class38.field804[var5++] = Client.grandExchangeOffers[var15].price;
                                    continue;
                                 }

                                 if(var47 == 3906) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    class38.field804[var5++] = Client.grandExchangeOffers[var15].totalQuantity;
                                    continue;
                                 }

                                 if(var47 == 3907) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    class38.field804[var5++] = Client.grandExchangeOffers[var15].quantitySold;
                                    continue;
                                 }

                                 if(var47 == 3908) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    class38.field804[var5++] = Client.grandExchangeOffers[var15].spent;
                                    continue;
                                 }

                                 if(var47 == 3910) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var39 = Client.grandExchangeOffers[var15].method4063();
                                    class38.field804[var5++] = var39 == 0?1:0;
                                    continue;
                                 }

                                 if(var47 == 3911) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var39 = Client.grandExchangeOffers[var15].method4063();
                                    class38.field804[var5++] = var39 == 2?1:0;
                                    continue;
                                 }

                                 if(var47 == 3912) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var39 = Client.grandExchangeOffers[var15].method4063();
                                    class38.field804[var5++] = var39 == 5?1:0;
                                    continue;
                                 }

                                 if(var47 == 3913) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var39 = Client.grandExchangeOffers[var15].method4063();
                                    class38.field804[var5++] = var39 == 1?1:0;
                                    continue;
                                 }

                                 boolean var69;
                                 if(var47 == 3914) {
                                    --var5;
                                    var69 = class38.field804[var5] == 1;
                                    if(class13.field193 != null) {
                                       class13.field193.method4080(class224.field3227, var69);
                                    }
                                    continue;
                                 }

                                 if(var47 == 3915) {
                                    --var5;
                                    var69 = class38.field804[var5] == 1;
                                    if(null != class13.field193) {
                                       class13.field193.method4080(class224.field3226, var69);
                                    }
                                    continue;
                                 }

                                 if(var47 == 3916) {
                                    var5 -= 2;
                                    var69 = class38.field804[var5] == 1;
                                    var94 = class38.field804[var5 + 1] == 1;
                                    if(null != class13.field193) {
                                       class13.field193.method4080(new class22(var94), var69);
                                    }
                                    continue;
                                 }

                                 if(var47 == 3917) {
                                    --var5;
                                    var69 = class38.field804[var5] == 1;
                                    if(null != class13.field193) {
                                       class13.field193.method4080(class224.field3225, var69);
                                    }
                                    continue;
                                 }

                                 if(var47 == 3918) {
                                    --var5;
                                    var69 = class38.field804[var5] == 1;
                                    if(class13.field193 != null) {
                                       class13.field193.method4080(class224.field3229, var69);
                                    }
                                    continue;
                                 }

                                 if(var47 == 3919) {
                                    class38.field804[var5++] = null == class13.field193?0:class13.field193.field3228.size();
                                    continue;
                                 }

                                 class217 var50;
                                 if(var47 == 3920) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var50 = (class217)class13.field193.field3228.get(var15);
                                    class38.field804[var5++] = var50.field3196;
                                    continue;
                                 }

                                 if(var47 == 3921) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var50 = (class217)class13.field193.field3228.get(var15);
                                    class38.chatboxSegments[var6++] = var50.method4029();
                                    continue;
                                 }

                                 if(var47 == 3922) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var50 = (class217)class13.field193.field3228.get(var15);
                                    class38.chatboxSegments[var6++] = var50.method4027();
                                    continue;
                                 }

                                 if(var47 == 3923) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var50 = (class217)class13.field193.field3228.get(var15);
                                    var60 = class11.method139() - Client.field558 - var50.field3192;
                                    var19 = (int)(var60 / 3600000L);
                                    var20 = (int)((var60 - (long)(var19 * 3600000)) / 60000L);
                                    var96 = (int)((var60 - (long)(3600000 * var19) - (long)('\uea60' * var20)) / 1000L);
                                    String var41 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var96 / 10 + var96 % 10;
                                    class38.chatboxSegments[var6++] = var41;
                                    continue;
                                 }

                                 if(var47 == 3924) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var50 = (class217)class13.field193.field3228.get(var15);
                                    class38.field804[var5++] = var50.field3194.totalQuantity;
                                    continue;
                                 }

                                 if(var47 == 3925) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var50 = (class217)class13.field193.field3228.get(var15);
                                    class38.field804[var5++] = var50.field3194.price;
                                    continue;
                                 }

                                 if(var47 == 3926) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    var50 = (class217)class13.field193.field3228.get(var15);
                                    class38.field804[var5++] = var50.field3194.itemId;
                                    continue;
                                 }
                              } else if(var47 < 4100) {
                                 if(var47 == 4000) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[1 + var5];
                                    class38.field804[var5++] = var39 + var15;
                                    continue;
                                 }

                                 if(var47 == 4001) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[1 + var5];
                                    class38.field804[var5++] = var15 - var39;
                                    continue;
                                 }

                                 if(var47 == 4002) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[var5 + 1];
                                    class38.field804[var5++] = var39 * var15;
                                    continue;
                                 }

                                 if(var47 == 4003) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[var5 + 1];
                                    class38.field804[var5++] = var15 / var39;
                                    continue;
                                 }

                                 if(var47 == 4004) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    class38.field804[var5++] = (int)(Math.random() * (double)var15);
                                    continue;
                                 }

                                 if(var47 == 4005) {
                                    --var5;
                                    var15 = class38.field804[var5];
                                    class38.field804[var5++] = (int)(Math.random() * (double)(var15 + 1));
                                    continue;
                                 }

                                 if(var47 == 4006) {
                                    var5 -= 5;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[1 + var5];
                                    var17 = class38.field804[var5 + 2];
                                    var18 = class38.field804[var5 + 3];
                                    var19 = class38.field804[var5 + 4];
                                    class38.field804[var5++] = var15 + (var19 - var17) * (var39 - var15) / (var18 - var17);
                                    continue;
                                 }

                                 if(var47 == 4007) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[var5 + 1];
                                    class38.field804[var5++] = var15 + var15 * var39 / 100;
                                    continue;
                                 }

                                 if(var47 == 4008) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[var5 + 1];
                                    class38.field804[var5++] = var15 | 1 << var39;
                                    continue;
                                 }

                                 if(var47 == 4009) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[1 + var5];
                                    class38.field804[var5++] = var15 & -1 - (1 << var39);
                                    continue;
                                 }

                                 if(var47 == 4010) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[var5 + 1];
                                    class38.field804[var5++] = (var15 & 1 << var39) != 0?1:0;
                                    continue;
                                 }

                                 if(var47 == 4011) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[var5 + 1];
                                    class38.field804[var5++] = var15 % var39;
                                    continue;
                                 }

                                 if(var47 == 4012) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[1 + var5];
                                    if(var15 == 0) {
                                       class38.field804[var5++] = 0;
                                    } else {
                                       class38.field804[var5++] = (int)Math.pow((double)var15, (double)var39);
                                    }
                                    continue;
                                 }

                                 if(var47 == 4013) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[var5 + 1];
                                    if(var15 == 0) {
                                       class38.field804[var5++] = 0;
                                    } else if(var39 == 0) {
                                       class38.field804[var5++] = Integer.MAX_VALUE;
                                    } else {
                                       class38.field804[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var39);
                                    }
                                    continue;
                                 }

                                 if(var47 == 4014) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[1 + var5];
                                    class38.field804[var5++] = var15 & var39;
                                    continue;
                                 }

                                 if(var47 == 4015) {
                                    var5 -= 2;
                                    var15 = class38.field804[var5];
                                    var39 = class38.field804[var5 + 1];
                                    class38.field804[var5++] = var15 | var39;
                                    continue;
                                 }

                                 if(var47 == 4018) {
                                    var5 -= 3;
                                    long var76 = (long)class38.field804[var5];
                                    var60 = (long)class38.field804[var5 + 1];
                                    long var53 = (long)class38.field804[2 + var5];
                                    class38.field804[var5++] = (int)(var76 * var53 / var60);
                                    continue;
                                 }
                              } else {
                                 int var24;
                                 if(var47 < 4200) {
                                    if(var47 == 4100) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       --var5;
                                       var39 = class38.field804[var5];
                                       class38.chatboxSegments[var6++] = var102 + var39;
                                       continue;
                                    }

                                    if(var47 == 4101) {
                                       var6 -= 2;
                                       var102 = class38.chatboxSegments[var6];
                                       var48 = class38.chatboxSegments[1 + var6];
                                       class38.chatboxSegments[var6++] = var102 + var48;
                                       continue;
                                    }

                                    if(var47 == 4102) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       --var5;
                                       var39 = class38.field804[var5];
                                       class38.chatboxSegments[var6++] = var102 + class160.method3193(var39, true);
                                       continue;
                                    }

                                    if(var47 == 4103) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       class38.chatboxSegments[var6++] = var102.toLowerCase();
                                       continue;
                                    }

                                    if(var47 == 4104) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       long var106 = 86400000L * (11745L + (long)var15);
                                       class38.field808.setTime(new Date(var106));
                                       var18 = class38.field808.get(5);
                                       var19 = class38.field808.get(2);
                                       var20 = class38.field808.get(1);
                                       class38.chatboxSegments[var6++] = var18 + "-" + class38.field800[var19] + "-" + var20;
                                       continue;
                                    }

                                    if(var47 == 4105) {
                                       var6 -= 2;
                                       var102 = class38.chatboxSegments[var6];
                                       var48 = class38.chatboxSegments[var6 + 1];
                                       if(class34.localPlayer.composition != null && class34.localPlayer.composition.isFemale) {
                                          class38.chatboxSegments[var6++] = var48;
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = var102;
                                       continue;
                                    }

                                    if(var47 == 4106) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.chatboxSegments[var6++] = Integer.toString(var15);
                                       continue;
                                    }

                                    if(var47 == 4107) {
                                       var6 -= 2;
                                       int[] var107 = class38.field804;
                                       var39 = var5++;
                                       var83 = class38.chatboxSegments[var6];
                                       var81 = class38.chatboxSegments[1 + var6];
                                       var96 = Client.field287;
                                       var22 = var83.length();
                                       int var23 = var81.length();
                                       var24 = 0;
                                       int var25 = 0;
                                       char var26 = 0;
                                       char var27 = 0;

                                       label3548:
                                       while(true) {
                                          if(var24 - var26 >= var22 && var25 - var27 >= var23) {
                                             int var71 = Math.min(var22, var23);

                                             char var31;
                                             int var73;
                                             for(var73 = 0; var73 < var71; ++var73) {
                                                char var30 = var83.charAt(var73);
                                                var31 = var81.charAt(var73);
                                                if(var31 != var30 && Character.toUpperCase(var30) != Character.toUpperCase(var31)) {
                                                   var30 = Character.toLowerCase(var30);
                                                   var31 = Character.toLowerCase(var31);
                                                   if(var31 != var30) {
                                                      var18 = class141.method2955(var30, var96) - class141.method2955(var31, var96);
                                                      break label3548;
                                                   }
                                                }
                                             }

                                             var73 = var22 - var23;
                                             if(var73 != 0) {
                                                var18 = var73;
                                             } else {
                                                for(int var74 = 0; var74 < var71; ++var74) {
                                                   var31 = var83.charAt(var74);
                                                   char var32 = var81.charAt(var74);
                                                   if(var31 != var32) {
                                                      var18 = class141.method2955(var31, var96) - class141.method2955(var32, var96);
                                                      break label3548;
                                                   }
                                                }

                                                var18 = 0;
                                             }
                                             break;
                                          }

                                          if(var24 - var26 >= var22) {
                                             var18 = -1;
                                             break;
                                          }

                                          if(var25 - var27 >= var23) {
                                             var18 = 1;
                                             break;
                                          }

                                          char var28;
                                          if(var26 != 0) {
                                             var28 = var26;
                                             boolean var66 = false;
                                          } else {
                                             var28 = var83.charAt(var24++);
                                          }

                                          char var29;
                                          if(var27 != 0) {
                                             var29 = var27;
                                             boolean var68 = false;
                                          } else {
                                             var29 = var81.charAt(var25++);
                                          }

                                          var26 = class128.method2822(var28);
                                          var27 = class128.method2822(var29);
                                          var28 = BufferProvider.method1733(var28, var96);
                                          var29 = BufferProvider.method1733(var29, var96);
                                          if(var28 != var29 && Character.toUpperCase(var28) != Character.toUpperCase(var29)) {
                                             var28 = Character.toLowerCase(var28);
                                             var29 = Character.toLowerCase(var29);
                                             if(var29 != var28) {
                                                var18 = class141.method2955(var28, var96) - class141.method2955(var29, var96);
                                                break;
                                             }
                                          }
                                       }

                                       if(var18 > 0) {
                                          var67 = 1;
                                       } else if(var18 < 0) {
                                          var67 = -1;
                                       } else {
                                          var67 = 0;
                                       }

                                       var107[var39] = var67;
                                       continue;
                                    }

                                    class227 var88;
                                    byte[] var90;
                                    if(var47 == 4108) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var39 = class38.field804[var5];
                                       var17 = class38.field804[var5 + 1];
                                       var90 = class154.field2301.method3304(var17, 0);
                                       var88 = new class227(var90);
                                       class38.field804[var5++] = var88.method4094(var102, var39);
                                       continue;
                                    }

                                    if(var47 == 4109) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var39 = class38.field804[var5];
                                       var17 = class38.field804[1 + var5];
                                       var90 = class154.field2301.method3304(var17, 0);
                                       var88 = new class227(var90);
                                       class38.field804[var5++] = var88.method4093(var102, var39);
                                       continue;
                                    }

                                    if(var47 == 4110) {
                                       var6 -= 2;
                                       var102 = class38.chatboxSegments[var6];
                                       var48 = class38.chatboxSegments[1 + var6];
                                       --var5;
                                       if(class38.field804[var5] == 1) {
                                          class38.chatboxSegments[var6++] = var102;
                                       } else {
                                          class38.chatboxSegments[var6++] = var48;
                                       }
                                       continue;
                                    }

                                    if(var47 == 4111) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       class38.chatboxSegments[var6++] = class226.method4170(var102);
                                       continue;
                                    }

                                    if(var47 == 4112) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       --var5;
                                       var39 = class38.field804[var5];
                                       class38.chatboxSegments[var6++] = var102 + (char)var39;
                                       continue;
                                    }

                                    char var57;
                                    if(var47 == 4113) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       var56 = class38.field804;
                                       var17 = var5++;
                                       var57 = (char)var15;
                                       if(var57 >= 32 && var57 <= 126) {
                                          var52 = true;
                                       } else if(var57 >= 160 && var57 <= 255) {
                                          var52 = true;
                                       } else if(var57 != 8364 && var57 != 338 && var57 != 8212 && var57 != 339 && var57 != 376) {
                                          var52 = false;
                                       } else {
                                          var52 = true;
                                       }

                                       var56[var17] = var52?1:0;
                                       continue;
                                    }

                                    if(var47 == 4114) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       var56 = class38.field804;
                                       var17 = var5++;
                                       var57 = (char)var15;
                                       var52 = var57 >= 48 && var57 <= 57 || var57 >= 65 && var57 <= 90 || var57 >= 97 && var57 <= 122;
                                       var56[var17] = var52?1:0;
                                       continue;
                                    }

                                    if(var47 == 4115) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.field804[var5++] = class51.method1063((char)var15)?1:0;
                                       continue;
                                    }

                                    if(var47 == 4116) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.field804[var5++] = class167.method3259((char)var15)?1:0;
                                       continue;
                                    }

                                    if(var47 == 4117) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       if(var102 != null) {
                                          class38.field804[var5++] = var102.length();
                                       } else {
                                          class38.field804[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var47 == 4118) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var39 = class38.field804[var5];
                                       var17 = class38.field804[var5 + 1];
                                       class38.chatboxSegments[var6++] = var102.substring(var39, var17);
                                       continue;
                                    }

                                    if(var47 == 4119) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       StringBuilder var54 = new StringBuilder(var102.length());
                                       var61 = false;

                                       for(var18 = 0; var18 < var102.length(); ++var18) {
                                          var57 = var102.charAt(var18);
                                          if(var57 == 60) {
                                             var61 = true;
                                          } else if(var57 == 62) {
                                             var61 = false;
                                          } else if(!var61) {
                                             var54.append(var57);
                                          }
                                       }

                                       class38.chatboxSegments[var6++] = var54.toString();
                                       continue;
                                    }

                                    if(var47 == 4120) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       --var5;
                                       var39 = class38.field804[var5];
                                       class38.field804[var5++] = var102.indexOf(var39);
                                       continue;
                                    }

                                    if(var47 == 4121) {
                                       var6 -= 2;
                                       var102 = class38.chatboxSegments[var6];
                                       var48 = class38.chatboxSegments[1 + var6];
                                       --var5;
                                       var17 = class38.field804[var5];
                                       class38.field804[var5++] = var102.indexOf(var48, var17);
                                       continue;
                                    }
                                 } else if(var47 < 4300) {
                                    if(var47 == 4200) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.chatboxSegments[var6++] = class45.getItemDefinition(var15).name;
                                       continue;
                                    }

                                    ItemComposition var82;
                                    if(var47 == 4201) {
                                       var5 -= 2;
                                       var15 = class38.field804[var5];
                                       var39 = class38.field804[var5 + 1];
                                       var82 = class45.getItemDefinition(var15);
                                       if(var39 >= 1 && var39 <= 5 && var82.groundActions[var39 - 1] != null) {
                                          class38.chatboxSegments[var6++] = var82.groundActions[var39 - 1];
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var47 == 4202) {
                                       var5 -= 2;
                                       var15 = class38.field804[var5];
                                       var39 = class38.field804[1 + var5];
                                       var82 = class45.getItemDefinition(var15);
                                       if(var39 >= 1 && var39 <= 5 && null != var82.inventoryActions[var39 - 1]) {
                                          class38.chatboxSegments[var6++] = var82.inventoryActions[var39 - 1];
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var47 == 4203) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.field804[var5++] = class45.getItemDefinition(var15).price;
                                       continue;
                                    }

                                    if(var47 == 4204) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.field804[var5++] = class45.getItemDefinition(var15).isStackable == 1?1:0;
                                       continue;
                                    }

                                    ItemComposition var59;
                                    if(var47 == 4205) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       var59 = class45.getItemDefinition(var15);
                                       if(var59.field1192 == -1 && var59.note >= 0) {
                                          class38.field804[var5++] = var59.note;
                                          continue;
                                       }

                                       class38.field804[var5++] = var15;
                                       continue;
                                    }

                                    if(var47 == 4206) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       var59 = class45.getItemDefinition(var15);
                                       if(var59.field1192 >= 0 && var59.note >= 0) {
                                          class38.field804[var5++] = var59.note;
                                          continue;
                                       }

                                       class38.field804[var5++] = var15;
                                       continue;
                                    }

                                    if(var47 == 4207) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.field804[var5++] = class45.getItemDefinition(var15).isMembers?1:0;
                                       continue;
                                    }

                                    if(var47 == 4208) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       var59 = class45.getItemDefinition(var15);
                                       if(var59.field1203 == -1 && var59.field1202 >= 0) {
                                          class38.field804[var5++] = var59.field1202;
                                          continue;
                                       }

                                       class38.field804[var5++] = var15;
                                       continue;
                                    }

                                    if(var47 == 4209) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       var59 = class45.getItemDefinition(var15);
                                       if(var59.field1203 >= 0 && var59.field1202 >= 0) {
                                          class38.field804[var5++] = var59.field1202;
                                          continue;
                                       }

                                       class38.field804[var5++] = var15;
                                       continue;
                                    }

                                    if(var47 == 4210) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       --var5;
                                       var39 = class38.field804[var5];
                                       var52 = var39 == 1;
                                       var35 = var102.toLowerCase();
                                       short[] var91 = new short[16];
                                       var20 = 0;
                                       var96 = 0;

                                       while(true) {
                                          if(var96 >= class192.field3101) {
                                             class13.field195 = var91;
                                             class49.field1077 = 0;
                                             Item.field688 = var20;
                                             String[] var21 = new String[Item.field688];

                                             for(var22 = 0; var22 < Item.field688; ++var22) {
                                                var21[var22] = class45.getItemDefinition(var91[var22]).name;
                                             }

                                             short[] var99 = class13.field195;
                                             GroundObject.method2200(var21, var99, 0, var21.length - 1);
                                             break;
                                          }

                                          ItemComposition var95 = class45.getItemDefinition(var96);
                                          if((!var52 || var95.field1199) && var95.field1192 == -1 && var95.name.toLowerCase().indexOf(var35) != -1) {
                                             if(var20 >= 250) {
                                                Item.field688 = -1;
                                                class13.field195 = null;
                                                break;
                                             }

                                             if(var20 >= var91.length) {
                                                short[] var42 = new short[2 * var91.length];

                                                for(var24 = 0; var24 < var20; ++var24) {
                                                   var42[var24] = var91[var24];
                                                }

                                                var91 = var42;
                                             }

                                             var91[var20++] = (short)var96;
                                          }

                                          ++var96;
                                       }

                                       class38.field804[var5++] = Item.field688;
                                       continue;
                                    }

                                    if(var47 == 4211) {
                                       if(class13.field195 != null && class49.field1077 < Item.field688) {
                                          class38.field804[var5++] = class13.field195[++class49.field1077 - 1] & '\uffff';
                                          continue;
                                       }

                                       class38.field804[var5++] = -1;
                                       continue;
                                    }

                                    if(var47 == 4212) {
                                       class49.field1077 = 0;
                                       continue;
                                    }
                                 } else if(var47 < 5100) {
                                    if(var47 == 5000) {
                                       class38.field804[var5++] = Client.field497;
                                       continue;
                                    }

                                    if(var47 == 5001) {
                                       var5 -= 3;
                                       Client.field497 = class38.field804[var5];
                                       class130.field2100 = class23.method593(class38.field804[1 + var5]);
                                       if(null == class130.field2100) {
                                          class130.field2100 = class133.field2116;
                                       }

                                       Client.field324 = class38.field804[var5 + 2];
                                       Client.field397.method2768(157);
                                       Client.field397.method2518(Client.field497);
                                       Client.field397.method2518(class130.field2100.field2111);
                                       Client.field397.method2518(Client.field324);
                                       continue;
                                    }

                                    if(var47 == 5002) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var39 = class38.field804[var5];
                                       var17 = class38.field804[1 + var5];
                                       Client.field397.method2768(240);
                                       Client.field397.method2518(class75.method1624(var102) + 2);
                                       Client.field397.method2524(var102);
                                       Client.field397.method2518(var39 - 1);
                                       Client.field397.method2518(var17);
                                       continue;
                                    }

                                    if(var47 == 5003) {
                                       var5 -= 2;
                                       var15 = class38.field804[var5];
                                       var39 = class38.field804[var5 + 1];
                                       ChatLineBuffer var93 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var15));
                                       MessageNode var86 = var93.method657(var39);
                                       if(null != var86) {
                                          class38.field804[var5++] = var86.id;
                                          class38.field804[var5++] = var86.tick;
                                          class38.chatboxSegments[var6++] = null != var86.name?var86.name:"";
                                          class38.chatboxSegments[var6++] = null != var86.sender?var86.sender:"";
                                          class38.chatboxSegments[var6++] = var86.value != null?var86.value:"";
                                       } else {
                                          class38.field804[var5++] = -1;
                                          class38.field804[var5++] = 0;
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var47 == 5004) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       MessageNode var62 = (MessageNode)class11.field167.method3881((long)var15);
                                       if(var62 != null) {
                                          class38.field804[var5++] = var62.type;
                                          class38.field804[var5++] = var62.tick;
                                          class38.chatboxSegments[var6++] = null != var62.name?var62.name:"";
                                          class38.chatboxSegments[var6++] = null != var62.sender?var62.sender:"";
                                          class38.chatboxSegments[var6++] = null != var62.value?var62.value:"";
                                       } else {
                                          class38.field804[var5++] = -1;
                                          class38.field804[var5++] = 0;
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var47 == 5005) {
                                       if(class130.field2100 == null) {
                                          class38.field804[var5++] = -1;
                                       } else {
                                          class38.field804[var5++] = class130.field2100.field2111;
                                       }
                                       continue;
                                    }

                                    if(var47 == 5008) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       --var5;
                                       var39 = class38.field804[var5];
                                       var35 = var102.toLowerCase();
                                       byte var64 = 0;
                                       if(var35.startsWith("yellow:")) {
                                          var64 = 0;
                                          var102 = var102.substring("yellow:".length());
                                       } else if(var35.startsWith("red:")) {
                                          var64 = 1;
                                          var102 = var102.substring("red:".length());
                                       } else if(var35.startsWith("green:")) {
                                          var64 = 2;
                                          var102 = var102.substring("green:".length());
                                       } else if(var35.startsWith("cyan:")) {
                                          var64 = 3;
                                          var102 = var102.substring("cyan:".length());
                                       } else if(var35.startsWith("purple:")) {
                                          var64 = 4;
                                          var102 = var102.substring("purple:".length());
                                       } else if(var35.startsWith("white:")) {
                                          var64 = 5;
                                          var102 = var102.substring("white:".length());
                                       } else if(var35.startsWith("flash1:")) {
                                          var64 = 6;
                                          var102 = var102.substring("flash1:".length());
                                       } else if(var35.startsWith("flash2:")) {
                                          var64 = 7;
                                          var102 = var102.substring("flash2:".length());
                                       } else if(var35.startsWith("flash3:")) {
                                          var64 = 8;
                                          var102 = var102.substring("flash3:".length());
                                       } else if(var35.startsWith("glow1:")) {
                                          var64 = 9;
                                          var102 = var102.substring("glow1:".length());
                                       } else if(var35.startsWith("glow2:")) {
                                          var64 = 10;
                                          var102 = var102.substring("glow2:".length());
                                       } else if(var35.startsWith("glow3:")) {
                                          var64 = 11;
                                          var102 = var102.substring("glow3:".length());
                                       } else if(Client.field287 != 0) {
                                          if(var35.startsWith("yellow:")) {
                                             var64 = 0;
                                             var102 = var102.substring("yellow:".length());
                                          } else if(var35.startsWith("red:")) {
                                             var64 = 1;
                                             var102 = var102.substring("red:".length());
                                          } else if(var35.startsWith("green:")) {
                                             var64 = 2;
                                             var102 = var102.substring("green:".length());
                                          } else if(var35.startsWith("cyan:")) {
                                             var64 = 3;
                                             var102 = var102.substring("cyan:".length());
                                          } else if(var35.startsWith("purple:")) {
                                             var64 = 4;
                                             var102 = var102.substring("purple:".length());
                                          } else if(var35.startsWith("white:")) {
                                             var64 = 5;
                                             var102 = var102.substring("white:".length());
                                          } else if(var35.startsWith("flash1:")) {
                                             var64 = 6;
                                             var102 = var102.substring("flash1:".length());
                                          } else if(var35.startsWith("flash2:")) {
                                             var64 = 7;
                                             var102 = var102.substring("flash2:".length());
                                          } else if(var35.startsWith("flash3:")) {
                                             var64 = 8;
                                             var102 = var102.substring("flash3:".length());
                                          } else if(var35.startsWith("glow1:")) {
                                             var64 = 9;
                                             var102 = var102.substring("glow1:".length());
                                          } else if(var35.startsWith("glow2:")) {
                                             var64 = 10;
                                             var102 = var102.substring("glow2:".length());
                                          } else if(var35.startsWith("glow3:")) {
                                             var64 = 11;
                                             var102 = var102.substring("glow3:".length());
                                          }
                                       }

                                       var35 = var102.toLowerCase();
                                       byte var58 = 0;
                                       if(var35.startsWith("wave:")) {
                                          var58 = 1;
                                          var102 = var102.substring("wave:".length());
                                       } else if(var35.startsWith("wave2:")) {
                                          var58 = 2;
                                          var102 = var102.substring("wave2:".length());
                                       } else if(var35.startsWith("shake:")) {
                                          var58 = 3;
                                          var102 = var102.substring("shake:".length());
                                       } else if(var35.startsWith("scroll:")) {
                                          var58 = 4;
                                          var102 = var102.substring("scroll:".length());
                                       } else if(var35.startsWith("slide:")) {
                                          var58 = 5;
                                          var102 = var102.substring("slide:".length());
                                       } else if(Client.field287 != 0) {
                                          if(var35.startsWith("wave:")) {
                                             var58 = 1;
                                             var102 = var102.substring("wave:".length());
                                          } else if(var35.startsWith("wave2:")) {
                                             var58 = 2;
                                             var102 = var102.substring("wave2:".length());
                                          } else if(var35.startsWith("shake:")) {
                                             var58 = 3;
                                             var102 = var102.substring("shake:".length());
                                          } else if(var35.startsWith("scroll:")) {
                                             var58 = 4;
                                             var102 = var102.substring("scroll:".length());
                                          } else if(var35.startsWith("slide:")) {
                                             var58 = 5;
                                             var102 = var102.substring("slide:".length());
                                          }
                                       }

                                       Client.field397.method2768(254);
                                       Client.field397.method2518(0);
                                       var20 = Client.field397.offset;
                                       Client.field397.method2518(var39);
                                       Client.field397.method2518(var64);
                                       Client.field397.method2518(var58);
                                       class155.method3179(Client.field397, var102);
                                       Client.field397.method2530(Client.field397.offset - var20);
                                       continue;
                                    }

                                    if(var47 == 5009) {
                                       var6 -= 2;
                                       var102 = class38.chatboxSegments[var6];
                                       var48 = class38.chatboxSegments[var6 + 1];
                                       Client.field397.method2768(150);
                                       Client.field397.method2519(0);
                                       var17 = Client.field397.offset;
                                       Client.field397.method2524(var102);
                                       class155.method3179(Client.field397, var48);
                                       Client.field397.method2529(Client.field397.offset - var17);
                                       continue;
                                    }

                                    if(var47 == 5015) {
                                       if(null != class34.localPlayer && class34.localPlayer.name != null) {
                                          var102 = class34.localPlayer.name;
                                       } else {
                                          var102 = "";
                                       }

                                       class38.chatboxSegments[var6++] = var102;
                                       continue;
                                    }

                                    if(var47 == 5016) {
                                       class38.field804[var5++] = Client.field324;
                                       continue;
                                    }

                                    if(var47 == 5017) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.field804[var5++] = World.method622(var15);
                                       continue;
                                    }

                                    if(var47 == 5018) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.field804[var5++] = CollisionData.method2430(var15);
                                       continue;
                                    }

                                    if(var47 == 5019) {
                                       --var5;
                                       var15 = class38.field804[var5];
                                       class38.field804[var5++] = Renderable.method1963(var15);
                                       continue;
                                    }

                                    if(var47 == 5020) {
                                       --var6;
                                       var102 = class38.chatboxSegments[var6];
                                       if(var102.equalsIgnoreCase("toggleroof")) {
                                          class16.field232.field149 = !class16.field232.field149;
                                          class18.method193();
                                          if(class16.field232.field149) {
                                             class190.sendGameMessage(99, "", "Roofs are now all hidden");
                                          } else {
                                             class190.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                          }
                                       }

                                       if(var102.equalsIgnoreCase("displayfps")) {
                                          Client.field296 = !Client.field296;
                                       }

                                       if(Client.field446 >= 2) {
                                          if(var102.equalsIgnoreCase("fpson")) {
                                             Client.field296 = true;
                                          }

                                          if(var102.equalsIgnoreCase("fpsoff")) {
                                             Client.field296 = false;
                                          }

                                          if(var102.equalsIgnoreCase("gc")) {
                                             System.gc();
                                          }

                                          if(var102.equalsIgnoreCase("clientdrop")) {
                                             class56.method1159();
                                          }

                                          if(var102.equalsIgnoreCase("errortest") && Client.field343 == 2) {
                                             throw new RuntimeException();
                                          }
                                       }

                                       Client.field397.method2768(227);
                                       Client.field397.method2518(var102.length() + 1);
                                       Client.field397.method2524(var102);
                                       continue;
                                    }

                                    if(var47 == 5021) {
                                       --var6;
                                       Client.field499 = class38.chatboxSegments[var6].toLowerCase().trim();
                                       continue;
                                    }

                                    if(var47 == 5022) {
                                       class38.chatboxSegments[var6++] = Client.field499;
                                       continue;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  } else {
                     var39 = -1;
                     if(var47 >= 2000) {
                        var47 -= 1000;
                        --var5;
                        var39 = class38.field804[var5];
                        var34 = class153.method3170(var39);
                     } else {
                        var34 = var51?BufferProvider.field1448:class165.field2683;
                     }

                     if(var47 == 1100) {
                        var5 -= 2;
                        var34.itemId = class38.field804[var5];
                        if(var34.itemId > var34.scrollWidth - var34.width) {
                           var34.itemId = var34.scrollWidth - var34.width;
                        }

                        if(var34.itemId < 0) {
                           var34.itemId = 0;
                        }

                        var34.scrollY = class38.field804[var5 + 1];
                        if(var34.scrollY > var34.scrollHeight - var34.height) {
                           var34.scrollY = var34.scrollHeight - var34.height;
                        }

                        if(var34.scrollY < 0) {
                           var34.scrollY = 0;
                        }

                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1101) {
                        --var5;
                        var34.textColor = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1102) {
                        --var5;
                        var34.field2831 = class38.field804[var5] == 1;
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1103) {
                        --var5;
                        var34.opacity = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1104) {
                        --var5;
                        var34.field2821 = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1105) {
                        --var5;
                        var34.textureId = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1106) {
                        --var5;
                        var34.field2778 = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1107) {
                        --var5;
                        var34.field2900 = class38.field804[var5] == 1;
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1108) {
                        var34.modelType = 1;
                        --var5;
                        var34.modelId = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1109) {
                        var5 -= 6;
                        var34.field2837 = class38.field804[var5];
                        var34.field2860 = class38.field804[1 + var5];
                        var34.rotationX = class38.field804[2 + var5];
                        var34.rotationZ = class38.field804[var5 + 3];
                        var34.rotationY = class38.field804[4 + var5];
                        var34.field2842 = class38.field804[5 + var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1110) {
                        --var5;
                        var17 = class38.field804[var5];
                        if(var34.field2835 != var17) {
                           var34.field2835 = var17;
                           var34.field2910 = 0;
                           var34.field2911 = 0;
                           MessageNode.method750(var34);
                        }
                        continue;
                     }

                     if(var47 == 1111) {
                        --var5;
                        var34.field2845 = class38.field804[var5] == 1;
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1112) {
                        --var6;
                        var35 = class38.chatboxSegments[var6];
                        if(!var35.equals(var34.text)) {
                           var34.text = var35;
                           MessageNode.method750(var34);
                        }
                        continue;
                     }

                     if(var47 == 1113) {
                        --var5;
                        var34.field2902 = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1114) {
                        var5 -= 3;
                        var34.field2851 = class38.field804[var5];
                        var34.field2829 = class38.field804[var5 + 1];
                        var34.field2898 = class38.field804[2 + var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1115) {
                        --var5;
                        var34.field2863 = class38.field804[var5] == 1;
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1116) {
                        --var5;
                        var34.borderThickness = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1117) {
                        --var5;
                        var34.sprite2 = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1118) {
                        --var5;
                        var34.flippedVertically = class38.field804[var5] == 1;
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1119) {
                        --var5;
                        var34.flippedHorizontally = class38.field804[var5] == 1;
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1120) {
                        var5 -= 2;
                        var34.scrollWidth = class38.field804[var5];
                        var34.scrollHeight = class38.field804[1 + var5];
                        MessageNode.method750(var34);
                        if(var39 != -1 && var34.type == 0) {
                           class174.method3428(Widget.widgets[var39 >> 16], var34, false);
                        }
                        continue;
                     }

                     if(var47 == 1121) {
                        class75.method1623(var34.id, var34.index);
                        Client.field443 = var34;
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1122) {
                        --var5;
                        var34.field2824 = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1123) {
                        --var5;
                        var34.field2814 = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1124) {
                        --var5;
                        var34.field2782 = class38.field804[var5];
                        MessageNode.method750(var34);
                        continue;
                     }

                     if(var47 == 1125) {
                        --var5;
                        var17 = class38.field804[var5];
                        class85 var38 = (class85)class168.method3262(NPC.method742(), var17);
                        if(null != var38) {
                           var34.field2818 = var38;
                           MessageNode.method750(var34);
                        }
                        continue;
                     }
                  }
               }

               if(var47 < 5400) {
                  if(var47 == 5306) {
                     class38.field804[var5++] = class158.method3187();
                     continue;
                  }

                  if(var47 == 5307) {
                     --var5;
                     var15 = class38.field804[var5];
                     if(var15 != 1 && var15 != 2) {
                        continue;
                     }

                     Client.field454 = 0L;
                     if(var15 >= 2) {
                        Client.isResized = true;
                     } else {
                        Client.isResized = false;
                     }

                     class49.method1009();
                     if(Client.gameState >= 25) {
                        class14.method158();
                     }

                     GameEngine.field2250 = true;
                     continue;
                  }

                  if(var47 == 5308) {
                     class38.field804[var5++] = class16.field232.field136;
                     continue;
                  }

                  if(var47 == 5309) {
                     --var5;
                     var15 = class38.field804[var5];
                     if(var15 == 1 || var15 == 2) {
                        class16.field232.field136 = var15;
                        class18.method193();
                     }
                     continue;
                  }
               }

               if(var47 < 5600) {
                  if(var47 == 5504) {
                     var5 -= 2;
                     var15 = class38.field804[var5];
                     var39 = class38.field804[var5 + 1];
                     if(!Client.field562) {
                        Client.field365 = var15;
                        Client.mapAngle = var39;
                     }
                     continue;
                  }

                  if(var47 == 5505) {
                     class38.field804[var5++] = Client.field365;
                     continue;
                  }

                  if(var47 == 5506) {
                     class38.field804[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var47 == 5530) {
                     --var5;
                     var15 = class38.field804[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     Client.field371 = var15;
                     continue;
                  }

                  if(var47 == 5531) {
                     class38.field804[var5++] = Client.field371;
                     continue;
                  }
               }

               if(var47 < 5700 && var47 == 5630) {
                  Client.field335 = 250;
               } else {
                  if(var47 < 6300) {
                     if(var47 == 6200) {
                        var5 -= 2;
                        Client.field410 = (short)class38.field804[var5];
                        if(Client.field410 <= 0) {
                           Client.field410 = 256;
                        }

                        Client.field542 = (short)class38.field804[var5 + 1];
                        if(Client.field542 <= 0) {
                           Client.field542 = 205;
                        }
                        continue;
                     }

                     if(var47 == 6201) {
                        var5 -= 2;
                        Client.field513 = (short)class38.field804[var5];
                        if(Client.field513 <= 0) {
                           Client.field513 = 256;
                        }

                        Client.field536 = (short)class38.field804[1 + var5];
                        if(Client.field536 <= 0) {
                           Client.field536 = 320;
                        }
                        continue;
                     }

                     if(var47 == 6202) {
                        var5 -= 4;
                        Client.field537 = (short)class38.field804[var5];
                        if(Client.field537 <= 0) {
                           Client.field537 = 1;
                        }

                        Client.field538 = (short)class38.field804[var5 + 1];
                        if(Client.field538 <= 0) {
                           Client.field538 = 32767;
                        } else if(Client.field538 < Client.field537) {
                           Client.field538 = Client.field537;
                        }

                        Client.field539 = (short)class38.field804[2 + var5];
                        if(Client.field539 <= 0) {
                           Client.field539 = 1;
                        }

                        Client.field540 = (short)class38.field804[3 + var5];
                        if(Client.field540 <= 0) {
                           Client.field540 = 32767;
                        } else if(Client.field540 < Client.field539) {
                           Client.field540 = Client.field539;
                        }
                        continue;
                     }

                     if(var47 == 6203) {
                        if(Client.field451 != null) {
                           class32.method685(0, 0, Client.field451.width, Client.field451.height, false);
                           class38.field804[var5++] = Client.camera2;
                           class38.field804[var5++] = Client.camera3;
                        } else {
                           class38.field804[var5++] = -1;
                           class38.field804[var5++] = -1;
                        }
                        continue;
                     }

                     if(var47 == 6204) {
                        class38.field804[var5++] = Client.field513;
                        class38.field804[var5++] = Client.field536;
                        continue;
                     }

                     if(var47 == 6205) {
                        class38.field804[var5++] = Client.field410;
                        class38.field804[var5++] = Client.field542;
                        continue;
                     }
                  }

                  if(var47 < 6600) {
                     if(var47 == 6500) {
                        class38.field804[var5++] = class34.loadWorlds()?1:0;
                        continue;
                     }

                     World var108;
                     if(var47 == 6501) {
                        World.field659 = 0;
                        var108 = Actor.method775();
                        if(var108 != null) {
                           class38.field804[var5++] = var108.id;
                           class38.field804[var5++] = var108.mask;
                           class38.chatboxSegments[var6++] = var108.activity;
                           class38.field804[var5++] = var108.location;
                           class38.field804[var5++] = var108.playerCount;
                           class38.chatboxSegments[var6++] = var108.address;
                        } else {
                           class38.field804[var5++] = -1;
                           class38.field804[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field804[var5++] = 0;
                           class38.field804[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var47 == 6502) {
                        var108 = Actor.method775();
                        if(var108 != null) {
                           class38.field804[var5++] = var108.id;
                           class38.field804[var5++] = var108.mask;
                           class38.chatboxSegments[var6++] = var108.activity;
                           class38.field804[var5++] = var108.location;
                           class38.field804[var5++] = var108.playerCount;
                           class38.chatboxSegments[var6++] = var108.address;
                        } else {
                           class38.field804[var5++] = -1;
                           class38.field804[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field804[var5++] = 0;
                           class38.field804[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     World var70;
                     if(var47 == 6506) {
                        --var5;
                        var15 = class38.field804[var5];
                        var70 = null;

                        for(var17 = 0; var17 < World.field651; ++var17) {
                           if(World.worldList[var17].id == var15) {
                              var70 = World.worldList[var17];
                              break;
                           }
                        }

                        if(var70 != null) {
                           class38.field804[var5++] = var70.id;
                           class38.field804[var5++] = var70.mask;
                           class38.chatboxSegments[var6++] = var70.activity;
                           class38.field804[var5++] = var70.location;
                           class38.field804[var5++] = var70.playerCount;
                           class38.chatboxSegments[var6++] = var70.address;
                        } else {
                           class38.field804[var5++] = -1;
                           class38.field804[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field804[var5++] = 0;
                           class38.field804[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var47 == 6507) {
                        var5 -= 4;
                        var15 = class38.field804[var5];
                        var94 = class38.field804[1 + var5] == 1;
                        var17 = class38.field804[var5 + 2];
                        var52 = class38.field804[3 + var5] == 1;
                        if(null != World.worldList) {
                           class140.method2953(0, World.worldList.length - 1, var15, var94, var17, var52);
                        }
                        continue;
                     }

                     if(var47 == 6511) {
                        --var5;
                        var15 = class38.field804[var5];
                        if(var15 >= 0 && var15 < World.field651) {
                           var70 = World.worldList[var15];
                           class38.field804[var5++] = var70.id;
                           class38.field804[var5++] = var70.mask;
                           class38.chatboxSegments[var6++] = var70.activity;
                           class38.field804[var5++] = var70.location;
                           class38.field804[var5++] = var70.playerCount;
                           class38.chatboxSegments[var6++] = var70.address;
                           continue;
                        }

                        class38.field804[var5++] = -1;
                        class38.field804[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field804[var5++] = 0;
                        class38.field804[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var46) {
            StringBuilder var44 = new StringBuilder(30);
            var44.append("").append(var4.hash).append(" ");

            for(var13 = class38.field806 - 1; var13 >= 0; --var13) {
               var44.append("").append(class38.field807[var13].field216.hash).append(" ");
            }

            var44.append("").append(var10);
            Frames.method2316(var44.toString(), var46);
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-25"
   )
   static void method614() {
      Client.field291 = -1L;
      Client.field283 = -1;
      class222.field3213.field191 = 0;
      World.field665 = true;
      Client.field409 = true;
      Client.field505 = -1L;
      WidgetNode.method48();
      Client.field397.offset = 0;
      Client.field327.offset = 0;
      Client.packetOpcode = -1;
      Client.field326 = -1;
      Client.field333 = -1;
      Client.field289 = -1;
      Client.field330 = 0;
      Client.field457 = 0;
      Client.field335 = 0;
      Client.field298 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class136.method2885(0);
      class11.chatLineMap.clear();
      class11.field167.method3871();
      class11.field174.method3921();
      class11.field169 = 0;
      Client.field432 = 0;
      Client.field434 = false;
      Client.field363 = 0;
      Client.field346 = (int)(Math.random() * 100.0D) - 50;
      Client.field348 = (int)(Math.random() * 110.0D) - 55;
      Client.field350 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field369 = 0;
      Client.field430 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field510 = class21.field578;
      Client.field320 = class21.field578;
      Client.field321 = 0;
      class12.method147();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field471 = -1;
      Client.projectiles.method3885();
      Client.field415.method3885();

      int var2;
      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.field413 = new Deque();
      Client.field494 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class56.field1211; ++var0) {
         class56 var3 = FaceNormal.method1951(var0);
         if(var3 != null) {
            class179.settings[var0] = 0;
            class179.widgetSettings[var0] = 0;
         }
      }

      class126.chatMessages.method199();
      Client.field447 = -1;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(var0 != -1 && Widget.validInterfaces[var0]) {
            Widget.field2780.method3296(var0);
            if(null != Widget.widgets[var0]) {
               boolean var5 = true;

               for(var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var5 = false;
                     }
                  }
               }

               if(var5) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.method3852(); var4 != null; var4 = (WidgetNode)Client.componentTable.method3857()) {
         Player.method33(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field443 = null;
      Client.isMenuOpen = false;
      Client.menuOptionCount = 0;
      Client.field305.method3571((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.field408[var0] = null;
         Client.field368[var0] = false;
      }

      class151.method3149();
      Client.field527 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field526[var0] = true;
      }

      class14.method158();
      Client.field506 = null;
      XItemContainer.field224 = 0;
      TextureProvider.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      class13.field193 = null;
   }
}
