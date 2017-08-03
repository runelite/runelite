import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
public class class287 {
   @ObfuscatedName("i")
   boolean field3790;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -776121643
   )
   int field3789;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   IndexDataBase field3784;
   @ObfuscatedName("f")
   String field3787;

   @ObfuscatedSignature(
      signature = "(Lim;)V"
   )
   class287(IndexDataBase var1) {
      this.field3789 = 0;
      this.field3790 = false;
      this.field3784 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2058350110"
   )
   int method5182() {
      if(this.field3789 < 25) {
         if(!this.field3784.method4135(class40.field516.field510, this.field3787)) {
            return this.field3789;
         }

         this.field3789 = 25;
      }

      if(this.field3789 == 25) {
         if(!this.field3784.method4135(this.field3787, class40.field512.field510)) {
            return 25 + this.field3784.method4136(this.field3787) * 25 / 100;
         }

         this.field3789 = 50;
      }

      if(this.field3789 == 50) {
         if(this.field3784.method4150(class40.field511.field510, this.field3787) && !this.field3784.method4135(class40.field511.field510, this.field3787)) {
            return 50;
         }

         this.field3789 = 75;
      }

      if(this.field3789 == 75) {
         if(!this.field3784.method4135(this.field3787, class40.field513.field510)) {
            return 75;
         }

         this.field3789 = 100;
         this.field3790 = true;
      }

      return this.field3789;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "941121190"
   )
   boolean method5183() {
      return this.field3790;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1707789037"
   )
   void method5184(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3787) {
            this.field3787 = var1;
            this.field3789 = 0;
            this.field3790 = false;
            this.method5182();
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "100"
   )
   int method5190() {
      return this.field3789;
   }
}
