package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class54 extends class56 {
   @ObfuscatedName("j")
   static class53 field1175;
   @ObfuscatedName("l")
   int field1176;

   @ObfuscatedName("l")
   void vmethod1502(int var1) throws Exception {
      if(var1 > '耀') {
         throw new IllegalArgumentException();
      } else {
         field1175.method1095();
      }
   }

   class54(class135 var1, int var2) {
      field1175 = var1.method2815();
      this.field1176 = var2;
   }

   @ObfuscatedName("a")
   int vmethod1521() {
      return field1175.method1096();
   }

   @ObfuscatedName("f")
   void vmethod1511() {
      field1175.method1098();
   }

   @ObfuscatedName("m")
   void vmethod1520() {
      field1175.method1094();
   }

   @ObfuscatedName("j")
   void vmethod1501() throws Exception {
      field1175.method1099();
   }

   @ObfuscatedName("i")
   void vmethod1503() {
      field1175.method1102();
   }
}
