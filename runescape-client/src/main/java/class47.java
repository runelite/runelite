import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class47 extends class204 {
   @ObfuscatedName("i")
   public static class193 field1072 = new class193(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 560401905
   )
   public int field1073;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1682743739
   )
   public int field1074;
   @ObfuscatedName("l")
   static int[] field1075;
   @ObfuscatedName("t")
   public static class167 field1076;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1231532907
   )
   public int field1078;
   @ObfuscatedName("f")
   static byte[][][] field1081;
   @ObfuscatedName("v")
   static class13 field1082;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "5"
   )
   public void method950(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method951(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "634642727"
   )
   void method951(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1073 = var1.method2470();
         this.field1074 = var1.method2494();
         this.field1078 = var1.method2494();
      }

   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "0"
   )
   static boolean method962(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class36.method723(var0, class96.field1641);

         for(int var3 = 0; var3 < client.field418; ++var3) {
            if(var2.equalsIgnoreCase(class36.method723(client.field551[var3].field239, class96.field1641))) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class36.method723(class152.field2301.field39, class96.field1641))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
