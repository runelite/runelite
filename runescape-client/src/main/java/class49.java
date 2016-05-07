import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class49 extends class204 {
   @ObfuscatedName("s")
   public static class167 field1090;
   @ObfuscatedName("u")
   public static boolean field1091;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = 1220940671
   )
   static int field1092;
   @ObfuscatedName("j")
   public static class193 field1098 = new class193(64);
   @ObfuscatedName("p")
   public boolean field1099 = false;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-791975266"
   )
   public void method975(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(var2 == 0) {
            return;
         }

         this.method979(var1, var2);
      }
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "168980065"
   )
   static final String[] method976(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "10"
   )
   void method979(class119 var1, int var2) {
      if(2 == var2) {
         this.field1099 = true;
      }

   }
}
