import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("Resampler")
public class Resampler {
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 65564479
   )
   public static int field1563;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1726075489
   )
   @Export("storedSampleRateRatio")
   int storedSampleRateRatio;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1696964183
   )
   @Export("playbackSampleRateRatio")
   int playbackSampleRateRatio;
   @ObfuscatedName("h")
   @Export("resampleTable")
   int[][] resampleTable;

   public Resampler(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class153.method3140(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.storedSampleRateRatio = var1;
         this.playbackSampleRateRatio = var2;
         this.resampleTable = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.resampleTable[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var8 - var6));
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-53"
   )
   @Export("resampleIfNecessary")
   byte[] resampleIfNecessary(byte[] var1) {
      if(this.resampleTable != null) {
         int var2 = (int)((long)var1.length * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.resampleTable[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.playbackSampleRateRatio;
            var9 = var5 / this.storedSampleRateRatio;
            var4 += var9;
            var5 -= var9 * this.storedSampleRateRatio;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + 32768 >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1486326149"
   )
   int method2297(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)this.playbackSampleRateRatio * (long)var1 / (long)this.storedSampleRateRatio);
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-1"
   )
   int method2294(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)var1 * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio) + 6;
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfi;ZI)V",
      garbageValue = "-646317282"
   )
   public static void method2306(class168 var0, boolean var1) {
      if(class258.NetCache_socket != null) {
         try {
            class258.NetCache_socket.vmethod3317();
         } catch (Exception var6) {
            ;
         }

         class258.NetCache_socket = null;
      }

      class258.NetCache_socket = var0;
      class230.sendConInfo(var1);
      class258.NetCache_responseHeaderBuffer.offset = 0;
      class168.currentRequest = null;
      VertexNormal.NetCache_responseArchiveBuffer = null;
      class258.field3369 = 0;

      while(true) {
         FileRequest var2 = (FileRequest)class258.NetCache_pendingPriorityResponses.first();
         if(var2 == null) {
            while(true) {
               var2 = (FileRequest)class258.NetCache_pendingResponses.first();
               if(var2 == null) {
                  if(class258.field3372 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class258.field3372);
                        var7.putShort(0);
                        class258.NetCache_socket.vmethod3323(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class258.NetCache_socket.vmethod3317();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class258.field3374;
                        class258.NetCache_socket = null;
                     }
                  }

                  class258.field3373 = 0;
                  class258.field3358 = class188.currentTimeMs();
                  return;
               }

               class258.NetCache_pendingWritesQueue.setHead(var2);
               class258.NetCache_pendingWrites.put(var2, var2.hash);
               ++class258.NetCache_pendingWritesCount;
               --class258.NetCache_pendingResponsesCount;
            }
         }

         class258.NetCache_pendingPriorityWrites.put(var2, var2.hash);
         ++class258.NetCache_pendingPriorityWritesCount;
         --class258.NetCache_pendingPriorityResponsesCount;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;IIIIIII)V",
      garbageValue = "-1245175209"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -Ignore.method5331(932731 + var2 + var4, var3 + 556238 + var5) * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class235.field2764[var1][var2][var3] = var0.readByte();
               ContextMenuRow.field1282[var1][var2][var3] = (byte)((var7 - 2) / 4);
               BaseVarType.field27[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class61.field687[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   static final void method2309() {
      int[] var0 = class92.playerIndices;

      int var1;
      for(var1 = 0; var1 < class92.playerIndexesCount; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.overheadTextCyclesRemaining > 0) {
            --var2.overheadTextCyclesRemaining;
            if(var2.overheadTextCyclesRemaining == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.overheadTextCyclesRemaining > 0) {
            --var3.overheadTextCyclesRemaining;
            if(var3.overheadTextCyclesRemaining == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "768835271"
   )
   static void method2310() {
      PacketNode var0 = class61.method1076(ClientPacket.field2346, Client.field863.field1434);
      PacketBuffer var1 = var0.packetBuffer;
      int var2 = Client.isResized?2:1;
      var1.putByte(var2);
      var0.packetBuffer.putShort(class1.canvasWidth);
      var0.packetBuffer.putShort(class25.canvasHeight);
      Client.field863.method2039(var0);
   }
}
