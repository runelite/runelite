import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class79 {
   @ObfuscatedName("ep")
   static SpritePixels[] field1428;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1139030533
   )
   static int field1429;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -57766495
   )
   static int field1430;
   @ObfuscatedName("v")
   static int[] field1431;
   @ObfuscatedName("b")
   static int[] field1432;
   @ObfuscatedName("cv")
   static class227 field1434;
   @ObfuscatedName("r")
   static int[] field1435;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -436432389
   )
   static int field1437;
   @ObfuscatedName("gb")
   static Widget field1439;

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "255586418"
   )
   static final void method1695(Widget var0, int var1, int var2) {
      if(Client.field452 == null && !Client.isMenuOpen) {
         if(null != var0) {
            Widget var5 = var0;
            int var8 = class49.method992(class93.method2130(var0));
            Widget var4;
            int var7;
            if(var8 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if(var7 >= var8) {
                     var4 = var5;
                     break;
                  }

                  var5 = class153.method3170(var5.parentId);
                  if(null == var5) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            Widget var6 = var4;
            if(null == var4) {
               var6 = var0.parent;
            }

            if(var6 != null) {
               Client.field452 = var0;
               var5 = var0;
               var8 = class49.method992(class93.method2130(var0));
               if(var8 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if(var7 >= var8) {
                        var4 = var5;
                        break;
                     }

                     var5 = class153.method3170(var5.parentId);
                     if(null == var5) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var6 = var4;
               if(null == var4) {
                  var6 = var0.parent;
               }

               Client.field453 = var6;
               Client.field521 = var1;
               Client.field455 = var2;
               GameEngine.field2256 = 0;
               Client.field463 = false;
               if(Client.menuOptionCount > 0) {
                  int var9 = Client.menuOptionCount - 1;
                  class23.field603 = new class32();
                  class23.field603.field718 = Client.menuActionParams0[var9];
                  class23.field603.field714 = Client.menuActionParams1[var9];
                  class23.field603.field708 = Client.menuTypes[var9];
                  class23.field603.field710 = Client.menuIdentifiers[var9];
                  class23.field603.field709 = Client.menuOptions[var9];
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1494434143"
   )
   static boolean method1725(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIILRegion;[LCollisionData;B)V",
      garbageValue = "-90"
   )
   static final void method1727(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2546();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2546();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.method2656();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var2 + var10;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class5.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               ItemComposition.method1112(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }
}
