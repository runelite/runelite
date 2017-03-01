import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2115574499
   )
   int field1551;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -416058405
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2185365
   )
   int field1555;
   @ObfuscatedName("p")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 302568721
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 812481629
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 694436291
   )
   int field1562 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1707502645
   )
   @Export("floor")
   int floor;

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "12"
   )
   static final void method1981() {
      int var0 = class162.menuX;
      int var1 = class160.menuY;
      int var2 = class41.menuWidth;
      int var3 = XItemContainer.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4056(var0, var1, var2, var3, var4);
      Rasterizer2D.method4056(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.method4012(1 + var0, 18 + var1, var2 - 2, var3 - 19, 0);
      class217.field3188.method3973("Choose Option", 3 + var0, var1 + 14, var4, -1);
      int var5 = class115.field1805;
      int var6 = class115.field1806;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = 31 + var1 + (Client.menuOptionCount - 1 - var7) * 15;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         Font var10 = class217.field3188;
         String var11;
         if(var7 < 0) {
            var11 = "";
         } else if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method3973(var11, 3 + var0, var8, var9, 0);
      }

      class13.method187(class162.menuX, class160.menuY, class41.menuWidth, XItemContainer.menuHeight);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-38"
   )
   public static void method1982(int var0) {
      class138.field1921 = 1;
      class138.field1924 = null;
      class168.field2193 = -1;
      class138.field1922 = -1;
      class101.field1661 = 0;
      class138.field1923 = false;
      class178.field2678 = var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-12842633"
   )
   static final void method1983(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = ChatMessages.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.sizeX;
         var11 = var9.sizeY;
      } else {
         var10 = var9.sizeY;
         var11 = var9.sizeX;
      }

      int var12;
      int var13;
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var11 + var3 <= 104) {
         var14 = (var11 >> 1) + var3;
         var15 = (var11 + 1 >> 1) + var3;
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class10.tileHeights[var1];
      int var17 = var16[var13][var15] + var16[var12][var15] + var16[var13][var14] + var16[var12][var14] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var11 << 6) + (var3 << 7);
      int var20 = 1073741824 + var2 + (var3 << 7) + (var4 << 14);
      if(var9.field2917 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = var6 + (var5 << 6);
      if(var9.field2938 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method3692(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class49(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.field2915 == 1) {
            var8.method2347(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method3692(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method1828(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.field2915 != 0) {
               var8.method2358(var2, var3, var10, var11, var9.field2936);
            }

         } else if(var6 == 0) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method3692(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method1899(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field85[var5], 0, var20, var21);
            if(var9.field2915 != 0) {
               var8.method2344(var2, var3, var6, var5, var9.field2936);
            }

         } else if(var6 == 1) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method3692(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method1899(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field79[var5], 0, var20, var21);
            if(var9.field2915 != 0) {
               var8.method2344(var2, var3, var6, var5, var9.field2936);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var28;
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var28 = var9.method3692(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method3692(2, var27, var16, var18, var17, var19);
               } else {
                  var28 = new class49(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new class49(var4, 2, var27, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method1899(var0, var2, var3, var17, (Renderable)var28, (Renderable)var24, class10.field85[var5], class10.field85[var27], var20, var21);
               if(var9.field2915 != 0) {
                  var8.method2344(var2, var3, var6, var5, var9.field2936);
               }

            } else if(var6 == 3) {
               if(var9.animationId == -1 && null == var9.impostorIds) {
                  var22 = var9.method3692(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method1899(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field79[var5], 0, var20, var21);
               if(var9.field2915 != 0) {
                  var8.method2344(var2, var3, var6, var5, var9.field2936);
               }

            } else if(var6 == 9) {
               if(var9.animationId == -1 && null == var9.impostorIds) {
                  var22 = var9.method3692(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method1828(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.field2915 != 0) {
                  var8.method2358(var2, var3, var10, var11, var9.field2936);
               }

            } else if(var6 == 4) {
               if(var9.animationId == -1 && null == var9.impostorIds) {
                  var22 = var9.method3692(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method1799(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field85[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var27 = 16;
                  var23 = var7.method1815(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = ChatMessages.getObjectDefinition(var23 >> 14 & 32767).field2922;
                  }

                  if(var9.animationId == -1 && null == var9.impostorIds) {
                     var24 = var9.method3692(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method1799(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class10.field85[var5], 0, class10.field81[var5] * var27, class10.field88[var5] * var27, var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var23 = var7.method1815(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = ChatMessages.getObjectDefinition(var23 >> 14 & 32767).field2922 / 2;
                  }

                  if(var9.animationId == -1 && null == var9.impostorIds) {
                     var24 = var9.method3692(4, 4 + var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method1799(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, class10.field93[var5] * var27, var27 * class10.field90[var5], var20, var21);
               } else if(var6 == 7) {
                  var23 = 2 + var5 & 3;
                  if(var9.animationId == -1 && null == var9.impostorIds) {
                     var22 = var9.method3692(4, var23 + 4, var16, var18, var17, var19);
                  } else {
                     var22 = new class49(var4, 4, var23 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method1799(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var23 = var7.method1815(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = ChatMessages.getObjectDefinition(var23 >> 14 & 32767).field2922 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.animationId == -1 && null == var9.impostorIds) {
                     var24 = var9.method3692(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method3692(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, 4 + var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new class49(var4, 4, 4 + var26, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method1799(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class10.field93[var5], var27 * class10.field90[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.animationId == -1 && null == var9.impostorIds) {
            var22 = var9.method3692(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class49(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method1828(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.field2915 != 0) {
            var8.method2358(var2, var3, var10, var11, var9.field2936);
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "474369047"
   )
   static int method1984(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2437((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "413244716"
   )
   public static synchronized long method1985() {
      long var0 = System.currentTimeMillis();
      if(var0 < class155.field2102) {
         class155.field2107 += class155.field2102 - var0;
      }

      class155.field2102 = var0;
      return class155.field2107 + var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   public static void method1986() {
      class225.field3236 = null;
      class145.field2013 = null;
      class186.field2775 = null;
      class225.field3235 = null;
      class225.field3237 = null;
      Ignore.field211 = null;
   }
}
