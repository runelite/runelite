import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public final class class146 implements Runnable {
   @ObfuscatedName("s")
   InputStream field2216;
   @ObfuscatedName("z")
   OutputStream field2217;
   @ObfuscatedName("t")
   Socket field2218;
   @ObfuscatedName("y")
   boolean field2219 = false;
   @ObfuscatedName("p")
   class139 field2220;
   @ObfuscatedName("i")
   static String field2221;
   @ObfuscatedName("m")
   byte[] field2222;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1101468921
   )
   int field2223 = 0;
   @ObfuscatedName("g")
   class149 field2224;
   @ObfuscatedName("h")
   boolean field2225 = false;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -594542753
   )
   int field2226 = 0;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1695377645"
   )
   public void method2986() {
      if(!this.field2219) {
         synchronized(this) {
            this.field2219 = true;
            this.notifyAll();
         }

         if(null != this.field2224) {
            while(this.field2224.field2257 == 0) {
               class16.method185(1L);
            }

            if(this.field2224.field2257 == 1) {
               try {
                  ((Thread)this.field2224.field2261).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2224 = null;
      }
   }

   protected void finalize() {
      this.method2986();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-58"
   )
   public void method2987(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2219) {
         if(this.field2225) {
            this.field2225 = false;
            throw new IOException();
         } else {
            if(this.field2222 == null) {
               this.field2222 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2222[this.field2226] = var1[var5 + var2];
                  this.field2226 = (this.field2226 + 1) % 5000;
                  if((this.field2223 + 4900) % 5000 == this.field2226) {
                     throw new IOException();
                  }
               }

               if(this.field2224 == null) {
                  this.field2224 = this.field2220.method2878(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-89413065"
   )
   public int method2988() throws IOException {
      return this.field2219?0:this.field2216.available();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2223 == this.field2226) {
                     if(this.field2219) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2223;
                  if(this.field2226 >= this.field2223) {
                     var1 = this.field2226 - this.field2223;
                  } else {
                     var1 = 5000 - this.field2223;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2217.write(this.field2222, var2, var1);
               } catch (IOException var9) {
                  this.field2225 = true;
               }

               this.field2223 = (this.field2223 + var1) % 5000;

               try {
                  if(this.field2223 == this.field2226) {
                     this.field2217.flush();
                  }
               } catch (IOException var8) {
                  this.field2225 = true;
               }
               continue;
            }

            try {
               if(null != this.field2216) {
                  this.field2216.close();
               }

               if(null != this.field2217) {
                  this.field2217.close();
               }

               if(this.field2218 != null) {
                  this.field2218.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2222 = null;
            break;
         }
      } catch (Exception var12) {
         class144.method2970((String)null, var12);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "626481079"
   )
   public int method2991() throws IOException {
      return this.field2219?0:this.field2216.read();
   }

   public class146(Socket var1, class139 var2) throws IOException {
      this.field2220 = var2;
      this.field2218 = var1;
      this.field2218.setSoTimeout(30000);
      this.field2218.setTcpNoDelay(true);
      this.field2218.setReceiveBufferSize(16384);
      this.field2218.setSendBufferSize(16384);
      this.field2216 = this.field2218.getInputStream();
      this.field2217 = this.field2218.getOutputStream();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1268666411"
   )
   public void method2996(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2219) {
         while(var3 > 0) {
            int var4 = this.field2216.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1187171129"
   )
   static final void method3001() {
      for(Projectile var0 = (Projectile)Client.projectiles.method3808(); var0 != null; var0 = (Projectile)Client.projectiles.method3810()) {
         if(class59.plane == var0.floor && Client.gameCycle <= var0.field94) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(null != var1 && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method90(var1.x, var1.y, class79.method1656(var1.x, var1.y, var0.floor) - var0.field92, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(Client.localInteractingIndex == var2) {
                     var3 = TextureProvider.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(null != var3 && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method90(var3.x, var3.y, class79.method1656(var3.x, var3.y, var0.floor) - var0.field92, Client.gameCycle);
                  }
               }

               var0.method89(Client.field297);
               class114.region.method1926(class59.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field107, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
