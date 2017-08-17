import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
public class class288 {
   @ObfuscatedName("w")
   boolean field3793;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1025843053
   )
   int field3792;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   IndexDataBase field3791;
   @ObfuscatedName("g")
   String field3790;

   @ObfuscatedSignature(
      signature = "(Lia;)V"
   )
   class288(IndexDataBase var1) {
      this.field3792 = 0;
      this.field3793 = false;
      this.field3791 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-104"
   )
   int method5213() {
      if(this.field3792 < 25) {
         if(!this.field3791.method4133(class40.field550.field551, this.field3790)) {
            return this.field3792;
         }

         this.field3792 = 25;
      }

      if(this.field3792 == 25) {
         if(!this.field3791.method4133(this.field3790, class40.field552.field551)) {
            return 25 + this.field3791.method4136(this.field3790) * 25 / 100;
         }

         this.field3792 = 50;
      }

      if(this.field3792 == 50) {
         if(this.field3791.method4191(class40.field554.field551, this.field3790) && !this.field3791.method4133(class40.field554.field551, this.field3790)) {
            return 50;
         }

         this.field3792 = 75;
      }

      if(this.field3792 == 75) {
         if(!this.field3791.method4133(this.field3790, class40.field553.field551)) {
            return 75;
         }

         this.field3792 = 100;
         this.field3793 = true;
      }

      return this.field3792;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-118"
   )
   boolean method5223() {
      return this.field3793;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-1"
   )
   void method5214(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3790) {
            this.field3790 = var1;
            this.field3792 = 0;
            this.field3793 = false;
            this.method5213();
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2084578126"
   )
   int method5215() {
      return this.field3792;
   }
}
