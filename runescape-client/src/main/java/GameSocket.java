import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("GameSocket")
public class GameSocket implements Runnable {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   public static Font field2036;
   @ObfuscatedName("w")
   Thread field2032;
   @ObfuscatedName("m")
   OutputStream field2031;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -637420263
   )
   int field2035;
   @ObfuscatedName("b")
   byte[] field2033;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1035658403
   )
   int field2039;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 973030665
   )
   int field2030;
   @ObfuscatedName("h")
   IOException field2034;
   @ObfuscatedName("x")
   boolean field2037;

   GameSocket(OutputStream var1, int var2) {
      this.field2039 = 0;
      this.field2030 = 0;
      this.field2031 = var1;
      this.field2035 = var2 + 1;
      this.field2033 = new byte[this.field2035];
      this.field2032 = new Thread(this);
      this.field2032.setDaemon(true);
      this.field2032.start();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2045893110"
   )
   boolean method3399() {
      if(this.field2037) {
         try {
            this.field2031.close();
            if(this.field2034 == null) {
               this.field2034 = new IOException("");
            }
         } catch (IOException var2) {
            if(this.field2034 == null) {
               this.field2034 = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-204100853"
   )
   @Export("read")
   void read(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if(this.field2034 != null) {
               throw new IOException(this.field2034.toString());
            } else {
               int var5;
               if(this.field2039 <= this.field2030) {
                  var5 = this.field2035 - this.field2030 + this.field2039 - 1;
               } else {
                  var5 = this.field2039 - this.field2030 - 1;
               }

               if(var5 < var3) {
                  throw new IOException("");
               } else {
                  if(var3 + this.field2030 <= this.field2035) {
                     System.arraycopy(var1, var2, this.field2033, this.field2030, var3);
                  } else {
                     int var6 = this.field2035 - this.field2030;
                     System.arraycopy(var1, var2, this.field2033, this.field2030, var6);
                     System.arraycopy(var1, var6 + var2, this.field2033, 0, var3 - var6);
                  }

                  this.field2030 = (var3 + this.field2030) % this.field2035;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-81"
   )
   void method3402() {
      synchronized(this) {
         this.field2037 = true;
         this.notifyAll();
      }

      try {
         this.field2032.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2034 != null) {
                  return;
               }

               if(this.field2039 <= this.field2030) {
                  var1 = this.field2030 - this.field2039;
               } else {
                  var1 = this.field2035 - this.field2039 + this.field2030;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.field2031.flush();
               } catch (IOException var11) {
                  this.field2034 = var11;
                  return;
               }

               if(this.method3399()) {
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
            if(var1 + this.field2039 <= this.field2035) {
               this.field2031.write(this.field2033, this.field2039, var1);
            } else {
               int var7 = this.field2035 - this.field2039;
               this.field2031.write(this.field2033, this.field2039, var7);
               this.field2031.write(this.field2033, 0, var1 - var7);
            }
         } catch (IOException var10) {
            IOException var2 = var10;
            synchronized(this) {
               this.field2034 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field2039 = (var1 + this.field2039) % this.field2035;
         }
      } while(!this.method3399());

   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1044304180"
   )
   static final int method3411() {
      if(ScriptState.preferences.hideRoofs) {
         return class192.plane;
      } else {
         int var0 = 3;
         if(class146.cameraPitch < 310) {
            int var1;
            int var2;
            if(Client.field678 == 1) {
               var1 = Signlink.field1979 >> 7;
               var2 = ItemContainer.field481 >> 7;
            } else {
               var1 = MilliTimer.localPlayer.x >> 7;
               var2 = MilliTimer.localPlayer.y >> 7;
            }

            int var3 = WorldMapType3.cameraX >> 7;
            int var4 = class13.cameraY >> 7;
            if(var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
               return class192.plane;
            }

            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class192.plane;
            }

            if((class50.tileSettings[class192.plane][var3][var4] & 4) != 0) {
               var0 = class192.plane;
            }

            int var5;
            if(var1 > var3) {
               var5 = var1 - var3;
            } else {
               var5 = var3 - var1;
            }

            int var6;
            if(var2 > var4) {
               var6 = var2 - var4;
            } else {
               var6 = var4 - var2;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = 32768;

               while(var3 != var1) {
                  if(var3 < var1) {
                     ++var3;
                  } else if(var3 > var1) {
                     --var3;
                  }

                  if((class50.tileSettings[class192.plane][var3][var4] & 4) != 0) {
                     var0 = class192.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var4 < var2) {
                        ++var4;
                     } else if(var4 > var2) {
                        --var4;
                     }

                     if((class50.tileSettings[class192.plane][var3][var4] & 4) != 0) {
                        var0 = class192.plane;
                     }
                  }
               }
            } else if(var6 > 0) {
               var7 = var5 * 65536 / var6;
               var8 = 32768;

               while(var4 != var2) {
                  if(var4 < var2) {
                     ++var4;
                  } else if(var4 > var2) {
                     --var4;
                  }

                  if((class50.tileSettings[class192.plane][var3][var4] & 4) != 0) {
                     var0 = class192.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var3 < var1) {
                        ++var3;
                     } else if(var3 > var1) {
                        --var3;
                     }

                     if((class50.tileSettings[class192.plane][var3][var4] & 4) != 0) {
                        var0 = class192.plane;
                     }
                  }
               }
            }
         }

         if(MilliTimer.localPlayer.x >= 0 && MilliTimer.localPlayer.y >= 0 && MilliTimer.localPlayer.x < 13312 && MilliTimer.localPlayer.y < 13312) {
            if((class50.tileSettings[class192.plane][MilliTimer.localPlayer.x >> 7][MilliTimer.localPlayer.y >> 7] & 4) != 0) {
               var0 = class192.plane;
            }

            return var0;
         } else {
            return class192.plane;
         }
      }
   }
}
