import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class103 implements Runnable {
   @ObfuscatedName("bd")
   static class184 field1665;
   @ObfuscatedName("m")
   static String field1666;
   @ObfuscatedName("b")
   class102 field1667 = null;
   @ObfuscatedName("g")
   class102 field1668 = null;
   @ObfuscatedName("l")
   EventQueue field1669;
   @ObfuscatedName("h")
   Thread field1672;
   @ObfuscatedName("i")
   static String[] field1677;
   @ObfuscatedName("o")
   static String field1678;
   @ObfuscatedName("v")
   boolean field1681 = false;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "1285630771"
   )
   final class102 method1915(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1661 = var1;
      var5.field1656 = var2;
      var5.field1663 = var4;
      synchronized(this) {
         if(this.field1668 != null) {
            this.field1668.field1660 = var5;
            this.field1668 = var5;
         } else {
            this.field1668 = this.field1667 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1718029935"
   )
   final void method1916() {
      synchronized(this) {
         this.field1681 = true;
         this.notifyAll();
      }

      try {
         this.field1672.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1681) {
                  return;
               }

               if(this.field1667 != null) {
                  var1 = this.field1667;
                  this.field1667 = this.field1667.field1660;
                  if(null == this.field1667) {
                     this.field1668 = null;
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
            int var5 = var1.field1661;
            if(var5 == 1) {
               var1.field1662 = new Socket(InetAddress.getByName((String)var1.field1663), var1.field1656);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1663);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1656);
               var1.field1662 = var3;
            } else if(var5 == 4) {
               var1.field1662 = new DataInputStream(((URL)var1.field1663).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1656 >> 24 & 255) + "." + (var1.field1656 >> 16 & 255) + "." + (var1.field1656 >> 8 & 255) + "." + (var1.field1656 & 255);
               var1.field1662 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1664 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1664 = 2;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass102;",
      garbageValue = "-83"
   )
   public final class102 method1918(String var1, int var2) {
      return this.method1915(1, var2, 0, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass102;",
      garbageValue = "-1779390698"
   )
   public final class102 method1920(int var1) {
      return this.method1915(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass102;",
      garbageValue = "-16"
   )
   public final class102 method1921(URL var1) {
      return this.method1915(4, 0, 0, var1);
   }

   class103() {
      field1678 = "Unknown";
      field1666 = "1.1";

      try {
         field1678 = System.getProperty("java.vendor");
         field1666 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1669 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1681 = false;
      this.field1672 = new Thread(this);
      this.field1672.setPriority(10);
      this.field1672.setDaemon(true);
      this.field1672.start();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "-1009911507"
   )
   public final class102 method1939(Runnable var1, int var2) {
      return this.method1915(2, var2, 0, var1);
   }
}
