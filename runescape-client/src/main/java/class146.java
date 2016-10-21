import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public final class class146 implements Runnable {
   @ObfuscatedName("m")
   byte[] field2225;
   @ObfuscatedName("f")
   InputStream field2226;
   @ObfuscatedName("b")
   class149 field2227;
   @ObfuscatedName("t")
   boolean field2228 = false;
   @ObfuscatedName("e")
   OutputStream field2229;
   @ObfuscatedName("n")
   Socket field2230;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1075091513
   )
   int field2232 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 16077553
   )
   int field2233 = 0;
   @ObfuscatedName("w")
   boolean field2234 = false;
   @ObfuscatedName("v")
   class139 field2237;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2102789716"
   )
   public void method3009(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2228) {
         if(this.field2234) {
            this.field2234 = false;
            throw new IOException();
         } else {
            if(this.field2225 == null) {
               this.field2225 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2225[this.field2233] = var1[var5 + var2];
                  this.field2233 = (this.field2233 + 1) % 5000;
                  if(this.field2233 == (this.field2232 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(this.field2227 == null) {
                  this.field2227 = this.field2237.method2910(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-518957050"
   )
   public void method3010() {
      if(!this.field2228) {
         synchronized(this) {
            this.field2228 = true;
            this.notifyAll();
         }

         if(null != this.field2227) {
            while(this.field2227.field2262 == 0) {
               class110.method2407(1L);
            }

            if(this.field2227.field2262 == 1) {
               try {
                  ((Thread)this.field2227.field2266).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2227 = null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-651990310"
   )
   public int method3013() throws IOException {
      return this.field2228?0:this.field2226.available();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "390102373"
   )
   public void method3014(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2228) {
         while(var3 > 0) {
            int var4 = this.field2226.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
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
                  if(this.field2232 == this.field2233) {
                     if(this.field2228) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2232;
                  if(this.field2233 >= this.field2232) {
                     var1 = this.field2233 - this.field2232;
                  } else {
                     var1 = 5000 - this.field2232;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2229.write(this.field2225, var2, var1);
               } catch (IOException var9) {
                  this.field2234 = true;
               }

               this.field2232 = (this.field2232 + var1) % 5000;

               try {
                  if(this.field2232 == this.field2233) {
                     this.field2229.flush();
                  }
               } catch (IOException var8) {
                  this.field2234 = true;
               }
               continue;
            }

            try {
               if(null != this.field2226) {
                  this.field2226.close();
               }

               if(null != this.field2229) {
                  this.field2229.close();
               }

               if(this.field2230 != null) {
                  this.field2230.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2225 = null;
            break;
         }
      } catch (Exception var12) {
         Frames.method2316((String)null, var12);
      }

   }

   protected void finalize() {
      this.method3010();
   }

   public class146(Socket var1, class139 var2) throws IOException {
      this.field2237 = var2;
      this.field2230 = var1;
      this.field2230.setSoTimeout(30000);
      this.field2230.setTcpNoDelay(true);
      this.field2230.setReceiveBufferSize(16384);
      this.field2230.setSendBufferSize(16384);
      this.field2226 = this.field2230.getInputStream();
      this.field2229 = this.field2230.getOutputStream();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1922435646"
   )
   public int method3029() throws IOException {
      return this.field2228?0:this.field2226.read();
   }
}
