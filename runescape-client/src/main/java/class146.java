import java.awt.Font;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public final class class146 implements Runnable {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1559039111
   )
   int field2225 = 0;
   @ObfuscatedName("l")
   OutputStream field2226;
   @ObfuscatedName("c")
   Socket field2227;
   @ObfuscatedName("h")
   boolean field2228 = false;
   @ObfuscatedName("e")
   InputStream field2229;
   @ObfuscatedName("a")
   class149 field2230;
   @ObfuscatedName("b")
   byte[] field2231;
   @ObfuscatedName("r")
   class139 field2232;
   @ObfuscatedName("cg")
   static class227 field2233;
   @ObfuscatedName("p")
   boolean field2234 = false;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1115423245
   )
   int field2235 = 0;
   @ObfuscatedName("qs")
   protected static Font field2236;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = 866320245
   )
   static int field2237;

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2225 == this.field2235) {
                     if(this.field2228) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2225;
                  if(this.field2235 >= this.field2225) {
                     var1 = this.field2235 - this.field2225;
                  } else {
                     var1 = 5000 - this.field2225;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2226.write(this.field2231, var2, var1);
               } catch (IOException var9) {
                  this.field2234 = true;
               }

               this.field2225 = (this.field2225 + var1) % 5000;

               try {
                  if(this.field2225 == this.field2235) {
                     this.field2226.flush();
                  }
               } catch (IOException var8) {
                  this.field2234 = true;
               }
               continue;
            }

            try {
               if(this.field2229 != null) {
                  this.field2229.close();
               }

               if(null != this.field2226) {
                  this.field2226.close();
               }

               if(null != this.field2227) {
                  this.field2227.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2231 = null;
            break;
         }
      } catch (Exception var12) {
         class46.method1008((String)null, var12);
      }

   }

   protected void finalize() {
      this.method3088();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method3080() throws IOException {
      return this.field2228?0:this.field2229.read();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2002354755"
   )
   public int method3081() throws IOException {
      return this.field2228?0:this.field2229.available();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-336893789"
   )
   public void method3082(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2228) {
         while(var3 > 0) {
            int var4 = this.field2229.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1329204043"
   )
   public void method3083(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2228) {
         if(this.field2234) {
            this.field2234 = false;
            throw new IOException();
         } else {
            if(this.field2231 == null) {
               this.field2231 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2231[this.field2235] = var1[var5 + var2];
                  this.field2235 = (this.field2235 + 1) % 5000;
                  if(this.field2235 == (this.field2225 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field2230) {
                  this.field2230 = this.field2232.method3005(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   public class146(Socket var1, class139 var2) throws IOException {
      this.field2232 = var2;
      this.field2227 = var1;
      this.field2227.setSoTimeout(30000);
      this.field2227.setTcpNoDelay(true);
      this.field2227.setReceiveBufferSize(16384);
      this.field2227.setSendBufferSize(16384);
      this.field2229 = this.field2227.getInputStream();
      this.field2226 = this.field2227.getOutputStream();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2039324762"
   )
   public void method3088() {
      if(!this.field2228) {
         synchronized(this) {
            this.field2228 = true;
            this.notifyAll();
         }

         if(this.field2230 != null) {
            while(this.field2230.field2264 == 0) {
               class125.method2881(1L);
            }

            if(this.field2230.field2264 == 1) {
               try {
                  ((Thread)this.field2230.field2260).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2230 = null;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass42;",
      garbageValue = "109766750"
   )
   @Export("getObjectDefinition")
   public static class42 method3102(int var0) {
      class42 var1 = (class42)class42.field961.method3834((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class229.field3258.method3340(6, var0);
         var1 = new class42();
         var1.field974 = var0;
         if(var2 != null) {
            var1.method839(new class122(var2));
         }

         var1.method866();
         if(var1.field990) {
            var1.field976 = 0;
            var1.field977 = false;
         }

         class42.field961.method3836(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   static String method3106(int var0) {
      return client.field441[var0].length() > 0?client.field440[var0] + " " + client.field441[var0]:client.field440[var0];
   }
}
