import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class103 implements Runnable {
   @ObfuscatedName("m")
   class102 field1666 = null;
   @ObfuscatedName("d")
   static String field1667;
   @ObfuscatedName("r")
   boolean field1669 = false;
   @ObfuscatedName("c")
   public EventQueue field1670;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1452603853
   )
   static int field1671;
   @ObfuscatedName("n")
   public static String field1672;
   @ObfuscatedName("w")
   Thread field1673;
   @ObfuscatedName("h")
   class102 field1674 = null;

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1669) {
                  return;
               }

               if(this.field1666 != null) {
                  var1 = this.field1666;
                  this.field1666 = this.field1666.field1655;
                  if(this.field1666 == null) {
                     this.field1674 = null;
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
               var1.field1663 = new Socket(InetAddress.getByName((String)var1.field1662), var1.field1659);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1662);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1659);
               var1.field1663 = var3;
            } else if(var5 == 4) {
               var1.field1663 = new DataInputStream(((URL)var1.field1662).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1659 >> 24 & 255) + "." + (var1.field1659 >> 16 & 255) + "." + (var1.field1659 >> 8 & 255) + "." + (var1.field1659 & 255);
               var1.field1663 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1661 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1661 = 2;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "1679520022"
   )
   final class102 method1993(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1660 = var1;
      var5.field1659 = var2;
      var5.field1662 = var4;
      synchronized(this) {
         if(this.field1674 != null) {
            this.field1674.field1655 = var5;
            this.field1674 = var5;
         } else {
            this.field1674 = this.field1666 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass102;",
      garbageValue = "-51"
   )
   public final class102 method1994(String var1, int var2) {
      return this.method1993(1, var2, 0, var1);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-1954293913"
   )
   static final void method1995(Actor var0, int var1) {
      int var3;
      int var4;
      int var5;
      if(var0.field648 > Client.gameCycle) {
         var5 = var0.field648 - Client.gameCycle;
         var3 = var0.field599 * 64 + var0.field637 * 128;
         var4 = var0.field599 * 64 + var0.field639 * 128;
         var0.x += (var3 - var0.x) / var5;
         var0.y += (var4 - var0.y) / var5;
         var0.field634 = 0;
         var0.field646 = var0.field643;
      } else if(var0.field642 >= Client.gameCycle) {
         Widget.method2836(var0);
      } else {
         class34.method732(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field648 = 0;
         var0.field642 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field599 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field599 * 64;
         var0.method617();
      }

      if(var0 == class40.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field648 = 0;
         var0.field642 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field599 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field599 * 64;
         var0.method617();
      }

      if(var0.field629 != 0) {
         if(var0.interacting != -1) {
            Object var2 = null;
            if(var0.interacting < '耀') {
               var2 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var2 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var2 != null) {
               var3 = var0.x - ((Actor)var2).x;
               var4 = var0.y - ((Actor)var2).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field646 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field622) {
               var0.interacting = -1;
               var0.field622 = false;
            }
         }

         if(var0.field623 != -1 && (var0.field649 == 0 || var0.field634 > 0)) {
            var0.field646 = var0.field623;
            var0.field623 = -1;
         }

         var5 = var0.field646 - var0.angle & 2047;
         if(var5 == 0 && var0.field622) {
            var0.interacting = -1;
            var0.field622 = false;
         }

         if(var5 != 0) {
            ++var0.field635;
            boolean var7;
            if(var5 > 1024) {
               var0.angle -= var0.field629;
               var7 = true;
               if(var5 < var0.field629 || var5 > 2048 - var0.field629) {
                  var0.angle = var0.field646;
                  var7 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field635 > 25 || var7)) {
                  if(var0.field601 != -1) {
                     var0.poseAnimation = var0.field601;
                  } else {
                     var0.poseAnimation = var0.field603;
                  }
               }
            } else {
               var0.angle += var0.field629;
               var7 = true;
               if(var5 < var0.field629 || var5 > 2048 - var0.field629) {
                  var0.angle = var0.field646;
                  var7 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field635 > 25 || var7)) {
                  if(var0.field604 != -1) {
                     var0.poseAnimation = var0.field604;
                  } else {
                     var0.poseAnimation = var0.field603;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field635 = 0;
         }
      }

      XItemContainer.method180(var0);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lclass102;",
      garbageValue = "-4879039"
   )
   public final class102 method1996(int var1) {
      return this.method1993(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "-1363542151"
   )
   public final class102 method1997(URL var1) {
      return this.method1993(4, 0, 0, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lclass102;",
      garbageValue = "72"
   )
   public final class102 method2000(Runnable var1, int var2) {
      return this.method1993(2, var2, 0, var1);
   }

   class103() {
      field1672 = "Unknown";
      field1667 = "1.1";

      try {
         field1672 = System.getProperty("java.vendor");
         field1667 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1670 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1669 = false;
      this.field1673 = new Thread(this);
      this.field1673.setPriority(10);
      this.field1673.setDaemon(true);
      this.field1673.start();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1796319269"
   )
   final void method2017() {
      synchronized(this) {
         this.field1669 = true;
         this.notifyAll();
      }

      try {
         this.field1673.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "1873816848"
   )
   static void method2018(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2076 == 0) {
         var0.width = var0.field2144;
      } else if(var0.field2076 == 1) {
         var0.width = var1 - var0.field2144;
      } else if(var0.field2076 == 2) {
         var0.width = var0.field2144 * var1 >> 14;
      }

      if(var0.field2077 == 0) {
         var0.height = var0.field2081;
      } else if(var0.field2077 == 1) {
         var0.height = var2 - var0.field2081;
      } else if(var0.field2077 == 2) {
         var0.height = var0.field2081 * var2 >> 14;
      }

      if(var0.field2076 == 4) {
         var0.width = var0.height * var0.field2061 / var0.field2138;
      }

      if(var0.field2077 == 4) {
         var0.height = var0.width * var0.field2138 / var0.field2061;
      }

      if(Client.field455 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field457 = var0;
      }

      if(var3 && var0.field2100 != null && (var4 != var0.width || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field192 = var0;
         var6.field196 = var0.field2100;
         Client.field484.method2454(var6);
      }

   }
}
