package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class52 extends class203 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1891144565
   )
   public static int field1143;
   @ObfuscatedName("f")
   public static class192 field1144 = new class192(64);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -521679079
   )
   public int field1145 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -72783941
   )
   static int field1146;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 1412836757
   )
   static int field1147;
   @ObfuscatedName("j")
   public static class166 field1149;
   @ObfuscatedName("u")
   static class166 field1150;

   @ObfuscatedName("f")
   public void method1117(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(var2 == 0) {
            return;
         }

         this.method1119(var1, var2);
      }
   }

   @ObfuscatedName("l")
   void method1119(class118 var1, int var2) {
      if(5 == var2) {
         this.field1145 = var1.method2538();
      }

   }
}
