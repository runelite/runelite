import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class163 implements Runnable {
   @ObfuscatedName("o")
   Thread field2186;
   @ObfuscatedName("k")
   InputStream field2187;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1658845473
   )
   int field2188;
   @ObfuscatedName("d")
   byte[] field2189;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1249541047
   )
   int field2192;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1683105831
   )
   int field2191;
   @ObfuscatedName("z")
   IOException field2190;

   class163(InputStream var1, int var2) {
      this.field2192 = 0;
      this.field2191 = 0;
      this.field2187 = var1;
      this.field2188 = var2 + 1;
      this.field2189 = new byte[this.field2188];
      this.field2186 = new Thread(this);
      this.field2186.setDaemon(true);
      this.field2186.start();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1798284945"
   )
   boolean method3200(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2188) {
         synchronized(this) {
            int var3;
            if(this.field2192 <= this.field2191) {
               var3 = this.field2191 - this.field2192;
            } else {
               var3 = this.field2188 - this.field2192 + this.field2191;
            }

            if(var3 < var1) {
               if(this.field2190 != null) {
                  throw new IOException(this.field2190.toString());
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "892552373"
   )
   int method3196() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2192 <= this.field2191) {
            var2 = this.field2191 - this.field2192;
         } else {
            var2 = this.field2188 - this.field2192 + this.field2191;
         }

         if(var2 <= 0 && this.field2190 != null) {
            throw new IOException(this.field2190.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "934612812"
   )
   int method3203() throws IOException {
      synchronized(this) {
         if(this.field2191 == this.field2192) {
            if(this.field2190 != null) {
               throw new IOException(this.field2190.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2189[this.field2192] & 255;
            this.field2192 = (this.field2192 + 1) % this.field2188;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1840223672"
   )
   int method3198(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2192 <= this.field2191) {
               var5 = this.field2191 - this.field2192;
            } else {
               var5 = this.field2188 - this.field2192 + this.field2191;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2190 != null) {
               throw new IOException(this.field2190.toString());
            } else {
               if(var3 + this.field2192 <= this.field2188) {
                  System.arraycopy(this.field2189, this.field2192, var1, var2, var3);
               } else {
                  int var6 = this.field2188 - this.field2192;
                  System.arraycopy(this.field2189, this.field2192, var1, var2, var6);
                  System.arraycopy(this.field2189, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2192 = (var3 + this.field2192) % this.field2188;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "837736070"
   )
   void method3204() {
      synchronized(this) {
         if(this.field2190 == null) {
            this.field2190 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2186.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2190 != null) {
                  return;
               }

               if(this.field2192 == 0) {
                  var1 = this.field2188 - this.field2191 - 1;
               } else if(this.field2192 <= this.field2191) {
                  var1 = this.field2188 - this.field2191;
               } else {
                  var1 = this.field2192 - this.field2191 - 1;
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
            var7 = this.field2187.read(this.field2189, this.field2191, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2190 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2191 = (var7 + this.field2191) % this.field2188;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjf;IIIZI)V",
      garbageValue = "532918908"
   )
   public static void method3213(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class229.field2687 = 1;
      class185.field2511 = var1;
      VertexNormal.field1931 = var2;
      GrandExchangeEvents.field284 = var3;
      class86.field1330 = var4;
      class229.field2692 = var5;
      class2.field11 = var0;
   }
}
