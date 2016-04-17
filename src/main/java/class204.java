import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
@Implements("CacheableNode")
public class class204 extends class208 {
   @ObfuscatedName("cj")
   @Export("next")
   public class204 field3113;
   @ObfuscatedName("cn")
   @Export("previous")
   public class204 field3114;

   @ObfuscatedName("fp")
   public void method3979() {
      if(this.field3113 != null) {
         this.field3113.field3114 = this.field3114;
         this.field3114.field3113 = this.field3113;
         this.field3114 = null;
         this.field3113 = null;
      }
   }
}
