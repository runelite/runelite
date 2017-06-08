import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class154 implements Runnable {
   @ObfuscatedName("n")
   public static String field2241;
   @ObfuscatedName("p")
   public static String field2242;
   @ObfuscatedName("j")
   class153 field2244;
   @ObfuscatedName("i")
   class153 field2245;
   @ObfuscatedName("m")
   boolean field2246;
   @ObfuscatedName("pf")
   static class109 field2250;
   @ObfuscatedName("f")
   Thread field2251;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1806302161"
   )
   public final void method2934() {
      synchronized(this) {
         this.field2246 = true;
         this.notifyAll();
      }

      try {
         this.field2251.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class153 var1;
         synchronized(this) {
            while(true) {
               if(this.field2246) {
                  return;
               }

               if(this.field2245 != null) {
                  var1 = this.field2245;
                  this.field2245 = this.field2245.field2237;
                  if(this.field2245 == null) {
                     this.field2244 = null;
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
            int var5 = var1.field2238;
            if(var5 == 1) {
               var1.field2240 = new Socket(InetAddress.getByName((String)var1.field2239), var1.field2232);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2239);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2232);
               var1.field2240 = var3;
            } else if(var5 == 4) {
               var1.field2240 = new DataInputStream(((URL)var1.field2239).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2232 >> 24 & 255) + "." + (var1.field2232 >> 16 & 255) + "." + (var1.field2232 >> 8 & 255) + "." + (var1.field2232 & 255);
               var1.field2240 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2236 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2236 = 2;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass153;",
      garbageValue = "1458197384"
   )
   final class153 method2935(int var1, int var2, int var3, Object var4) {
      class153 var5 = new class153();
      var5.field2238 = var1;
      var5.field2232 = var2;
      var5.field2239 = var4;
      synchronized(this) {
         if(this.field2244 != null) {
            this.field2244.field2237 = var5;
            this.field2244 = var5;
         } else {
            this.field2244 = this.field2245 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass153;",
      garbageValue = "-1968697918"
   )
   public final class153 method2936(String var1, int var2) {
      return this.method2935(1, var2, 0, var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lclass153;",
      garbageValue = "-76"
   )
   public final class153 method2937(Runnable var1, int var2) {
      return this.method2935(2, var2, 0, var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass153;",
      garbageValue = "1151013592"
   )
   public final class153 method2938(int var1) {
      return this.method2935(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass153;",
      garbageValue = "-1293535908"
   )
   public final class153 method2946(URL var1) {
      return this.method2935(4, 0, 0, var1);
   }

   public class154() {
      this.field2245 = null;
      this.field2244 = null;
      this.field2246 = false;
      field2241 = "Unknown";
      field2242 = "1.6";

      try {
         field2241 = System.getProperty("java.vendor");
         field2242 = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.field2246 = false;
      this.field2251 = new Thread(this);
      this.field2251.setPriority(10);
      this.field2251.setDaemon(true);
      this.field2251.start();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZI)V",
      garbageValue = "-135689568"
   )
   public static void method2956(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.field3442 = var0;
      ObjectComposition.field3443 = var1;
      ObjectComposition.field3473 = var2;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass154;III)Lclass109;",
      garbageValue = "264609198"
   )
   public static final class109 method2957(class154 var0, int var1, int var2) {
      if(class109.field1633 == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            class109 var3 = class109.field1635.vmethod1901();
            var3.field1636 = new int[(class109.field1630?2:1) * 256];
            var3.field1641 = var2;
            var3.vmethod2001();
            var3.field1640 = (var2 & -1024) + 1024;
            if(var3.field1640 > 16384) {
               var3.field1640 = 16384;
            }

            var3.vmethod2002(var3.field1640);
            if(class71.field852 > 0 && class109.field1632 == null) {
               class109.field1632 = new class111();
               class51.field644 = Executors.newScheduledThreadPool(1);
               class51.field644.scheduleAtFixedRate(class109.field1632, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class109.field1632 != null) {
               if(class109.field1632.field1666[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class109.field1632.field1666[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new class109();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
