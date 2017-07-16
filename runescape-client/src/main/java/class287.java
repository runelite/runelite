import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
public class class287 {
   @ObfuscatedName("w")
   boolean field3803;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 204082539
   )
   int field3804;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   IndexDataBase field3799;
   @ObfuscatedName("e")
   String field3802;

   @ObfuscatedSignature(
      signature = "(Lif;)V"
   )
   class287(IndexDataBase var1) {
      this.field3804 = 0;
      this.field3803 = false;
      this.field3799 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1795805578"
   )
   int method5096() {
      if(this.field3804 < 25) {
         if(!this.field3799.method4101(class40.field528.field532, this.field3802)) {
            return this.field3804;
         }

         this.field3804 = 25;
      }

      if(this.field3804 == 25) {
         if(!this.field3799.method4101(this.field3802, class40.field533.field532)) {
            return 25 + this.field3799.method4112(this.field3802) * 25 / 100;
         }

         this.field3804 = 50;
      }

      if(this.field3804 == 50) {
         if(this.field3799.method4084(class40.field529.field532, this.field3802) && !this.field3799.method4101(class40.field529.field532, this.field3802)) {
            return 50;
         }

         this.field3804 = 75;
      }

      if(this.field3804 == 75) {
         if(!this.field3799.method4101(this.field3802, class40.field531.field532)) {
            return 75;
         }

         this.field3804 = 100;
         this.field3803 = true;
      }

      return this.field3804;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "662396375"
   )
   boolean method5103() {
      return this.field3803;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1293277822"
   )
   void method5101(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3802) {
            this.field3802 = var1;
            this.field3804 = 0;
            this.field3803 = false;
            this.method5096();
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1261889066"
   )
   int method5097() {
      return this.field3804;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   static int method5105(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
