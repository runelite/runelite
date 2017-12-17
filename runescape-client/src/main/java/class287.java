import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
public class class287 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -1464932891006096739L
   )
   long field3793;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 3858172528322480033L
   )
   long field3792;
   @ObfuscatedName("e")
   public boolean field3796;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -479932440443260291L
   )
   long field3794;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 3728905196014058417L
   )
   long field3795;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 8617052935885687655L
   )
   long field3791;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 16962539
   )
   int field3797;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -395334099
   )
   int field3798;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -319293965
   )
   int field3799;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 168642959
   )
   int field3800;

   public class287() {
      this.field3793 = -1L;
      this.field3792 = -1L;
      this.field3796 = false;
      this.field3794 = 0L;
      this.field3795 = 0L;
      this.field3791 = 0L;
      this.field3797 = 0;
      this.field3798 = 0;
      this.field3799 = 0;
      this.field3800 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1173679905"
   )
   public void method5031() {
      this.field3793 = Preferences.currentTimeMs();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-102"
   )
   public void method5047() {
      if(-1L != this.field3793) {
         this.field3795 = Preferences.currentTimeMs() - this.field3793;
         this.field3793 = -1L;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-36"
   )
   public void method5033(int var1) {
      this.field3792 = Preferences.currentTimeMs();
      this.field3797 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-943258725"
   )
   public void method5032() {
      if(this.field3792 != -1L) {
         this.field3794 = Preferences.currentTimeMs() - this.field3792;
         this.field3792 = -1L;
      }

      ++this.field3799;
      this.field3796 = true;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1029153973"
   )
   public void method5035() {
      this.field3796 = false;
      this.field3798 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1883907191"
   )
   public void method5044() {
      this.method5032();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "-549017917"
   )
   public void method5056(Buffer var1) {
      MessageNode.method1073(var1, this.field3795);
      MessageNode.method1073(var1, this.field3794);
      MessageNode.method1073(var1, this.field3791);
      var1.putShort(this.field3797);
      var1.putShort(this.field3798);
      var1.putShort(this.field3799);
      var1.putShort(this.field3800);
   }
}
