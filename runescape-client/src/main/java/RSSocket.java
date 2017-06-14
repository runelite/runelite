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

@ObfuscatedName("fq")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("p")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("g")
   boolean field2277;
   @ObfuscatedName("i")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("j")
   boolean field2279;
   @ObfuscatedName("f")
   class154 field2280;
   @ObfuscatedName("m")
   class153 field2281;
   @ObfuscatedName("c")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1829986223
   )
   int field2283;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1905972573
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("n")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("u")
   static int[] field2286;
   @ObfuscatedName("pg")
   static class109 field2287;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1246510059"
   )
   public void method2989() {
      if(!this.field2279) {
         synchronized(this) {
            this.field2279 = true;
            this.notifyAll();
         }

         if(this.field2281 != null) {
            while(this.field2281.field2236 == 0) {
               DynamicObject.method1842(1L);
            }

            if(this.field2281.field2236 == 1) {
               try {
                  ((Thread)this.field2281.field2240).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2281 = null;
      }
   }

   protected void finalize() {
      this.method2989();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "547326136"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.field2279?0:this.inputStream.read();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("available")
   public int available() throws IOException {
      return this.field2279?0:this.inputStream.available();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1639762423"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2279) {
         if(this.field2277) {
            this.field2277 = false;
            throw new IOException();
         } else {
            if(this.outbuffer == null) {
               this.outbuffer = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outbuffer[this.outbufLen] = var1[var5 + var2];
                  this.outbufLen = (this.outbufLen + 1) % 5000;
                  if((this.field2283 + 4900) % 5000 == this.outbufLen) {
                     throw new IOException();
                  }
               }

               if(this.field2281 == null) {
                  this.field2281 = this.field2280.method2937(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2283 == this.outbufLen) {
                     if(this.field2279) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2283;
                  if(this.outbufLen >= this.field2283) {
                     var1 = this.outbufLen - this.field2283;
                  } else {
                     var1 = 5000 - this.field2283;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var9) {
                  this.field2277 = true;
               }

               this.field2283 = (var1 + this.field2283) % 5000;

               try {
                  if(this.field2283 == this.outbufLen) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.field2277 = true;
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

            this.outbuffer = null;
            break;
         }
      } catch (Exception var12) {
         Projectile.method1734((String)null, var12);
      }

   }

   public RSSocket(Socket var1, class154 var2) throws IOException {
      this.field2279 = false;
      this.field2283 = 0;
      this.outbufLen = 0;
      this.field2277 = false;
      this.field2280 = var2;
      this.socket = var1;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(16384);
      this.socket.setSendBufferSize(16384);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-16711936"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2279) {
         while(var3 > 0) {
            int var4 = this.inputStream.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lclass244;",
      garbageValue = "215712503"
   )
   public static class244 method3006(int var0) {
      class244 var1 = (class244)class244.field3320.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class244.field3324.getConfigData(15, var0);
         var1 = new class244();
         if(var2 != null) {
            var1.method4344(new Buffer(var2));
         }

         class244.field3320.put(var1, (long)var0);
         return var1;
      }
   }
}
