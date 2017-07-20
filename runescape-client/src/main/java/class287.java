import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
public class class287 {
   @ObfuscatedName("p")
   boolean field3791;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2000454571
   )
   int field3790;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   IndexDataBase field3793;
   @ObfuscatedName("m")
   String field3792;

   @ObfuscatedSignature(
      signature = "(Lip;)V"
   )
   class287(IndexDataBase var1) {
      this.field3790 = 0;
      this.field3791 = false;
      this.field3793 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1649912486"
   )
   int method5070() {
      if(this.field3790 < 25) {
         if(!this.field3793.method4028(class40.field541.field549, this.field3792)) {
            return this.field3790;
         }

         this.field3790 = 25;
      }

      if(this.field3790 == 25) {
         if(!this.field3793.method4028(this.field3792, class40.field545.field549)) {
            return 25 + this.field3793.method4031(this.field3792) * 25 / 100;
         }

         this.field3790 = 50;
      }

      if(this.field3790 == 50) {
         if(this.field3793.method4026(class40.field542.field549, this.field3792) && !this.field3793.method4028(class40.field542.field549, this.field3792)) {
            return 50;
         }

         this.field3790 = 75;
      }

      if(this.field3790 == 75) {
         if(!this.field3793.method4028(this.field3792, class40.field544.field549)) {
            return 75;
         }

         this.field3790 = 100;
         this.field3791 = true;
      }

      return this.field3790;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   boolean method5077() {
      return this.field3791;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "2"
   )
   void method5069(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3792) {
            this.field3792 = var1;
            this.field3790 = 0;
            this.field3791 = false;
            this.method5070();
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   int method5072() {
      return this.field3790;
   }
}
