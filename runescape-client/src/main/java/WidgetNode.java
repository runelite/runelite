import java.awt.Image;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -858964405
   )
   @Export("id")
   int id;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1123093715
   )
   int field179;
   @ObfuscatedName("n")
   boolean field180 = false;
   @ObfuscatedName("rb")
   protected static Image field183;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-91"
   )
   public static int method193() {
      return ++class115.mouseIdleTicks - 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2046238438"
   )
   static void method194(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field676[var5] != var0) {
            var2[var4] = World.field676[var5];
            var3[var4] = World.field675[var5];
            ++var4;
         }
      }

      World.field676 = var2;
      World.field675 = var3;
      class26.method574(World.worldList, 0, World.worldList.length - 1, World.field676, World.field675);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      XItemContainer.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "1225853563"
   )
   static final void method196(Player var0, int var1, int var2, int var3) {
      if(class22.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field241 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class31.method652(var0.combatLevel, class22.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field241 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field351 == 1) {
               class59.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class213.method4037(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field440) {
               if((class159.field2071 & 8) == 8) {
                  class59.addMenuEntry(Client.field438, Client.field392 + " " + "->" + " " + class213.method4037(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field306 == class40.field807) {
                           continue;
                        }

                        if(Client.field306 == class40.field805 || Client.field306 == class40.field809 && var0.combatLevel > class22.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class22.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class22.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.playerMenuTypes[var5] + var6;
                     class59.addMenuEntry(Client.playerOptions[var5], class213.method4037(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class213.method4037(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "28"
   )
   public static File method197(String var0) {
      if(!class107.field1721) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1715.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class120.field1866, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class107.field1715.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "1578185706"
   )
   static final void method198(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field638 > Client.gameCycle) {
         XClanMember.method254(var0);
      } else {
         int var5;
         int var7;
         if(var0.field646 >= Client.gameCycle) {
            if(var0.field646 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field633 + 1 > NPCComposition.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var2 = var0.field646 - var0.field638;
               var3 = Client.gameCycle - var0.field638;
               var4 = var0.field660 * 128 + var0.field603 * 64;
               var5 = var0.field643 * 128 + var0.field603 * 64;
               int var6 = var0.field642 * 128 + var0.field603 * 64;
               var7 = var0.field603 * 64 + var0.field644 * 128;
               var0.x = (var4 * (var2 - var3) + var6 * var3) / var2;
               var0.y = (var7 * var3 + (var2 - var3) * var5) / var2;
            }

            var0.field657 = 0;
            var0.field650 = var0.field647;
            var0.angle = var0.field650;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.field653 == 0) {
               var0.field657 = 0;
            } else {
               label458: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     Sequence var11 = NPCComposition.getAnimation(var0.animation);
                     if(var0.field658 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field657;
                        break label458;
                     }

                     if(var0.field658 <= 0 && var11.priority == 0) {
                        ++var0.field657;
                        break label458;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.field603 * 64 + var0.pathX[var0.field653 - 1] * 128;
                  var5 = var0.field603 * 64 + var0.pathY[var0.field653 - 1] * 128;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.field650 = 1280;
                     } else if(var3 > var5) {
                        var0.field650 = 1792;
                     } else {
                        var0.field650 = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.field650 = 768;
                     } else if(var3 > var5) {
                        var0.field650 = 256;
                     } else {
                        var0.field650 = 512;
                     }
                  } else if(var3 < var5) {
                     var0.field650 = 1024;
                  } else if(var3 > var5) {
                     var0.field650 = 0;
                  }

                  byte var14 = var0.field618[var0.field653 - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.field650 - var0.angle & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field608;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field659;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field610;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field609;
                     }

                     if(var8 == -1) {
                        var8 = var0.field659;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.field650 != var0.angle && var0.interacting == -1 && var0.field652 != 0) {
                           var9 = 2;
                        }

                        if(var0.field653 > 2) {
                           var9 = 6;
                        }

                        if(var0.field653 > 3) {
                           var9 = 8;
                        }

                        if(var0.field657 > 0 && var0.field653 > 1) {
                           var9 = 8;
                           --var0.field657;
                        }
                     } else {
                        if(var0.field653 > 1) {
                           var9 = 6;
                        }

                        if(var0.field653 > 2) {
                           var9 = 8;
                        }

                        if(var0.field657 > 0 && var0.field653 > 1) {
                           var9 = 8;
                           --var0.field657;
                        }
                     }

                     if(var14 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.poseAnimation == var0.field659 && var0.field649 != -1) {
                        var0.poseAnimation = var0.field649;
                     }

                     if(var2 != var4 || var5 != var3) {
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

                     if(var0.x == var4 && var0.y == var5) {
                        --var0.field653;
                        if(var0.field658 > 0) {
                           --var0.field658;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.field653;
                     if(var0.field658 > 0) {
                        --var0.field658;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field638 = 0;
         var0.field646 = 0;
         var0.x = var0.field603 * 64 + var0.pathX[0] * 128;
         var0.y = var0.pathY[0] * 128 + var0.field603 * 64;
         var0.method584();
      }

      if(var0 == class22.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field638 = 0;
         var0.field646 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field603 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field603 * 64;
         var0.method584();
      }

      if(var0.field652 != 0) {
         if(var0.interacting != -1) {
            Object var15 = null;
            if(var0.interacting < '耀') {
               var15 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var15 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var15 != null) {
               var3 = var0.x - ((Actor)var15).x;
               var4 = var0.y - ((Actor)var15).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field650 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field614) {
               var0.interacting = -1;
               var0.field614 = false;
            }
         }

         if(var0.field627 != -1 && (var0.field653 == 0 || var0.field657 > 0)) {
            var0.field650 = var0.field627;
            var0.field627 = -1;
         }

         var2 = var0.field650 - var0.angle & 2047;
         if(var2 == 0 && var0.field614) {
            var0.interacting = -1;
            var0.field614 = false;
         }

         if(var2 != 0) {
            ++var0.field651;
            boolean var13;
            if(var2 > 1024) {
               var0.angle -= var0.field652;
               var13 = true;
               if(var2 < var0.field652 || var2 > 2048 - var0.field652) {
                  var0.angle = var0.field650;
                  var13 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field651 > 25 || var13)) {
                  if(var0.field605 != -1) {
                     var0.poseAnimation = var0.field605;
                  } else {
                     var0.poseAnimation = var0.field659;
                  }
               }
            } else {
               var0.angle += var0.field652;
               var13 = true;
               if(var2 < var0.field652 || var2 > 2048 - var0.field652) {
                  var0.angle = var0.field650;
                  var13 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field651 > 25 || var13)) {
                  if(var0.field606 != -1) {
                     var0.poseAnimation = var0.field606;
                  } else {
                     var0.poseAnimation = var0.field659;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field651 = 0;
         }
      }

      class20.method205(var0);
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1829672807"
   )
   static boolean method199(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class108.method2059(var0, NPC.field757);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class108.method2059(Client.friends[var3].name, NPC.field757)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class108.method2059(class22.localPlayer.name, NPC.field757))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "379036711"
   )
   static final void method200(boolean var0) {
      Client.field407 = 0;
      Client.field292 = 0;
      Client.secretCipherBuffer2.method2644();
      int var1 = Client.secretCipherBuffer2.method2645(8);
      int var2;
      if(var1 < Client.field321) {
         for(var2 = var1; var2 < Client.field321; ++var2) {
            Client.field408[++Client.field407 - 1] = Client.field350[var2];
         }
      }

      if(var1 > Client.field321) {
         throw new RuntimeException("");
      } else {
         Client.field321 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.field350[var2];
            NPC var4 = Client.cachedNPCs[var3];
            var5 = Client.secretCipherBuffer2.method2645(1);
            if(var5 == 0) {
               Client.field350[++Client.field321 - 1] = var3;
               var4.field648 = Client.gameCycle;
            } else {
               var6 = Client.secretCipherBuffer2.method2645(2);
               if(var6 == 0) {
                  Client.field350[++Client.field321 - 1] = var3;
                  var4.field648 = Client.gameCycle;
                  Client.field324[++Client.field292 - 1] = var3;
               } else if(var6 == 1) {
                  Client.field350[++Client.field321 - 1] = var3;
                  var4.field648 = Client.gameCycle;
                  var7 = Client.secretCipherBuffer2.method2645(3);
                  var4.method735(var7, (byte)1);
                  var8 = Client.secretCipherBuffer2.method2645(1);
                  if(var8 == 1) {
                     Client.field324[++Client.field292 - 1] = var3;
                  }
               } else if(var6 == 2) {
                  Client.field350[++Client.field321 - 1] = var3;
                  var4.field648 = Client.gameCycle;
                  var7 = Client.secretCipherBuffer2.method2645(3);
                  var4.method735(var7, (byte)2);
                  var8 = Client.secretCipherBuffer2.method2645(3);
                  var4.method735(var8, (byte)2);
                  var9 = Client.secretCipherBuffer2.method2645(1);
                  if(var9 == 1) {
                     Client.field324[++Client.field292 - 1] = var3;
                  }
               } else if(var6 == 3) {
                  Client.field408[++Client.field407 - 1] = var3;
               }
            }
         }

         DecorativeObject.method1928(var0);

         for(var1 = 0; var1 < Client.field292; ++var1) {
            var2 = Client.field324[var1];
            NPC var13 = Client.cachedNPCs[var2];
            int var14 = Client.secretCipherBuffer2.readUnsignedByte();
            if((var14 & 2) != 0) {
               var13.interacting = Client.secretCipherBuffer2.method2418();
               if(var13.interacting == '\uffff') {
                  var13.interacting = -1;
               }
            }

            if((var14 & 32) != 0) {
               var5 = Client.secretCipherBuffer2.method2409();
               int var10;
               int var11;
               if(var5 > 0) {
                  for(var6 = 0; var6 < var5; ++var6) {
                     var8 = -1;
                     var9 = -1;
                     var10 = -1;
                     var7 = Client.secretCipherBuffer2.method2395();
                     if(var7 == 32767) {
                        var7 = Client.secretCipherBuffer2.method2395();
                        var9 = Client.secretCipherBuffer2.method2395();
                        var8 = Client.secretCipherBuffer2.method2395();
                        var10 = Client.secretCipherBuffer2.method2395();
                     } else if(var7 != 32766) {
                        var9 = Client.secretCipherBuffer2.method2395();
                     } else {
                        var7 = -1;
                     }

                     var11 = Client.secretCipherBuffer2.method2395();
                     var13.method583(var7, var9, var8, var10, Client.gameCycle, var11);
                  }
               }

               var6 = Client.secretCipherBuffer2.readUnsignedByte();
               if(var6 > 0) {
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = Client.secretCipherBuffer2.method2395();
                     var9 = Client.secretCipherBuffer2.method2395();
                     if(var9 != 32767) {
                        var10 = Client.secretCipherBuffer2.method2395();
                        var11 = Client.secretCipherBuffer2.method2409();
                        int var12 = var9 > 0?Client.secretCipherBuffer2.method2409():var11;
                        var13.method580(var8, Client.gameCycle, var9, var10, var11, var12);
                     } else {
                        var13.method587(var8);
                     }
                  }
               }
            }

            if((var14 & 4) != 0) {
               var5 = Client.secretCipherBuffer2.method2420();
               var6 = Client.secretCipherBuffer2.method2419();
               var7 = var13.x - (var5 - class108.baseX - class108.baseX) * 64;
               var8 = var13.y - (var6 - GameEngine.baseY - GameEngine.baseY) * 64;
               if(var7 != 0 || var8 != 0) {
                  var13.field627 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if((var14 & 64) != 0) {
               var13.composition = Widget.getNpcDefinition(Client.secretCipherBuffer2.method2418());
               var13.field603 = var13.composition.field3042;
               var13.field652 = var13.composition.field3048;
               var13.field659 = var13.composition.field3065;
               var13.field608 = var13.composition.field3033;
               var13.field609 = var13.composition.field3062;
               var13.field610 = var13.composition.field3057;
               var13.idlePoseAnimation = var13.composition.field3047;
               var13.field605 = var13.composition.field3043;
               var13.field606 = var13.composition.field3066;
            }

            if((var14 & 1) != 0) {
               var13.graphic = Client.secretCipherBuffer2.method2420();
               var5 = Client.secretCipherBuffer2.readInt();
               var13.field622 = var5 >> 16;
               var13.field639 = Client.gameCycle + (var5 & '\uffff');
               var13.field637 = 0;
               var13.field631 = 0;
               if(var13.field639 > Client.gameCycle) {
                  var13.field637 = -1;
               }

               if(var13.graphic == '\uffff') {
                  var13.graphic = -1;
               }
            }

            if((var14 & 8) != 0) {
               var5 = Client.secretCipherBuffer2.readUnsignedShort();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = Client.secretCipherBuffer2.method2558();
               if(var5 == var13.animation && var5 != -1) {
                  var7 = NPCComposition.getAnimation(var5).replyMode;
                  if(var7 == 1) {
                     var13.actionFrame = 0;
                     var13.field633 = 0;
                     var13.actionAnimationDisable = var6;
                     var13.field635 = 0;
                  }

                  if(var7 == 2) {
                     var13.field635 = 0;
                  }
               } else if(var5 == -1 || var13.animation == -1 || NPCComposition.getAnimation(var5).forcedPriority >= NPCComposition.getAnimation(var13.animation).forcedPriority) {
                  var13.animation = var5;
                  var13.actionFrame = 0;
                  var13.field633 = 0;
                  var13.actionAnimationDisable = var6;
                  var13.field635 = 0;
                  var13.field658 = var13.field653;
               }
            }

            if((var14 & 16) != 0) {
               var13.overhead = Client.secretCipherBuffer2.readString();
               var13.field615 = 100;
            }
         }

         for(var1 = 0; var1 < Client.field407; ++var1) {
            var2 = Client.field408[var1];
            if(Client.cachedNPCs[var2].field648 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.secretCipherBuffer2.offset != Client.packetLength) {
            throw new RuntimeException(Client.secretCipherBuffer2.offset + "," + Client.packetLength);
         } else {
            for(var1 = 0; var1 < Client.field321; ++var1) {
               if(Client.cachedNPCs[Client.field350[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field321);
               }
            }

         }
      }
   }
}
