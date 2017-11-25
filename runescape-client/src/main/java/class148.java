import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class148 implements Runnable {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static IndexedSprite field2098;
   @ObfuscatedName("d")
   final Thread field2099;
   @ObfuscatedName("x")
   volatile boolean field2096;
   @ObfuscatedName("k")
   Queue field2097;

   public class148() {
      this.field2097 = new LinkedList();
      this.field2099 = new Thread(this);
      this.field2099.setPriority(1);
      this.field2099.start();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lew;",
      garbageValue = "0"
   )
   public class149 method3022(URL var1) {
      class149 var2 = new class149(var1);
      synchronized(this) {
         this.field2097.add(var2);
         this.notify();
         return var2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-374239776"
   )
   public void method3023() {
      this.field2096 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field2099.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   public void run() {
      while(!this.field2096) {
         try {
            class149 var1;
            synchronized(this) {
               var1 = (class149)this.field2097.poll();
               if(var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var13) {
                     ;
                  }
                  continue;
               }
            }

            DataInputStream var2 = null;
            URLConnection var3 = null;

            try {
               var3 = var1.field2103.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var7 = var3.getContentLength();
               if(var7 >= 0) {
                  byte[] var5 = new byte[var7];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.field2102 = var5;
               }

               var1.field2101 = true;
            } catch (IOException var14) {
               var1.field2101 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            Item.method1829((String)null, var17);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-1191471062"
   )
   static int method3021(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class54.field636:class82.field1265;
      if(var0 == 1500) {
         class82.intStack[++class13.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class82.intStack[++class13.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class82.intStack[++class13.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class82.intStack[++class13.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class82.intStack[++class13.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class82.intStack[++class13.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-455156470"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = KeyFocusListener.font_p12full.method4928(var0, 250);
      int var6 = KeyFocusListener.font_p12full.method4929(var0, 250) * 13;
      Rasterizer2D.method5173(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
      KeyFocusListener.font_p12full.method4935(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class44.method636(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6);
      if(var1) {
         class86.field1309.vmethod5222(0, 0);
      } else {
         DState.method3276(var3, var4, var5, var6);
      }

   }
}
