import java.awt.FontMetrics;
import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("ag")
   static FontMetrics field2247;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("mo")
   @ObfuscatedSignature(
      signature = "[Liz;"
   )
   static Widget[] field2246;
   @ObfuscatedName("g")
   Thread field2236;
   @ObfuscatedName("e")
   OutputStream field2244;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 669093191
   )
   int field2237;
   @ObfuscatedName("z")
   byte[] field2239;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 40079749
   )
   int field2240;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 490650313
   )
   int field2241;
   @ObfuscatedName("s")
   IOException field2242;
   @ObfuscatedName("y")
   boolean field2238;

   GameSocket(OutputStream var1, int var2) {
      this.field2240 = 0;
      this.field2241 = 0;
      this.field2244 = var1;
      this.field2237 = var2 + 1;
      this.field2239 = new byte[this.field2237];
      this.field2236 = new Thread(this);
      this.field2236.setDaemon(true);
      this.field2236.start();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "412174666"
   )
   boolean method3444() {
      if(this.field2238) {
         try {
            this.field2244.close();
            if(this.field2242 == null) {
               this.field2242 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2242 == null) {
               this.field2242 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-294427870"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2242 != null) {
               throw new IOException(this.field2242.toString());
            } else {
               int var5;
               if(this.field2240 <= this.field2241) {
                  var5 = this.field2237 - this.field2241 + this.field2240 - 1;
               } else {
                  var5 = this.field2240 - this.field2241 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2241 <= this.field2237) {
                     System.arraycopy(var1, var2, this.field2239, this.field2241, var3);
                  } else {
                     int var6 = this.field2237 - this.field2241;
                     System.arraycopy(var1, var2, this.field2239, this.field2241, var6);
                     System.arraycopy(var1, var6 + var2, this.field2239, 0, var3 - var6);
                  }

                  this.field2241 = (var3 + this.field2241) % this.field2237;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-996608139"
   )
   void method3446() {
      synchronized(this) {
         this.field2238 = true;
         this.notifyAll();
      }

      try {
         this.field2236.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2242 != null) {
                  return;
               }

               if(this.field2240 <= this.field2241) {
                  var1 = this.field2241 - this.field2240;
               } else {
                  var1 = this.field2237 - this.field2240 + this.field2241;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2244.flush();
               } catch (IOException var11) {
                  this.field2242 = var11;
                  return;
               }

               if(this.method3444()) {
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
            if(var1 + this.field2240 <= this.field2237) {
               this.field2244.write(this.field2239, this.field2240, var1);
            } else {
               int var7 = this.field2237 - this.field2240;
               this.field2244.write(this.field2239, this.field2240, var7);
               this.field2244.write(this.field2239, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2242 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2240 = (var1 + this.field2240) % this.field2237;
         }
      } while(!this.method3444());

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)J",
      garbageValue = "192"
   )
   static long method3443(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 'A' && var5 <= 'Z') {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 'a' && var5 <= 'z') {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= '0' && var5 <= '9') {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1903419189"
   )
   public static void method3447() {
      class281.field3568.reset();
      class281.field3584.reset();
      class281.field3570.reset();
   }
}
