import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("q")
   static boolean field235;
   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -443137477
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -538559971
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1357133025
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 552755495
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 911679263
   )
   @Export("color")
   final int color;

   public BoundingBox2D(int var1, int var2, int var3, int var4, int var5) {
      this.xMin = var1;
      this.yMin = var2;
      this.xMax = var3;
      this.yMax = var4;
      this.color = var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "160"
   )
   final void draw() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "120"
   )
   public static boolean method53() {
      long var0 = ScriptVarType.currentTimeMs();
      int var2 = (int)(var0 - class25.field351);
      class25.field351 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class249.field3321 += var2;
      if(class249.NetCache_pendingResponsesCount == 0 && class249.NetCache_pendingPriorityResponsesCount == 0 && class249.NetCache_pendingWritesCount == 0 && class249.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if(class249.NetCache_socket == null) {
         return false;
      } else {
         try {
            if(class249.field3321 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class249.NetCache_pendingPriorityResponsesCount < 200 && class249.NetCache_pendingPriorityWritesCount > 0) {
                  var3 = (FileRequest)class249.NetCache_pendingPriorityWrites.first();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class249.NetCache_socket.vmethod3192(var4.payload, 0, 4);
                  class249.NetCache_pendingPriorityResponses.put(var3, var3.hash);
                  --class249.NetCache_pendingPriorityWritesCount;
                  ++class249.NetCache_pendingPriorityResponsesCount;
               }

               while(class249.NetCache_pendingResponsesCount < 200 && class249.NetCache_pendingWritesCount > 0) {
                  var3 = (FileRequest)class249.NetCache_pendingWritesQueue.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class249.NetCache_socket.vmethod3192(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class249.NetCache_pendingResponses.put(var3, var3.hash);
                  --class249.NetCache_pendingWritesCount;
                  ++class249.NetCache_pendingResponsesCount;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class249.NetCache_socket.vmethod3188();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class249.field3321 = 0;
                  byte var5 = 0;
                  if(class19.currentRequest == null) {
                     var5 = 8;
                  } else if(class249.field3332 == 0) {
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

                     class249.NetCache_socket.vmethod3190(class249.NetCache_responseHeaderBuffer.payload, class249.NetCache_responseHeaderBuffer.offset, var6);
                     if(class249.field3335 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class249.NetCache_responseHeaderBuffer.payload[class249.NetCache_responseHeaderBuffer.offset + var7] ^= class249.field3335;
                        }
                     }

                     class249.NetCache_responseHeaderBuffer.offset += var6;
                     if(class249.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if(class19.currentRequest == null) {
                        class249.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = class249.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = class249.NetCache_responseHeaderBuffer.readUnsignedShort();
                        int var9 = class249.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = class249.NetCache_responseHeaderBuffer.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class249.NetCache_pendingPriorityResponses.get(var11);
                        field235 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class249.NetCache_pendingResponses.get(var11);
                           field235 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class19.currentRequest = var13;
                        class94.NetCache_responseArchiveBuffer = new Buffer(var10 + var14 + class19.currentRequest.padding);
                        class94.NetCache_responseArchiveBuffer.putByte(var9);
                        class94.NetCache_responseArchiveBuffer.putInt(var10);
                        class249.field3332 = 8;
                        class249.NetCache_responseHeaderBuffer.offset = 0;
                     } else if(class249.field3332 == 0) {
                        if(class249.NetCache_responseHeaderBuffer.payload[0] == -1) {
                           class249.field3332 = 1;
                           class249.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           class19.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = class94.NetCache_responseArchiveBuffer.payload.length - class19.currentRequest.padding;
                     var7 = 512 - class249.field3332;
                     if(var7 > var6 - class94.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - class94.NetCache_responseArchiveBuffer.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class249.NetCache_socket.vmethod3190(class94.NetCache_responseArchiveBuffer.payload, class94.NetCache_responseArchiveBuffer.offset, var7);
                     if(class249.field3335 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class94.NetCache_responseArchiveBuffer.payload[var8 + class94.NetCache_responseArchiveBuffer.offset] ^= class249.field3335;
                        }
                     }

                     class94.NetCache_responseArchiveBuffer.offset += var7;
                     class249.field3332 += var7;
                     if(var6 == class94.NetCache_responseArchiveBuffer.offset) {
                        if(class19.currentRequest.hash == 16711935L) {
                           class87.NetCache_reference = class94.NetCache_responseArchiveBuffer;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class249.NetCache_indexCaches[var8];
                              if(var17 != null) {
                                 class87.NetCache_reference.offset = var8 * 8 + 5;
                                 var10 = class87.NetCache_reference.readInt();
                                 int var18 = class87.NetCache_reference.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class249.NetCache_crc.reset();
                           class249.NetCache_crc.update(class94.NetCache_responseArchiveBuffer.payload, 0, var6);
                           var8 = (int)class249.NetCache_crc.getValue();
                           if(var8 != class19.currentRequest.crc) {
                              try {
                                 class249.NetCache_socket.vmethod3186();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class249.field3336;
                              class249.NetCache_socket = null;
                              class249.field3335 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class249.field3336 = 0;
                           class249.field3337 = 0;
                           class19.currentRequest.index.write((int)(class19.currentRequest.hash & 65535L), class94.NetCache_responseArchiveBuffer.payload, (class19.currentRequest.hash & 16711680L) == 16711680L, field235);
                        }

                        class19.currentRequest.unlink();
                        if(field235) {
                           --class249.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --class249.NetCache_pendingResponsesCount;
                        }

                        class249.field3332 = 0;
                        class19.currentRequest = null;
                        class94.NetCache_responseArchiveBuffer = null;
                     } else {
                        if(class249.field3332 != 512) {
                           break;
                        }

                        class249.field3332 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class249.NetCache_socket.vmethod3186();
            } catch (Exception var19) {
               ;
            }

            ++class249.field3337;
            class249.NetCache_socket = null;
            return false;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;Ljava/lang/String;I)[Lko;",
      garbageValue = "1672793030"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      SpritePixels[] var5;
      if(!class160.method3147(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = Fonts.method5199();
      }

      return var5;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "509912798"
   )
   static final void method54(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4904()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1127 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field909[var4][var5] == Client.field821) {
                     continue;
                  }

                  Client.field909[var4][var5] = Client.field821;
               }

               if(!var2.composition.field3630) {
                  var3 -= Integer.MIN_VALUE;
               }

               class48.region.method2822(MessageNode.plane, var2.x, var2.y, GameCanvas.getTileHeight(var2.field1127 * 64 - 64 + var2.x, var2.field1127 * 64 - 64 + var2.y, MessageNode.plane), var2.field1127 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1132);
            }
         }
      }

   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "98"
   )
   static void method55() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.menuBooleanArray[var3] = Client.menuBooleanArray[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
