import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("Friend")
public class Friend extends ChatPlayer {
   @ObfuscatedName("d")
   boolean field3854;
   @ObfuscatedName("z")
   boolean field3855;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lke;I)I",
      garbageValue = "-1108105906"
   )
   int method5554(Friend var1) {
      return super.world == Client.world && Client.world != var1.world?-1:(Client.world == var1.world && super.world != Client.world?1:(super.world != 0 && var1.world == 0?-1:(var1.world != 0 && super.world == 0?1:(this.field3854 && !var1.field3854?-1:(!this.field3854 && var1.field3854?1:(this.field3855 && !var1.field3855?-1:(!this.field3855 && var1.field3855?1:(super.world != 0?super.field3840 - var1.field3840:var1.field3840 - super.field3840))))))));
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lkm;I)I",
      garbageValue = "-1994435588"
   )
   public int vmethod5558(Nameable var1) {
      return this.method5554((Friend)var1);
   }

   public int compareTo(Object var1) {
      return this.method5554((Friend)var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)Lkw;",
      garbageValue = "-1934882318"
   )
   static Font method5560(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class332.field3990, class332.offsetsY, Varbit.field3539, BoundingBox2D.field242, class332.field3994, class332.spritePixels);
         class151.method3208();
         return var1;
      }
   }
}
