import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
@Implements("UserComparator1")
public class UserComparator1 implements Comparator {
   @ObfuscatedName("m")
   @Export("reversed")
   final boolean reversed;

   public UserComparator1(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljs;Ljs;B)I",
      garbageValue = "68"
   )
   @Export("compareUser")
   int compareUser(User var1, User var2) {
      return this.reversed ? var1.compareToUser(var2) : var2.compareToUser(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.compareUser((User)var1, (User)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
