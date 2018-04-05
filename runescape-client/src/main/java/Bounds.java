import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -810396107
   )
   static int field3945;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1936728375
   )
   public int field3943;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1724403647
   )
   public int field3941;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2077569667
   )
   public int field3942;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1046470257
   )
   public int field3944;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.method5675(var1, var2);
      this.method5676(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1359914920"
   )
   public void method5675(int var1, int var2) {
      this.field3943 = var1;
      this.field3941 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "53029735"
   )
   public void method5676(int var1, int var2) {
      this.field3942 = var1;
      this.field3944 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Llx;Llx;I)V",
      garbageValue = "-1191841162"
   )
   public void method5680(Bounds var1, Bounds var2) {
      this.method5678(var1, var2);
      this.method5694(var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Llx;Llx;I)V",
      garbageValue = "1895882893"
   )
   void method5678(Bounds var1, Bounds var2) {
      var2.field3943 = this.field3943;
      var2.field3942 = this.field3942;
      if(this.field3943 < var1.field3943) {
         var2.field3942 -= var1.field3943 - this.field3943;
         var2.field3943 = var1.field3943;
      }

      if(var2.method5683() > var1.method5683()) {
         var2.field3942 -= var2.method5683() - var1.method5683();
      }

      if(var2.field3942 < 0) {
         var2.field3942 = 0;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Llx;Llx;B)V",
      garbageValue = "-61"
   )
   void method5694(Bounds var1, Bounds var2) {
      var2.field3941 = this.field3941;
      var2.field3944 = this.field3944;
      if(this.field3941 < var1.field3941) {
         var2.field3944 -= var1.field3941 - this.field3941;
         var2.field3941 = var1.field3941;
      }

      if(var2.method5681() > var1.method5681()) {
         var2.field3944 -= var2.method5681() - var1.method5681();
      }

      if(var2.field3944 < 0) {
         var2.field3944 = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "32"
   )
   int method5683() {
      return this.field3942 + this.field3943;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1717053294"
   )
   int method5681() {
      return this.field3941 + this.field3944;
   }

   public String toString() {
      return null;
   }
}
