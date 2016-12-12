import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class103 implements Runnable {
   @ObfuscatedName("f")
   class102 field1655 = null;
   @ObfuscatedName("k")
   class102 field1656 = null;
   @ObfuscatedName("g")
   Thread field1657;
   @ObfuscatedName("n")
   boolean field1658 = false;
   @ObfuscatedName("a")
   EventQueue field1659;
   @ObfuscatedName("ad")
   static boolean field1662;
   @ObfuscatedName("e")
   static String field1663;
   @ObfuscatedName("i")
   public static String field1665;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Lclass102;",
      garbageValue = "3"
   )
   public final class102 method1928(int var1) {
      return this.method1950(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "-1883227748"
   )
   public final class102 method1929(URL var1) {
      return this.method1950(4, 0, 0, var1);
   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1658) {
                  return;
               }

               if(null != this.field1655) {
                  var1 = this.field1655;
                  this.field1655 = this.field1655.field1644;
                  if(this.field1655 == null) {
                     this.field1656 = null;
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
            int var5 = var1.field1649;
            if(var5 == 1) {
               var1.field1652 = new Socket(InetAddress.getByName((String)var1.field1651), var1.field1648);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1651);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1648);
               var1.field1652 = var3;
            } else if(var5 == 4) {
               var1.field1652 = new DataInputStream(((URL)var1.field1651).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1648 >> 24 & 255) + "." + (var1.field1648 >> 16 & 255) + "." + (var1.field1648 >> 8 & 255) + "." + (var1.field1648 & 255);
               var1.field1652 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1650 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1650 = 2;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   final void method1930() {
      synchronized(this) {
         this.field1658 = true;
         this.notifyAll();
      }

      try {
         this.field1657.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass102;",
      garbageValue = "1891441947"
   )
   public final class102 method1931(String var1, int var2) {
      return this.method1950(1, var2, 0, var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "1661425883"
   )
   public final class102 method1932(Runnable var1, int var2) {
      return this.method1950(2, var2, 0, var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1117867479"
   )
   static final void method1933(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class10.field92[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var1 + var3 == var4 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }

   class103() {
      field1665 = "Unknown";
      field1663 = "1.1";

      try {
         field1665 = System.getProperty("java.vendor");
         field1663 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1659 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1658 = false;
      this.field1657 = new Thread(this);
      this.field1657.setPriority(10);
      this.field1657.setDaemon(true);
      this.field1657.start();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "-1048037033"
   )
   final class102 method1950(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1649 = var1;
      var5.field1648 = var2;
      var5.field1651 = var4;
      synchronized(this) {
         if(this.field1656 != null) {
            this.field1656.field1644 = var5;
            this.field1656 = var5;
         } else {
            this.field1656 = this.field1655 = var5;
         }

         this.notify();
         return var5;
      }
   }
}
