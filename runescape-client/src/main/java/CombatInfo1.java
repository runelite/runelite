import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 752206111
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1309587599
   )
   int field1275;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1105050915
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 111613453
   )
   @Export("health")
   int health;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -618945733
   )
   int field1272;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1275 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1272 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "818066540"
   )
   void method1543(int var1, int var2, int var3, int var4) {
      this.field1275 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1272 = var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lip;II)Z",
      garbageValue = "113739466"
   )
   static boolean method1542(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4230(var1);
      if(var2 == null) {
         return false;
      } else {
         class93.decodeSprite(var2);
         return true;
      }
   }
}
