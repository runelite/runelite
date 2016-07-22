import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class139 implements Runnable {
   @ObfuscatedName("w")
   static String field2143;
   @ObfuscatedName("e")
   class149 field2144 = null;
   @ObfuscatedName("o")
   class149 field2145 = null;
   @ObfuscatedName("l")
   boolean field2146 = false;
   @ObfuscatedName("m")
   public static String field2147;
   @ObfuscatedName("j")
   EventQueue field2148;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1013419509
   )
   public static int field2152;
   @ObfuscatedName("g")
   Thread field2154;
   @ObfuscatedName("bo")
   static class171 field2155;

   public final void run() {
      while(true) {
         class149 var1;
         synchronized(this) {
            while(true) {
               if(this.field2146) {
                  return;
               }

               if(this.field2144 != null) {
                  var1 = this.field2144;
                  this.field2144 = this.field2144.field2281;
                  if(null == this.field2144) {
                     this.field2145 = null;
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
            int var5 = var1.field2279;
            if(var5 == 1) {
               var1.field2282 = new Socket(InetAddress.getByName((String)var1.field2280), var1.field2275);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2280);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2275);
               var1.field2282 = var3;
            } else if(var5 == 4) {
               var1.field2282 = new DataInputStream(((URL)var1.field2280).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2275 >> 24 & 255) + "." + (var1.field2275 >> 16 & 255) + "." + (var1.field2275 >> 8 & 255) + "." + (var1.field2275 & 255);
               var1.field2282 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2278 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2278 = 2;
         }
      }
   }

   class139() {
      field2147 = "Unknown";
      field2143 = "1.1";

      try {
         field2147 = System.getProperty("java.vendor");
         field2143 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2148 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2146 = false;
      this.field2154 = new Thread(this);
      this.field2154.setPriority(10);
      this.field2154.setDaemon(true);
      this.field2154.start();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;B)Lclass149;",
      garbageValue = "-42"
   )
   final class149 method2935(int var1, int var2, int var3, Object var4) {
      class149 var5 = new class149();
      var5.field2279 = var1;
      var5.field2275 = var2;
      var5.field2280 = var4;
      synchronized(this) {
         if(null != this.field2145) {
            this.field2145.field2281 = var5;
            this.field2145 = var5;
         } else {
            this.field2145 = this.field2144 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass149;",
      garbageValue = "1631137782"
   )
   public final class149 method2936(String var1, int var2) {
      return this.method2935(1, var2, 0, var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass149;",
      garbageValue = "887798037"
   )
   public final class149 method2937(Runnable var1, int var2) {
      return this.method2935(2, var2, 0, var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "19207"
   )
   final void method2944() {
      synchronized(this) {
         this.field2146 = true;
         this.notifyAll();
      }

      try {
         this.field2154.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lclass149;",
      garbageValue = "-1389231458"
   )
   public final class149 method2947(int var1) {
      return this.method2935(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass149;",
      garbageValue = "709567583"
   )
   public final class149 method2957(URL var1) {
      return this.method2935(4, 0, 0, var1);
   }
}
