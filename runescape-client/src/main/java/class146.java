import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public final class class146 implements Runnable {
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -2088980825
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("n")
   class139 field2229;
   @ObfuscatedName("e")
   Socket field2230;
   @ObfuscatedName("g")
   boolean field2231 = false;
   @ObfuscatedName("mh")
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("u")
   class149 field2233;
   @ObfuscatedName("d")
   byte[] field2234;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 476869437
   )
   int field2235 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -764207571
   )
   int field2236 = 0;
   @ObfuscatedName("h")
   InputStream field2237;
   @ObfuscatedName("i")
   OutputStream field2238;
   @ObfuscatedName("j")
   boolean field2239 = false;

   public class146(Socket var1, class139 var2) throws IOException {
      this.field2229 = var2;
      this.field2230 = var1;
      this.field2230.setSoTimeout(30000);
      this.field2230.setTcpNoDelay(true);
      this.field2230.setReceiveBufferSize(16384);
      this.field2230.setSendBufferSize(16384);
      this.field2237 = this.field2230.getInputStream();
      this.field2238 = this.field2230.getOutputStream();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "127"
   )
   public int method3025() throws IOException {
      return this.field2231?0:this.field2237.read();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "683420451"
   )
   public int method3026() throws IOException {
      return this.field2231?0:this.field2237.available();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1626366103"
   )
   public void method3027(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2231) {
         while(var3 > 0) {
            int var4 = this.field2237.read(var1, var2, var3);
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
      signature = "([BIIB)V",
      garbageValue = "35"
   )
   public void method3028(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2231) {
         if(this.field2239) {
            this.field2239 = false;
            throw new IOException();
         } else {
            if(this.field2234 == null) {
               this.field2234 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2234[this.field2236] = var1[var5 + var2];
                  this.field2236 = (1 + this.field2236) % 5000;
                  if((this.field2235 + 4900) % 5000 == this.field2236) {
                     throw new IOException();
                  }
               }

               if(null == this.field2233) {
                  this.field2233 = this.field2229.method2920(this, 3);
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
                  if(this.field2236 == this.field2235) {
                     if(this.field2231) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2235;
                  if(this.field2236 >= this.field2235) {
                     var1 = this.field2236 - this.field2235;
                  } else {
                     var1 = 5000 - this.field2235;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2238.write(this.field2234, var2, var1);
               } catch (IOException var9) {
                  this.field2239 = true;
               }

               this.field2235 = (var1 + this.field2235) % 5000;

               try {
                  if(this.field2236 == this.field2235) {
                     this.field2238.flush();
                  }
               } catch (IOException var8) {
                  this.field2239 = true;
               }
               continue;
            }

            try {
               if(this.field2237 != null) {
                  this.field2237.close();
               }

               if(this.field2238 != null) {
                  this.field2238.close();
               }

               if(null != this.field2230) {
                  this.field2230.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2234 = null;
            break;
         }
      } catch (Exception var12) {
         class93.method2139((String)null, var12);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "114022640"
   )
   public void method3029() {
      if(!this.field2231) {
         synchronized(this) {
            this.field2231 = true;
            this.notifyAll();
         }

         if(null != this.field2233) {
            while(this.field2233.field2265 == 0) {
               PlayerComposition.method3511(1L);
            }

            if(this.field2233.field2265 == 1) {
               try {
                  ((Thread)this.field2233.field2270).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2233 = null;
      }
   }

   protected void finalize() {
      this.method3029();
   }
}
