import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class153 implements Runnable {
   @ObfuscatedName("g")
   @Export("userHome")
   static String userHome;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1659131861
   )
   static int field2128;
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("n")
   Thread field2133;
   @ObfuscatedName("v")
   InputStream field2125;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1280891897
   )
   int field2127;
   @ObfuscatedName("r")
   byte[] field2126;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1795840831
   )
   int field2132;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2120280661
   )
   int field2130;
   @ObfuscatedName("s")
   IOException field2131;

   class153(InputStream var1, int var2) {
      this.field2132 = 0;
      this.field2130 = 0;
      this.field2125 = var1;
      this.field2127 = var2 + 1;
      this.field2126 = new byte[this.field2127];
      this.field2133 = new Thread(this);
      this.field2133.setDaemon(true);
      this.field2133.start();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-918576593"
   )
   boolean method3010(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2127) {
         synchronized(this) {
            int var3;
            if(this.field2132 <= this.field2130) {
               var3 = this.field2130 - this.field2132;
            } else {
               var3 = this.field2127 - this.field2132 + this.field2130;
            }

            if(var3 < var1) {
               if(this.field2131 != null) {
                  throw new IOException(this.field2131.toString());
               } else {
                  this.notifyAll();
                  return false;
               }
            } else {
               return true;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1406106689"
   )
   int method3024() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2132 <= this.field2130) {
            var2 = this.field2130 - this.field2132;
         } else {
            var2 = this.field2127 - this.field2132 + this.field2130;
         }

         if(var2 <= 0 && this.field2131 != null) {
            throw new IOException(this.field2131.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1127559893"
   )
   int method3011() throws IOException {
      synchronized(this) {
         if(this.field2132 == this.field2130) {
            if(this.field2131 != null) {
               throw new IOException(this.field2131.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2126[this.field2132] & 255;
            this.field2132 = (this.field2132 + 1) % this.field2127;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-62"
   )
   int method3012(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2132 <= this.field2130) {
               var5 = this.field2130 - this.field2132;
            } else {
               var5 = this.field2127 - this.field2132 + this.field2130;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2131 != null) {
               throw new IOException(this.field2131.toString());
            } else {
               if(var3 + this.field2132 <= this.field2127) {
                  System.arraycopy(this.field2126, this.field2132, var1, var2, var3);
               } else {
                  int var6 = this.field2127 - this.field2132;
                  System.arraycopy(this.field2126, this.field2132, var1, var2, var6);
                  System.arraycopy(this.field2126, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2132 = (var3 + this.field2132) % this.field2127;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   void method3013() {
      synchronized(this) {
         if(this.field2131 == null) {
            this.field2131 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2133.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2131 != null) {
                  return;
               }

               if(this.field2132 == 0) {
                  var1 = this.field2127 - this.field2130 - 1;
               } else if(this.field2132 <= this.field2130) {
                  var1 = this.field2127 - this.field2130;
               } else {
                  var1 = this.field2132 - this.field2130 - 1;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var10) {
                  ;
               }
            }
         }

         int var7;
         try {
            var7 = this.field2125.read(this.field2126, this.field2130, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2131 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2130 = (var7 + this.field2130) % this.field2127;
         }
      }
   }

   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "(Lhq;I)Lhq;",
      garbageValue = "-1603704239"
   )
   static Widget method3030(Widget var0) {
      int var1 = class263.method4654(GraphicsObject.getWidgetConfig(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = UrlRequester.getWidget(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
