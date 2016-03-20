import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ef")
public class class135 implements Runnable {
   @ObfuscatedName("a")
   public static String field2080;
   @ObfuscatedName("f")
   class53 field2081;
   @ObfuscatedName("s")
   class145 field2082 = null;
   @ObfuscatedName("y")
   class145 field2083 = null;
   @ObfuscatedName("e")
   Thread field2084;
   @ObfuscatedName("g")
   boolean field2085 = false;
   @ObfuscatedName("m")
   EventQueue field2086;

   @ObfuscatedName("g")
   public final class145 method2880(int var1) {
      return this.method2883(3, var1, (Object)null);
   }

   @ObfuscatedName("f")
   final void method2881() {
      synchronized(this) {
         this.field2085 = true;
         this.notifyAll();
      }

      try {
         this.field2084.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("s")
   public static class226 method2882(String var0, String var1, boolean var2) {
      File var3 = new File(class148.field2219, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class226 var10 = new class226(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class134.field2078 == 33) {
         var4 = "_rc";
      } else if(class134.field2078 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class140.field2161, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class226 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class226(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class226(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("s")
   final class145 method2883(int var1, int var2, Object var3) {
      class145 var4 = new class145();
      var4.field2198 = var1;
      var4.field2203 = var2;
      var4.field2205 = var3;
      synchronized(this) {
         if(null != this.field2083) {
            this.field2083.field2204 = var4;
            this.field2083 = var4;
         } else {
            this.field2083 = this.field2082 = var4;
         }

         this.notify();
         return var4;
      }
   }

   @ObfuscatedName("y")
   public final class145 method2884(String var1, int var2) {
      return this.method2883(1, var2, var1);
   }

   class135() {
      field2080 = "Unknown";
      class108.field1900 = "1.1";

      try {
         field2080 = System.getProperty("java.vendor");
         class108.field1900 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2086 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2085 = false;
      this.field2084 = new Thread(this);
      this.field2084.setPriority(10);
      this.field2084.setDaemon(true);
      this.field2084.start();
   }

   public final void run() {
      while(true) {
         class145 var1;
         synchronized(this) {
            while(true) {
               if(this.field2085) {
                  return;
               }

               if(this.field2082 != null) {
                  var1 = this.field2082;
                  this.field2082 = this.field2082.field2204;
                  if(this.field2082 == null) {
                     this.field2083 = null;
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
            int var2 = var1.field2198;
            if(var2 == 1) {
               var1.field2206 = new Socket(InetAddress.getByName((String)var1.field2205), var1.field2203);
            } else if(var2 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2205);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2203);
               var1.field2206 = var3;
            } else if(4 == var2) {
               var1.field2206 = new DataInputStream(((URL)var1.field2205).openStream());
            } else if(var2 == 3) {
               String var9 = (var1.field2203 >> 24 & 255) + "." + (var1.field2203 >> 16 & 255) + "." + (var1.field2203 >> 8 & 255) + "." + (var1.field2203 & 255);
               var1.field2206 = InetAddress.getByName(var9).getHostName();
            }

            var1.field2202 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field2202 = 2;
         }
      }
   }

   @ObfuscatedName("j")
   public final class53 method2886() {
      return this.field2081;
   }

   @ObfuscatedName("e")
   public final class145 method2893(Runnable var1, int var2) {
      return this.method2883(2, var2, var1);
   }

   @ObfuscatedName("m")
   public final class145 method2901(URL var1) {
      return this.method2883(4, 0, var1);
   }

   @ObfuscatedName("f")
   static void method2910(int var0, class133 var1, class167 var2) {
      byte[] var3 = null;
      class198 var4 = class169.field2696;
      synchronized(class169.field2696) {
         for(class168 var5 = (class168)class169.field2696.method3860(); null != var5; var5 = (class168)class169.field2696.method3861()) {
            if(var5.field3111 == (long)var0 && var5.field2689 == var1 && 0 == var5.field2688) {
               var3 = var5.field2687;
               break;
            }
         }
      }

      if(null != var3) {
         var2.method3361(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2872(var0);
         var2.method3361(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("a")
   public static boolean method2911(int var0) {
      return 0 != (var0 >> 20 & 1);
   }
}
