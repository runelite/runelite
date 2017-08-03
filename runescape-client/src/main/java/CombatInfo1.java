import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("fn")
   static byte[][] field1250;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -134326809
   )
   int field1257;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1303115387
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1520555549
   )
   @Export("health")
   int health;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1906868489
   )
   int field1253;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1257 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1253 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1331488398"
   )
   void method1555(int var1, int var2, int var3, int var4) {
      this.field1257 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1253 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "-51"
   )
   public static int method1557(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "115"
   )
   static final void method1554() {
      if(Client.field1111 != class8.plane) {
         Client.field1111 = class8.plane;
         class157.method2998(class8.plane);
      }

   }
}
