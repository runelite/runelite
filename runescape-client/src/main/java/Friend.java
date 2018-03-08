import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
@Implements("Friend")
public class Friend extends ChatPlayer {
   @ObfuscatedName("t")
   boolean field3862;
   @ObfuscatedName("q")
   boolean field3861;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lks;B)I",
      garbageValue = "1"
   )
   int method5438(Friend var1) {
      return super.world == Client.world && Client.world != var1.world?-1:(Client.world == var1.world && super.world != Client.world?1:(super.world != 0 && var1.world == 0?-1:(var1.world != 0 && super.world == 0?1:(this.field3862 && !var1.field3862?-1:(!this.field3862 && var1.field3862?1:(this.field3861 && !var1.field3861?-1:(!this.field3861 && var1.field3861?1:(super.world != 0?super.field3842 - var1.field3842:var1.field3842 - super.field3842))))))));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lkv;I)I",
      garbageValue = "-1435662815"
   )
   public int vmethod5444(Nameable var1) {
      return this.method5438((Friend)var1);
   }

   public int compareTo(Object var1) {
      return this.method5438((Friend)var1);
   }
}
