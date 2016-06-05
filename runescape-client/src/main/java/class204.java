import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
@Implements("CacheableNode")
public class class204 extends class208 {
   @ObfuscatedName("cm")
   @Export("previous")
   public class204 field3114;
   @ObfuscatedName("cy")
   @Export("next")
   public class204 field3115;

   @ObfuscatedName("fj")
   public void method3844() {
      if(this.field3115 != null) {
         this.field3115.field3114 = this.field3114;
         this.field3114.field3115 = this.field3115;
         this.field3114 = null;
         this.field3115 = null;
      }
   }
}
