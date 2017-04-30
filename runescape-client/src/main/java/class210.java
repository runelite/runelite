import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class210 {
   @ObfuscatedName("d")
   public static final char[] field3134;

   static {
      field3134 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   class210() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-2120246606"
   )
   static final void method4010(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class112.method2112(var0)) {
         ScriptState.field117 = null;
         class164.gameDraw(class133.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(ScriptState.field117 != null) {
            class164.gameDraw(ScriptState.field117, -1412584499, var1, var2, var3, var4, class122.field1886, NPC.field760, var7);
            ScriptState.field117 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field368[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field368[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-1937985847"
   )
   public static ModIcon[] method4011(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method3296(var1);
      int var4 = var0.method3310(var3, var2);
      ModIcon[] var5;
      if(!class199.method3620(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon[] var7 = new ModIcon[class229.field3250];

         for(int var8 = 0; var8 < class229.field3250; ++var8) {
            ModIcon var9 = var7[var8] = new ModIcon();
            var9.width = class229.field3255;
            var9.originalHeight = class229.field3251;
            var9.offsetX = class199.field2877[var8];
            var9.offsetY = class229.field3252[var8];
            var9.originalWidth = class229.field3254[var8];
            var9.height = class36.field772[var8];
            var9.palette = class229.field3249;
            var9.pixels = class229.field3253[var8];
         }

         class199.field2877 = null;
         class229.field3252 = null;
         class229.field3254 = null;
         class36.field772 = null;
         class229.field3249 = null;
         class229.field3253 = null;
         var5 = var7;
      }

      return var5;
   }
}
