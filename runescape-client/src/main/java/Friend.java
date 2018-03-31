import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("Friend")
public class Friend extends ChatPlayer {
   @ObfuscatedName("c")
   boolean field3854;
   @ObfuscatedName("i")
   boolean field3855;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lkt;B)I",
      garbageValue = "-65"
   )
   int method5459(Friend var1) {
      return super.world == Client.world && Client.world != var1.world?-1:(Client.world == var1.world && super.world != Client.world?1:(super.world != 0 && var1.world == 0?-1:(var1.world != 0 && super.world == 0?1:(this.field3854 && !var1.field3854?-1:(!this.field3854 && var1.field3854?1:(this.field3855 && !var1.field3855?-1:(!this.field3855 && var1.field3855?1:(super.world != 0?super.field3839 - var1.field3839:var1.field3839 - super.field3839))))))));
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lku;B)I",
      garbageValue = "0"
   )
   public int vmethod5454(Nameable var1) {
      return this.method5459((Friend)var1);
   }

   public int compareTo(Object var1) {
      return this.method5459((Friend)var1);
   }
}
