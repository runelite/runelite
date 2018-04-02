import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1027156361
   )
   static int field2258;
   @ObfuscatedName("c")
   Thread field2256;
   @ObfuscatedName("i")
   OutputStream field2250;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1635066913
   )
   int field2252;
   @ObfuscatedName("j")
   byte[] field2253;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 404655515
   )
   int field2251;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1299558609
   )
   int field2255;
   @ObfuscatedName("z")
   IOException field2254;
   @ObfuscatedName("p")
   boolean field2257;

   GameSocket(OutputStream var1, int var2) {
      this.field2251 = 0;
      this.field2255 = 0;
      this.field2250 = var1;
      this.field2252 = var2 + 1;
      this.field2253 = new byte[this.field2252];
      this.field2256 = new Thread(this);
      this.field2256.setDaemon(true);
      this.field2256.start();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1670459788"
   )
   boolean method3354() {
      if(this.field2257) {
         try {
            this.field2250.close();
            if(this.field2254 == null) {
               this.field2254 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2254 == null) {
               this.field2254 = new IOException(var2);
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
      garbageValue = "1843339632"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2254 != null) {
               throw new IOException(this.field2254.toString());
            } else {
               int var5;
               if(this.field2251 <= this.field2255) {
                  var5 = this.field2252 - this.field2255 + this.field2251 - 1;
               } else {
                  var5 = this.field2251 - this.field2255 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2255 <= this.field2252) {
                     System.arraycopy(var1, var2, this.field2253, this.field2255, var3);
                  } else {
                     int var6 = this.field2252 - this.field2255;
                     System.arraycopy(var1, var2, this.field2253, this.field2255, var6);
                     System.arraycopy(var1, var6 + var2, this.field2253, 0, var3 - var6);
                  }

                  this.field2255 = (var3 + this.field2255) % this.field2252;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "540187265"
   )
   void method3353() {
      synchronized(this) {
         this.field2257 = true;
         this.notifyAll();
      }

      try {
         this.field2256.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2254 != null) {
                  return;
               }

               if(this.field2251 <= this.field2255) {
                  var1 = this.field2255 - this.field2251;
               } else {
                  var1 = this.field2252 - this.field2251 + this.field2255;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2250.flush();
               } catch (IOException var11) {
                  this.field2254 = var11;
                  return;
               }

               if(this.method3354()) {
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
            if(var1 + this.field2251 <= this.field2252) {
               this.field2250.write(this.field2253, this.field2251, var1);
            } else {
               int var7 = this.field2252 - this.field2251;
               this.field2250.write(this.field2253, this.field2251, var7);
               this.field2250.write(this.field2253, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2254 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2251 = (var1 + this.field2251) % this.field2252;
         }
      } while(!this.method3354());

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)[Lfe;",
      garbageValue = "2118610258"
   )
   public static ServerPacket[] method3366() {
      return new ServerPacket[]{ServerPacket.field2302, ServerPacket.field2286, ServerPacket.field2360, ServerPacket.field2332, ServerPacket.field2310, ServerPacket.field2300, ServerPacket.field2291, ServerPacket.field2289, ServerPacket.field2293, ServerPacket.field2294, ServerPacket.field2295, ServerPacket.field2316, ServerPacket.field2297, ServerPacket.field2298, ServerPacket.field2299, ServerPacket.field2356, ServerPacket.field2301, ServerPacket.field2361, ServerPacket.field2334, ServerPacket.field2304, ServerPacket.field2305, ServerPacket.field2322, ServerPacket.field2307, ServerPacket.field2308, ServerPacket.field2341, ServerPacket.field2313, ServerPacket.field2290, ServerPacket.field2312, ServerPacket.field2342, ServerPacket.field2314, ServerPacket.field2350, ServerPacket.field2285, ServerPacket.field2317, ServerPacket.field2346, ServerPacket.field2319, ServerPacket.field2320, ServerPacket.field2321, ServerPacket.field2288, ServerPacket.field2323, ServerPacket.field2324, ServerPacket.field2309, ServerPacket.field2326, ServerPacket.field2327, ServerPacket.field2296, ServerPacket.field2329, ServerPacket.field2330, ServerPacket.field2331, ServerPacket.field2292, ServerPacket.field2333, ServerPacket.field2306, ServerPacket.field2335, ServerPacket.field2336, ServerPacket.field2337, ServerPacket.field2363, ServerPacket.field2339, ServerPacket.field2340, ServerPacket.field2287, ServerPacket.field2315, ServerPacket.field2343, ServerPacket.field2344, ServerPacket.field2345, ServerPacket.field2325, ServerPacket.field2347, ServerPacket.field2348, ServerPacket.field2349, ServerPacket.field2328, ServerPacket.field2351, ServerPacket.field2352, ServerPacket.field2353, ServerPacket.field2354, ServerPacket.field2355, ServerPacket.field2366, ServerPacket.field2357, ServerPacket.field2358, ServerPacket.field2359, ServerPacket.field2303, ServerPacket.field2318, ServerPacket.field2362, ServerPacket.field2311, ServerPacket.field2364, ServerPacket.field2365, ServerPacket.field2338, ServerPacket.field2367, ServerPacket.field2368};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Lcv;",
      garbageValue = "1602843149"
   )
   static AttackOption[] method3365() {
      return new AttackOption[]{AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick};
   }
}
