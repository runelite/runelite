package net.runelite.rs.client;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ep")
public class class135 implements Runnable {
   @ObfuscatedName("l")
   class145 field2074 = null;
   @ObfuscatedName("u")
   class145 field2075 = null;
   @ObfuscatedName("a")
   Thread field2076;
   @ObfuscatedName("h")
   boolean field2077 = false;
   @ObfuscatedName("i")
   EventQueue field2078;
   @ObfuscatedName("m")
   static String field2080;
   @ObfuscatedName("f")
   class53 field2082;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 1944344261
   )
   static int field2084;
   @ObfuscatedName("j")
   static String field2089;

   @ObfuscatedName("f")
   public static boolean method2911() {
      try {
         if(2 == class182.field2940) {
            if(null == class147.field2213) {
               class147.field2213 = class179.method3566(class188.field3038, class182.field2945, class35.field778);
               if(null == class147.field2213) {
                  return false;
               }
            }

            if(null == class86.field1518) {
               class86.field1518 = new class59(class182.field2938, class182.field2937);
            }

            if(class182.field2943.method3654(class147.field2213, class182.field2939, class86.field1518, 22050)) {
               class182.field2943.method3744();
               class182.field2943.method3652(class182.field2942);
               class182.field2943.method3657(class147.field2213, class158.field2586);
               class182.field2940 = 0;
               class147.field2213 = null;
               class86.field1518 = null;
               class188.field3038 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class182.field2943.method3658();
         class182.field2940 = 0;
         class147.field2213 = null;
         class86.field1518 = null;
         class188.field3038 = null;
      }

      return false;
   }

   @ObfuscatedName("m")
   final void method2912() {
      synchronized(this) {
         this.field2077 = true;
         this.notifyAll();
      }

      try {
         this.field2076.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("f")
   final class145 method2914(int var1, int var2, Object var3) {
      class145 var4 = new class145();
      var4.field2201 = var1;
      var4.field2202 = var2;
      var4.field2203 = var3;
      synchronized(this) {
         if(this.field2075 != null) {
            this.field2075.field2197 = var4;
            this.field2075 = var4;
         } else {
            this.field2075 = this.field2074 = var4;
         }

         this.notify();
         return var4;
      }
   }

   @ObfuscatedName("l")
   public final class145 method2915(String var1, int var2) {
      return this.method2914(1, var2, var1);
   }

   class135() {
      field2089 = "Unknown";
      field2080 = "1.1";

      try {
         field2089 = System.getProperty("java.vendor");
         field2080 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2078 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2077 = false;
      this.field2076 = new Thread(this);
      this.field2076.setPriority(10);
      this.field2076.setDaemon(true);
      this.field2076.start();
   }

   @ObfuscatedName("a")
   public final class145 method2916(int var1) {
      return this.method2914(3, var1, (Object)null);
   }

   @ObfuscatedName("h")
   public final class145 method2917(URL var1) {
      return this.method2914(4, 0, var1);
   }

   public final void run() {
      while(true) {
         class145 var1;
         synchronized(this) {
            while(true) {
               if(this.field2077) {
                  return;
               }

               if(null != this.field2074) {
                  var1 = this.field2074;
                  this.field2074 = this.field2074.field2197;
                  if(this.field2074 == null) {
                     this.field2075 = null;
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
            int var2 = var1.field2201;
            if(var2 == 1) {
               var1.field2204 = new Socket(InetAddress.getByName((String)var1.field2203), var1.field2202);
            } else if(2 == var2) {
               Thread var3 = new Thread((Runnable)var1.field2203);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2202);
               var1.field2204 = var3;
            } else if(4 == var2) {
               var1.field2204 = new DataInputStream(((URL)var1.field2203).openStream());
            } else if(var2 == 3) {
               String var9 = (var1.field2202 >> 24 & 255) + "." + (var1.field2202 >> 16 & 255) + "." + (var1.field2202 >> 8 & 255) + "." + (var1.field2202 & 255);
               var1.field2204 = InetAddress.getByName(var9).getHostName();
            }

            var1.field2198 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field2198 = 2;
         }
      }
   }

   @ObfuscatedName("u")
   public final class145 method2919(Runnable var1, int var2) {
      return this.method2914(2, var2, var1);
   }

   @ObfuscatedName("i")
   public final class53 method2926() {
      return this.field2082;
   }

   @ObfuscatedName("z")
   static void method2935() {
      class76.field1366 = null;
      class76.field1370 = null;
      class76.field1371 = null;
      class76.field1373 = null;
      class76.field1369 = null;
      class17.field236 = (byte[][])null;
   }
}
