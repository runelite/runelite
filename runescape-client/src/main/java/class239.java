import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public enum class239 implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3252("runescape", "RuneScape", 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3250("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3253("game3", "Game 3", 2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3255("game4", "Game 4", 3),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3254("game5", "Game 5", 4),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3257("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("u")
   public final String field3256;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1009020233
   )
   final int field3251;

   class239(String var3, String var4, int var5) {
      this.field3256 = var3;
      this.field3251 = var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field3251;
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(Lhx;IIZB)V",
      garbageValue = "-90"
   )
   static void method4101(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2720 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2720 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2720 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2725;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2725;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2725 >> 14;
      }

      if(var0.field2720 == 4) {
         var0.width = var0.height * var0.field2816 / var0.field2794;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2794 / var0.field2816;
      }

      if(Client.field1017 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1019 = var0;
      }

      if(var3 && var0.field2822 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field785 = var0.field2822;
         Client.field862.addFront(var6);
      }

   }
}
