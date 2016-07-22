import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class0 extends class211 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1573581435
   )
   int field0;
   @ObfuscatedName("m")
   Object[] field1;
   @ObfuscatedName("j")
   class176 field2;
   @ObfuscatedName("e")
   class176 field3;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1218107515
   )
   int field4;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1550319533
   )
   static int field6;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1290993493
   )
   int field7;
   @ObfuscatedName("w")
   boolean field8;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 419404809
   )
   int field9;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 222467617
   )
   int field10;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -856727899
   )
   int field11;
   @ObfuscatedName("k")
   String field13;
   @ObfuscatedName("at")
   static class149 field19;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1629729158"
   )
   public static final boolean method0() {
      class140 var0 = class140.field2189;
      synchronized(class140.field2189) {
         if(class140.field2184 == class140.field2180) {
            return false;
         } else {
            class139.field2152 = class140.field2179[class140.field2180];
            class48.field1079 = class140.field2174[class140.field2180];
            class140.field2180 = 1 + class140.field2180 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1684734018"
   )
   static final void method1() {
      client.field313.method2797(214);
      client.field313.method2557(0);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass134;",
      garbageValue = "-2134123882"
   )
   public static class134 method2() {
      try {
         return new class148();
      } catch (Throwable var1) {
         return null;
      }
   }
}
