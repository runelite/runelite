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

@ObfuscatedName("ci")
public class class103 implements Runnable {
   @ObfuscatedName("g")
   boolean field1668 = false;
   @ObfuscatedName("c")
   static String field1669;
   @ObfuscatedName("s")
   public static String field1670;
   @ObfuscatedName("a")
   Thread field1671;
   @ObfuscatedName("h")
   class102 field1673 = null;
   @ObfuscatedName("k")
   EventQueue field1674;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1910843469
   )
   static int field1678;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 1701681825
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("f")
   class102 field1680 = null;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "82"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class167.field2194 = null;
            Friend.field164 = null;
            GameEngine.field1787 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field327 = 0;
            Client.field328 = 0;
            Client.field329 = 0;
         }

         if(var0 != 20 && var0 != 40 && ItemComposition.field3003 != null) {
            ItemComposition.field3003.method2006();
            ItemComposition.field3003 = null;
         }

         if(Client.gameState == 25) {
            Client.field528 = 0;
            Client.field348 = 0;
            Client.field349 = 1;
            Client.field350 = 0;
            Client.field351 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class30.method647(class25.canvas, class108.field1736, class40.field807, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class30.method647(class25.canvas, class108.field1736, class40.field807, false, 4);
            } else {
               class30.method649();
            }
         } else {
            class30.method647(class25.canvas, class108.field1736, class40.field807, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "-1779982962"
   )
   final class102 method1910(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1662 = var1;
      var5.field1665 = var2;
      var5.field1659 = var4;
      synchronized(this) {
         if(null != this.field1673) {
            this.field1673.field1667 = var5;
            this.field1673 = var5;
         } else {
            this.field1673 = this.field1680 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass102;",
      garbageValue = "1437847369"
   )
   public final class102 method1911(String var1, int var2) {
      return this.method1910(1, var2, 0, var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "563860186"
   )
   public final class102 method1912(Runnable var1, int var2) {
      return this.method1910(2, var2, 0, var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Lclass102;",
      garbageValue = "-74"
   )
   public final class102 method1913(int var1) {
      return this.method1910(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass102;",
      garbageValue = "28"
   )
   public final class102 method1914(URL var1) {
      return this.method1910(4, 0, 0, var1);
   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1668) {
                  return;
               }

               if(null != this.field1680) {
                  var1 = this.field1680;
                  this.field1680 = this.field1680.field1667;
                  if(this.field1680 == null) {
                     this.field1673 = null;
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
            int var5 = var1.field1662;
            if(var5 == 1) {
               var1.field1666 = new Socket(InetAddress.getByName((String)var1.field1659), var1.field1665);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1659);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1665);
               var1.field1666 = var3;
            } else if(var5 == 4) {
               var1.field1666 = new DataInputStream(((URL)var1.field1659).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1665 >> 24 & 255) + "." + (var1.field1665 >> 16 & 255) + "." + (var1.field1665 >> 8 & 255) + "." + (var1.field1665 & 255);
               var1.field1666 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1663 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1663 = 2;
         }
      }
   }

   class103() {
      field1670 = "Unknown";
      field1669 = "1.1";

      try {
         field1670 = System.getProperty("java.vendor");
         field1669 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1674 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1668 = false;
      this.field1671 = new Thread(this);
      this.field1671.setPriority(10);
      this.field1671.setDaemon(true);
      this.field1671.start();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "296135202"
   )
   static final void method1927(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class38.field794.field699 = !class38.field794.field699;
         PlayerComposition.method3057();
         if(class38.field794.field699) {
            Player.method220(99, "", "Roofs are now all hidden");
         } else {
            Player.method220(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field309 = !Client.field309;
      }

      if(Client.field458 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            Client.field309 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field309 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class105.method1961();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field297 == 2) {
            throw new RuntimeException();
         }
      }

      Client.field336.method2963(11);
      Client.field336.method2708(var0.length() + 1);
      Client.field336.method2714(var0);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1194991238"
   )
   final void method1931() {
      synchronized(this) {
         this.field1668 = true;
         this.notifyAll();
      }

      try {
         this.field1671.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "197376925"
   )
   static final void method1933(class159 var0) {
      var0.method2982();
      int var1 = Client.localInteractingIndex;
      Player var2 = XItemContainer.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field278 = var1;
      int var3 = var0.method2973(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class22.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method195() << 6);
      var2.pathY[0] = var6 - baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method195() << 6);
      class118.plane = var2.field277 = var4;
      if(class45.field893[var1] != null) {
         var2.method212(class45.field893[var1]);
      }

      class45.field894 = 0;
      class45.field896[++class45.field894 - 1] = var1;
      class45.field891[var1] = 0;
      class45.field902 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2973(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class45.field898[var7] = (var10 << 14) + (var9 << 28) + var11;
            class45.field899[var7] = 0;
            class45.field900[var7] = -1;
            class45.field897[++class45.field902 - 1] = var7;
            class45.field891[var7] = 0;
         }
      }

      var0.method2967();
   }
}
