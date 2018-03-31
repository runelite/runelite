import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
@Implements("Ignore")
public class Ignore extends Nameable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1817700977
   )
   int field3837;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lkx;B)I",
      garbageValue = "8"
   )
   int method5389(Ignore var1) {
      return this.field3837 - var1.field3837;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lku;B)I",
      garbageValue = "0"
   )
   public int vmethod5454(Nameable var1) {
      return this.method5389((Ignore)var1);
   }

   public int compareTo(Object var1) {
      return this.method5389((Ignore)var1);
   }
}
