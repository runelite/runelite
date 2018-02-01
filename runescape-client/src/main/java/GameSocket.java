import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("p")
   Thread field2163;
   @ObfuscatedName("i")
   OutputStream field2164;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1382508221
   )
   int field2169;
   @ObfuscatedName("s")
   byte[] field2165;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1986274811
   )
   int field2166;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1340259817
   )
   int field2162;
   @ObfuscatedName("t")
   IOException field2168;
   @ObfuscatedName("r")
   boolean field2167;

   GameSocket(OutputStream var1, int var2) {
      this.field2166 = 0;
      this.field2162 = 0;
      this.field2164 = var1;
      this.field2169 = var2 + 1;
      this.field2165 = new byte[this.field2169];
      this.field2163 = new Thread(this);
      this.field2163.setDaemon(true);
      this.field2163.start();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1044005427"
   )
   boolean method3237() {
      if(this.field2167) {
         try {
            this.field2164.close();
            if(this.field2168 == null) {
               this.field2168 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2168 == null) {
               this.field2168 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-93055267"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2168 != null) {
               throw new IOException(this.field2168.toString());
            } else {
               int var5;
               if(this.field2166 <= this.field2162) {
                  var5 = this.field2169 - this.field2162 + this.field2166 - 1;
               } else {
                  var5 = this.field2166 - this.field2162 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2162 <= this.field2169) {
                     System.arraycopy(var1, var2, this.field2165, this.field2162, var3);
                  } else {
                     int var6 = this.field2169 - this.field2162;
                     System.arraycopy(var1, var2, this.field2165, this.field2162, var6);
                     System.arraycopy(var1, var6 + var2, this.field2165, 0, var3 - var6);
                  }

                  this.field2162 = (var3 + this.field2162) % this.field2169;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1889822290"
   )
   void method3242() {
      synchronized(this) {
         this.field2167 = true;
         this.notifyAll();
      }

      try {
         this.field2163.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2168 != null) {
                  return;
               }

               if(this.field2166 <= this.field2162) {
                  var1 = this.field2162 - this.field2166;
               } else {
                  var1 = this.field2169 - this.field2166 + this.field2162;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2164.flush();
               } catch (IOException var11) {
                  this.field2168 = var11;
                  return;
               }

               if(this.method3237()) {
                  return;
               }

               try {
                  this.wait();
               } catch (InterruptedException var12) {
                  ;
               }
            }
         }

         try {
            if(var1 + this.field2166 <= this.field2169) {
               this.field2164.write(this.field2165, this.field2166, var1);
            } else {
               int var7 = this.field2169 - this.field2166;
               this.field2164.write(this.field2165, this.field2166, var7);
               this.field2164.write(this.field2165, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2168 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2166 = (var1 + this.field2166) % this.field2169;
         }
      } while(!this.method3237());

   }
}
