import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class139 implements Runnable {
   @ObfuscatedName("e")
   static String field2140;
   @ObfuscatedName("m")
   public EventQueue field2141;
   @ObfuscatedName("n")
   class149 field2142 = null;
   @ObfuscatedName("t")
   class149 field2143 = null;
   @ObfuscatedName("v")
   Thread field2144;
   @ObfuscatedName("b")
   boolean field2145 = false;
   @ObfuscatedName("f")
   public static String field2146;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = 1024295427
   )
   static int field2149;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 1364116625
   )
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1209715858"
   )
   final void method2906() {
      synchronized(this) {
         this.field2145 = true;
         this.notifyAll();
      }

      try {
         this.field2144.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass149;",
      garbageValue = "-1715622212"
   )
   final class149 method2908(int var1, int var2, int var3, Object var4) {
      class149 var5 = new class149();
      var5.field2264 = var1;
      var5.field2258 = var2;
      var5.field2260 = var4;
      synchronized(this) {
         if(this.field2143 != null) {
            this.field2143.field2265 = var5;
            this.field2143 = var5;
         } else {
            this.field2143 = this.field2142 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass149;",
      garbageValue = "1948121840"
   )
   public final class149 method2909(String var1, int var2) {
      return this.method2908(1, var2, 0, var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lclass149;",
      garbageValue = "-10"
   )
   public final class149 method2910(Runnable var1, int var2) {
      return this.method2908(2, var2, 0, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Lclass149;",
      garbageValue = "-1"
   )
   public final class149 method2911(int var1) {
      return this.method2908(3, var1, 0, (Object)null);
   }

   public final void run() {
      while(true) {
         class149 var1;
         synchronized(this) {
            while(true) {
               if(this.field2145) {
                  return;
               }

               if(null != this.field2142) {
                  var1 = this.field2142;
                  this.field2142 = this.field2142.field2265;
                  if(this.field2142 == null) {
                     this.field2143 = null;
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
            int var5 = var1.field2264;
            if(var5 == 1) {
               var1.field2266 = new Socket(InetAddress.getByName((String)var1.field2260), var1.field2258);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2260);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2258);
               var1.field2266 = var3;
            } else if(var5 == 4) {
               var1.field2266 = new DataInputStream(((URL)var1.field2260).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2258 >> 24 & 255) + "." + (var1.field2258 >> 16 & 255) + "." + (var1.field2258 >> 8 & 255) + "." + (var1.field2258 & 255);
               var1.field2266 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2262 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2262 = 2;
         }
      }
   }

   class139() {
      field2146 = "Unknown";
      field2140 = "1.1";

      try {
         field2146 = System.getProperty("java.vendor");
         field2140 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2141 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2145 = false;
      this.field2144 = new Thread(this);
      this.field2144.setPriority(10);
      this.field2144.setDaemon(true);
      this.field2144.start();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass149;",
      garbageValue = "-856717561"
   )
   public final class149 method2920(URL var1) {
      return this.method2908(4, 0, 0, var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-2137807791"
   )
   public static String method2929(CharSequence var0) {
      return class179.method3508('*', var0.length());
   }
}
