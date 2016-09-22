import java.awt.Component;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class1 {
   @ObfuscatedName("bn")
   static class171 field18;
   @ObfuscatedName("c")
   static int[] field20;
   @ObfuscatedName("e")
   static int[] field25;
   @ObfuscatedName("bf")
   static ModIcon[] field27;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      longValue = -7577605839536178343L
   )
   static long field28;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZLclass227;I)V",
      garbageValue = "-1474590967"
   )
   public static void method4(class170 var0, class170 var1, boolean var2, class227 var3) {
      ItemComposition.field1179 = var0;
      class54.field1173 = var1;
      ItemComposition.isMembersWorld = var2;
      class10.field158 = ItemComposition.field1179.method3319(10);
      class10.field161 = var3;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1995298828"
   )
   static final void method5() {
      boolean var0 = false;

      int var1;
      int var4;
      while(!var0) {
         var0 = true;

         for(var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var13 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[1 + var1];
               Client.menuTargets[var1 + 1] = var13;
               String var15 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[1 + var1];
               Client.menuOptions[1 + var1] = var15;
               var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[1 + var1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[1 + var1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               var0 = false;
            }
         }
      }

      if(null == class26.field650) {
         if(Client.field453 == null) {
            int var2;
            int var3;
            label319: {
               int var18 = class143.field2227;
               int var6;
               int var19;
               if(Client.isMenuOpen) {
                  if(var18 != 1 && (class24.field626 || var18 != 4)) {
                     var1 = class143.field2225;
                     var2 = class143.field2222;
                     if(var1 < VertexNormal.menuX - 10 || var1 > class85.menuWidth + VertexNormal.menuX + 10 || var2 < class14.menuY - 10 || var2 > class14.menuY + Renderable.menuHeight + 10) {
                        Client.isMenuOpen = false;
                        class113.method2446(VertexNormal.menuX, class14.menuY, class85.menuWidth, Renderable.menuHeight);
                     }
                  }

                  if(var18 == 1 || !class24.field626 && var18 == 4) {
                     var1 = VertexNormal.menuX;
                     var2 = class14.menuY;
                     var3 = class85.menuWidth;
                     var4 = class143.field2223;
                     var19 = class143.field2226;
                     var6 = -1;

                     int var7;
                     int var8;
                     for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
                        var8 = 31 + var2 + 15 * (Client.menuOptionCount - 1 - var7);
                        if(var4 > var1 && var4 < var1 + var3 && var19 > var8 - 13 && var19 < 3 + var8) {
                           var6 = var7;
                        }
                     }

                     if(var6 != -1 && var6 >= 0) {
                        var7 = Client.menuActionParams0[var6];
                        var8 = Client.menuActionParams1[var6];
                        int var9 = Client.menuTypes[var6];
                        int var10 = Client.menuIdentifiers[var6];
                        String var11 = Client.menuOptions[var6];
                        String var12 = Client.menuTargets[var6];
                        class77.menuAction(var7, var8, var9, var10, var11, var12, class143.field2223, class143.field2226);
                     }

                     Client.isMenuOpen = false;
                     class113.method2446(VertexNormal.menuX, class14.menuY, class85.menuWidth, Renderable.menuHeight);
                  }
               } else {
                  if((var18 == 1 || !class24.field626 && var18 == 4) && Client.menuOptionCount > 0) {
                     var1 = Client.menuTypes[Client.menuOptionCount - 1];
                     if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                        var2 = Client.menuActionParams0[Client.menuOptionCount - 1];
                        var3 = Client.menuActionParams1[Client.menuOptionCount - 1];
                        Widget var14 = class24.method600(var3);
                        var6 = GameEngine.method3133(var14);
                        boolean var5 = (var6 >> 28 & 1) != 0;
                        if(var5) {
                           break label319;
                        }

                        Object var10000 = null;
                        if(class193.method3775(GameEngine.method3133(var14))) {
                           break label319;
                        }
                     }
                  }

                  if((var18 == 1 || !class24.field626 && var18 == 4) && (Client.field341 == 1 && Client.menuOptionCount > 2 || class0.method2(Client.menuOptionCount - 1))) {
                     var18 = 2;
                  }

                  if((var18 == 1 || !class24.field626 && var18 == 4) && Client.menuOptionCount > 0) {
                     var1 = Client.menuOptionCount - 1;
                     if(var1 >= 0) {
                        var2 = Client.menuActionParams0[var1];
                        var3 = Client.menuActionParams1[var1];
                        var4 = Client.menuTypes[var1];
                        var19 = Client.menuIdentifiers[var1];
                        String var16 = Client.menuOptions[var1];
                        String var17 = Client.menuTargets[var1];
                        class77.menuAction(var2, var3, var4, var19, var16, var17, class143.field2223, class143.field2226);
                     }
                  }

                  if(var18 == 2 && Client.menuOptionCount > 0) {
                     class50.method1044(class143.field2223, class143.field2226);
                  }
               }

               return;
            }

            if(null != class26.field650 && !Client.field440 && Client.field341 != 1 && !class0.method2(Client.menuOptionCount - 1) && Client.menuOptionCount > 0) {
               class92.method2112(Client.field450, Client.field398);
            }

            Client.field440 = false;
            Client.field515 = 0;
            if(null != class26.field650) {
               class53.method1101(class26.field650);
            }

            class26.field650 = class24.method600(var3);
            Client.field396 = var2;
            Client.field450 = class143.field2223;
            Client.field398 = class143.field2226;
            if(Client.menuOptionCount > 0) {
               class85.method1925(Client.menuOptionCount - 1);
            }

            class53.method1101(class26.field650);
         }
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1145727376"
   )
   static void method6(int var0, int var1) {
      Client.field323.method2801(109);
      Client.field323.method2711(var1);
      Client.field323.method2541(var0);
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Ljava/lang/String;",
      garbageValue = "-519950699"
   )
   static String method7(Widget var0) {
      return ChatMessages.method240(GameEngine.method3133(var0)) == 0?null:(var0.field2895 != null && var0.field2895.trim().length() != 0?var0.field2895:null);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "307296587"
   )
   static void method9(class0 var0, int var1) {
      Object[] var2 = var0.field7;
      int var3 = ((Integer)var2[0]).intValue();
      class23 var4 = class0.method1(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field603;
         int[] var9 = var4.field600;
         byte var10 = -1;
         class38.field824 = 0;

         int var13;
         try {
            NPC.field808 = new int[var4.field602];
            int var11 = 0;
            class38.field826 = new String[var4.field605];
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
                     var14 = var0.field4;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field2 != null?var0.field2.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field10;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field2?var0.field2.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field5?var0.field5.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field5 != null?var0.field5.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field6;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field8;
                  }

                  NPC.field808[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var33 = (String)var2[var13];
                  if(var33.equals("event_opbase")) {
                     var33 = var0.field0;
                  }

                  class38.field826[var12++] = var33;
               }
            }

            var13 = 0;
            class38.field835 = var0.field11;

            label3898:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var46 = var8[var7];
               int var15;
               int var18;
               int var19;
               int var20;
               String var35;
               int var39;
               int var47;
               String var53;
               int[] var58;
               byte var65;
               String var92;
               String var109;
               if(var46 < 100) {
                  if(var46 == 0) {
                     class38.field833[var5++] = var9[var7];
                     continue;
                  }

                  if(var46 == 1) {
                     var14 = var9[var7];
                     class38.field833[var5++] = class179.widgetSettings[var14];
                     continue;
                  }

                  if(var46 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class179.widgetSettings[var14] = class38.field833[var5];
                     class35.method748(var14);
                     continue;
                  }

                  if(var46 == 3) {
                     class38.chatboxSegments[var6++] = var4.field601[var7];
                     continue;
                  }

                  if(var46 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var46 == 7) {
                     var5 -= 2;
                     if(class38.field833[var5] != class38.field833[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var46 == 8) {
                     var5 -= 2;
                     if(class38.field833[1 + var5] == class38.field833[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var46 == 9) {
                     var5 -= 2;
                     if(class38.field833[var5] < class38.field833[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var46 == 10) {
                     var5 -= 2;
                     if(class38.field833[var5] > class38.field833[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var46 == 21) {
                     if(class38.field824 == 0) {
                        return;
                     }

                     class14 var79 = class38.field838[--class38.field824];
                     var4 = var79.field210;
                     var8 = var4.field603;
                     var9 = var4.field600;
                     var7 = var79.field204;
                     NPC.field808 = var79.field203;
                     class38.field826 = var79.field206;
                     continue;
                  }

                  if(var46 == 25) {
                     var14 = var9[var7];
                     class38.field833[var5++] = class153.method3184(var14);
                     continue;
                  }

                  if(var46 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class38.field833[var5];
                     class50 var74 = XClanMember.method604(var14);
                     var47 = var74.field1111;
                     var18 = var74.field1110;
                     var19 = var74.field1113;
                     var20 = class179.field2967[var19 - var18];
                     if(var15 < 0 || var15 > var20) {
                        var15 = 0;
                     }

                     var20 <<= var18;
                     class179.widgetSettings[var47] = class179.widgetSettings[var47] & ~var20 | var15 << var18 & var20;
                     continue;
                  }

                  if(var46 == 31) {
                     var5 -= 2;
                     if(class38.field833[var5] <= class38.field833[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var46 == 32) {
                     var5 -= 2;
                     if(class38.field833[var5] >= class38.field833[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var46 == 33) {
                     class38.field833[var5++] = NPC.field808[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var46 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     NPC.field808[var10001] = class38.field833[var5];
                     continue;
                  }

                  if(var46 == 35) {
                     class38.chatboxSegments[var6++] = class38.field826[var9[var7]];
                     continue;
                  }

                  if(var46 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class38.field826[var10001] = class38.chatboxSegments[var6];
                     continue;
                  }

                  if(var46 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var73 = class38.chatboxSegments;
                     if(var14 == 0) {
                        var109 = "";
                     } else if(var14 == 1) {
                        var35 = var73[var6];
                        if(null == var35) {
                           var109 = "null";
                        } else {
                           var109 = var35.toString();
                        }
                     } else {
                        var47 = var14 + var6;
                        var18 = 0;

                        for(var19 = var6; var19 < var47; ++var19) {
                           var92 = var73[var19];
                           if(null == var92) {
                              var18 += 4;
                           } else {
                              var18 += var92.length();
                           }
                        }

                        StringBuilder var108 = new StringBuilder(var18);

                        for(var20 = var6; var20 < var47; ++var20) {
                           var53 = var73[var20];
                           if(null == var53) {
                              var108.append("null");
                           } else {
                              var108.append(var53);
                           }
                        }

                        var109 = var108.toString();
                     }

                     class38.chatboxSegments[var6++] = var109;
                     continue;
                  }

                  if(var46 == 38) {
                     --var5;
                     continue;
                  }

                  if(var46 == 39) {
                     --var6;
                     continue;
                  }

                  if(var46 == 40) {
                     var14 = var9[var7];
                     class23 var114 = class0.method1(var14);
                     var58 = new int[var114.field602];
                     String[] var106 = new String[var114.field605];

                     for(var18 = 0; var18 < var114.field604; ++var18) {
                        var58[var18] = class38.field833[var18 + (var5 - var114.field604)];
                     }

                     for(var18 = 0; var18 < var114.field598; ++var18) {
                        var106[var18] = class38.chatboxSegments[var6 - var114.field598 + var18];
                     }

                     var5 -= var114.field604;
                     var6 -= var114.field598;
                     class14 var110 = new class14();
                     var110.field210 = var4;
                     var110.field204 = var7;
                     var110.field203 = NPC.field808;
                     var110.field206 = class38.field826;
                     class38.field838[++class38.field824 - 1] = var110;
                     var4 = var114;
                     var8 = var114.field603;
                     var9 = var114.field600;
                     var7 = -1;
                     NPC.field808 = var58;
                     class38.field826 = var106;
                     continue;
                  }

                  if(var46 == 42) {
                     class38.field833[var5++] = Friend.chatMessages.method202(var9[var7]);
                     continue;
                  }

                  if(var46 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     Friend.chatMessages.method216(var10001, class38.field833[var5]);
                     continue;
                  }

                  if(var46 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var39 = class38.field833[var5];
                     if(var39 >= 0 && var39 <= 5000) {
                        class38.field827[var14] = var39;
                        var65 = -1;
                        if(var15 == 105) {
                           var65 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var39) {
                              continue label3898;
                           }

                           class38.field828[var14][var18] = var65;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var46 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class38.field833[var5];
                     if(var15 >= 0 && var15 < class38.field827[var14]) {
                        class38.field833[var5++] = class38.field828[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var46 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class38.field833[var5];
                     if(var15 >= 0 && var15 < class38.field827[var14]) {
                        class38.field828[var14][var15] = class38.field833[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var46 == 47) {
                     var33 = Friend.chatMessages.method204(var9[var7]);
                     if(var33 == null) {
                        var33 = "null";
                     }

                     class38.chatboxSegments[var6++] = var33;
                     continue;
                  }

                  if(var46 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     Friend.chatMessages.method203(var10001, class38.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var52;
               if(var9[var7] == 1) {
                  var52 = true;
               } else {
                  var52 = false;
               }

               Widget var16;
               Widget var34;
               boolean var56;
               Widget var80;
               Widget var87;
               boolean var100;
               if(var46 < 1000) {
                  if(var46 == 100) {
                     var5 -= 3;
                     var15 = class38.field833[var5];
                     var39 = class38.field833[1 + var5];
                     var47 = class38.field833[2 + var5];
                     if(var39 == 0) {
                        throw new RuntimeException();
                     }

                     var87 = class24.method600(var15);
                     if(var87.children == null) {
                        var87.children = new Widget[1 + var47];
                     }

                     if(var87.children.length <= var47) {
                        Widget[] var105 = new Widget[1 + var47];

                        for(var20 = 0; var20 < var87.children.length; ++var20) {
                           var105[var20] = var87.children[var20];
                        }

                        var87.children = var105;
                     }

                     if(var47 > 0 && null == var87.children[var47 - 1]) {
                        throw new RuntimeException("" + (var47 - 1));
                     }

                     Widget var107 = new Widget();
                     var107.type = var39;
                     var107.parentId = var107.id = var87.id;
                     var107.index = var47;
                     var107.field2815 = true;
                     var87.children[var47] = var107;
                     if(var52) {
                        FileOnDisk.field3263 = var107;
                     } else {
                        class38.field829 = var107;
                     }

                     class53.method1101(var87);
                     continue;
                  }

                  if(var46 == 101) {
                     var34 = var52?FileOnDisk.field3263:class38.field829;
                     var16 = class24.method600(var34.id);
                     var16.children[var34.index] = null;
                     class53.method1101(var16);
                     continue;
                  }

                  if(var46 == 102) {
                     --var5;
                     var34 = class24.method600(class38.field833[var5]);
                     var34.children = null;
                     class53.method1101(var34);
                     continue;
                  }

                  if(var46 == 200) {
                     var5 -= 2;
                     var15 = class38.field833[var5];
                     var39 = class38.field833[1 + var5];
                     var80 = class38.method781(var15, var39);
                     if(null != var80 && var39 != -1) {
                        class38.field833[var5++] = 1;
                        if(var52) {
                           FileOnDisk.field3263 = var80;
                        } else {
                           class38.field829 = var80;
                        }
                        continue;
                     }

                     class38.field833[var5++] = 0;
                     continue;
                  }

                  if(var46 == 201) {
                     --var5;
                     var34 = class24.method600(class38.field833[var5]);
                     if(var34 != null) {
                        class38.field833[var5++] = 1;
                        if(var52) {
                           FileOnDisk.field3263 = var34;
                        } else {
                           class38.field829 = var34;
                        }
                     } else {
                        class38.field833[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var17;
                  if((var46 < 1000 || var46 >= 1100) && (var46 < 2000 || var46 >= 2100)) {
                     if((var46 < 1100 || var46 >= 1200) && (var46 < 2100 || var46 >= 2200)) {
                        if((var46 < 1200 || var46 >= 1300) && (var46 < 2200 || var46 >= 2300)) {
                           if((var46 < 1300 || var46 >= 1400) && (var46 < 2300 || var46 >= 2400)) {
                              String var50;
                              int[] var81;
                              if(var46 >= 1400 && var46 < 1500 || var46 >= 2400 && var46 < 2500) {
                                 if(var46 >= 2000) {
                                    var46 -= 1000;
                                    --var5;
                                    var34 = class24.method600(class38.field833[var5]);
                                 } else {
                                    var34 = var52?FileOnDisk.field3263:class38.field829;
                                 }

                                 --var6;
                                 var50 = class38.chatboxSegments[var6];
                                 var81 = null;
                                 if(var50.length() > 0 && var50.charAt(var50.length() - 1) == 89) {
                                    --var5;
                                    var18 = class38.field833[var5];
                                    if(var18 > 0) {
                                       for(var81 = new int[var18]; var18-- > 0; var81[var18] = class38.field833[var5]) {
                                          --var5;
                                       }
                                    }

                                    var50 = var50.substring(0, var50.length() - 1);
                                 }

                                 Object[] var103 = new Object[var50.length() + 1];

                                 for(var19 = var103.length - 1; var19 >= 1; --var19) {
                                    if(var50.charAt(var19 - 1) == 115) {
                                       --var6;
                                       var103[var19] = class38.chatboxSegments[var6];
                                    } else {
                                       --var5;
                                       var103[var19] = new Integer(class38.field833[var5]);
                                    }
                                 }

                                 --var5;
                                 var19 = class38.field833[var5];
                                 if(var19 != -1) {
                                    var103[0] = new Integer(var19);
                                 } else {
                                    var103 = null;
                                 }

                                 if(var46 == 1400) {
                                    var34.field2898 = var103;
                                 }

                                 if(var46 == 1401) {
                                    var34.field2901 = var103;
                                 }

                                 if(var46 == 1402) {
                                    var34.field2900 = var103;
                                 }

                                 if(var46 == 1403) {
                                    var34.field2869 = var103;
                                 }

                                 if(var46 == 1404) {
                                    var34.field2904 = var103;
                                 }

                                 if(var46 == 1405) {
                                    var34.field2905 = var103;
                                 }

                                 if(var46 == 1406) {
                                    var34.field2892 = var103;
                                 }

                                 if(var46 == 1407) {
                                    var34.field2909 = var103;
                                    var34.field2868 = var81;
                                 }

                                 if(var46 == 1408) {
                                    var34.field2950 = var103;
                                 }

                                 if(var46 == 1409) {
                                    var34.field2887 = var103;
                                 }

                                 if(var46 == 1410) {
                                    var34.field2906 = var103;
                                 }

                                 if(var46 == 1411) {
                                    var34.field2899 = var103;
                                 }

                                 if(var46 == 1412) {
                                    var34.field2903 = var103;
                                 }

                                 if(var46 == 1414) {
                                    var34.field2911 = var103;
                                    var34.field2912 = var81;
                                 }

                                 if(var46 == 1415) {
                                    var34.field2836 = var103;
                                    var34.field2915 = var81;
                                 }

                                 if(var46 == 1416) {
                                    var34.field2819 = var103;
                                 }

                                 if(var46 == 1417) {
                                    var34.field2820 = var103;
                                 }

                                 if(var46 == 1418) {
                                    var34.field2918 = var103;
                                 }

                                 if(var46 == 1419) {
                                    var34.field2919 = var103;
                                 }

                                 if(var46 == 1420) {
                                    var34.field2920 = var103;
                                 }

                                 if(var46 == 1421) {
                                    var34.field2921 = var103;
                                 }

                                 if(var46 == 1422) {
                                    var34.field2927 = var103;
                                 }

                                 if(var46 == 1423) {
                                    var34.field2923 = var103;
                                 }

                                 if(var46 == 1424) {
                                    var34.field2842 = var103;
                                 }

                                 if(var46 == 1425) {
                                    var34.field2926 = var103;
                                 }

                                 if(var46 == 1426) {
                                    var34.field2821 = var103;
                                 }

                                 if(var46 == 1427) {
                                    var34.field2902 = var103;
                                 }

                                 var34.field2826 = true;
                                 continue;
                              }

                              if(var46 < 1600) {
                                 var34 = var52?FileOnDisk.field3263:class38.field829;
                                 if(var46 == 1500) {
                                    class38.field833[var5++] = var34.relativeX;
                                    continue;
                                 }

                                 if(var46 == 1501) {
                                    class38.field833[var5++] = var34.relativeY;
                                    continue;
                                 }

                                 if(var46 == 1502) {
                                    class38.field833[var5++] = var34.width;
                                    continue;
                                 }

                                 if(var46 == 1503) {
                                    class38.field833[var5++] = var34.height;
                                    continue;
                                 }

                                 if(var46 == 1504) {
                                    class38.field833[var5++] = var34.isHidden?1:0;
                                    continue;
                                 }

                                 if(var46 == 1505) {
                                    class38.field833[var5++] = var34.parentId;
                                    continue;
                                 }
                              } else if(var46 < 1700) {
                                 var34 = var52?FileOnDisk.field3263:class38.field829;
                                 if(var46 == 1600) {
                                    class38.field833[var5++] = var34.itemId;
                                    continue;
                                 }

                                 if(var46 == 1601) {
                                    class38.field833[var5++] = var34.scrollY;
                                    continue;
                                 }

                                 if(var46 == 1602) {
                                    class38.chatboxSegments[var6++] = var34.text;
                                    continue;
                                 }

                                 if(var46 == 1603) {
                                    class38.field833[var5++] = var34.scrollWidth;
                                    continue;
                                 }

                                 if(var46 == 1604) {
                                    class38.field833[var5++] = var34.scrollHeight;
                                    continue;
                                 }

                                 if(var46 == 1605) {
                                    class38.field833[var5++] = var34.field2870;
                                    continue;
                                 }

                                 if(var46 == 1606) {
                                    class38.field833[var5++] = var34.rotationX;
                                    continue;
                                 }

                                 if(var46 == 1607) {
                                    class38.field833[var5++] = var34.rotationY;
                                    continue;
                                 }

                                 if(var46 == 1608) {
                                    class38.field833[var5++] = var34.rotationZ;
                                    continue;
                                 }

                                 if(var46 == 1609) {
                                    class38.field833[var5++] = var34.opacity;
                                    continue;
                                 }

                                 if(var46 == 1610) {
                                    class38.field833[var5++] = var34.field2848;
                                    continue;
                                 }

                                 if(var46 == 1611) {
                                    class38.field833[var5++] = var34.textColor;
                                    continue;
                                 }

                                 if(var46 == 1612) {
                                    class38.field833[var5++] = var34.field2861;
                                    continue;
                                 }

                                 if(var46 == 1613) {
                                    class38.field833[var5++] = var34.field2910.vmethod3214();
                                    continue;
                                 }
                              } else if(var46 < 1800) {
                                 var34 = var52?FileOnDisk.field3263:class38.field829;
                                 if(var46 == 1700) {
                                    class38.field833[var5++] = var34.item;
                                    continue;
                                 }

                                 if(var46 == 1701) {
                                    if(var34.item != -1) {
                                       class38.field833[var5++] = var34.stackSize;
                                    } else {
                                       class38.field833[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var46 == 1702) {
                                    class38.field833[var5++] = var34.index;
                                    continue;
                                 }
                              } else if(var46 < 1900) {
                                 var34 = var52?FileOnDisk.field3263:class38.field829;
                                 if(var46 == 1800) {
                                    class38.field833[var5++] = ChatMessages.method240(GameEngine.method3133(var34));
                                    continue;
                                 }

                                 if(var46 == 1801) {
                                    --var5;
                                    var39 = class38.field833[var5];
                                    --var39;
                                    if(null != var34.actions && var39 < var34.actions.length && var34.actions[var39] != null) {
                                       class38.chatboxSegments[var6++] = var34.actions[var39];
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var46 == 1802) {
                                    if(var34.name == null) {
                                       class38.chatboxSegments[var6++] = "";
                                    } else {
                                       class38.chatboxSegments[var6++] = var34.name;
                                    }
                                    continue;
                                 }
                              } else if((var46 < 1900 || var46 >= 2000) && (var46 < 2900 || var46 >= 3000)) {
                                 if(var46 < 2600) {
                                    --var5;
                                    var34 = class24.method600(class38.field833[var5]);
                                    if(var46 == 2500) {
                                       class38.field833[var5++] = var34.relativeX;
                                       continue;
                                    }

                                    if(var46 == 2501) {
                                       class38.field833[var5++] = var34.relativeY;
                                       continue;
                                    }

                                    if(var46 == 2502) {
                                       class38.field833[var5++] = var34.width;
                                       continue;
                                    }

                                    if(var46 == 2503) {
                                       class38.field833[var5++] = var34.height;
                                       continue;
                                    }

                                    if(var46 == 2504) {
                                       class38.field833[var5++] = var34.isHidden?1:0;
                                       continue;
                                    }

                                    if(var46 == 2505) {
                                       class38.field833[var5++] = var34.parentId;
                                       continue;
                                    }
                                 } else if(var46 < 2700) {
                                    --var5;
                                    var34 = class24.method600(class38.field833[var5]);
                                    if(var46 == 2600) {
                                       class38.field833[var5++] = var34.itemId;
                                       continue;
                                    }

                                    if(var46 == 2601) {
                                       class38.field833[var5++] = var34.scrollY;
                                       continue;
                                    }

                                    if(var46 == 2602) {
                                       class38.chatboxSegments[var6++] = var34.text;
                                       continue;
                                    }

                                    if(var46 == 2603) {
                                       class38.field833[var5++] = var34.scrollWidth;
                                       continue;
                                    }

                                    if(var46 == 2604) {
                                       class38.field833[var5++] = var34.scrollHeight;
                                       continue;
                                    }

                                    if(var46 == 2605) {
                                       class38.field833[var5++] = var34.field2870;
                                       continue;
                                    }

                                    if(var46 == 2606) {
                                       class38.field833[var5++] = var34.rotationX;
                                       continue;
                                    }

                                    if(var46 == 2607) {
                                       class38.field833[var5++] = var34.rotationY;
                                       continue;
                                    }

                                    if(var46 == 2608) {
                                       class38.field833[var5++] = var34.rotationZ;
                                       continue;
                                    }

                                    if(var46 == 2609) {
                                       class38.field833[var5++] = var34.opacity;
                                       continue;
                                    }

                                    if(var46 == 2610) {
                                       class38.field833[var5++] = var34.field2848;
                                       continue;
                                    }

                                    if(var46 == 2611) {
                                       class38.field833[var5++] = var34.textColor;
                                       continue;
                                    }

                                    if(var46 == 2612) {
                                       class38.field833[var5++] = var34.field2861;
                                       continue;
                                    }

                                    if(var46 == 2613) {
                                       class38.field833[var5++] = var34.field2910.vmethod3214();
                                       continue;
                                    }
                                 } else if(var46 < 2800) {
                                    if(var46 == 2700) {
                                       --var5;
                                       var34 = class24.method600(class38.field833[var5]);
                                       class38.field833[var5++] = var34.item;
                                       continue;
                                    }

                                    if(var46 == 2701) {
                                       --var5;
                                       var34 = class24.method600(class38.field833[var5]);
                                       if(var34.item != -1) {
                                          class38.field833[var5++] = var34.stackSize;
                                       } else {
                                          class38.field833[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var46 == 2702) {
                                       --var5;
                                       var15 = class38.field833[var5];
                                       WidgetNode var49 = (WidgetNode)Client.componentTable.method3817((long)var15);
                                       if(null != var49) {
                                          class38.field833[var5++] = 1;
                                       } else {
                                          class38.field833[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var46 == 2706) {
                                       class38.field833[var5++] = Client.widgetRoot;
                                       continue;
                                    }
                                 } else if(var46 < 2900) {
                                    --var5;
                                    var34 = class24.method600(class38.field833[var5]);
                                    if(var46 == 2800) {
                                       class38.field833[var5++] = ChatMessages.method240(GameEngine.method3133(var34));
                                       continue;
                                    }

                                    if(var46 == 2801) {
                                       --var5;
                                       var39 = class38.field833[var5];
                                       --var39;
                                       if(var34.actions != null && var39 < var34.actions.length && var34.actions[var39] != null) {
                                          class38.chatboxSegments[var6++] = var34.actions[var39];
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var46 == 2802) {
                                       if(var34.name == null) {
                                          class38.chatboxSegments[var6++] = "";
                                       } else {
                                          class38.chatboxSegments[var6++] = var34.name;
                                       }
                                       continue;
                                    }
                                 } else if(var46 < 3200) {
                                    if(var46 == 3100) {
                                       --var6;
                                       var109 = class38.chatboxSegments[var6];
                                       class10.sendGameMessage(0, "", var109);
                                       continue;
                                    }

                                    if(var46 == 3101) {
                                       var5 -= 2;
                                       class45.method949(WidgetNode.localPlayer, class38.field833[var5], class38.field833[1 + var5]);
                                       continue;
                                    }

                                    if(var46 == 3103) {
                                       class62.method1321();
                                       continue;
                                    }

                                    if(var46 == 3104) {
                                       --var6;
                                       var109 = class38.chatboxSegments[var6];
                                       var39 = 0;
                                       if(BufferProvider.method1715(var109)) {
                                          var47 = class145.method3020(var109, 10, true);
                                          var39 = var47;
                                       }

                                       Client.field323.method2801(209);
                                       Client.field323.method2600(var39);
                                       continue;
                                    }

                                    if(var46 == 3105) {
                                       --var6;
                                       var109 = class38.chatboxSegments[var6];
                                       Client.field323.method2801(192);
                                       Client.field323.method2513(var109.length() + 1);
                                       Client.field323.method2519(var109);
                                       continue;
                                    }

                                    if(var46 == 3106) {
                                       --var6;
                                       var109 = class38.chatboxSegments[var6];
                                       Client.field323.method2801(19);
                                       Client.field323.method2513(var109.length() + 1);
                                       Client.field323.method2519(var109);
                                       continue;
                                    }

                                    if(var46 == 3107) {
                                       --var5;
                                       var15 = class38.field833[var5];
                                       --var6;
                                       var50 = class38.chatboxSegments[var6];
                                       class59.method1284(var15, var50);
                                       continue;
                                    }

                                    if(var46 == 3108) {
                                       var5 -= 3;
                                       var15 = class38.field833[var5];
                                       var39 = class38.field833[1 + var5];
                                       var47 = class38.field833[2 + var5];
                                       var87 = class24.method600(var47);
                                       class124.method2777(var87, var15, var39);
                                       continue;
                                    }

                                    if(var46 == 3109) {
                                       var5 -= 2;
                                       var15 = class38.field833[var5];
                                       var39 = class38.field833[1 + var5];
                                       var80 = var52?FileOnDisk.field3263:class38.field829;
                                       class124.method2777(var80, var15, var39);
                                       continue;
                                    }

                                    if(var46 == 3110) {
                                       --var5;
                                       class24.field626 = class38.field833[var5] == 1;
                                       continue;
                                    }

                                    if(var46 == 3111) {
                                       class38.field833[var5++] = class116.field2039.field131?1:0;
                                       continue;
                                    }

                                    if(var46 == 3112) {
                                       --var5;
                                       class116.field2039.field131 = class38.field833[var5] == 1;
                                       class79.method1710();
                                       continue;
                                    }

                                    if(var46 == 3113) {
                                       --var6;
                                       var109 = class38.chatboxSegments[var6];
                                       --var5;
                                       var100 = class38.field833[var5] == 1;
                                       SecondaryBufferProvider.method1682(var109, var100, false);
                                       continue;
                                    }

                                    if(var46 == 3115) {
                                       --var5;
                                       var15 = class38.field833[var5];
                                       Client.field323.method2801(107);
                                       Client.field323.method2514(var15);
                                       continue;
                                    }

                                    if(var46 == 3116) {
                                       --var5;
                                       var15 = class38.field833[var5];
                                       var6 -= 2;
                                       var50 = class38.chatboxSegments[var6];
                                       var35 = class38.chatboxSegments[var6 + 1];
                                       if(var50.length() <= 500 && var35.length() <= 500) {
                                          Client.field323.method2801(44);
                                          Client.field323.method2514(1 + ChatMessages.method229(var50) + ChatMessages.method229(var35));
                                          Client.field323.method2519(var35);
                                          Client.field323.method2519(var50);
                                          Client.field323.method2558(var15);
                                       }
                                       continue;
                                    }
                                 } else if(var46 < 3300) {
                                    if(var46 == 3200) {
                                       var5 -= 3;
                                       var15 = class38.field833[var5];
                                       var39 = class38.field833[var5 + 1];
                                       var47 = class38.field833[var5 + 2];
                                       if(Client.field520 != 0 && var39 != 0 && Client.field522 < 50) {
                                          Client.field523[Client.field522] = var15;
                                          Client.field428[Client.field522] = var39;
                                          Client.field471[Client.field522] = var47;
                                          Client.field432[Client.field522] = null;
                                          Client.field526[Client.field522] = 0;
                                          ++Client.field522;
                                       }
                                       continue;
                                    }

                                    if(var46 == 3201) {
                                       --var5;
                                       class161.method3211(class38.field833[var5]);
                                       continue;
                                    }

                                    if(var46 == 3202) {
                                       var5 -= 2;
                                       class124.method2780(class38.field833[var5], class38.field833[var5 + 1]);
                                       continue;
                                    }
                                 } else {
                                    int var22;
                                    int var40;
                                    if(var46 < 3400) {
                                       if(var46 == 3300) {
                                          class38.field833[var5++] = Client.gameCycle;
                                          continue;
                                       }

                                       XItemContainer var36;
                                       if(var46 == 3301) {
                                          var5 -= 2;
                                          var15 = class38.field833[var5];
                                          var39 = class38.field833[1 + var5];
                                          var81 = class38.field833;
                                          var18 = var5++;
                                          var36 = (XItemContainer)XItemContainer.itemContainers.method3817((long)var15);
                                          if(var36 == null) {
                                             var19 = -1;
                                          } else if(var39 >= 0 && var39 < var36.itemIds.length) {
                                             var19 = var36.itemIds[var39];
                                          } else {
                                             var19 = -1;
                                          }

                                          var81[var18] = var19;
                                          continue;
                                       }

                                       if(var46 == 3302) {
                                          var5 -= 2;
                                          var15 = class38.field833[var5];
                                          var39 = class38.field833[var5 + 1];
                                          var81 = class38.field833;
                                          var18 = var5++;
                                          var36 = (XItemContainer)XItemContainer.itemContainers.method3817((long)var15);
                                          if(var36 == null) {
                                             var19 = 0;
                                          } else if(var39 >= 0 && var39 < var36.stackSizes.length) {
                                             var19 = var36.stackSizes[var39];
                                          } else {
                                             var19 = 0;
                                          }

                                          var81[var18] = var19;
                                          continue;
                                       }

                                       if(var46 == 3303) {
                                          var5 -= 2;
                                          var15 = class38.field833[var5];
                                          var39 = class38.field833[1 + var5];
                                          var81 = class38.field833;
                                          var18 = var5++;
                                          var36 = (XItemContainer)XItemContainer.itemContainers.method3817((long)var15);
                                          if(var36 == null) {
                                             var19 = 0;
                                          } else if(var39 == -1) {
                                             var19 = 0;
                                          } else {
                                             var40 = 0;

                                             for(var22 = 0; var22 < var36.stackSizes.length; ++var22) {
                                                if(var36.itemIds[var22] == var39) {
                                                   var40 += var36.stackSizes[var22];
                                                }
                                             }

                                             var19 = var40;
                                          }

                                          var81[var18] = var19;
                                          continue;
                                       }

                                       if(var46 == 3304) {
                                          --var5;
                                          var15 = class38.field833[var5];
                                          class38.field833[var5++] = class23.method588(var15).field1168;
                                          continue;
                                       }

                                       if(var46 == 3305) {
                                          --var5;
                                          var15 = class38.field833[var5];
                                          class38.field833[var5++] = Client.boostedSkillLevels[var15];
                                          continue;
                                       }

                                       if(var46 == 3306) {
                                          --var5;
                                          var15 = class38.field833[var5];
                                          class38.field833[var5++] = Client.realSkillLevels[var15];
                                          continue;
                                       }

                                       if(var46 == 3307) {
                                          --var5;
                                          var15 = class38.field833[var5];
                                          class38.field833[var5++] = Client.skillExperiences[var15];
                                          continue;
                                       }

                                       if(var46 == 3308) {
                                          var15 = Item.plane;
                                          var39 = (WidgetNode.localPlayer.x >> 7) + class9.baseX;
                                          var47 = KitDefinition.baseY + (WidgetNode.localPlayer.y >> 7);
                                          class38.field833[var5++] = var47 + (var39 << 14) + (var15 << 28);
                                          continue;
                                       }

                                       if(var46 == 3309) {
                                          --var5;
                                          var15 = class38.field833[var5];
                                          class38.field833[var5++] = var15 >> 14 & 16383;
                                          continue;
                                       }

                                       if(var46 == 3310) {
                                          --var5;
                                          var15 = class38.field833[var5];
                                          class38.field833[var5++] = var15 >> 28;
                                          continue;
                                       }

                                       if(var46 == 3311) {
                                          --var5;
                                          var15 = class38.field833[var5];
                                          class38.field833[var5++] = var15 & 16383;
                                          continue;
                                       }

                                       if(var46 == 3312) {
                                          class38.field833[var5++] = Client.isMembers?1:0;
                                          continue;
                                       }

                                       if(var46 == 3313) {
                                          var5 -= 2;
                                          var15 = class38.field833[var5] + '耀';
                                          var39 = class38.field833[var5 + 1];
                                          var81 = class38.field833;
                                          var18 = var5++;
                                          var36 = (XItemContainer)XItemContainer.itemContainers.method3817((long)var15);
                                          if(null == var36) {
                                             var19 = -1;
                                          } else if(var39 >= 0 && var39 < var36.itemIds.length) {
                                             var19 = var36.itemIds[var39];
                                          } else {
                                             var19 = -1;
                                          }

                                          var81[var18] = var19;
                                          continue;
                                       }

                                       if(var46 == 3314) {
                                          var5 -= 2;
                                          var15 = class38.field833[var5] + '耀';
                                          var39 = class38.field833[1 + var5];
                                          var81 = class38.field833;
                                          var18 = var5++;
                                          var36 = (XItemContainer)XItemContainer.itemContainers.method3817((long)var15);
                                          if(var36 == null) {
                                             var19 = 0;
                                          } else if(var39 >= 0 && var39 < var36.stackSizes.length) {
                                             var19 = var36.stackSizes[var39];
                                          } else {
                                             var19 = 0;
                                          }

                                          var81[var18] = var19;
                                          continue;
                                       }

                                       if(var46 == 3315) {
                                          var5 -= 2;
                                          var15 = class38.field833[var5] + '耀';
                                          var39 = class38.field833[var5 + 1];
                                          var81 = class38.field833;
                                          var18 = var5++;
                                          var36 = (XItemContainer)XItemContainer.itemContainers.method3817((long)var15);
                                          if(var36 == null) {
                                             var19 = 0;
                                          } else if(var39 == -1) {
                                             var19 = 0;
                                          } else {
                                             var40 = 0;

                                             for(var22 = 0; var22 < var36.stackSizes.length; ++var22) {
                                                if(var39 == var36.itemIds[var22]) {
                                                   var40 += var36.stackSizes[var22];
                                                }
                                             }

                                             var19 = var40;
                                          }

                                          var81[var18] = var19;
                                          continue;
                                       }

                                       if(var46 == 3316) {
                                          if(Client.field351 >= 2) {
                                             class38.field833[var5++] = Client.field351;
                                          } else {
                                             class38.field833[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var46 == 3317) {
                                          class38.field833[var5++] = Client.field381;
                                          continue;
                                       }

                                       if(var46 == 3318) {
                                          class38.field833[var5++] = Client.world;
                                          continue;
                                       }

                                       if(var46 == 3321) {
                                          class38.field833[var5++] = Client.energy;
                                          continue;
                                       }

                                       if(var46 == 3322) {
                                          class38.field833[var5++] = Client.weight;
                                          continue;
                                       }

                                       if(var46 == 3323) {
                                          if(Client.field478) {
                                             class38.field833[var5++] = 1;
                                          } else {
                                             class38.field833[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var46 == 3324) {
                                          class38.field833[var5++] = Client.flags;
                                          continue;
                                       }
                                    } else if(var46 < 3500) {
                                       if(var46 == 3400) {
                                          var5 -= 2;
                                          var15 = class38.field833[var5];
                                          var39 = class38.field833[1 + var5];
                                          class52 var89 = (class52)class52.field1149.get((long)var15);
                                          class52 var83;
                                          if(var89 != null) {
                                             var83 = var89;
                                          } else {
                                             byte[] var86 = class52.field1146.method3309(8, var15);
                                             var89 = new class52();
                                             if(null != var86) {
                                                var89.method1090(new Buffer(var86));
                                             }

                                             class52.field1149.put(var89, (long)var15);
                                             var83 = var89;
                                          }

                                          var89 = var83;
                                          if(var83.field1147 != 115) {
                                             ;
                                          }

                                          for(var19 = 0; var19 < var89.field1150; ++var19) {
                                             if(var39 == var89.field1151[var19]) {
                                                class38.chatboxSegments[var6++] = var89.field1145[var19];
                                                var89 = null;
                                                break;
                                             }
                                          }

                                          if(var89 != null) {
                                             class38.chatboxSegments[var6++] = var89.field1148;
                                          }
                                          continue;
                                       }

                                       if(var46 == 3408) {
                                          var5 -= 4;
                                          var15 = class38.field833[var5];
                                          var39 = class38.field833[var5 + 1];
                                          var47 = class38.field833[2 + var5];
                                          var18 = class38.field833[3 + var5];
                                          class52 var84 = (class52)class52.field1149.get((long)var47);
                                          class52 var82;
                                          if(null != var84) {
                                             var82 = var84;
                                          } else {
                                             byte[] var21 = class52.field1146.method3309(8, var47);
                                             var84 = new class52();
                                             if(null != var21) {
                                                var84.method1090(new Buffer(var21));
                                             }

                                             class52.field1149.put(var84, (long)var47);
                                             var82 = var84;
                                          }

                                          var84 = var82;
                                          if(var82.field1144 == var15 && var39 == var82.field1147) {
                                             for(var40 = 0; var40 < var84.field1150; ++var40) {
                                                if(var84.field1151[var40] == var18) {
                                                   if(var39 == 115) {
                                                      class38.chatboxSegments[var6++] = var84.field1145[var40];
                                                   } else {
                                                      class38.field833[var5++] = var84.field1152[var40];
                                                   }

                                                   var84 = null;
                                                   break;
                                                }
                                             }

                                             if(var84 != null) {
                                                if(var39 == 115) {
                                                   class38.chatboxSegments[var6++] = var84.field1148;
                                                } else {
                                                   class38.field833[var5++] = var84.field1153;
                                                }
                                             }
                                             continue;
                                          }

                                          if(var39 == 115) {
                                             class38.chatboxSegments[var6++] = "null";
                                          } else {
                                             class38.field833[var5++] = 0;
                                          }
                                          continue;
                                       }
                                    } else {
                                       String var88;
                                       if(var46 < 3700) {
                                          if(var46 == 3600) {
                                             if(Client.field469 == 0) {
                                                class38.field833[var5++] = -2;
                                             } else if(Client.field469 == 1) {
                                                class38.field833[var5++] = -1;
                                             } else {
                                                class38.field833[var5++] = Client.friendCount;
                                             }
                                             continue;
                                          }

                                          if(var46 == 3601) {
                                             --var5;
                                             var15 = class38.field833[var5];
                                             if(Client.field469 == 2 && var15 < Client.friendCount) {
                                                class38.chatboxSegments[var6++] = Client.friends[var15].name;
                                                class38.chatboxSegments[var6++] = Client.friends[var15].previousName;
                                                continue;
                                             }

                                             class38.chatboxSegments[var6++] = "";
                                             class38.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var46 == 3602) {
                                             --var5;
                                             var15 = class38.field833[var5];
                                             if(Client.field469 == 2 && var15 < Client.friendCount) {
                                                class38.field833[var5++] = Client.friends[var15].world;
                                                continue;
                                             }

                                             class38.field833[var5++] = 0;
                                             continue;
                                          }

                                          if(var46 == 3603) {
                                             --var5;
                                             var15 = class38.field833[var5];
                                             if(Client.field469 == 2 && var15 < Client.friendCount) {
                                                class38.field833[var5++] = Client.friends[var15].rank;
                                                continue;
                                             }

                                             class38.field833[var5++] = 0;
                                             continue;
                                          }

                                          if(var46 == 3604) {
                                             --var6;
                                             var109 = class38.chatboxSegments[var6];
                                             --var5;
                                             var39 = class38.field833[var5];
                                             class169.method3301(var109, var39);
                                             continue;
                                          }

                                          Ignore var94;
                                          Friend var97;
                                          if(var46 == 3605) {
                                             --var6;
                                             var109 = class38.chatboxSegments[var6];
                                             if(var109 == null) {
                                                continue;
                                             }

                                             if((Client.friendCount < 200 || Client.field405 == 1) && Client.friendCount < 400) {
                                                var50 = Frames.method2312(var109, Client.field283);
                                                if(null == var50) {
                                                   continue;
                                                }

                                                for(var47 = 0; var47 < Client.friendCount; ++var47) {
                                                   var97 = Client.friends[var47];
                                                   var88 = Frames.method2312(var97.name, Client.field283);
                                                   if(null != var88 && var88.equals(var50)) {
                                                      class10.sendGameMessage(30, "", var109 + " is already on your friend list");
                                                      continue label3898;
                                                   }

                                                   if(null != var97.previousName) {
                                                      var92 = Frames.method2312(var97.previousName, Client.field283);
                                                      if(var92 != null && var92.equals(var50)) {
                                                         class10.sendGameMessage(30, "", var109 + " is already on your friend list");
                                                         continue label3898;
                                                      }
                                                   }
                                                }

                                                for(var47 = 0; var47 < Client.ignoreCount; ++var47) {
                                                   var94 = Client.ignores[var47];
                                                   var88 = Frames.method2312(var94.name, Client.field283);
                                                   if(null != var88 && var88.equals(var50)) {
                                                      class10.sendGameMessage(30, "", "Please remove " + var109 + " from your ignore list first");
                                                      continue label3898;
                                                   }

                                                   if(null != var94.previousName) {
                                                      var92 = Frames.method2312(var94.previousName, Client.field283);
                                                      if(null != var92 && var92.equals(var50)) {
                                                         class10.sendGameMessage(30, "", "Please remove " + var109 + " from your ignore list first");
                                                         continue label3898;
                                                      }
                                                   }
                                                }

                                                if(Frames.method2312(WidgetNode.localPlayer.name, Client.field283).equals(var50)) {
                                                   class10.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                                } else {
                                                   Client.field323.method2801(223);
                                                   Client.field323.method2513(ChatMessages.method229(var109));
                                                   Client.field323.method2519(var109);
                                                }
                                                continue;
                                             }

                                             class10.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                             continue;
                                          }

                                          if(var46 == 3606) {
                                             --var6;
                                             var109 = class38.chatboxSegments[var6];
                                             if(null == var109) {
                                                continue;
                                             }

                                             var50 = Frames.method2312(var109, Client.field283);
                                             if(null == var50) {
                                                continue;
                                             }

                                             var47 = 0;

                                             while(true) {
                                                if(var47 >= Client.friendCount) {
                                                   continue label3898;
                                                }

                                                var97 = Client.friends[var47];
                                                var88 = var97.name;
                                                var92 = Frames.method2312(var88, Client.field283);
                                                if(class20.method562(var109, var50, var88, var92)) {
                                                   --Client.friendCount;

                                                   for(var40 = var47; var40 < Client.friendCount; ++var40) {
                                                      Client.friends[var40] = Client.friends[var40 + 1];
                                                   }

                                                   Client.field473 = Client.field465;
                                                   Client.field323.method2801(152);
                                                   Client.field323.method2513(ChatMessages.method229(var109));
                                                   Client.field323.method2519(var109);
                                                   continue label3898;
                                                }

                                                ++var47;
                                             }
                                          }

                                          if(var46 == 3607) {
                                             --var6;
                                             var109 = class38.chatboxSegments[var6];
                                             if(null == var109) {
                                                continue;
                                             }

                                             if((Client.ignoreCount < 100 || Client.field405 == 1) && Client.ignoreCount < 400) {
                                                var50 = Frames.method2312(var109, Client.field283);
                                                if(var50 == null) {
                                                   continue;
                                                }

                                                for(var47 = 0; var47 < Client.ignoreCount; ++var47) {
                                                   var94 = Client.ignores[var47];
                                                   var88 = Frames.method2312(var94.name, Client.field283);
                                                   if(var88 != null && var88.equals(var50)) {
                                                      class10.sendGameMessage(31, "", var109 + " is already on your ignore list");
                                                      continue label3898;
                                                   }

                                                   if(null != var94.previousName) {
                                                      var92 = Frames.method2312(var94.previousName, Client.field283);
                                                      if(null != var92 && var92.equals(var50)) {
                                                         class10.sendGameMessage(31, "", var109 + " is already on your ignore list");
                                                         continue label3898;
                                                      }
                                                   }
                                                }

                                                for(var47 = 0; var47 < Client.friendCount; ++var47) {
                                                   var97 = Client.friends[var47];
                                                   var88 = Frames.method2312(var97.name, Client.field283);
                                                   if(var88 != null && var88.equals(var50)) {
                                                      class10.sendGameMessage(31, "", "Please remove " + var109 + " from your friend list first");
                                                      continue label3898;
                                                   }

                                                   if(var97.previousName != null) {
                                                      var92 = Frames.method2312(var97.previousName, Client.field283);
                                                      if(var92 != null && var92.equals(var50)) {
                                                         class10.sendGameMessage(31, "", "Please remove " + var109 + " from your friend list first");
                                                         continue label3898;
                                                      }
                                                   }
                                                }

                                                if(Frames.method2312(WidgetNode.localPlayer.name, Client.field283).equals(var50)) {
                                                   class10.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                                } else {
                                                   Client.field323.method2801(47);
                                                   Client.field323.method2513(ChatMessages.method229(var109));
                                                   Client.field323.method2519(var109);
                                                }
                                                continue;
                                             }

                                             class10.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                             continue;
                                          }

                                          if(var46 == 3608) {
                                             --var6;
                                             var109 = class38.chatboxSegments[var6];
                                             if(var109 == null) {
                                                continue;
                                             }

                                             var50 = Frames.method2312(var109, Client.field283);
                                             if(var50 == null) {
                                                continue;
                                             }

                                             var47 = 0;

                                             while(true) {
                                                if(var47 >= Client.ignoreCount) {
                                                   continue label3898;
                                                }

                                                var94 = Client.ignores[var47];
                                                var88 = var94.name;
                                                var92 = Frames.method2312(var88, Client.field283);
                                                if(class20.method562(var109, var50, var88, var92)) {
                                                   --Client.ignoreCount;

                                                   for(var40 = var47; var40 < Client.ignoreCount; ++var40) {
                                                      Client.ignores[var40] = Client.ignores[1 + var40];
                                                   }

                                                   Client.field473 = Client.field465;
                                                   Client.field323.method2801(123);
                                                   Client.field323.method2513(ChatMessages.method229(var109));
                                                   Client.field323.method2519(var109);
                                                   continue label3898;
                                                }

                                                ++var47;
                                             }
                                          }

                                          if(var46 == 3609) {
                                             --var6;
                                             var109 = class38.chatboxSegments[var6];
                                             class155[] var51 = new class155[]{class155.field2329, class155.field2328, class155.field2330, class155.field2337, class155.field2331};
                                             class155[] var91 = var51;

                                             for(var18 = 0; var18 < var91.length; ++var18) {
                                                class155 var90 = var91[var18];
                                                if(var90.field2334 != -1) {
                                                   var22 = var90.field2334;
                                                   var53 = "<img=" + var22 + ">";
                                                   if(var109.startsWith(var53)) {
                                                      var109 = var109.substring(6 + Integer.toString(var90.field2334).length());
                                                      break;
                                                   }
                                                }
                                             }

                                             class38.field833[var5++] = class132.method2871(var109, false)?1:0;
                                             continue;
                                          }

                                          if(var46 == 3611) {
                                             if(Client.field507 != null) {
                                                class38.chatboxSegments[var6++] = class166.method3284(Client.field507);
                                             } else {
                                                class38.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var46 == 3612) {
                                             if(Client.field507 != null) {
                                                class38.field833[var5++] = class133.field2138;
                                             } else {
                                                class38.field833[var5++] = 0;
                                             }
                                             continue;
                                          }

                                          if(var46 == 3613) {
                                             --var5;
                                             var15 = class38.field833[var5];
                                             if(Client.field507 != null && var15 < class133.field2138) {
                                                class38.chatboxSegments[var6++] = class175.clanMembers[var15].username;
                                                continue;
                                             }

                                             class38.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var46 == 3614) {
                                             --var5;
                                             var15 = class38.field833[var5];
                                             if(Client.field507 != null && var15 < class133.field2138) {
                                                class38.field833[var5++] = class175.clanMembers[var15].world;
                                                continue;
                                             }

                                             class38.field833[var5++] = 0;
                                             continue;
                                          }

                                          if(var46 == 3615) {
                                             --var5;
                                             var15 = class38.field833[var5];
                                             if(null != Client.field507 && var15 < class133.field2138) {
                                                class38.field833[var5++] = class175.clanMembers[var15].rank;
                                                continue;
                                             }

                                             class38.field833[var5++] = 0;
                                             continue;
                                          }

                                          if(var46 == 3616) {
                                             class38.field833[var5++] = VertexNormal.field1722;
                                             continue;
                                          }

                                          if(var46 == 3617) {
                                             --var6;
                                             var109 = class38.chatboxSegments[var6];
                                             if(null != class175.clanMembers) {
                                                Client.field323.method2801(48);
                                                Client.field323.method2513(ChatMessages.method229(var109));
                                                Client.field323.method2519(var109);
                                             }
                                             continue;
                                          }

                                          if(var46 == 3618) {
                                             class38.field833[var5++] = class79.field1459;
                                             continue;
                                          }

                                          if(var46 == 3619) {
                                             --var6;
                                             var109 = class38.chatboxSegments[var6];
                                             Renderable.method1946(var109);
                                             continue;
                                          }

                                          if(var46 == 3620) {
                                             Projectile.method98();
                                             continue;
                                          }

                                          if(var46 == 3621) {
                                             if(Client.field469 == 0) {
                                                class38.field833[var5++] = -1;
                                             } else {
                                                class38.field833[var5++] = Client.ignoreCount;
                                             }
                                             continue;
                                          }

                                          if(var46 == 3622) {
                                             --var5;
                                             var15 = class38.field833[var5];
                                             if(Client.field469 != 0 && var15 < Client.ignoreCount) {
                                                class38.chatboxSegments[var6++] = Client.ignores[var15].name;
                                                class38.chatboxSegments[var6++] = Client.ignores[var15].previousName;
                                                continue;
                                             }

                                             class38.chatboxSegments[var6++] = "";
                                             class38.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var46 == 3623) {
                                             label3608: {
                                                --var6;
                                                var109 = class38.chatboxSegments[var6];
                                                var35 = "<img=0>";
                                                if(!var109.startsWith(var35)) {
                                                   var88 = "<img=1>";
                                                   if(!var109.startsWith(var88)) {
                                                      break label3608;
                                                   }
                                                }

                                                var109 = var109.substring(7);
                                             }

                                             class38.field833[var5++] = SecondaryBufferProvider.method1676(var109)?1:0;
                                             continue;
                                          }

                                          if(var46 == 3624) {
                                             --var5;
                                             var15 = class38.field833[var5];
                                             if(class175.clanMembers != null && var15 < class133.field2138 && class175.clanMembers[var15].username.equalsIgnoreCase(WidgetNode.localPlayer.name)) {
                                                class38.field833[var5++] = 1;
                                                continue;
                                             }

                                             class38.field833[var5++] = 0;
                                             continue;
                                          }

                                          if(var46 == 3625) {
                                             if(null != Client.field286) {
                                                class38.chatboxSegments[var6++] = class166.method3284(Client.field286);
                                             } else {
                                                class38.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }
                                       } else {
                                          long var59;
                                          if(var46 < 4000) {
                                             if(var46 == 3903) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                class38.field833[var5++] = Client.grandExchangeOffers[var15].method4044();
                                                continue;
                                             }

                                             if(var46 == 3904) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                class38.field833[var5++] = Client.grandExchangeOffers[var15].itemId;
                                                continue;
                                             }

                                             if(var46 == 3905) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                class38.field833[var5++] = Client.grandExchangeOffers[var15].price;
                                                continue;
                                             }

                                             if(var46 == 3906) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                class38.field833[var5++] = Client.grandExchangeOffers[var15].totalQuantity;
                                                continue;
                                             }

                                             if(var46 == 3907) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                class38.field833[var5++] = Client.grandExchangeOffers[var15].quantitySold;
                                                continue;
                                             }

                                             if(var46 == 3908) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                class38.field833[var5++] = Client.grandExchangeOffers[var15].spent;
                                                continue;
                                             }

                                             if(var46 == 3910) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var39 = Client.grandExchangeOffers[var15].method4042();
                                                class38.field833[var5++] = var39 == 0?1:0;
                                                continue;
                                             }

                                             if(var46 == 3911) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var39 = Client.grandExchangeOffers[var15].method4042();
                                                class38.field833[var5++] = var39 == 2?1:0;
                                                continue;
                                             }

                                             if(var46 == 3912) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var39 = Client.grandExchangeOffers[var15].method4042();
                                                class38.field833[var5++] = var39 == 5?1:0;
                                                continue;
                                             }

                                             if(var46 == 3913) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var39 = Client.grandExchangeOffers[var15].method4042();
                                                class38.field833[var5++] = var39 == 1?1:0;
                                                continue;
                                             }

                                             boolean var69;
                                             if(var46 == 3914) {
                                                --var5;
                                                var69 = class38.field833[var5] == 1;
                                                if(class18.field260 != null) {
                                                   class18.field260.method4056(class224.field3223, var69);
                                                }
                                                continue;
                                             }

                                             if(var46 == 3915) {
                                                --var5;
                                                var69 = class38.field833[var5] == 1;
                                                if(null != class18.field260) {
                                                   class18.field260.method4056(class224.field3226, var69);
                                                }
                                                continue;
                                             }

                                             if(var46 == 3916) {
                                                var5 -= 2;
                                                var69 = class38.field833[var5] == 1;
                                                var100 = class38.field833[var5 + 1] == 1;
                                                if(null != class18.field260) {
                                                   class18.field260.method4056(new class22(var100), var69);
                                                }
                                                continue;
                                             }

                                             if(var46 == 3917) {
                                                --var5;
                                                var69 = class38.field833[var5] == 1;
                                                if(null != class18.field260) {
                                                   class18.field260.method4056(class224.field3224, var69);
                                                }
                                                continue;
                                             }

                                             if(var46 == 3918) {
                                                --var5;
                                                var69 = class38.field833[var5] == 1;
                                                if(class18.field260 != null) {
                                                   class18.field260.method4056(class224.field3225, var69);
                                                }
                                                continue;
                                             }

                                             if(var46 == 3919) {
                                                class38.field833[var5++] = class18.field260 == null?0:class18.field260.field3227.size();
                                                continue;
                                             }

                                             class217 var54;
                                             if(var46 == 3920) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var54 = (class217)class18.field260.field3227.get(var15);
                                                class38.field833[var5++] = var54.field3204;
                                                continue;
                                             }

                                             if(var46 == 3921) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var54 = (class217)class18.field260.field3227.get(var15);
                                                class38.chatboxSegments[var6++] = var54.method4000();
                                                continue;
                                             }

                                             if(var46 == 3922) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var54 = (class217)class18.field260.field3227.get(var15);
                                                class38.chatboxSegments[var6++] = var54.method4004();
                                                continue;
                                             }

                                             if(var46 == 3923) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var54 = (class217)class18.field260.field3227.get(var15);
                                                var59 = class5.method63() - field28 - var54.field3203;
                                                var19 = (int)(var59 / 3600000L);
                                                var20 = (int)((var59 - (long)(3600000 * var19)) / 60000L);
                                                var40 = (int)((var59 - (long)(var19 * 3600000) - (long)(var20 * '\uea60')) / 1000L);
                                                String var41 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var40 / 10 + var40 % 10;
                                                class38.chatboxSegments[var6++] = var41;
                                                continue;
                                             }

                                             if(var46 == 3924) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var54 = (class217)class18.field260.field3227.get(var15);
                                                class38.field833[var5++] = var54.field3202.totalQuantity;
                                                continue;
                                             }

                                             if(var46 == 3925) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var54 = (class217)class18.field260.field3227.get(var15);
                                                class38.field833[var5++] = var54.field3202.price;
                                                continue;
                                             }

                                             if(var46 == 3926) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                var54 = (class217)class18.field260.field3227.get(var15);
                                                class38.field833[var5++] = var54.field3202.itemId;
                                                continue;
                                             }
                                          } else if(var46 < 4100) {
                                             if(var46 == 4000) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[1 + var5];
                                                class38.field833[var5++] = var15 + var39;
                                                continue;
                                             }

                                             if(var46 == 4001) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[1 + var5];
                                                class38.field833[var5++] = var15 - var39;
                                                continue;
                                             }

                                             if(var46 == 4002) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[var5 + 1];
                                                class38.field833[var5++] = var39 * var15;
                                                continue;
                                             }

                                             if(var46 == 4003) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[1 + var5];
                                                class38.field833[var5++] = var15 / var39;
                                                continue;
                                             }

                                             if(var46 == 4004) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                class38.field833[var5++] = (int)(Math.random() * (double)var15);
                                                continue;
                                             }

                                             if(var46 == 4005) {
                                                --var5;
                                                var15 = class38.field833[var5];
                                                class38.field833[var5++] = (int)(Math.random() * (double)(1 + var15));
                                                continue;
                                             }

                                             if(var46 == 4006) {
                                                var5 -= 5;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[var5 + 1];
                                                var47 = class38.field833[var5 + 2];
                                                var18 = class38.field833[var5 + 3];
                                                var19 = class38.field833[var5 + 4];
                                                class38.field833[var5++] = var15 + (var19 - var47) * (var39 - var15) / (var18 - var47);
                                                continue;
                                             }

                                             if(var46 == 4007) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[1 + var5];
                                                class38.field833[var5++] = var39 * var15 / 100 + var15;
                                                continue;
                                             }

                                             if(var46 == 4008) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[var5 + 1];
                                                class38.field833[var5++] = var15 | 1 << var39;
                                                continue;
                                             }

                                             if(var46 == 4009) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[1 + var5];
                                                class38.field833[var5++] = var15 & -1 - (1 << var39);
                                                continue;
                                             }

                                             if(var46 == 4010) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[var5 + 1];
                                                class38.field833[var5++] = (var15 & 1 << var39) != 0?1:0;
                                                continue;
                                             }

                                             if(var46 == 4011) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[1 + var5];
                                                class38.field833[var5++] = var15 % var39;
                                                continue;
                                             }

                                             if(var46 == 4012) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[var5 + 1];
                                                if(var15 == 0) {
                                                   class38.field833[var5++] = 0;
                                                } else {
                                                   class38.field833[var5++] = (int)Math.pow((double)var15, (double)var39);
                                                }
                                                continue;
                                             }

                                             if(var46 == 4013) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[var5 + 1];
                                                if(var15 == 0) {
                                                   class38.field833[var5++] = 0;
                                                } else if(var39 == 0) {
                                                   class38.field833[var5++] = Integer.MAX_VALUE;
                                                } else {
                                                   class38.field833[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var39);
                                                }
                                                continue;
                                             }

                                             if(var46 == 4014) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[1 + var5];
                                                class38.field833[var5++] = var15 & var39;
                                                continue;
                                             }

                                             if(var46 == 4015) {
                                                var5 -= 2;
                                                var15 = class38.field833[var5];
                                                var39 = class38.field833[var5 + 1];
                                                class38.field833[var5++] = var15 | var39;
                                                continue;
                                             }

                                             if(var46 == 4018) {
                                                var5 -= 3;
                                                long var78 = (long)class38.field833[var5];
                                                var59 = (long)class38.field833[1 + var5];
                                                long var66 = (long)class38.field833[2 + var5];
                                                class38.field833[var5++] = (int)(var78 * var66 / var59);
                                                continue;
                                             }
                                          } else {
                                             int var24;
                                             if(var46 < 4200) {
                                                if(var46 == 4100) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   --var5;
                                                   var39 = class38.field833[var5];
                                                   class38.chatboxSegments[var6++] = var109 + var39;
                                                   continue;
                                                }

                                                if(var46 == 4101) {
                                                   var6 -= 2;
                                                   var109 = class38.chatboxSegments[var6];
                                                   var50 = class38.chatboxSegments[var6 + 1];
                                                   class38.chatboxSegments[var6++] = var109 + var50;
                                                   continue;
                                                }

                                                if(var46 == 4102) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   --var5;
                                                   var39 = class38.field833[var5];
                                                   class38.chatboxSegments[var6++] = var109 + class24.method599(var39, true);
                                                   continue;
                                                }

                                                if(var46 == 4103) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   class38.chatboxSegments[var6++] = var109.toLowerCase();
                                                   continue;
                                                }

                                                if(var46 == 4104) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   long var111 = (11745L + (long)var15) * 86400000L;
                                                   class38.field834.setTime(new Date(var111));
                                                   var18 = class38.field834.get(5);
                                                   var19 = class38.field834.get(2);
                                                   var20 = class38.field834.get(1);
                                                   class38.chatboxSegments[var6++] = var18 + "-" + class38.field831[var19] + "-" + var20;
                                                   continue;
                                                }

                                                if(var46 == 4105) {
                                                   var6 -= 2;
                                                   var109 = class38.chatboxSegments[var6];
                                                   var50 = class38.chatboxSegments[var6 + 1];
                                                   if(null != WidgetNode.localPlayer.composition && WidgetNode.localPlayer.composition.isFemale) {
                                                      class38.chatboxSegments[var6++] = var50;
                                                      continue;
                                                   }

                                                   class38.chatboxSegments[var6++] = var109;
                                                   continue;
                                                }

                                                if(var46 == 4106) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.chatboxSegments[var6++] = Integer.toString(var15);
                                                   continue;
                                                }

                                                if(var46 == 4107) {
                                                   var6 -= 2;
                                                   int[] var112 = class38.field833;
                                                   var39 = var5++;
                                                   var88 = class38.chatboxSegments[var6];
                                                   var92 = class38.chatboxSegments[1 + var6];
                                                   var40 = Client.field489;
                                                   var22 = var88.length();
                                                   int var23 = var92.length();
                                                   var24 = 0;
                                                   int var25 = 0;
                                                   byte var26 = 0;
                                                   byte var27 = 0;

                                                   label3669:
                                                   while(true) {
                                                      if(var24 - var26 >= var22 && var25 - var27 >= var23) {
                                                         int var70 = Math.min(var22, var23);

                                                         int var72;
                                                         char var77;
                                                         for(var72 = 0; var72 < var70; ++var72) {
                                                            char var75 = var88.charAt(var72);
                                                            var77 = var92.charAt(var72);
                                                            if(var75 != var77 && Character.toUpperCase(var75) != Character.toUpperCase(var77)) {
                                                               var75 = Character.toLowerCase(var75);
                                                               var77 = Character.toLowerCase(var77);
                                                               if(var75 != var77) {
                                                                  var18 = class50.method1047(var75, var40) - class50.method1047(var77, var40);
                                                                  break label3669;
                                                               }
                                                            }
                                                         }

                                                         var72 = var22 - var23;
                                                         if(var72 != 0) {
                                                            var18 = var72;
                                                         } else {
                                                            for(int var76 = 0; var76 < var70; ++var76) {
                                                               var77 = var88.charAt(var76);
                                                               char var32 = var92.charAt(var76);
                                                               if(var77 != var32) {
                                                                  var18 = class50.method1047(var77, var40) - class50.method1047(var32, var40);
                                                                  break label3669;
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
                                                         var28 = (char)var26;
                                                         boolean var61 = false;
                                                      } else {
                                                         var28 = var88.charAt(var24++);
                                                      }

                                                      char var29;
                                                      if(var27 != 0) {
                                                         var29 = (char)var27;
                                                         boolean var63 = false;
                                                      } else {
                                                         var29 = var92.charAt(var25++);
                                                      }

                                                      byte var30;
                                                      if(var28 == 198) {
                                                         var30 = 69;
                                                      } else if(var28 == 230) {
                                                         var30 = 101;
                                                      } else if(var28 == 223) {
                                                         var30 = 115;
                                                      } else if(var28 == 338) {
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
                                                      } else if(var29 == 230) {
                                                         var31 = 101;
                                                      } else if(var29 == 223) {
                                                         var31 = 115;
                                                      } else if(var29 == 338) {
                                                         var31 = 69;
                                                      } else if(var29 == 339) {
                                                         var31 = 101;
                                                      } else {
                                                         var31 = 0;
                                                      }

                                                      var27 = var31;
                                                      var28 = class152.method3182(var28, var40);
                                                      var29 = class152.method3182(var29, var40);
                                                      if(var28 != var29 && Character.toUpperCase(var28) != Character.toUpperCase(var29)) {
                                                         var28 = Character.toLowerCase(var28);
                                                         var29 = Character.toLowerCase(var29);
                                                         if(var29 != var28) {
                                                            var18 = class50.method1047(var28, var40) - class50.method1047(var29, var40);
                                                            break;
                                                         }
                                                      }
                                                   }

                                                   if(var18 > 0) {
                                                      var65 = 1;
                                                   } else if(var18 < 0) {
                                                      var65 = -1;
                                                   } else {
                                                      var65 = 0;
                                                   }

                                                   var112[var39] = var65;
                                                   continue;
                                                }

                                                class227 var96;
                                                byte[] var102;
                                                if(var46 == 4108) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   var5 -= 2;
                                                   var39 = class38.field833[var5];
                                                   var47 = class38.field833[var5 + 1];
                                                   var102 = class53.field1156.method3309(var47, 0);
                                                   var96 = new class227(var102);
                                                   class38.field833[var5++] = var96.method4068(var109, var39);
                                                   continue;
                                                }

                                                if(var46 == 4109) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   var5 -= 2;
                                                   var39 = class38.field833[var5];
                                                   var47 = class38.field833[1 + var5];
                                                   var102 = class53.field1156.method3309(var47, 0);
                                                   var96 = new class227(var102);
                                                   class38.field833[var5++] = var96.method4067(var109, var39);
                                                   continue;
                                                }

                                                if(var46 == 4110) {
                                                   var6 -= 2;
                                                   var109 = class38.chatboxSegments[var6];
                                                   var50 = class38.chatboxSegments[1 + var6];
                                                   --var5;
                                                   if(class38.field833[var5] == 1) {
                                                      class38.chatboxSegments[var6++] = var109;
                                                   } else {
                                                      class38.chatboxSegments[var6++] = var50;
                                                   }
                                                   continue;
                                                }

                                                if(var46 == 4111) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   class38.chatboxSegments[var6++] = class226.method4069(var109);
                                                   continue;
                                                }

                                                if(var46 == 4112) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   --var5;
                                                   var39 = class38.field833[var5];
                                                   class38.chatboxSegments[var6++] = var109 + (char)var39;
                                                   continue;
                                                }

                                                if(var46 == 4113) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.field833[var5++] = class107.method2317((char)var15)?1:0;
                                                   continue;
                                                }

                                                if(var46 == 4114) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.field833[var5++] = class23.method585((char)var15)?1:0;
                                                   continue;
                                                }

                                                char var67;
                                                if(var46 == 4115) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   var58 = class38.field833;
                                                   var47 = var5++;
                                                   var67 = (char)var15;
                                                   var56 = var67 >= 65 && var67 <= 90 || var67 >= 97 && var67 <= 122;
                                                   var58[var47] = var56?1:0;
                                                   continue;
                                                }

                                                if(var46 == 4116) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.field833[var5++] = SecondaryBufferProvider.method1668((char)var15)?1:0;
                                                   continue;
                                                }

                                                if(var46 == 4117) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   if(var109 != null) {
                                                      class38.field833[var5++] = var109.length();
                                                   } else {
                                                      class38.field833[var5++] = 0;
                                                   }
                                                   continue;
                                                }

                                                if(var46 == 4118) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   var5 -= 2;
                                                   var39 = class38.field833[var5];
                                                   var47 = class38.field833[1 + var5];
                                                   class38.chatboxSegments[var6++] = var109.substring(var39, var47);
                                                   continue;
                                                }

                                                if(var46 == 4119) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   StringBuilder var57 = new StringBuilder(var109.length());
                                                   var17 = false;

                                                   for(var18 = 0; var18 < var109.length(); ++var18) {
                                                      var67 = var109.charAt(var18);
                                                      if(var67 == 60) {
                                                         var17 = true;
                                                      } else if(var67 == 62) {
                                                         var17 = false;
                                                      } else if(!var17) {
                                                         var57.append(var67);
                                                      }
                                                   }

                                                   class38.chatboxSegments[var6++] = var57.toString();
                                                   continue;
                                                }

                                                if(var46 == 4120) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   --var5;
                                                   var39 = class38.field833[var5];
                                                   class38.field833[var5++] = var109.indexOf(var39);
                                                   continue;
                                                }

                                                if(var46 == 4121) {
                                                   var6 -= 2;
                                                   var109 = class38.chatboxSegments[var6];
                                                   var50 = class38.chatboxSegments[var6 + 1];
                                                   --var5;
                                                   var47 = class38.field833[var5];
                                                   class38.field833[var5++] = var109.indexOf(var50, var47);
                                                   continue;
                                                }
                                             } else if(var46 < 4300) {
                                                if(var46 == 4200) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.chatboxSegments[var6++] = MessageNode.getItemDefinition(var15).name;
                                                   continue;
                                                }

                                                ItemComposition var93;
                                                if(var46 == 4201) {
                                                   var5 -= 2;
                                                   var15 = class38.field833[var5];
                                                   var39 = class38.field833[var5 + 1];
                                                   var93 = MessageNode.getItemDefinition(var15);
                                                   if(var39 >= 1 && var39 <= 5 && var93.groundActions[var39 - 1] != null) {
                                                      class38.chatboxSegments[var6++] = var93.groundActions[var39 - 1];
                                                      continue;
                                                   }

                                                   class38.chatboxSegments[var6++] = "";
                                                   continue;
                                                }

                                                if(var46 == 4202) {
                                                   var5 -= 2;
                                                   var15 = class38.field833[var5];
                                                   var39 = class38.field833[var5 + 1];
                                                   var93 = MessageNode.getItemDefinition(var15);
                                                   if(var39 >= 1 && var39 <= 5 && null != var93.inventoryActions[var39 - 1]) {
                                                      class38.chatboxSegments[var6++] = var93.inventoryActions[var39 - 1];
                                                      continue;
                                                   }

                                                   class38.chatboxSegments[var6++] = "";
                                                   continue;
                                                }

                                                if(var46 == 4203) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.field833[var5++] = MessageNode.getItemDefinition(var15).price;
                                                   continue;
                                                }

                                                if(var46 == 4204) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.field833[var5++] = MessageNode.getItemDefinition(var15).isStackable == 1?1:0;
                                                   continue;
                                                }

                                                ItemComposition var60;
                                                if(var46 == 4205) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   var60 = MessageNode.getItemDefinition(var15);
                                                   if(var60.field1219 == -1 && var60.note >= 0) {
                                                      class38.field833[var5++] = var60.note;
                                                      continue;
                                                   }

                                                   class38.field833[var5++] = var15;
                                                   continue;
                                                }

                                                if(var46 == 4206) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   var60 = MessageNode.getItemDefinition(var15);
                                                   if(var60.field1219 >= 0 && var60.note >= 0) {
                                                      class38.field833[var5++] = var60.note;
                                                      continue;
                                                   }

                                                   class38.field833[var5++] = var15;
                                                   continue;
                                                }

                                                if(var46 == 4207) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.field833[var5++] = MessageNode.getItemDefinition(var15).isMembers?1:0;
                                                   continue;
                                                }

                                                if(var46 == 4208) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   var60 = MessageNode.getItemDefinition(var15);
                                                   if(var60.field1184 == -1 && var60.field1227 >= 0) {
                                                      class38.field833[var5++] = var60.field1227;
                                                      continue;
                                                   }

                                                   class38.field833[var5++] = var15;
                                                   continue;
                                                }

                                                if(var46 == 4209) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   var60 = MessageNode.getItemDefinition(var15);
                                                   if(var60.field1184 >= 0 && var60.field1227 >= 0) {
                                                      class38.field833[var5++] = var60.field1227;
                                                      continue;
                                                   }

                                                   class38.field833[var5++] = var15;
                                                   continue;
                                                }

                                                if(var46 == 4210) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   --var5;
                                                   var39 = class38.field833[var5];
                                                   var56 = var39 == 1;
                                                   var35 = var109.toLowerCase();
                                                   short[] var101 = new short[16];
                                                   var20 = 0;
                                                   var40 = 0;

                                                   while(true) {
                                                      if(var40 >= class10.field158) {
                                                         class110.field1959 = var101;
                                                         Client.field379 = 0;
                                                         class12.field181 = var20;
                                                         String[] var55 = new String[class12.field181];

                                                         for(var22 = 0; var22 < class12.field181; ++var22) {
                                                            var55[var22] = MessageNode.getItemDefinition(var101[var22]).name;
                                                         }

                                                         short[] var99 = class110.field1959;
                                                         class127.method2823(var55, var99, 0, var55.length - 1);
                                                         break;
                                                      }

                                                      ItemComposition var98 = MessageNode.getItemDefinition(var40);
                                                      if((!var56 || var98.field1191) && var98.field1219 == -1 && var98.name.toLowerCase().indexOf(var35) != -1) {
                                                         if(var20 >= 250) {
                                                            class12.field181 = -1;
                                                            class110.field1959 = null;
                                                            break;
                                                         }

                                                         if(var20 >= var101.length) {
                                                            short[] var42 = new short[2 * var101.length];

                                                            for(var24 = 0; var24 < var20; ++var24) {
                                                               var42[var24] = var101[var24];
                                                            }

                                                            var101 = var42;
                                                         }

                                                         var101[var20++] = (short)var40;
                                                      }

                                                      ++var40;
                                                   }

                                                   class38.field833[var5++] = class12.field181;
                                                   continue;
                                                }

                                                if(var46 == 4211) {
                                                   if(class110.field1959 != null && Client.field379 < class12.field181) {
                                                      class38.field833[var5++] = class110.field1959[++Client.field379 - 1] & '\uffff';
                                                      continue;
                                                   }

                                                   class38.field833[var5++] = -1;
                                                   continue;
                                                }

                                                if(var46 == 4212) {
                                                   Client.field379 = 0;
                                                   continue;
                                                }
                                             } else if(var46 < 5100) {
                                                if(var46 == 5000) {
                                                   class38.field833[var5++] = Client.field498;
                                                   continue;
                                                }

                                                if(var46 == 5001) {
                                                   var5 -= 3;
                                                   Client.field498 = class38.field833[var5];
                                                   Renderable.field1544 = class107.method2315(class38.field833[1 + var5]);
                                                   if(null == Renderable.field1544) {
                                                      Renderable.field1544 = class133.field2131;
                                                   }

                                                   Client.field499 = class38.field833[var5 + 2];
                                                   Client.field323.method2801(158);
                                                   Client.field323.method2513(Client.field498);
                                                   Client.field323.method2513(Renderable.field1544.field2133);
                                                   Client.field323.method2513(Client.field499);
                                                   continue;
                                                }

                                                if(var46 == 5002) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   var5 -= 2;
                                                   var39 = class38.field833[var5];
                                                   var47 = class38.field833[var5 + 1];
                                                   Client.field323.method2801(49);
                                                   Client.field323.method2513(ChatMessages.method229(var109) + 2);
                                                   Client.field323.method2519(var109);
                                                   Client.field323.method2513(var39 - 1);
                                                   Client.field323.method2513(var47);
                                                   continue;
                                                }

                                                if(var46 == 5003) {
                                                   var5 -= 2;
                                                   var15 = class38.field833[var5];
                                                   var39 = class38.field833[1 + var5];
                                                   MessageNode var95 = class160.method3210(var15, var39);
                                                   if(var95 != null) {
                                                      class38.field833[var5++] = var95.id;
                                                      class38.field833[var5++] = var95.tick;
                                                      class38.chatboxSegments[var6++] = var95.name != null?var95.name:"";
                                                      class38.chatboxSegments[var6++] = var95.sender != null?var95.sender:"";
                                                      class38.chatboxSegments[var6++] = null != var95.value?var95.value:"";
                                                   } else {
                                                      class38.field833[var5++] = -1;
                                                      class38.field833[var5++] = 0;
                                                      class38.chatboxSegments[var6++] = "";
                                                      class38.chatboxSegments[var6++] = "";
                                                      class38.chatboxSegments[var6++] = "";
                                                   }
                                                   continue;
                                                }

                                                if(var46 == 5004) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   MessageNode var64 = (MessageNode)class11.field166.method3836((long)var15);
                                                   if(var64 != null) {
                                                      class38.field833[var5++] = var64.type;
                                                      class38.field833[var5++] = var64.tick;
                                                      class38.chatboxSegments[var6++] = var64.name != null?var64.name:"";
                                                      class38.chatboxSegments[var6++] = var64.sender != null?var64.sender:"";
                                                      class38.chatboxSegments[var6++] = var64.value != null?var64.value:"";
                                                   } else {
                                                      class38.field833[var5++] = -1;
                                                      class38.field833[var5++] = 0;
                                                      class38.chatboxSegments[var6++] = "";
                                                      class38.chatboxSegments[var6++] = "";
                                                      class38.chatboxSegments[var6++] = "";
                                                   }
                                                   continue;
                                                }

                                                if(var46 == 5005) {
                                                   if(Renderable.field1544 == null) {
                                                      class38.field833[var5++] = -1;
                                                   } else {
                                                      class38.field833[var5++] = Renderable.field1544.field2133;
                                                   }
                                                   continue;
                                                }

                                                if(var46 == 5008) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   --var5;
                                                   var39 = class38.field833[var5];
                                                   var35 = var109.toLowerCase();
                                                   byte var62 = 0;
                                                   if(var35.startsWith("yellow:")) {
                                                      var62 = 0;
                                                      var109 = var109.substring("yellow:".length());
                                                   } else if(var35.startsWith("red:")) {
                                                      var62 = 1;
                                                      var109 = var109.substring("red:".length());
                                                   } else if(var35.startsWith("green:")) {
                                                      var62 = 2;
                                                      var109 = var109.substring("green:".length());
                                                   } else if(var35.startsWith("cyan:")) {
                                                      var62 = 3;
                                                      var109 = var109.substring("cyan:".length());
                                                   } else if(var35.startsWith("purple:")) {
                                                      var62 = 4;
                                                      var109 = var109.substring("purple:".length());
                                                   } else if(var35.startsWith("white:")) {
                                                      var62 = 5;
                                                      var109 = var109.substring("white:".length());
                                                   } else if(var35.startsWith("flash1:")) {
                                                      var62 = 6;
                                                      var109 = var109.substring("flash1:".length());
                                                   } else if(var35.startsWith("flash2:")) {
                                                      var62 = 7;
                                                      var109 = var109.substring("flash2:".length());
                                                   } else if(var35.startsWith("flash3:")) {
                                                      var62 = 8;
                                                      var109 = var109.substring("flash3:".length());
                                                   } else if(var35.startsWith("glow1:")) {
                                                      var62 = 9;
                                                      var109 = var109.substring("glow1:".length());
                                                   } else if(var35.startsWith("glow2:")) {
                                                      var62 = 10;
                                                      var109 = var109.substring("glow2:".length());
                                                   } else if(var35.startsWith("glow3:")) {
                                                      var62 = 11;
                                                      var109 = var109.substring("glow3:".length());
                                                   } else if(Client.field489 != 0) {
                                                      if(var35.startsWith("yellow:")) {
                                                         var62 = 0;
                                                         var109 = var109.substring("yellow:".length());
                                                      } else if(var35.startsWith("red:")) {
                                                         var62 = 1;
                                                         var109 = var109.substring("red:".length());
                                                      } else if(var35.startsWith("green:")) {
                                                         var62 = 2;
                                                         var109 = var109.substring("green:".length());
                                                      } else if(var35.startsWith("cyan:")) {
                                                         var62 = 3;
                                                         var109 = var109.substring("cyan:".length());
                                                      } else if(var35.startsWith("purple:")) {
                                                         var62 = 4;
                                                         var109 = var109.substring("purple:".length());
                                                      } else if(var35.startsWith("white:")) {
                                                         var62 = 5;
                                                         var109 = var109.substring("white:".length());
                                                      } else if(var35.startsWith("flash1:")) {
                                                         var62 = 6;
                                                         var109 = var109.substring("flash1:".length());
                                                      } else if(var35.startsWith("flash2:")) {
                                                         var62 = 7;
                                                         var109 = var109.substring("flash2:".length());
                                                      } else if(var35.startsWith("flash3:")) {
                                                         var62 = 8;
                                                         var109 = var109.substring("flash3:".length());
                                                      } else if(var35.startsWith("glow1:")) {
                                                         var62 = 9;
                                                         var109 = var109.substring("glow1:".length());
                                                      } else if(var35.startsWith("glow2:")) {
                                                         var62 = 10;
                                                         var109 = var109.substring("glow2:".length());
                                                      } else if(var35.startsWith("glow3:")) {
                                                         var62 = 11;
                                                         var109 = var109.substring("glow3:".length());
                                                      }
                                                   }

                                                   var35 = var109.toLowerCase();
                                                   byte var71 = 0;
                                                   if(var35.startsWith("wave:")) {
                                                      var71 = 1;
                                                      var109 = var109.substring("wave:".length());
                                                   } else if(var35.startsWith("wave2:")) {
                                                      var71 = 2;
                                                      var109 = var109.substring("wave2:".length());
                                                   } else if(var35.startsWith("shake:")) {
                                                      var71 = 3;
                                                      var109 = var109.substring("shake:".length());
                                                   } else if(var35.startsWith("scroll:")) {
                                                      var71 = 4;
                                                      var109 = var109.substring("scroll:".length());
                                                   } else if(var35.startsWith("slide:")) {
                                                      var71 = 5;
                                                      var109 = var109.substring("slide:".length());
                                                   } else if(Client.field489 != 0) {
                                                      if(var35.startsWith("wave:")) {
                                                         var71 = 1;
                                                         var109 = var109.substring("wave:".length());
                                                      } else if(var35.startsWith("wave2:")) {
                                                         var71 = 2;
                                                         var109 = var109.substring("wave2:".length());
                                                      } else if(var35.startsWith("shake:")) {
                                                         var71 = 3;
                                                         var109 = var109.substring("shake:".length());
                                                      } else if(var35.startsWith("scroll:")) {
                                                         var71 = 4;
                                                         var109 = var109.substring("scroll:".length());
                                                      } else if(var35.startsWith("slide:")) {
                                                         var71 = 5;
                                                         var109 = var109.substring("slide:".length());
                                                      }
                                                   }

                                                   Client.field323.method2801(157);
                                                   Client.field323.method2513(0);
                                                   var20 = Client.field323.offset;
                                                   Client.field323.method2513(var39);
                                                   Client.field323.method2513(var62);
                                                   Client.field323.method2513(var71);
                                                   class191.method3773(Client.field323, var109);
                                                   Client.field323.method2523(Client.field323.offset - var20);
                                                   continue;
                                                }

                                                if(var46 == 5009) {
                                                   var6 -= 2;
                                                   var109 = class38.chatboxSegments[var6];
                                                   var50 = class38.chatboxSegments[1 + var6];
                                                   Client.field323.method2801(167);
                                                   Client.field323.method2514(0);
                                                   var47 = Client.field323.offset;
                                                   Client.field323.method2519(var109);
                                                   class191.method3773(Client.field323, var50);
                                                   Client.field323.method2578(Client.field323.offset - var47);
                                                   continue;
                                                }

                                                if(var46 == 5015) {
                                                   if(null != WidgetNode.localPlayer && WidgetNode.localPlayer.name != null) {
                                                      var109 = WidgetNode.localPlayer.name;
                                                   } else {
                                                      var109 = "";
                                                   }

                                                   class38.chatboxSegments[var6++] = var109;
                                                   continue;
                                                }

                                                if(var46 == 5016) {
                                                   class38.field833[var5++] = Client.field499;
                                                   continue;
                                                }

                                                if(var46 == 5017) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.field833[var5++] = class154.method3187(var15);
                                                   continue;
                                                }

                                                if(var46 == 5018) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   var58 = class38.field833;
                                                   var47 = var5++;
                                                   MessageNode var104 = (MessageNode)class11.field166.method3836((long)var15);
                                                   if(var104 == null) {
                                                      var18 = -1;
                                                   } else if(var104.previous == class11.field167.field3154) {
                                                      var18 = -1;
                                                   } else {
                                                      var18 = ((MessageNode)var104.previous).id;
                                                   }

                                                   var58[var47] = var18;
                                                   continue;
                                                }

                                                if(var46 == 5019) {
                                                   --var5;
                                                   var15 = class38.field833[var5];
                                                   class38.field833[var5++] = MessageNode.method773(var15);
                                                   continue;
                                                }

                                                if(var46 == 5020) {
                                                   --var6;
                                                   var109 = class38.chatboxSegments[var6];
                                                   if(var109.equalsIgnoreCase("toggleroof")) {
                                                      class116.field2039.field131 = !class116.field2039.field131;
                                                      class79.method1710();
                                                      if(class116.field2039.field131) {
                                                         class10.sendGameMessage(99, "", "Roofs are now all hidden");
                                                      } else {
                                                         class10.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                                      }
                                                   }

                                                   if(var109.equalsIgnoreCase("displayfps")) {
                                                      Client.field296 = !Client.field296;
                                                   }

                                                   if(Client.field351 >= 2) {
                                                      if(var109.equalsIgnoreCase("fpson")) {
                                                         Client.field296 = true;
                                                      }

                                                      if(var109.equalsIgnoreCase("fpsoff")) {
                                                         Client.field296 = false;
                                                      }

                                                      if(var109.equalsIgnoreCase("gc")) {
                                                         System.gc();
                                                      }

                                                      if(var109.equalsIgnoreCase("clientdrop")) {
                                                         class151.method3162();
                                                      }

                                                      if(var109.equalsIgnoreCase("errortest") && Client.field281 == 2) {
                                                         throw new RuntimeException();
                                                      }
                                                   }

                                                   Client.field323.method2801(77);
                                                   Client.field323.method2513(var109.length() + 1);
                                                   Client.field323.method2519(var109);
                                                   continue;
                                                }

                                                if(var46 == 5021) {
                                                   --var6;
                                                   Client.field500 = class38.chatboxSegments[var6].toLowerCase().trim();
                                                   continue;
                                                }

                                                if(var46 == 5022) {
                                                   class38.chatboxSegments[var6++] = Client.field500;
                                                   continue;
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              } else {
                                 if(var46 >= 2000) {
                                    var46 -= 1000;
                                    --var5;
                                    var34 = class24.method600(class38.field833[var5]);
                                 } else {
                                    var34 = var52?FileOnDisk.field3263:class38.field829;
                                 }

                                 if(var46 == 1927) {
                                    if(class38.field835 >= 10) {
                                       throw new RuntimeException();
                                    }

                                    if(null == var34.field2902) {
                                       return;
                                    }

                                    class0 var48 = new class0();
                                    var48.field2 = var34;
                                    var48.field7 = var34.field2902;
                                    var48.field11 = 1 + class38.field835;
                                    Client.field479.method3849(var0);
                                    continue;
                                 }
                              }
                           } else {
                              if(var46 >= 2000) {
                                 var46 -= 1000;
                                 --var5;
                                 var34 = class24.method600(class38.field833[var5]);
                              } else {
                                 var34 = var52?FileOnDisk.field3263:class38.field829;
                              }

                              if(var46 == 1300) {
                                 --var5;
                                 var39 = class38.field833[var5] - 1;
                                 if(var39 >= 0 && var39 <= 9) {
                                    --var6;
                                    var34.method3451(var39, class38.chatboxSegments[var6]);
                                    continue;
                                 }

                                 --var6;
                                 continue;
                              }

                              if(var46 == 1301) {
                                 var5 -= 2;
                                 var39 = class38.field833[var5];
                                 var47 = class38.field833[var5 + 1];
                                 var34.parent = class38.method781(var39, var47);
                                 continue;
                              }

                              if(var46 == 1302) {
                                 --var5;
                                 var34.field2894 = class38.field833[var5] == 1;
                                 continue;
                              }

                              if(var46 == 1303) {
                                 --var5;
                                 var34.field2863 = class38.field833[var5];
                                 continue;
                              }

                              if(var46 == 1304) {
                                 --var5;
                                 var34.field2893 = class38.field833[var5];
                                 continue;
                              }

                              if(var46 == 1305) {
                                 --var6;
                                 var34.name = class38.chatboxSegments[var6];
                                 continue;
                              }

                              if(var46 == 1306) {
                                 --var6;
                                 var34.field2895 = class38.chatboxSegments[var6];
                                 continue;
                              }

                              if(var46 == 1307) {
                                 var34.actions = null;
                                 continue;
                              }
                           }
                        } else {
                           if(var46 >= 2000) {
                              var46 -= 1000;
                              --var5;
                              var34 = class24.method600(class38.field833[var5]);
                           } else {
                              var34 = var52?FileOnDisk.field3263:class38.field829;
                           }

                           class53.method1101(var34);
                           if(var46 == 1200 || var46 == 1205 || var46 == 1212) {
                              var5 -= 2;
                              var39 = class38.field833[var5];
                              var47 = class38.field833[var5 + 1];
                              var34.item = var39;
                              var34.stackSize = var47;
                              ItemComposition var85 = MessageNode.getItemDefinition(var39);
                              var34.rotationX = var85.field1215;
                              var34.rotationZ = var85.field1193;
                              var34.rotationY = var85.field1194;
                              var34.field2865 = var85.field1177;
                              var34.field2843 = var85.field1216;
                              var34.field2870 = var85.field1232;
                              if(var46 == 1205) {
                                 var34.field2874 = 0;
                              } else if(var46 == 1212 | var85.isStackable == 1) {
                                 var34.field2874 = 1;
                              } else {
                                 var34.field2874 = 2;
                              }

                              if(var34.field2847 > 0) {
                                 var34.field2870 = var34.field2870 * 32 / var34.field2847;
                              } else if(var34.field2827 > 0) {
                                 var34.field2870 = var34.field2870 * 32 / var34.field2827;
                              }
                              continue;
                           }

                           if(var46 == 1201) {
                              var34.modelType = 2;
                              --var5;
                              var34.modelId = class38.field833[var5];
                              continue;
                           }

                           if(var46 == 1202) {
                              var34.modelType = 3;
                              var34.modelId = WidgetNode.localPlayer.composition.method3526();
                              continue;
                           }
                        }
                     } else {
                        var39 = -1;
                        if(var46 >= 2000) {
                           var46 -= 1000;
                           --var5;
                           var39 = class38.field833[var5];
                           var34 = class24.method600(var39);
                        } else {
                           var34 = var52?FileOnDisk.field3263:class38.field829;
                        }

                        if(var46 == 1100) {
                           var5 -= 2;
                           var34.itemId = class38.field833[var5];
                           if(var34.itemId > var34.scrollWidth - var34.width) {
                              var34.itemId = var34.scrollWidth - var34.width;
                           }

                           if(var34.itemId < 0) {
                              var34.itemId = 0;
                           }

                           var34.scrollY = class38.field833[var5 + 1];
                           if(var34.scrollY > var34.scrollHeight - var34.height) {
                              var34.scrollY = var34.scrollHeight - var34.height;
                           }

                           if(var34.scrollY < 0) {
                              var34.scrollY = 0;
                           }

                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1101) {
                           --var5;
                           var34.textColor = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1102) {
                           --var5;
                           var34.field2811 = class38.field833[var5] == 1;
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1103) {
                           --var5;
                           var34.opacity = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1104) {
                           --var5;
                           var34.field2849 = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1105) {
                           --var5;
                           var34.textureId = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1106) {
                           --var5;
                           var34.field2807 = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1107) {
                           --var5;
                           var34.field2845 = class38.field833[var5] == 1;
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1108) {
                           var34.modelType = 1;
                           --var5;
                           var34.modelId = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1109) {
                           var5 -= 6;
                           var34.field2865 = class38.field833[var5];
                           var34.field2843 = class38.field833[1 + var5];
                           var34.rotationX = class38.field833[2 + var5];
                           var34.rotationZ = class38.field833[3 + var5];
                           var34.rotationY = class38.field833[var5 + 4];
                           var34.field2870 = class38.field833[5 + var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1110) {
                           --var5;
                           var47 = class38.field833[var5];
                           if(var47 != var34.field2938) {
                              var34.field2938 = var47;
                              var34.field2862 = 0;
                              var34.field2825 = 0;
                              class53.method1101(var34);
                           }
                           continue;
                        }

                        if(var46 == 1111) {
                           --var5;
                           var34.field2873 = class38.field833[var5] == 1;
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1112) {
                           --var6;
                           var35 = class38.chatboxSegments[var6];
                           if(!var35.equals(var34.text)) {
                              var34.text = var35;
                              class53.method1101(var34);
                           }
                           continue;
                        }

                        if(var46 == 1113) {
                           --var5;
                           var34.field2924 = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1114) {
                           var5 -= 3;
                           var34.field2879 = class38.field833[var5];
                           var34.field2880 = class38.field833[1 + var5];
                           var34.field2878 = class38.field833[2 + var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1115) {
                           --var5;
                           var34.field2881 = class38.field833[var5] == 1;
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1116) {
                           --var5;
                           var34.borderThickness = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1117) {
                           --var5;
                           var34.sprite2 = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1118) {
                           --var5;
                           var34.flippedVertically = class38.field833[var5] == 1;
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1119) {
                           --var5;
                           var34.flippedHorizontally = class38.field833[var5] == 1;
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1120) {
                           var5 -= 2;
                           var34.scrollWidth = class38.field833[var5];
                           var34.scrollHeight = class38.field833[1 + var5];
                           class53.method1101(var34);
                           if(var39 != -1 && var34.type == 0) {
                              class10.method136(Widget.widgets[var39 >> 16], var34, false);
                           }
                           continue;
                        }

                        if(var46 == 1121) {
                           method6(var34.id, var34.index);
                           Client.field444 = var34;
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1122) {
                           --var5;
                           var34.field2850 = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1123) {
                           --var5;
                           var34.field2861 = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1124) {
                           --var5;
                           var34.field2848 = class38.field833[var5];
                           class53.method1101(var34);
                           continue;
                        }

                        if(var46 == 1125) {
                           --var5;
                           var47 = class38.field833[var5];
                           class85[] var38 = new class85[]{class85.field1508, class85.field1505, class85.field1514, class85.field1507, class85.field1504};
                           class85 var37 = (class85)class54.method1117(var38, var47);
                           if(var37 != null) {
                              var34.field2910 = var37;
                              class53.method1101(var34);
                           }
                           continue;
                        }
                     }
                  } else {
                     var15 = -1;
                     if(var46 >= 2000) {
                        var46 -= 1000;
                        --var5;
                        var15 = class38.field833[var5];
                        var16 = class24.method600(var15);
                     } else {
                        var16 = var52?FileOnDisk.field3263:class38.field829;
                     }

                     if(var46 == 1000) {
                        var5 -= 4;
                        var16.field2830 = class38.field833[var5];
                        var16.field2896 = class38.field833[var5 + 1];
                        var16.field2866 = class38.field833[var5 + 2];
                        var16.field2822 = class38.field833[var5 + 3];
                        class53.method1101(var16);
                        Player.method38(var16);
                        if(var15 != -1 && var16.type == 0) {
                           class10.method136(Widget.widgets[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var46 == 1001) {
                        var5 -= 4;
                        var16.field2827 = class38.field833[var5];
                        var16.field2828 = class38.field833[var5 + 1];
                        var16.field2823 = class38.field833[2 + var5];
                        var16.field2824 = class38.field833[var5 + 3];
                        class53.method1101(var16);
                        Player.method38(var16);
                        if(var15 != -1 && var16.type == 0) {
                           class10.method136(Widget.widgets[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var46 == 1003) {
                        --var5;
                        var17 = class38.field833[var5] == 1;
                        if(var16.isHidden != var17) {
                           var16.isHidden = var17;
                           class53.method1101(var16);
                        }
                        continue;
                     }

                     if(var46 == 1005) {
                        --var5;
                        var16.field2949 = class38.field833[var5] == 1;
                        continue;
                     }

                     if(var46 == 1006) {
                        --var5;
                        var16.field2854 = class38.field833[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var46 < 5400) {
                  if(var46 == 5306) {
                     class38.field833[var5++] = class23.method586();
                     continue;
                  }

                  if(var46 == 5307) {
                     --var5;
                     var15 = class38.field833[var5];
                     if(var15 == 1 || var15 == 2) {
                        WidgetNode.method45(var15);
                     }
                     continue;
                  }

                  if(var46 == 5308) {
                     class38.field833[var5++] = class116.field2039.field134;
                     continue;
                  }

                  if(var46 == 5309) {
                     --var5;
                     var15 = class38.field833[var5];
                     if(var15 == 1 || var15 == 2) {
                        class116.field2039.field134 = var15;
                        class79.method1710();
                     }
                     continue;
                  }
               }

               if(var46 < 5600) {
                  if(var46 == 5504) {
                     var5 -= 2;
                     var15 = class38.field833[var5];
                     var39 = class38.field833[var5 + 1];
                     if(!Client.field528) {
                        Client.field366 = var15;
                        Client.mapAngle = var39;
                     }
                     continue;
                  }

                  if(var46 == 5505) {
                     class38.field833[var5++] = Client.field366;
                     continue;
                  }

                  if(var46 == 5506) {
                     class38.field833[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var46 == 5530) {
                     --var5;
                     var15 = class38.field833[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     Client.field372 = var15;
                     continue;
                  }

                  if(var46 == 5531) {
                     class38.field833[var5++] = Client.field372;
                     continue;
                  }
               }

               if(var46 < 5700 && var46 == 5630) {
                  Client.field333 = 250;
               } else {
                  if(var46 < 6300) {
                     if(var46 == 6200) {
                        var5 -= 2;
                        Client.field535 = (short)class38.field833[var5];
                        if(Client.field535 <= 0) {
                           Client.field535 = 256;
                        }

                        Client.field368 = (short)class38.field833[1 + var5];
                        if(Client.field368 <= 0) {
                           Client.field368 = 205;
                        }
                        continue;
                     }

                     if(var46 == 6201) {
                        var5 -= 2;
                        Client.field537 = (short)class38.field833[var5];
                        if(Client.field537 <= 0) {
                           Client.field537 = 256;
                        }

                        Client.field530 = (short)class38.field833[1 + var5];
                        if(Client.field530 <= 0) {
                           Client.field530 = 320;
                        }
                        continue;
                     }

                     if(var46 == 6202) {
                        var5 -= 4;
                        Client.field284 = (short)class38.field833[var5];
                        if(Client.field284 <= 0) {
                           Client.field284 = 1;
                        }

                        Client.field540 = (short)class38.field833[var5 + 1];
                        if(Client.field540 <= 0) {
                           Client.field540 = 32767;
                        } else if(Client.field540 < Client.field284) {
                           Client.field540 = Client.field284;
                        }

                        Client.field541 = (short)class38.field833[2 + var5];
                        if(Client.field541 <= 0) {
                           Client.field541 = 1;
                        }

                        Client.field542 = (short)class38.field833[3 + var5];
                        if(Client.field542 <= 0) {
                           Client.field542 = 32767;
                        } else if(Client.field542 < Client.field541) {
                           Client.field542 = Client.field541;
                        }
                        continue;
                     }

                     if(var46 == 6203) {
                        if(null != Client.field452) {
                           class110.method2404(0, 0, Client.field452.width, Client.field452.height, false);
                           class38.field833[var5++] = Client.camera2;
                           class38.field833[var5++] = Client.camera3;
                        } else {
                           class38.field833[var5++] = -1;
                           class38.field833[var5++] = -1;
                        }
                        continue;
                     }

                     if(var46 == 6204) {
                        class38.field833[var5++] = Client.field537;
                        class38.field833[var5++] = Client.field530;
                        continue;
                     }

                     if(var46 == 6205) {
                        class38.field833[var5++] = Client.field535;
                        class38.field833[var5++] = Client.field368;
                        continue;
                     }
                  }

                  if(var46 < 6600) {
                     if(var46 == 6500) {
                        class38.field833[var5++] = class18.loadWorlds()?1:0;
                        continue;
                     }

                     World var113;
                     if(var46 == 6501) {
                        World.field658 = 0;
                        var113 = XClanMember.method606();
                        if(var113 != null) {
                           class38.field833[var5++] = var113.id;
                           class38.field833[var5++] = var113.mask;
                           class38.chatboxSegments[var6++] = var113.activity;
                           class38.field833[var5++] = var113.location;
                           class38.field833[var5++] = var113.playerCount;
                           class38.chatboxSegments[var6++] = var113.address;
                        } else {
                           class38.field833[var5++] = -1;
                           class38.field833[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field833[var5++] = 0;
                           class38.field833[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var46 == 6502) {
                        var113 = XClanMember.method606();
                        if(var113 != null) {
                           class38.field833[var5++] = var113.id;
                           class38.field833[var5++] = var113.mask;
                           class38.chatboxSegments[var6++] = var113.activity;
                           class38.field833[var5++] = var113.location;
                           class38.field833[var5++] = var113.playerCount;
                           class38.chatboxSegments[var6++] = var113.address;
                        } else {
                           class38.field833[var5++] = -1;
                           class38.field833[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field833[var5++] = 0;
                           class38.field833[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     World var68;
                     if(var46 == 6506) {
                        --var5;
                        var15 = class38.field833[var5];
                        var68 = null;

                        for(var47 = 0; var47 < World.field659; ++var47) {
                           if(World.worldList[var47].id == var15) {
                              var68 = World.worldList[var47];
                              break;
                           }
                        }

                        if(var68 != null) {
                           class38.field833[var5++] = var68.id;
                           class38.field833[var5++] = var68.mask;
                           class38.chatboxSegments[var6++] = var68.activity;
                           class38.field833[var5++] = var68.location;
                           class38.field833[var5++] = var68.playerCount;
                           class38.chatboxSegments[var6++] = var68.address;
                        } else {
                           class38.field833[var5++] = -1;
                           class38.field833[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field833[var5++] = 0;
                           class38.field833[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var46 == 6507) {
                        var5 -= 4;
                        var15 = class38.field833[var5];
                        var100 = class38.field833[var5 + 1] == 1;
                        var47 = class38.field833[var5 + 2];
                        var56 = class38.field833[var5 + 3] == 1;
                        class109.method2398(var15, var100, var47, var56);
                        continue;
                     }

                     if(var46 == 6511) {
                        --var5;
                        var15 = class38.field833[var5];
                        if(var15 >= 0 && var15 < World.field659) {
                           var68 = World.worldList[var15];
                           class38.field833[var5++] = var68.id;
                           class38.field833[var5++] = var68.mask;
                           class38.chatboxSegments[var6++] = var68.activity;
                           class38.field833[var5++] = var68.location;
                           class38.field833[var5++] = var68.playerCount;
                           class38.chatboxSegments[var6++] = var68.address;
                           continue;
                        }

                        class38.field833[var5++] = -1;
                        class38.field833[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field833[var5++] = 0;
                        class38.field833[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var45) {
            StringBuilder var44 = new StringBuilder(30);
            var44.append("").append(var4.hash).append(" ");

            for(var13 = class38.field824 - 1; var13 >= 0; --var13) {
               var44.append("").append(class38.field838[var13].field210.hash).append(" ");
            }

            var44.append("").append(var10);
            class128.method2843(var44.toString(), var45);
         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)LBufferProvider;",
      garbageValue = "-1564022518"
   )
   public static BufferProvider method10(int var0, int var1, Component var2) {
      try {
         MainBufferProvider var3 = new MainBufferProvider();
         var3.init(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         SecondaryBufferProvider var4 = new SecondaryBufferProvider();
         var4.init(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1825207492"
   )
   public static void method11() {
      Sequence.field1011.reset();
      Sequence.field1012.reset();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILclass110;LCollisionData;B)Z",
      garbageValue = "97"
   )
   public static final boolean method12(int var0, int var1, class110 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class109.field1949[var6][var7] = 99;
      class109.field1950[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class109.field1953[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class109.field1954[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class109.field1953[var11];
         var5 = class109.field1954[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2408(1, var4, var5, var3)) {
            class35.field800 = var4;
            class109.field1948 = var5;
            return true;
         }

         int var15 = class109.field1950[var16][var17] + 1;
         if(var16 > 0 && class109.field1949[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class109.field1953[var18] = var4 - 1;
            class109.field1954[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1949[var16 - 1][var17] = 2;
            class109.field1950[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class109.field1949[1 + var16][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class109.field1953[var18] = var4 + 1;
            class109.field1954[var18] = var5;
            var18 = 1 + var18 & 4095;
            class109.field1949[1 + var16][var17] = 8;
            class109.field1950[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class109.field1949[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1953[var18] = var4;
            class109.field1954[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1949[var16][var17 - 1] = 1;
            class109.field1950[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class109.field1949[var16][1 + var17] == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1953[var18] = var4;
            class109.field1954[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class109.field1949[var16][var17 + 1] = 4;
            class109.field1950[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class109.field1949[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1953[var18] = var4 - 1;
            class109.field1954[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1949[var16 - 1][var17 - 1] = 3;
            class109.field1950[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class109.field1949[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class109.field1953[var18] = 1 + var4;
            class109.field1954[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1949[var16 + 1][var17 - 1] = 9;
            class109.field1950[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class109.field1949[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class109.field1953[var18] = var4 - 1;
            class109.field1954[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1949[var16 - 1][1 + var17] = 6;
            class109.field1950[var16 - 1][1 + var17] = var15;
         }

         if(var16 < 127 && var17 < 127 && class109.field1949[1 + var16][1 + var17] == 0 && (var12[1 + var13][1 + var14] & 19136992) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class109.field1953[var18] = var4 + 1;
            class109.field1954[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1949[1 + var16][var17 + 1] = 12;
            class109.field1950[1 + var16][1 + var17] = var15;
         }
      }

      class35.field800 = var4;
      class109.field1948 = var5;
      return false;
   }
}
