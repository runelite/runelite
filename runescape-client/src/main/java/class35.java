import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("MessageNode")
public class class35 extends class204 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -119698201
   )
   @Export("tick")
   int field764;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1054869757
   )
   @Export("type")
   int field765;
   @ObfuscatedName("d")
   @Export("name")
   String field766;
   @ObfuscatedName("x")
   @Export("sender")
   String field767;
   @ObfuscatedName("y")
   @Export("value")
   String field768;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1246523873
   )
   @Export("id")
   int field769;
   @ObfuscatedName("bs")
   static class168 field771;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "88"
   )
   static void method737() {
      int var0 = class144.field2184;
      int var1 = class144.field2182;
      int var2 = class110.field1934 - class45.field1026 - var0;
      int var3 = class89.field1532 - class143.field2169 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field284.method3057();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class75.field1346) {
               Insets var7 = class75.field1346.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class89.field1532);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class110.field1934, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class110.field1934 + var5 - var2, var6, var2, class89.field1532);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class89.field1532 + var6 - var3, class110.field1934, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-257396880"
   )
   void method738(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field168 - 1;
      this.field769 = var5;
      this.field764 = client.field296;
      this.field765 = var1;
      this.field766 = var2;
      this.field767 = var3;
      this.field768 = var4;
   }

   class35(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field168 - 1;
      this.field769 = var5;
      this.field764 = client.field296;
      this.field765 = var1;
      this.field766 = var2;
      this.field767 = var3;
      this.field768 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Lclass51;",
      garbageValue = "102"
   )
   @Export("getItemDefinition")
   public static class51 method741(int var0) {
      class51 var1 = (class51)class51.field1079.method3764((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class34.field761.method3266(10, var0);
         var1 = new class51();
         var1.field1092 = var0;
         if(null != var2) {
            var1.method1022(new class119(var2));
         }

         var1.method1027();
         if(var1.field1116 != -1) {
            var1.method1061(method741(var1.field1116), method741(var1.field1112));
         }

         if(var1.field1085 != -1) {
            var1.method1021(method741(var1.field1085), method741(var1.field1110));
         }

         if(var1.field1127 != -1) {
            var1.method1059(method741(var1.field1127), method741(var1.field1126));
         }

         if(!class10.field157 && var1.field1098) {
            var1.field1090 = "Members object";
            var1.field1123 = false;
            var1.field1099 = null;
            var1.field1105 = null;
            var1.field1122 = 0;
         }

         class51.field1079.method3759(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZI)I",
      garbageValue = "1510194662"
   )
   static int method742(class25 var0, class25 var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.field638;
         int var5 = var1.field638;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field641 - var1.field641:(var2 == 3?(var0.field646.equals("-")?(var1.field646.equals("-")?0:(var3?-1:1)):(var1.field646.equals("-")?(var3?1:-1):var0.field646.compareTo(var1.field646))):(var2 == 4?(var0.method594()?(var1.method594()?0:1):(var1.method594()?-1:0)):(var2 == 5?(var0.method599()?(var1.method599()?0:1):(var1.method599()?-1:0)):(var2 == 6?(var0.method611()?(var1.method611()?0:1):(var1.method611()?-1:0)):(var2 == 7?(var0.method627()?(var1.method627()?0:1):(var1.method627()?-1:0)):var0.field636 - var1.field636)))));
      }
   }
}
