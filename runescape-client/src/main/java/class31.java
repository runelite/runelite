import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public final class class31 extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 371138227
   )
   int field695;
   @ObfuscatedName("n")
   static Deque field697 = new Deque();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 373196323
   )
   int field698;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1897378905
   )
   int field699;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1056643351
   )
   int field701;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2061143451
   )
   int field702;
   @ObfuscatedName("z")
   class66 field703;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1573543757
   )
   int field704;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1184635813
   )
   int field705;
   @ObfuscatedName("y")
   int[] field706;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -242108203
   )
   int field707;
   @ObfuscatedName("x")
   class66 field708;
   @ObfuscatedName("r")
   ObjectComposition field709;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -80925911
   )
   int field710;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 67791889
   )
   int field713;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "206292266"
   )
   void method688() {
      int var1 = this.field702;
      ObjectComposition var2 = this.field709.getImpostor();
      if(null != var2) {
         this.field702 = var2.field2922;
         this.field701 = var2.field2936 * 128;
         this.field704 = var2.field2898;
         this.field713 = var2.field2938;
         this.field706 = var2.field2895;
      } else {
         this.field702 = -1;
         this.field701 = 0;
         this.field704 = 0;
         this.field713 = 0;
         this.field706 = null;
      }

      if(var1 != this.field702 && this.field703 != null) {
         class143.field2007.method915(this.field703);
         this.field703 = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-93"
   )
   static byte[] method695(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}
