import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("t")
   Thread field2223;
   @ObfuscatedName("q")
   OutputStream field2222;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 453998783
   )
   int field2225;
   @ObfuscatedName("a")
   byte[] field2224;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -885760093
   )
   int field2226;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -94509961
   )
   int field2221;
   @ObfuscatedName("e")
   IOException field2227;
   @ObfuscatedName("x")
   boolean field2228;

   GameSocket(OutputStream var1, int var2) {
      this.field2226 = 0;
      this.field2221 = 0;
      this.field2222 = var1;
      this.field2225 = var2 + 1;
      this.field2224 = new byte[this.field2225];
      this.field2223 = new Thread(this);
      this.field2223.setDaemon(true);
      this.field2223.start();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-39"
   )
   boolean method3381() {
      if(this.field2228) {
         try {
            this.field2222.close();
            if(this.field2227 == null) {
               this.field2227 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2227 == null) {
               this.field2227 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1112849919"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2227 != null) {
               throw new IOException(this.field2227.toString());
            } else {
               int var5;
               if(this.field2226 <= this.field2221) {
                  var5 = this.field2225 - this.field2221 + this.field2226 - 1;
               } else {
                  var5 = this.field2226 - this.field2221 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2221 <= this.field2225) {
                     System.arraycopy(var1, var2, this.field2224, this.field2221, var3);
                  } else {
                     int var6 = this.field2225 - this.field2221;
                     System.arraycopy(var1, var2, this.field2224, this.field2221, var6);
                     System.arraycopy(var1, var6 + var2, this.field2224, 0, var3 - var6);
                  }

                  this.field2221 = (var3 + this.field2221) % this.field2225;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-86"
   )
   void method3373() {
      synchronized(this) {
         this.field2228 = true;
         this.notifyAll();
      }

      try {
         this.field2223.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2227 != null) {
                  return;
               }

               if(this.field2226 <= this.field2221) {
                  var1 = this.field2221 - this.field2226;
               } else {
                  var1 = this.field2225 - this.field2226 + this.field2221;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2222.flush();
               } catch (IOException var11) {
                  this.field2227 = var11;
                  return;
               }

               if(this.method3381()) {
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
            if(var1 + this.field2226 <= this.field2225) {
               this.field2222.write(this.field2224, this.field2226, var1);
            } else {
               int var7 = this.field2225 - this.field2226;
               this.field2222.write(this.field2224, this.field2226, var7);
               this.field2222.write(this.field2224, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2227 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2226 = (var1 + this.field2226) % this.field2225;
         }
      } while(!this.method3381());

   }
}
