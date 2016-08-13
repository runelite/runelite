import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -265715
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 314188497
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1041734195
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 569320307
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -835877039
   )
   int field1668;
   @ObfuscatedName("qh")
   protected static class136 field1669;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 1541264873
   )
   @Export("cameraY")
   static int cameraY;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-2011661079"
   )
   static final void method2252(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2633();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var12 = class5.tileHeights[0][var2];
                  int var9 = var4 + 932731 + var2;
                  int var10 = 556238 + var3 + var5;
                  int var11 = class144.method3126(var9 + '넵', 91923 + var10, 4) - 128 + (class144.method3126(var9 + 10294, '鎽' + var10, 2) - 128 >> 1) + (class144.method3126(var9, var10, 1) - 128 >> 2);
                  var11 = 35 + (int)(0.3D * (double)var11);
                  if(var11 < 10) {
                     var11 = 10;
                  } else if(var11 > 60) {
                     var11 = 60;
                  }

                  var12[var3] = -var11 * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2633();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class75.field1422[var1][var2][var3] = var0.method2634();
               class5.field88[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field86[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field82[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2633();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2633();
               break;
            }

            if(var7 <= 49) {
               var0.method2633();
            }
         }
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-699890278"
   )
   static final void method2253() {
      boolean var0 = false;

      int var1;
      int var2;
      while(!var0) {
         var0 = true;

         for(var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[1 + var1] > 1000) {
               String var3 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[1 + var1];
               Client.menuTargets[1 + var1] = var3;
               String var4 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[1 + var1];
               Client.menuOptions[1 + var1] = var4;
               var2 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var2;
               var2 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[var1 + 1] = var2;
               var2 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               Client.menuActionParams1[var1 + 1] = var2;
               var2 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var2;
               var0 = false;
            }
         }
      }

      if(null == class23.field614 && null == Client.field466) {
         int var7 = class143.field2217;
         int var5;
         int var6;
         int var14;
         int var15;
         if(Client.isMenuOpen) {
            if(var7 != 1 && (class214.field3188 || var7 != 4)) {
               var1 = class143.field2206;
               var14 = class143.field2209;
               if(var1 < class13.menuX - 10 || var1 > class13.menuX + Item.menuWidth + 10 || var14 < class14.menuY - 10 || var14 > class77.menuHeight + class14.menuY + 10) {
                  Client.isMenuOpen = false;
                  class51.method1082(class13.menuX, class14.menuY, Item.menuWidth, class77.menuHeight);
               }
            }

            if(var7 == 1 || !class214.field3188 && var7 == 4) {
               var1 = class13.menuX;
               var14 = class14.menuY;
               var15 = Item.menuWidth;
               var2 = class143.field2215;
               var6 = class143.field2216;
               var5 = -1;

               int var17;
               int var19;
               for(var17 = 0; var17 < Client.menuOptionCount; ++var17) {
                  var19 = (Client.menuOptionCount - 1 - var17) * 15 + var14 + 31;
                  if(var2 > var1 && var2 < var15 + var1 && var6 > var19 - 13 && var6 < var19 + 3) {
                     var5 = var17;
                  }
               }

               if(var5 != -1 && var5 >= 0) {
                  var17 = Client.menuActionParams0[var5];
                  var19 = Client.menuActionParams1[var5];
                  int var10 = Client.menuTypes[var5];
                  int var11 = Client.menuIdentifiers[var5];
                  String var12 = Client.menuOptions[var5];
                  String var13 = Client.menuTargets[var5];
                  class51.menuAction(var17, var19, var10, var11, var12, var13, class143.field2215, class143.field2216);
               }

               Client.isMenuOpen = false;
               class51.method1082(class13.menuX, class14.menuY, Item.menuWidth, class77.menuHeight);
            }
         } else {
            if((var7 == 1 || !class214.field3188 && var7 == 4) && Client.menuOptionCount > 0) {
               var1 = Client.menuTypes[Client.menuOptionCount - 1];
               if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                  label238: {
                     var14 = Client.menuActionParams0[Client.menuOptionCount - 1];
                     var15 = Client.menuActionParams1[Client.menuOptionCount - 1];
                     Widget var8 = class134.method2983(var15);
                     if(!class167.method3373(Player.method39(var8))) {
                        var5 = Player.method39(var8);
                        boolean var9 = (var5 >> 29 & 1) != 0;
                        if(!var9) {
                           break label238;
                        }
                     }

                     if(class23.field614 != null && !Client.field413 && Client.field412 != 1 && !ChatLineBuffer.method680(Client.menuOptionCount - 1) && Client.menuOptionCount > 0) {
                        var6 = Client.field410;
                        var5 = Client.field322;
                        class132.method2973(class75.field1423, var6, var5);
                        class75.field1423 = null;
                     }

                     Client.field413 = false;
                     Client.field414 = 0;
                     if(null != class23.field614) {
                        class79.method1777(class23.field614);
                     }

                     class23.field614 = class134.method2983(var15);
                     Client.field409 = var14;
                     Client.field410 = class143.field2215;
                     Client.field322 = class143.field2216;
                     if(Client.menuOptionCount > 0) {
                        var6 = Client.menuOptionCount - 1;
                        class75.field1423 = new class32();
                        class75.field1423.field729 = Client.menuActionParams0[var6];
                        class75.field1423.field739 = Client.menuActionParams1[var6];
                        class75.field1423.field737 = Client.menuTypes[var6];
                        class75.field1423.field732 = Client.menuIdentifiers[var6];
                        class75.field1423.field733 = Client.menuOptions[var6];
                     }

                     class79.method1777(class23.field614);
                     return;
                  }
               }
            }

            if((var7 == 1 || !class214.field3188 && var7 == 4) && (Client.field412 == 1 && Client.menuOptionCount > 2 || ChatLineBuffer.method680(Client.menuOptionCount - 1))) {
               var7 = 2;
            }

            if((var7 == 1 || !class214.field3188 && var7 == 4) && Client.menuOptionCount > 0) {
               var1 = Client.menuOptionCount - 1;
               if(var1 >= 0) {
                  var14 = Client.menuActionParams0[var1];
                  var15 = Client.menuActionParams1[var1];
                  var2 = Client.menuTypes[var1];
                  var6 = Client.menuIdentifiers[var1];
                  String var16 = Client.menuOptions[var1];
                  String var18 = Client.menuTargets[var1];
                  class51.menuAction(var14, var15, var2, var6, var16, var18, class143.field2215, class143.field2216);
               }
            }

            if(var7 == 2 && Client.menuOptionCount > 0) {
               class172.method3514(class143.field2215, class143.field2216);
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "1308784348"
   )
   static void method2254(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2254(var0, var1, var2, var5 - 1);
         method2254(var0, var1, var5 + 1, var3);
      }

   }
}
