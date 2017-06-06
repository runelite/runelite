import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class154 implements Runnable {
   @ObfuscatedName("b")
   Thread field2249;
   @ObfuscatedName("c")
   public static String field2250;
   @ObfuscatedName("e")
   class153 field2251;
   @ObfuscatedName("v")
   class153 field2252;
   @ObfuscatedName("i")
   public static String field2254;
   @ObfuscatedName("y")
   boolean field2256;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "784551189"
   )
   public final void method2933() {
      synchronized(this) {
         this.field2256 = true;
         this.notifyAll();
      }

      try {
         this.field2249.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class153 var1;
         synchronized(this) {
            while(true) {
               if(this.field2256) {
                  return;
               }

               if(this.field2251 != null) {
                  var1 = this.field2251;
                  this.field2251 = this.field2251.field2245;
                  if(this.field2251 == null) {
                     this.field2252 = null;
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
            int var5 = var1.field2240;
            if(var5 == 1) {
               var1.field2248 = new Socket(InetAddress.getByName((String)var1.field2242), var1.field2246);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2242);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2246);
               var1.field2248 = var3;
            } else if(var5 == 4) {
               var1.field2248 = new DataInputStream(((URL)var1.field2242).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2246 >> 24 & 255) + "." + (var1.field2246 >> 16 & 255) + "." + (var1.field2246 >> 8 & 255) + "." + (var1.field2246 & 255);
               var1.field2248 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2244 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2244 = 2;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass153;",
      garbageValue = "-100"
   )
   public final class153 method2935(String var1, int var2) {
      return this.method2939(1, var2, 0, var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lclass153;",
      garbageValue = "-90"
   )
   public final class153 method2936(Runnable var1, int var2) {
      return this.method2939(2, var2, 0, var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lclass153;",
      garbageValue = "923077137"
   )
   public final class153 method2937(int var1) {
      return this.method2939(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass153;",
      garbageValue = "954296804"
   )
   final class153 method2939(int var1, int var2, int var3, Object var4) {
      class153 var5 = new class153();
      var5.field2240 = var1;
      var5.field2246 = var2;
      var5.field2242 = var4;
      synchronized(this) {
         if(this.field2252 != null) {
            this.field2252.field2245 = var5;
            this.field2252 = var5;
         } else {
            this.field2252 = this.field2251 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "48"
   )
   static World method2943() {
      World.field1322 = 0;
      return class8.method32();
   }

   public class154() {
      this.field2251 = null;
      this.field2252 = null;
      this.field2256 = false;
      field2254 = "Unknown";
      field2250 = "1.6";

      try {
         field2254 = System.getProperty("java.vendor");
         field2250 = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.field2256 = false;
      this.field2249 = new Thread(this);
      this.field2249.setPriority(10);
      this.field2249.setDaemon(true);
      this.field2249.start();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass153;",
      garbageValue = "108"
   )
   public final class153 method2954(URL var1) {
      return this.method2939(4, 0, 0, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass289;I)Ljava/lang/String;",
      garbageValue = "1635732504"
   )
   public static String method2955(CharSequence var0, class289 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && ItemLayer.method2395(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && ItemLayer.method2395(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= class54.method776(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else {
                  boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                  if(var9) {
                     var8 = true;
                  } else {
                     char[] var10 = class267.field3666;
                     int var11 = 0;

                     label124:
                     while(true) {
                        char var12;
                        if(var11 >= var10.length) {
                           var10 = class267.field3665;

                           for(var11 = 0; var11 < var10.length; ++var11) {
                              var12 = var10[var11];
                              if(var7 == var12) {
                                 var8 = true;
                                 break label124;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var12 = var10[var11];
                        if(var12 == var7) {
                           var8 = true;
                           break;
                        }

                        ++var11;
                     }
                  }
               }

               if(var8) {
                  char var14;
                  switch(var7) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var14 = 95;
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var14 = var7;
                     break;
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
                     var14 = 97;
                     break;
                  case 'Ç':
                  case 'ç':
                     var14 = 99;
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var14 = 101;
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var14 = 105;
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var14 = 110;
                     break;
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
                     var14 = 111;
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var14 = 117;
                     break;
                  case 'ß':
                     var14 = 98;
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var14 = 121;
                     break;
                  default:
                     var14 = Character.toLowerCase(var7);
                  }

                  if(var14 != 0) {
                     var5.append(var14);
                  }
               }
            }

            if(var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }
}
