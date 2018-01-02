import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;

@ObfuscatedName("ai")
@Implements("NamedRecord")
public class NamedRecord {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final NamedRecord field510;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final NamedRecord field508;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final NamedRecord field513;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final NamedRecord field511;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   public static final NamedRecord field512;
   @ObfuscatedName("as")
   static FontMetrics field515;
   @ObfuscatedName("z")
   public final String field514;

   static {
      field510 = new NamedRecord("details");
      field508 = new NamedRecord("compositemap");
      field513 = new NamedRecord("compositetexture");
      field511 = new NamedRecord("area");
      field512 = new NamedRecord("labels");
   }

   NamedRecord(String var1) {
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
