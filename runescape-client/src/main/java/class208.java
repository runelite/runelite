import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hf")
@Implements("Node")
public class class208 {
   @ObfuscatedName("ex")
   @Export("hash")
   public long field3115;
   @ObfuscatedName("en")
   @Export("next")
   public class208 field3116;
   @ObfuscatedName("ec")
   @Export("previous")
   class208 field3117;

   @ObfuscatedName("ha")
   @Export("linked")
   public boolean method3942() {
      return this.field3117 != null;
   }

   @ObfuscatedName("hj")
   @Export("unlink")
   public void method3946() {
      if(this.field3117 != null) {
         this.field3117.field3116 = this.field3116;
         this.field3116.field3117 = this.field3117;
         this.field3116 = null;
         this.field3117 = null;
      }
   }
}
