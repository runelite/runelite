import net.runelite.mapping.*;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@ObfuscatedName("fl")
@Implements("SocketSession")
public final class SocketSession extends AbstractSocket implements Runnable {
   @ObfuscatedName("a")
   InputStream field2165;
   @ObfuscatedName("w")
   OutputStream field2161;
   @ObfuscatedName("e")
   Socket field2162;
   @ObfuscatedName("k")
   boolean field2163;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   Signlink field2167;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   Task field2174;
   @ObfuscatedName("t")
   byte[] field2166;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1368876635
   )
   int field2168;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1071537291
   )
   int field2172;
   @ObfuscatedName("j")
   boolean field2160;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2020363775
   )
   final int field2164;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -715135773
   )
   final int field2171;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfs;I)V"
   )
   public SocketSession(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2163 = false;
      this.field2168 = 0;
      this.field2172 = 0;
      this.field2160 = false;
      this.field2167 = var2;
      this.field2162 = var1;
      this.field2164 = var3;
      this.field2171 = var3 - 100;
      this.field2162.setSoTimeout(30000);
      this.field2162.setTcpNoDelay(true);
      this.field2162.setReceiveBufferSize(65536);
      this.field2162.setSendBufferSize(65536);
      this.field2165 = this.field2162.getInputStream();
      this.field2161 = this.field2162.getOutputStream();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1430377833"
   )
   public boolean available(int var1) throws IOException {
      if(this.field2163) {
         return false;
      } else {
         try {
            return this.field2165.available() >= var1;
         } catch (IOException var3) {
            throw new IOException("Error reading from clientstream", var3);
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int readable() throws IOException {
      return this.field2163?0:this.field2165.available();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1221609909"
   )
   public int read() throws IOException {
      return this.field2163?0:this.field2165.read();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1823409792"
   )
   public int vmethod3085(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2163) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2165.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "906468650"
   )
   public void vmethod3082(byte[] var1, int var2, int var3) throws IOException {
      this.method3080(var1, var2, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-124"
   )
   public void close() {
      if(!this.field2163) {
         synchronized(this) {
            this.field2163 = true;
            this.notifyAll();
         }

         if(this.field2174 != null) {
            while(this.field2174.status == 0) {
               World.method1500(1L);
            }

            if(this.field2174.status == 1) {
               try {
                  ((Thread)this.field2174.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2174 = null;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1715923081"
   )
   void method3080(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2163) {
         if(this.field2160) {
            this.field2160 = false;
            throw new IOException();
         } else {
            if(this.field2166 == null) {
               this.field2166 = new byte[this.field2164];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2166[this.field2172] = var1[var5 + var2];
                  this.field2172 = (this.field2172 + 1) % this.field2164;
                  if((this.field2168 + this.field2171) % this.field2164 == this.field2172) {
                     throw new IOException();
                  }
               }

               if(this.field2174 == null) {
                  this.field2174 = this.field2167.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   protected void finalize() {
      this.close();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2168 == this.field2172) {
                     if(this.field2163) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2168;
                  if(this.field2172 >= this.field2168) {
                     var1 = this.field2172 - this.field2168;
                  } else {
                     var1 = this.field2164 - this.field2168;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2161.write(this.field2166, var2, var1);
               } catch (IOException var9) {
                  this.field2160 = true;
               }

               this.field2168 = (var1 + this.field2168) % this.field2164;

               try {
                  if(this.field2168 == this.field2172) {
                     this.field2161.flush();
                  }
               } catch (IOException var8) {
                  this.field2160 = true;
               }
               continue;
            }

            try {
               if(this.field2165 != null) {
                  this.field2165.close();
               }

               if(this.field2161 != null) {
                  this.field2161.close();
               }

               if(this.field2162 != null) {
                  this.field2162.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2166 = null;
            break;
         }
      } catch (Exception var12) {
         PendingSpawn.method1461((String)null, var12);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lib;III)Lks;",
      garbageValue = "-474356099"
   )
   @Export("takeItemSnapshot")
   public static SpritePixels takeItemSnapshot(IndexDataBase var0, int var1, int var2) {
      return !Parameters.spriteDataValid(var0, var1, var2)?null:Ignore.renderItemSnapshot();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "952500617"
   )
   static int method3092(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
