import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
public class class296 {
   @ObfuscatedName("m")
   String field3858;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   IndexDataBase field3856;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -798318543
   )
   int field3859;
   @ObfuscatedName("p")
   boolean field3857;

   @ObfuscatedSignature(
      signature = "(Lid;)V"
   )
   class296(IndexDataBase var1) {
      this.field3859 = 0;
      this.field3857 = false;
      this.field3856 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1914131105"
   )
   void method5391(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3858) {
            this.field3858 = var1;
            this.field3859 = 0;
            this.field3857 = false;
            this.method5384();
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1664688465"
   )
   int method5384() {
      if(this.field3859 < 25) {
         if(!this.field3856.method4285(class40.field515.field517, this.field3858)) {
            return this.field3859;
         }

         this.field3859 = 25;
      }

      if(this.field3859 == 25) {
         if(!this.field3856.method4285(this.field3858, class40.field519.field517)) {
            return 25 + this.field3856.method4296(this.field3858) * 25 / 100;
         }

         this.field3859 = 50;
      }

      if(this.field3859 == 50) {
         if(this.field3856.method4283(class40.field516.field517, this.field3858) && !this.field3856.method4285(class40.field516.field517, this.field3858)) {
            return 50;
         }

         this.field3859 = 75;
      }

      if(this.field3859 == 75) {
         if(!this.field3856.method4285(this.field3858, class40.field518.field517)) {
            return 75;
         }

         this.field3859 = 100;
         this.field3857 = true;
      }

      return this.field3859;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-495685061"
   )
   boolean method5380() {
      return this.field3857;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-505913184"
   )
   int method5381() {
      return this.field3859;
   }
}
