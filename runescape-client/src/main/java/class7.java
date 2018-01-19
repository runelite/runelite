import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class7 {
   @ObfuscatedName("n")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("v")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("y")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   @Export("boundingBox3DDrawMode")
   public static class11 boundingBox3DDrawMode;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("boundingBoxes")
   static CombatInfoList boundingBoxes;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 1054954093
   )
   @Export("plane")
   static int plane;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = class11.BoundingBox3DDrawMode_mouseOver;
      boundingBoxes = new CombatInfoList();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "113"
   )
   static int method30(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class82.field1267:CombatInfo1.field1216;
      if(var0 == 1700) {
         class82.intStack[++class82.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class82.intStack[++class82.intStackSize - 1] = var3.itemQuantity;
         } else {
            class82.intStack[++class82.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class82.intStack[++class82.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1857114035"
   )
   static final void method34(int var0) {
      class160.method3100();

      for(class81 var1 = (class81)class81.field1247.getFront(); var1 != null; var1 = (class81)class81.field1247.getNext()) {
         if(var1.field1255 != null) {
            var1.method1641();
         }
      }

      int var4 = ContextMenuRow.method1742(var0).configType;
      if(var4 != 0) {
         int var2 = class222.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            class46.method691();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field1090) {
               if(Client.field1090 == 0 && Client.field1091 != -1) {
                  World.method1618(Size.indexTrack1, Client.field1091, 0, var3, false);
                  Client.field991 = false;
               } else if(var3 == 0) {
                  class214.field2630.method3904();
                  class214.field2631 = 1;
                  class214.field2632 = null;
                  Client.field991 = false;
               } else if(class214.field2631 != 0) {
                  class35.field477 = var3;
               } else {
                  class214.field2630.method3898(var3);
               }

               Client.field1090 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field903 = 127;
            }

            if(var2 == 1) {
               Client.field903 = 96;
            }

            if(var2 == 2) {
               Client.field903 = 64;
            }

            if(var2 == 3) {
               Client.field903 = 32;
            }

            if(var2 == 4) {
               Client.field903 = 0;
            }
         }

         if(var4 == 5) {
            Client.field992 = var2;
         }

         if(var4 == 6) {
            Client.field1017 = var2;
         }

         if(var4 == 9) {
            Client.field1018 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field1094 = 127;
            }

            if(var2 == 1) {
               Client.field1094 = 96;
            }

            if(var2 == 2) {
               Client.field1094 = 64;
            }

            if(var2 == 3) {
               Client.field1094 = 32;
            }

            if(var2 == 4) {
               Client.field1094 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1047 = var2 & 65535;
         }

         AttackOption[] var5;
         if(var4 == 18) {
            var5 = new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable};
            Client.playerAttackOption = (AttackOption)class34.forOrdinal(var5, var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field974 = -1;
            } else {
               Client.field974 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable};
            Client.npcAttackOption = (AttackOption)class34.forOrdinal(var5, var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
