import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lq")
public class class320 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("n")
   String field3813;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   IndexDataBase field3814;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1362180319
   )
   int field3810;
   @ObfuscatedName("j")
   boolean field3812;

   @ObfuscatedSignature(
      signature = "(Liv;)V"
   )
   class320(IndexDataBase var1) {
      this.field3810 = 0;
      this.field3812 = false;
      this.field3814 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "724147284"
   )
   void method6042(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3813) {
            this.field3813 = var1;
            this.field3810 = 0;
            this.field3812 = false;
            this.method6034();
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1747682512"
   )
   int method6034() {
      if(this.field3810 < 25) {
         if(!this.field3814.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, this.field3813)) {
            return this.field3810;
         }

         this.field3810 = 25;
      }

      if(this.field3810 == 25) {
         if(!this.field3814.tryLoadRecordByNames(this.field3813, MapCacheArchiveNames.AREA.name)) {
            return 25 + this.field3814.archiveLoadPercentByName(this.field3813) * 25 / 100;
         }

         this.field3810 = 50;
      }

      if(this.field3810 == 50) {
         if(this.field3814.method4689(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field3813) && !this.field3814.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field3813)) {
            return 50;
         }

         this.field3810 = 75;
      }

      if(this.field3810 == 75) {
         if(!this.field3814.tryLoadRecordByNames(this.field3813, MapCacheArchiveNames.LABELS.name)) {
            return 75;
         }

         this.field3810 = 100;
         this.field3812 = true;
      }

      return this.field3810;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1636039541"
   )
   boolean method6035() {
      return this.field3812;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1998455094"
   )
   int method6036() {
      return this.field3810;
   }
}
