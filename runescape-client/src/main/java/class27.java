import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("World")
public class class27 {
   @ObfuscatedName("p")
   @Export("worldServersDownload")
   static class18 field672;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 246379359
   )
   static int field673 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1735827031
   )
   @Export("id")
   int field674;
   @ObfuscatedName("u")
   static int[] field675 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1081900987
   )
   @Export("mask")
   int field676;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1609168701
   )
   @Export("playerCount")
   int field677;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 592132657
   )
   static int field679 = 0;
   @ObfuscatedName("o")
   static int[] field681 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("w")
   @Export("activity")
   String field682;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -177560901
   )
   @Export("location")
   int field683;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 515672207
   )
   @Export("index")
   int field684;
   @ObfuscatedName("j")
   @Export("address")
   String field685;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 159846551
   )
   static int field688;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1262928314"
   )
   boolean method604() {
      return (1 & this.field676) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1338092571"
   )
   boolean method605() {
      return (2 & this.field676) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1887832567"
   )
   boolean method606() {
      return (4 & this.field676) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-45635129"
   )
   boolean method607() {
      return (8 & this.field676) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1257830146"
   )
   boolean method608() {
      return (536870912 & this.field676) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1024814147"
   )
   boolean method609() {
      return (33554432 & this.field676) != 0;
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)I",
      garbageValue = "-619741856"
   )
   static int method644(class176 var0) {
      class204 var1 = (class204)client.field414.method3864((long)var0.field2795 + ((long)var0.field2794 << 32));
      return null != var1?var1.field3147:var0.field2902;
   }
}
