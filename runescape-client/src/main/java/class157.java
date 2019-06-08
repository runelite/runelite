import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class157 extends AbstractUserComparator {
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1006519291
   )
   @Export("__fw_nm")
   static int __fw_nm;
   @ObfuscatedName("m")
   final boolean field1969;

   public class157(boolean var1) {
      this.field1969 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "884616259"
   )
   int method3381(Buddy var1, Buddy var2) {
      return var2.rank != var1.rank?(this.field1969?var1.rank - var2.rank:var2.rank - var1.rank):this.__x_461(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3381((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "307754910"
   )
   public static void method3382() {
      Widget.widgetSpriteCache.clear();
      Widget.Widget_cachedModels.clear();
      Widget.Widget_cachedFonts.clear();
      Widget.__ho_z.clear();
   }
}
