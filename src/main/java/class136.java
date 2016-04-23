import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class136 implements Runnable {
   @ObfuscatedName("h")
   static String field2071;
   @ObfuscatedName("i")
   boolean field2072 = false;
   @ObfuscatedName("m")
   class53 field2073;
   @ObfuscatedName("x")
   class146 field2074 = null;
   @ObfuscatedName("e")
   Thread field2075;
   @ObfuscatedName("j")
   static String field2076;
   @ObfuscatedName("c")
   public EventQueue field2077;
   @ObfuscatedName("z")
   class146 field2078 = null;
   @ObfuscatedName("ba")
   static class168 field2080;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2108006659"
   )
   final void method2848() {
      synchronized(this) {
         this.field2072 = true;
         this.notifyAll();
      }

      try {
         this.field2075.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class146 var1;
         synchronized(this) {
            while(true) {
               if(this.field2072) {
                  return;
               }

               if(null != this.field2078) {
                  var1 = this.field2078;
                  this.field2078 = this.field2078.field2199;
                  if(null == this.field2078) {
                     this.field2074 = null;
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
            int var2 = var1.field2196;
            if(1 == var2) {
               var1.field2194 = new Socket(InetAddress.getByName((String)var1.field2198), var1.field2197);
            } else if(var2 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2198);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2197);
               var1.field2194 = var3;
            } else if(var2 == 4) {
               var1.field2194 = new DataInputStream(((URL)var1.field2198).openStream());
            } else if(var2 == 3) {
               String var9 = (var1.field2197 >> 24 & 255) + "." + (var1.field2197 >> 16 & 255) + "." + (var1.field2197 >> 8 & 255) + "." + (var1.field2197 & 255);
               var1.field2194 = InetAddress.getByName(var9).getHostName();
            }

            var1.field2195 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field2195 = 2;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;B)Lclass146;",
      garbageValue = "2"
   )
   final class146 method2849(int var1, int var2, int var3, Object var4) {
      class146 var5 = new class146();
      var5.field2196 = var1;
      var5.field2197 = var2;
      var5.field2198 = var4;
      synchronized(this) {
         if(null != this.field2074) {
            this.field2074.field2199 = var5;
            this.field2074 = var5;
         } else {
            this.field2074 = this.field2078 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass146;",
      garbageValue = "1064328772"
   )
   public final class146 method2850(String var1, int var2) {
      return this.method2849(1, var2, 0, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass146;",
      garbageValue = "493765911"
   )
   public final class146 method2851(Runnable var1, int var2) {
      return this.method2849(2, var2, 0, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass146;",
      garbageValue = "2131225062"
   )
   public final class146 method2853(URL var1) {
      return this.method2849(4, 0, 0, var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Lclass53;",
      garbageValue = "98"
   )
   public final class53 method2854() {
      return this.field2073;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lclass108;I)V",
      garbageValue = "1265791090"
   )
   static final void method2861(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class108[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].field1879[var2 + var9][var10 + var3] &= -16777217;
            }
         }
      }

      class119 var20 = new class119(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < var6 + 8) {
                  int var17 = var11 & 7;
                  int var18 = var12 & 7;
                  int var19 = var7 & 3;
                  int var16;
                  if(0 == var19) {
                     var16 = var17;
                  } else if(1 == var19) {
                     var16 = var18;
                  } else if(var19 == 2) {
                     var16 = 7 - var17;
                  } else {
                     var16 = 7 - var18;
                  }

                  class85.method1902(var20, var1, var2 + var16, var3 + class138.method2899(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class85.method1902(var20, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   class136() {
      field2076 = "Unknown";
      field2071 = "1.1";

      try {
         field2076 = System.getProperty("java.vendor");
         field2071 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2077 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2072 = false;
      this.field2075 = new Thread(this);
      this.field2075.setPriority(10);
      this.field2075.setDaemon(true);
      this.field2075.start();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass146;",
      garbageValue = "-1397258384"
   )
   public final class146 method2872(int var1) {
      return this.method2849(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "22"
   )
   static final void method2873() {
      client.field318.method2735(245);

      for(class3 var0 = (class3)client.field434.method3745(); null != var0; var0 = (class3)client.field434.method3746()) {
         if(0 == var0.field64 || 3 == var0.field64) {
            class130.method2798(var0, true);
         }
      }

      if(null != client.field437) {
         class2.method28(client.field437);
         client.field437 = null;
      }

   }
}
