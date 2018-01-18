import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public class class287 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -3605345647244689805L
   )
   long field3800;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 3517287855869183809L
   )
   long field3801;
   @ObfuscatedName("y")
   public boolean field3802;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 9046111112022033913L
   )
   long field3803;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 6318547120974047731L
   )
   long field3804;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 3870011214012449273L
   )
   long field3808;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1224350793
   )
   int field3805;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -224898457
   )
   int field3807;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1685810635
   )
   int field3806;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -228903269
   )
   int field3809;

   public class287() {
      this.field3800 = -1L;
      this.field3801 = -1L;
      this.field3802 = false;
      this.field3803 = 0L;
      this.field3804 = 0L;
      this.field3808 = 0L;
      this.field3805 = 0;
      this.field3807 = 0;
      this.field3806 = 0;
      this.field3809 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   public void method5119() {
      this.field3800 = class60.currentTimeMs();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2023931303"
   )
   public void method5097() {
      if(this.field3800 != -1L) {
         this.field3804 = class60.currentTimeMs() - this.field3800;
         this.field3800 = -1L;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-6690"
   )
   public void method5098(int var1) {
      this.field3801 = class60.currentTimeMs();
      this.field3805 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-522293058"
   )
   public void method5099() {
      if(this.field3801 != -1L) {
         this.field3803 = class60.currentTimeMs() - this.field3801;
         this.field3801 = -1L;
      }

      ++this.field3806;
      this.field3802 = true;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "263810926"
   )
   public void method5100() {
      this.field3802 = false;
      this.field3807 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1173930146"
   )
   public void method5101() {
      this.method5099();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgv;B)V",
      garbageValue = "56"
   )
   public void method5095(Buffer var1) {
      class22.method166(var1, this.field3804);
      class22.method166(var1, this.field3803);
      class22.method166(var1, this.field3808);
      var1.putShort(this.field3805);
      var1.putShort(this.field3807);
      var1.putShort(this.field3806);
      var1.putShort(this.field3809);
   }
}
