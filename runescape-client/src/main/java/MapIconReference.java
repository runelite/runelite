import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("MapIconReference")
public class MapIconReference {
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lef;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -805707893
   )
   @Export("areaId")
   public int areaId;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public Coordinates field576;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public Coordinates field574;

   @ObfuscatedSignature(
      signature = "(ILim;Lim;)V"
   )
   public MapIconReference(int var1, Coordinates var2, Coordinates var3) {
      this.areaId = var1;
      this.field576 = var2;
      this.field574 = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1167165949"
   )
   public static boolean method749() {
      long var0 = ScriptVarType.method28();
      int var2 = (int)(var0 - class264.field3413);
      class264.field3413 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class264.field3410 += var2;
      if(class264.NetCache_pendingResponsesCount == 0 && class264.NetCache_pendingPriorityResponsesCount == 0 && class264.NetCache_pendingWritesCount == 0 && class264.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if(class264.NetCache_socket == null) {
         return false;
      } else {
         try {
            if(class264.field3410 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class264.NetCache_pendingPriorityResponsesCount < 200 && class264.NetCache_pendingPriorityWritesCount > 0) {
                  var3 = (FileRequest)class264.NetCache_pendingPriorityWrites.first();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class264.NetCache_socket.vmethod3320(var4.payload, 0, 4);
                  class264.NetCache_pendingPriorityResponses.put(var3, var3.hash);
                  --class264.NetCache_pendingPriorityWritesCount;
                  ++class264.NetCache_pendingPriorityResponsesCount;
               }

               while(class264.NetCache_pendingResponsesCount < 200 && class264.NetCache_pendingWritesCount > 0) {
                  var3 = (FileRequest)class264.NetCache_pendingWritesQueue.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class264.NetCache_socket.vmethod3320(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class264.NetCache_pendingResponses.put(var3, var3.hash);
                  --class264.NetCache_pendingWritesCount;
                  ++class264.NetCache_pendingResponsesCount;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class264.NetCache_socket.vmethod3316();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class264.field3410 = 0;
                  byte var5 = 0;
                  if(GraphicsObject.currentRequest == null) {
                     var5 = 8;
                  } else if(class264.field3416 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class264.NetCache_responseHeaderBuffer.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class264.NetCache_socket.vmethod3318(class264.NetCache_responseHeaderBuffer.payload, class264.NetCache_responseHeaderBuffer.offset, var6);
                     if(class264.field3420 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class264.NetCache_responseHeaderBuffer.payload[var7 + class264.NetCache_responseHeaderBuffer.offset] ^= class264.field3420;
                        }
                     }

                     class264.NetCache_responseHeaderBuffer.offset += var6;
                     if(class264.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if(GraphicsObject.currentRequest == null) {
                        class264.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = class264.NetCache_responseHeaderBuffer.readUnsignedShort();
                        int var9 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = class264.NetCache_responseHeaderBuffer.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var11);
                        IndexStoreActionHandler.field3388 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class264.NetCache_pendingResponses.get(var11);
                           IndexStoreActionHandler.field3388 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        GraphicsObject.currentRequest = var13;
                        ISAACCipher.NetCache_responseArchiveBuffer = new Buffer(var10 + var14 + GraphicsObject.currentRequest.padding);
                        ISAACCipher.NetCache_responseArchiveBuffer.putByte(var9);
                        ISAACCipher.NetCache_responseArchiveBuffer.putInt(var10);
                        class264.field3416 = 8;
                        class264.NetCache_responseHeaderBuffer.offset = 0;
                     } else if(class264.field3416 == 0) {
                        if(class264.NetCache_responseHeaderBuffer.payload[0] == -1) {
                           class264.field3416 = 1;
                           class264.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           GraphicsObject.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = ISAACCipher.NetCache_responseArchiveBuffer.payload.length - GraphicsObject.currentRequest.padding;
                     var7 = 512 - class264.field3416;
                     if(var7 > var6 - ISAACCipher.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - ISAACCipher.NetCache_responseArchiveBuffer.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class264.NetCache_socket.vmethod3318(ISAACCipher.NetCache_responseArchiveBuffer.payload, ISAACCipher.NetCache_responseArchiveBuffer.offset, var7);
                     if(class264.field3420 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           ISAACCipher.NetCache_responseArchiveBuffer.payload[ISAACCipher.NetCache_responseArchiveBuffer.offset + var8] ^= class264.field3420;
                        }
                     }

                     ISAACCipher.NetCache_responseArchiveBuffer.offset += var7;
                     class264.field3416 += var7;
                     if(var6 == ISAACCipher.NetCache_responseArchiveBuffer.offset) {
                        if(16711935L == GraphicsObject.currentRequest.hash) {
                           class264.NetCache_reference = ISAACCipher.NetCache_responseArchiveBuffer;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class264.NetCache_indexCaches[var8];
                              if(var17 != null) {
                                 class264.NetCache_reference.offset = var8 * 8 + 5;
                                 var10 = class264.NetCache_reference.readInt();
                                 int var18 = class264.NetCache_reference.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class264.NetCache_crc.reset();
                           class264.NetCache_crc.update(ISAACCipher.NetCache_responseArchiveBuffer.payload, 0, var6);
                           var8 = (int)class264.NetCache_crc.getValue();
                           if(var8 != GraphicsObject.currentRequest.crc) {
                              try {
                                 class264.NetCache_socket.vmethod3325();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class264.field3423;
                              class264.NetCache_socket = null;
                              class264.field3420 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class264.field3423 = 0;
                           class264.field3422 = 0;
                           GraphicsObject.currentRequest.index.write((int)(GraphicsObject.currentRequest.hash & 65535L), ISAACCipher.NetCache_responseArchiveBuffer.payload, 16711680L == (GraphicsObject.currentRequest.hash & 16711680L), IndexStoreActionHandler.field3388);
                        }

                        GraphicsObject.currentRequest.unlink();
                        if(IndexStoreActionHandler.field3388) {
                           --class264.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --class264.NetCache_pendingResponsesCount;
                        }

                        class264.field3416 = 0;
                        GraphicsObject.currentRequest = null;
                        ISAACCipher.NetCache_responseArchiveBuffer = null;
                     } else {
                        if(class264.field3416 != 512) {
                           break;
                        }

                        class264.field3416 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class264.NetCache_socket.vmethod3325();
            } catch (Exception var19) {
               ;
            }

            ++class264.field3422;
            class264.NetCache_socket = null;
            return false;
         }
      }
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "920120574"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            BoundingBox.clientInstance.method907();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field891 = 0;
            Client.field1110 = 0;
            Client.field1050.method5212(var0);
            if(var0 != 20) {
               class61.method1058(false);
            }
         }

         if(var0 != 20 && var0 != 40 && ContextMenuRow.field1324 != null) {
            ContextMenuRow.field1324.vmethod3325();
            ContextMenuRow.field1324 = null;
         }

         if(Client.gameState == 25) {
            Client.field978 = 0;
            Client.field908 = 0;
            Client.field859 = 1;
            Client.field910 = 0;
            Client.field911 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class178.method3415(Client.indexCache10, class44.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class178.method3415(Client.indexCache10, class44.indexSprites, false, 4);
            } else {
               ClanMemberManager.method5483();
            }
         } else {
            class178.method3415(Client.indexCache10, class44.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-90"
   )
   static final void method746() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class237.plane && Client.gameCycle <= var0.endCycle) {
            if(Client.gameCycle >= var0.startMovementCycle) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.moveProjectile(var1.x, var1.y, class5.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = WorldComparator.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.moveProjectile(var3.x, var3.y, class5.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.update(Client.field893);
               class308.region.method3006(class237.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1017445837"
   )
   static String method747(String var0) {
      Permission[] var1 = class3.method6();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Permission var3 = var1[var2];
         if(var3.field3334 != -1 && var0.startsWith(class22.method186(var3.field3334))) {
            var0 = var0.substring(6 + Integer.toString(var3.field3334).length());
            break;
         }
      }

      return var0;
   }
}
