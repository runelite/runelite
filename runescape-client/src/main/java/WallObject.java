import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -848426587
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -395897065
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1588001219
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -659812433
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 529102943
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2085641561
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 585357267
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "982209386"
   )
   static int method2882(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.scriptStringStack[++class35.scriptStringStackSize - 1] = KitDefinition.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if(var0 == 4201) {
            class82.intStackSize -= 2;
            var3 = class82.intStack[class82.intStackSize];
            var4 = class82.intStack[class82.intStackSize + 1];
            var5 = KitDefinition.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class82.intStackSize -= 2;
            var3 = class82.intStack[class82.intStackSize];
            var4 = class82.intStack[class82.intStackSize + 1];
            var5 = KitDefinition.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class82.intStack[--class82.intStackSize];
            class82.intStack[++class82.intStackSize - 1] = KitDefinition.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class82.intStack[--class82.intStackSize];
            class82.intStack[++class82.intStackSize - 1] = KitDefinition.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var6;
            if(var0 == 4205) {
               var3 = class82.intStack[--class82.intStackSize];
               var6 = KitDefinition.getItemDefinition(var3);
               if(var6.notedTemplate == -1 && var6.note >= 0) {
                  class82.intStack[++class82.intStackSize - 1] = var6.note;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class82.intStack[--class82.intStackSize];
               var6 = KitDefinition.getItemDefinition(var3);
               if(var6.notedTemplate >= 0 && var6.note >= 0) {
                  class82.intStack[++class82.intStackSize - 1] = var6.note;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class82.intStack[--class82.intStackSize];
               class82.intStack[++class82.intStackSize - 1] = KitDefinition.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class82.intStack[--class82.intStackSize];
               var6 = KitDefinition.getItemDefinition(var3);
               if(var6.int3 == -1 && var6.int2 >= 0) {
                  class82.intStack[++class82.intStackSize - 1] = var6.int2;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class82.intStack[--class82.intStackSize];
               var6 = KitDefinition.getItemDefinition(var3);
               if(var6.int3 >= 0 && var6.int2 >= 0) {
                  class82.intStack[++class82.intStackSize - 1] = var6.int2;
               } else {
                  class82.intStack[++class82.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = class82.scriptStringStack[--class35.scriptStringStackSize];
               var4 = class82.intStack[--class82.intStackSize];
               Occluder.method2906(var7, var4 == 1);
               class82.intStack[++class82.intStackSize - 1] = class41.field523;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  WidgetNode.field766 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(Actor.field1182 != null && WidgetNode.field766 < class41.field523) {
                  class82.intStack[++class82.intStackSize - 1] = Actor.field1182[++WidgetNode.field766 - 1] & '\uffff';
               } else {
                  class82.intStack[++class82.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(Lbr;II)V",
      garbageValue = "1514679338"
   )
   static final void method2881(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      Sequence var11;
      if(var0.field1138 > Client.gameCycle) {
         var2 = var0.field1138 - Client.gameCycle;
         var3 = var0.field1164 * 128 + var0.field1126 * 64;
         var4 = var0.field1166 * 128 + var0.field1126 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1180 = 0;
         var0.orientation = var0.field1133;
      } else {
         int var5;
         int var7;
         if(var0.field1169 >= Client.gameCycle) {
            if(var0.field1169 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1156 + 1 > Permission.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var2 = var0.field1169 - var0.field1138;
               var3 = Client.gameCycle - var0.field1138;
               var4 = var0.field1164 * 128 + var0.field1126 * 64;
               var5 = var0.field1166 * 128 + var0.field1126 * 64;
               int var6 = var0.field1165 * 128 + var0.field1126 * 64;
               var7 = var0.field1125 * 128 + var0.field1126 * 64;
               var0.x = (var6 * var3 + var4 * (var2 - var3)) / var2;
               var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
            }

            var0.field1180 = 0;
            var0.orientation = var0.field1133;
            var0.angle = var0.orientation;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.queueSize == 0) {
               var0.field1180 = 0;
            } else {
               label469: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     var11 = Permission.getAnimation(var0.animation);
                     if(var0.field1155 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field1180;
                        break label469;
                     }

                     if(var0.field1155 <= 0 && var11.priority == 0) {
                        ++var0.field1180;
                        break label469;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1126 * 64;
                  var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1126 * 64;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.orientation = 1280;
                     } else if(var3 > var5) {
                        var0.orientation = 1792;
                     } else {
                        var0.orientation = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.orientation = 768;
                     } else if(var3 > var5) {
                        var0.orientation = 256;
                     } else {
                        var0.orientation = 512;
                     }
                  } else if(var3 < var5) {
                     var0.orientation = 1024;
                  } else if(var3 > var5) {
                     var0.orientation = 0;
                  }

                  byte var13 = var0.pathTraversed[var0.queueSize - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.orientation - var0.angle & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field1131;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field1139;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field1123;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field1132;
                     }

                     if(var8 == -1) {
                        var8 = var0.field1139;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1175 != 0) {
                           var9 = 2;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 3) {
                           var9 = 8;
                        }

                        if(var0.field1180 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1180;
                        }
                     } else {
                        if(var0.queueSize > 1) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 8;
                        }

                        if(var0.field1180 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1180;
                        }
                     }

                     if(var13 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.poseAnimation == var0.field1139 && var0.field1130 != -1) {
                        var0.poseAnimation = var0.field1130;
                     }

                     if(var2 != var4 || var3 != var5) {
                        if(var2 < var4) {
                           var0.x += var9;
                           if(var0.x > var4) {
                              var0.x = var4;
                           }
                        } else if(var2 > var4) {
                           var0.x -= var9;
                           if(var0.x < var4) {
                              var0.x = var4;
                           }
                        }

                        if(var3 < var5) {
                           var0.y += var9;
                           if(var0.y > var5) {
                              var0.y = var5;
                           }
                        } else if(var3 > var5) {
                           var0.y -= var9;
                           if(var0.y < var5) {
                              var0.y = var5;
                           }
                        }
                     }

                     if(var4 == var0.x && var5 == var0.y) {
                        --var0.queueSize;
                        if(var0.field1155 > 0) {
                           --var0.field1155;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.queueSize;
                     if(var0.field1155 > 0) {
                        --var0.field1155;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1138 = 0;
         var0.field1169 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1126 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1126 * 64;
         var0.method1464();
      }

      if(UrlRequest.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1138 = 0;
         var0.field1169 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1126 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1126 * 64;
         var0.method1464();
      }

      GrandExchangeOffer.method111(var0);
      var0.field1170 = false;
      if(var0.poseAnimation != -1) {
         var11 = Permission.getAnimation(var0.poseAnimation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1153;
            if(var0.poseFrame < var11.frameIDs.length && var0.field1153 > var11.frameLenghts[var0.poseFrame]) {
               var0.field1153 = 1;
               ++var0.poseFrame;
               class1.method1(var11, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var11.frameIDs.length) {
               var0.field1153 = 0;
               var0.poseFrame = 0;
               class1.method1(var11, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1160 < 0) {
            var0.field1160 = 0;
         }

         var2 = class250.getSpotAnimType(var0.graphic).field3413;
         if(var2 != -1) {
            Sequence var12 = Permission.getAnimation(var2);
            if(var12 != null && var12.frameIDs != null) {
               ++var0.field1143;
               if(var0.field1160 < var12.frameIDs.length && var0.field1143 > var12.frameLenghts[var0.field1160]) {
                  var0.field1143 = 1;
                  ++var0.field1160;
                  class1.method1(var12, var0.field1160, var0.x, var0.y);
               }

               if(var0.field1160 >= var12.frameIDs.length && (var0.field1160 < 0 || var0.field1160 >= var12.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var11 = Permission.getAnimation(var0.animation);
         if(var11.precedenceAnimating == 1 && var0.field1155 > 0 && var0.field1138 <= Client.gameCycle && var0.field1169 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var11 = Permission.getAnimation(var0.animation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1156;
            if(var0.actionFrame < var11.frameIDs.length && var0.field1156 > var11.frameLenghts[var0.actionFrame]) {
               var0.field1156 = 1;
               ++var0.actionFrame;
               class1.method1(var11, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var11.frameIDs.length) {
               var0.actionFrame -= var11.frameStep;
               ++var0.field1124;
               if(var0.field1124 >= var11.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var11.frameIDs.length) {
                  class1.method1(var11, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1170 = var11.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
