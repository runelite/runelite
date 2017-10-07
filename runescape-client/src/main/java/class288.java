import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
public class class288 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1784575613
   )
   public static int field3814;
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "[Ljz;"
   )
   static IndexedSprite[] field3819;
   @ObfuscatedName("v")
   boolean field3817;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 12759969
   )
   int field3809;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   IndexDataBase field3815;
   @ObfuscatedName("s")
   String field3812;

   @ObfuscatedSignature(
      signature = "(Lit;)V"
   )
   class288(IndexDataBase var1) {
      this.field3809 = 0;
      this.field3817 = false;
      this.field3815 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1844237138"
   )
   int method5304() {
      if(this.field3809 < 25) {
         if(!this.field3815.method4238(class40.field560.field559, this.field3812)) {
            return this.field3809;
         }

         this.field3809 = 25;
      }

      if(this.field3809 == 25) {
         if(!this.field3815.method4238(this.field3812, class40.field562.field559)) {
            return 25 + this.field3815.method4241(this.field3812) * 25 / 100;
         }

         this.field3809 = 50;
      }

      if(this.field3809 == 50) {
         if(this.field3815.method4276(class40.field568.field559, this.field3812) && !this.field3815.method4238(class40.field568.field559, this.field3812)) {
            return 50;
         }

         this.field3809 = 75;
      }

      if(this.field3809 == 75) {
         if(!this.field3815.method4238(this.field3812, class40.field564.field559)) {
            return 75;
         }

         this.field3809 = 100;
         this.field3817 = true;
      }

      return this.field3809;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "75"
   )
   boolean method5305() {
      return this.field3817;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "121648697"
   )
   void method5303(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3812) {
            this.field3812 = var1;
            this.field3809 = 0;
            this.field3817 = false;
            this.method5304();
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "39"
   )
   int method5306() {
      return this.field3809;
   }
}
