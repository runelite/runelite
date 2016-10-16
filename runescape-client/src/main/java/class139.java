import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class139 implements Runnable {
   @ObfuscatedName("g")
   boolean field2135 = false;
   @ObfuscatedName("z")
   static String field2136;
   @ObfuscatedName("s")
   public static String field2137;
   @ObfuscatedName("p")
   Thread field2139;
   @ObfuscatedName("t")
   class149 field2140 = null;
   @ObfuscatedName("m")
   public EventQueue field2141;
   @ObfuscatedName("y")
   class149 field2142 = null;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -1719692543
   )
   protected static int field2143;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-203614969"
   )
   static char method2875(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   public final void run() {
      while(true) {
         class149 var1;
         synchronized(this) {
            while(true) {
               if(this.field2135) {
                  return;
               }

               if(null != this.field2140) {
                  var1 = this.field2140;
                  this.field2140 = this.field2140.field2259;
                  if(this.field2140 == null) {
                     this.field2142 = null;
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
            int var5 = var1.field2258;
            if(var5 == 1) {
               var1.field2261 = new Socket(InetAddress.getByName((String)var1.field2253), var1.field2254);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2253);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2254);
               var1.field2261 = var3;
            } else if(var5 == 4) {
               var1.field2261 = new DataInputStream(((URL)var1.field2253).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2254 >> 24 & 255) + "." + (var1.field2254 >> 16 & 255) + "." + (var1.field2254 >> 8 & 255) + "." + (var1.field2254 & 255);
               var1.field2261 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2257 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2257 = 2;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass149;",
      garbageValue = "876087013"
   )
   final class149 method2876(int var1, int var2, int var3, Object var4) {
      class149 var5 = new class149();
      var5.field2258 = var1;
      var5.field2254 = var2;
      var5.field2253 = var4;
      synchronized(this) {
         if(this.field2142 != null) {
            this.field2142.field2259 = var5;
            this.field2142 = var5;
         } else {
            this.field2142 = this.field2140 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1461658040"
   )
   final void method2877() {
      synchronized(this) {
         this.field2135 = true;
         this.notifyAll();
      }

      try {
         this.field2139.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass149;",
      garbageValue = "-327978299"
   )
   public final class149 method2878(Runnable var1, int var2) {
      return this.method2876(2, var2, 0, var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass149;",
      garbageValue = "709779102"
   )
   public final class149 method2879(int var1) {
      return this.method2876(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass149;",
      garbageValue = "-1115173545"
   )
   public final class149 method2880(URL var1) {
      return this.method2876(4, 0, 0, var1);
   }

   class139() {
      field2137 = "Unknown";
      field2136 = "1.1";

      try {
         field2137 = System.getProperty("java.vendor");
         field2136 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2141 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2135 = false;
      this.field2139 = new Thread(this);
      this.field2139.setPriority(10);
      this.field2139.setDaemon(true);
      this.field2139.start();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass149;",
      garbageValue = "637651609"
   )
   public final class149 method2891(String var1, int var2) {
      return this.method2876(1, var2, 0, var1);
   }
}
