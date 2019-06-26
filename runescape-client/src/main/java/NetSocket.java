import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("NetSocket")
public final class NetSocket extends AbstractSocket implements Runnable {
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("worldSelectRightSprite")
   static IndexedSprite worldSelectRightSprite;
   @ObfuscatedName("m")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("f")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("q")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("w")
   @Export("isClosed")
   boolean isClosed;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   @Export("taskHandler")
   TaskHandler taskHandler;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("task")
   Task task;
   @ObfuscatedName("g")
   @Export("array")
   byte[] array;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -738185459
   )
   @Export("__l")
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2057244853
   )
   @Export("__e")
   int __e;
   @ObfuscatedName("x")
   @Export("exceptionWriting")
   boolean exceptionWriting;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1644762957
   )
   @Export("__d")
   final int __d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -782964015
   )
   @Export("__k")
   final int __k;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfz;I)V"
   )
   public NetSocket(Socket var1, TaskHandler var2, int var3) throws IOException {
      this.isClosed = false;
      this.__l = 0;
      this.__e = 0;
      this.exceptionWriting = false;
      this.taskHandler = var2;
      this.socket = var1;
      this.__d = var3;
      this.__k = var3 - 100;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(65536);
      this.socket.setSendBufferSize(65536);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1765046516"
   )
   public boolean isAvailable(int var1) throws IOException {
      return this.isClosed?false:this.inputStream.available() >= var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1078471130"
   )
   public int available() throws IOException {
      return this.isClosed?0:this.inputStream.available();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "516705222"
   )
   public int readUnsignedByte() throws IOException {
      return this.isClosed?0:this.inputStream.read();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1089665746"
   )
   public int read(byte[] var1, int var2, int var3) throws IOException {
      if(this.isClosed) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.inputStream.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-86"
   )
   public void write(byte[] var1, int var2, int var3) throws IOException {
      this.write0(var1, var2, var3);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1252618448"
   )
   public void close() {
      if(!this.isClosed) {
         synchronized(this) {
            this.isClosed = true;
            this.notifyAll();
         }

         if(this.task != null) {
            while(this.task.status == 0) {
               class203.method4010(1L);
            }

            if(this.task.status == 1) {
               try {
                  ((Thread)this.task.result).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.task = null;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-77"
   )
   @Export("write0")
   void write0(byte[] var1, int var2, int var3) throws IOException {
      if(!this.isClosed) {
         if(this.exceptionWriting) {
            this.exceptionWriting = false;
            throw new IOException();
         } else {
            if(this.array == null) {
               this.array = new byte[this.__d];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.array[this.__e] = var1[var5 + var2];
                  this.__e = (this.__e + 1) % this.__d;
                  if((this.__k + this.__l) % this.__d == this.__e) {
                     throw new IOException();
                  }
               }

               if(this.task == null) {
                  this.task = this.taskHandler.newThreadTask(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.__e == this.__l) {
                     if(this.isClosed) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.__l;
                  if(this.__e >= this.__l) {
                     var1 = this.__e - this.__l;
                  } else {
                     var1 = this.__d - this.__l;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.array, var2, var1);
               } catch (IOException var9) {
                  this.exceptionWriting = true;
               }

               this.__l = (var1 + this.__l) % this.__d;

               try {
                  if(this.__e == this.__l) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.exceptionWriting = true;
               }
               continue;
            }

            try {
               if(this.inputStream != null) {
                  this.inputStream.close();
               }

               if(this.outputStream != null) {
                  this.outputStream.close();
               }

               if(this.socket != null) {
                  this.socket.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.array = null;
            break;
         }
      } catch (Exception var12) {
         NpcDefinition.sendStackTrace((String)null, var12);
      }

   }

   @Export("finalize")
   @ObfuscatedName("finalize")
   protected void finalize() {
      this.close();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILfe;Lfy;Z[I[IB)I",
      garbageValue = "-98"
   )
   public static int calculateRoute(int srcX, int srcY, int srcSize, RouteStrategy strategy, CollisionMap collisionMap, boolean var5, int[] bufferX, int[] bufferY) {
      int graphBaseX;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(graphBaseX = 0; graphBaseX < 128; ++graphBaseX) {
            class178.directions[var8][graphBaseX] = 0;
            class178.distances[var8][graphBaseX] = 99999999;
         }
      }

      int graphBaseY;
      int endX;
      byte var13;
      int lowestDistance;
      int var15;
      int approxDestY;
      int approxDestSizeY;
      int checkX;
      int checkY;
      boolean found;
      int endY;
      int lowestCost;
      int approxDestX;
      if(srcSize == 1) {
         graphBaseY = srcX;
         endX = srcY;
         byte var12 = 64;
         var13 = 64;
         lowestDistance = srcX - var12;
         var15 = srcY - var13;
         class178.directions[var12][var13] = 99;
         class178.distances[var12][var13] = 0;
         byte var16 = 0;
         approxDestY = 0;
         class178.bufferX[var16] = srcX;
         approxDestX = var16 + 1;
         class178.bufferY[var16] = srcY;
         int[][] var18 = collisionMap.flags;

         boolean var29;
         while(true) {
            if(approxDestX == approxDestY) {
               WidgetGroupParent.__bx_o = graphBaseY;
               UrlRequester.__eo_u = endX;
               var29 = false;
               break;
            }

            graphBaseY = class178.bufferX[approxDestY];
            endX = class178.bufferY[approxDestY];
            approxDestY = approxDestY + 1 & 4095;
            endY = graphBaseY - lowestDistance;
            lowestCost = endX - var15;
            approxDestSizeY = graphBaseY - collisionMap.xInset;
            checkX = endX - collisionMap.yInset;
            if(strategy.vmethod3644(1, graphBaseY, endX, collisionMap)) {
               WidgetGroupParent.__bx_o = graphBaseY;
               UrlRequester.__eo_u = endX;
               var29 = true;
               break;
            }

            checkY = class178.distances[endY][lowestCost] + 1;
            if(endY > 0 && class178.directions[endY - 1][lowestCost] == 0 && (var18[approxDestSizeY - 1][checkX] & 19136776) == 0) {
               class178.bufferX[approxDestX] = graphBaseY - 1;
               class178.bufferY[approxDestX] = endX;
               approxDestX = approxDestX + 1 & 4095;
               class178.directions[endY - 1][lowestCost] = 2;
               class178.distances[endY - 1][lowestCost] = checkY;
            }

            if(endY < 127 && class178.directions[endY + 1][lowestCost] == 0 && (var18[approxDestSizeY + 1][checkX] & 19136896) == 0) {
               class178.bufferX[approxDestX] = graphBaseY + 1;
               class178.bufferY[approxDestX] = endX;
               approxDestX = approxDestX + 1 & 4095;
               class178.directions[endY + 1][lowestCost] = 8;
               class178.distances[endY + 1][lowestCost] = checkY;
            }

            if(lowestCost > 0 && class178.directions[endY][lowestCost - 1] == 0 && (var18[approxDestSizeY][checkX - 1] & 19136770) == 0) {
               class178.bufferX[approxDestX] = graphBaseY;
               class178.bufferY[approxDestX] = endX - 1;
               approxDestX = approxDestX + 1 & 4095;
               class178.directions[endY][lowestCost - 1] = 1;
               class178.distances[endY][lowestCost - 1] = checkY;
            }

            if(lowestCost < 127 && class178.directions[endY][lowestCost + 1] == 0 && (var18[approxDestSizeY][checkX + 1] & 19136800) == 0) {
               class178.bufferX[approxDestX] = graphBaseY;
               class178.bufferY[approxDestX] = endX + 1;
               approxDestX = approxDestX + 1 & 4095;
               class178.directions[endY][lowestCost + 1] = 4;
               class178.distances[endY][lowestCost + 1] = checkY;
            }

            if(endY > 0 && lowestCost > 0 && class178.directions[endY - 1][lowestCost - 1] == 0 && (var18[approxDestSizeY - 1][checkX - 1] & 19136782) == 0 && (var18[approxDestSizeY - 1][checkX] & 19136776) == 0 && (var18[approxDestSizeY][checkX - 1] & 19136770) == 0) {
               class178.bufferX[approxDestX] = graphBaseY - 1;
               class178.bufferY[approxDestX] = endX - 1;
               approxDestX = approxDestX + 1 & 4095;
               class178.directions[endY - 1][lowestCost - 1] = 3;
               class178.distances[endY - 1][lowestCost - 1] = checkY;
            }

            if(endY < 127 && lowestCost > 0 && class178.directions[endY + 1][lowestCost - 1] == 0 && (var18[approxDestSizeY + 1][checkX - 1] & 19136899) == 0 && (var18[approxDestSizeY + 1][checkX] & 19136896) == 0 && (var18[approxDestSizeY][checkX - 1] & 19136770) == 0) {
               class178.bufferX[approxDestX] = graphBaseY + 1;
               class178.bufferY[approxDestX] = endX - 1;
               approxDestX = approxDestX + 1 & 4095;
               class178.directions[endY + 1][lowestCost - 1] = 9;
               class178.distances[endY + 1][lowestCost - 1] = checkY;
            }

            if(endY > 0 && lowestCost < 127 && class178.directions[endY - 1][lowestCost + 1] == 0 && (var18[approxDestSizeY - 1][checkX + 1] & 19136824) == 0 && (var18[approxDestSizeY - 1][checkX] & 19136776) == 0 && (var18[approxDestSizeY][checkX + 1] & 19136800) == 0) {
               class178.bufferX[approxDestX] = graphBaseY - 1;
               class178.bufferY[approxDestX] = endX + 1;
               approxDestX = approxDestX + 1 & 4095;
               class178.directions[endY - 1][lowestCost + 1] = 6;
               class178.distances[endY - 1][lowestCost + 1] = checkY;
            }

            if(endY < 127 && lowestCost < 127 && class178.directions[endY + 1][lowestCost + 1] == 0 && (var18[approxDestSizeY + 1][checkX + 1] & 19136992) == 0 && (var18[approxDestSizeY + 1][checkX] & 19136896) == 0 && (var18[approxDestSizeY][checkX + 1] & 19136800) == 0) {
               class178.bufferX[approxDestX] = graphBaseY + 1;
               class178.bufferY[approxDestX] = endX + 1;
               approxDestX = approxDestX + 1 & 4095;
               class178.directions[endY + 1][lowestCost + 1] = 12;
               class178.distances[endY + 1][lowestCost + 1] = checkY;
            }
         }

         found = var29; // Vars are weird above here cause that's an inlined method
      } else if(srcSize == 2) {
         found = WorldMapSection2.method593(srcX, srcY, strategy, collisionMap);
      } else {
         found = IndexStore.method3585(srcX, srcY, srcSize, strategy, collisionMap);
      }

      graphBaseX = srcX - 64;
      graphBaseY = srcY - 64;
      endX = WidgetGroupParent.__bx_o;
      endY = UrlRequester.__eo_u;
      if(!found) {
         lowestCost = Integer.MAX_VALUE;
         lowestDistance = Integer.MAX_VALUE;
         byte alternativeRouteRange = 10;
         approxDestX = strategy.approxDestinationX;
         approxDestY = strategy.approxDestinationY;
         int approxDestSizeX = strategy.approxDestinationSizeX;
         approxDestSizeY = strategy.approxDestinationSizeY;

         for(checkX = approxDestX - alternativeRouteRange; checkX <= alternativeRouteRange + approxDestX; ++checkX) {
            for(checkY = approxDestY - alternativeRouteRange; checkY <= approxDestY + alternativeRouteRange; ++checkY) {
               int graphX = checkX - graphBaseX;
               int graphY = checkY - graphBaseY;
               if(graphX >= 0 && graphY >= 0 && graphX < 128 && graphY < 128 && class178.distances[graphX][graphY] < 100) {
                  int deltaX = 0;
                  if(checkX < approxDestX) {
                     deltaX = approxDestX - checkX;
                  } else if(checkX > approxDestSizeX + approxDestX - 1) {
                     deltaX = checkX - (approxDestSizeX + approxDestX - 1);
                  }

                  int deltaY = 0;
                  if(checkY < approxDestY) {
                     deltaY = approxDestY - checkY;
                  } else if(checkY > approxDestSizeY + approxDestY - 1) {
                     deltaY = checkY - (approxDestSizeY + approxDestY - 1);
                  }

                  int cost = deltaY * deltaY + deltaX * deltaX;
                  if(cost < lowestCost || cost == lowestCost && class178.distances[graphX][graphY] < lowestDistance) {
                     lowestCost = cost;
                     lowestDistance = class178.distances[graphX][graphY];
                     endX = checkX;
                     endY = checkY;
                  }
               }
            }
         }

         if(lowestCost == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(srcX == endX && endY == srcY) {
         return 0;
      } else { // Inlined again after this I think
         var13 = 0;
         class178.bufferX[var13] = endX;
         lowestCost = var13 + 1;
         class178.bufferY[var13] = endY;

         for(lowestDistance = var15 = class178.directions[endX - graphBaseX][endY - graphBaseY]; srcX != endX || endY != srcY; lowestDistance = class178.directions[endX - graphBaseX][endY - graphBaseY]) {
            if(lowestDistance != var15) {
               var15 = lowestDistance;
               class178.bufferX[lowestCost] = endX;
               class178.bufferY[lowestCost++] = endY;
            }

            if((lowestDistance & 2) != 0) {
               ++endX;
            } else if((lowestDistance & 8) != 0) {
               --endX;
            }

            if((lowestDistance & 1) != 0) {
               ++endY;
            } else if((lowestDistance & 4) != 0) {
               --endY;
            }
         }

         approxDestX = 0;

         while(lowestCost-- > 0) {
            bufferX[approxDestX] = class178.bufferX[lowestCost];
            bufferY[approxDestX++] = class178.bufferY[lowestCost];
            if(approxDestX >= bufferX.length) {
               break;
            }
         }

         return approxDestX;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;Lir;Lhm;I)Z",
      garbageValue = "-590103687"
   )
   public static boolean method3537(AbstractIndexCache var0, AbstractIndexCache var1, AbstractIndexCache var2, MidiPcmStream var3) {
      class1.__f_m = var0;
      class214.__hf_f = var1;
      class214.__hf_q = var2;
      class214.midiPcmStream = var3;
      return true;
   }
}
