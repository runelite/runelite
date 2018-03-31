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
public final class class173 extends class169 implements Runnable {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1080382583
   )
   static int field2242;
   @ObfuscatedName("c")
   InputStream field2231;
   @ObfuscatedName("i")
   OutputStream field2234;
   @ObfuscatedName("o")
   Socket field2235;
   @ObfuscatedName("j")
   boolean field2229;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   Signlink field2233;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   Task field2232;
   @ObfuscatedName("z")
   byte[] field2230;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 614044513
   )
   int field2236;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2140298413
   )
   int field2243;
   @ObfuscatedName("r")
   boolean field2238;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1016970483
   )
   final int field2239;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2113146707
   )
   final int field2240;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfl;I)V"
   )
   public class173(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2229 = false;
      this.field2236 = 0;
      this.field2243 = 0;
      this.field2238 = false;
      this.field2233 = var2;
      this.field2235 = var1;
      this.field2239 = var3;
      this.field2240 = var3 - 100;
      this.field2235.setSoTimeout(30000);
      this.field2235.setTcpNoDelay(true);
      this.field2235.setReceiveBufferSize(65536);
      this.field2235.setSendBufferSize(65536);
      this.field2231 = this.field2235.getInputStream();
      this.field2234 = this.field2235.getOutputStream();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-41"
   )
   public boolean vmethod3338(int var1) throws IOException {
      return this.field2229?false:this.field2231.available() >= var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "8917861"
   )
   public int vmethod3316() throws IOException {
      return this.field2229?0:this.field2231.available();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1719250034"
   )
   public int vmethod3315() throws IOException {
      return this.field2229?0:this.field2231.read();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "903617518"
   )
   public int vmethod3318(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2229) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2231.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1130563356"
   )
   public void vmethod3320(byte[] var1, int var2, int var3) throws IOException {
      this.method3319(var1, var2, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1801563331"
   )
   public void vmethod3325() {
      if(!this.field2229) {
         synchronized(this) {
            this.field2229 = true;
            this.notifyAll();
         }

         if(this.field2232 != null) {
            while(this.field2232.status == 0) {
               class163.method3223(1L);
            }

            if(this.field2232.status == 1) {
               try {
                  ((Thread)this.field2232.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2232 = null;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "32"
   )
   void method3319(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2229) {
         if(this.field2238) {
            this.field2238 = false;
            throw new IOException();
         } else {
            if(this.field2230 == null) {
               this.field2230 = new byte[this.field2239];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2230[this.field2243] = var1[var5 + var2];
                  this.field2243 = (this.field2243 + 1) % this.field2239;
                  if((this.field2240 + this.field2236) % this.field2239 == this.field2243) {
                     throw new IOException();
                  }
               }

               if(this.field2232 == null) {
                  this.field2232 = this.field2233.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   protected void finalize() {
      this.vmethod3325();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2243 == this.field2236) {
                     if(this.field2229) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2236;
                  if(this.field2243 >= this.field2236) {
                     var1 = this.field2243 - this.field2236;
                  } else {
                     var1 = this.field2239 - this.field2236;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2234.write(this.field2230, var2, var1);
               } catch (IOException var9) {
                  this.field2238 = true;
               }

               this.field2236 = (var1 + this.field2236) % this.field2239;

               try {
                  if(this.field2243 == this.field2236) {
                     this.field2234.flush();
                  }
               } catch (IOException var8) {
                  this.field2238 = true;
               }
               continue;
            }

            try {
               if(this.field2231 != null) {
                  this.field2231.close();
               }

               if(this.field2234 != null) {
                  this.field2234.close();
               }

               if(this.field2235 != null) {
                  this.field2235.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2230 = null;
            break;
         }
      } catch (Exception var12) {
         UrlRequest.processClientError((String)null, var12);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "1682574293"
   )
   public static void method3341(String[] var0, short[] var1) {
      class138.method3065(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-72"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "-88"
   )
   public static int method3340(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1332901100"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class33.method384();
      ++Client.field902.field1481;
      if(Client.field902.field1481 >= 50 || var0) {
         Client.field902.field1481 = 0;
         if(!Client.socketError && Client.field902.getSocket() != null) {
            PacketNode var1 = FaceNormal.method3078(ClientPacket.field2412, Client.field902.field1475);
            Client.field902.method2036(var1);

            try {
               Client.field902.method2035();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }
}
