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
         Object var2 = this.lock;
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
      int var11;
      int var12;
      int var17;
      if(var5 != 0L) {
         var7 = class65.scene.getObjectFlags(var0, var1, var2, var5);
         var8 = var7 >> 6 & 3;
         var9 = var7 & 31;
         var10 = var3;
         boolean var13 = var5 != 0L;
         if(var13) {
            boolean var14 = (int)(var5 >>> 16 & 1L) == 1;
            var13 = !var14;
         }

         if(var13) {
            var10 = var4;
         }

         int[] var20 = WidgetGroupParent.sceneMinimapSprite.pixels;
         var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var11 = HitSplatDefinition.method4972(var5);
         ObjectDefinition var15 = class50.getObjectDefinition(var11);
         if(var15.mapSceneId != -1) {
            IndexedSprite var16 = class192.mapSceneSprites[var15.mapSceneId];
            if(var16 != null) {
               var17 = (var15.sizeX * 4 - var16.subWidth) / 2;
               int var18 = (var15.sizeY * 4 - var16.subHeight) / 2;
               var16.__q_496(var1 * 4 + var17 + 48, (104 - var2 - var15.sizeY) * 4 + var18 + 48);
            }
         } else {
            if(var9 == 0 || var9 == 2) {
               if(var8 == 0) {
                  var20[var12] = var10;
                  var20[var12 + 512] = var10;
                  var20[var12 + 1024] = var10;
                  var20[var12 + 1536] = var10;
               } else if(var8 == 1) {
                  var20[var12] = var10;
                  var20[var12 + 1] = var10;
                  var20[var12 + 2] = var10;
                  var20[var12 + 3] = var10;
               } else if(var8 == 2) {
                  var20[var12 + 3] = var10;
                  var20[var12 + 512 + 3] = var10;
                  var20[var12 + 1024 + 3] = var10;
                  var20[var12 + 1536 + 3] = var10;
               } else if(var8 == 3) {
                  var20[var12 + 1536] = var10;
                  var20[var12 + 1536 + 1] = var10;
                  var20[var12 + 1536 + 2] = var10;
                  var20[var12 + 1536 + 3] = var10;
               }
            }

            if(var9 == 3) {
               if(var8 == 0) {
                  var20[var12] = var10;
               } else if(var8 == 1) {
                  var20[var12 + 3] = var10;
               } else if(var8 == 2) {
                  var20[var12 + 1536 + 3] = var10;
               } else if(var8 == 3) {
                  var20[var12 + 1536] = var10;
               }
            }

            if(var9 == 2) {
               if(var8 == 3) {
                  var20[var12] = var10;
                  var20[var12 + 512] = var10;
                  var20[var12 + 1024] = var10;
                  var20[var12 + 1536] = var10;
               } else if(var8 == 0) {
                  var20[var12] = var10;
                  var20[var12 + 1] = var10;
                  var20[var12 + 2] = var10;
                  var20[var12 + 3] = var10;
               } else if(var8 == 1) {
                  var20[var12 + 3] = var10;
                  var20[var12 + 512 + 3] = var10;
                  var20[var12 + 1024 + 3] = var10;
                  var20[var12 + 1536 + 3] = var10;
               } else if(var8 == 2) {
                  var20[var12 + 1536] = var10;
                  var20[var12 + 1536 + 1] = var10;
                  var20[var12 + 1536 + 2] = var10;
                  var20[var12 + 1536 + 3] = var10;
               }
            }
         }
      }

      var5 = class65.scene.__ay_246(var0, var1, var2);
      ObjectDefinition var19;
      IndexedSprite var21;
      if(0L != var5) {
         var7 = class65.scene.getObjectFlags(var0, var1, var2, var5);
         var8 = var7 >> 6 & 3;
         var9 = var7 & 31;
         var10 = HitSplatDefinition.method4972(var5);
         var19 = class50.getObjectDefinition(var10);
         if(var19.mapSceneId != -1) {
            var21 = class192.mapSceneSprites[var19.mapSceneId];
            if(var21 != null) {
               var12 = (var19.sizeX * 4 - var21.subWidth) / 2;
               var11 = (var19.sizeY * 4 - var21.subHeight) / 2;
               var21.__q_496(var12 + var1 * 4 + 48, (104 - var2 - var19.sizeY) * 4 + var11 + 48);
            }
         } else if(var9 == 9) {
            int var22 = 15658734;
            boolean var23 = 0L != var5;
            if(var23) {
               boolean var24 = (int)(var5 >>> 16 & 1L) == 1;
               var23 = !var24;
            }

            if(var23) {
               var22 = 15597568;
            }

            int[] var26 = WidgetGroupParent.sceneMinimapSprite.pixels;
            var17 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var8 != 0 && var8 != 2) {
               var26[var17] = var22;
               var26[var17 + 1 + 512] = var22;
               var26[var17 + 1024 + 2] = var22;
               var26[var17 + 1536 + 3] = var22;
            } else {
               var26[var17 + 1536] = var22;
               var26[var17 + 1 + 1024] = var22;
               var26[var17 + 512 + 2] = var22;
               var26[var17 + 3] = var22;
            }
         }
      }

      var5 = class65.scene.getFloorDecorationTag(var0, var1, var2);
      if(var5 != 0L) {
         var7 = HitSplatDefinition.method4972(var5);
         var19 = class50.getObjectDefinition(var7);
         if(var19.mapSceneId != -1) {
            var21 = class192.mapSceneSprites[var19.mapSceneId];
            if(var21 != null) {
               var10 = (var19.sizeX * 4 - var21.subWidth) / 2;
               int var25 = (var19.sizeY * 4 - var21.subHeight) / 2;
               var21.__q_496(var10 + var1 * 4 + 48, var25 + (104 - var2 - var19.sizeY) * 4 + 48);
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
               int var5 = class16.method187(var1, var2 - 1);
               String var6;
               if(var5 < 999999999) {
                  var6 = Integer.toString(var5);
               } else {
                  var6 = "*";
               }

               var0 = var4 + var6 + var0.substring(var3 + 2);
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

            var8 = 0;

            while(true) {
               int var11;
               int var12;
               if(var8 >= 104) {
                  for(var8 = 0; var8 < Client.npcCount; ++var8) {
                     NPC var17 = Client.npcs[Client.npcIndices[var8]];
                     if(var17 != null && var17.isVisible()) {
                        NPCDefinition var14 = var17.definition;
                        if(var14 != null && var14.transforms != null) {
                           var14 = var14.transform();
                        }

                        if(var14 != null && var14.drawMapDot && var14.isInteractable) {
                           var11 = var17.x / 32 - Canvas.localPlayer.x / 32;
                           var12 = var17.y / 32 - Canvas.localPlayer.y / 32;
                           NetFileRequest.method4554(var1, var2, var11, var12, class39.mapDotSprites[1], var4);
                        }
                     }
                  }

                  var8 = Players.Players_count;
                  int[] var18 = Players.Players_indices;

                  Player var19;
                  for(var10 = 0; var10 < var8; ++var10) {
                     var19 = Client.players[var18[var10]];
                     if(var19 != null && var19.isVisible() && !var19.isHidden && var19 != Canvas.localPlayer) {
                        var12 = var19.x / 32 - Canvas.localPlayer.x / 32;
                        int var15 = var19.y / 32 - Canvas.localPlayer.y / 32;
                        boolean var16 = false;
                        if(Canvas.localPlayer.team != 0 && var19.team != 0 && var19.team == Canvas.localPlayer.team) {
                           var16 = true;
                        }

                        if(var19.isFriend()) {
                           NetFileRequest.method4554(var1, var2, var12, var15, class39.mapDotSprites[3], var4);
                        } else if(var16) {
                           NetFileRequest.method4554(var1, var2, var12, var15, class39.mapDotSprites[4], var4);
                        } else if(var19.isClanMember()) {
                           NetFileRequest.method4554(var1, var2, var12, var15, class39.mapDotSprites[5], var4);
                        } else {
                           NetFileRequest.method4554(var1, var2, var12, var15, class39.mapDotSprites[2], var4);
                        }
                     }
                  }

                  if(Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
                     if(Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
                        NPC var20 = Client.npcs[Client.hintArrowNpcIndex];
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
                        var19 = Client.players[Client.hintArrowPlayerIndex];
                        if(var19 != null) {
                           var11 = var19.x / 32 - Canvas.localPlayer.x / 32;
                           var12 = var19.y / 32 - Canvas.localPlayer.y / 32;
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
                  break;
               }

               for(var9 = 0; var9 < 104; ++var9) {
                  NodeDeque var13 = Client.groundItems[SoundSystem.plane][var8][var9];
                  if(var13 != null) {
                     var11 = var8 * 4 + 2 - Canvas.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - Canvas.localPlayer.y / 32;
                     NetFileRequest.method4554(var1, var2, var11, var12, class39.mapDotSprites[0], var4);
                  }
               }

               ++var8;
            }
         } else {
            Rasterizer2D.method5948(var1, var2, 0, var4.xStarts, var4.xWidths);
         }

         Client.__client_ot[var3] = true;
      }

   }
}
