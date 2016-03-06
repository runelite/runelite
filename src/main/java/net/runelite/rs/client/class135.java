import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
public class class135 implements Runnable {
   @ObfuscatedName("l")
   static String field2090;
   @ObfuscatedName("j")
   static String field2091;
   @ObfuscatedName("a")
   class53 field2092;
   @ObfuscatedName("i")
   class145 field2093 = null;
   @ObfuscatedName("m")
   Thread field2095;
   @ObfuscatedName("o")
   boolean field2096 = false;
   @ObfuscatedName("h")
   public EventQueue field2097;
   @ObfuscatedName("dy")
   static int[][] field2100;
   @ObfuscatedName("mr")
   @Export("clanMembers")
   static class24[] field2103;
   @ObfuscatedName("f")
   class145 field2106 = null;

   @ObfuscatedName("i")
   final void method2809() {
      synchronized(this) {
         this.field2096 = true;
         this.notifyAll();
      }

      try {
         this.field2095.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class145 var1;
         synchronized(this) {
            while(true) {
               if(this.field2096) {
                  return;
               }

               if(this.field2093 != null) {
                  var1 = this.field2093;
                  this.field2093 = this.field2093.field2226;
                  if(null == this.field2093) {
                     this.field2106 = null;
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
            int var2 = var1.field2218;
            if(1 == var2) {
               var1.field2223 = new Socket(InetAddress.getByName((String)var1.field2225), var1.field2224);
            } else if(2 == var2) {
               Thread var3 = new Thread((Runnable)var1.field2225);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2224);
               var1.field2223 = var3;
            } else if(var2 == 4) {
               var1.field2223 = new DataInputStream(((URL)var1.field2225).openStream());
            } else if(3 == var2) {
               String var9 = (var1.field2224 >> 24 & 255) + "." + (var1.field2224 >> 16 & 255) + "." + (var1.field2224 >> 8 & 255) + "." + (var1.field2224 & 255);
               var1.field2223 = InetAddress.getByName(var9).getHostName();
            }

            var1.field2222 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field2222 = 2;
         }
      }
   }

   @ObfuscatedName("h")
   public final class145 method2810(int var1) {
      return this.method2828(3, var1, (Object)null);
   }

   @ObfuscatedName("m")
   public final class145 method2811(String var1, int var2) {
      return this.method2828(1, var2, var1);
   }

   @ObfuscatedName("an")
   static final void method2812(class33 var0) {
      if(client.field296 == class148.field2249.field839 >> 7 && client.field319 == class148.field2249.field848 >> 7) {
         client.field296 = 0;
      }

      int var1 = class32.field749;
      int[] var2 = class32.field755;
      int var3 = var1;
      if(class33.field765 == var0 || class33.field769 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(var0 == class33.field765) {
            var5 = class148.field2249;
            var6 = class148.field2249.field56 << 14;
         } else if(var0 == class33.field769) {
            var5 = client.field410[client.field419];
            var6 = client.field419 << 14;
         } else {
            var5 = client.field410[var2[var4]];
            var6 = var2[var4] << 14;
            if(class33.field767 == var0 && client.field419 == var2[var4]) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod753() && !var5.field54) {
            var5.field58 = false;
            if((client.field457 && var1 > 50 || var1 > 200) && class33.field765 != var0 && var5.field838 == var5.field815) {
               var5.field58 = true;
            }

            int var7 = var5.field839 >> 7;
            int var8 = var5.field848 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.field47 != null && client.field394 >= var5.field43 && client.field394 < var5.field52) {
                  var5.field58 = false;
                  var5.field42 = class105.method2335(var5.field839, var5.field848, class75.field1386);
                  class107.field1906.method1887(class75.field1386, var5.field839, var5.field848, var5.field42, var5, var5.field852, var6, var5.field59, var5.field33, var5.field50, var5.field51);
               } else {
                  if(64 == (var5.field839 & 127) && 64 == (var5.field848 & 127)) {
                     if(client.field393[var7][var8] == client.field407) {
                        continue;
                     }

                     client.field393[var7][var8] = client.field407;
                  }

                  var5.field42 = class105.method2335(var5.field839, var5.field848, class75.field1386);
                  class107.field1906.method1886(class75.field1386, var5.field839, var5.field848, var5.field42, 60, var5, var5.field852, var6, var5.field813);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   public final class145 method2814(URL var1) {
      return this.method2828(4, 0, var1);
   }

   @ObfuscatedName("k")
   public final class53 method2815() {
      return this.field2092;
   }

   @ObfuscatedName("f")
   final class145 method2828(int var1, int var2, Object var3) {
      class145 var4 = new class145();
      var4.field2218 = var1;
      var4.field2224 = var2;
      var4.field2225 = var3;
      synchronized(this) {
         if(this.field2106 != null) {
            this.field2106.field2226 = var4;
            this.field2106 = var4;
         } else {
            this.field2106 = this.field2093 = var4;
         }

         this.notify();
         return var4;
      }
   }

   class135() {
      field2091 = "Unknown";
      field2090 = "1.1";

      try {
         field2091 = System.getProperty("java.vendor");
         field2090 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2097 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2096 = false;
      this.field2095 = new Thread(this);
      this.field2095.setPriority(10);
      this.field2095.setDaemon(true);
      this.field2095.start();
   }

   @ObfuscatedName("o")
   public final class145 method2833(Runnable var1, int var2) {
      return this.method2828(2, var2, var1);
   }

   @ObfuscatedName("de")
   static String method2838(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(client.field288 == 1) {
         var0 = var0 + "-wtrc";
      } else if(client.field288 == 2) {
         var0 = var0 + "-wtqa";
      } else if(client.field288 == 3) {
         var0 = var0 + "-wtwip";
      } else if(client.field288 == 5) {
         var0 = var0 + "-wti";
      } else if(client.field288 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class95.field1639 != null) {
         var3 = "/p=" + class95.field1639;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field472 + "/a=" + class24.field624 + var3 + "/";
   }
}
