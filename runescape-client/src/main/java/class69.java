import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class69 implements Runnable {
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1772757411
   )
   static int field832;
   @ObfuscatedName("n")
   volatile boolean field829;
   @ObfuscatedName("g")
   Queue field830;
   @ObfuscatedName("e")
   final Thread field833;

   class69() {
      this.field830 = new LinkedList();
      this.field833 = new Thread(this);
      this.field833.setPriority(1);
      this.field833.start();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1740202415"
   )
   void method1098() {
      this.field829 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field833.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lcu;",
      garbageValue = "-1282989217"
   )
   class83 method1097(URL var1) {
      class83 var2 = new class83(var1);
      synchronized(this) {
         this.field830.add(var2);
         this.notify();
         return var2;
      }
   }

   public void run() {
      while(!this.field829) {
         try {
            class83 var1;
            synchronized(this) {
               var1 = (class83)this.field830.poll();
               if(var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var6) {
                     ;
                  }
                  continue;
               }
            }

            try {
               URLConnection var2 = var1.field1323.openConnection();
               var2.setConnectTimeout(30000);
               int var3 = var2.getContentLength();
               if(var3 >= 0) {
                  byte[] var4 = new byte[var3];
                  (new DataInputStream(var2.getInputStream())).readFully(var4);
                  var1.field1320 = var4;
               }

               var1.field1321 = true;
            } catch (IOException var7) {
               var1.field1321 = true;
            }
         } catch (Exception var9) {
            NPC.method1722((String)null, var9);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-16711936"
   )
   public static boolean method1104(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
