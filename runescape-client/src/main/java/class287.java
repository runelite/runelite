import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
public class class287 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -499876773
   )
   int field3796;
   @ObfuscatedName("c")
   IndexDataBase field3800;
   @ObfuscatedName("m")
   String field3801;
   @ObfuscatedName("h")
   boolean field3802;

   class287(IndexDataBase var1) {
      this.field3796 = 0;
      this.field3802 = false;
      this.field3800 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-105"
   )
   int method5206() {
      if(this.field3796 < 25) {
         if(!this.field3800.method4145(class40.field544.field543, this.field3801)) {
            return this.field3796;
         }

         this.field3796 = 25;
      }

      if(this.field3796 == 25) {
         if(!this.field3800.method4145(this.field3801, class40.field542.field543)) {
            return this.field3800.method4172(this.field3801) * 25 / 100 + 25;
         }

         this.field3796 = 50;
      }

      if(this.field3796 == 50) {
         if(this.field3800.method4193(class40.field541.field543, this.field3801) && !this.field3800.method4145(class40.field541.field543, this.field3801)) {
            return 50;
         }

         this.field3796 = 75;
      }

      if(this.field3796 == 75) {
         if(!this.field3800.method4145(this.field3801, class40.field539.field543)) {
            return 75;
         }

         this.field3796 = 100;
         this.field3802 = true;
      }

      return this.field3796;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1971007952"
   )
   void method5207(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(this.field3801 != var1) {
            this.field3801 = var1;
            this.field3796 = 0;
            this.field3802 = false;
            this.method5206();
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1728611566"
   )
   int method5208() {
      return this.field3796;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1910810901"
   )
   boolean method5211() {
      return this.field3802;
   }
}
