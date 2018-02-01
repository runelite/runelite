import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public final class class163 extends class159 implements Runnable {
   @ObfuscatedName("p")
   InputStream field2141;
   @ObfuscatedName("i")
   OutputStream field2142;
   @ObfuscatedName("w")
   Socket field2145;
   @ObfuscatedName("s")
   boolean field2144;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   Signlink field2143;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   Task field2146;
   @ObfuscatedName("t")
   byte[] field2147;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1995410123
   )
   int field2148;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -5462145
   )
   int field2149;
   @ObfuscatedName("h")
   boolean field2150;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -443497321
   )
   final int field2151;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1715097059
   )
   final int field2152;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfw;I)V"
   )
   public class163(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2144 = false;
      this.field2148 = 0;
      this.field2149 = 0;
      this.field2150 = false;
      this.field2143 = var2;
      this.field2145 = var1;
      this.field2151 = var3;
      this.field2152 = var3 - 100;
      this.field2145.setSoTimeout(30000);
      this.field2145.setTcpNoDelay(true);
      this.field2145.setReceiveBufferSize(65536);
      this.field2145.setSendBufferSize(65536);
      this.field2141 = this.field2145.getInputStream();
      this.field2142 = this.field2145.getOutputStream();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1280125978"
   )
   public boolean vmethod3220(int var1) throws IOException {
      if(this.field2144) {
         return false;
      } else {
         try {
            return this.field2141.available() >= var1;
         } catch (IOException var3) {
            throw new IOException("Error reading from clientstream", var3);
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-120"
   )
   public int vmethod3188() throws IOException {
      return this.field2144?0:this.field2141.available();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-693383529"
   )
   public int vmethod3215() throws IOException {
      return this.field2144?0:this.field2141.read();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-719042495"
   )
   public int vmethod3190(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2144) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2141.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "44"
   )
   public void vmethod3192(byte[] var1, int var2, int var3) throws IOException {
      this.method3191(var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-953149698"
   )
   public void vmethod3186() {
      if(!this.field2144) {
         synchronized(this) {
            this.field2144 = true;
            this.notifyAll();
         }

         if(this.field2146 != null) {
            while(this.field2146.status == 0) {
               class1.method3(1L);
            }

            if(this.field2146.status == 1) {
               try {
                  ((Thread)this.field2146.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2146 = null;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-739958851"
   )
   void method3191(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2144) {
         if(this.field2150) {
            this.field2150 = false;
            throw new IOException();
         } else {
            if(this.field2147 == null) {
               this.field2147 = new byte[this.field2151];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2147[this.field2149] = var1[var5 + var2];
                  this.field2149 = (this.field2149 + 1) % this.field2151;
                  if((this.field2152 + this.field2148) % this.field2151 == this.field2149) {
                     throw new IOException();
                  }
               }

               if(this.field2146 == null) {
                  this.field2146 = this.field2143.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   protected void finalize() {
      this.vmethod3186();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2149 == this.field2148) {
                     if(this.field2144) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2148;
                  if(this.field2149 >= this.field2148) {
                     var1 = this.field2149 - this.field2148;
                  } else {
                     var1 = this.field2151 - this.field2148;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2142.write(this.field2147, var2, var1);
               } catch (IOException var9) {
                  this.field2150 = true;
               }

               this.field2148 = (var1 + this.field2148) % this.field2151;

               try {
                  if(this.field2149 == this.field2148) {
                     this.field2142.flush();
                  }
               } catch (IOException var8) {
                  this.field2150 = true;
               }
               continue;
            }

            try {
               if(this.field2141 != null) {
                  this.field2141.close();
               }

               if(this.field2142 != null) {
                  this.field2142.close();
               }

               if(this.field2145 != null) {
                  this.field2145.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2147 = null;
            break;
         }
      } catch (Exception var12) {
         class89.method1900((String)null, var12);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljg;",
      garbageValue = "-651880436"
   )
   public static class265 method3219(int var0) {
      class265 var1 = (class265)class265.field3471.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class265.field3492.getConfigData(32, var0);
         var1 = new class265();
         if(var2 != null) {
            var1.method4740(new Buffer(var2));
         }

         class265.field3471.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lik;IIIZI)V",
      garbageValue = "-227498671"
   )
   public static void method3202(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class214.field2596 = 1;
      Item.field1369 = var0;
      GZipDecompressor.field2420 = var1;
      class186.field2505 = var2;
      class214.field2597 = var3;
      class214.field2594 = var4;
      class85.field1268 = 10000;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1888385572"
   )
   static synchronized void method3221(byte[] var0) {
      if(var0.length == 100 && class185.field2494 < 1000) {
         class185.field2493[++class185.field2494 - 1] = var0;
      } else if(var0.length == 5000 && class185.field2498 < 250) {
         class185.field2497[++class185.field2498 - 1] = var0;
      } else if(var0.length == 30000 && class185.field2495 < 50) {
         class185.field2499[++class185.field2495 - 1] = var0;
      } else {
         if(class219.field2675 != null) {
            for(int var1 = 0; var1 < class185.field2496.length; ++var1) {
               if(var0.length == class185.field2496[var1] && class185.field2500[var1] < class219.field2675[var1].length) {
                  class219.field2675[var1][class185.field2500[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-917596457"
   )
   public static void method3218() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3307 != 0) {
            IndexStoreActionHandler.field3307 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "626142310"
   )
   static void method3185(boolean var0) {
      class89.loginMessage1 = "";
      class89.loginMessage2 = "Enter your username/email & password.";
      class89.loginMessage3 = "";
      class89.loginIndex = 2;
      if(var0) {
         class89.password = "";
      }

      class63.method1055();
      class41.method571();
   }
}
