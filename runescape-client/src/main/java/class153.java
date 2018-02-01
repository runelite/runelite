import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class153 implements Runnable {
   @ObfuscatedName("p")
   Thread field2091;
   @ObfuscatedName("i")
   InputStream field2094;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -249644223
   )
   int field2092;
   @ObfuscatedName("s")
   byte[] field2090;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -213211227
   )
   int field2096;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -282397057
   )
   int field2095;
   @ObfuscatedName("t")
   IOException field2093;

   class153(InputStream var1, int var2) {
      this.field2096 = 0;
      this.field2095 = 0;
      this.field2094 = var1;
      this.field2092 = var2 + 1;
      this.field2090 = new byte[this.field2092];
      this.field2091 = new Thread(this);
      this.field2091.setDaemon(true);
      this.field2091.start();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2141164983"
   )
   boolean method3063(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2092) {
         synchronized(this) {
            int var3;
            if(this.field2096 <= this.field2095) {
               var3 = this.field2095 - this.field2096;
            } else {
               var3 = this.field2092 - this.field2096 + this.field2095;
            }

            if(var3 < var1) {
               if(this.field2093 != null) {
                  throw new IOException(this.field2093.toString());
               } else {
                  this.notifyAll();
                  return false;
               }
            } else {
               return true;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1202189266"
   )
   int method3064() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2096 <= this.field2095) {
            var2 = this.field2095 - this.field2096;
         } else {
            var2 = this.field2092 - this.field2096 + this.field2095;
         }

         if(var2 <= 0 && this.field2093 != null) {
            throw new IOException(this.field2093.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1550099454"
   )
   int method3070() throws IOException {
      synchronized(this) {
         if(this.field2096 == this.field2095) {
            if(this.field2093 != null) {
               throw new IOException(this.field2093.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2090[this.field2096] & 255;
            this.field2096 = (this.field2096 + 1) % this.field2092;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "60"
   )
   int method3082(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2096 <= this.field2095) {
               var5 = this.field2095 - this.field2096;
            } else {
               var5 = this.field2092 - this.field2096 + this.field2095;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2093 != null) {
               throw new IOException(this.field2093.toString());
            } else {
               if(var3 + this.field2096 <= this.field2092) {
                  System.arraycopy(this.field2090, this.field2096, var1, var2, var3);
               } else {
                  int var6 = this.field2092 - this.field2096;
                  System.arraycopy(this.field2090, this.field2096, var1, var2, var6);
                  System.arraycopy(this.field2090, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2096 = (var3 + this.field2096) % this.field2092;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1886174837"
   )
   void method3067() {
      synchronized(this) {
         if(this.field2093 == null) {
            this.field2093 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2091.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2093 != null) {
                  return;
               }

               if(this.field2096 == 0) {
                  var1 = this.field2092 - this.field2095 - 1;
               } else if(this.field2096 <= this.field2095) {
                  var1 = this.field2092 - this.field2095;
               } else {
                  var1 = this.field2096 - this.field2095 - 1;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var10) {
                  ;
               }
            }
         }

         int var7;
         try {
            var7 = this.field2094.read(this.field2090, this.field2095, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2093 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2095 = (var7 + this.field2095) % this.field2092;
         }
      }
   }
}
