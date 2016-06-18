import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class136 implements Runnable {
   @ObfuscatedName("x")
   class146 field2072 = null;
   @ObfuscatedName("es")
   static class80[] field2073;
   @ObfuscatedName("d")
   class146 field2074 = null;
   @ObfuscatedName("c")
   EventQueue field2075;
   @ObfuscatedName("y")
   Thread field2076;
   @ObfuscatedName("r")
   boolean field2077 = false;
   @ObfuscatedName("j")
   class53 field2078;
   @ObfuscatedName("g")
   static String field2079;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1929356624"
   )
   final void method2914() {
      synchronized(this) {
         this.field2077 = true;
         this.notifyAll();
      }

      try {
         this.field2076.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class146 var1;
         synchronized(this) {
            while(true) {
               if(this.field2077) {
                  return;
               }

               if(null != this.field2074) {
                  var1 = this.field2074;
                  this.field2074 = this.field2074.field2195;
                  if(this.field2074 == null) {
                     this.field2072 = null;
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
            int var5 = var1.field2197;
            if(var5 == 1) {
               var1.field2201 = new Socket(InetAddress.getByName((String)var1.field2202), var1.field2200);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2202);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2200);
               var1.field2201 = var3;
            } else if(var5 == 4) {
               var1.field2201 = new DataInputStream(((URL)var1.field2202).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2200 >> 24 & 255) + "." + (var1.field2200 >> 16 & 255) + "." + (var1.field2200 >> 8 & 255) + "." + (var1.field2200 & 255);
               var1.field2201 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2199 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2199 = 2;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass146;",
      garbageValue = "-164308039"
   )
   final class146 method2915(int var1, int var2, int var3, Object var4) {
      class146 var5 = new class146();
      var5.field2197 = var1;
      var5.field2200 = var2;
      var5.field2202 = var4;
      synchronized(this) {
         if(null != this.field2072) {
            this.field2072.field2195 = var5;
            this.field2072 = var5;
         } else {
            this.field2072 = this.field2074 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass146;",
      garbageValue = "1345374396"
   )
   public final class146 method2916(String var1, int var2) {
      return this.method2915(1, var2, 0, var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass146;",
      garbageValue = "-1624084889"
   )
   public final class146 method2917(Runnable var1, int var2) {
      return this.method2915(2, var2, 0, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass53;",
      garbageValue = "-1386160025"
   )
   public final class53 method2920() {
      return this.field2078;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass146;",
      garbageValue = "52"
   )
   public final class146 method2925(URL var1) {
      return this.method2915(4, 0, 0, var1);
   }

   class136() {
      class26.field659 = "Unknown";
      field2079 = "1.1";

      try {
         class26.field659 = System.getProperty("java.vendor");
         field2079 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2075 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2077 = false;
      this.field2076 = new Thread(this);
      this.field2076.setPriority(10);
      this.field2076.setDaemon(true);
      this.field2076.start();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Lclass146;",
      garbageValue = "-21112964"
   )
   public final class146 method2928(int var1) {
      return this.method2915(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "154736345"
   )
   public static void method2941() {
      class47.field1042.method3755();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1753208840"
   )
   static void method2942(int var0) {
      class15 var1 = (class15)class15.field221.method3807((long)var0);
      if(null != var1) {
         var1.method3916();
      }
   }
}
