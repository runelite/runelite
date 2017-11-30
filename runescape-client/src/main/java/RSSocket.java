import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("RSSocket")
public class RSSocket implements Runnable {
   @ObfuscatedName("cu")
   public static char field2186;
   @ObfuscatedName("a")
   Thread field2191;
   @ObfuscatedName("w")
   OutputStream field2183;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1892310589
   )
   int field2192;
   @ObfuscatedName("k")
   byte[] field2185;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 985169115
   )
   int field2187;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1331862449
   )
   int field2184;
   @ObfuscatedName("t")
   IOException field2182;
   @ObfuscatedName("f")
   boolean field2189;

   RSSocket(OutputStream var1, int var2) {
      this.field2187 = 0;
      this.field2184 = 0;
      this.field2183 = var1;
      this.field2192 = var2 + 1;
      this.field2185 = new byte[this.field2192];
      this.field2191 = new Thread(this);
      this.field2191.setDaemon(true);
      this.field2191.start();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1927080309"
   )
   boolean method3118() {
      if(this.field2189) {
         try {
            this.field2183.close();
            if(this.field2182 == null) {
               this.field2182 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2182 == null) {
               this.field2182 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1788497738"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2182 != null) {
               throw new IOException(this.field2182.toString());
            } else {
               int var5;
               if(this.field2187 <= this.field2184) {
                  var5 = this.field2192 - this.field2184 + this.field2187 - 1;
               } else {
                  var5 = this.field2187 - this.field2184 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2184 <= this.field2192) {
                     System.arraycopy(var1, var2, this.field2185, this.field2184, var3);
                  } else {
                     int var6 = this.field2192 - this.field2184;
                     System.arraycopy(var1, var2, this.field2185, this.field2184, var6);
                     System.arraycopy(var1, var6 + var2, this.field2185, 0, var3 - var6);
                  }

                  this.field2184 = (var3 + this.field2184) % this.field2192;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method3125() {
      synchronized(this) {
         this.field2189 = true;
         this.notifyAll();
      }

      try {
         this.field2191.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         synchronized(this){}

         while(true) {
            boolean var14 = false;

            int var1;
            try {
               var14 = true;
               if(this.field2182 != null) {
                  return;
               }

               if(this.field2187 <= this.field2184) {
                  var1 = this.field2184 - this.field2187;
               } else {
                  var1 = this.field2192 - this.field2187 + this.field2184;
               }

               if(var1 <= 0) {
                  try {
                     this.field2183.flush();
                  } catch (IOException var18) {
                     this.field2182 = var18;
                     return;
                  }

                  if(this.method3118()) {
                     return;
                  }

                  try {
                     this.wait();
                  } catch (InterruptedException var19) {
                     ;
                  }
                  continue;
               }

               var14 = false;
            } finally {
               if(var14) {
                  ;
               }
            }

            try {
               if(var1 + this.field2187 <= this.field2192) {
                  this.field2183.write(this.field2185, this.field2187, var1);
               } else {
                  int var7 = this.field2192 - this.field2187;
                  this.field2183.write(this.field2185, this.field2187, var7);
                  this.field2183.write(this.field2185, 0, var1 - var7);
               }
            } catch (IOException var17) {
               IOException var2 = var17;
               synchronized(this) {
                  this.field2182 = var2;
                  return;
               }
            }

            synchronized(this) {
               this.field2187 = (var1 + this.field2187) % this.field2192;
            }

            if(!this.method3118()) {
               break;
            }

            return;
         }
      }
   }
}
