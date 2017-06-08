import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public abstract class class158 {
   @ObfuscatedName("w")
   static int[] field2274;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1772496227
   )
   public static int field2275;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1252915435"
   )
   public static int method2978(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class10.method68(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2087389048"
   )
   public abstract void vmethod2979();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "-44158056"
   )
   public static void method2982(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.field3326 = var0;
      Spotanim.field3330 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1909349990"
   )
   public abstract int vmethod2985(int var1, int var2);
}
