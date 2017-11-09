import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public class class283 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -7589324092182913947L
   )
   long field3774;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 4368429613995371045L
   )
   long field3779;
   @ObfuscatedName("i")
   public boolean field3776;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 6376518274035108547L
   )
   long field3777;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -7006512602539418149L
   )
   long field3778;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -7963948879234946269L
   )
   long field3775;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1641852997
   )
   int field3780;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1598344519
   )
   int field3781;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2015918229
   )
   int field3782;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1557012341
   )
   int field3783;

   public class283() {
      this.field3774 = -1L;
      this.field3779 = -1L;
      this.field3776 = false;
      this.field3777 = 0L;
      this.field3778 = 0L;
      this.field3775 = 0L;
      this.field3780 = 0;
      this.field3781 = 0;
      this.field3782 = 0;
      this.field3783 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1937683220"
   )
   public void method5106() {
      this.field3774 = class268.currentTimeMs();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   public void method5100() {
      if(this.field3774 != -1L) {
         this.field3778 = class268.currentTimeMs() - this.field3774;
         this.field3774 = -1L;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1021315818"
   )
   public void method5101(int var1) {
      this.field3779 = class268.currentTimeMs();
      this.field3780 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-852784300"
   )
   public void method5098() {
      if(-1L != this.field3779) {
         this.field3777 = class268.currentTimeMs() - this.field3779;
         this.field3779 = -1L;
      }

      ++this.field3782;
      this.field3776 = true;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1910187505"
   )
   public void method5103() {
      this.field3776 = false;
      this.field3781 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1944751534"
   )
   public void method5118() {
      this.method5098();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "1900932284"
   )
   public void method5105(Buffer var1) {
      long var2 = this.field3778;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.putShort((int)var2);
      long var4 = this.field3777;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.putShort((int)var4);
      PendingSpawn.method1613(var1, this.field3775);
      var1.putShort(this.field3780);
      var1.putShort(this.field3781);
      var1.putShort(this.field3782);
      var1.putShort(this.field3783);
   }
}
