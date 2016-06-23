import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
@Implements("CacheableNode")
public class class204 extends class208 {
   @ObfuscatedName("cw")
   @Export("previous")
   public class204 field3105;
   @ObfuscatedName("ck")
   @Export("next")
   public class204 field3106;

   @ObfuscatedName("fd")
   public void method3922() {
      if(this.field3106 != null) {
         this.field3106.field3105 = this.field3105;
         this.field3105.field3106 = this.field3106;
         this.field3105 = null;
         this.field3106 = null;
      }
   }
}
