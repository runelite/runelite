import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class44 extends WorldMapData {
   @ObfuscatedName("b")
   List field602;
   @ObfuscatedName("i")
   HashSet field601;
   @ObfuscatedName("u")
   HashSet field600;

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(Lfg;ZB)V",
      garbageValue = "112"
   )
   void method631(Buffer var1, boolean var2) {
      this.field602 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3252();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field602.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(Lfg;Lfg;Lfg;IZI)V",
      garbageValue = "-29377921"
   )
   void method636(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field601 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method153(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field601.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field600 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method641(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field600.add(var9);
      }

      this.method631(var2, var5);
   }

   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1336070067"
   )
   static String method637(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class148.sessionToken != null) {
         var3 = "/p=" + class148.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class85.field1377 + var3 + "/";
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-290993159"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class207.method3989(var0, class5.field42);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class207.method3989(Client.friends[var3].name, class5.field42)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class207.method3989(AbstractByteBuffer.localPlayer.name, class5.field42))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1539201272"
   )
   static final void method640() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if(var0.hitpoints == 0) {
            if(var0.field1198 >= 0) {
               var2 = var0.field1198;
               var3 = var0.field1200;
               var4 = Occluder.getObjectDefinition(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method4634(var3);
               if(!var1) {
                  continue;
               }
            }

            WorldMapType2.method519(var0.level, var0.type, var0.x, var0.y, var0.field1198, var0.field1199, var0.field1200);
            var0.unlink();
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102) {
               if(var0.id >= 0) {
                  var2 = var0.id;
                  var3 = var0.field1203;
                  var4 = Occluder.getObjectDefinition(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method4634(var3);
                  if(!var1) {
                     continue;
                  }
               }

               WorldMapType2.method519(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1203);
               var0.delay = -1;
               if(var0.id == var0.field1198 && var0.field1198 == -1) {
                  var0.unlink();
               } else if(var0.field1198 == var0.id && var0.field1199 == var0.orientation && var0.field1203 == var0.field1200) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(Lbs;II)V",
      garbageValue = "-2029839406"
   )
   static final void method629(Actor var0, int var1) {
      int var3;
      int var4;
      int var11;
      if(var0.field1255 > Client.gameCycle) {
         ClanMember.method1192(var0);
      } else if(var0.field1254 >= Client.gameCycle) {
         class17.method128(var0);
      } else {
         var0.poseAnimation = var0.idlePoseAnimation;
         if(var0.queueSize == 0) {
            var0.field1251 = 0;
         } else {
            label418: {
               if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                  Sequence var2 = class204.getAnimation(var0.animation);
                  if(var0.field1241 > 0 && var2.precedenceAnimating == 0) {
                     ++var0.field1251;
                     break label418;
                  }

                  if(var0.field1241 <= 0 && var2.priority == 0) {
                     ++var0.field1251;
                     break label418;
                  }
               }

               var11 = var0.x;
               var3 = var0.y;
               var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1211 * 64;
               int var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1211 * 64;
               if(var11 < var4) {
                  if(var3 < var5) {
                     var0.orientation = 1280;
                  } else if(var3 > var5) {
                     var0.orientation = 1792;
                  } else {
                     var0.orientation = 1536;
                  }
               } else if(var11 > var4) {
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

               byte var6 = var0.field1264[var0.queueSize - 1];
               if(var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.orientation - var0.angle & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field1260;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field1215;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field1218;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field1217;
                  }

                  if(var8 == -1) {
                     var8 = var0.field1215;
                  }

                  var0.poseAnimation = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof NPC) {
                     var10 = ((NPC)var0).composition.isClickable;
                  }

                  if(var10) {
                     if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1265 != 0) {
                        var9 = 2;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 3) {
                        var9 = 8;
                     }

                     if(var0.field1251 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1251;
                     }
                  } else {
                     if(var0.queueSize > 1) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 8;
                     }

                     if(var0.field1251 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1251;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.poseAnimation == var0.field1215 && var0.field1219 != -1) {
                     var0.poseAnimation = var0.field1219;
                  }

                  if(var11 != var4 || var3 != var5) {
                     if(var11 < var4) {
                        var0.x += var9;
                        if(var0.x > var4) {
                           var0.x = var4;
                        }
                     } else if(var11 > var4) {
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
                     if(var0.field1241 > 0) {
                        --var0.field1241;
                     }
                  }
               } else {
                  var0.x = var4;
                  var0.y = var5;
                  --var0.queueSize;
                  if(var0.field1241 > 0) {
                     --var0.field1241;
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1255 = 0;
         var0.field1254 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1211 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1211 * 64;
         var0.method1588();
      }

      if(AbstractByteBuffer.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1255 = 0;
         var0.field1254 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1211 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1211 * 64;
         var0.method1588();
      }

      if(var0.field1265 != 0) {
         if(var0.interacting != -1) {
            Object var13 = null;
            if(var0.interacting < '耀') {
               var13 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var13 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var13 != null) {
               var3 = var0.x - ((Actor)var13).x;
               var4 = var0.y - ((Actor)var13).y;
               if(var3 != 0 || var4 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1234) {
               var0.interacting = -1;
               var0.field1234 = false;
            }
         }

         if(var0.field1235 != -1 && (var0.queueSize == 0 || var0.field1251 > 0)) {
            var0.orientation = var0.field1235;
            var0.field1235 = -1;
         }

         var11 = var0.orientation - var0.angle & 2047;
         if(var11 == 0 && var0.field1234) {
            var0.interacting = -1;
            var0.field1234 = false;
         }

         if(var11 != 0) {
            ++var0.field1252;
            boolean var14;
            if(var11 > 1024) {
               var0.angle -= var0.field1265;
               var14 = true;
               if(var11 < var0.field1265 || var11 > 2048 - var0.field1265) {
                  var0.angle = var0.orientation;
                  var14 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1252 > 25 || var14)) {
                  if(var0.field1266 != -1) {
                     var0.poseAnimation = var0.field1266;
                  } else {
                     var0.poseAnimation = var0.field1215;
                  }
               }
            } else {
               var0.angle += var0.field1265;
               var14 = true;
               if(var11 < var0.field1265 || var11 > 2048 - var0.field1265) {
                  var0.angle = var0.orientation;
                  var14 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1252 > 25 || var14)) {
                  if(var0.field1213 != -1) {
                     var0.poseAnimation = var0.field1213;
                  } else {
                     var0.poseAnimation = var0.field1215;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1252 = 0;
         }
      }

      class254.method4607(var0);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-121"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = Preferences.method1645(var0 - 1, var1 - 1) + Preferences.method1645(var0 + 1, var1 - 1) + Preferences.method1645(var0 - 1, var1 + 1) + Preferences.method1645(var0 + 1, var1 + 1);
      int var3 = Preferences.method1645(var0 - 1, var1) + Preferences.method1645(var0 + 1, var1) + Preferences.method1645(var0, var1 - 1) + Preferences.method1645(var0, var1 + 1);
      int var4 = Preferences.method1645(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
