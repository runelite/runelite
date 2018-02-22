import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("b")
   Thread field2217;
   @ObfuscatedName("q")
   OutputStream field2219;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -80773807
   )
   int field2216;
   @ObfuscatedName("p")
   byte[] field2218;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -771442901
   )
   int field2220;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1719125147
   )
   int field2221;
   @ObfuscatedName("l")
   IOException field2222;
   @ObfuscatedName("y")
   boolean field2223;

   GameSocket(OutputStream var1, int var2) {
      this.field2220 = 0;
      this.field2221 = 0;
      this.field2219 = var1;
      this.field2216 = var2 + 1;
      this.field2218 = new byte[this.field2216];
      this.field2217 = new Thread(this);
      this.field2217.setDaemon(true);
      this.field2217.start();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "3228"
   )
   boolean method3360() {
      if(this.field2223) {
         try {
            this.field2219.close();
            if(this.field2222 == null) {
               this.field2222 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2222 == null) {
               this.field2222 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-455197351"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2222 != null) {
               throw new IOException(this.field2222.toString());
            } else {
               int var5;
               if(this.field2220 <= this.field2221) {
                  var5 = this.field2216 - this.field2221 + this.field2220 - 1;
               } else {
                  var5 = this.field2220 - this.field2221 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2221 <= this.field2216) {
                     System.arraycopy(var1, var2, this.field2218, this.field2221, var3);
                  } else {
                     int var6 = this.field2216 - this.field2221;
                     System.arraycopy(var1, var2, this.field2218, this.field2221, var6);
                     System.arraycopy(var1, var6 + var2, this.field2218, 0, var3 - var6);
                  }

                  this.field2221 = (var3 + this.field2221) % this.field2216;
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
      signature = "(S)V",
      garbageValue = "6203"
   )
   void method3363() {
      synchronized(this) {
         this.field2223 = true;
         this.notifyAll();
      }

      try {
         this.field2217.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2222 != null) {
                  return;
               }

               if(this.field2220 <= this.field2221) {
                  var1 = this.field2221 - this.field2220;
               } else {
                  var1 = this.field2216 - this.field2220 + this.field2221;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2219.flush();
               } catch (IOException var11) {
                  this.field2222 = var11;
                  return;
               }

               if(this.method3360()) {
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
            if(var1 + this.field2220 <= this.field2216) {
               this.field2219.write(this.field2218, this.field2220, var1);
            } else {
               int var7 = this.field2216 - this.field2220;
               this.field2219.write(this.field2218, this.field2220, var7);
               this.field2219.write(this.field2218, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2222 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2220 = (var1 + this.field2220) % this.field2216;
         }
      } while(!this.method3360());

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;Lie;I)Z",
      garbageValue = "1890494178"
   )
   public static boolean method3377(IndexDataBase var0, IndexDataBase var1) {
      Area.field3394 = var1;
      if(!var0.method4569()) {
         return false;
      } else {
         Area.field3408 = var0.fileCount(35);
         class330.mapAreaType = new Area[Area.field3408];

         for(int var2 = 0; var2 < Area.field3408; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               class330.mapAreaType[var2] = new Area(var2);
               class330.mapAreaType[var2].method4750(new Buffer(var3));
               class330.mapAreaType[var2].method4738();
            }
         }

         return true;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lie;Lie;III)Lkt;",
      garbageValue = "1883500573"
   )
   public static Font method3379(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!class258.method4705(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, TotalQuantityComparator.field281, FileSystem.offsetsY, BaseVarType.field28, GroundObject.field1751, class323.field3912, class323.spritePixels);
            class152.method3133();
            var4 = var6;
         }

         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "743373735"
   )
   public static void method3378() {
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
   }
}
