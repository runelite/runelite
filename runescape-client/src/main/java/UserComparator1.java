import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
@Implements("UserComparator1")
public class UserComparator1 implements Comparator {
   @ObfuscatedName("m")
   final boolean field931;

   public UserComparator1(boolean var1) {
      this.field931 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljs;Ljs;B)I",
      garbageValue = "68"
   )
   int method339(User var1, User var2) {
      return this.field931 ? var1.compareTo0(var2) : var2.compareTo0(var1);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.method339((User)var1, (User)var2);
   }

   @ObfuscatedName("equals")
   public boolean method340(Object var1) {
      return super.equals(var1);
   }
}
