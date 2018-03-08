import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
public class class333 {
   @ObfuscatedName("b")
   String field4003;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   IndexDataBase field4005;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -264227029
   )
   int field4004;
   @ObfuscatedName("p")
   boolean field4006;

   @ObfuscatedSignature(
      signature = "(Ljc;)V"
   )
   class333(IndexDataBase var1) {
      this.field4004 = 0;
      this.field4006 = false;
      this.field4005 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1677725568"
   )
   void method5974(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field4003) {
            this.field4003 = var1;
            this.field4004 = 0;
            this.field4006 = false;
            this.method5981();
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "84"
   )
   int method5981() {
      if(this.field4004 < 25) {
         if(!this.field4005.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, this.field4003)) {
            return this.field4004;
         }

         this.field4004 = 25;
      }

      if(this.field4004 == 25) {
         if(!this.field4005.tryLoadRecordByNames(this.field4003, MapCacheArchiveNames.AREA.name)) {
            return 25 + this.field4005.archiveLoadPercentByName(this.field4003) * 25 / 100;
         }

         this.field4004 = 50;
      }

      if(this.field4004 == 50) {
         if(this.field4005.method4584(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field4003) && !this.field4005.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field4003)) {
            return 50;
         }

         this.field4004 = 75;
      }

      if(this.field4004 == 75) {
         if(!this.field4005.tryLoadRecordByNames(this.field4003, MapCacheArchiveNames.LABELS.name)) {
            return 75;
         }

         this.field4004 = 100;
         this.field4006 = true;
      }

      return this.field4004;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-325319175"
   )
   boolean method5973() {
      return this.field4006;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
   )
   int method5977() {
      return this.field4004;
   }
}
