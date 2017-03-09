import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class103 implements Runnable {
   @ObfuscatedName("x")
   static String field1678;
   @ObfuscatedName("u")
   public EventQueue field1679;
   @ObfuscatedName("c")
   class102 field1680 = null;
   @ObfuscatedName("d")
   class102 field1681 = null;
   @ObfuscatedName("w")
   Thread field1682;
   @ObfuscatedName("h")
   boolean field1683 = false;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -917235917
   )
   static int field1685;
   @ObfuscatedName("j")
   static String field1687;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "854137622"
   )
   final void method2020() {
      synchronized(this) {
         this.field1683 = true;
         this.notifyAll();
      }

      try {
         this.field1682.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1683) {
                  return;
               }

               if(null != this.field1680) {
                  var1 = this.field1680;
                  this.field1680 = this.field1680.field1675;
                  if(this.field1680 == null) {
                     this.field1681 = null;
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
            int var5 = var1.field1674;
            if(var5 == 1) {
               var1.field1677 = new Socket(InetAddress.getByName((String)var1.field1670), var1.field1671);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1670);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1671);
               var1.field1677 = var3;
            } else if(var5 == 4) {
               var1.field1677 = new DataInputStream(((URL)var1.field1670).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1671 >> 24 & 255) + "." + (var1.field1671 >> 16 & 255) + "." + (var1.field1671 >> 8 & 255) + "." + (var1.field1671 & 255);
               var1.field1677 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1673 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1673 = 2;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "1988747726"
   )
   final class102 method2021(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1674 = var1;
      var5.field1671 = var2;
      var5.field1670 = var4;
      synchronized(this) {
         if(this.field1681 != null) {
            this.field1681.field1675 = var5;
            this.field1681 = var5;
         } else {
            this.field1681 = this.field1680 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass102;",
      garbageValue = "-977224098"
   )
   public final class102 method2022(String var1, int var2) {
      return this.method2021(1, var2, 0, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "-172835214"
   )
   public final class102 method2023(Runnable var1, int var2) {
      return this.method2021(2, var2, 0, var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)Lclass102;",
      garbageValue = "23"
   )
   public final class102 method2024(int var1) {
      return this.method2021(3, var1, 0, (Object)null);
   }

   class103() {
      field1678 = "Unknown";
      field1687 = "1.1";

      try {
         field1678 = System.getProperty("java.vendor");
         field1687 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1679 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1683 = false;
      this.field1682 = new Thread(this);
      this.field1682.setPriority(10);
      this.field1682.setDaemon(true);
      this.field1682.start();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "-2097271957"
   )
   public final class102 method2036(URL var1) {
      return this.method2021(4, 0, 0, var1);
   }

   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
   )
   protected static final void method2046() {
      class161.field2129.vmethod2107();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1783[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1784[var0] = 0L;
      }

      ItemLayer.field1226 = 0;
   }
}
