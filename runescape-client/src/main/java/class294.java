import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
public class class294 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -149088447
   )
   static int field3827;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -4516610365289548177L
   )
   long field3817;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -1371359647933789961L
   )
   long field3818;
   @ObfuscatedName("b")
   public boolean field3819;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 600998070766331625L
   )
   long field3820;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 8643880875919129495L
   )
   long field3821;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 2899274481610585031L
   )
   long field3822;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1130688809
   )
   int field3823;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1358647493
   )
   int field3824;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1467386187
   )
   int field3825;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -889433567
   )
   int field3826;

   public class294() {
      this.field3817 = -1L;
      this.field3818 = -1L;
      this.field3819 = false;
      this.field3820 = 0L;
      this.field3821 = 0L;
      this.field3822 = 0L;
      this.field3823 = 0;
      this.field3824 = 0;
      this.field3825 = 0;
      this.field3826 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-85"
   )
   public void method5272() {
      this.field3817 = class289.method5267();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1926156248"
   )
   public void method5273() {
      if(this.field3817 != -1L) {
         this.field3821 = class289.method5267() - this.field3817;
         this.field3817 = -1L;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1338923286"
   )
   public void method5274(int var1) {
      this.field3818 = class289.method5267();
      this.field3823 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1063022271"
   )
   public void method5275() {
      if(this.field3818 != -1L) {
         this.field3820 = class289.method5267() - this.field3818;
         this.field3818 = -1L;
      }

      ++this.field3825;
      this.field3819 = true;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1814743927"
   )
   public void method5276() {
      this.field3819 = false;
      this.field3824 = 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-927889540"
   )
   public void method5277() {
      this.method5275();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "2005996912"
   )
   public void method5278(Buffer var1) {
      long var2 = this.field3821;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.putShort((int)var2);
      long var4 = this.field3820;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.putShort((int)var4);
      long var6 = this.field3822;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.putShort((int)var6);
      var1.putShort(this.field3823);
      var1.putShort(this.field3824);
      var1.putShort(this.field3825);
      var1.putShort(this.field3826);
   }
}
