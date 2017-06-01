import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class7 {
   @ObfuscatedName("c")
   public static boolean field235;
   @ObfuscatedName("i")
   public static boolean field236;
   @ObfuscatedName("e")
   public static boolean field237;
   @ObfuscatedName("b")
   public static CombatInfoList field239;
   @ObfuscatedName("v")
   public static class11 field240;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILclass219;B)I",
      garbageValue = "-2"
   )
   public static int method22(int var0, class219 var1) {
      return var1.field2797 + (var0 + '鱀' << 8);
   }

   static {
      field236 = false;
      field235 = false;
      field237 = false;
      field240 = class11.field268;
      field239 = new CombatInfoList();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILIndexDataBase;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "189659239"
   )
   public static void method26(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method4125(var2);
      int var7 = var1.method4126(var6, var3);
      class51.method762(var0, var1, var6, var7, var4, var5);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)Z",
      garbageValue = "-1978219462"
   )
   public static boolean method28(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class31.method262(var3);
         return true;
      }
   }
}
