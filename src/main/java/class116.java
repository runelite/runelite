import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class116 {
   @ObfuscatedName("j")
   Inflater field1958;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "0"
   )
   static void method2442(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(class25.field617[var5] != var0) {
            var2[var4] = class25.field617[var5];
            var3[var4] = class25.field622[var5];
            ++var4;
         }
      }

      class25.field617 = var2;
      class25.field622 = var3;
      client.method553(class25.field616, 0, class25.field616.length - 1, class25.field617, class25.field622);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;[BB)V",
      garbageValue = "64"
   )
   public void method2444(class119 var1, byte[] var2) {
      if(var1.field1973[var1.field1971] == 31 && var1.field1973[1 + var1.field1971] == -117) {
         if(this.field1958 == null) {
            this.field1958 = new Inflater(true);
         }

         try {
            this.field1958.setInput(var1.field1973, var1.field1971 + 10, var1.field1973.length - (8 + var1.field1971 + 10));
            this.field1958.inflate(var2);
         } catch (Exception var4) {
            this.field1958.reset();
            throw new RuntimeException("");
         }

         this.field1958.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1"
   )
   class116(int var1, int var2, int var3) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "843887787"
   )
   public static int method2447(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "([Lclass173;Lclass173;ZI)V",
      garbageValue = "1724868175"
   )
   static void method2448(class173[] var0, class173 var1, boolean var2) {
      int var3 = 0 != var1.field2837?var1.field2837:var1.field2840;
      int var4 = var1.field2784 != 0?var1.field2784:var1.field2746;
      class150.method3116(var0, var1.field2774, var3, var4, var2);
      if(null != var1.field2868) {
         class150.method3116(var1.field2868, var1.field2774, var3, var4, var2);
      }

      class3 var5 = (class3)client.field434.method3742((long)var1.field2774);
      if(var5 != null) {
         class156.method3131(var5.field65, var3, var4, var2);
      }

      if(1337 == var1.field2748) {
         ;
      }

   }

   public class116() {
      this(-1, 1000000, 1000000);
   }
}
