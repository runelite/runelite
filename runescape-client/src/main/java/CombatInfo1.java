import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field1216;
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1816575847
   )
   static int field1215;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 410263585
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1060883801
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1905379511
   )
   @Export("health")
   int health;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1422168483
   )
   @Export("int2")
   int int2;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "62"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1035838025"
   )
   static final void method1576() {
      for(int var0 = 0; var0 < Client.npcIndexesCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class215.method4018(var2, var2.composition.field3667);
         }
      }

   }
}
