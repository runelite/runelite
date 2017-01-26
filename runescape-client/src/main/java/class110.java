import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public final class class110 implements Runnable {
   @ObfuscatedName("p")
   InputStream field1745;
   @ObfuscatedName("g")
   OutputStream field1746;
   @ObfuscatedName("d")
   class103 field1747;
   @ObfuscatedName("q")
   boolean field1748 = false;
   @ObfuscatedName("k")
   class102 field1749;
   @ObfuscatedName("x")
   Socket field1750;
   @ObfuscatedName("a")
   boolean field1751 = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -216976889
   )
   int field1752 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1268880829
   )
   int field1753 = 0;
   @ObfuscatedName("j")
   byte[] field1754;

   protected void finalize() {
      this.method2059();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field1753 == this.field1752) {
                     if(this.field1748) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1752;
                  if(this.field1753 >= this.field1752) {
                     var1 = this.field1753 - this.field1752;
                  } else {
                     var1 = 5000 - this.field1752;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1746.write(this.field1754, var2, var1);
               } catch (IOException var9) {
                  this.field1751 = true;
               }

               this.field1752 = (var1 + this.field1752) % 5000;

               try {
                  if(this.field1753 == this.field1752) {
                     this.field1746.flush();
                  }
               } catch (IOException var8) {
                  this.field1751 = true;
               }
               continue;
            }

            try {
               if(null != this.field1745) {
                  this.field1745.close();
               }

               if(this.field1746 != null) {
                  this.field1746.close();
               }

               if(null != this.field1750) {
                  this.field1750.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1754 = null;
            break;
         }
      } catch (Exception var12) {
         class65.method1151((String)null, var12);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "22"
   )
   public int method2054() throws IOException {
      return this.field1748?0:this.field1745.available();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1213764990"
   )
   public void method2055(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1748) {
         while(var3 > 0) {
            int var4 = this.field1745.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "573552363"
   )
   static void method2056() {
      for(class31 var0 = (class31)class31.field711.method2412(); var0 != null; var0 = (class31)class31.field711.method2426()) {
         if(var0.field708 != null) {
            var0.method662();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-252217424"
   )
   public void method2059() {
      if(!this.field1748) {
         synchronized(this) {
            this.field1748 = true;
            this.notifyAll();
         }

         if(null != this.field1749) {
            while(this.field1749.field1667 == 0) {
               class104.method1988(1L);
            }

            if(this.field1749.field1667 == 1) {
               try {
                  ((Thread)this.field1749.field1664).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1749 = null;
      }
   }

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1747 = var2;
      this.field1750 = var1;
      this.field1750.setSoTimeout(30000);
      this.field1750.setTcpNoDelay(true);
      this.field1750.setReceiveBufferSize(16384);
      this.field1750.setSendBufferSize(16384);
      this.field1745 = this.field1750.getInputStream();
      this.field1746 = this.field1750.getOutputStream();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-49"
   )
   public int method2065() throws IOException {
      return this.field1748?0:this.field1745.read();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-144343737"
   )
   public static void method2072() {
      KitDefinition.field2815.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "48"
   )
   public void method2073(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1748) {
         if(this.field1751) {
            this.field1751 = false;
            throw new IOException();
         } else {
            if(null == this.field1754) {
               this.field1754 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1754[this.field1753] = var1[var2 + var5];
                  this.field1753 = (1 + this.field1753) % 5000;
                  if(this.field1753 == (this.field1752 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field1749) {
                  this.field1749 = this.field1747.method1968(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }
}
