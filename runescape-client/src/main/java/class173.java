import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public final class class173 extends class169 implements Runnable {
   @ObfuscatedName("t")
   InputStream field2213;
   @ObfuscatedName("q")
   OutputStream field2202;
   @ObfuscatedName("i")
   Socket field2214;
   @ObfuscatedName("a")
   boolean field2204;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   Signlink field2212;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   Task field2203;
   @ObfuscatedName("e")
   byte[] field2207;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 935805525
   )
   int field2208;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1273935131
   )
   int field2209;
   @ObfuscatedName("g")
   boolean field2210;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1966092293
   )
   final int field2201;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1960215081
   )
   final int field2211;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfd;I)V"
   )
   public class173(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2204 = false;
      this.field2208 = 0;
      this.field2209 = 0;
      this.field2210 = false;
      this.field2212 = var2;
      this.field2214 = var1;
      this.field2201 = var3;
      this.field2211 = var3 - 100;
      this.field2214.setSoTimeout(30000);
      this.field2214.setTcpNoDelay(true);
      this.field2214.setReceiveBufferSize(65536);
      this.field2214.setSendBufferSize(65536);
      this.field2213 = this.field2214.getInputStream();
      this.field2202 = this.field2214.getOutputStream();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public boolean vmethod3337(int var1) throws IOException {
      return this.field2204?false:this.field2213.available() >= var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1714062859"
   )
   public int vmethod3336() throws IOException {
      return this.field2204?0:this.field2213.available();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-79385341"
   )
   public int vmethod3335() throws IOException {
      return this.field2204?0:this.field2213.read();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1560304317"
   )
   public int vmethod3338(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2204) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2213.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-796507680"
   )
   public void vmethod3340(byte[] var1, int var2, int var3) throws IOException {
      this.method3360(var1, var2, var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2082122029"
   )
   public void vmethod3339() {
      if(!this.field2204) {
         synchronized(this) {
            this.field2204 = true;
            this.notifyAll();
         }

         if(this.field2203 != null) {
            while(this.field2203.status == 0) {
               class93.method1982(1L);
            }

            if(this.field2203.status == 1) {
               try {
                  ((Thread)this.field2203.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2203 = null;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-755275946"
   )
   void method3360(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2204) {
         if(this.field2210) {
            this.field2210 = false;
            throw new IOException();
         } else {
            if(this.field2207 == null) {
               this.field2207 = new byte[this.field2201];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2207[this.field2209] = var1[var5 + var2];
                  this.field2209 = (this.field2209 + 1) % this.field2201;
                  if((this.field2211 + this.field2208) % this.field2201 == this.field2209) {
                     throw new IOException();
                  }
               }

               if(this.field2203 == null) {
                  this.field2203 = this.field2212.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   protected void finalize() {
      this.vmethod3339();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2209 == this.field2208) {
                     if(this.field2204) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2208;
                  if(this.field2209 >= this.field2208) {
                     var1 = this.field2209 - this.field2208;
                  } else {
                     var1 = this.field2201 - this.field2208;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2202.write(this.field2207, var2, var1);
               } catch (IOException var9) {
                  this.field2210 = true;
               }

               this.field2208 = (var1 + this.field2208) % this.field2201;

               try {
                  if(this.field2209 == this.field2208) {
                     this.field2202.flush();
                  }
               } catch (IOException var8) {
                  this.field2210 = true;
               }
               continue;
            }

            try {
               if(this.field2213 != null) {
                  this.field2213.close();
               }

               if(this.field2202 != null) {
                  this.field2202.close();
               }

               if(this.field2214 != null) {
                  this.field2214.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2207 = null;
            break;
         }
      } catch (Exception var12) {
         GroundObject.processClientError((String)null, var12);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   static void method3363() {
      class95.chatLineMap.clear();
      class95.messages.clear();
      class95.field1421.clear();
      class95.field1422 = 0;
   }
}
