import java.awt.Image;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public final class class110 implements Runnable {
   @ObfuscatedName("j")
   class102 field1742;
   @ObfuscatedName("r")
   boolean field1743 = false;
   @ObfuscatedName("o")
   Socket field1744;
   @ObfuscatedName("k")
   InputStream field1745;
   @ObfuscatedName("w")
   class103 field1746;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1632902633
   )
   int field1747 = 0;
   @ObfuscatedName("q")
   byte[] field1748;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -131261183
   )
   int field1749 = 0;
   @ObfuscatedName("y")
   OutputStream field1750;
   @ObfuscatedName("c")
   boolean field1751 = false;
   @ObfuscatedName("qa")
   static Image field1753;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "111"
   )
   public int method2049() throws IOException {
      return this.field1743?0:this.field1745.read();
   }

   protected void finalize() {
      this.method2064();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "14"
   )
   public int method2052() throws IOException {
      return this.field1743?0:this.field1745.available();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIS)V",
      garbageValue = "180"
   )
   public void method2053(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1743) {
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "125"
   )
   public void method2054(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1743) {
         if(this.field1751) {
            this.field1751 = false;
            throw new IOException();
         } else {
            if(this.field1748 == null) {
               this.field1748 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1748[this.field1749] = var1[var2 + var5];
                  this.field1749 = (1 + this.field1749) % 5000;
                  if(this.field1749 == (4900 + this.field1747) % 5000) {
                     throw new IOException();
                  }
               }

               if(this.field1742 == null) {
                  this.field1742 = this.field1746.method1945(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "70"
   )
   public void method2064() {
      if(!this.field1743) {
         synchronized(this) {
            this.field1743 = true;
            this.notifyAll();
         }

         if(null != this.field1742) {
            while(this.field1742.field1667 == 0) {
               class195.method3560(1L);
            }

            if(this.field1742.field1667 == 1) {
               try {
                  ((Thread)this.field1742.field1675).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1742 = null;
      }
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field1749 == this.field1747) {
                     if(this.field1743) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1747;
                  if(this.field1749 >= this.field1747) {
                     var1 = this.field1749 - this.field1747;
                  } else {
                     var1 = 5000 - this.field1747;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1750.write(this.field1748, var2, var1);
               } catch (IOException var9) {
                  this.field1751 = true;
               }

               this.field1747 = (this.field1747 + var1) % 5000;

               try {
                  if(this.field1749 == this.field1747) {
                     this.field1750.flush();
                  }
               } catch (IOException var8) {
                  this.field1751 = true;
               }
               continue;
            }

            try {
               if(this.field1745 != null) {
                  this.field1745.close();
               }

               if(this.field1750 != null) {
                  this.field1750.close();
               }

               if(null != this.field1744) {
                  this.field1744.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1748 = null;
            break;
         }
      } catch (Exception var12) {
         class32.method709((String)null, var12);
      }

   }

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1746 = var2;
      this.field1744 = var1;
      this.field1744.setSoTimeout(30000);
      this.field1744.setTcpNoDelay(true);
      this.field1744.setReceiveBufferSize(16384);
      this.field1744.setSendBufferSize(16384);
      this.field1745 = this.field1744.getInputStream();
      this.field1750 = this.field1744.getOutputStream();
   }
}
