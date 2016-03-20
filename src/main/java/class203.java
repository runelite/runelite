import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
@Implements("CacheableNode")
public class class203 extends class207 {
   @ObfuscatedName("cm")
   @Export("next")
   public class203 field3099;
   @ObfuscatedName("cu")
   @Export("previous")
   public class203 field3100;

   @ObfuscatedName("eb")
   public void method3920() {
      if(this.field3099 != null) {
         this.field3099.field3100 = this.field3100;
         this.field3100.field3099 = this.field3099;
         this.field3100 = null;
         this.field3099 = null;
      }
   }
}
