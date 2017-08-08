import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
public class class288 {
   @ObfuscatedName("r")
   boolean field3789;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1384361181
   )
   int field3787;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   IndexDataBase field3790;
   @ObfuscatedName("k")
   String field3786;

   @ObfuscatedSignature(
      signature = "(Lit;)V"
   )
   class288(IndexDataBase var1) {
      this.field3787 = 0;
      this.field3789 = false;
      this.field3790 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "502684852"
   )
   int method5222() {
      if(this.field3787 < 25) {
         if(!this.field3790.method4134(class40.field535.field540, this.field3786)) {
            return this.field3787;
         }

         this.field3787 = 25;
      }

      if(this.field3787 == 25) {
         if(!this.field3790.method4134(this.field3786, class40.field538.field540)) {
            return 25 + this.field3790.method4137(this.field3786) * 25 / 100;
         }

         this.field3787 = 50;
      }

      if(this.field3787 == 50) {
         if(this.field3790.method4132(class40.field536.field540, this.field3786) && !this.field3790.method4134(class40.field536.field540, this.field3786)) {
            return 50;
         }

         this.field3787 = 75;
      }

      if(this.field3787 == 75) {
         if(!this.field3790.method4134(this.field3786, class40.field539.field540)) {
            return 75;
         }

         this.field3787 = 100;
         this.field3789 = true;
      }

      return this.field3787;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "3713"
   )
   boolean method5212() {
      return this.field3789;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1025588760"
   )
   void method5210(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3786) {
            this.field3786 = var1;
            this.field3787 = 0;
            this.field3789 = false;
            this.method5222();
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1862603888"
   )
   int method5213() {
      return this.field3787;
   }
}
