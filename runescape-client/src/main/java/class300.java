import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
public class class300 {
   @ObfuscatedName("d")
   String field3873;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   IndexDataBase field3878;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1542734975
   )
   int field3877;
   @ObfuscatedName("e")
   boolean field3880;

   @ObfuscatedSignature(
      signature = "(Lil;)V"
   )
   class300(IndexDataBase var1) {
      this.field3877 = 0;
      this.field3880 = false;
      this.field3878 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1363770811"
   )
   void method5412(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3873) {
            this.field3873 = var1;
            this.field3877 = 0;
            this.field3880 = false;
            this.method5413();
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1263235962"
   )
   int method5413() {
      if(this.field3877 < 25) {
         if(!this.field3878.tryLoadRecordByNames(class40.field518.field517, this.field3873)) {
            return this.field3877;
         }

         this.field3877 = 25;
      }

      if(this.field3877 == 25) {
         if(!this.field3878.tryLoadRecordByNames(this.field3873, class40.field521.field517)) {
            return 25 + this.field3878.archiveLoadPercentByName(this.field3873) * 25 / 100;
         }

         this.field3877 = 50;
      }

      if(this.field3877 == 50) {
         if(this.field3878.method4321(class40.field519.field517, this.field3873) && !this.field3878.tryLoadRecordByNames(class40.field519.field517, this.field3873)) {
            return 50;
         }

         this.field3877 = 75;
      }

      if(this.field3877 == 75) {
         if(!this.field3878.tryLoadRecordByNames(this.field3873, class40.field520.field517)) {
            return 75;
         }

         this.field3877 = 100;
         this.field3880 = true;
      }

      return this.field3877;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "5"
   )
   boolean method5414() {
      return this.field3880;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1545817768"
   )
   int method5415() {
      return this.field3877;
   }
}
