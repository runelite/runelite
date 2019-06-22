import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
public class class311 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   static final class311 field3810;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2077113503
   )
   @Export("__ka_e")
   static int __ka_e;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -800980069
   )
   final int field3809;

   class311(int var1) {
      this.field3809 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Llj;",
      garbageValue = "-2017595575"
   )
   public static RectangleMode[] method5822() {
      return new RectangleMode[]{RectangleMode.__lj_f, RectangleMode.__lj_m, RectangleMode.__lj_q};
   }

   static {
      field3810 = new class311(3);
   }
}
