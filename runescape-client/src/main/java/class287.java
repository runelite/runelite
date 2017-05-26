import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public class class287 {
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -203580143
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("t")
   IndexDataBase field3791;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1748560047
   )
   int field3792;
   @ObfuscatedName("l")
   boolean field3793;
   @ObfuscatedName("v")
   String field3794;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1864108177"
   )
   void method5241(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3794) {
            this.field3794 = var1;
            this.field3792 = 0;
            this.field3793 = false;
            this.method5252();
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2135913761"
   )
   boolean method5243() {
      return this.field3793;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-221259533"
   )
   int method5244() {
      return this.field3792;
   }

   class287(IndexDataBase var1) {
      this.field3792 = 0;
      this.field3793 = false;
      this.field3791 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2049647824"
   )
   int method5252() {
      if(this.field3792 < 25) {
         if(!this.field3791.method4193(class40.field532.field540, this.field3794)) {
            return this.field3792;
         }

         this.field3792 = 25;
      }

      if(this.field3792 == 25) {
         if(!this.field3791.method4193(this.field3794, class40.field534.field540)) {
            return this.field3791.method4196(this.field3794) * 25 / 100 + 25;
         }

         this.field3792 = 50;
      }

      if(this.field3792 == 50) {
         if(this.field3791.method4191(class40.field533.field540, this.field3794) && !this.field3791.method4193(class40.field533.field540, this.field3794)) {
            return 50;
         }

         this.field3792 = 75;
      }

      if(this.field3792 == 75) {
         if(!this.field3791.method4193(this.field3794, class40.field535.field540)) {
            return 75;
         }

         this.field3792 = 100;
         this.field3793 = true;
      }

      return this.field3792;
   }
}
