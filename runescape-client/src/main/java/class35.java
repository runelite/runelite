import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class35 {
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   static class233 field505;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   static final class35 field506;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   static final class35 field502;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1903218639
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1783583469
   )
   final int field503;

   static {
      field506 = new class35(0);
      field502 = new class35(1);
   }

   class35(int var1) {
      this.field503 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1710636095"
   )
   public static boolean method507(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "1801"
   )
   public static boolean method506(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
