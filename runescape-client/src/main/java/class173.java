import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public final class class173 extends class169 implements Runnable {
   @ObfuscatedName("d")
   InputStream field2231;
   @ObfuscatedName("z")
   OutputStream field2235;
   @ObfuscatedName("n")
   Socket field2227;
   @ObfuscatedName("r")
   boolean field2230;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   Signlink field2229;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   Task field2225;
   @ObfuscatedName("k")
   byte[] field2226;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -688414321
   )
   int field2232;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1668937155
   )
   int field2233;
   @ObfuscatedName("x")
   boolean field2234;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1449246817
   )
   final int field2237;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1882919049
   )
   final int field2236;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfv;I)V"
   )
   public class173(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2230 = false;
      this.field2232 = 0;
      this.field2233 = 0;
      this.field2234 = false;
      this.field2229 = var2;
      this.field2227 = var1;
      this.field2237 = var3;
      this.field2236 = var3 - 100;
      this.field2227.setSoTimeout(30000);
      this.field2227.setTcpNoDelay(true);
      this.field2227.setReceiveBufferSize(65536);
      this.field2227.setSendBufferSize(65536);
      this.field2231 = this.field2227.getInputStream();
      this.field2235 = this.field2227.getOutputStream();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "723083645"
   )
   public boolean vmethod3383(int var1) throws IOException {
      return this.field2230?false:this.field2231.available() >= var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1228440200"
   )
   public int vmethod3389() throws IOException {
      return this.field2230?0:this.field2231.available();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1683920252"
   )
   public int vmethod3381() throws IOException {
      return this.field2230?0:this.field2231.read();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1694519349"
   )
   public int vmethod3399(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2230) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2231.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "572887195"
   )
   public void vmethod3387(byte[] var1, int var2, int var3) throws IOException {
      this.method3385(var1, var2, var3);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1035620035"
   )
   public void vmethod3379() {
      if(!this.field2230) {
         synchronized(this) {
            this.field2230 = true;
            this.notifyAll();
         }

         if(this.field2225 != null) {
            while(this.field2225.status == 0) {
               PacketBuffer.method3907(1L);
            }

            if(this.field2225.status == 1) {
               try {
                  ((Thread)this.field2225.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2225 = null;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "438077886"
   )
   void method3385(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2230) {
         if(this.field2234) {
            this.field2234 = false;
            throw new IOException();
         } else {
            if(this.field2226 == null) {
               this.field2226 = new byte[this.field2237];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2226[this.field2233] = var1[var5 + var2];
                  this.field2233 = (this.field2233 + 1) % this.field2237;
                  if((this.field2232 + this.field2236) % this.field2237 == this.field2233) {
                     throw new IOException();
                  }
               }

               if(this.field2225 == null) {
                  this.field2225 = this.field2229.createRunnable(this, 3);
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
                  if(this.field2233 == this.field2232) {
                     if(this.field2230) {
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
                     var1 = this.field2237 - this.field2232;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2235.write(this.field2226, var2, var1);
               } catch (IOException var9) {
                  this.field2234 = true;
               }

               this.field2232 = (var1 + this.field2232) % this.field2237;

               try {
                  if(this.field2233 == this.field2232) {
                     this.field2235.flush();
                  }
               } catch (IOException var8) {
                  this.field2234 = true;
               }
               continue;
            }

            try {
               if(this.field2231 != null) {
                  this.field2231.close();
               }

               if(this.field2235 != null) {
                  this.field2235.close();
               }

               if(this.field2227 != null) {
                  this.field2227.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2226 = null;
            break;
         }
      } catch (Exception var12) {
         ItemLayer.processClientError((String)null, var12);
      }

   }

   protected void finalize() {
      this.vmethod3379();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "64"
   )
   static synchronized void method3382(byte[] var0) {
      if(var0.length == 100 && class195.field2576 < 1000) {
         class195.field2575[++class195.field2576 - 1] = var0;
      } else if(var0.length == 5000 && class195.field2572 < 250) {
         class195.field2583[++class195.field2572 - 1] = var0;
      } else if(var0.length == 30000 && class195.field2574 < 50) {
         class195.field2573[++class195.field2574 - 1] = var0;
      } else {
         if(class195.field2579 != null) {
            for(int var1 = 0; var1 < class195.field2578.length; ++var1) {
               if(var0.length == class195.field2578[var1] && Item.field1396[var1] < class195.field2579[var1].length) {
                  class195.field2579[var1][Item.field1396[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }
}
