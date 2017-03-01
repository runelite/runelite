import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class103 implements Runnable {
   @ObfuscatedName("x")
   public static String field1677;
   @ObfuscatedName("v")
   class102 field1678 = null;
   @ObfuscatedName("j")
   public EventQueue field1679;
   @ObfuscatedName("p")
   boolean field1680 = false;
   @ObfuscatedName("g")
   class102 field1681 = null;
   @ObfuscatedName("y")
   Thread field1682;
   @ObfuscatedName("n")
   static String field1688;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "806133170"
   )
   public final class102 method2051(URL var1) {
      return this.method2068(4, 0, 0, var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-12"
   )
   final void method2052() {
      synchronized(this) {
         this.field1680 = true;
         this.notifyAll();
      }

      try {
         this.field1682.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass102;",
      garbageValue = "-2147037946"
   )
   public final class102 method2055(String var1, int var2) {
      return this.method2068(1, var2, 0, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIIS)Z",
      garbageValue = "231"
   )
   static final boolean method2056(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label81:
      while(true) {
         int var6 = var4.method3039();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method3039();
               if(var9 == 0) {
                  continue label81;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var2 + var10;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = ChatMessages.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.field290 || var15.field2917 != 0 || var15.field2915 == 1 || var15.field2943) {
                     if(!var15.method3701()) {
                        ++Client.field352;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method3039();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass102;",
      garbageValue = "-1631566793"
   )
   public final class102 method2057(int var1) {
      return this.method2068(3, var1, 0, (Object)null);
   }

   class103() {
      field1677 = "Unknown";
      field1688 = "1.1";

      try {
         field1677 = System.getProperty("java.vendor");
         field1688 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1679 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1680 = false;
      this.field1682 = new Thread(this);
      this.field1682.setPriority(10);
      this.field1682.setDaemon(true);
      this.field1682.start();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "-1123197409"
   )
   public final class102 method2067(Runnable var1, int var2) {
      return this.method2068(2, var2, 0, var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "-989490"
   )
   final class102 method2068(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1672 = var1;
      var5.field1671 = var2;
      var5.field1673 = var4;
      synchronized(this) {
         if(this.field1678 != null) {
            this.field1678.field1668 = var5;
            this.field1678 = var5;
         } else {
            this.field1678 = this.field1681 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZB)V",
      garbageValue = "17"
   )
   public static void method2075(class182 var0, class182 var1, boolean var2) {
      ObjectComposition.field2925 = var0;
      ObjectComposition.field2899 = var1;
      ObjectComposition.field2945 = var2;
   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1680) {
                  return;
               }

               if(this.field1681 != null) {
                  var1 = this.field1681;
                  this.field1681 = this.field1681.field1668;
                  if(null == this.field1681) {
                     this.field1678 = null;
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
            int var5 = var1.field1672;
            if(var5 == 1) {
               var1.field1674 = new Socket(InetAddress.getByName((String)var1.field1673), var1.field1671);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1673);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1671);
               var1.field1674 = var3;
            } else if(var5 == 4) {
               var1.field1674 = new DataInputStream(((URL)var1.field1673).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1671 >> 24 & 255) + "." + (var1.field1671 >> 16 & 255) + "." + (var1.field1671 >> 8 & 255) + "." + (var1.field1671 & 255);
               var1.field1674 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1670 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1670 = 2;
         }
      }
   }
}
