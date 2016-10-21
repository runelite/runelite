import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class40 extends class210 {
   @ObfuscatedName("n")
   short field878;
   @ObfuscatedName("e")
   String field880;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1765946675
   )
   int field881 = (int)(class11.method139() / 1000L);
   @ObfuscatedName("ea")
   static SpritePixels[] field882;

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-310664758"
   )
   static void method788(String var0) {
      XItemContainer.field219 = var0;

      try {
         String var1 = Client.field442.getParameter(class193.field3115.field3118);
         String var2 = Client.field442.getParameter(class193.field3116.field3118);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + Sequence.method918(class11.method139() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class135.method2872(Client.field442, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lclass134;",
      garbageValue = "-1905332555"
   )
   public static class134 method789() {
      try {
         return new class148();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lclass136;",
      garbageValue = "486440379"
   )
   static class136 method790() {
      try {
         return new class150();
      } catch (Throwable var1) {
         return new class144();
      }
   }

   class40(String var1, int var2) {
      this.field880 = var1;
      this.field878 = (short)var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "786296386"
   )
   static final void method791(class125 var0, int var1) {
      int var2 = var0.offset;
      class34.field771 = 0;
      class31.method680(var0);
      class109.method2392(var0);
      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}
