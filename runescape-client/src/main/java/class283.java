import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
public class class283 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -820030877123638185L
   )
   long field3778;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 4188772411303101067L
   )
   long field3771;
   @ObfuscatedName("r")
   public boolean field3769;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 6824773224743381441L
   )
   long field3772;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 5660252271295283509L
   )
   long field3770;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -4516234742170545615L
   )
   long field3774;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1828821003
   )
   int field3775;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1696654311
   )
   int field3776;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 832659627
   )
   int field3777;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -753818383
   )
   int field3773;

   public class283() {
      this.field3778 = -1L;
      this.field3771 = -1L;
      this.field3769 = false;
      this.field3772 = 0L;
      this.field3770 = 0L;
      this.field3774 = 0L;
      this.field3775 = 0;
      this.field3776 = 0;
      this.field3777 = 0;
      this.field3773 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1488237381"
   )
   public void method4918() {
      this.field3778 = ChatLineBuffer.currentTimeMs();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "33"
   )
   public void method4925() {
      if(-1L != this.field3778) {
         this.field3770 = ChatLineBuffer.currentTimeMs() - this.field3778;
         this.field3778 = -1L;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1582142772"
   )
   public void method4920(int var1) {
      this.field3771 = ChatLineBuffer.currentTimeMs();
      this.field3775 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "119"
   )
   public void method4926() {
      if(this.field3771 != -1L) {
         this.field3772 = ChatLineBuffer.currentTimeMs() - this.field3771;
         this.field3771 = -1L;
      }

      ++this.field3777;
      this.field3769 = true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1840343528"
   )
   public void method4932() {
      this.field3769 = false;
      this.field3776 = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "266630271"
   )
   public void method4923() {
      this.method4926();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "1359084157"
   )
   public void method4924(Buffer var1) {
      long var2 = this.field3770;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.putShort((int)var2);
      long var4 = this.field3772;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.putShort((int)var4);
      long var6 = this.field3774;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.putShort((int)var6);
      var1.putShort(this.field3775);
      var1.putShort(this.field3776);
      var1.putShort(this.field3777);
      var1.putShort(this.field3773);
   }
}
