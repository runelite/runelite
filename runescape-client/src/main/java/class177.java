import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class177 implements class158 {
   @ObfuscatedName("n")
   static final class177 field2662 = new class177(5, 10, false, false, true);
   @ObfuscatedName("d")
   static final class177 field2663 = new class177(1, 0, true, true, true);
   @ObfuscatedName("h")
   static final class177 field2664 = new class177(2, 1, true, true, false);
   @ObfuscatedName("p")
   static final class177 field2665 = new class177(3, 2, false, false, true);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -494761635
   )
   final int field2666;
   @ObfuscatedName("q")
   static final class177 field2667 = new class177(0, -1, true, false, true);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 269156195
   )
   public final int field2669;
   @ObfuscatedName("i")
   public final boolean field2670;
   @ObfuscatedName("o")
   public final boolean field2671;
   @ObfuscatedName("es")
   static SpritePixels[] field2672;
   @ObfuscatedName("j")
   static final class177 field2673 = new class177(4, 3, false, false, true);
   @ObfuscatedName("lf")
   static class216 field2674;

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-87"
   )
   static void method3279(int var0, int var1, int var2, int var3) {
      Widget var4 = class57.method1157(var0, var1);
      if(null != var4 && null != var4.field2296) {
         class18 var5 = new class18();
         var5.field198 = var4;
         var5.field209 = var4.field2296;
         class174.method3275(var5, 200000);
      }

      Client.field462 = var3;
      Client.field511 = true;
      Friend.field166 = var0;
      Client.field461 = var1;
      class31.field739 = var2;
      class174.method3276(var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "555633042"
   )
   public int vmethod4101() {
      return this.field2666;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2666 = var1;
      this.field2669 = var2;
      this.field2670 = var4;
      this.field2671 = var5;
   }
}
