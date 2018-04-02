import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class163 implements Runnable {
   @ObfuscatedName("c")
   Thread field2171;
   @ObfuscatedName("i")
   InputStream field2169;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 248679497
   )
   int field2170;
   @ObfuscatedName("j")
   byte[] field2173;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1592383275
   )
   int field2172;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 143569583
   )
   int field2168;
   @ObfuscatedName("z")
   IOException field2174;

   class163(InputStream var1, int var2) {
      this.field2172 = 0;
      this.field2168 = 0;
      this.field2169 = var1;
      this.field2170 = var2 + 1;
      this.field2173 = new byte[this.field2170];
      this.field2171 = new Thread(this);
      this.field2171.setDaemon(true);
      this.field2171.start();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-3579"
   )
   boolean method3207(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2170) {
         synchronized(this) {
            int var3;
            if(this.field2172 <= this.field2168) {
               var3 = this.field2168 - this.field2172;
            } else {
               var3 = this.field2170 - this.field2172 + this.field2168;
            }

            if(var3 < var1) {
               if(this.field2174 != null) {
                  throw new IOException(this.field2174.toString());
               } else {
                  this.notifyAll();
                  return false;
               }
            } else {
               return true;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1762340013"
   )
   int method3208() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2172 <= this.field2168) {
            var2 = this.field2168 - this.field2172;
         } else {
            var2 = this.field2170 - this.field2172 + this.field2168;
         }

         if(var2 <= 0 && this.field2174 != null) {
            throw new IOException(this.field2174.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1857757321"
   )
   int method3211() throws IOException {
      synchronized(this) {
         if(this.field2168 == this.field2172) {
            if(this.field2174 != null) {
               throw new IOException(this.field2174.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2173[this.field2172] & 255;
            this.field2172 = (this.field2172 + 1) % this.field2170;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "139136151"
   )
   int method3210(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2172 <= this.field2168) {
               var5 = this.field2168 - this.field2172;
            } else {
               var5 = this.field2170 - this.field2172 + this.field2168;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2174 != null) {
               throw new IOException(this.field2174.toString());
            } else {
               if(var3 + this.field2172 <= this.field2170) {
                  System.arraycopy(this.field2173, this.field2172, var1, var2, var3);
               } else {
                  int var6 = this.field2170 - this.field2172;
                  System.arraycopy(this.field2173, this.field2172, var1, var2, var6);
                  System.arraycopy(this.field2173, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2172 = (var3 + this.field2172) % this.field2170;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2141740289"
   )
   void method3222() {
      synchronized(this) {
         if(this.field2174 == null) {
            this.field2174 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2171.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2174 != null) {
                  return;
               }

               if(this.field2172 == 0) {
                  var1 = this.field2170 - this.field2168 - 1;
               } else if(this.field2172 <= this.field2168) {
                  var1 = this.field2170 - this.field2168;
               } else {
                  var1 = this.field2172 - this.field2168 - 1;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var10) {
                  ;
               }
            }
         }

         int var7;
         try {
            var7 = this.field2169.read(this.field2173, this.field2168, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2174 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2168 = (var7 + this.field2168) % this.field2170;
         }
      }
   }

   @ObfuscatedName("c")
   public static final void method3223(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            DState.method3499(var0 - 1L);
            DState.method3499(1L);
         } else {
            DState.method3499(var0);
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)[Lgn;",
      garbageValue = "1922351899"
   )
   static LoginPacket[] method3220() {
      return new LoginPacket[]{LoginPacket.field2477, LoginPacket.field2474, LoginPacket.field2473, LoginPacket.field2475};
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfr;ZI)V",
      garbageValue = "891327356"
   )
   public static void method3224(class169 var0, boolean var1) {
      if(class264.NetCache_socket != null) {
         try {
            class264.NetCache_socket.vmethod3325();
         } catch (Exception var6) {
            ;
         }

         class264.NetCache_socket = null;
      }

      class264.NetCache_socket = var0;
      class189.sendConInfo(var1);
      class264.NetCache_responseHeaderBuffer.offset = 0;
      GraphicsObject.currentRequest = null;
      ISAACCipher.NetCache_responseArchiveBuffer = null;
      class264.field3416 = 0;

      while(true) {
         FileRequest var2 = (FileRequest)class264.NetCache_pendingPriorityResponses.first();
         if(var2 == null) {
            while(true) {
               var2 = (FileRequest)class264.NetCache_pendingResponses.first();
               if(var2 == null) {
                  if(class264.field3420 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class264.field3420);
                        var7.putShort(0);
                        class264.NetCache_socket.vmethod3320(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class264.NetCache_socket.vmethod3325();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class264.field3422;
                        class264.NetCache_socket = null;
                     }
                  }

                  class264.field3410 = 0;
                  class264.field3413 = ScriptVarType.method28();
                  return;
               }

               class264.NetCache_pendingWritesQueue.setHead(var2);
               class264.NetCache_pendingWrites.put(var2, var2.hash);
               ++class264.NetCache_pendingWritesCount;
               --class264.NetCache_pendingResponsesCount;
            }
         }

         class264.NetCache_pendingPriorityWrites.put(var2, var2.hash);
         ++class264.NetCache_pendingPriorityWritesCount;
         --class264.NetCache_pendingPriorityResponsesCount;
      }
   }
}
