import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class103 implements Runnable {
   @ObfuscatedName("d")
   static String field1659;
   @ObfuscatedName("n")
   class102 field1660 = null;
   @ObfuscatedName("q")
   class102 field1661 = null;
   @ObfuscatedName("t")
   Thread field1662;
   @ObfuscatedName("p")
   boolean field1663 = false;
   @ObfuscatedName("u")
   EventQueue field1664;
   @ObfuscatedName("c")
   static String field1668;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)Ljava/lang/String;",
      garbageValue = "7603"
   )
   public static String method1963(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(var7 + 1 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(var7 + 27 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(var3 % 37L == 0L && var3 != 0L) {
         var3 /= 37L;
      }

      String var8 = XItemContainer.method175(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "2102499614"
   )
   static int method1964(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class200.field2894:Script.field942;
      if(var0 == 1500) {
         class32.field720[++class32.field715 - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class32.field720[++class32.field715 - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class32.field720[++class32.field715 - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class32.field720[++class32.field715 - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class32.field720[++class32.field715 - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class32.field720[++class32.field715 - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "232413472"
   )
   final class102 method1966(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1649 = var1;
      var5.field1655 = var2;
      var5.field1656 = var4;
      synchronized(this) {
         if(this.field1661 != null) {
            this.field1661.field1654 = var5;
            this.field1661 = var5;
         } else {
            this.field1661 = this.field1660 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "1868039995"
   )
   public final class102 method1968(Runnable var1, int var2) {
      return this.method1966(2, var2, 0, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass102;",
      garbageValue = "2007315192"
   )
   public final class102 method1969(int var1) {
      return this.method1966(3, var1, 0, (Object)null);
   }

   class103() {
      field1659 = "Unknown";
      field1668 = "1.1";

      try {
         field1659 = System.getProperty("java.vendor");
         field1668 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1664 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1663 = false;
      this.field1662 = new Thread(this);
      this.field1662.setPriority(10);
      this.field1662.setDaemon(true);
      this.field1662.start();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass102;",
      garbageValue = "0"
   )
   public final class102 method1975(String var1, int var2) {
      return this.method1966(1, var2, 0, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-13902"
   )
   final void method1976() {
      synchronized(this) {
         this.field1663 = true;
         this.notifyAll();
      }

      try {
         this.field1662.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1663) {
                  return;
               }

               if(this.field1660 != null) {
                  var1 = this.field1660;
                  this.field1660 = this.field1660.field1654;
                  if(this.field1660 == null) {
                     this.field1661 = null;
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
               var1.field1657 = new Socket(InetAddress.getByName((String)var1.field1656), var1.field1655);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1656);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1655);
               var1.field1657 = var3;
            } else if(var5 == 4) {
               var1.field1657 = new DataInputStream(((URL)var1.field1656).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1655 >> 24 & 255) + "." + (var1.field1655 >> 16 & 255) + "." + (var1.field1655 >> 8 & 255) + "." + (var1.field1655 & 255);
               var1.field1657 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1653 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1653 = 2;
         }
      }
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "-506523012"
   )
   static int method1988(Widget var0) {
      class154 var1 = (class154)Client.widgetFlags.method2773(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.field2046:var0.field2237;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-567226845"
   )
   static int method1990(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class32.field715 -= 2;
         var3 = class32.field720[class32.field715];
         int var4 = class32.field720[class32.field715 + 1];
         if(!Client.field534) {
            Client.field366 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class32.field720[++class32.field715 - 1] = Client.field366;
         return 1;
      } else if(var0 == 5506) {
         class32.field720[++class32.field715 - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class32.field720[--class32.field715];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field372 = var3;
         return 1;
      } else if(var0 == 5531) {
         class32.field720[++class32.field715 - 1] = Client.field372;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "-1061094493"
   )
   public final class102 method1991(URL var1) {
      return this.method1966(4, 0, 0, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1635277223"
   )
   public static String method1992(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "421462965"
   )
   static final void method1993(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class44.field882[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
