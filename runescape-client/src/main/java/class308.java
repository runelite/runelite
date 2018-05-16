import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
public class class308 implements Comparator {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1447092561
   )
   static int field3746;
   @ObfuscatedName("w")
   final boolean field3745;

   public class308(boolean var1) {
      this.field3745 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljn;Ljn;I)I",
      garbageValue = "607151868"
   )
   int method5706(Nameable var1, Nameable var2) {
      return this.field3745?var1.vmethod5482(var2):var2.vmethod5482(var1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method5706((Nameable)var1, (Nameable)var2);
   }
}
