import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -728991009
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 122374345
   )
   @Export("type")
   int type;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2015219081
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1420285757
   )
   @Export("level")
   int level;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 260513921
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1203729239
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkc;"
   )
   Sequence field1447;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -557259807
   )
   @Export("animFrame")
   int animFrame;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 307497225
   )
   @Export("animCycleCount")
   int animCycleCount;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLey;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1447 = NPC.getAnimation(var7);
         this.animFrame = 0;
         this.animCycleCount = Client.gameCycle - 1;
         if(this.field1447.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1447 == this.field1447) {
               this.animFrame = var10.animFrame;
               this.animCycleCount = var10.animCycleCount;
               return;
            }
         }

         if(var8 && this.field1447.frameStep != -1) {
            this.animFrame = (int)(Math.random() * (double)this.field1447.frameIDs.length);
            this.animCycleCount -= (int)(Math.random() * (double)this.field1447.frameLengths[this.animFrame]);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "-1967116980"
   )
   protected final Model getModel() {
      if(this.field1447 != null) {
         int var1 = Client.gameCycle - this.animCycleCount;
         if(var1 > 100 && this.field1447.frameStep > 0) {
            var1 = 100;
         }

         label55: {
            do {
               do {
                  if(var1 <= this.field1447.frameLengths[this.animFrame]) {
                     break label55;
                  }

                  var1 -= this.field1447.frameLengths[this.animFrame];
                  ++this.animFrame;
               } while(this.animFrame < this.field1447.frameIDs.length);

               this.animFrame -= this.field1447.frameStep;
            } while(this.animFrame >= 0 && this.animFrame < this.field1447.frameIDs.length);

            this.field1447 = null;
         }

         this.animCycleCount = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class80.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.width;
            var3 = var12.length;
         } else {
            var2 = var12.length;
            var3 = var12.width;
         }

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class62.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var4][var6] + var8[var5][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method5086(this.type, this.orientation, var8, var10, var9, var11, this.field1447, this.animFrame);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "265571776"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1161938854"
   )
   public static boolean method2112() {
      try {
         if(class229.field2694 == 2) {
            if(class229.field2698 == null) {
               class229.field2698 = Track1.getMusicFile(class132.field1905, class321.field3940, class132.field1897);
               if(class229.field2698 == null) {
                  return false;
               }
            }

            if(class237.field2788 == null) {
               class237.field2788 = new class110(class229.field2696, class229.field2700);
            }

            if(class38.field507.method4237(class229.field2698, class229.field2697, class237.field2788, 22050)) {
               class38.field507.method4350();
               class38.field507.method4324(AttackOption.field1334);
               class38.field507.method4240(class229.field2698, Signlink.field2193);
               class229.field2694 = 0;
               class229.field2698 = null;
               class237.field2788 = null;
               class132.field1905 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class38.field507.method4241();
         class229.field2694 = 0;
         class229.field2698 = null;
         class237.field2788 = null;
         class132.field1905 = null;
      }

      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "14"
   )
   static final int method2115(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1671966706"
   )
   static final void method2113(int var0) {
      GroundObject.method2767();

      for(class80 var1 = (class80)class80.field1247.getFront(); var1 != null; var1 = (class80)class80.field1247.getNext()) {
         if(var1.field1257 != null) {
            var1.method1845();
         }
      }

      int var4 = class71.method1204(var0).configType;
      if(var4 != 0) {
         int var2 = class237.clientVarps[var0];
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

            ItemComposition.itemSpriteCache.reset();
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

            if(var3 != Client.field1083) {
               if(Client.field1083 == 0 && Client.field1084 != -1) {
                  MilliTimer.method3279(class7.indexTrack1, Client.field1084, 0, var3, false);
                  Client.field1085 = false;
               } else if(var3 == 0) {
                  class46.method684();
                  Client.field1085 = false;
               } else {
                  Preferences.method1768(var3);
               }

               Client.field1083 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field1086 = 127;
            }

            if(var2 == 1) {
               Client.field1086 = 96;
            }

            if(var2 == 2) {
               Client.field1086 = 64;
            }

            if(var2 == 3) {
               Client.field1086 = 32;
            }

            if(var2 == 4) {
               Client.field1086 = 0;
            }
         }

         if(var4 == 5) {
            Client.field986 = var2;
         }

         if(var4 == 6) {
            Client.field1014 = var2;
         }

         if(var4 == 9) {
            Client.field970 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field1018 = 127;
            }

            if(var2 == 1) {
               Client.field1018 = 96;
            }

            if(var2 == 2) {
               Client.field1018 = 64;
            }

            if(var2 == 3) {
               Client.field1018 = 32;
            }

            if(var2 == 4) {
               Client.field1018 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1057 = var2 & 65535;
         }

         AttackOption[] var5;
         if(var4 == 18) {
            var5 = new AttackOption[]{AttackOption.AttackOption_hidden, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_alwaysRightClick};
            Client.playerAttackOption = (AttackOption)class185.forOrdinal(var5, var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field978 = -1;
            } else {
               Client.field978 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new AttackOption[]{AttackOption.AttackOption_hidden, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_alwaysRightClick};
            Client.npcAttackOption = (AttackOption)class185.forOrdinal(var5, var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
