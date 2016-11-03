import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public final class class146 implements Runnable {
   @ObfuscatedName("c")
   boolean field2226 = false;
   @ObfuscatedName("q")
   OutputStream field2227;
   @ObfuscatedName("f")
   Socket field2228;
   @ObfuscatedName("j")
   class149 field2230;
   @ObfuscatedName("m")
   byte[] field2232;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -392890089
   )
   int field2233 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1250531939
   )
   int field2234 = 0;
   @ObfuscatedName("h")
   boolean field2235 = false;
   @ObfuscatedName("k")
   InputStream field2237;
   @ObfuscatedName("v")
   class139 field2239;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -187112923
   )
   static int field2240;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1314801348"
   )
   public void method3020() {
      if(!this.field2226) {
         synchronized(this) {
            this.field2226 = true;
            this.notifyAll();
         }

         if(null != this.field2230) {
            while(this.field2230.field2268 == 0) {
               class127.method2846(1L);
            }

            if(this.field2230.field2268 == 1) {
               try {
                  ((Thread)this.field2230.field2262).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2230 = null;
      }
   }

   protected void finalize() {
      this.method3020();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-43"
   )
   public int method3021() throws IOException {
      return this.field2226?0:this.field2237.read();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method3022() throws IOException {
      return this.field2226?0:this.field2237.available();
   }

   public class146(Socket var1, class139 var2) throws IOException {
      this.field2239 = var2;
      this.field2228 = var1;
      this.field2228.setSoTimeout(30000);
      this.field2228.setTcpNoDelay(true);
      this.field2228.setReceiveBufferSize(16384);
      this.field2228.setSendBufferSize(16384);
      this.field2237 = this.field2228.getInputStream();
      this.field2227 = this.field2228.getOutputStream();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2234 == this.field2233) {
                     if(this.field2226) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2233;
                  if(this.field2234 >= this.field2233) {
                     var1 = this.field2234 - this.field2233;
                  } else {
                     var1 = 5000 - this.field2233;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2227.write(this.field2232, var2, var1);
               } catch (IOException var9) {
                  this.field2235 = true;
               }

               this.field2233 = (this.field2233 + var1) % 5000;

               try {
                  if(this.field2234 == this.field2233) {
                     this.field2227.flush();
                  }
               } catch (IOException var8) {
                  this.field2235 = true;
               }
               continue;
            }

            try {
               if(this.field2237 != null) {
                  this.field2237.close();
               }

               if(null != this.field2227) {
                  this.field2227.close();
               }

               if(null != this.field2228) {
                  this.field2228.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2232 = null;
            break;
         }
      } catch (Exception var12) {
         RSCanvas.method2969((String)null, var12);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-112"
   )
   public void method3024(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2226) {
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-30"
   )
   public void method3027(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2226) {
         if(this.field2235) {
            this.field2235 = false;
            throw new IOException();
         } else {
            if(this.field2232 == null) {
               this.field2232 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2232[this.field2234] = var1[var5 + var2];
                  this.field2234 = (1 + this.field2234) % 5000;
                  if((this.field2233 + 4900) % 5000 == this.field2234) {
                     throw new IOException();
                  }
               }

               if(null == this.field2230) {
                  this.field2230 = this.field2239.method2918(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "1803315106"
   )
   public static void method3042(class170 var0, class170 var1, class170 var2, class170 var3) {
      class214.field3185 = var0;
      Widget.field2902 = var1;
      Widget.field2805 = var2;
      Widget.field2847 = var3;
      Widget.widgets = new Widget[class214.field3185.method3291()][];
      Widget.validInterfaces = new boolean[class214.field3185.method3291()];
   }
}
