import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
public class class292 extends Friend {
   @ObfuscatedName("b")
   boolean field3736;
   @ObfuscatedName("q")
   boolean field3737;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lkm;I)I",
      garbageValue = "634887800"
   )
   int method5383(class292 var1) {
      return super.world == Client.world && Client.world != var1.world?-1:(Client.world == var1.world && super.world != Client.world?1:(super.world != 0 && var1.world == 0?-1:(var1.world != 0 && super.world == 0?1:(this.field3736 && !var1.field3736?-1:(!this.field3736 && var1.field3736?1:(this.field3737 && !var1.field3737?-1:(!this.field3737 && var1.field3737?1:(super.world != 0?super.field3718 - var1.field3718:var1.field3718 - super.field3718))))))));
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljw;I)I",
      garbageValue = "-1639507459"
   )
   public int vmethod5385(Nameable var1) {
      return this.method5383((class292)var1);
   }

   public int compareTo(Object var1) {
      return this.method5383((class292)var1);
   }
}
