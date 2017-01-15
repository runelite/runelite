import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("cc")
public class class103 implements Runnable {
   @ObfuscatedName("c")
   boolean field1653 = false;
   @ObfuscatedName("x")
   static String field1655;
   @ObfuscatedName("a")
   class102 field1656 = null;
   @ObfuscatedName("f")
   Thread field1657;
   @ObfuscatedName("d")
   public EventQueue field1659;
   @ObfuscatedName("u")
   static String field1661;
   @ObfuscatedName("i")
   class102 field1663 = null;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   final void method1913() {
      synchronized(this) {
         this.field1653 = true;
         this.notifyAll();
      }

      try {
         this.field1657.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1653) {
                  return;
               }

               if(this.field1663 != null) {
                  var1 = this.field1663;
                  this.field1663 = this.field1663.field1649;
                  if(this.field1663 == null) {
                     this.field1656 = null;
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
            int var2 = var1.field1647;
            if(var2 == 1) {
               var1.field1652 = new Socket(InetAddress.getByName((String)var1.field1651), var1.field1650);
            } else if(var2 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1651);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1650);
               var1.field1652 = var3;
            } else if(var2 == 4) {
               var1.field1652 = new DataInputStream(((URL)var1.field1651).openStream());
            } else if(var2 == 3) {
               String var9 = (var1.field1650 >> 24 & 255) + "." + (var1.field1650 >> 16 & 255) + "." + (var1.field1650 >> 8 & 255) + "." + (var1.field1650 & 255);
               var1.field1652 = InetAddress.getByName(var9).getHostName();
            }

            var1.field1648 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field1648 = 2;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass102;",
      garbageValue = "0"
   )
   public final class102 method1915(String var1, int var2) {
      return this.method1917(1, var2, 0, var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "883953458"
   )
   public final class102 method1916(Runnable var1, int var2) {
      return this.method1917(2, var2, 0, var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "1725847202"
   )
   final class102 method1917(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1647 = var1;
      var5.field1650 = var2;
      var5.field1651 = var4;
      synchronized(this) {
         if(this.field1656 != null) {
            this.field1656.field1649 = var5;
            this.field1656 = var5;
         } else {
            this.field1656 = this.field1663 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "517146181"
   )
   public final class102 method1918(URL var1) {
      return this.method1917(4, 0, 0, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lclass102;",
      garbageValue = "1281541309"
   )
   public final class102 method1926(int var1) {
      return this.method1917(3, var1, 0, (Object)null);
   }

   class103() {
      field1661 = "Unknown";
      field1655 = "1.1";

      try {
         field1661 = System.getProperty("java.vendor");
         field1655 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1659 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1653 = false;
      this.field1657 = new Thread(this);
      this.field1657.setPriority(10);
      this.field1657.setDaemon(true);
      this.field1657.start();
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1961006882"
   )
   static void method1935(String var0) {
      class217.field3167 = var0;

      try {
         String var1 = Client.field279.getParameter(class214.field3149.field3156);
         String var2 = Client.field279.getParameter(class214.field3154.field3156);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class168.method3162(class9.method117() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         Client var4 = Client.field279;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1595139967"
   )
   static final void method1936() {
      for(int var0 = 0; var0 < Client.field322; ++var0) {
         int var1 = Client.field483[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class31.method680(var2, var2.composition.field3007);
         }
      }

   }
}
