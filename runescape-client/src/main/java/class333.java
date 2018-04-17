import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lw")
public class class333 {
   @ObfuscatedName("m")
   String field4000;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   IndexDataBase field4003;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -154841371
   )
   int field4004;
   @ObfuscatedName("u")
   boolean field4005;

   @ObfuscatedSignature(
      signature = "(Ljf;)V"
   )
   class333(IndexDataBase var1) {
      this.field4004 = 0;
      this.field4005 = false;
      this.field4003 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "331392099"
   )
   void method5995(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field4000) {
            this.field4000 = var1;
            this.field4004 = 0;
            this.field4005 = false;
            this.method5996();
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "14"
   )
   int method5996() {
      if(this.field4004 < 25) {
         if(!this.field4003.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, this.field4000)) {
            return this.field4004;
         }

         this.field4004 = 25;
      }

      if(this.field4004 == 25) {
         if(!this.field4003.tryLoadRecordByNames(this.field4000, MapCacheArchiveNames.AREA.name)) {
            return 25 + this.field4003.archiveLoadPercentByName(this.field4000) * 25 / 100;
         }

         this.field4004 = 50;
      }

      if(this.field4004 == 50) {
         if(this.field4003.method4599(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field4000) && !this.field4003.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field4000)) {
            return 50;
         }

         this.field4004 = 75;
      }

      if(this.field4004 == 75) {
         if(!this.field4003.tryLoadRecordByNames(this.field4000, MapCacheArchiveNames.LABELS.name)) {
            return 75;
         }

         this.field4004 = 100;
         this.field4005 = true;
      }

      return this.field4004;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2021900848"
   )
   boolean method5997() {
      return this.field4005;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "16"
   )
   int method5998() {
      return this.field4004;
   }
}
