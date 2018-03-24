import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class163 implements Runnable {
   @ObfuscatedName("t")
   Thread field2148;
   @ObfuscatedName("q")
   InputStream field2145;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1320275103
   )
   int field2144;
   @ObfuscatedName("a")
   byte[] field2147;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -778470853
   )
   int field2149;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 917854409
   )
   int field2150;
   @ObfuscatedName("e")
   IOException field2146;

   class163(InputStream var1, int var2) {
      this.field2149 = 0;
      this.field2150 = 0;
      this.field2145 = var1;
      this.field2144 = var2 + 1;
      this.field2147 = new byte[this.field2144];
      this.field2148 = new Thread(this);
      this.field2148.setDaemon(true);
      this.field2148.start();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-611377705"
   )
   boolean method3190(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2144) {
         synchronized(this) {
            int var3;
            if(this.field2149 <= this.field2150) {
               var3 = this.field2150 - this.field2149;
            } else {
               var3 = this.field2144 - this.field2149 + this.field2150;
            }

            if(var3 < var1) {
               if(this.field2146 != null) {
                  throw new IOException(this.field2146.toString());
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "970797743"
   )
   int method3191() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2149 <= this.field2150) {
            var2 = this.field2150 - this.field2149;
         } else {
            var2 = this.field2144 - this.field2149 + this.field2150;
         }

         if(var2 <= 0 && this.field2146 != null) {
            throw new IOException(this.field2146.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "30"
   )
   int method3192() throws IOException {
      synchronized(this) {
         if(this.field2150 == this.field2149) {
            if(this.field2146 != null) {
               throw new IOException(this.field2146.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2147[this.field2149] & 255;
            this.field2149 = (this.field2149 + 1) % this.field2144;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "94"
   )
   int method3193(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2149 <= this.field2150) {
               var5 = this.field2150 - this.field2149;
            } else {
               var5 = this.field2144 - this.field2149 + this.field2150;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2146 != null) {
               throw new IOException(this.field2146.toString());
            } else {
               if(var3 + this.field2149 <= this.field2144) {
                  System.arraycopy(this.field2147, this.field2149, var1, var2, var3);
               } else {
                  int var6 = this.field2144 - this.field2149;
                  System.arraycopy(this.field2147, this.field2149, var1, var2, var6);
                  System.arraycopy(this.field2147, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2149 = (var3 + this.field2149) % this.field2144;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-329500182"
   )
   void method3198() {
      synchronized(this) {
         if(this.field2146 == null) {
            this.field2146 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2148.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2146 != null) {
                  return;
               }

               if(this.field2149 == 0) {
                  var1 = this.field2144 - this.field2150 - 1;
               } else if(this.field2149 <= this.field2150) {
                  var1 = this.field2144 - this.field2150;
               } else {
                  var1 = this.field2149 - this.field2150 - 1;
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
            var7 = this.field2145.read(this.field2147, this.field2150, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2146 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2150 = (var7 + this.field2150) % this.field2144;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lek;IIII)V",
      garbageValue = "64035249"
   )
   public static final void method3207(Model var0, int var1, int var2, int var3) {
      if(class71.boundingBox3DContainsMouse(var0, var1, var2, var3)) {
         class255.method4545(var0, var1, var2, var3, -65281);
      } else if(class7.boundingBox3DDrawMode == BoundingBox3DDrawMode.ALWAYS) {
         class255.method4545(var0, var1, var2, var3, -16776961);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "-2078182693"
   )
   public static boolean method3210(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label84: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == '-') {
                  var2 = true;
                  break label84;
               }

               if(var7 == '+') {
                  break label84;
               }
            }

            int var9;
            if(var7 >= '0' && var7 <= '9') {
               var9 = var7 - '0';
            } else if(var7 >= 'A' && var7 <= 'Z') {
               var9 = var7 - '7';
            } else {
               if(var7 < 'a' || var7 > 'z') {
                  var1 = false;
                  break;
               }

               var9 = var7 - 'W';
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var4 * 10 + var9;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgz;IB)Z",
      garbageValue = "3"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class93.field1404[++class93.field1395 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field837 = var1;
            if(class93.field1405[var1] != null) {
               var6.decodeApperance(class93.field1405[var1]);
            }

            var6.orientation = class93.Players_orientations[var1];
            var6.interacting = class93.Players_targetIndices[var1];
            var7 = class93.Players_regions[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class93.field1393[var1];
            var6.field836 = (byte)var8;
            var6.method1214((var9 << 13) + var3 - class38.baseX, (var10 << 13) + var4 - PlayerComposition.baseY);
            var6.field820 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class93.Players_regions[var1];
         class93.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class93.Players_regions[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class93.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class93.Players_regions[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class93.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1901223735"
   )
   static void method3212(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }
}
