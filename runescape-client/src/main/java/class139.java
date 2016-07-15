import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class139 implements Runnable {
   @ObfuscatedName("c")
   class149 field2141 = null;
   @ObfuscatedName("r")
   Thread field2142;
   @ObfuscatedName("e")
   static String field2143;
   @ObfuscatedName("b")
   public EventQueue field2144;
   @ObfuscatedName("a")
   boolean field2146 = false;
   @ObfuscatedName("h")
   class149 field2148 = null;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "-799479164"
   )
   static final void method2992(class69 var0) {
      var0.field1336 = false;
      if(null != var0.field1333) {
         var0.field1333.field1332 = 0;
      }

      for(class69 var1 = var0.vmethod3803(); null != var1; var1 = var0.vmethod3804()) {
         method2992(var1);
      }

   }

   class139() {
      field2143 = "Unknown";
      class216.field3190 = "1.1";

      try {
         field2143 = System.getProperty("java.vendor");
         class216.field3190 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2144 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2146 = false;
      this.field2142 = new Thread(this);
      this.field2142.setPriority(10);
      this.field2142.setDaemon(true);
      this.field2142.start();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass149;",
      garbageValue = "-1897408118"
   )
   public final class149 method2994(String var1, int var2) {
      return this.method3008(1, var2, 0, var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lclass149;",
      garbageValue = "-1409262669"
   )
   public final class149 method2996(int var1) {
      return this.method3008(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass149;",
      garbageValue = "-1982507518"
   )
   public final class149 method2997(URL var1) {
      return this.method3008(4, 0, 0, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass149;",
      garbageValue = "-1060764632"
   )
   public final class149 method3005(Runnable var1, int var2) {
      return this.method3008(2, var2, 0, var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass149;",
      garbageValue = "-1425398505"
   )
   final class149 method3008(int var1, int var2, int var3, Object var4) {
      class149 var5 = new class149();
      var5.field2265 = var1;
      var5.field2266 = var2;
      var5.field2267 = var4;
      synchronized(this) {
         if(null != this.field2148) {
            this.field2148.field2261 = var5;
            this.field2148 = var5;
         } else {
            this.field2148 = this.field2141 = var5;
         }

         this.notify();
         return var5;
      }
   }

   public final void run() {
      while(true) {
         class149 var1;
         synchronized(this) {
            while(true) {
               if(this.field2146) {
                  return;
               }

               if(this.field2141 != null) {
                  var1 = this.field2141;
                  this.field2141 = this.field2141.field2261;
                  if(this.field2141 == null) {
                     this.field2148 = null;
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
            int var5 = var1.field2265;
            if(var5 == 1) {
               var1.field2260 = new Socket(InetAddress.getByName((String)var1.field2267), var1.field2266);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2267);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2266);
               var1.field2260 = var3;
            } else if(var5 == 4) {
               var1.field2260 = new DataInputStream(((URL)var1.field2267).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2266 >> 24 & 255) + "." + (var1.field2266 >> 16 & 255) + "." + (var1.field2266 >> 8 & 255) + "." + (var1.field2266 & 255);
               var1.field2260 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2264 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2264 = 2;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass156;",
      garbageValue = "1090478586"
   )
   public static class156 method3014(int var0) {
      class156[] var1 = class56.method1228();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class156 var3 = var1[var2];
         if(var3.field2327 == var0) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2070092951"
   )
   static final void method3015(int var0) {
      if(class10.method112(var0)) {
         class176[] var1 = class176.field2811[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class176 var3 = var1[var2];
            if(var3 != null) {
               var3.field2790 = 0;
               var3.field2917 = 0;
            }
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   final void method3016() {
      synchronized(this) {
         this.field2146 = true;
         this.notifyAll();
      }

      try {
         this.field2142.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1702720947"
   )
   static void method3017(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         class27 var8 = class118.field2032[var6];
         class118.field2032[var6] = class118.field2032[var1];
         class118.field2032[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            class27 var11 = class118.field2032[var9];
            int var12 = class17.method168(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class17.method168(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               class27 var14 = class118.field2032[var9];
               class118.field2032[var9] = class118.field2032[var7];
               class118.field2032[var7++] = var14;
            }
         }

         class118.field2032[var1] = class118.field2032[var7];
         class118.field2032[var7] = var8;
         method3017(var0, var7 - 1, var2, var3, var4, var5);
         method3017(1 + var7, var1, var2, var3, var4, var5);
      }

   }
}
