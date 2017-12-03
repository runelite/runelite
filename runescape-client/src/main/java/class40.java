import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class40 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final class40 field510;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final class40 field508;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final class40 field513;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final class40 field511;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final class40 field512;
   @ObfuscatedName("as")
   static FontMetrics field515;
   @ObfuscatedName("z")
   public final String field514;

   static {
      field510 = new class40("details");
      field508 = new class40("compositemap");
      field513 = new class40("compositetexture");
      field511 = new class40("area");
      field512 = new class40("labels");
   }

   class40(String var1) {
      this.field514 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1980950996"
   )
   static void method548(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILck;ZS)I",
      garbageValue = "-18276"
   )
   static int method549(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field881 = 250;
         return 1;
      } else {
         return 2;
      }
   }
}
