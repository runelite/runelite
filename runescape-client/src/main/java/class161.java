import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public final class class161 extends class157 implements Runnable {
   @ObfuscatedName("w")
   InputStream field2017;
   @ObfuscatedName("m")
   OutputStream field2015;
   @ObfuscatedName("q")
   Socket field2022;
   @ObfuscatedName("b")
   boolean field2012;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   Signlink field2010;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   Task field2014;
   @ObfuscatedName("h")
   byte[] field2011;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1306170743
   )
   int field2016;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1028476947
   )
   int field2009;
   @ObfuscatedName("a")
   boolean field2018;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1256523181
   )
   final int field2019;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1431179485
   )
   final int field2020;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lea;I)V"
   )
   public class161(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2012 = false;
      this.field2016 = 0;
      this.field2009 = 0;
      this.field2018 = false;
      this.field2010 = var2;
      this.field2022 = var1;
      this.field2019 = var3;
      this.field2020 = var3 - 100;
      this.field2022.setSoTimeout(30000);
      this.field2022.setTcpNoDelay(true);
      this.field2022.setReceiveBufferSize(65536);
      this.field2022.setSendBufferSize(65536);
      this.field2017 = this.field2022.getInputStream();
      this.field2015 = this.field2022.getOutputStream();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1138130565"
   )
   public boolean vmethod3355(int var1) throws IOException {
      return this.field2012?false:this.field2017.available() >= var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "255159045"
   )
   public int vmethod3354() throws IOException {
      return this.field2012?0:this.field2017.available();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1722557406"
   )
   public int vmethod3353() throws IOException {
      return this.field2012?0:this.field2017.read();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-61239109"
   )
   public int vmethod3356(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2012) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2017.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1450005148"
   )
   public void vmethod3385(byte[] var1, int var2, int var3) throws IOException {
      this.method3383(var1, var2, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "188281095"
   )
   public void vmethod3368() {
      if(!this.field2012) {
         synchronized(this) {
            this.field2012 = true;
            this.notifyAll();
         }

         if(this.field2014 != null) {
            while(this.field2014.status == 0) {
               WorldMapType1.method218(1L);
            }

            if(this.field2014.status == 1) {
               try {
                  ((Thread)this.field2014.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2014 = null;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-702422468"
   )
   void method3383(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2012) {
         if(this.field2018) {
            this.field2018 = false;
            throw new IOException();
         } else {
            if(this.field2011 == null) {
               this.field2011 = new byte[this.field2019];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2011[this.field2009] = var1[var5 + var2];
                  this.field2009 = (this.field2009 + 1) % this.field2019;
                  if((this.field2016 + this.field2020) % this.field2019 == this.field2009) {
                     throw new IOException();
                  }
               }

               if(this.field2014 == null) {
                  this.field2014 = this.field2010.createRunnable(this, 3);
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
                  if(this.field2009 == this.field2016) {
                     if(this.field2012) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2016;
                  if(this.field2009 >= this.field2016) {
                     var1 = this.field2009 - this.field2016;
                  } else {
                     var1 = this.field2019 - this.field2016;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2015.write(this.field2011, var2, var1);
               } catch (IOException var9) {
                  this.field2018 = true;
               }

               this.field2016 = (var1 + this.field2016) % this.field2019;

               try {
                  if(this.field2016 == this.field2009) {
                     this.field2015.flush();
                  }
               } catch (IOException var8) {
                  this.field2018 = true;
               }
               continue;
            }

            try {
               if(this.field2017 != null) {
                  this.field2017.close();
               }

               if(this.field2015 != null) {
                  this.field2015.close();
               }

               if(this.field2022 != null) {
                  this.field2022.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2011 = null;
            break;
         }
      } catch (Exception var12) {
         class43.processClientError((String)null, var12);
      }

   }

   protected void finalize() {
      this.vmethod3368();
   }
}
