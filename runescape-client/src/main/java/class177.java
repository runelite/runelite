import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class177 implements class158 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -839945989
   )
   public final int field2659;
   @ObfuscatedName("e")
   static final class177 field2660 = new class177(1, 0, true, true, true);
   @ObfuscatedName("i")
   static final class177 field2661 = new class177(0, -1, true, false, true);
   @ObfuscatedName("k")
   static final class177 field2662 = new class177(3, 2, false, false, true);
   @ObfuscatedName("g")
   static final class177 field2663 = new class177(4, 3, false, false, true);
   @ObfuscatedName("n")
   static final class177 field2664 = new class177(5, 10, false, false, true);
   @ObfuscatedName("f")
   static final class177 field2665 = new class177(2, 1, true, true, false);
   @ObfuscatedName("w")
   public final boolean field2666;
   @ObfuscatedName("v")
   public final boolean field2668;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -18342301
   )
   final int field2671;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-24"
   )
   static final String method3186(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2671 = var1;
      this.field2659 = var2;
      this.field2666 = var4;
      this.field2668 = var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "382736064"
   )
   public static int method3191(CharSequence var0) {
      return class146.method2699(var0, 10, true);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1889072846"
   )
   static final void method3192() {
      if(Client.field453 > 0) {
         class10.method146();
      } else {
         XGrandExchangeOffer.setGameState(40);
         Client.field326 = class156.field2118;
         class156.field2118 = null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2056039019"
   )
   public int vmethod3974() {
      return this.field2671;
   }
}
