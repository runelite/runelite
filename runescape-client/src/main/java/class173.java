import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public final class class173 extends class169 implements Runnable {
   @ObfuscatedName("g")
   InputStream field2229;
   @ObfuscatedName("e")
   OutputStream field2220;
   @ObfuscatedName("b")
   Socket field2221;
   @ObfuscatedName("z")
   boolean field2219;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   Signlink field2223;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   Task field2224;
   @ObfuscatedName("s")
   byte[] field2228;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1453931379
   )
   int field2226;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -91759403
   )
   int field2225;
   @ObfuscatedName("h")
   boolean field2222;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1806723443
   )
   final int field2230;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -23516471
   )
   final int field2227;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfl;I)V"
   )
   public class173(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2219 = false;
      this.field2226 = 0;
      this.field2225 = 0;
      this.field2222 = false;
      this.field2223 = var2;
      this.field2221 = var1;
      this.field2230 = var3;
      this.field2227 = var3 - 100;
      this.field2221.setSoTimeout(30000);
      this.field2221.setTcpNoDelay(true);
      this.field2221.setReceiveBufferSize(65536);
      this.field2221.setSendBufferSize(65536);
      this.field2229 = this.field2221.getInputStream();
      this.field2220 = this.field2221.getOutputStream();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-37990145"
   )
   public boolean vmethod3407(int var1) throws IOException {
      return this.field2219?false:this.field2229.available() >= var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1289513265"
   )
   public int vmethod3406() throws IOException {
      return this.field2219?0:this.field2229.available();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-6075"
   )
   public int vmethod3405() throws IOException {
      return this.field2219?0:this.field2229.read();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "680375269"
   )
   public int vmethod3426(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2219) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2229.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1818485286"
   )
   public void vmethod3411(byte[] var1, int var2, int var3) throws IOException {
      this.method3409(var1, var2, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1579216827"
   )
   public void vmethod3404() {
      if(!this.field2219) {
         synchronized(this) {
            this.field2219 = true;
            this.notifyAll();
         }

         if(this.field2224 != null) {
            while(this.field2224.status == 0) {
               BoundingBox3DDrawMode.method59(1L);
            }

            if(this.field2224.status == 1) {
               try {
                  ((Thread)this.field2224.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2224 = null;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1111798950"
   )
   void method3409(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2219) {
         if(this.field2222) {
            this.field2222 = false;
            throw new IOException();
         } else {
            if(this.field2228 == null) {
               this.field2228 = new byte[this.field2230];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2228[this.field2225] = var1[var5 + var2];
                  this.field2225 = (this.field2225 + 1) % this.field2230;
                  if((this.field2227 + this.field2226) % this.field2230 == this.field2225) {
                     throw new IOException();
                  }
               }

               if(this.field2224 == null) {
                  this.field2224 = this.field2223.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   protected void finalize() {
      this.vmethod3404();
   }

   protected void aaw() {
      this.vmethod3404();
   }

   protected void aav() {
      this.vmethod3404();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2226 == this.field2225) {
                     if(this.field2219) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2226;
                  if(this.field2225 >= this.field2226) {
                     var1 = this.field2225 - this.field2226;
                  } else {
                     var1 = this.field2230 - this.field2226;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2220.write(this.field2228, var2, var1);
               } catch (IOException var9) {
                  this.field2222 = true;
               }

               this.field2226 = (var1 + this.field2226) % this.field2230;

               try {
                  if(this.field2225 == this.field2226) {
                     this.field2220.flush();
                  }
               } catch (IOException var8) {
                  this.field2222 = true;
               }
               continue;
            }

            try {
               if(this.field2229 != null) {
                  this.field2229.close();
               }

               if(this.field2220 != null) {
                  this.field2220.close();
               }

               if(this.field2221 != null) {
                  this.field2221.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2228 = null;
            break;
         }
      } catch (Exception var12) {
         class253.processClientError((String)null, var12);
      }

   }
}
