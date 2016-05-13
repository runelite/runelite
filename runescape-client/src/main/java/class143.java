import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public final class class143 implements Runnable {
   @ObfuscatedName("o")
   byte[] field2189;
   @ObfuscatedName("x")
   boolean field2190 = false;
   @ObfuscatedName("d")
   class136 field2191;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -115979939
   )
   int field2192 = 0;
   @ObfuscatedName("s")
   InputStream field2193;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -224735635
   )
   int field2194 = 0;
   @ObfuscatedName("j")
   OutputStream field2195;
   @ObfuscatedName("c")
   boolean field2196 = false;
   @ObfuscatedName("u")
   class146 field2197;
   @ObfuscatedName("p")
   Socket field2199;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "76"
   )
   public void method2960() {
      if(!this.field2190) {
         synchronized(this) {
            this.field2190 = true;
            this.notifyAll();
         }

         if(null != this.field2197) {
            while(0 == this.field2197.field2226) {
               class116.method2448(1L);
            }

            if(1 == this.field2197.field2226) {
               try {
                  ((Thread)this.field2197.field2224).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2197 = null;
      }

   }

   protected void finalize() {
      this.method2960();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-470372781"
   )
   public void method2961(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2190) {
         while(var3 > 0) {
            int var4 = this.field2193.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method2962() throws IOException {
      return this.field2190?0:this.field2193.available();
   }

   public class143(Socket var1, class136 var2) throws IOException {
      this.field2191 = var2;
      this.field2199 = var1;
      this.field2199.setSoTimeout(30000);
      this.field2199.setTcpNoDelay(true);
      this.field2199.setReceiveBufferSize(16384);
      this.field2199.setSendBufferSize(16384);
      this.field2193 = this.field2199.getInputStream();
      this.field2195 = this.field2199.getOutputStream();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   public void method2964(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2190) {
         if(this.field2196) {
            this.field2196 = false;
            throw new IOException();
         }

         if(null == this.field2189) {
            this.field2189 = new byte[5000];
         }

         synchronized(this) {
            for(int var5 = 0; var5 < var3; ++var5) {
               this.field2189[this.field2192] = var1[var2 + var5];
               this.field2192 = (this.field2192 + 1) % 5000;
               if(this.field2192 == (4900 + this.field2194) % 5000) {
                  throw new IOException();
               }
            }

            if(null == this.field2197) {
               this.field2197 = this.field2191.method2862(this, 3);
            }

            this.notifyAll();
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
                  if(this.field2192 == this.field2194) {
                     if(this.field2190) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field2194;
                  if(this.field2192 >= this.field2194) {
                     var1 = this.field2192 - this.field2194;
                  } else {
                     var1 = 5000 - this.field2194;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2195.write(this.field2189, var2, var1);
               } catch (IOException var8) {
                  this.field2196 = true;
               }

               this.field2194 = (var1 + this.field2194) % 5000;

               try {
                  if(this.field2194 == this.field2192) {
                     this.field2195.flush();
                  }
               } catch (IOException var7) {
                  this.field2196 = true;
               }
               continue;
            }

            try {
               if(this.field2193 != null) {
                  this.field2193.close();
               }

               if(null != this.field2195) {
                  this.field2195.close();
               }

               if(this.field2199 != null) {
                  this.field2199.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field2189 = null;
            break;
         }
      } catch (Exception var11) {
         class90.method2067((String)null, var11);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-34"
   )
   public int method2979() throws IOException {
      return this.field2190?0:this.field2193.read();
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-925433920"
   )
   static final void method2980(int var0, int var1) {
      if(var0 != class110.field1945 || var1 != class82.field1438) {
         class110.field1945 = var0;
         class82.field1438 = var1;
         class15.method188(25);
         class153.method3132("Loading - please wait.", true);
         int var2 = class22.field594;
         int var3 = class114.field1981;
         class22.field594 = (var0 - 6) * 8;
         class114.field1981 = (var1 - 6) * 8;
         int var4 = class22.field594 - var2;
         int var5 = class114.field1981 - var3;
         var2 = class22.field594;
         var3 = class114.field1981;

         int var6;
         int var7;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var8 = client.field515[var6];
            if(null != var8) {
               for(var7 = 0; var7 < 10; ++var7) {
                  var8.field866[var7] -= var4;
                  var8.field863[var7] -= var5;
               }

               var8.field823 -= var4 * 128;
               var8.field813 -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var19 = client.field491[var6];
            if(var19 != null) {
               for(var7 = 0; var7 < 10; ++var7) {
                  var19.field866[var7] -= var4;
                  var19.field863[var7] -= var5;
               }

               var19.field823 -= 128 * var4;
               var19.field813 -= 128 * var5;
            }
         }

         byte var20 = 0;
         byte var9 = 104;
         byte var10 = 1;
         if(var4 < 0) {
            var20 = 103;
            var9 = -1;
            var10 = -1;
         }

         byte var11 = 0;
         byte var12 = 104;
         byte var13 = 1;
         if(var5 < 0) {
            var11 = 103;
            var12 = -1;
            var13 = -1;
         }

         int var14;
         for(int var15 = var20; var9 != var15; var15 += var10) {
            for(var14 = var11; var12 != var14; var14 += var13) {
               int var16 = var15 + var4;
               int var17 = var5 + var14;

               for(int var18 = 0; var18 < 4; ++var18) {
                  if(var16 >= 0 && var17 >= 0 && var16 < 104 && var17 < 104) {
                     client.field345[var18][var15][var14] = client.field345[var18][var16][var17];
                  } else {
                     client.field345[var18][var15][var14] = null;
                  }
               }
            }
         }

         for(class16 var21 = (class16)client.field411.method3812(); null != var21; var21 = (class16)client.field411.method3817()) {
            var21.field221 -= var4;
            var21.field232 -= var5;
            if(var21.field221 < 0 || var21.field232 < 0 || var21.field221 >= 104 || var21.field232 >= 104) {
               var21.method3898();
            }
         }

         if(0 != client.field512) {
            client.field512 -= var4;
            client.field513 -= var5;
         }

         client.field521 = 0;
         client.field558 = false;
         client.field507 = -1;
         client.field413.method3806();
         client.field414.method3806();

         for(var14 = 0; var14 < 4; ++var14) {
            client.field340[var14].method2374();
         }
      }

   }
}
