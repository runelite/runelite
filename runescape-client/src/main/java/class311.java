import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public class class311 {
   @ObfuscatedName("a")
   String field3907;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   IndexDataBase field3905;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 148252747
   )
   int field3906;
   @ObfuscatedName("m")
   boolean field3900;

   @ObfuscatedSignature(
      signature = "(Lik;)V"
   )
   class311(IndexDataBase var1) {
      this.field3906 = 0;
      this.field3900 = false;
      this.field3905 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1967153694"
   )
   void method5645(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3907) {
            this.field3907 = var1;
            this.field3906 = 0;
            this.field3900 = false;
            this.method5644();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2039004459"
   )
   int method5644() {
      if(this.field3906 < 25) {
         if(!this.field3905.tryLoadRecordByNames(class40.field505.field509, this.field3907)) {
            return this.field3906;
         }

         this.field3906 = 25;
      }

      if(this.field3906 == 25) {
         if(!this.field3905.tryLoadRecordByNames(this.field3907, class40.field512.field509)) {
            return 25 + this.field3905.archiveLoadPercentByName(this.field3907) * 25 / 100;
         }

         this.field3906 = 50;
      }

      if(this.field3906 == 50) {
         if(this.field3905.method4434(class40.field506.field509, this.field3907) && !this.field3905.tryLoadRecordByNames(class40.field506.field509, this.field3907)) {
            return 50;
         }

         this.field3906 = 75;
      }

      if(this.field3906 == 75) {
         if(!this.field3905.tryLoadRecordByNames(this.field3907, class40.field507.field509)) {
            return 75;
         }

         this.field3906 = 100;
         this.field3900 = true;
      }

      return this.field3906;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1890088499"
   )
   boolean method5647() {
      return this.field3900;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "208996336"
   )
   int method5648() {
      return this.field3906;
   }
}
