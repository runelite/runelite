import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lb")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1245223283
   )
   public int field3941;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1231090535
   )
   public int field3942;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 850119981
   )
   public int field3943;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1784600163
   )
   public int field3944;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.method5680(var1, var2);
      this.method5671(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1347027473"
   )
   public void method5680(int var1, int var2) {
      this.field3941 = var1;
      this.field3942 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1026297832"
   )
   public void method5671(int var1, int var2) {
      this.field3943 = var1;
      this.field3944 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Llb;Llb;I)V",
      garbageValue = "1818261206"
   )
   public void method5667(Bounds var1, Bounds var2) {
      this.method5666(var1, var2);
      this.method5664(var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Llb;Llb;B)V",
      garbageValue = "53"
   )
   void method5666(Bounds var1, Bounds var2) {
      var2.field3941 = this.field3941;
      var2.field3943 = this.field3943;
      if(this.field3941 < var1.field3941) {
         var2.field3943 -= var1.field3941 - this.field3941;
         var2.field3941 = var1.field3941;
      }

      if(var2.method5668() > var1.method5668()) {
         var2.field3943 -= var2.method5668() - var1.method5668();
      }

      if(var2.field3943 < 0) {
         var2.field3943 = 0;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Llb;Llb;I)V",
      garbageValue = "1703752617"
   )
   void method5664(Bounds var1, Bounds var2) {
      var2.field3942 = this.field3942;
      var2.field3944 = this.field3944;
      if(this.field3942 < var1.field3942) {
         var2.field3944 -= var1.field3942 - this.field3942;
         var2.field3942 = var1.field3942;
      }

      if(var2.method5669() > var1.method5669()) {
         var2.field3944 -= var2.method5669() - var1.method5669();
      }

      if(var2.field3944 < 0) {
         var2.field3944 = 0;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "97"
   )
   int method5668() {
      return this.field3941 + this.field3943;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "2048"
   )
   int method5669() {
      return this.field3942 + this.field3944;
   }

   public String toString() {
      return null;
   }
}
