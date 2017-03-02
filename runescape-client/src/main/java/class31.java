import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public final class class31 extends Node {
   @ObfuscatedName("a")
   class66 field696;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -745988021
   )
   int field697;
   @ObfuscatedName("p")
   int[] field698;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -280636725
   )
   int field699;
   @ObfuscatedName("b")
   static Deque field700 = new Deque();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1551249619
   )
   int field701;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1092444021
   )
   int field702;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -795681299
   )
   int field703;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 784724615
   )
   int field704;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 450850295
   )
   int field705;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -619099181
   )
   int field706;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2146978473
   )
   int field708;
   @ObfuscatedName("o")
   class66 field709;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1597606211
   )
   int field710;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -173794709
   )
   static int field713;
   @ObfuscatedName("r")
   ObjectComposition field714;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1993572840"
   )
   void method704() {
      int var1 = this.field703;
      ObjectComposition var2 = this.field714.getImpostor();
      if(var2 != null) {
         this.field703 = var2.ambientSoundId;
         this.field702 = var2.field2939 * 128;
         this.field705 = var2.field2947;
         this.field706 = var2.field2944;
         this.field698 = var2.field2933;
      } else {
         this.field703 = -1;
         this.field702 = 0;
         this.field705 = 0;
         this.field706 = 0;
         this.field698 = null;
      }

      if(this.field703 != var1 && this.field696 != null) {
         class16.field168.method994(this.field696);
         this.field696 = null;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "8"
   )
   static void method706(int var0, int var1) {
      if(Client.field522 != 0 && var0 != -1) {
         GameEngine.method2168(class114.field1789, var0, 0, Client.field522, false);
         Client.field401 = true;
      }

   }
}
