import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class103 implements Runnable {
   @ObfuscatedName("q")
   class102 field1669 = null;
   @ObfuscatedName("x")
   class102 field1670 = null;
   @ObfuscatedName("p")
   public static String field1671;
   @ObfuscatedName("d")
   Thread field1672;
   @ObfuscatedName("k")
   boolean field1673 = false;
   @ObfuscatedName("j")
   public EventQueue field1674;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1281499437
   )
   static int field1676;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -726035113
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("g")
   static String field1678;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16711680"
   )
   final void method1948() {
      synchronized(this) {
         this.field1673 = true;
         this.notifyAll();
      }

      try {
         this.field1672.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass102;",
      garbageValue = "-604433510"
   )
   public final class102 method1949(String var1, int var2) {
      return this.method1951(1, var2, 0, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "-1577486021"
   )
   final class102 method1951(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1660 = var1;
      var5.field1665 = var2;
      var5.field1666 = var4;
      synchronized(this) {
         if(null != this.field1669) {
            this.field1669.field1663 = var5;
            this.field1669 = var5;
         } else {
            this.field1669 = this.field1670 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)LFloorUnderlayDefinition;",
      garbageValue = "-37"
   )
   public static FloorUnderlayDefinition method1953(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2806.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.field2811.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(null != var2) {
            var1.method3476(new Buffer(var2), var0);
         }

         var1.method3477();
         FloorUnderlayDefinition.field2806.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass102;",
      garbageValue = "1896062786"
   )
   public final class102 method1954(int var1) {
      return this.method1951(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "-116309413"
   )
   public final class102 method1955(URL var1) {
      return this.method1951(4, 0, 0, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1398741385"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      Projectile.addChatMessage(var0, var1, var2, (String)null);
   }

   class103() {
      field1671 = "Unknown";
      field1678 = "1.1";

      try {
         field1671 = System.getProperty("java.vendor");
         field1678 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1674 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1673 = false;
      this.field1672 = new Thread(this);
      this.field1672.setPriority(10);
      this.field1672.setDaemon(true);
      this.field1672.start();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lclass102;",
      garbageValue = "127"
   )
   public final class102 method1968(Runnable var1, int var2) {
      return this.method1951(2, var2, 0, var1);
   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1673) {
                  return;
               }

               if(this.field1670 != null) {
                  var1 = this.field1670;
                  this.field1670 = this.field1670.field1663;
                  if(this.field1670 == null) {
                     this.field1669 = null;
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
            int var5 = var1.field1660;
            if(var5 == 1) {
               var1.field1664 = new Socket(InetAddress.getByName((String)var1.field1666), var1.field1665);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1666);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1665);
               var1.field1664 = var3;
            } else if(var5 == 4) {
               var1.field1664 = new DataInputStream(((URL)var1.field1666).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1665 >> 24 & 255) + "." + (var1.field1665 >> 16 & 255) + "." + (var1.field1665 >> 8 & 255) + "." + (var1.field1665 & 255);
               var1.field1664 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1667 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1667 = 2;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass139;B)Z",
      garbageValue = "0"
   )
   public static boolean method1971(class182 var0, class182 var1, class182 var2, class139 var3) {
      class138.field1919 = var0;
      Frames.field1571 = var1;
      class138.field1918 = var2;
      class138.field1920 = var3;
      return true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-358514306"
   )
   public static void method1972(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            Widget.field2281.method3338(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(null != Widget.widgets[var0][var2]) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "101"
   )
   public static boolean method1973(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2281.method3274(var0)) {
         return false;
      } else {
         int var1 = Widget.field2281.method3309(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.field2281.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3189(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3172(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
