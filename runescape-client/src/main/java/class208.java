import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hk")
@Implements("Node")
public class class208 {
   @ObfuscatedName("ez")
   @Export("hash")
   public long field3113;
   @ObfuscatedName("eg")
   @Export("next")
   public class208 field3114;
   @ObfuscatedName("er")
   @Export("previous")
   class208 field3115;

   @ObfuscatedName("jt")
   @Export("linked")
   public boolean method3911() {
      return this.field3115 != null;
   }

   @ObfuscatedName("ji")
   @Export("unlink")
   public void method3916() {
      if(this.field3115 != null) {
         this.field3115.field3114 = this.field3114;
         this.field3114.field3115 = this.field3115;
         this.field3114 = null;
         this.field3115 = null;
      }
   }
}
