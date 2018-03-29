import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lw")
public class class333 {
   @ObfuscatedName("x")
   String field3998;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   IndexDataBase field4000;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -534960787
   )
   int field3995;
   @ObfuscatedName("w")
   boolean field4001;

   @ObfuscatedSignature(
      signature = "(Ljm;)V"
   )
   class333(IndexDataBase var1) {
      this.field3995 = 0;
      this.field4001 = false;
      this.field4000 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-452363258"
   )
   void method5994(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3998) {
            this.field3998 = var1;
            this.field3995 = 0;
            this.field4001 = false;
            this.method5995();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "344420033"
   )
   int method5995() {
      if(this.field3995 < 25) {
         if(!this.field4000.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, this.field3998)) {
            return this.field3995;
         }

         this.field3995 = 25;
      }

      if(this.field3995 == 25) {
         if(!this.field4000.tryLoadRecordByNames(this.field3998, MapCacheArchiveNames.AREA.name)) {
            return 25 + this.field4000.archiveLoadPercentByName(this.field3998) * 25 / 100;
         }

         this.field3995 = 50;
      }

      if(this.field3995 == 50) {
         if(this.field4000.method4571(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field3998) && !this.field4000.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field3998)) {
            return 50;
         }

         this.field3995 = 75;
      }

      if(this.field3995 == 75) {
         if(!this.field4000.tryLoadRecordByNames(this.field3998, MapCacheArchiveNames.LABELS.name)) {
            return 75;
         }

         this.field3995 = 100;
         this.field4001 = true;
      }

      return this.field3995;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1758694332"
   )
   boolean method5999() {
      return this.field4001;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-924662176"
   )
   int method5997() {
      return this.field3995;
   }
}
