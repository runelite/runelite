import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public final class class31 extends Node {
   @ObfuscatedName("x")
   static int[] field697;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -767924869
   )
   int field698;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -987691637
   )
   int field699;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1371614363
   )
   int field700;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -286171147
   )
   int field701;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2067263317
   )
   int field702;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1458262305
   )
   int field703;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2079038243
   )
   int field704;
   @ObfuscatedName("l")
   class66 field705;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1096074503
   )
   int field707;
   @ObfuscatedName("w")
   int[] field708;
   @ObfuscatedName("d")
   static Deque field709 = new Deque();
   @ObfuscatedName("k")
   class66 field710;
   @ObfuscatedName("r")
   ObjectComposition field711;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1066329369
   )
   int field712;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1961539771
   )
   int field713;

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(IIB)Ljava/lang/String;",
      garbageValue = "61"
   )
   static final String method652(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class213.method4037(16711680):(var2 < -6?class213.method4037(16723968):(var2 < -3?class213.method4037(16740352):(var2 < 0?class213.method4037(16756736):(var2 > 9?class213.method4037('\uff00'):(var2 > 6?class213.method4037(4259584):(var2 > 3?class213.method4037(8453888):(var2 > 0?class213.method4037(12648192):class213.method4037(16776960))))))));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2118003083"
   )
   void method653() {
      int var1 = this.field704;
      ObjectComposition var2 = this.field711.getImpostor();
      if(var2 != null) {
         this.field704 = var2.ambientSoundId;
         this.field703 = var2.field2969 * 128;
         this.field713 = var2.field2923;
         this.field707 = var2.field2971;
         this.field708 = var2.field2959;
      } else {
         this.field704 = -1;
         this.field703 = 0;
         this.field713 = 0;
         this.field707 = 0;
         this.field708 = null;
      }

      if(this.field704 != var1 && this.field705 != null) {
         class114.field1791.method945(this.field705);
         this.field705 = null;
      }

   }
}
