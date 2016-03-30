import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
@Implements("CacheableNode")
public class class204 extends class208 {
   @ObfuscatedName("cd")
   @Export("next")
   public class204 field3113;
   @ObfuscatedName("cf")
   @Export("previous")
   public class204 field3114;

   @ObfuscatedName("fv")
   public void method3909() {
      if(this.field3113 != null) {
         this.field3113.field3114 = this.field3114;
         this.field3114.field3113 = this.field3113;
         this.field3114 = null;
         this.field3113 = null;
      }
   }
}
