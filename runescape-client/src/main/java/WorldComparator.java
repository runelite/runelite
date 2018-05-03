import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("n")
   @Export("indexedSpriteOffsetYs")
   static int[] indexedSpriteOffsetYs;
   @ObfuscatedName("d")
   @Export("floorMultiplier")
   static int[] floorMultiplier;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lp;Lp;I)I",
      garbageValue = "374327103"
   )
   int method63(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method63((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "286824349"
   )
   public static boolean method76() {
      long var0 = class289.method5267();
      int var2 = (int)(var0 - class264.field3404);
      class264.field3404 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class264.field3403 += var2;
      if(class264.NetCache_pendingResponsesCount == 0 && class264.NetCache_pendingPriorityResponsesCount == 0 && class264.NetCache_pendingWritesCount == 0 && class264.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if(class264.NetCache_socket == null) {
         return false;
      } else {
         try {
            if(class264.field3403 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class264.NetCache_pendingPriorityResponsesCount < 200 && class264.NetCache_pendingPriorityWritesCount > 0) {
                  var3 = (FileRequest)class264.NetCache_pendingPriorityWrites.first();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class264.NetCache_socket.vmethod3411(var4.payload, 0, 4);
                  class264.NetCache_pendingPriorityResponses.put(var3, var3.hash);
                  --class264.NetCache_pendingPriorityWritesCount;
                  ++class264.NetCache_pendingPriorityResponsesCount;
               }

               while(class264.NetCache_pendingResponsesCount < 200 && class264.NetCache_pendingWritesCount > 0) {
                  var3 = (FileRequest)class264.NetCache_pendingWritesQueue.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class264.NetCache_socket.vmethod3411(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class264.NetCache_pendingResponses.put(var3, var3.hash);
                  --class264.NetCache_pendingWritesCount;
                  ++class264.NetCache_pendingResponsesCount;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class264.NetCache_socket.vmethod3406();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class264.field3403 = 0;
                  byte var5 = 0;
                  if(Buffer.currentRequest == null) {
                     var5 = 8;
                  } else if(class264.field3423 == 0) {
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

                     class264.NetCache_socket.vmethod3426(class264.NetCache_responseHeaderBuffer.payload, class264.NetCache_responseHeaderBuffer.offset, var6);
                     if(class264.field3419 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class264.NetCache_responseHeaderBuffer.payload[class264.NetCache_responseHeaderBuffer.offset + var7] ^= class264.field3419;
                        }
                     }

                     class264.NetCache_responseHeaderBuffer.offset += var6;
                     if(class264.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if(Buffer.currentRequest == null) {
                        class264.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = class264.NetCache_responseHeaderBuffer.readUnsignedShort();
                        int var9 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = class264.NetCache_responseHeaderBuffer.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var11);
                        ChatLineBuffer.field1454 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class264.NetCache_pendingResponses.get(var11);
                           ChatLineBuffer.field1454 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        Buffer.currentRequest = var13;
                        Frames.NetCache_responseArchiveBuffer = new Buffer(var14 + var10 + Buffer.currentRequest.padding);
                        Frames.NetCache_responseArchiveBuffer.putByte(var9);
                        Frames.NetCache_responseArchiveBuffer.putInt(var10);
                        class264.field3423 = 8;
                        class264.NetCache_responseHeaderBuffer.offset = 0;
                     } else if(class264.field3423 == 0) {
                        if(class264.NetCache_responseHeaderBuffer.payload[0] == -1) {
                           class264.field3423 = 1;
                           class264.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           Buffer.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = Frames.NetCache_responseArchiveBuffer.payload.length - Buffer.currentRequest.padding;
                     var7 = 512 - class264.field3423;
                     if(var7 > var6 - Frames.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - Frames.NetCache_responseArchiveBuffer.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class264.NetCache_socket.vmethod3426(Frames.NetCache_responseArchiveBuffer.payload, Frames.NetCache_responseArchiveBuffer.offset, var7);
                     if(class264.field3419 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           Frames.NetCache_responseArchiveBuffer.payload[var8 + Frames.NetCache_responseArchiveBuffer.offset] ^= class264.field3419;
                        }
                     }

                     Frames.NetCache_responseArchiveBuffer.offset += var7;
                     class264.field3423 += var7;
                     if(var6 == Frames.NetCache_responseArchiveBuffer.offset) {
                        if(16711935L == Buffer.currentRequest.hash) {
                           class264.NetCache_reference = Frames.NetCache_responseArchiveBuffer;

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
                           class264.NetCache_crc.update(Frames.NetCache_responseArchiveBuffer.payload, 0, var6);
                           var8 = (int)class264.NetCache_crc.getValue();
                           if(var8 != Buffer.currentRequest.crc) {
                              try {
                                 class264.NetCache_socket.vmethod3404();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class264.field3420;
                              class264.NetCache_socket = null;
                              class264.field3419 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class264.field3420 = 0;
                           class264.field3415 = 0;
                           Buffer.currentRequest.index.write((int)(Buffer.currentRequest.hash & 65535L), Frames.NetCache_responseArchiveBuffer.payload, 16711680L == (Buffer.currentRequest.hash & 16711680L), ChatLineBuffer.field1454);
                        }

                        Buffer.currentRequest.unlink();
                        if(ChatLineBuffer.field1454) {
                           --class264.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --class264.NetCache_pendingResponsesCount;
                        }

                        class264.field3423 = 0;
                        Buffer.currentRequest = null;
                        Frames.NetCache_responseArchiveBuffer = null;
                     } else {
                        if(class264.field3423 != 512) {
                           break;
                        }

                        class264.field3423 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class264.NetCache_socket.vmethod3404();
            } catch (Exception var19) {
               ;
            }

            ++class264.field3415;
            class264.NetCache_socket = null;
            return false;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;Ljava/lang/String;)Lfd;"
   )
   public static RunException method75(Throwable var0, String var1) {
      RunException var2;
      if(var0 instanceof RunException) {
         var2 = (RunException)var0;
         var2.field2171 = var2.field2171 + ' ' + var1;
      } else {
         var2 = new RunException(var0, var1);
      }

      return var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgg;IB)V",
      garbageValue = "0"
   )
   public static void method74(Buffer var0, int var1) {
      if(class167.randomDat != null) {
         try {
            class167.randomDat.seek(0L);
            class167.randomDat.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(Lji;Ljava/lang/String;B)V",
      garbageValue = "-107"
   )
   static void method62(IndexData var0, String var1) {
      class64 var2 = new class64(var0, var1);
      Client.field1120.add(var2);
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Lcm;III)V",
      garbageValue = "-1238820572"
   )
   static final void method73(ContextMenuRow var0, int var1, int var2) {
      GameCanvas.menuAction(var0.param0, var0.param1, var0.type, var0.identifier, var0.option, var0.option, var1, var2);
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method72() {
      Client.field911.method2135(AbstractSoundSystem.method2350(ClientPacket.field2410, Client.field911.field1460));
      Client.field926 = 0;
   }
}
