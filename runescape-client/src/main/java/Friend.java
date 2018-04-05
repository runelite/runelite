import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
@Implements("Friend")
public class Friend extends ChatPlayer {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static IndexDataBase field3864;
   @ObfuscatedName("o")
   boolean field3862;
   @ObfuscatedName("k")
   boolean field3861;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkh;I)I",
      garbageValue = "-187135044"
   )
   int method5445(Friend var1) {
      return super.world == Client.world && Client.world != var1.world?-1:(Client.world == var1.world && super.world != Client.world?1:(super.world != 0 && var1.world == 0?-1:(var1.world != 0 && super.world == 0?1:(this.field3862 && !var1.field3862?-1:(!this.field3862 && var1.field3862?1:(this.field3861 && !var1.field3861?-1:(!this.field3861 && var1.field3861?1:(super.world != 0?super.field3845 - var1.field3845:var1.field3845 - super.field3845))))))));
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lku;I)I",
      garbageValue = "-1796643174"
   )
   public int vmethod5448(Nameable var1) {
      return this.method5445((Friend)var1);
   }

   public int compareTo(Object var1) {
      return this.method5445((Friend)var1);
   }
}
