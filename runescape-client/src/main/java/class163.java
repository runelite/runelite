import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class163 implements Runnable {
   @ObfuscatedName("d")
   Thread field2166;
   @ObfuscatedName("z")
   InputStream field2162;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 126742333
   )
   int field2165;
   @ObfuscatedName("r")
   byte[] field2164;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -488054265
   )
   int field2161;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1660186195
   )
   int field2163;
   @ObfuscatedName("k")
   IOException field2167;

   class163(InputStream var1, int var2) {
      this.field2161 = 0;
      this.field2163 = 0;
      this.field2162 = var1;
      this.field2165 = var2 + 1;
      this.field2164 = new byte[this.field2165];
      this.field2166 = new Thread(this);
      this.field2166.setDaemon(true);
      this.field2166.start();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "224954090"
   )
   boolean method3267(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2165) {
         synchronized(this) {
            int var3;
            if(this.field2161 <= this.field2163) {
               var3 = this.field2163 - this.field2161;
            } else {
               var3 = this.field2165 - this.field2161 + this.field2163;
            }

            if(var3 < var1) {
               if(this.field2167 != null) {
                  throw new IOException(this.field2167.toString());
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-89"
   )
   int method3280() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2161 <= this.field2163) {
            var2 = this.field2163 - this.field2161;
         } else {
            var2 = this.field2165 - this.field2161 + this.field2163;
         }

         if(var2 <= 0 && this.field2167 != null) {
            throw new IOException(this.field2167.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   int method3268() throws IOException {
      synchronized(this) {
         if(this.field2161 == this.field2163) {
            if(this.field2167 != null) {
               throw new IOException(this.field2167.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2164[this.field2161] & 255;
            this.field2161 = (this.field2161 + 1) % this.field2165;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1574110824"
   )
   int method3271(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2161 <= this.field2163) {
               var5 = this.field2163 - this.field2161;
            } else {
               var5 = this.field2165 - this.field2161 + this.field2163;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2167 != null) {
               throw new IOException(this.field2167.toString());
            } else {
               if(var3 + this.field2161 <= this.field2165) {
                  System.arraycopy(this.field2164, this.field2161, var1, var2, var3);
               } else {
                  int var6 = this.field2165 - this.field2161;
                  System.arraycopy(this.field2164, this.field2161, var1, var2, var6);
                  System.arraycopy(this.field2164, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2161 = (var3 + this.field2161) % this.field2165;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1177486122"
   )
   void method3270() {
      synchronized(this) {
         if(this.field2167 == null) {
            this.field2167 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2166.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2167 != null) {
                  return;
               }

               if(this.field2161 == 0) {
                  var1 = this.field2165 - this.field2163 - 1;
               } else if(this.field2161 <= this.field2163) {
                  var1 = this.field2165 - this.field2163;
               } else {
                  var1 = this.field2161 - this.field2163 - 1;
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
            var7 = this.field2162.read(this.field2164, this.field2163, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2167 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2163 = (var7 + this.field2163) % this.field2165;
         }
      }
   }
}
