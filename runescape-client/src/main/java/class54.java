import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class54 extends class56 {
   @ObfuscatedName("j")
   int field1173;
   @ObfuscatedName("s")
   static class53 field1174;

   @ObfuscatedName("s")
   void vmethod1492(Component var1) throws Exception {
      field1174.method1085(var1, class56.field1186, class56.field1180, 1388610464);
   }

   @ObfuscatedName("j")
   void vmethod1493(int var1) throws Exception {
      if(var1 > '耀') {
         throw new IllegalArgumentException();
      } else {
         field1174.method1086(this.field1173, var1, 1539237816);
      }
   }

   class54(class136 var1, int var2) {
      field1174 = var1.method2868();
      this.field1173 = var2;
   }

   @ObfuscatedName("d")
   void vmethod1491() {
      field1174.method1074(this.field1173, 1757810835);
   }

   @ObfuscatedName("u")
   void vmethod1503() {
      field1174.method1072(this.field1173, 2063515680);
   }

   @ObfuscatedName("x")
   void vmethod1495() {
      field1174.method1071(this.field1173, super.field1200, 1951552826);
   }

   @ObfuscatedName("p")
   int vmethod1510() {
      return field1174.method1073(this.field1173, (byte)-58);
   }
}
