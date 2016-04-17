import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class54 extends class56 {
   @ObfuscatedName("w")
   int field1177;
   @ObfuscatedName("a")
   static class53 field1178;

   @ObfuscatedName("a")
   void vmethod1614(Component var1) throws Exception {
      field1178.method1212(var1, class40.field973, class96.field1633, (short)-2768);
   }

   @ObfuscatedName("k")
   void vmethod1621() {
      field1178.method1202(this.field1177, (byte)38);
   }

   @ObfuscatedName("c")
   void vmethod1619() {
      field1178.method1200(this.field1177, super.field1188, -2052258961);
   }

   @ObfuscatedName("d")
   int vmethod1617() {
      return field1178.method1197(this.field1177, 1703020384);
   }

   @ObfuscatedName("y")
   void vmethod1618() {
      field1178.method1199(this.field1177, -1555225132);
   }

   @ObfuscatedName("w")
   void vmethod1615(int var1) throws Exception {
      if(var1 > '耀') {
         throw new IllegalArgumentException();
      } else {
         field1178.method1198(this.field1177, var1, (byte)-93);
      }
   }

   class54(class136 var1, int var2) {
      field1178 = var1.method2994();
      this.field1177 = var2;
   }
}
