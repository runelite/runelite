import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
public class class324 {
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "Llk;"
   )
   @Export("rasterProvider")
   public static BufferProvider rasterProvider;
   @ObfuscatedName("h")
   String field3921;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   IndexDataBase field3924;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2028078853
   )
   int field3923;
   @ObfuscatedName("g")
   boolean field3920;

   @ObfuscatedSignature(
      signature = "(Lie;)V"
   )
   class324(IndexDataBase var1) {
      this.field3923 = 0;
      this.field3920 = false;
      this.field3924 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1280164085"
   )
   void method5949(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3921) {
            this.field3921 = var1;
            this.field3923 = 0;
            this.field3920 = false;
            this.method5950();
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1527505793"
   )
   int method5950() {
      if(this.field3923 < 25) {
         if(!this.field3924.tryLoadRecordByNames(class40.field503.field502, this.field3921)) {
            return this.field3923;
         }

         this.field3923 = 25;
      }

      if(this.field3923 == 25) {
         if(!this.field3924.tryLoadRecordByNames(this.field3921, class40.field500.field502)) {
            return 25 + this.field3924.archiveLoadPercentByName(this.field3921) * 25 / 100;
         }

         this.field3923 = 50;
      }

      if(this.field3923 == 50) {
         if(this.field3924.method4539(class40.field506.field502, this.field3921) && !this.field3924.tryLoadRecordByNames(class40.field506.field502, this.field3921)) {
            return 50;
         }

         this.field3923 = 75;
      }

      if(this.field3923 == 75) {
         if(!this.field3924.tryLoadRecordByNames(this.field3921, class40.field501.field502)) {
            return 75;
         }

         this.field3923 = 100;
         this.field3920 = true;
      }

      return this.field3923;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-76"
   )
   boolean method5958() {
      return this.field3920;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-247862294"
   )
   int method5952() {
      return this.field3923;
   }
}
