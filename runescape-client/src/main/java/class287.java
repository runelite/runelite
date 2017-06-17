import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
public class class287 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 643768189
   )
   int field3799;
   @ObfuscatedName("f")
   boolean field3801;
   @ObfuscatedName("z")
   String field3802;
   @ObfuscatedName("j")
   IndexDataBase field3803;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "219600729"
   )
   void method5032(String var1) {
      if(var1 != null && !var1.isEmpty() && var1 != this.field3802) {
         this.field3802 = var1;
         this.field3799 = 0;
         this.field3801 = false;
         this.method5033();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "648092932"
   )
   int method5033() {
      if(this.field3799 < 25) {
         if(!this.field3803.method4026(class40.field547.field548, this.field3802)) {
            return this.field3799;
         }

         this.field3799 = 25;
      }

      if(this.field3799 == 25) {
         if(!this.field3803.method4026(this.field3802, class40.field551.field548)) {
            return this.field3803.method4018(this.field3802) * 25 / 100 + 25;
         }

         this.field3799 = 50;
      }

      if(this.field3799 == 50) {
         if(this.field3803.method4013(class40.field557.field548, this.field3802) && !this.field3803.method4026(class40.field557.field548, this.field3802)) {
            return 50;
         }

         this.field3799 = 75;
      }

      if(this.field3799 == 75) {
         if(!this.field3803.method4026(this.field3802, class40.field550.field548)) {
            return 75;
         }

         this.field3799 = 100;
         this.field3801 = true;
      }

      return this.field3799;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "97"
   )
   boolean method5034() {
      return this.field3801;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-714740306"
   )
   int method5035() {
      return this.field3799;
   }

   class287(IndexDataBase var1) {
      this.field3799 = 0;
      this.field3801 = false;
      this.field3803 = var1;
   }
}
