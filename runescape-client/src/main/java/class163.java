import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public final class class163 extends class159 implements Runnable {
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -1379614509
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("n")
   InputStream field2198;
   @ObfuscatedName("v")
   OutputStream field2199;
   @ObfuscatedName("y")
   Socket field2194;
   @ObfuscatedName("r")
   boolean field2197;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   Signlink field2196;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   Task field2193;
   @ObfuscatedName("s")
   byte[] field2195;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1643480459
   )
   int field2201;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2117490119
   )
   int field2200;
   @ObfuscatedName("f")
   boolean field2192;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1095337365
   )
   final int field2202;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -640787223
   )
   final int field2203;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lff;I)V"
   )
   public class163(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2197 = false;
      this.field2201 = 0;
      this.field2200 = 0;
      this.field2192 = false;
      this.field2196 = var2;
      this.field2194 = var1;
      this.field2202 = var3;
      this.field2203 = var3 - 100;
      this.field2194.setSoTimeout(30000);
      this.field2194.setTcpNoDelay(true);
      this.field2194.setReceiveBufferSize(65536);
      this.field2194.setSendBufferSize(65536);
      this.field2198 = this.field2194.getInputStream();
      this.field2199 = this.field2194.getOutputStream();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "677753628"
   )
   public boolean vmethod3153(int var1) throws IOException {
      if(this.field2197) {
         return false;
      } else {
         try {
            return this.field2198.available() >= var1;
         } catch (IOException var3) {
            throw new IOException("Error reading from clientstream", var3);
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2068163237"
   )
   public int vmethod3138() throws IOException {
      return this.field2197?0:this.field2198.available();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "267419020"
   )
   public int vmethod3167() throws IOException {
      return this.field2197?0:this.field2198.read();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-189738498"
   )
   public int vmethod3148(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2197) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2198.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-383534561"
   )
   public void vmethod3166(byte[] var1, int var2, int var3) throws IOException {
      this.method3159(var1, var2, var3);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   public void vmethod3136() {
      if(!this.field2197) {
         synchronized(this) {
            this.field2197 = true;
            this.notifyAll();
         }

         if(this.field2193 != null) {
            while(this.field2193.status == 0) {
               class61.method1077(1L);
            }

            if(this.field2193.status == 1) {
               try {
                  ((Thread)this.field2193.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2193 = null;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-128962294"
   )
   void method3159(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2197) {
         if(this.field2192) {
            this.field2192 = false;
            throw new IOException();
         } else {
            if(this.field2195 == null) {
               this.field2195 = new byte[this.field2202];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2195[this.field2200] = var1[var5 + var2];
                  this.field2200 = (this.field2200 + 1) % this.field2202;
                  if((this.field2201 + this.field2203) % this.field2202 == this.field2200) {
                     throw new IOException();
                  }
               }

               if(this.field2193 == null) {
                  this.field2193 = this.field2196.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   protected void finalize() {
      this.vmethod3136();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2200 == this.field2201) {
                     if(this.field2197) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2201;
                  if(this.field2200 >= this.field2201) {
                     var1 = this.field2200 - this.field2201;
                  } else {
                     var1 = this.field2202 - this.field2201;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2199.write(this.field2195, var2, var1);
               } catch (IOException var9) {
                  this.field2192 = true;
               }

               this.field2201 = (var1 + this.field2201) % this.field2202;

               try {
                  if(this.field2201 == this.field2200) {
                     this.field2199.flush();
                  }
               } catch (IOException var8) {
                  this.field2192 = true;
               }
               continue;
            }

            try {
               if(this.field2198 != null) {
                  this.field2198.close();
               }

               if(this.field2199 != null) {
                  this.field2199.close();
               }

               if(this.field2194 != null) {
                  this.field2194.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2195 = null;
            break;
         }
      } catch (Exception var12) {
         Bounds.method5132((String)null, var12);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "1663339496"
   )
   public static int method3151(CharSequence var0, int var1) {
      return PacketNode.parseInt(var0, var1, true);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILfv;Lif;I)V",
      garbageValue = "1496117736"
   )
   static void method3168(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      class25.method174();
   }
}
