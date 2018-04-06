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
   @ObfuscatedName("o")
   Socket field2242;
   @ObfuscatedName("k")
   InputStream field2247;
   @ObfuscatedName("t")
   OutputStream field2243;
   @ObfuscatedName("d")
   boolean field2245;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   Signlink field2244;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   Task field2248;
   @ObfuscatedName("z")
   byte[] field2246;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 195369995
   )
   int field2251;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -891271245
   )
   int field2240;
   @ObfuscatedName("x")
   boolean field2249;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1145720011
   )
   final int field2250;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1020972685
   )
   final int field2252;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfe;I)V"
   )
   public class173(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2245 = false;
      this.field2251 = 0;
      this.field2240 = 0;
      this.field2249 = false;
      this.field2244 = var2;
      this.field2242 = var1;
      this.field2250 = var3;
      this.field2252 = var3 - 100;
      this.field2242.setSoTimeout(30000);
      this.field2242.setTcpNoDelay(true);
      this.field2242.setReceiveBufferSize(65536);
      this.field2242.setSendBufferSize(65536);
      this.field2247 = this.field2242.getInputStream();
      this.field2243 = this.field2242.getOutputStream();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1585663712"
   )
   public boolean vmethod3335(int var1) throws IOException {
      return this.field2245?false:this.field2247.available() >= var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "45"
   )
   public int vmethod3334() throws IOException {
      return this.field2245?0:this.field2247.available();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1452513085"
   )
   public int vmethod3349() throws IOException {
      return this.field2245?0:this.field2247.read();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "692266189"
   )
   public int vmethod3348(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2245) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2247.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1491035871"
   )
   public void vmethod3337(byte[] var1, int var2, int var3) throws IOException {
      this.method3336(var1, var2, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-102019490"
   )
   public void vmethod3331() {
      if(!this.field2245) {
         synchronized(this) {
            this.field2245 = true;
            this.notifyAll();
         }

         if(this.field2248 != null) {
            while(this.field2248.status == 0) {
               ScriptVarType.method11(1L);
            }

            if(this.field2248.status == 1) {
               try {
                  ((Thread)this.field2248.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2248 = null;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-949767131"
   )
   void method3336(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2245) {
         if(this.field2249) {
            this.field2249 = false;
            throw new IOException();
         } else {
            if(this.field2246 == null) {
               this.field2246 = new byte[this.field2250];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2246[this.field2240] = var1[var5 + var2];
                  this.field2240 = (this.field2240 + 1) % this.field2250;
                  if((this.field2252 + this.field2251) % this.field2250 == this.field2240) {
                     throw new IOException();
                  }
               }

               if(this.field2248 == null) {
                  this.field2248 = this.field2244.createRunnable(this, 3);
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
                  if(this.field2240 == this.field2251) {
                     if(this.field2245) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2251;
                  if(this.field2240 >= this.field2251) {
                     var1 = this.field2240 - this.field2251;
                  } else {
                     var1 = this.field2250 - this.field2251;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2243.write(this.field2246, var2, var1);
               } catch (IOException var9) {
                  this.field2249 = true;
               }

               this.field2251 = (var1 + this.field2251) % this.field2250;

               try {
                  if(this.field2251 == this.field2240) {
                     this.field2243.flush();
                  }
               } catch (IOException var8) {
                  this.field2249 = true;
               }
               continue;
            }

            try {
               if(this.field2247 != null) {
                  this.field2247.close();
               }

               if(this.field2243 != null) {
                  this.field2243.close();
               }

               if(this.field2242 != null) {
                  this.field2242.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2246 = null;
            break;
         }
      } catch (Exception var12) {
         AttackOption.processClientError((String)null, var12);
      }

   }

   protected void finalize() {
      this.vmethod3331();
   }
}
