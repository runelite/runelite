import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class148 implements Runnable {
   @ObfuscatedName("j")
   volatile boolean field2193;
   @ObfuscatedName("a")
   Queue field2195;
   @ObfuscatedName("i")
   final Thread field2194;

   public class148() {
      this.field2195 = new LinkedList();
      this.field2194 = new Thread(this);
      this.field2194.setPriority(1);
      this.field2194.start();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1425751142"
   )
   public void method2946() {
      this.field2193 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field2194.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Len;",
      garbageValue = "1781541517"
   )
   public class149 method2955(URL var1) {
      class149 var2 = new class149(var1);
      synchronized(this) {
         this.field2195.add(var2);
         this.notify();
         return var2;
      }
   }

   public void run() {
      while(!this.field2193) {
         try {
            class149 var1;
            synchronized(this) {
               var1 = (class149)this.field2195.poll();
               if(var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var13) {
                     ;
                  }
                  continue;
               }
            }

            DataInputStream var2 = null;
            URLConnection var3 = null;

            try {
               var3 = var1.field2202.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var4 = var3.getContentLength();
               if(var4 >= 0) {
                  byte[] var5 = new byte[var4];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.field2200 = var5;
               }

               var1.field2199 = true;
            } catch (IOException var14) {
               var1.field2199 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            class150.method2975((String)null, var17);
         }
      }

   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1896430250"
   )
   static void method2956(int var0) {
      if(var0 == -1 && !Client.field1169) {
         class165.method3158();
      } else if(var0 != -1 && var0 != Client.field1168 && Client.field1167 != 0 && !Client.field1169) {
         class46.method736(2, class45.indexTrack1, var0, 0, Client.field1167, false);
      }

      Client.field1168 = var0;
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lhx;IB)Ljava/lang/String;",
      garbageValue = "8"
   )
   static String method2953(Widget var0, int var1) {
      int var3 = Coordinates.getWidgetConfig(var0);
      boolean var2 = 0 != (var3 >> var1 + 1 & 1);
      return !var2 && var0.field2701 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
