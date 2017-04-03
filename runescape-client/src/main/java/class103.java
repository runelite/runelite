import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class103 implements Runnable {
   @ObfuscatedName("o")
   boolean field1691 = false;
   @ObfuscatedName("i")
   static String field1692;
   @ObfuscatedName("u")
   class102 field1693 = null;
   @ObfuscatedName("h")
   class102 field1694 = null;
   @ObfuscatedName("r")
   Thread field1695;
   @ObfuscatedName("l")
   EventQueue field1696;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = -7226480058837029831L
   )
   static long field1698;
   @ObfuscatedName("f")
   static String field1700;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "102"
   )
   static void method2000(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class181 var4 = (class181)class185.field2762.method2417(var2);
      if(var4 != null) {
         class185.field2768.method2364(var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-838048203"
   )
   final void method2001() {
      synchronized(this) {
         this.field1691 = true;
         this.notifyAll();
      }

      try {
         this.field1695.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1691) {
                  return;
               }

               if(null != this.field1693) {
                  var1 = this.field1693;
                  this.field1693 = this.field1693.field1682;
                  if(this.field1693 == null) {
                     this.field1694 = null;
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
            int var5 = var1.field1687;
            if(var5 == 1) {
               var1.field1690 = new Socket(InetAddress.getByName((String)var1.field1689), var1.field1688);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1689);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1688);
               var1.field1690 = var3;
            } else if(var5 == 4) {
               var1.field1690 = new DataInputStream(((URL)var1.field1689).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1688 >> 24 & 255) + "." + (var1.field1688 >> 16 & 255) + "." + (var1.field1688 >> 8 & 255) + "." + (var1.field1688 & 255);
               var1.field1690 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1686 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1686 = 2;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IS)Lclass102;",
      garbageValue = "5401"
   )
   public final class102 method2003(String var1, int var2) {
      return this.method2026(1, var2, 0, var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "-761277578"
   )
   public final class102 method2004(Runnable var1, int var2) {
      return this.method2026(2, var2, 0, var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "-651703766"
   )
   public final class102 method2006(URL var1) {
      return this.method2026(4, 0, 0, var1);
   }

   class103() {
      field1700 = "Unknown";
      field1692 = "1.1";

      try {
         field1700 = System.getProperty("java.vendor");
         field1692 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1696 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1691 = false;
      this.field1695 = new Thread(this);
      this.field1695.setPriority(10);
      this.field1695.setDaemon(true);
      this.field1695.start();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass102;",
      garbageValue = "-782590900"
   )
   public final class102 method2011(int var1) {
      return this.method2026(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "20"
   )
   static final int method2025(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class10.tileHeights[var5][var3 + 1][var4] + (128 - var6) * class10.tileHeights[var5][var3][var4] >> 7;
         int var9 = class10.tileHeights[var5][var3][1 + var4] * (128 - var6) + var6 * class10.tileHeights[var5][var3 + 1][var4 + 1] >> 7;
         return (128 - var7) * var8 + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "-588180165"
   )
   final class102 method2026(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1687 = var1;
      var5.field1688 = var2;
      var5.field1689 = var4;
      synchronized(this) {
         if(this.field1694 != null) {
            this.field1694.field1682 = var5;
            this.field1694 = var5;
         } else {
            this.field1694 = this.field1693 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)[LSpritePixels;",
      garbageValue = "-963029477"
   )
   static SpritePixels[] method2027(IndexDataBase var0, int var1, int var2) {
      return !VertexNormal.method1667(var0, var1, var2)?null:class38.method767();
   }
}
