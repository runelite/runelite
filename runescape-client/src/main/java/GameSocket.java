import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("d")
   Thread field2250;
   @ObfuscatedName("z")
   OutputStream field2247;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1257422465
   )
   int field2248;
   @ObfuscatedName("r")
   byte[] field2249;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1808972607
   )
   int field2252;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1607402475
   )
   int field2251;
   @ObfuscatedName("k")
   IOException field2246;
   @ObfuscatedName("s")
   boolean field2253;

   GameSocket(OutputStream var1, int var2) {
      this.field2252 = 0;
      this.field2251 = 0;
      this.field2247 = var1;
      this.field2248 = var2 + 1;
      this.field2249 = new byte[this.field2248];
      this.field2250 = new Thread(this);
      this.field2250.setDaemon(true);
      this.field2250.start();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1756865742"
   )
   boolean method3421() {
      if(this.field2253) {
         try {
            this.field2247.close();
            if(this.field2246 == null) {
               this.field2246 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2246 == null) {
               this.field2246 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "430922557"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2246 != null) {
               throw new IOException(this.field2246.toString());
            } else {
               int var5;
               if(this.field2252 <= this.field2251) {
                  var5 = this.field2248 - this.field2251 + this.field2252 - 1;
               } else {
                  var5 = this.field2252 - this.field2251 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2251 <= this.field2248) {
                     System.arraycopy(var1, var2, this.field2249, this.field2251, var3);
                  } else {
                     int var6 = this.field2248 - this.field2251;
                     System.arraycopy(var1, var2, this.field2249, this.field2251, var6);
                     System.arraycopy(var1, var6 + var2, this.field2249, 0, var3 - var6);
                  }

                  this.field2251 = (var3 + this.field2251) % this.field2248;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-32348"
   )
   void method3423() {
      synchronized(this) {
         this.field2253 = true;
         this.notifyAll();
      }

      try {
         this.field2250.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2246 != null) {
                  return;
               }

               if(this.field2252 <= this.field2251) {
                  var1 = this.field2251 - this.field2252;
               } else {
                  var1 = this.field2248 - this.field2252 + this.field2251;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2247.flush();
               } catch (IOException var11) {
                  this.field2246 = var11;
                  return;
               }

               if(this.method3421()) {
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
            if(var1 + this.field2252 <= this.field2248) {
               this.field2247.write(this.field2249, this.field2252, var1);
            } else {
               int var7 = this.field2248 - this.field2252;
               this.field2247.write(this.field2249, this.field2252, var7);
               this.field2247.write(this.field2249, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2246 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2252 = (var1 + this.field2252) % this.field2248;
         }
      } while(!this.method3421());

   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2032579996"
   )
   static final void method3420(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1099 - Client.field871) * var5 / 100 + Client.field871;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1104) {
         var15 = Client.field1104;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field860) {
            var6 = Client.field860;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field992) {
         var15 = Client.field992;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field893) {
            var6 = Client.field893;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1101 - Client.field1100) * var5 / 100 + Client.field1100;
      Client.scale = var3 * var8 * var6 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.buildVisibilityMaps(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }
}
