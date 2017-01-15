import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public final class class110 implements Runnable {
   @ObfuscatedName("a")
   boolean field1730 = false;
   @ObfuscatedName("i")
   Socket field1732;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 511727373
   )
   int field1733 = 0;
   @ObfuscatedName("c")
   class102 field1734;
   @ObfuscatedName("d")
   byte[] field1736;
   @ObfuscatedName("x")
   OutputStream field1737;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 863130375
   )
   int field1738 = 0;
   @ObfuscatedName("z")
   boolean field1739 = false;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -117871671
   )
   protected static int field1740;
   @ObfuscatedName("u")
   InputStream field1741;
   @ObfuscatedName("f")
   class103 field1744;

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field1733 == this.field1738) {
                     if(this.field1730) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var9) {
                        ;
                     }
                  }

                  var2 = this.field1733;
                  if(this.field1738 >= this.field1733) {
                     var1 = this.field1738 - this.field1733;
                  } else {
                     var1 = 5000 - this.field1733;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1737.write(this.field1736, var2, var1);
               } catch (IOException var8) {
                  this.field1739 = true;
               }

               this.field1733 = (var1 + this.field1733) % 5000;

               try {
                  if(this.field1738 == this.field1733) {
                     this.field1737.flush();
                  }
               } catch (IOException var7) {
                  this.field1739 = true;
               }
               continue;
            }

            try {
               if(null != this.field1741) {
                  this.field1741.close();
               }

               if(this.field1737 != null) {
                  this.field1737.close();
               }

               if(null != this.field1732) {
                  this.field1732.close();
               }
            } catch (IOException var6) {
               ;
            }

            this.field1736 = null;
            break;
         }
      } catch (Exception var11) {
         class174.method3240((String)null, var11);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2123123753"
   )
   public void method2014(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1730) {
         while(var3 > 0) {
            int var4 = this.field1741.read(var1, var2, var3);
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
      signature = "(I)I",
      garbageValue = "1969111152"
   )
   public int method2017() throws IOException {
      return this.field1730?0:this.field1741.available();
   }

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1744 = var2;
      this.field1732 = var1;
      this.field1732.setSoTimeout(30000);
      this.field1732.setTcpNoDelay(true);
      this.field1732.setReceiveBufferSize(16384);
      this.field1732.setSendBufferSize(16384);
      this.field1741 = this.field1732.getInputStream();
      this.field1737 = this.field1732.getOutputStream();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "2"
   )
   public void method2018(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1730) {
         if(this.field1739) {
            this.field1739 = false;
            throw new IOException();
         }

         if(this.field1736 == null) {
            this.field1736 = new byte[5000];
         }

         synchronized(this) {
            for(int var5 = 0; var5 < var3; ++var5) {
               this.field1736[this.field1738] = var1[var2 + var5];
               this.field1738 = (this.field1738 + 1) % 5000;
               if(this.field1738 == (this.field1733 + 4900) % 5000) {
                  throw new IOException();
               }
            }

            if(this.field1734 == null) {
               this.field1734 = this.field1744.method1916(this, 3);
            }

            this.notifyAll();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1015624839"
   )
   public int method2021() throws IOException {
      return this.field1730?0:this.field1741.read();
   }

   protected void finalize() {
      this.method2026();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-657646102"
   )
   public void method2026() {
      if(!this.field1730) {
         synchronized(this) {
            this.field1730 = true;
            this.notifyAll();
         }

         if(null != this.field1734) {
            while(this.field1734.field1648 == 0) {
               VertexNormal.method1598(1L);
            }

            if(this.field1734.field1648 == 1) {
               try {
                  ((Thread)this.field1734.field1652).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1734 = null;
      }

   }
}
