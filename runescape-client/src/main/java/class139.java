import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class139 implements Runnable {
   @ObfuscatedName("ba")
   static class171 field2139;
   @ObfuscatedName("h")
   static String field2140;
   @ObfuscatedName("e")
   class149 field2141 = null;
   @ObfuscatedName("g")
   class149 field2142 = null;
   @ObfuscatedName("u")
   boolean field2143 = false;
   @ObfuscatedName("n")
   Thread field2144;
   @ObfuscatedName("d")
   public EventQueue field2148;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1239809060"
   )
   final void method2917() {
      synchronized(this) {
         this.field2143 = true;
         this.notifyAll();
      }

      try {
         this.field2144.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class149 var1;
         synchronized(this) {
            while(true) {
               if(this.field2143) {
                  return;
               }

               if(this.field2141 != null) {
                  var1 = this.field2141;
                  this.field2141 = this.field2141.field2267;
                  if(null == this.field2141) {
                     this.field2142 = null;
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
            int var5 = var1.field2266;
            if(var5 == 1) {
               var1.field2270 = new Socket(InetAddress.getByName((String)var1.field2269), var1.field2268);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2269);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2268);
               var1.field2270 = var3;
            } else if(var5 == 4) {
               var1.field2270 = new DataInputStream(((URL)var1.field2269).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2268 >> 24 & 255) + "." + (var1.field2268 >> 16 & 255) + "." + (var1.field2268 >> 8 & 255) + "." + (var1.field2268 & 255);
               var1.field2270 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2265 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2265 = 2;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass149;",
      garbageValue = "1648915111"
   )
   final class149 method2918(int var1, int var2, int var3, Object var4) {
      class149 var5 = new class149();
      var5.field2266 = var1;
      var5.field2268 = var2;
      var5.field2269 = var4;
      synchronized(this) {
         if(this.field2142 != null) {
            this.field2142.field2267 = var5;
            this.field2142 = var5;
         } else {
            this.field2142 = this.field2141 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass149;",
      garbageValue = "17"
   )
   public final class149 method2919(String var1, int var2) {
      return this.method2918(1, var2, 0, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass149;",
      garbageValue = "-1796618955"
   )
   public final class149 method2920(Runnable var1, int var2) {
      return this.method2918(2, var2, 0, var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass149;",
      garbageValue = "68"
   )
   public final class149 method2922(URL var1) {
      return this.method2918(4, 0, 0, var1);
   }

   class139() {
      class93.field1614 = "Unknown";
      field2140 = "1.1";

      try {
         class93.field1614 = System.getProperty("java.vendor");
         field2140 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2148 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2143 = false;
      this.field2144 = new Thread(this);
      this.field2144.setPriority(10);
      this.field2144.setDaemon(true);
      this.field2144.start();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass149;",
      garbageValue = "521181466"
   )
   public final class149 method2940(int var1) {
      return this.method2918(3, var1, 0, (Object)null);
   }
}
