import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public final class class172 extends class168 implements Runnable {
   @ObfuscatedName("b")
   InputStream field2206;
   @ObfuscatedName("q")
   OutputStream field2204;
   @ObfuscatedName("o")
   Socket field2198;
   @ObfuscatedName("p")
   boolean field2199;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   Signlink field2200;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   Task field2196;
   @ObfuscatedName("l")
   byte[] field2202;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1881433681
   )
   int field2203;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 293978891
   )
   int field2197;
   @ObfuscatedName("c")
   boolean field2205;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1589260623
   )
   final int field2201;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1021824329
   )
   final int field2207;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lff;I)V"
   )
   public class172(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2199 = false;
      this.field2203 = 0;
      this.field2197 = 0;
      this.field2205 = false;
      this.field2200 = var2;
      this.field2198 = var1;
      this.field2201 = var3;
      this.field2207 = var3 - 100;
      this.field2198.setSoTimeout(30000);
      this.field2198.setTcpNoDelay(true);
      this.field2198.setReceiveBufferSize(65536);
      this.field2198.setSendBufferSize(65536);
      this.field2206 = this.field2198.getInputStream();
      this.field2204 = this.field2198.getOutputStream();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-118954090"
   )
   public boolean vmethod3341(int var1) throws IOException {
      if(this.field2199) {
         return false;
      } else {
         try {
            return this.field2206.available() >= var1;
         } catch (IOException var3) {
            throw new IOException("Error reading from clientstream", var3);
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "26"
   )
   public int vmethod3346() throws IOException {
      return this.field2199?0:this.field2206.available();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1770569252"
   )
   public int vmethod3318() throws IOException {
      return this.field2199?0:this.field2206.read();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1399740149"
   )
   public int vmethod3321(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2199) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2206.read(var1, var2, var3);
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
      garbageValue = "-2027539026"
   )
   public void vmethod3323(byte[] var1, int var2, int var3) throws IOException {
      this.method3322(var1, var2, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   public void vmethod3317() {
      if(!this.field2199) {
         synchronized(this) {
            this.field2199 = true;
            this.notifyAll();
         }

         if(this.field2196 != null) {
            while(this.field2196.status == 0) {
               class19.method152(1L);
            }

            if(this.field2196.status == 1) {
               try {
                  ((Thread)this.field2196.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2196 = null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "76"
   )
   void method3322(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2199) {
         if(this.field2205) {
            this.field2205 = false;
            throw new IOException();
         } else {
            if(this.field2202 == null) {
               this.field2202 = new byte[this.field2201];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2202[this.field2197] = var1[var5 + var2];
                  this.field2197 = (this.field2197 + 1) % this.field2201;
                  if((this.field2203 + this.field2207) % this.field2201 == this.field2197) {
                     throw new IOException();
                  }
               }

               if(this.field2196 == null) {
                  this.field2196 = this.field2200.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   protected void finalize() {
      this.vmethod3317();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2203 == this.field2197) {
                     if(this.field2199) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2203;
                  if(this.field2197 >= this.field2203) {
                     var1 = this.field2197 - this.field2203;
                  } else {
                     var1 = this.field2201 - this.field2203;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2204.write(this.field2202, var2, var1);
               } catch (IOException var9) {
                  this.field2205 = true;
               }

               this.field2203 = (var1 + this.field2203) % this.field2201;

               try {
                  if(this.field2203 == this.field2197) {
                     this.field2204.flush();
                  }
               } catch (IOException var8) {
                  this.field2205 = true;
               }
               continue;
            }

            try {
               if(this.field2206 != null) {
                  this.field2206.close();
               }

               if(this.field2204 != null) {
                  this.field2204.close();
               }

               if(this.field2198 != null) {
                  this.field2198.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2202 = null;
            break;
         }
      } catch (Exception var12) {
         class37.method519((String)null, var12);
      }

   }

   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "(Lim;IB)Ljava/lang/String;",
      garbageValue = "115"
   )
   static String method3320(Widget var0, int var1) {
      int var3 = class230.getWidgetConfig(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2877 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
