import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("Signlink")
public class Signlink implements Runnable {
   @ObfuscatedName("p")
   public static String field2242;
   @ObfuscatedName("m")
   public static String field2243;
   @ObfuscatedName("t")
   class153 field2244;
   @ObfuscatedName("w")
   Thread field2245;
   @ObfuscatedName("e")
   class153 field2246;
   @ObfuscatedName("z")
   boolean field2247;
   @ObfuscatedName("bi")
   static ModIcon field2253;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -1009143401
   )
   @Export("menuWidth")
   static int menuWidth;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LSpritePixels;",
      garbageValue = "1160240475"
   )
   public static SpritePixels method2820(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4055(var1);
      int var4 = var0.method4020(var3, var2);
      return class262.method4613(var0, var3, var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lclass153;",
      garbageValue = "86"
   )
   public final class153 method2822(Runnable var1, int var2) {
      return this.method2837(2, var2, 0, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1615873495"
   )
   public final void method2832() {
      synchronized(this) {
         this.field2247 = true;
         this.notifyAll();
      }

      try {
         this.field2245.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass153;",
      garbageValue = "1980716465"
   )
   public final class153 method2835(URL var1) {
      return this.method2837(4, 0, 0, var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass153;",
      garbageValue = "79089635"
   )
   final class153 method2837(int var1, int var2, int var3, Object var4) {
      class153 var5 = new class153();
      var5.field2236 = var1;
      var5.field2238 = var2;
      var5.field2240 = var4;
      synchronized(this) {
         if(this.field2244 != null) {
            this.field2244.field2233 = var5;
            this.field2244 = var5;
         } else {
            this.field2244 = this.field2246 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass153;",
      garbageValue = "-2092945627"
   )
   public final class153 method2838(int var1) {
      return this.method2837(3, var1, 0, (Object)null);
   }

   public final void run() {
      while(true) {
         class153 var1;
         synchronized(this) {
            while(true) {
               if(this.field2247) {
                  return;
               }

               if(this.field2246 != null) {
                  var1 = this.field2246;
                  this.field2246 = this.field2246.field2233;
                  if(this.field2246 == null) {
                     this.field2244 = null;
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
            int var2 = var1.field2236;
            if(var2 == 1) {
               var1.field2241 = new Socket(InetAddress.getByName((String)var1.field2240), var1.field2238);
            } else if(var2 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2240);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2238);
               var1.field2241 = var3;
            } else if(var2 == 4) {
               var1.field2241 = new DataInputStream(((URL)var1.field2240).openStream());
            } else if(var2 == 3) {
               String var9 = (var1.field2238 >> 24 & 255) + "." + (var1.field2238 >> 16 & 255) + "." + (var1.field2238 >> 8 & 255) + "." + (var1.field2238 & 255);
               var1.field2241 = InetAddress.getByName(var9).getHostName();
            }

            var1.status = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.status = 2;
         }
      }
   }

   public Signlink() {
      this.field2246 = null;
      this.field2244 = null;
      this.field2247 = false;
      field2242 = "Unknown";
      field2243 = "1.6";

      try {
         field2242 = System.getProperty("java.vendor");
         field2243 = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.field2247 = false;
      this.field2245 = new Thread(this);
      this.field2245.setPriority(10);
      this.field2245.setDaemon(true);
      this.field2245.start();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass153;",
      garbageValue = "-44"
   )
   public final class153 method2842(String var1, int var2) {
      return this.method2837(1, var2, 0, var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-1832867530"
   )
   static boolean method2843(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var9;
            if(var8 >= 48 && var8 <= 57) {
               var9 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var9 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var9 = var8 - 87;
            }

            if(var9 >= var1) {
               return false;
            }

            if(var3) {
               var9 = -var9;
            }

            int var10 = var5 * var1 + var9;
            if(var5 != var10 / var1) {
               return false;
            }

            var5 = var10;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
