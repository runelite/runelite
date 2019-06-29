import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class65 extends RouteStrategy
{
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("pcmPlayerProvider")
   public static PcmPlayerProvider pcmPlayerProvider;
   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   @Export("scene")
   static Scene scene;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILfy;I)Z",
      garbageValue = "-519225044"
   )
   protected boolean vmethod3644(int var1, int var2, int var3, CollisionMap var4) {
      return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Lbz;II)V",
      garbageValue = "406386718"
   )
   static final void method1232(Actor actor, int var1) {
      if(actor.__bw > Client.cycle) {
         SpriteIds.method5828(actor);
      } else {
         int var2;
         int var3;
         int var4;
         int var5;
         int var7;
         if(actor.__cr >= Client.cycle) {
            if(actor.__cr == Client.cycle || actor.sequence == -1 || actor.sequenceDelay != 0 || actor.sequenceFrameCycle + 1 > WorldMapAreaData.getSequenceDefinition(actor.sequence).frameLengths[actor.sequenceFrame]) {
               var2 = actor.__cr - actor.__bw;
               var3 = Client.cycle - actor.__bw;
               var4 = actor.__bf * 128 + actor.size * 64;
               var5 = actor.__be * 128 + actor.size * 64;
               int var6 = actor.__bh * 128 + actor.size * 64;
               var7 = actor.__bv * 128 + actor.size * 64;
               actor.x = (var3 * var6 + var4 * (var2 - var3)) / var2;
               actor.y = (var3 * var7 + var5 * (var2 - var3)) / var2;
            }

            actor.__cq = 0;
            actor.orientation = actor.__cv;
            actor.__ac = actor.orientation;
         } else {
            actor.movementSequence = actor.idleSequence;
            if(actor.pathLength == 0) {
               actor.__cq = 0;
            } else {
               label310: {
                  if(actor.sequence != -1 && actor.sequenceDelay == 0) {
                     SequenceDefinition var11 = WorldMapAreaData.getSequenceDefinition(actor.sequence);
                     if(actor.__ch > 0 && var11.__j == 0) {
                        ++actor.__cq;
                        break label310;
                     }

                     if(actor.__ch <= 0 && var11.__s == 0) {
                        ++actor.__cq;
                        break label310;
                     }
                  }

                  var2 = actor.x;
                  var3 = actor.y;
                  var4 = actor.pathX[actor.pathLength - 1] * 128 + actor.size * 64;
                  var5 = actor.pathY[actor.pathLength - 1] * 128 + actor.size * 64;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        actor.orientation = 1280;
                     } else if(var3 > var5) {
                        actor.orientation = 1792;
                     } else {
                        actor.orientation = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        actor.orientation = 768;
                     } else if(var3 > var5) {
                        actor.orientation = 256;
                     } else {
                        actor.orientation = 512;
                     }
                  } else if(var3 < var5) {
                     actor.orientation = 1024;
                  } else if(var3 > var5) {
                     actor.orientation = 0;
                  }

                  byte var12 = actor.pathTraversed[actor.pathLength - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = actor.orientation - actor.__ac & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = actor.walkTurnSequence;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = actor.walkSequence;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = actor.walkTurnRightSequence;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = actor.walkTurnLeftSequence;
                     }

                     if(var8 == -1) {
                        var8 = actor.walkSequence;
                     }

                     actor.movementSequence = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(actor instanceof Npc) {
                        var10 = ((Npc)actor).definition.isClickable;
                     }

                     if(var10) {
                        if(actor.__ac != actor.orientation && actor.targetIndex == -1 && actor.__cj != 0) {
                           var9 = 2;
                        }

                        if(actor.pathLength > 2) {
                           var9 = 6;
                        }

                        if(actor.pathLength > 3) {
                           var9 = 8;
                        }

                        if(actor.__cq > 0 && actor.pathLength > 1) {
                           var9 = 8;
                           --actor.__cq;
                        }
                     } else {
                        if(actor.pathLength > 1) {
                           var9 = 6;
                        }

                        if(actor.pathLength > 2) {
                           var9 = 8;
                        }

                        if(actor.__cq > 0 && actor.pathLength > 1) {
                           var9 = 8;
                           --actor.__cq;
                        }
                     }

                     if(var12 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && actor.movementSequence == actor.walkSequence && actor.runSequence != -1) {
                        actor.movementSequence = actor.runSequence;
                     }

                     if(var2 != var4 || var5 != var3) {
                        if(var2 < var4) {
                           actor.x += var9;
                           if(actor.x > var4) {
                              actor.x = var4;
                           }
                        } else if(var2 > var4) {
                           actor.x -= var9;
                           if(actor.x < var4) {
                              actor.x = var4;
                           }
                        }

                        if(var3 < var5) {
                           actor.y += var9;
                           if(actor.y > var5) {
                              actor.y = var5;
                           }
                        } else if(var3 > var5) {
                           actor.y -= var9;
                           if(actor.y < var5) {
                              actor.y = var5;
                           }
                        }
                     }

                     if(var4 == actor.x && var5 == actor.y) {
                        --actor.pathLength;
                        if(actor.__ch > 0) {
                           --actor.__ch;
                        }
                     }
                  } else {
                     actor.x = var4;
                     actor.y = var5;
                     --actor.pathLength;
                     if(actor.__ch > 0) {
                        --actor.__ch;
                     }
                  }
               }
            }
         }
      }

      if(actor.x < 128 || actor.y < 128 || actor.x >= 13184 || actor.y >= 13184) {
         actor.sequence = -1;
         actor.spotAnimation = -1;
         actor.__bw = 0;
         actor.__cr = 0;
         actor.x = actor.pathX[0] * 128 + actor.size * 64;
         actor.y = actor.pathY[0] * 128 + actor.size * 64;
         actor.__bb_143();
      }

      if(Canvas.localPlayer == actor && (actor.x < 1536 || actor.y < 1536 || actor.x >= 11776 || actor.y >= 11776)) {
         actor.sequence = -1;
         actor.spotAnimation = -1;
         actor.__bw = 0;
         actor.__cr = 0;
         actor.x = actor.pathX[0] * 128 + actor.size * 64;
         actor.y = actor.pathY[0] * 128 + actor.size * 64;
         actor.__bb_143();
      }

      IndexStoreAction.method4553(actor);
      ChatChannel.method2225(actor);
   }
}
