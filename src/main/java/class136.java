import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class136 implements Runnable {
   @ObfuscatedName("k")
   Thread field2091;
   @ObfuscatedName("w")
   static String field2092;
   @ObfuscatedName("d")
   class53 field2093;
   @ObfuscatedName("c")
   class146 field2094 = null;
   @ObfuscatedName("y")
   class146 field2095 = null;
   @ObfuscatedName("a")
   static String field2096;
   @ObfuscatedName("p")
   EventQueue field2098;
   @ObfuscatedName("r")
   boolean field2101 = false;

   class136() {
      field2096 = "Unknown";
      field2092 = "1.1";

      try {
         field2096 = System.getProperty("java.vendor");
         field2092 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2098 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2101 = false;
      this.field2091 = new Thread(this);
      this.field2091.setPriority(10);
      this.field2091.setDaemon(true);
      this.field2091.start();
   }

   public final void run() {
      while(true) {
         class146 var1;
         synchronized(this) {
            while(true) {
               if(this.field2101) {
                  return;
               }

               if(this.field2094 != null) {
                  var1 = this.field2094;
                  this.field2094 = this.field2094.field2206;
                  if(null == this.field2094) {
                     this.field2095 = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var7) {
                  ;
               }
            }
         }

         try {
            int var2 = var1.field2208;
            if(var2 == 1) {
               var1.field2211 = new Socket(InetAddress.getByName((String)var1.field2213), var1.field2212);
            } else if(2 == var2) {
               Thread var3 = new Thread((Runnable)var1.field2213);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2212);
               var1.field2211 = var3;
            } else if(4 == var2) {
               var1.field2211 = new DataInputStream(((URL)var1.field2213).openStream());
            } else if(3 == var2) {
               String var9 = (var1.field2212 >> 24 & 255) + "." + (var1.field2212 >> 16 & 255) + "." + (var1.field2212 >> 8 & 255) + "." + (var1.field2212 & 255);
               var1.field2211 = InetAddress.getByName(var9).getHostName();
            }

            var1.field2210 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field2210 = 2;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass146;",
      garbageValue = "2"
   )
   final class146 method2989(int var1, int var2, int var3, Object var4) {
      class146 var5 = new class146();
      var5.field2208 = var1;
      var5.field2212 = var2;
      var5.field2213 = var4;
      synchronized(this) {
         if(this.field2095 != null) {
            this.field2095.field2206 = var5;
            this.field2095 = var5;
         } else {
            this.field2095 = this.field2094 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass146;",
      garbageValue = "-671482803"
   )
   public final class146 method2990(String var1, int var2) {
      return this.method2989(1, var2, 0, var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass146;",
      garbageValue = "-581703623"
   )
   public final class146 method2991(Runnable var1, int var2) {
      return this.method2989(2, var2, 0, var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-110"
   )
   public static int method2992(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lclass53;",
      garbageValue = "-445280168"
   )
   public final class53 method2994() {
      return this.field2093;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1532921774"
   )
   final void method3007() {
      synchronized(this) {
         this.field2101 = true;
         this.notifyAll();
      }

      try {
         this.field2091.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IS)Lclass146;",
      garbageValue = "6821"
   )
   public final class146 method3008(int var1) {
      return this.method2989(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;S)Lclass146;",
      garbageValue = "128"
   )
   public final class146 method3011(URL var1) {
      return this.method2989(4, 0, 0, var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;IB)Lclass181;",
      garbageValue = "63"
   )
   static class181 method3014(class167 var0, int var1) {
      byte[] var2 = var0.method3414(var1);
      return var2 == null?null:new class181(var2);
   }
}
