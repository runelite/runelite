import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
@Implements("CacheableNode")
public class class204 extends class208 {
   @ObfuscatedName("cj")
   @Export("previous")
   public class204 field3103;
   @ObfuscatedName("cy")
   @Export("next")
   public class204 field3104;

   @ObfuscatedName("fn")
   public void method3889() {
      if(this.field3104 != null) {
         this.field3104.field3103 = this.field3103;
         this.field3103.field3104 = this.field3104;
         this.field3103 = null;
         this.field3104 = null;
      }
   }
}
