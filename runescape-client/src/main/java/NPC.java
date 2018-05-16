import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("n")
   @Export("tileOverlayPath")
   static byte[][][] tileOverlayPath;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 160231311
   )
   static int field1056;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "71"
   )
   final void method1824(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && class137.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var5 = super.queueSize; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.pathTraversed[0] = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIZS)V",
      garbageValue = "30985"
   )
   final void method1823(int var1, int var2, boolean var3) {
      if(super.animation != -1 && class137.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.queueSize < 9) {
               ++super.queueSize;
            }

            for(int var6 = super.queueSize; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.pathTraversed[0] = 1;
            return;
         }
      }

      super.queueSize = 0;
      super.field942 = 0;
      super.field936 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field885 * 64 + super.pathX[0] * 128;
      super.y = super.field885 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Ldk;",
      garbageValue = "111"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class137.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class137.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            if(super.graphic != -1 && super.spotAnimFrame != -1) {
               Model var4 = ScriptState.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field924, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.size == 1) {
               var3.field1636 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;Liv;ZII)V",
      garbageValue = "-2126731808"
   )
   static void method1841(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class78.field1122) {
         if(var3 == 4) {
            class78.loginIndex = 4;
         }

      } else {
         class78.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         class78.field1107 = VarCInt.method4854(var4);
         class24.field224 = class78.field1107.method5956();
         if((Client.flags & 536870912) != 0) {
            class78.logoSprite = GameEngine.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class78.logoSprite = GameEngine.getSprite(var1, "logo", "");
         }

         class78.field1105 = GameEngine.getSprite(var1, "titlebox", "");
         class78.field1113 = GameEngine.getSprite(var1, "titlebutton", "");
         class192.runeSprites = class278.getIndexedSprites(var1, "runes", "");
         WidgetNode.titlemuteSprite = class278.getIndexedSprites(var1, "title_mute", "");
         class78.field1109 = GameEngine.getSprite(var1, "options_radio_buttons,0", "");
         CombatInfo1.field944 = GameEngine.getSprite(var1, "options_radio_buttons,4", "");
         class78.field1110 = GameEngine.getSprite(var1, "options_radio_buttons,2", "");
         Buffer.field2363 = GameEngine.getSprite(var1, "options_radio_buttons,6", "");
         UrlRequest.field1881 = class78.field1109.width;
         class69.field1028 = class78.field1109.height;
         WorldComparator.field4 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            WorldComparator.field4[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldComparator.field4[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldComparator.field4[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldComparator.field4[var5 + 192] = 16777215;
         }

         class81.field1178 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class81.field1178[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class81.field1178[var5 + 64] = var5 * 4 + 65280;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class81.field1178[var5 + 128] = var5 * 262144 + 65535;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class81.field1178[var5 + 192] = 16777215;
         }

         DynamicObject.field1228 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            DynamicObject.field1228[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            DynamicObject.field1228[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            DynamicObject.field1228[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            DynamicObject.field1228[var5 + 192] = 16777215;
         }

         class45.field376 = new int[256];
         class8.field51 = new int['耀'];
         class83.field1206 = new int['耀'];
         class43.method790((IndexedSprite)null);
         class297.field3701 = new int['耀'];
         class274.field3569 = new int['耀'];
         if(var2) {
            class78.username = "";
            class78.password = "";
         }

         MessageNode.field549 = 0;
         GameEngine.field414 = "";
         class78.field1132 = true;
         class78.worldSelectShown = false;
         if(!ScriptState.preferences.muted) {
            IndexData var8 = MouseInput.indexTrack1;
            int var6 = var8.getFile("scape main");
            int var7 = var8.getChild(var6, "");
            ClientPacket.method3459(2, var8, var6, var7, 255, false);
         } else {
            ISAACCipher.method3911(2);
         }

         WorldMapType3.sendConInfo(false);
         class78.field1122 = true;
         class78.field1104 = (class9.canvasWidth - 765) / 2;
         class78.loginWindowX = class78.field1104 + 202;
         class78.field1112 = class78.loginWindowX + 180;
         class78.field1107.method5893(class78.field1104, 0);
         class24.field224.method5893(class78.field1104 + 382, 0);
         class78.logoSprite.method5873(class78.field1104 + 382 - class78.logoSprite.width / 2, 18);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;III)Llh;",
      garbageValue = "1929954642"
   )
   static IndexedSprite method1842(IndexDataBase var0, int var1, int var2) {
      return !class306.method5702(var0, var1, var2)?null:class224.method4461();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "-654488904"
   )
   static int method1831(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
      } else {
         var3 = var2?class184.field2379:FriendManager.field996;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class69.intStack[--class45.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class69.scriptStringStack[--class83.scriptStringStackSize]);
            return 1;
         } else {
            --class83.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class45.intStackSize -= 2;
         var4 = class69.intStack[class45.intStackSize];
         int var5 = class69.intStack[class45.intStackSize + 1];
         var3.dragParent = class21.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.dragRenderBehavior = class69.intStack[--class45.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.dragDeadZone = class69.intStack[--class45.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.dragDeadTime = class69.intStack[--class45.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.opBase = class69.scriptStringStack[--class83.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.targetVerb = class69.scriptStringStack[--class83.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
