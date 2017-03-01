import java.awt.Canvas;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public final class class110 implements Runnable {
   @ObfuscatedName("j")
   byte[] field1742;
   @ObfuscatedName("i")
   boolean field1743 = false;
   @ObfuscatedName("qa")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("n")
   OutputStream field1745;
   @ObfuscatedName("y")
   class103 field1746;
   @ObfuscatedName("p")
   class102 field1747;
   @ObfuscatedName("x")
   InputStream field1748;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1489070287
   )
   int field1749 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1559861447
   )
   int field1750 = 0;
   @ObfuscatedName("g")
   Socket field1751;
   @ObfuscatedName("v")
   boolean field1754 = false;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "16"
   )
   public int method2138() throws IOException {
      return this.field1754?0:this.field1748.available();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-364979196"
   )
   public void method2139() {
      if(!this.field1754) {
         synchronized(this) {
            this.field1754 = true;
            this.notifyAll();
         }

         if(null != this.field1747) {
            while(this.field1747.field1670 == 0) {
               class47.method970(1L);
            }

            if(this.field1747.field1670 == 1) {
               try {
                  ((Thread)this.field1747.field1674).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1747 = null;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2101829760"
   )
   public int method2141() throws IOException {
      return this.field1754?0:this.field1748.read();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2132235372"
   )
   public void method2143(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1754) {
         while(var3 > 0) {
            int var4 = this.field1748.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   protected void finalize() {
      this.method2139();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field1749 == this.field1750) {
                     if(this.field1754) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1749;
                  if(this.field1750 >= this.field1749) {
                     var1 = this.field1750 - this.field1749;
                  } else {
                     var1 = 5000 - this.field1749;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1745.write(this.field1742, var2, var1);
               } catch (IOException var9) {
                  this.field1743 = true;
               }

               this.field1749 = (this.field1749 + var1) % 5000;

               try {
                  if(this.field1750 == this.field1749) {
                     this.field1745.flush();
                  }
               } catch (IOException var8) {
                  this.field1743 = true;
               }
               continue;
            }

            try {
               if(null != this.field1748) {
                  this.field1748.close();
               }

               if(null != this.field1745) {
                  this.field1745.close();
               }

               if(null != this.field1751) {
                  this.field1751.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1742 = null;
            break;
         }
      } catch (Exception var12) {
         class97.method2025((String)null, var12);
      }

   }

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1746 = var2;
      this.field1751 = var1;
      this.field1751.setSoTimeout(30000);
      this.field1751.setTcpNoDelay(true);
      this.field1751.setReceiveBufferSize(16384);
      this.field1751.setSendBufferSize(16384);
      this.field1748 = this.field1751.getInputStream();
      this.field1745 = this.field1751.getOutputStream();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-112493450"
   )
   public void method2148(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1754) {
         if(this.field1743) {
            this.field1743 = false;
            throw new IOException();
         } else {
            if(this.field1742 == null) {
               this.field1742 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1742[this.field1750] = var1[var5 + var2];
                  this.field1750 = (1 + this.field1750) % 5000;
                  if((this.field1749 + 4900) % 5000 == this.field1750) {
                     throw new IOException();
                  }
               }

               if(null == this.field1747) {
                  this.field1747 = this.field1746.method2067(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   public static void method2162() {
      try {
         if(class138.field1921 == 1) {
            int var0 = class138.field1919.method2696();
            if(var0 > 0 && class138.field1919.method2582()) {
               var0 -= class178.field2678;
               if(var0 < 0) {
                  var0 = 0;
               }

               class138.field1919.method2575(var0);
               return;
            }

            class138.field1919.method2672();
            class138.field1919.method2579();
            if(class138.field1924 != null) {
               class138.field1921 = 2;
            } else {
               class138.field1921 = 0;
            }

            DecorativeObject.field1614 = null;
            class30.field698 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class138.field1919.method2672();
         class138.field1921 = 0;
         DecorativeObject.field1614 = null;
         class30.field698 = null;
         class138.field1924 = null;
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1298420555"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[CollisionData.plane][var0][var1];
      if(var2 == null) {
         Friend.region.method1810(CollisionData.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2503(); var6 != null; var6 = (Item)var2.method2492()) {
            ItemComposition var7 = ChatLineBuffer.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(1 + var6.quantity);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            Friend.region.method1810(CollisionData.plane, var0, var1);
         } else {
            var2.method2500(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2503(); var6 != null; var6 = (Item)var2.method2492()) {
               if(var6.id != var5.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            Friend.region.method1808(CollisionData.plane, var0, var1, class25.method615(64 + var0 * 128, 64 + var1 * 128, CollisionData.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIS)I",
      garbageValue = "23968"
   )
   public static int method2164(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2087[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1661544198"
   )
   static int method2165(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         int var4 = class32.field726[class32.field735 + 1];
         if(!Client.field459) {
            Client.field372 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class32.field726[++class32.field735 - 1] = Client.field372;
         return 1;
      } else if(var0 == 5506) {
         class32.field726[++class32.field735 - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class32.field726[--class32.field735];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field378 = var3;
         return 1;
      } else if(var0 == 5531) {
         class32.field726[++class32.field735 - 1] = Client.field378;
         return 1;
      } else {
         return 2;
      }
   }
}
