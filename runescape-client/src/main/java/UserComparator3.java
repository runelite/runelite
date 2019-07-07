import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("UserComparator3")
public class UserComparator3 extends AbstractUserComparator {
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("archive6")
   static Archive archive6;
   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("socketTask")
   static Task socketTask;
   @ObfuscatedName("m")
   @Export("reversed")
   final boolean reversed;

   public UserComparator3(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "-1157645406"
   )
   @Export("compareBuddy")
   int compareBuddy(Buddy var1, Buddy var2) {
      return var2.world != var1.world ? (this.reversed ? var1.world - var2.world : var2.world - var1.world) : this.compareUser(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.compareBuddy((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "699084605"
   )
   public static void method3379() {
      SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
      SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
   }
}
