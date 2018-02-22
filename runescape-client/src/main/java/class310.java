import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kw")
public class class310 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 4119896269798758353L
   )
   long field3847;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -8471088934381524003L
   )
   long field3841;
   @ObfuscatedName("o")
   public boolean field3843;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -6273404906258403861L
   )
   long field3844;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -2556271349652430721L
   )
   long field3845;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 5653291629099379111L
   )
   long field3846;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -358800489
   )
   int field3848;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1610405231
   )
   int field3849;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1873328777
   )
   int field3842;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1946099961
   )
   int field3850;

   public class310() {
      this.field3847 = -1L;
      this.field3841 = -1L;
      this.field3843 = false;
      this.field3844 = 0L;
      this.field3845 = 0L;
      this.field3846 = 0L;
      this.field3848 = 0;
      this.field3849 = 0;
      this.field3842 = 0;
      this.field3850 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   public void method5603() {
      this.field3847 = class188.currentTimeMs();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1803340491"
   )
   public void method5599() {
      if(-1L != this.field3847) {
         this.field3845 = class188.currentTimeMs() - this.field3847;
         this.field3847 = -1L;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1553628994"
   )
   public void method5600(int var1) {
      this.field3841 = class188.currentTimeMs();
      this.field3848 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1461468574"
   )
   public void method5601() {
      if(this.field3841 != -1L) {
         this.field3844 = class188.currentTimeMs() - this.field3841;
         this.field3841 = -1L;
      }

      ++this.field3842;
      this.field3843 = true;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1027840989"
   )
   public void method5602() {
      this.field3843 = false;
      this.field3849 = 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1773616809"
   )
   public void method5620() {
      this.method5601();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "-189841557"
   )
   public void method5604(Buffer var1) {
      ClanMember.method5163(var1, this.field3845);
      ClanMember.method5163(var1, this.field3844);
      ClanMember.method5163(var1, this.field3846);
      var1.putShort(this.field3848);
      var1.putShort(this.field3849);
      var1.putShort(this.field3842);
      var1.putShort(this.field3850);
   }
}
