import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class139 implements Runnable {
   @ObfuscatedName("l")
   EventQueue field2137;
   @ObfuscatedName("r")
   static String field2138;
   @ObfuscatedName("i")
   Thread field2139;
   @ObfuscatedName("x")
   static String field2141;
   @ObfuscatedName("j")
   class149 field2142 = null;
   @ObfuscatedName("z")
   class149 field2144 = null;
   @ObfuscatedName("b")
   boolean field2147 = false;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-31"
   )
   final void method2923() {
      synchronized(this) {
         this.field2147 = true;
         this.notifyAll();
      }

      try {
         this.field2139.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass149;",
      garbageValue = "-1910006151"
   )
   public final class149 method2926(String var1, int var2) {
      return this.method2934(1, var2, 0, var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass149;",
      garbageValue = "-1502857445"
   )
   public final class149 method2927(Runnable var1, int var2) {
      return this.method2934(2, var2, 0, var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass149;",
      garbageValue = "287672247"
   )
   public final class149 method2928(int var1) {
      return this.method2934(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass149;",
      garbageValue = "2028149187"
   )
   public final class149 method2929(URL var1) {
      return this.method2934(4, 0, 0, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass149;",
      garbageValue = "1019683736"
   )
   final class149 method2934(int var1, int var2, int var3, Object var4) {
      class149 var5 = new class149();
      var5.field2271 = var1;
      var5.field2272 = var2;
      var5.field2273 = var4;
      synchronized(this) {
         if(this.field2144 != null) {
            this.field2144.field2267 = var5;
            this.field2144 = var5;
         } else {
            this.field2144 = this.field2142 = var5;
         }

         this.notify();
         return var5;
      }
   }

   public final void run() {
      while(true) {
         class149 var1;
         synchronized(this) {
            while(true) {
               if(this.field2147) {
                  return;
               }

               if(null != this.field2142) {
                  var1 = this.field2142;
                  this.field2142 = this.field2142.field2267;
                  if(this.field2142 == null) {
                     this.field2144 = null;
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
            int var5 = var1.field2271;
            if(var5 == 1) {
               var1.field2270 = new Socket(InetAddress.getByName((String)var1.field2273), var1.field2272);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2273);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2272);
               var1.field2270 = var3;
            } else if(var5 == 4) {
               var1.field2270 = new DataInputStream(((URL)var1.field2273).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2272 >> 24 & 255) + "." + (var1.field2272 >> 16 & 255) + "." + (var1.field2272 >> 8 & 255) + "." + (var1.field2272 & 255);
               var1.field2270 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2266 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2266 = 2;
         }
      }
   }

   class139() {
      field2141 = "Unknown";
      field2138 = "1.1";

      try {
         field2141 = System.getProperty("java.vendor");
         field2138 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2137 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2147 = false;
      this.field2139 = new Thread(this);
      this.field2139.setPriority(10);
      this.field2139.setDaemon(true);
      this.field2139.start();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "869332755"
   )
   public static boolean method2942(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
