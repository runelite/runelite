import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public enum class239 implements Enumerated {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3251(2, 0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3245(0, 1),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3246(4, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3249(6, 3),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3255(5, 4),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3244(1, 5),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3250(3, 6),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3247(7, 7);

   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 455437101
   )
   public final int field3252;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -684433551
   )
   final int field3248;

   class239(int var3, int var4) {
      this.field3252 = var3;
      this.field3248 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.field3248;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2088060801"
   )
   public static void method4481(boolean var0) {
      if(var0 != class35.isMembersWorld) {
         JagexGame.method4492();
         class35.isMembersWorld = var0;
      }

   }
}
