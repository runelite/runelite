import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("JagexGame")
public enum JagexGame implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3293("runescape", "RuneScape", 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3290("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3291("game3", "Game 3", 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3292("game4", "Game 4", 3),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3296("game5", "Game 5", 4),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3289("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -1528030989
   )
   static int field3297;
   @ObfuscatedName("t")
   @Export("name")
   public final String name;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1037398473
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "690461627"
   )
   public static boolean method4243() {
      long var0 = Preferences.currentTimeMs();
      int var2 = (int)(var0 - class188.field2539);
      class188.field2539 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class249.field3344 += var2;
      if(class249.NetCache_pendingResponsesCount == 0 && class249.NetCache_pendingPriorityResponsesCount == 0 && class249.NetCache_pendingWritesCount == 0 && class249.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if(class249.NetCache_socket == null) {
         return false;
      } else {
         try {
            if(class249.field3344 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class249.NetCache_pendingPriorityResponsesCount < 20 && class249.NetCache_pendingPriorityWritesCount > 0) {
                  var3 = (FileRequest)class249.NetCache_pendingPriorityWrites.first();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class249.NetCache_socket.vmethod3082(var4.payload, 0, 4);
                  class249.NetCache_pendingPriorityResponses.put(var3, var3.hash);
                  --class249.NetCache_pendingPriorityWritesCount;
                  ++class249.NetCache_pendingPriorityResponsesCount;
               }

               while(class249.NetCache_pendingResponsesCount < 20 && class249.NetCache_pendingWritesCount > 0) {
                  var3 = (FileRequest)class249.NetCache_pendingWritesQueue.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class249.NetCache_socket.vmethod3082(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class249.NetCache_pendingResponses.put(var3, var3.hash);
                  --class249.NetCache_pendingWritesCount;
                  ++class249.NetCache_pendingResponsesCount;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class249.NetCache_socket.vmethod3083();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class249.field3344 = 0;
                  byte var5 = 0;
                  if(class61.currentRequest == null) {
                     var5 = 8;
                  } else if(class249.field3356 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class249.NetCache_responseHeaderBuffer.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class249.NetCache_socket.vmethod3085(class249.NetCache_responseHeaderBuffer.payload, class249.NetCache_responseHeaderBuffer.offset, var6);
                     if(class249.field3358 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class249.NetCache_responseHeaderBuffer.payload[class249.NetCache_responseHeaderBuffer.offset + var7] ^= class249.field3358;
                        }
                     }

                     class249.NetCache_responseHeaderBuffer.offset += var6;
                     if(class249.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if(class61.currentRequest == null) {
                        class249.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = class249.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = class249.NetCache_responseHeaderBuffer.readUnsignedShort();
                        int var9 = class249.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = class249.NetCache_responseHeaderBuffer.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class249.NetCache_pendingPriorityResponses.get(var11);
                        class25.field347 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class249.NetCache_pendingResponses.get(var11);
                           class25.field347 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class61.currentRequest = var13;
                        class287.NetCache_responseArchiveBuffer = new Buffer(var14 + var10 + class61.currentRequest.padding);
                        class287.NetCache_responseArchiveBuffer.putByte(var9);
                        class287.NetCache_responseArchiveBuffer.putInt(var10);
                        class249.field3356 = 8;
                        class249.NetCache_responseHeaderBuffer.offset = 0;
                     } else if(class249.field3356 == 0) {
                        if(class249.NetCache_responseHeaderBuffer.payload[0] == -1) {
                           class249.field3356 = 1;
                           class249.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           class61.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = class287.NetCache_responseArchiveBuffer.payload.length - class61.currentRequest.padding;
                     var7 = 512 - class249.field3356;
                     if(var7 > var6 - class287.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - class287.NetCache_responseArchiveBuffer.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class249.NetCache_socket.vmethod3085(class287.NetCache_responseArchiveBuffer.payload, class287.NetCache_responseArchiveBuffer.offset, var7);
                     if(class249.field3358 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class287.NetCache_responseArchiveBuffer.payload[var8 + class287.NetCache_responseArchiveBuffer.offset] ^= class249.field3358;
                        }
                     }

                     class287.NetCache_responseArchiveBuffer.offset += var7;
                     class249.field3356 += var7;
                     if(var6 == class287.NetCache_responseArchiveBuffer.offset) {
                        if(16711935L == class61.currentRequest.hash) {
                           SoundTask.NetCache_reference = class287.NetCache_responseArchiveBuffer;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class249.NetCache_indexCaches[var8];
                              if(var17 != null) {
                                 SoundTask.NetCache_reference.offset = var8 * 8 + 5;
                                 var10 = SoundTask.NetCache_reference.readInt();
                                 int var18 = SoundTask.NetCache_reference.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class249.NetCache_crc.reset();
                           class249.NetCache_crc.update(class287.NetCache_responseArchiveBuffer.payload, 0, var6);
                           var8 = (int)class249.NetCache_crc.getValue();
                           if(var8 != class61.currentRequest.crc) {
                              try {
                                 class249.NetCache_socket.vmethod3081();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class249.field3345;
                              class249.NetCache_socket = null;
                              class249.field3358 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class249.field3345 = 0;
                           class249.field3360 = 0;
                           class61.currentRequest.index.write((int)(class61.currentRequest.hash & 65535L), class287.NetCache_responseArchiveBuffer.payload, (class61.currentRequest.hash & 16711680L) == 16711680L, class25.field347);
                        }

                        class61.currentRequest.unlink();
                        if(class25.field347) {
                           --class249.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --class249.NetCache_pendingResponsesCount;
                        }

                        class249.field3356 = 0;
                        class61.currentRequest = null;
                        class287.NetCache_responseArchiveBuffer = null;
                     } else {
                        if(class249.field3356 != 512) {
                           break;
                        }

                        class249.field3356 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class249.NetCache_socket.vmethod3081();
            } catch (Exception var19) {
               ;
            }

            ++class249.field3360;
            class249.NetCache_socket = null;
            return false;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;Lib;I)V",
      garbageValue = "-463905442"
   )
   public static void method4250(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.NpcDefinition_indexCache = var0;
      NPCComposition.NpcDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "2097547679"
   )
   static final void method4249(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class48.region.method2716(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class48.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = BoundingBox3D.field250.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = CacheFile.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = AttackOption.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5176(var15 + var1 * 4 + 48, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class48.region.method2718(var0, var1, var2);
      if(var5 != 0) {
         var6 = class48.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = CacheFile.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = AttackOption.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method5176(var1 * 4 + var12 + 48, var18 + (104 - var2 - var23.sizeY) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = BoundingBox3D.field250.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class48.region.method2840(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = CacheFile.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = AttackOption.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method5176(var9 + var1 * 4 + 48, var21 + (104 - var2 - var19.sizeY) * 4 + 48);
            }
         }
      }

   }
}
