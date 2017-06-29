import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("w")
   public static String field2248;
   @ObfuscatedName("r")
   boolean field2249;
   @ObfuscatedName("a")
   class153 field2250;
   @ObfuscatedName("t")
   class153 field2251;
   @ObfuscatedName("s")
   Thread field2252;
   @ObfuscatedName("i")
   public static String field2253;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   public final void method2923() {
      synchronized(this) {
         this.field2249 = true;
         this.notifyAll();
      }

      try {
         this.field2252.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass153;",
      garbageValue = "-1334399042"
   )
   final class153 method2925(int var1, int var2, int var3, Object var4) {
      class153 var5 = new class153();
      var5.field2244 = var1;
      var5.field2245 = var2;
      var5.field2246 = var4;
      synchronized(this) {
         if(this.field2251 != null) {
            this.field2251.field2242 = var5;
            this.field2251 = var5;
         } else {
            this.field2251 = this.field2250 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass153;",
      garbageValue = "-718440342"
   )
   public final class153 method2926(String var1, int var2) {
      return this.method2925(1, var2, 0, var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass153;",
      garbageValue = "-1975001180"
   )
   public final class153 method2927(Runnable var1, int var2) {
      return this.method2925(2, var2, 0, var1);
   }

   public final void run() {
      while(true) {
         class153 var1;
         synchronized(this) {
            while(true) {
               if(this.field2249) {
                  return;
               }

               if(this.field2250 != null) {
                  var1 = this.field2250;
                  this.field2250 = this.field2250.field2242;
                  if(this.field2250 == null) {
                     this.field2251 = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var8) {
                  ;
               }
            }
         }

         try {
            int var5 = var1.field2244;
            if(var5 == 1) {
               var1.field2239 = new Socket(InetAddress.getByName((String)var1.field2246), var1.field2245);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2246);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2245);
               var1.field2239 = var3;
            } else if(var5 == 4) {
               var1.field2239 = new DataInputStream(((URL)var1.field2246).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2245 >> 24 & 255) + "." + (var1.field2245 >> 16 & 255) + "." + (var1.field2245 >> 8 & 255) + "." + (var1.field2245 & 255);
               var1.field2239 = InetAddress.getByName(var10).getHostName();
            }

            var1.status = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.status = 2;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass153;",
      garbageValue = "25"
   )
   public final class153 method2928(URL var1) {
      return this.method2925(4, 0, 0, var1);
   }

   public Signlink() {
      this.field2250 = null;
      this.field2251 = null;
      this.field2249 = false;
      field2253 = "Unknown";
      field2248 = "1.6";

      try {
         field2253 = System.getProperty("java.vendor");
         field2248 = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.field2249 = false;
      this.field2252 = new Thread(this);
      this.field2252.setPriority(10);
      this.field2252.setDaemon(true);
      this.field2252.start();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass153;",
      garbageValue = "1927296735"
   )
   public final class153 method2930(int var1) {
      return this.method2925(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "17"
   )
   @Export("drawWidget")
   static final void drawWidget(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class66.method1121(var0)) {
         class262.field3641 = null;
         WallObject.gameDraw(class46.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class262.field3641 != null) {
            WallObject.gameDraw(class262.field3641, -1412584499, var1, var2, var3, var4, class77.field1237, class270.field3689, var7);
            class262.field3641 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1132[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1132[var8] = true;
            }
         }

      }
   }
}
