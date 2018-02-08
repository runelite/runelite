import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("s")
   Thread field2195;
   @ObfuscatedName("g")
   OutputStream field2194;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -466339517
   )
   int field2196;
   @ObfuscatedName("h")
   byte[] field2198;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1160776617
   )
   int field2201;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -201566575
   )
   int field2199;
   @ObfuscatedName("t")
   IOException field2200;
   @ObfuscatedName("d")
   boolean field2197;

   GameSocket(OutputStream var1, int var2) {
      this.field2201 = 0;
      this.field2199 = 0;
      this.field2194 = var1;
      this.field2196 = var2 + 1;
      this.field2198 = new byte[this.field2196];
      this.field2195 = new Thread(this);
      this.field2195.setDaemon(true);
      this.field2195.start();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1411261537"
   )
   boolean method3338() {
      if(this.field2197) {
         try {
            this.field2194.close();
            if(this.field2200 == null) {
               this.field2200 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2200 == null) {
               this.field2200 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2070892941"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2200 != null) {
               throw new IOException(this.field2200.toString());
            } else {
               int var5;
               if(this.field2201 <= this.field2199) {
                  var5 = this.field2196 - this.field2199 + this.field2201 - 1;
               } else {
                  var5 = this.field2201 - this.field2199 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2199 <= this.field2196) {
                     System.arraycopy(var1, var2, this.field2198, this.field2199, var3);
                  } else {
                     int var6 = this.field2196 - this.field2199;
                     System.arraycopy(var1, var2, this.field2198, this.field2199, var6);
                     System.arraycopy(var1, var6 + var2, this.field2198, 0, var3 - var6);
                  }

                  this.field2199 = (var3 + this.field2199) % this.field2196;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "83"
   )
   void method3347() {
      synchronized(this) {
         this.field2197 = true;
         this.notifyAll();
      }

      try {
         this.field2195.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2200 != null) {
                  return;
               }

               if(this.field2201 <= this.field2199) {
                  var1 = this.field2199 - this.field2201;
               } else {
                  var1 = this.field2196 - this.field2201 + this.field2199;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2194.flush();
               } catch (IOException var11) {
                  this.field2200 = var11;
                  return;
               }

               if(this.method3338()) {
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
            if(var1 + this.field2201 <= this.field2196) {
               this.field2194.write(this.field2198, this.field2201, var1);
            } else {
               int var7 = this.field2196 - this.field2201;
               this.field2194.write(this.field2198, this.field2201, var7);
               this.field2194.write(this.field2198, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2200 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2201 = (var1 + this.field2201) % this.field2196;
         }
      } while(!this.method3338());

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lfx;",
      garbageValue = "633635987"
   )
   public static ServerPacket[] method3340() {
      return new ServerPacket[]{ServerPacket.field2285, ServerPacket.field2237, ServerPacket.field2238, ServerPacket.field2239, ServerPacket.field2258, ServerPacket.field2257, ServerPacket.field2242, ServerPacket.field2243, ServerPacket.field2315, ServerPacket.field2245, ServerPacket.field2246, ServerPacket.field2281, ServerPacket.field2302, ServerPacket.field2274, ServerPacket.field2260, ServerPacket.field2251, ServerPacket.field2252, ServerPacket.field2253, ServerPacket.field2254, ServerPacket.field2267, ServerPacket.field2256, ServerPacket.field2250, ServerPacket.field2249, ServerPacket.field2259, ServerPacket.field2270, ServerPacket.field2261, ServerPacket.field2289, ServerPacket.field2263, ServerPacket.field2262, ServerPacket.field2293, ServerPacket.field2266, ServerPacket.field2272, ServerPacket.field2268, ServerPacket.field2307, ServerPacket.field2304, ServerPacket.field2271, ServerPacket.field2269, ServerPacket.field2265, ServerPacket.field2283, ServerPacket.field2275, ServerPacket.field2276, ServerPacket.field2277, ServerPacket.field2278, ServerPacket.field2279, ServerPacket.field2264, ServerPacket.field2236, ServerPacket.field2282, ServerPacket.field2280, ServerPacket.field2284, ServerPacket.field2288, ServerPacket.field2286, ServerPacket.field2287, ServerPacket.field2297, ServerPacket.field2306, ServerPacket.field2290, ServerPacket.field2291, ServerPacket.field2292, ServerPacket.field2316, ServerPacket.field2294, ServerPacket.field2295, ServerPacket.field2296, ServerPacket.field2241, ServerPacket.field2298, ServerPacket.field2255, ServerPacket.field2248, ServerPacket.field2301, ServerPacket.field2300, ServerPacket.field2303, ServerPacket.field2247, ServerPacket.field2305, ServerPacket.field2273, ServerPacket.field2244, ServerPacket.field2308, ServerPacket.field2309, ServerPacket.field2310, ServerPacket.field2311, ServerPacket.field2312, ServerPacket.field2313, ServerPacket.field2314, ServerPacket.field2240, ServerPacket.field2299};
   }
}
