import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2000315563
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("q")
   @Export("padding")
   byte padding;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lit;",
      garbageValue = "-1507691651"
   )
   public static InvType method4622(int var0) {
      InvType var1 = (InvType)InvType.inventoryCache.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvType.field3247.getConfigData(5, var0);
         var1 = new InvType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvType.inventoryCache.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhl;I)Ljava/lang/String;",
      garbageValue = "240844690"
   )
   static String method4621(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + WorldMapType2.method491(class11.method114(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1914952653"
   )
   static void method4623(int var0) {
      Client.field678 = var0;
   }
}
