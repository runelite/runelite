import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hd")
@Implements("Node")
public class class208 {
   @ObfuscatedName("ed")
   @Export("next")
   public class208 field3114;
   @ObfuscatedName("ej")
   @Export("hash")
   public long field3115;
   @ObfuscatedName("em")
   @Export("previous")
   class208 field3116;

   @ObfuscatedName("ht")
   public void method3913() {
      if(this.field3116 != null) {
         this.field3116.field3114 = this.field3114;
         this.field3114.field3116 = this.field3116;
         this.field3114 = null;
         this.field3116 = null;
      }
   }

   @ObfuscatedName("hp")
   public boolean method3915() {
      return this.field3116 != null;
   }
}
