import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ha")
@Implements("Node")
public class class208 {
   @ObfuscatedName("es")
   @Export("previous")
   class208 field3123;
   @ObfuscatedName("ef")
   @Export("next")
   public class208 field3124;
   @ObfuscatedName("em")
   @Export("hash")
   public long field3125;

   @ObfuscatedName("iz")
   public void method3998() {
      if(this.field3123 != null) {
         this.field3123.field3124 = this.field3124;
         this.field3124.field3123 = this.field3123;
         this.field3124 = null;
         this.field3123 = null;
      }
   }

   @ObfuscatedName("jh")
   public boolean method4003() {
      return this.field3123 != null;
   }
}
