import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("VertexNormal")
public class class96 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1086283585
   )
   int field1632;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 882170309
   )
   int field1634;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2127040129
   )
   int field1635;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = -1436704075
   )
   static int field1636;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1435100875
   )
   int field1637;

   class96() {
   }

   class96(class96 var1) {
      this.field1634 = var1.field1634;
      this.field1632 = var1.field1632;
      this.field1637 = var1.field1637;
      this.field1635 = var1.field1635;
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "1740438949"
   )
   static void method2260(int var0, int var1, int var2, int var3, String var4) {
      class173 var5 = class172.method3425(var1, var2);
      if(var5 != null) {
         if(null != var5.field2859) {
            class0 var6 = new class0();
            var6.field1 = var5;
            var6.field2 = var0;
            var6.field9 = var4;
            var6.field0 = var5.field2859;
            class31.method737(var6, 200000);
         }

         boolean var7 = true;
         if(var5.field2758 > 0) {
            var7 = class11.method150(var5);
         }

         if(var7) {
            if(class167.method3361(class18.method205(var5), var0 - 1)) {
               if(var0 == 1) {
                  client.field333.method2773(121);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

               if(var0 == 2) {
                  client.field333.method2773(5);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

               if(var0 == 3) {
                  client.field333.method2773(175);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

               if(var0 == 4) {
                  client.field333.method2773(23);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

               if(var0 == 5) {
                  client.field333.method2773(42);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

               if(var0 == 6) {
                  client.field333.method2773(202);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

               if(var0 == 7) {
                  client.field333.method2773(69);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

               if(var0 == 8) {
                  client.field333.method2773(174);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

               if(var0 == 9) {
                  client.field333.method2773(210);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

               if(var0 == 10) {
                  client.field333.method2773(192);
                  client.field333.method2539(var1);
                  client.field333.method2540(var2);
                  client.field333.method2540(var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIIZI)V",
      garbageValue = "-1648075804"
   )
   public static void method2261(class167 var0, int var1, int var2, int var3, boolean var4) {
      class183.field2953 = 1;
      class20.field582 = var0;
      class21.field589 = var1;
      class213.field3145 = var2;
      class183.field2956 = var3;
      class20.field583 = var4;
      class183.field2957 = 10000;
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2128275727"
   )
   static final String method2262(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class164.method3251('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class164.method3251(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class164.method3251(16776960) + var1 + "</col>");
   }
}
