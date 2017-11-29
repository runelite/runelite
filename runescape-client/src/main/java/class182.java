import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class182 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 5701028984755165113L
   )
   @Export("currentTimeMsLast")
   static long currentTimeMsLast;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static SpritePixels field2511;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   public static Track1 field2513;

   @ObfuscatedName("x")
   public static String method3529(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class275.field3732[(int)(var6 - 37L * var0)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1737424076"
   )
   public static void method3524() {
      CombatInfo2.field3432.reset();
      CombatInfo2.spriteCache.reset();
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-930654095"
   )
   static void method3528(int var0, int var1) {
      PacketNode var2 = class218.method4105(ClientPacket.field2335, Client.field916.field1470);
      var2.packetBuffer.writeIntLE(var0);
      var2.packetBuffer.method3332(var1);
      Client.field916.method1925(var2);
   }
}
