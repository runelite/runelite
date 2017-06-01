import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
public class class287 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1041945295
   )
   int field3795;
   @ObfuscatedName("y")
   String field3798;
   @ObfuscatedName("f")
   boolean field3799;
   @ObfuscatedName("h")
   IndexDataBase field3800;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1911058812"
   )
   boolean method5156() {
      return this.field3799;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1101433928"
   )
   void method5157(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(this.field3798 != var1) {
            this.field3798 = var1;
            this.field3795 = 0;
            this.field3799 = false;
            this.method5158();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1973097072"
   )
   int method5158() {
      if(this.field3795 < 25) {
         if(!this.field3800.method4128(class40.field545.field542, this.field3798)) {
            return this.field3795;
         }

         this.field3795 = 25;
      }

      if(this.field3795 == 25) {
         if(!this.field3800.method4128(this.field3798, class40.field544.field542)) {
            return this.field3800.method4133(this.field3798) * 25 / 100 + 25;
         }

         this.field3795 = 50;
      }

      if(this.field3795 == 50) {
         if(this.field3800.method4176(class40.field539.field542, this.field3798) && !this.field3800.method4128(class40.field539.field542, this.field3798)) {
            return 50;
         }

         this.field3795 = 75;
      }

      if(this.field3795 == 75) {
         if(!this.field3800.method4128(this.field3798, class40.field541.field542)) {
            return 75;
         }

         this.field3795 = 100;
         this.field3799 = true;
      }

      return this.field3795;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1613372071"
   )
   int method5160() {
      return this.field3795;
   }

   class287(IndexDataBase var1) {
      this.field3795 = 0;
      this.field3799 = false;
      this.field3800 = var1;
   }
}
