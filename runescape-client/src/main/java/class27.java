import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public enum class27 implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   field391(2, (byte)0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   field382(3, (byte)1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   field383(1, (byte)2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   field384(0, (byte)3);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -331477673
   )
   final int field385;
   @ObfuscatedName("m")
   final byte field386;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   static IndexData field387;
   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "[Ljj;"
   )
   static SpritePixels[] field388;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field390;

   class27(int var3, byte var4) {
      this.field385 = var3;
      this.field386 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field386;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)[Laj;",
      garbageValue = "-23"
   )
   static class27[] method211() {
      return new class27[]{field383, field391, field382, field384};
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(Lho;IIIIIII)V",
      garbageValue = "-2086342303"
   )
   static final void method213(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field1076) {
         Client.field985 = 32;
      } else {
         Client.field985 = 0;
      }

      Client.field1076 = false;
      int var7;
      if(MouseInput.field733 == 1 || !GameEngine.field699 && MouseInput.field733 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class21.method156(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class21.method156(var0);
         } else if(var5 >= var1 - Client.field985 && var5 < var1 + 16 + Client.field985 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class21.method156(var0);
            Client.field1076 = true;
         }
      }

      if(Client.field1102 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field1102 * 45;
            class21.method156(var0);
         }
      }

   }
}
