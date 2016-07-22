import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class145 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -861045527
   )
   static int field2237;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1865482194"
   )
   public static void method3037() {
      class50.field1105.method3814();
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-6743340"
   )
   static void method3039() {
      for(int var0 = 0; var0 < client.field412; ++var0) {
         int var2 = client.field415[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < client.field412 - 1) {
               for(int var3 = var0; var3 < client.field412 - 1; ++var3) {
                  client.field417[var3] = client.field417[1 + var3];
                  client.field328[var3] = client.field328[var3 + 1];
                  client.field415[var3] = client.field415[var3 + 1];
                  client.field322[var3] = client.field322[1 + var3];
                  client.field294[var3] = client.field294[1 + var3];
                  client.field414[var3] = client.field414[var3 + 1];
               }
            }

            --client.field412;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass27;I)V",
      garbageValue = "120656467"
   )
   @Export("selectWorld")
   static void method3040(class27 var0) {
      if(var0.method614() != client.field276) {
         client.field276 = var0.method614();
         boolean var1 = var0.method614();
         if(var1 != class55.field1175) {
            class12.method150();
            class55.field1175 = var1;
         }
      }

      class124.field2060 = var0.field654;
      client.field272 = var0.field650;
      client.field480 = var0.field651;
      class116.field2019 = client.field275 == 0?'ꩊ':var0.field650 + '鱀';
      class0.field6 = client.field275 == 0?443:var0.field650 + '썐';
      class42.field991 = class116.field2019;
   }
}
