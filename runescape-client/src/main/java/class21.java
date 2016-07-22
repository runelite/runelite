import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class21 implements class115 {
   @ObfuscatedName("w")
   static final class21 field568 = new class21(1);
   @ObfuscatedName("e")
   static final class21 field569 = new class21(2);
   @ObfuscatedName("m")
   static final class21 field570 = new class21(0);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1150475193
   )
   final int field571;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1069158987
   )
   public static int field574;
   @ObfuscatedName("pg")
   static class163 field577;
   @ObfuscatedName("o")
   static final class21 field581 = new class21(3);

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class21(int var1) {
      this.field571 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1587180348"
   )
   public int vmethod3218() {
      return this.field571;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "-1758576558"
   )
   public static class48 method563(int var0) {
      class48 var1 = (class48)class48.field1072.method3817((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class48.field1083.method3304(4, var0);
         var1 = new class48();
         if(null != var2) {
            var1.method995(new class122(var2), var0);
         }

         var1.method994();
         class48.field1072.method3823(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass125;B)I",
      garbageValue = "29"
   )
   static int method566(class125 var0) {
      int var1 = var0.method2813(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2813(5);
      } else if(var1 == 2) {
         var2 = var0.method2813(8);
      } else {
         var2 = var0.method2813(11);
      }

      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1771181198"
   )
   static Class method567(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
