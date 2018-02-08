import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
public class class311 {
   @ObfuscatedName("w")
   String field3916;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   IndexDataBase field3917;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -646630637
   )
   int field3918;
   @ObfuscatedName("z")
   boolean field3919;

   @ObfuscatedSignature(
      signature = "(Lir;)V"
   )
   class311(IndexDataBase var1) {
      this.field3918 = 0;
      this.field3919 = false;
      this.field3917 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2130917929"
   )
   void method5795(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3916) {
            this.field3916 = var1;
            this.field3918 = 0;
            this.field3919 = false;
            this.method5796();
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-377601582"
   )
   int method5796() {
      if(this.field3918 < 25) {
         if(!this.field3917.tryLoadRecordByNames(class40.field516.field515, this.field3916)) {
            return this.field3918;
         }

         this.field3918 = 25;
      }

      if(this.field3918 == 25) {
         if(!this.field3917.tryLoadRecordByNames(this.field3916, class40.field518.field515)) {
            return 25 + this.field3917.archiveLoadPercentByName(this.field3916) * 25 / 100;
         }

         this.field3918 = 50;
      }

      if(this.field3918 == 50) {
         if(this.field3917.method4502(class40.field517.field515, this.field3916) && !this.field3917.tryLoadRecordByNames(class40.field517.field515, this.field3916)) {
            return 50;
         }

         this.field3918 = 75;
      }

      if(this.field3918 == 75) {
         if(!this.field3917.tryLoadRecordByNames(this.field3916, class40.field519.field515)) {
            return 75;
         }

         this.field3918 = 100;
         this.field3919 = true;
      }

      return this.field3918;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "271752723"
   )
   boolean method5797() {
      return this.field3919;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1567033695"
   )
   int method5805() {
      return this.field3918;
   }
}
