import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gh")
@Implements("CacheableNode")
public class class204 extends class208 {
   @ObfuscatedName("cw")
   @Export("next")
   public class204 field3104;
   @ObfuscatedName("ck")
   @Export("previous")
   public class204 field3105;

   @ObfuscatedName("fu")
   public void method3891() {
      if(this.field3104 != null) {
         this.field3104.field3105 = this.field3105;
         this.field3105.field3104 = this.field3104;
         this.field3105 = null;
         this.field3104 = null;
      }
   }
}
