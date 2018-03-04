import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("Ignore")
public class Ignore extends Nameable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1799944039
   )
   int field3837;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkb;I)I",
      garbageValue = "1770193833"
   )
   int method5496(Ignore var1) {
      return this.field3837 - var1.field3837;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lkm;I)I",
      garbageValue = "-1994435588"
   )
   public int vmethod5558(Nameable var1) {
      return this.method5496((Ignore)var1);
   }

   public int compareTo(Object var1) {
      return this.method5496((Ignore)var1);
   }
}
