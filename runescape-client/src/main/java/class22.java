import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class22 extends class119 {
   @ObfuscatedName("dn")
   static byte[][] field239;
   @ObfuscatedName("al")
   @Export("authCode")
   static String authCode;

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "-101"
   )
   static boolean method221(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class162.method3194(var0, class108.field1740);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class162.method3194(Client.friends[var3].name, class108.field1740)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class162.method3194(class40.localPlayer.name, class108.field1740))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-975449823"
   )
   static final void method226(int var0, int var1) {
      if(Client.field302 == 2) {
         class3.method41((Client.field305 - class16.baseX << 7) + Client.field308, Client.field309 + (Client.field306 - Client.baseY << 7), Client.field453 * 2);
         if(Client.field347 > -1 && Client.gameCycle % 20 < 10) {
            class3.field37[0].method4192(Client.field347 + var0 - 12, var1 + Client.field394 - 28);
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-47430657"
   )
   protected boolean vmethod2346(int var1, int var2, int var3, CollisionData var4) {
      return super.field1856 == var2 && super.field1849 == var3;
   }
}
