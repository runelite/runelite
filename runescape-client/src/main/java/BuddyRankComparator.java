import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("BuddyRankComparator")
public class BuddyRankComparator extends AbstractUserComparator {
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1006519291
   )
   static int field1114;
   @ObfuscatedName("m")
   @Export("reversed")
   final boolean reversed;

   public BuddyRankComparator(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "884616259"
   )
   @Export("compareBuddy")
   int compareBuddy(Buddy var1, Buddy var2) {
      return var2.rank != var1.rank ? (this.reversed ? var1.rank - var2.rank : var2.rank - var1.rank) : this.compareUser(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.compareBuddy((Buddy)var1, (Buddy)var2);
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
      Widget.field956.clear();
   }
}
