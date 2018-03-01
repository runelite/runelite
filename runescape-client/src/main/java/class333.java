import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
public class class333 {
   @ObfuscatedName("y")
   String field4000;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   IndexDataBase field4001;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1938351847
   )
   int field3998;
   @ObfuscatedName("p")
   boolean field4003;

   @ObfuscatedSignature(
      signature = "(Ljk;)V"
   )
   class333(IndexDataBase var1) {
      this.field3998 = 0;
      this.field4003 = false;
      this.field4001 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-551502548"
   )
   void method6053(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field4000) {
            this.field4000 = var1;
            this.field3998 = 0;
            this.field4003 = false;
            this.method6054();
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1167777833"
   )
   int method6054() {
      if(this.field3998 < 25) {
         if(!this.field4001.tryLoadRecordByNames(class41.field541.field542, this.field4000)) {
            return this.field3998;
         }

         this.field3998 = 25;
      }

      if(this.field3998 == 25) {
         if(!this.field4001.tryLoadRecordByNames(this.field4000, class41.field544.field542)) {
            return 25 + this.field4001.archiveLoadPercentByName(this.field4000) * 25 / 100;
         }

         this.field3998 = 50;
      }

      if(this.field3998 == 50) {
         if(this.field4001.method4689(class41.field548.field542, this.field4000) && !this.field4001.tryLoadRecordByNames(class41.field548.field542, this.field4000)) {
            return 50;
         }

         this.field3998 = 75;
      }

      if(this.field3998 == 75) {
         if(!this.field4001.tryLoadRecordByNames(this.field4000, class41.field545.field542)) {
            return 75;
         }

         this.field3998 = 100;
         this.field4003 = true;
      }

      return this.field3998;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1289580997"
   )
   boolean method6055() {
      return this.field4003;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   int method6056() {
      return this.field3998;
   }
}
