import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class139 implements Runnable {
   @ObfuscatedName("h")
   Thread field2145;
   @ObfuscatedName("g")
   static String field2146;
   @ObfuscatedName("r")
   class149 field2149 = null;
   @ObfuscatedName("s")
   boolean field2150 = false;
   @ObfuscatedName("k")
   public EventQueue field2151;
   @ObfuscatedName("l")
   static String field2152;
   @ObfuscatedName("e")
   class149 field2153 = null;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "191560590"
   )
   final void method3026() {
      synchronized(this) {
         this.field2150 = true;
         this.notifyAll();
      }

      try {
         this.field2145.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class149 var1;
         synchronized(this) {
            while(true) {
               if(this.field2150) {
                  return;
               }

               if(this.field2149 != null) {
                  var1 = this.field2149;
                  this.field2149 = this.field2149.field2279;
                  if(this.field2149 == null) {
                     this.field2153 = null;
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
            int var5 = var1.field2275;
            if(var5 == 1) {
               var1.field2272 = new Socket(InetAddress.getByName((String)var1.field2274), var1.field2278);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2274);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2278);
               var1.field2272 = var3;
            } else if(var5 == 4) {
               var1.field2272 = new DataInputStream(((URL)var1.field2274).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2278 >> 24 & 255) + "." + (var1.field2278 >> 16 & 255) + "." + (var1.field2278 >> 8 & 255) + "." + (var1.field2278 & 255);
               var1.field2272 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2276 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2276 = 2;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass149;",
      garbageValue = "-1536904006"
   )
   final class149 method3027(int var1, int var2, int var3, Object var4) {
      class149 var5 = new class149();
      var5.field2275 = var1;
      var5.field2278 = var2;
      var5.field2274 = var4;
      synchronized(this) {
         if(this.field2153 != null) {
            this.field2153.field2279 = var5;
            this.field2153 = var5;
         } else {
            this.field2153 = this.field2149 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass149;",
      garbageValue = "7"
   )
   public final class149 method3028(String var1, int var2) {
      return this.method3027(1, var2, 0, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass149;",
      garbageValue = "-883965180"
   )
   public final class149 method3029(Runnable var1, int var2) {
      return this.method3027(2, var2, 0, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass149;",
      garbageValue = "-13"
   )
   public final class149 method3031(URL var1) {
      return this.method3027(4, 0, 0, var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2080042332"
   )
   public static void method3032() {
      if(field2152.toLowerCase().indexOf("microsoft") != -1) {
         class140.field2183[186] = 57;
         class140.field2183[187] = 27;
         class140.field2183[188] = 71;
         class140.field2183[189] = 26;
         class140.field2183[190] = 72;
         class140.field2183[191] = 73;
         class140.field2183[192] = 58;
         class140.field2183[219] = 42;
         class140.field2183[220] = 74;
         class140.field2183[221] = 43;
         class140.field2183[222] = 59;
         class140.field2183[223] = 28;
      } else {
         class140.field2183[44] = 71;
         class140.field2183[45] = 26;
         class140.field2183[46] = 72;
         class140.field2183[47] = 73;
         class140.field2183[59] = 57;
         class140.field2183[61] = 27;
         class140.field2183[91] = 42;
         class140.field2183[92] = 74;
         class140.field2183[93] = 43;
         class140.field2183[192] = 28;
         class140.field2183[222] = 58;
         class140.field2183[520] = 59;
      }

   }

   class139() {
      field2152 = "Unknown";
      field2146 = "1.1";

      try {
         field2152 = System.getProperty("java.vendor");
         field2146 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2151 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2150 = false;
      this.field2145 = new Thread(this);
      this.field2145.setPriority(10);
      this.field2145.setDaemon(true);
      this.field2145.start();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lclass149;",
      garbageValue = "-1979322161"
   )
   public final class149 method3046(int var1) {
      return this.method3027(3, var1, 0, (Object)null);
   }
}
