import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
public class class296 {
   @ObfuscatedName("f")
   String field3857;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   IndexDataBase field3855;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -162162585
   )
   int field3851;
   @ObfuscatedName("k")
   boolean field3853;

   @ObfuscatedSignature(
      signature = "(Lij;)V"
   )
   class296(IndexDataBase var1) {
      this.field3851 = 0;
      this.field3853 = false;
      this.field3855 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-212311953"
   )
   void method5224(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3857) {
            this.field3857 = var1;
            this.field3851 = 0;
            this.field3853 = false;
            this.method5235();
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "828836836"
   )
   int method5235() {
      if(this.field3851 < 25) {
         if(!this.field3855.method4127(class40.field500.field504, this.field3857)) {
            return this.field3851;
         }

         this.field3851 = 25;
      }

      if(this.field3851 == 25) {
         if(!this.field3855.method4127(this.field3857, class40.field502.field504)) {
            return 25 + this.field3855.method4128(this.field3857) * 25 / 100;
         }

         this.field3851 = 50;
      }

      if(this.field3851 == 50) {
         if(this.field3855.method4125(class40.field501.field504, this.field3857) && !this.field3855.method4127(class40.field501.field504, this.field3857)) {
            return 50;
         }

         this.field3851 = 75;
      }

      if(this.field3851 == 75) {
         if(!this.field3855.method4127(this.field3857, class40.field503.field504)) {
            return 75;
         }

         this.field3851 = 100;
         this.field3853 = true;
      }

      return this.field3851;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-244770159"
   )
   boolean method5226() {
      return this.field3853;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   int method5230() {
      return this.field3851;
   }
}
