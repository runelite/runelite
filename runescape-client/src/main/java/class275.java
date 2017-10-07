import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class275 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 6455756924506434381L
   )
   long field3739;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 4178260345248170241L
   )
   long field3733;
   @ObfuscatedName("e")
   public boolean field3735;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 3790287593749549163L
   )
   long field3738;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1054102895
   )
   int field3740;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2015618495
   )
   int field3741;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 4063592258915756873L
   )
   long field3734;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -7448374143879815307L
   )
   long field3737;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2117260945
   )
   int field3736;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 157330773
   )
   int field3742;

   public class275() {
      this.field3733 = -1L;
      this.field3738 = -1L;
      this.field3735 = false;
      this.field3734 = 0L;
      this.field3739 = 0L;
      this.field3737 = 0L;
      this.field3736 = 0;
      this.field3740 = 0;
      this.field3741 = 0;
      this.field3742 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1971597185"
   )
   public void method4995() {
      if(-1L != this.field3738) {
         this.field3734 = class147.currentTimeMs() - this.field3738;
         this.field3738 = -1L;
      }

      ++this.field3741;
      this.field3735 = true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   public void method4993() {
      if(-1L != this.field3733) {
         this.field3739 = class147.currentTimeMs() - this.field3733;
         this.field3733 = -1L;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1677432830"
   )
   public void method4991(int var1) {
      this.field3738 = class147.currentTimeMs();
      this.field3736 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "110"
   )
   public void method4998(Buffer var1) {
      PacketBuffer.method3505(var1, this.field3739);
      PacketBuffer.method3505(var1, this.field3734);
      PacketBuffer.method3505(var1, this.field3737);
      var1.putShort(this.field3736);
      var1.putShort(this.field3740);
      var1.putShort(this.field3741);
      var1.putShort(this.field3742);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void method4996() {
      this.field3735 = false;
      this.field3740 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1138490387"
   )
   public void method5001() {
      this.field3733 = class147.currentTimeMs();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1409216246"
   )
   public void method5014() {
      this.method4995();
   }
}
