import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("li")
@Implements("UserComparator2")
public class UserComparator2 implements Comparator {
   @ObfuscatedName("m")
   @Export("__m")
   final boolean __m;

   public UserComparator2(boolean var1) {
      this.__m = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljs;Ljs;I)I",
      garbageValue = "-2069683911"
   )
   @Export("__m_479")
   int __m_479(User var1, User var2) {
      return this.__m?var1.username().compareTo0(var2.username()):var2.username().compareTo0(var1.username());
   }

   @Export("__equals_481")
   @ObfuscatedName("equals")
   public boolean __equals_481(Object var1) {
      return super.equals(var1);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.__m_479((User)var1, (User)var2);
   }
}
