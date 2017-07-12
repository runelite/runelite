import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
public class class287 {
   @ObfuscatedName("r")
   String field3807;
   @ObfuscatedName("v")
   IndexDataBase field3808;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -721163537
   )
   int field3809;
   @ObfuscatedName("j")
   boolean field3810;

   class287(IndexDataBase var1) {
      this.field3809 = 0;
      this.field3810 = false;
      this.field3808 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2082301828"
   )
   boolean method5163() {
      return this.field3810;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1495111999"
   )
   int method5164() {
      return this.field3809;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2033313589"
   )
   int method5170() {
      if(this.field3809 < 25) {
         if(!this.field3808.method4134(class40.field562.field566, this.field3807)) {
            return this.field3809;
         }

         this.field3809 = 25;
      }

      if(this.field3809 == 25) {
         if(!this.field3808.method4134(this.field3807, class40.field561.field566)) {
            return 25 + this.field3808.method4118(this.field3807) * 25 / 100;
         }

         this.field3809 = 50;
      }

      if(this.field3809 == 50) {
         if(this.field3808.method4190(class40.field567.field566, this.field3807) && !this.field3808.method4134(class40.field567.field566, this.field3807)) {
            return 50;
         }

         this.field3809 = 75;
      }

      if(this.field3809 == 75) {
         if(!this.field3808.method4134(this.field3807, class40.field565.field566)) {
            return 75;
         }

         this.field3809 = 100;
         this.field3810 = true;
      }

      return this.field3809;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-186137854"
   )
   void method5176(String var1) {
      if(var1 != null && !var1.isEmpty() && this.field3807 != var1) {
         this.field3807 = var1;
         this.field3809 = 0;
         this.field3810 = false;
         this.method5170();
      }

   }
}
