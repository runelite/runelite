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

@ObfuscatedName("fy")
@Implements("RSSocket")
public final class RSSocket implements Runnable {
   @ObfuscatedName("p")
   @Export("inputStream")
   InputStream inputStream;
   @ObfuscatedName("z")
   class153 field2279;
   @ObfuscatedName("e")
   @Export("socket")
   Socket socket;
   @ObfuscatedName("t")
   boolean field2281;
   @ObfuscatedName("w")
   class154 field2282;
   @ObfuscatedName("m")
   @Export("outputStream")
   OutputStream outputStream;
   @ObfuscatedName("j")
   @Export("outbuffer")
   byte[] outbuffer;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 439390587
   )
   int field2285;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1577439597
   )
   @Export("outbufLen")
   int outbufLen;
   @ObfuscatedName("c")
   boolean field2287;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   public void method2879() {
      if(!this.field2281) {
         synchronized(this) {
            this.field2281 = true;
            this.notifyAll();
         }

         if(this.field2279 != null) {
            while(this.field2279.field2237 == 0) {
               class172.method3014(1L);
            }

            if(this.field2279.field2237 == 1) {
               try {
                  ((Thread)this.field2279.field2241).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2279 = null;
      }

   }

   protected void finalize() {
      this.method2879();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1250416685"
   )
   @Export("readByte")
   public int readByte() throws IOException {
      return this.field2281?0:this.inputStream.read();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   @Export("available")
   public int available() throws IOException {
      return this.field2281?0:this.inputStream.available();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1776816500"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2281) {
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

   public RSSocket(Socket var1, class154 var2) throws IOException {
      this.field2281 = false;
      this.field2285 = 0;
      this.outbufLen = 0;
      this.field2287 = false;
      this.field2282 = var2;
      this.socket = var1;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(16384);
      this.socket.setSendBufferSize(16384);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2285 == this.outbufLen) {
                     if(this.field2281) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2285;
                  if(this.outbufLen >= this.field2285) {
                     var1 = this.outbufLen - this.field2285;
                  } else {
                     var1 = 5000 - this.field2285;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outbuffer, var2, var1);
               } catch (IOException var8) {
                  this.field2287 = true;
               }

               this.field2285 = (this.field2285 + var1) % 5000;

               try {
                  if(this.field2285 == this.outbufLen) {
                     this.outputStream.flush();
                  }
               } catch (IOException var7) {
                  this.field2287 = true;
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
            } catch (IOException var6) {
               ;
            }

            this.outbuffer = null;
            break;
         }
      } catch (Exception var11) {
         class8.method43((String)null, var11);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1348556689"
   )
   @Export("queueForWrite")
   public void queueForWrite(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2281) {
         if(this.field2287) {
            this.field2287 = false;
            throw new IOException();
         }

         if(this.outbuffer == null) {
            this.outbuffer = new byte[5000];
         }

         synchronized(this) {
            for(int var5 = 0; var5 < var3; ++var5) {
               this.outbuffer[this.outbufLen] = var1[var5 + var2];
               this.outbufLen = (this.outbufLen + 1) % 5000;
               if(this.outbufLen == (this.field2285 + 4900) % 5000) {
                  throw new IOException();
               }
            }

            if(this.field2279 == null) {
               this.field2279 = this.field2282.method2822(this, 3);
            }

            this.notifyAll();
         }
      }

   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(IZZZI)LIndexData;",
      garbageValue = "1334116791"
   )
   static IndexData method2891(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2262 != null) {
         var4 = new IndexFile(var0, class155.field2262, WorldMapType3.field404[var0], 1000000);
      }

      return new IndexData(var4, class9.field254, var0, var1, var2, var3);
   }
}
