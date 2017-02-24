import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public final class class110 implements Runnable {
   @ObfuscatedName("j")
   class103 field1747;
   @ObfuscatedName("h")
   Socket field1748;
   @ObfuscatedName("p")
   boolean field1749 = false;
   @ObfuscatedName("n")
   class102 field1751;
   @ObfuscatedName("r")
   byte[] field1752;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 743161251
   )
   int field1753 = 0;
   @ObfuscatedName("d")
   OutputStream field1754;
   @ObfuscatedName("o")
   boolean field1755 = false;
   @ObfuscatedName("q")
   InputStream field1756;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -34335339
   )
   int field1757 = 0;
   @ObfuscatedName("gm")
   static Widget field1758;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "963291457"
   )
   public void method2114(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1749) {
         if(this.field1755) {
            this.field1755 = false;
            throw new IOException();
         } else {
            if(this.field1752 == null) {
               this.field1752 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1752[this.field1757] = var1[var2 + var5];
                  this.field1757 = (1 + this.field1757) % 5000;
                  if(this.field1757 == (this.field1753 + 4900) % 5000) {
                     throw new IOException();
                  }
               }

               if(this.field1751 == null) {
                  this.field1751 = this.field1747.method2025(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-553857054"
   )
   public int method2116() throws IOException {
      return this.field1749?0:this.field1756.read();
   }

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1747 = var2;
      this.field1748 = var1;
      this.field1748.setSoTimeout(30000);
      this.field1748.setTcpNoDelay(true);
      this.field1748.setReceiveBufferSize(16384);
      this.field1748.setSendBufferSize(16384);
      this.field1756 = this.field1748.getInputStream();
      this.field1754 = this.field1748.getOutputStream();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-419710772"
   )
   public void method2117(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1749) {
         while(var3 > 0) {
            int var4 = this.field1756.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   protected void finalize() {
      this.method2118();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method2118() {
      if(!this.field1749) {
         synchronized(this) {
            this.field1749 = true;
            this.notifyAll();
         }

         if(this.field1751 != null) {
            while(this.field1751.field1671 == 0) {
               class115.method2292(1L);
            }

            if(this.field1751.field1671 == 1) {
               try {
                  ((Thread)this.field1751.field1672).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1751 = null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2128() throws IOException {
      return this.field1749?0:this.field1756.available();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field1753 == this.field1757) {
                     if(this.field1749) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1753;
                  if(this.field1757 >= this.field1753) {
                     var1 = this.field1757 - this.field1753;
                  } else {
                     var1 = 5000 - this.field1753;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1754.write(this.field1752, var2, var1);
               } catch (IOException var9) {
                  this.field1755 = true;
               }

               this.field1753 = (this.field1753 + var1) % 5000;

               try {
                  if(this.field1753 == this.field1757) {
                     this.field1754.flush();
                  }
               } catch (IOException var8) {
                  this.field1755 = true;
               }
               continue;
            }

            try {
               if(null != this.field1756) {
                  this.field1756.close();
               }

               if(null != this.field1754) {
                  this.field1754.close();
               }

               if(this.field1748 != null) {
                  this.field1748.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1752 = null;
            break;
         }
      } catch (Exception var12) {
         class37.method822((String)null, var12);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1685957899"
   )
   public static void method2137(boolean var0) {
      if(class185.field2759 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2918(var0?2:3);
            var1.method2961(0);
            class185.field2759.method2114(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2759.method2118();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2765;
            class185.field2759 = null;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "122"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method978(var0, var1, var2, var3);
      class47.field951.method2365(var5, (long)var5.id);
      class47.field948.method2523(var5);
      Client.field497 = Client.field490;
   }
}
