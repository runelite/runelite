import java.awt.Container;
import java.awt.Insets;
import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("an")
   static class102 field188;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 445722813
   )
   int field189;
   @ObfuscatedName("h")
   boolean field190 = false;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1446149569
   )
   @Export("id")
   int id;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-1930373609"
   )
   static void method189(File var0) {
      class107.field1732 = var0;
      if(!class107.field1732.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1731 = true;
      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-532700281"
   )
   static final void method190(int var0, int var1) {
      int var2 = NPC.field786.method3921("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         Font var4 = NPC.field786;
         String var8;
         if(var3 < 0) {
            var8 = "";
         } else if(Client.menuTargets[var3].length() > 0) {
            var8 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var8 = Client.menuOptions[var3];
         }

         int var6 = var4.method3921(var8);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = 22 + Client.menuOptionCount * 15;
      int var7 = var0 - var2 / 2;
      if(var2 + var7 > class32.field758) {
         var7 = class32.field758 - var2;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class47.field950) {
         var5 = class47.field950 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      class48.region.method1871(WallObject.plane, var0, var1, false);
      Client.isMenuOpen = true;
      class6.menuX = var7;
      class10.menuY = var5;
      class107.menuWidth = var2;
      Player.menuHeight = Client.menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-721425020"
   )
   static final void method191() {
      int var0 = class6.menuX;
      int var1 = class10.menuY;
      int var2 = class107.menuWidth;
      int var3 = Player.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4011(var0, var1, var2, var3, var4);
      Rasterizer2D.method4011(1 + var0, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.method4017(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      NPC.field786.method3898("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class115.field1792;
      int var6 = class115.field1799;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = (Client.menuOptionCount - 1 - var7) * 15 + 31 + var1;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         Font var10 = NPC.field786;
         String var11;
         if(var7 < 0) {
            var11 = "";
         } else if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method3898(var11, var0 + 3, var8, var9, 0);
      }

      class31.method710(class6.menuX, class10.menuY, class107.menuWidth, Player.menuHeight);
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   static final boolean method192() {
      return Client.menuOptionCount <= 0?false:Client.field453 && class105.field1713[81] && Client.field433 != -1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-677627135"
   )
   static void method193() {
      Client var0 = Client.field508;
      synchronized(Client.field508) {
         Container var1 = Client.field508.method2177();
         if(var1 != null) {
            class49.field976 = Math.max(var1.getSize().width, Actor.field683);
            class26.field619 = Math.max(var1.getSize().height, class103.field1683);
            Insets var2;
            if(class3.field39 == var1) {
               var2 = class3.field39.getInsets();
               class49.field976 -= var2.left + var2.right;
               class26.field619 -= var2.top + var2.bottom;
            }

            if(class49.field976 <= 0) {
               class49.field976 = 1;
            }

            if(class26.field619 <= 0) {
               class26.field619 = 1;
            }

            if(class8.method97() == 1) {
               class32.field758 = Client.field563;
               class47.field950 = Client.field521;
            } else {
               class32.field758 = Math.min(class49.field976, 7680);
               class47.field950 = Math.min(class26.field619, 2160);
            }

            GameEngine.field1777 = (class49.field976 - class32.field758) / 2;
            GameEngine.field1784 = 0;
            GameObject.canvas.setSize(class32.field758, class47.field950);
            CombatInfo1.bufferProvider = Varbit.method3558(class32.field758, class47.field950, GameObject.canvas);
            if(class3.field39 == var1) {
               var2 = class3.field39.getInsets();
               GameObject.canvas.setLocation(var2.left + GameEngine.field1777, var2.top + GameEngine.field1784);
            } else {
               GameObject.canvas.setLocation(GameEngine.field1777, GameEngine.field1784);
            }

            class142.method2714();
            if(Client.widgetRoot != -1) {
               CombatInfoListHolder.method797(true);
            }

            class26.method611();
         }
      }
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "535779556"
   )
   static final void method194(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class48.region.method1773(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class48.region.method1777(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class16.field183.image;
         var11 = 24624 + var1 * 4 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class187.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            ModIcon var14 = class31.field741[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method4122(var1 * 4 + 48 + var15, var16 + 4 * (104 - var2 - var13.sizeY) + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + var11 + 1536] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }
         }
      }

      var5 = class48.region.method1878(var0, var1, var2);
      if(var5 != 0) {
         var6 = class48.region.method1777(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class187.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            ModIcon var19 = class31.field741[var23.mapSceneId];
            if(var19 != null) {
               var12 = (var23.sizeX * 4 - var19.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var19.height) / 2;
               var19.method4122(48 + var1 * 4 + var12, 4 * (104 - var2 - var23.sizeY) + 48 + var18);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var17 = class16.field183.image;
            var18 = 4 * var1 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var17[var18] = var11;
               var17[1 + 512 + var18] = var11;
               var17[2 + 1024 + var18] = var11;
               var17[var18 + 1536 + 3] = var11;
            } else {
               var17[1536 + var18] = var11;
               var17[1 + var18 + 1024] = var11;
               var17[2 + 512 + var18] = var11;
               var17[3 + var18] = var11;
            }
         }
      }

      var5 = class48.region.method1776(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = class187.getObjectDefinition(var6);
         if(var20.mapSceneId != -1) {
            ModIcon var21 = class31.field741[var20.mapSceneId];
            if(null != var21) {
               var9 = (var20.sizeX * 4 - var21.originalWidth) / 2;
               int var22 = (var20.sizeY * 4 - var21.height) / 2;
               var21.method4122(var9 + var1 * 4 + 48, var22 + 48 + (104 - var2 - var20.sizeY) * 4);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1112884980"
   )
   public static int method195() {
      return ++class115.mouseIdleTicks - 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "-487776779"
   )
   static int method196(int var0, class48 var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class179.method3296(class32.field747[--class103.field1686]);
      } else {
         var3 = var2?XGrandExchangeOffer.field58:class24.field297;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class32.field747[--class103.field1686] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method3220(var4, class32.field748[--class32.field749]);
            return 1;
         } else {
            --class32.field749;
            return 1;
         }
      } else if(var0 == 1301) {
         class103.field1686 -= 2;
         var4 = class32.field747[class103.field1686];
         int var5 = class32.field747[class103.field1686 + 1];
         var3.parent = class57.method1157(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2283 = class32.field747[--class103.field1686] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2281 = class32.field747[--class103.field1686];
         return 1;
      } else if(var0 == 1304) {
         var3.field2236 = class32.field747[--class103.field1686];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class32.field748[--class32.field749];
         return 1;
      } else if(var0 == 1306) {
         var3.field2306 = class32.field748[--class32.field749];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "208255649"
   )
   static void method197(Sequence var0, int var1, int var2, int var3) {
      if(Client.field547 < 50 && Client.field546 != 0) {
         if(var0.field3059 != null && var1 < var0.field3059.length) {
            int var4 = var0.field3059[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field548[Client.field547] = var5;
               Client.field549[Client.field547] = var6;
               Client.field550[Client.field547] = 0;
               Client.field349[Client.field547] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field555[Client.field547] = var7 + (var8 << 16) + (var9 << 8);
               ++Client.field547;
            }
         }
      }
   }
}
