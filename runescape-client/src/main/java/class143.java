import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public final class class143 implements Runnable {
   @ObfuscatedName("n")
   byte[] field2177;
   @ObfuscatedName("u")
   OutputStream field2178;
   @ObfuscatedName("x")
   Socket field2179;
   @ObfuscatedName("b")
   boolean field2180 = false;
   @ObfuscatedName("l")
   class136 field2181;
   @ObfuscatedName("d")
   class146 field2182;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 18319765
   )
   int field2184 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1398318017
   )
   int field2185 = 0;
   @ObfuscatedName("s")
   boolean field2186 = false;
   @ObfuscatedName("f")
   InputStream field2188;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1707770328"
   )
   public int method3012() throws IOException {
      return this.field2180?0:this.field2188.available();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   public void method3013() {
      if(!this.field2180) {
         synchronized(this) {
            this.field2180 = true;
            this.notifyAll();
         }

         if(this.field2182 != null) {
            while(this.field2182.field2214 == 0) {
               class98.method2264(1L);
            }

            if(this.field2182.field2214 == 1) {
               try {
                  ((Thread)this.field2182.field2216).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2182 = null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-500540860"
   )
   public int method3015() throws IOException {
      return this.field2180?0:this.field2188.read();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1856079456"
   )
   public void method3018(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2180) {
         if(this.field2186) {
            this.field2186 = false;
            throw new IOException();
         } else {
            if(this.field2177 == null) {
               this.field2177 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2177[this.field2185] = var1[var5 + var2];
                  this.field2185 = (1 + this.field2185) % 5000;
                  if((4900 + this.field2184) % 5000 == this.field2185) {
                     throw new IOException();
                  }
               }

               if(null == this.field2182) {
                  this.field2182 = this.field2181.method2903(this, 3);
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
                  if(this.field2185 == this.field2184) {
                     if(this.field2180) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2184;
                  if(this.field2185 >= this.field2184) {
                     var1 = this.field2185 - this.field2184;
                  } else {
                     var1 = 5000 - this.field2184;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2178.write(this.field2177, var2, var1);
               } catch (IOException var9) {
                  this.field2186 = true;
               }

               this.field2184 = (var1 + this.field2184) % 5000;

               try {
                  if(this.field2184 == this.field2185) {
                     this.field2178.flush();
                  }
               } catch (IOException var8) {
                  this.field2186 = true;
               }
               continue;
            }

            try {
               if(null != this.field2188) {
                  this.field2188.close();
               }

               if(this.field2178 != null) {
                  this.field2178.close();
               }

               if(this.field2179 != null) {
                  this.field2179.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2177 = null;
            break;
         }
      } catch (Exception var12) {
         class45.method984((String)null, var12);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1461295401"
   )
   public void method3036(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2180) {
         while(var3 > 0) {
            int var4 = this.field2188.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   public class143(Socket var1, class136 var2) throws IOException {
      this.field2181 = var2;
      this.field2179 = var1;
      this.field2179.setSoTimeout(30000);
      this.field2179.setTcpNoDelay(true);
      this.field2179.setReceiveBufferSize(16384);
      this.field2179.setSendBufferSize(16384);
      this.field2188 = this.field2179.getInputStream();
      this.field2178 = this.field2179.getOutputStream();
   }

   protected void finalize() {
      this.method3013();
   }
}
