import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class156 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -91812097
   )
   @Export("idxCount")
   static int idxCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 1842846479
   )
   static int field2159;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -256686117
   )
   static int field2161;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1110826807"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class245.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class245.NetCache_socket.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class245.NetCache_socket.close();
            } catch (Exception var3) {
               ;
            }

            ++class245.field3342;
            class245.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Liq;",
      garbageValue = "1"
   )
   public static class259 method3089(int var0) {
      class259 var1 = (class259)class259.field3461.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class259.field3462.getConfigData(34, var0);
         var1 = new class259();
         if(var2 != null) {
            var1.method4615(new Buffer(var2));
         }

         var1.method4613();
         class259.field3461.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "36"
   )
   public static boolean method3091(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
