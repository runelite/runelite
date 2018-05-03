import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
public class class333 {
   @ObfuscatedName("l")
   String field4005;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   IndexDataBase field4006;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -379382937
   )
   int field4007;
   @ObfuscatedName("c")
   boolean field4008;

   @ObfuscatedSignature(
      signature = "(Ljr;)V"
   )
   class333(IndexDataBase var1) {
      this.field4007 = 0;
      this.field4008 = false;
      this.field4006 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "92"
   )
   void method6060(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field4005) {
            this.field4005 = var1;
            this.field4007 = 0;
            this.field4008 = false;
            this.method6056();
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1166661501"
   )
   int method6056() {
      if(this.field4007 < 25) {
         if(!this.field4006.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, this.field4005)) {
            return this.field4007;
         }

         this.field4007 = 25;
      }

      if(this.field4007 == 25) {
         if(!this.field4006.tryLoadRecordByNames(this.field4005, MapCacheArchiveNames.AREA.name)) {
            return 25 + this.field4006.archiveLoadPercentByName(this.field4005) * 25 / 100;
         }

         this.field4007 = 50;
      }

      if(this.field4007 == 50) {
         if(this.field4006.method4663(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field4005) && !this.field4006.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field4005)) {
            return 50;
         }

         this.field4007 = 75;
      }

      if(this.field4007 == 75) {
         if(!this.field4006.tryLoadRecordByNames(this.field4005, MapCacheArchiveNames.LABELS.name)) {
            return 75;
         }

         this.field4007 = 100;
         this.field4008 = true;
      }

      return this.field4007;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1707233772"
   )
   boolean method6053() {
      return this.field4008;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1104410433"
   )
   int method6051() {
      return this.field4007;
   }
}
