import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
@Implements("CacheableNode")
public class class204 extends class208 {
   @ObfuscatedName("ct")
   @Export("previous")
   public class204 field3114;
   @ObfuscatedName("ce")
   @Export("next")
   public class204 field3115;

   @ObfuscatedName("fw")
   public void method3876() {
      if(this.field3115 != null) {
         this.field3115.field3114 = this.field3114;
         this.field3114.field3115 = this.field3115;
         this.field3114 = null;
         this.field3115 = null;
      }
   }
}
