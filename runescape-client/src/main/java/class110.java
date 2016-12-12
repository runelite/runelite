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

@ObfuscatedName("dh")
public final class class110 implements Runnable {
   @ObfuscatedName("k")
   boolean field1733 = false;
   @ObfuscatedName("n")
   class102 field1734;
   @ObfuscatedName("f")
   Socket field1735;
   @ObfuscatedName("g")
   class103 field1737;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 661810615
   )
   int field1738 = 0;
   @ObfuscatedName("a")
   byte[] field1739;
   @ObfuscatedName("i")
   OutputStream field1740;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1187222207
   )
   int field1741 = 0;
   @ObfuscatedName("v")
   boolean field1742 = false;
   @ObfuscatedName("e")
   InputStream field1745;
   @ObfuscatedName("qy")
   @Export("canvas")
   public static Canvas canvas;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-9"
   )
   public int method2028() throws IOException {
      return this.field1733?0:this.field1745.available();
   }

   protected void finalize() {
      this.method2035();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public int method2030() throws IOException {
      return this.field1733?0:this.field1745.read();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "220745382"
   )
   public void method2031(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1733) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "42"
   )
   public void method2032(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1733) {
         if(this.field1742) {
            this.field1742 = false;
            throw new IOException();
         } else {
            if(null == this.field1739) {
               this.field1739 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1739[this.field1741] = var1[var2 + var5];
                  this.field1741 = (this.field1741 + 1) % 5000;
                  if(this.field1741 == (this.field1738 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(null == this.field1734) {
                  this.field1734 = this.field1737.method1932(this, 3);
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
                  if(this.field1741 == this.field1738) {
                     if(this.field1733) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1738;
                  if(this.field1741 >= this.field1738) {
                     var1 = this.field1741 - this.field1738;
                  } else {
                     var1 = 5000 - this.field1738;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1740.write(this.field1739, var2, var1);
               } catch (IOException var9) {
                  this.field1742 = true;
               }

               this.field1738 = (this.field1738 + var1) % 5000;

               try {
                  if(this.field1738 == this.field1741) {
                     this.field1740.flush();
                  }
               } catch (IOException var8) {
                  this.field1742 = true;
               }
               continue;
            }

            try {
               if(this.field1745 != null) {
                  this.field1745.close();
               }

               if(null != this.field1740) {
                  this.field1740.close();
               }

               if(this.field1735 != null) {
                  this.field1735.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1739 = null;
            break;
         }
      } catch (Exception var12) {
         FaceNormal.method1864((String)null, var12);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "31"
   )
   public void method2035() {
      if(!this.field1733) {
         synchronized(this) {
            this.field1733 = true;
            this.notifyAll();
         }

         if(this.field1734 != null) {
            while(this.field1734.field1650 == 0) {
               class10.method149(1L);
            }

            if(this.field1734.field1650 == 1) {
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

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1737 = var2;
      this.field1735 = var1;
      this.field1735.setSoTimeout(30000);
      this.field1735.setTcpNoDelay(true);
      this.field1735.setReceiveBufferSize(16384);
      this.field1735.setSendBufferSize(16384);
      this.field1745 = this.field1735.getInputStream();
      this.field1740 = this.field1735.getOutputStream();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "121"
   )
   static long method2047(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(1 + var5 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(27 + var5 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "-1970928742"
   )
   public static ModIcon method2048(class182 var0, String var1, String var2) {
      int var3 = var0.method3225(var1);
      int var4 = var0.method3226(var3, var2);
      ModIcon var5;
      if(!class178.method3196(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class156.method2963();
      }

      return var5;
   }
}
