import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1268343805
   )
   public int field3939;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -97681331
   )
   public int field3938;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1827604245
   )
   public int field3936;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1409713421
   )
   public int field3937;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.method5716(var1, var2);
      this.method5694(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-17"
   )
   public void method5716(int var1, int var2) {
      this.field3939 = var1;
      this.field3938 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2118317902"
   )
   public void method5694(int var1, int var2) {
      this.field3936 = var1;
      this.field3937 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Llg;Llg;I)V",
      garbageValue = "1083239693"
   )
   public void method5693(Bounds var1, Bounds var2) {
      this.method5697(var1, var2);
      this.method5692(var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Llg;Llg;B)V",
      garbageValue = "-31"
   )
   void method5697(Bounds var1, Bounds var2) {
      var2.field3939 = this.field3939;
      var2.field3936 = this.field3936;
      if(this.field3939 < var1.field3939) {
         var2.field3936 -= var1.field3939 - this.field3939;
         var2.field3939 = var1.field3939;
      }

      if(var2.method5699() > var1.method5699()) {
         var2.field3936 -= var2.method5699() - var1.method5699();
      }

      if(var2.field3936 < 0) {
         var2.field3936 = 0;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Llg;Llg;I)V",
      garbageValue = "-1507993064"
   )
   void method5692(Bounds var1, Bounds var2) {
      var2.field3938 = this.field3938;
      var2.field3937 = this.field3937;
      if(this.field3938 < var1.field3938) {
         var2.field3937 -= var1.field3938 - this.field3938;
         var2.field3938 = var1.field3938;
      }

      if(var2.method5708() > var1.method5708()) {
         var2.field3937 -= var2.method5708() - var1.method5708();
      }

      if(var2.field3937 < 0) {
         var2.field3937 = 0;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-648229316"
   )
   int method5699() {
      return this.field3936 + this.field3939;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1559885291"
   )
   int method5708() {
      return this.field3938 + this.field3937;
   }

   public String toString() {
      return null;
   }
}
