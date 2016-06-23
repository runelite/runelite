import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class136 implements Runnable {
   @ObfuscatedName("f")
   public static String field2089;
   @ObfuscatedName("u")
   static String field2090;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 2007726391
   )
   static int field2091;
   @ObfuscatedName("b")
   class146 field2092 = null;
   @ObfuscatedName("l")
   class146 field2093 = null;
   @ObfuscatedName("n")
   boolean field2094 = false;
   @ObfuscatedName("x")
   class53 field2095;
   @ObfuscatedName("m")
   EventQueue field2096;
   @ObfuscatedName("pn")
   static class221 field2098;
   @ObfuscatedName("d")
   Thread field2099;
   @ObfuscatedName("bo")
   static class168 field2101;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-10781"
   )
   final void method2899() {
      synchronized(this) {
         this.field2094 = true;
         this.notifyAll();
      }

      try {
         this.field2099.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;S)Lclass146;",
      garbageValue = "7829"
   )
   final class146 method2901(int var1, int var2, int var3, Object var4) {
      class146 var5 = new class146();
      var5.field2215 = var1;
      var5.field2210 = var2;
      var5.field2217 = var4;
      synchronized(this) {
         if(this.field2093 != null) {
            this.field2093.field2211 = var5;
            this.field2093 = var5;
         } else {
            this.field2093 = this.field2092 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass146;",
      garbageValue = "1681495797"
   )
   public final class146 method2902(String var1, int var2) {
      return this.method2901(1, var2, 0, var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass146;",
      garbageValue = "1871078426"
   )
   public final class146 method2903(Runnable var1, int var2) {
      return this.method2901(2, var2, 0, var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass146;",
      garbageValue = "-1367574423"
   )
   public final class146 method2905(URL var1) {
      return this.method2901(4, 0, 0, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lclass53;",
      garbageValue = "65280"
   )
   public final class53 method2906() {
      return this.field2095;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lclass146;",
      garbageValue = "87"
   )
   public final class146 method2918(int var1) {
      return this.method2901(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1124628168"
   )
   static void method2923(int var0, String var1) {
      int var2 = class32.field753;
      int[] var3 = class32.field761;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         class2 var6 = client.field302[var3[var5]];
         if(var6 != null && class15.field225 != var6 && null != var6.field60 && var6.field60.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               client.field333.method2773(241);
               client.field333.method2549(0);
               client.field333.method2586(var3[var5]);
            } else if(var0 == 4) {
               client.field333.method2773(221);
               client.field333.method2549(0);
               client.field333.method2586(var3[var5]);
            } else if(var0 == 6) {
               client.field333.method2773(91);
               client.field333.method2586(var3[var5]);
               client.field333.method2577(0);
            } else if(var0 == 7) {
               client.field333.method2773(8);
               client.field333.method2586(var3[var5]);
               client.field333.method2578(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class52.method1147(4, "", "Unable to find " + var1);
      }

   }

   class136() {
      field2089 = "Unknown";
      field2090 = "1.1";

      try {
         field2089 = System.getProperty("java.vendor");
         field2090 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2096 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2094 = false;
      this.field2099 = new Thread(this);
      this.field2099.setPriority(10);
      this.field2099.setDaemon(true);
      this.field2099.start();
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "431331591"
   )
   static final void method2930(boolean var0) {
      client.field324 = 0;
      client.field331 = 0;
      client.field335.method2775();
      int var1 = client.field335.method2776(8);
      int var2;
      if(var1 < client.field494) {
         for(var2 = var1; var2 < client.field494; ++var2) {
            client.field414[++client.field324 - 1] = client.field330[var2];
         }
      }

      if(var1 > client.field494) {
         throw new RuntimeException("");
      } else {
         client.field494 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var10 = client.field330[var2];
            class34 var11 = client.field328[var10];
            var5 = client.field335.method2776(1);
            if(var5 == 0) {
               client.field330[++client.field494 - 1] = var10;
               var11.field867 = client.field301;
            } else {
               var6 = client.field335.method2776(2);
               if(var6 == 0) {
                  client.field330[++client.field494 - 1] = var10;
                  var11.field867 = client.field301;
                  client.field288[++client.field331 - 1] = var10;
               } else if(var6 == 1) {
                  client.field330[++client.field494 - 1] = var10;
                  var11.field867 = client.field301;
                  var7 = client.field335.method2776(3);
                  var11.method758(var7, (byte)1);
                  var8 = client.field335.method2776(1);
                  if(var8 == 1) {
                     client.field288[++client.field331 - 1] = var10;
                  }
               } else if(var6 == 2) {
                  client.field330[++client.field494 - 1] = var10;
                  var11.field867 = client.field301;
                  var7 = client.field335.method2776(3);
                  var11.method758(var7, (byte)2);
                  var8 = client.field335.method2776(3);
                  var11.method758(var8, (byte)2);
                  int var9 = client.field335.method2776(1);
                  if(var9 == 1) {
                     client.field288[++client.field331 - 1] = var10;
                  }
               } else if(var6 == 3) {
                  client.field414[++client.field324 - 1] = var10;
               }
            }
         }

         class34 var3;
         int var4;
         while(client.field335.method2779(client.field419) >= 27) {
            var1 = client.field335.method2776(15);
            if(var1 == 32767) {
               break;
            }

            boolean var12 = false;
            if(client.field328[var1] == null) {
               client.field328[var1] = new class34();
               var12 = true;
            }

            var3 = client.field328[var1];
            client.field330[++client.field494 - 1] = var1;
            var3.field867 = client.field301;
            if(var0) {
               var4 = client.field335.method2776(8);
               if(var4 > 127) {
                  var4 -= 256;
               }
            } else {
               var4 = client.field335.method2776(5);
               if(var4 > 15) {
                  var4 -= 32;
               }
            }

            var5 = client.field418[client.field335.method2776(3)];
            if(var12) {
               var3.field871 = var3.field883 = var5;
            }

            if(var0) {
               var6 = client.field335.method2776(8);
               if(var6 > 127) {
                  var6 -= 256;
               }
            } else {
               var6 = client.field335.method2776(5);
               if(var6 > 15) {
                  var6 -= 32;
               }
            }

            var3.field782 = class172.method3424(client.field335.method2776(14));
            var7 = client.field335.method2776(1);
            var8 = client.field335.method2776(1);
            if(var8 == 1) {
               client.field288[++client.field331 - 1] = var1;
            }

            var3.field825 = var3.field782.field907;
            var3.field873 = var3.field782.field922;
            if(var3.field873 == 0) {
               var3.field883 = 0;
            }

            var3.field829 = var3.field782.field913;
            var3.field830 = var3.field782.field906;
            var3.field831 = var3.field782.field927;
            var3.field832 = var3.field782.field908;
            var3.field826 = var3.field782.field902;
            var3.field827 = var3.field782.field903;
            var3.field845 = var3.field782.field929;
            var3.method753(class15.field225.field875[0] + var6, var4 + class15.field225.field876[0], var7 == 1);
         }

         client.field335.method2791();

         for(var1 = 0; var1 < client.field331; ++var1) {
            var2 = client.field288[var1];
            var3 = client.field328[var2];
            var4 = client.field335.method2554();
            if((var4 & 16) != 0) {
               var3.field782 = class172.method3424(client.field335.method2695());
               var3.field825 = var3.field782.field907;
               var3.field873 = var3.field782.field922;
               var3.field829 = var3.field782.field913;
               var3.field830 = var3.field782.field906;
               var3.field831 = var3.field782.field927;
               var3.field832 = var3.field782.field908;
               var3.field826 = var3.field782.field902;
               var3.field827 = var3.field782.field903;
               var3.field845 = var3.field782.field929;
            }

            if((var4 & 4) != 0) {
               var3.field846 = client.field335.method2588();
               if(var3.field846 == '\uffff') {
                  var3.field846 = -1;
               }
            }

            if((var4 & 64) != 0) {
               var3.field857 = client.field335.method2556();
               var5 = client.field335.method2696();
               var3.field842 = var5 >> 16;
               var3.field860 = client.field301 + (var5 & '\uffff');
               var3.field821 = 0;
               var3.field859 = 0;
               if(var3.field860 > client.field301) {
                  var3.field821 = -1;
               }

               if(var3.field857 == '\uffff') {
                  var3.field857 = -1;
               }
            }

            if((var4 & 32) != 0) {
               var5 = client.field335.method2597();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = client.field335.method2579();
               if(var3.field822 == var5 && var5 != -1) {
                  var7 = class34.method768(var5).field1015;
                  if(var7 == 1) {
                     var3.field853 = 0;
                     var3.field854 = 0;
                     var3.field855 = var6;
                     var3.field856 = 0;
                  }

                  if(var7 == 2) {
                     var3.field856 = 0;
                  }
               } else if(var5 == -1 || var3.field822 == -1 || class34.method768(var5).field1009 >= class34.method768(var3.field822).field1009) {
                  var3.field822 = var5;
                  var3.field853 = 0;
                  var3.field854 = 0;
                  var3.field855 = var6;
                  var3.field856 = 0;
                  var3.field879 = var3.field874;
               }
            }

            if((var4 & 128) != 0) {
               var5 = client.field335.method2579();
               var6 = client.field335.method2580();
               var3.method806(var5, var6, client.field301);
               var3.field843 = 300 + client.field301;
               var3.field861 = client.field335.method2588();
               var3.field834 = client.field335.method2597();
            }

            if((var4 & 1) != 0) {
               var5 = client.field335.method2580();
               var6 = client.field335.method2580();
               var3.method806(var5, var6, client.field301);
               var3.field843 = client.field301 + 300;
               var3.field861 = client.field335.method2597();
               var3.field834 = client.field335.method2695();
            }

            if((var4 & 2) != 0) {
               var3.field824 = client.field335.method2668();
               var3.field882 = 100;
            }

            if((var4 & 8) != 0) {
               var5 = client.field335.method2695();
               var6 = client.field335.method2588();
               var7 = var3.field837 - 64 * (var5 - class172.field2734 - class172.field2734);
               var8 = var3.field880 - 64 * (var6 - class20.field576 - class20.field576);
               if(var7 != 0 || var8 != 0) {
                  var3.field848 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }
         }

         for(var1 = 0; var1 < client.field324; ++var1) {
            var2 = client.field414[var1];
            if(client.field328[var2].field867 != client.field301) {
               client.field328[var2].field782 = null;
               client.field328[var2] = null;
            }
         }

         if(client.field335.field1998 != client.field419) {
            throw new RuntimeException(client.field335.field1998 + "," + client.field419);
         } else {
            for(var1 = 0; var1 < client.field494; ++var1) {
               if(client.field328[client.field330[var1]] == null) {
                  throw new RuntimeException(var1 + "," + client.field494);
               }
            }

         }
      }
   }

   public final void run() {
      while(true) {
         class146 var1;
         synchronized(this) {
            while(true) {
               if(this.field2094) {
                  return;
               }

               if(this.field2092 != null) {
                  var1 = this.field2092;
                  this.field2092 = this.field2092.field2211;
                  if(this.field2092 == null) {
                     this.field2093 = null;
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
            int var5 = var1.field2215;
            if(var5 == 1) {
               var1.field2216 = new Socket(InetAddress.getByName((String)var1.field2217), var1.field2210);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2217);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2210);
               var1.field2216 = var3;
            } else if(var5 == 4) {
               var1.field2216 = new DataInputStream(((URL)var1.field2217).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2210 >> 24 & 255) + "." + (var1.field2210 >> 16 & 255) + "." + (var1.field2210 >> 8 & 255) + "." + (var1.field2210 & 255);
               var1.field2216 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2214 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2214 = 2;
         }
      }
   }
}
