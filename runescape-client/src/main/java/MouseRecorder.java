import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 2059180753
   )
   @Export("widgetDragDuration")
   static int widgetDragDuration;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1075569245
   )
   @Export("__bu_hy")
   static int __bu_hy;
   @ObfuscatedName("m")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("f")
   @Export("lock")
   Object lock;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 973045825
   )
   @Export("index")
   int index;
   @ObfuscatedName("w")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("o")
   @Export("ys")
   int[] ys;
   @ObfuscatedName("u")
   @Export("millis")
   long[] millis;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
      this.millis = new long[500];
   }

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      for(; this.isRunning; class203.method4010(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseHandler.MouseHandler_x;
               this.ys[this.index] = MouseHandler.MouseHandler_y;
               this.millis[this.index] = MouseHandler.MouseHandler_millis;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-51"
   )
   @Export("drawObject")
   static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
      long var5 = class65.scene.__ar_244(var0, var1, var2);
      int var7;
      int var8;
      int var9;
      int var10;
      int var14;
      int var26;
      if(var5 != 0L) {
         var7 = class65.scene.getObjectFlags(var0, var1, var2, var5);
         var8 = var7 >> 6 & 3;
         var9 = var7 & 31;
         var10 = var3;
         boolean var12 = var5 != 0L;
         if(var12) {
            boolean var13 = (int)(var5 >>> 16 & 1L) == 1;
            var12 = !var13;
         }

         if(var12) {
            var10 = var4;
         }

         int[] var19 = WidgetGroupParent.sceneMinimapSprite.pixels;
         var26 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var14 = HitSplatDefinition.method4972(var5);
         ObjectDefinition var15 = class50.getObjectDefinition(var14);
         if(var15.mapSceneId != -1) {
            IndexedSprite var16 = class192.mapSceneSprites[var15.mapSceneId];
            if(var16 != null) {
               int var17 = (var15.sizeX * 4 - var16.subWidth) / 2;
               int var18 = (var15.sizeY * 4 - var16.subHeight) / 2;
               var16.__q_496(var1 * 4 + var17 + 48, (104 - var2 - var15.sizeY) * 4 + var18 + 48);
            }
         } else {
            if(var9 == 0 || var9 == 2) {
               if(var8 == 0) {
                  var19[var26] = var10;
                  var19[var26 + 512] = var10;
                  var19[var26 + 1024] = var10;
                  var19[var26 + 1536] = var10;
               } else if(var8 == 1) {
                  var19[var26] = var10;
                  var19[var26 + 1] = var10;
                  var19[var26 + 2] = var10;
                  var19[var26 + 3] = var10;
               } else if(var8 == 2) {
                  var19[var26 + 3] = var10;
                  var19[var26 + 512 + 3] = var10;
                  var19[var26 + 1024 + 3] = var10;
                  var19[var26 + 1536 + 3] = var10;
               } else if(var8 == 3) {
                  var19[var26 + 1536] = var10;
                  var19[var26 + 1536 + 1] = var10;
                  var19[var26 + 1536 + 2] = var10;
                  var19[var26 + 1536 + 3] = var10;
               }
            }

            if(var9 == 3) {
               if(var8 == 0) {
                  var19[var26] = var10;
               } else if(var8 == 1) {
                  var19[var26 + 3] = var10;
               } else if(var8 == 2) {
                  var19[var26 + 1536 + 3] = var10;
               } else if(var8 == 3) {
                  var19[var26 + 1536] = var10;
               }
            }

            if(var9 == 2) {
               if(var8 == 3) {
                  var19[var26] = var10;
                  var19[var26 + 512] = var10;
                  var19[var26 + 1024] = var10;
                  var19[var26 + 1536] = var10;
               } else if(var8 == 0) {
                  var19[var26] = var10;
                  var19[var26 + 1] = var10;
                  var19[var26 + 2] = var10;
                  var19[var26 + 3] = var10;
               } else if(var8 == 1) {
                  var19[var26 + 3] = var10;
                  var19[var26 + 512 + 3] = var10;
                  var19[var26 + 1024 + 3] = var10;
                  var19[var26 + 1536 + 3] = var10;
               } else if(var8 == 2) {
                  var19[var26 + 1536] = var10;
                  var19[var26 + 1536 + 1] = var10;
                  var19[var26 + 1536 + 2] = var10;
                  var19[var26 + 1536 + 3] = var10;
               }
            }
         }
      }

      var5 = class65.scene.__ay_246(var0, var1, var2);
      if(0L != var5) {
         var7 = class65.scene.getObjectFlags(var0, var1, var2, var5);
         var8 = var7 >> 6 & 3;
         var9 = var7 & 31;
         var10 = HitSplatDefinition.method4972(var5);
         ObjectDefinition var20 = class50.getObjectDefinition(var10);
         if(var20.mapSceneId != -1) {
            IndexedSprite var28 = class192.mapSceneSprites[var20.mapSceneId];
            if(var28 != null) {
               var26 = (var20.sizeX * 4 - var28.subWidth) / 2;
               var14 = (var20.sizeY * 4 - var28.subHeight) / 2;
               var28.__q_496(var26 + var1 * 4 + 48, (104 - var2 - var20.sizeY) * 4 + var14 + 48);
            }
         } else if(var9 == 9) {
            int var25 = 15658734;
            boolean var27 = 0L != var5;
            if(var27) {
               boolean var23 = (int)(var5 >>> 16 & 1L) == 1;
               var27 = !var23;
            }

            if(var27) {
               var25 = 15597568;
            }

            int[] var24 = WidgetGroupParent.sceneMinimapSprite.pixels;
            int var29 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var8 != 0 && var8 != 2) {
               var24[var29] = var25;
               var24[var29 + 1 + 512] = var25;
               var24[var29 + 1024 + 2] = var25;
               var24[var29 + 1536 + 3] = var25;
            } else {
               var24[var29 + 1536] = var25;
               var24[var29 + 1 + 1024] = var25;
               var24[var29 + 512 + 2] = var25;
               var24[var29 + 3] = var25;
            }
         }
      }

      var5 = class65.scene.getFloorDecorationTag(var0, var1, var2);
      if(var5 != 0L) {
         var7 = HitSplatDefinition.method4972(var5);
         ObjectDefinition var21 = class50.getObjectDefinition(var7);
         if(var21.mapSceneId != -1) {
            IndexedSprite var22 = class192.mapSceneSprites[var21.mapSceneId];
            if(var22 != null) {
               var10 = (var21.sizeX * 4 - var22.subWidth) / 2;
               int var11 = (var21.sizeY * 4 - var22.subHeight) / 2;
               var22.__q_496(var10 + var1 * 4 + 48, var11 + (104 - var2 - var21.sizeY) * 4 + 48);
            }
         }
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lho;B)Ljava/lang/String;",
      garbageValue = "17"
   )
   static String method1194(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class16.method187(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lho;IIII)V",
      garbageValue = "-335916694"
   )
   static final void method1189(Widget var0, int var1, int var2, int var3) {
      class13.playPcmPlayers();
      SpriteMask var4 = var0.getSpriteMask(false);
      if(var4 != null) {
         Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
         if(Client.minimapState != 2 && Client.minimapState != 5) {
            int var5 = Client.minimapOrientation & 2047;
            int var6 = Canvas.localPlayer.x / 32 + 48;
            int var7 = 464 - Canvas.localPlayer.y / 32;
            WidgetGroupParent.sceneMinimapSprite.__ay_513(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.mapIconCount; ++var8) {
               var9 = Client.mapIconXs[var8] * 4 + 2 - Canvas.localPlayer.x / 32;
               var10 = Client.mapIconYs[var8] * 4 + 2 - Canvas.localPlayer.y / 32;
               NetFileRequest.method4554(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  NodeDeque var15 = Client.groundItems[SoundSystem.plane][var8][var9];
                  if(var15 != null) {
                     var11 = var8 * 4 + 2 - Canvas.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - Canvas.localPlayer.y / 32;
                     NetFileRequest.method4554(var1, var2, var11, var12, class39.mapDotSprites[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcCount; ++var8) {
               Npc var16 = Client.npcs[Client.npcIndices[var8]];
               if(var16 != null && var16.isVisible()) {
                  NpcDefinition var18 = var16.definition;
                  if(var18 != null && var18.transforms != null) {
                     var18 = var18.transform();
                  }

                  if(var18 != null && var18.drawMapDot && var18.isInteractable) {
                     var11 = var16.x / 32 - Canvas.localPlayer.x / 32;
                     var12 = var16.y / 32 - Canvas.localPlayer.y / 32;
                     NetFileRequest.method4554(var1, var2, var11, var12, class39.mapDotSprites[1], var4);
                  }
               }
            }

            var8 = Players.Players_count;
            int[] var19 = Players.Players_indices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var17 = Client.players[var19[var10]];
               if(var17 != null && var17.isVisible() && !var17.isHidden && var17 != Canvas.localPlayer) {
                  var12 = var17.x / 32 - Canvas.localPlayer.x / 32;
                  int var13 = var17.y / 32 - Canvas.localPlayer.y / 32;
                  boolean var14 = false;
                  if(Canvas.localPlayer.team != 0 && var17.team != 0 && var17.team == Canvas.localPlayer.team) {
                     var14 = true;
                  }

                  if(var17.isFriend()) {
                     NetFileRequest.method4554(var1, var2, var12, var13, class39.mapDotSprites[3], var4);
                  } else if(var14) {
                     NetFileRequest.method4554(var1, var2, var12, var13, class39.mapDotSprites[4], var4);
                  } else if(var17.isClanMember()) {
                     NetFileRequest.method4554(var1, var2, var12, var13, class39.mapDotSprites[5], var4);
                  } else {
                     NetFileRequest.method4554(var1, var2, var12, var13, class39.mapDotSprites[2], var4);
                  }
               }
            }

            if(Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
               if(Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
                  Npc var20 = Client.npcs[Client.hintArrowNpcIndex];
                  if(var20 != null) {
                     var11 = var20.x / 32 - Canvas.localPlayer.x / 32;
                     var12 = var20.y / 32 - Canvas.localPlayer.y / 32;
                     UserComparator5.worldToMinimap(var1, var2, var11, var12, class16.mapMarkerSprites[1], var4);
                  }
               }

               if(Client.hintArrowType == 2) {
                  var10 = Client.hintArrowX * 4 - class50.baseX * 4 + 2 - Canvas.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - GraphicsObject.baseY * 4 + 2 - Canvas.localPlayer.y / 32;
                  UserComparator5.worldToMinimap(var1, var2, var10, var11, class16.mapMarkerSprites[1], var4);
               }

               if(Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
                  Player var21 = Client.players[Client.hintArrowPlayerIndex];
                  if(var21 != null) {
                     var11 = var21.x / 32 - Canvas.localPlayer.x / 32;
                     var12 = var21.y / 32 - Canvas.localPlayer.y / 32;
                     UserComparator5.worldToMinimap(var1, var2, var11, var12, class16.mapMarkerSprites[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - Canvas.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - Canvas.localPlayer.y / 32;
               NetFileRequest.method4554(var1, var2, var10, var11, class16.mapMarkerSprites[0], var4);
            }

            if(!Canvas.localPlayer.isHidden) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5948(var1, var2, 0, var4.xStarts, var4.xWidths);
         }

         Client.__client_ot[var3] = true;
      }
   }
}
