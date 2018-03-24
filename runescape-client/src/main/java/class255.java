import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
public final class class255 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;B)V",
      garbageValue = "-123"
   )
   public static void method4546(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3525 = var0;
      class229.field2678 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lek;IIIII)V",
      garbageValue = "983917042"
   )
   static final void method4545(Model var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, var4));
   }
}
