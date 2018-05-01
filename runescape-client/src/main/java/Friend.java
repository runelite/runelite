import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("Friend")
public class Friend extends ChatPlayer {
   @ObfuscatedName("g")
   boolean field3867;
   @ObfuscatedName("e")
   boolean field3868;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lke;I)I",
      garbageValue = "1377833058"
   )
   int method5504(Friend var1) {
      return super.world == Client.world && Client.world != var1.world?-1:(Client.world == var1.world && super.world != Client.world?1:(super.world != 0 && var1.world == 0?-1:(var1.world != 0 && super.world == 0?1:(this.field3867 && !var1.field3867?-1:(!this.field3867 && var1.field3867?1:(this.field3868 && !var1.field3868?-1:(!this.field3868 && var1.field3868?1:(super.world != 0?super.field3851 - var1.field3851:var1.field3851 - super.field3851))))))));
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lkg;I)I",
      garbageValue = "1389713193"
   )
   public int vmethod5501(Nameable var1) {
      return this.method5504((Friend)var1);
   }

   public int compareTo(Object var1) {
      return this.method5504((Friend)var1);
   }
}
