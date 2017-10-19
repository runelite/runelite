import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
public class class275 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 653291847198752043L
   )
   long field3730;
   @ObfuscatedName("q")
   public boolean field3732;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 6691804990526158911L
   )
   long field3734;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -3808860700115427123L
   )
   long field3731;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1080619477
   )
   int field3737;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -886140301
   )
   int field3738;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 6582958372533018075L
   )
   long field3733;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 3324687787754482331L
   )
   long field3739;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 481770167
   )
   int field3740;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1275284283
   )
   int field3736;

   public class275() {
      this.field3734 = -1L;
      this.field3731 = -1L;
      this.field3732 = false;
      this.field3733 = 0L;
      this.field3730 = 0L;
      this.field3739 = 0L;
      this.field3740 = 0;
      this.field3737 = 0;
      this.field3738 = 0;
      this.field3736 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "529648922"
   )
   public void method4994() {
      if(this.field3731 != -1L) {
         this.field3733 = class174.currentTimeMs() - this.field3731;
         this.field3731 = -1L;
      }

      ++this.field3738;
      this.field3732 = true;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "522059052"
   )
   public void method4995() {
      if(-1L != this.field3734) {
         this.field3730 = class174.currentTimeMs() - this.field3734;
         this.field3734 = -1L;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-61"
   )
   public void method4993(int var1) {
      this.field3731 = class174.currentTimeMs();
      this.field3740 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "391685167"
   )
   public void method4997(Buffer var1) {
      long var2 = this.field3730;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.putShort((int)var2);
      long var4 = this.field3733;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.putShort((int)var4);
      long var6 = this.field3739;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.putShort((int)var6);
      var1.putShort(this.field3740);
      var1.putShort(this.field3737);
      var1.putShort(this.field3738);
      var1.putShort(this.field3736);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   public void method5009() {
      this.field3732 = false;
      this.field3737 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   public void method4991() {
      this.field3734 = class174.currentTimeMs();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "67"
   )
   public void method4996() {
      this.method4994();
   }
}
