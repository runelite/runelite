import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class158 {
   @ObfuscatedName("w")
   public static boolean field2001;
   @ObfuscatedName("m")
   public static File field2000;
   @ObfuscatedName("q")
   static Hashtable field2002;

   static {
      field2001 = false;
      field2002 = new Hashtable(16);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lla;I)I",
      garbageValue = "1139858817"
   )
   static final int method3317(JagexLoginType var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3876) {
         case 1:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1579994359"
   )
   static void method3313() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3191 == 0) {
            IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
            IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.field3191 = 600;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1319609905"
   )
   public static boolean method3314() {
      return class217.field2486 != 0?true:class217.field2485.method4354();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-463701689"
   )
   static final int method3316(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Graphics3D.COSINE[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1610310061"
   )
   static final int method3315(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
