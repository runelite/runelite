import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("o")
   Thread field2262;
   @ObfuscatedName("k")
   OutputStream field2263;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2071517315
   )
   int field2260;
   @ObfuscatedName("d")
   byte[] field2261;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -90861275
   )
   int field2259;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 105279205
   )
   int field2258;
   @ObfuscatedName("z")
   IOException field2264;
   @ObfuscatedName("i")
   boolean field2265;

   GameSocket(OutputStream var1, int var2) {
      this.field2259 = 0;
      this.field2258 = 0;
      this.field2263 = var1;
      this.field2260 = var2 + 1;
      this.field2261 = new byte[this.field2260];
      this.field2262 = new Thread(this);
      this.field2262.setDaemon(true);
      this.field2262.start();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "251398267"
   )
   boolean method3373() {
      if(this.field2265) {
         try {
            this.field2263.close();
            if(this.field2264 == null) {
               this.field2264 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2264 == null) {
               this.field2264 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1453798699"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2264 != null) {
               throw new IOException(this.field2264.toString());
            } else {
               int var5;
               if(this.field2259 <= this.field2258) {
                  var5 = this.field2260 - this.field2258 + this.field2259 - 1;
               } else {
                  var5 = this.field2259 - this.field2258 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2258 <= this.field2260) {
                     System.arraycopy(var1, var2, this.field2261, this.field2258, var3);
                  } else {
                     int var6 = this.field2260 - this.field2258;
                     System.arraycopy(var1, var2, this.field2261, this.field2258, var6);
                     System.arraycopy(var1, var6 + var2, this.field2261, 0, var3 - var6);
                  }

                  this.field2258 = (var3 + this.field2258) % this.field2260;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "418874305"
   )
   void method3375() {
      synchronized(this) {
         this.field2265 = true;
         this.notifyAll();
      }

      try {
         this.field2262.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2264 != null) {
                  return;
               }

               if(this.field2259 <= this.field2258) {
                  var1 = this.field2258 - this.field2259;
               } else {
                  var1 = this.field2260 - this.field2259 + this.field2258;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2263.flush();
               } catch (IOException var11) {
                  this.field2264 = var11;
                  return;
               }

               if(this.method3373()) {
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
            if(var1 + this.field2259 <= this.field2260) {
               this.field2263.write(this.field2261, this.field2259, var1);
            } else {
               int var7 = this.field2260 - this.field2259;
               this.field2263.write(this.field2261, this.field2259, var7);
               this.field2263.write(this.field2261, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2264 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2259 = (var1 + this.field2259) % this.field2260;
         }
      } while(!this.method3373());

   }
}
