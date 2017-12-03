import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class153 implements Runnable {
   @ObfuscatedName("a")
   Thread field2109;
   @ObfuscatedName("w")
   InputStream field2105;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 598845505
   )
   int field2104;
   @ObfuscatedName("k")
   byte[] field2107;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 4962757
   )
   int field2112;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1748739795
   )
   int field2111;
   @ObfuscatedName("t")
   IOException field2110;

   class153(InputStream var1, int var2) {
      this.field2112 = 0;
      this.field2111 = 0;
      this.field2105 = var1;
      this.field2104 = var2 + 1;
      this.field2107 = new byte[this.field2104];
      this.field2109 = new Thread(this);
      this.field2109.setDaemon(true);
      this.field2109.start();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1515870281"
   )
   boolean method2955(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2104) {
         synchronized(this) {
            int var3;
            if(this.field2112 <= this.field2111) {
               var3 = this.field2111 - this.field2112;
            } else {
               var3 = this.field2104 - this.field2112 + this.field2111;
            }

            if(var3 < var1) {
               if(this.field2110 != null) {
                  throw new IOException(this.field2110.toString());
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1571695955"
   )
   int method2965() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2112 <= this.field2111) {
            var2 = this.field2111 - this.field2112;
         } else {
            var2 = this.field2104 - this.field2112 + this.field2111;
         }

         if(var2 <= 0 && this.field2110 != null) {
            throw new IOException(this.field2110.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "26"
   )
   int method2949() throws IOException {
      synchronized(this) {
         if(this.field2112 == this.field2111) {
            if(this.field2110 != null) {
               throw new IOException(this.field2110.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2107[this.field2112] & 255;
            this.field2112 = (this.field2112 + 1) % this.field2104;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "65"
   )
   int method2950(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2112 <= this.field2111) {
               var5 = this.field2111 - this.field2112;
            } else {
               var5 = this.field2104 - this.field2112 + this.field2111;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2110 != null) {
               throw new IOException(this.field2110.toString());
            } else {
               if(var3 + this.field2112 <= this.field2104) {
                  System.arraycopy(this.field2107, this.field2112, var1, var2, var3);
               } else {
                  int var6 = this.field2104 - this.field2112;
                  System.arraycopy(this.field2107, this.field2112, var1, var2, var6);
                  System.arraycopy(this.field2107, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2112 = (var3 + this.field2112) % this.field2104;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   void method2951() {
      synchronized(this) {
         if(this.field2110 == null) {
            this.field2110 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2109.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2110 != null) {
                  return;
               }

               if(this.field2112 == 0) {
                  var1 = this.field2104 - this.field2111 - 1;
               } else if(this.field2112 <= this.field2111) {
                  var1 = this.field2104 - this.field2111;
               } else {
                  var1 = this.field2112 - this.field2111 - 1;
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
            var7 = this.field2105.read(this.field2107, this.field2111, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2110 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2111 = (var7 + this.field2111) % this.field2104;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lii;",
      garbageValue = "-185957239"
   )
   public static class239[] method2967() {
      return new class239[]{class239.field3263, class239.field3257, class239.field3262, class239.field3258, class239.field3256, class239.field3261, class239.field3260, class239.field3259};
   }
}
