import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public final class class31 extends Node {
   @ObfuscatedName("c")
   static Deque field703 = new Deque();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1981548785
   )
   int field704;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 164239323
   )
   int field705;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1618461165
   )
   int field706;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1170639071
   )
   int field707;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -25967067
   )
   int field708;
   @ObfuscatedName("m")
   int[] field709;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2075486419
   )
   int field710;
   @ObfuscatedName("x")
   class66 field711;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 932616723
   )
   int field712;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -554650095
   )
   int field713;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 861323969
   )
   int field714;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1410346775
   )
   int field715;
   @ObfuscatedName("w")
   class66 field716;
   @ObfuscatedName("r")
   ObjectComposition field717;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1321185672"
   )
   void method653() {
      int var1 = this.field707;
      ObjectComposition var2 = this.field717.getImpostor();
      if(var2 != null) {
         this.field707 = var2.ambientSoundId;
         this.field710 = var2.field2944 * 128;
         this.field712 = var2.field2945;
         this.field713 = var2.field2946;
         this.field709 = var2.field2937;
      } else {
         this.field707 = -1;
         this.field710 = 0;
         this.field712 = 0;
         this.field713 = 0;
         this.field709 = null;
      }

      if(this.field707 != var1 && null != this.field711) {
         CombatInfoListHolder.field758.method869(this.field711);
         this.field711 = null;
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1619458544"
   )
   static final void method659(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field404; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field497[var4] = true;
         }
      }

   }
}
