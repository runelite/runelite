import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gh")
public class class207 {
   @ObfuscatedName("y")
   class207 field3121;
   @ObfuscatedName("c")
   class207 field3122;

   @ObfuscatedName("a")
   public void method3994() {
      if(this.field3121 != null) {
         this.field3121.field3122 = this.field3122;
         this.field3122.field3121 = this.field3121;
         this.field3122 = null;
         this.field3121 = null;
      }
   }
}
