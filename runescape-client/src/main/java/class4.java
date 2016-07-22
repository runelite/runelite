import java.awt.datatransfer.Clipboard;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class4 {
   @ObfuscatedName("u")
   static int[] field67;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 45793271
   )
   static int field68;
   @ObfuscatedName("bi")
   static class83[] field69;
   @ObfuscatedName("pd")
   static Clipboard field73;
   @ObfuscatedName("w")
   static final BigInteger field75 = new BigInteger("e62bc37a4642635c725433722395b7a4cd63864f4fa36d7b2833f9ee8345975ea9f777cf500ccad777cbabcc0bac810753b25991c583b5461f9dafbd2936a7c2e494972dc04c20235894fe77ad9dc5d98d0b3be0755302c01824a055eb82599b19bfb52ce2c1f1e962bbc19e079df8b5fb6f40b873431201750817977cb98491", 16);
   @ObfuscatedName("m")
   static final BigInteger field76 = new BigInteger("10001", 16);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass56;",
      garbageValue = "1458498671"
   )
   public static class56 method41(int var0) {
      class56 var1 = (class56)class56.field1233.method3817((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class56.field1235.method3304(16, var0);
         var1 = new class56();
         if(var2 != null) {
            var1.method1193(new class122(var2));
         }

         class56.field1233.method3823(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass55;",
      garbageValue = "478428959"
   )
   @Export("getItemDefinition")
   public static class55 method42(int var0) {
      class55 var1 = (class55)class55.field1178.method3817((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class55.field1230.method3304(10, var0);
         var1 = new class55();
         var1.field1181 = var0;
         if(var2 != null) {
            var1.method1134(new class122(var2));
         }

         var1.method1147();
         if(var1.field1214 != -1) {
            var1.method1141(method42(var1.field1214), method42(var1.field1213));
         }

         if(var1.field1179 != -1) {
            var1.method1137(method42(var1.field1179), method42(var1.field1222));
         }

         if(var1.field1225 != -1) {
            var1.method1138(method42(var1.field1225), method42(var1.field1224));
         }

         if(!class55.field1175 && var1.field1196) {
            var1.field1183 = "Members object";
            var1.field1220 = false;
            var1.field1197 = null;
            var1.field1198 = null;
            var1.field1182 = 0;
         }

         class55.field1178.method3823(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)Z",
      garbageValue = "-142494449"
   )
   public static boolean method43(class170 var0, int var1) {
      byte[] var2 = var0.method3309(var1);
      if(null == var2) {
         return false;
      } else {
         class45.method958(var2);
         return true;
      }
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-101"
   )
   static void method44() {
      for(class3 var0 = (class3)client.field535.method3847(); null != var0; var0 = (class3)client.field535.method3852()) {
         int var1 = var0.field66;
         if(class122.method2739(var1)) {
            boolean var2 = true;
            class176[] var3 = class176.field2814[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2794;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3167;
               class176 var5 = class34.method720(var4);
               if(null != var5) {
                  class92.method2164(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1934276603"
   )
   static char method45(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }
}
