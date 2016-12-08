import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public final class class110 implements Runnable {
   @ObfuscatedName("b")
   OutputStream field1751;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1468287237
   )
   int field1752 = 0;
   @ObfuscatedName("g")
   boolean field1753 = false;
   @ObfuscatedName("h")
   class103 field1754;
   @ObfuscatedName("v")
   class102 field1755;
   @ObfuscatedName("l")
   byte[] field1756;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 430753931
   )
   int field1757 = 0;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -655807297
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("k")
   boolean field1759 = false;
   @ObfuscatedName("m")
   InputStream field1760;
   @ObfuscatedName("o")
   Socket field1761;
   @ObfuscatedName("ms")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   protected void finalize() {
      this.method2027();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1947918558"
   )
   public int method2013() throws IOException {
      return this.field1753?0:this.field1760.read();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "291774042"
   )
   public int method2014() throws IOException {
      return this.field1753?0:this.field1760.available();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1850481462"
   )
   public void method2015(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1753) {
         while(var3 > 0) {
            int var4 = this.field1760.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-999563926"
   )
   public void method2016(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1753) {
         if(this.field1759) {
            this.field1759 = false;
            throw new IOException();
         } else {
            if(this.field1756 == null) {
               this.field1756 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1756[this.field1757] = var1[var5 + var2];
                  this.field1757 = (this.field1757 + 1) % 5000;
                  if((this.field1752 + 4900) % 5000 == this.field1757) {
                     throw new IOException();
                  }
               }

               if(this.field1755 == null) {
                  this.field1755 = this.field1754.method1939(this, 3);
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
                  if(this.field1757 == this.field1752) {
                     if(this.field1753) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1752;
                  if(this.field1757 >= this.field1752) {
                     var1 = this.field1757 - this.field1752;
                  } else {
                     var1 = 5000 - this.field1752;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1751.write(this.field1756, var2, var1);
               } catch (IOException var9) {
                  this.field1759 = true;
               }

               this.field1752 = (var1 + this.field1752) % 5000;

               try {
                  if(this.field1752 == this.field1757) {
                     this.field1751.flush();
                  }
               } catch (IOException var8) {
                  this.field1759 = true;
               }
               continue;
            }

            try {
               if(null != this.field1760) {
                  this.field1760.close();
               }

               if(this.field1751 != null) {
                  this.field1751.close();
               }

               if(null != this.field1761) {
                  this.field1761.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1756 = null;
            break;
         }
      } catch (Exception var12) {
         FaceNormal.method1844((String)null, var12);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1354248158"
   )
   static int method2018(int var0) {
      MessageNode var1 = (MessageNode)class47.field945.method2258((long)var0);
      return null == var1?-1:(var1.previous == class47.field939.field1913?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "438629009"
   )
   static final void method2025(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class84.field1435[var6];
         var12 = class84.field1446[var6];
         var13 = var9 * var12 - var5 * var11 >> 16;
         var10 = var5 * var12 + var9 * var11 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class84.field1435[var7];
         var12 = class84.field1446[var7];
         var13 = var11 * var10 + var12 * var8 >> 16;
         var10 = var12 * var10 - var8 * var11 >> 16;
         var8 = var13;
      }

      cameraX = var0 - var8;
      class189.cameraZ = var1 - var9;
      class16.cameraY = var2 - var10;
      WidgetNode.cameraPitch = var3;
      class60.cameraYaw = var4;
   }

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1754 = var2;
      this.field1761 = var1;
      this.field1761.setSoTimeout(30000);
      this.field1761.setTcpNoDelay(true);
      this.field1761.setReceiveBufferSize(16384);
      this.field1761.setSendBufferSize(16384);
      this.field1760 = this.field1761.getInputStream();
      this.field1751 = this.field1761.getOutputStream();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-71"
   )
   public void method2027() {
      if(!this.field1753) {
         synchronized(this) {
            this.field1753 = true;
            this.notifyAll();
         }

         if(this.field1755 != null) {
            while(this.field1755.field1664 == 0) {
               XClanMember.method237(1L);
            }

            if(this.field1755.field1664 == 1) {
               try {
                  ((Thread)this.field1755.field1662).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1755 = null;
      }
   }
}
