import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
@Implements("CacheableNode")
public class class204 extends class208 {
   @ObfuscatedName("cl")
   @Export("previous")
   public class204 field3112;
   @ObfuscatedName("cp")
   @Export("next")
   public class204 field3113;

   @ObfuscatedName("fq")
   public void method3863() {
      if(this.field3113 != null) {
         this.field3113.field3112 = this.field3112;
         this.field3112.field3113 = this.field3113;
         this.field3112 = null;
         this.field3113 = null;
      }
   }
}
