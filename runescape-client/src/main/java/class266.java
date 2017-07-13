import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public class class266 {
   @ObfuscatedName("a")
   public static final char[] field3663;

   static {
      field3663 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-1038978163"
   )
   public static ModIcon[] method4774(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      ModIcon[] var5;
      if(!IndexData.method4200(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class210.method3911();
      }

      return var5;
   }
}
