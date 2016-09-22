import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public final class class146 implements Runnable {
   @ObfuscatedName("d")
   OutputStream field2247;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1202955933
   )
   public static int field2248;
   @ObfuscatedName("t")
   class149 field2249;
   @ObfuscatedName("r")
   boolean field2250 = false;
   @ObfuscatedName("z")
   class139 field2251;
   @ObfuscatedName("v")
   Socket field2252;
   @ObfuscatedName("n")
   byte[] field2253;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 423820689
   )
   int field2254 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 870608131
   )
   int field2255 = 0;
   @ObfuscatedName("m")
   boolean field2256 = false;
   @ObfuscatedName("a")
   InputStream field2257;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = 1918850207
   )
   protected static int field2258;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "19136782"
   )
   public int method3021() throws IOException {
      return this.field2250?0:this.field2257.available();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2254 == this.field2255) {
                     if(this.field2250) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2254;
                  if(this.field2255 >= this.field2254) {
                     var1 = this.field2255 - this.field2254;
                  } else {
                     var1 = 5000 - this.field2254;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2247.write(this.field2253, var2, var1);
               } catch (IOException var9) {
                  this.field2256 = true;
               }

               this.field2254 = (var1 + this.field2254) % 5000;

               try {
                  if(this.field2254 == this.field2255) {
                     this.field2247.flush();
                  }
               } catch (IOException var8) {
                  this.field2256 = true;
               }
               continue;
            }

            try {
               if(null != this.field2257) {
                  this.field2257.close();
               }

               if(null != this.field2247) {
                  this.field2247.close();
               }

               if(null != this.field2252) {
                  this.field2252.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2253 = null;
            break;
         }
      } catch (Exception var12) {
         class128.method2843((String)null, var12);
      }

   }

   protected void finalize() {
      this.method3039();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "105"
   )
   public int method3022() throws IOException {
      return this.field2250?0:this.field2257.read();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1762292567"
   )
   public void method3025(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2250) {
         if(this.field2256) {
            this.field2256 = false;
            throw new IOException();
         } else {
            if(this.field2253 == null) {
               this.field2253 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2253[this.field2255] = var1[var5 + var2];
                  this.field2255 = (this.field2255 + 1) % 5000;
                  if((4900 + this.field2254) % 5000 == this.field2255) {
                     throw new IOException();
                  }
               }

               if(null == this.field2249) {
                  this.field2249 = this.field2251.method2934(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1342682734"
   )
   public void method3035(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2250) {
         while(var3 > 0) {
            int var4 = this.field2257.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1902796165"
   )
   public void method3039() {
      if(!this.field2250) {
         synchronized(this) {
            this.field2250 = true;
            this.notifyAll();
         }

         if(null != this.field2249) {
            while(this.field2249.field2284 == 0) {
               Item.method681(1L);
            }

            if(this.field2249.field2284 == 1) {
               try {
                  ((Thread)this.field2249.field2287).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2249 = null;
      }
   }

   public class146(Socket var1, class139 var2) throws IOException {
      this.field2251 = var2;
      this.field2252 = var1;
      this.field2252.setSoTimeout(30000);
      this.field2252.setTcpNoDelay(true);
      this.field2252.setReceiveBufferSize(16384);
      this.field2252.setSendBufferSize(16384);
      this.field2257 = this.field2252.getInputStream();
      this.field2247 = this.field2252.getOutputStream();
   }
}
