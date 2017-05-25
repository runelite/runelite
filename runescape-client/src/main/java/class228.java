import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class228 implements class178 {
   @ObfuscatedName("h")
   public static final class228 field3137;
   @ObfuscatedName("u")
   public static final class228 field3138;
   @ObfuscatedName("t")
   public static final class228 field3139;
   @ObfuscatedName("g")
   public static final class228 field3140;
   @ObfuscatedName("v")
   public static final class228 field3141;
   @ObfuscatedName("q")
   public static final class228 field3142;
   @ObfuscatedName("p")
   public static final class228 field3143;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -998585525
   )
   public final int field3144;
   @ObfuscatedName("i")
   public static final class228 field3145;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 780754333
   )
   final int field3147;
   @ObfuscatedName("gn")
   static SpritePixels[] field3148;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field3147;
   }

   static {
      field3145 = new class228(5, 0);
      field3137 = new class228(7, 1);
      field3138 = new class228(6, 2);
      field3142 = new class228(4, 3);
      field3140 = new class228(0, 4);
      field3141 = new class228(2, 5);
      field3139 = new class228(3, 6);
      field3143 = new class228(1, 7);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class228(int var1, int var2) {
      this.field3144 = var1;
      this.field3147 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-565659583"
   )
   public static String method4153(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class266.field3658[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-958399584"
   )
   public static int method4154(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)Z",
      garbageValue = "-318828532"
   )
   static boolean method4155(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class43.method638(var3);
         return true;
      }
   }
}
