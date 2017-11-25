import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
public class class283 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -51709736291225115L
   )
   long field3774;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 6085956174996029015L
   )
   long field3772;
   @ObfuscatedName("k")
   public boolean field3776;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -5012160022244813477L
   )
   long field3773;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -8229095895758197203L
   )
   long field3775;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 4712654165580709235L
   )
   long field3771;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1318680391
   )
   int field3777;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -22910595
   )
   int field3778;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1895401133
   )
   int field3780;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -542206757
   )
   int field3779;

   public class283() {
      this.field3774 = -1L;
      this.field3772 = -1L;
      this.field3776 = false;
      this.field3773 = 0L;
      this.field3775 = 0L;
      this.field3771 = 0L;
      this.field3777 = 0;
      this.field3778 = 0;
      this.field3780 = 0;
      this.field3779 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1409020115"
   )
   public void method5094() {
      this.field3774 = ServerPacket.currentTimeMs();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   public void method5095() {
      if(this.field3774 != -1L) {
         this.field3775 = ServerPacket.currentTimeMs() - this.field3774;
         this.field3774 = -1L;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1995262804"
   )
   public void method5096(int var1) {
      this.field3772 = ServerPacket.currentTimeMs();
      this.field3777 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public void method5093() {
      if(this.field3772 != -1L) {
         this.field3773 = ServerPacket.currentTimeMs() - this.field3772;
         this.field3772 = -1L;
      }

      ++this.field3780;
      this.field3776 = true;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1216148387"
   )
   public void method5098() {
      this.field3776 = false;
      this.field3778 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1359500880"
   )
   public void method5099() {
      this.method5093();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "-347265083"
   )
   public void method5097(Buffer var1) {
      long var2 = this.field3775;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.putShort((int)var2);
      long var4 = this.field3773;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.putShort((int)var4);
      long var6 = this.field3771;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.putShort((int)var6);
      var1.putShort(this.field3777);
      var1.putShort(this.field3778);
      var1.putShort(this.field3780);
      var1.putShort(this.field3779);
   }
}
