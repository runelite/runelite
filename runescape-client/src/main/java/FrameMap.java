import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("k")
   int[][] field1467;
   @ObfuscatedName("f")
   int[] field1468;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -10599773
   )
   int field1469;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -873555889
   )
   int field1473;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "65"
   )
   static void method1687(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class191.method3433(var0.parentId);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = ItemLayer.field1223;
         var3 = class112.field1755;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class1.method12(var0, var2, var3, false);
      Friend.method167(var0, var2, var3);
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "250377100"
   )
   static String method1688(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var6 = var0.indexOf("%" + var2);
               if(var6 == -1) {
                  break;
               }

               var0 = var0.substring(0, var6) + Ignore.method187(ItemLayer.method1448(var1, var2 - 1)) + var0.substring(var6 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(class6.field60 != null) {
               int var5 = class6.field60.field1648;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var3 = var4;
               if(null != class6.field60.field1652) {
                  var3 = (String)class6.field60.field1652;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   FrameMap(int var1, byte[] var2) {
      this.field1469 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1473 = var3.readUnsignedByte();
      this.field1468 = new int[this.field1473];
      this.field1467 = new int[this.field1473][];

      int var4;
      for(var4 = 0; var4 < this.field1473; ++var4) {
         this.field1468[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1473; ++var4) {
         this.field1467[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1473; ++var4) {
         for(int var5 = 0; var5 < this.field1467[var4].length; ++var5) {
            this.field1467[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-99"
   )
   static void method1689() {
      Client.field294.method2976(172);
      Client.field294.method2932(XGrandExchangeOffer.method57());
      Client.field294.method2746(ItemLayer.field1223);
      Client.field294.method2746(class112.field1755);
   }
}
