import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class122 {
   @ObfuscatedName("ct")
   static class102 field1884;
   @ObfuscatedName("ah")
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -1741670701
   )
   static int field1886;
   @ObfuscatedName("d")
   Inflater field1887;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1924895925
   )
   @Export("authCodeForLogin")
   static int authCodeForLogin;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lclass180;",
      garbageValue = "-2054859508"
   )
   static class180[] method2312() {
      return new class180[]{class180.field2674, class180.field2677, class180.field2672, class180.field2673};
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class122(int var1, int var2, int var3) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "-1669320959"
   )
   public void method2313(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field1887 == null) {
            this.field1887 = new Inflater(true);
         }

         try {
            this.field1887.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 10 + 8));
            this.field1887.inflate(var2);
         } catch (Exception var4) {
            this.field1887.reset();
            throw new RuntimeException("");
         }

         this.field1887.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CIB)Ljava/lang/String;",
      garbageValue = "11"
   )
   public static String method2314(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   public class122() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1939754476"
   )
   static int method2318() {
      return ++class47.field926 - 1;
   }
}
