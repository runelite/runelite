import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public final class class143 implements Runnable {
   @ObfuscatedName("w")
   OutputStream field2175;
   @ObfuscatedName("d")
   Socket field2176;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1908914071
   )
   int field2177 = 0;
   @ObfuscatedName("c")
   boolean field2178 = false;
   @ObfuscatedName("k")
   class146 field2179;
   @ObfuscatedName("r")
   byte[] field2180;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1850362667
   )
   int field2181 = 0;
   @ObfuscatedName("m")
   boolean field2182 = false;
   @ObfuscatedName("y")
   class136 field2183;
   @ObfuscatedName("a")
   InputStream field2184;

   public class143(Socket var1, class136 var2) throws IOException {
      this.field2183 = var2;
      this.field2176 = var1;
      this.field2176.setSoTimeout(30000);
      this.field2176.setTcpNoDelay(true);
      this.field2176.setReceiveBufferSize(16384);
      this.field2176.setSendBufferSize(16384);
      this.field2184 = this.field2176.getInputStream();
      this.field2175 = this.field2176.getOutputStream();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "644396791"
   )
   public void method3095() {
      if(!this.field2178) {
         synchronized(this) {
            this.field2178 = true;
            this.notifyAll();
         }

         if(this.field2179 != null) {
            while(this.field2179.field2210 == 0) {
               class4.method55(1L);
            }

            if(this.field2179.field2210 == 1) {
               try {
                  ((Thread)this.field2179.field2211).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2179 = null;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-7641"
   )
   public int method3097() throws IOException {
      return this.field2178?0:this.field2184.read();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-191402794"
   )
   public int method3098() throws IOException {
      return this.field2178?0:this.field2184.available();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "2083832607"
   )
   public void method3099(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2178) {
         while(var3 > 0) {
            int var4 = this.field2184.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "0"
   )
   public void method3100(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2178) {
         if(this.field2182) {
            this.field2182 = false;
            throw new IOException();
         } else {
            if(this.field2180 == null) {
               this.field2180 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2180[this.field2177] = var1[var5 + var2];
                  this.field2177 = (this.field2177 + 1) % 5000;
                  if(this.field2177 == (4900 + this.field2181) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field2179) {
                  this.field2179 = this.field2183.method2991(this, 3);
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
                  if(this.field2177 == this.field2181) {
                     if(this.field2178) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2181;
                  if(this.field2177 >= this.field2181) {
                     var1 = this.field2177 - this.field2181;
                  } else {
                     var1 = 5000 - this.field2181;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2175.write(this.field2180, var2, var1);
               } catch (IOException var8) {
                  this.field2182 = true;
               }

               this.field2181 = (this.field2181 + var1) % 5000;

               try {
                  if(this.field2177 == this.field2181) {
                     this.field2175.flush();
                  }
               } catch (IOException var7) {
                  this.field2182 = true;
               }
               continue;
            }

            try {
               if(this.field2184 != null) {
                  this.field2184.close();
               }

               if(this.field2175 != null) {
                  this.field2175.close();
               }

               if(null != this.field2176) {
                  this.field2176.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field2180 = null;
            break;
         }
      } catch (Exception var11) {
         class22.method655((String)null, var11);
      }

   }

   protected void finalize() {
      this.method3095();
   }

   @ObfuscatedName("tg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1328491927"
   )
   protected static final void method3110() {
      class106.field1864 = null;
      class29.field708 = null;
      class23.field625 = null;
   }
}
