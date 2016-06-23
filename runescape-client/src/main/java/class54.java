import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public class class54 extends class56 {
   @ObfuscatedName("u")
   int field1180;
   @ObfuscatedName("f")
   static class53 field1181;

   @ObfuscatedName("f")
   void vmethod1576(Component var1) throws Exception {
      field1181.method1156(var1, class56.field1196, class56.field1200, (byte)1);
   }

   @ObfuscatedName("x")
   int vmethod1585() {
      return field1181.method1155(this.field1180, (byte)-69);
   }

   @ObfuscatedName("l")
   void vmethod1567() {
      field1181.method1151(this.field1180, (byte)10);
   }

   @ObfuscatedName("d")
   void vmethod1562() {
      field1181.method1149(this.field1180, 1851962248);
   }

   @ObfuscatedName("u")
   void vmethod1575(int var1) throws Exception {
      if(var1 > '耀') {
         throw new IllegalArgumentException();
      } else {
         field1181.method1150(this.field1180, var1, -1069426097);
      }
   }

   @ObfuscatedName("b")
   void vmethod1566() {
      field1181.method1152(this.field1180, super.field1191, (byte)19);
   }

   class54(class136 var1, int var2) {
      field1181 = var1.method2906();
      this.field1180 = var2;
   }
}
