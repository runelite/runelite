import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2128084359
   )
   int field1503;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1194723603
   )
   int field1504;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1772414087
   )
   int field1506;
   @ObfuscatedName("y")
   public static class227 field1507;

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "-101"
   )
   static boolean method1940(Widget var0) {
      if(Client.field470) {
         if(Projectile.method96(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;B)V",
      garbageValue = "0"
   )
   public static void method1941(class170 var0) {
      class53.field1147 = var0;
   }
}
