import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
public class class300 {
   @ObfuscatedName("z")
   String field3871;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   IndexDataBase field3872;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -462634383
   )
   int field3876;
   @ObfuscatedName("g")
   boolean field3877;

   @ObfuscatedSignature(
      signature = "(Lib;)V"
   )
   class300(IndexDataBase var1) {
      this.field3876 = 0;
      this.field3877 = false;
      this.field3872 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1815427242"
   )
   void method5332(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3871) {
            this.field3871 = var1;
            this.field3876 = 0;
            this.field3877 = false;
            this.method5328();
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-733919187"
   )
   int method5328() {
      if(this.field3876 < 25) {
         if(!this.field3872.tryLoadRecordByNames(NamedRecord.field508.field514, this.field3871)) {
            return this.field3876;
         }

         this.field3876 = 25;
      }

      if(this.field3876 == 25) {
         if(!this.field3872.tryLoadRecordByNames(this.field3871, NamedRecord.field511.field514)) {
            return 25 + this.field3872.archiveLoadPercentByName(this.field3871) * 25 / 100;
         }

         this.field3876 = 50;
      }

      if(this.field3876 == 50) {
         if(this.field3872.method4273(NamedRecord.field513.field514, this.field3871) && !this.field3872.tryLoadRecordByNames(NamedRecord.field513.field514, this.field3871)) {
            return 50;
         }

         this.field3876 = 75;
      }

      if(this.field3876 == 75) {
         if(!this.field3872.tryLoadRecordByNames(this.field3871, NamedRecord.field512.field514)) {
            return 75;
         }

         this.field3876 = 100;
         this.field3877 = true;
      }

      return this.field3876;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "561437912"
   )
   boolean method5337() {
      return this.field3877;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   int method5329() {
      return this.field3876;
   }
}
