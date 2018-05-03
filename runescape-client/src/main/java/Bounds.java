import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -292313249
   )
   public int field3947;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1705193091
   )
   public int field3945;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2070920631
   )
   public int field3946;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1945608617
   )
   public int field3944;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.method5765(var1, var2);
      this.method5761(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1256025478"
   )
   public void method5765(int var1, int var2) {
      this.field3947 = var1;
      this.field3945 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1052158768"
   )
   public void method5761(int var1, int var2) {
      this.field3946 = var1;
      this.field3944 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lls;Lls;I)V",
      garbageValue = "-57018569"
   )
   public void method5762(Bounds var1, Bounds var2) {
      this.method5763(var1, var2);
      this.method5764(var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lls;Lls;I)V",
      garbageValue = "731155364"
   )
   void method5763(Bounds var1, Bounds var2) {
      var2.field3947 = this.field3947;
      var2.field3946 = this.field3946;
      if(this.field3947 < var1.field3947) {
         var2.field3946 -= var1.field3947 - this.field3947;
         var2.field3947 = var1.field3947;
      }

      if(var2.method5775() > var1.method5775()) {
         var2.field3946 -= var2.method5775() - var1.method5775();
      }

      if(var2.field3946 < 0) {
         var2.field3946 = 0;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lls;Lls;I)V",
      garbageValue = "-1635381505"
   )
   void method5764(Bounds var1, Bounds var2) {
      var2.field3945 = this.field3945;
      var2.field3944 = this.field3944;
      if(this.field3945 < var1.field3945) {
         var2.field3944 -= var1.field3945 - this.field3945;
         var2.field3945 = var1.field3945;
      }

      if(var2.method5766() > var1.method5766()) {
         var2.field3944 -= var2.method5766() - var1.method5766();
      }

      if(var2.field3944 < 0) {
         var2.field3944 = 0;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   int method5775() {
      return this.field3946 + this.field3947;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1944124735"
   )
   int method5766() {
      return this.field3944 + this.field3945;
   }

   public String aac() {
      return null;
   }

   public String toString() {
      return null;
   }

   public String aad() {
      return null;
   }
}
