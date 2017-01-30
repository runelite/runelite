import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public final class class31 extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 85948385
   )
   int field695;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 585540477
   )
   int field696;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 917894189
   )
   int field697;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -719903629
   )
   int field698;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 535367421
   )
   int field699;
   @ObfuscatedName("m")
   int[] field700;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1408202065
   )
   int field701;
   @ObfuscatedName("a")
   class66 field702;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -247972047
   )
   int field703;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -769358321
   )
   int field704;
   @ObfuscatedName("u")
   class66 field706;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -310389059
   )
   int field707;
   @ObfuscatedName("r")
   ObjectComposition field708;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1370583125
   )
   int field709;
   @ObfuscatedName("bu")
   static ModIcon[] field710;
   @ObfuscatedName("p")
   static Deque field711 = new Deque();
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 1534193155
   )
   static int field712;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1571404143
   )
   static int field713;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-399049195"
   )
   void method662() {
      int var1 = this.field704;
      ObjectComposition var2 = this.field708.getImpostor();
      if(null != var2) {
         this.field704 = var2.ambientSoundId;
         this.field709 = var2.field2910 * 128;
         this.field703 = var2.field2888;
         this.field695 = var2.field2911;
         this.field700 = var2.field2937;
      } else {
         this.field704 = -1;
         this.field709 = 0;
         this.field703 = 0;
         this.field695 = 0;
         this.field700 = null;
      }

      if(var1 != this.field704 && null != this.field702) {
         CombatInfoListHolder.field753.method899(this.field702);
         this.field702 = null;
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-16711936"
   )
   static void method668(int var0, int var1) {
      if(Client.field536 != 0 && var0 != -1) {
         class48.method875(class49.field962, var0, 0, Client.field536, false);
         Client.field516 = true;
      }

   }
}
