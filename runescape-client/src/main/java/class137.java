import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class137 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2044434839"
   )
   public static boolean method3102() {
      long var0 = SceneTilePaint.currentTimeMs();
      int var2 = (int)(var0 - class249.field3337);
      class249.field3337 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class249.field3342 += var2;
      if(class249.NetCache_pendingResponsesCount == 0 && class249.NetCache_pendingPriorityResponsesCount == 0 && class249.NetCache_pendingWritesCount == 0 && class249.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if(class19.NetCache_socket == null) {
         return false;
      } else {
         try {
            if(class249.field3342 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class249.NetCache_pendingPriorityResponsesCount < 200 && class249.NetCache_pendingPriorityWritesCount > 0) {
                  var3 = (FileRequest)class249.NetCache_pendingPriorityWrites.first();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class19.NetCache_socket.vmethod3304(var4.payload, 0, 4);
                  class249.NetCache_pendingPriorityResponses.put(var3, var3.hash);
                  --class249.NetCache_pendingPriorityWritesCount;
                  ++class249.NetCache_pendingPriorityResponsesCount;
               }

               while(class249.NetCache_pendingResponsesCount < 200 && class249.NetCache_pendingWritesCount > 0) {
                  var3 = (FileRequest)class249.NetCache_pendingWritesQueue.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class19.NetCache_socket.vmethod3304(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class249.NetCache_pendingResponses.put(var3, var3.hash);
                  --class249.NetCache_pendingWritesCount;
                  ++class249.NetCache_pendingResponsesCount;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class19.NetCache_socket.vmethod3300();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class249.field3342 = 0;
                  byte var5 = 0;
                  if(VertexNormal.currentRequest == null) {
                     var5 = 8;
                  } else if(class249.field3338 == 0) {
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

                     class19.NetCache_socket.vmethod3302(class249.NetCache_responseHeaderBuffer.payload, class249.NetCache_responseHeaderBuffer.offset, var6);
                     if(class249.field3353 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class249.NetCache_responseHeaderBuffer.payload[class249.NetCache_responseHeaderBuffer.offset + var7] ^= class249.field3353;
                        }
                     }

                     class249.NetCache_responseHeaderBuffer.offset += var6;
                     if(class249.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if(VertexNormal.currentRequest == null) {
                        class249.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = class249.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = class249.NetCache_responseHeaderBuffer.readUnsignedShort();
                        int var9 = class249.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = class249.NetCache_responseHeaderBuffer.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class249.NetCache_pendingPriorityResponses.get(var11);
                        SceneTilePaint.field1927 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class249.NetCache_pendingResponses.get(var11);
                           SceneTilePaint.field1927 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        VertexNormal.currentRequest = var13;
                        class249.NetCache_responseArchiveBuffer = new Buffer(var14 + var10 + VertexNormal.currentRequest.padding);
                        class249.NetCache_responseArchiveBuffer.putByte(var9);
                        class249.NetCache_responseArchiveBuffer.putInt(var10);
                        class249.field3338 = 8;
                        class249.NetCache_responseHeaderBuffer.offset = 0;
                     } else if(class249.field3338 == 0) {
                        if(class249.NetCache_responseHeaderBuffer.payload[0] == -1) {
                           class249.field3338 = 1;
                           class249.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           VertexNormal.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = class249.NetCache_responseArchiveBuffer.payload.length - VertexNormal.currentRequest.padding;
                     var7 = 512 - class249.field3338;
                     if(var7 > var6 - class249.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - class249.NetCache_responseArchiveBuffer.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class19.NetCache_socket.vmethod3302(class249.NetCache_responseArchiveBuffer.payload, class249.NetCache_responseArchiveBuffer.offset, var7);
                     if(class249.field3353 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class249.NetCache_responseArchiveBuffer.payload[class249.NetCache_responseArchiveBuffer.offset + var8] ^= class249.field3353;
                        }
                     }

                     class249.NetCache_responseArchiveBuffer.offset += var7;
                     class249.field3338 += var7;
                     if(var6 == class249.NetCache_responseArchiveBuffer.offset) {
                        if(16711935L == VertexNormal.currentRequest.hash) {
                           class150.NetCache_reference = class249.NetCache_responseArchiveBuffer;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class249.NetCache_indexCaches[var8];
                              if(var17 != null) {
                                 class150.NetCache_reference.offset = var8 * 8 + 5;
                                 var10 = class150.NetCache_reference.readInt();
                                 int var18 = class150.NetCache_reference.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class249.NetCache_crc.reset();
                           class249.NetCache_crc.update(class249.NetCache_responseArchiveBuffer.payload, 0, var6);
                           var8 = (int)class249.NetCache_crc.getValue();
                           if(var8 != VertexNormal.currentRequest.crc) {
                              try {
                                 class19.NetCache_socket.vmethod3299();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class249.field3354;
                              class19.NetCache_socket = null;
                              class249.field3353 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class249.field3354 = 0;
                           class249.field3355 = 0;
                           VertexNormal.currentRequest.index.write((int)(VertexNormal.currentRequest.hash & 65535L), class249.NetCache_responseArchiveBuffer.payload, 16711680L == (VertexNormal.currentRequest.hash & 16711680L), SceneTilePaint.field1927);
                        }

                        VertexNormal.currentRequest.unlink();
                        if(SceneTilePaint.field1927) {
                           --class249.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --class249.NetCache_pendingResponsesCount;
                        }

                        class249.field3338 = 0;
                        VertexNormal.currentRequest = null;
                        class249.NetCache_responseArchiveBuffer = null;
                     } else {
                        if(class249.field3338 != 512) {
                           break;
                        }

                        class249.field3338 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class19.NetCache_socket.vmethod3299();
            } catch (Exception var19) {
               ;
            }

            ++class249.field3355;
            class19.NetCache_socket = null;
            return false;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1862214698"
   )
   public static final void method3104(int var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox2D(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Lbl;ZB)V",
      garbageValue = "1"
   )
   static final void method3103(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && GrandExchangeOffer.validInterfaces[var2]) {
         class60.widgetIndex.method4517(var2);
         if(ScriptState.widgets[var2] != null) {
            boolean var6 = true;

            for(var5 = 0; var5 < ScriptState.widgets[var2].length; ++var5) {
               if(ScriptState.widgets[var2][var5] != null) {
                  if(ScriptState.widgets[var2][var5].type != 2) {
                     ScriptState.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               ScriptState.widgets[var2] = null;
            }

            GrandExchangeOffer.validInterfaces[var2] = false;
         }
      }

      World.method1661(var2);
      Widget var4 = class216.getWidget(var3);
      if(var4 != null) {
         class33.method341(var4);
      }

      class80.method1825();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(ServerPacket.loadWidget(var5)) {
            WorldMapType1.method269(ScriptState.widgets[var5], 1);
         }
      }

   }
}
