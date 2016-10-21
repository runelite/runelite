import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class28 {
   @ObfuscatedName("t")
   public static class187 field670;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1050604157
   )
   static int field673;
   @ObfuscatedName("en")
   static SpritePixels[] field678;
   @ObfuscatedName("cp")
   static class149 field679;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass50;",
      garbageValue = "-1174296059"
   )
   public static class50 method652(int var0) {
      class50 var1 = (class50)class50.field1097.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class50.field1095.method3304(14, var0);
         var1 = new class50();
         if(var2 != null) {
            var1.method1015(new Buffer(var2));
         }

         class50.field1097.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-39"
   )
   public static int method653(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "-1046652311"
   )
   static void method654(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var6.parentId == var1) {
            World.method648(var6, var2, var3, var4);
            Ignore.method92(var6, var2, var3);
            if(var6.itemId > var6.scrollWidth - var6.width) {
               var6.itemId = var6.scrollWidth - var6.width;
            }

            if(var6.itemId < 0) {
               var6.itemId = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class174.method3428(var0, var6, var4);
            }
         }
      }

   }
}
