import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
public class class281 extends class273 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 216251869
   )
   public int field3705;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -781877595
   )
   public int field3707;
   @ObfuscatedName("w")
   boolean field3706;
   @ObfuscatedName("s")
   boolean field3704;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljc;I)I",
      garbageValue = "2141076686"
   )
   int method5151(class281 var1) {
      return this.field3705 == Client.world && Client.world != var1.field3705?-1:(Client.world == var1.field3705 && this.field3705 != Client.world?1:(this.field3705 != 0 && var1.field3705 == 0?-1:(var1.field3705 != 0 && this.field3705 == 0?1:(this.field3706 && !var1.field3706?-1:(!this.field3706 && var1.field3706?1:(this.field3704 && !var1.field3704?-1:(!this.field3704 && var1.field3704?1:super.vmethod5152(var1))))))));
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lju;B)I",
      garbageValue = "1"
   )
   int vmethod5152(class273 var1) {
      return this.method5151((class281)var1);
   }

   public int compareTo(Object var1) {
      return this.method5151((class281)var1);
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   static final void method5158() {
      if(DecorativeObject.soundSystem1 != null) {
         DecorativeObject.soundSystem1.method2184();
      }

      if(CombatInfoListHolder.soundSystem0 != null) {
         CombatInfoListHolder.soundSystem0.method2184();
      }

   }
}
