import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   public static class109 field1281;
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -371578253
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1634152591
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2108844971
   )
   @Export("type")
   int type;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -819822163
   )
   @Export("identifier")
   int identifier;
   @ObfuscatedName("j")
   @Export("option")
   String option;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lfh;",
      garbageValue = "1622056349"
   )
   public static class173[] method1847() {
      return new class173[]{class173.field2395, class173.field2389, class173.field2390, class173.field2391, class173.field2392, class173.field2393, class173.field2394, class173.field2397, class173.field2396, class173.field2388};
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-414357950"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1573767420"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(Lbx;I)V",
      garbageValue = "-570635551"
   )
   static final void method1848(Actor var0) {
      int var1 = var0.field1143 - Client.gameCycle;
      int var2 = var0.field1120 * 128 + var0.field1127 * 64;
      int var3 = var0.field1141 * 128 + var0.field1127 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field1136 = 0;
      var0.orientation = var0.field1145;
   }
}
