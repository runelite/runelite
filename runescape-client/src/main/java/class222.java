import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public enum class222 implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2801(0, 0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2806(1, 0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2783(2, 0),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2792(3, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2785(9, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2786(4, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2787(5, 1),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2803(6, 1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2782(7, 1),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2790(8, 1),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2791(12, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2795(13, 2),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2793(14, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2794(15, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2789(16, 2),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2796(17, 2),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2797(18, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2798(19, 2),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2799(20, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2800(21, 2),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2784(10, 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2802(11, 2),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   field2788(22, 3);

   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1046723153
   )
   public final int field2804;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 972816383
   )
   static int field2807;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class222(int var3, int var4) {
      this.field2804 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field2804;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;Ljava/lang/String;I)[Lkn;",
      garbageValue = "1176010645"
   )
   public static SpritePixels[] method4065(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      SpritePixels[] var5;
      if(!Script.method1883(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class209.method3909();
      }

      return var5;
   }
}
