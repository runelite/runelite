import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class163 implements Runnable {
   @ObfuscatedName("g")
   Thread field2158;
   @ObfuscatedName("e")
   InputStream field2159;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 208836217
   )
   int field2162;
   @ObfuscatedName("z")
   byte[] field2165;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -667460489
   )
   int field2166;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 238683405
   )
   int field2163;
   @ObfuscatedName("s")
   IOException field2164;

   class163(InputStream var1, int var2) {
      this.field2166 = 0;
      this.field2163 = 0;
      this.field2159 = var1;
      this.field2162 = var2 + 1;
      this.field2165 = new byte[this.field2162];
      this.field2158 = new Thread(this);
      this.field2158.setDaemon(true);
      this.field2158.start();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1751218372"
   )
   boolean method3282(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2162) {
         synchronized(this) {
            int var3;
            if(this.field2166 <= this.field2163) {
               var3 = this.field2163 - this.field2166;
            } else {
               var3 = this.field2162 - this.field2166 + this.field2163;
            }

            if(var3 < var1) {
               if(this.field2164 != null) {
                  throw new IOException(this.field2164.toString());
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130058624"
   )
   int method3299() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2166 <= this.field2163) {
            var2 = this.field2163 - this.field2166;
         } else {
            var2 = this.field2162 - this.field2166 + this.field2163;
         }

         if(var2 <= 0 && this.field2164 != null) {
            throw new IOException(this.field2164.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1363030110"
   )
   int method3284() throws IOException {
      synchronized(this) {
         if(this.field2166 == this.field2163) {
            if(this.field2164 != null) {
               throw new IOException(this.field2164.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2165[this.field2166] & 255;
            this.field2166 = (this.field2166 + 1) % this.field2162;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1671576935"
   )
   int method3285(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2166 <= this.field2163) {
               var5 = this.field2163 - this.field2166;
            } else {
               var5 = this.field2162 - this.field2166 + this.field2163;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2164 != null) {
               throw new IOException(this.field2164.toString());
            } else {
               if(var3 + this.field2166 <= this.field2162) {
                  System.arraycopy(this.field2165, this.field2166, var1, var2, var3);
               } else {
                  int var6 = this.field2162 - this.field2166;
                  System.arraycopy(this.field2165, this.field2166, var1, var2, var6);
                  System.arraycopy(this.field2165, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2166 = (var3 + this.field2166) % this.field2162;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   void method3293() {
      synchronized(this) {
         if(this.field2164 == null) {
            this.field2164 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2158.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2164 != null) {
                  return;
               }

               if(this.field2166 == 0) {
                  var1 = this.field2162 - this.field2163 - 1;
               } else if(this.field2166 <= this.field2163) {
                  var1 = this.field2162 - this.field2163;
               } else {
                  var1 = this.field2166 - this.field2163 - 1;
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
            var7 = this.field2159.read(this.field2165, this.field2163, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2164 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2163 = (var7 + this.field2163) % this.field2162;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[Lfj;",
      garbageValue = "-1505029449"
   )
   public static ServerPacket[] method3298() {
      return new ServerPacket[]{ServerPacket.field2362, ServerPacket.field2278, ServerPacket.field2279, ServerPacket.field2289, ServerPacket.field2281, ServerPacket.field2345, ServerPacket.field2335, ServerPacket.field2299, ServerPacket.field2320, ServerPacket.field2286, ServerPacket.field2284, ServerPacket.field2288, ServerPacket.field2355, ServerPacket.field2290, ServerPacket.field2291, ServerPacket.field2310, ServerPacket.field2293, ServerPacket.field2294, ServerPacket.field2295, ServerPacket.field2296, ServerPacket.field2297, ServerPacket.field2300, ServerPacket.field2282, ServerPacket.field2344, ServerPacket.field2301, ServerPacket.field2302, ServerPacket.field2303, ServerPacket.field2304, ServerPacket.field2305, ServerPacket.field2306, ServerPacket.field2298, ServerPacket.field2317, ServerPacket.field2309, ServerPacket.field2334, ServerPacket.field2311, ServerPacket.field2312, ServerPacket.field2313, ServerPacket.field2319, ServerPacket.field2337, ServerPacket.field2316, ServerPacket.field2360, ServerPacket.field2318, ServerPacket.field2331, ServerPacket.field2333, ServerPacket.field2321, ServerPacket.field2322, ServerPacket.field2323, ServerPacket.field2324, ServerPacket.field2325, ServerPacket.field2326, ServerPacket.field2327, ServerPacket.field2328, ServerPacket.field2329, ServerPacket.field2330, ServerPacket.field2358, ServerPacket.field2332, ServerPacket.field2308, ServerPacket.field2277, ServerPacket.field2315, ServerPacket.field2336, ServerPacket.field2357, ServerPacket.field2338, ServerPacket.field2339, ServerPacket.field2340, ServerPacket.field2341, ServerPacket.field2342, ServerPacket.field2343, ServerPacket.field2283, ServerPacket.field2285, ServerPacket.field2346, ServerPacket.field2347, ServerPacket.field2348, ServerPacket.field2349, ServerPacket.field2350, ServerPacket.field2351, ServerPacket.field2352, ServerPacket.field2353, ServerPacket.field2314, ServerPacket.field2280, ServerPacket.field2356, ServerPacket.field2287, ServerPacket.field2359, ServerPacket.field2292, ServerPacket.field2354};
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-624190528"
   )
   public static int method3286(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(Lbd;IIS)V",
      garbageValue = "147"
   )
   static void method3290(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = NPC.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.actionFrameCycle = 0;
            var0.actionAnimationDisable = var2;
            var0.field1176 = 0;
         }

         if(var3 == 2) {
            var0.field1176 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || NPC.getAnimation(var1).forcedPriority >= NPC.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.actionFrameCycle = 0;
         var0.actionAnimationDisable = var2;
         var0.field1176 = 0;
         var0.field1178 = var0.queueSize;
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "43"
   )
   static final void method3303(int var0, int var1, int var2, int var3, int var4) {
      class7.scrollbarSprites[0].method5898(var0, var1);
      class7.scrollbarSprites[1].method5898(var0, var3 + var1 - 16);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field914);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field1065);
      Rasterizer2D.method5814(var0, var6 + var1 + 16, var5, Client.field903);
      Rasterizer2D.method5814(var0 + 1, var6 + var1 + 16, var5, Client.field903);
      Rasterizer2D.method5812(var0, var6 + var1 + 16, 16, Client.field903);
      Rasterizer2D.method5812(var0, var6 + var1 + 17, 16, Client.field903);
      Rasterizer2D.method5814(var0 + 15, var6 + var1 + 16, var5, Client.field1107);
      Rasterizer2D.method5814(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field1107);
      Rasterizer2D.method5812(var0, var6 + var5 + var1 + 15, 16, Client.field1107);
      Rasterizer2D.method5812(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field1107);
   }
}
