import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
public class class294 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -5282136434597562347L
   )
   long field3813;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -1271192693389662005L
   )
   long field3812;
   @ObfuscatedName("i")
   public boolean field3811;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -478721389705804311L
   )
   long field3814;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 2236536688876256489L
   )
   long field3815;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -7041072746381165797L
   )
   long field3816;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2044768599
   )
   int field3819;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 889201593
   )
   int field3821;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 308516409
   )
   int field3818;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 331426147
   )
   int field3820;

   public class294() {
      this.field3813 = -1L;
      this.field3812 = -1L;
      this.field3811 = false;
      this.field3814 = 0L;
      this.field3815 = 0L;
      this.field3816 = 0L;
      this.field3819 = 0;
      this.field3821 = 0;
      this.field3818 = 0;
      this.field3820 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1989296344"
   )
   public void method5208() {
      this.field3813 = WorldMapRegion.method465();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1310201514"
   )
   public void method5204() {
      if(-1L != this.field3813) {
         this.field3815 = WorldMapRegion.method465() - this.field3813;
         this.field3813 = -1L;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1501434601"
   )
   public void method5205(int var1) {
      this.field3812 = WorldMapRegion.method465();
      this.field3819 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3222"
   )
   public void method5224() {
      if(-1L != this.field3812) {
         this.field3814 = WorldMapRegion.method465() - this.field3812;
         this.field3812 = -1L;
      }

      ++this.field3818;
      this.field3811 = true;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-31"
   )
   public void method5216() {
      this.field3811 = false;
      this.field3821 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-458231100"
   )
   public void method5207() {
      this.method5224();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgb;B)V",
      garbageValue = "39"
   )
   public void method5202(Buffer var1) {
      long var2 = this.field3815;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.putShort((int)var2);
      long var4 = this.field3814;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.putShort((int)var4);
      long var6 = this.field3816;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.putShort((int)var6);
      var1.putShort(this.field3819);
      var1.putShort(this.field3821);
      var1.putShort(this.field3818);
      var1.putShort(this.field3820);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Ljv;",
      garbageValue = "1"
   )
   public static Enum method5225(int var0) {
      Enum var1 = (Enum)Enum.EnumDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.EnumDefinition_indexCache.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.EnumDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }
}
