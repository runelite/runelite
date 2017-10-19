import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
public class class288 {
   @ObfuscatedName("d")
   boolean field3811;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 817525333
   )
   int field3817;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   IndexDataBase field3815;
   @ObfuscatedName("v")
   String field3816;

   @ObfuscatedSignature(
      signature = "(Lip;)V"
   )
   class288(IndexDataBase var1) {
      this.field3817 = 0;
      this.field3811 = false;
      this.field3815 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "4"
   )
   int method5290() {
      if(this.field3817 < 25) {
         if(!this.field3815.method4210(class40.field564.field563, this.field3816)) {
            return this.field3817;
         }

         this.field3817 = 25;
      }

      if(this.field3817 == 25) {
         if(!this.field3815.method4210(this.field3816, class40.field566.field563)) {
            return 25 + this.field3815.method4213(this.field3816) * 25 / 100;
         }

         this.field3817 = 50;
      }

      if(this.field3817 == 50) {
         if(this.field3815.method4208(class40.field565.field563, this.field3816) && !this.field3815.method4210(class40.field565.field563, this.field3816)) {
            return 50;
         }

         this.field3817 = 75;
      }

      if(this.field3817 == 75) {
         if(!this.field3815.method4210(this.field3816, class40.field568.field563)) {
            return 75;
         }

         this.field3817 = 100;
         this.field3811 = true;
      }

      return this.field3817;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "499308205"
   )
   boolean method5289() {
      return this.field3811;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2007625071"
   )
   void method5279(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3816) {
            this.field3816 = var1;
            this.field3817 = 0;
            this.field3811 = false;
            this.method5290();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2147391919"
   )
   int method5282() {
      return this.field3817;
   }
}
