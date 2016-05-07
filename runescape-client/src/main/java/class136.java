import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class136 implements Runnable {
   @ObfuscatedName("ed")
   static class78[] field2105;
   @ObfuscatedName("p")
   class53 field2106;
   @ObfuscatedName("x")
   class146 field2107 = null;
   @ObfuscatedName("d")
   class146 field2108 = null;
   @ObfuscatedName("u")
   Thread field2109;
   @ObfuscatedName("o")
   boolean field2110 = false;
   @ObfuscatedName("b")
   EventQueue field2111;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 1828308017
   )
   protected static int field2114;
   @ObfuscatedName("s")
   public static String field2115;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lclass146;",
      garbageValue = "19"
   )
   public final class146 method2862(Runnable var1, int var2) {
      return this.method2863(2, var2, 0, var1);
   }

   public final void run() {
      while(true) {
         class146 var1;
         synchronized(this) {
            while(true) {
               if(this.field2110) {
                  return;
               }

               if(this.field2107 != null) {
                  var1 = this.field2107;
                  this.field2107 = this.field2107.field2227;
                  if(null == this.field2107) {
                     this.field2108 = null;
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
            int var2 = var1.field2222;
            if(var2 == 1) {
               var1.field2224 = new Socket(InetAddress.getByName((String)var1.field2229), var1.field2228);
            } else if(2 == var2) {
               Thread var3 = new Thread((Runnable)var1.field2229);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2228);
               var1.field2224 = var3;
            } else if(4 == var2) {
               var1.field2224 = new DataInputStream(((URL)var1.field2229).openStream());
            } else if(3 == var2) {
               String var9 = (var1.field2228 >> 24 & 255) + "." + (var1.field2228 >> 16 & 255) + "." + (var1.field2228 >> 8 & 255) + "." + (var1.field2228 & 255);
               var1.field2224 = InetAddress.getByName(var9).getHostName();
            }

            var1.field2226 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field2226 = 2;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass146;",
      garbageValue = "2"
   )
   final class146 method2863(int var1, int var2, int var3, Object var4) {
      class146 var5 = new class146();
      var5.field2222 = var1;
      var5.field2228 = var2;
      var5.field2229 = var4;
      synchronized(this) {
         if(this.field2108 != null) {
            this.field2108.field2227 = var5;
            this.field2108 = var5;
         } else {
            this.field2108 = this.field2107 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass146;",
      garbageValue = "-5"
   )
   public final class146 method2864(String var1, int var2) {
      return this.method2863(1, var2, 0, var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lclass146;",
      garbageValue = "407481602"
   )
   public final class146 method2866(int var1) {
      return this.method2863(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass146;",
      garbageValue = "-24"
   )
   public final class146 method2867(URL var1) {
      return this.method2863(4, 0, 0, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass53;",
      garbageValue = "1449927977"
   )
   public final class53 method2868() {
      return this.field2106;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1955064772"
   )
   final void method2880() {
      synchronized(this) {
         this.field2110 = true;
         this.notifyAll();
      }

      try {
         this.field2109.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   class136() {
      field2115 = "Unknown";
      class124.field2046 = "1.1";

      try {
         field2115 = System.getProperty("java.vendor");
         class124.field2046 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2111 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2110 = false;
      this.field2109 = new Thread(this);
      this.field2109.setPriority(10);
      this.field2109.setDaemon(true);
      this.field2109.start();
   }
}
