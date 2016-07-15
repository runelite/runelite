import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
@Implements("CacheableNode")
public class class207 extends class211 {
   @ObfuscatedName("cm")
   @Export("next")
   public class207 field3151;
   @ObfuscatedName("cq")
   @Export("previous")
   public class207 field3152;

   @ObfuscatedName("fl")
   public void method3978() {
      if(this.field3151 != null) {
         this.field3151.field3152 = this.field3152;
         this.field3152.field3151 = this.field3151;
         this.field3152 = null;
         this.field3151 = null;
      }
   }
}
