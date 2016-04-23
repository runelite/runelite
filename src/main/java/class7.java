import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("j")
   @Export("name")
   String field131;
   @ObfuscatedName("db")
   static int[][] field132;
   @ObfuscatedName("h")
   @Export("previousName")
   String field133;
   @ObfuscatedName("aw")
   static class143 field137;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "-1991164516"
   )
   public static int method105(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ class119.field1972[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "914667195"
   )
   static String method106(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "2"
   )
   static final void method107(int var0) {
      if(class107.method2374(var0)) {
         class6.method98(class173.field2735[var0], -1);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1986003268"
   )
   public static int method108() {
      return class137.field2104;
   }
}
