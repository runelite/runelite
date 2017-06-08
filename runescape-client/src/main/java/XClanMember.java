import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("p")
   String field898;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1508640109
   )
   @Export("world")
   int world;
   @ObfuscatedName("j")
   @Export("rank")
   byte rank;
   @ObfuscatedName("n")
   @Export("username")
   String username;

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "773863729"
   )
   static String method1124(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class36.method495(class261.method4763(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(class88.field1387 != null) {
               var4 = FileOnDisk.method2386(class88.field1387.field2232);
               if(class88.field1387.field2240 != null) {
                  var4 = (String)class88.field1387.field2240;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static final void method1125(int var0) {
      if(class73.method1095(var0)) {
         class13.method90(Widget.widgets[var0], -1);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1569120387"
   )
   public static boolean method1126(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "-1260918940"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field3356.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field3357.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method4392(new Buffer(var2));
         }

         KitDefinition.field3356.put(var1, (long)var0);
         return var1;
      }
   }
}
