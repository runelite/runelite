import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("RectangleMode")
public enum RectangleMode implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   @Export("__lj_m")
   __lj_m(0, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   @Export("__lj_f")
   __lj_f(1, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   @Export("__lj_q")
   __lj_q(2, 2);
   @ObfuscatedName("d")
   @Export("musicTrackBoolean")
   public static boolean musicTrackBoolean;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1391612747
   )
   @Export("id")
   public final int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1204297807
   )
   @Export("id2")
   final int id2;

   RectangleMode(int var3, int var4) {
      this.id = var3;
      this.id2 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public int rsOrdinal() {
      return this.id2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;ZB)V",
      garbageValue = "1"
   )
   public static void method6028(AbstractIndexCache var0, AbstractIndexCache var1, boolean var2) {
      ObjectDefinition.ObjectDefinition_indexCache = var0;
      ObjectDefinition.__jr_q = var1;
      ObjectDefinition.ObjectDefinition_isLowDetail = var2;
   }
}
