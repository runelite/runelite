import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("et")
public class class153 implements Runnable {
   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 979128853
   )
   static int field2114;
   @ObfuscatedName("s")
   Thread field2110;
   @ObfuscatedName("g")
   InputStream field2104;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1396303575
   )
   int field2105;
   @ObfuscatedName("h")
   byte[] field2106;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 931183707
   )
   int field2108;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -612504639
   )
   int field2111;
   @ObfuscatedName("t")
   IOException field2109;

   class153(InputStream var1, int var2) {
      this.field2108 = 0;
      this.field2111 = 0;
      this.field2104 = var1;
      this.field2105 = var2 + 1;
      this.field2106 = new byte[this.field2105];
      this.field2110 = new Thread(this);
      this.field2110.setDaemon(true);
      this.field2110.start();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2049417744"
   )
   boolean method3182(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2105) {
         synchronized(this) {
            int var3;
            if(this.field2108 <= this.field2111) {
               var3 = this.field2111 - this.field2108;
            } else {
               var3 = this.field2105 - this.field2108 + this.field2111;
            }

            if(var3 < var1) {
               if(this.field2109 != null) {
                  throw new IOException(this.field2109.toString());
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "13"
   )
   int method3183() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2108 <= this.field2111) {
            var2 = this.field2111 - this.field2108;
         } else {
            var2 = this.field2105 - this.field2108 + this.field2111;
         }

         if(var2 <= 0 && this.field2109 != null) {
            throw new IOException(this.field2109.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-302589793"
   )
   int method3184() throws IOException {
      synchronized(this) {
         if(this.field2108 == this.field2111) {
            if(this.field2109 != null) {
               throw new IOException(this.field2109.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2106[this.field2108] & 255;
            this.field2108 = (this.field2108 + 1) % this.field2105;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-120"
   )
   int method3199(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2108 <= this.field2111) {
               var5 = this.field2111 - this.field2108;
            } else {
               var5 = this.field2105 - this.field2108 + this.field2111;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2109 != null) {
               throw new IOException(this.field2109.toString());
            } else {
               if(var3 + this.field2108 <= this.field2105) {
                  System.arraycopy(this.field2106, this.field2108, var1, var2, var3);
               } else {
                  int var6 = this.field2105 - this.field2108;
                  System.arraycopy(this.field2106, this.field2108, var1, var2, var6);
                  System.arraycopy(this.field2106, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2108 = (var3 + this.field2108) % this.field2105;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "301530419"
   )
   void method3192() {
      synchronized(this) {
         if(this.field2109 == null) {
            this.field2109 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2110.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2109 != null) {
                  return;
               }

               if(this.field2108 == 0) {
                  var1 = this.field2105 - this.field2111 - 1;
               } else if(this.field2108 <= this.field2111) {
                  var1 = this.field2105 - this.field2111;
               } else {
                  var1 = this.field2108 - this.field2111 - 1;
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
            var7 = this.field2104.read(this.field2106, this.field2111, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2109 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2111 = (var7 + this.field2111) % this.field2105;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Ljm;",
      garbageValue = "0"
   )
   @Export("getOverlayDefinition")
   public static Overlay getOverlayDefinition(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SB)V",
      garbageValue = "3"
   )
   public static void method3200(String[] var0, short[] var1) {
      Projectile.method1943(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   static void method3203() {
      int var0 = class92.playerIndexesCount;
      int[] var1 = class92.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         if(var1[var2] != Client.field953 && var1[var2] != Client.localInteractingIndex) {
            class214.method4127(Client.cachedPlayers[var1[var2]], true);
         }
      }

   }

   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2147209522"
   )
   static void method3201(String var0) {
      IndexFile.sessionToken = var0;

      try {
         String var1 = class175.clientInstance.getParameter(Parameters.field3837.key);
         String var2 = class175.clientInstance.getParameter(Parameters.field3838.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + FileOnDisk.method2097(SceneTilePaint.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         Client var4 = class175.clientInstance;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }
}
