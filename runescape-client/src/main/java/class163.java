import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public final class class163 extends class159 implements Runnable {
   @ObfuscatedName("s")
   InputStream field2181;
   @ObfuscatedName("g")
   OutputStream field2177;
   @ObfuscatedName("m")
   Socket field2173;
   @ObfuscatedName("h")
   boolean field2174;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   Signlink field2175;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   Task field2176;
   @ObfuscatedName("t")
   byte[] field2184;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1949194017
   )
   int field2178;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1523611669
   )
   int field2179;
   @ObfuscatedName("k")
   boolean field2180;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1040362211
   )
   final int field2172;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2071310273
   )
   final int field2182;

   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;Lfy;I)V"
   )
   public class163(Socket var1, Signlink var2, int var3) throws IOException {
      this.field2174 = false;
      this.field2178 = 0;
      this.field2179 = 0;
      this.field2180 = false;
      this.field2175 = var2;
      this.field2173 = var1;
      this.field2172 = var3;
      this.field2182 = var3 - 100;
      this.field2173.setSoTimeout(30000);
      this.field2173.setTcpNoDelay(true);
      this.field2173.setReceiveBufferSize(65536);
      this.field2173.setSendBufferSize(65536);
      this.field2181 = this.field2173.getInputStream();
      this.field2177 = this.field2173.getOutputStream();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2070343570"
   )
   public boolean vmethod3297(int var1) throws IOException {
      if(this.field2174) {
         return false;
      } else {
         try {
            return this.field2181.available() >= var1;
         } catch (IOException var3) {
            throw new IOException("Error reading from clientstream", var3);
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "479833160"
   )
   public int vmethod3300() throws IOException {
      return this.field2174?0:this.field2181.available();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "91"
   )
   public int vmethod3301() throws IOException {
      return this.field2174?0:this.field2181.read();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-14"
   )
   public int vmethod3302(byte[] var1, int var2, int var3) throws IOException {
      if(this.field2174) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.field2181.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "16711680"
   )
   public void vmethod3304(byte[] var1, int var2, int var3) throws IOException {
      this.method3303(var1, var2, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1598662762"
   )
   public void vmethod3299() {
      if(!this.field2174) {
         synchronized(this) {
            this.field2174 = true;
            this.notifyAll();
         }

         if(this.field2176 != null) {
            while(this.field2176.status == 0) {
               Tile.method2712(1L);
            }

            if(this.field2176.status == 1) {
               try {
                  ((Thread)this.field2176.value).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field2176 = null;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2045377257"
   )
   void method3303(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field2174) {
         if(this.field2180) {
            this.field2180 = false;
            throw new IOException();
         } else {
            if(this.field2184 == null) {
               this.field2184 = new byte[this.field2172];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field2184[this.field2179] = var1[var5 + var2];
                  this.field2179 = (this.field2179 + 1) % this.field2172;
                  if((this.field2178 + this.field2182) % this.field2172 == this.field2179) {
                     throw new IOException();
                  }
               }

               if(this.field2176 == null) {
                  this.field2176 = this.field2175.createRunnable(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   protected void finalize() {
      this.vmethod3299();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field2178 == this.field2179) {
                     if(this.field2174) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field2178;
                  if(this.field2179 >= this.field2178) {
                     var1 = this.field2179 - this.field2178;
                  } else {
                     var1 = this.field2172 - this.field2178;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field2177.write(this.field2184, var2, var1);
               } catch (IOException var9) {
                  this.field2180 = true;
               }

               this.field2178 = (var1 + this.field2178) % this.field2172;

               try {
                  if(this.field2178 == this.field2179) {
                     this.field2177.flush();
                  }
               } catch (IOException var8) {
                  this.field2180 = true;
               }
               continue;
            }

            try {
               if(this.field2181 != null) {
                  this.field2181.close();
               }

               if(this.field2177 != null) {
                  this.field2177.close();
               }

               if(this.field2173 != null) {
                  this.field2173.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field2184 = null;
            break;
         }
      } catch (Exception var12) {
         GrandExchangeEvent.method78((String)null, var12);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "43"
   )
   public static void method3323(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      class3.method7(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;Ljava/lang/String;I)Lkh;",
      garbageValue = "-995222149"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!class35.method484(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class89.method1909();
      }

      return var5;
   }
}
