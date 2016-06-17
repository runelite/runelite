import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public final class class143 implements Runnable {
   @ObfuscatedName("y")
   class146 field2159;
   @ObfuscatedName("g")
   OutputStream field2160;
   @ObfuscatedName("j")
   Socket field2161;
   @ObfuscatedName("d")
   boolean field2162 = false;
   @ObfuscatedName("x")
   class136 field2163;
   @ObfuscatedName("b")
   InputStream field2164;
   @ObfuscatedName("r")
   byte[] field2166;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 107708935
   )
   int field2167 = 0;
   @ObfuscatedName("u")
   boolean field2168 = false;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 745720803
   )
   protected static int field2169;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1098267027
   )
   int field2170 = 0;
   @ObfuscatedName("pe")
   static class221 field2172;

   protected void finalize() {
      this.method3025();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-74"
   )
   public int method3018() throws IOException {
      return this.field2162?0:this.field2164.available();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1250404651"
   )
   public void method3019(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2162) {
         while(var3 > 0) {
            int var4 = this.field2164.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "0"
   )
   public void method3020(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2162) {
         if(this.field2168) {
            this.field2168 = false;
            throw new IOException();
         } else {
            if(null == this.field2166) {
               this.field2166 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2166[this.field2167] = var1[var5 + var2];
                  this.field2167 = (this.field2167 + 1) % 5000;
                  if(this.field2167 == (4900 + this.field2170) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field2159) {
                  this.field2159 = this.field2163.method2917(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2167 == this.field2170) {
                     if(this.field2162) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2170;
                  if(this.field2167 >= this.field2170) {
                     var1 = this.field2167 - this.field2170;
                  } else {
                     var1 = 5000 - this.field2170;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2160.write(this.field2166, var2, var1);
               } catch (IOException var9) {
                  this.field2168 = true;
               }

               this.field2170 = (this.field2170 + var1) % 5000;

               try {
                  if(this.field2170 == this.field2167) {
                     this.field2160.flush();
                  }
               } catch (IOException var8) {
                  this.field2168 = true;
               }
               continue;
            }

            try {
               if(null != this.field2164) {
                  this.field2164.close();
               }

               if(null != this.field2160) {
                  this.field2160.close();
               }

               if(this.field2161 != null) {
                  this.field2161.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2166 = null;
            break;
         }
      } catch (Exception var12) {
         class7.method94((String)null, var12);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)Lclass78;",
      garbageValue = "-2146826988"
   )
   public static class78 method3022(class167 var0, int var1, int var2) {
      if(!class38.method766(var0, var1, var2)) {
         return null;
      } else {
         class78 var4 = new class78();
         var4.field1370 = class109.field1890;
         var4.field1372 = class76.field1351;
         var4.field1369 = class76.field1353[0];
         var4.field1373 = class131.field2048[0];
         var4.field1374 = class76.field1354[0];
         var4.field1371 = class28.field674[0];
         int var5 = var4.field1374 * var4.field1371;
         byte[] var6 = class76.field1355[0];
         var4.field1380 = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.field1380[var7] = class8.field135[var6[var7] & 255];
         }

         class7.method95();
         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-95899752"
   )
   public void method3025() {
      if(!this.field2162) {
         synchronized(this) {
            this.field2162 = true;
            this.notifyAll();
         }

         if(this.field2159 != null) {
            while(this.field2159.field2199 == 0) {
               class116.method2459(1L);
            }

            if(this.field2159.field2199 == 1) {
               try {
                  ((Thread)this.field2159.field2201).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2159 = null;
      }
   }

   public class143(Socket var1, class136 var2) throws IOException {
      this.field2163 = var2;
      this.field2161 = var1;
      this.field2161.setSoTimeout(30000);
      this.field2161.setTcpNoDelay(true);
      this.field2161.setReceiveBufferSize(16384);
      this.field2161.setSendBufferSize(16384);
      this.field2164 = this.field2161.getInputStream();
      this.field2160 = this.field2161.getOutputStream();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "855540005"
   )
   public int method3026() throws IOException {
      return this.field2162?0:this.field2164.read();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass167;II)Z",
      garbageValue = "-1197240254"
   )
   public static boolean method3041(class167 var0, int var1) {
      byte[] var2 = var0.method3271(var1);
      if(var2 == null) {
         return false;
      } else {
         class135.method2911(var2);
         return true;
      }
   }
}
