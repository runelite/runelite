import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class156 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   public static CacheFile field2253;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   public static CacheFile field2250;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   public static CacheFile field2255;
   @ObfuscatedName("h")
   @Export("userHome")
   public static String userHome;
   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;

   static {
      field2253 = null;
      field2250 = null;
      field2255 = null;
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhx;B)Ljava/lang/String;",
      garbageValue = "0"
   )
   static String method3036(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + GameEngine.method1028(GameObject.method2942(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var6 = "";
            if(World.field1297 != null) {
               int var5 = World.field1297.field2238;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var6 = var4;
               if(World.field1297.value != null) {
                  var6 = (String)World.field1297.value;
               }
            }

            var0 = var0.substring(0, var2) + var6 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
